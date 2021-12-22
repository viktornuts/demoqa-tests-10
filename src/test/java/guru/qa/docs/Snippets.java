package guru.qa.docs;

import com.codeborne.selenide.*;
import org.openqa.selenium.*;

import java.io.*;
import java.time.*;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class Snippets {

    void browser_command_examples() {
        // -Dselenide.baseUrl=http://github.com   - для прогрузки в Jenkins
        open("https://google.com"); // - открывает сайт
        open("/customer/orders"); // - если указан baseUrl
        open("/", AuthenticationType.BASIC, "user", "password"); // - если на сейте есть авторизация

        Selenide.back(); // - назад как в браузере
        Selenide.refresh(); // - обновить как в браузере кнопка

        Selenide.clearBrowserCookies(); // -  очищаем куки
        Selenide.clearBrowserLocalStorage(); // - очищаем просомтренные страницы

        Selenide.confirm(); // OK in alert dialogs // - когда выпадает коно с подтверждением и надо нажать да
        Selenide.dismiss(); // Cancel in alert dialogs // - когда выпадает коно с подтверждением и надо нажать нет

        Selenide.closeWindow(); // close active tab
        Selenide.closeWebDriver(); // close browser completely

        Selenide.switchTo().frame("new"); // - переключается между фреймами для поиска внутри фрейма
        Selenide.switchTo().defaultContent(); // - вернуться в стандартный документ ДОМ

        Selenide.switchTo().window("The Internet"); // - переключение между окнами
    }

    void selectors_examples() {
        $("div").click();
        element("div").click(); // - это для котлина , там доллар зарезервирован

        $("div", 2).click(); // the third div // - можно искать сразу какой то див

        $x("//h1/div").click(); // - это Икс паз
        $(byXpath("//h1/div")).click(); // - это Икс Паз

        $(byText("full text")).click(); // - полное совпадение текста
        $(withText("ull tex")).click(); // - частичное совпадение текста

        $("").parent(); // -к родителю
        $("").sibling(1); // - перепрыгиваем к соседниму элементу вниз через вложе
        $("").preceding(1);// - перепрыгиваем к соседниму элементу вверх через вложе
        $("").closest("div"); // - вверх по дереву по имени тага или классу атрибуту
        $("").ancestor("div"); // the same as closest
        $("div:last-child");




        $("div").$("h1").find(byText("abc")).click(); // -многоуровневый поиск

        // very optional
        $(byAttribute("abc", "x")).click();
        $("[abc=x]").click();

        $(byId("mytext")).click();
        $("#mytext").click();

        $(byClassName("red")).click();
        $(".red").click();
    }

    void actions_examples() {
        $("").click();
        $("").doubleClick();
        $("").contextClick(); // - правый клик

        $("").hover(); // - навести и держать мышку на

        $("").setValue("text"); // - вставить текст
        $("").append("text"); // - как бы дописать к имеющемуся
        $("").clear(); // - отчистить
        $("").setValue(""); // clear


        $("div").sendKeys("c"); // hotkey c on element
        actions().sendKeys("c").perform(); //hotkey c on whole application
        actions().sendKeys(Keys.chord(Keys.CONTROL, "f")).perform(); // Ctrl + F
        $("html").sendKeys(Keys.chord(Keys.CONTROL, "f"));

        $("").pressEnter();
        $("").pressEscape();
        $("").pressTab();


        // complex actions with keybord and mouse, example
        actions().moveToElement($("div")).clickAndHold().moveByOffset(300, 200).release().perform(); // у - по высоте х - по горизонтали

        // old html actions don't work with many modern frameworks
        $("").selectOption("dropdown_option"); // - дроп боксы старого типа
        $("").selectRadio("radio_options"); // - радио батоны

    }

    void assertions_examples() {
        $("").shouldBe(visible);
        $("").shouldNotBe(visible);
        $("").shouldHave(text("abc"));
        $("").shouldNotHave(text("abc"));
        $("").should(appear);
        $("").shouldNot(appear);


        //longer timeouts
        $("").shouldBe(visible, Duration.ofSeconds(30));
        $("").waitUntil(visible, 30000);


    }

    void conditions_examples() {
        $("").shouldBe(visible);
        $("").shouldBe(hidden);

        $("").shouldHave(text("abc")); // - частичное
        $("").shouldHave(exactText("abc"));// - полное
        $("").shouldHave(textCaseSensitive("abc"));
        $("").shouldHave(exactTextCaseSensitive("abc"));
        $("").should(matchText("[0-9]abc$"));

        $("").shouldHave(cssClass("red"));
        $("").shouldHave(cssValue("font-size", "12"));

        $("").shouldHave(value("25")); // - частичное
        $("").shouldHave(exactValue("25")); // - полное
        $("").shouldBe(empty);

        $("").shouldHave(attribute("disabled"));
        $("").shouldHave(attribute("name", "example"));
        $("").shouldHave(attributeMatching("name", "[0-9]abc$"));

        $("").shouldBe(checked); // for checkboxes

        // Warning! Only checks if it is in DOM, not if it is visible! You don't need it in most tests!
        $("").should(exist);

        // Warning! Checks only the "disabled" attribute! Will not work with many modern frameworks
        $("").shouldBe(disabled);
        $("").shouldBe(enabled);
    }

    void collections_examples() {

        $$("div"); // does nothing!

        // selections
        $$("div").filterBy(text("123")).shouldHave(size(1));  // -  фильтровка
        $$("div").excludeWith(text("123")).shouldHave(size(1));

        $$("div").first().click();
        elements("div").first().click();
        // $("div").click();
        $$("div").last().click();
        $$("div").get(1).click(); // the second! (start with 0)
        $("div", 1).click(); // same as previous
        $$("div").findBy(text("123")).click(); //  finds first

        // assertions
        $$("").shouldHave(size(0));
        $$("").shouldBe(CollectionCondition.empty); // the same

        $$("").shouldHave(texts("Alfa", "Beta", "Gamma")); // - текст
        $$("").shouldHave(exactTexts("Alfa", "Beta", "Gamma")); // - полный текст и проверка по очередности

        $$("").shouldHave(textsInAnyOrder("Beta", "Gamma", "Alfa")); // - порядок тектса не важен
        $$("").shouldHave(exactTextsCaseSensitiveInAnyOrder("Beta", "Gamma", "Alfa"));

        $$("").shouldHave(itemWithText("Gamma")); // only one text // -  проверить что из всего списка только 1 элемент

        $$("").shouldHave(sizeGreaterThan(0)); // - провкерить что результатов больше чем
        $$("").shouldHave(sizeGreaterThanOrEqual(1));
        $$("").shouldHave(sizeLessThan(3)); // - проверить что результатов меньше чем
        $$("").shouldHave(sizeLessThanOrEqual(2));


    }

    void file_operation_examples() throws FileNotFoundException {

        File file1 = $("a.fileLink").download(); // only for <a href=".."> links
        File file2 = $("div").download(DownloadOptions.using(FileDownloadMode.FOLDER)); // more common options, but may have problems with Grid/Selenoid

        File file = new File("src/test/resources/readme.txt");
        $("#file-upload").uploadFile(file);
        $("#file-upload").uploadFromClasspath("readme.txt");
        // don't forget to submit!
        $("uploadButton").click();
    }

    void javascript_examples() {
        executeJavaScript("alert('selenide')");
        executeJavaScript("alert(arguments[0]+arguments[1])", "abc", 12);
        long fortytwo = executeJavaScript("return arguments[0]*arguments[1];", 6, 7);

    }

}
