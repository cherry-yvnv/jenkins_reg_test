package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;



public class CalendarComponent {

    private SelenideElement monthPick = $(".react-datepicker__month-select");
    private SelenideElement yearPick = $(".react-datepicker__year-select");

    public void setDate(String day, String month, String year) {
        monthPick.$(byText(month)).click();
        yearPick.$(byText(year)).click();
        $(".react-datepicker__day.react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
    }


}
