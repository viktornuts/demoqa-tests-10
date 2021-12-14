package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

   @BeforeAll
   static void beforeAll(){
      Configuration.startMaximized = true;
   }

   @Test
    void fillFromTest(){
       open("https://demoqa.com/text-box");
       $("[id=userName]").setValue("Viktor Slon");
       $("#userEmail").setValue("viktornuts@gmail.com");
       $("#currentAddress").setValue("Nikolaya Shishka 21");
       $("[id=permanentAddress]").setValue("Voroshilova 30");
       $("#submit").click();



       $("#output #name").shouldHave(text("Viktor Slon"));
       $("#output #email").shouldHave(text("viktornuts@gmail.com"));
       $("#output #currentAddress").shouldHave(text("Nikolaya Shishka 21"));
       $("#output #permanentAddress").shouldHave(text("Voroshilova 30"));

   }


}
