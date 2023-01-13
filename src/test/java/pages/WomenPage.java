package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class WomenPage extends BasePage {

    public WomenPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class=\"right-block\"]//span[@class=\"price product-price\"]")
    List<WebElement> productPricesList;

    @FindBy(className = "bt_compare")
    List<WebElement> compareButtonsList;

    public List<BigDecimal> getProductPricesList() {
        wait.until(ExpectedConditions.visibilityOfAllElements(productPricesList));

        return productPricesList.stream()
                .map(WebElement::getText)
                .map(el -> el.replaceAll("[^0-9.]", ""))
                .map(BigDecimal::new)
                .collect(Collectors.toList());
    }

    public boolean areCompareButtonsEnabled() {
        return areAllWebElementsEnabled(compareButtonsList);
    }
}
