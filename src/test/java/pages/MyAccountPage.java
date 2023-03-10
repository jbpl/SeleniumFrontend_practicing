package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "alert-success")
    WebElement greenAlertBox;

    public boolean isGreenAlertBoxDisplayed() {
        return isElementDisplayed(greenAlertBox);
    }
}