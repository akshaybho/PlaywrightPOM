package pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private Page pg;
    private String emailAddress = "//input[@id='input-email']";
    private String password = "//input[@id='input-password']";
    private String loginBtn = "input[value='Login']";
    private String forgotPassword = "div[class='form-group'] a";
    private String logoutLink = "//a[@class='list-group-item'][normalize-space()='Logout']";
    public LoginPage(Page pg)
    {
        this.pg = pg;
    }

    public String getLoginPageTitle()
    {
        return pg.title();
    }
    public boolean isForgotPasswordExist()
    {
        return pg.isVisible(forgotPassword);
    }
    public boolean doLogin(String emailID, String Password)
    {
        System.out.println("AppCred : "+emailID+":"+Password);
        pg.fill(emailAddress, emailID);
        pg.fill(password, Password);
        pg.click(loginBtn);
        if(pg.isVisible(logoutLink))
        {
            System.out.println("User is successfully logedin");
            return true;
        }
        return false;
    }

}
