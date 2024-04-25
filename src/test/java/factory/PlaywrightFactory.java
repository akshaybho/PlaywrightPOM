package factory;

import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PlaywrightFactory {
    Properties prop;
    Playwright pw;
    Browser browser;
    BrowserContext browserContext;
    Page pg;
    private static ThreadLocal <Browser> tlBrowser = new ThreadLocal<>();
    private static ThreadLocal <BrowserContext> tlBrowserContext = new ThreadLocal<>();
    private static ThreadLocal <Page> tlpg = new ThreadLocal<>();
    private static ThreadLocal <Playwright> tlpw = new ThreadLocal<>();

    public static Playwright getPlaywright()
    {
        return tlpw.get();
    }
    public static BrowserContext getBrowserContext()
    {
        return tlBrowserContext.get();
    }
    public static Browser getBrowser()
    {
        return tlBrowser.get();
    }
    public static Page getPage()
    {
        return tlpg.get();
    }

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

    /**
     * this method is used to initialize the properties from Config file
     */
    public Properties init_prop() throws IOException {
        FileInputStream ip = new FileInputStream("D:\\ak\\PlaywrightPOM\\src\\test\\resources\\Config.properties");
        prop = new Properties();
        prop.load(ip);
        return prop;
    }

}
