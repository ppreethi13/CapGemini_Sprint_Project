package ObjRepo;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {

    WebDriver driver;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement backpack;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement bikeLight;

    @FindBy(className = "shopping_cart_link")
    WebElement cart;

    @FindBy(className = "product_sort_container")
    WebElement sortDropdown;

    @FindBy(id = "item_4_title_link")
    WebElement backpackName;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addBackpack() {
        backpack.click();
    }

    public void openCart() {
        cart.click();
    }

    public void sortNameAtoZ() {
        Select select = new Select(sortDropdown);
        select.selectByVisibleText("Name (A to Z)");
    }

    public void selectBackpack() {
        backpackName.click();
    }

    public boolean isProductPageDisplayed() {
        return driver.getCurrentUrl().contains("inventory.html");
    }
    public void openMenu() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    public void clickAllItems() {
        driver.findElement(By.id("inventory_sidebar_link")).click();
    }
}