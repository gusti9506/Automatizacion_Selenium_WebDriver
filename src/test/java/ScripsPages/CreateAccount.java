package ScripsPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount {
	//Select gender
	@FindBy(id="id_gender1")
	WebElement radioGender1;
	
	//Complete data
	@FindBy(id="customer_firstname")
	WebElement firstName;
	@FindBy(id="customer_lastname")
	WebElement lastName;
	@FindBy(id="email")
	public
	WebElement emailUser;
	@FindBy(id="passwd")
	WebElement passWord;
	
	
	//Select date
	@FindBy(id="days")
	WebElement selectDays;
	@FindBy(id="months")
	WebElement selectMonths;
	@FindBy(id="years")
	WebElement selectYears;
	@FindBy(id="newsletter")
	WebElement checkBox1;
	@FindBy(id="optin")
	WebElement checkBox2;
	
	public CreateAccount(WebDriver driver ) {
		PageFactory.initElements(driver, this);
	}

	public void selectGender() throws InterruptedException {
		Thread.sleep(5000);
		radioGender1.click();
	}
	
	public void completeDatas(String name, String last, String email, String pass) {
		firstName.sendKeys(name);
		lastName.sendKeys(last);
		emailUser.sendKeys(email);
		passWord.sendKeys(pass);
	}
	
	public void selectDays(String days, String month, String year) {
		selectDays.sendKeys(days);
		selectMonths.sendKeys(month);		
		selectYears.sendKeys(year);
	}

	public void checkBoxs() {
		checkBox1.click();
		checkBox2.click();
		
	}
}
