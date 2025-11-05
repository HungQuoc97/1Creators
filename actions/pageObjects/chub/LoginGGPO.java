package pageObjects.chub;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class LoginGGPO extends BasePage {
	WebDriver driver;

	public LoginGGPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToButtonByTextEmail(WebDriver driver, String string) {
		waitForElementClickable(driver, pageUIs.chub.LoginGGPageUI.BUTTON_BY_TEXT, string);
		clickToElement(driver, pageUIs.chub.LoginGGPageUI.BUTTON_BY_TEXT, string);

	}

}
