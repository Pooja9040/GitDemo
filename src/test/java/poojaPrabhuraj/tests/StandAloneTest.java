package poojaPrabhuraj.tests;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StandAloneTest {

	static String phone = "IPHONE 13 PRO";
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new EdgeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2000));
		
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		Assert.assertEquals(driver.getTitle(), "Let's Shop");
		  
		  driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(
		  "poojajprabhuraj@gmail.com");
		  driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys(
		  "JPpooja@9040");
		  driver.findElement(By.xpath("//input[@value='Login']")).click();
		  Thread.sleep(1000);
		  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
		 Assert.assertEquals("Login Successfully",driver.findElement(By.xpath("//div[@id='toast-container']")).getText() );
		  List<WebElement> products = driver.findElements(By.xpath("//div[@class='card-body']/h5/b"));
		  
		  WebElement selectedProd 
		  = products.stream()
		  .filter(product->product.getText().equals(phone))
		  .findFirst().orElse(null);
		  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
		 selectedProd.findElement(By.xpath("parent::h5/parent::div/button/i[contains(@class,'shopping-cart')]")).click();
		 
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[contains(@class,'ngx-spinner-overlay')]"))));
		
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
	
		 Assert.assertEquals("Product Added To Cart",driver.findElement(By.xpath("//div[@id='toast-container']")).getText() );
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
		 
		 
		 driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
	
		 List<WebElement> cartItems = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		 Boolean itemMatch 
		  = cartItems.stream()
		  .anyMatch(ci->ci.getText().equalsIgnoreCase(phone));
		 Assert.assertEquals(true,itemMatch);
		 
		 driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		 
		 	//driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
		 	
		 	 Actions a = new Actions(driver);
		 	a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")),"ind").build().perform();
			
			  List<WebElement> dynDd = driver.findElements(By.xpath("//button/span"));
			  dynDd.stream()
			  .filter(sc->sc.getText().trim().equals("India"))
			  .findFirst().orElse(null)
			  .click();	
				
				/*
				 * try { long temp = 0; while (true) { ((JavascriptExecutor)
				 * driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
				 * Thread.sleep(2500); long start = (Long) ((JavascriptExecutor)
				 * driver).executeScript("return document.body.scrollHeight"); if (start ==
				 * temp) { break; } temp = start; } System.out.println("completed the scroll");
				 * } catch (Exception e) { e.printStackTrace(); }
				 */
			  
			  a.sendKeys(Keys.PAGE_DOWN).build().perform();
			  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".action__submit"))));
			  driver.findElement(By.cssSelector(".action__submit")).click();	
			  Assert.assertEquals("THANKYOU FOR THE ORDER.", driver.findElement(By.className("hero-primary")).getText());
			  driver.close();
	}

}
