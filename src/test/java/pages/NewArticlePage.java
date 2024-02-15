package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
public class NewArticlePage {
	 @FindBy(xpath="//a[@href='#/editor']")
	   WebElement newArticle_btn;
	   
	   @FindBy(xpath="//input[@placeholder='Article Title']")
	   WebElement articleTitle;
	   
	   @FindBy(xpath="//input[@class='form-control ' and @name='description']")
	   WebElement articleAbout;
	   
	   @FindBy(xpath="//textArea[@rows='8']")
	   WebElement textArea;
	   
	    @FindBy(xpath="//input[@placeholder='Enter tags']")
	   WebElement enterTags;
	    
	    @FindBy(xpath="//button[@type='submit']")
	    WebElement pub_article_btn;
	    
	    @FindBy(xpath="//h1[contains(text(),'Unit Test')]")
	    WebElement headerBtn;
	    
	   public NewArticlePage(WebDriver driver) {
	 		PageFactory.initElements(driver,this);
	 	}
	   public void newArticle(String str1,String str2,String str3,String str4) {
		   newArticle_btn.click();
		   articleTitle.sendKeys(str1); 
		   articleAbout.sendKeys(str2);
		   textArea.sendKeys(str3);
		   enterTags.sendKeys(str4);
		   pub_article_btn.click();
		  
		   
		 
		 }

}
