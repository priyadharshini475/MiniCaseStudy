package pages;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class DeleteArticlePage {
	WebDriver driver;
	@FindBy(xpath = "//button[@class='btn btn-sm'][1]")
	WebElement deleteBtn;
	
	@FindBy(xpath="//div[contains(text(),'Articles not available.')]")
	WebElement check;
	
	 public DeleteArticlePage(WebDriver driver) {
		 this.driver=driver;
	 		PageFactory.initElements(driver,this);
	 	}
	 public void deleteArticle()
		{
			deleteBtn.click();
			Alert alert=driver.switchTo().alert();
			alert.accept();
			
		}
	 public String deleteValidate() {
		 return check.getText();
	 }

}
