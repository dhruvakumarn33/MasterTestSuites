package com.charter.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.charter.page.AuthenticationPage;
import com.charter.page.HomePage;
import com.charter.page.MyAccountPage;
import com.charter.page.OverviewPage;
import com.charter.page.VoiceServicesPage;
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
		
		AuthenticationPage auth=new AuthenticationPage(driver);
		auth.getAccountDetails(ACnumber);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		
		Assert.assertTrue(auth.FID_RetrieveID_HOH(password,security_answer,lastname_fID,address_fID,zipcode_fID,mac_fID, fLinkCID,AccountNumberVerify,ACnumber), "HOH user is not able to retrieve the forgotten username");
		hp.logoutApplication();	
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

	/*//Name: TA24_Validate_ForgotUsernamePage_HelpLink_NavigateTo_SupportArticlePage()
	//Description: Validate whether the user is able to navigate to the support article page on clicking Help link to find Charter ID link in Forgot Charter ID Flow
	//Scripter:Ayesha
	//Date/Version:
	@Test
	public void TA24_Validate_ForgotUsernamePage_HelpLink_NavigateTo_SupportArticlePage() throws Exception{
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.fID_Supportpage(),"User is -Not able to Navigate to Support Article page");
	}*/

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
	//Description: Validate whether the user is displayed with an error message when user enters invalid security answer in Forgot Charter ID flow
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
	
	//Name: TA56_Validate_ForgotUsername_3C_InlineErrorMessage()
	//Description:Validate whether the user is able to view in-line warning message when no data is provided in Forgot username 3C
	//Scripter:Dhruva
	//Date/Version:03-Sep-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA56_Validate_ForgotUsername_3C_InlineErrorMessage(Map<String,String> testdata) throws Exception{

		String AccountNumberVerify = testdata.get("AccountNumberVerify");
		String ACnumber=testdata.get("ACnumber");
		String zipcode_fID=testdata.get("zipcode_fID");
		String fLinked_CharterID=testdata.get("fLinked_CharterID");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.dontRememberAns(AccountNumberVerify,ACnumber,zipcode_fID,fLinked_CharterID), "In-line warning message is not displayed when no data is provided in Forgot username 3C");
	}
	
	//Name: TA57_Validate_ForgotUsername_ConflictingEmail()
	//Description:To verify whether the user is getting error message for conflictions in first step while retriving Username
	//Scripter:Dhruva
	//Date/Version:03-Sep-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA57_Validate_ForgotUsername_ConflictingEmail(Map<String,String> testdata) throws Exception{

		String AccountNumberVerify = testdata.get("AccountNumberVerify");
		String email=testdata.get("email");
		String zipcode_fID=testdata.get("zipcode_fID");
		String ACnumber=testdata.get("ACnumber");
		
		AuthenticationPage auth=new AuthenticationPage(driver);
		//auth.getAccountDetails(ACnumber);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);

		Assert.assertTrue(auth.conflictEmail(AccountNumberVerify,email,zipcode_fID), "In-line warning message is not displayed for conflicts in first step while retrieving Username");
	}
	
	//Name: TA58_Validate_ForgotUsername_ConflictingPhone()
	//Description:To verify whether the user is getting error message for conflictions in first step while retriving Username
	//Scripter:Dhruva
	//Date/Version:03-Sep-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA58_Validate_ForgotUsername_ConflictingPhone(Map<String,String> testdata) throws Exception{

		String AccountNumberVerify = testdata.get("AccountNumberVerify");
		String mobile=testdata.get("Mobilephone");
		String zipcode_fID=testdata.get("zipcode_fID");
		String lastname_fID=testdata.get("lastname_fID");

		String ACnumber=testdata.get("ACnumber");
		HomePage hp=new HomePage(driver);
		AuthenticationPage auth=new AuthenticationPage(driver);
		//auth.getAccountDetails(ACnumber);
		hp.loadCharterPage(URL);

		Assert.assertTrue(auth.conflictPhone(AccountNumberVerify,mobile,zipcode_fID,lastname_fID), "In-line warning message is not displayed for conflicts in first step while retrieving Username");
	}
	
	//Name: TA60_Validate_ForgotUsername_UsingEmail()
	//Description: Validate the forgot username condition to retrieve username using email 
	//Standard user
	//Scripter:Dhruva
	//Date/Version:23-Jul-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA60_Validate_ForgotUsername_UsingEmail(Map<String,String> testdata) throws Exception {

		String security_answer=testdata.get("security_answer");
		String zipcode_fID=testdata.get("zipcode_fID");
		String fLinkCID=testdata.get("fLinked_CharterID"); //Specify unique first two letter for user ID
		fLinkCID = fLinkCID.substring(0, 2);
		String AccountNumberVerify=testdata.get("AccountNumberVerify");
		String ACnumber=testdata.get("ACnumber");
		String email= testdata.get("email");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.fid_successfultqmessage(security_answer,zipcode_fID,fLinkCID,AccountNumberVerify,email),"Successful message is not displayed in Forgot Username flow");
	}
	
	//Name: TA65_Validate_ForgotUsername_UsingEmail_confirmationMail()
	//Description: Validate whether user is able to receive confirmation mail to retrieve username using email 
	//Standard user
	//Scripter:Dhruva
	//Date/Version:08-Sep-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA65_Validate_ForgotUsername_UsingEmail_confirmationMail(Map<String,String> testdata) throws Exception {

		String zipcode_fID=testdata.get("zipcode_fID");
		String fLinkCID=testdata.get("fLinked_CharterID"); //Specify unique first two letter for user ID
		fLinkCID = fLinkCID.substring(0, 2);
		String AccountNumberVerify=testdata.get("AccountNumberVerify");
		String ACnumber=testdata.get("ACnumber");
		String GmailID=testdata.get("GmailID");
		String Gmailpw=testdata.get("Gmailpw");
		String username=testdata.get("UserID");
		String password=testdata.get("UserPassword");
		String chartermailID = ReadFromExcel.getData("Auth","chartermailID");
		String chartermailPwd = ReadFromExcel.getData("Auth","chartermailPwd");
		String email=testdata.get("email");
		
		AuthenticationPage auth=new AuthenticationPage(driver);
		//auth.getAccountDetails(ACnumber);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		
		auth.fid_email(zipcode_fID,fLinkCID,AccountNumberVerify,ACnumber,email);
		auth.charterDotComMailLogin(chartermailID, chartermailPwd);
		Assert.assertTrue(auth.retrieveUsernameCharterMail(),"Confirmation Mail is not received to retrieve User ID");
		hp.loadCharterPage(URL);
		hp.login(username, password);
		hp.logoutApplication();
	}
	
	//Name: TA70_Validate_ForgotUsername_CPNINonVoiceUser_UsingEmail_confirmationMail()
	//Description: Verification of no CPNI Email generation by Getting verification code through Email of Forgot Username flow 
	//Standard user
	//Scripter:Dhruva
	//Date/Version:21-Oct-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA70_Validate_ForgotUsername_CPNINonVoiceUser_UsingEmail_confirmationMail(Map<String,String> testdata) throws Exception {

		String zipcode_fID=testdata.get("zipcode_fID");
		String fLinkCID=testdata.get("fLinked_CharterID"); //Specify unique first two letter for user ID
		int start = fLinkCID.length()-3;
		int end = fLinkCID.length()-1;
		fLinkCID = fLinkCID.substring(start, end);
		String AccountNumberVerify=testdata.get("AccountNumberVerify");
		String ACnumber=testdata.get("ACnumber");
		String GmailID=testdata.get("GmailID");
		String Gmailpw=testdata.get("Gmailpw");
		String username=testdata.get("UserID");
		String password=testdata.get("UserPassword");
		String mac_fID=testdata.get("mac_fID");
		String chartermailID = ReadFromExcel.getData("Auth","chartermailID");
		String chartermailPwd = ReadFromExcel.getData("Auth","chartermailPwd");
		String email=testdata.get("email");
		
		AuthenticationPage auth=new AuthenticationPage(driver);
		//auth.getAccountDetails(ACnumber);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);

		auth.fid_email(zipcode_fID,fLinkCID,AccountNumberVerify,ACnumber,email);
		auth.charterDotComMailLogin(chartermailID, chartermailPwd);
		Assert.assertTrue(auth.retrieveUsernameCharterMail(),"Confirmation Mail is not received to retrieve User ID");

		hp.loadCharterPage(URL);
		hp.login(username, password);
		OverviewPage OvPage = new OverviewPage(driver);
		MyAccountPage MAPage= new MyAccountPage(driver);
		MAPage.loadBillingAndTransactionSection();
		OvPage.upcomingPaymentsLink();
		VoiceServicesPage vsp= new VoiceServicesPage(driver);
		Assert.assertTrue(vsp.CPNIRoadBlock(mac_fID),"CPNI Road Block is not Displayed");
	}

	//Name: TA71_Validate_ForgotUsername_CPNIVoiceUser_UsingEmail_confirmationMail()
	//Description: Verification of no CPNI Email generation by Getting verification code through Email of Forgot Username flow 
	//Standard user
	//Scripter:Dhruva
	//Date/Version:21-Oct-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA71_Validate_ForgotUsername_CPNIVoiceUser_UsingEmail_confirmationMail(Map<String,String> testdata) throws Exception {

		String zipcode_fID=testdata.get("zipcode_fID");
		String fLinkCID=testdata.get("fLinked_CharterID");
		int start = fLinkCID.length()-3;
		int end = fLinkCID.length()-1;//Specify unique first two letter for user ID
		fLinkCID = fLinkCID.substring(start, end);
		String AccountNumberVerify=testdata.get("AccountNumberVerify");
		String ACnumber=testdata.get("ACnumber");
		String GmailID=testdata.get("GmailID");
		String Gmailpw=testdata.get("Gmailpw");
		String username=testdata.get("UserID");
		String password=testdata.get("UserPassword");
		String mac_fID=testdata.get("mac_fID");
		String chartermailID = ReadFromExcel.getData("Auth","chartermailID");
		String chartermailPwd = ReadFromExcel.getData("Auth","chartermailPwd");
		String email=testdata.get("email");
		
		AuthenticationPage auth=new AuthenticationPage(driver);
		//auth.getAccountDetails(ACnumber);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);

		auth.fid_email(zipcode_fID,fLinkCID,AccountNumberVerify,ACnumber,email);
		auth.charterDotComMailLogin(chartermailID, chartermailPwd);
		Assert.assertTrue(auth.retrieveUsernameCharterMail(),"Confirmation Mail is not received to retrieve User ID");
		//auth.recoverUID();
		hp.loadCharterPage(URL);
		hp.login(username, password);
		OverviewPage OvPage = new OverviewPage(driver);
		MyAccountPage MAPage= new MyAccountPage(driver);
		MAPage.loadBillingAndTransactionSection();
		OvPage.upcomingPaymentsLink();
		VoiceServicesPage vsp= new VoiceServicesPage(driver);
		Assert.assertTrue(vsp.CPNIRoadBlock(mac_fID),"CPNI Road Block is not Displayed");
	}
	
	//Name: TA72_Validate_ForgotUsername_CPNIVoiceUser_SecurityQandA_confirmationMail()
	//Description: Verification of CPNI Email Generation_reset security question through forgot username flow
	//Scripter:Dhruva
	//Date/Version: 27-Oct-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA72_Validate_ForgotUsername_CPNIVoiceUser_SecurityQandA_confirmationMail(Map<String,String> testdata) throws Exception{

		String security_answer=testdata.get("security_answer");
		String zipcode_fID=testdata.get("zipcode_fID");
		String fLinkCID=testdata.get("fLinked_CharterID"); //Specify unique first two letter for user ID
		fLinkCID = fLinkCID.substring(0, 2);
		String AccountNumberVerify=testdata.get("AccountNumberVerify");
		String ACnumber=testdata.get("ACnumber");
		String mac_fID=testdata.get("mac_fID");
		String username=testdata.get("UserID");
		String password=testdata.get("UserPassword");

		AuthenticationPage auth=new AuthenticationPage(driver);
		//auth.getAccountDetails(ACnumber);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);

		Assert.assertTrue(auth.fid_successfultqmessage(security_answer,zipcode_fID,fLinkCID,AccountNumberVerify,ACnumber),"Successful message is not displayed in Forgot Username flow");
		hp.loadCharterPage(URL);
		hp.login(username, password);
		OverviewPage OvPage = new OverviewPage(driver);
		MyAccountPage MAPage= new MyAccountPage(driver);
		MAPage.loadBillingAndTransactionSection();
		OvPage.upcomingPaymentsLink();
		VoiceServicesPage vsp= new VoiceServicesPage(driver);
		Assert.assertTrue(vsp.CPNIRoadBlock(mac_fID),"CPNI Road Block is not Displayed");
	}
	
	//Name: TA73_Validate_ForgotUsername_CPNINonVoiceUser_SecurityQandA_confirmationMail()
	//Description: Verification of CPNI Email Generation_reset security question through forgot username flow
	//Scripter:Dhruva
	//Date/Version: 27-Oct-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA73_Validate_ForgotUsername_CPNINonVoiceUser_SecurityQandA_confirmationMail(Map<String,String> testdata) throws Exception{

		String security_answer=testdata.get("security_answer");
		String zipcode_fID=testdata.get("zipcode_fID");
		String fLinkCID=testdata.get("fLinked_CharterID");
		int start = fLinkCID.length()-3;
		int end = fLinkCID.length()-1;//Specify unique first two letter for user ID
		fLinkCID = fLinkCID.substring(start, end);
		String AccountNumberVerify=testdata.get("AccountNumberVerify");
		String ACnumber=testdata.get("ACnumber");
		String mac_fID=testdata.get("mac_fID");
		String username=testdata.get("UserID");
		String password=testdata.get("UserPassword");

		AuthenticationPage auth=new AuthenticationPage(driver);
		//auth.getAccountDetails(ACnumber);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);

		Assert.assertTrue(auth.fid_successfultqmessage(security_answer,zipcode_fID,fLinkCID,AccountNumberVerify,ACnumber),"Successful message is not displayed in Forgot Username flow");
		hp.loadCharterPage(URL);
		hp.login(username, password);
		OverviewPage OvPage = new OverviewPage(driver);
		MyAccountPage MAPage= new MyAccountPage(driver);
		MAPage.loadBillingAndTransactionSection();
		OvPage.upcomingPaymentsLink();
		VoiceServicesPage vsp= new VoiceServicesPage(driver);
		Assert.assertTrue(vsp.CPNIRoadBlock(mac_fID),"CPNI Road Block is not Displayed");
	}
	
	//Name: TA74_Validate_ForgotUsername_NonCPNIUser_SecurityQandA_confirmationMail()
	//Description: Verification of Non CPNI Email Generation_reset security question through forgot username flow
	//Scripter:Dhruva
	//Date/Version: 06-Nov-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA74_Validate_ForgotUsername_NonCPNIUser_SecurityQandA_confirmationMail(Map<String,String> testdata) throws Exception{

		String security_answer=testdata.get("security_answer");
		String zipcode_fID=testdata.get("zipcode_fID");
		String fLinkCID=testdata.get("fLinked_CharterID");
		int start = fLinkCID.length()-2;
		int end = fLinkCID.length()-1;//Specify unique first two letter for user ID
		fLinkCID = fLinkCID.substring(start, end);
		String AccountNumberVerify=testdata.get("AccountNumberVerify");
		String ACnumber=testdata.get("ACnumber");
		String mac_fID=testdata.get("mac_fID");
		String username=testdata.get("UserID");
		String password=testdata.get("UserPassword");

		AuthenticationPage auth=new AuthenticationPage(driver);
		//auth.getAccountDetails(ACnumber);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);

		Assert.assertTrue(auth.fid_successfultqmessage(security_answer,zipcode_fID,fLinkCID,AccountNumberVerify,ACnumber),"Successful message is not displayed in Forgot Username flow");
		hp.loadCharterPage(URL);
		hp.login(username, password);
		OverviewPage OvPage = new OverviewPage(driver);
		MyAccountPage MAPage= new MyAccountPage(driver);
		MAPage.loadBillingAndTransactionSection();
		OvPage.upcomingPaymentsLink();
		VoiceServicesPage vsp= new VoiceServicesPage(driver);
		Assert.assertTrue(vsp.CPNIRoadBlock(mac_fID),"CPNI Road Block is not Displayed");
	}
	
	//Name: TA75_Validate_ForgotUsername_UsingMobileNumber()
	//Description: Validate the forgot username condition to retrieve username using Mobile Number 
	//Standard user
	//Scripter:Dhruva
	//Date/Version:06-Nov-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA75_Validate_ForgotUsername_UsingMobileNumber(Map<String,String> testdata) throws Exception {

		String security_answer=testdata.get("security_answer");
		String zipcode_fID=testdata.get("zipcode_fID");
		String fLinkCID=testdata.get("fLinked_CharterID"); //Specify unique first two letter for user ID
		int start = fLinkCID.length()-2;
		int end = fLinkCID.length()-1;//Specify unique first two letter for user ID
		fLinkCID = fLinkCID.substring(start, end);
		String AccountNumberVerify=testdata.get("AccountNumberVerify");
		String Mobilephone=testdata.get("Mobilephone");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.fid_successfultqmessage(security_answer,zipcode_fID,fLinkCID,AccountNumberVerify,Mobilephone),"Successful message is not displayed in Forgot Username flow");
	}
	
	//Name: TA76_Validate_ForgotUsername_UsingPrimaryPhoneNumber()
	//Description: Validate the forgot username condition to retrieve username using Primary Phone Number 
	//Standard user
	//Scripter:Dhruva
	//Date/Version:06-Nov-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA76_Validate_ForgotUsername_UsingPrimaryPhoneNumber(Map<String,String> testdata) throws Exception {

		String security_answer=testdata.get("security_answer");
		String zipcode_fID=testdata.get("zipcode_fID");
		String fLinkCID=testdata.get("fLinked_CharterID"); //Specify unique first two letter for user ID
		int start = fLinkCID.length()-2;
		int end = fLinkCID.length()-1;//Specify unique first two letter for user ID
		fLinkCID = fLinkCID.substring(start, end);
		String AccountNumberVerify=testdata.get("AccountNumberVerify");
		String Mobilephone=testdata.get("Mobilephone");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.fid_successfultqmessage(security_answer,zipcode_fID,fLinkCID,AccountNumberVerify,Mobilephone),"Successful message is not displayed in Forgot Username flow");
	}
	
	@AfterMethod
	public void afterMethod() throws InterruptedException{
		Thread.sleep(2000);
		driver.manage().deleteAllCookies();
		driver.close();
	}

}
