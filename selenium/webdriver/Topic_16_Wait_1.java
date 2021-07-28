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


public class Topic_16_Wait_1 {
	   WebDriver driver;
	   Select select; 
	   JavascriptExecutor JSExcutor;
       WebDriverWait explicitWait;
       String projectPath = System.getProperty("user.dir");
       String jsHelper = projectPath + "dragAndDrop/drag_and_drop_helper.js";
       Actions action;
	   @BeforeClass
	   public void beforeClass() {
		  
		   System.setProperty("webdriver.chrome.driver",projectPath + "\\Libraries\\chromedriver.exe");
		   System.setProperty("webdriver.gecko.driver",projectPath + "\\Libraries\\geckodriver.exe");
		   driver = new FirefoxDriver();
		   
		
		   
		   explicitWait = new WebDriverWait(driver, 15);
		   
		   //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		   //JSExcutor = (JavascriptExecutor) driver;
		   //action = new Actions(driver);
		   //JSExcutor = (JavascriptExecutor) driver;
		}
	 


	public void TC_01_Visible_Displayed() {
      driver.get("https://facebook.com/");     
      //action -> verify -> Wait
      //wait luon truoc action verify
      //wait cho thang email input dc hien thi trong khoang tg 15s
      explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']")));
      //verify element hien thi
      Assert.assertTrue(driver.findElement(By.xpath("//input[@id='email']")).isDisplayed());
    }


	@Test 
	public void TC_02_Invisible_Displayed() {
      driver.get("https://facebook.com/"); 
      //wait cho button Tao tai khoan co the click   
      explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Tạo tài khoản mới']")));
      //action
      driver.findElement(By.xpath("//a[text()='Tạo tài khoản mới']")).click();
      // khong hien co tren UI nhung hien thi trong DOM
      explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@name='reg_email_confirmation__']")));
      explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Đăng ký']/parent::div/preceding-sibling::img")));
      driver.findElement(By.xpath("//div[text()='Đăng ký']/parent::div/preceding-sibling::img")).click();
      // ko co tren UI va khong co trong DOM
      explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='reg_box']")));
    }
    //TC_03_Presence su co mat phai co trong DOM neu ko co tescase se fail
	@Test   
	public void TC_03_Presence() {
      driver.get("https://facebook.com/"); 
      // Hien thi tren UI va co trong DOM -> PASS
      explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='email']")));
      explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Tạo tài khoản mới']")));
      driver.findElement(By.xpath("//a[text()='Tạo tài khoản mới']")).click();
      // Khong hien thi tren UI va van co trong DOM -> PASSS
      // dung cho 1 elemet thi dung of neu dung cho nhieu thi dung all
      explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='reg_email_confirmation__']")));
      explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Đăng ký']/parent::div/preceding-sibling::img")));
      driver.findElement(By.xpath("//div[text()='Đăng ký']/parent::div/preceding-sibling::img")).click();
      // Khong hien thi tren UI va khong co trong DOM -> FAIL
     // explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='reg_box']")));
      
    }
	
	@Test   // chi bat voi case ko co trong dom 
	public void TC_04_Staleness() {
	
      driver.get("https://facebook.com/");
      
      explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='email']")));
      explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Tạo tài khoản mới']")));
      driver.findElement(By.xpath("//a[text()='Tạo tài khoản mới']")).click();
      // hien thi tren UI va co trong DOM
      explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='reg']")));
      WebElement resgiterForm = driver.findElement(By.xpath("//form[@id='reg']"));
      // khong hien thi tren UI vaf co trong DOM
      WebElement confirmEmail = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")); 
   
      explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Đăng ký']/parent::div/preceding-sibling::img")));
      driver.findElement(By.xpath("//div[text()='Đăng ký']/parent::div/preceding-sibling::img")).click();
      
      // tai thoi diem click thi mong muon 2 gia tri khong con trong DOM
      // Khong hien thi tren UI va khong co trong DOM   
      explicitWait.until(ExpectedConditions.stalenessOf(resgiterForm));
      explicitWait.until(ExpectedConditions.stalenessOf(confirmEmail));
      
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
