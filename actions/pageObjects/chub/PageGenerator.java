package pageObjects.chub;

import org.openqa.selenium.WebDriver;


public class PageGenerator {

	public static LoginPO getLoginPage(WebDriver driver) {
		return new LoginPO(driver);
	}

	public static ArticleListPO getArticleListPage(WebDriver driver) {
		return new ArticleListPO(driver);
	}

	public static LoginGGPO getGoogleLogin(WebDriver driver) {
		return new LoginGGPO(driver);
	}
	
	public static ProfilePO getProfilePage(WebDriver driver) {
		return new ProfilePO(driver);
	}
	
	public static LoginSocialPO getLoginSocialPage(WebDriver driver) {
		return new LoginSocialPO(driver);
	}


}
