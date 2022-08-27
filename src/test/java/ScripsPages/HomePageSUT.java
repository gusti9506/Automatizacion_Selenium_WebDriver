package ScripsPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageSUT {
	
	//Identificacion del boton "Sign In".
	//Importante: con cada elemento identificado se debe hacer una "accion".	
	@FindBy(linkText="Sign in")
	WebElement linkSignIn;            //Representacion del hipervinculo Sign In (btn).
	
	@FindBy(id="email_create")        //Campo email para creacion de cuenta.
	WebElement emailCreateAccount;
	
	@FindBy(name="SubmitCreate")      //Boton Create An Account
	WebElement btnSubmitCreate;
	
	//Este FindBy se agrego despues para hacer otro @Test
	@FindBy(id="search_query_top")    //Localizador del elemento.
	WebElement txtSearch;             //Representacion de la barra del buscador.
	
	@FindBy(name="submit_search")      //Localiza la lupa de busqueda
	WebElement clickedLens;            //y hace click.
	
	//Aca se define el constructor de la pagina (con el mismo nombre de la clase).
	public HomePageSUT (WebDriver driver) {
		
 		//"initElements" revisa e inicializa los elementos (los WebElements).
 		//el parametro "this", hace que los elementos inicien en "esta" clase en el navegador.
		PageFactory.initElements(driver, this);
	}
	//Metodo que representa la accion sobre LinkSign (hipervin), solo se puede hacer click().
	public void clickedSignIn() {
		linkSignIn.click();           //"Accion" de hacer click in Sign In.
	}
	
	
	public void emailCreateAcc(String emailAcc) { //email create an account.
		emailCreateAccount.sendKeys(emailAcc);
	}
	
	public void clickBtnSumitAcc() {  //click buttom create an account.
		btnSubmitCreate.click();
	}

	public void searchWord (String word) {  //Representa la palabra a buscar y se la identifica
		txtSearch.sendKeys(word);           // con una variable String como parametro
	}
	
	public void clickedInLens () {
		clickedLens.click();        //Hacer click en la lupa del buscador.
	}
	
}
