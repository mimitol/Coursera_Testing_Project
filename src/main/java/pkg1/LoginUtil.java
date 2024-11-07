package pkg1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginUtil {
    private String email = "shanshe2004@gmail.com";
    private String password = "PsqvH7_$LGi#g@p";

    private By emailInput = By.cssSelector("[aria-label=\"Email\"]");
    private By passwordInput = By.cssSelector("[aria-label=\"Password\"]");
    private By loginBtn = By.cssSelector("[data-track-component=\"login_form_submit_button\"]");

    public void performLogin(WebDriver driver, WebDriverWait wait) {
        driver.get("https://www.coursera.org/?authMode=login");
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginBtn).click();
    }
}
