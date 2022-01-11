package guru.qa.pages.MCHD;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

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



}
