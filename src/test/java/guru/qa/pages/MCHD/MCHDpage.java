package guru.qa.pages.MCHD;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class MCHDpage {

    SelenideElement
            permissionList = $("[class='multiselect-tags-container']"),
            allPermissions = $("[class='checkbox-label'] > span"),
            companyNameInput = $("[name='companyName']"),
            issureInnInput = $("input[name='inn']"),
            issureKppInput = $("input[name='kpp']"),
            issureOgrnInput = $("input[name='ogrnip']"),
            issureAdressInput = $("input[name='address']"),
            chiefLastNameInput = $("input[name='chief_lastName']"),
            chiefFirstNameInput = $("input[name='chief_firstName']"),
            chiefMidleNameInput = $("input[name='chief_middleName']"),
            chiefPositionInput = $("input[name='position']"),
            chiefInnInput = $("input[name='chief_inn']"),
            chiefSnilsInput = $("input[name='chief_snils']"),
            confidantLastNameInput =  $("input[name='confidant_lastName']"),
            confidantFirstNameInput = $("input[name='confidant_firstName']"),
            confidantMidleNameInput = $("input[name='confidant_middleName']"),
            confidantInnInput =  $("input[name='confidant_inn']"),
            confidantSnilsInput =  $("input[name='confidant_snils']"),
            documentCodeInput = $("input[name='documentCode']"),
            documentNumbetInput = $("input[name='documentNumber']"),
            documentIssureInput = $("input[name='docIssuerName']"),
            successButton = $("div[class='light-box-footer'] .button-wrapper.success");





    public MCHDpage choisePermissions() {
        permissionList.scrollTo().click();
        allPermissions.click();
        return this;

    }

    public MCHDpage setCompanyName(String name) {
        companyNameInput.setValue(name);
        return this;

    }

    public MCHDpage setIssureInn(String value) {
        issureInnInput.setValue(value);
        return this;

    }

    public MCHDpage setIssureKpp(String value) {
        issureKppInput.setValue(value);
        return this;

    }

    public MCHDpage setIssureOgrn(String value) {
        issureOgrnInput.setValue(value);
        return this;

    }

    public MCHDpage setIssureAddres(String value) {
        issureAdressInput.setValue(value);
        return this;

    }

    public MCHDpage setChiefLastName(String value) {
        chiefLastNameInput.setValue(value);
        return this;

    }

    public MCHDpage setChiefFirstName(String value) {
        chiefFirstNameInput.setValue(value);
        return this;

    }

    public MCHDpage setChiefMidleName(String value) {
        chiefMidleNameInput.setValue(value);
        return this;

    }

    public MCHDpage setChiefPosition(String value) {
        chiefPositionInput.setValue(value);
        return this;

    }
    public MCHDpage setChiefInn(String value) {
        chiefInnInput.setValue(value);
        return this;

    }
    public MCHDpage setChiefSnils(String value) {
        //253 799 532 23
        chiefSnilsInput.click();
        chiefSnilsInput.sendKeys(value);
        return this;

    }
    public MCHDpage setConfidantLastName(String value) {
        confidantLastNameInput.setValue(value);
        return this;

    }
    public MCHDpage setConfidantFirstName(String value) {
        confidantFirstNameInput.setValue(value);
        return this;

    }
    public MCHDpage setConfidantMidleName(String value) {
        confidantMidleNameInput.setValue(value);
        return this;

    }

    public MCHDpage setConfidantInn(String value){
        confidantInnInput.scrollIntoView(true).setValue(value);
        return this;

    }
    public MCHDpage setConfidantSnils (String value){
        confidantSnilsInput.click();
        confidantSnilsInput.sendKeys(value);
        return this;

    }

    public MCHDpage setDocumentCode(String value){
        documentCodeInput.click();
        $("ul[class='suggestion-list'] li:nth-child(" + value + ")").click();
        return this;

    }

    public MCHDpage setDocumentNumber(String value) {
        actions().moveToElement(documentNumbetInput).click(documentNumbetInput).perform();
        documentNumbetInput.sendKeys(value);
        return this;
        //for pasport mask = 7512203355 (10 sim)
    }

    public MCHDpage setDocumentIssure(String value){
        documentIssureInput.setValue(value);
        return this;

    }

    public MCHDpage acceptMchd() {
        successButton.scrollTo().click();
        return this;
    }

    public void assertCreateMchd() {
        $(".button-wrapper.success.disabled").shouldHave(text("Отправить на регистрацию в ФНС"));
        String MCHDnumber = $(".txt-default.txt-gray").getText();
        System.out.println(MCHDnumber);
    }

    public void assertValidation() {

        $(".width-45.daterange-wrapper").$$(".invalid-message-item").get(0).shouldHave(text("Поле обязательно для заполнения"));
        $(".width-45.daterange-wrapper").$$(".invalid-message-item").get(1).shouldHave(text("Поле обязательно для заполнения"));
        $(".width-70.multiselect-checkboxes.multiselect-wrapper").$(".invalid-message-item").shouldHave(text("Поле обязательно для заполнения"));
        $("div[class='input-wrapper'] span[class='invalid-message-list']").shouldHave(text("Поле обязательно для заполнения"));
        $$("div[class='masked-wrapper'] span[class='invalid-message-list']").get(0).shouldHave(text("Поле обязательно для заполнения"));
        $$("div[class='input-wrapper'] span[class='invalid-message-list']").get(0).shouldHave(text("Поле обязательно для заполнения"));
        $$("div[class='input-wrapper'] span[class='invalid-message-list']").get(1).shouldHave(text("Поле обязательно для заполнения"));
        $$("div[class='input-wrapper'] span[class='invalid-message-list']").get(2).shouldHave(text("Поле обязательно для заполнения"));
        $$("div[class='input-wrapper'] span[class='invalid-message-list']").get(3).shouldHave(text("Поле обязательно для заполнения"));
        $$("div[class='masked-wrapper'] span[class='invalid-message-list']").get(1).shouldHave(text("Поле обязательно для заполнения"));
        $$("div[class='width-20 datepicker-wrapper'] span[class='invalid-message-list']").get(0).shouldHave(text("Поле обязательно для заполнения"));
        $$("div[class='width-20 datepicker-wrapper'] span[class='invalid-message-list']").get(1).shouldHave(text("Поле обязательно для заполнения"));
        $("div[class='dropdownselect-wrapper width-70'] span[class='invalid-message-list']").shouldHave(text("Поле обязательно для заполнения"));
        $("div[class='width-45 input-wrapper'] span[class='invalid-message-list']").shouldHave(text("Поле обязательно для заполнения"));
        System.out.println("Валидация на обязательность заполнения полей пройдена");
    }
}
