package Validations;


import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import User_Page_Objects.PO_User_Login;

public class LoginTest {
	WebDriver driver;
	 PO_User_Login loginPage;
	 ExtentReports extent;
	 ExtentTest test;
	 
	    

	    @BeforeSuite
	    public void setupReport() {
	    	
	        ExtentSparkReporter spark = new ExtentSparkReporter("./TestReports//ExtentReport.html");
	        extent = new ExtentReports();
	        extent.attachReporter(spark);
	    }
	
	@BeforeClass
    public void setUp() throws Exception {
      driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        
        loginPage = new  PO_User_Login(driver);
        ValidationsForUserPages.readData();
        
        
	}
	@Test
	public void loginWithExcelCredentials() throws IOException {
		int rows = ValidationsForUserPages.getRowCount("Sheet1");

       for (int i = 1; i <= rows; i++) {
        String username = ValidationsForUserPages.getCellData("Sheet1", i, 0); // row=1 col=0
        String password = ValidationsForUserPages.getCellData("Sheet1", i, 1); // row=1 col=1
        test = extent.createTest("Login Test - User: " + username);
      
        loginPage.login(username, password);
        
      
        try {
     // Add verification logic (example: URL check)
        if (driver.getCurrentUrl().contains("dashboard")) {
        	String screenshotPath = ScreenshotUtils.takeScreenshot(driver, "LoginSuccess_" + username);
     
            test.pass("Login successful with username: " + username).addScreenCaptureFromPath(screenshotPath);
        } else {
        	
        	String screenshotPath = ScreenshotUtils.takeScreenshot(driver, "LoginFailed_" + username);
        	
            test.fail("Login failed for username: " + username).addScreenCaptureFromPath(screenshotPath);
        }
    } catch (Exception e) {
   
    	
    	try {
            String screenshotPath = ScreenshotUtils.takeScreenshot(driver, "Exception_" + username);
            test.fail("Exception occurred: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
        } catch (Exception ex) {
            test.fail("Could not capture screenshot: " + ex.getMessage());
        } continue;
    }
       
	}
	
        }
	
		
		  @AfterClass 
		  public void tearDown() 
		  {
			  driver.quit(); 
		  } 
		  
		     @AfterSuite
    public void flushReport(){
    	
        extent.flush();
    }
}
	

