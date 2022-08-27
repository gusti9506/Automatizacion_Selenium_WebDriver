package Desafios_practicas;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Laboratorio_2 {
	//Variable (url) que agrega la url (web) donde se va a hacer la prueba.
	String url = "http://automationpractice.com";
	
	//Variable con la ubicacion del driver de Chrome.
	String driverChromePath = "..\\Practicas\\Drivers\\chromedriver.exe";
	
	//Variable con la ubicacion de Firefox.
	String driverFirefoxPath = "..\\Practicas\\Drivers\\geckodriver.exe";
	
	/*Al agregar @Test se pone en rojo porque falta el import, entones 
	 * al pararnos sobre el @Test nos marca la libreria que falta, hacemos 
	 * click sobre ella y se agrega autom. (import org.junit.Test;)
	 */
	@Test
	
	//Se le da un nombre al metodo (public void)
	public void buscarEnChrome() {
		
		// Pasos para crear la class (clase):
		// 1)- Indicar donde esta el Driver (con System.setProperty)
		System.setProperty("webdriver.chrome.driver", driverChromePath);
		
		// 2)- Acceder a la pagina a testear (SUT).
		// a- Creamos el objeto que usa el driver del navegador (WebDriver) 
		// y se le asigna el nombre driver (esto es necesario para usar la
		// pagina y hacer todo tipo de acciones, maximizar, buscar, abrir). 
		// b- Luego creamos el objeto que llama al navegador (ChromeDriver)
		// y luego importamos las librerias como explico en linea "22-23".
		// Primer import linea 6(import org.openqa.selenium.WebDriver;).
		// Segundo import linea 8 (import org.openqa.selenium.chrome.ChromeDriver;).
		WebDriver driver = new ChromeDriver();
		
		//Para maximizar la pantalla.
		driver.manage().window().maximize();
		
		//ahora abrimos el navegador (ChromeDriver()) en la "url" especificada
		//en la linea 13 con la variable url.
		driver.get(url);		
		
		// 3)- Escribir la palabra a buscar.
		//Ahora localizamos el elemente (en este caso el buscador del SUT)
		//con la palabra WedElement (es un objeto que identifica cada elemento de la 
		//pagina, un boton, una tabla, etc) y le damos el nombre "txtBuscador".
		//WebElement al tener la linea roja hay que importar la libreria (linea 7).
		//Luego despues del = con driver llamamos a Chrome y "findElement(By.id)"
		//ubica e identifica el elemento de la pagina, por su "id".
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		
		//Ahora introducimos la palabra a buscar con rl metodo "sendKeys()".
		txtBuscador.sendKeys("dress");
		
		// 4)- Hacer la busqueda.
		//Y hacemos la busqueda, en este caso con la tecla "Enter", dentro del metodo
		//sendKeys con la orden  "Keys." se abre un menu para elegir tecla.
		txtBuscador.sendKeys(Keys.ENTER);
		
		//Solo para visualizar en consola
		System.out.println("Barra De Titulo: " + driver.getTitle());
		System.out.println("Direccion de la url :" + driver.getCurrentUrl());
		//System.out.println("Muestra el campo buscador :" + txtBuscador.isDisplayed());
		//System.out.println("Campo buscador esta enabled :" + txtBuscador.isEnabled());
	
	}	
	@Test
	//Se le da un nombre al metodo (public void)
	
	public void buscarEnFirefox() {
		// 1)- Indicar donde esta el Driver (con System.setProperty) para Firefox.
		System.setProperty("webdriver.gecko.driver", driverFirefoxPath);
		
		// 2)- Acceder a la pagina a testear (SUT).
		// Hacemos el import de la libreria de Firefox (FirefoxDriver), linea 9.
		WebDriver driver = new FirefoxDriver();
		
		//ahora accedemos el navegador (FierefoxDriver()) en la "url" especificada
		//en la linea 13 con la variable url.
		driver.get(url);
		
		// 3)- Escribir la palabra a buscar.
		//Luego despues del = con driver llamamos a geckodriver y "findElement(By.id)"
		//ubica e identifica el elemento de la pagina, por su "id".
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		
		//Ahora introducimos la palabra a buscar (dress) con sendKeys.
		txtBuscador.sendKeys("dress");
		
		// 4)- Hacer la busqueda con el metodo click().
		
		// Se identifica el elemento (lupa) donde hacer click para iniciar la busqueda.
		driver.findElement(By.name("submit_search")).click();
			
		//Tambien se puede hacer asi:
		//WebElement hacerClick =  driver.findElement(By.name("submit_search"));
		//hacerClick.click();
	}
	

}
