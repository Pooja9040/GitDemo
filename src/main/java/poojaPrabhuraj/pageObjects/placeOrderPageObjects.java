package poojaPrabhuraj.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import poojaPrabhuraj.AbstractComponents.AbstractComponent;

public class placeOrderPageObjects extends AbstractComponent {

	WebDriver driver;

	public placeOrderPageObjects(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, driver);
	}

	By placeOrderSelectCountryDropdown = By.xpath("//input[@placeholder='Select Country']");

	@FindBy(xpath = "//button[contains(@class,'ta-item')]")
	List<WebElement> placeOrderdynDdOptions;
	
	@FindBy(xpath = "//section[contains(@class,'ta-results')]")
	WebElement placeOrderdynDd;
	
	@FindBy(css = ".action__submit")
	WebElement placeOrderButton;

	public ConfirmationPageObjects placeOrder(String country, String selectCountry) throws InterruptedException {
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(placeOrderSelectCountryDropdown), "ind").build().perform();
		
		visibilityOfElement(placeOrderdynDd);
		
		placeOrderdynDdOptions.stream().filter(sc -> sc.findElement(By.cssSelector("span")).getText().equals(selectCountry)).findFirst().orElse(null).click();
	
		
		  a.sendKeys(Keys.PAGE_DOWN).build().perform();
		  placeOrderButton.click();
		  
		 return new ConfirmationPageObjects(driver);
	
	}

}
