package Desafios_practicas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DobleClick_RightClick {
	
	@Test
	public void main() throws InterruptedException {
		String url = "https://www.automationtestinginsider.com/2019/08/textarea-textarea-element-defines-multi.html";
		String driverChromePath = "..\\Practicas\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverChromePath);
		WebDriver driver; 
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);

		WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
		Actions act = new Actions(driver);
		act.doubleClick(doubleClickBtn).perform();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
	}

}
