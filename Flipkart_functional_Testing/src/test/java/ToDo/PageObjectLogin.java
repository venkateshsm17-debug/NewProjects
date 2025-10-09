package ToDo;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PageObjectLogin {
	
 WebDriver driver;
 Properties prop;
 
 @BeforeMethod
 void launchingBrowser() throws IOException {
	 FileInputStream fs=new FileInputStream("./src/test/resources/Properties/example.properties");
		prop =new Properties();
		prop.load(fs);
	driver= new ChromeDriver();
		driver.manage().window().maximize();
		String url= prop.getProperty("url");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	 
 }
 
	@Test
	void loginCredentials() throws InterruptedException {
		
		//PageObjectExample pg= PageFactory.initElements(driver,PageObjectExample.class );
		  PageObjectExample pg= new PageObjectExample(driver);
		  
		String username= prop.getProperty("username");
		String password= prop.getProperty("password");
		  pg.enterCredential(username,password);
		 
	}
	/*
	 * @AfterTest(groups = {"regression"}) public void invalidLoginTest() {
	 * 
	 * PageObjectExample pg= PageFactory.initElements(driver,PageObjectExample.class
	 * ); pg.enterCredential("hgaja","qdadminad");
	 * 
	 * 
	 * }
	 */

}
