package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartLayerPage extends BasePage {

    public CartLayerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "icon-check")
    WebElement iconCheck;

    @FindBy(css = ".layer_cart_product.col-xs-12.col-md-6")
    WebElement productColumn;

    @FindBy(id = "layer_cart_product_title")
    WebElement productTitle;

    @FindBy(id = "layer_cart_product_quantity")
    WebElement productQuantity;

    public boolean isIconCheckVisible() {
        return isElementDisplayed(iconCheck);
    }

    public String getProductColumnText() {
        return productColumn.getText();
    }

    public int getProductQuantity() {
        return Integer.parseInt(productQuantity.getText());
    }
}
