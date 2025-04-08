package Main;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	
	@FindBy(xpath = "//a[contains(text(),'Log in')]")
	    private WebElement loginlink;
	
	 @FindBy(xpath = "//input[@id='loginusername']")
	    private WebElement username;

	    @FindBy(xpath = "//input[@id='loginpassword']")
	    private WebElement password;

	    @FindBy(xpath = "//button[contains(text(),'Log in')]")
	    private WebElement login;
	    
	    @FindBy(xpath = "//button[contains(text(),'logout')]")
	    private WebElement logout;
	    
	    
	    private WebDriver driver;
	    private WebDriverWait wait;

	    public Login(WebDriver driver) throws AWTException {
	    	 
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
	    }

	    public void performlogin(String txtusername, String txtpassword) throws AWTException {
	    	wait.until(ExpectedConditions.elementToBeClickable(loginlink)).click();
	        wait.until(ExpectedConditions.elementToBeClickable(username)).sendKeys(txtusername);
	        wait.until(ExpectedConditions.elementToBeClickable(password)).sendKeys(txtpassword);
	        wait.until(ExpectedConditions.elementToBeClickable(login)).click();
	    }
	    public void performlogout() throws AWTException {
	    	wait.until(ExpectedConditions.elementToBeClickable(logout)).click();
	    }
}


