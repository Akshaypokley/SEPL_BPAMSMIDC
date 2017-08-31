import Pages.Applicant_Console.ApplicantMenu;
import Pages.Applicant_Console.Application_Submission.Application;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static Utilites.LoginFunction.LogFunction;
import static Utilites.OpenBrowser.GetUrl;
import static Utilites.OpenBrowser.openBrowser;

/**
 * Created by akshay.pokley on 8/30/2017.
 */
public class Example {
    WebDriver driver;
    public    Application application;
    @Test
    public void dj() throws InterruptedException {
        driver = openBrowser("chrome");
        GetUrl("url");
        LogFunction(driver);
        Thread.sleep(200);
       /* application=new Application(driver);
        ApplicantMenu applicantMenu=new ApplicantMenu(driver);
        applicantMenu.ClickApplication();*/
      String d= driver.switchTo().frame("ifrmListing").getTitle();
        System.out.println(d);

     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      String sd=  driver.findElement(By.xpath(".//*[@id='ListProposalGrid']/tbody/tr[2]/td[2]/div/div[1]/table/tbody/tr/td[3]")).getText();
        System.out.println(sd);

        driver.close();
            }
}
