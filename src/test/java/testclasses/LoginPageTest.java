package testclasses;

import constant.ApplicationConst;
import factory.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass {
    @Test(priority = 1)
    public void loginPageNavigationTest()
    {
        loginPage = homePage.navigateToLoginPage();
        String actualTitle = loginPage.getLoginPageTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(actualTitle, ApplicationConst.LOGIN_PAGE_TITLE);
    }
    @Test(priority =2)
    public void forgotlinkExist()
    {
        Assert.assertTrue(loginPage.isForgotPasswordExist());
    }
    @Test(priority = 3)
    public void loginTest()
    {
        Assert.assertTrue(loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password")));
    }
}
