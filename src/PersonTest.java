import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    void testFullName() {
        Person person = new Person("John", "Doe", "123", "Mr.", 1980);
        assertEquals("John Doe", person.fullName());
    }

    @Test
    void testFormalName() {
        Person person = new Person("John", "Doe", "123", "Dr.", 1980);
        assertEquals("Dr. John Doe", person.formalName());
    }

    @Test
    void testGetAge() {
        Person person = new Person("John", "Doe", "123", "Mr.", 2000);
        assertEquals(String.valueOf(Calendar.getInstance().get(Calendar.YEAR) - 2000), person.getAge());
    }

    @Test
    void testGetAgeForYear() {
        Person person = new Person("John", "Doe", "123", "Mr.", 1980);
        assertEquals("20", person.getAge(2000));
    }

    @Test
    void testToCSV() {
        Person person = new Person("John", "Doe", "123", "Mr.", 1980);
        assertEquals("123, John, Doe, Mr., 1980", person.toCSV());
    }

    @Test
    void testToJSON() {
        Person person = new Person("John", "Doe", "123", "Dr.", 1980);
        assertEquals("{\"id\":\"123\",\"firstName\":\"John\",\"lastName\":\"Doe\",\"title\":\"Dr.\",\"yearOfBirth\":1980}", person.toJSON());
    }

    @Test
    void testToXML() {
        Person person = new Person("John", "Doe", "123", "Dr.", 1980);
        assertEquals("<Person><ID>123</ID><FirstName>John</FirstName><LastName>Doe</LastName><Title>Dr.</Title><YearOfBirth>1980</YearOfBirth></Person>",
                person.toXML());
    }
}
