package Desafios_practicas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDrop {

	@Test
	public static void main() throws InterruptedException {
		String url = "https://demoqa.com/droppable";
		String driverChromePath = "..\\Practicas\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverChromePath);
		WebDriver driver; 
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
		WebElement fromDrag = driver.findElement(By.id("draggable"));
		WebElement toDrop = driver.findElement(By.id("droppable"));
		Actions act = new Actions(driver);
		//act.dragAndDrop(fromDrag, toDrop).perform();
		//act.dragAndDropBy(fromDrag, 138, 24).perform();
		act.clickAndHold(fromDrag).moveToElement(toDrop).release().build().perform();
		
		WebElement msg1 = driver.findElement(By.xpath("//p[contains(text(),'Dropped!')]"));
		if(msg1.isDisplayed()) {
			System.out.println("Successs");
			System.out.println(msg1.getText());
			
		}else {
			System.out.println("NOOOO");
		}
		
		Thread.sleep(3000);;
	}

}
