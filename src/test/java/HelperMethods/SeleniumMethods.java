package HelperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumMethods {
    private static WebDriver driver;

    public static Select selectDropdown(WebElement element) {
        Select select = new Select(element);
        return select;
    }

    public static Actions getActions(WebDriver driver) {
        Actions actions = new Actions(driver);
        return actions;
    }
}