package Pages.SPA_ConsoleActivity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by akshay.pokley on 9/26/2017.
 */
public class SPA_Menu {

    WebDriver driver;

    @FindBy(xpath = ".//*[@id='lblDesign']")
    WebElement Logo;

    @FindBy(xpath = ".//*[@id='cboArchitect_Input']")
    WebElement Select_ArchitectName;
    @FindBy(xpath = ".//*[@class='container-fluid']//div/div[2]/input")
    WebElement SeachBtn;
 /*---------------------------------------Application Status--------------------------------------------------------*/

    @FindBy(xpath = ".//*[@id='MainUL']/li[3]/a/div/div[2]/span")
    WebElement ApplicationTab;

    @FindBy(xpath = ".//*[@id='a_19634']/span")
    WebElement RejectedFile;

    @FindBy(xpath = ".//*[@id='a_19652']/span")
    WebElement Total_Files;

    @FindBy(xpath = ".//*[@id='a_19656']/span")
    WebElement Approval_Pending;

    @FindBy(xpath = ".//*[@id='a_19658']/span")
    WebElement Approved_Files;
    /*---------------------------------------Scrunity--------------------------------------------------------*/
    @FindBy(xpath = ".//*[@id='MainUL']/li[4]/a/div/div[2]/span")
    WebElement ScrunityTab;

    @FindBy(xpath = ".//*[@id='a_19697']/span")
    WebElement ScrunityVerify_Pending;

    @FindBy(xpath = ".//*[@id='a_19698']/span")
    WebElement  ScrunityVerify_Done;

    @FindBy(xpath = ".//*[@id='a_19703']/span")
    WebElement DrawingFailin_rules;

    /*---------------------------------------DashboardTest--------------------------------------------------------*/
    @FindBy(xpath = ".//*[@id='MainUL']/li[1]/a/div/div[2]/span")
    WebElement DashboardTab;

    @FindBy(xpath = ".//*[@id='a_19601']/span")
    WebElement Dashboard;

 /*---------------------------------------Submission--------------------------------------------------------*/
    @FindBy(xpath = ".//*[@id='MainUL']/li[2]/a/div/div[2]/span")
    WebElement SubmissionTab;

    @FindBy(xpath = ".//*[@id='a_19629']/span")
    WebElement SubmittedApllication;

    public SPA_Menu(WebDriver driver)
    { this.driver=driver;
        PageFactory.initElements(driver,this);
        if(!Logo.isDisplayed())
            throw  new IllegalStateException("This is not SPA page");
    }
    public void ClickSeachBtn()
    {
        SeachBtn.click();
    }
    public void  setSelect_ArchitectName(String select_architectName)
    {
        Select_ArchitectName.clear();
        Select_ArchitectName.sendKeys(select_architectName);
    }
 /*---------------------------------------Application Status--------------------------------------------------------*/

    public void setApproved_Files()
    {
        Approved_Files.click();
    }

    public void setApproval_Pending()
    {
        Approval_Pending.click();
    }

    public void setRejectedFile()
    {
        RejectedFile.click();
    }

    public void setTotal_Files()
    {
        Total_Files.click();
    }

    public void setApplicationTab()
    {
        ApplicationTab.click();
    }

/*---------------------------------------ScrunityCell--------------------------------------------------------*/

    public void setScrunityTab()
    {
        ScrunityTab.click();
    }
    public void setScrunityVerify_Pending()
    {
        ScrunityVerify_Pending.click();
    }

    public void setScrunityVerify_Done()
    {
        ScrunityVerify_Done.click();
    }

    public  void setDrawingFailin_rules()
    {
        DrawingFailin_rules.click();
    }
 /*---------------------------------------Submission--------------------------------------------------------*/


    public void setSubmissionTab()
    {
        SubmissionTab.click();
    }
    public void setSubmittedApllication()
    {
        SubmittedApllication.click();
    }

/*---------------------------------------DashboardTest--------------------------------------------------------*/

    public void setDashboard()
    {
        Dashboard.click();
    }
    public void setDashboardTab()
    {
        DashboardTab.click();
    }


}
