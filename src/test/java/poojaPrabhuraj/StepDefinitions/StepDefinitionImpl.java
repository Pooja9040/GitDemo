package poojaPrabhuraj.StepDefinitions;

import java.io.IOException;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import poojaPrabhuraj.TestComponents.BaseTest;
import poojaPrabhuraj.pageObjects.CheckoutPageObects;
import poojaPrabhuraj.pageObjects.ConfirmationPageObjects;
import poojaPrabhuraj.pageObjects.LandingPageObjects;
import poojaPrabhuraj.pageObjects.ProductCataloguePageObjects;
import poojaPrabhuraj.pageObjects.placeOrderPageObjects;

public class StepDefinitionImpl extends BaseTest {
	public LandingPageObjects landingPage;
	public ProductCataloguePageObjects pc;
	public CheckoutPageObects co;
	public placeOrderPageObjects po;
	public ConfirmationPageObjects cp;

	@Given("Land on eCommerce Web Application")
	public void Land_on_eCommmerce_Web_Application() throws IOException {
		landingPage = launchApplication();
	}

	@Given("^Login with (.+) and (.+)$")
	public void Login_with_UserName_and_Password(String UserName, String Password) throws InterruptedException {
	 pc = lp.loginPageLoginApplication(UserName, Password);
	}
	
	@When("^Add the product (.+) to cart$")
	public void Add_the_product_ProductName_to_cart(String ProductName) throws InterruptedException {
		pc.productCatalogueAddToCart(ProductName);
	}
	
	@And("^Chechout (.+) and Submit the Order$")
	public void Checkout_ProductName_and_Submit_the_order(String ProductName) {
		CheckoutPageObects co = pc.goToCartPage();

		Boolean itemMatch = co.checkOutValidateAddedItems(ProductName);
		Assert.assertTrue(itemMatch);
		co.checkOut();
	}
	
	@Then("{string} message is displayed in ConfirmationPage")
	public void confirmation_message_is_displayed_in_ConfirmationPage(String string) throws InterruptedException {
		po = new placeOrderPageObjects(driver);
		cp = po.placeOrder("ind", "India");
		String confirmation = cp.confirmationPageGetMessage();
		Assert.assertEquals(string, confirmation);
		driver.close();
	}
	
	@Then("Error Massage is displyed {string}")
	public void Error_Message_is_displayed() throws InterruptedException {
		Assert.assertEquals("Incorrect email or password.", lp.getErrorMessage());
		driver.close();
	}
}
