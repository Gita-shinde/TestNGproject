package TestNGTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertTest {
public WebDriver driver;
	
	@Test (priority = 0)
	public void CloseBrowser() {
		driver.close();
		Reporter.log("Driver Closed After Testing");
	}
	
	@Test (priority = -1)
	public void OpenBrowser() {
			driver = new FirefoxDriver();
			Reporter.log("This test verifies the current selenium compatibility with TestNG by launching the Firefox driver");
	        Reporter.log("Launching Firefox Driver version 81 for this test"); 
	        
	        driver.get("https://demoqa.com");
	        
	        Reporter.log("The website used was DemoQA for this test", true);
	        String expectedTitle = "demoqa";
	        String originalTitle = driver.getTitle();
	        Assert.assertEquals(originalTitle, expectedTitle);
	        System.out.println("Test Fail");
  }
	@Test (priority = -1)
	public void OpenBrowserSoftA() {
			driver = new FirefoxDriver();
			Reporter.log("This test verifies the current selenium compatibility with TestNG by launching the Firefox driver");
	        Reporter.log("Launching Firefox Driver version 81 for this test"); 
	        
	        driver.get("https://demoqa.com");
	        
	        Reporter.log("The website used was DemoQA for this test", true);
	        String expectedTitle = "demoqa";
	        String originalTitle = driver.getTitle();
	        SoftAssert sassert = new SoftAssert();
	        sassert.assertEquals(originalTitle, expectedTitle);
	        System.out.println("Test Fail");
	        sassert.assertAll();
  }
}
