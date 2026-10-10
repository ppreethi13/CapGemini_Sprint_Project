
package ecom.swaglabs.login;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseClass.Base;
import ObjRepo.LoginPage;
import ecom.swaglabs.genericutility.ExcelUtils;

public class TCN2 extends Base {

    // NEGATIVE TESTING
    @Test(groups = {"negative"})
    public void TC_LOGIN_09() throws Exception {

        LoginPage login = new LoginPage(driver);

        ExcelUtils eu = new ExcelUtils();

        String username = eu.getData("Sheet2", 2, 0);
        String password = eu.getData("Sheet2", 3, 1);

        login.login(username, password);

        // Verify locked-out error message
        Assert.assertTrue(
                login.getErrorMessage().contains("locked out"),
                "Expected locked-out user error message was not displayed"
        );

        Reporter.log("TC_LOGIN_09 --> PASSED", true);
    }
}
