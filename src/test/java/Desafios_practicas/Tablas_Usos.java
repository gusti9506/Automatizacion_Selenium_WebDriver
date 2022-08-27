package Desafios_practicas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Tablas_Usos {
	String url = "https://demo.guru99.com/test/table.html";
	String driverChromePath = "..\\EduxacionIT\\Drivers\\chromedriver.exe";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.chrome.driver", driverChromePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().deleteAllCookies();
	}

	@Test
	public void imprimirTabla() {
		String uno = driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
		System.out.println(uno);
		String une = driver.findElement(By.xpath("//tbody/tr[3]/td[2]")).getText();
		System.out.println(une);
	}

	@AfterSuite
	public void cerrarDriver() {
		driver.close();
	}
}


