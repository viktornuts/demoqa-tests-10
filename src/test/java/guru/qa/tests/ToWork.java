package guru.qa.tests;


import com.codeborne.selenide.Configuration;
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

    @BeforeEach
    void before(){

        open("https://mchd-front-ui-mchd-tst.tst.cld.esphere.local");
        $("#IDToken1").setValue("romashkaa");
        $("#IDToken2").setValue("12345678");
        $("[name='Login.Submit']").click();

    }

    @AfterEach
    void after(){
        closeWebDriver();
    }




    @Test
    @Order(1)
    void fillFromTest() {

        //Главная страница сервиса МЧД - создать
        $("[class='button-wrapper success']").click();

        //Полномочия по доверенности

        $("[class='datepicker-calendar-icon']").click();
        $("[class='calendar-title']").click();
        $("[class='calendar-title']").click();
        $("[title='2019']").click();
        $("[title='Март']").click();
        $("[title='5 марта 2019']").click();

        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[2]/dd[1]/div/div[2]/div/span/span")).click();
        $("[class='calendar-title']").click();
        $("[class='calendar-title']").click();
        $("[title='2022']").click();
        $("[title='Ноябрь']").click();
        $("[title='22 ноября 2022']").click();

        $("[class='multiselect-tags-container']").scrollIntoView(true);
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[2]/dd[2]/div/div[1]/div")).click();
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[2]/dd[2]/div/div[2]/div[2]/div/ul/li[1]/div/div")).click();

        //Сведения о доверителе

        $("[name='companyName']").setValue("ООО \"Рога и копыта\"");
        $("input[name='inn']").setValue("4431602938");
        $("input[name='kpp']").setValue("270545600");
        $("input[name='ogrnip']").setValue("6083327334755");
        $("input[name='address']").setValue("Москва ул.Пушкина дом 1");
        $("input[name='chief_lastName']").setValue("Доверчивый");
        $("input[name='chief_firstName']").setValue("Петр");
        $("input[name='chief_middleName']").setValue("Петрович");
        $("input[name='position']").setValue("Директор по экономике");
        $("input[name='chief_inn']").setValue("476826216095");

        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[5]/dd[3]/ul/li[3]/div/div/input")).click();
        $("input[name='chief_snils']").sendKeys("253 799 532 23");

        //Сведенеия о представителе (доверенной стороне)

        $("input[name='confidant_lastName']").setValue("Подписантов");
        $("input[name='confidant_firstName']").setValue("Олег");
        $("input[name='confidant_middleName']").setValue("Иванович");

        $("input[name='confidant_inn']").scrollIntoView(true);

        $("input[name='confidant_inn']").setValue("832231002384");
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[6]/dd[2]/ul/li[3]/div/div/input")).click();
        $("input[name='confidant_snils']").sendKeys("201 531 994 22");

        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[6]/dd[3]/div/div/span/span")).click();
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[6]/dd[3]/div/div[2]/div[1]/span[2]")).click();
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[6]/dd[3]/div/div[2]/div[1]/span[2]")).click();
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[6]/dd[3]/div/div[2]/div[1]/span[1]/i")).click();
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[6]/dd[3]/div/div[2]/div[1]/span[1]/i")).click();
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[6]/dd[3]/div/div[2]/div[1]/span[1]/i")).click();
        $("[title='1990']").click();
        $("[title='Июнь']").click();
        $("[title='22 июня 1990']").click();

        //Документ удостоверяющий личность

        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[7]/dl/dd[1]/div/div/span")).click();
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[7]/dl/dd[1]/div/div[2]/ul/li[2]")).click();
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[7]/dl/dd[3]/div/div/input")).click();
        $("input[name='documentNumber']").sendKeys("7512 203313");

        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[7]/dl/dd[3]/div/div/span/span")).click();
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[7]/dl/dd[3]/div/div[2]/div[1]/span[2]")).click();
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[7]/dl/dd[3]/div/div[2]/div[1]/span[2]")).click();
        $("[title='2019']").click();
        $("[title='Январь']").click();
        $("[title='13 января 2019']").click();
        $("input[name='docIssuerName']").setValue("Отделением №1 УФМС России по Челябинской области");

        $(By.xpath("/html/body/div[2]/div/div/div/div[4]/ul/li[2]/button")).scrollIntoView(true);
        $(By.xpath("/html/body/div[2]/div/div/div/div[4]/ul/li[2]/button")).click();

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
        $(By.xpath("/html/body/div[2]/div/div/div/div[4]/ul/li[2]/button")).scrollTo().click();

        //Assert

        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[2]/dd[1]/div/div[1]/span/span")).shouldHave(text("Поле обязательно для заполнения"));
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[2]/dd[1]/div/div[2]/span/span")).shouldHave(text("Поле обязательно для заполнения"));
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[2]/dd[2]/div/span/span")).shouldHave(text("Поле обязательно для заполнения"));
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[4]/dd[1]/div/span/span")).shouldHave(text("Поле обязательно для заполнения"));
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[4]/dd[2]/ul/li[1]/div/span/span")).shouldHave(text("Поле обязательно для заполнения"));
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[4]/dd[2]/ul/li[3]/div/span/span")).shouldHave(text("Поле обязательно для заполнения"));
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[4]/dd[2]/ul/li[5]/div/span/span")).shouldHave(text("Поле обязательно для заполнения"));
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[4]/dd[3]/div/span/span")).shouldHave(text("Поле обязательно для заполнения"));
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[5]/dd[1]/ul/li[1]/div/span/span")).shouldHave(text("Поле обязательно для заполнения"));
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[5]/dd[1]/ul/li[2]/div/span/span")).shouldHave(text("Поле обязательно для заполнения"));
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[5]/dd[3]/ul/li[1]/div/span/span")).shouldHave(text("Поле обязательно для заполнения"));
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[5]/dd[3]/ul/li[3]/div/span/span")).shouldHave(text("Поле обязательно для заполнения"));
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[6]/dd[1]/ul/li[1]/div/span/span")).shouldHave(text("Поле обязательно для заполнения"));
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[6]/dd[1]/ul/li[2]/div/span/span")).shouldHave(text("Поле обязательно для заполнения"));
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[7]/dl/dd[1]/div/span/span")).shouldHave(text("Поле обязательно для заполнения"));
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[7]/dl/dd[2]/div/span/span")).shouldHave(text("Поле обязательно для заполнения"));
        $(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/dl[7]/dl/dd[3]/div/span/span")).shouldHave(text("Поле обязательно для заполнения"));

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

//    @Test
//    @Order(4)
//
//    void Logout {
//
//
//
//
//    }



}


