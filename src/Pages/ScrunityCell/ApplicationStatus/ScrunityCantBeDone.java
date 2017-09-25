package Pages.ScrunityCell.ApplicationStatus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by akshay.pokley on 9/25/2017.
 */
public class ScrunityCantBeDone {



    WebDriver driver;

    @FindBy(xpath = ".//*[@id='a_22634']/span")
    WebElement logo;

    /*------------------------------------------HederTab-----------------------------------------------------*/
    @FindBy(xpath = ".//*[@id='seTbGeneral']/tbody/tr/td[2]/a[5]")
    WebElement Back;

    @FindBy(xpath = ".//*[@id='SetbReports']/tbody/tr/td[2]/a")
    WebElement Scrutiny_Remarks;
    /*-----------------------------------------Status Tab---------------------------------------------------*/
    @FindBy(xpath = ".//*[@id='lblStatus']")
    WebElement ProposalStatus;
    /*--------------------------------------------Filter---------------------------------------------*/
    @FindBy(xpath = ".//*[@id='form1']/div[3]//div[5]/div//div[2]/table/tbody/tr/td[2]/div")
    WebElement SeachWithKeyword;


    public ScrunityCantBeDone (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        if (!logo.isDisplayed())
            throw new IllegalStateException("This is not Scrunity Can't Be Done page");
    }

    /*------------------------------------------HederTab-----------------------------------------------------*/
    public void setBack() {
        Back.click();
    }
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
