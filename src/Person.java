import java.util.Calendar;

public record Person(String firstName, String lastName, String id, String title, int yearOfBirth) {

    /**
     * Returns the full name of the person.
     *
     * @return full name in the format "FirstName LastName".
     */
    public String fullName() {
        return firstName + " " + lastName;
    }

    /**
     * Returns the formal name of the person.
     *
     * @return formal name in the format "Title FirstName LastName".
     */
    public String formalName() {
        return title + " " + fullName();
    }

    /**
     * Calculates the age of the person based on the current year.
     *
     * @return age as a String.
     */
    public String getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return String.valueOf(currentYear - yearOfBirth);
    }

    /**
     * Calculates the age of the person for a specified year.
     *
     * @param year the year for which the age is calculated.
     * @return age as a String.
     */
    public String getAge(int year) {
        return String.valueOf(year - yearOfBirth);
    }

    /**
     * Converts the person details to a CSV format.
     *
     * @return a CSV-formatted string.
     */
    public String toCSV() {
        return String.format("%s, %s, %s, %s, %d", id, firstName, lastName, title, yearOfBirth);
    }

    /**
     * Converts the person details to JSON format.
     *
     * @return a JSON-formatted string.
     */
    public String toJSON() {
        return String.format("{\"id\":\"%s\",\"firstName\":\"%s\",\"lastName\":\"%s\",\"title\":\"%s\",\"yearOfBirth\":%d}",
                id, firstName, lastName, title, yearOfBirth);
    }

    /**
     * Converts the person details to XML format.
     *
     * @return an XML-formatted string.
     */
    public String toXML() {
        return String.format("<Person><ID>%s</ID><FirstName>%s</FirstName><LastName>%s</LastName><Title>%s</Title><YearOfBirth>%d</YearOfBirth></Person>",
                id, firstName, lastName, title, yearOfBirth);
    }

    /**
     * Returns the ID of the person.
     *
     * @return the ID as a String.
     */
    @Override
    public String id() {
        return id;
    }

    /**
     * Returns the first name of the person.
     *
     * @return the first name as a String.
     */
    @Override
    public String firstName() {
        return firstName;
    }

    /**
     * Returns the last name of the person.
     *
     * @return the last name as a String.
     */
    @Override
    public String lastName() {
        return lastName;
    }

    /**
     * Returns the title of the person.
     *
     * @return the title as a String.
     */
    @Override
    public String title() {
        return title;
    }

    /**
     * Returns the year of birth of the person.
     *
     * @return the year of birth as an int.
     */
    @Override
    public int yearOfBirth() {
        return yearOfBirth;
    }
}
