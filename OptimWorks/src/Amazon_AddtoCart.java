import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.Timeout;

public class Amazon_AddtoCart {

	public static void main(String[] args) {
		
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("wireless mouse");
		WebElement submit=driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']"));
		submit.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		//
		WebElement AddtoCart=driver.findElement(By.xpath("//button[@name='submit.addToCart']"));
		AddtoCart.click();
		driver.findElement(By.xpath("//a[@class='a-link-normal s-line-clamp-2 s-link-style a-text-normal']")).click();
		WebElement add2=driver.findElement(By.xpath("//button[@name='submit.addToCart']"));
		WebDriverWait wait= new WebDriverWait(driver,(Duration.ofSeconds(10)));
		wait.until(ExpectedConditions.elementToBeClickable(add2));
		AddtoCart.click();
		
		//Verify AddtoCart
		 driver.findElement(By.xpath("//div[@id='nav-cart-count-container']")).click();
		 WebElement totalPrice=driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']"));
		 System.out.println(totalPrice.getText());
		 
		/*
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 * List<WebElement> products=driver.findElements(By.
		 * xpath("//a[@class='a-link-normal s-line-clamp-2 s-link-style a-text-normal']"
		 * )); for(WebElement product:products) {
		 * 
		 * product.findElement(By.xpath("//button[@name='submit.addToCart']")).click();
		 * 
		 * 
		 * //product.click(); //see similar items
		 * //driver.findElement(By.linkText("See Similar Items")).click();
		 * 
		 * //product.findElement(By.
		 * xpath("//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal']"
		 * )).click();
		 * 
		 * 
		 * 
		 * }
		 */
	
		/*
		 * submit.click(); 
		 */
}
}
