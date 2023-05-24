package TestNGTests;

import org.testng.annotations.Test;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public class LoginTest {
	public WebDriver driver;
	@BeforeClass
	public void beforeclass() {
		driver = new FirefoxDriver();
	}
  @Test(dataProvider = "dp")
  public void BookStorelogin(String username, String password) throws InterruptedException {
	  
	  driver.get("https://demoqa.com/login");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  WebElement UserName = driver.findElement(By.xpath("//input[@id='userName']"));
	  WebElement Password = driver.findElement(By.xpath("//input[@id='password']"));
	  WebElement Login = driver.findElement(By.xpath("//button[@id='login']"));
	  UserName.sendKeys(username);
	  Password.sendKeys(password);
	  Login.click(); 
	  Thread.sleep(1000);
	  String profileURL = "https://demoqa.com/profile";
	  String ActualURL = driver.getCurrentUrl();
	  Assert.assertEquals(profileURL, ActualURL);
	  
	  WebElement Logout = driver.findElement(By.xpath("//button[@id='submit' and text()='Log out']"));
	  Logout.click();
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "ravi.nangre","Qwerty@123" },
      new Object[] { "ravi.nangre1983", "Qwerty@123" },
      new Object[] { "ravi.nangare", "Qwerty@123" },
      new Object[] { "ravi.nangare", "Qwerty" },
      new Object[] { "ravi.nangare", "Qwerty@321" },
    };
  }
  @AfterClass
  public void afterclass()
  {
	  driver.close();
  }
}
