import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static Utilites.OpenBrowser.openBrowser;

/**
 * Created by akshay.pokley on 1/6/2018.
 */
public class swapnil {

    @Test
    public void  test() throws InterruptedException {
        WebDriver driver;
        driver = openBrowser("chrome");
        driver.get("http://ext-ciwapp.minerva-plm.com/De2Mat_11_QA_AIRBUS/Client/scripts/Innovator.aspx");
driver.switchTo().frame("main");
driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("ng478d5");
driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("de2mat");
        driver.findElement(By.xpath(".//*[@id='login.login_btn_label']")).click();
        Thread.sleep(3000);
        driver.switchTo().parentFrame();
Thread.sleep(3000);
     driver.findElement(By.xpath("/html/body/dialog/div[2]/div[2]/div[2]/button")).click();

    }

}
