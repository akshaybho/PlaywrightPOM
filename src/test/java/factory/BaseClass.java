package factory;

import com.microsoft.playwright.Page;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pages.HomePage;

import java.io.IOException;
import java.util.Properties;

public class BaseClass {

    Page pg;
    PlaywrightFactory pf;

    protected Properties prop;
    protected HomePage homePage;
    @BeforeSuite
    public void setUp() throws IOException {
        pf = new PlaywrightFactory();
        prop = pf.init_prop();
        pg = pf.initBrowser(prop);
        homePage = new HomePage(pg);
    }

    @AfterSuite
    public void tearDown()
    {
        pg.context().browser().close();
    }
}
