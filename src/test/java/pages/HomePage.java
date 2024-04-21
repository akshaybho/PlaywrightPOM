package pages;

import com.microsoft.playwright.Page;

public class HomePage {
    private Page pg;
    // String locators
    private String search = "input[name='search']";
    private String searchIcon = "button.btn.btn-default.btn-lg";

    private String searchPageHeader = "div#content h1";

    public HomePage(Page pg)
    {
        this.pg = pg;
    }
    public String getHomePageTitle()
    {
        String title = pg.title();
        System.out.println(title);
        return title;
    }
    public String getHomePageUrl()
    {
        String url = pg.url();
        System.out.println(url);
        return url;
    }
    public String doSearch(String productName)
    {
        pg.fill(search, productName);
        pg.click(searchIcon);
        //pg.locator(searchPageHeader).waitFor();
        String header = pg.textContent(searchPageHeader);
        System.out.println(header);
        return header;
    }

}
