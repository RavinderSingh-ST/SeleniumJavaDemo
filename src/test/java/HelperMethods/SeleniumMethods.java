package HelperMethods;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.function.Function;

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

    public static void waitForElement() throws InterruptedException {
        Thread.sleep(1000);
    }
}