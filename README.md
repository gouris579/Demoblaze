# Demoblaze Product Purchase Automation

This project automates the process of purchasing a product on the Demoblaze website using Selenium and TestNG.

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Maven
- TestNG
- Selenium WebDriver
- A JSON library (e.g., json-simple)

## Project Structure

- `src/test/java/Test/PurchaseFlow.java`: Contains the test cases for the purchase flow.
- `src/main/java/Main/Login.java`: Contains methods for user login.
- `src/main/java/Main/Signup.java`: Contains methods for user signup.
- `src/main/java/Main/Product.java`: Contains methods for product selection and adding to cart.
- `src/main/java/Main/CartTest.java`: Contains methods for cart operations and checkout.
- `src/main/java/utils/ReadFromJSON.java`: Utility class for reading test data from JSON files.
- `src/test/resources/LoginTestData.json`: JSON file containing login test data.
- `src/test/resources/SignupTestData.json`: JSON file containing signup test data.
- `src/test/resources/ProductTestData.json`: JSON file containing product test data.

## Setup

1. Clone the repository.
2. Navigate to the project directory.
3. Ensure all dependencies are included in the `pom.xml` file.
4. Import the project into your IDE (e.g., Eclipse).

## Execution Steps

1. **Launch the browser and open the URL**:
   - The browser is launched, and the URL `https://www.demoblaze.com/` is opened in the `@BeforeClass` method of `PurchaseFlow`.

2. **Register a new user (Sign Up)**:
   - The `performsignup` method in `PurchaseFlow` calls the `performsignup` method in `Signup` class to register a new user.

3. **Login with the registered credentials**:
   - The `performlogin` method in `PurchaseFlow` calls the `performlogin` method in `Login` class to log in with the registered credentials.

4. **Select a product from the home page**:
   - The `clickProductByName` method in `PurchaseFlow` calls the `clickProductByName` method in `Product` class to select a product by name.

5. **Add the product to the cart and verify the confirmation message**:
   - The `addToCart` method in `PurchaseFlow` calls the `addToCart` and `verifyAddToCartConfirmation` methods in `Product` class to add the product to the cart and verify the confirmation message.

6. **Navigate to the cart and verify the selected product is displayed**:
   - The `verifyProductInCart` method in `PurchaseFlow` calls the `navigateToCart` and `verifyProductInCart` methods in `CartTest` class to verify the product in the cart.

7. **Proceed to checkout and fill in payment details**:
   - The `checkout` method in `PurchaseFlow` calls the `proceedToCheckout` and `fillPaymentDetails` methods in `CartTest` class to proceed to checkout and fill in payment details.

8. **Place the order and verify the success message**:
   - The `placeOrder` method in `PurchaseFlow` calls the `placeOrder` and `verifyOrderSuccess` methods in `CartTest` class to place the order and verify the success message.

9. **Logout and close the browser**:
   - The `performlogout` method in `PurchaseFlow` calls the `logout` method in `Login` class to log out and close the browser.

## Running the Tests

1. Open the `PurchaseFlow` class in your IDE.
2. Right-click on the class and select `Run As -> TestNG Test`.
3. The tests will execute sequentially, following the steps outlined above.

## Notes

- Ensure that the JSON files (`LoginTestData.json`, `SignupTestData.json`, `ProductTestData.json`) are correctly populated with the necessary test data.
- The `ReadFromJSON` utility class is used to read data from these JSON files.


