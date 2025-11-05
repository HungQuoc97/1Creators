package pageObjects.chub;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class LoginSocialPO extends BasePage {
	WebDriver driver;

	public LoginSocialPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToButtonText(WebDriver driver) {
		waitForElementVisible(driver, pageUIs.chub.LoginSocialPageUI.BUTTON_BY_TEXT);
		clickToElement(driver, pageUIs.chub.LoginSocialPageUI.BUTTON_BY_TEXT);
		
	}

	public void clickToLoginWithPass(WebDriver driver) {
		waitForElementVisible(driver, pageUIs.chub.LoginSocialPageUI.BUTTON_LOGIN_PASSWORD);
		clickToElement(driver, pageUIs.chub.LoginSocialPageUI.BUTTON_LOGIN_PASSWORD);
	    sendkeyToElement(driver,  pageUIs.chub.LoginSocialPageUI.PHONE, "0961561897");
	    sendkeyToElement(driver,  pageUIs.chub.LoginSocialPageUI.PASSWORD, "Love168603031@");
	    clickToElement(driver, pageUIs.chub.LoginSocialPageUI.SUBMIT_BUTTON);
	}
	
	
	
	public void clickToLoginFacebook(WebDriver driver) {
	    sendkeyToElement(driver,  pageUIs.chub.LoginSocialPageUI.FACEBOOK_ACCOUNT, "hungdo.mta@gmail.com");
	    sendkeyToElement(driver,  pageUIs.chub.LoginSocialPageUI.PASSWORD_FACEBOOK, "Love1515@@");
	    clickToElement(driver, pageUIs.chub.LoginSocialPageUI.SUBMIT_BUTTON_FACEBOOK);
	}

	public void clickToButtonAccept(WebDriver driver) {
		waitForElementVisible(driver, pageUIs.chub.LoginSocialPageUI.BUTTON_CONFIRM);
		clickToElement(driver, pageUIs.chub.LoginSocialPageUI.BUTTON_CONFIRM);
	}

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
	

}
