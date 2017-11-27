package Pages.SPA_ConsoleActivity.Application_Submission;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Submitted_Application {



    WebDriver driver;

    @FindBy(xpath = ".//*[@id='a_19629']/span")
    WebElement logo;

    /*------------------------------------------HederTab-----------------------------------------------------*/


    @FindBy(xpath = ".//*[@id='SetbReports']/tbody/tr/td[2]/a")
    WebElement Scrutiny_Remarks;
    /*-----------------------------------------Status Tab---------------------------------------------------*/
    @FindBy(xpath = ".//*[@id='lblStatus']")
    WebElement ProposalStatus;
    /*--------------------------------------------Filter---------------------------------------------*/
    @FindBy(xpath = ".//*[@id='form1']/div[3]//div[5]/div//div[2]/table/tbody/tr/td[2]/div")
    WebElement SeachWithKeyword;


    public Submitted_Application (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        if (!logo.isDisplayed())
            throw new IllegalStateException("This is not Submitted application page");
    }

    /*------------------------------------------HederTab-----------------------------------------------------*/

    public void setScrutiny_Remarks() {
        Scrutiny_Remarks.click();
    }

/*-----------------------------------------Status Tab---------------------------------------------------*/

    public WebElement getProposalStatus()
    {
        return  ProposalStatus;
    }
/*--------------------------------------------Filter---------------------------------------------*/

    public WebElement getSeachWithKeyword()
    {
        return SeachWithKeyword;
    }





}
