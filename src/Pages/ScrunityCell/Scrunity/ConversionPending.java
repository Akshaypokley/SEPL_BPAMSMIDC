package Pages.ScrunityCell.Scrunity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by akshay.pokley on 9/18/2017.
 */
public class ConversionPending {

    WebDriver driver;

    @FindBy(xpath = ".//*[@id='a_22675']/span")
    WebElement logo;

    /*------------------------------------------HederTab-----------------------------------------------------*/
    @FindBy(xpath = ".//*[@id='seTbGeneral']/tbody/tr/td[2]/a[1]")
    WebElement Upload_DWG_file;

    @FindBy(xpath = ".//*[@id='seTbGeneral']/tbody/tr/td[2]/a[2]")
    WebElement Run_PreDCR;

    @FindBy(xpath = ".//*[@id='seTbGeneral']/tbody/tr/td[2]/a[3]")
    WebElement Change_Status;

    @FindBy(xpath = ".//*[@id='seTbGeneral']/tbody/tr/td[2]/a[4]")
    WebElement Back;

    @FindBy(xpath = ".//*[@id='SetbReports']/tbody/tr/td[2]/a")
    WebElement Scrutiny_Remarks;
    /*-----------------------------------------Status Tab---------------------------------------------------*/
    @FindBy(xpath = ".//*[@id='lblStatus']")
    WebElement ProposalStatus;
/*--------------------------------------------Filter---------------------------------------------*/
    @FindBy(xpath = ".//*[@id='form1']/div[3]//div[5]/div//div[2]/table/tbody/tr/td[2]/div")
    WebElement SeachWithKeyword;

/*--------------------------------------------Change Status ---------------------------------------------*/
    @FindBy(xpath = ".//*[@id='cboStatus']")
    WebElement selectStatus;

    @FindBy(xpath = ".//*[@id='txtRemarks']")
    WebElement Remarks;

    @FindBy(xpath = ".//*[@id='btnSubmited']")
    WebElement Submit;
    public ConversionPending(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        if (!logo.isDisplayed())
            throw new IllegalStateException("This is not Conversion pending page");
    }

    /*--------------------------------------------Change Status ---------------------------------------------*/

    public void setselectStatus(String selectStatus1)
    {
        Select combo = new Select (selectStatus) ;
        combo.selectByValue(selectStatus1);
    }

    public void setRemarks(String remarks)
    {
        Remarks.sendKeys(remarks);
    }

    public WebElement getRemarks()
    {
       return Remarks;
    }

    public void setSubmit()
    {
        Submit.click();
    }




/*------------------------------------------HederTab-----------------------------------------------------*/

    public void setScrutiny_Remarks() {
        Scrutiny_Remarks.click();
    }

    public void setBack() {
        Back.click();
    }

    public void setChange_Status() {
        Change_Status.click();
    }

    public void setRun_PreDCR() {
        Run_PreDCR.click();
    }

    public void setUpload_DWG_file() {
        Upload_DWG_file.click();
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