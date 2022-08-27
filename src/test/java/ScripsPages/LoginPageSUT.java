package ScripsPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Pagina para hacer el login de ususario
public class LoginPageSUT {
	@FindBy(id="email")    //Se localiza el campo email.
	WebElement txtEmail;   
	
	@FindBy(id="passwd")    //Se localiza el campo password.
	WebElement txtPass;
	
	@FindBy(name="SubmitLogin")   //Se localiza el btn SignIn.
	WebElement clickedSignIn;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/header[1]/div[2]/div[1]/div[1]/nav[1]/div[2]") //Buttom Sign Out.
	WebElement btnSignOut;
	
	@FindBy(xpath="//p[contains(text(),'There is 1 error')]")  //Mensaje error, email invalid.
	WebElement mesageError;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/a[1]/i[1]]")  //My Account, con email valid.
	WebElement myAccount;

	//Se crea el constructor, con mismo nombre de la clase.
	public LoginPageSUT(WebDriver driver) {
		//"initElements" revisa e inicializa los elementos (los WebElements).
 		//el parametro "this", hace que los elementos inicien en "esta" clase en el navegador.
		PageFactory.initElements(driver, this);
		
	}
	
	//Acciones sobre los elementos (los 3 campos).
	//Se crea un metodo para cada elemento, y se agrega un String como parametro.
	//El parametro queda generico, para asi completar con los datos en el @Test (TestHomeAndLogin).
	public void completarMail(String mail) {
		txtEmail.sendKeys(mail);             //Representa el ingreso del mail.
	}
	
	public void completarPass(String pass) {
		txtPass.sendKeys(pass);              //Representa el ingreso del password
	}
	
	public void hacerClick() {
		clickedSignIn.click();               //Representa el click.
	}
	
	public void clickSignOut() {             //Representa el boton Sign Out (deslogueo).
		btnSignOut.click();
	}
	
	public String thereIsOneError() {       //Representa mensaje de error: pass, email invalidos.
		return mesageError.getText();
	}
	
	/*public Boolean myAccountValid() { 	//Representa la imagen de cuenta valida.
		return myAccount.isDisplayed();
	}*/
	//en este metodo incluye las acciones juntas, mismo resultado que los anteriores.
	public void enterEmailAndPass(String email, String pass) {
		txtEmail.sendKeys(email);
		txtPass.sendKeys(pass);
	}
}
