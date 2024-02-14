package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
public class NewArticlePageTest {
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
	    
	   public NewArticlePageTest(WebDriver driver) {
	 		PageFactory.initElements(driver,this);
	 	}
	   public void newArticle() {
		   newArticle_btn.click();
		   articleTitle.sendKeys("Unit Test"); 
		   articleAbout.sendKeys("About Unit Test");
		   textArea.sendKeys("Unit Testing Details");
		   enterTags.sendKeys("UnitTest");
		   pub_article_btn.click();
		   String headerName=headerBtn.getText();
		   System.out.println("New Article Title-"+headerName);
		   Assert.assertEquals(headerName,"Unit Test");
		 }
}
