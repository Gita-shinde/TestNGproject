import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShotDemo {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.utkarshaaacademy.com");
		driver.manage().window().maximize();
		
		TakesScreenshot ts = (TakesScreenshot)driver;    // TypeCasting
		File srcfile = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File("C:\\November_Selenium22\\ScreenShots\\"+timestamp()+".jpeg"));
	}
	public static String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
}
