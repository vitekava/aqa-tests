package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class LoginTestPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    private final String titleText = "Practice Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail");

    public LoginTestPage openPage() {

        open("https://demoqa.com/automation-practice-form");
        $(".text-center").shouldHave(text(titleText));

        return this;

    }

    public LoginTestPage setFirstName(String value){
        firstNameInput.setValue(value);

        return this;

    }

    public LoginTestPage setLastName(String value){
        lastNameInput.setValue(value);

        return this;

    }
    public LoginTestPage setEmail(String value){
        emailInput.setValue(value);

        return this;

    }
    public LoginTestPage setGender(){
        $("[for ='gender-radio-1']").click();

        return this;

    }
    public LoginTestPage setPhone(String value){
        $("#userNumber").setValue(value);

        return this;

    }
    public LoginTestPage setBirthDate(String day, String month, String year){
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;

    }
    public LoginTestPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();

        return this;

    }
    public LoginTestPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;

    }
}
