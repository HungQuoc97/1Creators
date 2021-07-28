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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




public class Topic_05_Web_Element_Method {
	//biến driver đại diện cho selenium webdriver
	   WebDriver driver;
	   
	   @BeforeClass
	   public void beforeClass() {
			//mở trình duyệt fire-fox
			driver = new FirefoxDriver();
			// wait cho element xuất hiện trong 1 khoảng thời gian xxx second 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// Khởi tạo data test


		}
	   By emailTextbox = By.id("mail");
		By educationTextAre = By.id("edu");
		By under18radio = By.id("under_18");
		By javaCheckbox = By.id("java");
		By passwordTextbox = By.id("password");
		By disableCheckbox = By.id("check-disbaled");
		By disbaleButton = By.id("check-disabled");
		
				
		
	@Test
	public void TC_03_Displayed() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		
		if (isElementDisplayed(emailTextbox)) {
			senKeyToElemet(emailTextbox, "Automation FA");
			
		}
		
		if(isElementDisplayed(educationTextAre)) {
		    senKeyToElemet(educationTextAre, "Automation FA");
		    
			
		}
		if (isElementDisplayed(under18radio)) {
			clickToElementy(under18radio);
			
		}
	
	}
	
	@Test
	public void TC_04_SelectFuncion() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		clickToElementy(under18radio);
		clickToElementy(javaCheckbox);

		
	//verify checkbox/radio are selected
		Assert.assertTrue(isElementSelected(under18radio));
		Assert.assertTrue(isElementSelected(javaCheckbox));
	
		clickToElementy(javaCheckbox);
		

		//verify checkbox is de-selected 
		Assert.assertFalse(isElementSelected(javaCheckbox));
		
		//verify checkbox is selected 
		clickToElementy(under18radio);
		Assert.assertTrue(isElementSelected(under18radio));
	}
	
	public void TC_06_SelectFuncion() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
	    //expected enabled
		Assert.assertTrue(isElementEnable(emailTextbox));
		Assert.assertTrue(isElementEnable(educationTextAre));
		Assert.assertTrue(isElementEnable(under18radio));
		Assert.assertTrue(isElementEnable(javaCheckbox));
		//expected disabled
		
		Assert.assertFalse(isElementEnable(passwordTextbox));
		Assert.assertFalse(isElementEnable(disableCheckbox));
		Assert.assertFalse(isElementEnable(disbaleButton));
	
	
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
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

  public String generateUser() {
	Random rand = new Random();
	return "OC_" + rand.nextInt(9999) ;
	
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
