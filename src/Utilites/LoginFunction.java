package Utilites;

import Pages.LoginConsole;
import org.openqa.selenium.WebDriver;

/**
 * Created by laxmikant on 18/05/2017.
 */
public class LoginFunction {
    static WebDriver driver;

    public static void LogFunction(WebDriver driver)
    {

        LoginConsole loginConsole =new LoginConsole(driver);
        loginConsole.setUsername("aditi@midc.com");
        loginConsole.setPassword("Aditi@123");
        loginConsole.ClickLoginBtn();


    }

    public static void CFO_LogFunction(WebDriver driver)
    {

        LoginConsole loginConsole =new LoginConsole(driver);
        loginConsole.setUsername("Cfofficer");
        loginConsole.setPassword("Admin@123");
        loginConsole.ClickLoginBtn();


    }


    public static void PC_LogFunction(WebDriver driver)
    {

        LoginConsole loginConsole =new LoginConsole(driver);
        loginConsole.setUsername("support@1");
        loginConsole.setPassword("Admin@123");
        loginConsole.ClickLoginBtn();


    }

    public static void SC_LogFunction(WebDriver driver)
    {

        LoginConsole loginConsole =new LoginConsole(driver);
        loginConsole.setUsername("scrutinycell8");
        loginConsole.setPassword("Admin@123");
        loginConsole.ClickLoginBtn();


    }
}
