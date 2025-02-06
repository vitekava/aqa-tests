package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select [value='1996']").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select [value='4']").click();
        $(".react-datepicker__day.react-datepicker__day--001[aria-label='Choose Wednesday, May 1st, 1996']").click();
    }

}
