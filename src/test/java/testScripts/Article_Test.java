package testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import base.TestBase;
//import commonUtils.Utility;
import pages.DeleteArticlePage;
import pages.LoginPageArticle;
import pages.NewArticlePageTest;
import pages.UpdateArticle;

public class Article_Test {
	WebDriver driver;
	LoginPageArticle loginPage;
	NewArticlePageTest newArticlePage;
	UpdateArticle updateArticle;
	DeleteArticlePage deleteArticle;

	public Article_Test() {
		TestBase.initDriver();
		driver=TestBase.getDriver();
		loginPage=new LoginPageArticle(driver);
		newArticlePage=new NewArticlePageTest(driver);
		updateArticle=new UpdateArticle(driver);
		deleteArticle=new DeleteArticlePage(driver);
	}

 @BeforeTest
	public void setup() {
		TestBase.openUrl("https://conduit-realworld-example-app.fly.dev/");
	}
	@Test(priority=1)
	public void loginTest() {
	
		loginPage.loginTest("priyadharshini475507@gmail.com","abcd1234");
	}
	@Test(priority=2)
	public void newArticle() {
	
		newArticlePage.newArticle();
	}
	@Test(priority=3)
	public void update_Article() {
	
		updateArticle.update();
	}
	@Test(priority=4)
	public void delete_Article() {
	
		deleteArticle.deleteArticle();
	}

	}