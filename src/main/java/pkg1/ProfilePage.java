package pkg1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends Base {

    private LoginUtil loginUtil = new LoginUtil(); 

    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    private By profileButton = By.cssSelector("button[data-e2e='header-profile']");
    private By profileLink = By.cssSelector("a[aria-label='Profile'][href*='/account-profile']");
    private By addWorkPreferencesButton = By.cssSelector("button[data-e2e='profile-work-pref-edit']");
    private By jobTitleField = By.xpath("//button[@role='combobox'][.//p[text()='Select a role']]"); // Open dropdown
    private By jobTitleOption = By.xpath("//li[@value='back-end-developer-engineer']"); // Specific job title
    private By industryDropdown = By.xpath("//button[@role='combobox'][.//p[text()='Select an industry']]"); // Open dropdown
    private By industryOption = By.cssSelector("li[value='technology']"); // Specific industry
    private By saveButton = By.cssSelector("button[data-e2e='profile-work-pref-dialog-save']");
    private By jobTitleLocator = By.xpath("//p[text()='Back End Developer / Engineer']");



    public void goToProfilePage() {
        click(profileButton);
        waitUntilElementLocated(profileLink);
        click(profileLink);

    }
    public void loginIfNeeded() {
        loginUtil.performLogin(driver, wait);  // Use LoginUtil to perform login
    }

    public void openWorkPreferencesEditForm() {
        List<WebElement> elements = driver.findElements(addWorkPreferencesButton);

        for (WebElement element : elements) {
            if (element.isDisplayed()) {
                element.click();
                break;
            }
        }

        waitUntilElementLocated(jobTitleField);
    }

    public void setJobTitle() {
        click(jobTitleField);
        waitUntilElementLocated(jobTitleOption);
        click(jobTitleOption);
    }

    public void selectIndustry() {
        click(industryDropdown);
        waitUntilElementLocated(industryOption);
        click(industryOption);
    }

    public void savePreferences() {
        click(saveButton);
    }

    public boolean isPreferencesSaved() {
        List<WebElement> elements = driver.findElements(jobTitleLocator);

        if (!elements.isEmpty()) {
            System.out.println("Element exists: Test passed.");
            return true;
        } else {
            System.out.println("Element does not exist: Test failed.");
            return false;
        }
    }
}