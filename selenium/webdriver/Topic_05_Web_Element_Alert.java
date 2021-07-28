package webdriver;

import static org.testng.AssertJUnit.assertArrayEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;
import com.sun.org.apache.bcel.internal.ExceptionConst;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import jdk.nashorn.internal.runtime.regexp.joni.constants.internal.Arguments;
import netscape.javascript.JSException;


public class Topic_05_Web_Element_Alert {
	   WebDriver driver;
	   Select select;
       Alert alert;
   
	   JavascriptExecutor JSExcutor;

       WebDriverWait explicitWait;
       
       String projectPath = System.getProperty("user.dir");
	   
	   @BeforeClass
	   public void beforeClass() {
		
		   System.setProperty("webdriver.chrome.driver",projectPath + "\\Libraries\\chromedriver.exe");
		   System.setProperty("webdriver.gecko.driver",projectPath + "\\Libraries\\geckodriver.exe");
		   //driver = new ChromeDriver();
		   
		    driver = new FirefoxDriver();
			// wait cho element xuất hiện trong 1 khoảng thời gian xxx second 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//khai bao wait muc dich tro or tam dung 15s 
			explicitWait = new WebDriverWait(driver, 15);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
            //ep kieu tuong minh
			JSExcutor = (JavascriptExecutor) driver;  
		}
	   
	public void TC_01_Accpect_Alert() {
		driver.get("http://demo.guru99.com/v4/index.php");
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
	    //wait de doi alert hien thị
		//explicitWait.until(ExpectedConditions.alertIsPresent());
		//Swich to alert
		//alert = driver.switchTo().alert();
		
		//vua wait vua swich
		alert = explicitWait.until(ExpectedConditions.alertIsPresent());
		sleepInSecond(5);
		Assert.assertEquals(alert.getText(),"User or Password is not valid");
		alert.accept();
		
		//alert.dismiss();
		//alert.getText();
		//alert.sendKeys("");
		
	}
	
	
	public void TC_02_Comfirm_Alert() {
		
		
	}
	
	public void TC_03_Prompt_Alert() {
		
		
	}

	public void TC_04_Authentication_Alert() {
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credenti')]")).isDisplayed());
		
		
	}
	@Test
	public void TC_05_Authentication_Alert() {
		driver.get("http://the-internet.herokuapp.com/");
		String hrefValue = driver.findElement(By.xpath("//a[normalize-space()='Basic Auth']")).getAttribute("href");
		System.out.println(hrefValue);
		sleepInSecond(5);
	    passValueToUrl(hrefValue, "admin", "admin");
	    Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credenti')]")).isDisplayed());
	}
	
	public void passValueToUrl(String url, String username, String password){
		String[] hrefValue = url.split("//");
		url = hrefValue[0] + "//" + username + ":" + password + "@" + hrefValue[1];
		driver.get(url);
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
