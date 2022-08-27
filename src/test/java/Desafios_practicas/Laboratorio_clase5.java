package Desafios_practicas;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class Laboratorio_clase5 {
	String url = "http://automationpractice.com/index.php";
	String driverPath = "..\\Practicas\\Drivers\\chromedriver.exe";
	WebDriver driver;

	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void buscarPalabra() {
		WebElement txtBuscador = driver.findElement(By.cssSelector("#search_query_top"));
		txtBuscador.sendKeys("shirt");
		txtBuscador.sendKeys(Keys.ENTER);
		
		//Validaciones
		String urlEspe = "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=shirt&submit_search=";
		String urlOtra = "Search - My Store"; 
		Assert.assertEquals(urlEspe, driver.getCurrentUrl());
		Assert.assertEquals(urlOtra, driver.getTitle());

	}
	
	@Test
	public void irAContactanos() {
		driver.findElement(By.linkText("Contact us")).click();
		
		Select selSubject = new Select(driver.findElement(By.id("id_contact")));
		selSubject.selectByVisibleText("Webmaster");
		
		driver.findElement(By.name("from")).sendKeys("micorreo@mailinator.com");
		driver.findElement(By.id("id_order")).sendKeys("No se que va");
		
		
		driver.findElement(By.id("fileUpload")).sendKeys("C:\\CV Actual_1.docx");
		driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("Comentario Adicional Agregado");
		driver.findElement(By.id("submitMessage")).click();
	}
	
	@AfterSuite
	public void cerrarPagina() {
		driver.close();
	}
}
