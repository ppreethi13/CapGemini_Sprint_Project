
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

public class TCSS4 extends Base {

    ExcelUtils eu = new ExcelUtils();

    // SYSTEM TESTING
    @Test(groups = { "system", "positive" })
    public void Purchase_Sys_001() throws Exception {

        LoginPage login = new LoginPage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);

        login.login("standard_user", "secret_sauce");
        

        product.addBackpack();
        

        product.openCart();
        

        cart.clickCheckout();
        

        // Fetch checkout data from Excel
        String firstName = eu.getData("Sheet1", 1, 0);
        String lastName = eu.getData("Sheet1", 1, 1);
        String postalCode = eu.getData("Sheet1", 1, 2);

        checkout.enterFirstName(firstName);
        checkout.enterLastName(lastName);
        checkout.enterPostalCode(postalCode);
        

        checkout.clickContinue();
        

        checkout.clickFinish();
        

        Assert.assertEquals(
                checkout.getConfirmationMessage(),
                "Thank you for your order!",
                "Purchase system test 001 failed"
        );

        Reporter.log("PURCHASE_SYS_001 --> PASSED", true);
    }


    // SYSTEM TESTING
    @Test(groups = { "system", "positive" })
    public void Purchase_Sys_002() throws Exception {

        LoginPage login = new LoginPage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);

        login.login("standard_user", "secret_sauce");
        

        product.addBackpack();
        

        product.openCart();
        

        cart.clickCheckout();
        

        // Fetch checkout data from Excel
        String firstName = eu.getData("Sheet1", 1, 0);
        String lastName = eu.getData("Sheet1", 1, 1);
        String postalCode = eu.getData("Sheet1", 1, 2);

        checkout.enterFirstName(firstName);
        checkout.enterLastName(lastName);
        checkout.enterPostalCode(postalCode);
        

        checkout.clickContinue();
        

        checkout.clickFinish();
        

        Assert.assertEquals(
                checkout.getConfirmationMessage(),
                "Thank you for your order!",
                "Purchase system test 002 failed"
        );

        Reporter.log("PURCHASE_SYS_002 --> PASSED", true);
    }
}
