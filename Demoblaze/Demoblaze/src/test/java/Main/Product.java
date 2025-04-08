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

public class Product {
	
	private WebDriver driver;
    private WebDriverWait wait;
    
    public Product(WebDriver driver) throws AWTException {
   	 
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
    }

	    public void clickProductByName(String productName) {
	        driver.findElement(By.linkText(productName)).click();
	    }

	    public void addToCart(String productName) {
	        clickProductByName(productName);
	        driver.findElement(By.linkText("Add to cart")).click();
	    }

	    public void verifyAddToCartConfirmation() {
	        WebElement confirmationMessage = driver.findElement(By.xpath("//div[@class='confirm-message']"));
	        String messageText = confirmationMessage.getText();
	        if (messageText.contains("Product added to cart")) {
	            System.out.println("Product added to cart successfully.");
	        } else {
	            System.out.println("Failed to add product to cart.");
	        }
	    }
	}

