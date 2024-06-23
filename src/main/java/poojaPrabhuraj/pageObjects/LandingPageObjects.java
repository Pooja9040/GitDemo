package poojaPrabhuraj.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import poojaPrabhuraj.AbstractComponents.AbstractComponent;

public class LandingPageObjects extends AbstractComponent {
	
	WebDriver driver;
	
	public LandingPageObjects(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//Page Object Factory
	
	@FindBy(xpath="//input[@id='userEmail']")
	WebElement loginPageUserEmailInputField;
	
	@FindBy(xpath="//input[@id='userPassword']")
	WebElement loginPageUserPasswordInputField;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginPageLoginButton;
	
	@FindBy(xpath="//div[@id='toast-container']")
	WebElement toaster;
	
	@FindBy(xpath="//div[@class='toast-message']")
	WebElement toasterIncorrect;
	
	
	//Action Method
	
	public void goToLoginPage() {
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
	}
	
	public ProductCataloguePageObjects loginPageLoginApplication(String email, String password) throws InterruptedException {
		loginPageUserEmailInputField.sendKeys(email);
		loginPageUserPasswordInputField.sendKeys(password);
		loginPageLoginButton.click();
		visibilityOfElement(toaster);
		return new ProductCataloguePageObjects(driver);
	}
	
	public String getErrorMessage() throws InterruptedException {
		visibilityOfElement(toasterIncorrect);
		return toasterIncorrect.getText();
	}
	
	
	
}
