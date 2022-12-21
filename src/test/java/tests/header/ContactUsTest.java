package tests.header;

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

}
