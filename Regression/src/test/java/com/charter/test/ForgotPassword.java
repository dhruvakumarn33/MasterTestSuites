package com.charter.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.charter.page.AuthenticationPage;
import com.charter.page.HomePage;
import com.charter.page.MyAccountPage;
import com.charter.page.UserPreferencePage;
import com.charter.utils.Constants;
import com.charter.utils.DataProviderClass;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.TestNGBase;

public class ForgotPassword extends TestNGBase{
	private String URL= Constants.URL;

	//Name: TA35_Validate_RetrievingPassword_HOHuser()
	//Description: Validate whether the HOH user is able to retrieve the password from Forgot Password Flow
	//HOH User
	//Scripter:Dhruva
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA35_Validate_RetrievingPassword_HOHuser(Map<String,String> testdata) throws Exception{

		String password = testdata.get("UserPassword");
		String CharterID_fp = testdata.get("CharterID_fp");
		String Zipcode_fp=testdata.get("Zipcode_fp");
		String security_answer=testdata.get("security_answer");
		String ACnumber=testdata.get("ACnumber");

		HomePage hp=new HomePage(driver);
		AuthenticationPage auth=new AuthenticationPage(driver);
		//auth.getAccountDetails(ACnumber);
		hp.loadCharterPage(URL);
		Assert.assertTrue(auth.fp_ValidE2E_HOH(password,CharterID_fp,Zipcode_fp,security_answer), "HOH user is not able to retrieve forgotten password");
		hp.logoutApplication();
	}

	//Name: TA37_Validate_RetrievingPassword_AdminUser()
	//Description: Validate whether the Admin user is able to retrieve the password from Forgot Password Flow
	//Admin User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA37_Validate_RetrievingPassword_AdminUser(Map<String,String> testdata) throws Exception{

		String password = testdata.get("UserPassword");
		String CharterID_fp = testdata.get("CharterID_fp");
		String Zipcode_fp=testdata.get("Zipcode_fp");
		String security_answer=testdata.get("security_answer");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.fp_ValidE2E_Admin(password,CharterID_fp,Zipcode_fp,security_answer), "Admin user is not able to retrieve forgotten password");
	}

	//Name: TA38_Validate_RetrievingPassword_StandardUser()
	//Description: Validate whether the Standard user is able to retrieve the password from Forgot Password Flow
	//Standard User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA38_Validate_RetrievingPassword_StandardUser(Map<String,String> testdata) throws Exception{
		String password = testdata.get("UserPassword");
		String CharterID_fp = testdata.get("CharterID_fp");
		String Zipcode_fp=testdata.get("Zipcode_fp");
		String security_answer=testdata.get("security_answer");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.fp_ValidE2E_Standard(password,CharterID_fp,Zipcode_fp,security_answer), "Standard user is not able to retrieve forgotten password");
	}

	//Name: TA39_Validate_ForgotPasswordPage_HelpLink_NavigateTo_SupportArticlePage()
	//Description: Validate whether the user is able to navigate to the support article page on clicking Help link to find Charter ID link in Forgot Password Flow
	//Scripter:Lakshmi
	//Date/Version:
	@Test
	public void TA39_Validate_ForgotPasswordPage_HelpLink_NavigateTo_SupportArticlePage() throws Exception{
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.fp_supportPage(), "User is not able to Navigate to Support article page");
	}
	//Name: TA40_Validate_ForgotPasswordPage_GetChaterIDLink_NavigateTo_ForgotPasswordPage()
	//Description: Validate whether the user is able to navigate to Create account page on clicking business customers Get Charter ID link in Forgot Password Flow
	//Scripter:Lakshmi
	//Date/Version:
	@Test
	public void TA40_Validate_ForgotPasswordPage_GetChaterIDLink_NavigateTo_ForgotPasswordPage() throws Exception{
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.fp_CCommPage(), "User is not able to Navigate to Create Account page with business customer link in Forgot password flow");
	}

	//Name: TA43_Validate_ForgotUsernamePage_ConfirmPassword_Message()
	//Description:Validate Confirm password and successful message after password has been reset
	//Scripter:Ramana
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA43_Validate_ForgotPasswordPage_ConfirmPassword_Message(Map<String,String> testdata) throws Exception{

		String password = testdata.get("UserPassword");
		String CharterID_fp = testdata.get("CharterID_fp");
		String lastname_fp=testdata.get("lastname_fp");
		String Zipcode_fp=testdata.get("Zipcode_fp");
		String security_answer=testdata.get("security_answer");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.fp_pwdresetsuccess(password,CharterID_fp,lastname_fp,Zipcode_fp,security_answer), "Successful message is not displayed after resetting the password in Forgot password flow");
	}

	//Name: TA44_Validate_ForgotPassword_InvalidZipCodeMessage()
	//Description:Validate whether the user is able to view in-line warning message is getting displayed when invalid length of Zipcode is entered in Forgot Password flow
	//Scripter:Ramana
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA44_Validate_ForgotPassword_InvalidZipCodeMessage(Map<String,String> testdata) throws Exception{

		String CharterID_fp = testdata.get("CharterID_fp");
		String invalidZipcode=testdata.get("invalidZipcode");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.fp_invalidzipcode(CharterID_fp,invalidZipcode), "In-line warning message is not displayed for invalid length of zipcode in Forgot password flow");
	}

	//Name: TA45_Validate_ForgotPassword_InvalidSecurityCodeMessage()
	//Description: Validate whether the user is dispalyed with an error message when user enters invalid security answer in Forgot Password flow
	//Scripter:Ramana
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA45_Validate_ForgotPassword_InvalidSecurityCodeMessage(Map<String,String> testdata) throws Exception{

		String CharterID_fp = testdata.get("CharterID_fp");
		String lastname_fp=testdata.get("lastname_fp");
		String Zipcode_fp=testdata.get("Zipcode_fp");
		String invalidSecurityAns=testdata.get("invalidSecurityAns");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.fp_invalidsecuritycode(CharterID_fp,lastname_fp,Zipcode_fp,invalidSecurityAns), "");
	}
	//Name: TA46_Validate_ForgotPassword_PasswordMismatchMessage()
	//Description:Validate whether the user is able to view in-line warning message when mismatch of password in Forgot Password flow
	//Scripter:Ramana
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA46_Validate_ForgotPassword_PasswordMismatchMessage(Map<String,String> testdata) throws Exception{

		String password = testdata.get("UserPassword");
		String invalidPassword=testdata.get("invalidPassword");
		String CharterID_fp = testdata.get("CharterID_fp");
		String lastname_fp=testdata.get("lastname_fp");
		String Zipcode_fp=testdata.get("Zipcode_fp");
		String security_answer=testdata.get("security_answer");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.fp_pwdmismatch(password,CharterID_fp,lastname_fp,Zipcode_fp,security_answer,invalidPassword), "In-line warning message is not displayed for mismatch of password in Forgot password flow");

	}

	//Name: TA47_Validate_ForgotPassword_NoDataEntry_Message()
	//Description:Validate error message if user didn't entered any data in any of the fields
	//Scripter:Ramana
	//Date/Version:
	@Test
	public void TA47_Validate_ForgotPassword_NoDataEntry_Message() throws Exception{
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.fp_missedfieldsmessages(), "Error Messages are not displayed when data is not entered in fields of forgot password first page");
	}
	
    @Test
	public void TA52_Validate_ForgotPassword_Non_Converted_MS_Login() throws Exception{
    
    	HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		auth.fp_ValidE2E_NonconvertedMSLogin();
    }
    
    @Test
   	public void TA53_Validate_ForgotPassword_Non_Converted_CharterID() throws Exception{
       
       	HomePage hp=new HomePage(driver);
   		hp.loadCharterPage(URL);
   		AuthenticationPage auth=new AuthenticationPage(driver);
   		auth.fp_ValidE2E_NonconvertedCharterID();
       }
    
    @Test
   	public void TA54_Validate_ForgotPassword_Converted_CharterID() throws Exception{
       
       	HomePage hp=new HomePage(driver);
   		hp.loadCharterPage(URL);
   		AuthenticationPage auth=new AuthenticationPage(driver);
   		auth.fp_ValidE2E_convertedCharterID();
       }

	//Name: TA55_Validate_ForgotPassword_InvalidCharterIDMessage()
	//Description:Validate whether the user is able to view in-line warning message when invalid Charter ID is entered in Forgot Password flow
	//Scripter:Dhruva
	//Date/Version:27-Aug-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA55_Validate_ForgotPassword_InvalidCharterIDMessage(Map<String,String> testdata) throws Exception{

		String CharterID_fp = testdata.get("CharterID_fp");
		String invalidZipcode=testdata.get("invalidZipcode");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.fp_invalidzipcode(CharterID_fp,invalidZipcode), "In-line warning message is not displayed for invalid length of zipcode in Forgot password flow");
	}
	
	//Name: TA59_Validate_ForgotPassword_DontRemember_SecurityAnswer_Email()
	//Description: Validate the forgot password condition when user doesn't remember security answer using email address
	//Standard user
	//Scripter:Dhruva
	//Date/Version:22-Jul-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA59_Validate_ForgotPassword_DontRemember_SecurityAnswer_Email(Map<String,String> testdata) throws Exception {

		String username = testdata.get("CharterID_fp");
		String password = testdata.get("UserPassword");
		String zipcode = testdata.get("Zipcode_fp");
		String GmailID=testdata.get("GmailID");
		String Gmailpw=testdata.get("Gmailpw");
		String ACnumber=testdata.get("ACnumber");
		String chartermailID = ReadFromExcel.getData("Auth","chartermailID");
		String chartermailPwd = ReadFromExcel.getData("Auth","chartermailPwd");
		
		HomePage hp=new HomePage(driver);
		AuthenticationPage ap = new AuthenticationPage(driver);
		//ap.getAccountDetails(ACnumber);
		hp.loadCharterPage(URL);
		
		Assert.assertTrue(ap.fp_forgotSecurityAnswer(username, zipcode), "User not able to retrieve password when Security answer is not remembered");
		AuthenticationPage auth = new AuthenticationPage(driver);
		auth.charterDotComMailLogin(chartermailID, chartermailPwd);
		auth.resetPasswordCharterMail(password);
		auth.resetLinkExpirationwait();
		auth.charterDotComMailLogin(chartermailID, chartermailPwd);
		auth.resetPasswordlinkExpire(password);
/*		auth.gmailLogin(GmailID, Gmailpw);
		auth.resetPasswordMail(password);
		auth.GmailLogout();
		auth.resetLinkExpirationwait();
		auth.gmailLogin(GmailID, Gmailpw);
		auth.resetPasswordlinkExpire(password);*/
	}
	
	//Name: TA61_Validate_ForgotPassword_nonCPNI_SecurityQA()
	//Description: Validate the forgot password condition for non CPNI user to retrieve through security Q&A
	//Standard user
	//Scripter:Dhruva
	//Date/Version:23-Jul-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA61_Validate_ForgotPassword_nonCPNI_SecurityQA(Map<String,String> testdata) throws Exception {

		String username = testdata.get("CharterID_fp");
		String password = testdata.get("UserPassword");
		String security_answer=testdata.get("security_answer");
		String zipcode_fID=testdata.get("Zipcode_fp");
		//String mac = testdata.get("mac_fID");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.fp_NonCPNISecurityAnswer(username,password,security_answer,zipcode_fID),"Successful message is not displayed in Forgot Password flow");
		MyAccountPage MAPage = new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.VoiceServiceslink();
		MAPage.verifyNonCPNI();	
	}
	
	//Name: TA62_Validate_ForgotPassword_CPNI_SecurityQA_convertTo_NonCPNI()
	//Description: Validate the forgot password condition for CPNI user to retrieve through security Q&A and convert to non CPNI
	//Standard user
	//Scripter:Dhruva
	//Date/Version:23-Jul-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA62_Validate_ForgotPassword_CPNI_SecurityQA_convertTo_NonCPNI(Map<String,String> testdata) throws Exception {

		String username = testdata.get("CharterID_fp");
		String password = testdata.get("UserPassword");
		String security_answer=testdata.get("security_answer");
		String zipcode_fID=testdata.get("Zipcode_fp");	
		String ACnumber=testdata.get("ACnumber");
		String macID=testdata.get("mac_fID");
		
		HomePage hp=new HomePage(driver);
		AuthenticationPage auth = new AuthenticationPage(driver);
		//auth.getAccountDetails(ACnumber);
		hp.loadCharterPage(URL);
		Assert.assertTrue(auth.fp_CPNISecurityAnswer(username,password,security_answer,zipcode_fID),"Successful message is not displayed in Retrieve Password flow");
		MyAccountPage MAPage = new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.VoiceServiceslink();
		MAPage.verifyCPNI(macID);	
	}
	
	//Name: TA63_Validate_ForgotPassword_nonCPNI_Email()
	//Description: Validate the forgot password condition for non CPNI user to retrieve through security Q&A
	//Standard user
	//Scripter:Dhruva
	//Date/Version:23-Jul-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA63_Validate_ForgotPassword_nonCPNI_Email(Map<String,String> testdata) throws Exception {

		String username = testdata.get("CharterID_fp");
		String password = testdata.get("UserPassword");
		String zipcode_fID=testdata.get("Zipcode_fp");
		String ACnumber=testdata.get("ACnumber");
		
		HomePage hp=new HomePage(driver);
		AuthenticationPage auth = new AuthenticationPage(driver);
		auth.getAccountDetails(ACnumber);
		hp.loadCharterPage(URL);

		Assert.assertTrue(auth.fp_NonCPNIEmail(username,password,zipcode_fID),"Successful message is not displayed in Retrieve Password flow");
	}
	
	//Name: TA64_Validate_ForgotPassword_CPNI_Email_convertTo_NonCPNI()
	//Description: Validate the forgot password condition for CPNI user to retrieve through Email and convert to non CPNI
	//Standard user
	//Scripter:Dhruva
	//Date/Version:23-Jul-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA64_Validate_ForgotPassword_CPNI_Email_convertTo_NonCPNI(Map<String,String> testdata) throws Exception {

		String username = testdata.get("CharterID_fp");
		String password = testdata.get("UserPassword");
		String zipcode_fID=testdata.get("Zipcode_fp");
		String GmailID=testdata.get("GmailID");
		String Gmailpw=testdata.get("Gmailpw");
		String ACnumber=testdata.get("ACnumber");
		String mac = testdata.get("mac_fID");
		String chartermailID = ReadFromExcel.getData("Auth","chartermailID");
		String chartermailPwd = ReadFromExcel.getData("Auth","chartermailPwd");
		String email=testdata.get("email");
		
		HomePage hp=new HomePage(driver);
		AuthenticationPage auth = new AuthenticationPage(driver);
		MyAccountPage ma = new MyAccountPage(driver);
		//auth.getAccountDetails(ACnumber);
		hp.loadCharterPage(URL);
		auth.fp_CPNIEmail(username,zipcode_fID,email);		
		//auth.gmailLogin(GmailID,Gmailpw);
		//auth.resetPasswordMail(password);
		auth.charterDotComMailLogin(chartermailID, chartermailPwd);
		Assert.assertTrue(auth.resetPasswordCharterMail(password),"Successful message is not displayed in Retrieve Password flow");
		hp.loadCharterPage(URL);
		hp.login(username, password);
		ma.openMyAccountTab();
		ma.VoiceServiceslink();
		ma.verifyCPNI(mac);
	}
	
	//Name: TA66_Validate_ForgotPassword_Change_SecurityQuestionAnswer()
	//Description: Validate whether User is able to see changed Security Q&A in Forgot Password flow 
	//Standard user
	//Scripter:Dhruva
	//Date/Version:16-Sep-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA66_Validate_ForgotPassword_Change_SecurityQuestionAnswer(Map<String,String> testdata) throws Exception {

		String username = testdata.get("CharterID_fp");
		String password = testdata.get("UserPassword");
		String Zipcode_fp=testdata.get("Zipcode_fp");
		String security_question = testdata.get("security_question");
		String security_answer=testdata.get("security_answer");
		String GmailID=testdata.get("GmailID");
		String Gmailpw=testdata.get("Gmailpw");
		String ACnumber=testdata.get("ACnumber");
		String email=testdata.get("email");
		String chartermailID = ReadFromExcel.getData("Auth","chartermailID");
		String chartermailPwd = ReadFromExcel.getData("Auth","chartermailPwd");
		
		HomePage hp=new HomePage(driver);
		AuthenticationPage auth = new AuthenticationPage(driver);
		//auth.getAccountDetails(ACnumber);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.loadUPPage();
		UserPreferencePage up= new UserPreferencePage(driver);
		up.EditSecurityQandA(security_question, security_answer);
		hp.logoutApplication();
		hp.loadCharterPage(URL);

		Assert.assertTrue(auth.fp_ChangedSecurityQuestion(password,username,Zipcode_fp,security_answer,email), "HOH user is not able to retrieve forgotten password");
		auth.charterDotComMailLogin(chartermailID, chartermailPwd);
		auth.resetPasswordCharterMail(password);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MAPage.loadUPPage();
		up.EditSecurityQandA("Color or make of your first car?", "red");
		hp.logoutApplication();
	}
	
	//Name: TA67_Validate_RetrievingPassword_HOHuser_ConfirmationMail()
	//Description: Validate whether the HOH user is able to retrieve the password from Forgot Password Flow and receive mail for the updated password
	//HOH User
	//Scripter:Dhruva
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA67_Validate_RetrievingPassword_HOHuser_ConfirmationMail(Map<String,String> testdata) throws Exception{

		String password = testdata.get("UserPassword");
		String CharterID_fp = testdata.get("CharterID_fp");
		String Zipcode_fp=testdata.get("Zipcode_fp");
		String security_answer=testdata.get("security_answer");
		String GmailID=testdata.get("GmailID");
		String Gmailpw=testdata.get("Gmailpw");
		String chartermailID = ReadFromExcel.getData("Auth","chartermailID");
		String chartermailPwd = ReadFromExcel.getData("Auth","chartermailPwd");
		String ACnumber=testdata.get("ACnumber");
		
		HomePage hp=new HomePage(driver);
		AuthenticationPage auth = new AuthenticationPage(driver);
		//auth.getAccountDetails(ACnumber);
		hp.loadCharterPage(URL);

		Assert.assertTrue(auth.fp_ValidE2E_HOH(password,CharterID_fp,Zipcode_fp,security_answer), "HOH user is not able to retrieve forgotten password");
		hp.logoutApplication();
		auth.charterDotComMailLogin(chartermailID,chartermailPwd);
		auth.newPwdConfirmCharterMail();
	}
	
	//Name: TA68_Validate_ConflictingUsername_RetrievingPassword_HOHuser()
	//Description: Validate whether the HOH user is able to retrieve password when .com and .net user for given account conflicts
	//HOH User
	//Scripter:Dhruva
	//Date/Version: 14-Oct-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA68_Validate_ConflictingUsername_RetrievingPassword_HOHuser(Map<String,String> testdata) throws Exception{

		String password = testdata.get("UserPassword");
		String CharterID_fp = testdata.get("CharterID_fp");
		String Zipcode_fp=testdata.get("Zipcode_fp");
		String security_answer=testdata.get("security_answer");

		String ACnumber=testdata.get("ACnumber");
		
		HomePage hp=new HomePage(driver);
		AuthenticationPage auth = new AuthenticationPage(driver);
		//auth.getAccountDetails(ACnumber);
		hp.loadCharterPage(URL);

		Assert.assertTrue(auth.fp_ValidE2E_HOH(password,CharterID_fp,Zipcode_fp,security_answer), "HOH user is not able to retrieve forgotten password");
		hp.logoutApplication();
	}
	
	//Name: TA69_Validate_ConflictingUsername_RetrievingPassword_UnconvertedHOHuser()
	//Description: Validate whether the Unconverted HOH user is able to retrieve password when .com and .net user for given account conflicts
	//HOH User
	//Scripter:Dhruva
	//Date/Version: 14-Oct-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA69_Validate_ConflictingUsername_RetrievingPassword_UnconvertedHOHuser(Map<String,String> testdata) throws Exception{

		String password = testdata.get("UserPassword");
		String CharterID_fp = testdata.get("CharterID_fp");
		String Zipcode_fp=testdata.get("Zipcode_fp");
		String security_answer=testdata.get("security_answer");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.fp_ValidE2E_UnconvertedHOH(password,CharterID_fp,Zipcode_fp,security_answer), "HOH user is not able to retrieve forgotten password");
	}
	
	//Name: TA79_Validate_SpectrumWifi_RetrievingPassword()
	//Description: Validate Spectrum Wifi user is able to retrieve password 
	//HOH User
	//Scripter:Dhruva
	//Date/Version: 12-Dec-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA79_Validate_SpectrumWifi_RetrievingPassword(Map<String,String> testdata) throws Exception{

		String password = testdata.get("UserPassword");
		String CharterID_fp = testdata.get("CharterID_fp");
		String Zipcode_fp=testdata.get("Zipcode_fp");
		String security_answer=testdata.get("security_answer");
		String lastname_fp = testdata.get("lastname_fp");
		String spectrumwifiURL = ReadFromExcel.getData("HomePage","SpectrumWifiFpLink");

		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.forgotPasswordSpectrumWifi(spectrumwifiURL, CharterID_fp, lastname_fp, Zipcode_fp, security_answer, password), "Spectrum Wifi user is not able to retrieve forgotten password");
	}
	
	@AfterMethod
	public void afterMethod() throws InterruptedException{
		Thread.sleep(2000);
		driver.manage().deleteAllCookies();
		driver.close();
	}
	
}
