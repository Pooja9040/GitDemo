package poojaPrabhuraj.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import poojaPrabhuraj.AbstractComponents.AbstractComponent;

public class ConfirmationPageObjects extends AbstractComponent{

	WebDriver driver;

	public ConfirmationPageObjects(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, driver);
	}
	
	@FindBy(css=".hero-primary")
	WebElement ConfirmationPageText;
	
	public String confirmationPageGetMessage() {
		return ConfirmationPageText.getText();
	}
}
