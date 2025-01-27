import java.util.Scanner;

/**
 * SafeInputObj provides utility methods for safe and validated user input.
 * This class wraps a Scanner object for interactive input handling.
 */
public class SafeInputObj {
    private final Scanner pipe;

    /**
     * Default constructor that initializes the Scanner to System.in.
     */
    public SafeInputObj() {
        this.pipe = new Scanner(System.in);
    }

    /**
     * Constructor that accepts a custom Scanner object.
     * @param scanner a Scanner instance.
     */
    public SafeInputObj(Scanner scanner) {
        this.pipe = scanner;
    }

    /**
     * Prompts the user for a non-zero length string.
     * @param prompt the input prompt.
     * @return a non-empty string.
     */
    public String getNonZeroLenString(String prompt) {
        String retString;

        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.trim().isEmpty());

        return retString;
    }

    /**
     * Prompts the user for an integer within a specific range.
     * @param prompt the input prompt.
     * @param low the minimum value (inclusive).
     * @param high the maximum value (inclusive).
     * @return a validated integer within the range.
     */
    public int getRangedInt(String prompt, int low, int high) {
        int retVal = 0;
        boolean done = false;

        do {
            System.out.print("\n" + prompt + " [" + low + "-" + high + "]: ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine(); // Clear the buffer
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("Number is out of range [" + low + "-" + high + "]: " + retVal);
                }
            } else {
                System.out.println("You must enter an integer: " + pipe.nextLine());
            }
        } while (!done);

        return retVal;
    }

    /**
     * Prompts the user for a double within a specific range.
     * @param prompt the input prompt.
     * @param low the minimum value (inclusive).
     * @param high the maximum value (inclusive).
     * @return a validated double within the range.
     */
    public double getRangedDouble(String prompt, double low, double high) {
        double retVal = 0.0;
        boolean done = false;

        do {
            System.out.print("\n" + prompt + " [" + low + "-" + high + "]: ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine(); // Clear the buffer
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("Number is out of range [" + low + "-" + high + "]: " + retVal);
                }
            } else {
                System.out.println("You must enter a double: " + pipe.nextLine());
            }
        } while (!done);

        return retVal;
    }

    /**
     * Prompts the user for a yes or no confirmation.
     * @param prompt the input prompt.
     * @return true for "Y/y", false for "N/n".
     */
    public boolean getYNConfirm(String prompt) {
        boolean retVal = false;
        boolean done = false;

        do {
            System.out.print("\n" + prompt + " [Y/N]: ");
            String response = pipe.nextLine().trim();
            if (response.equalsIgnoreCase("Y")) {
                retVal = true;
                done = true;
            } else if (response.equalsIgnoreCase("N")) {
                retVal = false;
                done = true;
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        } while (!done);

        return retVal;
    }

    /**
     * Prompts the user for a string that matches a specific regex pattern.
     * @param prompt the input prompt.
     * @param regExPattern the regular expression pattern to match.
     * @return a validated string matching the regex.
     */
    public String getRegExString(String prompt, String regExPattern) {
        String response;
        boolean done = false;

        do {
            System.out.print("\n" + prompt + ": ");
            response = pipe.nextLine().trim();
            if (response.matches(regExPattern)) {
                done = true;
            } else {
                System.out.println("Input must match the pattern: " + regExPattern);
            }
        } while (!done);

        return response;
    }
}
