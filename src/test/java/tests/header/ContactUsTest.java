package tests.header;

import enums.ContactUsMessageSubject;
import model.ContactUsMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ContactUsFormPage;
import pages.TopMenuPage;
import tests.BaseTest;
import utils.PageTitleUtils;

class ContactUsTest extends BaseTest {
    private TopMenuPage topMenuPage;
    private ContactUsFormPage contactUsFormPage;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        Assertions.assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        topMenuPage = new TopMenuPage(driver);
        contactUsFormPage = new ContactUsFormPage(driver);
    }

    @Test
    void shouldNotAllowToSendEmptyContactUsFormTest() {
        topMenuPage.clickOnContactUsLink();
        contactUsFormPage.clickOnSendButton();

        Assertions.assertThat(contactUsFormPage.isRedAlertBoxDisplayed()).isTrue();
    }

    @Test
    void shouldNotAllowToSendContactUsFormWithEmailOnlyTest() {
        topMenuPage.clickOnContactUsLink();
        contactUsFormPage.enterEmail("jb@pl.pl");
        contactUsFormPage.clickOnSendButton();

        Assertions.assertThat(contactUsFormPage.isRedAlertBoxDisplayed()).isTrue();
    }

    @Test
    void shouldSendContactUsFormWithValidDataTest() {
        topMenuPage.clickOnContactUsLink();

        ContactUsMessage message = new ContactUsMessage();
        message.setSubject(ContactUsMessageSubject.WEBMASTER);
        message.setEmailAddress("jb@pl.pl");
        message.setOrderReference("Order 66");
        message.setMessageText("Cancel");

        contactUsFormPage.sendValidContactUsForm(message);
        Assertions.assertThat(contactUsFormPage.isGreenAlertBoxDisplayed()).isTrue();
    }
}
