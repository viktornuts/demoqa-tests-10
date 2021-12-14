package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeForm {

    @BeforeAll
    static void beforeAll(){
        Configuration.startMaximized = true;
    }

    @Test
    void fillFromTest(){
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Viktor");
        $("#lastName").setValue(" Slon");
        $("#userEmail").setValue("viktornuts@gmail.com");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("8955245541");
        $("[class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']").click();
       // $("[class='css-12jo7m5 subjects-auto-complete__multi-value__label']").setValue("English");
        $("[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").sendKeys("C:\\Users\\serdobintsev.vm\\Desktop\\Autotests\\lesson1.png");
        $("[placeholder='Current Address']").setValue("Nikolaya Shishka 21");
        $("[placeholder='Current Address']").scrollIntoView(true);
        $("#state").click();
        $("#state > div > div.css-1hwfws3 > div.css-1uccc91-singleValue").click();

    }



}
