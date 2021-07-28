package webdriver;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertArrayEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.awt.Checkbox;
import java.awt.Component;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
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
import javax.tools.Tool;
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
import com.sun.glass.events.KeyEvent;
import com.sun.org.apache.bcel.internal.ExceptionConst;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import jdk.nashorn.internal.runtime.regexp.joni.constants.internal.Arguments;
import jdk.nashorn.internal.scripts.JS;
import sun.awt.windows.WWindowPeer;


public class Topic_14_Upload {
	   WebDriver driver;
	   Select select; 
	   JavascriptExecutor JSExcutor;
       WebDriverWait explicitWait;
       String projectPath = System.getProperty("user.dir");
       String jsHelper = projectPath + "dragAndDrop/drag_and_drop_helper.js";
       String chileID;
       Actions action;
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
		   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		   
		   explicitWait = new WebDriverWait(driver, 15);
		   
		   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		   
		   JSExcutor = (JavascriptExecutor) driver;
		   action = new Actions(driver);
		   JSExcutor = (JavascriptExecutor) driver;
		}
	 


	public void TC_01() {
	
      if (driver.toString().contains("chrome") || driver.toString().contains("edge")) {
		//Runtime.getRuntime().exec(new String[] {})
	}
      else if (driver.toString().contains("firefox")) {
    	  //Runtime.getRuntime().exec(new String[] {})
	}
    }

	
	
	public void TC_02_Java_Robot() {
		driver.get("");
		
		uploadFile(FilePath_01);
		
		
	}
	
	@Test
	public void TC_03_Upload_Flow(){
	
		
		driver.get("https://gofile.io/uploadFiles");
		String parentId = driver.getWindowHandle();
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys( FilePath_01 + "\n" + FilePath_02 + "\n" + FilePath_03 );
      // driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg mb-1 uploadButton']")).click();
		//wait thang dowloadpage visible
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("rowUploadSuccess-downloadPage")));
		
		//verify
	    Assert.assertTrue(driver.findElement(By.id("rowUploadSuccess-downloadPage")).isDisplayed());
		
		driver.findElement(By.id("rowUploadSuccess-downloadPage")).click();
		
		switchToWindowsByID(parentId);
		
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='1.png']")).isDisplayed());
		
	}
	
	

	public static void uploadFile(String filePath) {
	
	try {
	//Setting clipboard with file location
	StringSelection select = new StringSelection(filePath);
	
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);
	//native key strokes for CTRL, V and ENTER keys
	Robot robot = new Robot();
	//nhan enter
	
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	//nhan ctrl - v
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	//nhan ctrl - V
	robot.keyRelease(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	//nhan enter
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	
	} catch (Exception exp) {
	exp.printStackTrace();
	}
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


	  public String generateEmail() {
    	Random rand = new Random();
    	return "oc" + rand.nextInt(9999) + "@qa.team";
    	
    }

}
