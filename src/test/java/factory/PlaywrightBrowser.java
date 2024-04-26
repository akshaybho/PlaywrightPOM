package factory;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PlaywrightBrowser extends PlaywrightFactory {
    Properties prop;
    public Page initBrowser(Properties prop)
    {
        String browserName = prop.getProperty("browser").trim();

        System.out.println("Browsername is : "+browserName);

        //pw = Playwright.create();
        tlpw.set(Playwright.create());

        switch(browserName.toLowerCase())
        {
            case "chromium":
                //browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;

            case "firefox":
                //browser = pw.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                tlBrowser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;

            case "safari":
                //browser = pw.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                tlBrowser.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;

            case "chrome":
                //browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)));
                break;

            default:
                System.out.println("please pass the right browser name .......");
                break;
        }
        // browserContext = browser.newContext();
        tlBrowserContext.set(getBrowser().newContext());
        //pg = browserContext.newPage();
        tlpg.set(getBrowserContext().newPage());
        //pg.navigate(prop.getProperty("url").trim());
        getPage().navigate(prop.getProperty("url").trim());

        return getPage();
    }
    public Properties init_prop() throws IOException {
        FileInputStream ip = new FileInputStream("D:\\ak\\PlaywrightPOM\\src\\test\\resources\\Config.properties");
        prop = new Properties();
        prop.load(ip);
        return prop;
    }
}
