package Pages.Chief_Fire_Officer_Console.Application_Status;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by akshay.pokley on 9/2/2017.
 */
public class InprocessPlan {
    WebDriver driver;

    @FindBy(xpath = ".//*[@id='imgOrgHeader']")
    WebElement Formlogo;

    /************************* Filter's**********************/

    @FindBy(xpath = ".//*[@id='cboArchitect_Input']")
    WebElement Select_ArchitectName;

    @FindBy(xpath = ".//*[@class='container-fluid']//div/div[2]/input")
    WebElement SeachBtn;

    @FindBy(xpath = ".//*[@id='form1']/div[3]//div[5]/div//div[2]/table/tbody/tr/td[2]/div")
    WebElement SeachWithKeyword;

    @FindBy(xpath = ".//*[@id='form1']/div[3]//div[5]//div[2]/table/tbody/tr/td/div/button")
    WebElement Filters;
    /************************* File Status**********************/

    @FindBy(xpath = "html/body/form/div[4]//div[2]/div//label[9]")
    WebElement FileStaus;

    @FindBy(xpath = ".//*[@id='seTbGeneral']/tbody/tr/td[2]/a[1]/img")
    WebElement Add_NoteSheet;

    @FindBy(xpath = ".//*[@id='seTbGeneral']/tbody/tr/td[2]/a[3]/img")
    WebElement ApproveProposal;

    @FindBy(xpath = ".//*[@id='liPaymentDetails']")
    WebElement PaymentsTab;

    @FindBy(xpath = "//div[6]/div[11]//table/tbody/tr[2]/td[2]//div[1]/table/tbody/tr/td[4]")
    WebElement ChallanType;

    @FindBy(xpath = "//div[6]/div[11]//table/tbody/tr[2]/td[2]//div[1]/table/tbody/tr/td[5]")
    WebElement PaymentStatus;

    public InprocessPlan(WebDriver driver)
    { this.driver=driver;
        PageFactory.initElements(driver,this);
        if(!Formlogo.isDisplayed())
            throw  new IllegalStateException("This is not Home page");
    }

    /************************* File Status**********************/

    public WebElement getPaymentStatus()
    {
        return PaymentStatus;
    }

    public WebElement getChallanType()
    {
        return ChallanType;
    }

    public void ClickPaymentsTab()
    {
        PaymentsTab.click();
    }


    public void ClickApproveProposal()
    {
        ApproveProposal.click();
    }

    public void ClickAdd_NoteSheet()
    {
        Add_NoteSheet.click();
    }

public WebElement getFileStaus()
{
    return  FileStaus;
}

    /************************* Filter's**********************/

    public WebElement getFilters()
    {
        return Filters;
    }

    public WebElement getSeachWithKeyword()
    {
       return SeachWithKeyword ;
    }

    public void setSeachWithKeyword(String seachWithKeyword)
    {
        SeachWithKeyword.sendKeys(seachWithKeyword);
    }

    public void ClickSeachBtn()
    {
        SeachBtn.click();
    }


    public WebElement getSelect_ArchitectName()
   {
       return Select_ArchitectName;
   }

    public void  setSelect_ArchitectName(String select_architectName)
    {
        Select_ArchitectName.clear();
        Select_ArchitectName.sendKeys(select_architectName);
    }


    public WebElement getFormlogo()
    {
        return Formlogo;
    }
}
