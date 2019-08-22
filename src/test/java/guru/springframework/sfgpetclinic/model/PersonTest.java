package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void groupedAssertions() {

        //given
        Person person = new Person(1L, "Victor", "Wardi");

        //then
        assertAll("Testing all Person properties",
                () ->  assertEquals("Victor", person.getFirstName()),
                () -> assertEquals("Wardi", person.getLastName())
                );
    }
    @Test
    void groupedAssertionsMessages() {

        //given
        Person person = new Person(1L, "Victor", "Wardi");

        //then
        assertAll("Testing all Person properties",
                () ->  assertEquals("Victor", person.getFirstName(),  "First Name Failed"),
                () -> assertEquals("Wardi", person.getLastName(), "Last Name Failed")
                );
    }
}