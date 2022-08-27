package Desafios_practicas;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;


public class Desafio_1 {
	String url = "https://www.saucedemo.com/inventory.html";
	String driverChromePath = "..\\Practicas\\Drivers\\chromedriver.exe";
	//String driverFirefoxPath = "..\\K-EducacionIT2_copia\\Drivers\\geckodriver.exe";
	
	@Test
	public void desafioChromeSauce() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", driverChromePath);
		WebDriver driver = new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver", driverFirefoxPath);
		//WebDriver driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		
		//Ingreso con usuario
		driver.findElement(By.name("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		//Seleccionar producto y agregar al carrito
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		
		//Se realiza una pausa de 3 segundos, y se agrega al public void "throws InterruptedException 
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'1')]")).click();
				
		//Checkout
		Thread.sleep(3000);
		driver.findElement(By.id("checkout")).click();
				
		//Formulario de compra
		driver.findElement(By.id("first-name")).sendKeys("Gustavin");
		driver.findElement(By.name("lastName")).sendKeys("Lopecito");
		driver.findElement(By.cssSelector("#postal-code")).sendKeys("12345");
		
		//Continuar y finalizar
		driver.findElement(By.id("continue")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("finish")).click();
		
	}
	
}
