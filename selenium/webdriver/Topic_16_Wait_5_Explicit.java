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


public class Topic_16_Wait_5_Explicit {
	   WebDriver driver;
	   Select select; 
	   JavascriptExecutor JSExcutor;
       WebDriverWait explicitWait;
       String projectPath = System.getProperty("user.dir");
       String jsHelper = projectPath + "dragAndDrop/drag_and_drop_helper.js";
       Actions action;
       By startButton = By.cssSelector("#start>button");
       By loadingIcon = By.cssSelector("#loading");
       By helloworldText = By.xpath("//h4[text()='Hello World!']");
       Date date ;
       String FileName_1="1.png";
       String FileName_2="2.png";
       String FileName_3="3.png";
       String FilePath_01 = projectPath + "\\Upload_file\\"+FileName_1 ;
       String FilePath_02 = projectPath + "\\Upload_file\\"+FileName_2 ;
       String FilePath_03 = projectPath + "\\Upload_file\\"+FileName_3 ;
       
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
	 
		
	public void TC_01_Visible() {	
      driver.get("https://the-internet.herokuapp.com/dynamic_loading/2"); 
      driver.findElement(startButton).click();
      
      //cho cho hello world duoc hien thi
      explicitWait.until(ExpectedConditions.visibilityOfElementLocated(helloworldText));
      Assert.assertTrue(driver.findElement(helloworldText).isDisplayed());
}
	

	public void TC_02_Invisible () {
		
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/2"); 
	    driver.findElement(startButton).click();
		// cho cho loading icon biet mat (invisible)
		//explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon));
		  explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon));
		  Assert.assertTrue(driver.findElement(helloworldText).isDisplayed());
    }
	

	public void TC_03_Ajax_Loading () {
		driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		
		//Wait cho Date Picker hien thi
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ContentPlaceholder1_Label1"))); 
		Assert.assertEquals(driver.findElement(By.id("ctl00_ContentPlaceholder1_Label1")).getText(),"No Selected Dates to display.");
		driver.findElement(By.xpath("//a[text()='26']")).click();
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[not(@style='display:none;')]//div[@class='raDiv']")));	
		//verify date is selected
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='rcSelected']//a[text()='26']")));
		Assert.assertTrue(driver.findElement(By.xpath("//td[@class='rcSelected']//a[text()='26']")).isDisplayed());
		// verify  date is update Selected Date 
		Assert.assertEquals(driver.findElement(By.id("ctl00_ContentPlaceholder1_Label1")).getText(),"Monday, July 26, 2021");
		 
    }

	@Test 
	public void TC_04_Upload () {
		driver.get("https://gofile.io/uploadFiles");
		
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.uploadButton")));
		
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(FilePath_01 + "\n" + FilePath_02);
		//Wait choose server icon invisible icon loading
		System.out.println("Start sever icon= " + getDateTimeNow());
		
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#rowUploadProgress-selectServer")));
		System.out.println("Start sever icon= " + getDateTimeNow());
		// Wait for file loaded success
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements((By.cssSelector("div.progress")))));
		System.out.println("Start sever icon= " + getDateTimeNow());
		// Wait progress bar icon invisible
		//explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@role='progressbar']")));
		
		// Wait "Your files have been successfully uploaded" isdisplayed
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Your files have been successfully uploaded']")));
		Assert.assertTrue(driver.findElement(By.xpath("//h5[text()='Your files have been successfully uploaded']")).isDisplayed());
		
		System.out.println("Start sever icon= " + getDateTimeNow());
		// Wait button show files co the click 
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#rowUploadSuccess-showFiles")));
		driver.findElement(By.cssSelector("#rowUploadSuccess-showFiles")).click();
		// verify upload success
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='contentName' and text()='"+ FileName_1 +"']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='contentName' and text()='"+ FileName_2 +"']")).isDisplayed());
		
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
	
	public String getDateTimeNow() {
		Date date = new Date();
		return date.toString();
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
