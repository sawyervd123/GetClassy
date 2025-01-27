import java.util.Scanner;

class ObjInputTest {
    public static void main(String[] args) {
        SafeInputObj input = new SafeInputObj();

        String nonZeroLenString = input.getNonZeroLenString("Enter a non-zero length string");
        System.out.println("You entered: " + nonZeroLenString);

        int rangedInt = input.getRangedInt("Enter an integer between 1 and 10", 1, 10);
        System.out.println("You entered: " + rangedInt);

        double rangedDouble = input.getRangedDouble("Enter a double between 0.0 and 100.0", 0.0, 100.0);
        System.out.println("You entered: " + rangedDouble);

        boolean ynConfirm = input.getYNConfirm("Do you like programming?");
        System.out.println("You answered: " + (ynConfirm ? "Yes" : "No"));

        String regExString = input.getRegExString("Enter a valid email address", "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$");
        System.out.println("You entered a valid email: " + regExString);
    }
}
