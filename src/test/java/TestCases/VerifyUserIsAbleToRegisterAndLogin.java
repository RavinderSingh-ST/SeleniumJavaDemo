package TestCases;

import Pages.Config.BaseClass;
import org.testng.annotations.Test;

public class VerifyUserIsAbleToRegisterAndLogin extends BaseClass {
    @Test
    public void verifyUserIsAbleToRegisterAndLogin() throws InterruptedException {
        pageFactory.getHomePage().navigateToRegisterPage();
        pageFactory.getRegisterPage().userRegisters();
        pageFactory.getHomePage().navigateToLoginPage();
        pageFactory.getLoginPage().userLogin();
        pageFactory.getHomePage().userLogout();
    }
}