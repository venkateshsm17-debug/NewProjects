package ToDo;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PropertiefileExample {
	WebDriver driver;
	WebDriverWait wait;
	Properties prop;
	 
	@BeforeTest(groups = {"smoke"})
	void launchingWebsApplication() throws InterruptedException, IOException{
	FileInputStream fs=new FileInputStream("./src/test/resources/Properties/example.properties");
	prop =new Properties();
	prop.load(fs);
	/*
	 * WebDriver driver= new ChromeDriver(); driver.get(prop.getProperty("url"));
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 * driver.findElement(By.name("username")).sendKeys((prop.getProperty("username"
	 * )));
	 */
	String url= prop.getProperty("url");
	
	    driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(4000); 
	}
	
		@Test(groups = {"regression"})
		void enterCredential() {
			String username= prop.getProperty("username");
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
		 WebElement ele2=driver.findElement(By.xpath("//input[@name='username']"));
		 ele2.sendKeys(username);
		 String password= prop.getProperty("password");
		wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
		 WebElement ele1=driver.findElement(By.xpath("//input[@name='password']"));
		 ele1.sendKeys(password);
	}
	}
	

