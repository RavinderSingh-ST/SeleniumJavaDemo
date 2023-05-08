package TestCases;

import Pages.Config.BaseClass;
import org.testng.annotations.Test;

public class VerifyUserIsAbleToAddProductAndCheckout extends BaseClass {
    @Test
    public void verifyUserIsAbleToAddProductAndCheckout() {
        pageFactory.getHomePage().navigateToLoginPage();
        pageFactory.getLoginPage().userLogin();
        pageFactory.getHomePage().navigateToDesktopsPage();
        pageFactory.getProductsPage().addBuildYourComputerToCart();
        pageFactory.getProductDescriptionPage().buildYourComputerInfo();
        pageFactory.getHomePage().navigateToCartPage();
        pageFactory.getCartPage().updateCustomCompQuantity();
        pageFactory.getCartPage().proceedToCheckout();
        pageFactory.getCheckoutPage().enterBillingDetails();
        pageFactory.getCheckoutPage().chooseShippingMethod();
        pageFactory.getCheckoutPage().enterCardDetailsAndConfirmOrder();
        pageFactory.getHomePage().userLogout();
    }
}