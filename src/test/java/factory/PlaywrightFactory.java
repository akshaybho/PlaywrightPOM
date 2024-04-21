package factory;

import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PlaywrightFactory {

    Properties prop;
    public Page initBrowser(Properties prop)
    {
        String browserName = prop.getProperty("browser").trim();
        Playwright pw;
        Browser browser = null;
        BrowserContext browserContext;
        Page pg;
        System.out.println("Browsername is : "+browserName);

        pw = Playwright.create();

        switch(browserName.toLowerCase())
        {
            case "chromium":
                browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;

            case "firefox":
                browser = pw.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;

            case "safari":
                browser = pw.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;

            case "chrome":
                browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;

            default:
                System.out.println("please pass the right browser name .......");
                break;
        }
        browserContext = browser.newContext();
        pg = browserContext.newPage();
        pg.navigate(prop.getProperty("url").trim());

        return pg;
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
