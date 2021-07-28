package webdriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Topic_01_CheckEnvironment2_run_IDE {
	//biến driver đại diện cho selenium webdriver
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");


	@Test
	public void TC_01_Run_On_Firefox() {
	driver = new FirefoxDriver();
	driver.get("https://app.test.schools.vn/");

	//System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
	//driver.get("https://app.test.schools.vn/");
	//driver = new FirefoxDriver();
	driver.quit();
	}



	
	@Test
	public void TC_02_Run_On_Chrome() {
	//driver = new FirefoxDriver();
	//driver.get("https://app.test.schools.vn/");
	//driver.quit();

	System.setProperty("webdriver.chrome.driver",projectPath + "\\browserDriver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://app.test.schools.vn/");
	driver.quit();
	}

	@Test
	public void TC_03_Run_On_Microsoft_Edge() {
	//driver = new FirefoxDriver();
	//driver.get("https://app.test.schools.vn/");
	//driver.quit();

	System.setProperty("webdriver.edge.driver",projectPath + "\\browserDriver\\msedgedriver.exe");
	driver = new EdgeDriver();
	driver.get("https://app.test.schools.vn/");
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
