package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";

    }

    @Test
    void fillFormTests() {
        open("/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ivanov@yahoo.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("7958473526");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__day--010:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Biology").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/img/2.png"));
        $("#currentAddress").setValue("Lala street 44");
        $("div").scrollTo();
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();


        $("#example-modal-sizes-title-lg").shouldHave(exactText("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                Condition.text("Student Name Ivan Ivanov"),
                Condition.text("Student Email ivanov@yahoo.com"),
                Condition.text("Gender Male"),
                Condition.text("Mobile 7958473526"),
                Condition.text("Date of Birth 10 October,1990"),
                Condition.text("Subjects Biology"),
                Condition.text("Hobbies Reading"),
                Condition.text("Picture 2.png"),
                Condition.text("Address Lala street 44"),
                Condition.text("State and City NCR Noida")

        );
    }
}