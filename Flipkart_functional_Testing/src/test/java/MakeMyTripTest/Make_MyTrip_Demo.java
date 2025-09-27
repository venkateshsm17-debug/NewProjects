package MakeMyTripTest;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Make_MyTrip_Demo {
	@Test
	void openBrowser() throws InterruptedException {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter city name");
		String city=sc.next();
		String containCity=sc.next();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(5000);

		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='lbl_input appendBottom10']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[@class='autoSuggestPlugin hsw_autocomplePopup']/div/input"))
				.sendKeys(city);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='styles__Close-sc-1bytt3z-0 kezeYI']")).click();
		List<WebElement> li = driver.findElements(By.xpath("//p[@class='font14 appendBottom5 blackText']"));
		for (WebElement ele : li) {
			String Text = ele.getText();
			System.out.println(Text);
			boolean status = ele.getText().contains(containCity);
			System.out.println("Status" + status);
			if (status == true) {
				ele.click();
				break;
			}
			else {
				System.out.println("city not exist");
			}
		}
		driver.findElement(By.xpath("//div[@class='flt_fsw_inputBox searchToCity inactiveWidget ']/label ")).click();
		
		
	}
}
