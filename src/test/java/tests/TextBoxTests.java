package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPageResult;

public class TextBoxTests extends TestBase {


    @Test
    void fillFormTest() {

        pages.TextBoxPage textBoxPage = new pages.TextBoxPage();
        TextBoxPageResult checkTextBox = new TextBoxPageResult();


        textBoxPage.openPage();
        textBoxPage
                .setUserName("Alex")
                .setUserEmail("alex@egorov.com")
                .setCurrentAddress("Some street 1")
                .setPermanentAddress("Another street 1")
                .submitForm();


        checkTextBox
                .checkName("Alex")
                .checkEmail("alex@egorov.com")
                .checkCurrentAddress("Some street 1")
                .checkPermanentAddress("Another street 1");


    }

}
