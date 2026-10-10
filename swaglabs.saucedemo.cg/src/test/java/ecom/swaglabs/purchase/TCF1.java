
package ecom.swaglabs.purchase;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseClass.Base;
import ObjRepo.CartPage;
import ObjRepo.CheckoutPage;
import ObjRepo.LoginPage;
import ObjRepo.ProductPage;

public class TCF1 extends Base {

    // FUNCTIONAL TESTING
    @Test(groups = { "functional", "positive" })
    public void Purchase_Fun_001() {

        LoginPage login = new LoginPage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);

        login.login("standard_user", "secret_sauce");

        product.addBackpack();
        product.openCart();
        cart.clickCheckout();

        checkout.enterFirstName("Preethi");
        checkout.enterLastName("M");
        checkout.enterPostalCode("560001");

        checkout.clickContinue();
        checkout.clickFinish();

        boolean result = checkout.getConfirmationMessage()
                .contains("Thank you for your order!");

        Assert.assertTrue(result,
                "Purchase was not completed");

        Reporter.log("PURCHASE_FUN_001 --> PASSED", true);
    }


    // FUNCTIONAL TESTING
    @Test(groups = { "functional", "positive" })
    public void Purchase_Fun_002() {

        LoginPage login = new LoginPage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);

        login.login("standard_user", "secret_sauce");

        product.addBackpack();
        product.openCart();
        cart.clickCheckout();

        checkout.enterFirstName("Preethi");
        checkout.enterLastName("M");
        checkout.enterPostalCode("560001");

        checkout.clickContinue();
        checkout.clickFinish();

        boolean result = checkout.getConfirmationMessage()
                .contains("Thank you for your order!");

        Assert.assertTrue(result,
                "Order confirmation message was not displayed");

        Reporter.log("PURCHASE_FUN_002 --> PASSED", true);
    }
}
