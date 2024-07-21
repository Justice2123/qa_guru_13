package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TextBoxPageResult {

    private SelenideElement inputName = $("#output #name"),
            inputEmail = $("#output #email"),
            currentAddress = $("#output #currentAddress"),
            permanentAddress = $("#output #permanentAddress");


    public TextBoxPageResult checkName(String value) {
        inputName.shouldHave(text(value));

        return this;
    }

    public TextBoxPageResult checkEmail(String value) {
        inputEmail.shouldHave(text(value));

        return this;
    }

    public TextBoxPageResult checkCurrentAddress(String value) {
        currentAddress.shouldHave(text(value));

        return this;
    }

    public TextBoxPageResult checkPermanentAddress(String value) {
        permanentAddress.shouldHave(text(value));

        return this;
    }

}
