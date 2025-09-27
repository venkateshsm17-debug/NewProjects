package ToDo;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class AllDemos {
	WebDriver driver;
	WebDriverWait wait;
	 
	@BeforeTest(groups = {"smoke"})
	void launchingWebsApplication() throws InterruptedException{

		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(4000); 
	}
	
		@Test(groups = {"regression"})
		void enterCredential() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0,1000)");
		
	   //WebElement ele=driver.findElement(By.xpath("//input[@name='password']"));
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
		 WebElement ele2=driver.findElement(By.xpath("//input[@name='username']"));
		 ele2.sendKeys("Admin");
		wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
		 WebElement ele1=driver.findElement(By.xpath("//input[@name='password']"));
		 ele1.sendKeys("admin123");
	}
		 
		 @AfterTest(groups= {"sanity"})
			void enterSubmit() throws IOException {
			 wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		//WebElement ele1= driver.findElement(By.xpath("//button[@type='submit']"));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
		
		WebElement ele3=driver.findElement(By.xpath("//button[@type='submit']"));
		String color=ele3.getCssValue("color");
		System.out.println(color);
		ele3.click();
		String title=driver.getTitle();
		System.out.println(title);
		 
		
		
		try {
		
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")));
			
		WebElement ele4=(driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")));
		/*
		 * SoftAssert sf=new SoftAssert(); sf.assertNotEquals(title, "OrangeHRM");
		 */
		if(ele4.isDisplayed()) {
			System.out.println("Login successful");
			
		}
		}
		
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
		
		 //
		 
	    //driver.findElement(By.name("password")).sendKeys("jkjkjk");
	    //js.executeScript("arguments[0].value='admin'",ele);
		
		
		catch(Exception e) {
			System.out.println("Invalid credential");
			File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scr, new File("D:\\New Preparation 2025//error"+".png"));
			
			
			
			
		
		}	
		 }
}
	

