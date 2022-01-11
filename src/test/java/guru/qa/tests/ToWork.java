package guru.qa.tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.MCHD.AuthPage;
import guru.qa.pages.MCHD.Companents.CalendarCompanents;
import guru.qa.pages.MCHD.MCHDpage;
import guru.qa.pages.MCHD.StartPage;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ToWork {


    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;

    }

    @AfterEach
    void after() {
        closeWebDriver();
    }



    AuthPage authPage = new AuthPage();
    StartPage startPage = new StartPage();
    CalendarCompanents calendarCompanents = new CalendarCompanents();
    MCHDpage mchdpage = new MCHDpage();


    @Test
    @Order(1)
    void fillFromTest() {

        authPage.openPage().inputLogin("romashkaa").inputPass("12345678").login();
        startPage.createNewMchd();
        calendarCompanents.setDateMCHDFor();
        calendarCompanents.setDateMCHDTo();
        mchdpage.choisePermissions()
                .setChiefInn("683224144001")
                .setChiefSnils("253 799 532 23");

        //Сведенеия о представителе (доверенной стороне)

        $("input[name='confidant_lastName']").setValue("Подписантов");
        $("input[name='confidant_firstName']").setValue("Олег");
        $("input[name='confidant_middleName']").setValue("Иванович");

        $("input[name='confidant_inn']").scrollIntoView(true);

        $("input[name='confidant_inn']").setValue("832231002384");
        $("input[name='confidant_snils']").click();
        $("input[name='confidant_snils']").sendKeys("201 531 994 22");

        $$("[class='datepicker-calendar-icon']").get(2).click();
        $("[class='calendar-title']").click();
        $("[class='calendar-title']").click();
        $("i[class='calendar-prev-icon']").click();
        $("i[class='calendar-prev-icon']").click();
        $("i[class='calendar-prev-icon']").click();
        $("[title='1990']").click();
        $("[title='Июнь']").click();
        $("[title='22 июня 1990']").click();

        //Документ удостоверяющий личность

        $("input[name='documentCode']").click();
        $("ul[class='suggestion-list'] li:nth-child(1)").click();

        // webElement.sendKeys("text to send");

        SelenideElement PassportEdit = $("input[name='documentNumber']");
        actions().moveToElement(PassportEdit).click(PassportEdit).perform();
        PassportEdit.sendKeys("7512203313");
        //   PassportEdit.sendKeys("203313");
        //   new Actions($("input[name='documentNumber']")).sendKeys("text to send").perform();
        $$("[class='datepicker-calendar-icon']").get(3).click();
        $("[class='calendar-title']").click();
        $("[class='calendar-title']").click();
        $("[title='2019']").click();
        $("[title='Январь']").click();
        $("[title='13 января 2019']").click();
        $("input[name='docIssuerName']").setValue("Отделением №1 УФМС России по Челябинской области");

        $("div[class='light-box-footer'] .button-wrapper.success").scrollTo().click();

        //Assert
        $(".button-wrapper.success.disabled").shouldHave(text("Отправить на регистрацию в ФНС"));
        String MCHDnumber = $(".txt-default.txt-gray").getText();
        System.out.println(MCHDnumber);
    }

    @Test
    @Order(2)
    void ValidationForm() {

        //Создать МЧД оставить пустыми поля нажать на "Перейти к подписанию"

        $("[class='button-wrapper success']").click();
        $("div[class='light-box-footer'] .button-wrapper.success").scrollTo().click();

        //Assert

        $(".width-45.daterange-wrapper").$$(".invalid-message-item").get(0).shouldHave(text("Поле обязательно для заполнения"));
        $(".width-45.daterange-wrapper").$$(".invalid-message-item").get(1).shouldHave(text("Поле обязательно для заполнения"));
        $(".width-70.multiselect-checkboxes.multiselect-wrapper").$(".invalid-message-item").shouldHave(text("Поле обязательно для заполнения"));
        $(".textarea-wrapper").$(".invalid-message-item").shouldHave(text("Поле обязательно для заполнения"));
        $(".width-20.padding-y-none.margin-right-none").$(".invalid-message-item").shouldHave(text("Поле обязательно для заполнения"));
        $("li[class='width-20 margin-right-none']").$(".invalid-message-item").shouldHave(text("Поле обязательно для заполнения"));
        $("input[name='address'] + span > span").shouldHave(text("Поле обязательно для заполнения"));
//        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[2]/dd[2]/div/span/span")).shouldHave(text("Поле обязательно для заполнения"));
//        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[4]/dd[1]/div/span/span")).shouldHave(text("Поле обязательно для заполнения"));
//        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[4]/dd[2]/ul/li[1]/div/span/span")).shouldHave(text("Поле обязательно для заполнения"));
//        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[4]/dd[2]/ul/li[3]/div/span/span")).shouldHave(text("Поле обязательно для заполнения"));
//        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[4]/dd[2]/ul/li[5]/div/span/span")).shouldHave(text("Поле обязательно для заполнения"));
//        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[4]/dd[3]/div/span/span")).shouldHave(text("Поле обязательно для заполнения"));
//        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[5]/dd[1]/ul/li[1]/div/span/span")).shouldHave(text("Поле обязательно для заполнения"));
//        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[5]/dd[1]/ul/li[2]/div/span/span")).shouldHave(text("Поле обязательно для заполнения"));
//        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[5]/dd[3]/ul/li[1]/div/span/span")).shouldHave(text("Поле обязательно для заполнения"));
//        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[5]/dd[3]/ul/li[3]/div/span/span")).shouldHave(text("Поле обязательно для заполнения"));
//        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[6]/dd[1]/ul/li[1]/div/span/span")).shouldHave(text("Поле обязательно для заполнения"));
//        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[6]/dd[1]/ul/li[2]/div/span/span")).shouldHave(text("Поле обязательно для заполнения"));
//        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[7]/dl/dd[1]/div/span/span")).shouldHave(text("Поле обязательно для заполнения"));
//        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[7]/dl/dd[2]/div/span/span")).shouldHave(text("Поле обязательно для заполнения"));
//        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[7]/dl/dd[3]/div/span/span")).shouldHave(text("Поле обязательно для заполнения"));

        System.out.println("Валидация на обязательность заполнения полей пройдена");

    }

    @Test
    @Order(3)
    void ContorlSummCheck() {


        //Проверка контрольных сумм у полей
        $("[class='button-wrapper success']").click();

        $("[name='companyName']").scrollTo();
        $("input[name='inn']").setValue("4431602933");
        $("input[name='ogrnip']").setValue("6083327334753");
        $("input[name='chief_inn']").setValue("476826216093");
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[5]/dd[3]/ul/li[3]/div/div/input")).click();
        $("input[name='chief_snils']").sendKeys("253 799 532 21");
        $("input[name='confidant_inn']").setValue("832231002381");
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[6]/dd[2]/ul/li[3]/div/div/input")).click();
        $("input[name='confidant_snils']").sendKeys("201 531 994 21");


        $(By.xpath("/html/body/div[2]/div/div/div/div[4]/ul/li[2]/button")).scrollTo().click();


        //Assert

        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[4]/dd[2]/ul/li[1]/div/span/span")).shouldHave(text("Введите ИНН юридического лица"));
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[4]/dd[2]/ul/li[5]/div/span/span")).shouldHave(text("Введите ОГРН"));
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[5]/dd[3]/ul/li[1]/div/span/span")).shouldHave(text("Введите ИНН физического лица"));
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[5]/dd[3]/ul/li[3]/div/span/span")).shouldHave(text("Введите СНИЛС"));
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[6]/dd[2]/ul/li[1]/div/span/span")).shouldHave(text("Введите ИНН физического лица"));
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[6]/dd[2]/ul/li[3]/div/span/span")).shouldHave(text("Введите СНИЛС"));

        System.out.println("Проверка контрольных сумм произведена");

    }

    @Test
    @Order(4)
    void Logout() {

        $(".button-wrapper.header-button.more.blank").click();


    }

//    @Test
//    @Order(5)
//
//    void LogInUl() {
//
//        $(".button-wrapper.header-button.more.blank").click();
//
//
//
//    }
//
//    @Test
//    @Order(6)
//
//    void LogInIp() {
//
//        $(".button-wrapper.header-button.more.blank").click();
//
//
//
//    }

}


