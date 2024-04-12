package com.hm.employee;

import java.lang.reflect.Method;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import bsh.Console;
import commons.BasePage;
import commons.BaseTest;
import commons.GlobalConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObjects.hrm.AddEmployeePO;
import pageObjects.hrm.DashboardPO;
import pageObjects.hrm.EmployeeListPO;
import pageObjects.hrm.LoginPO;
import pageObjects.hrm.PageGenerator;
import pageObjects.hrm.MyInfoPO;

// su dung tinh ke thua cua BasePage 
public class Level_16_Live_Coding extends BaseTest {

	String adminUserName, adminPassword, empFirstName, empLastName , empMiddleName, empUserName, empPassword, employeeID, statusValue;
	String empFullName; 
	String avatarFilePath = GlobalConstants.UPLOAD_FOLDER_PATH + "pokemon.jpg" ;
	String empFullname, editEmpFirstName, editEmpLastName, editEmpGender, editEmpMaritalStatus, editEmpNationlity;
	String addressStreet1, addressStreet2, city, state, zip, country, homeTelephone, mobile, workTelephone, workEmail, otherEmail ;
     @Parameters({"browser", "url"})  // bien dang mang
	 @BeforeClass
	   public void beforeClass(String browserName, String appUrl) {
    	  log.info("Pre-Condition - Step 01: Open browser ' " + browserName + " ' and navigate to ' " + appUrl + " ' " );
    	  driver = getBrowserDriver(browserName, appUrl);
    	  driver.manage().window().maximize();
    	  loginPage = PageGenerator.getLoginPage(driver);
    	  
    	  statusValue = "Enabled";
    	  adminUserName = "Admin";
    	  adminPassword = "admin123";
    	  empFirstName = "Automation";
    	  empMiddleName = "ABC";
    	  empLastName = "FC";
    	  empFullName = empFirstName + empMiddleName + empLastName;
    	  
    	  
    	  Random rand = new Random();
    	  empUserName = "autofc1" + rand.nextInt(9999);
    	 
    	  empPassword = "123456Aa@";
    	
    	  editEmpFirstName = "John";
    	  editEmpLastName = "Wick";
    	  editEmpGender = "Male";
    	  editEmpMaritalStatus = "Single"; 
    	  editEmpNationlity = "Vietnamese";
    	  
    	  
    	  // contact details
    	  addressStreet1 ="Ly Nham district, Ha Nam Province";
    	  addressStreet2 ="Pham Van Dong street Mai dich Cau Giay Ha Noi City";
    	  city = "Mehicio"; 
    	  state= "Kohaciu"; 
    	  zip = "100000";
    	  country = "Viet Nam";
    	  homeTelephone = "098383828"; 
    	  mobile = "0983838281";
    	  workTelephone = "0983838281";
    	  workEmail = "JonLips" + generateEmail();
    	  otherEmail = "Ahihi" + generateEmail();
    	  
    	  log.info("Pre-Condition - Step 02: Login with Admin role");
    	  dashboardPage = loginPage.loginToSystem(driver, adminUserName, adminPassword);
    	 
    	

     }
     
     @Story("Register")
     @Severity(SeverityLevel.NORMAL)
     @Description("Register to system and check registered success")
		@Test
		public void Employee_01_Add_New_Employee() {
			log.info("Add_New_01 - Step 01: Open Employee List Page");
			dashboardPage.openSubMenuPage(driver, "PIM", "Employee List");
			employeeListPage = PageGenerator.getEmployeeListPage(driver);
			
			log.info("Add_New_01 - Step 02: Click to 'Add' button");
			employeeListPage.clickToButtonByID(driver, "Add");
			addEmployeePage = PageGenerator.getAddEmployeePage(driver);
			
			log.info("Add_New_01 - Step 03: Enter valid info to 'First Name' textbox");
			addEmployeePage.enterToTextboxByID(driver, "firstName", empFirstName);
			
			log.info("Add_New_01 - Step 04: Enter valid info to 'Middle Name' textbox");
			addEmployeePage.enterToTextboxByID(driver, "middleName", empMiddleName);
			
			
			log.info("Add_New_01 - Step 05: Enter valid info to 'Last Name' textbox");
			addEmployeePage.enterToTextboxByID(driver, "lastName", empLastName);
			
			log.info("Add_New_01 - Step 06: Enter valid info to 'Employee ID' textbox");
			employeeID = addEmployeePage.getTextboxValueByID(driver, "Employee Id");
			
			log.info("Add_New_01 - Step 07: Click to 'Create Login Details' checkbox");
			addEmployeePage.clickToCheckboxByLable1(driver, "Create Login Details");
			
			log.info("Add_New_01 - Step 08: Enter valid info to 'User Name' textbox");
			addEmployeePage.enterToTextboxByID1(driver, "Username", empUserName);
			
			log.info("Add_New_01 - Step 09: Enter valid info to 'Password' textbox");
			addEmployeePage.enterToTextboxByID1(driver, "Password", empPassword);
			
			
			System.out.print(empUserName + " " + empPassword);
			
			log.info("Add_New_01 - Step 10: Enter valid info to 'Confirm Password' textbox");
			addEmployeePage.enterToTextboxByID1(driver, "Confirm Password", empPassword);
			
			//log.info("Add_New_01 - Step 11: Select '"+ statusValue + "' value in 'Status' dropdown");
			//addEmployeePage.selectItemInDropdownByID(driver, "status", statusValue);
			addEmployeePage.sleepInSecond(5); 
			
			log.info("Add_New_01 - Step 12: Click to 'Save' button");	
			addEmployeePage.clickToButtonByID(driver, "Save");
			addEmployeePage.sleepInSecond(2);
			
			myInforPage = PageGenerator.getPersonalDetailPage(driver);
			
			log.info("Add_New_01 - Step 13: Open Employee List Page");
			myInforPage.openSubMenuPage(driver, "PIM", "Employee List");
			employeeListPage = PageGenerator.getEmployeeListPage(driver);
			
			log.info("Add_New_01 - Step 14: Enter valid info to 'Employee Name' textbox");
			//verifyTrue(employeeListPage.isJQueryAjaxLoadedSuccess(driver));
			employeeListPage.enterToTextboxByID1(driver, "Employee Name", "Automation FC");
			//verifyTrue(employeeListPage.isJQueryAjaxLoadedSuccess(driver));
			
			log.info("Add_New_01 - Step 15: Click to 'Search' button");
			employeeListPage.clickToButtonByID(driver, "Search");
			//verifyTrue(employeeListPage.isJQueryAjaxLoadedSuccess(driver));
			
			log.info("Add_New_01 - Step 16: Verify Employee Infomation displayed at 'Result Table'");
			verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "oxd-table orangehrm-employee-list", "Last Name", "1"), empLastName);
			verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "oxd-table orangehrm-employee-list", "Id", "1"), employeeID);
			verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "oxd-table orangehrm-employee-list", "First (& Middle) Name", "1"), empFirstName + empMiddleName);
			//verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "oxd-table orangehrm-employee-list", "Id", "1"), employeeID);
			
			
			
			}
															
		@Test
		public void Employee_02_Upload_Avatar() {
			log.info("Upload_Avatar_02 - Step 01: Login with Employee role");
			loginPage = employeeListPage.logoutToSystem(driver);
			dashboardPage = loginPage.loginToSystem(driver, empUserName, empPassword);

			log.info("Upload_Avatar_02 - Step 02: Open Personal page");
			dashboardPage.openMenuPage(driver, "My Info");
			myInforPage = PageGenerator.getPersonalDetailPage(driver);
			
			log.info("Upload_Avatar_02 - Step 03: Click to Change Photo image");
			myInforPage.clickToChangePhotoImage();
			
			log.info("Upload_Avatar_02 - Step 04: Upload new Avatar image");
			myInforPage.uploadImage(driver, avatarFilePath);
				
			log.info("Upload_Avatar_02 - Step 05: Click to Upload button");
			myInforPage.clickToButtonByID(driver, "Save");
		
			log.info("Upload_Avatar_02 - Step 06: Verify new Avatar image is displayed");
			verifyTrue(myInforPage.isSuccessMessageDisplayed(driver, "Successfully Updated"));
			
			log.info("Upload_Avatar_02 - Step 7: Verify new Avatar image is displayed");
			verifyTrue(myInforPage.isNewAvatarImageDisplayed());
			
		}
		 
		@Test
		public void Employee_03_Personal_Details() {		
			log.info("Employee_03_Personal_Details - Step 01: Open 'Personal Details' tab at sidebar ");
			myInforPage.openTabAtSideBarByName("Personal Details");
			
			log.info("Employee_03_Personal_Details - Step 02: Verify all field at 'Personal Detail' tab disabled ");
			verifyTrue(myInforPage.isFieldNameEnabledByName(driver,"firstName"));
			verifyTrue(myInforPage.isFieldNameEnabledByName(driver,"middleName"));
			verifyTrue(myInforPage.isFieldNameEnabledByName(driver,"lastName"));
			verifyFalse(myInforPage.isFieldEnabledByName(driver,"Employee Id"));
			verifyFalse(myInforPage.isFieldEnabledByName(driver,"License Number"));
			verifyFalse(myInforPage.isFieldEnabledByName(driver,"Other Id"));
			//verifyFalse(myInforPage.isFieldEnabledByName(driver,"SSN Number"));
			//verifyFalse(myInforPage.isFieldEnabledByName(driver,"SIN Number"));
			verifyFalse(myInforPage.isFieldEnabledByName(driver,"Nationality"));
			verifyFalse(myInforPage.isFieldEnabledByName(driver,"Marital Status"));
			verifyFalse(myInforPage.isFieldEnabledByName(driver,"Date of Birth"));
			
			myInforPage.sleepInSecond(2);
			log.info("Employee_03_Personal_Details - Step 03: Click to 'Edit' button at 'Personal Details' form ");
			myInforPage.clickToSaveButtonByID(driver, "Personal Details");
			
			log.info("Employee_03_Personal_Details - Step 04: Verify 'Employee Id' textbox is disabled");
			verifyFalse(myInforPage.isFieldEnabledByName(driver,"Employee Id"));
			
			log.info("Employee_03_Personal_Details - Step 05: Verify 'Driver's License Number' textbox is disabled");
			verifyFalse(myInforPage.isFieldEnabledByName(driver,"License Number"));
			
			//log.info("Employee_03_Personal_Details - Step 06: Verify 'SSN Number' textbox is disabled");
			//verifyFalse(myInforPage.isFieldEnabledByName(driver,"SSN Number"));
			
			//log.info("Employee_03_Personal_Details - Step 07: Verify 'SIN Number' textbox is disabled");
			//verifyFalse(myInforPage.isFieldEnabledByName(driver,"SIN Number"));
			
			log.info("Employee_03_Personal_Details - Step 08: Verify 'Date of Birth' textbox is disabled");
			verifyFalse(myInforPage.isFieldEnabledByName(driver,"Date of Birth"));
			
			log.info("Employee_03_Personal_Details - Step 09: Enter new value to 'First Name' textbox");
			myInforPage.enterToTextboxByID(driver, "firstName", editEmpFirstName);
			
			log.info("Employee_03_Personal_Details - Step 10: Enter new value to 'Last Name' textbox");
			myInforPage.enterToTextboxByID(driver, "lastName", editEmpLastName);
			
			//log.info("Employee_03_Personal_Details - Step 11: Select value to 'Gender' radio button");
			//myInforPage.clickToRadioByLable(driver, editEmpGender);
			log.info("Employee_03_Personal_Details - Step 12: Select value to 'Marital Status' dropdown");
			
			myInforPage.clickToElementDropdown(driver, "Marital Status", editEmpMaritalStatus);
			
			log.info("Employee_03_Personal_Details - Step 13: Select value to 'Nationality' dropdown");
			myInforPage.clickToElementDropdown(driver, "Nationality", editEmpNationlity);
			//myInforPage.clickToElementDropdown(driver, "Marital Status", editEmpMaritalStatus);
			
			
			//myInforPage.selectItemInDropdownByID1(driver, "Marital Status", editEmpMaritalStatus);
			
			
			//myInforPage.selectItemInDropdownByID1(driver, "Nationality", editEmpNationlity);
			
			log.info("Employee_03_Personal_Details - Step 14: Click to 'Save' button at 'Personal Details' form");
			myInforPage.clickToButtonByID(driver, "Save");
			
            log.info("Employee_03_Personal_Details - Step 15: Verify Success message is displayed");
            verifyTrue(myInforPage.isSuccessMessageDisplayed(driver, "Successfully Updated"));
            
            
	        log.info("Employee_03_Personal_Details - Step 16: Verify 'First Name' textbox is update success");
			//verifyEquals(myInforPage.getTextboxValueByID(driver, "personal_txtEmpFirstName"), editEmpFirstName);
	        
			log.info("Employee_03_Personal_Details - Step 17: Verify 'Last Name' textbox is update success");
			//verifyEquals(myInforPage.getTextboxValueByID(driver, "personal_txtEmpLastName"), editEmpLastName);
			
			log.info("Employee_03_Personal_Details - Step 18: Verify 'Gender' radio button is update success");
			//verifyTrue(myInforPage.isRadioButtonSelectedByLabel(driver, editEmpGender));
			
			log.info("Employee_03_Personal_Details - Step 19: Verify 'Marital Status' dropdown is update success");
			//verifyEquals(myInforPage.getSelectedValueInDropdownByID(driver),editEmpMaritalStatus);
			verifyEquals(myInforPage.getSelectboxValueByID(driver, "Marital Status"), editEmpMaritalStatus);
			
			log.info("Employee_03_Personal_Details - Step 20: Verify 'Nationality' dropdown is update success");
			verifyEquals(myInforPage.getSelectboxValueByID(driver, "Nationality"), editEmpNationlity);
	
			log.info("Employee_03_Personal_Details - Step 20: Verify 'Employee Id' textbox value is correct");
			//verifyEquals(myInforPage.getTextboxValueByID(driver, "personal_txtEmployeeId"),employeeID);
			
		}
	
		public void Employee_04_Contact_Details() {		
			System.out.print(empUserName + "\n");
			System.out.print(empPassword + "\n");
			
			log.info("Employee_04_Contact_Details - Step 01: Open 'Contact Details' tab at side bar ");
			myInforPage.openTabAtSideBarByName("Contact Details");
			
			log.info("Employee_04_Contact_Details - Step 02: Verify all field at 'Contact Details' tab disabled ");
			verifyFalse(myInforPage.isFieldEnabledByName(driver,"contact_street1"));
			verifyFalse(myInforPage.isFieldEnabledByName(driver,"contact_street2"));
			verifyFalse(myInforPage.isFieldEnabledByName(driver,"contact_city"));
			verifyFalse(myInforPage.isFieldEnabledByName(driver,"contact_province"));
			verifyFalse(myInforPage.isFieldEnabledByName(driver,"contact_emp_zipcode"));
			verifyFalse(myInforPage.isFieldEnabledByName(driver,"contact_country"));
			verifyFalse(myInforPage.isFieldEnabledByName(driver,"contact_emp_hm_telephone"));
			verifyFalse(myInforPage.isFieldEnabledByName(driver,"contact_emp_mobile"));
			verifyFalse(myInforPage.isFieldEnabledByName(driver,"contact_emp_work_telephone"));
			verifyFalse(myInforPage.isFieldEnabledByName(driver,"contact_emp_work_email"));
			verifyFalse(myInforPage.isFieldEnabledByName(driver,"contact_emp_oth_email"));
			
			log.info("Employee_04_Contact_Details - Step 03: Click to 'Edit' button at 'Contact Details'");
			myInforPage.clickToButtonByID(driver, "btnSave");
			
			log.info("Employee_04_Contact_Details - Step 03: Enter to textbox");
			myInforPage.enterToTextboxByID(driver, "contact_street1", addressStreet1);
			myInforPage.enterToTextboxByID(driver, "contact_street2", addressStreet2);
			myInforPage.enterToTextboxByID(driver, "contact_city", city);
			myInforPage.enterToTextboxByID(driver, "contact_province", state);
			myInforPage.enterToTextboxByID(driver, "contact_emp_zipcode", zip);
			myInforPage.selectItemInDropdownByID(driver, "contact_country", country);
			myInforPage.enterToTextboxByID(driver, "contact_emp_hm_telephone", homeTelephone);
			myInforPage.enterToTextboxByID(driver, "contact_emp_mobile", mobile);
			myInforPage.enterToTextboxByID(driver, "contact_emp_work_telephone", workTelephone);
			myInforPage.enterToTextboxByID(driver, "contact_emp_work_email", workEmail);
			myInforPage.enterToTextboxByID(driver, "contact_emp_oth_email", otherEmail);
			
			log.info("Employee_04_Contact_Details - Step 04: Click to 'Save' button at 'Contact Details'");
			myInforPage.clickToButtonByID(driver, "btnSave");
			
			log.info("Employee_04_Contact_Details - Step 15: Verify Success message is displayed");
	        verifyTrue(myInforPage.isSuccessMessageDisplayed(driver, "Successfully Saved"));
	            
			log.info("Employee_04_Contact_Details - Step 05: Verify textbox is update success");
			
			verifyEquals(myInforPage.getTextboxValueByID(driver, "contact_street1"), addressStreet1);
			verifyEquals(myInforPage.getTextboxValueByID(driver, "contact_street2"), addressStreet2);
			verifyEquals(myInforPage.getTextboxValueByID(driver, "contact_city"), city);
			verifyEquals(myInforPage.getTextboxValueByID(driver, "contact_province"), state);
			verifyEquals(myInforPage.getTextboxValueByID(driver, "contact_emp_zipcode"), zip);
			verifyEquals(myInforPage.getSelectedValueInDropdownByID(driver, "contact_country"), country);
			verifyEquals(myInforPage.getTextboxValueByID(driver, "contact_emp_hm_telephone"), homeTelephone);
			verifyEquals(myInforPage.getTextboxValueByID(driver, "contact_emp_mobile"), mobile);
			verifyEquals(myInforPage.getTextboxValueByID(driver, "contact_emp_work_telephone"), workTelephone);
			verifyEquals(myInforPage.getTextboxValueByID(driver, "contact_emp_work_email"), workEmail);
			verifyEquals(myInforPage.getTextboxValueByID(driver, "contact_emp_oth_email"), otherEmail);
		
	
			
			
		}
		
		@Test
		public void Employee_05_Emergency_Details() {		
			
			
		}
		
		@Test
		public void Employee_06_Assigned_Dependents() {		
			log.info("Employee_06_Assigned_Dependents - Step 01: Open 'Dependents' tab at side bar ");
			myInforPage.openTabAtSideBarByName("Dependents");
			
			log.info("Employee_06_Assigned_Dependents - Step 02: Click to 'Add' button at 'Assigned Dependents'");
			myInforPage.clickToButtonByID(driver, "Add");
			
			log.info("Employee_06_Assigned_Dependents - Step 03: Enter to textbox at 'Assigned Dependents' ");
			myInforPage.enterToTextboxByID1(driver, "Name", "Ahihi");
			myInforPage.clickToElementDropdown(driver, "Relationship", "Child");
			myInforPage.enterToTextboxByID1(driver, "Date of Birth", "1995-02-16");
			
			log.info("Employee_06_Assigned_Dependents - Step 04: Click to 'Save' button at 'Assigned Dependents'");
			myInforPage.clickToButtonByID(driver, "Save");
			
			log.info("Employee_06_Assigned_Dependents - Step 05: Verify Success message is displayed");
			 verifyTrue(myInforPage.isSuccessMessageDisplayed(driver, "Successfully Saved"));
	        
	        log.info("Add_New_01 - Step 16: Verify Employee Infomation displayed at 'Result Table'");
			//verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "dependent_list", "Name", "1"), "Ahihi");
			//verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "dependent_list", "Relationship", "1"), "Child");
			//verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "dependent_list", "Date of Birth", "1"), "02-1995-16");
			
	            
			verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "orangehrm-container", "Name", "1"), "Ahihi");
			verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "orangehrm-container", "Relationship", "1"), "Child");
			verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "orangehrm-container", "Date of Birth", "1"), "02-1995-16");
			
		}
		
		
		@Test
		public void Employee_07_Edit_View_Job() {		
			
		}
		
		@Test
		public void Employee_08_Edit_View_Salary() {		
			
		}
		
		
		@Test
		public void Employee_09_Edit_View_Tax() {		
			
		}
		
		@Test
		public void Employee_10_Qualifications() {		
			
		}
		
		@Test
		public void Employee_11_Search_Employee() {		
			
		}
		
		
		@Parameters({"browser"})
		@AfterClass(alwaysRun = true)
		public void cleanBrowser(String browserName) {
		    closeBrowserAndDriver();
		    log.info("Post-Condition: Close browser: '" + browserName + "' ");
		}
		
		 WebDriver driver;
		 LoginPO loginPage;
		 AddEmployeePO addEmployeePage;
		 DashboardPO dashboardPage;
		 EmployeeListPO employeeListPage;
		 MyInfoPO myInforPage;
		 
		 public String generateEmail() {
		    Random rand = new Random();
		    return rand.nextInt(9999) + "@qa.team";
		 }     
	   
}




































