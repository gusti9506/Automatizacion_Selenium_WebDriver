package ScripsPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Pagina para hacer el login de ususario
public class LoginPageSUT {
	@FindBy(id="email")
	WebElement txtEmail;   
	
	@FindBy(id="passwd")
	WebElement txtPass;
	
	@FindBy(name="SubmitLogin")
	WebElement clickedSignIn;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/header[1]/div[2]/div[1]/div[1]/nav[1]/div[2]")
	WebElement btnSignOut;
	
	@FindBy(xpath="//p[contains(text(),'There is 1 error')]")
	WebElement mesageError;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/a[1]/i[1]]")
	WebElement myAccount;

	public LoginPageSUT(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
	public void completarMail(String mail) {
		txtEmail.sendKeys(mail);
	}
	
	public void completarPass(String pass) {
		txtPass.sendKeys(pass);
	}
	
	public void hacerClick() {
		clickedSignIn.click();
	}
	
	public void clickSignOut() {
		btnSignOut.click();
	}
	
	public String thereIsOneError() {
		return mesageError.getText();
	}
	
	public void enterEmailAndPass(String email, String pass) {
		txtEmail.sendKeys(email);
		txtPass.sendKeys(pass);
	}
}
