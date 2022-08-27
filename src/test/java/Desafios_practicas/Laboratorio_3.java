package Desafios_practicas;

import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Laboratorio_3 {
	String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account\r\n";
	String driverChromePath = "..\\Practicas\\Drivers\\chromedriver.exe";
	

    @Test
    public void createAccount() {
    	System.setProperty("webdriver.chrome.driver", driverChromePath);
    	//En las lineas de abajo se abre el navegador en modo incognito.
    	ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
				
		// Argumentos de ChromeOptions
		// 1) incognito
		// 2) start-maximized
		// 3) disable-extensions
		// 4) disable-popup-blocking
		// 5) headless
		
		//Para que abra en modo incognito hay que colocar "options" como parametro.
		WebDriver driver = new ChromeDriver(options);   	
		driver.navigate().to(url);
		driver.manage().window().maximize();
		
		//Completar correo y dar click en boton
		double valor = Math.random()*100000;
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("gusti" + Math.round(valor) + "@gmail.com");
		driver.findElement(By.cssSelector("#SubmitCreate")).click();
		
		//Agregar espera, ya que hay un cambio de pagina y no selecciona el radio-boton (Mr).
		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(12));
		
		//Ahora usamos el objeto "waits"."until" (esperar hasta), "ExpectedConditions".
		//(Cierta condicion se cumpla), "elementToBeClickable" (hasta que cierto elemento sea clickeable).
		waits.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
				
		//Llenar el formulario, primero seleccionamos el radio-botton
		driver.findElement(By.id("id_gender1")).click();
		
		//Ahora completamos los campos nombre, apellido y pass.
		driver.findElement(By.id("customer_firstname")).sendKeys("Gustavo");
		driver.findElement(By.id("customer_lastname")).sendKeys("Lopez");
		driver.findElement(By.cssSelector("#passwd")).sendKeys("a2123275a");
	
		//Para seleccionar el dia en la lista usanos "Select".
		Select days = new Select(driver.findElement(By.xpath("//select[@id='days']")));
		days.selectByValue("30");
		
		//Ahora se seleccionamos el mes, con Select tambien.
		Select months = new Select(driver.findElement(By.id("months")));
		months.selectByVisibleText("September ");
		
		//Ahora el año (con distinta manera de hacerlo).
		(new Select(driver.findElement(By.name("years")))).selectByIndex(52);
				
		//Ahora tildamos los checkbox.
		driver.findElement(By.name("newsletter")).click();
		driver.findElement(By.id("uniform-optin")).click();
		
		
		
		//Continuamos con el resto del form.
		driver.findElement(By.id("company")).sendKeys("xxxxxx");
		driver.findElement(By.id("address1")).sendKeys("Miramar");
		driver.findElement(By.name("address2")).sendKeys("Gral Alvarado");
		driver.findElement(By.cssSelector("#city")).sendKeys("Bs AS");
		
		//Usamos Select para elegir state.
		Select state = new Select(driver.findElement(By.name("id_state")));
		state.selectByVisibleText("Missouri");
		
		driver.findElement(By.id("postcode")).sendKeys("76001");
		//La proxima linea esta demas (solo practica) en el SUT ya viene por defecto el pais.
		//(new Select(driver.findElement(By.name("id_country")))).selectByVisibleText("United States");
		driver.findElement(By.id("other")).sendKeys("askjasf ashfaskhf sahsafsa jsa ksa");
		driver.findElement(By.id("phone")).sendKeys("2291527458");
		driver.findElement(By.id("phone_mobile")).sendKeys("20223154214250");
		
		//Aca se borra el contenido por defecto del campo "assign an address alias...".
		driver.findElement(By.name("alias")).clear();
		driver.findElement(By.name("alias")).sendKeys("Mi casa");
		
		//Aca asigno una espera de 15s antes de clickear en "Register".
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='submitAccount']")));
		driver.findElement(By.id("submitAccount")).click();
		
    }
    
}