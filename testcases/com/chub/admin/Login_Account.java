package com.chub.admin;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObjects.chub.ArticleListPO;
import pageObjects.chub.LoginGGPO;
import pageObjects.chub.LoginPO;
import pageObjects.chub.PageGenerator;
import pageObjects.chub.ProfilePO;

// su dung tinh ke thua cua BasePage 
public class Login_Account extends BaseTest {
	String avatarFilePath = GlobalConstants.UPLOAD_FOLDER_PATH + "img.png";
	List<String> categories = Arrays.asList(
		    "Nhà cửa và Vườn tược",
		    "Cuộc sống và Xã hội",
		    "Thiên nhiên",
		    "Hoạt động ngoài trời",
		    "Thú cưng",
		    "Nhiếp ảnh",
		    "Giới thiệu sản phẩm (hướng dẫn)",
		    "Trưng bày sản phẩm",
		    "Tình yêu và Đám cưới",
		    "Thể thao",
		    "Du lịch",
		    "Nâng cao kỹ năng"
		);
	String email, password, password_gg, email_gg, table_row, table_column, userName,
	phone, display_Name, date_Of_Birth, address, bio, category_value_1, category_value_2,
	countryCode;
	@Parameters({ "browser", "url" }) // bien dang mang
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition - Step 01: Open browser ' " + browserName + " ' and navigate to ' " + appUrl + " ' ");
		driver = getBrowserDriver(browserName, appUrl);
		driver.manage().window().maximize();
		loginPage = PageGenerator.getLoginPage(driver);
		
		email = "qctest501+15@gmail.com";
		password = "123456789Aa@";
		password_gg = "123456Aa";
		email_gg = "qctest501+15@gmail.com";
		table_row = "5";
		table_column = "5";
	    userName = "Binz";
	    phone = "0912345678";
	    display_Name = "Binz Da Poet";
	    date_Of_Birth = "24/05/1988"; 
	    address = "Quận 1, TP. Hồ Chí Minh";
	    bio = "Binz (tên thật: Lê Nguyễn Trung Đan, sinh ngày 24/5/1988) là rapper, ca sĩ và songwriter nổi bật của Việt Nam.\r\n"
	        + "Anh từng hoạt động trong cộng đồng underground với GVR, rồi hợp tác cùng Spacespeakers, góp phần đưa Rap Việt tiếp cận đại chúng.\r\n"
	        + "Binz ghi dấu ấn với loạt hit như Bigcityboi, They Said, Gene, Và Tôi, OK và Krazy.\r\n"
	        + "Phong cách nghệ thuật của anh mang màu sắc thời thượng, cá tính, pha trộn giữa rap, R&B và vibe US-UK hiện đại.\r\n"
	        + "Anh là HLV Rap Việt (2020–2021) và là một trong những icon ảnh hưởng nhất trong làn sóng rap Việt đương đại.";
	    category_value_1 = "Tình yêu và Đám cưới";
	    category_value_2 = "Cuộc sống và Xã hội";
		countryCode = "United States";
	}

	@Story("Register")
	@Severity(SeverityLevel.NORMAL)
	@Description("Register to system and check registered success")
	
	
	@Test
	public void Employee_01_Add_New_Article() {
		//login account
		loginPage.enterToTextboxByType(driver, "username", email);
		loginPage.enterToTextboxByType(driver, "password", password);
		loginPage.clickToButtonByID_1(driver, "submit");
		
		
		profilePage = PageGenerator.getProfilePage(driver);
		//verifyTrue(profilePage.getElemenUserName(driver).equals("Binz"));
        
		//upload image profile
		profilePage.clickButtonUploadFile(driver);
        profilePage.uploadImage(driver, avatarFilePath);
        profilePage.clickButtonSaveImage(driver);
        verifyTrue(profilePage.isToastMessageDisplayed(driver, "Thông tin đã được cập nhật thành công"));
       
        //update profle user
        profilePage.enterToTextboxByLable(driver, "Họ & tên", userName);
        profilePage.enterToTextboxByLable(driver, "Số điện thoại", phone);
        
        profilePage.enterToTextboxByLable(driver, "Tên hiển thị", userName);
        profilePage.selectDropdownLableText(driver, "Giới tính", "Nam");
      
        
        verifyTrue(profilePage.getElementByLabelText(driver,"Email").equals(email));
        profilePage.enterToTextboxByLable(driver, "Ngày tháng năm sinh", phone);
        profilePage.enterToTextboxByLable(driver, "Địa chỉ", address);
        
        profilePage.enterToTextArea(driver, "Giới thiệu ngắn về nhà sáng tạo", bio);
        profilePage.clickToButtonByLable(driver, "Thông tin tài khoản");
        verifyTrue(profilePage.isToastMessageDisplayed(driver, "Thông tin đã được cập nhật thành công"));
        profilePage.clickToXicon(driver);
        profilePage.selectDropdownLableText(driver, "Lĩnh vực", category_value_1);
        profilePage.selectDropdownLableText(driver, "Lĩnh vực", category_value_2);
        profilePage.selectMultipleDropdownLabelText(driver, "Lĩnh vực", categories);
        profilePage.selectDropdownLableText(driver, "Quốc tịch", countryCode);
        profilePage.selectDropdownLableText(driver, "Tỉnh/thành", "Anderson");
        profilePage.clickToButtonByLable(driver, "Tạo hồ sơ Creator");
        verifyTrue(profilePage.isToastMessageDisplayed(driver, "Thông tin đã được cập nhật thành công"),
                "❌ Toast fail hiển thị sai" );
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
	
}
