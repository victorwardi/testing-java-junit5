package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest implements ModelTests{

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

    @DisplayName("Parameterized Test")
    @ParameterizedTest(name = "{displayName} - {arguments}")
    @ValueSource(strings = {"Man", "Woman"})
    void testValueSource(String value) {
         System.out.println(value);
    }

    @DisplayName("Parameterized ENUM Test")
    @ParameterizedTest(name = "{displayName} - {arguments}")
    @EnumSource(OwnerType.class)
    void testParameterizedEnumTest(OwnerType ownerType) {
        System.out.println(ownerType.name());
    }

    @DisplayName("Parameterized CSV Test")
    @ParameterizedTest(name = "{displayName} - {arguments}")
    @CsvSource({
            "Victor, 34, Saquarema",
            "Ursula, 35, Sao Pedro da Aldeia",
            "Belinha, 6, Niteroi"
    })
    void testParameterizedCVSTest(String name, int age, String city) {
        System.out.println(name + " - "  + age + " - > " + city);
    }

    @DisplayName("Parameterized CSV Test")
    @ParameterizedTest(name = "{displayName} - {arguments}")
    @CsvFileSource(resources = "/owners.csv", numLinesToSkip = 0, delimiter = ';')
    void testParameterizedCSVFileTest(String name, int age, String city) {
        System.out.println(name + " - "  + age + " - > " + city);
    }
}