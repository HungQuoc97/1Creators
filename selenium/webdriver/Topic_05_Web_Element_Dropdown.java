package webdriver;
import static org.testng.AssertJUnit.assertArrayEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import netscape.javascript.JSException;



public class Topic_05_Web_Element_Dropdown {
	//biến driver đại diện cho selenium webdriver
	   WebDriver driver;
	   Select select;
	   String emailAddress, firstName, lastName, companyName, day, month, year, password ;
       JavascriptExecutor JSExcutor;
       String projectPath = System.getProperty("user.dir");
	   
	   
	   @BeforeClass
	   public void beforeClass() {
			//mở trình duyệt fire-fox
		    System.setProperty("webdriver.gecko.driver",projectPath + "\\Libraries\\geckodriver.exe");
			driver = new FirefoxDriver();
			// wait cho element xuất hiện trong 1 khoảng thời gian xxx second 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            //eps kieu tuong minh
			JSExcutor = (JavascriptExecutor) driver;
			
			emailAddress="Oc_"+generateEmail();
			firstName="Oc";
			lastName="Isme";
			companyName="HNCP";
			day = "10";
			month ="September";
			year ="1997";
			password = radompassword();

			
		   
		}
	   By gender = By.id("gender-male");
	   
	@Test
	public void TC_01_dropdown() {
		driver.get("https://demo.nopcommerce.com/");
		
		driver.findElement(By.className("ico-register")).click();
		
		
		if (isElementDisplayed(gender)) {
			clickToElementy(gender);
			
		}
		
		driver.findElement(By.id("FirstName")).sendKeys(firstName);
		driver.findElement(By.id("LastName")).sendKeys(lastName);
	    
		//dropdown ngay
	    select = new Select(driver.findElement(By.name("DateOfBirthDay")));
        //select.selectByIndex(30);
	    select.selectByVisibleText(day);
	    //kiem tra xem da chon dung item chua 
	    Assert.assertEquals( select.getFirstSelectedOption().getText(), day);
	    //kiem tra xem dropdown tra ve bn item (co 32 gia tri trong dropdown)
	   // Assert.assertEquals(select.getOptions().size(), 32);   
	    //kieemr tra xem co ho cho chon nhieu gia tri trong droupdown khong 
	  //  Assert.assertEquals(select.isMultiple(), false);
	    
	    //dropdown thang
	    select = new Select(driver.findElement(By.name("DateOfBirthMonth")));
	    select.selectByVisibleText("September");
	    Assert.assertEquals( select.getFirstSelectedOption().getText(), month);
		
	    //dropdown nam
	    select = new Select(driver.findElement(By.name("DateOfBirthYear")));
	    select.selectByVisibleText(year);
	    Assert.assertEquals( select.getFirstSelectedOption().getText(), year);
		
	    
	   driver.findElement(By.xpath(".//*[@id='Email']")).sendKeys(emailAddress);
	   driver.findElement(By.id("Company")).sendKeys(companyName);
	   driver.findElement(By.id("Password")).sendKeys(password);
	   driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
	   
	   clickByJS(By.id("register-button"));
	   //driver.findElement(By.id("register-button")).click();
	   
	   Assert.assertEquals(driver.findElement(By.xpath("//div[@class = 'result']")).getText(), "Your registration completed");
	   
	   clickByJS(By.xpath("//a[@class='ico-account']"));
	   //driver.findElement(By.id("ico-account")).click();
	   
	   Assert.assertTrue(isElementSelected(gender));
	   Assert.assertEquals(driver.findElement(By.id("FirstName")).getAttribute("Value"), firstName);
	   Assert.assertEquals(driver.findElement(By.id("LastName")).getAttribute("Value"), lastName);
	   Assert.assertEquals(driver.findElement(By.id("Email")).getAttribute("Value"), emailAddress);
	   Assert.assertEquals(driver.findElement(By.id("Company")).getAttribute("Value"), companyName);
	 
	   //verify dropdown phai lua lai bien select 
	   select = new Select(driver.findElement(By.name("DateOfBirthDay")));
	   Assert.assertEquals( select.getFirstSelectedOption().getText(), day);
	   select = new Select(driver.findElement(By.name("DateOfBirthMonth")));
	   Assert.assertEquals( select.getFirstSelectedOption().getText(), month);
	   select = new Select(driver.findElement(By.name("DateOfBirthYear")));
	   Assert.assertEquals( select.getFirstSelectedOption().getText(), year);
	}
	
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public void clickByJS(By by) {
		JSExcutor.executeScript("arguments[0].click();",driver.findElement(by));
		
	}
	 
	public boolean isElementDisplayed(By by) 
	{ 
		if(driver.findElement(by).isDisplayed()) 
		{
			System.out.println(by + " is displayed");
			return true;
			
		}
        else 
        {
			System.out.println(by + " is not displayed");
			return false;
		}
	}
	
	
	public boolean isElementEnable(By by) 
	{ 
		if(driver.findElement(by).isEnabled())
		{
			System.out.println(by + " is enable");
			return true;
			
		}
        else 
        {
			System.out.println(by + " is displayed");
			return false;
		}
	}
	
	 public void senKeyToElemet(By by , String Value) {
	        driver.findElement(by).clear();
	        driver.findElement(by).sendKeys(Value);
	    }
	 
     public void clickToElementy(By by) {
		
		 driver.findElement(by).click();
		 
	}
	 
 	public boolean isElementSelected(By by) 
 	{ 
 		if(driver.findElement(by).isSelected())
 		{
 			System.out.println(by + " is selected ");
 			return true;
 			
 		}
         else 
         {
 			System.out.println(by + " is not selected ");
 			return false;
 		}
 	} 
     
     
  public String generateEmail() {
	Random rand = new Random();
	return rand.nextInt(9999) + "@qa.team";
	
}
  public String radompassword() {
	Random rand = new Random();
	return "A" + rand.nextInt(999999) ;
	
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
