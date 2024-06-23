package poojaPrabhuraj.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import poojaPrabhuraj.AbstractComponents.AbstractComponent;

public class ProductCataloguePageObjects extends AbstractComponent {
	WebDriver driver;

	public ProductCataloguePageObjects(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> producCatalogueProducts;

	@FindBy(css = ".mb-3")
	WebElement producCatalogueProduct;

	By producCatalogueAddToCart = By.xpath("//button[text()=' Add To Cart']");

	@FindBy(xpath = "//div[@id='toast-container']")
	WebElement toaster;

	@FindBy(xpath = "//div[contains(@class,'ngx-spinner-overlay')]")
	WebElement spinner;

	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement producCatalogueCartIcon;
	
	  public void productCatalogueAddToCart(String prodName) throws InterruptedException {
	  invisibilityOfElement(toaster);
	  
	  visibilityOfElement(producCatalogueProduct);
	  WebElement selectedProd = producCatalogueProducts.stream()
	  .filter(p->p.findElement(By.cssSelector("b")).getText().equals(prodName))
	  .findFirst().orElse(null); 
	  selectedProd.findElement(producCatalogueAddToCart).click();
	  visibilityOfElement(spinner);
	  //invisibilityOfElement(spinner); 
	  visibilityOfElement(toaster);
	  invisibilityOfElement(toaster); 
	  
	  }
	  

	/*
	 * public List<WebElement> getProductList() { visibilityOfElement(product);
	 * return products; }
	 * 
	 * public WebElement getProductByName(String prodName) { WebElement selectedProd
	 * = getProductList().stream()
	 * .filter(p->p.findElement(By.cssSelector("b")).getText().equals(prodName))
	 * .findFirst().orElse(null); return selectedProd; }
	 * 
	 * public void addToCart(String prodName ) { WebElement p =
	 * getProductByName(prodName); p.findElement(addToCart).click(); }
	 */

}
