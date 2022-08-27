package ScripsTests;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ScripsPages.HomePageSUT;
import ScripsPages.LoginPageSUT;
import Utilidades.CapturaEvidencia;
import Utilidades.DatosExcel;




public class TestExcellScripts {
	String nombreDocumento = "..\\Practicas\\Evidencias\\Evidencias.docx";
	String url = "http://automationpractice.com";
	String driverChromePath = "..\\Practicas\\Drivers\\chromedriver.exe";
	WebDriver driver;
	String dirEvidencias = "..\\Practicas\\Evidencias\\";
	
	@BeforeSuite
	public void abrirPagina() throws  IOException, InterruptedException, InvalidFormatException {
		System.setProperty("webdriver.chrome.driver", driverChromePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
	}
	
	@AfterSuite
	public void cerrarDriver() {
		driver.close();
	}
	
	// 3)-Paso 3: agregar parametro al @Test, (dataProvider sin mayusculas al principio).
	//De acuerdo el name del dataProvider es el metodo que va a correr.
	@Test(priority=0, dataProvider="Obtener datos de Login, de la hoja Excell")
	//Esta seria la segunda parte de los cambios a realizar.
	// 1)-Paso 1: agregar dos parametros al metodo loginMetodo1
	public void loginSuiteTest(String email, String pass, String expected) throws InterruptedException, InvalidFormatException, IOException { //aca las variables como parametros.
		HomePageSUT inicio = new HomePageSUT(driver);
		inicio.clickedSignIn();
		
		LoginPageSUT login2 = new LoginPageSUT(driver);
		// 2)-Paso 2: cambiar los textos por las variables (email, pass).
		login2.completarMail(email);
		login2.completarPass(pass);
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "Img.png", nombreDocumento, "Email and password:    " + email + "  ;  " + pass);
		login2.hacerClick();
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "Img.png", nombreDocumento, "Click en Login");
		
		try {
			System.out.println(login2.thereIsOneError());
			Assert.assertEquals(login2.thereIsOneError(), expected);
			
		}catch(NoSuchElementException ese) {
			System.out.println("Happy Path Test....");
			Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", driver.getCurrentUrl());
		}
		login2.clickSignOut();		
		
		//Hacer una comprobacion cuando el usuario y pass existen.
		/*Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", driver.getCurrentUrl());
		//Si ingresas user y pass existente, y el hacer es True, se hace un deslogueo.
		System.out.println("Test exitoso, User y Pass Validos " + email + " ; " + pass);*/

	}

	// 2)-Paso 2: cambiar los textos por las variables (email, pass).
	//login2.completarMail(email);
	//login2.completarPass(pass);
	
	//Esta seria la primera parte en cuanto a los cambios realizados.
	@DataProvider(name="Datos para el Login: 'mail y pass'")
	//Object[3[2] representa la cantidad de filas(3) y columnas(2).
	public Object[][] obtenerDatos() {
		Object[][] datos = new Object[1][2];
		//Las filas y columnas empiezan de 0 porque representa un Array.
		datos[0][0] = "gusti9506@gmail.com";  //Fila 0, Columna 0.
		datos[0][1] = "a2123275a";              //Fila 0, columna 1.
		
		/*datos[1][0] ="";   //Fila 1, Columna 0.
		datos[1][1] = "654321";              //Fila 1, Columna 1.
		
		datos[2][0] = "correo@mail.com";  //Fila 2, Columna 0.
		datos[2][1] = "";              //Fila 2, Columna 1.*/
		
		return datos;
	}
	
	@DataProvider(name="Obtener datos de Login, de la hoja Excell")
	public Object[][] datosExcell() throws Exception {
		//Se llama al archivo DatosExcell y al metodo leerExcel, con la ubicacion + nombre y la Hoja.
		return DatosExcel.leerExcel("..\\Practicas\\ArchivosGrales\\LibroExcell1.xlsx","Hoja1");
	}

	
}
