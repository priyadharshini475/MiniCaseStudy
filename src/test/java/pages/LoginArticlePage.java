package pages;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class LoginArticlePage {
	@FindBy(xpath="//a[@href='#/login']")
    WebElement login_btn;
    @FindBy(xpath="//input[@name='email']")
    WebElement email;
    @FindBy(xpath="//input[@name='password']")
    WebElement password;
    @FindBy(xpath="//button[contains(text(),'Login')]")
    WebElement loginbtn;
    @FindBy(xpath="//div[contains(text(),'Priyadharshini')]")
    WebElement check;
    
    public LoginArticlePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
    public void loginTest(String strmail,String strpassword) {
  	
  	  login_btn.click();
  	  email.sendKeys(strmail);
  	  password.sendKeys(strpassword);
  	  loginbtn.click();
  	}
   public String checkValidLogin() {
    	 return check.getText();
    }
    

}
