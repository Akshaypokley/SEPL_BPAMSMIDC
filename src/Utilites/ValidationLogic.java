package Utilites;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.regex.Pattern;

import static org.apache.log4j.spi.Configurator.NULL;

/**
 * Created by akshay.pokley on 6/26/2017.
 */
public class ValidationLogic {

    static WebDriver driver;
    public static String ActualOutput;
    public static String AcutualResult;
    public static String VActual;    static final java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("^[A-Za-z,0-9  ]++$");
    public static String ValidationLogic(WebDriver driver, String Vfield, String Origvalue, String OrigenExpeted,String VResult) {

        if (Vfield.isEmpty()) {
            try {
                if ((ExpectedConditions.alertIsPresent()) == null) {

                } else {
                    Alert alert = driver.switchTo().alert();
                    ActualOutput = driver.switchTo().alert().getText();
                    if (ActualOutput.equals(OrigenExpeted)) {
                        VResult = "pass";
                        AcutualResult=VResult;
                    } else {
                        VResult = "Fail";     AcutualResult=VResult;
                    }
                    System.out.println(ActualOutput);
                    //    Thread.sleep(50);
                    alert.accept();

                }

            } catch (Throwable e) {ActualOutput = "Alert message not display.";
                VResult = "Fail";    AcutualResult=VResult;
            }


        } else {
            if (Vfield.equals(Origvalue)) {

                System.out.println("y1");
                if (!pattern.matcher(Vfield).matches()) {
                    try {
                        if ((ExpectedConditions.alertIsPresent()) == null) {
                            ActualOutput = "Alert message not display.";
                            VResult = "Fail";    AcutualResult=VResult;
                        } else {
                            Alert alert = driver.switchTo().alert();
                            ActualOutput = driver.switchTo().alert().getText();
                            if (ActualOutput.equals(OrigenExpeted)) {
                                VResult = "pass"; AcutualResult=VResult;
                            } else {
                                VResult = "Fail";    AcutualResult=VResult;
                            }
                            System.out.println(ActualOutput);
                            //    Thread.sleep(50);
                            alert.accept();

                        }

                    } catch (Throwable e) {ActualOutput = "Alert message not display .";
                        VResult = "Fail";    AcutualResult=VResult;
                    }
                } else {
                    VResult = "pass";
                    System.out.println("y2");
                    AcutualResult=VResult;
                    System.out.println(Vfield);
                    System.out.println(VResult);


                }


            } else {
                try {
                    if ((ExpectedConditions.alertIsPresent()) == null) {
                        ActualOutput = "Alert message not display .";
                        VResult = "Fail";AcutualResult=VResult;
                    } else {
                        Alert alert = driver.switchTo().alert();
                        ActualOutput = driver.switchTo().alert().getText();
                        if (ActualOutput.equals(OrigenExpeted)) {
                            VResult = "pass";AcutualResult=VResult;
                        } else {
                            VResult = "Fail";AcutualResult=VResult;
                        }
                        System.out.println(ActualOutput);
                        //    Thread.sleep(50);
                        alert.accept();

                    }

                } catch (Throwable e) {ActualOutput = "Alert message not display.";
                    VResult = "Fail";AcutualResult=VResult;
                }
            }
        }
        return VResult;
    }
public static String ActualoutputFun(String VActual1) {
    System.out.println("h:" + AcutualResult);
    if (!ActualOutput.equals("pass"))
        VActual1 = VActual;
    return VActual1;
} }