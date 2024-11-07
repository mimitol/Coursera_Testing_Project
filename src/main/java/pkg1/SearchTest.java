package pkg1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private SearchPage searchPage;

    @Before
	public void setup() throws InterruptedException {
    	searchPage = new SearchPage(driver, wait);
        driver = searchPage.chromDriverConnection();
        searchPage.visit("https://www.coursera.org/");
    }

    @Test
    public void searchTest() throws InterruptedException {
    	searchPage.SearchValue();
    	searchPage.filtering();
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}