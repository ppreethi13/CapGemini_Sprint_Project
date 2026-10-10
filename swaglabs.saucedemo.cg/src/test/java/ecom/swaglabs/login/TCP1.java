
package ecom.swaglabs.login;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseClass.Base;
import ObjRepo.LoginPage;
import ObjRepo.ProductPage;
import ecom.swaglabs.genericutility.ExcelUtils;

public class TCP1 extends Base {

    // FUNCTIONAL TESTING
    @Test(groups = { "functional", "positive" })
    public void TC_LOGIN_01() throws Exception {

        LoginPage login = new LoginPage(driver);
        ExcelUtils eu = new ExcelUtils();

        String username = eu.getData("Sheet2", 1, 0);
        String password = eu.getData("Sheet2", 1, 1);

        login.login(username, password);

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory.html"),
                "Login failed or Product page was not displayed"
        );

        Reporter.log("TC_LOGIN_01 --> PASSED", true);
    }


    // SMOKE TESTING
    @Test(groups = { "smoke", "positive" })
    public void TC_LOGIN_08() throws Exception {

        LoginPage login = new LoginPage(driver);
        ExcelUtils eu = new ExcelUtils();

        String username = eu.getData("Sheet2", 3, 0);
        String password = eu.getData("Sheet2", 3, 1);

        login.login(username, password);

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory.html"),
                "Login failed or Product page was not displayed"
        );

        Reporter.log("TC_LOGIN_08 --> PASSED", true);
    }


    // INTEGRATION TESTING
    @Test(groups = { "integration", "positive" })
    public void TC_LOGIN_03() throws Exception {

        LoginPage login = new LoginPage(driver);
        ExcelUtils eu = new ExcelUtils();

        String username = eu.getData("Sheet2", 4, 0);
        String password = eu.getData("Sheet2", 4, 1);

        login.login(username, password);

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory.html"),
                "Login failed or Product page was not displayed"
        );

        Reporter.log("TC_LOGIN_03 --> PASSED", true);
    }


    // SYSTEM TESTING
    @Test(groups = { "system", "positive" })
    public void TC_LOGIN_05() throws Exception {

        LoginPage login = new LoginPage(driver);
        ProductPage product = new ProductPage(driver);
        ExcelUtils eu = new ExcelUtils();

        String username = eu.getData("Sheet2", 5, 0);
        String password = eu.getData("Sheet2", 5, 1);

        login.login(username, password);

        product.sortNameAtoZ();
        product.selectBackpack();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory-item.html"),
                "Product details page was not displayed"
        );

        Reporter.log("TC_LOGIN_05 --> PASSED", true);
    }
}
