package Pages;

import Enums.WebElementEnums.RegisterPageEnums;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import static HelperMethods.FetchExcelFileData.fetchUserRegisterDataExcel;
import static HelperMethods.FetchPropertiesFileData.fetchPropertiesData;
import static HelperMethods.GetUniqueValue.getUniqueValue;
import static HelperMethods.SeleniumMethods.selectDropdown;

public class RegisterPage {
    WebDriver driver;

    static String uniqueUsername = fetchPropertiesData("Email").replace("{uniqueValue}", getUniqueValue());
    String genderRadioFieldXpath = "//div[@class='gender']/span[@class='%s']/input";
    String registerInputFieldsXpath = "//div[@class='inputs']/input[@name='%s']";
    String dateOfBirthDropdownXpath = "//select[@name='%s']";
    By registerButton = By.xpath("//button[@name='register-button']");
    By registrationCompleteMessage = By.xpath("//div[@class='result']");
    By continueAfterRegisterLinkBtn = By.xpath("//a[contains(@class,'register-continue-button')]");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void userRegisters() {
        driver.findElement(By.xpath(String.format(genderRadioFieldXpath, RegisterPageEnums.MaleRadioFieldClass.value))).click();
        driver.findElement(By.xpath(String.format(registerInputFieldsXpath, RegisterPageEnums.FirstNameInputFieldName.value))).sendKeys(fetchUserRegisterDataExcel(2, 0));
        driver.findElement(By.xpath(String.format(registerInputFieldsXpath, RegisterPageEnums.LastNameInputFieldName.value))).sendKeys(fetchUserRegisterDataExcel(2, 1));
        selectDropdown(driver.findElement(By.xpath(String.format(dateOfBirthDropdownXpath, RegisterPageEnums.DayDropdownName.value)))).selectByValue(fetchPropertiesData("Day_Of_Birth"));
        selectDropdown(driver.findElement(By.xpath(String.format(dateOfBirthDropdownXpath, RegisterPageEnums.MonthDropdownName.value)))).selectByValue(fetchPropertiesData("Month_Of_Birth"));
        selectDropdown(driver.findElement(By.xpath(String.format(dateOfBirthDropdownXpath, RegisterPageEnums.YearDropdownName.value)))).selectByValue(fetchPropertiesData("Year_Of_Birth"));
        driver.findElement(By.xpath(String.format(registerInputFieldsXpath, RegisterPageEnums.EmailInputFieldName.value))).sendKeys(uniqueUsername);
        driver.findElement(By.xpath(String.format(registerInputFieldsXpath, RegisterPageEnums.PasswordInputFieldName.value))).sendKeys(fetchUserRegisterDataExcel(2, 2));
        driver.findElement(By.xpath(String.format(registerInputFieldsXpath, RegisterPageEnums.ConfirmPasswordInputFieldName.value))).sendKeys(fetchUserRegisterDataExcel(2, 2));
        driver.findElement(registerButton).click();
        Assert.assertEquals(driver.findElement(registrationCompleteMessage).getText(), fetchPropertiesData("Register_Completion_Message"));
        driver.findElement(continueAfterRegisterLinkBtn).click();
    }
}