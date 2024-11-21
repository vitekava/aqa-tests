import com.codeborne.selenide.*;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;



class LoginTest {

    @Test
    void successfulTest() {
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "none";


        open("https://school.qa.guru/cms/system/login?required=true");
        SelenideElement enter = $(".login-form").shouldHave(text("Войти"));

        //$("[name=email]").shouldBe(appear);
        $("[name=email]").setValue("qagurubot@gmail.com");
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
        $(".text-3xl.font-bold.mb-4.text-center.mx-auto").should(appear);
        $(".text-3xl.font-bold.mb-4.text-center.mx-auto").shouldHave(text("Выбор профиля"));

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
        $(".bg-brand-danger.text-white").shouldHave(text("Такой пользователь уже существует"));

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
}