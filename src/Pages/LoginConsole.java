package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by akshay.pokley on 5/24/2017.
 */
public class LoginConsole {


    WebDriver driver;
    @FindBy(xpath = ".//*[@id='A1']")
    WebElement RegistrationLink;

    @FindBy(xpath = ".//*[@id='A2']")
    WebElement ForgotPasswordlink;

    @FindBy(xpath = ".//*[@id='tblLoginBox']//tbody/tr[2]/td[1]/img")
    WebElement LoginLogo;

    @FindBy(xpath = ".//*[@id='txtUsername']")
    WebElement Username;

    @FindBy(xpath = ".//*[@id='txtPassword']")
    WebElement Password;

    @FindBy(xpath = ".//*[@id='btnLogin']")
    WebElement loginBtn;

    @FindBy(xpath = ".//*[@id='lblUsername']")
    WebElement LoginFLabel;

    @FindBy(xpath = ".//*[@id='lblPasswd']")
    WebElement passFLabel;




    public LoginConsole(WebDriver driver)
    { this.driver=driver;
        PageFactory.initElements(driver,this);
        if(!LoginLogo.isDisplayed())
            throw  new IllegalStateException("This is not login page");
    }
    public void setRegistrationLink()
    {
        RegistrationLink.click();
    }
    public WebElement getLogo()
    {
        return LoginLogo;
    }
    public WebElement getLoginFLabel()
    {
        return LoginFLabel;
    }
    public WebElement getpassFLabel()
    {
        return passFLabel;
    }
    public void setUsername(String UserNm)
    {
        Username.sendKeys(UserNm);
    }

    public void  setPassword(String passF1)
    {
        Password.sendKeys(passF1);
    }

    public  void ClickLoginBtn()
    {
        loginBtn.click();
    }

    public  void ClickForgotPasswordlink()
    {
        ForgotPasswordlink.click();
    }

    public  WebElement getUsername()
    {
        return Username;
    }
    public  WebElement getPassword() {
        return Password;
    }
    }
