package Pages.Chief_Fire_Officer_Console;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by akshay.pokley on 9/2/2017.
 */
public class CFOC_Menu {


    WebDriver driver;

    @FindBy(xpath = ".//*[@id='imgOrgHeader']")
    WebElement MenuLogo;

    /*ApplicationStatus*/
   /* @FindBy(xpath = "//li[1]/a/div/div[2]/span")
    WebElement ApplicationSubmission;*/

    @FindBy(xpath = ".//*[@id='a_18433']/span")
    WebElement InprocessPlan;

    @FindBy(xpath = ".//*[@id='a_18434']/span")
    WebElement ObjectedFile;

    @FindBy(xpath = ".//*[@id='a_18443']/span")
    WebElement  Approval;

    @FindBy(xpath = ".//*[@id='a_18444']/span")
    WebElement  TotalFile;

    @FindBy(xpath = ".//*[@id='a_18444']/span")
    WebElement  SelectFile;

    public CFOC_Menu  (WebDriver driver)
    { this.driver=driver;
        PageFactory.initElements(driver,this);
        if(!MenuLogo.isDisplayed())
            throw  new IllegalStateException("This is not Home page");
    }
    public void ClickApproval()
    {
        Approval.click();
    }

    public void ClickTotalFile()
    {
        TotalFile.click();
    }

    /*
    public void ClickApplicationSubmission()
    {
        ApplicationSubmission.click();
    }*/

    public void ClickInprocessPlan()
    {
        InprocessPlan.click();
    }


    public void ClickObjectedFile()
    {
        ObjectedFile.click();
    }
    public  WebElement getMenuLogo()
    {
        return MenuLogo;
    }
}


