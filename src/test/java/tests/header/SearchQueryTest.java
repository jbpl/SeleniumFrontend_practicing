package tests.header;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.TopMenuPage;
import tests.BaseTest;
import utils.PageTitleUtils;
import utils.SearchQueryUtils;

public class SearchQueryTest extends BaseTest {

    private TopMenuPage topMenuPage;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        Assertions.assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        topMenuPage = new TopMenuPage(driver);
    }

    @Test
    void shouldReturnCorrectSearchResults() {

        topMenuPage.enterSearchedText(SearchQueryUtils.PROPER_BLOUSE_SEARCH);
        topMenuPage.clickOnSearchButton();


    }
}
