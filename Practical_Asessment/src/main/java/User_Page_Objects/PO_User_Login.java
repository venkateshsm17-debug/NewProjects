package User_Page_Objects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PO_User_Login {
	WebDriver driver;

    @FindBy(name="username")
    WebElement usernameField;

    @FindBy(name="password")
    WebElement passwordField;

    @FindBy(xpath="//button[@type='submit']")
    WebElement loginButton;

    public PO_User_Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
     
        loginButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

}
