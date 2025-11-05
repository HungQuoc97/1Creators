package pageObjects.chub;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class LoginPO extends BasePage {
	WebDriver driver;

	public LoginPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToButtonByID(WebDriver driver, String text) {
		waitForElementClickable(driver, pageUIs.chub.BasePageUI.BUTTON_BY_TYPE, text);
		clickToElement(driver, pageUIs.chub.BasePageUI.BUTTON_BY_TYPE, text);
		
	}

}
