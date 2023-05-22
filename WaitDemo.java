import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		// Implicit Wait
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// OLD IMPLICIT WAIT CODE
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		WebElement CreateNewAcc = driver.findElement(By.xpath("//a[text()='Create new account']"));
		CreateNewAcc.click();
		
		// Static Wait provided by java
	//	Thread.sleep(10000);     
		// Selenium waits ----- Implicit Wait & Explicit Wait
		// Explicit WAIT
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='firstname']")));
		WebElement FirstName = driver.findElement(By.xpath("//input[@name='firstname']"));
		FirstName.sendKeys("Utkarshaa");
		WebElement LastName = driver.findElement(By.xpath("//input[@name='lastname']"));
		LastName.sendKeys("Academy");
		try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("alert('Welcome To FaceBook Sign UP Page')");
			Thread.sleep(1000);
			wait.until(ExpectedConditions.alertIsPresent()).accept();
		} catch (Exception e) {};
		
	}

}
