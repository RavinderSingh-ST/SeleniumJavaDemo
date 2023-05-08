package Pages.Config;

import Pages.*;
import org.openqa.selenium.WebDriver;

public class PageFactory {
    WebDriver driver;

    private HomePage homePage;
    private RegisterPage registerPage;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private ProductDescriptionPage productDescriptionPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage(driver);
        }
        return homePage;
    }

    public RegisterPage getRegisterPage() {
        if (registerPage == null) {
            registerPage = new RegisterPage(driver);
        }
        return registerPage;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public ProductsPage getProductsPage() {
        if (productsPage == null) {
            productsPage = new ProductsPage(driver);
        }
        return productsPage;
    }

    public ProductDescriptionPage getProductDescriptionPage() {
        if (productDescriptionPage == null) {
            productDescriptionPage = new ProductDescriptionPage(driver);
        }
        return productDescriptionPage;
    }

    public CartPage getCartPage() {
        if (cartPage == null) {
            cartPage = new CartPage(driver);
        }
        return cartPage;
    }

    public CheckoutPage getCheckoutPage() {
        if (checkoutPage == null) {
            checkoutPage = new CheckoutPage(driver);
        }
        return checkoutPage;
    }
}