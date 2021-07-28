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


public class Topic_05_Web_Element_Bai_tap_1 {
	//biến driver đại diện cho selenium webdriver
	   WebDriver driver;
	   String emailAddress, loginPageUrl, password, uid;
	   
	   String name, dob, addr, city, state, pin, phone, customer_id ; 
	   
	   //khai bao edit
	   String   addrEdit, cityEdit, stateEdit, pinEdit, phoneEdit, emailEdit ; 
	   //UI customer 
	   By nameTextboxBy = By.name("name");
	   By dobTextboxBy = By.name("dob");
	   By addrTextareBy = By.name("addr");
	   By cityTextboxBy = By.name("city");
	   By stateTextboxBy = By.name("state");
	   By pinnoTextboxBy = By.name("pinno");
 	   By phoneTextboxBy = By.name("telephoneno");
	   By emailidTextboxBy = By.name("emailid");
	   By passwordTextboxBy = By.name("password"); 
	   
	   
	   
	   
	   @BeforeClass
	   public void beforeClass() {
			//mở trình duyệt fire-fox
			driver = new FirefoxDriver();
			// wait cho element xuất hiện trong 1 khoảng thời gian xxx second 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// Khởi tạo data test
			
			emailAddress= "Join"+ emailAddress;
			name="Join Lips"; 
			dob="1998-01-02";
			addr="145st USA";
			city= "USA" ;
			state="Hawai";
			pin="123421";
			phone="09736238932";

			loginPageUrl = "http://demo.guru99.com/v4/";
			emailAddress = "JonLips" + generateEmail();
			
			//Khai bao bien edit
			 addrEdit = "Ha noi computer";
			 cityEdit ="ha noi";
			 stateEdit ="123123";
			 pinEdit ="123123";
			 phoneEdit ="099999999";
	         emailEdit = "hanoi"+ generateEmail() ; 
			
			
			
            driver.get(loginPageUrl);

		}
	
	@Test
	public void TC_01_Register() {
		
		
		loginPageUrl = driver.getCurrentUrl();
		
		driver.findElement(By.xpath("//a[text()='here']")).click();
		driver.findElement(By.name("emailid")).sendKeys(emailAddress);
		driver.findElement(By.xpath("//input[@name = 'btnLogin' ]")).click();
		uid = driver.findElement(By.xpath("//td[text()='User ID :'] // following-sibling::td")).getText();
		password= driver.findElement(By.xpath("//td[text()='Password :'] // following-sibling::td")).getText();
		
	
	}
	
	@Test
	public void TC_02_Login() {
	    // Cach 1 de back lai 1 page bat ky
		
		//driver.navigate().back();
	    //driver.navigate().back();
	    
	    // Cach 2 de back lai 1 page bat ky
	    //driver.get("http://demo.guru99.com/v4/");
	
	    // Cach 3 de back lai 1 page bat ky
	    driver.get(loginPageUrl);
	    driver.findElement(By.name("uid")).sendKeys(uid);
	    driver.findElement(By.name("password")).sendKeys(password);
	    driver.findElement(By.name("btnLogin")).click();
	    
	    Assert.assertEquals(driver.findElement(By.cssSelector("marquee.heading3")).getText(), "Welcome To Manager's Page of Guru99 Bank");
	    
	}
	 
	@Test
	public void TC_03_Create_new_user() {
	  
		driver.findElement(By.xpath("//a[text()='New Customer']")).click();
		
		driver.findElement(nameTextboxBy).sendKeys(name);
		driver.findElement(dobTextboxBy).sendKeys(dob);
		driver.findElement(addrTextareBy).sendKeys(addr);
		driver.findElement(cityTextboxBy).sendKeys(city);
		driver.findElement(stateTextboxBy).sendKeys(state);
		driver.findElement(pinnoTextboxBy).sendKeys(pin);
		driver.findElement(phoneTextboxBy).sendKeys(phone);
		driver.findElement(emailidTextboxBy).sendKeys(emailAddress);
		driver.findElement(passwordTextboxBy).sendKeys(password);
		driver.findElement(By.name("sub")).click();
		
		   Assert.assertEquals(driver.findElement(By.cssSelector(".heading3")).getText(), "Customer Registered Successfully!!!");
		   
		   
		   Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='customer']/tbody/tr[5]/td[2]")).getText(), name) ;
		   Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='customer']/tbody/tr[7]/td[2]")).getText(), dob) ;
		   Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='customer']/tbody/tr[8]/td[2]")).getText(), addr) ;
		   Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='customer']/tbody/tr[9]/td[2]")).getText(), city) ;
		   Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='customer']/tbody/tr[10]/td[2]")).getText(), state) ;
		   Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='customer']/tbody/tr[11]/td[2]")).getText(), pin) ;
		   Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='customer']/tbody/tr[12]/td[2]")).getText(), phone) ;
		   Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='customer']/tbody/tr[13]/td[2]")).getText(), emailAddress) ;

		   customer_id = driver.findElement(By.xpath(".//*[@id='customer']/tbody/tr[4]/td[2]")).getText() ;
		   
	}
	
	@Test
	public void TC_03_Edit_user() {
	  
		driver.findElement(By.xpath("//a[text()='Edit Customer']")).click();
		
		driver.findElement(By.name("cusid")).sendKeys(customer_id);
		driver.findElement(By.name("AccSubmit")).click();
		
		Assert.assertEquals(driver.findElement(nameTextboxBy).getAttribute("value"),name) ;
		Assert.assertEquals(driver.findElement(dobTextboxBy).getAttribute("value"),dob) ;
		Assert.assertEquals(driver.findElement(addrTextareBy).getText(),addr) ;
		Assert.assertEquals(driver.findElement(cityTextboxBy).getAttribute("value"),city) ;
		Assert.assertEquals(driver.findElement(stateTextboxBy).getAttribute("value"),state) ;
		Assert.assertEquals(driver.findElement(pinnoTextboxBy).getAttribute("value"),pin) ;
		Assert.assertEquals(driver.findElement(phoneTextboxBy).getAttribute("value"),phone) ;
		Assert.assertEquals(driver.findElement(emailidTextboxBy).getAttribute("value"),emailAddress) ;
	
		
		driver.findElement(addrTextareBy).clear();
		driver.findElement(addrTextareBy).sendKeys(addrEdit);
		
		driver.findElement(cityTextboxBy).clear();
		driver.findElement(cityTextboxBy).sendKeys(cityEdit);

		driver.findElement(stateTextboxBy).clear();
		driver.findElement(stateTextboxBy).sendKeys(stateEdit);
		
		driver.findElement(pinnoTextboxBy).clear();
		driver.findElement(pinnoTextboxBy).sendKeys(pinEdit);
		
		driver.findElement(phoneTextboxBy).clear();
		driver.findElement(phoneTextboxBy).sendKeys(phoneEdit);
		
		driver.findElement(emailidTextboxBy).clear();
		driver.findElement(emailidTextboxBy).sendKeys(emailEdit);
		 
		driver.findElement(By.name("sub")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector(".heading3")).getText(), "Customer details updated Successfully!!!");
		   
		   Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='customer']/tbody/tr[5]/td[2]")).getText(), name) ;
		   Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='customer']/tbody/tr[7]/td[2]")).getText(), dob) ;
		   Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='customer']/tbody/tr[8]/td[2]")).getText(), addrEdit) ;
		   Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='customer']/tbody/tr[9]/td[2]")).getText(), cityEdit) ;
		   Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='customer']/tbody/tr[10]/td[2]")).getText(), stateEdit) ;
		   Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='customer']/tbody/tr[11]/td[2]")).getText(), pinEdit) ;
		   Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='customer']/tbody/tr[12]/td[2]")).getText(), phoneEdit) ;
		   Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='customer']/tbody/tr[13]/td[2]")).getText(), emailEdit) ;		
		
	}

	
	@AfterClass
	public void afterClass() {
		driver.quit();
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
