package webdriver;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertArrayEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.awt.Checkbox;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.tools.Diagnostic;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;
import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.sun.corba.se.spi.orbutil.fsm.FSM;
import com.sun.corba.se.spi.orbutil.fsm.Input;
import com.sun.org.apache.bcel.internal.ExceptionConst;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import jdk.nashorn.internal.runtime.regexp.joni.constants.internal.Arguments;
import jdk.nashorn.internal.scripts.JS;
import sun.awt.windows.WWindowPeer;


public class Topic_14_JavascriptExcutor {
	   WebDriver driver;
	   Select select; 
	   JavascriptExecutor JSExcutor;
       WebDriverWait explicitWait;
       String projectPath = System.getProperty("user.dir");
       String jsHelper = projectPath + "dragAndDrop/drag_and_drop_helper.js";
       String chileID;
       Actions action;
	   @BeforeClass
	   public void beforeClass() {
		  
		   System.setProperty("webdriver.chrome.driver",projectPath + "\\Libraries\\chromedriver.exe");
		   System.setProperty("webdriver.gecko.driver",projectPath + "\\Libraries\\geckodriver.exe");
		   driver = new FirefoxDriver();
		   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		   explicitWait = new WebDriverWait(driver, 15);
		   driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		   
		   Object address = "Ho Chi Minh" ;
		   
		   JSExcutor = (JavascriptExecutor) driver;
		   action = new Actions(driver);
		   JSExcutor = (JavascriptExecutor) driver;
		}
	 


	@Test
	public void TC_01() {
		
		navigateToUrlByJS("http://live.demoguru99.com/");
		sleepInSecond(2);
		String liveGuruDemo = (String) executeForBrowser("return document.domain;") ;
		Assert.assertEquals(liveGuruDemo, "live.demoguru99.com");
		
		String liveGuruDemoURL = (String) executeForBrowser("return document.URL;") ;
		Assert.assertEquals(liveGuruDemoURL, "http://live.demoguru99.com/");
		clickToElementByJS("//a[normalize-space()='Mobile']");
		clickToElementByJS("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']//button");
		sleepInSecond(2);
		Assert.assertTrue(areExpectedTextInInnerText("Samsung Galaxy was added to your shopping cart."));
		clickToElementByJS("//a[normalize-space()='Customer Service']");
		scrollToElement("//span[normalize-space()='Newsletter']");
        sendkeyToElementByJS("//input[@id='newsletter']", generateEmail());
        clickToElementByJS("//button[@title='Subscribe']");
        sleepInSecond(1);
        Assert.assertTrue(areExpectedTextInInnerText("Thank you for your subscription."));
        navigateToUrlByJS("http://demo.guru99.com/v4/");
        explicitWait.until(ExpectedConditions.urlToBe("http://demo.guru99.com/v4/"));
        
        Assert.assertEquals((String) executeForBrowser("return document.domain;"), "demo.guru99.com");
      
      
    }

	
	
	public void switchToWindowsByID(String parentId) {
		
		// get ra tat ca tab/windown đang có
		Set <String> allWindowns = driver.getWindowHandles();
		
		for (String id : allWindowns) {
			if(!id.equals(parentId)) {
				//id nao khac parenID thi switch vao id do
				driver.switchTo().window(id);
				
			}
		}
	}

	
	public void switchToWindowsByTitle(String expectedTile) {
		Set <String> allWindowns = driver.getWindowHandles();
		
		for(String id : allWindowns)
		{
			driver.switchTo().window(id);
			String windowTitle = driver.getTitle();
			
			// neu nhu ma = thi stop khong kiem tra tiep nua
			if (windowTitle.equals(expectedTile)) {
				System.out.println(windowTitle);
				break;
			}
		}
		
	}
	
	public void closeToWindowsByTitle(String parentId) {
		// get ra tat ca tab/windown đang có
		Set <String> allWindowns = driver.getWindowHandles();
		
		for (String id : allWindowns) {
			if(!id.equals(parentId)) {
				//id nao khac parenID thi switch vao id do
				driver.switchTo().window(id);
				driver.close();
				}
			//sau khi dong toan bo tab !parenId can phai swith lai tab parent
			driver.switchTo().window(parentId);
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


	  public String generateEmail() {
    	Random rand = new Random();
    	return "oc" + rand.nextInt(9999) + "@qa.team";
    	
    }
	//jsExcutor
	
	public Object executeForBrowser(String javaScript) {
		return JSExcutor.executeScript(javaScript);
	}

	public String getInnerText() {
		return (String) JSExcutor.executeScript("return document.documentElement.innerText;");   //return du lieu 
	}
	
	public boolean areExpectedTextInInnerText(String textExpected) {
		String textActual = (String) JSExcutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");   // dung de verify - textExpected la text ma minh mong muon
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage() {
		JSExcutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");   // scroll xuong buttom cuoi trang
	}

	//it dung 
	public void navigateToUrlByJS(String url) {
		JSExcutor.executeScript("window.location = '" + url + "'");        //
	}

	//lay elemet -> highlight element -> 
	public void highlightElement(String locator) {
		WebElement element = getElement(locator);
		String originalStyle = element.getAttribute("style");
		JSExcutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		JSExcutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	//click element
	public void clickToElementByJS(String locator) {
		JSExcutor.executeScript("arguments[0].click();", getElement(locator));
	}

	//scroll element
	public void scrollToElement(String locator) {
		JSExcutor.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
	}

	//senkey vao textbox texare
	public void sendkeyToElementByJS(String locator, String value) {
		JSExcutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
	}

	// thuong dung remore disable
	public void removeAttributeInDOM(String locator, String attributeRemove) {
		JSExcutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(locator));
	}

	//dung de verify du lieu
	public String getElementValidationMessage(String locator) {
		return (String) JSExcutor.executeScript("return arguments[0].validationMessage;", getElement(locator));
	}

	// 
	public boolean isImageLoaded(String locator) {
		boolean status = (boolean) JSExcutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getElement(locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public WebElement getElement(String locator) {
		return driver.findElement(By.xpath(locator));
	}
}
