package guru.springframework.sfgpetclinic.util;

import org.junit.jupiter.api.*;

public interface CustomRepeatedDI {

    @BeforeEach
    default void beforeEach(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println("Running Test: " + testInfo.getDisplayName() + " - " + repetitionInfo.getCurrentRepetition());
    }
}
