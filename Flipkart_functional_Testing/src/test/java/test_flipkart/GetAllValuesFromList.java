package test_flipkart;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utility.All_Links;


public class GetAllValuesFromList implements All_Links {

	WebDriver driver;
	@BeforeTest
	void OpenWebpage() throws InterruptedException {
		driver=new ChromeDriver();
		driver.get(url);
		Thread.sleep(5000);
	}
		
	@Test
		void SearchProduct() throws InterruptedException {
		
			WebElement searchKey =driver.findElement(searchXpath);
		searchKey.sendKeys("Mobile");
		searchKey.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
	
	}
		@AfterTest
		void FindMobiles() {
		List<WebElement> ListOfElements= driver.findElements(MXpath);
		int length=ListOfElements.size();
		System.out.println(length);
		if(length != 0) {
			for(WebElement ele:ListOfElements) {
				
				String DisplayNames=ele.getText();
				
				System.out.println(DisplayNames);
				boolean status=ele.getText().contains("OPPO K13x 5G 6000mAh and 45W SUPERVOOC Charger & AI (Midnight Violet, 128 GB)");
				System.out.println("Status"+status);
				if(status==true) {
					ele.click();
				}
			}
			
		
	}
		else {
			System.out.println("No mobiles");
			
		}
		}
			
}
