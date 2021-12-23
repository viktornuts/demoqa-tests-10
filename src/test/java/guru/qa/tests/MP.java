package guru.qa.tests;

import com.codeborne.selenide.AuthenticationType;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class MP {

    @BeforeAll
    static void beforeAll(){
        Configuration.startMaximized = true;
    }

    @Test
    void fillFromTest(){
        open("https://notary-test.region-tech.ru", AuthenticationType.BEARER, "ift", "iftU$ER!");




        $("#IDToken2").setValue("12345678");
        $("[name='Login.Submit']").click();
        $("[class='button-wrapper success']").click();

        $("[class='datepicker-calendar-icon']").click();
        $("[class='calendar-title']").click();
        $("[class='calendar-title']").click();
        $("[title='2019']").click();
        $("[title='Март']").click();
        $("[title='5 марта 2019']").click();

        $("[name='companyName']").click();

        //$("input[name='mra-to'] span.datepicker-icons-wrapper").click();
        //$("[class='calendar-title']").click();
        //$("[title='2022']").click();
        //$("[title='Апрель']").click();
        // $("[title='5 апреля 2022']").click();
        $("[class='multiselect-tags-container']").scrollIntoView(true);
        $("[class='multiselect-tags-container']").click();
        $("div[class='input-wrapper'] div[class='input-element-wrapper'] input[placeholder='Введите значение']").setValue("Подписывать акты");
        $("div[for='checkbox-7x7up0']").click();

        $("[name='companyName']").click();

        $("[class='multiselect-input-wrapper']").selectOption("Подписывать договоры");


        $("[class='react-datepicker__month-select']").selectOption("June");
        $("[class='react-datepicker__year-select']").selectOption("1990");
        $("[class*='react-datepicker__day--021']").click();


        $("#userEmail").setValue("viktornuts@gmail.com");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("8955245541");

        $("#dateOfBirthInput").click();

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
        $("#submit").click();

        //Assert
        $$x("//*[@class='modal-body']//td[2]").shouldHave(CollectionCondition.exactTexts(
                "Viktor Slon", "viktornuts@gmail.com", "Male", "8955245541", "21 June,1990",
                "English, Maths", "Sports, Reading", "lesson1.png", "Nikolaya Shishka 21", "Rajasthan Jaiselmer"));

    }



}
