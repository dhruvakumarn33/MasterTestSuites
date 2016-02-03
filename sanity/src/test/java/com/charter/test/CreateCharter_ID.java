package com.charter.test;

import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.charter.page.AuthenticationPage;
import com.charter.page.HomePage;
import com.charter.page.MyAccountPage;
import com.charter.page.UserPreferencePage;
import com.charter.page.UserPreferencePage.userType;
import com.charter.utils.Constants;
import com.charter.utils.DataProviderClass;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.TestNGBase;

public class CreateCharter_ID extends TestNGBase{
	private String URL= Constants.URL;


	//Name: TA01_Validate_HOHUser_CreateID()
	//Description: Validate whether the user is able to create an HOH account
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA01_Validate_HOHUser_CreateID(Map<String,String> testdata) throws Exception{

		String randomNumbers = RandomStringUtils.randomNumeric(3);
		String password = testdata.get("UserPassword");
		String charterID=testdata.get("charterID")+randomNumbers;
		String email=testdata.get("email");
		String security_question=testdata.get("security_question");
		String security_answer=testdata.get("security_answer");
		String firstname_CID=testdata.get("firstname_CID");
		String lastname_CID=testdata.get("lastname_CID");
		String Address_CID=testdata.get("address_CID");
		String Zipcode_CID=testdata.get("zipcode_CID");
		String MAC_CID=testdata.get("mac_CID");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		auth.createuser_HOH(firstname_CID,lastname_CID,Address_CID,Zipcode_CID,MAC_CID,charterID, password, email,security_question, security_answer);
		hp.logoutApplication();
	}

	//Name: TA02_Validate_StandardUser_PromotTo_Admin_HOHUser()
	//Description: Validate whether the HOH user is able to create an Standard user and promote him as an admin user 
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA02_Validate_StandardUser_PromotTo_Admin_HOHUser(Map<String,String> testdata) throws Exception{

		String randomNumbers = RandomStringUtils.randomNumeric(3);
		String password = testdata.get("UserPassword");
		String charterID=testdata.get("charterID")+randomNumbers;
		String email=testdata.get("email");
		String security_question=testdata.get("security_question");
		String security_answer=testdata.get("security_answer");
		String firstname_CID=testdata.get("firstname_CID");
		String lastname_CID=testdata.get("lastname_CID");
		String Address_CID=testdata.get("address_CID");
		String Zipcode_CID=testdata.get("zipcode_CID");
		String MAC_CID=testdata.get("mac_CID");
		String hohuser=testdata.get("hohuser");
		String Account_Type=testdata.get("Account_Type");
		String Mobilephone=testdata.get("Mobilephone");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		auth.createuser_STND(firstname_CID,lastname_CID,Address_CID,Zipcode_CID,MAC_CID,charterID, password, email,security_question, security_answer,Mobilephone);
		hp.login(hohuser, password);
		hp.pagewait();
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.loadUPPage();
		hp.pagewait();
		UserPreferencePage UPpage=new UserPreferencePage(driver);
		UPpage.selectuser(userType.username,charterID);
		UPpage.Promote_Selected_User(Account_Type);
		UPpage.selectuser(userType.username, charterID);
		Assert.assertTrue(UPpage.deleteUser(), "User not deleted");
		hp.logoutApplication();
	}

	//Name: TA03_Validate_StandardUser_CreateID()
	//Description: Validate whether the user is able to create a Standard account 
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA03_Validate_StandardUser_CreateID(Map<String,String> testdata) throws Exception{

		String randomNumbers = RandomStringUtils.randomNumeric(3);
		String password = testdata.get("UserPassword");
		String charterID=testdata.get("charterID")+randomNumbers;
		String email=testdata.get("email");
		String security_question=testdata.get("security_question");
		String security_answer=testdata.get("security_answer");
		String firstname_CID=testdata.get("firstname_CID");
		String lastname_CID=testdata.get("lastname_CID");
		String Address_CID=testdata.get("address_CID");
		String Zipcode_CID=testdata.get("zipcode_CID");
		String MAC_CID=testdata.get("mac_CID");
		String hohuser=testdata.get("hohuser");
		String Mobilephone=testdata.get("Mobilephone");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		auth.createuser_STND(firstname_CID,lastname_CID,Address_CID,Zipcode_CID,MAC_CID,charterID, password, email,security_question, security_answer,Mobilephone);
		hp.login(hohuser, password);
		hp.pagewait();
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.loadUPPage();
		hp.pagewait();
		UserPreferencePage UPpage =new  UserPreferencePage(driver);
		UPpage.selectuser(userType.username, charterID);
		Assert.assertTrue(UPpage.deleteUser(), "User not deleted");
		hp.logoutApplication();
	}

	//Name: TA04_Validate_GetChaterIDLink_NavigateTo_CreateIDPage()
	//Description: Validate whether the user is able to navigate to Create account page on clicking business customers Get Charter ID link in Create ID Flow 
	//Scripter:Lakshmi
	//Date/Version:
	@Test
	public void TA04_Validate_GetChaterIDLink_NavigateTo_CreateIDPage() throws Exception{
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.cID_CommPage(), "User is not able to Navigate to Create Account page with business customer link in create Charter ID flow");
	}

	//Name: TA05_Validate_NextButtonEnabledWith_MandatoryFieldsFilled()
	//Description: Validate whether the Next button is getting enabled only after entering the mandatory fields in  Create ID flow 
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA05_Validate_NextButtonEnabledWith_MandatoryFieldsFilled(Map<String,String> testdata) throws Exception{

		String firstname_CID=testdata.get("firstname_CID");
		String lastname_CID=testdata.get("lastname_CID");
		String Address_CID=testdata.get("address_CID");
		String Zipcode_CID=testdata.get("zipcode_CID");
		String MAC_CID=testdata.get("mac_CID");
		String invalidZipcode=testdata.get("invalidZipcode");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.createID_Nextbutton(firstname_CID,lastname_CID,Address_CID,Zipcode_CID,MAC_CID,invalidZipcode), "Next button is not displayed after entering valid data in mandatory fields");
	}
	//Name: TA06_Validate_CreateIDHelpIcons()
	//Description: Validate help icons in Charter ID creation page 
	//Scripter:Ramana
	//Date/Version:
	@Test
	public void TA06_Validate_CreateIDHelpIcons() throws Exception{
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.CreateID_helpicons(), "Help icons are not present in the create ID First page");
	}
	
	//Name: TA07_Validate_ChaterIDRules()
	//Description: Validate Charter ID rules 
	//Scripter:Ramana
	//Date/Version:

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA07_Validate_ChaterIDRules(Map<String,String> testdata)throws Exception{
		
		String firstname_CID=testdata.get("firstname_CID");
		String lastname_CID=testdata.get("lastname_CID");
		String Address_CID=testdata.get("address_CID");
		String Zipcode_CID=testdata.get("zipcode_CID");
		String MAC_CID=testdata.get("mac_CID");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.CharterIDrules(firstname_CID,lastname_CID,Address_CID,Zipcode_CID,MAC_CID), "Charter ID rules Help icon is not present in create id flow");
	}

	//Name: TA08_Validate_CreateID_DataEntryFields()
	//Description: Validate Password data entry page for Password data requirements,Password help icon,Password Strength meter and Security Question
	//Scripter:Ramana
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA08_Validate_CreateID_DataEntryFields(Map<String,String> testdata) throws Exception{

		String randomNumbers = RandomStringUtils.randomNumeric(3);
		String charterID=testdata.get("charterID")+randomNumbers;
		String password = testdata.get("UserPassword");
		String email=testdata.get("email");
		String security_question=testdata.get("security_question");
		String security_answer=testdata.get("security_answer");
		String lastname_CID=testdata.get("lastname_CID");
		String Address_CID=testdata.get("address_CID");
		String Zipcode_CID=testdata.get("zipcode_CID");
		String MAC_CID=testdata.get("mac_CID");
		String invalidPassword=testdata.get("invalidPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.create_user_ID_fields(charterID,password,email,security_question,security_answer,lastname_CID,Address_CID,Zipcode_CID,MAC_CID,invalidPassword), "Password Entry requirements are not present in the create id flow");
	}

	//Name: TA09_Validate_CreateID_SuccessMessage()
	//Description:Validate successful message after charter ID creation
	//Scripter:Ramana
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA09_Validate_CreateID_SuccessMessage(Map<String,String> testdata) throws Exception{
		String randomNumbers = RandomStringUtils.randomNumeric(3);
		String charterID=testdata.get("charterID")+randomNumbers;
		String password = testdata.get("UserPassword");
		String email=testdata.get("email");
		String security_question=testdata.get("security_question");
		String security_answer=testdata.get("security_answer");
		String firstname_CID=testdata.get("firstname_CID");
		String lastname_CID=testdata.get("lastname_CID");
		String Address_CID=testdata.get("address_CID");
		String Zipcode_CID=testdata.get("zipcode_CID");
		String MAC_CID=testdata.get("mac_CID");
		String Mobilephone=testdata.get("Mobilephone");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.successful_msg(firstname_CID,charterID,password,email,security_question,security_answer,lastname_CID,Address_CID,Zipcode_CID,MAC_CID,Mobilephone), "User is -Not able to see Successful message after Charter ID creation in create id flow");
	}

	//Name: TA12_Validate_CreateID_InvalidZipCode_Message()
	//Description: Validate whether the user is able to view in-line warning message  when invalid length Zipcode entered in Create ID flow
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA12_Validate_CreateID_InvalidZipCode_Message(Map<String,String> testdata) throws Exception{

		String firstname_CID=testdata.get("firstname_CID");
		String lastname_CID=testdata.get("lastname_CID");
		String Address_CID=testdata.get("address_CID");
		String invalidZipcode=testdata.get("invalidZipcode");
		String MAC_CID=testdata.get("mac_CID");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.invalid_ZIP_CID(firstname_CID,lastname_CID,Address_CID,invalidZipcode,MAC_CID), "in-line Error message for Zipcode field is not displayed -Failed");
	}

	//Name: TA13_Validate_CreateID_InvalidMACaddress_Message()
	//Description: Validate whether the user is able to view in-line warning message is getting displayed when invalid length MAC address is entered in Create ID flow
	//Scripter:Ramana
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA13_Validate_CreateID_InvalidMACaddress_Message(Map<String,String> testdata) throws Exception{
		
		String firstname_CID=testdata.get("firstname_CID");
		String lastname_CID=testdata.get("lastname_CID");
		String Address_CID=testdata.get("address_CID");
		String Zipcode_CID=testdata.get("zipcode_CID");
		String invalidMAC=testdata.get("invalidMAC");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.invalid_Mac_CID(firstname_CID,lastname_CID,Address_CID,Zipcode_CID,invalidMAC), "in-line Error message for MAC field is not displayed -Failed");
	}

	//Name: TA14_Validate_CreateID_InvalidLastname_Message()
	//Description:Validate whether the user is able to view in-line warning message is getting displayed when invalid last name is entered in Create ID flow
	//Scripter:Ramana
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)	
	public void TA14_Validate_CreateID_InvalidLastname_Message(Map<String,String> testdata) throws Exception{
		
		String firstname_CID=testdata.get("firstname_CID");
		String invalidLastname=testdata.get("invalidLastname");
		String Address_CID=testdata.get("address_CID");
		String Zipcode_CID=testdata.get("zipcode_CID");
		String MAC_CID=testdata.get("mac_CID");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.invalid_lastname_CID(firstname_CID,invalidLastname,Address_CID,Zipcode_CID,MAC_CID), "in-line Error message for Last Name field is not displayed -Failed");
	}

	//Name: TA15_Validate_CreateID_InvalidServiceAddress_Message()
	//Description:Validate whether the user is able to view in-line warning message is getting displayed when invalid service address is entered in Create ID flow
	//Scripter:Ramana
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA15_Validate_CreateID_InvalidServiceAddress_Message(Map<String,String> testdata) throws Exception{

		String firstname_CID=testdata.get("firstname_CID");
		String lastname_CID=testdata.get("lastname_CID");
		String invalidAddress=testdata.get("invalidAddress");
		String Zipcode_CID=testdata.get("zipcode_CID");
		String MAC_CID=testdata.get("mac_CID");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.invalid_Service_Address_CID(firstname_CID,lastname_CID,invalidAddress,Zipcode_CID,MAC_CID), "in-line Error message for Address field is not displayed -Failed");
	}

	//Name: TA16_Validate_CreateID_NoDataEntry_Message()
	//Description: Validate error message if user didn't entered any data in any of the fields
	//Scripter:Ayesha
	//Date/Version:
	@Test
	public void TA16_Validate_CreateID_NoDataEntry_Message() throws Exception{
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.CreateID_missedfieldsmessages(), "Next button is enabled -if data is not entered in the fields");
	}

	//Name: TA17_Validate_CreateID_ConfirmPasswordMismatch_Message()
	//Description: Validate Confirm Password - must match password entered.Display in-line warning message if confirm password is not entered or about the password mismatch
	//Scripter:Ayesha
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA17_Validate_CreateID_ConfirmPasswordMismatch_Message(Map<String,String> testdata) throws Exception{

		String randomNumbers = RandomStringUtils.randomNumeric(3);
		String charterID=testdata.get("charterID")+randomNumbers;
		String password = testdata.get("UserPassword");
		String email=testdata.get("email");
		String firstname_CID=testdata.get("firstname_CID");
		String lastname_CID=testdata.get("lastname_CID");
		String Address_CID=testdata.get("address_CID");
		String Zipcode_CID=testdata.get("zipcode_CID");
		String MAC_CID=testdata.get("mac_CID");
		String invalidPassword=testdata.get("invalidPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.passwordmismatch_CID(firstname_CID,lastname_CID,Address_CID,Zipcode_CID,MAC_CID,charterID, password,invalidPassword, email), "In-line error message for password field is not displayed in create id flow -Failed");
	}

	//Name: TA18_Validate_CreateID_InvalidEmailText_Message()
	//Description: Validate whether the user is able to view in-line warning message is getting displayed when invalid Email is entered in Create ID flow
	//Scripter:Ayesha
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA18_Validate_CreateID_InvalidEmailText_Message(Map<String,String> testdata) throws Exception{

		String randomNumbers = RandomStringUtils.randomNumeric(3);
		String charterID=testdata.get("charterID")+randomNumbers;
		String password = testdata.get("UserPassword");
		String invalidEmail=testdata.get("invalidEmail");
		String firstname_CID=testdata.get("firstname_CID");
		String lastname_CID=testdata.get("lastname_CID");
		String Address_CID=testdata.get("address_CID");
		String Zipcode_CID=testdata.get("zipcode_CID");
		String MAC_CID=testdata.get("mac_CID");
		WebElement checkbx = driver.findElement(By.xpath("/html/body/div[1]/section/div/section/div[2]/div/div/div[2]/div[1]/form/div/div[2]/div/div[6]/label"));
		checkbx.click();
		String security_question=testdata.get("security_question");
		String security_answer=testdata.get("security_answer");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.InvalidEmail_CID(firstname_CID,charterID,password,invalidEmail,lastname_CID,Address_CID,Zipcode_CID,MAC_CID,security_question,security_answer), "In-line error message for Email field is not displayed in create id flow -Failed");
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException{
		Thread.sleep(2000);
		driver.manage().deleteAllCookies();
		driver.close();
	}


}
