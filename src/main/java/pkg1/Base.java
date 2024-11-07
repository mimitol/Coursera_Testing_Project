package pkg1;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Base {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public Base(WebDriver driver, WebDriverWait wait) {
        this.driver=driver;
        this.wait=wait;
    }
 

	
	public WebDriver chromDriverConnection() {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return driver;

	}
	
	   
    public void visit(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    public void waitUntilElementLocated(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public void waitUntilElementInteractable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public List findElements(By locator) {
        return driver.findElements(locator);
    }
    
    public void click(By locator) {
        driver.findElement(locator).click();
    }
    
    
    public boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    
    public void selectDropDownList(By locator, String value) {
        Select select = new Select(driver.findElement(locator));
        select.selectByValue(value);
    }
    
    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }
    
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebElement type(By locator, String text) {
    	WebElement element = findElement(locator);
    	element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
    	 try {
    	        Thread.sleep(200);
    	    } catch (InterruptedException e) {
    	        e.printStackTrace();
    	    }
    	 element.sendKeys(text);
    	 
         return element;
    }
}
