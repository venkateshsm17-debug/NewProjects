package Validations;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public  class ScreenshotUtils {
	public static String takeScreenshot(WebDriver driver, String screenshotName) throws IOException {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "Screenshots/" + screenshotName + "_" + timestamp + ".png";
        File dest = new File(path);
        FileHandler.copy(src, dest);
        return path;
    }

}
