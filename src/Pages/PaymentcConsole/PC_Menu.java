package Pages.PaymentcConsole;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by akshay.pokley on 9/15/2017.
 */
public class PC_Menu {


    WebDriver driver;
    @FindBy(xpath = ".//*[@id='lblDesign']")
    WebElement logo;

    @FindBy(xpath = ".//*[@id='MainUL']/li[3]/a/div/div[2]/span")
    WebElement SupportClick;

    @FindBy(xpath = ".//*[@id='a_26917']/span")
    WebElement Paychallanclick;

    public PC_Menu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        if (!logo.isDisplayed())
            throw new IllegalStateException("This is not support page");
    }


    public void ClickSupportClick()
    {
        SupportClick.click();
    }

    public void  ClickPaychallanclick()
    {Paychallanclick.click();}

}
