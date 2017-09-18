package Pages.PaymentcConsole.Support;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
/**
 * Created by akshay.pokley on 9/15/2017.
 */
public class PayChallan {
    WebDriver driver;

    @FindBy(xpath = ".//*[@id='Div2']/a/h2")
    WebElement logo;

    @FindBy(xpath = ".//*[@id='cboChallanType']")
    WebElement ChallanType;

    @FindBy(xpath = ".//*[@id='txtSubID']")
    WebElement FileNo;

    @FindBy(xpath = ".//*[@id='txtTransNo']")
    WebElement TransitionNo;

    @FindBy(xpath = ".//*[@id='btnSubmit']")
    WebElement Submit;


    public PayChallan(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        if (!logo.isDisplayed())
            throw new IllegalStateException("This is not PayChallan page");
    }

    public  void ClickSubmit()
    {
        Submit.click();
    }

    public  void setChallanType(String challanType)
    {
     Select combo=new Select(ChallanType);
        combo.selectByVisibleText(challanType);
    }

    public void setFileNo(String fileNo )
    {
        FileNo.sendKeys(fileNo);
    }

    public void setTransitionNo(String transitionNo)
    {
        TransitionNo.sendKeys(transitionNo);
    }

}
