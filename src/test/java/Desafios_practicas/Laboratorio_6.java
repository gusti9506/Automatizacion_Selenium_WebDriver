package Desafios_practicas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Laboratorio_6 {
	String url = "http://automationpractice.com/index.php";
	String driverChromePath = "..\\Practicas\\Drivers\\chromedriver.exe";
	String driverFirefoxPath = "..\\\\Practicas\\Drivers\\geckodriver.exe";
	WebDriver driver; 

	//Se cambia @BeforeSuite por @BeforeTest y se agrega la anotacion @Parameters()
	//con un parametro (navegador) que indicara cual navegador utilizaremos.
	@BeforeTest
	@Parameters("navegador")
	//Se crea el metodo y la variable "navegador" como parametro.
	public void urlPagina(String navegador) { 
		//Ahora se inicia con un "if" para especificar que navegador usar
		if (navegador.equalsIgnoreCase("Chrome")) {
			//Aca se inicia Chrome.
			System.setProperty("webdriver.chrome.driver", driverChromePath);
			driver = new ChromeDriver();
			
		}else if (navegador.equalsIgnoreCase("Firefox")) {
			//De la misma manera que con Chrome, se inicia Firefox
			//Pero primero agregamos direccion del driver (linea 23).
			System.setProperty("webdriver.gecko.driver", driverFirefoxPath);
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.get(url);		
		
	}
	@Test //(priority=0, description="Validar ir a Contact Us")
	public void irContactanos() {
		driver.findElement(By.linkText("Contact us")).click();
		Select subSubject = new Select(driver.findElement(By.id("id_contact")));
		subSubject.selectByVisibleText("Webmaster");
		driver.findElement(By.id("email")).sendKeys("gusti800@mail.com");
		driver.findElement(By.id("id_order")).sendKeys("Campo de texto!!");
		
		driver.findElement(By.cssSelector("#fileUpload")).sendKeys("E:\\Sintítulo.png");
		driver.findElement(By.id("message")).sendKeys("Mensaje agregado satisfactoriamente!!");
		driver.findElement(By.name("submitMessage")).click();
	}
	@AfterTest
	public void cerrarChrome() {
		driver.close();
	}
}
