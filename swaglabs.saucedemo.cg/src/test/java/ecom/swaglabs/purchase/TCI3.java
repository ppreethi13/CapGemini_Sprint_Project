
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

public class TCI3 extends Base {

    ExcelUtils eu = new ExcelUtils();

    // INTEGRATION TESTING
    @Test(groups = { "integration", "positive" })
    public void Purchase_Int_001() throws Exception {

        LoginPage login = new LoginPage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);

        login.login("standard_user", "secret_sauce");

        product.addBackpack();
        product.openCart();

        // Verify product in cart
        Assert.assertTrue(
                cart.getProductName().contains("Sauce Labs Backpack"),
                "Sauce Labs Backpack was not displayed in the cart"
        );

        cart.clickCheckout();

        // Read FN, LN, and PC from Excel
        String firstName = eu.getData("Sheet1", 1, 0);
        String lastName = eu.getData("Sheet1", 1, 1);
        String postalCode = eu.getData("Sheet1", 1, 2);

        checkout.enterFirstName(firstName);
        checkout.enterLastName(lastName);
        checkout.enterPostalCode(postalCode);

        checkout.clickContinue();

        // Verify checkout overview page
        Assert.assertTrue(
                driver.getCurrentUrl().contains("checkout-step-two"),
                "Checkout overview page was not displayed"
        );

        Reporter.log("PURCHASE_INT_001 --> PASSED", true);
    }


    // INTEGRATION TESTING
    @Test(groups = { "integration", "positive" })
    public void Purchase_Int_002() throws Exception {

        LoginPage login = new LoginPage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);

        login.login("standard_user", "secret_sauce");

        product.addBackpack();
        product.openCart();

        cart.clickCheckout();

        // Read FN, LN, and PC from Excel
        String firstName = eu.getData("Sheet1", 1, 0);
        String lastName = eu.getData("Sheet1", 1, 1);
        String postalCode = eu.getData("Sheet1", 1, 2);

        checkout.enterFirstName(firstName);
        checkout.enterLastName(lastName);
        checkout.enterPostalCode(postalCode);

        checkout.clickContinue();
        checkout.clickFinish();

        // Verify order confirmation
        Assert.assertEquals(
                checkout.getConfirmationMessage(),
                "Thank you for your order!",
                "Order confirmation message was not displayed"
        );

        Reporter.log("PURCHASE_INT_002 --> PASSED", true);
    }
}
