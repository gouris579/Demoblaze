package Main;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Signup {
	
	@FindBy(xpath = "//a[contains(text(),'Sign up')]")
	    private WebElement signuplink;
	
	 @FindBy(xpath = "//input[@id='sign-username']")
	    private WebElement signusername;

	    @FindBy(xpath = "//input[@id='sign-password']")
	    private WebElement signpassword;

	    @FindBy(xpath = "//button[contains(text(),'Sign up')]")
	    private WebElement Signup;
	    
	    @FindBy(xpath = "//button[contains(text(),'OK')]")
	    private WebElement ok;
	    
	    
	    private WebDriver driver;
	    private WebDriverWait wait;

	    public Signup(WebDriver driver) throws AWTException {
	    	 
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
	    }

	    public void performsignup(String username, String password) throws AWTException {
	    	 wait.until(ExpectedConditions.elementToBeClickable(signuplink)).click();
	        wait.until(ExpectedConditions.elementToBeClickable(signusername)).sendKeys(username);
	        wait.until(ExpectedConditions.elementToBeClickable(signpassword)).sendKeys(password);
	        wait.until(ExpectedConditions.elementToBeClickable(Signup)).click();
	        wait.until(ExpectedConditions.elementToBeClickable(ok)).click();
	    }}



