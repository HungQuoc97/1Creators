package pageObjects.chub;

import java.util.List;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class ProfilePO extends BasePage {
	WebDriver driver;

	public ProfilePO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToButtonByID(WebDriver driver, String text) {
		waitForElementClickable(driver, pageUIs.chub.BasePageUI.BUTTON_BY_TYPE, text);
		clickToElement(driver, pageUIs.chub.BasePageUI.BUTTON_BY_TYPE, text);
		
	}

	public void verifyisplayUserName(WebDriver driver, String string) {
	   waitForAllElementVisible(driver, pageUIs.chub.BasePageUI.USER_NAME);
	   
	}

    public boolean isUserNameDisplayed(WebDriver driver, String expectedUserName) {
        String actualUserName = getElementText(driver,pageUIs.chub.BasePageUI.USER_NAME);
        return actualUserName.equals(expectedUserName);
    }

	public String getElemenUserName(WebDriver driver) {
		waitForElementVisible(driver, pageUIs.chub.BasePageUI.USER_NAME);
		return getElementText(driver, pageUIs.chub.BasePageUI.USER_NAME);
		
	}

	public void enterToTextboxByLable(WebDriver driver, String lableName, String value) {
		waitForElementVisible(driver, pageUIs.chub.BasePageUI.TEXBOX_BY_LABLE, lableName );
		sendkeyToElement(driver, pageUIs.chub.BasePageUI.TEXBOX_BY_LABLE, value, lableName);
		
	}

	public String getElementByLabelText(WebDriver driver, String lableName) {
	    waitForElementVisible(driver, pageUIs.chub.BasePageUI.TEXBOX_BY_LABLE, lableName);
	    return getElementText(driver, pageUIs.chub.BasePageUI.TEXBOX_BY_LABLE, lableName);
	}

	public void enterToTextArea(WebDriver driver, String lableName, String value) {
		waitForElementVisible(driver, pageUIs.chub.BasePageUI.TEXT_AREA_BY_LABLE, lableName );
		sendkeyToElement(driver, pageUIs.chub.BasePageUI.TEXT_AREA_BY_LABLE, value, lableName);
		
	}

	public void clickToButtonByLable(WebDriver driver, String label) {
        waitForElementClickable(driver, pageUIs.chub.BasePageUI.BUTTON_BY_LABLE, label);
        clickToElement(driver, pageUIs.chub.BasePageUI.BUTTON_BY_LABLE, label);
	}

	public boolean istoastMessageDisplayed(WebDriver driver, String text) {

		waitForElementVisible(driver, pageUIs.chub.BasePageUI.TOAST_MESSAGE_VERIFY, text);
		// isJQueryAjaxLoadedSuccess(driver);
		return isElementDisplay(driver, pageUIs.chub.BasePageUI.TOAST_MESSAGE_VERIFY, text);
		
	}

//	public boolean isToastMessageDisplayed(WebDriver driver, String text) {
//	    try {
//	    	waitForElementVisible(driver, pageUIs.chub.BasePageUI.TOAST_MESSAGE_VERIFY, text);
//	    	String actualText = getElementText(driver, pageUIs.chub.BasePageUI.TOAST_MESSAGE_VERIFY);
//	    	System.out.print(actualText);
//	        return actualText.equals(text);
//	    } catch (Exception e) {
//	        return false;
//	    }
//	}
	
		
		public boolean isToastMessageDisplayed(WebDriver driver, String expectedText) {
		    try {
		        // Chờ đúng toast có chứa text mong đợi
		        waitForElementVisible(driver, pageUIs.chub.BasePageUI.TOAST_MESSAGE_VERIFY, expectedText);
	
		        // Lấy text thực tế
		        String actualText = getElementText(driver, pageUIs.chub.BasePageUI.TOAST_MESSAGE_VERIFY, expectedText).trim();
		        System.out.println("👉 Toast hiển thị: " + actualText);
	
		        // So sánh nội dung
		        return actualText.equals(expectedText);
		    } catch (Exception e) {
		        System.out.println("⚠️ Không tìm thấy toast: " + expectedText);
		        return false;
		    }
		}
	
	




	public void clickToXicon(WebDriver driver) {
		waitForElementClickable(driver, pageUIs.chub.BasePageUI.X_ICON);
        clickToElement(driver, pageUIs.chub.BasePageUI.X_ICON);
	}

	public void selectDropdownLableText(WebDriver driver, String label, String category_value) {
		
	    waitForElementClickable(driver, pageUIs.chub.BasePageUI.TEXBOX_BY_LABLE, label);
	    clickToElement(driver, pageUIs.chub.BasePageUI.TEXBOX_BY_LABLE, label);
	    waitForElementClickable(driver, pageUIs.chub.BasePageUI.DROPDOWN_OPTIONS, category_value);
	    clickToElement(driver, pageUIs.chub.BasePageUI.DROPDOWN_OPTIONS, category_value);
	    sleepInSecond(1);
	}
	public void selectMultipleDropdownLabelText(WebDriver driver, String label, List<String> categoryValues) {
	    for (String value : categoryValues) {
	        waitForElementClickable(driver, pageUIs.chub.BasePageUI.TEXBOX_BY_LABLE, label);
		    clickToElement(driver, pageUIs.chub.BasePageUI.TEXBOX_BY_LABLE, label);
	        waitForElementClickable(driver, pageUIs.chub.BasePageUI.DROPDOWN_OPTIONS, value);
	        clickToElement(driver, pageUIs.chub.BasePageUI.DROPDOWN_OPTIONS, value);
	        sleepInSecond(1); // chỉ delay nhẹ
	    }
	}

	public void clickButtonUploadFile(WebDriver driver) {
		waitForElementClickable(driver, pageUIs.chub.BasePageUI.INPUT_UPLOAD_FILE);
	    clickToElement(driver, pageUIs.chub.BasePageUI.INPUT_UPLOAD_FILE );
		
		
		
	}

	public void clickButtonSaveImage(WebDriver driver) {
		waitForElementClickable(driver, pageUIs.chub.BasePageUI.SAVE_IMAGE);
	    clickToElement(driver, pageUIs.chub.BasePageUI.SAVE_IMAGE );
	    waitForElementInvisible3Second(driver,pageUIs.chub.BasePageUI.PROGRESSBAR_ICON);
	}

	public void clickMenuIconToBottom(WebDriver driver, String menuName) {
	    waitForElementClickable(driver, pageUIs.chub.BasePageUI.MENU_ICON_BOTTOM, menuName );
	    clickToElement(driver, pageUIs.chub.BasePageUI.MENU_ICON_BOTTOM, menuName );
		
	}

	public void clickIconToBottom(WebDriver driver) {
		waitForElementClickable(driver, pageUIs.chub.BasePageUI.ICON_BOTTOM );
	    clickToElement(driver, pageUIs.chub.BasePageUI.ICON_BOTTOM );
		
	}

	public void enterToTextAreaSupportRequest(WebDriver driver, String lableName, String value) {
		waitForElementVisible(driver, pageUIs.chub.BasePageUI.DISCRIPTION_SUPPORT_REQUEST, lableName );
		sendkeyToElement(driver, pageUIs.chub.BasePageUI.DISCRIPTION_SUPPORT_REQUEST, value, lableName);
		
	}

	public void clickToSocialButotn(WebDriver driver, String SocialName) {
		//waitForElementClickable(driver, pageUIs.chub.BasePageUI.SOCIAL_ICON );
	   // clickToElement(driver, pageUIs.chub.BasePageUI.SOCIAL_ICON );
	    clickToElementByJS(driver, pageUIs.chub.BasePageUI.SOCIAL_ICON,SocialName);
		
	}
	

}
