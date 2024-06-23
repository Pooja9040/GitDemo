package poojaPrabhuraj.tests;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import poojaPrabhuraj.TestComponents.BaseTest;
import poojaPrabhuraj.TestComponents.Retry;
import poojaPrabhuraj.pageObjects.CheckoutPageObects;
import poojaPrabhuraj.pageObjects.ProductCataloguePageObjects;

public class ErrorValidationTest extends BaseTest {

	
@Test(groups= {"ErrorHandling"},retryAnalyzer = Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException {
		String email = "poojajprabhuraj@gmail.com";
		String password = "JPpooj@9040";
		

		Assert.assertEquals(driver.getTitle(), "Let's Shop");
		lp.loginPageLoginApplication(email, password);
        Assert.assertEquals("Incorrect email or password.", lp.getErrorMessage());
	}

@Test
public void ProductErrorValidation() throws IOException, InterruptedException {
	// TODO Auto-generated method stub
	String phone = "ZARA COAT 3";
	String email = "poojajprabhuraj@gmail.com";
	String password = "JPpooja@9040";
	String country = "India";

	Assert.assertEquals(driver.getTitle(), "Let's Shop");
	ProductCataloguePageObjects pc = lp.loginPageLoginApplication(email, password);

	//Assert.assertEquals("Login Successfully",driver.findElement(By.xpath("//div[@id='toast-container']")).getText());

	  pc.productCatalogueAddToCart(phone);
	  
	  //Assert.assertEquals("Product Added To Cart",driver.findElement(By.xpath("//div[@id='toast-container']")).getText());
	  CheckoutPageObects co =  pc.goToCartPage();
	 
	  Boolean itemMatch = co.checkOutValidateAddedItems("ZARA COAT 33");
	  Assert.assertFalse(itemMatch);
	   
		
}


}
