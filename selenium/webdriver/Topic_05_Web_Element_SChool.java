package webdriver;

import static org.testng.AssertJUnit.assertArrayEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Document;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
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
import netscape.javascript.JSException;



public class Topic_05_Web_Element_SChool {
	//biáº¿n driver Ä‘áº¡i diá»‡n cho selenium webdriver
	   WebDriver driver;
	   Select select;
       Actions action;
	   JavascriptExecutor JSExcutor;
       WebDriverWait explicitWait;
       String projectPath = System.getProperty("user.dir");
	   Alert alert;
	   String FileName="2.jpg";
	   String FilePath = projectPath + "\\Upload_file\\"+ FileName ;
	   
	   @BeforeClass
	   public void beforeClass() {

		   System.setProperty("webdriver.chrome.driver",projectPath + "\\Libraries\\chromedriver.exe");
		   System.setProperty("webdriver.gecko.driver",projectPath + "\\Libraries\\geckodriver.exe");
			driver = new ChromeDriver();
			action = new Actions(driver);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			explicitWait = new WebDriverWait(driver, 15);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			JSExcutor = (JavascriptExecutor) driver;  
			WebDriverWait wait = new WebDriverWait(driver, 5000);
			
		}
	   
	@Test
	public void TC_01_Edit_Schools() {

		driver.get("https://app.dev.schools.vn/");
		driver.findElement(By.xpath("//div[@id=\"wrap\"]//div/div[1]//div[1]//input")).sendKeys("0511111111");
		
        driver.findElement(By.xpath("//div[@id=\"wrap\"]//div//div[1]//form//div[2]//input")).sendKeys("123456");
        driver.findElement(By.xpath("//div[@id=\"wrap\"]//div//div[1]//form//button")).click();
        
		driver.findElement(By.xpath("//*[@id=\"header\"]//a[@href='/school/school']")).click();
		
		//driver.findElement(By.xpath("//div[@class='inp_file']//input[@type='file']")).sendKeys(FilePath + "\n" + FilePath + "\n" + FilePath );
		driver.findElement(By.xpath("//div[@class='inp_file']//input[@type='file']")).sendKeys(FilePath);
		 sleepInSecond(10);
		driver.findElement(By.xpath("//button[text()=' Lưu']")).click();
	   
		
		// selenium khong quan tam element co hien thi hay khong 
		

		//action.moveToElement(driver.findElement(By.xpath("//th[contains(text(),'Tỉnh (Thành phố)')]/following-sibling::td//select"))).perform();
	   // Select se = new Select(driver.findElement(By.xpath("//th[contains(text(),'Tỉnh (Thành phố)')]//following-sibling::td//select[@class= 'sel_box form_w_md']")));
	
	   // System.out.println(se);
	    //se.selectByVisibleText("Tỉnh Sơn La");
	    
		
		//selectItemIncustomerDropdown("//div[@id='thông-tin-cơ-bản']/div/table/tbody/tr[2]/td/select","//th[contains(text(),'Tỉnh (Thành phố)')]/following-sibling::td//select//option", "Tỉnh Sơn La");
	   //Assert.assertEquals(driver.findElement(By.xpath("//th[contains(text(),'Tỉnh (Thành phố)')]/following-sibling::td//select//option[text()='Tỉnh Sơn La']")).getText(), "Tỉnh Sơn La");
	
	    //driver.findElement(By.xpath("//button[contains(text(),'Lưu')]")).click();
       // Assert.assertEquals(driver.findElement(By.xpath("//h1[@class='title']")).getText(), "Lỗi chưa nhập đủ mục bắt buộc");
        
	    
	}

    public void TC_02_Edit_Class() {
    	driver.get("https://app.dev.schools.vn/");
		driver.findElement(By.xpath("//div[@id=\"wrap\"]//div/div[1]//div[1]//input")).sendKeys("0511111111");	
        driver.findElement(By.xpath("//div[@id=\"wrap\"]//div//div[1]//form//div[2]//input")).sendKeys("123456");
        driver.findElement(By.xpath("//div[@id=\"wrap\"]//div//div[1]//form//button")).click();
        
		driver.findElement(By.xpath("//*[@id=\"header\"]//a[@href='/school/school']")).click();
        
        
		driver.findElement(By.xpath("//a[contains(text(),'Tổ chức lớp học')]")).click();
		driver.findElement(By.xpath("//td[text()='10A']")).click();
       
		
		selectItemIncustomerDropdown("//select[@class='sel_box form_w_md']", "//select[@class='sel_box form_w_md']//option", "Liễu");
		
		driver.findElement(By.xpath("//button[contains(text(),'Lưu')]")).click();
		driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
		//Alert alert = driver.switchTo().alert();
		//alert.accept();
	     Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'Liễu')]")).getText(), "Liễu");
		
		//td[text()='10A']
	}
    public void selectItemIncustomerDropdown(String parentXpath, String chidXpath, String expectedItem) {
    	
    	//action.moveToElement(driver.findElement(By.xpath(parentXpath))).perform();
    	//JSExcutor.executeScript("arguments[0].click();",parentXpath);
        driver.findElement(By.xpath(parentXpath)).click();
        sleepInSecond(2);
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(chidXpath)));
        System.out.println(allItems.size());
        for (WebElement item : allItems) {
			if (item.getText().equals(expectedItem)) {
				if (!item.isDisplayed()) {
					
					JSExcutor.executeScript("arguments[0].scrollIntoView(true);", item);
					sleepInSecond(2);
					
				}
			
				//action.moveToElement(item).perform();
				item.click();
				break; 		
			}
		}
		
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
