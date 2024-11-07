package pkg1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LanguagePage extends Base{
	
    private LoginUtil loginUtil = new LoginUtil();  // Instantiate LoginUtil

    public LanguagePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    By changeLanguageButton = By.cssSelector("[class=\"cds-113 cds-button-disableElevation cds-button-ghost css-n0cgmw\"]");
    By spanishButton = By.xpath("//li[.//div[contains(text(), 'Español')]]");
    By frenchButton=By.xpath("//li[.//div[contains(text(), 'Français')]]");
    By italianButton=By.xpath("//li[.//div[contains(text(), 'Italiano')]]");
    By wordToCheck=By.cssSelector(("[class=\"rc-GlobalFooter_column_container rc-GlobalFooter_column_container--logo-column\"]"));
    //for login
    By loginBtn =By.cssSelector("[data-track-component=\"login_form_submit_button\"]");
    By emailInput =By.cssSelector("[aria-label=\"Email\"]");
    By passwordInput =By.cssSelector("[aria-label=\"Password\"]");

    public void ChangeLanguageChecking(By lang,String exceptedStr) throws InterruptedException{
        waitUntilElementLocated(changeLanguageButton);
        click(changeLanguageButton);
        waitUntilElementLocated(lang);
        click(lang);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(wordToCheck, exceptedStr));
        if(getText(wordToCheck).equals(exceptedStr))
        {
            System.out.println("Language changed correctly");
        }
        else
        {
            System.out.println("trying to change language failed");
        }
    }
    public void checkAllLanguages() throws InterruptedException{
        ChangeLanguageChecking(spanishButton, "Aplicación móvil");
        ChangeLanguageChecking(frenchButton, "Application mobile");
        ChangeLanguageChecking(italianButton, "app mobile");
    }

    public void loginIfNeeded()
    {
        loginUtil.performLogin(driver, wait);  // Use LoginUtil to perform login

    }


}
