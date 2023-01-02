package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public boolean isEachPriceGreaterThanZero(List<BigDecimal> pricesList) {
        return pricesList.stream()
                .allMatch(el -> el.compareTo(BigDecimal.ZERO) > 0);
    }
}
