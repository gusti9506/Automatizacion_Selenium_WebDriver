package Desafios_practicas;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import Utilidades.CapturaEvidencia;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


public class Laboratorio_6b {
	String url = "http://automationpractice.com/index.php";
	String driverChromePath = "..\\Practicas\\Drivers\\chromedriver.exe";
	WebDriver driver; 
	String nombreDocumento = "..\\Practicas\\Evidencias\\DocumentoEvidencias.docx";
	//Creamos el directorio dentro del proyecto para alojar capturas.
	String dirEvidencias = "..\\Practicas\\Evidencias\\";
	//Se crea el objeto "File" para poder hacer el screenshot.
	File captura;
	
	@BeforeSuite
	public void urlPagina() {
		System.setProperty("webdriver.chrome.driver", driverChromePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
	}
	
	@Test(priority=0, description="Validar busqueda de dress en la Store y tomar captura")
	public void buscarPalabraConImagen() throws IOException {
		WebElement txtBuscador = driver.findElement(By.cssSelector("#search_query_top"));
		//Aca se toma una captura, en el inicio del script
		//Con el objeto TakesScreenshot y el metodo getScreenshotAs genera el archivo.
		captura = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Ahora se agrega la clase FileUtils y el metodo copyFile y new File
		FileUtils.copyFile(captura, new File(dirEvidencias, "#1_capturaInicial.png"));
		
		txtBuscador.sendKeys("dress");
		txtBuscador.sendKeys(Keys.ENTER);
		
		//=== Captura de Pantalla completa con Scroll ===
		//Se crea el objeto Ashot...se llama al metodo shootingStrategy para el scroll con un tiempo de 500 ms...se hace el screen.
		Screenshot capturaInicial = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);	
		//Mediante la clase ImageIO se accede al metodo write y se le asignan 3 parametros.
		//1)- la captura mediante getImage()...2)- el tipo de image...3)- el directorio y nombre archivo
		ImageIO.write(capturaInicial.getImage(), "png", new File(dirEvidencias + "#2-ImgFinalCompleta.png"));
		
		//captura = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(captura, new File(dirEvidencias, "02_capturaDress.png"));
		
		String urlEsperada = "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=";
		String tituloEsperado = "Search - My Store";
		
		Assert.assertEquals(urlEsperada, driver.getCurrentUrl());
		Assert.assertEquals(tituloEsperado, driver.getTitle());
		//Assert.assertEquals(tituloEsperado, "fallo a proposito");
				
	}
	@Test(priority=1, description="Validar busqueda de shirt y tomar Captura con Docx ")
	public void buscarPalabraConWord() throws IOException, InvalidFormatException, InterruptedException {
		//driver.get(url);
		//Aca usamos la clase "CapturaEvidencia" con los metodos "capturarPantallaEnDocumento" y
		//"escribirTituloEnDocumento", este ultimo se usa abajo.
		CapturaEvidencia.escribirTituloEnDocumento(nombreDocumento, "Buscar Shirt en Automation-practice.com", 24);
		//Ahora lo mismo que linea 65 pero con captura de pantalla guardada en docx.
		//Se indica el navegador (driver), el nombre de la imagen (img.png) y el dir a guardar
		//nombre del documento docx y el titulo de la evidencia.
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "captura.png", nombreDocumento, "Paso 1- Pantalla Inicial");
		WebElement txtBuscador = driver.findElement(By.cssSelector("#search_query_top"));
		txtBuscador.clear();
		
		txtBuscador.sendKeys("shirt");
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "captura.png", nombreDocumento, "Paso 2 - Busqueda de palabra (shirt)");
		
		txtBuscador.sendKeys(Keys.ENTER);
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "captura.png", nombreDocumento, "Paso 3- Resultado Obtenido");

		Screenshot capturaCompleta = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
		ImageIO.write(capturaCompleta.getImage(), "png", new File("..\\Practicas\\Evidencias\\ImgResultFinal.png"));
		
	}

	@AfterTest
	public void cerrarNavegador() {
		driver.close();	
	}
}
	


