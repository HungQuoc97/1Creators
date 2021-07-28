package webdriver;

import static org.testng.AssertJUnit.assertArrayEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.crypto.SecretKey;
import javax.swing.text.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.json.Json;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumhq.jetty9.util.PathWatcher.DirAction;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import netscape.javascript.JSException;



public class Topic_SChool_Login {
	//biÃ¡ÂºÂ¿n driver Ã„â€˜Ã¡ÂºÂ¡i diÃ¡Â»â€¡n cho selenium webdriver
	   WebDriver driver;
	   Select select;
       
	   //inject 1 javascrip code 
	   JavascriptExecutor JSExcutor;
       
       //wait 
       WebDriverWait explicitWait;
       
       String projectPath = System.getProperty("user.dir");
	    
       String LID, password, lidInvail, nameTeacher, helloText, newPass, comfirmPassFail, secretKey, LID_Not_Verify,parent_Name1;
       String nameTeacher1, secretKeyIsActive, nameTeacher2, LID2, LID_new, LID3,student_SecretKey,user_Id, Parent_phone_01,
       parent_Qr2, parent_Qr3, parent_Qr4,parent_Name2 , parent_Name3, parent_Name4, parent_Lid2, parent_Lid3, parent_Lid_4_1, parent_Lid_4_2;
       
       Actions action; 
	   
	   @BeforeClass
	   public void beforeClass() {
			//mÃ¡Â»Å¸ trÃƒÂ¬nh duyÃ¡Â»â€¡t fire-fox
		    System.setProperty("webdriver.chrome.driver",projectPath + "\\browserDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().setSize(new Dimension(360, 870));
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			explicitWait = new WebDriverWait(driver, 15);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			JSExcutor = (JavascriptExecutor) driver;  
			WebDriverWait wait = new WebDriverWait(driver, 5000);
			action = new Actions(driver);
			//Khai bao bien 
			LID_Not_Verify ="0961561897";
			LID="0983059229";
			LID2="0902579616";   //sdt gan voi gv 2
			LID3="0912398812";
			lidInvail = "05111111111111111";
			password= "123456";
			nameTeacher="Ä�á»— Quá»‘c HÆ°ng";
			helloText = "QuÃ½ tháº§y cÃ´: "+ nameTeacher;
			newPass="123456";
			comfirmPassFail="123456";
			secretKey="2KT8VSGJ";              // ma bi mat gv 2
			secretKeyIsActive = "2KT8Z9VX";   //ma bi mat gv 1
			nameTeacher1 = "Phan Thu Hien";  // giao vien login thanh cong
			nameTeacher2 = "Tran Thi Thanh Thao"; // quet qr gv da dk sdt
			student_SecretKey ="2KT8VYRS";
			user_Id = "20250";
			LID_new = "0512398765";
			Parent_phone_01 ="0967146986";
			parent_Name1 ="Nguyá»…n VÄƒn HÆ°ng";
			
			parent_Qr2 = "2KT8YJ5R"; 
			parent_Qr3 = "2KT9192F"; 
			parent_Qr4 = "2KT8YJDX" ; 
			parent_Name2 ="Nguyá»…n Anh ThÆ°"; //phu huynh chua lien ket sdt
			parent_Name3= "Trá»‹nh KhÃ¡nh Linh";  // phu huynh da lien ket 1 sdt 
			parent_Name4 ="Nguyá»…n Thá»‹ BÃ­ch" ; //phu huynh da lien ket 2 sdt 
			parent_Lid2 = "0511123778";
			parent_Lid3 = "0961888123";
			parent_Lid_4_1 ="0982359591";
			parent_Lid_4_2 ="0989359591";
			
			

		}
	   
	@Test
	public void TC_01_GV_Account_Not_Verify() {
		
		driver.get("https://mapp.schools.vn/");
		
		splash_screem_gv();
		driver.findElement(By.xpath("//span[text()='GiÃ¡o viÃªn']")).click();
		driver.findElement(By.cssSelector("div#__layout input")).sendKeys(LID_Not_Verify);
		driver.findElement(By.xpath("//button[contains(text(),'Tiáº¿p theo')]")).click();
		
		//ko nhap password vÃ  comfirm password 
		driver.findElement(By.xpath("//input[@placeholder='Máº­t kháº©u má»›i']/following-sibling::input")).sendKeys("");
		driver.findElement(By.xpath("//input[@placeholder='XÃ¡c nháº­n máº­t kháº©u']/following-sibling::input")).sendKeys("");
		driver.findElement(By.xpath("//button[text()]")).click();
		//sleepInSecond(1);
	    Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Vui lÃ²ng nháº­p 6 chá»¯ sá»‘']")).getText(),"Vui lÃ²ng nháº­p 6 chá»¯ sá»‘");
	    driver.findElement(By.xpath("//button[contains(text(),'Thá»­ láº¡i')]")).click();
		
	    //nhap password khong nhap comfirm pass
	    driver.findElement(By.xpath("//input[@placeholder='Máº­t kháº©u má»›i']/following-sibling::input")).sendKeys(newPass);
	    driver.findElement(By.xpath("//button[text()]")).click();
	    
	    Assert.assertEquals(driver.findElement(By.xpath("//div[text()='[Máº­t kháº©u má»›i] vÃ  [XÃ¡c nháº­n máº­t kháº©u] khÃ´ng thá»‘ng nháº¥t']")).getText(),"[Máº­t kháº©u má»›i] vÃ  [XÃ¡c nháº­n máº­t kháº©u] khÃ´ng thá»‘ng nháº¥t");
	    driver.findElement(By.xpath("//button[contains(text(),'Thá»­ láº¡i')]")).click();
	    
		//nhap password vÃ  comfirm password 
	    driver.findElement(By.xpath("//input[@placeholder='Máº­t kháº©u má»›i']/following-sibling::input")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Máº­t kháº©u má»›i']/following-sibling::input")).sendKeys(newPass);
		driver.findElement(By.xpath("//input[@placeholder='XÃ¡c nháº­n máº­t kháº©u']/following-sibling::input")).clear();
		driver.findElement(By.xpath("//input[@placeholder='XÃ¡c nháº­n máº­t kháº©u']/following-sibling::input")).sendKeys(newPass);
		driver.findElement(By.xpath("//button[text()]")).click();
		
		WebElement popup = driver.findElement(By.xpath("//h3[contains(text(),'XÃ¡c thá»±c tÃ i khoáº£n')]")) ;
	
		Assert.assertEquals(driver.findElement(By.xpath("//h3[contains(text(),'XÃ¡c thá»±c tÃ i khoáº£n')]")).getText(), "XÃ¡c thá»±c tÃ i khoáº£n");
		System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'XÃ¡c thá»±c tÃ i khoáº£n')]")).getText());
	    if (popup.isDisplayed()) {
	    	//button[contains(text(),'Huá»·')]
	    	driver.findElement(By.xpath("//button[contains(text(),'Huá»·')]")).click();
		}
	    Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'QuÃ½ tháº§y cÃ´:')]/following-sibling::div[1]")).getText(),nameTeacher);
	    Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'QuÃ½ tháº§y cÃ´:')]/following-sibling::div[2]")).getText(),LID_Not_Verify);
	    driver.findElement(By.xpath("//input[@type='password']")).sendKeys(newPass);
		driver.findElement(By.xpath("//button[contains(text(),'XÃ¡c nháº­n')]")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Sá»‘ Ä‘iá»‡n thoáº¡i chÆ°a Ä‘c xÃ¡c minh']")).getText(), "Sá»‘ Ä‘iá»‡n thoáº¡i chÆ°a Ä‘c xÃ¡c minh");
		
		//sleepInSecond(1);
		driver.findElement(By.xpath("//button[contains(text(),'Thá»­ láº¡i')]")).click();

		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'QuÃ½ tháº§y cÃ´:')]/following-sibling::div[1]")).getText(),nameTeacher);
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'QuÃ½ tháº§y cÃ´:')]/following-sibling::div[2]")).getText(),LID_Not_Verify);
		if (popup.isDisplayed()) {
		    	//button[contains(text(),'Huá»·')]
		    	driver.findElement(By.xpath("//button[contains(text(),'Huá»·')]")).click();
			}		  
		//click thoat tai khoan lan 1
		driver.findElement(By.xpath("//button[contains(text(),'ThoÃ¡t tÃ i khoáº£n')]")).click();
		//sleepInSecond(1);
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Báº¡n cháº¯c cháº¯n muá»‘n thoÃ¡t tÃ i khoáº£n?')]")).getText(), "Báº¡n cháº¯c cháº¯n muá»‘n thoÃ¡t tÃ i khoáº£n?");
		driver.findElement(By.xpath("//div[@class='flex justify-end']//button[contains(text(),'Huá»·')]")).click();
		//sleepInSecond(1);
		//click thoat tai khoan lan 2
		move_to_choose_role();
	
		
	}
	

	public void TC_02_GV_Login_Succes() {
		driver.get("https://mapp.schools.vn/");
		driver.findElement(By.xpath("//span[text()='GiÃ¡o viÃªn']")).click();
		driver.findElement(By.cssSelector("div#__layout input")).sendKeys(LID);
		driver.findElement(By.xpath("//button[contains(text(),'Tiáº¿p theo')]")).click();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(newPass);
		//sleepInSecond(1);
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'QuÃ½ tháº§y cÃ´:')]/following-sibling::div[1]")).getText(),nameTeacher1);
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'QuÃ½ tháº§y cÃ´:')]/following-sibling::div[2]")).getText(),LID);
		driver.findElement(By.xpath("//button[contains(text(),'XÃ¡c nháº­n')]")).click();
		//sleepInSecond(1);
		driver.findElement(By.xpath("//a[@class='icoApp-hamberger']")).click();
		sleepInSecond(1);
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='person-name']")).getText(), nameTeacher1);
        driver.findElement(By.xpath("//a[text()='Ä�Äƒng xuáº¥t']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//h1[text()='Ä�Äƒng nháº­p']")).getText(), "Ä�Äƒng nháº­p");
	}

	public void TC_03_GV_Wrong_Password() {
		driver.get("https://mapp.schools.vn/");
		driver.findElement(By.xpath("//span[text()='GiÃ¡o viÃªn']")).click();
		//khong nhap sdt screskey click tiep theo
		driver.findElement(By.xpath("//button[contains(text(),'Tiáº¿p theo')]")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Vui lÃ²ng nháº­p sá»‘ Ä‘iá»‡n thoáº¡i hoáº·c mÃ£ sá»‘ bÃ­ máº­t']")).getText(), "Vui lÃ²ng nháº­p sá»‘ Ä‘iá»‡n thoáº¡i hoáº·c mÃ£ sá»‘ bÃ­ máº­t");
		//button[contains(text(),'Thá»­ láº¡i')]
		driver.findElement(By.xpath("//button[contains(text(),'Thá»­ láº¡i')]")).click();
		//sleepInSecond(1);
		driver.findElement(By.cssSelector("div#__layout input")).sendKeys(LID);
		driver.findElement(By.xpath("//button[contains(text(),'Tiáº¿p theo')]")).click();
	    driver.findElement(By.xpath("//input[@type='password']")).clear();
	    //nhap pass duoi 6 ki tu
	    driver.findElement(By.xpath("//input[@type='password']")).sendKeys("39012");
	    driver.findElement(By.xpath("//button[contains(text(),'XÃ¡c nháº­n')]")).click();
	    Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Vui lÃ²ng nháº­p 6 chá»¯ sá»‘']")).getText(),"Vui lÃ²ng nháº­p 6 chá»¯ sá»‘");
	    driver.findElement(By.xpath("//button[contains(text(),'Thá»­ láº¡i')]")).click();
	    //nhap pass khong chinh xac
	    driver.findElement(By.xpath("//input[@type='password']")).clear();
	    driver.findElement(By.xpath("//input[@type='password']")).sendKeys("390124");
	    driver.findElement(By.xpath("//button[contains(text(),'XÃ¡c nháº­n')]")).click();
	    Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Máº­t kháº©u khÃ´ng chÃ­nh xÃ¡c!']")).getText(),"Máº­t kháº©u khÃ´ng chÃ­nh xÃ¡c!");
	    driver.findElement(By.xpath("//button[contains(text(),'Thá»­ láº¡i')]")).click();
	    move_to_choose_role();
	    
	}

	public void TC_04_GV_LoginQR() {
		driver.get("https://mapp.schools.vn/");
		driver.findElement(By.xpath("//span[text()='GiÃ¡o viÃªn']")).click();
		
		//nhap vao ma bi mat da active
		driver.findElement(By.cssSelector("div#__layout input")).sendKeys(secretKeyIsActive);
		driver.findElement(By.xpath("//button[contains(text(),'Tiáº¿p theo')]")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()='MÃ£ bÃ­ máº­t Ä‘Ã£ Ä‘c liÃªn káº¿t vá»›i sÄ‘t "+LID_Not_Verify+"']")).getText(), "MÃ£ bÃ­ máº­t Ä‘Ã£ Ä‘c liÃªn káº¿t vá»›i sÄ‘t " +LID_Not_Verify);
		driver.findElement(By.xpath("//button[contains(text(),'Thá»­ láº¡i')]")).click();
		
		//clear textbox
		driver.findElement(By.xpath("//input[@placeholder='Sá»‘ Ä‘iá»‡n thoáº¡i hoáº·c mÃ£ sá»‘ bÃ­ máº­t']")). sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath("//input[@placeholder='Sá»‘ Ä‘iá»‡n thoáº¡i hoáº·c mÃ£ sá»‘ bÃ­ máº­t']")).sendKeys(Keys.BACK_SPACE);
		// nhap vao ma bi mat chua dc active
		
		driver.findElement(By.xpath("//input[@placeholder='Sá»‘ Ä‘iá»‡n thoáº¡i hoáº·c mÃ£ sá»‘ bÃ­ máº­t']")).sendKeys(secretKey);
		driver.findElement(By.xpath("//button[contains(text(),'Tiáº¿p theo')]")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()= '"+nameTeacher2+"']")).getText(), nameTeacher2);
		//Assert.assertEquals(driver.findElement(By.xpath("//input[@type= 'number']"))., LID2);
		
		//get value 
		String elementval = driver.findElement(By.xpath("//input[@type= 'number']")).getAttribute("value");
		System.out.println(elementval);
		if(elementval.length() != 0)
		{
			Assert.assertEquals(elementval, LID3);
		}
		else
		{
			//khong nhap sdt click xac nhan
			driver.findElement(By.xpath("//button[contains(text(),'XÃ¡c nháº­n')]")).click();
			
			Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Vui lÃ²ng nháº­p sá»‘ Ä‘iá»‡n thoáº¡i']")).getText(), "Vui lÃ²ng nháº­p sá»‘ Ä‘iá»‡n thoáº¡i");
			driver.findElement(By.xpath("//button[contains(text(),'Thá»­ láº¡i')]")).click();
			//nhap sdt ko dung dinh dang
			driver.findElement(By.xpath("//input[@type='number']")).sendKeys("09321837711");
			driver.findElement(By.xpath("//button[contains(text(),'XÃ¡c nháº­n')]")).click();
			Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Sá»‘ Ä‘iá»‡n thoáº¡i khÃ´ng Ä‘Ãºng Ä‘á»‹nh dáº¡ng']")).getText(), "Sá»‘ Ä‘iá»‡n thoáº¡i khÃ´ng Ä‘Ãºng Ä‘á»‹nh dáº¡ng");
			driver.findElement(By.xpath("//button[contains(text(),'Thá»­ láº¡i')]")).click();
			driver.findElement(By.xpath("//input[@type='number']")). sendKeys(Keys.chord(Keys.CONTROL, "a"));
			driver.findElement(By.xpath("//input[@type='number']")).sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.xpath("//input[@type='number']")).sendKeys(LID_new);
		}
		driver.findElement(By.xpath("//button[contains(text(),'XÃ¡c nháº­n')]")).click();
		driver.findElement(By.xpath("//input[@type='password' and @placeholder='Máº­t kháº©u má»›i']")).sendKeys(newPass);
		driver.findElement(By.xpath("//input[@type='password' and @placeholder='XÃ¡c nháº­n máº­t kháº©u']")).sendKeys(newPass);
		
		driver.findElement(By.xpath("//button[contains(text(),'XÃ¡c nháº­n')]")).click();
		//nhap lai pass vua tao de dang nhap
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'QuÃ½ tháº§y cÃ´:')]/following-sibling::div[1]")).getText(),nameTeacher2);
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'QuÃ½ tháº§y cÃ´:')]/following-sibling::div[2]")).getText(),LID2);
		
		driver.findElement(By.xpath("//input[@type='password' and @placeholder='Máº­t kháº©u']")).sendKeys(newPass);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//sleepInSecond(1);
		driver.findElement(By.xpath("//a[@class='icoApp-hamberger']")).click();
		sleepInSecond(1);
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='person-name']")).getText(), nameTeacher2);
        driver.findElement(By.xpath("//a[text()='Ä�Äƒng xuáº¥t']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//h1[text()='Ä�Äƒng nháº­p']")).getText(), "Ä�Äƒng nháº­p");
	}
	
	public void TC_05_GV_Login_Edit_phone() {
		

	}


	//HOC SINH
	public void TC_06_Login_Student_QR() {
		driver.get("https://mapp.schools.vn/");
		driver.findElement(By.xpath("//span[text()='Há»�c sinh']")).click();
		driver.findElement(By.cssSelector("div#__layout input")).sendKeys(student_SecretKey);
		driver.findElement(By.xpath("//button[contains(text(),'Tiáº¿p theo')]")).click();
		driver.findElement(By.xpath("//a[@class='icoApp-hamberger']")).click();
		sleepInSecond(1);
		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'Há»�c sinh')]")).getText(), "Há»�c sinh " + user_Id );
		driver.findElement(By.xpath("//a[text()='Ä�Äƒng xuáº¥t']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//h1[text()='Ä�Äƒng nháº­p']")).getText(), "Ä�Äƒng nháº­p");
        sleepInSecond(3);
		
	}
	
	//Phu Huynh

	public void TC_07_Login_Parent_SDT() {
		driver.get("https://mapp.schools.vn/");
		driver.findElement(By.xpath("//span[text()='Phá»¥ huynh']")).click();
		
		//nhap sdt chua co trong he thong 
		driver.findElement(By.xpath("//input[@placeholder='Sá»‘ Ä‘iá»‡n thoáº¡i hoáº·c mÃ£ sá»‘ bÃ­ máº­t']")).sendKeys(LID_new);
		driver.findElement(By.xpath("//button[contains(text(),'Tiáº¿p theo')]")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()='ChÆ°a cÃ³ sá»‘ Ä‘iá»‡n thoáº¡i trong há»‡ thá»‘ng']")).getText(),"ChÆ°a cÃ³ sá»‘ Ä‘iá»‡n thoáº¡i trong há»‡ thá»‘ng" );
		driver.findElement(By.xpath("//button[contains(text(),'Thá»­ láº¡i')]")).click();
		driver.findElement(By.xpath("//input[@placeholder]")). sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath("//input[@placeholder]")).sendKeys(Keys.BACK_SPACE);
		
		//sdt da map vs phu huynh nhung chua dk
		driver.findElement(By.xpath("//input[@placeholder='Sá»‘ Ä‘iá»‡n thoáº¡i hoáº·c mÃ£ sá»‘ bÃ­ máº­t']")).sendKeys(LID_Not_Verify);
		driver.findElement(By.xpath("//button[contains(text(),'Tiáº¿p theo')]")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Vui lÃ²ng Ä‘Äƒng nháº­p báº±ng mÃ£ bÃ­ máº­t']")).getText(),"Vui lÃ²ng Ä‘Äƒng nháº­p báº±ng mÃ£ bÃ­ máº­t" );
		driver.findElement(By.xpath("//button[contains(text(),'Thá»­ láº¡i')]")).click();
		driver.findElement(By.xpath("//input[@placeholder]")). sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath("//input[@placeholder]")).sendKeys(Keys.BACK_SPACE);
		//nhap sdt da dc dang ky
		driver.findElement(By.xpath("//input[@placeholder='Sá»‘ Ä‘iá»‡n thoáº¡i hoáº·c mÃ£ sá»‘ bÃ­ máº­t']")).sendKeys("0987999994");
		driver.findElement(By.xpath("//button[contains(text(),'Tiáº¿p theo')]")).click();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(newPass);
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()='"+parent_Name1+"']")).getText(),parent_Name1);
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()='0987999994']")).getText(),"0987999994");
		driver.findElement(By.xpath("//button[contains(text(),'XÃ¡c nháº­n')]")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//section[@class='child is-active']//h2[@class='home-title']")).getText(), "TÃ¬nh hÃ¬nh con cá»§a báº¡n");
		driver.findElement(By.xpath("//a[@class='icoApp-hamberger']")).click();
		sleepInSecond(1);
        driver.findElement(By.xpath("//a[text()='Ä�Äƒng xuáº¥t']")).click();
       
        //dang nhap bang qr da dc da ky 

		
	}

	public void TC_08_Login_Parent_QR() {
		driver.get("https://mapp.schools.vn/");
		driver.findElement(By.xpath("//span[text()='Phá»¥ huynh']")).click();
		//dang nhap bang qr da dc da ky 
		driver.findElement(By.xpath("//input[@placeholder='Sá»‘ Ä‘iá»‡n thoáº¡i hoáº·c mÃ£ sá»‘ bÃ­ máº­t']")).sendKeys("2KT8VY5T");
		driver.findElement(By.xpath("//button[contains(text(),'Tiáº¿p theo')]")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()='MÃ£ bÃ­ máº­t Ä‘Ã£ Ä‘c liÃªn káº¿t vá»›i sÄ‘t 0946189266']")).getText(),"MÃ£ bÃ­ máº­t Ä‘Ã£ Ä‘c liÃªn káº¿t vá»›i sÄ‘t 0946189266" );
		driver.findElement(By.xpath("//button[contains(text(),'Thá»­ láº¡i')]")).click();
		driver.findElement(By.xpath("//input[@placeholder]")). sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath("//input[@placeholder]")).sendKeys(Keys.BACK_SPACE);
		
		//dang nhap bang qr chua dc lien ket voi sdt nao
		
	
		//dang nhap bang qr da dc da ky 
		driver.findElement(By.xpath("//input[@placeholder='Sá»‘ Ä‘iá»‡n thoáº¡i hoáº·c mÃ£ sá»‘ bÃ­ máº­t']")).sendKeys(parent_Qr3);
		driver.findElement(By.xpath("//button[contains(text(),'Tiáº¿p theo')]")).click();
	
		String SDT = driver.findElement(By.xpath("//input[@type='number']")).getAttribute("value");
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()='"+parent_Name3+"']")).getText(), parent_Name3);
	    if (SDT.length() == 0  ) {
	    	// khong nhap sdt -> click tiep theo 
	    	driver.findElement(By.xpath("//button[@type='submit']")).click();
	    	Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Vui lÃ²ng nháº­p sá»‘ Ä‘iá»‡n thoáº¡i']")).getText(),"Vui lÃ²ng nháº­p sá»‘ Ä‘iá»‡n thoáº¡i");
	    	driver.findElement(By.xpath("//button[contains(text(),'Thá»­ láº¡i')]")).click();
	    	driver.findElement(By.xpath("//input[@type='number']")). sendKeys(Keys.chord(Keys.CONTROL, "a"));
			driver.findElement(By.xpath("//input[@type='number']")).sendKeys(Keys.BACK_SPACE);
			// sdt trung voi sdt da dang ky -> click tiep theo

			// sdt chua dang ky -> Click tiep theo 
			driver.findElement(By.xpath("//input[@type='number']")).sendKeys(parent_Lid2);
		}
	    else {
	    	// da co lien ket sdt    	
	    	driver.findElement(By.xpath("//button[@type='submit']")).click();
	    }
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//input[@type='password' and @placeholder='Máº­t kháº©u má»›i']")).sendKeys(newPass);
		driver.findElement(By.xpath("//input[@type='password' and @placeholder='XÃ¡c nháº­n máº­t kháº©u']")).sendKeys(newPass);
		driver.findElement(By.xpath("//button[contains(text(),'XÃ¡c nháº­n')]")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()='"+parent_Name3+"']")).getText(),parent_Name3);
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()='"+parent_Lid3+"']")).getText(),parent_Lid3);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(newPass);
		driver.findElement(By.xpath("//button[contains(text(),'XÃ¡c nháº­n')]")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//section[@class='child is-active']//h2[@class='home-title']")).getText(), "TÃ¬nh hÃ¬nh con cá»§a báº¡n");
		driver.findElement(By.xpath("//a[@class='icoApp-hamberger']")).click();
		sleepInSecond(1);
        driver.findElement(By.xpath("//a[text()='Ä�Äƒng xuáº¥t']")).click();

	}
	@Test
	public void TC_09_Login_Parent_QR_2_SDT() {
		driver.get("https://mapp.schools.vn/");
		driver.findElement(By.xpath("//span[text()='Phá»¥ huynh']")).click();
		//dang nhap bang qr da dc da ky 
		driver.findElement(By.xpath("//input[@placeholder='Sá»‘ Ä‘iá»‡n thoáº¡i hoáº·c mÃ£ sá»‘ bÃ­ máº­t']")).sendKeys(parent_Qr4);
		driver.findElement(By.xpath("//button[contains(text(),'Tiáº¿p theo')]")).click();
	
		String SDT = driver.findElement(By.xpath("//input[@type='number']")).getAttribute("value");
		

	}
	
	
	
	

	
    public void selectItemIncustomerDropdown(String parentXpath, String chidXpath, String expectedItem) {
		
    	//driver.findElement(By.xpath(parentXpath)).click();
        
    	JSExcutor.executeScript("arguments[0].click();",parentXpath);
        
        //new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath(parentXpath))).click();
        //List<WebElement> allItems = driver.findElements(By.xpath(chidXpath));
    	//lay het tat ca cac item nay luu vao list element 
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(chidXpath)));
        System.out.println(allItems.size());
        for (WebElement item : allItems) {
			if (item.getText().equals(expectedItem)) {
				if (!item.isDisplayed()) {
					
					JSExcutor.executeScript("arguments[0].scrollIntroView(true);", item);
					sleepInSecond(2);
					
				}
				item.click();
				break; 		
			}
		}
		
	}
	public void  move_to_choose_role() {
		driver.findElement(By.xpath("//button[contains(text(),'ThoÃ¡t tÃ i khoáº£n')]")).click();
		//sleepInSecond(1);
		driver.findElement(By.xpath("//div[@class='flex justify-end']//button[contains(text(),'XÃ¡c thá»±c')]")).click();
		//sleepInSecond(1);
		Assert.assertEquals(driver.findElement(By.xpath("//h1[text()='Ä�Äƒng nháº­p']")).getText(), "Ä�Äƒng nháº­p");
	}

	public void splash_screem_gv() {
      
		Assert.assertEquals(driver.findElement(By.xpath("//h1[normalize-space()='ThÃ´ng tin nhanh chÃ³ng']")).getText(), "ThÃ´ng tin nhanh chÃ³ng");		
		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'Náº¯m báº¯t thÃ´ng tin, thÃ´ng bÃ¡o cá»§a nhÃ  trÆ°á»�ng tá»©c th')]")).getText(), "Náº¯m báº¯t thÃ´ng tin, thÃ´ng bÃ¡o cá»§a nhÃ  trÆ°á»�ng tá»©c thá»�i");
		driver.findElement(By.xpath("//button[contains(text(),'Tiáº¿p tá»¥c')]")).click();
		
		sleepInSecond(1);
		Assert.assertEquals(driver.findElement(By.xpath("//h1[contains(text(),'Cáº§u ná»‘i liÃªn láº¡c')]")).getText(), "Cáº§u ná»‘i liÃªn láº¡c");		
		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'Káº¿t ná»‘i gia Ä‘Ã¬nh vÃ  nhÃ  trÆ°á»�ng thÃ´ng qua sá»• liÃªn l')]")).getText(), "Káº¿t ná»‘i gia Ä‘Ã¬nh vÃ  nhÃ  trÆ°á»�ng thÃ´ng qua sá»• liÃªn láº¡c Ä‘iá»‡n tá»­");
		driver.findElement(By.xpath("//button[contains(text(),'Tiáº¿p tá»¥c')]")).click();
		
		sleepInSecond(1);
		Assert.assertEquals(driver.findElement(By.xpath("//h1[contains(text(),'Quáº£n lÃ½ thÃ´ng minh')]")).getText(), "Quáº£n lÃ½ thÃ´ng minh");	
		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'Há»‡ thá»‘ng thá»�i khoÃ¡ biá»ƒu vÃ  theo dÃµi Ä‘iá»ƒm danh há»— t')]")).getText(), "Há»‡ thá»‘ng thá»�i khoÃ¡ biá»ƒu vÃ  theo dÃµi Ä‘iá»ƒm danh há»— trá»£ quáº£n lÃ½");
		driver.findElement(By.xpath("//button[contains(text(),'Báº¯t Ä‘áº§u')]")).click();
		sleepInSecond(1);
        
		Assert.assertEquals(driver.findElement(By.xpath("//h1[text()='Ä�Äƒng nháº­p']")).getText(),"Ä�Äƒng nháº­p");
       
       
 
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
