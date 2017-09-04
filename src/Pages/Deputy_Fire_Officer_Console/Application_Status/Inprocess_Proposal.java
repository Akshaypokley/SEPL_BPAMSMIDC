package Pages.Deputy_Fire_Officer_Console.Application_Status;

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by babasaheb.londhe on 04-09-17.
 */
public class Inprocess_Proposal {
    WebDriver driver;

   @FindBy(xpath= ".//*[@id='cboArchitect_DropDown']/div/ul/li")
    WebElement Applicant_Name;

   public WebElement getApplicant_Name()
   {
       return Applicant_Name;
   }

    @FindBy(xpath = ".//*[@id='imgOrgHeader']")
    WebElement Formlogo;

    public Inprocess_Proposal(WebDriver driver)
    { this.driver=driver;
        PageFactory.initElements(driver,this);
        if(!Formlogo.isDisplayed())
            throw  new IllegalStateException("This is not Inprocess proposal List Page.");
    }

    /* ---------------Search Button-------------------- */

    @FindBy(xpath= ".//*[@id='btnSearch']")
    WebElement Search_Button;
    public void setSearch_Button()
    {
        Search_Button.click();
    }

     /* ---------------Search box-------------------- */
    @FindBy(xpath= ".//*[@id='form1']/div[3]//div[5]//div[2]/table/tbody/tr/td[2]/div")
    WebElement Search_box;
    public void setSearch_box(String search_box)
    {
        Search_box.sendKeys(search_box);
    }
    public WebElement getSearch_box()
    {
        return Search_box;
    }

    /* ---------------Filter Search Text-------------------- */
   @FindBy (xpath= ".//*[@id='form1']/div[3]//div[5]//div[2]/table/tbody/tr/td[3]/div/button")
    WebElement Filter_SearchText;
   public void setFilter_SearchText (String filter_searchText)
   {
       Filter_SearchText.sendKeys(filter_searchText);
   }
   public WebElement getFilter_SearchText()
   {
       return Filter_SearchText;
   }

    /* ---------------Find -------------------- */
   @FindBy (xpath= ".//*[@id='form1']/div[3]//div[5]//div[2]/table/tbody/tr/td[4]/div/button")
    WebElement Find_button;
   public void setFind_button (String find_button)
    {
        Find_button.sendKeys(find_button);
    }


    /* ---------------Clear Search Text-------------------- */
   @FindBy(xpath= ".//*[@id='form1']/div[3]//div[5]//div[2]/table/tbody/tr/td[5]/div/button")
    WebElement SearchText_Clear;
   public void clearSearchText()
   {
       SearchText_Clear.clear();
   }

   /* ---------------Sort SWC File List-------------------- */
    @FindBy (xpath=".//*[@id='ListProposalGrid']/tbody/tr[1]/td[2]/div/table/tbody/tr[2]/td[5]/u")
    WebElement Sort_SWCFileNo;
   public void clickSort_SWCFileNo()
   {
       Sort_SWCFileNo.click();
   }

    /* ---------------Sort By Case Type-------------------- */
   @FindBy(xpath=".//*[@id='ListProposalGrid']/tbody/tr[1]/td[2]/div/table/tbody/tr[3]/td[7]")
    WebElement Sort_CaseType;
   public  void clickSort_CaseType()
    {
        Sort_CaseType.click();
    }

    /* ---------------Sort Proposal By Date-------------------- */
   @FindBy(xpath=".//*[@id='ListProposalGrid']/tbody/tr[1]/td[2]/div/table/tbody/tr[3]/td[9]")
    WebElement Sort_ProposalDate;
   public void clickSort_ProposalDate()
   {
       Sort_ProposalDate.click();
   }

   /* ---------------Sort Proposal By Date-------------------- */
   @FindBy (xpath= ".//*[@id='ListProposalGrid']/tbody/tr[2]/td[2]//div[1]/table/tbody/tr/td[3]")
    WebElement SWCFileCount;
   public WebElement getSWCFileCount()
   {
       return SWCFileCount;
   }

   /* ---------------Sort Proposal By Date-------------------- */
   @FindBy(xpath=".//*[@id='ListProposalGrid']/tbody/tr[6]/td/div/table/tbody/tr/td[3]/div/b")
    WebElement TotalProposalCount;




}

