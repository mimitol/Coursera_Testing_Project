package pkg1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends Base{
   public SearchPage(WebDriver driver, WebDriverWait wait) {
       super(driver, wait);
   }
   
       By join = By.cssSelector("[class=\"cds-160 cds-button-disableElevation cds-button-primary css-ycfn34\"]");
       By searchBar = By.cssSelector("[id=\"search-autocomplete-input\"]");
       By searchInput = By.cssSelector("[id=\"search-autocomplete-input\"]");
       By searchButton = By.cssSelector("[class=\"nostyle search-button\"]");
       By coursesList = By.cssSelector("[class=\"cds-ProductCard-gridCard\"]");
       By spcificTitle = By.cssSelector("[data-e2e=\"hero-title\"]");
       By filterType = By.cssSelector("[data-testid=\"Beginner-false\"]");
       By coursesAfterFiltering = By.cssSelector("[class=\"cds-ProductCard-gridCard\"]");
       
      String valueToSearch = "AI";
       public void SearchValue() throws InterruptedException {
          type(searchInput,valueToSearch);
          findElement(searchButton).sendKeys(Keys.ENTER);
          List<WebElement> courses = findElements(coursesList);
          boolean flag=false;
          String title;
          int marketing = 0;
          for (WebElement course : courses) {
        	  if(!flag) {
        		  title= course.getText();
                  if (!title.contains(valueToSearch)) {
                      if(!title.contains("Google Prompting Essentials")) {
                          flag=true;
                      }
                   }
                  if (title.contains("Marketing")) {
                      marketing++;
                  }
        	  }
        	  else {
        	     break;
        	  }
        	  
              
          }
          if(flag) {
              System.out.println("Course without "+valueToSearch+" in title found");
          }
          else {
              System.out.println("All courses with "+valueToSearch+"in title");
          }
          
          System.out.println("Amount of courses that talks about marketing:"+marketing);
         
       }
       
       //works only when the filter appear on the side
       public void filtering() throws InterruptedException{
    	   click(filterType);
    	   List<WebElement> coursesAfterFilter = findElements(coursesAfterFiltering);
    	   String filter = "Begginer";
    	   String title;
    	   boolean flag = false;
    	   for(WebElement course : coursesAfterFilter) {
    		   if(!flag) {
    			   title = course.getText();
    			   if (!title.contains(filter)) {
                       flag=true;
    			   }
    			 }
    		   else {
    			   break;
    		   }
    	   }
    	   if(flag) {
               System.out.println("Course with "+filter+" in title found");
           }
           else {
               System.out.println("All courses without "+filter+" in title");
           }       
       }
}


