import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductWriter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();

        System.out.println("Enter product records (leave ID blank to stop):");
        while (true) {
            System.out.print("Enter Product ID: ");
            String id = scanner.nextLine();
            if (id.isBlank()) break;

            System.out.print("Enter Product Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Product Description: ");
            String description = scanner.nextLine();

            double cost = SafeInput.getDouble(scanner, "Enter Product Cost");

            // Create Product object
            products.add(new Product(name, description, id, cost));
        }

        System.out.print("Enter file name to save: ");
        String fileName = scanner.nextLine();

        try (FileWriter writer = new FileWriter(fileName)) {
            for (Product product : products) {
                writer.write(product.toCSV() + "\n");
            }
            System.out.println("Data saved successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
