package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class SearchResultsPage extends BasePage {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"center_column\"]//*[@class=\"lighter\"]")
    WebElement searchResultsTitle;

    @FindBy(xpath = "//*[@id=\"center_column\"]//*[@class=\"product_list grid row\"]//*[@class=\"product-name\"]")
    List<WebElement> searchedProductsNames;

    @FindBy(xpath = "//*[@id=\"center_column\"]//*[@class=\"product_list grid row\"]//*[@class=\"right-block\"]//*[@class=\"price product-price\"]")
    List<WebElement> searchedProductsPrices;

    @FindBy(className = "bt_compare")
    List<WebElement> compareButtonsList;

    public String getSearchResultsTitle() {
        return searchResultsTitle.getText();
    }

    public List<String> getSearchedProductsNames() {
        return searchedProductsNames.stream()
                .map(el -> el.getText().trim())
                .collect(Collectors.toList());
    }

    public boolean doesEachProductNameContainTheSearchedTerm(String searchedTerm) {
        return getSearchedProductsNames().stream()
                .allMatch(el -> el.toLowerCase().contains(searchedTerm.toLowerCase()));
    }

    public List<BigDecimal> getProductPricesList() {
        wait.until(ExpectedConditions.visibilityOfAllElements(searchedProductsPrices));

        return searchedProductsPrices.stream()
                .map(WebElement::getText)
                .map(el -> el.replaceAll("[^0-9.]", ""))
                .map(BigDecimal::new)
                .collect(Collectors.toList());
    }

    public boolean areCompareButtonsEnabled() {
        return areAllWebElementsEnabled(compareButtonsList);
    }
}