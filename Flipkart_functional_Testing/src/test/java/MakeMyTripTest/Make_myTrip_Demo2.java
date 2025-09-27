package MakeMyTripTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Make_myTrip_Demo2 {

	@Test
	void openBrowserWindow() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class='flt_fsw_inputBox searchToCity inactiveWidget ']/label")).click();
		
	}

}
