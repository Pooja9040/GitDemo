package poojaPrabhuraj.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import poojaPrabhuraj.TestComponents.BaseTest;
import poojaPrabhuraj.TestComponents.Retry;
import poojaPrabhuraj.pageObjects.CheckoutPageObects;
import poojaPrabhuraj.pageObjects.ConfirmationPageObjects;
import poojaPrabhuraj.pageObjects.OrdersPageObjects;
import poojaPrabhuraj.pageObjects.ProductCataloguePageObjects;
import poojaPrabhuraj.pageObjects.placeOrderPageObjects;

public class StandAloneOrderTest extends BaseTest {
	String phone = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = { "Purchase" },retryAnalyzer = Retry.class)
	public void SubmitOrder(HashMap<String, String> input) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		// String email = "poojajprabhuraj@gmail.com";
		// String password = "JPpooja@9040";
		String country = "India";

		Assert.assertEquals(driver.getTitle(), "Let's Shop");
	
		ProductCataloguePageObjects pc = lp.loginPageLoginApplication(input.get("email"), input.get("password"));

		// Assert.assertEquals("Login
		// Successfully",driver.findElement(By.xpath("//div[@id='toast-container']")).getText());

		pc.productCatalogueAddToCart(input.get("ProductName"));

		// Assert.assertEquals("Product Added To
		// Cart",driver.findElement(By.xpath("//div[@id='toast-container']")).getText());
		CheckoutPageObects co = pc.goToCartPage();

		Boolean itemMatch = co.checkOutValidateAddedItems(input.get("ProductName"));
		Assert.assertTrue(itemMatch);
		co.checkOut();

		placeOrderPageObjects po = new placeOrderPageObjects(driver);
		ConfirmationPageObjects cp = po.placeOrder("ind", country);
		String confirmation = cp.confirmationPageGetMessage();

		Assert.assertEquals("THANKYOU FOR THE ORDER.", confirmation);

	}

	@Test(dependsOnMethods = { "SubmitOrder" })
	public void orderHistoryTest(String ProductName) throws InterruptedException {
		ProductCataloguePageObjects pc = lp.loginPageLoginApplication("poojajprabhuraj@gmail.com", "JPpooja@9040");
		OrdersPageObjects ordp = pc.goToOrdersPage();
		Assert.assertTrue(ordp.verifyProductsDisplay(ProductName));
	}

	@DataProvider
	public Object[][] getData() throws IOException {

		/*
		 * return new Object[][] {{
		 * "poojajprabhuraj@gmail.com","JPpooja@9040","ZARA COAT 3"},
		 * {"poojajprabhuraj@gmail.com","JPpooja@9040","ZARA COAT 3"}};
		 */

		/*
		 * HashMap<String,String> map = new HashMap<String,String>(); map.put("email",
		 * "poojajprabhuraj@gmail.com"); map.put("password", "JPpooja@9040");
		 * map.put("ProductName", "ZARA COAT 3");
		 * 
		 * HashMap<String,String> map1 = new HashMap<String,String>(); map1.put("email",
		 * "poojajprabhuraj@gmail.com"); map1.put("password", "JPpooja@9040");
		 * map1.put("ProductName", "ADIDAS ORIGINAL");
		 */

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//poojaPrabhuraj//data//PurchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

}
