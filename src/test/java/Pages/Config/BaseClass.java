package Pages.Config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static HelperMethods.FetchPropertiesFileData.fetchPropertiesData;

public class BaseClass {
    WebDriver driver;
    protected PageFactory pageFactory;

    @BeforeClass
    public void navigateToNopcommerce() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String nopcommerceUrl = fetchPropertiesData("URL");
        driver.navigate().to(nopcommerceUrl);
        Assert.assertEquals(driver.getCurrentUrl(), nopcommerceUrl);
        pageFactory = new PageFactory(driver);
    }

    @AfterClass
    public void closeBrowserWindow() {
        driver.quit();
    }
}