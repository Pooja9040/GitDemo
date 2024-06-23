package poojaPrabhuraj.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import poojaPrabhuraj.AbstractComponents.AbstractComponent;

public class CheckoutPageObects extends AbstractComponent{
	
	WebDriver driver;
	
	public CheckoutPageObects(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@class='cartSection']/h3")
	List<WebElement> checkoutAddedItems;
	
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkoutCheckoutButton;
	
	public Boolean checkOutValidateAddedItems(String product) {
		
		Boolean itemMatch = checkoutAddedItems.stream().anyMatch(ci ->
				  ci.getText().equalsIgnoreCase(product)); 
		return itemMatch;
		}
	public void checkOut() {
				  checkoutCheckoutButton.click();
				  
				  }
	
	
}
