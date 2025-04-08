package Main;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CartTest {
	
	@FindBy(xpath = "//a[contains(text(),'Cart')]")
	private WebElement cartLink;

	@FindBy(xpath = "//button[contains(text(),'Place Order')]")
	private WebElement placeOrderButton;

	@FindBy(id = "name")
	private WebElement nameField;

	@FindBy(id = "card")
	private WebElement cardField;

	@FindBy(id = "month")
	private WebElement monthField;

	@FindBy(id = "year")
	private WebElement yearField;

	@FindBy(id = "cvv")
	private WebElement cvvField;
	
	private WebDriver driver;
    private WebDriverWait wait;
    
    public CartTest(WebDriver driver) throws AWTException {
   	 
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
    }

	
	 public void navigateToCart() {
	        driver.findElement(By.id("cartur")).click();
	    }

	    public void verifyProductInCart(String productName) {
	        	WebElement productInCart = driver.findElement(By.xpath("//td[contains(text(),'" + productName + "')]"));
	        String actualProductName = productInCart.getText();
	        Assert.assertEquals(actualProductName, productName, "Product not found in cart");
	    }

	    public void proceedToCheckout() {
	        driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
	    }

	    public void fillPaymentDetails(String name, String cardNumber, String expiry, String cvv) {
	       wait.until(ExpectedConditions.elementToBeClickable(nameField)).sendKeys(name);
	        wait.until(ExpectedConditions.elementToBeClickable(cardField)).sendKeys(cardNumber);
	        wait.until(ExpectedConditions.elementToBeClickable(monthField)).sendKeys(expiry.split("/")[0]);
	        wait.until(ExpectedConditions.elementToBeClickable(yearField)).sendKeys(expiry.split("/")[1]);
	        wait.until(ExpectedConditions.elementToBeClickable(cvvField)).sendKeys(cvv);
	    }

	    public void placeOrder() {
	        driver.findElement(By.xpath("//button[contains(text(),'Purchase')]")).click();
	    }

	    public void verifyOrderSuccess() {
	       		        WebElement successMessage = driver.findElement(By.xpath("//div[contains(text(),'Thank you for your purchase!')]"));
	        String messageText = successMessage.getText();
	        Assert.assertTrue(messageText.contains("Thank you for your purchase"), "Order was not successful");
	    }
    }

