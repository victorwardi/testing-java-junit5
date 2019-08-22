package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    @Test
    void dependentAssertions() {
        Owner owner = new Owner(1L, "Victor", "Wardi");
        owner.setCity("Niteroi");
        owner.setTelephone("11123456789");

        assertAll("Testing All Owner Properties",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Victor", owner.getFirstName(), "First Name did not match"),
                        () -> assertEquals("Wardi", owner.getLastName(), "Last Name did not match")),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Niteroi", owner.getCity(), "City did not match"),
                        () -> assertEquals("11123456789", owner.getTelephone(), "Telephone did not match"))
        );
    }
}