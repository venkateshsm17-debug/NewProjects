package ToDo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PageObjectExample {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(name = "username")
	WebElement ele1;
	@FindBy(name = "password")
	WebElement ele2;

	/*
	 * PageObjectExample(WebDriver driver) { this.driver=driver;
	 * PageFactory.initElements(driver, this); }
	 */

	public void enterCredential(String username, String password) {
		/*
		 * wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		 * wait.until(ExpectedConditions.elementToBeClickable(ele1));
		 */
		ele1.sendKeys(username);
		/*
		 * wait.until(ExpectedConditions.elementToBeClickable(ele2));
		 */
		ele2.sendKeys(password);

	}
}

/*
 * By ele1=By.name("username"); By ele2=By.name("password");
 * 
 * 
 * 
 * 
 * @BeforeTest(groups = {"smoke"}) void launchingWebsApplication() throws
 * InterruptedException{
 * 
 * 
 * driver= new ChromeDriver(); driver.manage().window().maximize(); driver.get(
 * "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
 * Thread.sleep(4000); }
 * 
 * public void enterCredential(String username,String password) {
 * 
 * wait=new WebDriverWait(driver,Duration.ofSeconds(10));
 * wait.until(ExpectedConditions.elementToBeClickable(ele1));
 * driver.findElement(ele1).sendKeys(username);
 * wait.until(ExpectedConditions.elementToBeClickable(ele2));
 * driver.findElement(ele2).sendKeys(password); }
 * 
 * 
 * 
 * 
 * }
 */