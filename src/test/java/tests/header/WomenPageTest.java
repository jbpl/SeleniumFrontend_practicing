package tests.header;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.TopMenuPage;
import pages.WomenPage;
import tests.BaseTest;
import utils.PageTitleUtils;

public class WomenPageTest extends BaseTest {
    private TopMenuPage topMenuPage;
    private WomenPage womenPage;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        Assertions.assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        topMenuPage = new TopMenuPage(driver);
        womenPage = new WomenPage(driver);
    }

    @Test
    void shouldNotShowPricesLessThanOrEqualToZeroTest() {
     topMenuPage.clickOnWomenPageLink();

     Assertions.assertThat(womenPage.isAllPricesAboveZero()).isTrue();
    }
}
