/*

import java.awt.*;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import com.DeathByCaptcha.AccessDeniedException;
import com.DeathByCaptcha.Captcha;
import com.DeathByCaptcha.Client;
import com.DeathByCaptcha.SocketClient;
import com.DeathByCaptcha.HttpClient;

*/
/**
 * Created by akshay.pokley on 12/15/2017.
 *//*

public class pp {


    @Test



    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://125.99.73.119:8097/BPAMSClient/");
        System.out.println(driver.getTitle());
        WebElement un = driver.findElement(By.id("txtUN"));
        un.clear();
        un.sendKeys("ar.arun02");
        WebElement pw = driver.findElement(By.id("txtPW"));
        pw.clear();
        pw.sendKeys("a");

        WebElement captchaimage = driver.findElement(By.xpath(".*/
/*//*
*/
/*[@id='RadCaptcha1_CaptchaImageUP']"));
        System.out.println(" get the instance ");

        //  URL url = new URL(captchaimage);
        //   Image image = ImageIO.read(url);


        System.out.println(captchaimage);
        WebElement captcha = driver.findElement(By.name("RadCaptcha1$CaptchaTextBox"));
        captcha.click();

        //String captchavalue = scanner.next();
        //captcha.sendKeys(captchaimage);
        // captcha.click();
        //WebElement login = driver.findElement(By.name("btnLog"));
        //login.click();

        //   WebElement newapplication = driver.findElement(By.id("a_3069"));
        // newapplication.click();

    }
}
*/
