package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by akshay.pokley on 8/28/2017.
 */
public class ForgotPasswordConsole {

    WebDriver driver;
    @FindBy(xpath = ".//*[@id='A1']")
    WebElement ForgotPasswrdLogo;

    @FindBy(xpath = ".//*[@id='txtLoginId']")
    WebElement LoginID;

    @FindBy(xpath = ".//*[@id='txtMobNo']")
    WebElement MobileNo;

    @FindBy(xpath = ".//*[@id='txtEmailid']")
    WebElement EmailID;


    @FindBy(xpath = ".//*[@id='btnSubmit']")
    WebElement SubmitBtn;


    public ForgotPasswordConsole(WebDriver driver)
    { this.driver=driver;
        PageFactory.initElements(driver,this);
        if(!ForgotPasswrdLogo.isDisplayed())
            throw  new IllegalStateException("This is not login page");
    }

    public void setSubmitBtn()
    {SubmitBtn.click();}
    public WebElement getRegistrationLink()
    {
        return ForgotPasswrdLogo;
    }

    public void setLoginID(String loginID)
    {
        LoginID.sendKeys(loginID);
    }

    public WebElement getLoginID()
    {
        return LoginID;
    }

    public void setEmailID(String emailID)
    {
        EmailID.sendKeys(emailID);
    }

    public WebElement getEmailID()
    {
        return EmailID;
    }
    public void setMobileNo(String mobileNo)
    {
        MobileNo.sendKeys(mobileNo);
    }

    public WebElement getMobileNo()
    {
        return MobileNo;
    }
}
