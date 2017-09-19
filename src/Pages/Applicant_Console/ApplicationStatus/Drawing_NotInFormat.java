package Pages.Applicant_Console.ApplicationStatus;

import Pages.ScrunityCell.SC_Menu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by akshay.pokley on 9/19/2017.
 */
public class Drawing_NotInFormat {

    WebDriver driver;

    @FindBy(xpath = ".//*[@id='a_26751']/span")
    WebElement logo;

    @FindBy(xpath = ".//*[@id='form1']/div[3]//div[5]/div//div[2]/table/tbody/tr/td[2]/div")
    WebElement SeachWithKeyword;

/*------------------------------------------Drwing Status---------------------------------------------------------*/

@FindBy(xpath = ".//*[@id='lblStatus']")
WebElement ProposalStatus;

@FindBy(xpath = ".//*[@id='seTbGeneral']/tbody/tr/td[2]/a[2]")
WebElement Resubmit;
/*------------------------------------------Case Info--------------------------------------------------------*/
@FindBy(xpath = ".//*[@id='lblApplicationNo']")
WebElement fileno;

@FindBy(xpath = ".//*[@id='lblConsultantName']")
WebElement Consultant_Name;

@FindBy(xpath = ".//*[@id='lblCaseType']")
WebElement CaseType;

@FindBy(xpath = ".//*[@id='lblSubmiteDate']")
WebElement LastSubDate;
/*------------------------------------------Remarks-------------------------------------------------------*/
@FindBy(xpath = ".//*[@id='txtRemarks']")
WebElement Remarks;

@FindBy(xpath = ".//*[@id='btnSave']")
WebElement Submit;

@FindBy(xpath = ".//*[@id='trButton']/td[2]/input[2]")
WebElement back;
/*------------------------------------------Attachment process------------------------------------------------------*/

@FindBy(xpath = ".//*[@id='btnAttached']")
WebElement selectFile;

    public Drawing_NotInFormat(WebDriver driver)
    { this.driver=driver;
        PageFactory.initElements(driver,this);
        if(!logo.isDisplayed())
            throw  new IllegalStateException("This is not Drawing not in format");
    }

    /*------------------------------------------Case Info--------------------------------------------------------*/
    public  WebElement getfileno()
    {
        return fileno;
    }

    public WebElement getConsultant_Name()
    {
        return Consultant_Name;
    }

    public WebElement getCaseType()
{
    return CaseType;
}

  public WebElement getLastSubDate()
  {
      return LastSubDate;
  }
    /*------------------------------------------Remarks-------------------------------------------------------*/

    public void setRemarks(String remarks)
    {
        Remarks.sendKeys(remarks);
    }

public void setSubmit()
{
    Submit.click();
}

public void getback()
{
    back.click();
}
/*------------------------------------------Attachment process------------------------------------------------------*/

public void setselectFile()
{
    selectFile.click();
}
/*------------------------------------------Drwing /Resubmit Status---------------------------------------------------------*/

public WebElement getProposalStatus()
{
    return ProposalStatus;
}

public void setResubmit()
{
    Resubmit.click();
}
/*------------------------------------------Drwing Status---------------------------------------------------------*/

    public void setSeachWithKeyword(String seachWithKeyword)
    {
        SeachWithKeyword.sendKeys(seachWithKeyword);
    }

    public WebElement getSeachWithKeyword()
    {
       return SeachWithKeyword;
    }

}
