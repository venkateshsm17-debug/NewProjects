package maventest.demo;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestMvn {
	
		@Test
		public void sampleTest() {
			
			WebDriver driver=new ChromeDriver();		
			driver.get("https://opensource-demo.orangehrmlive.com/");
			driver.manage().window().maximize();
		}

}
