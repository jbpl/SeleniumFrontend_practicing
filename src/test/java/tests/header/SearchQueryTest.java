package tests.header;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SearchResultsPage;
import pages.TopMenuPage;
import tests.BaseTest;
import utils.PageTitleUtils;
import utils.SearchQueryUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchQueryTest extends BaseTest {

    private TopMenuPage topMenuPage;
    private SearchResultsPage searchResultsPage;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        topMenuPage = new TopMenuPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
    }

    @Test
    void shouldReturnCorrectSearchResults() {

        String searchedTerm = SearchQueryUtils.PROPER_BLOUSE_SEARCH;

        topMenuPage.enterSearchedText(searchedTerm);
        topMenuPage.clickOnSearchButton();

        assertThat(searchResultsPage.getSearchResultsTitle()).containsIgnoringCase(searchedTerm);

        assertThat(searchResultsPage.doesEachProductNameContainTheSearchedTerm(searchedTerm)).isTrue();
        assertThat(searchResultsPage.isEachPriceGreaterThanZero()).isTrue();
    }
}
