package tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PopularItemsPage;
import utils.PageTitleUtils;

import java.util.List;
import java.util.stream.Collectors;

class HomePageTest extends BaseTest {

    private PopularItemsPage popularItemsPage;

    @BeforeEach
    public void SetupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        Assertions.assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        popularItemsPage = new PopularItemsPage(driver);
    }

    @Test
    void shouldSeePopularItemsOnHomePage() {
        List<String> productNames = popularItemsPage.getProductNames();

        List<String> productsWithEmptyNames = productNames.stream()
                .filter(el -> el.isEmpty())
                .collect(Collectors.toList());

        Assertions.assertThat(productsWithEmptyNames).isEmpty();
    }
}
