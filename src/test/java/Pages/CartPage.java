package Pages;

import Enums.WebElementEnums.CartPageEnums;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static HelperMethods.FetchPropertiesFileData.fetchPropertiesData;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;

    String productQuantityInputBox = "//span[contains(text(),'%s')]//following::input[@class='qty-input'][1]";

    By updateCartButton = By.xpath("//button[contains(@class,'update-cart-button')]");
    By termServiceCheckbox = By.xpath("//div[@class='terms-of-service']//input");
    By checkoutButton = By.xpath("//button[@name='checkout']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void updateCustomCompQuantity() {
        driver.findElement(By.xpath(String.format(productQuantityInputBox, CartPageEnums.CustomComputerSkuText.value))).clear();
        driver.findElement(By.xpath(String.format(productQuantityInputBox, CartPageEnums.CustomComputerSkuText.value))).sendKeys(fetchPropertiesData("Custom_Comp_Quantity"));
        driver.findElement(updateCartButton).click();
    }

    public void proceedToCheckout() {
        driver.findElement(termServiceCheckbox).click();
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        driver.findElement(checkoutButton).click();
    }
}