package ToDo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GropusDemo {
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
		void enterCredential()throws NullPointerException {
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
}
