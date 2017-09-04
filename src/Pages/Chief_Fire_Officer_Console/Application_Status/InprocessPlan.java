package Pages.Chief_Fire_Officer_Console.Application_Status;

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

    @FindBy(xpath = ".//*[@id='cboArchitect_DropDown']/div/ul/li")
    WebElement Select_ArchitectName;

    @FindBy(xpath = ".//*[@class='container-fluid']//div/div[2]/input")
    WebElement SeachBtn;

        @FindBy(xpath = ".//*[@id='form1']/div[3]//div[5]/div//div[2]/table/tbody/tr/td[2]/div")
    WebElement SeachWithKeyword;

    @FindBy(xpath = ".//*[@id='form1']/div[3]//div[5]//div[2]/table/tbody/tr/td/div/button")
    WebElement Filters;

    public InprocessPlan(WebDriver driver)
    { this.driver=driver;
        PageFactory.initElements(driver,this);
        if(!Formlogo.isDisplayed())
            throw  new IllegalStateException("This is not Home page");
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


    public WebElement getFormlogo()
    {
        return Formlogo;
    }
}
