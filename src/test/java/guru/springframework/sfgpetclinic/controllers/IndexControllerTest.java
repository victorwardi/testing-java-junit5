package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.exceptions.ValueNotFoundExcpetion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest implements ControllerTests{

    IndexController indexController;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @Test
    @DisplayName("Test View Name for index page")
    void index() {
        assertEquals("index", indexController.index());
        assertEquals("index", indexController.index(), "Wrong View Returned");

        assertThat(indexController.index()).isEqualTo("index");
    }

    @Test
    @DisplayName("Testing especific excpetion handler")
    void oopsHandler() {
       assertThrows(ValueNotFoundExcpetion.class, () ->{
           indexController.oopsHandler();
       });
    }

    @Test
    @EnabledOnJre(JRE.JAVA_11)
    void testTimeOut() {
        assertTimeout(Duration.ofMillis(100), () ->{
            Thread.sleep(10);
            System.out.println("I got Here");
        });
    }

    @Test
    void testTimeOutPreempt() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () ->{
            Thread.sleep(10);
            System.out.println("I got here in a different Thread");
        });
    }

    @Test
    void testAssumptions() {
        assumeTrue("Victor".equalsIgnoreCase("Victor"));
    }
}