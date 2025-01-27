import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PersonReader {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        System.out.println("Please select a file to read.");

        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            ArrayList<Person> persons = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(", ");
                    if (parts.length == 5) {
                        try {
                            String id = parts[0].trim();
                            String firstName = parts[1].trim();
                            String lastName = parts[2].trim();
                            String title = parts[3].trim();
                            int yearOfBirth = Integer.parseInt(parts[4].trim());

                            // Create Person object and add to the list
                            persons.add(new Person(firstName, lastName, id, title, yearOfBirth));
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid year of birth: " + parts[4]);
                        }
                    } else {
                        System.out.println("Invalid record: " + line);
                    }
                }

                System.out.printf("%-10s %-15s %-15s %-10s %-5s%n", "ID", "First Name", "Last Name", "Title", "YOB");
                System.out.println("==============================================================");
                for (Person person : persons) {
                    System.out.printf("%-10s %-15s %-15s %-10s %-5d%n",
                            person.id(), person.firstName(), person.lastName(), person.title(), person.yearOfBirth());
                }
            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }
        } else {
            System.out.println("No file selected.");
        }
    }
}
