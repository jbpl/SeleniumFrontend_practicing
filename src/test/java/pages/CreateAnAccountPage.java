package pages;

import model.YourPersonalInformationForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateAnAccountPage extends BasePage {
    public CreateAnAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_gender1")
    WebElement gender1Checkbox;

    @FindBy(id = "customer_firstname")
    WebElement customerFirstNameInputBox;

    @FindBy(id = "customer_lastname")
    WebElement customerLastNameInputBox;

    @FindBy(id = "passwd")
    WebElement passwordInputBox;

    @FindBy(id = "submitAccount")
    WebElement registerAccountButton;

    public void clickOnGender1Button() {
        wait.until(ExpectedConditions.visibilityOfAllElements(gender1Checkbox));
        gender1Checkbox.click();
    }

    public void sendValidYourPersonalInformationForm(YourPersonalInformationForm form) {
        customerFirstNameInputBox.sendKeys(form.getFirstName());
        customerLastNameInputBox.sendKeys(form.getLastName());
        passwordInputBox.sendKeys(form.getPassword());
        registerAccountButton.click();
    }
}