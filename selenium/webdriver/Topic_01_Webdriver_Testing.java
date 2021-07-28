package webdriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_01_Webdriver_Testing {
 // interface
   WebDriver driver;
   @BeforeClass
   public void beforeClass() {
		//mở trình duyệt fire-fox
		driver = new FirefoxDriver();

	}
	
	@Test
	public void TC_01_ID() {
	
		driver.get("https://www.facebook.com/r.php");
		
	// lấy ra đường dẫn URL của trang web  **
		String localPageUrl = driver.getCurrentUrl();  
		// lấy ra title   **
		driver.getTitle();
		//lay ra source code html của trang web hiện tại
	    driver.getPageSource();
	    // xử lý tab/ windowns   **
	    driver.getWindowHandle();
	    
	    driver.getWindowHandles();
	    
	    //
	    //driver.manage().addCookie("cookie")
	    // chờ cho element được tìm thấy trong vòng xxx thời gian **
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	    driver.navigate().back();
	    
	    //browser chỉ có 1 tab
	    //brower có nhiều tab
	    
	    // không quan tâm bao nhiêu tab đóng hết tất cả là quit   *
	    driver.quit();   
	    
	    // Đóng tab đang đứng
	    
	   
	  
	    driver.close();
	    
	    // Xử lý swith tab/windown 
	    driver.switchTo().alert();
	    
	    driver.switchTo().frame(1);
	    
	    driver.switchTo().window("");
	    
	    driver.manage().window().fullscreen();
	    
	    driver.manage().window().maximize();
	    
	    driver.manage().window().getPosition();
	    
	    driver.manage().window().getSize();    //lây chieu rong và chiều cao trình duyệt 
	}
	

}
