import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import com.github.javafaker.Faker;



class LoginTest {

    @Test
    void successfulTest() {

        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "none";

        Faker faker = new Faker();

        String userEmail = faker.internet().emailAddress();


        open("https://school.qa.guru/cms/system/login?required=true");
        sleep(5000);
        //SelenideElement enter = $(".login-form").shouldHave(text("Войти"));
        $(byText("Войти")).click();

        //$("[name=email]").shouldBe(appear);
        $("[name=email]").setValue(userEmail);
        $("[name=password]").setValue("qagurupassword").pressEnter();
        $(".btn-error").shouldHave(text("Неверный пароль"));
    }

    @Test
    void checkJunit5CodeExample() {
        Configuration.holdBrowserOpen = true;


        open("https://www.google.com/");
        SelenideElement search = $("[placeholder]");
        $("[placeholder]").setValue("github selenide").pressEnter();
        $("a[href='https://github.com/selenide/selenide']").click();
        $("#wiki-tab").click();
        $(".internal.present[href='/selenide/selenide/wiki/SoftAssertions']").click();
        //$("//div[@class='heading-element' and text()='3. Using JUnit5 extend test class:']").shouldBe(visible);
        //$("//div>div>div>div>div>div[@class='.heading-element' and contains(text(), '3. Using JUnit5 extend test class:')]").shouldBe(visible);
        //$("markdown-body:nth-of-type(6) .highlight.highlight-source-java").shouldNotBe(empty);
        //$("//div[@class='.heading-element][4]").shouldNotBe(empty);
        //$x("//div[@class='markdown-body']//div[@class='highlight highlight-source-java notranslate position-relative overflow-auto'][4]").shouldNotBe(empty);
        $$(".markdown-body .highlight.highlight-source-java.notranslate.position-relative.overflow-auto").get(3).shouldNotBe(empty);
        //$$(".markdown-body .highlight.highlight-source-java.notranslate.position-relative.overflow-auto").get(3).shouldBe(visible).shouldNotBe(empty);

        }

    @Test
    void dragtest() {
        Configuration.holdBrowserOpen = true;

        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-a").shouldHave(text("B"));
    }
    @Test
    void Registration() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        Configuration.holdBrowserOpen = true;
        //Configuration.pageLoadStrategy = "none";

        open("https://limehd.tv");

        $("a[href='/signup']").click();
        $("input[placeholder='Введите e-mail']").setValue("smartttt04@yandex.ru");
        $("input[placeholder='Введите пароль']").setValue("1234567890");
        $("input[placeholder='Повторите пароль']").setValue("1234567890");
        $(".cursor-pointer.flex.items-center.text-current").click();
        $("[type='submit']").click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //$(".text-3xl.font-bold.mb-4.text-center.mx-auto").should(appear);
        //$(".text-3xl.font-bold.mb-4.text-center.mx-auto").shouldHave(text("Выбор профиля"));
        $(".items-center.bg-brand-danger").shouldHave(text("Такой пользователь уже существует"));

    }
    @Test
    void RERegistration() {
        Configuration.holdBrowserOpen = true;
        //Configuration.pageLoadStrategy = "none";

        open("https://limehd.tv");

        $("a[href='/signup']").click();
        $("input[placeholder='Введите e-mail']").setValue("smartttt04@yandex.ru");
        $("input[placeholder='Введите пароль']").setValue("1234567890");
        $("input[placeholder='Повторите пароль']").setValue("1234567890");
        $(".cursor-pointer.flex.items-center.text-current").click();
        $("[type='submit']").click();
        $(".bg-brand-danger.text-white").shouldHave(text("Такой пользователь уже НЕ существует"));

    }
    @Test
    void InvalidRegistration() {
        Configuration.holdBrowserOpen = true;
        //Configuration.pageLoadStrategy = "none";

        open("https://limehd.tv");

        $("a[href='/signup']").click();
        $("input[placeholder='Введите e-mail']").setValue("smartttt04@yandex.ru");
        $("input[placeholder='Введите пароль']").setValue("1234567890");
        $("input[placeholder='Повторите пароль']").setValue("1234567891");
        $(".cursor-pointer.flex.items-center.text-current").click();
        $("[type='submit']").click();
        $(".text-brand-danger.text-xs").shouldNotHave(text("Пароли не совпадаютттттттт"));
    }
    @Test
    void FormTestDemoqa() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        //Configuration.pageLoadStrategy = "none";

        open("https://demoqa.com/automation-practice-form");
        $(".text-center").shouldHave(text("Practice Form"));

        $("#firstName").setValue("Viktor");
        $("#lastName").setValue("Avruiskii");
        $("#userEmail").setValue("vitya@vitya.com");
        $("[for ='gender-radio-1']").click();
        $("#userNumber").setValue("89005678909");
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
