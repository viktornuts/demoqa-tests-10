package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class Lesson3 {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;

    }


    /*1. Разница между

- $("h1").$("div"): сперва мы ищем первый "h1", внутри первого найденного элемента "h1" мы ищем первый элемент "div"

- $("h1 div"): мы ищем первый "div" вложенный в элемент "h1"
*/


    @Test
    void shouldFindCodeJUnit5InSoftAssertions() {


        open("https://github.com/");
        $("input[data-test-selector='nav-search-input']").setValue("Selenide").pressEnter();
        $("span[data-search-type='Wikis']").shouldBe(visible).click();
        $("#wiki_search_results").shouldHave(text("SoftAssertions"));
        $("#wiki_search_results").$("a[title='SoftAssertions']").click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:")).shouldBe(visible);

    }

    @Test
    void dragAndDrop() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo($("#column-b"));
        $$("#columns > div").get(0).shouldHave(text("B"));
        $$("#columns > div").get(1).shouldHave(text("A"));

    }
}
