package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultComponent {
    private SelenideElement resultWindow = $(".modal-open");
    private SelenideElement tableOutput = $(".table-responsive");
    private SelenideElement closeButton = $("#closeLargeModal");


    public void checkResultWindow() {
        resultWindow.should(appear);
    }

    public void checkResult(String key, String value) {
        tableOutput.$(byText(key)).parent().shouldHave(text(value));
    }

    public  void closeWindow() {
        closeButton.click();
    }
}
