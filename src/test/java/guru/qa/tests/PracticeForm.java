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
        $("#gender-radio-1").doubleClick();

        $("#userNumber").setValue("8955245541");

        //$("#dateOfBirthInput").click();

        //$("#react-datepicker__year-dropdown-container react-datepicker__year-dropdown-container--select").doubleClick();
       // $("ul li:first-child(6)").click();
       // $("#react-datepicker__month-dropdown-container react-datepicker__month-dropdown-container--select").click();
        $("#subjectsContainer").doubleClick();
        $("#subjectsContainer").setValue("E");
        $("#hobbies-checkbox-1").doubleClick();

    }



}
