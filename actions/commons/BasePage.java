package commons;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

	public static BasePage getBasePage() {
		return new BasePage();
	}

	public void openUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public Set<Cookie> getAllCookies(WebDriver driver) {
		return driver.manage().getCookies();

	}

	public void setAllCookies(WebDriver driver, Set<Cookie> allCookies) {
		for (Cookie cookie : allCookies) {
			driver.manage().addCookie(cookie);
		}
	}

	public void accepAlert(WebDriver driver) {
		alert = waitForAlertPresence(driver);
		alert.accept();
		sleepInSecond(1);
	}

//	public void cancelAlert(WebDriver driver) {
//		alert = alert = waitForAlertPresence(driver);
//		alert.dismiss();
//	}
//
//	public void senkeyToAlert(WebDriver driver, String value) {
//		alert = alert = waitForAlertPresence(driver);
//		alert.sendKeys(value);
//	}

	public void cancelAlert(WebDriver driver) {
	    Alert alert = waitForAlertPresence(driver);
	    if (alert != null) {
	        alert.dismiss();
	    }
	}

	public void sendKeysToAlert(WebDriver driver, String value) {
	    Alert alert = waitForAlertPresence(driver);
	    if (alert != null) {
	        alert.sendKeys(value);
	    }
	}
	
	public String getAlertText(WebDriver driver, String value) {
		alert = driver.switchTo().alert();
		return alert.getText();
	}
//
//	public void switchToWindowsByID(WebDriver driver, String parentId) {
//		Set<String> allWindowns = driver.getWindowHandles();
//		for (String id : allWindowns) {
//			if (!id.equals(parentId)) {
//				driver.switchTo().window(id);
//			}
//		}
//	}
	
	
	public void switchToWindowByTitle(WebDriver driver, String expectedTitle) {
		
	    Set<String> allWindows = driver.getWindowHandles();
	    boolean switched = false;
	    for (String windowId : allWindows) {
	        driver.switchTo().window(windowId);
	        String currentTitle = driver.getTitle();
	        // In log để debug
	        System.out.println("Checking window title: " + currentTitle);
	        if (currentTitle.contains(expectedTitle)) {
	            System.out.println("✅ Switched to window: " + currentTitle);
	            switched = true;
	            break;
	        }
	    }
	    if (!switched) {
	        throw new RuntimeException("❌ Could not find window with title: " + expectedTitle);
	    }
	}

//
//	public void switchToWindowsByTitle(WebDriver driver, String expectedTile) {
//		Set<String> allWindowns = driver.getWindowHandles();
//		for (String id : allWindowns) {
//			driver.switchTo().window(id);
//			String windowTitle = driver.getTitle();
//			if (windowTitle.equals(expectedTile)) {
//				System.out.println(windowTitle);
//				break;
//			}
//		}
//
//	}

	public void closeAllWindowsExceptParent(WebDriver driver, String parentId) {
		Set<String> allWindowns = driver.getWindowHandles();
		for (String id : allWindowns) {
			if (!id.equals(parentId)) {
				driver.switchTo().window(id);
				driver.close();
				sleepInSecond(1);
			}
			if (driver.getWindowHandles().size() == 1) {
				driver.switchTo().window(parentId);
				break;
			}

		}
	}

	public void sleepInSecond(long timeoutInSecond) {
		try {
			Thread.sleep(timeoutInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void refreshToPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	// locator
	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}

	public WebElement getElement(WebDriver driver, String locator, String... params) {
		return driver.findElement(getByXpath(getDynamicLocator(locator, params)));
	}

	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}

	public By getByXpath(String locator) {
		return By.xpath(locator);
	}

	public String getDynamicLocator(String locator, String... params) {
		return String.format(locator, (Object[]) params);
	}

	public void clickToElement(WebDriver driver, String locator) {
		getElement(driver, locator).click();
	}

	public void clickToElement(WebDriver driver, String locator, String... params) {
		getElement(driver, getDynamicLocator(locator, params)).click();
	}

	public void sendkeyToElement(WebDriver driver, String locator, String value) {
		getElement(driver, locator).clear();
		getElement(driver, locator).sendKeys(value);
	}

	public void sendkeyToElement(WebDriver driver, String locator, String value, String... params) {
		locator = getDynamicLocator(locator, params);
//		getElement(driver, locator).clear();
//		getElement(driver, locator).sendKeys(Keys.chord(Keys.COMMAND, "A"));
//		getElement(driver, locator).sendKeys(Keys.DELETE);
		
		try {
			getElement(driver, locator).clear();; // thử clear trực tiếp
	    } catch (Exception e) {
	        // fallback nếu clear() fail
	    }

	    // chọn toàn bộ text và xoá
	    String os = System.getProperty("os.name").toLowerCase();
	    if (os.contains("mac")) {
	    	getElement(driver, locator).sendKeys(Keys.chord(Keys.COMMAND, "A"));
	    } else {
	    	getElement(driver, locator).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	    }
	    getElement(driver, locator).sendKeys(Keys.DELETE);
		getElement(driver, locator).sendKeys(value);
	}

	public int getElementSize(WebDriver driver, String locator) {
		return getElements(driver, locator).size();
	}

	public int getElementSize(WebDriver driver, String locator, String... params) {
		locator = getDynamicLocator(locator, params);
		return getElements(driver, locator).size();
	}

	public void selectDropdownByText(WebDriver driver, String locator, String itemText) {
		select = new Select(getElement(driver, locator));
		select.selectByVisibleText(itemText);
	}
	
	
	

	public void selectDropdownByText(WebDriver driver, String locator, String itemText, String... params) {
		locator = getDynamicLocator(locator, params);
		select = new Select(getElement(driver, locator));
		select.selectByVisibleText(itemText);
	}

	public String getSelectItemDropdown(WebDriver driver, String locator) {
		select = new Select(getElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}

	public String getSelectItemDropdown(WebDriver driver, String locator, String... params) {
		locator = getDynamicLocator(locator, params);
		select = new Select(getElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String locator) {
		select = new Select(getElement(driver, locator));
		return select.isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator,
			String expectedItem) {
		getElement(driver, parentLocator).click();
		sleepInSecond(1);

		explicitWait = new WebDriverWait(driver, shortTimeout);
		List<WebElement> allItems = explicitWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);
				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}

	public String getElementAttributeValue(WebDriver driver, String locator, String attributeName) {
		return getElement(driver, locator).getAttribute(attributeName);
	}

	public String getElementAttributeValue(WebDriver driver, String locator, String attributeName, String... params) {

		return getElement(driver, getDynamicLocator(locator, params)).getAttribute(attributeName);
	}

	public String getElementText(WebDriver driver, String locator) {
		return getElement(driver, locator).getText();
	}

	public String getElementText(WebDriver driver, String locator, String... params) {
		return getElement(driver, getDynamicLocator(locator, params)).getText();
	}

	public void checkToCheckboxOrRadio(WebDriver driver, String locator) {
		// neu nhu checkbox or radio button da dc chon hay chua
		if (!isElementSelected(driver, locator)) {
			getElement(driver, locator).click();
		}
	}

	public void checkToCheckboxOrRadio(WebDriver driver, String locator, String... params) {
		// neu nhu checkbox or radio button da dc chon hay chua
		locator = getDynamicLocator(locator, params);
		if (!isElementSelected(driver, locator)) {
			getElement(driver, locator).click();
		}
	}

	public void unCheckToCheckbox(WebDriver driver, String locator) {
		// neu nhu checkbox or radio button da dc chon hay chua
		if (isElementSelected(driver, locator)) {
			getElement(driver, locator).click();
		}
	}

	public void unCheckToCheckbox(WebDriver driver, String locator, String... params) {
		// neu nhu checkbox or radio button da dc chon hay chua
		locator = getDynamicLocator(locator, params);
		if (isElementSelected(driver, locator)) {
			getElement(driver, locator).click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locator) {
		try {
			// displayed: visible on UI + In DOM
			// Undisplayed: Invisible on UI + IN DOM
			return getElement(driver, locator).isDisplayed();
		} catch (Exception e) {
			// Undisplayed: Invisible on UI + not in DOM
			return false;
		}
	}

	public boolean isElementUndisplayed(WebDriver driver, String locator) {
		System.out.print("Start time = " + new Date().toString());
//		overrodeGlobalTimeout(driver, shortTimeout);
//		List<WebElement> elements = getElements(driver, locator);
//		overrodeGlobalTimeout(driver, longTimeout);

		overrodeGlobalTimeout(driver, shortTimeout);
		List<WebElement> elements = getElements(driver, locator);
		overrodeGlobalTimeout(driver,longTimeout);
		
		
		if (elements.size() == 0) {
			System.out.println("Element not in DOM and not visible on UI");
			System.out.println("End Time = " + new Date().toString());
			return true;

		} else if (elements.size() > 0 && elements.get(0).isDisplayed()) {
			System.out.println("Element in DOM but not visible on UI");
			System.out.println("End Time = " + new Date().toString());
			return true;
		} else {
			System.out.println("Element in DOM and visible on UI");
			return false;
		}
	}

	public void overrodeGlobalTimeout(WebDriver driver, Duration timeout) {
		//driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(timeout);
	}

	public boolean isElementDisplay(WebDriver driver, String locator, String... params) {

		return getElement(driver, getDynamicLocator(locator, params)).isDisplayed();
	}

	public boolean isElementEnable(WebDriver driver, String locator) {
		return getElement(driver, locator).isEnabled();
	}

	public boolean isElementEnable(WebDriver driver, String locator, String... params) {
		return getElement(driver, locator = getDynamicLocator(locator, params)).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String locator) {
		return getElement(driver, locator).isSelected();
	}

	public boolean isElementSelected(WebDriver driver, String locator, String... params) {
		return getElement(driver, locator = getDynamicLocator(locator, params)).isSelected();
	}

	public WebDriver swithToIframeByElement(WebDriver driver, String locator) {
		return driver.switchTo().frame(getElement(driver, locator));
	}

	public WebDriver swithToDefaultContent(WebDriver driver) {
		return driver.switchTo().defaultContent();
	}

	public void hoverToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.moveToElement(getElement(driver, locator));
		action.moveToElement(getElement(driver, locator)).perform();
	}

	public void hoverToElement(WebDriver driver, String locator, String... params) {
		action = new Actions(driver);
		action.moveToElement(getElement(driver, getDynamicLocator(locator, params))).perform();
	}

	public void dobleClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.doubleClick(getElement(driver, locator));
		action.doubleClick(getElement(driver, locator)).perform();
	}

	public void rightClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.contextClick(getElement(driver, locator));
		action.contextClick(getElement(driver, locator)).perform();
	}

	public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		action = new Actions(driver);
		action.dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
	}

	public void pressKeyToElement(WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(getElement(driver, locator), key).perform();
	}

	public void pressKeyToElement(WebDriver driver, String locator, Keys key, String... params) {
		action = new Actions(driver);
		locator = getDynamicLocator(locator, params);
		action.sendKeys(getElement(driver, locator), key).perform();
	}

	public void clickToElementByJS(WebDriver driver, String locator, String... params) {
		jsExecutor = (JavascriptExecutor) driver;
		locator = getDynamicLocator(locator, params);
		jsExecutor.executeScript("arguments[0].click();", getElement(driver, locator));
	}

	// jsExcutor
	public Object executeForBrowser(WebDriver driver, String javaScript) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getElement(driver, locator));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getElement(driver, locator));
	}

	public boolean isJQueryAjaxLoadedSuccess(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		jsExecutor = (JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {
				return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
			}
		};
		return explicitWait.until(jQueryLoad);
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}

	public void waitForElementVisible(WebDriver driver, String locator, String... params) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait
				.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicLocator(locator, params))));
	}

	public void waitForAllElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
	}

	public void waitForAllElementVisible(WebDriver driver, String locator, String... params) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(getDynamicLocator(locator, params))));
	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}

	public void waitForElementClickable(WebDriver driver, String locator, String... params) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(getDynamicLocator(locator, params))));
	}

	public void waitForElementInvisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
	}
	
	public void waitForElementInvisible3Second(WebDriver driver, String locator) {
	    if (isElementDisplayed(driver, locator)) { 
	    	   try {
	    	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
	    	        wait.pollingEvery(Duration.ofMillis(300));
	    	        wait.ignoring(NoSuchElementException.class);
	    	        wait.ignoring(StaleElementReferenceException.class);
	    	        wait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
	    	    } catch ( Exception e) {
	    	        System.out.println("⚠️ Spinner still visible after timeout, continue test anyway");
	    	    }
	    }
	}

	public void waitForElementInvisible(WebDriver driver, String locator, String... params) {
		explicitWait = new WebDriverWait(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(getDynamicLocator(locator, params))));
	}

	// button componnet chub

	public void clickToButtonByID_1(WebDriver driver, String buttonIDName) {
		waitForElementClickable(driver, pageUIs.chub.BasePageUI.BUTTON_BY_TYPE, buttonIDName);
		clickToElement(driver, pageUIs.chub.BasePageUI.BUTTON_BY_TYPE, buttonIDName);
	}

	public void clickToButtonByText(WebDriver driver, String buttonIDName) {
		waitForElementClickable(driver, pageUIs.chub.BasePageUI.BUTTON_BY_TEXT, buttonIDName);
		clickToElement(driver, pageUIs.chub.BasePageUI.BUTTON_BY_TEXT, buttonIDName);
	}
	
	public void clickToButtonByTable(WebDriver driver, String buttonIDName) {
		//waitForElementClickable(driver, pageUIs.chub.BasePageUI.BUTTON_BY_TEXT_TABLE, buttonIDName);
		clickToElement(driver, pageUIs.chub.BasePageUI.BUTTON_BY_TEXT_TABLE, buttonIDName);
	}
	

	public void enterToTextboxByType(WebDriver driver, String textboxIDName, String value) {
		waitForElementVisible(driver, pageUIs.chub.BasePageUI.TEXTBOX_BY_ID, textboxIDName);
		sendkeyToElement(driver, pageUIs.chub.BasePageUI.TEXTBOX_BY_ID, value, textboxIDName);
	}

	// verify chub display text

	public boolean isSuccessDisplayText(WebDriver driver, String text) {
		waitForAllElementVisible(driver, pageUIs.chub.BasePageUI.TEXT_VALUE, text);
		// isJQueryAjaxLoadedSuccess(driver);
		return isElementDisplay(driver, pageUIs.chub.BasePageUI.TEXT_VALUE, text);
	}
	
	public void uploadImage(WebDriver driver, String filePath) {
		getElement(driver, pageUIs.chub.BasePageUI.UPLOAD_FILE).sendKeys(filePath);
		
	}
	
	
	
	
	
	private Alert alert;
	private Select select;
	private Actions action;
//	private long shortTimeout = GlobalConstants.SHORT_TIMEOUT;
//	private long longTimeout = GlobalConstants.LONG_TIMEOUT;
	private Duration shortTimeout = GlobalConstants.SHORT_TIMEOUT;
	private Duration longTimeout = GlobalConstants.LONG_TIMEOUT;
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;

}
