package Desafios_practicas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Tooltips {
	@Test
	public void toolTips() {
		String url = "https://demoqa.com/tool-tips";
		String driverChromePath = "..\\Practicas\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverChromePath);
		WebDriver driver; 
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);

		WebElement mouseHover = driver.findElement(By.id("toolTipButton"));
		Actions act = new Actions(driver);
		act.moveToElement(mouseHover).perform();
		
	}
}
