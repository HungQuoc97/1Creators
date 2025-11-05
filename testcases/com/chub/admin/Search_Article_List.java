package com.chub.admin;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObjects.chub.ArticleListPO;
import pageObjects.chub.LoginGGPO;
import pageObjects.chub.LoginPO;
import pageObjects.chub.LoginSocialPO;
import pageObjects.chub.PageGenerator;
import pageObjects.chub.ProfilePO;

public class Search_Article_List extends BaseTest {

	String email, password, password_gg, email_gg;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition - Step 01: Open browser ' " + browserName + " ' and navigate to ' " + appUrl + " ' ");
		driver = getBrowserDriver(browserName, appUrl);
		driver.manage().window().maximize();
		loginPage = PageGenerator.getLoginPage(driver);
		email = "qctest501+15@gmail.com";
		password = "123456789Aa@";
		email_gg = "qctest501+15@gmail.com";
		
	}

	@Story("Register")
	@Severity(SeverityLevel.NORMAL)
	@Description("Register to system and check registered success")

	@Test
	public void Article_search() {
		loginPage.enterToTextboxByType(driver, "username", email);
		loginPage.enterToTextboxByType(driver, "password", password);
		loginPage.clickToButtonByID_1(driver, "submit");
		
		profilePage = PageGenerator.getProfilePage(driver);
	    profilePage.clickToButtonByText(driver,"Liên kết nhanh");
	    profilePage.clickToButtonByText(driver, "Thêm kiên kết");
	    profilePage.clickToSocialButotn(driver, "Tiktok");
	    profilePage.clickToButtonByText(driver, "Chọn");
	    
	    profilePage.sleepInSecond(2);
	   
 	    profilePage.switchToWindowByTitle(driver, "Đăng nhập | TikTok");
  
        System.out.println(driver.getTitle());

	    profilePage.sleepInSecond(2);
	    LoginSocialPage = PageGenerator.getLoginSocialPage(driver);
	    LoginSocialPage.clickToButtonText(driver);
	    LoginSocialPage.clickToLoginWithPass(driver);
	    LoginSocialPage.clickToButtonAccept(driver);
	    LoginSocialPage.sleepInSecond(2);
	    LoginSocialPage.switchToWindowByTitle(driver,"1Creators");
	    
	    profilePage = PageGenerator.getProfilePage(driver);
	    profilePage.clickToButtonByText(driver, "Thêm kiên kết");
        profilePage.clickToSocialButotn(driver, "Facebook");   
	    profilePage.clickToButtonByText(driver, "Chọn");
	    System.out.println(driver.getTitle());
	    profilePage.sleepInSecond(2);
 	    profilePage.switchToWindowByTitle(driver, "Đăng nhập Facebook");
 	    LoginSocialPage = PageGenerator.getLoginSocialPage(driver);
 	    LoginSocialPage.clickToLoginFacebook(driver);
 	    LoginSocialPage.clickToButtonAccept(driver);
 	    
 	    
 	    
	    //verifyTrue(LoginSocialPage.isToastMessageDisplayed(driver, "Kết nối TIKTOK thành công!"));
//	    verifyTrue(LoginSocialPage.isToastMessageDisplayed(driver, "Kết nối TIKTOK thành công!"),
//                "❌ Toast fail hiển thị sai" );
//		profilePage.clickIconToBottom(driver);
//		profilePage.clickIconToBottom(driver);
//		profilePage.clickMenuIconToBottom(driver,"Thông tin tài khoản");
//	
//		profilePage.selectDropdownLableText(driver, "Loại hỗ trợ", "Khiếu nại");
//		profilePage.enterToTextAreaSupportRequest(driver, "Mô tả chi tiết", "testng send reques");
//		profilePage.clickToButtonByText(driver, "Gửi yêu cầu");
//		
	//	profilePage.sleepInSecond(20);
		
		//Kết nối TIKTOK thành công!
	}

	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		closeBrowserAndDriver();
		log.info("Post-Condition: Close browser: '" + browserName + "' ");
	}

	WebDriver driver;
	LoginPO loginPage;
	ArticleListPO articleList;
	LoginGGPO loginGG;
	ProfilePO profilePage;
	LoginSocialPO LoginSocialPage;
}
