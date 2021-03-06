package guru.qa.docs;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;

public class JUnit5Examples {

    @DisplayName("New tests")
    @BeforeAll
    static void beforeAll(){
        System.out.println("This is the before method!");
    }

    @AfterAll
    static void AfterAll(){
        System.out.println("This is the after method!");
    }

    @BeforeEach
    void openYandex() {

        System.out.println("        open \"ya.ru\"");

    }

    @AfterEach
    void takeScreen(){

        System.out.println("        takeScreen();");
    }
    @DisplayName("My first test")
    @Test
    void firstTest() {
        System.out.println("                first test()");
        Assertions.assertTrue(true);

    }
    @DisplayName("My second test")
    @Test
    void secondTest() {
        System.out.println("                second test()");
        Assertions.assertTrue(true);

    }

}
