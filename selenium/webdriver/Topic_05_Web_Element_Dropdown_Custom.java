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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;
import com.sun.org.apache.bcel.internal.ExceptionConst;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import jdk.nashorn.internal.runtime.regexp.joni.constants.internal.Arguments;
import netscape.javascript.JSException;



public class Topic_05_Web_Element_Dropdown_Custom {
	//biến driver đại diện cho selenium webdriver
	   WebDriver driver;
	   Select select;
       
	   //inject 1 javascrip code 
	   JavascriptExecutor JSExcutor;
       
       //wait 
       WebDriverWait explicitWait;
       
       String projectPath = System.getProperty("user.dir");
       
	   String[] firstMonth = {"February","April","November"};
	   
	   String[] SeconMonth = {"February","September","December","August"};
	   
	   
	   @BeforeClass
	   public void beforeClass() {
		
		   
		   System.setProperty("webdriver.chrome.driver",projectPath + "\\Libraries\\chromedriver.exe");
			
		   //driver = new ChromeDriver();
		   
		    driver = new FirefoxDriver();
			// wait cho element xuất hiện trong 1 khoảng thời gian xxx second 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//khai bao wait muc dich tro or tam dung 15s 
			explicitWait = new WebDriverWait(driver, 15);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
            //ep kieu tuong minh
			JSExcutor = (JavascriptExecutor) driver;  
		}
	   
	
	public void TC_01_dropdown() {
		driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
		
		selectItemIncustomerDropdown("//span[@id='number-button']/span[contains(@class,'ui-selectmenu-icon')]", "//ul[@id='number-menu']//div", "5");
		sleepInSecond(3);
		Assert.assertTrue(driver.findElement(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text' and text()='5']")).isDisplayed());
		
		
		selectItemIncustomerDropdown("//span[@id='number-button']/span[contains(@class,'ui-selectmenu-icon')]", "//ul[@id='number-menu']//div", "15");
		sleepInSecond(3);
		Assert.assertTrue(driver.findElement(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text' and text()='15']")).isDisplayed());
		
		selectItemIncustomerDropdown("//span[@id='number-button']/span[contains(@class,'ui-selectmenu-icon')]", "//ul[@id='number-menu']//div", "3");
		sleepInSecond(3);
		Assert.assertTrue(driver.findElement(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text' and text()='3']")).isDisplayed());
		
	}
	
	
	public void TC_02_dropdownJS() {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
		
		selectItemIncustomerDropdown("//i[@class='dropdown icon']", "//div[@role='option']//span", "Jenny Hess");
		sleepInSecond(3);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='divider text' and text()='Jenny Hess'] ")).isDisplayed());
		
		selectItemIncustomerDropdown("//i[@class='dropdown icon']",  "//div[@role='option']//span", "Matt");
		sleepInSecond(3);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='divider text' and text()='Matt'] ")).isDisplayed());
		
		selectItemIncustomerDropdown("//i[@class='dropdown icon']", "//div[@role='option']//span", "Stevie Feliciano");
		sleepInSecond(3);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='divider text' and text()='Stevie Feliciano'] ")).isDisplayed());
		
		
	}
	
 	
 	public void TC_03_dropdownVueJs() {
 		driver.get("https://mikerodham.github.io/vue-dropdowns/");
 		
 		selectItemIncustomerDropdown("//li[@class='dropdown-toggle']", "//a[@href='javascript:void(0)']", "First Option");
 		sleepInSecond(3);
 		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='dropdown-toggle' and contains(text(),'First Option')]")).isDisplayed());
 		
 		selectItemIncustomerDropdown("//li[@class='dropdown-toggle']", "//a[@href='javascript:void(0)']", "Second Option");
 		sleepInSecond(3);
 		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='dropdown-toggle' and contains(text(),'Second Option')]")).isDisplayed());
 		
 		selectItemIncustomerDropdown("//li[@class='dropdown-toggle']", "//a[@href='javascript:void(0)']", "Third Option");
 		sleepInSecond(3);
 		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='dropdown-toggle' and contains(text(),'Third Option')]")).isDisplayed());
 		
 	}
	
 	
 	
 	public void TC_04_Angular() {
 		driver.get("https://valor-software.com/ng2-select/");
 		Enter_selectItemIncustomerDropdown("//tab[@heading='Single']//i[@class='caret pull-right']", "//tab[@heading='Single']//input", "//tab[@heading='Single']//a//div", "Amsterdam");
 		Assert.assertTrue(driver.findElement(By.xpath("//pre[text()='Amsterdam']")).isDisplayed());
 		System.out.println(driver.findElement(By.xpath("//pre[text()='Amsterdam']")).getText());
 		Assert.assertEquals(driver.findElement(By.xpath("//pre[text()='Amsterdam']")).getText(), "Amsterdam");
 	}
	
 	

 	public void TC_04_Angular_02() {
 		
		
 		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
 		
 		enterAndTabItemIncustomerDropdown("//input[@type='text']", "Angola");
 		System.out.println(driver.findElement(By.xpath("//div[@role='alert']")).getText());
 		Assert.assertTrue(driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed());
 		
 	}
 	
 	@Test
 	public void TC_5_MultipleSelect() {
 		
		
 		driver.get("https://multiple-select.wenzhixin.net.cn/templates/template.html?v=189&url=basic.html");

 		SelectMultiItemInDropdown("(//button[@class='ms-choice'])[1]", "//div[@class='form-group row'][2]//div[@class='ms-drop bottom']//li//span", firstMonth);
 		Assert.assertTrue(areItemSelected(firstMonth));
 		areItemSelected(firstMonth);
 		sleepInSecond(5);
 		driver.navigate().refresh();
 		SelectMultiItemInDropdown("(//button[@class='ms-choice'])[1]", "//div[@class='form-group row'][2]//div[@class='ms-drop bottom']//li//span", SeconMonth);
 		Assert.assertTrue(areItemSelected(SeconMonth));
 	}
 	
    public void SelectMultiItemInDropdown(String parentXpath, String chidXpath, String[] expectedValueItem) {
		
    	driver.findElement(By.xpath(parentXpath)).click();;
    	sleepInSecond(1);
    	explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(chidXpath)));
    	
        List<WebElement> allItems = driver.findElements(By.xpath(chidXpath));
        
        for (WebElement childElement : allItems) {
        	
        	for (String item : expectedValueItem) {
        		
        	
        		if (childElement.getText().equals(item)) {
        			
					
					
					//JSExcutor.executeScript("arguments[0].scrollIntoView(true);", childElement);
					  JSExcutor.executeScript("arguments[0].scrollIntoView(true);", childElement);
					childElement.click();
					sleepInSecond(1);
					
			        List<WebElement> itemSelected = driver.findElements(By.xpath("//li[@class='selected']//input"));
			        System.out.println("Item selected = " + itemSelected.size());
			
					if (expectedValueItem.length== itemSelected.size()) {
						break;	
					}
				}
			}
			
        }
				
	}
    
    
 	
    public void selectItemIncustomerDropdown(String parentXpath, String chidXpath, String expectedItem) {
		
		
		//Click vao 1 element de so ra tat ca du lieu trong dropdown -> parent 
    	driver.findElement(By.xpath(parentXpath)).click();

		// cho cac item duoc load het ra thanh cong  -> Child item 
    	
    	
		// tim item can chon 
    	// duyet qua tung item -> gettext de kiem tra xem no co bang text minh mong muon hay khong 
        //List<WebElement> allItems = driver.findElements(By.xpath(chidXpath));
    	//lay het tat ca cac item nay luu vao list element 
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(chidXpath)));
		
        //ham .trim() de loai bo ki tu khoang trang or xuong dong 
        for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				if (!item.isDisplayed()) {
					System.out.println("---------Scroll to element----------");
					JSExcutor.executeScript("arguments[0].scrollIntroView(true);", item);
					sleepInSecond(1);
					
				}
				item.click();
				break;  // luon dung break de dung khi da click 
				
			 // item can chon khong hien thi va bi an phia ben duoi 
			//scroll roi click 
				
		
				
				
			}
		}
        // Duyet qua tung item 
        
        // + item can chon no hien thi -> click vao item do luon
		// + item can chon no khong hien thi (an ben duoi ) -> Scroll xuong roi click vao item do 
		
		
	}
	
    public void Enter_selectItemIncustomerDropdown(String parentXpath, String textboxDropdown, String chidXpath, String expectedItem) {
		
    	driver.findElement(By.xpath(parentXpath)).click();;
    	sleepInSecond(1);
    	driver.findElement(By.xpath(textboxDropdown)).sendKeys(expectedItem);;
        sleepInSecond(1);
  
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(chidXpath)));
		
        //ham .trim() de loai bo ki tu khoang trang or xuong dong 
        for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				if (!item.isDisplayed()) {
					System.out.println("---------Scroll to element----------");
					JSExcutor.executeScript("arguments[0].scrollIntroView(true);", item);
					sleepInSecond(1);
					  // luon dung break de dung khi da click 

				}
				item.click();
				break;				
			 // item can chon khong hien thi va bi an phia ben duoi 
			//scroll roi click 
			}
        }
				
	}

    public void enterAndTabItemIncustomerDropdown(String textboxXath, String expectedItem) {
		
    	driver.findElement(By.xpath(textboxXath)).sendKeys(expectedItem);
        sleepInSecond(1);
        
        driver.findElement(By.xpath(textboxXath)).sendKeys(Keys.TAB);
        sleepInSecond(1);
	}
	
    public boolean areItemSelected(String[] months) {
    	List<WebElement> itemSelected = driver.findElements(By.xpath("//li[@class='selected']//input"));
    	int numberItemSelected = itemSelected.size();
    	String allitemSelectedText = driver.findElement(By.xpath("(//button[@class='ms-choice'])[1]")).getText();
    	System.out.println("Text da chon =" + allitemSelectedText);
    	if (numberItemSelected <=3 && numberItemSelected > 0) {
			boolean status = true ; 
			for(String item : months) {
				if(!allitemSelectedText.contains(item)) {
					status = false;
					return status;
				}
			}
			return status;
		} else if(numberItemSelected>=12) {
			return driver.findElement(By.xpath("//button[@class='ms-choice']/span[text()='All selected']")).isDisplayed();
			
		} else if(numberItemSelected > 3 && numberItemSelected < 12) 
		{
			  return driver.findElement(By.xpath("//button[@class='ms-choice']/span[text()= ' " + numberItemSelected + " of 12 selected']")).isDisplayed();
		} else {
			return false;
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
