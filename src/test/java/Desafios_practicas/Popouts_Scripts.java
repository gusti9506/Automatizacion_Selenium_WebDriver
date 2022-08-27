package Desafios_practicas;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Popouts_Scripts {
	String url = "https://demoqa.com/alerts";
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
	
	@AfterSuite
	public void cerrar() {
		driver.close();
	}
	
	@Test
	public void alert1() {
		driver.findElement(By.id("alertButton")).click();
		Alert alerta = driver.switchTo().alert();  //Cambio a la alerta/popout.
		alerta.accept();  //click en el OK del popout.
	}
	
	@Test
	public void alerta2() {
		driver.findElement(By.id("timerAlertButton")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alerta = driver.switchTo().alert();
		alerta.accept();
	}
	
	@Test
	public void alerta3() {
		driver.findElement(By.id("alertButton")).click();
		driver.switchTo().alert().dismiss();
		System.out.println("Fin de la prueba de alerta");
	}
	
	@Test
	public void alert4() {
		driver.findElement(By.id("promtButton")).click();
		Alert alerta = driver.switchTo().alert();
		alerta.sendKeys("akjsdfhhasjkas");  //Escribir en el campo de escritura del popout.
		alerta.accept();
	}
}
