package testclasses;

import com.microsoft.playwright.Page;
import constant.ApplicationConst;
import factory.BaseClass;
import factory.PlaywrightFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseClass {


    @Test
    public void homePageTitleTest()
    {
         String actualTitle = homePage.getHomePageTitle();
        Assert.assertEquals(actualTitle, ApplicationConst.LOGIN_PAGE_TITLE);
    }

    @Test
    public void homePageUrlTest()
    {
        String actualUrl = homePage.getHomePageUrl();
        Assert.assertEquals(actualUrl, prop.get("url"));
    }

    @Test(dataProvider = "getProductData")
    public void searchTest(String productname)
    {
        String actualHeader = homePage.doSearch(productname);
        Assert.assertEquals(actualHeader, "Search - "+productname);
    }

    @DataProvider
    public Object [][] getProductData()
    {
        return new Object[][]
                {
                        {"macbook"},
                        {"iMac"},
                        {"samsung"}
                };
    }
}
