package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends BasePage {

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email_create")
    WebElement registerEmailBox;

    @FindBy(id = "SubmitCreate")
    WebElement createAccountButton;

    public void enterRegisterEmail(String email) {
        registerEmailBox.sendKeys(email);
    }

    public void clickOnCreateAccountButton() {
        createAccountButton.click();
    }
}