package Utilites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.ParseException;

/**
 * Created by akshay.pokley on 12/25/2017.
 */
public class NewDate {


    static WebDriver driver;
    public static void NewDemanDateFun(WebDriver driver, String seDate,String month_year, String day) throws ParseException

    {  driver.findElement(By.xpath(".//*[@id='form1']/div[4]/div[2]/span/button")).click();
        String date = seDate;
        String splitter[] = date.split("/");
        String checkInmonth_year = splitter[1];
        String checkInday = splitter[0];



    }
}
