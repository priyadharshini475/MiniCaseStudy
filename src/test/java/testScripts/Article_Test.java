package testScripts;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
import CommonUtils.Utility;
import base.TestBase;
import pages.DeleteArticlePage;
import pages.LoginArticlePage;
import pages.NewArticlePage;
import pages.UpdateArticlePage;

public class Article_Test {
	WebDriver driver;
	LoginArticlePage loginPage;
	NewArticlePage newArticlePage;
	UpdateArticlePage updateArticle;
	DeleteArticlePage deleteArticle;
	ExtentReports extentReports;
	ExtentSparkReporter spark;
	ExtentTest extentTest;
	public Article_Test() {
		TestBase.initDriver();
		driver=TestBase.getDriver();
		loginPage=new LoginArticlePage(driver);
		newArticlePage=new NewArticlePage(driver);
		updateArticle=new UpdateArticlePage(driver);
		deleteArticle=new DeleteArticlePage(driver);
	}
	@BeforeTest
	public void setupExtent() {
		extentReports=new ExtentReports();
		spark=new ExtentSparkReporter("test-output/Sparkreport.html")
				   .viewConfigurer()
				   .viewOrder()
				   .as(new ViewName[] {
						 ViewName.DASHBOARD,
						 ViewName.TEST,
						 ViewName.AUTHOR,
						 ViewName.DEVICE,
						 ViewName.LOG
				   }).apply();
	    extentReports.attachReporter(spark);
	}

 @BeforeTest
	public void setup() {
		TestBase.openUrl("https://conduit-realworld-example-app.fly.dev/");
	}
   @Test(priority=1)
    public void inValidLoginTest() {
	   extentTest=extentReports.createTest("InValidLogin Test");
	  loginPage.inValidLoginTest("priyadharshini475507@gmail.com","abcd123");
	  Assert.assertEquals(loginPage.checkInValidLogin(),"Wrong email/password combination");

   }
	@Test(priority=2)
	public void validLoginTest() {
		extentTest=extentReports.createTest("ValidLogin Test");
		loginPage.validLoginTest("priyadharshini475507@gmail.com","abcd1234");
		Assert.assertEquals(loginPage.checkValidLogin(),"Priyadharshini");
		
	}
	@Test(priority=3)
	public void duplicateArticleTest() {
		 extentTest=extentReports.createTest("Duplicate Article Test");
		newArticlePage.newArticle("Smoke Test","About Smoke Test","Smoke Testing Details","SmokeTest");
		Assert.assertEquals(newArticlePage.duplicateArticleValidate(),"Title already exists..");
	}
	@Test(priority=4)
	public void newArticleTest() {
	  extentTest=extentReports.createTest("New Article Test");
		newArticlePage.newArticle("Unit Test","About Unit Test","Unit Testing Details","UnitTest");
	   Assert.assertEquals(newArticlePage.newArticleValidate(),"Unit Test");
	}
	@Test(priority=5)
	public void update_ArticleTest() {
		extentTest=extentReports.createTest("Update Article Test");
		updateArticle.update("Unit Test1..","About Unit Test1....","Unit Testing-1 Details");
       // String upName=updateArticle.updateArticleValidate();
		Assert.assertEquals(updateArticle.updateArticleValidate(),"Unit Test1..");
	}
	@Test(priority=6)
	public void delete_ArticleTest() {
		extentTest=extentReports.createTest("Delete Article Test");
		deleteArticle.deleteArticle();
	    //String delText=deleteArticle.deleteValidate();
        Assert.assertEquals(deleteArticle.deleteValidate(),"Articles not available.");
	}
	@AfterMethod
	  public void teardown(ITestResult result) {
		  extentTest.assignAuthor("AutomationTester1-Priyadharshini")
		  .assignCategory("Regression Test")
		  .assignDevice(System.getProperty("os.name"))
		  .assignDevice(System.getProperty("os.version"));
		   if(ITestResult.FAILURE==result.getStatus()) {
			  extentTest.log(Status.FAIL,result.getThrowable().getMessage());
			  String strPath=Utility.getScreenshotPath(driver);
			  extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(strPath).build());
		  }
	}
	@AfterTest
	   public void finishExtent() {
		  extentReports.flush();
	  }
	}