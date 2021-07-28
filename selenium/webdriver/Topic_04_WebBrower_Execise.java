package webdriver;
import static org.testng.AssertJUnit.assertArrayEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Topic_04_WebBrower_Execise {
	//biáº¿n driver Ä‘áº¡i diá»‡n cho selenium webdriver
	   WebDriver driver;
	   @BeforeClass
	   public void beforeClass() {
			//má»Ÿ trÃ¬nh duyá»‡t fire-fox
			driver = new FirefoxDriver();
			// wait cho element xuáº¥t hiá»‡n trong 1 khoáº£ng thá»�i gian xxx second 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			driver.get("http://live.demoguru99.com/");

		}
		
	@Test
	public void TC_01_Verify_Url() {
     //click vÃ o myAccount dÆ°á»›i foolter
	driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	
	Assert.assertEquals(driver.getCurrentUrl(), "http://live.demoguru99.com/index.php/customer/account/login/");
	
	//click Ä‘á»ƒ chuyá»ƒn sang trang register
	driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
	Assert.assertEquals(driver.getCurrentUrl(), "http://live.demoguru99.com/index.php/customer/account/create/");
	}
	
	@Test
	public void TC_02_Verify_Title() {
	driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	Assert.assertEquals(driver.getTitle(),"Customer Login");
	driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
	Assert.assertEquals(driver.getTitle(),"Create New Customer Account");
	
	

	}	
	
	@Test
	public void TC_03_Verify_Navigation() {
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		driver.navigate().back();
		sleepInSecond(3);
		Assert.assertEquals(driver.getTitle(),"Customer Login");
		
		driver.navigate().forward();
		sleepInSecond(3);
		Assert.assertEquals(driver.getTitle(),"Create New Customer Account");

	}
	
	@Test
	public void TC_04_Verify_View_Page_Source() {
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	// khai bÃ¡o vÃ  khá»Ÿi táº¡o bieetns táº¡i vá»‹ trÃ­ mÃ n hÃ¬nh login 
		String currentPageSource = driver.getPageSource();
	    Assert.assertTrue(currentPageSource.contains("Login or Create an Account"));
	    driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
	    sleepInSecond(3);
	    // khá»Ÿi táº¡o láº¡i giÃ¡ trá»‹ má»›i táº¡i mÃ n hÃ¬nh register
	    
	    currentPageSource = driver.getPageSource();
	    Assert.assertTrue(currentPageSource.contains("Create an Account"));
	    

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