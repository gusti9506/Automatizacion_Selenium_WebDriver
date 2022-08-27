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

public class Laboratorio_4 {
	String url = "http://automationpractice.com/index.php";
	String driverChromePath = "..\\Practicas\\Drivers\\chromedriver.exe";
	
	//Se llama al metodo driver y se crea en la linea 27.
	WebDriver driver; 

	// BeforeSuite seria lo que quiero ejecute antes de los test, en este caso abrimos
	//la pagina y no repetimos tanto codigo, ya que los test son en la misma "url".
	@BeforeSuite
	public void urlPagina() {
		System.setProperty("webdriver.chrome.driver", driverChromePath);
		
		//El driver se envia a la linea 15, ya que en esa parte de codigo las variables son globales.
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		/*Anotaciones...Before
		@BeforeSuite...se ejecuta al principio, antes de los @Test.
		    @BeforeClass...se ejecuta antes de todo lo que esta en una clase.
		        @BeforeTest...se ejecuta antes de los @Test
		            @BeforeMethod...se ejecuta antes de un metodo declarado.
		                 @Test....por lo gral se ejecuta un Before antes del test y un After despues.
		            @AfterMethod... 
 	            @AfterTest... 
 	        @AfterClass...
 	    @AfterSuite...*/
	}
	//"priority" = prioridad de ejecucion, 0 es el primer lugar,
	@Test(priority=1, description="Validar busqueda en la Store")
	public void buscarPalabra() {
		/* Estas lineas al repetirse en ambos @Test se agregan en el metodo "urlPagina".
		System.setProperty("webdriver.chrome.driver", driverChromePath);
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();*/
				
		WebElement txtBuscador = driver.findElement(By.cssSelector("#search_query_top"));
		txtBuscador.sendKeys("shirt");
		txtBuscador.sendKeys(Keys.ENTER);
		
		// Hacer validaciones de resultado esperado con Assertions.
		String urlEsperada = "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=shirt&submit_search=";
		String tituloEsperado = "Search - My Store";
		
		//Para hacer validaciones se usa el metodo "Assert"
		// Se compara urlERsperada con la url actual, "getCurrentUrl()".
		Assert.assertEquals(urlEsperada, driver.getCurrentUrl());
		
		//Se compara el tituloEsperado con el titulo actual, "getTitle()".
		Assert.assertEquals(tituloEsperado, driver.getTitle());
		
		//Assert con un error en el resultado esperado.
		//Assert.assertEquals(tituloEsperado, "fallo a proposito");
		
		/*Distintos tipos de Assert:
		 1)- assertNotEquals(1, 2)..dos elementos no deben ser iguales.
		 2)- assertTrue() y assertFalse().
		 3)- assertNull() y assertNotNull()...validan si cierta Variable tiene un valor o no.
		 */
				
	}
	//Al @Test (metodo) se le puede dar prioridad (de menor a mayor) y una descripcion.
	@Test(priority=0, description="Validar Contact Us")
	public void irContactanos() {
		
		driver.findElement(By.linkText("Contact us")).click();
		Select subSubject = new Select(driver.findElement(By.id("id_contact")));
		subSubject.selectByVisibleText("Webmaster");
		driver.findElement(By.id("email")).sendKeys("gusti800@mail.com");
		driver.findElement(By.id("id_order")).sendKeys("Campo de texto!!");
		
		//En este tipo de campo se agrega un archivo en el texto del mismo, no se debe
		//usar el boton "choose file", ya que Selenium no maneja Explorador de windows.
		driver.findElement(By.cssSelector("#fileUpload")).sendKeys("E:\\Sintítulo.png");
		driver.findElement(By.id("message")).sendKeys("Mensaje agregado satisfactoriamente!!");
		driver.findElement(By.name("submitMessage")).click();
		
	}
	// El AfterSuite seria lo contrario al Before, en este caso la accion se realiza 
	//despues de los test.
	@AfterSuite
	public void cerrarChrome() {
		driver.close();	}

}
