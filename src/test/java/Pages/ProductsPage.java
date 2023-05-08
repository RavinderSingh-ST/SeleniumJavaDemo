package Pages;

import Enums.WebElementEnums.ProductsPageEnums;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    WebDriver driver;

    String desktopProductAddToCartBtn = "//div[@class='product-item']//a[contains(text(),'%s')]//following::button[contains(text(),'Add to cart')][1]";

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addBuildYourComputerToCart() {
        driver.findElement(By.xpath(String.format(desktopProductAddToCartBtn, ProductsPageEnums.BuildYourComputerText.value))).click();
    }
}