package guru.qa.pages.MCHD;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class StartPage {

    SelenideElement
            CreateMchdButton = $("[class='button-wrapper success']");

    public StartPage createNewMchd() {
        CreateMchdButton.click();
        return this;

    }

}
