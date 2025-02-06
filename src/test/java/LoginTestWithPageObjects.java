import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import pages.LoginTestPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;


public class LoginTestWithPageObjects extends LoginTestPage {

    LoginTestPage loginTestPage = new LoginTestPage();

    @Test
    void FormTestDemoqa() {

        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";

        loginTestPage.openPage()
                     .setFirstName("Viktor")
                     .setLastName("Avruiskii")
                     .setEmail("vitya@vitya.com")
                     .setGender()
                     .setPhone("89005678909")
                     .setBirthDate("1", "May", "1996");


        //$("[for ='gender-radio-1']").click();
        //$("#genderWrapper").$(byText("Other")).click();
        //$("#userNumber").setValue("89005678909");
        //$("#dateOfBirthInput").click();
        //$(".react-datepicker__year-select").click();
        //$(".react-datepicker__year-select [value='1996']").click();
        //$(".react-datepicker__month-select").click();
        //$(".react-datepicker__month-select [value='4']").click();
        //$(".react-datepicker__day.react-datepicker__day--001[aria-label='Choose Wednesday, May 1st, 1996']").click();
        $("#subjectsContainer").click();
        $("input[autocapitalize='none']").setValue("Maths").pressEnter();
        $("[for = 'hobbies-checkbox-1']").click();

        String filePath = "C:/Users/avrui/Downloads/Снимок экрана 2024-10-23 в 13.01.04.png";
        $("#uploadPicture").sendKeys(filePath);

        $("textarea[placeholder='Current Address']").setValue("Улица Пушкина, дом Колотушкина");

        executeJavaScript("window.scrollTo(0, document.body.scrollHeight);");


        $("#state").click();
        $("#react-select-3-option-1").shouldBe(text("Uttar Pradesh")).click();
        $("#city").click();
        $("#react-select-4-option-1").shouldBe(text("Lucknow")).click();

        $("#subjectsInput").pressEnter();

        loginTestPage.verifyResultsModalAppears();
        loginTestPage.verifyResult("Student Name", "Viktor Avruiskii" );
        loginTestPage.verifyResult("Student Email", "vitya@vitya.com" );
        loginTestPage.verifyResult("Gender", "Male" );


        //$(".modal-dialog").should(appear);
        //$("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        //$(".table-responsive").shouldBe(text("Viktor"), text("Avruiskii"), text("89005678909"));


    }

    @Test
    void FormTestDemoqa1() {

        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";

        loginTestPage.openPage();

        loginTestPage.setFirstName("Viktor");
        loginTestPage.setLastName("Avruiskii");
        loginTestPage.setEmail("vitya@vitya.com");
        loginTestPage.setGender();
        loginTestPage.setPhone("89005678909");


        //$("[for ='gender-radio-1']").click();
        //$("#genderWrapper").$(byText("Other")).click();
        //$("#userNumber").setValue("89005678909");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select [value='1996']").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select [value='4']").click();
        $(".react-datepicker__day.react-datepicker__day--001[aria-label='Choose Wednesday, May 1st, 1996']").click();
        $("#subjectsContainer").click();
        $("input[autocapitalize='none']").setValue("Maths").pressEnter();
        $("[for = 'hobbies-checkbox-1']").click();

        String filePath = "C:/Users/avrui/Downloads/Снимок экрана 2024-10-23 в 13.01.04.png";
        $("#uploadPicture").sendKeys(filePath);

        $("textarea[placeholder='Current Address']").setValue("Улица Пушкина, дом Колотушкина");

        executeJavaScript("window.scrollTo(0, document.body.scrollHeight);");

        //$("#state").click();

        //actions().moveToElement($("#userForm").$("#stateCity-wrapper").sibling(0)).perform();
        $("#state").click();
        $("#react-select-3-option-1").shouldBe(text("Uttar Pradesh")).click();
        $("#city").click();
        $("#react-select-4-option-1").shouldBe(text("Lucknow")).click();

        $("#subjectsInput").pressEnter();

    }

}
