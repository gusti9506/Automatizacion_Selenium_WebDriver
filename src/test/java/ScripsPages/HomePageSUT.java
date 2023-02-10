package ScripsPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageSUT {
	
	//Identificacion del boton "Sign In".
	@FindBy(linkText="Sign in")
	WebElement linkSignIn;
	
	@FindBy(id="email_create")
	WebElement emailCreateAccount;
	
	@FindBy(name="SubmitCreate")      //Boton Create An Account
	WebElement btnSubmitCreate;
	
	@FindBy(id="search_query_top")    //Localizador del elemento.
	WebElement txtSearch;
	
	@FindBy(name="submit_search")      //Localiza la lupa de busqueda
	WebElement clickedLens;
	

	public HomePageSUT (WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public void clickedSignIn() {
		linkSignIn.click();
	}
	
	
	public void emailCreateAcc(String emailAcc) {
		emailCreateAccount.sendKeys(emailAcc);
	}
	
	public void clickBtnSumitAcc() {
		btnSubmitCreate.click();
	}

	public void searchWord (String word) {
		txtSearch.sendKeys(word);
	}
	
	public void clickedInLens () {
		clickedLens.click();        //Hacer click en la lupa del buscador.
	}
	
}
