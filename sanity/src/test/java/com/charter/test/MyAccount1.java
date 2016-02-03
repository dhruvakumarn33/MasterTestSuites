package com.charter.test;

import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.charter.page.HomePage;
import com.charter.page.MyAccountPage;
import com.charter.page.OverviewPage;
import com.charter.page.UserPreferencePage;
import com.charter.page.UserPreferencePage.userType;
import com.charter.utils.Constants;
import com.charter.utils.DataProviderClass;
import com.cognizant.framework.core.CaptureScreenshot;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.TestNGBase;

public class MyAccount1 extends TestNGBase{

	private String URL= Constants.URL;

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void addUserbyHoH_T518024(Map<String,String> testdata) throws Exception {

		String randomNumbers = RandomStringUtils.randomNumeric(3);
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String charterID=testdata.get("charterID")+randomNumbers;
		String lastname=testdata.get("lastname");
		String email=testdata.get("email");
		String security_question=testdata.get("security_question");
		String security_answer=testdata.get("security_answer");
		String phone=testdata.get("Mobilephone");
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518024"+ File.separator + "LoginPage");

		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadUPPage();
		screenshot.saveScreenshot("T518024"+ File.separator + "UserPreference Page");
		Thread.sleep(5000);
		UserPreferencePage UPPage=new UserPreferencePage(driver);
		UPPage.add_User(lastname, charterID, password, email,security_question, security_answer,phone);
		UPPage.relogin_with_added_user(charterID, password);
		hp.logoutApplication();

	}


	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void deleteUserbyHoH_C84683(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("C84683"+ File.separator + "LoginPage");

		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadUPPage();
		screenshot.saveScreenshot("C84683"+ File.separator + "UserPreference Page");
		Thread.sleep(5000);
		UserPreferencePage UPPage=new UserPreferencePage(driver);
		UPPage.selectuser(userType.role, "Head of Household");
		screenshot.saveScreenshot("C84683"+ File.separator + "Selected HOH user");
		UPPage.DeleteisVisible();
		UPPage.selectuser(userType.role, "Admin");
		screenshot.saveScreenshot("C84683"+ File.separator + "Selected Admin user");
		UPPage.deleteUser();             
		UPPage.selectuser(userType.role, "Standard");
		screenshot.saveScreenshot("C84683"+ File.separator + "Selected Standard user");
		UPPage.deleteUser();
		hp.logoutApplication();
	}

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void addUserbyAdmin_T518025(Map<String,String> testdata) throws Exception {

		String randomNumbers = RandomStringUtils.randomNumeric(3);
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String charterID=testdata.get("charterID")+randomNumbers;
		String lastname=testdata.get("lastname");
		String email=testdata.get("email");
		String security_question=testdata.get("security_question");
		String security_answer=testdata.get("security_answer");
		String Mobilephone=testdata.get("Mobilephone");
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518025"+ File.separator + "LoginPage");

		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadUPPage();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		screenshot.saveScreenshot("T518025"+ File.separator + "UserPreference Page");
		UserPreferencePage UPPage=new UserPreferencePage(driver);
		UPPage.add_User(lastname, charterID, password, email,security_question, security_answer,Mobilephone);
		UPPage.relogin_with_added_user(charterID, password);
		hp.logoutApplication();
	}

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void deleteUserbyAdmin_C84684(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("C84684"+ File.separator + "LoginPage");

		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadUPPage();
		screenshot.saveScreenshot("C84684"+ File.separator + "UserPreference Page");
		Thread.sleep(5000);
		UserPreferencePage UPPage=new UserPreferencePage(driver);
		UPPage.selectuser(userType.role, "Admin");
		screenshot.saveScreenshot("C84684"+ File.separator + "Selected Admin user");
		UPPage.DeleteisVisible();
		screenshot.saveScreenshot("C84684"+ File.separator + "Delete Button is not visible for logged in user");
		UPPage.selectuser(userType.role, "Standard");
		screenshot.saveScreenshot("C84684"+ File.separator + "Selected Standard user");
		UPPage.deleteUser();
		hp.logoutApplication();
	}


	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)

	public void MA_UsersandPreferences_Parentalcontrols_HOH_T518044(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String PC_TV = testdata.get("PC_TV");
		String PC_Movie=testdata.get("PC_Movie");
		String PC_Unratedcontent=testdata.get("PC_Unratedcontent");

		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518044"+ File.separator + "LoginPage");

		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadUPPage();
		screenshot.saveScreenshot("T518044"+ File.separator + "UserPreference Page");
		Thread.sleep(5000);
		UserPreferencePage UPPage=new UserPreferencePage(driver);
		UPPage.select_PC_TV(PC_TV);
		screenshot.saveScreenshot("T518044"+ File.separator + "TV");
		UPPage.Select_PC_Movie(PC_Movie);
		screenshot.saveScreenshot("T518044"+ File.separator + "Movie");
		UPPage.selectAllowUnratedContent(PC_Unratedcontent);
		screenshot.saveScreenshot("T518044"+ File.separator + "Saved TV and Movies");
		hp.logoutApplication();

	}


	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)

	public void MA_UsersandPreferences_Accountcontrols_Admin_T518043(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String Account_Type=testdata.get("Account_Type");
		String NewRole=testdata.get("NewRole");
		String Account_pom=testdata.get("Account_pom");
		String Account_DVRcontrol=testdata.get("Account_DVRcontrol");
		String Relogin_UserID=testdata.get("Relogin_UserID");
		String Relogin_Password=testdata.get("Relogin_Password");

		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518043"+ File.separator + "LoginPage");

		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadUPPage();
		screenshot.saveScreenshot("T518043"+ File.separator + "UserPreference Page");
		Thread.sleep(5000);
		UserPreferencePage UPPage=new UserPreferencePage(driver);
		UPPage.selectuser(userType.role, "Standard");
		screenshot.saveScreenshot("T518043"+ File.separator + "Selected Standard User");
		UPPage.Promote_Selected_User(Account_Type);
		screenshot.saveScreenshot("T518043"+ File.separator + "Promoted to Admin");
		driver.navigate().refresh();
		UPPage.VerifyNewuserrole(NewRole);
		screenshot.saveScreenshot("T518043"+ File.separator + "Promoted to Admin");
		UPPage.SelectPOM_AccntControl(Account_pom);
		UPPage.SelectDVRControl_AccntControl(Account_DVRcontrol);
		UPPage.Relogin(Relogin_UserID, Relogin_Password);
		hp.logoutApplication();
	}


	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)

	public void MA_UsersandPreferences_Accountcontrols_HOH_T518042(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String Account_Type=testdata.get("Account_Type");
		String NewRole=testdata.get("NewRole");
		String Account_pom=testdata.get("Account_pom");
		String Account_DVRcontrol=testdata.get("Account_DVRcontrol");
		String Relogin_UserID=testdata.get("Relogin_UserID");
		String Relogin_Password=testdata.get("Relogin_Password");

		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518042"+ File.separator + "LoginPage");

		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadUPPage();
		screenshot.saveScreenshot("T518042"+ File.separator + "UserPreference Page");
		Thread.sleep(5000);
		UserPreferencePage UPPage=new UserPreferencePage(driver);
		UPPage.selectuser(userType.role, "Standard");
		screenshot.saveScreenshot("T518042"+ File.separator + "Selected Standard User");
		UPPage.Promote_Selected_User(Account_Type);
		screenshot.saveScreenshot("T518042"+ File.separator + "Promoted to Admin");
		driver.navigate().refresh();
		UPPage.VerifyNewuserrole(NewRole);
		UPPage.SelectPOM_AccntControl(Account_pom);
		UPPage.SelectDVRControl_AccntControl(Account_DVRcontrol);
		UPPage.Relogin(Relogin_UserID, Relogin_Password);
		hp.logoutApplication();

	}



	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)

	public void MA_UP_Accountcontrols_Promoting_Standard_to_HOH_byHOH_C78606(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String Account_Type=testdata.get("Account_Type");

		String Relogin_UserID=testdata.get("Relogin_UserID");
		String Relogin_Password=testdata.get("Relogin_Password");

		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("C78606"+ File.separator + "LoginPage");

		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadUPPage();
		screenshot.saveScreenshot("C78606"+ File.separator + "UserPreference Page");
		Thread.sleep(5000);
		UserPreferencePage UPPage=new UserPreferencePage(driver);
		UPPage.selectuser(userType.role, "Standard");
		screenshot.saveScreenshot("C78606"+ File.separator + "Selected Standard User");
		UPPage.Promote_Selected_User(Account_Type);
		driver.navigate().refresh();
		//UPPage.VerifyNewuserrole(NewRole);
		screenshot.saveScreenshot("C78606"+ File.separator + "Promoted to HOH");
		UPPage.IntialRoleverification(username);
		UPPage.Relogin(Relogin_UserID, Relogin_Password);
		hp.logoutApplication();
	}



	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)

	public void MA_UP_Accountcontrols_Promoting_Admin_toHOH_byHOH_C78605(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String Account_Type=testdata.get("Account_Type");
		String NewRole=testdata.get("NewRole");

		String Relogin_UserID=testdata.get("Relogin_UserID");
		String Relogin_Password=testdata.get("Relogin_Password");

		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("C78605"+ File.separator + "LoginPage");

		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadUPPage();
		screenshot.saveScreenshot("C78605"+ File.separator + "UserPreference Page");
		Thread.sleep(5000);
		UserPreferencePage UPPage=new UserPreferencePage(driver);
		UPPage.selectuser(userType.role, "Admin");
		screenshot.saveScreenshot("C78605"+ File.separator + "Selected Admin User");
		UPPage.Promote_Selected_User(Account_Type);
		//driver.navigate().refresh();
		UPPage.VerifyNewuserrole(NewRole);
		screenshot.saveScreenshot("C78605"+ File.separator + "Promoted to HOH");
		UPPage.IntialRoleverification(username);
		UPPage.Relogin(Relogin_UserID, Relogin_Password);
		hp.logoutApplication();

	}

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)

	public void MA_UP_Accountcontrols_Demoting_Admin_to_Standard_C78604(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String Account_Type=testdata.get("Account_Type");
		String Relogin_UserID=testdata.get("Relogin_UserID");
		String Relogin_Password=testdata.get("Relogin_Password");
		String NewRole=testdata.get("NewRole");
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("C78604"+ File.separator + "LoginPage");

		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadUPPage();
		screenshot.saveScreenshot("C78604"+ File.separator + "UserPreference Page");
		Thread.sleep(5000);
		UserPreferencePage UPPage=new UserPreferencePage(driver);
		UPPage.selectuser(userType.role, "Admin");
		screenshot.saveScreenshot("C78604"+ File.separator + "Selected Admin User");
		UPPage.Demote_Selected_User(Account_Type);
		//driver.navigate().refresh();
		UPPage.VerifyNewuserrole(NewRole);
		screenshot.saveScreenshot("C78604"+ File.separator + "Demoted to Standard");
		UPPage.Relogin(Relogin_UserID, Relogin_Password);
		MAPage.openMyAccountTab();
		MAPage.loadUPPage();
		hp.logoutApplication();
	}

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void Validate_MyAccount_UsersPreferences_non_convertedUser_HOH_T518026(Map<String,String> testdata) throws Exception{
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);             
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518298"+ File.separator + "LoginPage");
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadOverviewPage();
		OverviewPage OP=new OverviewPage(driver);
		OP.CheckUserAndPreference();
		OP.CheckRedAlertAndConvertUSer();
		OP.Verifymessage(testdata);
		hp.logoutApplication();
	}
	//Name: TCC_01_Validate_UserPreferences_add_Promote_demote_deleteUser_HOH()
	//Description: Validate whether HOH user is able to create standard user, 
	//promote standard user to admin, demote admin to standard and delete the same user//
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TCC_01_Validate_UserPreferences_add_Promote_demote_deleteUser_HOH(Map<String,String> testdata) throws Exception{
		String randomNumbers = RandomStringUtils.randomNumeric(3);
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String charterID=testdata.get("charterID")+randomNumbers;
		String lastname=testdata.get("lastname");
		String email=testdata.get("email");
		String Mobilephone=testdata.get("Mobilephone");
		String security_question=testdata.get("security_question");
		String security_answer=testdata.get("security_answer");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadUPPage();

		UserPreferencePage UPPage=new UserPreferencePage(driver);
		UPPage.add_User(lastname, charterID, password, email,security_question, security_answer,Mobilephone);
		UPPage.selectuser(userType.username, charterID);
		UPPage.Promote_Selected_User("Admin");
		UPPage.selectuser(userType.username,charterID);
		UPPage.Demote_Selected_User("Standard");
		UPPage.selectuser(userType.username,charterID);
		Assert.assertTrue(UPPage.deleteUser(), "User is not able to delete Selected user");
		hp.logoutApplication();

	}

	//e2e5031_child_01

	//Name: TCC_02_Validate_UserPreferences_add_Promote_StandardUser_to_Admin_by_Admin()
	//Description: Validate whether Admin user is able to create standard user, 
	//promote standard user to admin, and login with HOH user and demote admin to standard and delete the same user//
	//Admin User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TCC_02_Validate_UserPreferences_add_Promote_StandardUser_to_Admin_by_Admin(Map<String,String> testdata) throws Exception{

		String randomNumbers = RandomStringUtils.randomNumeric(3);
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String charterID=testdata.get("charterID")+randomNumbers;
		String lastname=testdata.get("lastname");
		String email=testdata.get("email");
		String Mobilephone=testdata.get("Mobilephone");
		String security_question=testdata.get("security_question");
		String security_answer=testdata.get("security_answer");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadUPPage();
		UserPreferencePage UPPage=new UserPreferencePage(driver);
		UPPage.add_User(lastname, charterID, password, email,security_question, security_answer,Mobilephone);
		UPPage.selectuser(userType.username, charterID);
		UPPage.Promote_Selected_User("Admin");
		hp.logoutApplication();
		hp.login("E2E5034", password );  
		MAPage.openMyAccountTab();
		MAPage.loadUPPage();
		UPPage.selectuser(userType.username, charterID);
		UPPage.Demote_Selected_User("Standard");
		UPPage.selectuser(userType.username,charterID);
		Assert.assertTrue(UPPage.deleteUser(), "User is not able to delete Selected user");
		hp.logoutApplication();
	}

	// If you click on Reschedule button, calendar should be displayed to Reschedule the appointment 
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)

	public void MA_SAP_Rescheduleappointment_HOH_T517997(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T517997"+ File.separator + "LoginPage");
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		OverviewPage Vpage=new OverviewPage(driver);
		Vpage.Overviewlink();
		screenshot.saveScreenshot("T517997"+ File.separator + "Overview Page");
		Vpage.Reschedule_Appointment();
		hp.logoutApplication();
	}

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)

	public void MA_SAP_Rescheduleappointment_Admin_T517998(Map<String,String> testdata) throws Exception {


		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T517998"+ File.separator + "LoginPage");
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		OverviewPage Vpage=new OverviewPage(driver);
		Vpage.Overviewlink();
		screenshot.saveScreenshot("T517998"+ File.separator + "Overview Page");
		Vpage.Reschedule_Appointment();

		hp.logoutApplication();
	}


	// If you click on Reschedule button Message should be displayed
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)

	public void MA_SAP_Rescheduleinstalledwork_HOH_T518001(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518001"+ File.separator + "LoginPage");
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		OverviewPage Vpage=new OverviewPage(driver);
		Vpage.Overviewlink();
		screenshot.saveScreenshot("T518001"+ File.separator + "Overview Page");
		Vpage.Reschedule_Appointment();

		hp.logoutApplication();
	}



	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)

	public void MA_SAP_Rescheduleinstalledwork_Admin_T518002(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518002"+ File.separator + "LoginPage");
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		OverviewPage Vpage=new OverviewPage(driver);
		Vpage.Overviewlink();
		screenshot.saveScreenshot("T518002"+ File.separator + "Overview Page");
		Vpage.Reschedule_Appointment();
		hp.logoutApplication();
	}

	// Cancel Appointment
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)

	public void MA_SAP_Cancel_appointment_HOH_T517999(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T517999"+ File.separator + "Login Page");
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		OverviewPage Vpage=new OverviewPage(driver);
		Vpage.Overviewlink();
		screenshot.saveScreenshot("T517999"+ File.separator + "Overview Page");
		Vpage.Cancel_Appointment();
		hp.logoutApplication();

	}

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)

	public void MA_SAP_Cancel_appointment_Admin_T518000(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518000"+ File.separator + "LoginPage");
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		OverviewPage Vpage=new OverviewPage(driver);
		Vpage.Overviewlink();
		screenshot.saveScreenshot("T518000"+ File.separator + "Overview Page");
		Vpage.Cancel_Appointment();
		hp.logoutApplication();

	}


	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)

	public void validate_TVInternetVoice_DetailsLink_T517987(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );

		screenshot.saveScreenshot("T517987"+ File.separator + "LoginPage");

		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadOverviewPage();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		screenshot.saveScreenshot("T517987"+ File.separator + "Overview Page");
		OverviewPage Ovrpge=new OverviewPage(driver);
		Ovrpge.TVInternetVoiceLInk();
		screenshot.saveScreenshot("T517987"+ File.separator + "Navigated Back to Overview Page");
		hp.logoutApplication();

	}

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)

	public void MyAccount_ServiceAndEquipment_TV_T517981(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T517981"+ File.separator + "LoginPage");

		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadOverviewPage();
		//driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		screenshot.saveScreenshot("T517981"+ File.separator +"OverViewPage");
		OverviewPage Ovrpge=new OverviewPage(driver);
		Ovrpge.VerifyOverViewPageTitle();
		Ovrpge.validateServiceAndEquipment_TV();
		hp.logoutApplication();

	}

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)

	public void MyAccount_ServiceAndEquipment_Internet_T517988(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T517988"+ File.separator + "LoginPage");

		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadOverviewPage();
		// driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		screenshot.saveScreenshot("T517988"+ File.separator +"OverViewPage");
		OverviewPage Ovrpge=new OverviewPage(driver);
		Ovrpge.VerifyOverViewPageTitle();
		Ovrpge.validateServiceAndEquipment_Internet();
		hp.logoutApplication();

	}

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)

	public void MyAccount_ServiceAndEquipment_Voice_T517992(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T517992"+ File.separator + "LoginPage");

		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadOverviewPage();
		// driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		screenshot.saveScreenshot("T517992"+ File.separator +"OverViewPage");
		OverviewPage Ovrpge=new OverviewPage(driver);
		Ovrpge.VerifyOverViewPageTitle();
		Ovrpge.validateServiceAndEquipment_Voice();
		hp.logoutApplication();

	}
}
