package webdriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_01_CheckEnvironment {
	//biến driver đại diện cho selenium webdriver
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		//mở trình duyệt fire-fox
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//30s là thời gian chờ cho element được tìm thấy trong 1 khoảng thời gian (30s) 
		
		driver.manage().window().maximize();
		
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
		// mở AUT / SUT trên trang web 
		// AUT : Application Under Testing 
		// SUT : System Under Testing 
	}

	@Test
	public void TC_01_ID() {
		// nhập vào giá trị Firs Name 
		driver.findElement(By.id("FirstName")).sendKeys("Macbook");
		sleepInSecond(3);
		//Click vào radiButton
		driver.findElement(By.id("gender-male")).click();
		sleepInSecond(3);
	}

	@Test
	public void TC_02_Name1() {
		driver.navigate().refresh();
		driver.findElement(By.className("search-box-text")).sendKeys("Macbook");
		sleepInSecond(3);
		driver.findElement(By.className("search-box-button")).click();;
		sleepInSecond(3);
	}

	@Test
	public void TC_03_TagName() {
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
		driver.findElement(By.name("Email")).sendKeys("hungdo.mta@gmail.com");

		driver.findElement(By.name("Newsletter")).click();
		sleepInSecond(3);
	}
	
	@Test
	public void TC_04_Tagname() {
		System.out.println(("Sum link = " + driver.findElement(By.tagName("a")).getSize()));
		System.out.println("Sum input = " + driver.findElement(By.tagName("input")).getSize());
		
	}
	
	 
	@Test
	public void TC_05_LinkText() {
		driver.findElement(By.linkText("Log in")).click();
		sleepInSecond(3);
	}
	
	@Test
	public void TC_06_Partial_LinkText() {
		driver.findElement(By.partialLinkText("Recently viewed products")).click();
		sleepInSecond(3);
		
		driver.findElement(By.partialLinkText("viewed products")).click();
		sleepInSecond(3);
		
		driver.findElement(By.partialLinkText("Recently viewed")).click();
		sleepInSecond(3);
	}
	@Test
	public void TC_07_CSS() {
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
		
		driver.findElement(By.cssSelector("input[id='FirstName']")).sendKeys("Automation");
		sleepInSecond(3);
		
		driver.findElement(By.cssSelector("input[class='search-box-text ui-autocomplete-input']")).sendKeys("Macbook");
		sleepInSecond(3);
		driver.findElement(By.cssSelector("a[href*='login']")).click();
		sleepInSecond(3);
	}
	
	
	@Test
	public void TC_08_Xpath() {
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
		
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Automation FC");
		sleepInSecond(3);
		
		driver.findElement(By.xpath("//input[contains(@class, 'search-box-text') ]")).sendKeys("Macbook");
		sleepInSecond(3);
		
		driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("hungdo.mta@gmail.comn");
		sleepInSecond(3);
		
		driver.findElement(By.xpath("//a[contains(@href,'login')]")).click();
		sleepInSecond(3);
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
