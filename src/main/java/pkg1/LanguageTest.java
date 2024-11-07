package pkg1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
public class LanguageTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private LanguagePage languagePage;
    @Before
    public void setup() throws InterruptedException {
        languagePage = new LanguagePage(driver, wait);
        driver = languagePage.chromDriverConnection();
        languagePage.visit("https://www.coursera.org/");
        languagePage.loginIfNeeded();
    }

    @Test
    public void searchTest() throws InterruptedException {
        languagePage.checkAllLanguages();
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
