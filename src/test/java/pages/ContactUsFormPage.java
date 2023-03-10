package pages;

import model.ContactUsMessage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ContactUsFormPage extends BasePage {

    public ContactUsFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "submitMessage")
    WebElement sendButton;


    @FindBy(id = "email")
    WebElement emailInputBox;

    @FindBy(id = "id_contact")
    WebElement subjectSelector;

    @FindBy(id = "id_order")
    WebElement orderReferenceInput;

    @FindBy(id = "message")
    WebElement messageBox;

    @FindBy(className = "alert-danger")
    WebElement redAlertBox;

    @FindBy(className = "alert-success")
    WebElement greenAlertBox;

    @FindBy(id = "fileUpload")
    WebElement attachFileButton;

    public void clickOnSendButton() {
        sendButton.click();
    }

    public boolean isRedAlertBoxDisplayed() {
        return isElementDisplayed(redAlertBox);
    }

    public boolean isGreenAlertBoxDisplayed() {
        return isElementDisplayed(greenAlertBox);
    }

    public void enterEmail(String email) {
        emailInputBox.sendKeys(email);
    }

    public void sendValidContactUsForm(ContactUsMessage message) {
        Select subject = new Select(subjectSelector);
        subject.selectByVisibleText(message.getSubject().getValue());
        emailInputBox.sendKeys(message.getEmailAddress());
        orderReferenceInput.sendKeys(message.getOrderReference());
        messageBox.sendKeys(message.getMessageText());

        sendButton.click();
    }

    public boolean isAttachFileButtonActive() {
        return attachFileButton.isEnabled();
    }
}
