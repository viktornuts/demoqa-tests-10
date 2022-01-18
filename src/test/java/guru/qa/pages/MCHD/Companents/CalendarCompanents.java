package guru.qa.pages.MCHD.Companents;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarCompanents {

    public void setDateMCHDFor() {

        $("[class='datepicker-calendar-icon']").click();
        $("[class='calendar-title']").click();
        $("[class='calendar-title']").click();
        $("[title='2019']").click();
        $("[title='Март']").click();
        $("[title='5 марта 2019']").click();
    }

    public void setDateMCHDTo() {

        $$("[class='datepicker-calendar-icon']").get(1).click();
        $("[class='calendar-title']").click();
        $("[class='calendar-title']").click();
        $("[title='2022']").click();
        $("[title='Январь']").click();
        $("[title='23 января 2022']").click();

    }

    public void setConfidantBirthday() {

        $$("[class='datepicker-calendar-icon']").get(2).click();
        $("[class='calendar-title']").click();
        $("[class='calendar-title']").click();
        $("i[class='calendar-prev-icon']").click();
        $("i[class='calendar-prev-icon']").click();
        $("i[class='calendar-prev-icon']").click();
        $("[title='1990']").click();
        $("[title='Июнь']").click();
        $("[title='22 июня 1990']").click();
    }

    public void setDocumentReleaseDate() {
        $$("[class='datepicker-calendar-icon']").get(3).click();
        $("[class='calendar-title']").click();
        $("[class='calendar-title']").click();
        $("[title='2019']").click();
        $("[title='Январь']").click();
        $("[title='13 января 2019']").click();
    }

}
