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


public class Topic_16_Wait_2_findElement {
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
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);    // anh huong duy nhat den findElement findElements
		   
		   //JSExcutor = (JavascriptExecutor) driver;
		   //action = new Actions(driver);
		   //JSExcutor = (JavascriptExecutor) driver;
		}
	 


	
	@Test 
	public void TC_01_FindElement() {
      driver.get("https://www.facebook.com/");
      // Single element
      // 1 - co duy nhat 1 element 
      // khong can cho het timeout cua implicit
      //- tuong tac len element luon
       driver.findElement(By.id("email")).sendKeys("hungdo.mta@gmail.com");
        
      // 2 - Co duy nhat 1 element
      // Cho het timeout cua implicit
      // Trong thoi gian cho cu moi nua s se tim lại 1 lan 
      // khi nao het timeout cua implicit thi se danh fail testcase và throw exception: NoSuchElementException
       
     // driver.findElement(By.id("address")).sendKeys("Viet Nam");
     // driver.findElement(By.id("pass")).sendKeys("123456");
      
      // 3 - Nhieu hon 1 element ( >= 2)
      // Khong can cho het timeout implicit 
      // No se lay cai element dau tien de tuong tac 
      // khong quan tam co bao nhieu matching node se lay thang dau tien de thao tac
       
      
      System.out.println(driver.findElement(By.xpath("//input")).getAttribute("name"));
      System.out.println(driver.findElement(By.xpath("//input")).getAttribute("type"));
      System.out.println(driver.findElement(By.xpath("//input")).getAttribute("value"));
      
}
	
	@Test 
	public void TC_02_FindElements() {
	  //driver.get("https://www.facebook.com/");
		driver.navigate().refresh();
	  // 1 - co duy nhat 1 element 
      // khong can cho het timeout cua implicit
      //- tuong tac len element luon
	   
	  driver.findElements(By.id("email")).get(0).sendKeys("hungdo.mta@gmail.com");
      System.out.println(driver.findElements(By.id("email")).size());
	  // 2 - khong co element nao het  -> Can test 1 element ko xuat hien tren UI va khong co trong DOM 
      //  cho het timeout cua implicit
      // trong thoi gian cho cu moi 0.5s se tim lai 1 lan 
	  // khi nao cho het timeout cua implicit thi se khong danh fail testcase 
	  // tra ve 1 list empty(rong/ko co phan tu (web element) nao het )
	  // chuyen qua step tiep theo
	  System.out.println(driver.findElements(By.id("address")).size());
      driver.findElement(By.id("pass")).sendKeys("123456");
      
      // 3 - Nhieu hon 1 element ( >= 2)
      // Khong can cho het timeout implicit 
      // Luu het tat ca cac elemnt vao trong list 
      
      List<WebElement> footerLink = driver.findElements(By.cssSelector(".uiList.pageFooterLinkList a"));
      System.out.println(footerLink.size());
      
      for (WebElement link : footerLink) {
    	  System.out.println(link.getText());
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
