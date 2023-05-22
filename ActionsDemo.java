import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://demoqa.com/buttons");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions act = new Actions(driver);

		WebElement DoubleClkBtn = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
		WebElement RightClkBtn = driver.findElement(By.xpath("//button[@id='rightClickBtn']"));
		WebElement DynamicClkBtn = driver.findElement(By.xpath("//button[text()='Click Me']"));

		act.doubleClick(DoubleClkBtn).perform();
		act.contextClick(RightClkBtn).perform();
		act.click(DynamicClkBtn).perform();
		
		driver.get("https://demoqa.com/droppable");
		WebElement dragMe = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement dropHere = driver.findElement(By.xpath("//div[@id='draggable']//following-sibling::div"));
		WebElement Book_Store = driver.findElement(By.xpath("//*[contains(text(),'Book Store Appl')]"));

		
		act.dragAndDrop(dragMe, dropHere).perform();
	//	act.clickAndHold(dragMe).perform();
		act.moveToElement(Book_Store).perform();
		
		driver.get("https://demoqa.com/menu");
		WebElement MainItem2 = driver.findElement(By.xpath("//*[contains(text(),'Main Item 2')]"));
		act.moveToElement(MainItem2).perform();

	}

}
