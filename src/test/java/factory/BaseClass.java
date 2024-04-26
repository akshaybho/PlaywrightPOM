package factory;

import com.microsoft.playwright.Page;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    Page pg;
    PlaywrightBrowser pb;
    protected Properties prop;
    protected HomePage homePage;
    protected LoginPage loginPage;
    @BeforeSuite
    public void setUp() throws IOException {
        pb = new PlaywrightBrowser();
        prop = pb.init_prop();
        pg = pb.initBrowser(prop);
        homePage = new HomePage(pg);
    }

    @AfterSuite
    public void tearDown()
    {
        pg.context().browser().close();
    }
}
