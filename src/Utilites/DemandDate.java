package Utilites;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by akshay.pokley on 12/25/2017.
 */
public class DemandDate {

    static WebDriver driver;
    public static void DemanDateFun(WebDriver driver, String seDate) throws ParseException

    {
        //driver=openbrowser("chrome");
        //driver.findElement(By.xpath("html/body/div[1]/aside/section/ul/li[5]/a/span")).click();


        SimpleDateFormat myDateFormat = new SimpleDateFormat("dd/MM/YYYY");

        SimpleDateFormat calDateFormat = new SimpleDateFormat("MMMM yyyy");

        Date setDate=myDateFormat.parse(seDate);

        driver.findElement(By.xpath(".//*[@id='divpass']/table/tbody/tr[1]/td[2]/p/span/button")).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        Date curDate = calDateFormat.parse(driver.findElement(By.xpath("//html/body/div[2]/div[1]/table/thead/tr[1]/th[2]")).getText());
        System.out.println(curDate);

        int monthDiff = Months.monthsBetween(new DateTime(curDate).withDayOfMonth(1),new DateTime(setDate).withDayOfMonth(1)).getMonths();
        boolean isFuture = true;
        System.out.println(monthDiff);
        // decided whether set date is in past or future
        if(monthDiff <0){
            isFuture = false;
            monthDiff*=1;
        }
        // iterate through month difference
        for(int i=1;i<=monthDiff;i++){
            driver.findElement(By.xpath("html/body/div[2]/div[1]/table/thead/tr[1]/th[@class="+ (isFuture ? "'next'" : "'prev'") + "]")).click();
        }
        // Click on Day of Month from table
  for(int j=1;j<7;j++){

  WebElement ddd= driver.findElement(By.xpath("//html/body/div[2]/div[1]/table/tbody/tr/td['"+j+"']/td[text()='" + (new DateTime(setDate).getDayOfMonth()) + "']"));
if(ddd.equals(seDate))
{
    ddd.click();
}
    }


    }
}
