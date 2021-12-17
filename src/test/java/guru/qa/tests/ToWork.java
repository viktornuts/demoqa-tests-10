package guru.qa.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class ToWork {

    @BeforeAll
    static void beforeAll(){
        Configuration.startMaximized = true;
    }

    @Test
    void fillFromTest(){
        open("https://mchd-front-ui-mchd-tst.tst.cld.esphere.local");
        $("#IDToken1").setValue("romashkaa");
        $("#IDToken2").setValue("12345678");
        $("[name='Login.Submit']").click();
        $("[class='button-wrapper success']").click();

        $("[class='datepicker-calendar-icon']").click();
        $("[class='calendar-title']").click();
        $("[class='calendar-title']").click();
        $("[title='2019']").click();
        $("[title='Март']").click();
        $("[title='5 марта 2019']").click();



        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[2]/dd[1]/div/div[2]/div/span/span")).click();
        $("[class='calendar-title']").click();
        $("[class='calendar-title']").click();
        $("[title='2022']").click();
        $("[title='Ноябрь']").click();
        $("[title='22 ноября 2022']").click();

        $("[class='multiselect-tags-container']").scrollIntoView(true);
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[2]/dd[2]/div/div[1]/div")).click();
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[2]/dd[2]/div/div[2]/div[2]/div/ul/li[1]/div/div")).click();


        $("[name='companyName']").setValue("ООО \"Рога и копыта\"");

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
