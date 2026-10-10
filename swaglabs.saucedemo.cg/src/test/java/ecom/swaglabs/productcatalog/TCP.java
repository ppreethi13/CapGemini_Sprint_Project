package ecom.swaglabs.productcatalog;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseClass.Base;
import ObjRepo.LoginPage;
import ObjRepo.ProductPage;
import ecom.swaglabs.genericutility.ExcelUtils;

public class TCP extends Base {

    ExcelUtils eu = new ExcelUtils();

    // FUNCTIONAL TESTING
    @Test(groups = { "functional", "positive" })
    public void TC_PC_01() throws Exception {

        LoginPage login = new LoginPage(driver);
        ProductPage product = new ProductPage(driver);

        String username = eu.getData("Sheet2", 1, 0);
        String password = eu.getData("Sheet2", 1, 1);

        login.login(username, password);

        Assert.assertTrue(
                product.isProductPageDisplayed(),
                "Product page was not displayed after login"
        );

        Reporter.log("TC_PC_01 --> PASSED", true);
    }


    // SMOKE TESTING
    @Test(groups = { "smoke", "positive" })
    public void TC_PC_07() throws Exception {

        LoginPage login = new LoginPage(driver);
        ProductPage product = new ProductPage(driver);

        String username = eu.getData("Sheet2", 1, 0);
        String password = eu.getData("Sheet2", 1, 1);

        login.login(username, password);

        Assert.assertTrue(
                product.isProductPageDisplayed(),
                "Product page was not displayed after login"
        );

        Reporter.log("TC_PC_07 --> PASSED", true);
    }
}
