package Pages;

import Enums.WebElementEnums.CheckoutPageEnums;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static HelperMethods.FetchPropertiesFileData.fetchPropertiesData;
import static HelperMethods.SeleniumMethods.selectDropdown;

public class CheckoutPage {
    WebDriver driver;
    WebDriverWait wait;

    String continueCheckoutButton = "(//button[contains(@class,'%s')])[1]";
    String billingAddressInputBoxes = "//h2[contains(text(),'Billing address')]//following::input[@name='%s']";
    String shippingMethodRadioBtn = "//div[@class='method-name']//label[contains(text(),'%s')]";
    String paymentMethodRadioBtn = "//div[@class='payment-details']//label[contains(text(),'%s')]";
    String cardDetailsDropdown = "//select[@name='%s']";
    String cardDetailsInputBox = "//input[@name='%s']";

    By countryDropdown = By.xpath("//select[@name='BillingNewAddress.CountryId']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void enterBillingDetails() {
        selectDropdown(driver.findElement(countryDropdown)).selectByVisibleText(fetchPropertiesData("Country"));
        driver.findElement(By.xpath(String.format(billingAddressInputBoxes, CheckoutPageEnums.CityInputBoxName.value))).sendKeys(fetchPropertiesData("City"));
        driver.findElement(By.xpath(String.format(billingAddressInputBoxes, CheckoutPageEnums.Address1InputBoxName.value))).sendKeys(fetchPropertiesData("Address1"));
        driver.findElement(By.xpath(String.format(billingAddressInputBoxes, CheckoutPageEnums.Address2InputBoxName.value))).sendKeys(fetchPropertiesData("Address2"));
        driver.findElement(By.xpath(String.format(billingAddressInputBoxes, CheckoutPageEnums.ZipCodeInputBoxName.value))).sendKeys(fetchPropertiesData("Zip_Code"));
        driver.findElement(By.xpath(String.format(billingAddressInputBoxes, CheckoutPageEnums.PhoneNumberInputBoxName.value))).sendKeys(fetchPropertiesData("Phone"));
        driver.findElement(By.xpath(String.format(continueCheckoutButton, CheckoutPageEnums.NewAddressContinueBtnClass.value))).click();
    }

    public void chooseShippingMethod() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(shippingMethodRadioBtn, CheckoutPageEnums.NextDayAirShippingMethodRadioBtnText.value))));
        driver.findElement(By.xpath(String.format(shippingMethodRadioBtn, CheckoutPageEnums.NextDayAirShippingMethodRadioBtnText.value))).click();
        driver.findElement(By.xpath(String.format(continueCheckoutButton, CheckoutPageEnums.ShippingMethodContinueBtnClass.value))).click();
    }

    public void enterCardDetailsAndConfirmOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(paymentMethodRadioBtn, CheckoutPageEnums.CreditCartPaymentRadioBtnText.value))));
        driver.findElement(By.xpath(String.format(paymentMethodRadioBtn, CheckoutPageEnums.CreditCartPaymentRadioBtnText.value))).click();
        driver.findElement(By.xpath(String.format(continueCheckoutButton, CheckoutPageEnums.PaymentMethodContinueBtnClass.value))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(cardDetailsDropdown, CheckoutPageEnums.CreditCardTypeDropdownName.value))));
        selectDropdown(driver.findElement(By.xpath(String.format(cardDetailsDropdown, CheckoutPageEnums.CreditCardTypeDropdownName.value)))).selectByVisibleText(fetchPropertiesData("Credit_Card_Type"));
        driver.findElement(By.xpath(String.format(cardDetailsInputBox, CheckoutPageEnums.CardHolderNameInputBoxName.value))).sendKeys(fetchPropertiesData("Card_Holder_Name"));
        driver.findElement(By.xpath(String.format(cardDetailsInputBox, CheckoutPageEnums.CardNumberInputBoxName.value))).sendKeys(fetchPropertiesData("Card_Number"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(cardDetailsDropdown, CheckoutPageEnums.CardExpireMonthDropdownName.value))));
        selectDropdown(driver.findElement(By.xpath(String.format(cardDetailsDropdown, CheckoutPageEnums.CardExpireMonthDropdownName.value)))).selectByVisibleText(fetchPropertiesData("Card_Expire_Month"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(cardDetailsDropdown, CheckoutPageEnums.CardExpireYearDropdownName.value))));
        selectDropdown(driver.findElement(By.xpath(String.format(cardDetailsDropdown, CheckoutPageEnums.CardExpireYearDropdownName.value)))).selectByVisibleText(fetchPropertiesData("Card_Expire_Year"));
        driver.findElement(By.xpath(String.format(cardDetailsInputBox, CheckoutPageEnums.CardCodeInputBoxName.value))).sendKeys(fetchPropertiesData("Card_Code"));
        driver.findElement(By.xpath(String.format(continueCheckoutButton, CheckoutPageEnums.PaymentInfoContinueBtnClass.value))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(continueCheckoutButton, CheckoutPageEnums.ConfirmOrderContinueBtnClass.value))));
        driver.findElement(By.xpath(String.format(continueCheckoutButton, CheckoutPageEnums.ConfirmOrderContinueBtnClass.value))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(continueCheckoutButton, CheckoutPageEnums.OrderCompleteContinueBtnClass.value))));
        driver.findElement(By.xpath(String.format(continueCheckoutButton, CheckoutPageEnums.OrderCompleteContinueBtnClass.value))).click();
    }
}