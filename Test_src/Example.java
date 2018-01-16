import Pages.Applicant_Console.ApplicantMenu;
import Pages.Applicant_Console.Application_Submission.Application;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static Utilites.LoginFunction.LogFunction;
import static Utilites.OpenBrowser.GetUrl;
import static Utilites.OpenBrowser.openBrowser;
import static Utilites.Windowhander.NewWindow;

/**
 * Created by akshay.pokley on 8/30/2017.
 */
public class Example {
    WebDriver driver;
    public    Application application;
    @Test
    public void dj() throws InterruptedException, ParseException {

        SimpleDateFormat myDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat calDateFormat = new SimpleDateFormat("MMMM yyyy");
        Date setDate=myDateFormat.parse("16/01/2019");
        driver = openBrowser("chrome");

        GetUrl("url");
        driver.findElement(By.xpath(".//*[@id='A1']")).click();
        NewWindow(driver);
       // driver.get("http://seleniumbyneeds.blogspot.in/2015/01/selecting-date-on-jquery-datepicker.html");

// Switch to frame where the Menu Example is loaded
       // driver.switchTo().frame(driver.findElement(By.id("myFiddler"))).switchTo().frame(0);

        driver.findElement(By.id("raddate")).click();

        Date curDate = calDateFormat.parse(driver.findElement(By.className("datepicker-switch")).getText());
// Joda org.joda.time.Months class to calculate difference
// to do this converted Date to joda DatTime
        int monthDiff = Months.monthsBetween(new DateTime(curDate).withDayOfMonth(1), new DateTime(setDate).withDayOfMonth(1)).getMonths();
        System.out.println(monthDiff);
        boolean isFuture = true;
// decided whether set date is in past or future
        if(monthDiff<0){
            isFuture = false;
            monthDiff*=-1;
        }
// iterate through month difference
        for(int i=1;i<=monthDiff;i++){
            driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
            driver.findElement(By.xpath("//html/body/div[2]/div[1]/table/thead/tr[1]/th[@class="+ (isFuture ? "'next'" : "'prev'") + "]")).click();
        }
// Click on Day of Month from table
        driver.findElement(By.xpath("//html/body/div[2]/div[1]/table/tbody/tr/td[text()='" + (new DateTime(setDate).getDayOfMonth()) + "']")).click();


     /*   GetUrl("url");
        LogFunction(driver);
        Thread.sleep(200);
        driver.switchTo().frame("ifrmListing");
*/

            }
}
