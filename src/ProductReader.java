import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProductReader {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        System.out.println("Please select a product file to read.");

        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            ArrayList<Product> products = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(", ");
                    if (parts.length == 4) {
                        try {
                            String id = parts[0].trim();
                            String name = parts[1].trim();
                            String description = parts[2].trim();
                            double cost = Double.parseDouble(parts[3].trim());

                            // Create Product object and add to the list
                            products.add(new Product(name, description, id, cost));
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid cost: " + parts[3]);
                        }
                    } else {
                        System.out.println("Invalid record: " + line);
                    }
                }

                System.out.printf("%-10s %-15s %-30s %-10s%n", "ID", "Name", "Description", "Cost");
                System.out.println("==============================================================");
                for (Product product : products) {
                    System.out.printf("%-10s %-15s %-30s %-10.2f%n",
                            product.id(), product.name(), product.description(), product.cost());
                }
            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }
        } else {
            System.out.println("No file selected.");
        }
    }
}
