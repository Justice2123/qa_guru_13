package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationPage {
    private final SelenideElement
            header = $(".text-center"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            state = $("#state"),
            stateWrapper = $("#stateCity-wrapper"),
            city = $("#city"),
            cityWrapper = $("#stateCity-wrapper"),
            submit = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();

    @Step("open page")
    public void openPage() {
        open("/automation-practice-form");
        header.shouldHave(text("Practice Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#Ad.Plus-')");
    }

    @Step("entering Name {value}")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("entering Last name {value}")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    @Step("entering email {value}")
    public RegistrationPage setEmailInput(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    @Step("selection gender {value}")
    public RegistrationPage setGenderWrapper(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    @Step("entering mobile number {value}")
    public RegistrationPage setUserNumberInput(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    @Step("entering date of birthday {day}.{month}.{year}")
    public RegistrationPage setDateOfBirth(String month, String year, String day) {
        calendarInput.click();
        calendarComponent.setDate(month, year, day);

        return this;
    }

    @Step("selection subject {value}")
    public RegistrationPage setSubjectInput(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    @Step("selection hobbies {value}")
    public RegistrationPage setHobbiesWrapper(String value) {
        hobbiesWrapper.find(byText(value)).click();

        return this;
    }

    @Step("selection picture {value}")
    public RegistrationPage setUploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    @Step("entering address {value}")
    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }

    @Step("selection a state {value}")
    public RegistrationPage setState(String value) {
        state.click();
        stateWrapper.find(byText(value)).click();

        return this;
    }

    @Step("selection a city {value}")
    public RegistrationPage setCity(String value) {
        city.click();
        cityWrapper.find(byText(value)).click();

        return this;
    }

    @Step("submit form")
    public RegistrationPage submit() {
        submit.click();

        return this;
    }

}
