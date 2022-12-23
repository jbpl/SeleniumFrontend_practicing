package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class WomenPage extends BasePage{

    public WomenPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class=\"right-block\"]//span[@class=\"price product-price\"]")
    List<WebElement> productPricesList;

    public List<BigDecimal> getProductPricesList() {
        return productPricesList.stream()
                .map(WebElement::getText)
                .map(el -> el.replaceAll("[^0-9.]", ""))
                .map(BigDecimal::new)
                .collect(Collectors.toList());
    }

    public boolean isAllPricesAboveZero(){
        return getProductPricesList().stream()
// //
    }
}
