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
        loginConsole.setUsername("akshu123");
        loginConsole.setPassword("Akshay85");
        loginConsole.ClickLoginBtn();


    }
}
