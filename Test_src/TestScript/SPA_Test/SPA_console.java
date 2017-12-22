package TestScript.SPA_Test;

import Pages.Applicant_Console.ApplicantMenu;
import Pages.Applicant_Console.Application_Submission.Application;
import Pages.ScrunityCell.Scrunity.ConversionPending;

import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.read.biff.BiffException;
import jxl.write.*;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static TestScript.ForgotCTest.WinHandleBefore1;
import static Utilites.AttachFunction.AttachFuntn;
import static Utilites.BeforeWH.BeforeWH;
import static Utilites.DateFunction.DateFun;
import static Utilites.LoginFunction.*;
import static Utilites.OpenBrowser.GetUrl;
import static Utilites.OpenBrowser.openBrowser;
import static Utilites.Windowhander.NewWindow;
import static jxl.format.Colour.*;
import static jxl.format.Colour.LIGHT_TURQUOISE;

/**
 * Created by akshay.pokley on 12/19/2017.
 */
public class SPA_console {

    static WebDriver driver;
    public Label l4;
    public static WritableCellFormat cellFormat;
    public static WritableCellFormat cellFormat1;
    public static WritableCellFormat cellFormat3;
    public static WritableCellFormat cellFormat4;
    public WritableCellFormat cellFormat2;
    public static WritableCellFormat cellFormat6;
    public static WritableCellFormat cellFormat5;
    public String TestCase;
    public WritableWorkbook writableTempSource;
    public WritableWorkbook copyDocument;
    public WritableSheet sourceSheet;
    public static WritableSheet targetSheet;
    public Workbook sourceDocument;
    /*****************************************************************/
    private static int n = 2;
    private static int j = 1;
    public static String Result;
    public static String k;
    public static String ResultPass1 = "Username";
    public static String ResultFail1 = "Password";
    public static String Actual;
    public static String Actual2;
    public static String J;
    static int LastRow;
    static int SetBord;
    static final java.util.regex.Pattern String = java.util.regex.Pattern.compile("^[A-Za-z, ]++$");
    static final java.util.regex.Pattern Num = java.util.regex.Pattern.compile("^[0-9]++$");
    static final java.util.regex.Pattern Emailval = java.util.regex.Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    static final java.util.regex.Pattern Alphnu = java.util.regex.Pattern.compile("^[A-Za-z,0-9  ]++$");
    static final java.util.regex.Pattern Flot = java.util.regex.Pattern.compile("^[+-]?([0-9]*[.])?[0-9]++$");
    public static Application application;
    public static ApplicantMenu applicantMenu;
    public static String Actvalue;
    public static int x=3;
    public static int vb=2;
    public static int k1=1;
    public static int rr=1;
    public static ConversionPending conversionPending;


    @BeforeTest
    public  void OutputExcelCreation() throws IOException, BiffException, WriteException {

        sourceDocument = Workbook.getWorkbook(new File("ExcelData/InputData/SPATestData.xls"));
        writableTempSource = Workbook.createWorkbook(new File("ExcelData/InputData/temp.xls"), sourceDocument);
        copyDocument = Workbook.createWorkbook(new File("ExcelData/TestReport/SPAReports/SPATestReport.xls"));
        sourceSheet = writableTempSource.getSheet(0);
        targetSheet = copyDocument.createSheet("sheet 1", 2);

        WritableFont cellFont = new WritableFont(WritableFont.COURIER, 11);
        cellFont.setBoldStyle(WritableFont.BOLD);
/************************************************************************************************/
        WritableFont cellFont2 = new WritableFont(WritableFont.COURIER, 10);
        cellFont2.setColour(BLACK);
        //cellFont2.setBoldStyle(WritableFont.BOLD);
        cellFormat1 = new WritableCellFormat(cellFont2);
        cellFormat1.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
        cellFormat1.setWrap(true);
/*******************************************************************************************************/
/************************************************************************************************/
        WritableFont cellFont3 = new WritableFont(WritableFont.COURIER, 10);
        cellFont3.setColour(RED);
        // cellFont3.setBoldStyle(WritableFont.BOLD);
        cellFormat3 = new WritableCellFormat(cellFont3);
        cellFormat3.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
        cellFormat3.setWrap(true);

        WritableFont cellFont4 = new WritableFont(WritableFont.COURIER, 10);
        cellFont4.setColour(GREEN);
        // cellFont4.setBoldStyle(WritableFont.BOLD);
        cellFormat4 = new WritableCellFormat(cellFont4);
        cellFormat4.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
        cellFormat4.setWrap(true);


        cellFormat = new WritableCellFormat(cellFont);
        cellFormat.setBackground(LIGHT_BLUE);
        cellFormat.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
        cellFormat.setWrap(true);
        cellFormat2 = new WritableCellFormat(cellFont);
        cellFormat2.setBackground(RED);
        //cellFormat.setAlignment(jxl.format.Alignment.getAlignment(20));
        WritableFont cellFont5 = new WritableFont(WritableFont.COURIER, 18);
        cellFont5.setColour(BLACK);
        cellFont5.setBoldStyle(WritableFont.BOLD);
        cellFormat5 = new WritableCellFormat(cellFont5);
        cellFormat5.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
        cellFormat5.setBackground(LIGHT_BLUE);
        cellFormat5.setAlignment(Alignment.CENTRE);


        cellFormat6 = new WritableCellFormat(cellFont2);
        cellFormat6.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
        cellFormat6.setWrap(true);
        cellFormat6.setBackground(LIGHT_TURQUOISE);
        //  sheet.addCell(new Label(col, 1, "CCCCC", cellFormat));

        for (int row = 0; row < sourceSheet.getRows(); row++) {
            for (int col = 0; col < sourceSheet.getColumns(); col++) {
                WritableCell readCell = sourceSheet.getWritableCell(col, row);
                WritableCell newCell = readCell.copyTo(col, row);
                CellFormat readFormat = readCell.getCellFormat();

                WritableCellFormat newFormat = new WritableCellFormat(readFormat);
                newCell.setCellFormat(newFormat);
                targetSheet.addCell(newCell);


                Label l2=new Label(5,1,"Actual",cellFormat);

                Label l3=new Label(6,1,"Status",cellFormat);
                //Label l4=new Label(4,row,"",cellFormat);
                int widthInChars = 36;
                int widthInChars2 = 18;
                int widthInChars1 = 16;
                targetSheet.setColumnView(2, widthInChars1);
                targetSheet.setColumnView(3, widthInChars1);
                targetSheet.setColumnView(1, widthInChars1);
                targetSheet.setColumnView(4, widthInChars);
                targetSheet.setColumnView(5, widthInChars);

/*-----------------------------------------------------------------------------------------------------------------------*/
                targetSheet.setColumnView(0, widthInChars2);
                targetSheet.setColumnView(2, widthInChars2);

                targetSheet.setColumnView(3, widthInChars2);
                targetSheet.mergeCells(0, 0, 6, 0);
                Label lable = new Label (0, 0,
                        "SPA screen test  report",cellFormat5);
                targetSheet.addCell(lable);
                targetSheet.addCell(l2);
                targetSheet.addCell(l3);
                //targetSheet.addCell(l4);

            }
        }

    }
    @AfterTest
    public void f() throws IOException, WriteException
    {

        copyDocument.write();
        copyDocument.close();
        writableTempSource.close();
        sourceDocument.close();

    }


    @Test(dataProvider = "hybridData")
    public static void SPATest(String testcaseName, String keyword, String objectName, String value, String Expected) throws Exception {

        if (testcaseName != null && testcaseName.length() != 0) {

            driver = openBrowser("chrome");
            GetUrl("url");
            Thread.sleep(200);
            SetBord = j++;
            Label l7 = new Label(5, SetBord, "", cellFormat6);
            targetSheet.addCell(l7);
            Label l8 = new Label(6, SetBord, "", cellFormat6);
            targetSheet.addCell(l8);
        } else {
            SetBord = j++;
        }

        try {
            switch (keyword.toUpperCase()) {

                case "FRAME":

                    switch (objectName)
                    {
                        case "Main Frame":
                            driver.switchTo().frame("ifrmListing");
                            Result="pass";

                    }break;
                case "RECONCILIIATION":

                    switch (objectName) {


                        case "Save Reconciliation Status":
                            driver.findElement(By.xpath(".//*[@id='btnSave']")).click();
                            Thread.sleep(2315);
                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                System.out.println("alert was not present");
                            } else {
                                Alert alert = driver.switchTo().alert();
                                Actual = driver.switchTo().alert().getText();
                                alert.accept();
                            }
                            break;

                        case "Change Reconciliation Status":

                            //  driver.switchTo().frame("ifrmListing");
                            try {
                                WebElement Reco=driver.findElement(By.xpath(".//*//tr[6]/td/div/table/tbody/tr/td[5]/div/b"));
                                String total_payments=Reco.getText();
                                if (total_payments.equals("0"))
                                {Result="pass";
                                    Actual="Payment are pending";
                                }else {
                                    Actions actions = new Actions(driver);
                                    actions.moveToElement(driver.findElement(By.xpath(".//*[@id='ListPaymentReconsileGrid']/tbody/tr[2]/td[2]/div/div[1]/table/tbody/tr[2]/td[12]")));
                                    Thread.sleep(200);
                                    actions.click(); actions.build().perform();
                                    driver.manage().timeouts().implicitlyWait(23, TimeUnit.SECONDS);
                                    //   List<WebElement> paynow = driver.findElements(By.xpath(".//*[@id='TreeGridControls']/div/div/div[7]/div/div/div/div/div/div"));
                                    actions.moveToElement(driver.findElement(By.xpath(".//*[@id='TreeGridControls']/div/div/div[7]/div/div//div[2]")));
                                    actions.click(); actions.build().perform();
                                   /* for (WebElement paynow1 : paynow) {
                                        String fiels23 = paynow1.getText();
                                        System.out.println(fiels23);
                                        if (fiels23.equals(value)) {
                                            paynow1.click();
                                            break;
                                        } ++Rec;
                                    }
*/
                                }
                            } catch (Throwable e) {
                                System.out.println(e.getMessage());

                            }

                    }    break;

                case "PAY":

                    switch (objectName) {

                        case "Pending Demand Note":

                            driver.switchTo().frame("ifrmListing");
                            try {
                                List<WebElement> cells = driver.findElements(By.xpath(".//*/tr[2]/td[2]/div/div[1]/table/tbody//td[2]"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();
                                    System.out.println(fiels);
                                    if (fiels.equals(value)) {

                                        List<WebElement> paynow = driver.findElements(By.xpath(".//*//tr[2]/td[2]/div/div[1]/table/tbody/tr["+vb+"]/td[6]"));

                                        for (WebElement d : paynow) {

                                            d.click();
                                            BeforeWH(driver);

                                            WebElement dee=driver.findElement(By.xpath(".//*//tbody/tr[8]/td[2]/table/tbody/tr/td[1]"));
                                            String dddd=dee.getText();
                                            System.out.println(dddd);

                                        }


                                    }
                                    ++vb;
                                }
                            } catch (Throwable e) {

                            }

                    }    break;

                case "LEFT_MENU":

                    switch (objectName) {
                        case "LeftMenuTab":

                            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                            try {
                                List<WebElement> cells = driver.findElements(By.xpath(".//*/div/nav/ul/li/a/div/div[2]/span"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();
                                    System.out.println(fiels);
                                    if (fiels.equals(value)) {
                                        System.out.println(fiels);
                                        if (k1 != 1) {
                                            cell.click();
                                            System.out.println("Value Name is :-***" + value + "***");
                                            Result = "pass";break;
                                        }
                                    } else {Result="fail";
                                    Actual="Tab not present.";
                                    }   ++k1;

                                }
                            } catch (Throwable e) {

                            }
                            break;

                        case "LeftMenu_SubTab":
                            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                            try {
                                List<WebElement> cells = driver.findElements(By.xpath(".//*/div/nav/ul/li/ul/li/a/span"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();
                                    if (fiels.equals(value)) {
                                        cell.click();
                                        System.out.println("Value Name is :-***" + value + "***");

                                        System.out.println("The value of K:-" + k);
                                       /* driver.switchTo().frame("ifrmListing");*/ Result = "pass";
                                        break;
                                    }else {
                                        Result = "fail";
                                        Actual = "Sub Tab not present.";
                                    }
                                }
                            } catch (Throwable e) {

                                System.out.println(e.getMessage());
                            }
                    }break;

                case "LOGIN":

                    switch (objectName) {

                        case "Architect":
                            LogFunction(driver);
                            Result="pass";
                            break;
                        case "SPA Login":
                            SPA_LogFunction(driver);              Result="pass";
                            break;
                        case"Deputy Chief officer":
                            DFO_LogFunction(driver);              Result="pass";
                    }break;




                case "STATUS BAR":

                    switch (objectName) {
                        case "Get Opertional Bar Details":


                            if ( Actual.equals("File not Found")|| Actual.equals("Tab not present.")||Actual.equals("Sub Tab not present.")||Actual.equals("No data found")) {

                                Result="fail";
                                Actual="File Not found";
                                driver.quit();
                            } else {
                                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                                driver.switchTo().frame("ifrmProjectInfo");
                                driver.switchTo().parentFrame();
                                //  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                                try {
                                    driver.switchTo().frame("ifrmToolbar");
                                    List<WebElement> d = driver.findElements(By.xpath(".//*[@id='seTbGeneral']/tbody/tr/td/a"));
                                    for (WebElement cell : d) {
                                        String fiels = cell.getText();
                                        System.out.println("Tool bar Componets are " + fiels);
                                        Result = "pass";
                                        if (fiels.equals(value)) {


                                            if (fiels.equals(" Scrutiny Reports") || fiels.equals(" Print NoteSheet") || fiels.equals(" Site Visit Report")
                                                    || fiels.equals(" View Fire NOC")) {
                                                cell.click();
                                                NewWindow(driver);
                                                Thread.sleep(2000);
                                                java.awt.Robot robot = new java.awt.Robot();
                                                Thread.sleep(1000);
                                                robot.keyPress(KeyEvent.VK_CONTROL);
                                                robot.keyPress(KeyEvent.VK_S);
                                                robot.keyRelease(KeyEvent.VK_S);
                                                robot.keyRelease(KeyEvent.VK_CONTROL);
                                                Thread.sleep(2000);
                                                robot.keyPress(KeyEvent.VK_ENTER);
                                                Thread.sleep(2000);
                                                robot.keyPress(KeyEvent.VK_TAB);   // file replace move to yes button
                                                Thread.sleep(2000);
                                                robot.keyPress(KeyEvent.VK_ENTER);
                                                driver.switchTo().window(WinHandleBefore1);

                                                break;
                                            /* // hit enter*/
                                            } else {

                                                if (fiels.equals(" Create Demand")) {
                                                    cell.click();

                                                    try {

                                                        driver.switchTo().parentFrame();
                                                        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@style='width: 100%; height: 100%; border: 0px none; top: -10000px;']")));
                                                        String jjj = driver.findElement(By.xpath(".//*[@id='form1']/div[4]/label")).getText();
                                                        System.out.println(jjj);
                                                        driver.quit();
                                                        break;
                                                    } catch (NoSuchElementException gh) {
                                                        Result = "fail";
                                                        Actual = gh.getMessage();
                                                        break;
                                                    }


                                                } else {
                                                    if (fiels.equals(" Notesheet")) {
                                                        cell.click();
                                                        NewWindow(driver);
                                                        WebElement ns = driver.findElement(By.xpath(".//*[@id='lblnote']"));
                                                        String Note = ns.getText();
                                                        System.out.println(Note);
                                                        if (Note.equals("There is no observation in the Note Sheet !!!")) {
                                                            driver.findElement(By.xpath(".//*[@id='btnAdd']")).click();
                                                            NewWindow(driver);

                                                        } else {

                                                            driver.findElement(By.xpath(".//*[@id='RadPanelbar1']/ul/li/a/span/span[1]")).click();
                                                            driver.findElement(By.xpath(".//*[@id='RadPanelbar1']/ul/li/div/ul/li[1]/div/table/tbody/tr/td[2]/img")).click();
                                                            NewWindow(driver);

                                                        }


                                                    } else {
                                                        if (fiels.equals(" Site Details")) cell.click();
                                                        {
                                                            NewWindow(driver);
                                                            String jjj = driver.findElement(By.xpath(".//*[@id='seTB']/tbody/tr/td[2]/a[1] ")).getText();
                                                            System.out.println(jjj);
                                                            driver.quit();
                                                        }
                                                    }

                                                    //driver.quit();
                                                    break;
                                                }
                                            }


                                        } else {
                                            List<WebElement> d1 = driver.findElements(By.xpath("./*//*[@id='SetbReports']/tbody/tr/td[2]/a"));
                                            for (WebElement cell1 : d1) {
                                                String fiels1 = cell1.getText();
                                                System.out.println("Tool bar Componets are:->" + fiels1);
                                                if (fiels1.equals(value)) {

                                                    System.out.println("Tool bar Componets are " + fiels1);

                                                    if (fiels1.equals(" Scrutiny Remarks")||fiels1.equals(" Drawing PDF")||fiels1.equals(" Challan Report")) {
                                                        cell1.click();

                                                        NewWindow(driver);
                                                        Thread.sleep(2000);
                                                        java.awt.Robot robot = new java.awt.Robot();
                                                        Thread.sleep(1000);
                                                        robot.keyPress(KeyEvent.VK_CONTROL);
                                                        robot.keyPress(KeyEvent.VK_S);
                                                        robot.keyRelease(KeyEvent.VK_S);
                                                        robot.keyRelease(KeyEvent.VK_CONTROL);
                                                        Thread.sleep(2000);
                                                        robot.keyPress(KeyEvent.VK_ENTER);
                                                        Thread.sleep(2000);
                                                        robot.keyPress(KeyEvent.VK_TAB);   // file replace move to yes button
                                                        Thread.sleep(2000);
                                                        robot.keyPress(KeyEvent.VK_ENTER);
                                                        driver.switchTo().window(WinHandleBefore1);
                                                        Result="Pass";
                                                        driver.quit();

                                                        break;
                                            /* // hit enter*/
                                                    } else {

                                                        if (fiels1.equals(" IFMS Outward No")) {

                                                            cell1.click();
                                                            driver.switchTo().parentFrame();

                                                            WebElement frame = driver.findElement(By.xpath("//iframe[@frameborder='0']"));
                                                            driver.switchTo().frame(frame);
                                                            String jjj=driver.findElement(By.xpath(".//*[@id='lblrepass']")).getText();
                                                            System.out.println(jjj);
                                                            driver.quit();

                                                        }
                                                    }
                                                    Result = "pass";
                                                    break;
                                                } else {
                                                    Result = "fail";
                                                    Actual = "Componets are not available";
                                                    System.out.println("Componets are not available ");
                                                }
                                            }
                                        }


                                    }


                                } catch (Throwable e) {

/*try {
    if ((ExpectedConditions.alertIsPresent()) == null) {
        System.out.println("alert was not present");
    } else {
        Alert alert = driver.switchTo().alert();
        Actual = driver.switchTo().alert().getText();
        alert.accept();
    }


}catch (Throwable h)
{
    Result="Fail";
   Actual=h.getMessage();
}*/

                                    System.out.println(e.getMessage());

                                }
                            }
                    }break;



                case "CLICK":
                    String FilePath = "E:\\Akshay\\PWIMS Deployment.pdf";
                    String FilePath2 = "E:\\Akshay\\wew.dwg.dwg";
                    String WinHandleBefore1 = driver.getWindowHandle();
                    switch (objectName) {
/************************************************************************************************/
                        case "Filter":
                            try
                            {
                                List<WebElement> cells = driver.findElements(By.xpath(".//*[@id='form1']/div[3]/div/div/div[5]/div/div/div/div/div[2]/table/tbody/tr/td/div/button"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();
                                    System.out.println(fiels);

                                    if (fiels.equals(value)) {
                                        cell.click();
                                        Result="pass";
                                        Actual="Done";
                                        break;
                                    }
                                }
                            }
                            catch (Throwable t)
                            {
                                System.out.println(t.getMessage());
                            }
break;
                        case "Save/Submit challan details":
                            driver.findElement(By.xpath(".//*[@id='SetB']/tbody/tr/td[2]/a[1]")).click();
                            Thread.sleep(2333);
                            try {

                                if ((ExpectedConditions.alertIsPresent()) == null) {
                                } else {
                                    Alert alert = driver.switchTo().alert();      Actual=alert.getText();
                                    alert.accept();

                                    Thread.sleep(2333);
                                    if ((ExpectedConditions.alertIsPresent()) == null) {
                                    } else {
                                        Alert alert2 = driver.switchTo().alert();      Actual=alert2.getText();
                                        alert2.accept();
                                        Thread.sleep(2333);
                                        if ((ExpectedConditions.alertIsPresent()) == null) {
                                        } else {
                                            Alert alert3 = driver.switchTo().alert();      Actual=alert3.getText();
                                            alert3.accept();

                                        }
                                    }

                                }

                            }catch (Throwable j)
                            {
                                System.out.println(j.getMessage());
                                Result="pass";
                            }
                            Result="pass";

                        case "Submit":
                            application.clickSave_Submit();
                            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                            WebElement element = driver.findElement(By.xpath("html/body/form/div[1]/table/tbody/tr[2]/td[2]//div/a/span/span"));
                            System.out.println(element.getText());
                            Actions actions = new Actions(driver);
                            actions.moveToElement(element);
                            Thread.sleep(200);
                            actions.click();
                            Thread.sleep(200);
                            actions.build().perform();
                            driver.switchTo().parentFrame();

                            driver.switchTo().frame("ifrmProjectInfo");
                            Result = "pass";
                               /* driver.close();*/
                            break;

                        case "Submit Risk Details":
                            try {
                                driver.findElement(By.xpath("html/body/form/table[1]/tbody/tr[3]/td[1]/div/input")).click();
                                Thread.sleep(2000);
                                driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); Thread.sleep(2000);

                                if ((ExpectedConditions.alertIsPresent()) == null) {
                                } else {
                                    Alert alert = driver.switchTo().alert();
                                    alert.accept();


                                }

                                driver.findElement(By.xpath("html/body/form/table[1]/tbody/tr[3]/td[2]/input")).click();
                                driver.switchTo().parentFrame();
                                driver.switchTo().parentFrame();
                                Result = "pass";
                                break;
                            }catch (Throwable e){
                                System.out.println(e.getMessage());
                            }
                            Thread.sleep(2000);
                            break;

                        case "Click On proposal ":
                            applicantMenu.ClickSelectProposal();
                            driver.switchTo().frame("ifrmProjectInfo");
                            Result = "pass";
                            break;

                        case "Double Height FSI":
                            if (value.equals("Yes")) {
                                application.ClickDouble_Height_FSI__Yes();
                                Result = "pass";
                            } else {
                                application.ClickDouble_Height_FSI__NO();
                                Result = "pass";
                            }
                            break;

                        case "Drawing is PreDCR Converted OR Not":
                            if (value.equals("Yes")) {
                                application.ClickDrawing_is_PreDCR_Converted__Yes();
                                Result = "pass";
                            } else {
                                application.clickDrawing_is_PreDCR_Converted__NO();
                                Result = "pass";
                            }
                            break;

                        case "Add For Extra Floor Height":
                            if (value.equals("Yes")) {
                                application.ClickExtra_Floor_Height__Yes();
                                application.setAdditional_FSI_Area(value);
                                Result = "pass";
                            } else {
                                application.clickExtra_Floor_Height__NO();
                                Result = "pass";
                            }
                            break;
/*---------------------------------------------- Risk details --------------------------------------------------------*/
                        case "Risk details":


                            try {
                                if (application.getRiskField().getText().isEmpty()) {
                                    application.ClickRiskFieldMESH();
                                    WebElement frame = driver.findElement(By.xpath("//iframe[@frameborder='0']"));
                                    driver.switchTo().frame(frame);
                                  /*  Thread.sleep(700);
                                    System.out.println(driver.findElement(By.id("frmRiskFactor")).getText());
                                    Thread.sleep(700);*/
                                    Result = "pass";
                                } else {
                                    Result = "pass";
                                }
                                //  System.out.println("done");
                                // driver.close();
                            } catch (Throwable i) {
                                System.out.println(i.getMessage());
                                System.out.println("Not-done");

                                //  driver.close();
                            }
                            break;



/*---------------------------------------------- HeaderTab --------------------------------------------------------*/
                        case "get headers":
                            try {
                                Thread.sleep(30);
                                driver.switchTo().frame("ifrmToolbar");
                                System.out.println(application.getDrawingScunity().getText());
                                System.out.println(application.getRunPreDCR().getText());
                                System.out.println(application.getSendScunity().getText());
                                System.out.println(application.getBack().getText());
                                System.out.println("Done");
                                driver.close();
                            } catch (Throwable p) {
                                System.out.println("Not_Done");
                                System.out.println("************");
                                System.out.println(p.getMessage());
                                driver.close();
                            }
                            break;
                        case "Create Advance Challan":
                            try {
                                // Thread.sleep(30);
                                driver.switchTo().frame("ifrmToolbar");
                                application.ClickAdvancepayment();
                                Thread.sleep(4500);
                                if ((ExpectedConditions.alertIsPresent()) == null) {


                                } else {
                                    Alert alert = driver.switchTo().alert();

                                    //  Actual = driver.switchTo().alert().getText();
                                    Thread.sleep(4500);
                                    alert.accept();
                                    Thread.sleep(4500);
                                    System.out.println("Done");
                                }
                                driver.close();
                            } catch (Throwable p) {
                                System.out.println("Not_Done");
                                System.out.println("************");
                                System.out.println(p.getMessage());
                                    /* driver.close(); */
                            }
                            break;


/*---------------------------------------------- Building Deatials --------------------------------------------------------*/
                        case "File Name":

                                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                                try {

                                    if (driver.findElement(By.xpath(".//*[@id='ListProposalGrid']/tbody/tr[6]/td/div/table/tbody/tr/td[3]/div/b")).getText().equals("0")) {
                                        Thread.sleep(80);
                                        WebElement d = driver.findElement(By.xpath(".//*[@id='ListProposalGrid']/tbody/tr[3]/td/div/table/tbody/tr/td/div"));
                                        String s = d.getText();
                                        if (s.equals(Expected)) {
                                            Result = "pass";
                                        } else {
                                            Result = "fail";
                                            Actual = s;
                                        }
                                    } else {
                                        driver.manage().timeouts().implicitlyWait(78, TimeUnit.SECONDS);
                                        List<WebElement> cells = driver.findElements(By.xpath(".//*[@id='ListProposalGrid']/tbody/tr[2]/td[2]/div/div[1]/table/tbody/tr/td[3]"));

                                        for (WebElement cell : cells) {
                                            String fiels = cell.getText();
                                            System.out.println(fiels);

                                            if (fiels.equals(value)) {
                                                cell.click();
                                           /* driver.switchTo().frame("ifrmProjectInfo");*/
                                                Result = "pass";
                                                break;

                                            } else {
                                                Result = "fails";
                                                Actual = "File not Found";
                                            }
                                        }


                                    }
                                } catch (Throwable e) {

                                    System.out.println(e.getMessage());
                                }


                            break;

                        case "Click on Building Deatils":
                            driver.switchTo().parentFrame();
                            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
                            application.ClickBuildig_Deatils_Tab();
                            break;

                        case "Click on Submit Building":
                            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                            application.ClickBuilding_Submit();
                            driver.switchTo().parentFrame();

                            break;
/*---------------------------------------------- Drawing Deatials --------------------------------------------------------*/
                        case "Attach Drawing":
                            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                            application.ClickDrawing_Tab();
                            driver.switchTo().frame("ifrmDrawings");
                            String St = application.getDrawing_Data().getText();
                            if (St.equals("No data found")) {
                                driver.findElement(By.id("btnAttached")).click();
                                if ((ExpectedConditions.alertIsPresent()) == null) {

                                } else {
                                    Alert alert = driver.switchTo().alert();

                                    //  Actual = driver.switchTo().alert().getText();
                                    Thread.sleep(300);
                                    alert.accept();
                                }
                                Thread.sleep(300);
                                BeforeWH(driver);

                                WebElement ss = driver.findElement(By.id("RadAsyncUpload1file0"));
                                ss.click();
                                Thread.sleep(6000);
                                AttachFuntn(driver, FilePath2);
                                Thread.sleep(700);
                                driver.switchTo().window(WinHandleBefore1);
                                if ((ExpectedConditions.alertIsPresent()) == null) {

                                } else {
                                    Alert alert = driver.switchTo().alert();

                                    //  Actual = driver.switchTo().alert().getText();
                                    Thread.sleep(300);
                                    alert.accept();
                                    Thread.sleep(70);
                                    driver.switchTo().parentFrame();
                                }

                            } else {
                                driver.findElement(By.id("btnAttached")).click();
                                if ((ExpectedConditions.alertIsPresent()) == null) {

                                } else {
                                    Alert alert = driver.switchTo().alert();

                                    //  Actual = driver.switchTo().alert().getText();
                                    Thread.sleep(300);
                                    alert.accept();
                                    Thread.sleep(70);


                                }
                            }
                            driver.switchTo().parentFrame();
                            driver.findElement(By.xpath(".//*[@id='ProjectTab']/a")).click();
                            driver.switchTo().frame("ifrmProjectInfo");
                            Result = "pass";
                            break;
/*---------------------------------------------- Document Deatials --------------------------------------------------------*/
                        case "Click on Document Tab":
                            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                            try{

                                application.ClickDocument_Tab();
                                driver.switchTo().frame("ifrmDocuments");
                                Result = "pass";
                                break;
                            }catch (Throwable e)
                            {
                                Result="fail";
                                Actual="File not Found";
                                System.out.println(e.getMessage());
                            }
                            break;

                        case "Click On Types Of Document":
                            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


                            try {
                                List<WebElement> cells = driver.findElements(By.xpath(".//*[@id='RadTabStrip1']/div/ul/li/a/span/span"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();
                                    System.out.println(fiels);

                                    if (fiels.equals(value))
                                        cell.click();
                                    Result = "pass";

                                }
                            } catch (Throwable e) {
                                System.out.println(e.getMessage());
                            }
                            Result = "pass";


                            break;

                        case "Attch medatory doc":
                            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

                            try {
                                List<WebElement> cells = driver.findElements(By.xpath(".//*[@id='RadTabStrip1']/div/ul/li/a/span/span"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();


                                    if (fiels.equals(value)) {
                                        cell.click();
                                        System.out.println(fiels);
                                        if ("Building Plan Primary Documents".equals(value)) {

                                            for (int k = 1; k < 55; k++) {


                                                try {

                                                    if (k == 5) {
                                                        int g = 2 + k;
                                                        k = g;
                                                    } else {

                                                    }
                                                    if (k == 13) {
                                                        int g = 35 + k;
                                                        k = g;
                                                    } else {

                                                    }
                                                    if (k == 49) {
                                                        int g = 5 + k;
                                                        k = g;
                                                    } else {

                                                    }
                                                    Thread.sleep(400);
                                                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                                                    WebElement fiels3 = driver.findElement(By.xpath(".//*[@id='category_Doc" + k + "']/div/table/tbody/tr[2]/td[2]"));
                                                    String d = fiels3.getText();
                                                    System.out.println(d);
                                                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                                                    WebElement df = driver.findElement(By.xpath(".//*[@id='category_Doc" + k + "']/div/table/tbody/tr[2]/td[3]/a"));
                                                    String y = df.getText();
                                                    if (!y.equals("Attach Files")) {
                                                        System.out.println("E");
                                                    } else {
                                                        df.click();
                                                        System.out.println(k);
                                                        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

                                                        driver.switchTo().frame("RadWindowContentFrameRadWindowManager2_RadPopupWindow");
                                                        driver.findElement(By.xpath("//html/body/form/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input")).click();


                                                        BeforeWH(driver);
                                                        WebElement ss = driver.findElement(By.id("RadAsyncUpload1file0"));
                                                        ss.click();
                                                        Thread.sleep(600);
                                                        AttachFuntn(driver, FilePath);
                                                        System.out.println(driver.switchTo().window(WinHandleBefore1));
                                                        driver.switchTo().frame("ifrmListing");
                                                        Thread.sleep(70);

                                                        driver.switchTo().frame("ifrmDocuments");
                                                        System.out.println("pass");
                                                        driver.findElement(By.xpath("html/body/span/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/img")).click();

                                                        System.out.println(k);

                                                    }

                                                } catch (Throwable d) {
                                                    System.out.println(d.getMessage());
                                                }
                                                Result = "pass";
                                            }
                                            System.out.println("proposal");
                                        } else {
                                            System.out.println("Fire");
                                            for (int l = 35; l < 52; l++) {

                                                if (l == 39) {
                                                    int r = 12 + l;
                                                    l = r;
                                                } else {

                                                }

                                                try {
                                                    Thread.sleep(400);
                                                    WebElement fiels3 = driver.findElement(By.xpath(".//*[@id='category_Doc" + l + "']/div/table/tbody/tr[2]/td[2]"));
                                                    String d = fiels3.getText();
                                                    System.out.println(d);

                                                    Thread.sleep(400);
                                                    WebElement ty = driver.findElement(By.xpath(".//*[@id='category_Doc" + l + "']/div/table/tbody/tr[2]/td[3]/a"));
                                                    String h = ty.getText();
                                                    System.out.println(l);
                                                    if (!h.equals("Attach Files")) {
                                                    } else {
                                                        ty.click();
                                                        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

                                                        driver.switchTo().frame("RadWindowContentFrameRadWindowManager2_RadPopupWindow");
                                                        driver.findElement(By.xpath("//html/body/form/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input")).click();


                                                        BeforeWH(driver);
                                                        WebElement ss = driver.findElement(By.id("RadAsyncUpload1file0"));
                                                        ss.click();
                                                        Thread.sleep(600);
                                                        AttachFuntn(driver, FilePath);
                                                        System.out.println(driver.switchTo().window(WinHandleBefore1));
                                                        driver.switchTo().frame("ifrmListing");


                                                        driver.switchTo().frame("ifrmDocuments");
                                                        System.out.println("pass");
                                                        driver.findElement(By.xpath("html/body/span/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/img")).click();

                                                    }


                                                } catch (Throwable d) {
                                                    System.out.println(d.getMessage());

                                                }

                                            }

                                        }

                                    } else {
                                        System.out.println("NoCC");
                                    }

                                }
                            } catch (Throwable e) {
                                System.out.println(e.getMessage());

                                Result = "pass";}

                            // driver.switchTo().parentFrame();
                            break;

                        case "Attach Additional Document":


                            try {
                                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                                System.out.println(Actvalue);
                                try {
                                    if ("Building Plan Additional Documents".equals(Actvalue)) {
                                        System.out.println("Proposal");
                                        for (int k = 13; k < 54; k++) {

                                            if (k == 18) {
                                                int r = 4 + k;
                                                k = r;
                                            }
                                            if (k == 35) {
                                                int r = 17 + k;
                                                k = r;
                                            }
                                            try {
                                                Thread.sleep(400);
                                                WebElement fiels3 = driver.findElement(By.xpath(".//*[@id='category_Doc" + k + "']/div/table/tbody/tr[2]/td[2]"));
                                                String d = fiels3.getText();
                                                System.out.println(d);
                                                if (d.equals(value)) {
                                                    WebElement Chckbox = driver.findElement(By.xpath(".//*[@id='Checkbox" + k + "']"));
                                                    if (!Chckbox.isSelected()) {
                                                        Chckbox.click();
                                                        System.out.println("ch");
                                                        System.out.println(k);
                                                        application.ClickSubmit_Btn();
                                                        Thread.sleep(30);
                                                        driver.findElement(By.xpath(".//*[@id='CloseButtonAlert']")).click();
                                                        Thread.sleep(23);

                                                        driver.findElement(By.xpath(".//*[@id='category_Doc" + k + "']/div/table/tbody/tr[2]/td[3]/a")).click();
                                                        driver.switchTo().frame("RadWindowContentFrameRadWindowManager2_RadPopupWindow");
                                                        driver.findElement(By.xpath("//html/body/form/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input")).click();


                                                        BeforeWH(driver);
                                                        WebElement ss = driver.findElement(By.id("RadAsyncUpload1file0"));
                                                        ss.click();
                                                        Thread.sleep(700);
                                                        AttachFuntn(driver, FilePath);
                                                        System.out.println(driver.switchTo().window(WinHandleBefore1));
                                                        driver.switchTo().frame("ifrmListing");


                                                        driver.switchTo().frame("ifrmDocuments");
                                                        System.out.println("pass");
                                                        Thread.sleep(70);
                                                        driver.findElement(By.xpath("html/body/span/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/img")).click();

                                                    } else {
                                                        WebElement ty = driver.findElement(By.xpath(".//*[@id='category_Doc" + k + "']/div/table/tbody/tr[2]/td[3]/a"));
                                                        String h = ty.getText();
                                                        System.out.println(k);
                                                        if (h.equals("Attach Files")) {
                                                            driver.findElement(By.xpath(".//*[@id='category_Doc" + k + "']/div/table/tbody/tr[2]/td[3]/a")).click();
                                                            driver.switchTo().frame("RadWindowContentFrameRadWindowManager2_RadPopupWindow");
                                                            driver.findElement(By.xpath("//html/body/form/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input")).click();


                                                            BeforeWH(driver);
                                                            WebElement ss = driver.findElement(By.id("RadAsyncUpload1file0"));
                                                            ss.click();
                                                            Thread.sleep(600);
                                                            AttachFuntn(driver, FilePath);
                                                            System.out.println(driver.switchTo().window(WinHandleBefore1));
                                                            driver.switchTo().frame("ifrmListing");


                                                            driver.switchTo().frame("ifrmDocuments");
                                                            System.out.println("pass");
                                                            System.out.println("pass");
                                                            Thread.sleep(70);
                                                            driver.findElement(By.xpath("html/body/span/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/img")).click();

                                                        }

                                                    }

                                                    break;
                                                } else {
                                                    System.out.println("Document not Availble");
                                                }
                                            } catch (Throwable ls) {

                                            }


                                        }
                                    } else {
                                        System.out.println("Fire");
                                        for (int l = 39; l < 51; l++) {

                                            if (l == 43) {
                                                int r = 2 + l;
                                                l = r;
                                            }
                                            if (l == 46) {
                                                int r = 1 + l;
                                                l = r;
                                            }

                                            try {
                                                Thread.sleep(400);
                                                WebElement fiels3 = driver.findElement(By.xpath(".//*[@id='category_Doc" + l + "']/div/table/tbody/tr[2]/td[2]"));
                                                String d = fiels3.getText();
                                                System.out.println(d);
                                                if (d.equals(value)) {
                                                    WebElement Chckbox = driver.findElement(By.xpath(".//*[@id='Checkbox" + l + "']"));
                                                    if (!Chckbox.isSelected()) {
                                                        Chckbox.click();
                                                        System.out.println("ch");
                                                        System.out.println(l);
                                                        application.ClickSubmit_Btn();
                                                        Thread.sleep(30);
                                                        driver.findElement(By.xpath(".//*[@id='CloseButtonAlert']")).click();
                                                        Thread.sleep(30);

                                                        driver.findElement(By.xpath(".//*[@id='category_Doc" + l + "']/div/table/tbody/tr[2]/td[3]/a")).click();
                                                        driver.switchTo().frame("RadWindowContentFrameRadWindowManager2_RadPopupWindow");
                                                        driver.findElement(By.xpath("//html/body/form/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input")).click();


                                                        BeforeWH(driver);
                                                        WebElement ss = driver.findElement(By.id("RadAsyncUpload1file0"));
                                                        ss.click();
                                                        Thread.sleep(600);
                                                        AttachFuntn(driver, FilePath);
                                                        System.out.println(driver.switchTo().window(WinHandleBefore1));
                                                        driver.switchTo().frame("ifrmListing");


                                                        driver.switchTo().frame("ifrmDocuments");
                                                        System.out.println("pass");
                                                        driver.findElement(By.xpath("html/body/span/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/img")).click();

                                                    } else {
                                                        WebElement ty = driver.findElement(By.xpath(".//*[@id='category_Doc" + l + "']/div/table/tbody/tr[2]/td[3]/a"));
                                                        String h = ty.getText();
                                                        System.out.println(l);
                                                        if (h.equals("Attach Files")) {
                                                            driver.findElement(By.xpath(".//*[@id='category_Doc" + l + "']/div/table/tbody/tr[2]/td[3]/a")).click();
                                                            driver.switchTo().frame("RadWindowContentFrameRadWindowManager2_RadPopupWindow");
                                                            driver.findElement(By.xpath("//html/body/form/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input")).click();


                                                            BeforeWH(driver);
                                                            WebElement ss = driver.findElement(By.id("RadAsyncUpload1file0"));
                                                            ss.click();
                                                            Thread.sleep(600);
                                                            AttachFuntn(driver, FilePath);
                                                            System.out.println(driver.switchTo().window(WinHandleBefore1));
                                                            driver.switchTo().frame("ifrmListing");


                                                            driver.switchTo().frame("ifrmDocuments");
                                                            System.out.println("pass");
                                                            driver.findElement(By.xpath("html/body/span/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/img")).click();

                                                        }

                                                    }
                                                    break;
                                                }

                                            } catch (Throwable d) {
                                                System.out.println(d.getMessage());

                                            }


                                        }
                                        Result = "pass";
                                        driver.switchTo().parentFrame();
                                    }
                                    break;


                                } catch (Throwable e) {
                                    System.out.println(e.getMessage());
                                }
                                Result = "pass";
                            } catch (Throwable m) {
                                System.out.println(m.getMessage());
                            }

                            break;


                        case "Click on Additional Document":

                            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                            try {
                                List<WebElement> cells = driver.findElements(By.xpath(".//*[@id='RadTabStrip1']/div/ul/li/a/span/span"));

                                for (WebElement cell : cells) {
                                    Actvalue = cell.getText();


                                    if (Actvalue.equals(value)) {
                                        cell.click();
                                        break;
                                    }
                                }
                            } catch (Throwable d) {
                                System.out.println(d.getMessage());
                            }
                            Result = "pass";
                            break;

                    }
                    break;
                case "SELECT":

                    switch (objectName) {

                        case"Mode of Payment":
                            try {
                                List<WebElement> cells = driver.findElements(By.xpath(".//*[@id='trMode']/td[4]/span"));
                                for (WebElement cell : cells) {

                                    String Ra=cell.getText();
                                    if(cell.equals(value))
                                    {
                                        List<WebElement> RADi = driver.findElements(By.xpath(".//*[@id='trMode']/td[4]/input["+rr+"]"));
                                        for (WebElement RAD1i : RADi){  RAD1i.click();}
                                    }

                                }++rr;
                                break;
                            }catch (Throwable e)
                            {
                                System.out.println(e.getMessage());
                            }
                            break;

                        case"Select Bank Name":

                            WebElement Bank=driver.findElement(By.xpath(".//*[@id='cboBankName']"));
                            Select combo1=new Select(Bank);
                            combo1.selectByVisibleText(value);

                            break;

                       /* case"Challan Type":
                            driver.switchTo().frame("ifrmListing");
                            WebElement d22=driver.findElement(By.xpath("./*//*[@id='cboChallanType']"));
                            String dd222=d22.getText();

                            Select combo1=new Select(d22);
                            combo1.selectByVisibleText(value);
                            System.out.println(dd222);
                            break;*/


                        case "Risk paramitter":

                            List<WebElement> cell2 = driver.findElements(By.xpath("html/body/form/table[2]/tbody/tr/td[2]/span"));

                            for (WebElement cell12 : cell2) {
                                String fiels = cell12.getText();
                                if (value.equals(fiels))
                                {
                                    break;
                                }}
                            Result = "pass";
                            break;

                        case "Select Proposal Risk parameter":
                            WebElement d   = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr["+x+"]/td[5]/select"));
                            Select combo=new Select(d);
                            combo.selectByVisibleText(value);
                            ++x;  ++x;
                            Result = "pass";
                            break;

                        case "Proposal Type":
                            application.selectProposal_Type(value);
                            Result = "pass";
                            break;

                        case "Company Activity":
                            Thread.sleep(60);
                            try {
                                driver.manage().timeouts().implicitlyWait(45,TimeUnit.SECONDS);
                                List<WebElement> cells = driver.findElements(By.xpath("./*//*[@id='cboCompanyActivitys']/option"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();
                                    System.out.println(fiels);

                                    if (fiels.equals(value))
                                        cell.click();
                                    Result = "pass";
                                }
                            } catch (Throwable e) {
                            }
                            break;

                        case "Proposal Use":
                            application.selectProposal_Use(value);
                            Result = "pass";
                            break;

                        case "Plot Possession / A to L Date":
                            DateFun(driver, "09/08/2017");
                            Result = "pass";
                            break;

                        case "Industrial Area":
                            application.selectIndustrial_Area(value);
                            Result = "pass";
                            break;

                        case "Concerned SPA":
                            application.selectConcerned_SPA(value);
                            Result = "pass";
                            break;

                        case "MPCB Consent":
                            application.selectMPCB_Consent(value);
                            Result = "pass";
                            break;
/*---------------------------------------------- Building Deatials --------------------------------------------------------*/

                        case "Building Use":
                            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                            Actions actions = new Actions(driver);
                            actions.moveToElement(application.getBuilding_Use());
                            actions.click();
                            actions.build().perform();
                            try {

                                List<WebElement> cells = driver.findElements(By.xpath("./*//*[@class='GLMenuBody GLEnumMenuBody']/div//div"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();
                                    System.out.println(fiels);

                                    if (fiels.equals(value))
                                        cell.click();
                                    Result = "pass";
                                }
                            } catch (Throwable e) {
                                System.out.println(e);
                            }
                            break;
                        case "Building Subuse":
                            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                            Actions action = new Actions(driver);
                            action.moveToElement(application.getBuilding_Subuse());
                            action.click();

                            action.build().perform();
                            try {

                                List<WebElement> cells = driver.findElements(By.xpath("//div[@class='GLMenuMain GLEnumMenuMain']/div/div/div/div/div"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();
                                    System.out.println(fiels);

                                    if (fiels.equals(value))
                                        cell.click();
                                    Result = "pass";
                                }
                            } catch (Throwable e) {
                                System.out.println(e);
                            }
                            break;

                        case "Building Type":
                            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                            Actions action1 = new Actions(driver);
                            action1.moveToElement(application.getBuilding_Type());
                            action1.click();

                            action1.build().perform();
                            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                            try {

                                List<WebElement> cells = driver.findElements(By.xpath("//div[@class='GLMenuMain GLEnumMenuMain']/div/div/div/div/div"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();
                                    System.out.println(fiels);

                                    if (fiels.equals(value))
                                        cell.click();
                                    Result = "pass";
                                }
                            } catch (Throwable e) {
                                System.out.println(e);
                            }
                            break;

                        case "Building Strucher":
                            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                            Actions action3 = new Actions(driver);
                            action3.moveToElement(application.getBuilding_Strucher());
                            action3.click();

                            action3.build().perform();
                            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                            try {

                                List<WebElement> cells = driver.findElements(By.xpath("//div[@class='GLMenuMain GLEnumMenuMain']/div/div/div/div/div"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();
                                    System.out.println(fiels);

                                    if (fiels.equals(value))
                                        cell.click();
                                    Result = "pass";
                                }
                            } catch (Throwable e) {
                                System.out.println(e);
                            }
                            break;


                    }
                    break;
                case "SETTEXT":

                    switch (objectName) {

                        case "Enter Keyword for search":

                            Thread.sleep(3000);
                            Actions actionsff = new Actions(driver);
                            actionsff.moveToElement(driver.findElement(By.xpath(".//*[@id='form1']/div[3]//div[5]/div//div[2]/table/tbody/tr/td[2]/div")));
                            actionsff.doubleClick();
                            actionsff.sendKeys(value);
                            actionsff.build().perform();
                            Result="pass";

break;
                        case"Submit Note sheet Remarks":
                            Actions act23=  new Actions(driver);
                            try{
                                act23.moveToElement(driver.findElement(By.xpath("//iframe[@frameborder='0']"))).doubleClick().sendKeys(value).build().perform();
                                Result="pass";
                                Thread.sleep(30000);
                                driver.findElement(By.xpath(".//*[@id='btnSave']")).click();

                               driver.quit();
                                }catch (Throwable h){
                                Result="fail";
                                Actual=h.getMessage();
                              driver.quit();
                            }

                            break;

                        case "SWC File No":
                            driver.findElement(By.xpath(".//*[@id='txtFile']")).sendKeys(value);
                            driver.findElement(By.xpath(".//*//fieldset/table/tbody/tr[4]/td[4]/table/tbody/tr/td[1]/input")).click();
                            Result = "pass";
                            break;

                        case "UTR No.":
                            driver.findElement(By.xpath(".//*[@id='txtPayOrderNo']")).sendKeys(value);
                            Result = "pass";
                            break;
                        case "Branch Name":
                            driver.findElement(By.xpath(".//*[@id='txtChequeBranch']")).sendKeys(value);
                            Result = "pass";
                            break;


                        case "Set proposed value":
                            driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr["+x+"]/td[4]/input")).sendKeys(value);
                            Result = "pass";
                            break;

                        case "Proposal Title":
                            application.setProposal_Title(value);
                            Result = "pass";
                            break;

                        case "Plot No":
                            application.setPlot_No(value);
                            Result = "pass";
                            break;

                        case "Applicant Name":
                            application.setApplicant_Name(value);

                            final String fieldValue9 = application.getApplicant_Name().getAttribute("value");
                            if (fieldValue9.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(300);
                                        alert.accept();
                                        if (Actual.equals(Expected)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                        System.out.println(Actual);
                                        //    Thread.sleep(50);

                                    }

                                } catch (Throwable e) {
                                    Actual = "Alert message not display.";
                                    Result = "Fail";
                                }


                            } else {
                                if (fieldValue9.equals(value)) {
                                    if (!String.matcher(fieldValue9).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display.";
                                                Result = "Fail";
                                            } else {
                                                Alert alert = driver.switchTo().alert();
                                                Actual = driver.switchTo().alert().getText();
                                                if (Actual.equals(Expected)) {
                                                    Result = "pass";
                                                } else {
                                                    Result = "Fail";
                                                }
                                                System.out.println(Actual);
                                                //    Thread.sleep(50);
                                                alert.accept();

                                            }

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {
                                        Result = "pass";
                                        System.out.println(fieldValue9);
                                        System.out.println(Result);
                                    }
                                } else {
                                    if (Actual.equals(Expected)) {
                                        Result = "pass";
                                    } else {
                                        Result = "Fail";
                                    }
                                }
                            }

                            break;

                        case "Other Structure Area":

                            application.getOther_Structure_Area().clear();
                            application.setOther_Structure_Area(value);

                            final String fieldValue7 = application.getOther_Structure_Area().getAttribute("value");
                            if (fieldValue7.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(300);
                                        alert.accept();
                                        if (Actual.equals(Expected)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                        System.out.println(Actual);
                                        //    Thread.sleep(50);

                                    }

                                } catch (Throwable e) {
                                    Actual = "Alert message not display.";
                                    Result = "Fail";
                                }


                            } else {
                                if (fieldValue7.equals(value)) {

                                    System.out.println(fieldValue7);

                                    if (!Flot.matcher(fieldValue7).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display.";
                                                Result = "Fail";
                                            } else {
                                                Alert alert = driver.switchTo().alert();
                                                Actual = driver.switchTo().alert().getText();
                                                if (Actual.equals(Expected)) {
                                                    Result = "pass";
                                                } else {
                                                    Result = "Fail";
                                                }
                                                System.out.println(Actual);
                                                //    Thread.sleep(50);
                                                alert.accept();

                                            }

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {
                                        Result = "pass";
                                    }
                                } else {
                                    Actual = "Other Structure Area not be accept other than flot value ";

                                    Result = "fail";
                                }
                            }
                            break;

                        case "Shed Area":
                            application.getShed_Area().clear();
                            application.setShed_Area(value);

                            final String fieldValue6 = application.getShed_Area().getAttribute("value");
                            if (fieldValue6.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(300);
                                        alert.accept();
                                        if (Actual.equals(Expected)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                        System.out.println(Actual);
                                        //    Thread.sleep(50);

                                    }

                                } catch (Throwable e) {
                                    Actual = "Alert message not display.";
                                    Result = "Fail";
                                }


                            } else {
                                if (fieldValue6.equals(value)) {

                                    System.out.println(fieldValue6);

                                    if (!Flot.matcher(fieldValue6).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display.";
                                                Result = "Fail";
                                            } else {
                                                Alert alert = driver.switchTo().alert();
                                                Actual = driver.switchTo().alert().getText();
                                                if (Actual.equals(Expected)) {
                                                    Result = "pass";
                                                } else {
                                                    Result = "Fail";
                                                }
                                                System.out.println(Actual);
                                                //    Thread.sleep(50);
                                                alert.accept();

                                            }

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {
                                        Result = "pass";
                                    }
                                } else {
                                    Actual = "Shed Area not be accept other than flot value ";

                                    Result = "fail";
                                }
                            }
                            break;

                        case "RCC Area":
                            application.getRCC_Area().clear();
                            application.setRCC_Area(value);

                            final String fieldValue5 = application.getRCC_Area().getAttribute("value");
                            if (fieldValue5.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(300);
                                        alert.accept();
                                        if (Actual.equals(Expected)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                        System.out.println(Actual);
                                        //    Thread.sleep(50);

                                    }

                                } catch (Throwable e) {
                                    Actual = "Alert message not display.";
                                    Result = "Fail";
                                }


                            } else {
                                if (fieldValue5.equals(value)) {

                                    System.out.println(fieldValue5);

                                    if (!Flot.matcher(fieldValue5).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display.";
                                                Result = "Fail";
                                            } else {
                                                Alert alert = driver.switchTo().alert();
                                                Actual = driver.switchTo().alert().getText();
                                                if (Actual.equals(Expected)) {
                                                    Result = "pass";
                                                } else {
                                                    Result = "Fail";
                                                }
                                                System.out.println(Actual);
                                                //    Thread.sleep(50);
                                                alert.accept();

                                            }

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {
                                        Result = "pass";
                                    }
                                } else {
                                    Actual = "RCC Area not be accept other than flot value ";

                                    Result = "fail";
                                }
                            }
                            break;

                        case "Gross Built Up Area":
                            application.getGross_Built_Up_Area().clear();
                            application.setGross_Built_Up_Area(value);

                            final String fieldValue4 = application.getGross_Built_Up_Area().getAttribute("value");
                            if (fieldValue4.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(300);
                                        alert.accept();
                                        if (Actual.equals(Expected)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                        System.out.println(Actual);
                                        //    Thread.sleep(50);

                                    }

                                } catch (Throwable e) {
                                    Actual = "Alert message not display.";
                                    Result = "Fail";
                                }


                            } else {
                                if (fieldValue4.equals(value)) {

                                    System.out.println(fieldValue4);

                                    if (!Flot.matcher(fieldValue4).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display.";
                                                Result = "Fail";
                                            } else {
                                                Alert alert = driver.switchTo().alert();
                                                Actual = driver.switchTo().alert().getText();
                                                if (Actual.equals(Expected)) {
                                                    Result = "pass";
                                                } else {
                                                    Result = "Fail";
                                                }
                                                System.out.println(Actual);
                                                //    Thread.sleep(50);
                                                alert.accept();

                                            }

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {
                                        Result = "pass";
                                    }
                                } else {
                                    Actual = "Gross Built Up Area not be accept other than flot value ";

                                    Result = "fail";
                                }
                            }
                            break;

                        case "Basement Area":
                            application.getBasement_Area().clear();
                            application.setBasement_Area(value);

                            final String fieldValue3 = application.getBasement_Area().getAttribute("value");
                            if (fieldValue3.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(300);
                                        alert.accept();
                                        if (Actual.equals(Expected)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                        System.out.println(Actual);
                                        //    Thread.sleep(50);

                                    }

                                } catch (Throwable e) {
                                    Actual = "Alert message not display.";
                                    Result = "Fail";
                                }


                            } else {
                                if (fieldValue3.equals(value)) {

                                    System.out.println(fieldValue3);

                                    if (!Flot.matcher(fieldValue3).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display.";
                                                Result = "Fail";
                                            } else {
                                                Alert alert = driver.switchTo().alert();
                                                Actual = driver.switchTo().alert().getText();
                                                if (Actual.equals(Expected)) {
                                                    Result = "pass";
                                                } else {
                                                    Result = "Fail";
                                                }
                                                System.out.println(Actual);
                                                //    Thread.sleep(50);
                                                alert.accept();

                                            }

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {
                                        Result = "pass";
                                    }
                                } else {
                                    Actual = "Basement Area not be accept other than flot value ";

                                    Result = "fail";
                                }
                            }
                            break;

                        case "Plot Area":
                            application.getPlot_Area().clear();
                            application.setPlot_Area(value);

                            final String fieldValue2 = application.getPlot_Area().getAttribute("value");
                            if (fieldValue2.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(300);
                                        alert.accept();
                                        if (Actual.equals(Expected)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                        System.out.println(Actual);
                                        //    Thread.sleep(50);

                                    }

                                } catch (Throwable e) {
                                    Actual = "Alert message not display.";
                                    Result = "Fail";
                                }


                            } else {
                                if (fieldValue2.equals(value)) {

                                    System.out.println(fieldValue2);

                                    if (!Flot.matcher(fieldValue2).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display.";
                                                Result = "Fail";
                                            } else {
                                                Alert alert = driver.switchTo().alert();
                                                Actual = driver.switchTo().alert().getText();
                                                if (Actual.equals(Expected)) {
                                                    Result = "pass";
                                                } else {
                                                    Result = "Fail";
                                                }
                                                System.out.println(Actual);
                                                //    Thread.sleep(50);
                                                alert.accept();

                                            }

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {
                                        Result = "pass";
                                    }
                                } else {
                                    Actual = "Plot Area not be accept other than flot value ";

                                    Result = "fail";
                                }
                            }
                            break;

                        case "Total Building Height":
                            Thread.sleep(80);
                            application.getTotal_Building_Height().clear();
                            Thread.sleep(80);
                            application.setTotal_Building_Height(value);

                            final String fieldValue1 = application.getTotal_Building_Height().getAttribute("value");
                            if (fieldValue1.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(300);
                                        alert.accept();
                                        if (Actual.equals(Expected)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                        System.out.println(Actual);
                                        //    Thread.sleep(50);

                                    }

                                } catch (Throwable e) {
                                    Actual = "Alert message not display.";
                                    Result = "Fail";
                                }


                            } else {
                                if (fieldValue1.equals(value)) {

                                    System.out.println(fieldValue1);

                                    if (!Flot.matcher(fieldValue1).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display.";
                                                Result = "Fail";
                                            } else {
                                                Alert alert = driver.switchTo().alert();
                                                Actual = driver.switchTo().alert().getText();
                                                if (Actual.equals(Expected)) {
                                                    Result = "pass";
                                                } else {
                                                    Result = "Fail";
                                                }
                                                System.out.println(Actual);
                                                //    Thread.sleep(50);
                                                alert.accept();

                                            }

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {
                                        Result = "pass";
                                    }
                                } else {
                                    Actual = "Building Height not be accept other than flot value ";

                                    Result = "fail";
                                }
                            }
                            break;

                        case "Ready Reckoner Rate":
                            application.getReady_Reckoner_Rate().clear();
                            application.setReady_Reckoner_Rate(value);

                            final String fieldValue = application.getReady_Reckoner_Rate().getAttribute("value");
                            if (fieldValue.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(300);
                                        alert.accept();
                                        if (Actual.equals(Expected)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                        System.out.println(Actual);
                                        //    Thread.sleep(50);

                                    }

                                } catch (Throwable e) {
                                    Actual = "Alert message not display.";
                                    Result = "Fail";
                                }


                            } else {
                                if (fieldValue.equals(value)) {

                                    System.out.println(fieldValue);

                                    if (!Flot.matcher(fieldValue).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display.";
                                                Result = "Fail";
                                            } else {
                                                Alert alert = driver.switchTo().alert();
                                                Actual = driver.switchTo().alert().getText();
                                                if (Actual.equals(Expected)) {
                                                    Result = "pass";
                                                } else {
                                                    Result = "Fail";
                                                }
                                                System.out.println(Actual);
                                                //    Thread.sleep(50);
                                                alert.accept();

                                            }

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {
                                        Result = "pass";
                                    }
                                } else {
                                    Actual = "Ready Reckoner Rate not be accept other than flot value ";

                                    Result = "fail";
                                }
                            }
                            break;

                        case "Land_Ready Reckoner Rate":
                            application.getLand_Ready_Reckoner_Rate().clear();
                            application.setLand_Ready_Reckoner_Rate(value);

                            final String fieldValu = application.getLand_Ready_Reckoner_Rate().getAttribute("value");
                            if (fieldValu.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(300);
                                        alert.accept();
                                        if (Actual.equals(Expected)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                        System.out.println(Actual);
                                        //    Thread.sleep(50);

                                    }

                                } catch (Throwable e) {
                                    Actual = "Alert message not display.";
                                    Result = "Fail";
                                }


                            } else {
                                if (fieldValu.equals(value)) {

                                    //   System.out.println(fieldValue);

                                    if (!Flot.matcher(fieldValu).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display.";
                                                Result = "Fail";
                                            } else {
                                                Alert alert = driver.switchTo().alert();
                                                Actual = driver.switchTo().alert().getText();
                                                if (Actual.equals(Expected)) {
                                                    Result = "pass";
                                                } else {
                                                    Result = "Fail";
                                                }
                                                System.out.println(Actual);
                                                //    Thread.sleep(50);
                                                alert.accept();

                                            }

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {
                                        Result = "pass";
                                    }
                                } else {
                                    Actual = "Ready Reckoner Rate not be accept other than flot value ";

                                    Result = "fail";
                                }
                            }
                            break;
/*---------------------------------------------- Building Deatials --------------------------------------------------------*/

                        case "Building Name":

                            // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                            driver.switchTo().frame("ifrmBuildingDetails");
                            System.out.println("find");
                            Actions actions = new Actions(driver);
                            actions.moveToElement(application.getBuilding_Name());
                            actions.click();
                            actions.click();
                            actions.sendKeys(value);
                            actions.build().perform();
                            break;
                        case "Building rows":

                            System.out.println("find");
                            Actions actions2 = new Actions(driver);
                            actions2.moveToElement(application.getBuilding_Rows());
                            actions2.click();
                            actions2.click();
                            actions2.sendKeys(value);
                            actions2.build().perform();
                            break;

                        case "Building Height":

                            System.out.println("find");
                            Actions actions3 = new Actions(driver);
                            actions3.moveToElement(application.getBuilding_Height());
                            actions3.click();
                            actions3.click();
                            actions3.sendKeys(value);
                            actions3.build().perform();
                            break;

                        case "Building Floor":

                            System.out.println("find");
                            Actions actions4 = new Actions(driver);
                            actions4.moveToElement(application.getBuilding_Floors());
                            actions4.click();
                            actions4.click();
                            actions4.sendKeys(value);
                            actions4.build().perform();
                            break;


                    }
                    break;
                default:

                    break;
            }


            if (testcaseName.isEmpty()) {
                LastRow = n++;
                if (Result.equals("pass")) {
                    Label l5 = new Label(5, LastRow, "As Exptected", cellFormat1);
                    targetSheet.addCell(l5);
                    Label l6 = new Label(6, LastRow, "PASS", cellFormat4);
                    targetSheet.addCell(l6);
                } else {

                    Label l5 = new Label(5, LastRow, Actual, cellFormat1);
                    targetSheet.addCell(l5);
                    Label l6 = new Label(6, LastRow, "FAIL", cellFormat3);
                    targetSheet.addCell(l6);
                }
            } else {
                LastRow = n++;

            }
        } catch (NullPointerException e) {
        }


    }

    @DataProvider(name = "hybridData")
    public Object[][] getDataFromDataprovider() throws IOException {
        Object[][] object = null;
        FileInputStream fis = new FileInputStream("ExcelData/InputData/SPATestData.xls");
        HSSFWorkbook wb = new HSSFWorkbook(fis);
        HSSFSheet sh = wb.getSheet("SPA");
        //  HSSFRow rows = sh.getRow(1);
//Read keyword sheet
//Find number of rows in Expl.excel file
        int rowCount = sh.getLastRowNum() - sh.getFirstRowNum();
        System.out.println(rowCount);
        object = new Object[rowCount][5];
        for (int i = 1; i < rowCount; i++) {

            HSSFRow row = sh.getRow(i + 1);


            for (int j = 0; j < row.getLastCellNum(); j++) {
//                System.out.println(row.getCell(j).toString());
                object[i][j] = row.getCell(j).toString();

            }


        }
        return object;


    }



}
