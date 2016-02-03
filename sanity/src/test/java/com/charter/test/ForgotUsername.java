package com.charter.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.charter.page.AuthenticationPage;
import com.charter.page.HomePage;
import com.charter.utils.Constants;
import com.charter.utils.DataProviderClass;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.TestNGBase;

public class ForgotUsername extends TestNGBase{
	private String URL= Constants.URL;

	//Name: TA20_Validate_RetrievingChaterID_HOHuser()
	//Description: Validate whether the HOH user is able to retrieve the charter ID from Forget Charter ID flow
	//HOH User
	//Scripter:Ayesha
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA20_Validate_RetrievingChaterID_HOHuser(Map<String,String> testdata) throws Exception{
		String password = testdata.get("UserPassword");
		String security_answer=testdata.get("security_answer");
		String lastname_fID=testdata.get("lastname_fID");
		String address_fID=testdata.get("address_fID");
		String zipcode_fID=testdata.get("zipcode_fID");
		String mac_fID=testdata.get("mac_fID");
		String AccountNumberVerify=testdata.get("AccountNumberVerify");
		String ACnumber=testdata.get("ACnumber");
		String fLinkCID=testdata.get("fLinked_CharterID"); //Specify unique first two letter for user ID
		fLinkCID = fLinkCID.substring(0, 2);
		System.out.println(fLinkCID);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.FID_RetrieveID_HOH(password,security_answer,lastname_fID,address_fID,zipcode_fID,mac_fID, fLinkCID,AccountNumberVerify,ACnumber), "HOH user is not able to retrieve the forgotten username");

	}

	//Name: TA21_Validate_RetrievingChaterID_AdminUser()
	//Description: Validate whether the Admin user is able to retrieve the Charter ID from Forget Charter ID flow.
	//Admin User
	//Scripter:Ayesha
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA21_Validate_RetrievingChaterID_AdminUser(Map<String,String> testdata) throws Exception{

		String password = testdata.get("UserPassword");
		String security_answer=testdata.get("security_answer");
		String lastname_fID=testdata.get("lastname_fID");
		String address_fID=testdata.get("address_fID");
		String zipcode_fID=testdata.get("zipcode_fID");
		String mac_fID=testdata.get("mac_fID");
		String fLinkCID=testdata.get("fLinked_CharterID"); //Specify unique first two letter for user ID
		String AccountNumberVerify=testdata.get("AccountNumberVerify");
		String ACnumber=testdata.get("ACnumber");
		fLinkCID = fLinkCID.substring(0, 2);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.FID_RetrieveID_Admin(password,security_answer,lastname_fID,address_fID,zipcode_fID,mac_fID, fLinkCID,AccountNumberVerify,ACnumber), "Admin user is not able to retrieve the forgotten username");
	}

	//Name: TA22_Validate_RetrievingChaterID_StandardUser()
	//Description: Validate whether the Standard user is able to retrieve the Charter ID from Forget Charter ID flow.
	//Standard User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA22_Validate_RetrievingChaterID_StandardUser(Map<String,String> testdata) throws Exception{
		String password = testdata.get("UserPassword");
		String security_answer=testdata.get("security_answer");
		String lastname_fID=testdata.get("lastname_fID");
		String address_fID=testdata.get("address_fID");
		String zipcode_fID=testdata.get("zipcode_fID");
		String mac_fID=testdata.get("mac_fID");
		String AccountNumberVerify=testdata.get("AccountNumberVerify");
		String ACnumber=testdata.get("ACnumber");
		String fLinkCID=testdata.get("fLinked_CharterID"); //Specify unique first two letter for user ID
		fLinkCID = fLinkCID.substring(0, 2);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.FID_RetrieveID_Standard(password,security_answer,lastname_fID,address_fID,zipcode_fID,mac_fID, fLinkCID,AccountNumberVerify,ACnumber),"Standard user is not able to retrieve the forgotten username");

	}

	//Name: TA24_Validate_ForgotUsernamePage_HelpLink_NavigateTo_SupportArticlePage()
	//Description: Validate whether the user is able to navigate to the support article page on clicking Help link to find Charter ID link in Forgot Charter ID Flow
	//Scripter:Ayesha
	//Date/Version:
	@Test
	public void TA24_Validate_ForgotUsernamePage_HelpLink_NavigateTo_SupportArticlePage() throws Exception{
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.fID_Supportpage(),"User is -Not able to Navigate to Support Article page");
	}

	//Name: TA25_Validate_ForgotUsernamePage_GetChaterIDLink_NavigateTo_ForgotChaterIDPage()
	//Description: Validate whether the user is able to navigate to Create account page on clicking business customers Get Charter ID link in Forgot Charter ID Flow
	//Scripter:Ayesha
	//Date/Version:
	@Test
	public void TA25_Validate_ForgotUsernamePage_GetChaterIDLink_NavigateTo_ForgotChaterIDPage() throws Exception{
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.fID_CommPage(),"User is not able to Navigate to Create Account page with business customer link in Forgot Username flow");
	}

	//Name: TA28_Validate_ForgotUsernamePage_SuccessfulThankYouMessage()
	//Description: Validate successful message as Thank you. The username associated to the account
	//Scripter:Ramana
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA28_Validate_ForgotUsernamePage_SuccessfulThankYouMessage(Map<String,String> testdata) throws Exception{

		String security_answer=testdata.get("security_answer");
		String zipcode_fID=testdata.get("zipcode_fID");
		String fLinkCID=testdata.get("fLinked_CharterID"); //Specify unique first two letter for user ID
		fLinkCID = fLinkCID.substring(0, 2);
		String AccountNumberVerify=testdata.get("AccountNumberVerify");
		String ACnumber=testdata.get("ACnumber");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.fid_successfultqmessage(security_answer,zipcode_fID,fLinkCID,AccountNumberVerify,ACnumber),"Successful message is not displayed in Forgot Username flow");
	}
	//Name: TA29_Validate_ForgotUserName_InvalidZipCodeMessage()
	//Description: Validate whether the user is able to view in-line warning message is getting displayed when invalid Zipcode is entered in Forgot Charter ID flow
	//Scripter:Rana
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA29_Validate_ForgotUserName_InvalidZipCodeMessage(Map<String,String> testdata) throws Exception{

		String invalidZipcode=testdata.get("invalidZipcode");
		String AccountNumberVerify=testdata.get("AccountNumberVerify");
		String ACnumber=testdata.get("ACnumber");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.ZipCode_ErrorMsg(invalidZipcode,AccountNumberVerify,ACnumber),"In-line warning message is not displayed for invalid length of zipcode in Fogot Username flow");
	}

	//Name: TA31_Validate_ForgotUserName_InvalidSecurityAnswerMessage()
	//Description: Validate whether the user is dispalyed with an error message when user enters invalid security answer in Forgot Charter ID flow
	//Scripter:Rana
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA31_Validate_ForgotUserName_InvalidSecurityAnswerMessage(Map<String,String> testdata) throws Exception{

		String invalidSecurityAns=testdata.get("invalidSecurityAns");
		String zipcode_fID=testdata.get("zipcode_fID");
		String AccountNumberVerify=testdata.get("AccountNumberVerify");
		String ACnumber=testdata.get("ACnumber");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		auth.SecAns_ErrorMsg(zipcode_fID,AccountNumberVerify,ACnumber,invalidSecurityAns);
	}
	//Name: TA34_Validate_ForgotUserName_NoDataEntry_Message()
	//Description: Validate error message if user didn't entered any data in any of the fields
	//Scripter:Ayesha
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA34_Validate_ForgotUserName_NoDataEntry_Message(Map<String,String> testdata) throws Exception{

		String zipcode_fID=testdata.get("zipcode_fID");
		String AccountNumberVerify=testdata.get("AccountNumberVerify");
		String ACnumber=testdata.get("ACnumber");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.fId_missedfieldsmessages(zipcode_fID,AccountNumberVerify,ACnumber), "Error Message is not displayed when invalid data is entered in the fields");
	}

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA50_Validate_ForgotUsername_Non_Converted_MS_Login(Map<String,String> testdata) throws Exception{

		String password = testdata.get("UserPassword");
		String security_answer=testdata.get("security_answer");
		String lastname_fID=testdata.get("lastname_fID");
		String address_fID=testdata.get("address_fID");
		String zipcode_fID=testdata.get("zipcode_fID");
		String mac_fID=testdata.get("mac_fID");
		String fLinkCID=testdata.get("fLinked_CharterID"); //Specify unique first two letter for user ID
		String AccountNumberVerify=testdata.get("AccountNumberVerify");
		String ACnumber=testdata.get("ACnumber");
		fLinkCID = fLinkCID.substring(0, 2);
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.FID_Non_Converted_MS_Login(password,security_answer,lastname_fID,address_fID,zipcode_fID,mac_fID, fLinkCID,AccountNumberVerify,ACnumber), "Admin user is not able to retrieve the forgotten username");
	}

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA51_Validate_ForgotUsername_Non_Converted_HOH(Map<String,String> testdata) throws Exception{

		String password = testdata.get("UserPassword");
		String security_answer=testdata.get("security_answer");
		String lastname_fID=testdata.get("lastname_fID");
		String address_fID=testdata.get("address_fID");
		String zipcode_fID=testdata.get("zipcode_fID");
		String mac_fID=testdata.get("mac_fID");
		String fLinkCID=testdata.get("fLinked_CharterID"); //Specify unique first two letter for user ID
		String AccountNumberVerify=testdata.get("AccountNumberVerify");
		String ACnumber=testdata.get("ACnumber");
		fLinkCID = fLinkCID.substring(0, 2);
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.FID_Non_Converted_HOH(password,security_answer,lastname_fID,address_fID,zipcode_fID,mac_fID, fLinkCID,AccountNumberVerify,ACnumber), "Admin user is not able to retrieve the forgotten username");
		
	}
	
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA051_Validate_ForgotUsername_Non_Converted_CharterID(Map<String,String> testdata) throws Exception{

		String password = testdata.get("UserPassword");
		String security_answer=testdata.get("security_answer");
		String lastname_fID=testdata.get("lastname_fID");
		String address_fID=testdata.get("address_fID");
		String zipcode_fID=testdata.get("zipcode_fID");
		String mac_fID=testdata.get("mac_fID");
		String fLinkCID=testdata.get("fLinked_CharterID"); //Specify unique first two letter for user ID
		String AccountNumberVerify=testdata.get("AccountNumberVerify");
		String ACnumber=testdata.get("ACnumber");
		fLinkCID = fLinkCID.substring(0, 2);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.FID_Non_Converted_CharterID(password,security_answer,lastname_fID,address_fID,zipcode_fID,mac_fID, fLinkCID,AccountNumberVerify,ACnumber), "Admin user is not able to retrieve the forgotten username");
		
	}
	
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA052_Validate_ForgotUsername_ValidateEmail(Map<String,String> testdata) throws Exception{
		String password = testdata.get("UserPassword");
		String security_answer=testdata.get("security_answer");
		String lastname_fID=testdata.get("lastname_fID");
		String address_fID=testdata.get("address_fID");
		String zipcode_fID=testdata.get("zipcode_fID");
		String mac_fID=testdata.get("mac_fID");
		String AccountNumberVerify=testdata.get("AccountNumberVerify");
		String ACnumber=testdata.get("ACnumber");
		String fLinkCID=testdata.get("fLinked_CharterID"); //Specify unique first two letter for user ID
		fLinkCID = fLinkCID.substring(0, 2);
		System.out.println(fLinkCID);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.FID_FU_ValidateEmail(password,security_answer,lastname_fID,address_fID,zipcode_fID,mac_fID, fLinkCID,AccountNumberVerify,ACnumber), "HOH user is not able to retrieve the forgotten username");

	}
	

	@AfterMethod
	public void afterMethod() throws InterruptedException{
		Thread.sleep(2000);
		driver.manage().deleteAllCookies();
		driver.close();
	}

}
