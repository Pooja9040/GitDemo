package poojaPrabhuraj.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import poojaPrabhuraj.pageObjects.CheckoutPageObects;
import poojaPrabhuraj.pageObjects.OrdersPageObjects;

public class AbstractComponent {

	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cartIcon;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement ordersIcon;
	
	public void visibilityOfElement(WebElement ele) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
	wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void invisibilityOfElement(WebElement ele) throws InterruptedException {
		//Thread.sleep(2000);
		
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
		  wait.until(ExpectedConditions.invisibilityOf(ele)); 
	}
	
	public CheckoutPageObects goToCartPage() {
		cartIcon.click();
		return new CheckoutPageObects(driver);
	}
	
	public OrdersPageObjects goToOrdersPage() {
		ordersIcon.click();
		return new OrdersPageObjects(driver);
	}
}
