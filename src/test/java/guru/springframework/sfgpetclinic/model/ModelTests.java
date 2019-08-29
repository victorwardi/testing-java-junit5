package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;

@Tag("model")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface ModelTests {

    @BeforeAll
    default void beforeAll(){
        System.out.println("Does something before all model tests.");
    }
}
