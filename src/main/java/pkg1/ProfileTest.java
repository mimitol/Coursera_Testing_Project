package pkg1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class ProfileTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private ProfilePage profilePage;
    private Base base;


    @Before
    public void setUp() {
        base = new Base(driver, wait);
        driver = base.chromDriverConnection();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        profilePage = new ProfilePage(driver, wait);

    }

    @Test
    public void testAddWorkPreferences() {
    	profilePage.loginIfNeeded();
        profilePage.goToProfilePage();
        profilePage.openWorkPreferencesEditForm(); 
        profilePage.setJobTitle();
        profilePage.selectIndustry();
        profilePage.savePreferences();
        profilePage.isPreferencesSaved();
        assertTrue("Preferences were not saved successfully", profilePage.isPreferencesSaved());
    }



    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}