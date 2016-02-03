package com.charter.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.charter.page.AuthenticationPage;
import com.charter.page.EmailPage;
import com.charter.page.HomePage;
import com.charter.page.MyAccountPage;
import com.charter.page.OverviewPage;
import com.charter.page.UserPreferencePage;
import com.charter.utils.Constants;
import com.charter.utils.DataProviderClass;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.TestNGBase;

public class Login extends TestNGBase{
	
		private String URL= Constants.URL;
		
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TL01_Validate_ChaterValidLogin(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		
		HomePage hp=new HomePage(driver);
		String[] TDArray = {username,password};
		Assert.assertTrue(hp.verifyTestData(TDArray), "Test data Undefined"); // Verify the test data definition
		Assert.assertTrue(hp.loadCharterPage(URL),"Charter URL loading unsuccessful"); // Verify Charter URL is loaded
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.ValidLogin(username,password), "Valid login function failed"); // Verify login for valid credentials
	}
	
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TL02_Validate_ChaterInvalidLogin(Map<String,String> testdata) throws Exception {

		String invalidusername = testdata.get("UserID1");
		String invalidPassword = testdata.get("invalidPassword");
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		
		HomePage hp=new HomePage(driver);
		String[] TDArray = {invalidusername,invalidPassword,username,password};
		
		Assert.assertTrue(hp.verifyTestData(TDArray), "Test data Undefined"); // Verify the test data definition
		Assert.assertTrue(hp.loadCharterPage(URL),"Charter URL loading unsuccessful"); // Verify Charter URL is loaded
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.InValidLogin(invalidusername,invalidPassword), "Invalid login function failed"); // Verify Error displayed on invalid login credentials
		Assert.assertTrue(hp.loadCharterPage(URL),"Charter URL loading unsuccessful"); // Verify Charter URL is loaded
		Assert.assertTrue(auth.ValidLogin(username,password), "Valid login function failed"); // Verify successful login with valid credentials
	}
	
	//Name: TL03_Validate_Non_ConvertedUser_UpdateUserPage
	//Description: Validate Update Username Page displayed when non converted user logs into Charter.net 
	//HOH User
	//Scripter:Dhruva
	//Date/Version:17-Aug-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TL03_Validate_Non_ConvertedUser_UpdateUserPage(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String lastName = testdata.get("lastname");
		String secQ = testdata.get("security_question");
		String secA = testdata.get("security_answer");
		String email = testdata.get("email");
		String phone = testdata.get("Mobilephone");

		String[] TDArray = {username,password,lastName,secQ,secA,email,phone};
		HomePage hp=new HomePage(driver);
		Assert.assertTrue(hp.verifyTestData(TDArray), "Test data Undefined"); // Verify the test data definition
		
		Assert.assertTrue(hp.loadCharterPage(URL),"Charter URL loading unsuccessful"); // Verify Charter URL is loaded
		Assert.assertTrue(hp.UnconvertedLogin(username, password),"Login Unsuccessful"); // Login to Charter Application
		AuthenticationPage ap=new AuthenticationPage(driver);
		Assert.assertTrue(ap.updateUsername(username,lastName,secQ,secA,email,phone),"Update Username page is not displayed for Unconverted user"); //Update the username for unconverted user
		//ap.mailLogin(username, password);
		//ap.Conversion_ConfirmationMail(username);
	}
	
	//Name: TL04_Validate_ChaterLogin_RememberMe
	//Description: Validate username is saved in cookies when user selects Remember Me checkbox 
	//HOH User
	//Scripter:Dhruva
	//Date/Version:13-Oct-2015
	//Pre-requisite: Provision the double play account with Internet and Voice service in legacy through Sigma/CSG for Central State Sys Prin
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TL04_Validate_ChaterLogin_RememberMe(Map<String,String> testdata) throws Exception {
		
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		
		HomePage hp=new HomePage(driver);
		String[] TDArray = {username,password};// Verify the test data definition
		Assert.assertTrue(hp.verifyTestData(TDArray), "Test data Undefined");
		Assert.assertTrue(hp.loadCharterPage(URL),"Charter URL loading unsuccessful"); // Verify Charter URL is loaded
		Assert.assertTrue(hp.rememberMe(username,password),"Charter Login Unsuccessful"); // Login to Charter Application checking Remember Me option
		Assert.assertTrue(hp.logoutApplication(),"Charter Login Unsuccessful");//Logout from Charter Application 
		Assert.assertTrue(hp.usernameSuggestion(username,password),"Remember Me option doesn't save the username");//Checking the username suggestion during login 
		Assert.assertTrue(hp.logoutApplication(),"Charter Logout Unsuccessful"); // logout from Charter Application
	}
	
	//Name: TL05_Validate_Convert_StdUser_Check_HOHAdminLogin
	//Description: Validate that converting standard user doesn't affect HOH and Admin user 
	//HOH User
	//Scripter:Dhruva
	//Date/Version:13-Nov-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TL05_Validate_Convert_StdUser_Check_HOHAdminLogin(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String lastName = testdata.get("lastname");
		String secQ = testdata.get("security_question");
		String secA = testdata.get("security_answer");
		String email = testdata.get("email");
		String phone = testdata.get("Mobilephone");
		String hohuser=testdata.get("hohuser");
		String adminuser=testdata.get("adminuser");
		
		HomePage hp=new HomePage(driver);
		String[] TDArray = {username,password,lastName,secQ,secA,email,phone,hohuser,adminuser};// Verify the test data definition
		Assert.assertTrue(hp.verifyTestData(TDArray), "Test data Undefined");
		Assert.assertTrue(hp.loadCharterPage(URL),"Charter URL loading unsuccessful"); // Verify Charter URL is loaded
		Assert.assertTrue(hp.UnconvertedLogin(username, password),"Login Unsuccessful"); // Login to Charter Application
		AuthenticationPage ap=new AuthenticationPage(driver);
		Assert.assertTrue(ap.updateUsername(username,lastName,secQ,secA,email,phone),"Update Username page is not displayed for Unconverted user");//Update the username for unconverted user
		EmailPage em = new EmailPage(driver);
/*		ap.mailLogin(username, password);
		ap.Conversion_ConfirmationMail(username);
		em.mailLogout();*/
/*		Assert.assertTrue(hp.loadCharterPage(URL),"Charter URL loading unsuccessful"); // Verify Charter URL is loaded
		Assert.assertTrue(hp.login(hohuser, password),"Login Unsuccessful"); // Login to Charter Application by HOH user
		Assert.assertTrue(hp.logoutApplication(),"Charter Logout Unsuccessful"); // logout from Charter Application
		System.out.println("HOH user login successful");
		Assert.assertTrue(hp.loadCharterPage(URL),"Charter URL loading unsuccessful"); // Verify Charter URL is loaded
		Assert.assertTrue(hp.login(adminuser, password),"Login Unsuccessful"); // Login to Charter Application by Admin user
		Assert.assertTrue(hp.logoutApplication(),"Charter Logout Unsuccessful"); // logout from Charter Application
		System.out.println("Admin user login successful");*/
	}
	
	//Name: TL06_Validate_Convert_AdminUser_Check_HOHLogin
	//Description: Validate that converting Admin user doesn't affect HOH user 
	//HOH User
	//Scripter:Dhruva
	//Date/Version:13-Nov-2015
	//Pre Condition : HOH and Admin should have same name and different password
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TL06_Validate_Convert_AdminUser_Check_HOHLogin(Map<String,String> testdata) throws Exception {
		
		String password = testdata.get("UserPassword");
		String lastName = testdata.get("lastname");
		String secQ = testdata.get("security_question");
		String secA = testdata.get("security_answer");
		String email = testdata.get("email");
		String phone = testdata.get("Mobilephone");
		String hohuser=testdata.get("hohuser");
		String adminuser=testdata.get("adminuser");
		
		HomePage hp=new HomePage(driver);
		String[] TDArray = {password,lastName,secQ,secA,email,phone,hohuser,adminuser};// Verify the test data definition
		Assert.assertTrue(hp.verifyTestData(TDArray), "Test data Undefined");
		Assert.assertTrue(hp.loadCharterPage(URL),"Charter URL loading unsuccessful"); // Verify Charter URL is loaded
		Assert.assertTrue(hp.UnconvertedLogin(adminuser, password),"Login Unsuccessful"); // Login to Charter Application by admin user
		AuthenticationPage ap=new AuthenticationPage(driver);
		Assert.assertTrue(ap.updateUsername(adminuser,lastName,secQ,secA,email,phone),"Update Username page is not displayed for Unconverted user");//Update the username for unconverted user
/*		EmailPage em = new EmailPage(driver);
		ap.mailLogin(adminuser, password);
		ap.Conversion_ConfirmationMail(adminuser);
		em.mailLogout();
		Assert.assertTrue(hp.loadCharterPage(URL),"Charter URL loading unsuccessful"); // Verify Charter URL is loaded
		Assert.assertTrue(ap.InValidLogin(hohuser, password),"Login Error Message not displayed for HOH login");//HOH user login
		Assert.assertTrue(hp.logoutApplication(),"Charter Logout Unsuccessful"); // logout from Charter Application
		System.out.println("HOH user login unsuccessful");
		Assert.assertTrue(hp.login(adminuser, password),"Login Unsuccessful"); // Login to Charter Application by admin user
		Assert.assertTrue(hp.logoutApplication(),"Charter Logout Unsuccessful"); // logout from Charter Application
		System.out.println("Admin user login successful");*/
	}
	
	//Name: TL07_Validate_Convert_twoUsers_SamePassword
	//Description: Validate that while converting a user is not affecting another user with same password but different namespace(.com and .net)
	//HOH User
	//Scripter:Dhruva
	//Date/Version:13-Nov-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TL07_Validate_Convert_twoUsers_SamePassword(Map<String,String> testdata) throws Exception {
		
		String DotnetUser = testdata.get("UserID");
		String MSlogin = testdata.get("MSLogin");
		String password = testdata.get("UserPassword");
		String lastName = testdata.get("lastname");
		String secQ = testdata.get("security_question");
		String secA = testdata.get("security_answer");
		String DotNetemail = testdata.get("email");
		String phone = testdata.get("Mobilephone");

		HomePage hp=new HomePage(driver);
		String[] TDArray = {password,lastName,secQ,secA,DotNetemail,phone,DotnetUser,MSlogin};// Verify the test data definition
		Assert.assertTrue(hp.verifyTestData(TDArray), "Test data Undefined");
		AuthenticationPage ap=new AuthenticationPage(driver);
		Assert.assertTrue(hp.loadCharterPage(URL),"Charter URL loading unsuccessful"); // Verify Charter URL is loaded
		Assert.assertTrue(hp.UnconvertedLogin(MSlogin, password),"Login Unsuccessful"); // Login to Charter Application
		Assert.assertTrue(ap.updateUsername(MSlogin,lastName,secQ,secA,DotNetemail,phone),"Update Username page is not displayed for Unconverted user");//Update the username for unconverted user
/*		ap.mailLogin(user2, password);
		ap.Conversion_ConfirmationMail(user2);
		em.mailLogout();*/
		Assert.assertTrue(hp.loadCharterPage(URL),"Charter URL loading unsuccessful"); // Verify Charter URL is loaded
		Assert.assertTrue(hp.UnconvertedLogin(DotnetUser, password),"Login Unsuccessful"); // Login to Charter Application
		Assert.assertTrue(ap.updateUsername(DotnetUser,lastName,secQ,secA,DotNetemail,phone),"Update Username page is not displayed for Unconverted user");//Update the username for unconverted user
		EmailPage em = new EmailPage(driver);
/*		ap.mailLogin(user1, password);
		ap.Conversion_ConfirmationMail(user1);
		em.mailLogout();*/
	}
	
	//Name: TL08_Validate_ForceConvertUser_afterFirstAttempt
	//Description: Validate whether the user is getting converted forcefully after 1 attempt in not converting the account
	//HOH User
	//Scripter:Dhruva
	//Date/Version:13-Nov-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TL08_Validate_ForceConvertUser_afterFirstAttempt(Map<String,String> testdata) throws Exception {
		
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String lastName = testdata.get("lastname");
		String secQ = testdata.get("security_question");
		String secA = testdata.get("security_answer");
		String email = testdata.get("email");
		String phone = testdata.get("Mobilephone");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		AuthenticationPage ap=new AuthenticationPage(driver);
		ap.firstTimeConversion();
		EmailPage em = new EmailPage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		Assert.assertTrue(ap.secondTimeConversion(username,lastName,secQ,secA,email,phone),"Update Username page is not displayed for Unconverted user");
/*		ap.mailLogin(username, password);
		ap.Conversion_ConfirmationMail(username);
		em.mailLogout();*/
	}

	@Test
	public void Validate_Overviewpage_edit() throws Exception {

		String username = "tdr33005";
		String password = "Testing01";
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage ma=new MyAccountPage(driver);
		ma.openMyAccountTab();
		ma.loadOverviewPage();
	}
	
	//Name: TL09_Validate_MSLoginConvert_LessThan6Characters()
	//Description: To verify that MS Login ID is able to convert the user when Mslogin and Charter.net is < 6 Characters with same account numbers and MS Login is different from .net ID.
	//HOH user
	//Scripter:Dhruva
	//Date/Version:18-Nov-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TL09_Validate_MSLoginConvert_LessThan6Characters(Map<String,String> testdata) throws Exception {
		
		String dotnetID = testdata.get("UserID");
		String MSLogin = testdata.get("MSLogin");
		String MSLoginPassword = testdata.get("MSLoginPassword");
		String lastName = testdata.get("lastname");
		String secQ = testdata.get("security_question");
		String secA = testdata.get("security_answer");
		String email = testdata.get("email");
		String phone = testdata.get("Mobilephone");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(MSLogin, MSLoginPassword);
		AuthenticationPage ap=new AuthenticationPage(driver);
		Assert.assertTrue(ap.convertUserMSLogin(MSLogin,lastName,secQ,secA,email,phone,dotnetID),"Update Username page is not displayed for Unconverted user");
	}
	
	//Name: TL10_Validate_MSLoginConvert_LessThan6Characters_StdUser_MoreThan6Characters()
	//Description: To verify that MS Login ID is able to convert the user when MSlogin and Charter.net is < 6 Characters & Standard user>6 characters with same account numbers
	//HOH/Standard user
	//Scripter:Dhruva
	//Date/Version:18-Nov-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TL10_Validate_MSLoginConvert_LessThan6Characters_StdUser_MoreThan6Characters(Map<String,String> testdata) throws Exception {

		String dotnetID = testdata.get("UserID");
		String MSLogin = testdata.get("MSLogin");
		String MSLoginPassword = testdata.get("MSLoginPassword");
		String lastName = testdata.get("lastname");
		String secQ = testdata.get("security_question");
		String secA = testdata.get("security_answer");
		String email = testdata.get("email");
		String phone = testdata.get("Mobilephone");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(MSLogin, MSLoginPassword);
		AuthenticationPage ap=new AuthenticationPage(driver);
		Assert.assertTrue(ap.convertUserMSLogin(MSLogin,lastName,secQ,secA,email,phone,dotnetID),"Update Username page is not displayed for Unconverted user");
		hp.login(dotnetID, MSLoginPassword);
		MyAccountPage ma = new MyAccountPage(driver);
		ma.loadUPPage();
		UserPreferencePage up = new UserPreferencePage(driver);
		up.checkAccountUsers();
	}
	
	//Name: TL11_Validate_DotNetIDConvert_LessThan6Characters_StdUser_MoreThan6Characters()
	//Description: To verify that .net Login ID is able to convert the user when MSlogin and Charter.net is < 6 Characters & Standard user>6 characters with same account numbers
	//HOH/Standard user
	//Scripter:Dhruva
	//Date/Version:18-Nov-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TL11_Validate_DotNetIDConvert_LessThan6Characters_StdUser_MoreThan6Characters(Map<String,String> testdata) throws Exception {
		
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String lastName = testdata.get("lastname");
		String secQ = testdata.get("security_question");
		String secA = testdata.get("security_answer");
		String email = testdata.get("email");
		String phone = testdata.get("Mobilephone");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		AuthenticationPage ap=new AuthenticationPage(driver);
		Assert.assertTrue(ap.convertUserDotNetID(username,lastName,secQ,secA,email,phone),"Update Username page is not displayed for Unconverted user");
		hp.login(username, password);
		MyAccountPage ma = new MyAccountPage(driver);
		ma.loadUPPage();
		UserPreferencePage up = new UserPreferencePage(driver);
		up.checkAccountUsers();
	}
	
	//Name: TL12_Validate_MSLoginID_MSLogin_MoreThan6Characters_DotNetID_LessThan6Characters()
	//Description: To verify that MSLogin ID is able to login when Mslogin > 6 Character and Charter.net ID < 6 Character with same account numbers
	//HOH user
	//Scripter:Dhruva
	//Date/Version:18-Nov-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TL12_Validate_MSLoginID_MSLogin_MoreThan6Characters_DotNetID_LessThan6Characters(Map<String,String> testdata) throws Exception {
		
		String dotnetID = testdata.get("UserID");
		String MSLogin = testdata.get("MSLogin");
		String MSLoginPassword = testdata.get("MSLoginPassword");
		String lastName = testdata.get("lastname");
		String secQ = testdata.get("security_question");
		String secA = testdata.get("security_answer");
		String email = testdata.get("email");
		String phone = testdata.get("Mobilephone");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(MSLogin, MSLoginPassword);
		AuthenticationPage ap=new AuthenticationPage(driver);
		Assert.assertTrue(ap.convertUserMSLogin(MSLogin,lastName,secQ,secA,email,phone,dotnetID),"Update Username page is not displayed for Unconverted user");
		hp.login(dotnetID, MSLoginPassword);
		MyAccountPage ma = new MyAccountPage(driver);
		ma.loadUPPage();
		UserPreferencePage up = new UserPreferencePage(driver);
		up.checkAccountUsers();
	}
	
	//Name: TL13_Validate_DotNetID_MSLogin_MoreThan6Characters_DotNetLogin_LessThan6Characters()
	//Description: To verify that.net ID is able to login when Mslogin > 6 Character and Charter.net ID < 6 Character with same account numbers
	//HOH user
	//Scripter:Dhruva
	//Date/Version:18-Nov-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TL13_Validate_DotNetID_MSLogin_MoreThan6Characters_DotNetLogin_LessThan6Characters(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		String lastName = testdata.get("lastname");
		String secQ = testdata.get("security_question");
		String secA = testdata.get("security_answer");
		String email = testdata.get("email");
		String phone = testdata.get("Mobilephone");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		AuthenticationPage ap=new AuthenticationPage(driver);
		Assert.assertTrue(ap.convertUserDotNetID(username,lastName,secQ,secA,email,phone),"Update Username page is not displayed for Unconverted user");
	}
	
	//Name: TL14_Validate_Account1_MSLogin_Conflicts_with_Account2_stdUser_DotNetID_HOHConverted()
	//Description: To verify the MSlogin when MSLogin has Conflicting namespace with other account standard user .Net id(HOH user already converted)
	//HOH user
	//Scripter:Dhruva
	//Date/Version:18-Nov-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TL14_Validate_Account1_MSLogin_Conflicts_with_Account2_stdUser_DotNetID_HOHConverted(Map<String,String> testdata) throws Exception {

		String dotnetID = testdata.get("UserID");
		String MSLogin = testdata.get("MSLogin");
		String MSLoginPassword = testdata.get("MSLoginPassword");
		String lastName = testdata.get("lastname");
		String secQ = testdata.get("security_question");
		String secA = testdata.get("security_answer");
		String email = testdata.get("email");
		String phone = testdata.get("Mobilephone");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(MSLogin, MSLoginPassword);
		AuthenticationPage ap=new AuthenticationPage(driver);
		Assert.assertTrue(ap.convertUserMSLogin(MSLogin,lastName,secQ,secA,email,phone,dotnetID),"Update Username page is not displayed for Unconverted user");
	}
	
	//Name: TL15_Validate_Acc1_MSLoginConvert_when_Account1_MSLogin_Conflicts_with_Account2_DotNetID()
	//Description: To verify the Account 1 MSlogin when MSLogin has Conflicting namespace with other account .Net id
	//HOH user
	//Scripter:Dhruva
	//Date/Version:18-Nov-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TL15_Validate_Acc1_MSLoginConvert_when_Account1_MSLogin_Conflicts_with_Account2_DotNetID(Map<String,String> testdata) throws Exception {
		
		String dotnetID = testdata.get("UserID");
		String MSLogin = testdata.get("MSLogin");
		String MSLoginPassword = testdata.get("MSLoginPassword");
		String lastName = testdata.get("lastname");
		String secQ = testdata.get("security_question");
		String secA = testdata.get("security_answer");
		String email = testdata.get("email");
		String phone = testdata.get("Mobilephone");
		
		HomePage hp=new HomePage(driver);
		String[] TDArray = {dotnetID,MSLogin,lastName,secQ,secA,email,phone,MSLoginPassword};// Verify the test data definition
		Assert.assertTrue(hp.verifyTestData(TDArray), "Test data Undefined");
		Assert.assertTrue(hp.loadCharterPage(URL),"Charter URL loading unsuccessful"); // Verify Charter URL is loaded
		Assert.assertTrue(hp.UnconvertedLogin(MSLogin, MSLoginPassword),"Login Unsuccessful"); // Login to Charter Application
		AuthenticationPage ap=new AuthenticationPage(driver);
		Assert.assertTrue(ap.convertUserMSLogin(MSLogin,lastName,secQ,secA,email,phone,dotnetID),"Update Username page is not displayed for Unconverted user");//Update the username for unconverted user
	}
	
	//Name: TL16_Validate_Acc2_MSLoginConvert_when_Account1_MSLogin_Conflicts_with_Account2_DotNetID()
	//Description: To verify the Account 2 MSlogin when MSLogin has Conflicting namespace with other account .Net id
	//HOH user
	//Scripter:Dhruva
	//Date/Version:18-Nov-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TL16_Validate_Acc2_MSLoginConvert_when_Account1_MSLogin_Conflicts_with_Account2_DotNetID(Map<String,String> testdata) throws Exception {
		
		String dotnetID = testdata.get("UserID");
		String MSLogin = testdata.get("MSLogin");
		String MSLoginPassword = testdata.get("MSLoginPassword");
		String lastName = testdata.get("lastname");
		String secQ = testdata.get("security_question");
		String secA = testdata.get("security_answer");
		String email = testdata.get("email");
		String phone = testdata.get("Mobilephone");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(MSLogin, MSLoginPassword);
		AuthenticationPage ap=new AuthenticationPage(driver);
		Assert.assertTrue(ap.convertUserMSLogin(MSLogin,lastName,secQ,secA,email,phone,dotnetID),"Update Username page is not displayed for Unconverted user");//Update the username for unconverted user
	}
	
	//Name: TL17_Validate_Acc1_DotnetIDConvert_when_Account1_MSLogin_Conflicts_with_Account2_DotNetID()
	//Description: To verify the Account 1 .netID when MSLogin has Conflicting namespace with other account .Net id
	//HOH user
	//Scripter:Dhruva
	//Date/Version:18-Nov-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TL17_Validate_Acc1_DotnetIDConvert_when_Account1_MSLogin_Conflicts_with_Account2_DotNetID(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String lastName = testdata.get("lastname");
		String secQ = testdata.get("security_question");
		String secA = testdata.get("security_answer");
		String email = testdata.get("email");
		String phone = testdata.get("Mobilephone");
		
		HomePage hp=new HomePage(driver);
		String[] TDArray = {username,password,lastName,secQ,secA,email,phone};// Verify the test data definition
		Assert.assertTrue(hp.verifyTestData(TDArray), "Test data Undefined");
		Assert.assertTrue(hp.loadCharterPage(URL),"Charter URL loading unsuccessful"); // Verify Charter URL is loaded
		Assert.assertTrue(hp.UnconvertedLogin(username, password),"Login Unsuccessful"); // Login to Charter Application
		AuthenticationPage ap=new AuthenticationPage(driver);
		Assert.assertTrue(ap.convertUserDotNetID(username,lastName,secQ,secA,email,phone),"Update Username page is not displayed for Unconverted user");//Update the username for unconverted user
	}
	
	//Name: TL18_Validate_MSLoginConvert_when_same_MSLogin_DotNetID_differentPassword()
	//Description: To validate that MS Login is able to convert user when MS Login and .net IDs are same but with different password
	//HOH user
	//Scripter:Dhruva
	//Date/Version:18-Nov-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TL18_Validate_MSLoginConvert_when_same_MSLogin_DotNetID_differentPassword(Map<String,String> testdata) throws Exception {
		
		String dotnetID = testdata.get("UserID");
		String MSLogin = testdata.get("MSLogin");
		String MSLoginPassword = testdata.get("MSLoginPassword");
		String lastName = testdata.get("lastname");
		String secQ = testdata.get("security_question");
		String secA = testdata.get("security_answer");
		String email = testdata.get("email");
		String phone = testdata.get("Mobilephone");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.MyAccountRefererlogin(MSLogin, MSLoginPassword);
		AuthenticationPage ap=new AuthenticationPage(driver);
		Assert.assertTrue(ap.convertUserMSLogin(MSLogin,lastName,secQ,secA,email,phone,dotnetID),"Update Username page is not displayed for Unconverted user");//Update the username for unconverted user
	}
	
	//Name: TL19_Validate_DotNetIDConvert_when_same_MSLogin_DotNetID_differentPassword()
	//Description: To validate that DotNet ID is able to convert user when MS Login and .net IDs are same but with different password
	//HOH user
	//Scripter:Dhruva
	//Date/Version:18-Nov-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TL19_Validate_DotNetIDConvert_when_same_MSLogin_DotNetID_differentPassword(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String lastName = testdata.get("lastname");
		String secQ = testdata.get("security_question");
		String secA = testdata.get("security_answer");
		String email = testdata.get("email");
		String phone = testdata.get("Mobilephone");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.MyAccountRefererlogin(username, password);
		AuthenticationPage ap=new AuthenticationPage(driver);
		Assert.assertTrue(ap.convertUserDotNetID(username,lastName,secQ,secA,email,phone),"Update Username page is not displayed for Unconverted user");//Update the username for unconverted user
	}
	
	//Name: TL20_Validate_MSLoginConvert_when_same_MSLogin_DotNetID_samePassword()
	//Description: To validate that MSLogin ID is able to convert user when MS Login and .net IDs are same and with same password
	//HOH user
	//Scripter:Dhruva
	//Date/Version:18-Nov-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TL20_Validate_MSLoginConvert_when_same_MSLogin_DotNetID_samePassword(Map<String,String> testdata) throws Exception {
		
		String dotnetID = testdata.get("UserID");
		String MSLogin = testdata.get("MSLogin");
		String MSLoginPassword = testdata.get("MSLoginPassword");
		String lastName = testdata.get("lastname");
		String secQ = testdata.get("security_question");
		String secA = testdata.get("security_answer");
		String email = testdata.get("email");
		String phone = testdata.get("Mobilephone");
		
		HomePage hp=new HomePage(driver);
		String[] TDArray = {dotnetID,MSLogin,MSLoginPassword,lastName,secQ,secA,email,phone};// Verify the test data definition
		Assert.assertTrue(hp.verifyTestData(TDArray), "Test data Undefined");
		Assert.assertTrue(hp.loadCharterPage(URL),"Charter URL loading unsuccessful"); // Verify Charter URL is loaded
		Assert.assertTrue(hp.MyAccountRefererlogin(MSLogin, MSLoginPassword),"Charter login unsuccessful"); // Verify Charter login with myaccount=Referrer
		AuthenticationPage ap=new AuthenticationPage(driver);
		Assert.assertTrue(ap.convertUserMSLogin(MSLogin,lastName,secQ,secA,email,phone,dotnetID),"Update Username page is not displayed for Unconverted user");//Update the username for unconverted user
	}
	
	//Name: TL21_Validate_DotNetIDConvert_when_same_MSLogin_DotNetID_samePassword()
	//Description: To validate that DotNet ID is able to convert user when MS Login and .net IDs are same and with same password
	//HOH user
	//Scripter:Dhruva
	//Date/Version:18-Nov-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TL21_Validate_DotNetIDConvert_when_same_MSLogin_DotNetID_samePassword(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String lastName = testdata.get("lastname");
		String secQ = testdata.get("security_question");
		String secA = testdata.get("security_answer");
		String email = testdata.get("email");
		String phone = testdata.get("Mobilephone");
		
		HomePage hp=new HomePage(driver);
		String[] TDArray = {username,password,lastName,secQ,secA,email,phone};// Verify the test data definition
		Assert.assertTrue(hp.verifyTestData(TDArray), "Test data Undefined");
		Assert.assertTrue(hp.loadCharterPage(URL),"Charter URL loading unsuccessful"); // Verify Charter URL is loaded
		Assert.assertTrue(hp.MyAccountRefererlogin(username, password),"Charter login unsuccessful"); // Verify Charter login with myaccount=Referrer
		AuthenticationPage ap=new AuthenticationPage(driver);
		Assert.assertTrue(ap.convertUserDotNetID(username,lastName,secQ,secA,email,phone),"Update Username page is not displayed for Unconverted user");//Update the username for unconverted user
	}
	
	//Name: TL22_Validate_MSLoginConvert_when_same_MSLogin_DotNetID_samePassword_with_DotNetID_StandardUser()
	//Description: To validate that MS Login ID is able to convert user when MS Login and .net IDs are same with same passwords,with same account numbers and .net ID has standard user
	//HOH user
	//Scripter:Dhruva
	//Date/Version:18-Nov-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TL22_Validate_MSLoginConvert_when_same_MSLogin_DotNetID_samePassword_with_DotNetID_StandardUser(Map<String,String> testdata) throws Exception {

		String dotnetID = testdata.get("UserID");
		String MSLogin = testdata.get("MSLogin");
		String MSLoginPassword = testdata.get("MSLoginPassword");
		String lastName = testdata.get("lastname");
		String secQ = testdata.get("security_question");
		String secA = testdata.get("security_answer");
		String email = testdata.get("email");
		String phone = testdata.get("Mobilephone");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.MyAccountRefererlogin(MSLogin, MSLoginPassword);
		AuthenticationPage ap=new AuthenticationPage(driver);
		Assert.assertTrue(ap.convertUserMSLogin(MSLogin,lastName,secQ,secA,email,phone,dotnetID),"Update Username page is not displayed for Unconverted user");//Update the username for unconverted user
	}
	
	//Name: TL23_Validate_Login_HardDisconnectedAccount()
	//Description: To validate that hard disconnected user does not have access to charter.net
	//HOH user
	//Scripter:Dhruva
	//Date/Version:18-Nov-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TL23_Validate_Login_HardDisconnectedAccount(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		
		HomePage hp=new HomePage(driver);
		String[] TDArray = {username,password};// Verify the test data definition
		Assert.assertTrue(hp.verifyTestData(TDArray), "Test data Undefined");
		Assert.assertTrue(hp.loadCharterPage(URL),"Charter URL loading unsuccessful"); // Verify Charter URL is loaded
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.InValidLogin(username,password), "Disconnected user is allowed access to charter.net");//Verify login error for disconnected user
	}
	
	@AfterMethod
	public void afterMethod() throws InterruptedException{
		Thread.sleep(2000);
		driver.manage().deleteAllCookies();
		driver.close();
	}
}