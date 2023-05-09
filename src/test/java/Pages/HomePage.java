package Pages;

import Enums.WebElementEnums.HomePageEnums;
import Enums.WebElementEnums.NavbarHeaderLinkEnums;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import static HelperMethods.FetchPropertiesFileData.fetchPropertiesData;
import static HelperMethods.SeleniumMethods.getActions;
import static HelperMethods.SeleniumMethods.waitForElement;

public class HomePage {
    WebDriver driver;

    String navbarHeaderLinks = "//div[@class='header-links']/ul/li/a[contains(@class,'%s')]";
    String topMenuProductLinks = "(//ul[contains(@class,'top-menu')]//a[contains(text(),'%s')])[1]";
    String computerDropdownOptions = "(//a[contains(text(),'Computers')]//following::a[contains(text(),'%s')])[1]";

    By verifyPageTitle = By.xpath("//div[@class='page-title']/h1");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToRegisterPage() throws InterruptedException {
        waitForElement();
        driver.findElement(By.xpath(String.format(navbarHeaderLinks, NavbarHeaderLinkEnums.RegisterHeaderLinkClass.value))).click();
        Assert.assertEquals(driver.findElement(verifyPageTitle).getText(), fetchPropertiesData("Register_Page_Title"));
    }

    public void navigateToLoginPage() throws InterruptedException {
        waitForElement();
        driver.findElement((By.xpath(String.format(navbarHeaderLinks, NavbarHeaderLinkEnums.LoginHeaderLinkClass.value)))).click();
        Assert.assertEquals(driver.findElement(verifyPageTitle).getText(), fetchPropertiesData("Login_Page_Title"));
    }

    public void navigateToCartPage() throws InterruptedException {
        waitForElement();
        driver.findElement(By.xpath(String.format(navbarHeaderLinks, NavbarHeaderLinkEnums.CartLinkClass.value))).click();
        Assert.assertEquals(driver.findElement(verifyPageTitle).getText(), fetchPropertiesData("Cart_Page_Title"));
    }

    public void navigateToDesktopsPage() throws InterruptedException {
        waitForElement();
        getActions(driver).moveToElement(driver.findElement(By.xpath(String.format(topMenuProductLinks, HomePageEnums.ComputersProductMenuText.value)))).perform();
        driver.findElement(By.xpath(String.format(computerDropdownOptions, HomePageEnums.DesktopDropdownOptionText.value))).click();
    }

    public void userLogout() throws InterruptedException {
        waitForElement();
        driver.findElement(By.xpath(String.format(navbarHeaderLinks, NavbarHeaderLinkEnums.LogoutHeaderLinkClass.value))).click();
        waitForElement();
    }
}