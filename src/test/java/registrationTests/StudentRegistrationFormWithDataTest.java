package registrationTests;

import org.junit.jupiter.api.DisplayName;
import pages.StudentRegistrationFormPage;
import test_data.TestBase;
import org.junit.jupiter.api.Test;


import static io.qameta.allure.Allure.step;
import static test_data.TestData.*;


public class StudentRegistrationFormWithDataTest extends TestBase {
    StudentRegistrationFormPage studentRegistrationFormPage = new StudentRegistrationFormPage();
    @Test
    @DisplayName("Successful Registration")
    void successfulRegistrationFormTest() {
        step("Open registration page", () -> {
        studentRegistrationFormPage
                .openPage()
                .hideBanners();
        });
        step("Fill registration form", () -> {
        studentRegistrationFormPage
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(userEmail)
                .setGender(sex)
                .typeUserNumber(userNumber)
                .setDateOfBirth (day,month,year)
                .setSubjects(subject)
                .setHobby(hobby)
                .uploadPicture(picture)
                .setCurrentAddress(currentAddress)
                .chooseStateAndCity(state, city)
                .submitForm();
        });
        step("Check registration form results data", () -> {
        studentRegistrationFormPage
                .resultWindowAppear()
                .checkForm("Student Name", firstName + " " + lastName)
                .checkForm("Student Email", userEmail)
                .checkForm("Gender", sex)
                .checkForm("Mobile", userNumber)
                .checkForm("Date of Birth", day + " " + month + "," + year)
                .checkForm("Subjects", subject)
                .checkForm("Hobbies", hobby)
                .checkForm("Address", currentAddress)
                .checkForm("Picture", picture)
                .checkForm("State and City", state + " " + city)
                .closeForm();
    });
    }
}