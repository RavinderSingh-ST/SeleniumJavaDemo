package Pages;

import Enums.WebElementEnums.ProductDescriptionPageEnums;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static HelperMethods.FetchPropertiesFileData.fetchPropertiesData;
import static HelperMethods.SeleniumMethods.selectDropdown;

public class ProductDescriptionPage {
    WebDriver driver;
    WebDriverWait wait;

    String buildComputerCustomDropdown = "//label[contains(text(),'%s')]//following::select[1]";
    String hardDiskOptionRadioBtn = "//label[contains(text(),' HDD ')]//following::label[contains(text(),'%s')]";
    String osOptionRadioBtn = "//label[contains(text(),' OS ')]//following::label[contains(text(),'Vista Premium [+$60.00]')]";
    String softwareOptionRadioBtn = "//label[contains(text(),' Software ')]//following::label[contains(text(),'%s')]";

    By addToCartBtn = By.xpath("//button[contains(text(),'Add to cart')]");
    By productAddNotifyBar = By.xpath("//p[@class='content']");

    public ProductDescriptionPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void buildYourComputerInfo() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(buildComputerCustomDropdown, ProductDescriptionPageEnums.ProcessorDropdownLabelText.value))));
        selectDropdown(driver.findElement(By.xpath(String.format(buildComputerCustomDropdown, ProductDescriptionPageEnums.ProcessorDropdownLabelText.value)))).selectByVisibleText(fetchPropertiesData("Processor_Option"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(buildComputerCustomDropdown, ProductDescriptionPageEnums.RamDropdownLabelText.value))));
        selectDropdown(driver.findElement(By.xpath(String.format(buildComputerCustomDropdown, ProductDescriptionPageEnums.RamDropdownLabelText.value)))).selectByVisibleText(fetchPropertiesData("Ram_Option"));
        driver.findElement(By.xpath(String.format(hardDiskOptionRadioBtn, ProductDescriptionPageEnums.Hdd400Text.value))).click();
        driver.findElement(By.xpath(String.format(osOptionRadioBtn, ProductDescriptionPageEnums.VistaHomeText.value))).click();
        driver.findElement(By.xpath(String.format(softwareOptionRadioBtn, ProductDescriptionPageEnums.TotalCommanderText.value))).click();
        driver.findElement(addToCartBtn).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productAddNotifyBar));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(productAddNotifyBar));
    }
}