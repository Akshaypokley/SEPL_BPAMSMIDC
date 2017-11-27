package Pages.ScrunityCell;

import Pages.Applicant_Console.ApplicantMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by akshay.pokley on 9/18/2017.
 */
public class SC_Menu {

    WebDriver driver;

    @FindBy(xpath = ".//*[@id='lblDesign']")
    WebElement Logo;

    @FindBy(xpath = ".//*[@id='cboArchitect_Input']")
    WebElement Select_ArchitectName;
    @FindBy(xpath = ".//*[@class='container-fluid']//div/div[2]/input")
    WebElement SeachBtn;
 /*---------------------------------------Application Status--------------------------------------------------------*/

    @FindBy(xpath = ".//*[@id='MainUL']/li[1]/a/div/div[2]/span")
    WebElement ApplicationTab;

    @FindBy(xpath = ".//*[@id='a_22633']/span")
    WebElement Drawing_Not_In_Format;

    @FindBy(xpath = ".//*[@id='a_22634']/span")
    WebElement Scrutiny_Not_Done;
/*---------------------------------------Scrunity--------------------------------------------------------*/
    @FindBy(xpath = ".//*[@id='MainUL']/li[2]/a/div/div[2]/span")
    WebElement ScrunityTab;

    @FindBy(xpath = ".//*[@id='a_22675']/span")
    WebElement ConversionPending;

    @FindBy(xpath = ".//*[@id='a_22676']/span")
    WebElement ConversionDone;

    @FindBy(xpath = ".//*[@id='a_22677']/span")
    WebElement ScrunityPending;

    @FindBy(xpath = ".//*[@id='a_22678']/span")
    WebElement ScrunityDone;

    @FindBy(xpath = ".//*[@id='a_22681']/span")
    WebElement ConversionP_Resubmitted;

    @FindBy(xpath = ".//*[@id='a_22681']/span")
    WebElement ConversionP_30000;
/*---------------------------------------DashboardTest--------------------------------------------------------*/
    @FindBy(xpath = ".//*[@id='MainUL']/li[3]/a/div/div[2]/span")
    WebElement DashboardTab;

    @FindBy(xpath = ".//*[@id='a_22686']/span")
    WebElement Dashboard;

    public SC_Menu(WebDriver driver)
    { this.driver=driver;
        PageFactory.initElements(driver,this);
        if(!Logo.isDisplayed())
            throw  new IllegalStateException("This is not Scrunity page");
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

 public void setScrutiny_Not_Done()
 {
     Scrutiny_Not_Done.click();
 }

 public void setDrawing_Not_In_Format()
  {
      Drawing_Not_In_Format.click();
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
public void setConversionP_30000()
{
    ConversionP_30000.click();
}

public void setConversionP_Resubmitted()
{
    ConversionP_Resubmitted.click();
}

public  void setScrunityDone()
{
    ScrunityDone.click();
}
public void setScrunityPending()
{
    ScrunityPending.click();
}
public void setConversionDone()
{
    ConversionDone.click();
}
public void setConversionPending()
{
    ConversionPending.click();
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
