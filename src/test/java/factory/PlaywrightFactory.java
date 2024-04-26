package factory;

import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PlaywrightFactory {
    protected static ThreadLocal <Browser> tlBrowser = new ThreadLocal<>();
    protected static ThreadLocal <BrowserContext> tlBrowserContext = new ThreadLocal<>();
    protected static ThreadLocal <Page> tlpg = new ThreadLocal<>();
    protected static ThreadLocal <Playwright> tlpw = new ThreadLocal<>();

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

}
