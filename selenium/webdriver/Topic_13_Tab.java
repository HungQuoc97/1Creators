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


public class Topic_13_Tab {
	   WebDriver driver;
	   Select select; 
	   JavascriptExecutor JSExcutor;
       WebDriverWait explicitWait;
       String projectPath = System.getProperty("user.dir");
       String jsHelper = projectPath + "dragAndDrop/drag_and_drop_helper.js";
       String chileID;
       Actions action;
	   @BeforeClass
	   public void beforeClass() {
		  
		   System.setProperty("webdriver.chrome.driver",projectPath + "\\Libraries\\chromedriver.exe");
		   System.setProperty("webdriver.gecko.driver",projectPath + "\\Libraries\\geckodriver.exe");
		   driver = new FirefoxDriver();
		   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		   explicitWait = new WebDriverWait(driver, 15);
		   driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		   JSExcutor = (JavascriptExecutor) driver;
		   action = new Actions(driver);
		   JSExcutor = (JavascriptExecutor) driver;
		}
	 


	@Test
	public void TC_Frame() {
      driver.get("https://automationfc.github.io/basic-form/index.html");
      
      String parentId = driver.getWindowHandle();
      System.out.println("Parent ID = " + parentId);
      
      driver.findElement(By.xpath("//a[normalize-space()='TIKI']")).click();
      driver.findElement(By.xpath("//a[normalize-space()='LAZADA']")).click();
      
      
      sleepInSecond(1);
      switchToWindowsByTitle("Tiki - Mua hàng online giá tốt, hàng chuẩn, ship nhanh");
      driver.findElement(By.xpath("//input")).sendKeys("Gundam");
      sleepInSecond(1);
      
      switchToWindowsByTitle("SELENIUM WEBDRIVER FORM DEMO");
      driver.findElement(By.cssSelector("#email")).sendKeys("hungdo.mta@gmail.com");
      
      sleepInSecond(1);
      switchToWindowsByTitle("LAZADA Vietnam™ - Mua Hàng Trực Tuyến Giá Tốt");
      driver.findElement(By.cssSelector("input#q")).sendKeys("Gundam");
      sleepInSecond(1);

      
    }

	
	public void clicktoElementByJS(By by) {
		WebElement element = driver.findElement(by);
		JSExcutor.executeScript("arguments[0].click();", element);	
	}
	
	//ham chi dung cho 2 windown or tab
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
	
 	//dung cho 2 or nhieu hon 2 widows or tab
	//swith vao tung windown truoc 
	//get ra title cua tung tab or windows
	// kiem tra vs title mong muon neu nhu = thi dung ko kiem tra tiep
	
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
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	void sleepInSecond(long timeoutInSecond) {
		try {
			Thread.sleep(timeoutInSecond * 1000);
		}
		catch (InterruptedException e) {
		e.printStackTrace();
		}
	}

}
