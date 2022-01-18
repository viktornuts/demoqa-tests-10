package guru.qa.tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.pages.MCHD.AuthPage;
import guru.qa.pages.MCHD.Companents.CalendarCompanents;
import guru.qa.pages.MCHD.MCHDpage;
import guru.qa.pages.MCHD.StartPage;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import java.nio.charset.StandardCharsets;

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
        ToWork testWithAnatation1 = new ToWork();
        testWithAnatation1.attachPageSource();
        closeWebDriver();

    }


    AuthPage authPage = new AuthPage();
    StartPage startPage = new StartPage();
    CalendarCompanents calendarCompanents = new CalendarCompanents();
    MCHDpage mchdpage = new MCHDpage();


    @Test
    @Order(1)
    void fillFromTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        authPage.openPage().inputLogin("romashkaa").inputPass("12345678").login();
        startPage.createNewMchd();
        calendarCompanents.setDateMCHDFor();
        calendarCompanents.setDateMCHDTo();
        mchdpage.choisePermissions()
                .setChiefInn("683224144001")
                .setChiefSnils("253 799 532 23");

        mchdpage.setConfidantFirstName("Олег")
                .setConfidantMidleName("Иванович")
                .setConfidantLastName("Подписантов")
                .setConfidantInn("643395448808")
                .setConfidantSnils("201 531 994 22");

        calendarCompanents.setConfidantBirthday();

        mchdpage.setDocumentCode("3")
                .setDocumentNumber("22331723144A17");

        calendarCompanents.setDocumentReleaseDate();

        mchdpage.setDocumentIssure("Отделение №1 УФМС России по Челябинской области в Ордж. районе г. Магнитогорска")
                .acceptMchd();


        mchdpage.assertCreateMchd();

    }

    @Test
    @Order(2)
    void ValidationForm() {

        authPage.openPage().inputLogin("romashkaa").inputPass("12345678").login();
        startPage.createNewMchd();
        Selenide.sleep(4000);
        mchdpage.acceptMchd();
        mchdpage.assertValidation();

    }

    @Test
    @Order(3)
    void ContorlSummCheck() {
        authPage.openPage().inputLogin("romashkaa").inputPass("12345678").login();
        startPage.createNewMchd();

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
        authPage.openPage().inputLogin("romashkaa").inputPass("12345678").login();
        $("button[class = 'button-wrapper header-button more blank']").click();
        $(".login-box.inner.txt-center").shouldHave(text("Войти в систему"));


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

    @Attachment(value = "Screenshot", type = "text/html", fileExtension = "html")
    public byte[] attachPageSource() {
        return WebDriverRunner.source().getBytes(StandardCharsets.UTF_8);
    }

}


