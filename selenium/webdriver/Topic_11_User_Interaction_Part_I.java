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



public class Topic_11_User_Interaction_Part_I {
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
	   
	public void TC_01_Horver_Mouse_I() {
		driver.get("https://tiki.vn/");
	    action.moveToElement(driver.findElement(By.xpath("//span[@class='Userstyle__NoWrap-sc-6e6am-11 gtVgrD']"))).perform();
	    sleepInSecond(3);
	    Assert.assertEquals(driver.findElement(By.xpath("//button[@class='Userstyle__UserDropDownButton-sc-6e6am-10 dYkBsI'][contains(text(),'Đăng nhập')]")).getText(), "Đăng nhập");
		
	}
	
	public void TC_01_Horver_Mouse_II() {
     
		driver.get("https://www.myntra.com/");
		action.moveToElement(driver.findElement(By.xpath("//a[@class='desktop-main'][normalize-space()='Kids']"))).perform();
		sleepInSecond(2);
		driver.findElement(By.xpath("//a[@class='desktop-categoryName' and text()='Home & Bath']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='breadcrumbs-crumb' and text()='Kids Home Bath']")).isDisplayed());
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.myntra.com/kids-home-bath");
		
	}
	
	public void TC_01_Horver_Mouse_III() {
     driver.get("https://automationfc.github.io/jquery-selectable/");
     List<WebElement> retangleNumber = driver.findElements(By.cssSelector("#selectable>li"));
     System.out.println("Number of retangle = " + retangleNumber.size());
     // click and hold -> hover chuot den element -> nha chuot trai ra
     
     action.clickAndHold(retangleNumber.get(0))
     .moveToElement(retangleNumber.get(3))
     .release()
     .perform();
     sleepInSecond(3);
     //Assert.assertEquals(driver.findElement(By.cssSelector("#selectable>li.ui-selected")).getSize(), 4);
     
	}

	public void TC_02_Horver_Mouse_III() {
     driver.get("https://automationfc.github.io/jquery-selectable/");
     List<WebElement> retangleNumber = driver.findElements(By.cssSelector("#selectable>li"));
     //Nhan phim ctrl 
     action.keyDown(Keys.CONTROL).perform();
     
     // chon cac element dich (1-3-6-11) 
     action.click(retangleNumber.get(0));
     action.click(retangleNumber.get(2));
     action.click(retangleNumber.get(5));
     action.click(retangleNumber.get(10));
     
     action.keyUp(Keys.CONTROL).perform();

     // nha phim ctrl 
     Assert.assertEquals(driver.findElements(By.cssSelector("#selectable>li.ui-selected")).size(), 4);
     System.out.println(driver.findElements(By.cssSelector("#selectable>li.ui-selected")).size());
	}
	
	

	public void TC_03_Double_Click() {
     driver.get("https://automationfc.github.io/basic-form/index.html");
     
                             
     JSExcutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//button[text()='Double click me']")));
     
     action.doubleClick(driver.findElement(By.xpath("//button[text()='Double click me']"))).perform();
     Assert.assertTrue(driver.findElement(By.xpath("//p[@id='demo']")).isDisplayed());
     Assert.assertEquals(driver.findElement(By.xpath("//p[@id='demo']")).getText(), "Hello Automation Guys!");
    
	}
	
	public void TC_04_Right_Click() {
     driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
     //contextClick la right click
     action.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).perform();
     //hover cut menu
     action.moveToElement(driver.findElement(By.cssSelector(".context-menu-icon-cut"))).perform();
     
     Assert.assertTrue(driver.findElement(By.cssSelector(".context-menu-item.context-menu-icon.context-menu-icon-cut.context-menu-visible")).isDisplayed());
 
     action.click(driver.findElement(By.cssSelector(".context-menu-icon-cut"))).perform();
     
     Assert.assertEquals(driver.switchTo().alert().getText(), "clicked: cut");
     
     driver.switchTo().alert().accept();
	}
	
	@Test
	public void TC_07_Drag_And_Drop_HTML5() throws InterruptedException, IOException {
		driver.get("https://automationfc.github.io/drag-drop-html5/");
		jsHelper = readFile(jsHelper)+ "";
		
		
		//java_script = java_script + "$(\"" + sourceCss + "\").simulateDragDrop({ dropTarget: \"" + targetCss + "\"});";
	
	}
	
	public String readFile(String file) throws IOException {
		Charset cs = Charset.forName("UTF-8");
		FileInputStream stream = new FileInputStream(file);
		try {
			Reader reader = new BufferedReader(new InputStreamReader(stream, cs));
			StringBuilder builder = new StringBuilder();
			char[] buffer = new char[8192];
			int read;
			while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
				builder.append(buffer, 0, read);
			}
			return builder.toString();
		} finally {
			stream.close();
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
