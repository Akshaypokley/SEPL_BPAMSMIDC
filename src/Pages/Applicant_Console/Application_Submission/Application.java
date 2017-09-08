package Pages.Applicant_Console.Application_Submission;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by akshay.pokley on 8/29/2017.
 */
public class Application {
    WebDriver driver;

    @FindBy(xpath = ".//*[@id='imgOrgHeader']")
    WebElement Formlogo;
    @FindBy(xpath = "./*//*[@id='txtProposalTitle']")
    WebElement Proposal_Title;

    @FindBy(xpath = "./*//*[@id='txtProposalRisk']")
    WebElement Proposal_Risk;

    @FindBy(xpath = "./*//*[@id='cboProposalType']")
    WebElement Proposal_Type;

    @FindBy(xpath = "./*//*[@id='CboPlotUse']")
    WebElement Proposal_Use;

    @FindBy(xpath = "./*//*[@id='rdoResi']")
    WebElement Double_Height_FSI__Yes;

    @FindBy(xpath = "./*//*[@id='rdoOthers']")
    WebElement Double_Height_FSI__NO;

    @FindBy(xpath = "./*//*[@id='cboCompanyActivitys']")
    WebElement Company_Activity;

    @FindBy(xpath = ".//*[@id='radPossessionDate_dateInput_text']")
    WebElement Plot_Possession_Date;

    @FindBy(xpath = "./*//*[@id='txtRRate_text']")
    WebElement Ready_Reckoner_Rate;

    @FindBy(xpath = "./*//*[@id='CboLocation']")
    WebElement Industrial_Area;

    @FindBy(xpath = "./*//*[@id='cboSPA']")
    WebElement Concerned_SPA;

    @FindBy(xpath = ".//*[@id='txtBuildingHeight_text']")
    WebElement Total_Building_Height;

    @FindBy(xpath = "./*//*[@id='txtPlotArea_text']")
    WebElement Plot_Area;

    @FindBy(xpath = "./*//*[@id='txtPlotNo']")
    WebElement Plot_No;

    @FindBy(xpath = "./*//*[@id='txtBasementArea_text']")
    WebElement Basement_Area;

    @FindBy(xpath = "./*//*[@id='cboMPCB']")
    WebElement MPCB_Consent;

    @FindBy(xpath = "./*//*[@id='txtbuiltUpArea_text']")
    WebElement Gross_Built_Up_Area;

    @FindBy(xpath = "./*//*[@id='txtRCCArea_text']")
    WebElement RCC_Area;

    @FindBy(xpath = "./*//*[@id='txtShed_text']")
    WebElement Shed_Area;

    @FindBy(xpath = "./*//*[@id='TxtOtherArea_text']")
    WebElement Other_Structure_Area;

    @FindBy(xpath = "./*//*[@id='txtFSIArea_text']")
    WebElement Additional_FSI_Area;

    @FindBy(xpath = "./*//*[@id='RdoDCYes']")
    WebElement Drawing_is_PreDCR_Converted__Yes;

    @FindBy(xpath = "./*//*[@id='RdoDCNo']")
    WebElement  Drawing_is_PreDCR_Converted__NO;


    @FindBy(xpath = "./*//*[@id='rdoYes']")
    WebElement Extra_Floor_Height__Yes;

    @FindBy(xpath = "./*//*[@id='rdoNo']")
    WebElement  Extra_Floor_Height__NO;

    @FindBy(xpath = "./*//*[@id='txtApplicantName']")
    WebElement  Applicant_Name;

    @FindBy(xpath = "./*//*[@id='btnSave']")
    WebElement  Save_Submit;
/*---------------------------------------------- Building Deatials --------------------------------------------------------*/
    @FindBy(xpath = ".//*[@id='liBuildingDetails']")
    WebElement  Building_Deatils_tab;

    @FindBy(xpath = ".//*[@id='tgBuildingDetails']/tbody/tr[2]/td[2]/div/div[1]/table/tbody/tr[2]/td[3]")
    WebElement Building_Name;

    @FindBy(xpath = ".//*[@id='tgBuildingDetails']/tbody/tr[2]/td[2]/div/div[1]/table/tbody/tr[2]/td[4]")
    WebElement Building_Use;

    @FindBy(xpath = ".//*[@id='tgBuildingDetails']/tbody/tr[2]/td[2]/div/div[1]/table/tbody/tr[2]/td[5]")
    WebElement Building_Subuse;

    @FindBy(xpath = ".//*[@id='tgBuildingDetails']/tbody/tr[2]/td[2]/div/div[1]/table/tbody/tr[2]/td[6]")
    WebElement Building_Type;

    @FindBy(xpath = "//tbody/tr[2]/td[2]//table/tbody/tr[2]/td[7]")
    WebElement Building_Rows;

    @FindBy(xpath = "//tbody/tr[2]/td[2]//table/tbody/tr[2]/td[8]")
    WebElement Building_Height;

    @FindBy(xpath = "//tbody/tr[2]/td[2]//table/tbody/tr[2]/td[9]")
    WebElement Building_Floors;

    @FindBy(xpath = ".//*[@id='tgBuildingDetails']/tbody/tr[2]/td[2]/div/div[1]/table/tbody/tr[2]/td[10]")
    WebElement Building_Stucher;

    @FindBy(xpath = ".//*[@id='btnSave']")
    WebElement Building_Submit;
/*---------------------------------------------- Drawing Deatials --------------------------------------------------------*/
        @FindBy(xpath = ".//*[@id='liDrawings']")
        WebElement Drawing_Tab;

    @FindBy(xpath = ".//*[@id='AttachFile']/tbody/tr[3]/td/div/table/tbody/tr/td/div")
    WebElement Drawing_Data;



/*---------------------------------------------- Document Deatials --------------------------------------------------------*/

        @FindBy(xpath = ".//*[@id='liDocuments']")
        WebElement Document_Tab;

        @FindBy(xpath = ".//*[@id='RadTabStrip1']/div/ul/li/a/span/span")
        WebElement Document_Types;

        @FindBy(xpath = ".//*[@id='btnSave1']")
        WebElement Submit_Btn;



    public Application(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        if (!Formlogo.isDisplayed())
            throw new IllegalStateException("This is not Applicant Form");
    }

 /*---------------------------------------------- Document Deatials --------------------------------------------------------*/

 public void ClickSubmit_Btn()
 {
     Submit_Btn.click();
 }
    public void ClickDocument_Types()
    {
        Document_Types.click();
    }

    public WebElement getDocument_Types()
    {
        return Document_Types;
    }

 public void ClickDocument_Tab()
 {
     Document_Tab.click();
 }
/*---------------------------------------------- Drawing Deatials --------------------------------------------------------*/
    public void ClickDrawing_Tab()
    {
        Drawing_Tab.click();
    }

    public WebElement  getDrawing_Data()
    {
        return  Drawing_Data;
    }



/*---------------------------------------------- Building Deatials --------------------------------------------------------*/


public void ClickBuilding_Submit()
{
    Building_Submit.click();
}

    public WebElement getBuilding_Strucher()
    {
        return Building_Stucher;
    }


    public void setBuilding_Floors(String building_floors)
    {
        Building_Floors.sendKeys(building_floors);
    }

    public WebElement getBuilding_Floors()
    {
        return Building_Floors;
    }



    public void setBuilding_Height(String building_height)
    {
        Building_Height.sendKeys(building_height);
    }

    public WebElement getBuilding_Height()
    {
        return Building_Height;
    }


    public void setBuilding_Rows(String building_rows)
    {
        Building_Rows.sendKeys(building_rows);
     }

    public WebElement getBuilding_Rows()
    {
return Building_Rows;
    }

    public WebElement getBuilding_Type()
    {
        return Building_Type;
    }


    public WebElement getBuilding_Subuse()
    {
        return Building_Subuse;
    }


   public WebElement getBuilding_Use()
   {
       return Building_Use;
   }
  public void ClickBuildig_Deatils_Tab()
    {
        Building_Deatils_tab.click();
    }

    public void setBuilding_Name(String building_name)
    {
        Building_Name.sendKeys(building_name);
    }

    public WebElement getBuilding_Name()
    {
   return  Building_Name;
    }
/*---------------------------------------------- Applicant Deatials --------------------------------------------------------*/

    public  void clickSave_Submit()
    {
        Save_Submit.click();
    }

    public void setApplicant_Name( String applicant_name)
    {
        Applicant_Name.sendKeys(applicant_name);
    }

    public WebElement getApplicant_Name()
    {
      return   Applicant_Name;
    }

    public  void clickExtra_Floor_Height__NO()
    {
        Extra_Floor_Height__NO.click();
    }


    public  void ClickExtra_Floor_Height__Yes()
    {
        Extra_Floor_Height__Yes.click();
    }


    public  void clickDrawing_is_PreDCR_Converted__NO()
    {
        Drawing_is_PreDCR_Converted__NO.click();
    }


    public  void ClickDrawing_is_PreDCR_Converted__Yes()
    {
        Drawing_is_PreDCR_Converted__Yes.click();
    }

    public void setAdditional_FSI_Area( String additional_fsi_area)
    {
        Additional_FSI_Area.sendKeys(additional_fsi_area);
    }


    public WebElement getAdditional_FSI_Area()
    {
        return  Additional_FSI_Area;
    }

    public void setOther_Structure_Area( String other_structure_area)
    {
        Other_Structure_Area.sendKeys(other_structure_area);
    }


    public WebElement getOther_Structure_Area()
    {
        return  Other_Structure_Area;
    }
    public void setShed_Area( String shed_area)
    {
        Shed_Area.sendKeys(shed_area);
    }


    public WebElement getShed_Area()
    {
        return   Shed_Area;
    }
    public void setRCC_Area( String rcc_area)
    {
        RCC_Area.sendKeys(rcc_area);
    }
     public WebElement getRCC_Area()
    {
      return   RCC_Area;
    }
    public void setGross_Built_Up_Area( String gross_built_up_area)
        {
            Gross_Built_Up_Area.sendKeys(gross_built_up_area);
    }

    public WebElement getGross_Built_Up_Area()
    {
        return Gross_Built_Up_Area;
    }
    public void selectMPCB_Consent( String mPCB_Consent)
    {
        Select combo=new Select(MPCB_Consent);
        combo.selectByVisibleText(mPCB_Consent);
    }

    public void setBasement_Area( String basement_area)
    {
        Basement_Area.sendKeys(basement_area);
    }

    public WebElement getBasement_Area()
    {
      return   Basement_Area;
    }

    public void setPlot_No( String plot_no)
    {
            Plot_No.sendKeys(plot_no);
    }

    public WebElement getPlot_No()
    {
        return Plot_No;
    }

    public void setPlot_Area( String plot_area)
    {
        Plot_Area.sendKeys(plot_area);
    }

    public WebElement getPlot_Area()
    {
      return   Plot_Area;
    }

    public void setTotal_Building_Height( String total_building_height)
    {
        Total_Building_Height.sendKeys(total_building_height);
    }

    public WebElement getTotal_Building_Height()
    {
       return Total_Building_Height;
    }

    public void selectConcerned_SPA( String concerned_sPA)
    {
        Select combo=new Select(Concerned_SPA);
        combo.selectByVisibleText(concerned_sPA);
    }

    public void selectIndustrial_Area( String industrial_area)
    {
        Select combo=new Select(Industrial_Area);
        combo.selectByVisibleText(industrial_area);
    }


    public void setReady_Reckoner_Rate( String ready_reckoner_rate)
    {
        Ready_Reckoner_Rate.sendKeys(ready_reckoner_rate);
    }

    public WebElement getReady_Reckoner_Rate()
    {
      return   Ready_Reckoner_Rate;
    }

    public void setPlot_Possession_Date( String plot_possession_date)
    {
        Plot_Possession_Date.sendKeys(plot_possession_date);
    }

    public WebElement setPlot_Possession_Date()
    {
        return Plot_Possession_Date;
    }

    public void selectCompany_Activity( String company_activity)
    {
        Select combo=new Select(Company_Activity);
        combo.selectByVisibleText(company_activity);
    }


    public  void ClickDouble_Height_FSI__NO()
    {
        Double_Height_FSI__NO.click();
    }


    public  void ClickDouble_Height_FSI__Yes()
    {
        Double_Height_FSI__Yes.click();
    }

    public void selectProposal_Use( String proposal_use)
    {
        Select combo=new Select(Proposal_Use);
        combo.selectByVisibleText(proposal_use);
    }


    public void selectProposal_Type( String proposal_type)
    {
        Select combo=new Select(Proposal_Type);
        combo.selectByVisibleText(proposal_type);
    }


    public void setProposal_Risk( String proposal_risk)
    {
        Proposal_Risk.sendKeys(proposal_risk);
    }

    public WebElement getProposal_Risk()
    {
        return Proposal_Risk;
    }
    public void setProposal_Title( String proposal_title)
    {
        Proposal_Title.sendKeys(proposal_title);
    }

    public WebElement getProposal_Title( )
    {
       return Proposal_Title;
    }
}
