package Pages.Applicant_Console;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
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
    WebElement  SelectProposal;
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

    public ApplicantMenu(WebDriver driver)
    { this.driver=driver;
        PageFactory.initElements(driver,this);
        if(!MenuLogo.isDisplayed())
            throw  new IllegalStateException("This is not Home page");
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
