package pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class UpdateArticlePage {
	 @FindBy(xpath="(//a[contains(text(),' Edit Article')])[1]")
	    WebElement editBtn;
	    
	    @FindBy(xpath="//input[@placeholder='Article Title']")
	    WebElement articleTitle;
	    
	    @FindBy(xpath="//input[@class='form-control ' and @name='description']")
	    WebElement articleAbout;
	    
	    @FindBy(xpath="//textArea[@rows='8']")
	    WebElement textArea;
	    
	     @FindBy(xpath="//input[@placeholder='Enter tags']")
	    WebElement enterTags;
	     
	     @FindBy(xpath="//button[contains(text(),'Update Article')]")
	     WebElement update_btn;
	     
	     @FindBy(xpath="//h1[contains(text(),'Unit Test1..')]")
	       WebElement headerCheckBtn;
	     
	     @FindBy(xpath="//h1[contains(text(),'Unit Test1..')]")
	     WebElement check;
	     
	     public  UpdateArticlePage(WebDriver driver) {
	    	 PageFactory.initElements(driver,this);
	     }

		public void update(String title,String about,String text) {
		         editBtn.click();
		    	 articleTitle.clear();
		    	 articleTitle.sendKeys(title);
		    	 articleAbout.clear();
		    	 articleAbout.sendKeys(about);
		    	 textArea.clear();
		    	 textArea.sendKeys(text);
		    	 update_btn.click();
	 }
		public String updateArticleValidate() {
			return check.getText();
		}
}
