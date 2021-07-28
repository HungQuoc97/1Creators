package webdriver;
import static org.testng.AssertJUnit.assertArrayEquals;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


@Test
public class Topic_05_Web_Element {
	//biáº¿n driver Ä‘áº¡i diá»‡n cho selenium webdriver
	   WebDriver driver;
	   @BeforeClass
	   public void beforeClass() {
			//má»Ÿ trÃ¬nh duyá»‡t fire-fox
			driver = new FirefoxDriver();
			// wait cho element xuáº¥t hiá»‡n trong 1 khoáº£ng thá»�i gian xxx second 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			driver.get("https://demo.nopcommerce.com/");

		}
		
	public void TC_01_Web_Element() {
        // muá»‘n thao tÃ¡c Ä‘Æ°á»£c vá»›i element thÃ¬ pháº£i tÃ¬m Ä‘Æ°á»£c element trÆ°á»›c
		
		// tÃ¬m 1 element
		
		driver.findElement(By.id(""));   //**
		
		// tÃ¬m nhiá»�u element
		
		driver.findElement(By.id(""));    //**
		
		// náº¿u chá»‰ thao tÃ¡c vá»›i element má»™t láº§n thÃ¬ sáº½ khÃ´ng khai bÃ¡o biáº¿n 	
		
		driver.findElement(By.id("small-searchterms")).sendKeys("Macbook");  
		
		// Náº¿u thao tÃ¡c nhiá»�u láº§n thÃ¬ nÃªn khai bÃ¡o biáº¿n 
		
		WebElement searchText = driver.findElement(By.id("small-searchterms"));
	    searchText.clear();               //**
	    searchText.sendKeys("Apple");    //**
	    searchText.getAttribute("value");   //**
	    
		
		//driver.findElement(By.id("small-searchterms")).clear();
		//driver.findElement(By.id("small-searchterms")).sendKeys("Macbook");
		//driver.findElement(By.id("small-searchterms")).getAttribute("value");
		
	    
	    //Ä‘áº¿m xem cÃ³ bao nhiÃªu element thá»�a mÃ£n Ä‘iá»�u kiá»‡n 
	    //verify sá»‘ lÆ°á»£ng element tráº£ vÃ¨ nhÆ° mong Ä‘á»£i 
	    // thao tÃ¡c vá»›i táº¥t cáº£ cÃ¡c loáº¡i element giá»‘ng nhau trong 1 page(checkbox/textbox,....)
 
	    List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@class='inputs']/input[not(@type='checkbox')]"));
	    
       // verify cos dung 6 textbox tai form dang ky
	    
	    WebElement singleElement = driver.findElement(By.className(""));
	    
	   Assert.assertEquals(checkboxes.size(), 6);
	   
	   //textbox/textArea/Editable dropdown
	   
	    singleElement.clear();
	    singleElement.sendKeys("");
	    
	    // button /link/radio/checkbox/ custom droupdown
	    
	    singleElement.click();   //**
	    
	    // cac hÃ m cÃ³ tiá»�n tá»‘ báº¯t Ä‘áº§u báº±ng get luÃ´n tráº£ vá»� dá»¯ liá»‡u 
	    
	    //getTitle/getCurrenURL/getPageSource/ .....
	    // getAttribute("") co nhiem vá»¥ láº¥y ra GIÃ� tri cá»§a attribute
	    singleElement = driver.findElement(By.xpath("//input[@id= 'small-searchterms']"));
	    
	    singleElement.getAttribute("placeholder");
	    // láº¥y ra giÃ¡ trá»‹ cá»§a placeholder lÃ  : Search Store
	    
	    // láº¥y ra giÃ¡ trá»‹ cáº£u cÃ¡c thuá»™c tÃ­nh css = thÆ°á»�ng dÃ¹ng test UI
	    //font-sire backgground
	    
	    singleElement = driver.findElement(By.cssSelector(".search-box-button"));
	 
	    singleElement.getCssValue("background-color");     //*
	    singleElement.getCssValue("font-size");
	    
	    
	    // láº¥y ra vá»‹ trÃ­ trong trang web
	    
	    singleElement.getLocation();
	    
	// láº¥y ra kÃ­ch thÆ°á»›c element rá»™ng x cao 
	    
	    singleElement.getSize();
	    
	    // location  + Size 
	    
	    singleElement.getRect();
	    
	    // chá»¥p hÃ¬nh lá»—i -> Ä‘Æ°a vÃ o html report 
	    
	    singleElement.getScreenshotAs(OutputType.FILE);      //*
	    
	    //  tagname xá»­ dá»¥ng khi lÃ  id/class/css/name,...
	    // tá»« 1 element ko biáº¿t tagname -> láº¥y ra Ä‘Æ°á»£c cÃ¡c tagname truyá»�n vÃ o cho 1 locator khÃ¡c (Ä‘áº§u ra cá»§a tháº±ng nÃ y lÃ  Ä‘áº§u vÃ o cá»§a tháº±ng kia )
	    
	     singleElement = driver.findElement(By.cssSelector(".search-box-button"));
	     
	     String searchButtonTagName = singleElement.getTagName();
	     
	     searchText = driver.findElement(By.xpath("//" + searchButtonTagName + "[@class='inputs']/input[not(@type='checkbox')]"));
	     
	     // láº¥y ra text cá»§a element (hearder/messeger/tilte)
	     singleElement.getText();
	     
	     // cÃ¡c hÃ m cÃ³ tiá»�n tá»‘ lÃ  isxxx thÃ¬ sáº½ tráº£ vá»� kiá»ƒu dá»¯ liá»‡u dáº¡ng boolean(100%)  
	     //true:  Ä‘ang hiá»ƒn thá»‹ 
	     //false: KhÃ´ng hiá»ƒn thá»‹ 
	     
	     // Kiá»ƒm tra xem element lÃ  hiá»ƒn thá»‹ cho ngÆ°á»�i dÃ¹ng thao tÃ¡c hay khong 
	     singleElement.isDisplayed();       //**
	     // kiá»ƒm tra xem 1 element cÃ³ bá»‹ disable Ä‘i khÃ´ng  
	     // true lÃ  khÃ´ng thao tÃ¡c Ä‘Æ°á»£c
	     // false lÃ  cÃ³ thá»ƒ thao tÃ¡c Ä‘Æ°á»£c
	     singleElement.isEnabled();     //*     // kiá»ƒm tra 1 elemet cÃ³ Ä‘Æ°á»£c thao tÃ¡c hay khÃ´ng 
	     
	     singleElement.isSelected();     //*   // kiÃªm tra xem 1 element Ä‘Ã£ Ä‘Æ°á»£c chá»�n hay chÆ°a
	     // kiá»ƒm tra checkbox/ radio/ dropdown
	     // true Ä‘Ã£ Ä‘Æ°á»£c chá»�n false chÆ°a Ä‘Æ°á»£c chá»�n
	     
	     singleElement.submit();
	     // thay tháº¿ cho hÃ nh vi enter vÃ o textbox, click button 
	     //
	    singleElement = driver.findElement(By.id("small-searchterms"));
	    singleElement.sendKeys("Apple");
	    singleElement.submit();
	    
	    

	}
	By emailTextbox = By.id("mail");
	By educationTextAre = By.id("edu");
	By under18radio = By.id("under_18");

	
	void sleepInSecond(long timeoutInSecond) {
		try {
			Thread.sleep(timeoutInSecond * 1000);
		}
		catch (InterruptedException e) {
		e.printStackTrace();
		}
	}

}
