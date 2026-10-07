package registrationTests;

import pages.StudentRegistrationFormPage;
import test_data.TestBase;
import org.junit.jupiter.api.Test;


import static test_data.TestData.*;


public class StudentRegistrationFormWithDataTest extends TestBase {
    StudentRegistrationFormPage studentRegistrationFormPage = new StudentRegistrationFormPage();
    @Test
    void successfulRegistrationFormTest() {
        studentRegistrationFormPage
                .openPage()
                .hideBanners()
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
                .submitForm()
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
    }
}