package guru.qa.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.URI;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;


public class PracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("browserName", "chrome");
//        capabilities.setCapability("browserVersion", "98.0");
//        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
//                "enableVNC", true,
//                "enableVideo", true
//        ));                                                                             ------ для использования ДОКЕР и селениум на другом ПК
//        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.browserSize = "1920x1080";
//        Configuration.remote = "http://127.0.0.1:4444/wd/hub";



    }

    @Test
    void fillFromTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Viktor");
        $("#lastName").setValue("Slon");
        $("#userEmail").setValue("viktornuts@gmail.com");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("8955245541");

        $("#dateOfBirthInput").click();
        $("[class='react-datepicker__month-select']").selectOption("June");
        $("[class='react-datepicker__year-select']").selectOption("1990");
        $("[class*='react-datepicker__day--021']").click();

        $("#subjectsInput").setValue("English").pressEnter();
        $("#subjectsInput").setValue("Maths").pressEnter();

        $("[for='hobbies-checkbox-1']").click();
        $("[for='hobbies-checkbox-2']").click();

        File lesson = new File("src/test/java/guru/qa/files/lesson1.png");
        String path = lesson.getAbsolutePath();
        $("#uploadPicture").sendKeys(path);

        $("[placeholder='Current Address']").setValue("Nikolaya Shishka 21");
        $("[placeholder='Current Address']").scrollIntoView(true);
        $("#react-select-3-input").setValue("Raj").pressEnter();
        $("#react-select-4-input").setValue("Jaise").pressEnter();
        $("#submit").scrollTo().click();

        //Assert
        $$x("//*[@class='modal-body']//td[2]").shouldHave(CollectionCondition.exactTexts(
                "Viktor Slon", "viktornuts@gmail.com", "Male", "8955245541", "21 June,1990",
                "English, Maths", "Sports, Reading", "lesson1.png", "Nikolaya Shishka 21", "Rajasthan Jaiselmer"));


        // $(".table-responsive").shouldHave(text("Viktor"), text("Slon"); как 1 из вариантов

        // $(".table-responsive").$(byText("Student name")).parent().shouldHave(text("Slon"));
    }


}
