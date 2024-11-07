package pkg1;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class FormTest {
	    private WebDriver driver;
	    private WebDriverWait wait;
	    private FormPage formPage;
 
	   
	    @Before
		public void setup() throws InterruptedException {
	    	formPage = new FormPage(driver, wait);
	        driver = formPage.chromDriverConnection();
	        formPage.visit("https://www.coursera.org/courseraplus/?adgroupid=168083277494&adposition=&authMode=signup&campaignid=21836581617&creativeid=718590611982&device=c&devicemodel=&gad_source=1&gclid=EAIaIQobChMIg9eCvLuziQMVdoCDBx3EOBOkEAAYASAAEgLUtvD_BwE&hide_mobile_promo&keyword=coursera&matchtype=e&network=g&utm_campaign=b2c_emea_coursera-plus_coursera_ftcof_subscription_oct-24_dr_geo-multi-set1_sem_rsa_gads_lg-en&utm_medium=sem&utm_source=gg");

	    }

	    @Test
	    public void formTest() throws InterruptedException {
	    	formPage.runTheTest();
	    }
	    @After
		public void endTest() throws InterruptedException {
	        Thread.sleep(20000);
	        driver.quit();
	    }
	    /*@After
          public void tearDown() {
        if (driver != null) {
            driver.quit();
            }
        }
	     * */
}
