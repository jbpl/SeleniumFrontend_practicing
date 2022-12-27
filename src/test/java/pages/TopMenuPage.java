package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenuPage extends BasePage {

    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Contact us")
    WebElement contactUsLink;

    @FindBy(linkText = "Women")
    WebElement womenPageLink;

    @FindBy(id = "search_query_top")
    WebElement searchBoxInput;

    @FindBy(name = "submit_search")
    WebElement searchButton;

    public void clickOnContactUsLink() {
        contactUsLink.click();
    }

    public void clickOnWomenPageLink() {
        womenPageLink.click();
    }

    public void enterSearchedText(String text) {
        searchBoxInput.sendKeys(text);
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }
}
