
package ecom.swaglabs.checkout;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseClass.Base;
import ObjRepo.LoginPage;
import ObjRepo.ProductPage;
import ObjRepo.CartPage;
import ObjRepo.CheckoutPage;
import ecom.swaglabs.genericutility.ExcelUtils;

public class TCP extends Base {

    ExcelUtils eu = new ExcelUtils();

    // FUNCTIONAL TESTING
    @Test(groups = { "functional", "positive" })
    public void Purchase_Fun_001() throws Exception {

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
                "Functional checkout failed"
        );

        Reporter.log("PURCHASE_FUN_001 --> PASSED", true);
    }


    // SMOKE TESTING
    @Test(groups = { "smoke", "positive" })
    public void Purchase_Smoke_001() throws Exception {

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
                "Smoke checkout failed"
        );

        Reporter.log("PURCHASE_SMOKE_001 --> PASSED", true);
    }
}
