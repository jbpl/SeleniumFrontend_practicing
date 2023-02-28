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
//        driver.manage().window().maximize();
        assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        cartLayerPage = new CartLayerPage(driver);
        topMenuPage = new TopMenuPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
    }

    @Test
    void shouldAddItemToCartLayerFromSearchPageTest() {

        String searchedTerm = SearchQueryUtils.PROPER_ONE_PRODUCT_SEARCH;

        topMenuPage.enterSearchedText(searchedTerm);
        topMenuPage.clickOnSearchButton();
        searchResultsPage.clickOnAddToCartButton();

        assertThat(cartLayerPage.isIconCheckVisible()).isTrue();
        assertThat(cartLayerPage.getProductColumnText()).contains(CartLayerUtils.SUCCESS_RESULT_STRING);
        assertThat(cartLayerPage.getProductQuantity()).isEqualTo(1);
        assertThat(cartLayerPage.getProductName()).isEqualTo(SearchQueryUtils.PROPER_ONE_PRODUCT_SEARCH);
        assertThat(cartLayerPage.getCartTotalPrice()).isPositive();
    }

    @Test
    void shouldAddSeveralItemsToCartLayerFromSearchPageTest(){
        String searchedTerm = SearchQueryUtils.PROPER_SEVERAL_PRODUCTS_SEARCH;

        topMenuPage.enterSearchedText(searchedTerm);
        topMenuPage.clickOnSearchButton();

        searchResultsPage.addSeveralItemsToCart(3);
    }
}
