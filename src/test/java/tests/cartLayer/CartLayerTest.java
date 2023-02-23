package tests.cartLayer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CartLayerPage;
import pages.SearchResultsPage;
import pages.TopMenuPage;
import tests.BaseTest;
import utils.CartLayerUtils;
import utils.PageTitleUtils;
import utils.SearchQueryUtils;

import static org.assertj.core.api.Assertions.assertThat;


public class CartLayerTest extends BaseTest {
    private CartLayerPage cartLayerPage;
    private TopMenuPage topMenuPage;
    private SearchResultsPage searchResultsPage;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        cartLayerPage = new CartLayerPage(driver);
        topMenuPage = new TopMenuPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
    }

    @Test
    void shouldAddItemToCartLayerFromSearchPageTest() {

        String searchedTerm = SearchQueryUtils.PROPER_BLOUSE_SEARCH;

        topMenuPage.enterSearchedText(searchedTerm);
        topMenuPage.clickOnSearchButton();
        searchResultsPage.clickOnAddToCartButton();

        assertThat(cartLayerPage.isIconCheckVisible()).isTrue();
        assertThat(cartLayerPage.getProductColumnText()).contains(CartLayerUtils.SUCCESS_RESULT_STRING);
        assertThat(cartLayerPage.getProductQuantity()).isEqualTo(1);
    }
}
