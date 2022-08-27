package ScripsTests;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import ScripsPages.CreateAccount;
import ScripsPages.HomePageSUT;
import ScripsPages.LoginPageSUT;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TestHomeAndLogin {
	String url = "http://automationpractice.com/";
	String driverPath = "..\\Practicas\\Drivers\\chromedriver.exe";
	String dirScreenShots = "..\\Practicas\\Evidencias\\";
	WebDriver driver;
	
	@BeforeSuite
	public void homePages() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
						
	}
	
	@AfterSuite
	public void closeDriver() {
		driver.close();
	}
	
	@Test
	public void signInLogin() {
		//Paso 1= hacer click en Sign In.
		//Se crea el objeto "inicio" que llama y utiliza las clases creadas anteriormente (PaginaHome y PaginaLogin).
		HomePageSUT homeClick = new HomePageSUT(driver);
		homeClick.clickedSignIn();

		//Paso 2= ingresar los inputs.
		//Aca se crea el objeto "login" con la PaginaLogin y se usan las acciones que contiene.
		LoginPageSUT loginPage = new LoginPageSUT(driver);
		loginPage.enterEmailAndPass("gusti9506@gmail.com", "a2123275a");
		loginPage.hacerClick();
	
	}
	
	@Test
	public void searchProduct() throws IOException {
		//Se crea el objeto "search" que llama y utiliza las clases creadas anteriormente (PaginaHome y PaginaLogin).
		HomePageSUT search = new HomePageSUT(driver);
		search.searchWord("dress");
		search.clickedInLens();
		
		//Captura de pantalla completa!
		Screenshot screenPhoto = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
		ImageIO.write(screenPhoto.getImage(), "png", new File(dirScreenShots + "#1- ImageFinal.png"));
		
	}
	@Test
	public void enterAccount() throws InterruptedException, IOException {
		HomePageSUT signin = new HomePageSUT(driver);
		signin.clickedSignIn();

		HomePageSUT datas = new HomePageSUT(driver);
		datas.emailCreateAcc("pepitocalibre@email.com");
		datas.clickBtnSumitAcc();

		CreateAccount account = new CreateAccount(driver);
		//Thread.sleep(5000);
		account.selectGender();
		account.emailUser.clear();
		account.completeDatas("Pepito A",  "Pistola", "pepitocalibre@email.com", "a214250a");
		
		CreateAccount dates = new CreateAccount(driver);
		dates.selectDays("30  ", "September  ", "1977  ");
		dates.checkBoxs();

		//Captura
		Screenshot screenPhoto = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
		ImageIO.write(screenPhoto.getImage(), "png", new File(dirScreenShots + "#1- ImageFinal.png"));
	
	}
}