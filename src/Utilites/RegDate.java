package Utilites;

import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by akshay.pokley on 1/30/2018.
 */
public class RegDate {

    public static void RegDateFun(WebDriver driver, String seDate) throws ParseException, InterruptedException

    {

        SimpleDateFormat myDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat calDateFormat = new SimpleDateFormat("MMMM yyyy");
        Thread.sleep(1000);
        Date setDate=myDateFormat.parse(seDate);
        Thread.sleep(1000);
        Thread.sleep(1000);
        driver.findElement(By.xpath(".//*[@id='dtpk']/p/span/button")).click();

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
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//html/body/div[2]/div[1]/table/thead/tr[1]/th[@class="+ (isFuture ? "'next'" : "'prev'") + "]")).click();
        }
// Click on Day of Month from table
        driver.findElement(By.xpath("//html/body/div[2]/div[1]/table/tbody/tr/td[text()='" + (new org.joda.time.DateTime(setDate).getDayOfMonth()) + "']")).click();



    }


}
