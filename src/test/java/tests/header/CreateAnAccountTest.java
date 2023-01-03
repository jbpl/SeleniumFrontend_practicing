package tests.header;

import com.github.javafaker.Faker;
import model.YourPersonalInformationForm;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AuthenticationPage;
import pages.CreateAnAccountPage;
import pages.MyAccountPage;
import pages.TopMenuPage;
import tests.BaseTest;
import utils.PageTitleUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateAnAccountTest extends BaseTest {

    private TopMenuPage topMenuPage;
    private AuthenticationPage authenticationPage;
    private CreateAnAccountPage createAnAccountPage;
    private MyAccountPage myAccountPage;
    private String randomEmail;


    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        topMenuPage = new TopMenuPage(driver);
        authenticationPage = new AuthenticationPage(driver);
        createAnAccountPage = new CreateAnAccountPage(driver);
        myAccountPage = new MyAccountPage(driver);
    }

    @Test
    void shouldCreateAccountWithValidData() {

        Faker faker = new Faker();
        randomEmail = faker.internet().emailAddress();

        topMenuPage.clickOnSignInButton();
        authenticationPage.enterRegisterEmail(randomEmail);
        authenticationPage.clickOnCreateAccountButton();
        createAnAccountPage.clickOnGender1Button();

        YourPersonalInformationForm form = new YourPersonalInformationForm();
        form.setFirstName("Han");
        form.setLastName("Solo");
        form.setPassword("Leia123");
        createAnAccountPage.sendValidYourPersonalInformationForm(form);

        Assertions.assertThat(myAccountPage.isGreenAlertBoxDisplayed()).isTrue();
        Assertions.assertThat(topMenuPage.getHeaderUserName()).isEqualTo("Han Solo");
    }
}