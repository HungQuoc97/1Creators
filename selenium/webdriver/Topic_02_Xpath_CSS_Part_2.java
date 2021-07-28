package webdriver;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Topic_02_Xpath_CSS_Part_2 {
	//biến driver đại diện cho selenium webdriver
	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	@BeforeClass
	public void beforeClass() {
		//mở trình duyệt fire-fox
		System.setProperty("webdriver.gecko.driver",projectPath + "\\Libraries\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//30s là thời gian chờ cho element được tìm thấy trong 1 khoảng thời gian (30s) 
		
		driver.manage().window().maximize();
		
		driver.get("http://live.demoguru99.com/index.php/");
		// mở AUT / SUT trên trang web 
		// AUT : Application Under Testing 
		// SUT : System Under Testing 
	}

	@Test
	public void TC_01_Login_Empty_Email_Password() {

		driver.get("http://live.demoguru99.com/index.php/");
		
	//open my account page at footer
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.id("pass")).sendKeys("");
		driver.findElement(By.name("send")).click();

		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText(),"This is a required field.");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText(),"This is a required field.");
		
	
	}
	
	@Test
	
	public void TC_02_Login_invalid_Email() {

		driver.get("http://live.demoguru99.com/index.php/");
		
	//open my account page at footer
	driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		
		driver.findElement(By.id("email")).sendKeys("hungdo.mta@123.113");
		driver.findElement(By.id("pass")).sendKeys("121123");
		driver.findElement(By.name("send")).click();
		
		Assert.assertEquals(driver.findElement(By.id("advice-validate-email-email")).getText(),"Please enter a valid email address. For example johndoe@domain.com.");
		
	
	}
	
    @Test
	public void TC_03_Login_invalid_password() {

		driver.get("http://live.demoguru99.com/index.php/");
		
	//open my account page at footer
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		
		driver.findElement(By.id("email")).sendKeys("hungdo.mta@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("121");
		driver.findElement(By.name("send")).click();
		
		Assert.assertEquals(driver.findElement(By.id("advice-validate-password-pass")).getText(),"Please enter 6 or more characters without leading or trailing spaces.");
		
	
	}

    @Test
  	public void TC_04_Login_Incorrect_password() {

  		driver.get("http://live.demoguru99.com/index.php/");
  		
  	//open my account page at footer
  		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
  		
  		driver.findElement(By.id("email")).sendKeys("hungdo.mta@gmail.com");
  		driver.findElement(By.id("pass")).sendKeys("15150322");
  		driver.findElement(By.name("send")).click();
  		
  		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='error-msg']//span")).getText(),"Invalid login or password.");
  		
  	
  	}

    
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public void sleepInSecond(long timeoutInSecond) {
		try {
			Thread.sleep(timeoutInSecond * 1000);
		}
		catch (InterruptedException e) {
		e.printStackTrace();
		}
	}

}