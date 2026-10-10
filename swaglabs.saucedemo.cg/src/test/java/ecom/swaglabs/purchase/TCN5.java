
package ecom.swaglabs.purchase;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseClass.Base;
import ObjRepo.CartPage;
import ObjRepo.CheckoutPage;
import ObjRepo.LoginPage;
import ObjRepo.ProductPage;
import ecom.swaglabs.genericutility.ExcelUtils;
import ecom.swaglabs.genericutility.Screenshot;

public class TCN5 extends Base {

    ExcelUtils eu = new ExcelUtils();

    // NEGATIVE TESTING
    @Test(groups = {"negative"})
    public void Purchase_Neg_003() throws Exception {

        LoginPage login = new LoginPage(driver);
        ProductPage product = new ProductPage(driver);

        login.login("standard_user", "secret_sauce");

        product.openMenu();
        product.clickAllItems();

        Screenshot.takeScreenshot(driver, "Purchase_Neg_003");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory.html"),
                "All Items did not navigate to the inventory page"
        );

        Reporter.log("PURCHASE_NEG_003 --> PASSED", true);
    }


    // NEGATIVE TESTING - FIRST NAME MISSING
    @Test(groups = {"negative"})
    public void Purchase_Neg_001() throws Exception {

        LoginPage login = new LoginPage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);

        login.login("standard_user", "secret_sauce");

        product.addBackpack();
        product.openCart();
        cart.clickCheckout();

        // Fetch Last Name and Postal Code from Excel
        String lastName = eu.getData("Sheet1", 1, 1);
        String postalCode = eu.getData("Sheet1", 1, 2);

        // First Name intentionally left blank
        checkout.enterLastName(lastName);
        checkout.enterPostalCode(postalCode);
        checkout.clickContinue();

        Screenshot.takeScreenshot(driver, "Purchase_Neg_001");

        Assert.assertTrue(
                checkout.getErrorMessage().contains("First Name"),
                "Expected First Name validation error was not displayed"
        );

        Reporter.log("PURCHASE_NEG_001 --> PASSED", true);
    }


    // NEGATIVE TESTING - POSTAL CODE MISSING
    @Test(groups = {"negative"})
    public void Purchase_Neg_002() throws Exception {

        LoginPage login = new LoginPage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);

        login.login("standard_user", "secret_sauce");

        product.addBackpack();
        product.openCart();
        cart.clickCheckout();

        // Fetch First Name and Last Name from Excel
        String firstName = eu.getData("Sheet1", 1, 0);
        String lastName = eu.getData("Sheet1", 1, 1);

        checkout.enterFirstName(firstName);
        checkout.enterLastName(lastName);

        // Postal Code intentionally left blank
        checkout.clickContinue();

        Screenshot.takeScreenshot(driver, "Purchase_Neg_002");

        Assert.assertTrue(
                checkout.getErrorMessage().contains("Postal Code"),
                "Expected Postal Code validation error was not displayed"
        );

        Reporter.log("PURCHASE_NEG_002 --> PASSED", true);
    }
}
