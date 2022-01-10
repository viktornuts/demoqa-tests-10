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

        $$("[class='datepicker-calendar-icon']").get(2).click();
        $("[class='calendar-title']").click();
        $("[class='calendar-title']").click();
        $("[title='2022']").click();
        $("[title='Январь']").click();
        $("[title='23 января 2022']").click();

    }

}
