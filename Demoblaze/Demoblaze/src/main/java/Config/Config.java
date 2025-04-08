package Config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Config {
	
	public static WebDriver driver;
	 
	 @BeforeClass
	 
	 public static void setupdriver() {
	 
	 
	  driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get("https://www.demoblaze.com/");
	 }
	 
	 @AfterClass
	 
	 public static void closedriver()
	 {
		// driver.quit();
	 }
	 
	 
	 
	}




