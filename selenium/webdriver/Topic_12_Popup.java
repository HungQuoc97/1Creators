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



public class Topic_12_Popup {
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
		driver.get("https://ngoaingu24h.vn/");
		driver.findElement(By.xpath("//button[@class='login_ icon-before']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("div#modal-login-v1 div>div")).isDisplayed());
	    driver.findElement(By.cssSelector("input#account-input")).sendKeys("");
	    driver.findElement(By.cssSelector("input#password-input")).sendKeys("");
	    driver.findElement(By.cssSelector("button.btn-v1.btn-login-v1")).click();
	    Assert.assertEquals(driver.findElement(By.cssSelector("div#modal-login-v1 div.row.error-login-panel")).getText(),"Tên tài khoản không hợp lệ");
	    driver.findElement(By.cssSelector("div#modal-login-v1 button[type=\"button\"]")).click();
	    Assert.assertFalse(driver.findElement(By.cssSelector("div#modal-login-v1 div>div")).isDisplayed());
	    
	}

	public void TC_02_Ramdom_In_DOM() {
		driver.get("https://blog.testproject.io/");
		sleepInSecond(40);
	 // yeu cau cua mot ramdom popup thi phai close di de di qua dc cac step sau 
		// neu no ko hien thi thi thuc hien cac step sau 
	 WebElement popup = driver.findElement(By.cssSelector("div.mailch-wrap"));
	if(popup.isDisplayed()) {
		driver.findElement(By.cssSelector("div#close-mailch")).click();
		sleepInSecond(3);
	}
	else {
		System.out.println("Popup is not displayed");
	}
	driver.findElement(By.cssSelector("section#search-2 input[name=\"s\"]")).sendKeys("Selenium");
	driver.findElement(By.cssSelector("section#search-2 span.glass")).click();
	
	//verify thang co title = 'selenium'
	
	List<WebElement> articleTitle = driver.findElements(By.cssSelector("div.post-content>h3>a"));
	for(WebElement article : articleTitle) {
		Assert.assertTrue(article.getText().contains("Selenium"));
		System.out.println(article.getText());
	}
	
		
	}	
	//(neu hien thi va khong hien thi popup thi testcase deu co the chay dc bt )
	@Test
	public void TC_03_Ramdom_Not_In_DOM() {
	 driver.get("https://shopee.vn/");
	 sleepInSecond(3);
	 //neu element khong co trong DOM thi ham fintelement ko tim thay 
	 // het timeout se danh fail testcase tai step do
	 List<WebElement> pop_up = driver.findElements(By.cssSelector("div#modal img"));
	// neu element ko co trong DOM thi ham findElemet ko tim thay 
	// no se tra ve 1 list empty(size =0)
	// No se ko danh fail testcase 
	// khong throw exception
	 
	 if(pop_up.size() > 0 && pop_up.get(0).isDisplayed() ) {
		System.out.println("Popup is displayed");
		driver.findElement(By.cssSelector("div.shopee-popup__close-btn")).click();
		sleepInSecond(3);
	 }
	 else {
		System.out.println("Popup is not displayed");
	 }
	 
	 driver.findElement(By.cssSelector("div#main input")).sendKeys("Gundam MG");
	 driver.findElement(By.xpath("//button[@type='button']")).click();
		List<WebElement> articleTitle = driver.findElements(By.xpath("//*[@id=\"main\"]/div/div[3]/div/div[2]/div/div[2]//a"));
		for(WebElement article : articleTitle) {
			Assert.assertTrue(article.getText().contains("Gundam"));
			System.out.println(article.getText());
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
