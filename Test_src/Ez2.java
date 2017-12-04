import Pages.Applicant_Console.ApplicantMenu;
import Pages.Applicant_Console.Application_Submission.Application;
import Utilites.OpenBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static Utilites.BeforeWH.BeforeWH;
import static Utilites.LoginFunction.LogFunction;
import static Utilites.OpenBrowser.GetUrl;
import static Utilites.OpenBrowser.openBrowser;

/**
 * Created by akshay.pokley on 12/1/2017.
 */
public class Ez2 {

  public static int i=3;

  @Test
            public static void main()

    {
    WebDriver driver;
        driver = openBrowser("chrome");
        GetUrl("url");
        LogFunction(driver);
        Application application = new Application(driver);
        ApplicantMenu   applicantMenu = new ApplicantMenu(driver);
        applicantMenu.ClickApplication();
        driver.switchTo().frame("ifrmListing");
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        List<WebElement> cells = driver.findElements(By.xpath(".//*[@id='ListProposalGrid']/tbody/tr[2]/td[2]/div/div[1]/table/tbody/tr/td[3]"));

        for (WebElement cell : cells) {
            String fiels = cell.getText();
            System.out.println(fiels);

            if (fiels.equals("Select")) {
                cell.click();break;

            }else {  System.out.println(fiels);}
        }


 /*       driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.switchTo().frame("ifrmProjectInfo");
        driver.findElement(By.xpath("./*//*[@id='imgRisk']")).click();

        driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
        WebElement frame=driver.findElement(By.xpath("//iframe[@frameborder='0']"));
        driver.switchTo().frame(frame);*/
  List<WebElement> cell2 = driver.findElements(By.xpath("html/body/form/table[2]/tbody/tr/td[2]/span"));

        for (WebElement cell12 : cell2) {
            String fiels = cell12.getText();

            if (fiels.equals("Civil Aviation Height Permissibility"))
            {
                for(int j=i; j<22; j++)
                {
                    driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr["+i+"]/td[4]/input")).sendKeys("10");

                WebElement d   = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr["+i+"]/td[5]/select"));
                    Select combo=new Select(d);
                    combo.selectByVisibleText("Low");
               ++j;
        j=i;
        break;
                }
            }else {
            ++i;++i;

            }

            }

driver.findElement(By.xpath("html/body/form/table[1]/tbody/tr[3]/td[1]/div/input")).click();
        }


}
