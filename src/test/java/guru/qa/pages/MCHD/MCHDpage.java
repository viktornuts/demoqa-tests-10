package guru.qa.pages.MCHD;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MCHDpage {

    SelenideElement
            permissionList = $("[class='multiselect-tags-container']"),
            allPermissions = $("[class='checkbox-label'] > span");


    public MCHDpage choisePermissions() {
        permissionList.scrollTo().click();
        allPermissions.click();
        return this;

    }

}
