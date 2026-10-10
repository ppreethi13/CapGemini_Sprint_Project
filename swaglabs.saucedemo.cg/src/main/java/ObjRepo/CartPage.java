
package ObjRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    WebDriver driver;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    @FindBy(className = "inventory_item_name")
    WebElement productName;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCheckout() {
        driver.findElement(By.id("checkout")).click();
    }

    public String getProductName() {
        return driver.findElement(
            By.className("inventory_item_name")
        ).getText();
    }
}
