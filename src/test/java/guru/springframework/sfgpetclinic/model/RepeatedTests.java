package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.util.CustomRepeatedDI;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class RepeatedTests implements CustomRepeatedDI {

    @DisplayName("Test Assigment")
    @RepeatedTest(value = 5, name = "{displayName} -> {currentRepetition} - {totalRepetitions}")
    void myAssigmentRepeatedTest() {

    }

}
