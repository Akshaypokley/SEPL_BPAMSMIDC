package Utilites;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


/**
 * Created by AKSHAY on 20/04/2017.
 */
public class DateFunction {

 static WebDriver driver;
    public static void DateFun(WebDriver driver, String seDate) throws ParseException, InterruptedException

    {

        SimpleDateFormat myDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat calDateFormat = new SimpleDateFormat("MMMM yyyy");
        Thread.sleep(1000);
        Date setDate=myDateFormat.parse(seDate);
        Thread.sleep(1000);
        Thread.sleep(1000);
        driver.findElement(By.xpath(".//*[@id='form1']/div[4]/div[2]/span/button")).click();

        Date curDate = calDateFormat.parse(driver.findElement(By.className("datepicker-switch")).getText());
        Thread.sleep(1000);
        // Joda org.joda.time.Months class to calculate differenceThread.sleep(1000);
// to do this converted Date to joda DatTime
        int monthDiff = Months.monthsBetween(new org.joda.time.DateTime(curDate).withDayOfMonth(1), new org.joda.time.DateTime(setDate).withDayOfMonth(1)).getMonths();
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
        driver.findElement(By.xpath("//html/body/div[2]/div[1]/table/tbody/tr/td[text()='" + (new org.joda.time.DateTime(setDate).getDayOfMonth()) + "']")).click();


       /* SimpleDateFormat myDateFormat = new SimpleDateFormat("dd/MM/YYYY");
        System.out.println(myDateFormat);
        SimpleDateFormat calDateFormat = new SimpleDateFormat("MMMM yyyy");
        System.out.println(calDateFormat);
        Date setDate=myDateFormat.parse(seDate);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.xpath("./*//*[@id='txtODate']")).click();


        Date curDate = calDateFormat.parse(driver.findElement(By.className("datepicker-switch")).getText());
        System.out.println(curDate);

        int monthDiff = Months.monthsBetween(new DateTime(curDate).withDayOfMonth(1),new DateTime(setDate).withDayOfMonth(1)).getMonths();
        boolean isFuture = true;
        System.out.println(monthDiff);
        // decided whether set date is in past or future
        if(monthDiff <0){
            isFuture = false;
            monthDiff*=-1;
        }
        // iterate through month difference
        for(int i=1;i<=monthDiff;i++){
            driver.findElement(By.xpath("//html/body/div[2]/div[1]/table/thead/tr[1]/th[@class="+ (isFuture ? "'prev'" : "'next'") + "]")).click();
        }



        driver.findElement(By.xpath("//html/body/div[2]/div[1]/table/tbody/tr/td[text()='" + (new DateTime(setDate).getDayOfMonth()) + "']")).click();

*/


    }


}
