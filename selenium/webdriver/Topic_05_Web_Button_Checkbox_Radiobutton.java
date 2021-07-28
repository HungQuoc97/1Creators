package webdriver;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertArrayEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;

import java.awt.Checkbox;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
import jdk.nashorn.internal.scripts.JS;
import netscape.javascript.JSException;



public class Topic_05_Web_Button_Checkbox_Radiobutton {
	//biến driver đại diện cho selenium webdriver
	   WebDriver driver;
	   Select select;
	   //inject 1 javascrip code 
	   JavascriptExecutor JSExcutor;
       //wait 
       WebDriverWait explicitWait;
       String projectPath = System.getProperty("user.dir");
       boolean status;
	   
	   @BeforeClass
	   public void beforeClass() {

		   System.setProperty("webdriver.chrome.driver",projectPath + "\\Libraries\\chromedriver.exe");
		   System.setProperty("webdriver.gecko.driver",projectPath + "\\Libraries\\geckodriver.exe");
		   //driver = new ChromeDriver();
		    driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			explicitWait = new WebDriverWait(driver, 15);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			JSExcutor = (JavascriptExecutor) driver;  
		}
	@Test
	public void TC_01_dropdown() {
		driver.get("https://www.fahasa.com/customer/account/create?attempt=1");
		
		driver.findElement(By.cssSelector(".popup-login-tab-login")).click();
		//verify button disable
		status = driver.findElement(By.cssSelector(".fhs-btn-login")).isEnabled();
		System.out.println("Button status =" + status);
		// = false neu disable
		Assert.assertFalse(status);
	    driver.findElement(By.cssSelector("#login_username")).sendKeys("0961561897");   
		driver.findElement(By.cssSelector("#login_password")).sendKeys("123456");
		//verify button enabled
		status = driver.findElement(By.cssSelector(".fhs-btn-login")).isEnabled();
		System.out.println("Button status =" + status);
		Assert.assertTrue(status);
		driver.navigate().refresh();
		//trick
		//remove disabled attribute login button javascript selemium
		driver.findElement(By.cssSelector(".popup-login-tab-login")).click();
		JSExcutor.executeScript("arguments[0].removeAttribute('disabled')", driver.findElement(By.cssSelector(".fhs-btn-login")));
		sleepInSecond(5);
		//trick de tuong tac element bi an 
		//verify button enabled
		status = driver.findElement(By.cssSelector(".fhs-btn-login")).isEnabled();
		System.out.println("Button status =" + status);
		Assert.assertTrue(status);
		driver.findElement(By.cssSelector(".fhs-btn-login")).click();
		sleepInSecond(4);
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Số điện thoại/Email']/following-sibling::div[@class='fhs-input-alert']")).getText(), "Thông tin này không thể để trống");
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Mật khẩu']/following-sibling::div[@class='fhs-input-alert']")).getText(), "Thông tin này không thể để trống");
	    
		driver.navigate().refresh();
		JSExcutor.executeScript("arguments[0].removeAttribute('disabled')", driver.findElement(By.cssSelector(".fhs-btn-login")));
		sleepInSecond(3);
		JSExcutor.executeScript("arguments[0].click();", driver.findElement(By.cssSelector(".fhs-btn-login")));
		
	
	}
	

	public void TC_02_Radio_checkbox_default() {
	driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
	checkToCheckboxOrRadioButton(By.xpath("//label[text() ='Rear side airbags']/preceding-sibling::input"));
	sleepInSecond(2);
	Assert.assertTrue(driver.findElement(By.xpath("//label[text() ='Rear side airbags']/preceding-sibling::input")).isSelected());
	System.out.println(driver.findElement(By.xpath("//label[text() ='Rear side airbags']/preceding-sibling::input")).isSelected());
	
	unCheckToCheckboxOrRadioButton(By.xpath("//label[text() ='Rear side airbags']/preceding-sibling::input"));
    sleepInSecond(2);
    Assert.assertFalse(driver.findElement(By.xpath("//label[text() ='Rear side airbags']/preceding-sibling::input")).isSelected());
	// tuong tu radiobutton
    
	}
		
 	public void TC_03_checkboxSelecAll() {
    	
 		driver.get("https://automationfc.github.io/multiple-fields/");
 		
 		//select all checkbox
 		
 		List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
 		for(WebElement checkbox : checkboxes)
 			if(!checkbox.isSelected()) {
 				checkbox.click();
 				sleepInSecond(1);
 			}
 		for (WebElement checkbox : checkboxes) {
			Assert.assertTrue(checkbox.isSelected());
		}
    	
 	}
	
 	

    @Test 	
 	public void TC_04_radio_Checkbox_Custome() {
 		driver.get("https://material.angular.io/components/radio/examples");
 		
 		//By winterRadio = By.xpath("//input[@value='Winter']");
 		//1- the input bi an ko click dc + co the verify duoc 
 		//checkToCheckboxOrRadioButton(winterRadio);
 		//sleepInSecond(2);
 		//Assert.assertTrue(driver.findElement(winterRadio).isSelected());
 		
 		
 		//2- the span de click (hien thi) + ko verify duoc
 		//By winterRadio = By.xpath("//span[contains(text(),'Winter')]");
 		//driver.findElement(winterRadio).click();
 		//sleepInSecond(2);
 		//Assert.assertTrue(driver.findElement(winterRadio).isSelected());
 		
 		//3-the span de chay input de verify
 		//By winterSpan = By.xpath("//span[contains(text(),'Winter')]");
 		//driver.findElement(winterSpan).click();
 		//sleepInSecond(2);
 		//By winterRadio = By.xpath("//input[@value='Winter']");
 		//Assert.assertTrue(driver.findElement(winterRadio).isSelected());
 		
 		//4- dung JS de vua click vua verify
 		By winterRadio = By.xpath("//input[@value='Winter']");
 		clicktoElementByJS(winterRadio);
 		sleepInSecond(2);
 		Assert.assertTrue(driver.findElement(winterRadio).isSelected());
 	}
    
	public void clicktoElementByJS(By by) {
		WebElement element = driver.findElement(by);
		JSExcutor.executeScript("arguments[0].click();", element);
		
	}
 	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	

	public void checkToCheckboxOrRadioButton(By by) {
		WebElement checkbox = driver.findElement(by);
		if (!checkbox.isSelected()) {
			checkbox.click();
		}
	}
	public void unCheckToCheckboxOrRadioButton(By by) {
		WebElement checkbox = driver.findElement(by);
		if (checkbox.isSelected()) {
			checkbox.click();
		}
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
