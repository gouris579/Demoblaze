package Test;

import java.awt.AWTException;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Config.Config;
import Main.CartTest;
import Main.Login;
import Main.Product;
import Main.Signup;
import utils.ReadFromJSON;


    public class PurchaseFlow extends Config {
    private Login login;
    private Signup signup;
    private Product product;
    private CartTest cart;
    private JSONObject LoginTestData;
    private JSONObject SignupTestData;
    private JSONObject ProductTestData;
    private ReadFromJSON readfromjson;
    
    @BeforeClass
    public void setup() throws IOException, ParseException, AWTException {
        login = new Login(driver);
        signup = new Signup(driver);
        product = new Product(driver);
        cart = new CartTest(driver);
        readfromjson = new ReadFromJSON();
        LoginTestData = readfromjson.readfromJSON("Login", "LoginTestData", "");
        SignupTestData = readfromjson.readfromJSON("Signup", "SignupTestData", "");
        ProductTestData = readfromjson.readfromJSON("Product", "ProductTestData", "");
    }

    @Test(priority = 1, description = "Ensure that user is able to signup")
    public void performsignup() throws AWTException {
        signup.performsignup(SignupTestData.get("username").toString(), 
                             SignupTestData.get("password").toString());
    }

    @Test(priority = 2, description = "Ensure that user is able to login")
    public void performlogin() throws AWTException {
        login.performlogin(LoginTestData.get("txtusername").toString(), 
                           LoginTestData.get("txtpassword").toString());
    }

    @Test(priority = 3, description = "Ensure that user is able to find the product")
    public void clickProductByName() throws AWTException {
        product.clickProductByName(ProductTestData.get("productName").toString());
    }

    @Test(priority = 4, description = "Ensure that user is able to add the product to the cart and verify the confirmation message")
    public void addToCart() throws AWTException {
        product.addToCart(ProductTestData.get("productName").toString());
        product.verifyAddToCartConfirmation();
    }

    @Test(priority = 5, description = "Ensure that user is able to verify the product in the cart")
    public void verifyProductInCart() throws AWTException {
        cart.navigateToCart();
        cart.verifyProductInCart(ProductTestData.get("productName").toString());
    }

    @Test(priority = 6, description = "Ensure that user is able to checkout and fill in payment details")
    public void checkout() throws AWTException {
        cart.proceedToCheckout();
        cart.fillPaymentDetails("John Doe", "1234 5678 9012 3456", "12/23", "123");
    }

    @Test(priority = 7, description = "Ensure that user is able to place the order and verify the success message")
    public void placeOrder() throws AWTException {
        cart.placeOrder();
        cart.verifyOrderSuccess();
    }

    @Test(priority = 8, description = "Ensure that user is able to logout and close the browser")
    public void performlogout() throws AWTException {
        login.performlogout();
        
    }
}
    



