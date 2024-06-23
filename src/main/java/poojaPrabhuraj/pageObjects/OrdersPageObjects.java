package poojaPrabhuraj.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import poojaPrabhuraj.AbstractComponents.AbstractComponent;

public class OrdersPageObjects extends AbstractComponent{

	WebDriver driver;
	public OrdersPageObjects(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//tr[@class='ng-star-inserted'] //td[2]")
	List<WebElement> orderPageItems;
	
	public Boolean verifyProductsDisplay(String product) {
		
		Boolean itemMatch = orderPageItems.stream().anyMatch(ci ->
				  ci.getText().equalsIgnoreCase(product)); 
		return itemMatch;
		}
	
	
	

}
