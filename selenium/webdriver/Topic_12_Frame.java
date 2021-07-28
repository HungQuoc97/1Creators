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



public class Topic_12_Frame {
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
		   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		   explicitWait = new WebDriverWait(driver, 15);
		   driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		   JSExcutor = (JavascriptExecutor) driver;
		   action = new Actions(driver);
		   JSExcutor = (JavascriptExecutor) driver;
		}
	 


	@Test
	public void TC_Frame() {
		driver.get("https://kyna.vn/");
	   driver.findElement(By.xpath("//input[@id='live-search-bar']")).sendKeys("Excel");
	   driver.findElement(By.xpath("//button[@class='search-button']")).click();
	   
	   List<WebElement> courseName = driver.findElements(By.cssSelector("section div.content>h4"));
	   Assert.assertEquals(courseName.size(), 9);
	   
	   //vong lap for 
	   for (int i = 0; i < courseName.size(); i++) {
		   Assert.assertTrue(courseName.get(i).getText().toLowerCase().contains("excel"));
		   System.out.println(courseName.get(i).getText());
	}
	   
	   
	   
	   //vong lap for-each
	   for (WebElement course : courseName) {
		   //viet hoa viet thuong 
		Assert.assertTrue(course.getText().toLowerCase().contains("excel"));
		System.out.println(course.getText());
		
		// search khong phan biet hoa thuong 
		Assert.assertTrue(course.getText().matches("(.*)Excel(.*)"));
	}
    }
	
	
	
	
	public void clicktoElementByJS(By by) {
		WebElement element = driver.findElement(by);
		JSExcutor.executeScript("arguments[0].click();", element);	
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
