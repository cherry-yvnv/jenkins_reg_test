package pages;

import com.codeborne.selenide.SelenideElement;
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

    public StudentRegistrationFormPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public StudentRegistrationFormPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public StudentRegistrationFormPage typeUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public StudentRegistrationFormPage setGender(String value) {
        genderContainer.$(byText(value)).click();
        return this;
    }

    public StudentRegistrationFormPage typeUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public StudentRegistrationFormPage setDateOfBirth(String day, String month, String year) {
        $(dateOfBirthInput).click();
        calendar.setDate(day, month, year);
        return this;
    }

    public StudentRegistrationFormPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public StudentRegistrationFormPage setHobby(String hobby) {
        hobbiesWrapper.$(byText(hobby)).click();
        return this;
    }

    public StudentRegistrationFormPage uploadPicture(String value) {
        pictureInput.uploadFromClasspath(value);
        return this;
    }

    public StudentRegistrationFormPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public StudentRegistrationFormPage chooseState(String value) {
        stateList.click();
        $(byText(value)).click();
        return this;
    }

    public StudentRegistrationFormPage chooseCity(String value) {
        cityList.click();
        $(byText(value)).click();
        return this;
    }

    public StudentRegistrationFormPage chooseStateAndCity(String state, String city) {
        chooseState(state);
        chooseCity(city);
        return this;
    }

    public StudentRegistrationFormPage submitForm() {
        submitButton.click();
        return this;
    }

    public StudentRegistrationFormPage resultWindowAppear() {
        resultComponent.checkResultWindow();
        return this;
    }

    public StudentRegistrationFormPage checkForm(String key, String value) {
        resultComponent.checkResult(key, value);
        return this;
    }

    public StudentRegistrationFormPage closeForm() {
        resultComponent.closeWindow();
        return this;
    }
}

