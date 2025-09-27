package ToDo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizationExample {
	
	WebDriver driver;
	WebDriverWait wait;
	 
	@BeforeTest(groups = {"smoke"})
	@Parameters({"url","time"})
	void launchingWebsApplication(String url,int time) throws InterruptedException{
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(time);
	}
	@Test
	@Parameters({"username","password"})
		
		void enterCredential(String username, String password) { 
		
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
		 WebElement ele2=driver.findElement(By.xpath("//input[@name='username']"));
		 ele2.sendKeys(username);
		 String v=ele2.getAttribute("value");
		 System.out.println(v);
		wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
		 WebElement ele1=driver.findElement(By.xpath("//input[@name='password']"));
		 ele1.sendKeys(password);
	}
		
		}


