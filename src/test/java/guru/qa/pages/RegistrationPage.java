package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    SelenideElement
                    firstNameInput = $("#firstName"),
                    lastNameInput = $("#lastName");

    public RegistrationPage typeFirsName(String firstName){

        firstNameInput.setValue(firstName);

        return this;
    }

    public void typeLastName() {
        lastNameInput.setValue("Slon");

    }

}
