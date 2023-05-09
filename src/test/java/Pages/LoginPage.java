package Pages;

import Enums.WebElementEnums.LoginPageEnums;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static HelperMethods.FetchExcelFileData.fetchUserRegisterDataExcel;
import static HelperMethods.SeleniumMethods.waitForElement;
import static Pages.RegisterPage.uniqueUsername;

public class LoginPage {
    WebDriver driver;

    String loginInputBoxes = "//input[@class='%s']";

    By loginButton = By.xpath("//button[contains(@class,'login-button')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void userLogin() throws InterruptedException {
        waitForElement();
        driver.findElement(By.xpath(String.format(loginInputBoxes, LoginPageEnums.EmailInputBoxClass.value))).sendKeys(uniqueUsername);
        driver.findElement(By.xpath(String.format(loginInputBoxes, LoginPageEnums.PasswordInputBoxClass.value))).sendKeys(fetchUserRegisterDataExcel(2, 2));
        waitForElement();
        driver.findElement(loginButton).click();
    }
}