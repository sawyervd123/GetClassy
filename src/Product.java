/**
 * @param id Immutable
 */
public record Product(String name, String description, String id, double cost) {

    /**
     * Converts the product details to a CSV format.
     *
     * @return a CSV-formatted string.
     */
    public String toCSV() {
        return String.format("%s, %s, %s, %.2f", id, name, description, cost);
    }

    /**
     * Converts the product details to JSON format.
     *
     * @return a JSON-formatted string.
     */
    public String toJSON() {
        return String.format("{\"id\":\"%s\",\"name\":\"%s\",\"description\":\"%s\",\"cost\":%.2f}",
                id, name, description, cost);
    }

    /**
     * Converts the product details to XML format.
     *
     * @return an XML-formatted string.
     */
    public String toXML() {
        return String.format("<Product><ID>%s</ID><Name>%s</Name><Description>%s</Description><Cost>%.2f</Cost></Product>",
                id, name, description, cost);
    }
}
