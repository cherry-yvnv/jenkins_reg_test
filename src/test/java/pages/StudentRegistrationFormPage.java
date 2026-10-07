package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.ResultComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormPage {
    //Elements
    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement genderContainer = $("#genterWrapper");
    private SelenideElement userNumberInput = $("#userNumber");
    CalendarComponent calendar = new CalendarComponent();
    ResultComponent resultComponent = new ResultComponent();
    private SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private SelenideElement subjectsInput = $("#subjectsInput");
    private SelenideElement hobbiesWrapper = $("#hobbiesWrapper");
    private SelenideElement pictureInput = $("#uploadPicture");
    private SelenideElement currentAddressInput = $("#currentAddress");
    private SelenideElement stateList = $("#state");
    private SelenideElement cityList = $("#city");
    private SelenideElement submitButton = $("#submit");

    //Actions
    @Step("Open registration page /automation-practice-form")
    public StudentRegistrationFormPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public StudentRegistrationFormPage hideBanners() {
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);
        return this;
    }
    @Step("Type first name \"{value}\"")
    public StudentRegistrationFormPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    @Step("Type first name \"{value}\"")
    public StudentRegistrationFormPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    @Step("Type user email \"{value}\"")
    public StudentRegistrationFormPage typeUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    @Step("Set gender \"{value}\"")
    public StudentRegistrationFormPage setGender(String value) {
        genderContainer.$(byText(value)).click();
        return this;
    }
    @Step("Type user number \"{value}\"")
    public StudentRegistrationFormPage typeUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    @Step("Set birthday")
    public StudentRegistrationFormPage setDateOfBirth(String day, String month, String year) {
        $(dateOfBirthInput).click();
        calendar.setDate(day, month, year);
        return this;
    }
    @Step("Set subjects \"{value}\"")
    public StudentRegistrationFormPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    @Step("Set hobby \"{hobby}\"")
    public StudentRegistrationFormPage setHobby(String hobby) {
        hobbiesWrapper.$(byText(hobby)).click();
        return this;
    }
    @Step("Set picture \"{value}\"")
    public StudentRegistrationFormPage uploadPicture(String value) {
        pictureInput.uploadFromClasspath(value);
        return this;
    }
    @Step("Set current address \"{value}\"")
    public StudentRegistrationFormPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }
    @Step("Set state \"{value}\"")
    public StudentRegistrationFormPage chooseState(String value) {
        stateList.click();
        $(byText(value)).click();
        return this;
    }
    @Step("Set city \"{value}\"")
    public StudentRegistrationFormPage chooseCity(String value) {
        cityList.click();
        $(byText(value)).click();
        return this;
    }
    @Step("Set state and city \"{state}\" and \"{city}\"")
    public StudentRegistrationFormPage chooseStateAndCity(String state, String city) {
        chooseState(state);
        chooseCity(city);
        return this;
    }
    @Step("Submit form")
    public StudentRegistrationFormPage submitForm() {
        submitButton.click();
        return this;
    }
    @Step("Check result window appears")
    public StudentRegistrationFormPage resultWindowAppear() {
        resultComponent.checkResultWindow();
        return this;
    }
    @Step("check form \"{key}\" and \"{value}\"")
    public StudentRegistrationFormPage checkForm(String key, String value) {
        resultComponent.checkResult(key, value);
        return this;
    }
    @Step("close form")
    public StudentRegistrationFormPage closeForm() {
        resultComponent.closeWindow();
        return this;
    }
}

