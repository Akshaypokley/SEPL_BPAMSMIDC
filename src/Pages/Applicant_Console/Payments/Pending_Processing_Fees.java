package Pages.Applicant_Console.Payments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by akshay.pokley on 9/16/2017.
 */
public class Pending_Processing_Fees {

    WebDriver driver;

    @FindBy(xpath = ".//*[@id='lblFrom']")
    WebElement logo;

    @FindBy(xpath = ".//*[@id='rdochq']")
    WebElement PaymentMode_RTGSNEFT;

    @FindBy(xpath = ".//*[@id='rdOnlinePayment']")
    WebElement PaymentMode_Gateway;

    @FindBy(xpath = ".//*[@id='txtPayOrderNo']")
    WebElement UTR_No;

    @FindBy(xpath = ".//*[@id='cboBankName']")
    WebElement Bank_Name;

    @FindBy(xpath = ".//*[@id='txtChequeBranch']")
    WebElement Branch_Name;

    @FindBy(xpath = ".//*[@id='SetB']/tbody/tr/td[2]/a[1]")
    WebElement Save_Submit;

    public Pending_Processing_Fees(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        if (!logo.isDisplayed())
            throw new IllegalStateException("This is not Payment Details page");
    }

    public void setSave_Submit()
    {
        Save_Submit.click();
    }

    public void setPaymentMode_RTGSNEFT()
    {
        PaymentMode_RTGSNEFT.click();
    }

    public void setPaymentMode_Gateway()
    {
        PaymentMode_Gateway.click();
    }

    public void setUTR_No(String utr_no)
    {
       UTR_No.sendKeys(utr_no);
    }

    public void setBank_Name(String bank_name)
    {
        Select combo=new Select(Bank_Name);
        combo.selectByVisibleText(bank_name);
    }

    public void setBranch_Name(String branch_name)
    {
        Branch_Name.sendKeys(branch_name);
    }
}
