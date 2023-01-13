package tests.header;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.TopMenuPage;
import pages.WomenPage;
import tests.BaseTest;
import utils.PageTitleUtils;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WomenPageTest extends BaseTest {
    private TopMenuPage topMenuPage;
    private WomenPage womenPage;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        topMenuPage = new TopMenuPage(driver);
        womenPage = new WomenPage(driver);
    }

    @Test
    void shouldShowPricesGreaterThanZero() {
        topMenuPage.clickOnWomenPageLink();

        List<BigDecimal> pricesList = womenPage.getProductPricesList();
        assertThat(womenPage.isEachPriceGreaterThanZero(pricesList)).isTrue();
        assertThat(womenPage.areCompareButtonsEnabled()).isFalse();
    }
}
