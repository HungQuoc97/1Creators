package webdriver;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertArrayEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.awt.Checkbox;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.tools.Diagnostic;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;
import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.sun.corba.se.spi.orbutil.fsm.FSM;
import com.sun.corba.se.spi.orbutil.fsm.Input;
import com.sun.org.apache.bcel.internal.ExceptionConst;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import jdk.nashorn.internal.runtime.regexp.joni.constants.internal.Arguments;
import jdk.nashorn.internal.scripts.JS;
import sun.awt.windows.WWindowPeer;


public class Topic_16_Wait_6_Mixing {
	   WebDriver driver;
	   Select select; 
	   JavascriptExecutor JSExcutor;
       WebDriverWait explicitWait;
       String projectPath = System.getProperty("user.dir");

	   @BeforeClass
	   public void beforeClass() {
		  
		   System.setProperty("webdriver.chrome.driver",projectPath + "\\Libraries\\chromedriver.exe");
		   System.setProperty("webdriver.gecko.driver",projectPath + "\\Libraries\\geckodriver.exe");
		   driver = new FirefoxDriver();
		   explicitWait = new WebDriverWait(driver, 15);
		   //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);    // anh huong duy nhat den findElement findElements
		   
		   //JSExcutor = (JavascriptExecutor) driver;
		   //action = new Actions(driver);
		   //JSExcutor = (JavascriptExecutor) driver;
		     
		   
		}
	 


	public void TC_01_Element_Found_Implicit_Explicit() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		explicitWait = new WebDriverWait(driver, 15) ;
		driver.get("https://www.facebook.com/");
		showDateTimeNow("Start explicit: ");
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
		showDateTimeNow("End explicit - start Implicit: ");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("hungdo.mta@gmail.com");
        showDateTimeNow("End Implicit : ");
    }

	@Test 
	public void TC_02_Element_Not_Found_Implicit() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		showDateTimeNow("Start explicit: ");
		//try catch de truong hop trong try bi loi van chay cau lenh trong 
        try {
			driver.findElement(By.xpath("//input[@id='ss']")).sendKeys("hungdo.mta@gmail.com");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        showDateTimeNow("End Implicit : ");
    }

	@Test     //
	public void TC_03_Element_Not_Found_Implicit_Explicit() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		explicitWait = new WebDriverWait(driver, 10) ;
		driver.get("https://www.facebook.com/");
		
		//findElement truoc 
		// apply dieu kien
		// implicit se anh huong vao cac step co dung explicit
		showDateTimeNow("Start explicit: ");
		try {
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='1']")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		showDateTimeNow("End explicit:  ");
		
		// du dung explicit timeout thi ko anh huong vao viec findElement
		showDateTimeNow("Start implicit: ");
        try {
			driver.findElement(By.xpath("//input[@id='1']")).sendKeys("hungdo.mta@gmail.com");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        showDateTimeNow("End implicit : ");
    }
	@Test 
	public void TC_04_Element_Not_Found_Explicit_Param_By() {

    }
	
	@Test 
	public void TC_05_Element_Not_Found_Explicit_Param_WebElement() {

    }
	
	public void switchToWindowsByID(String parentId) {
		
		// get ra tat ca tab/windown đang có
		Set <String> allWindowns = driver.getWindowHandles();
		
		for (String id : allWindowns) {
			if(!id.equals(parentId)) {
				//id nao khac parenID thi switch vao id do
				driver.switchTo().window(id);
				
			}
		}
	}
	
	public void clicktoElementByJS(By by) {
		WebElement element = driver.findElement(by);
		JSExcutor.executeScript("arguments[0].click();", element);	
	}
 
	public void switchToWindowsByTitle(String expectedTile) {
		Set <String> allWindowns = driver.getWindowHandles();
		
		for(String id : allWindowns)
		{
			driver.switchTo().window(id);
			String windowTitle = driver.getTitle();
			
			// neu nhu ma = thi stop khong kiem tra tiep nua
			if (windowTitle.equals(expectedTile)) {
				System.out.println(windowTitle);
				break;
			}
		}
		
	}
	
	public void closeToWindowsByTitle(String parentId) {
		// get ra tat ca tab/windown đang có
		Set <String> allWindowns = driver.getWindowHandles();
		
		for (String id : allWindowns) {
			if(!id.equals(parentId)) {
				//id nao khac parenID thi switch vao id do
				driver.switchTo().window(id);
				driver.close();
				}
			//sau khi dong toan bo tab !parenId can phai swith lai tab parent
			driver.switchTo().window(parentId);
		}
	}
	
	public void showDateTimeNow(String status) {
		Date date = new Date();
		System.out.println("-------------------" + status + ": " + date.toString() + "------------------ ");
		//return date.toString();
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
