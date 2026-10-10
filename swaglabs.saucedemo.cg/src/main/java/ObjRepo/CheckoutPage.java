
package ObjRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(String value) {
        driver.findElement(By.id("first-name")).sendKeys(value);
    }

    public void enterLastName(String value) {
        driver.findElement(By.id("last-name")).sendKeys(value);
    }

    public void enterPostalCode(String value) {
        driver.findElement(By.id("postal-code")).sendKeys(value);
    }

    public void clickContinue() {
        driver.findElement(By.id("continue")).click();
    }

    public void clickFinish() {
        driver.findElement(By.id("finish")).click();
    }

    public String getConfirmationMessage() {
        return driver.findElement(
            By.className("complete-header")
        ).getText();
    }

    public String getErrorMessage() {
        return driver.findElement(
            By.cssSelector("h3[data-test='error']")
        ).getText();
    }
}
