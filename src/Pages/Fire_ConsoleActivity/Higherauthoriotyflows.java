package Pages.Fire_ConsoleActivity;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Higherauthoriotyflows {

    WebDriver driver;

    @FindBy(xpath = ".//*[@id='btnSubmit']")
    WebElement SubmitBtn;

    @FindBy(xpath = ".//*[@id='lblDesign']")
    String FireName;

     @FindBy(xpath = ".//*/div/nav/ul/li/a/div/div[2]/span")
     WebElement Menutabh;

    @FindBy(xpath = ".//*/div/nav/ul/li/ul/li/a/span")
    WebElement MenuTABsub;

    public Higherauthoriotyflows(WebDriver driver)
    { this.driver=driver;
        PageFactory.initElements(driver,this);
        String search  = "Fire";
        if ( FireName.toLowerCase().indexOf(search.toLowerCase()) != -1 )
            throw  new IllegalStateException("This is not login page");
    }

    public WebElement getMenutabh() {
        return Menutabh;
    }


}
