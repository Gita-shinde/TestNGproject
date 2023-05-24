import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadProp {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("/Users/ravinangare/eclipse-workspace/November_selenium/config.properties");
		
		Properties prop = new Properties();
		
		prop.load(fis);
		
		WebDriver driver = new FirefoxDriver();
		driver.get(prop.getProperty("url"));
		
		WebElement FirstName = driver.findElement(By.xpath("//input[@name='firstname']"));
		WebElement LastName = driver.findElement(By.xpath("//input[@name='lastname']"));
		WebElement Mobile = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		WebElement Password = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		
		FirstName.sendKeys(prop.getProperty("firstname"));
		LastName.sendKeys(prop.getProperty("sirname"));
		Mobile.sendKeys(prop.getProperty("mobile"));
		Password.sendKeys(prop.getProperty("password"));
	}

}
