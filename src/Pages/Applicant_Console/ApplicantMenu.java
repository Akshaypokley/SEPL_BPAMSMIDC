package Pages.Applicant_Console;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by akshay.pokley on 8/29/2017.
 */
public class ApplicantMenu {

    WebDriver driver;

    @FindBy(xpath = ".//*[@id='imgOrgHeader']")
    WebElement MenuLogo;

    /*ApplicationSubmission*/
    @FindBy(xpath = "//li[1]/a/div/div[2]/span")
    WebElement ApplicationSubmission;

    @FindBy(xpath = ".//*[@id='a_26725']/span")
    WebElement Application;

    @FindBy(xpath = ".//*[@id='a_26726']/span")
    WebElement Submitted_Application;

    @FindBy(xpath = ".//*[@id='btnNewApplication']")
    WebElement SelectProposal;
/*-------------------------------------------------Payments-------------------------------------------------*/

    @FindBy(xpath = ".//*[@id='MainUL']/li[3]/a/div/div[2]/span")
    WebElement PaymentsTab;

    @FindBy(xpath = ".//*[@id='a_26766']/span")
    WebElement Pending_Processing_FeesFPlan;

    @FindBy(xpath = ".//*[@id='a_26770']/span")
    WebElement Pending_Processing_Fees;

    @FindBy(xpath = ".//*[@id='a_26767']/span")
    WebElement Paid_Processing_FeesFPlan;

    @FindBy(xpath = ".//*[@id='a_26771']/span")
    WebElement PaidProcessingFees;
    /*-------------------------------------------------Application Status-------------------------------------------------*/
    @FindBy(xpath = ".//*[@id='MainUL']/li[2]/a/div/div[2]/span")
    WebElement ApplicationStatus;

    @FindBy(xpath = ".//*[@id='a_26742']/span")
    WebElement ObjectedFile;


    @FindBy(xpath = ".//*[@id='a_26743']/span")
    WebElement ApprovedFile;

    @FindBy(xpath = ".//*[@id='a_26745']/span")
    WebElement RejectedFile;

    @FindBy(xpath = ".//*[@id='a_26747']/span")
    WebElement ObjectedFiles_Fire;

    @FindBy(xpath = ".//*[@id='a_26751']/span")
    WebElement Drawing_NotInformat;

    @FindBy(xpath = ".//*[@id='a_26752']/span")
    WebElement Scrunity_notbeDone;

    @FindBy(xpath = ".//*[@id='a_26753']/span")
    WebElement DrawingFailIn_Rule;


    public ApplicantMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        if (!MenuLogo.isDisplayed())
            throw new IllegalStateException("This is not Home page");
    }
/*-------------------------------------------------Application Status-------------------------------------------------*/
public void setDrawingFailIn_Rule()
{
    DrawingFailIn_Rule.click();
}
public void setScrunity_notbeDone()
{
    Scrunity_notbeDone.click();
}

public void setDrawing_NotInformat()
{
    Drawing_NotInformat.click();
}
public void setObjectedFiles_Fire()
{
    ObjectedFiles_Fire.click();
}

public void setRejectedFile()
{
    RejectedFile.click();
}

public void setApprovedFile()
{
    ApprovedFile.click();
}

    public void setObjectedFile()

    {
        ObjectedFile.click();
    }

public void setApplicationStatus()
{
    ApplicationStatus.click();
}


/*-------------------------------------------------Payments-------------------------------------------------*/
public void ClickPaymentsTab()
{
    PaymentsTab.click();
}

    public void ClickPending_Processing_FeesFPlan()
    {
        Pending_Processing_FeesFPlan.click();
    }

    public void ClickPending_Processing_Fees()
    {
        Pending_Processing_Fees.click();
    }

    public void ClickPaid_Processing_FeesFPlan()
    {
        Paid_Processing_FeesFPlan.click();
    }

    public void ClickPaidProcessingFees()
    {
        PaidProcessingFees.click();
    }
/*-------------------------------------------------Application submission-------------------------------------------------*/

    public void ClickSelectProposal()
    {
        SelectProposal.click();
    }
    public void ClickApplicationSubmission()
    {
        ApplicationSubmission.click();
    }

    public void ClickApplication()
    {
        Application.click();
    }


    public void ClickSubmitted_Application()
    {
        Submitted_Application.click();
    }
    public  WebElement getMenuLogo()
    {
        return MenuLogo;
    }
}
