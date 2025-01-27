import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test
    void testToCSV() {
        Product product = new Product("Laptop", "Portable computer", "101", 899.99);
        assertEquals("101, Laptop, Portable computer, 899.99", product.toCSV());
    }

    @Test
    void testToJSON() {
        Product product = new Product("Laptop", "Portable computer", "101", 899.99);
        assertEquals("{\"id\":\"101\",\"name\":\"Laptop\",\"description\":\"Portable computer\",\"cost\":899.99}", product.toJSON());
    }

    @Test
    void testToXML() {
        Product product = new Product("Laptop", "Portable computer", "101", 899.99);
        assertEquals("<Product><ID>101</ID><Name>Laptop</Name><Description>Portable computer</Description><Cost>899.99</Cost></Product>",
                product.toXML());
    }
}
