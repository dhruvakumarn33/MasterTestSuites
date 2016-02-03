package com.charter.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.charter.page.AuthenticationPage;
import com.charter.page.BasicAuthenticaion;
import com.charter.page.HomePage;
import com.charter.page.InternetServicesPage;
import com.charter.page.MyAccountPage;
import com.charter.page.TVServicesPage;
import com.charter.page.VoiceServicesPage;
import com.charter.utils.Constants;
import com.charter.utils.DataProviderClass;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.TestNGBase;

public class MyServices extends TestNGBase{
	
	private String URL= Constants.URL;
	
	//Name: TD01_Validate_MyServicesPage_FindAndProgramYourRemoteLink_NavigateTo_SupportArticle()
	//Description: Validate "Find and Program your Remote" link is navigation the user to related (current) support article
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD01_Validate_MyServicesPage_FindAndProgramYourRemoteLink_NavigateTo_SupportArticle(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.TVServiceslink();
		TVServicesPage Tv=new TVServicesPage(driver);
		Assert.assertTrue(Tv.TV_Support_Links(), "User is - Not Navigated to the charter remote controls Page ");
		hp.logoutApplication();

	}
	
	//Name: TD02_Validate_MyServicesPage_DigitalReceiversLink_NavigateTo_SupportArticle()
	//Description: Validate "Digital Receivers" link is navigation the user to related (current) support article
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD02_Validate_MyServicesPage_DigitalReceiversLink_NavigateTo_SupportArticle(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.TVServiceslink();
		TVServicesPage Tv=new TVServicesPage(driver);
		Assert.assertTrue(Tv.DigitalReceiverLink(), "User is -Not Navigated to the Digital Receivers page ");
		hp.logoutApplication();
	}

	//Name: TD03_Validate_MyServicesPage_TVNonSubscribedUser_AbleToView_BannerAndSupportVideo()
	//Description: Validate if TV non subscribed user is able to view banner and support video in services page
	//HOH User
	//Scripter:Ayesha
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD03_Validate_MyServicesPage_TVNonSubscribedUser_AbleToView_BannerAndSupportVideo(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.TVServiceslink();
		TVServicesPage TVPage=new TVServicesPage(driver);
		Assert.assertTrue(TVPage.ViewBannerAndSupportVideo(), "Banner in TV Services Page is- Not present ");
		hp.logoutApplication();
	}
	//Name: TD04_Validate_MyservicesPage_UpdateDigitalReceiver_AndMessage()
	//Description: Validate Update Digital Receiver, Update action to pop-up dialog box with message
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD04_Validate_MyservicesPage_UpdateDigitalReceiver_AndMessage(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.TVServiceslink();
		TVServicesPage Tv=new TVServicesPage(driver);
		Assert.assertTrue(Tv.UpdateDigital_Reciever(), "User is not able to see popup -message for Update digital receiver");
		hp.logoutApplication();
	}

	//Name: TD05_Validate_MyServicesPage_UpdateDigitalReciever_LearnMoreLink_NavigateTo_UpdateDigitalRecieverPage()
	//Description: Validate Update Digital Receiver Learn more link action leads to Update (Refresh) Digital Receiver page
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD05_Validate_MyServicesPage_UpdateDigitalReciever_LearnMoreLink_NavigateTo_UpdateDigitalRecieverPage(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.TVServiceslink();
		TVServicesPage Tv=new TVServicesPage(driver);
		Assert.assertTrue(Tv.UDRLearnMLink(), "User - is Not Navigated to the Update Digital Receiver page");
		hp.logoutApplication();
	}

	//Name: TD06_Validate_MyServices_TV_Page_UpdateNickname()
	//Description: Validate Name Your Digital Receiver(s) option to update Nickname and Save button
	//HOH User
	//Scripter:Ayesha
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD06_Validate_MyServices_TV_Page_UpdateNickname(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
        String Devicenickname=testdata.get("Devicenickname");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.TVServiceslink();
		TVServicesPage TVPage=new TVServicesPage(driver);
		Assert.assertTrue(TVPage.UpdateAndSaveMACAddress(Devicenickname), "User is not able to update Nickname");
		verifyAssert(TVPage.nicknameverify(), Devicenickname, "Nick name is not updated in the tv services page");
	}
	
	//Name: TD07_Validate_MyservicesPage_CheckthisTVLink_NavigateTo_MyTVPage()
	//Description: Validate Name Your Digital Receiver(s) link check this TV is leading to My TV services page
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD07_Validate_MyservicesPage_CheckthisTVLink_NavigateTo_MyTVPage(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.TVServiceslink();
		TVServicesPage Tv=new TVServicesPage(driver);
		Assert.assertTrue(Tv.CheckTVlink(), "Check TV Link is -Not present");
		hp.logoutApplication();
	}
	//Name: TD08_Validate_MyservicesPage_NameYourDigitalReceiverLearnMoreLink_NavigateTo_TVServicesPage()
	//Description: Validate Name Your Digital Receiver(s) 'Learn more' link action leads to My Account - TV Services page
	//HOH User
	//Scripter:Ayesha
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD08_Validate_MyservicesPage_NameYourDigitalReceiverLearnMoreLink_NavigateTo_TVServicesPage(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.TVServiceslink();
		TVServicesPage TVPage=new TVServicesPage(driver);
		Assert.assertTrue(TVPage.NYDRToMATVPage(), "User is -Not Navigated to the NameReceiver Page");
		hp.logoutApplication();
	}
	//Name: TD09_Validate_MyServicesPage_ActivateNewDigitalReceiverUpdate_AndMessage()
	//Description: Validate Activate New Digital Receiver, Update action to pop-up dialog box with message
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD09_Validate_MyServicesPage_ActivateNewDigitalReceiverUpdate_AndMessage(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.TVServiceslink();
		TVServicesPage Tv=new TVServicesPage(driver);
		Assert.assertTrue(Tv.ADRUpdatebtn(), "User is -Not Navigated to Activate New Digital Receiver page");
	}

	//Name: TD10_Validate_MyServicesPage_ActivateNewDigitalReceiverLearnMoreLink_NavigateTo_TVServicesPage()
	//Description: Validate Activate New Digital Receiver Learn more link action leads to My Account - TV Services
	//HOH User
	//Scripter:Ayesha
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD10_Validate_MyServicesPage_ActivateNewDigitalReceiverLearnMoreLink_NavigateTo_TVServicesPage(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.TVServiceslink();
		TVServicesPage TVPage=new TVServicesPage(driver);
		Assert.assertTrue(TVPage.ANDRLMlink(), "User is -Not Navigated to Digital Receiver Self Install Page");
		hp.logoutApplication();
	}

	//Name: TD11_Validate_MyServicesPage_FindWiFiLink_Navigation()
	//Description: Validate "Finding WiFi Name and Password" link is navigation the user to related (current) support article
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD11_Validate_MyServicesPage_FindWiFiLink_Navigation(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.InternetServiceslink();
		InternetServicesPage IP= new InternetServicesPage(driver);
		Assert.assertTrue(IP.InternetSupport(), "User is - Not Navigated to Finding WiFi Name/Password Page");
		hp.logoutApplication();

	}
	
	//Name: TD12_Validate_MyServicesPage_RestartingYourCableModemLink_Navigation()
	//Description: Validate "Restarting Your Cable Modem" link is navigation the user to related (current) support article
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD12_Validate_MyServicesPage_RestartingYourCableModemLink_Navigation(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.InternetServiceslink();
		InternetServicesPage IP= new InternetServicesPage(driver);
		Assert.assertTrue(IP.CableModem(), "User is - Not Navigated to Reset Your Cable Modem Page");
		hp.logoutApplication();
	}

	//Name: TD13_Validate_MyServicesPage_InternetNonSubscribedUser_AbleToView_BannerAndSupportVideo()
	//Description: Validate if Internet non subscribed user is able to view banner and support video in services page
	//HOH User
	//Scripter:Ayesha
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD13_Validate_MyServicesPage_InternetNonSubscribedUser_AbleToView_BannerAndSupportVideo(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.InternetServiceslink();
		InternetServicesPage ISPage=new InternetServicesPage(driver);
		Assert.assertTrue(ISPage.ViewBannerAndSupportVideo(), "User is - Not Navigated to Internet charter wifi page");
		hp.logoutApplication();
	}
	//Name: TD14_Validate_MyServicesPage_ChaterEmail_NavigateTo_EmailInbox()
	//Description: Validate Charter Email, Manage/Charter Email is leading to Email inbox
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD14_Validate_MyServicesPage_ChaterEmail_NavigateTo_EmailInbox(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.InternetServiceslink();
		InternetServicesPage IP= new InternetServicesPage(driver);
		Assert.assertTrue(IP.CharterEmail_link(), "User is - Not Navigated to mail page");
	}
	
	//Name: TD15_Validate_MyServicesPage_ChaterEmailLearnMore_NavigateTo_EmailDesktopPage()
	//Description: Validate Charter Email's 'Learn More' link click is leading to Email - Desktop page
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD15_Validate_MyServicesPage_ChaterEmailLearnMore_NavigateTo_EmailDesktopPage(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.InternetServiceslink();
		InternetServicesPage IP= new InternetServicesPage(driver);
		Assert.assertTrue(IP.CharterEmail_LMlink(), "User is - Not Navigated to Email-Desktop Page");
		hp.logoutApplication();
	}
	
	//Name: TD16_Validate_MyservicesPage_SecuritySuite_NavigateTo_ChaterSecuritySuite()
	//Description: Validate Security Suite, Manage/Charter Security suite is leading to Charter Security Suite
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD16_Validate_MyservicesPage_SecuritySuite_NavigateTo_ChaterSecuritySuite(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.InternetServiceslink();
		InternetServicesPage IP= new InternetServicesPage(driver);
		Assert.assertTrue(IP.charterSecuritySuitelink(), "User is - Not Navigated to Charter Security Suite Page with Charter Security Link");
		hp.logoutApplication();

	}
	
	//Name: TD17_Validate_MyServicesPage_SecuritySuiteLearnMore_NavigateTo_SecuritySuitePage()
	//Description: Validate Security Suite's 'Learn More' link click is leading to Charter Security Suite page
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD17_Validate_MyServicesPage_SecuritySuiteLearnMore_NavigateTo_SecuritySuitePage(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.InternetServiceslink();
		InternetServicesPage IP= new InternetServicesPage(driver);
		Assert.assertTrue(IP.SecuritySuiteLM(), "User is - Not Navigated to Charter Security Suite Support Page");
		hp.logoutApplication();

	}

	//Name: TD18_Validate_MyServicesPage_CloudDriveLink_NavigateTo_CloudDrivePage()
	//Description: Validate Charter Cloud Drive, Manage/Cloud drive is leading to Charter Cloud Drive page
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD18_Validate_MyServicesPage_CloudDriveLink_NavigateTo_CloudDrivePage(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.InternetServiceslink();
		InternetServicesPage IP= new InternetServicesPage(driver);
		Assert.assertTrue(IP.CharterCloudDrivelink(), "User is - Not Navigated to  Cloud Drive login page with Cloud Drive link");
	}
	
	//Name: TD19_Validate_MyServicesPage_CloudDriveLearnMoreLink_NavigateTo_CloudDriveInfoPage()
	//Description:Validate Charter Cloud Drive's Learn More link click is leading to Charter Cloud Drive info page
	//HOH User
	//Scripter:Ayesha
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD19_Validate_MyServicesPage_CloudDriveLearnMoreLink_NavigateTo_CloudDriveInfoPage(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.InternetServiceslink();
		InternetServicesPage ISPage=new InternetServicesPage(driver);
		Assert.assertTrue(ISPage.CloudDriverLMLink(), "User is - Not Navigated to Charter Cloud Drive Support Page");
		hp.logoutApplication();
	}

	//Name: TD20_Validate_MyServicesPage_VoicemailHelpLink_NavigateTo_VoicemailHelpPage()
	//Description:Validate "Voice mail help" link is navigation the user to Voice mail Help page
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD20_Validate_MyServicesPage_VoicemailHelpLink_NavigateTo_VoicemailHelpPage(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.VoiceServiceslink();
		VoiceServicesPage VP=new VoiceServicesPage(driver);
		Assert.assertTrue(VP.Voicehelp(), "User is - Not Navigated to Voice mail help page");
		hp.logoutApplication();
	}

	//Name: TD21_Validate_MyServicesPage_VoiceFeaturesLink_NavigateTo_PhoneFeaturesPage()
	//Description:Validate "Voice features" link is navigation the user to Phone Features page
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD21_Validate_MyServicesPage_VoiceFeaturesLink_NavigateTo_PhoneFeaturesPage(Map<String,String> testdata) throws Exception{
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username,password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.VoiceServiceslink();
		VoiceServicesPage VP=new VoiceServicesPage(driver);
		Assert.assertTrue(VP.VoiceFeatures(), "User is - Not Navigated to Voice features page");
	}
	
	//Name: TD22_Validate_MyServicesPage_VoiceNonSubscribedUser_AbleToView_BannerAndSupportVideo()
	//Description:Validate if Voice non subscribed user is able to view banner and support video in services page
	//HOH User
	//Scripter:Ayesha
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD22_Validate_MyServicesPage_VoiceNonSubscribedUser_AbleToView_BannerAndSupportVideo(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.VoiceServiceslink();
		VoiceServicesPage VP=new VoiceServicesPage(driver);
		Assert.assertTrue(VP.ViewBannerAndSupportVideo(), "Banner for Voice Services Non Subscribed User -is not present  ");
		hp.logoutApplication();
	}

	//Name: TD23_Validate_MyServicesPage_CharterPhoneLink_NavigateTo_PhoneOnlineManagerPage()
	//Description:Validate Charter Phone, Manage/Charter Phone is leading to Phone Online Manager
	//Standard User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD23_Validate_MyServicesPage_CharterPhoneLink_NavigateTo_PhoneOnlineManagerPage(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.VoiceServiceslink();
		VoiceServicesPage VP=new VoiceServicesPage(driver);
		Assert.assertTrue(VP.VoiceOnlineManagerLink(), "User with Charter Phone Link -Not Navigated to Phone Online Manager Page");
	}

	//Name: TD24_Validate_MyServicesPage_CharterPhoneLearnMoreLink_NavigateTo_VoiceSupportPage()
	//Description:Validate Charter Phone 'Learn More' link click is leading to Welcome to Charter Voice Support page
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD24_Validate_MyServicesPage_CharterPhoneLearnMoreLink_NavigateTo_VoiceSupportPage(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.VoiceServiceslink();
		VoiceServicesPage VP=new VoiceServicesPage(driver);
		Assert.assertTrue(VP.CharterPhoneLMLink(), "User is -Not Navigated to Voice Support page");
		hp.logoutApplication();
	}
	
	//Name: TD25_Validate_MyServicesPage_LinksWithLogin()
	//Description:Validate my services links with user logged in
	//HOH User
	//Scripter:Ayesha
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD25_Validate_MyServicesPage_LinksWithLogin(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.InternetServiceslink();
		MA.TVServiceslink();
		Assert.assertTrue(MA.VoiceServiceslink(), "User is not able to validate Voice Services link");
		hp.logoutApplication();
	}

	//Name: TD26_Validate_MyServicesPage_LinksWithOutLogin()
	//Description:Validate my services links without logging in
	//Scripter:Ayesha
	//Date/Version:
	@Test
	public void TD26_Validate_MyServicesPage_LinksWithOutLogin() throws Exception {
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.TVwithoutLogin();
		MA.InternetwithoutLogin();
		Assert.assertTrue(MA.VoicewithoutLogin(), "User is not able to validate Voice Services link with out login");
	}
	
	//Name: TD27_Validate_CharterSecuritySuite_SupportLinks()
	//Description: Validate navigating to the respective pages on clicking Support and Uninstall Software in Security suite page
	//HOH user
	//Scripter:Dhruva
	//Date/Version:12-Aug-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD27_Validate_CharterSecuritySuite_SupportLinks(Map<String,String> testdata) throws Exception{
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.InternetServiceslink();
		InternetServicesPage isp=new InternetServicesPage(driver);
		isp.charterSecuritySuitelink();
		Assert.assertTrue(isp.SecuritySuiteSupportLink(), "User is not able to validate Support link in Security Suite page");
	}
	
	//Name: TD28_Validate_CharterSecuritySuite_UninstallSoftwareLink()
	//Description: Validate navigating to the respective page on clicking Uninstall link in Security suite page
	//HOH user
	//Scripter:Dhruva
	//Date/Version:12-Aug-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD28_Validate_CharterSecuritySuite_UninstallSoftwareLink(Map<String,String> testdata) throws Exception{
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.InternetServiceslink();
		InternetServicesPage isp=new InternetServicesPage(driver);
		isp.charterSecuritySuitelink();
		Assert.assertTrue(isp.SecuritySuiteUninstallLink(), "User is not able to validate Uninstall Software link in Security Suite page");
	}
	
	//Name: TD29_Validate_CharterSecuritySuite_DeviceNickName_WarningMsg()
	//Description: Validate the in -line warning message for Device Nick name field at Install now in security suite page 
	//HOH user
	//Scripter:Dhruva
	//Date/Version:12-Aug-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD29_Validate_CharterSecuritySuite_DeviceNickName_WarningMsg(Map<String,String> testdata) throws Exception{
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.InternetServiceslink();
		InternetServicesPage isp=new InternetServicesPage(driver);
		isp.charterSecuritySuitelink();
		Assert.assertTrue(isp.DeviceNicknameInstall(), "Device Nickname update warning message is not displayed");
	}	
	
	//Name: TD30_Validate_CharterSecuritySuite_AskSpectrum_Widget()
	//Description: Validate Ask Spectrum widget in Charter Security suite page
	//HOH user
	//Scripter:Dhruva
	//Date/Version:12-Aug-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD30_Validate_CharterSecuritySuite_AskSpectrum_Widget(Map<String,String> testdata) throws Exception{
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.InternetServiceslink();
		InternetServicesPage isp=new InternetServicesPage(driver);
		isp.charterSecuritySuitelink();
		Assert.assertTrue(isp.AskCharter_TV() & isp.Askbutton_TV(), "Ask Charter Widget cannot be validated");
	}	
	
	//Name: TD31_Validate_TVEquipment_ToggleOnImages()
	//Description: To verify that for an authenticated user with TV services, user will be able to toggle and enlarge images associated to his account within the TV Equipment detail page
	//HOH user
	//Scripter:Dhruva
	//Date/Version:20-Aug-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD31_Validate_TVEquipment_ToggleOnImages(Map<String,String> testdata) throws Exception{
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.TVServiceslink();
		TVServicesPage tvs=new TVServicesPage(driver);
		Assert.assertTrue(tvs.TVEquipmentImgToggle(),"Cannot toggle between TV Equipment images");
	}
	
	//Name: TD32_Validate_NoInternetEquipment()
	//Description: To verify that as an authenticated user with Internet services, user will not be able to see any equipment associated to his account within the Internet Equipment detail page
	//HOH user
	//Scripter:Dhruva
	//Date/Version:01-Sep-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD32_Validate_NoInternetEquipment(Map<String,String> testdata) throws Exception{
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.InternetServiceslink();
		InternetServicesPage isp=new InternetServicesPage(driver);
		Assert.assertTrue(isp.checkInternetEquipment(),"Internet Services page displays Equipment");
	}
	
	//Name: TD33_Validate_NoVoiceEquipment()
	//Description: To verify that as an authenticated user with Voice services, user will not be able to see any equipment associated to his account within the Voice Equipment detail page
	//HOH user
	//Scripter:Dhruva
	//Date/Version:01-Sep-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD33_Validate_NoVoiceEquipment(Map<String,String> testdata) throws Exception{
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.VoiceServiceslink();
		VoiceServicesPage vsp=new VoiceServicesPage(driver);
		Assert.assertTrue(vsp.checkVoiceEquipment(),"Voice Services page displays Equipment");
	}
	
	//Name: TD34_Validate_TVEquipmentDetailsPage()
	//Description: To verify that as an authenticated user with TV services, user will be able to see any equipment associated to his account within the TV Equipment detail page
	//HOH user
	//Scripter:Dhruva
	//Date/Version:01-Sep-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD34_Validate_TVEquipmentDetailsPage(Map<String,String> testdata) throws Exception{
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String Devicenickname=testdata.get("Devicenickname");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.TVServiceslink();
		TVServicesPage tvp=new TVServicesPage(driver);
		tvp.TVEquipmentImgToggle();
		Assert.assertTrue(tvp.checkTVEquipment(),"TV Services page doesn't display Equipment details");
		tvp.UpdateAndSaveMACAddress(Devicenickname);
	}
	
	//Name: TD35_Validate_TVEquipment_MakePrimary()
	//Description: To verify that for an authenticated user with TV services, user will be able to set equipment as primary for any equipment associated to his account within the TV Equipment detail page
	//HOH user
	//Scripter:Dhruva
	//Date/Version:01-Sep-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD35_Validate_TVEquipment_MakePrimary(Map<String,String> testdata) throws Exception{
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.TVServiceslink();
		TVServicesPage tvp=new TVServicesPage(driver);
		Assert.assertTrue(tvp.makePrimary(),"User could not change the primary equipment");
	}
	
	//Name: TD36_Validate_TVChannelList_Print()
	//Description: Verify whether the user is able to select and manage Print Channel Line Up Service Bar
	//HOH user
	//Scripter:Dhruva
	//Date/Version:02-Sep-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD36_Validate_TVChannelList_Print(Map<String,String> testdata) throws Exception{
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.TVServiceslink();
		TVServicesPage tvp=new TVServicesPage(driver);
		tvp.viewChLineup();
		Assert.assertTrue(tvp.printchList(),"User could not print Channel Lineup");
	}
	
	//Name: TD37_Validate_TVServices_ShowOnTV()
	//Description: To verify that for an authenticated user with TV services, user will be able to send signal for show on TV option
	//HOH user
	//Scripter:Dhruva
	//Date/Version:30-Sep-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD37_Validate_TVServices_ShowOnTV(Map<String,String> testdata) throws Exception{
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.TVServiceslink();
		TVServicesPage tvp=new TVServicesPage(driver);
		Assert.assertTrue(tvp.showOnTV(),"User is not able to view the message on TV services page");
	}
	
	//Name: TD38_Validate_VoiceMail_NotificationMail()
	//Description: Verification of Email received for readable voice
	//HOH user
	//Scripter:Dhruva
	//Date/Version:26-Oct-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD38_Validate_VoiceMail_NotificationMail(Map<String,String> testdata) throws Exception{
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String email = testdata.get("email");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		hp.Voicemailicon_Homepage();
		VoiceServicesPage vsp = new VoiceServicesPage(driver);
		Assert.assertTrue(vsp.VoiceNotificationMail(email),"User is not able to view the message on TV services page");
	}
	
	//Name: TD39_Validate_Voice_Upgrade_charterDotNet()
	//Description: Verification of buyflow for Voice Service Upgrade from charter.net
	//HOH user
	//Scripter:Dhruva
	//Date/Version:11-Nov-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD39_Validate_Voice_Upgrade_charterDotNet(Map<String,String> testdata) throws Exception{
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String Address1 = testdata.get("Address1");
		String Address2 = testdata.get("Address2");
		String Zipcode = testdata.get("Zipcode");
		String ACnumber = testdata.get("ACnumber");
		String Mobilephone=testdata.get("Mobilephone");
		String firstname=testdata.get("firstname_CID");
		String lastname=testdata.get("lastname_CID");
		String email=testdata.get("email");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MAPage = new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.UpgradeVoice(Address1,Address2,Zipcode,ACnumber,email,firstname,lastname,Mobilephone);

	}
	
	//Name: TD40_Validate_TV_Upgrade_charterDotNet()
	//Description: Verification of buyflow for TV Service Upgrade from charter.net
	//HOH user
	//Scripter:Dhruva
	//Date/Version:11-Nov-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD40_Validate_TV_Upgrade_charterDotNet(Map<String,String> testdata) throws Exception{
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String Address1 = testdata.get("Address1");
		String Address2 = testdata.get("Address2");
		String Zipcode = testdata.get("Zipcode");
		String ACnumber = testdata.get("ACnumber");
		String Mobilephone=testdata.get("Mobilephone");
		String firstname=testdata.get("firstname_CID");
		String lastname=testdata.get("lastname_CID");
		String email=testdata.get("email");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MAPage = new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.UpgradeTV(Address1,Address2,Zipcode,ACnumber,email,firstname,lastname,Mobilephone);

	}
	
	//Name: TD41_Validate_Internet_Upgrade_charterDotNet()
	//Description: Verification of buyflow for TV Service Upgrade from charter.net
	//HOH user
	//Scripter:Dhruva
	//Date/Version:11-Nov-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD41_Validate_Internet_Upgrade_charterDotNet(Map<String,String> testdata) throws Exception{
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String Address1 = testdata.get("Address1");
		String Address2 = testdata.get("Address2");
		String Zipcode = testdata.get("Zipcode");
		String ACnumber = testdata.get("ACnumber");
		String Mobilephone=testdata.get("Mobilephone");
		String firstname=testdata.get("firstname_CID");
		String lastname=testdata.get("lastname_CID");
		String email=testdata.get("email");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MAPage = new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.UpgradeInternet(Address1,Address2,Zipcode,ACnumber,email,firstname,lastname,Mobilephone);

	}
	
	//Name: TD42_Validate_Internet_Upgrade_charterDotCom()
	//Description: Verification of buyflow for TV Service Upgrade from charter.com
	//HOH user
	//Scripter:Dhruva
	//Date/Version:12-Nov-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD42_Validate_Internet_Upgrade_charterDotCom(Map<String,String> testdata) throws Exception{

		String BasicURL=testdata.get("LegacySiteURL");
		String ACnumber=testdata.get("ACnumber");
		String email=testdata.get("email");
		String Address1=testdata.get("Address1");
		String Address2=testdata.get("Address2");
		String Zipcode=testdata.get("Zipcode");
		String Mobilephone=testdata.get("Mobilephone");
		String fname=testdata.get("firstname_CID");
		String lname=testdata.get("lastname_CID");
		
		driver.navigate().to(BasicURL);
		BasicAuthenticaion basic=new BasicAuthenticaion(driver);
		//basic.dotComLogin(Address1, Address2, Zipcode, ACnumber);
		basic.internetUpgradeDotCom(Address1, Address2, Zipcode,ACnumber,email,Mobilephone,fname,lname);
	}
	
	//Name: TD43_Validate_TV_Upgrade_charterDotCom()
	//Description: Verification of buyflow for TV Service Upgrade from charter.com
	//HOH user
	//Scripter:Dhruva
	//Date/Version:12-Nov-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD43_Validate_TV_Upgrade_charterDotCom(Map<String,String> testdata) throws Exception{

		String BasicURL=testdata.get("LegacySiteURL");
		String ACnumber=testdata.get("ACnumber");
		String email=testdata.get("email");
		String Address1=testdata.get("Address1");
		String Address2=testdata.get("Address2");
		String Zipcode=testdata.get("Zipcode");
		String Mobilephone=testdata.get("Mobilephone");
		String fname=testdata.get("firstname_CID");
		String lname=testdata.get("lastname_CID");
		
		driver.navigate().to(BasicURL);
		BasicAuthenticaion basic=new BasicAuthenticaion(driver);
		//basic.dotComLogin(Address1, Address2, Zipcode, ACnumber);
		basic.tvUpgradeDotCom(Address1, Address2, Zipcode,ACnumber,email,Mobilephone,fname,lname);
		
	}
	
	//Name: TD44_Validate_Voice_Upgrade_charterDotCom()
	//Description: Verification of buyflow for Voice Service Upgrade from charter.com
	//HOH user
	//Scripter:Dhruva
	//Date/Version:12-Nov-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD44_Validate_Voice_Upgrade_charterDotCom(Map<String,String> testdata) throws Exception{

		String BasicURL=testdata.get("LegacySiteURL");
		String ACnumber=testdata.get("ACnumber");
		String email=testdata.get("email");
		String Address1=testdata.get("Address1");
		String Address2=testdata.get("Address2");
		String Zipcode=testdata.get("Zipcode");
		String Mobilephone=testdata.get("Mobilephone");
		String fname=testdata.get("firstname_CID");
		String lname=testdata.get("lastname_CID");
		
		driver.navigate().to(BasicURL);
		BasicAuthenticaion basic=new BasicAuthenticaion(driver);
		//basic.dotComLogin(Address1, Address2, Zipcode, ACnumber);
		basic.voiceUpgradeDotCom(Address1, Address2, Zipcode,ACnumber,email,Mobilephone,fname,lname);
		
	}
	
	//Name: TD45_Validate_TV_Upgrade_SilverPackage_charterDotCom()
	//Description: Verification of buyflow for TV Service Upgrade to Silver Package from charter.com
	//HOH user
	//Scripter:Dhruva
	//Date/Version:19-Nov-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD45_Validate_TV_Upgrade_SilverPackage_charterDotCom(Map<String,String> testdata) throws Exception{

		String BasicURL=testdata.get("LegacySiteURL");
		String ACnumber=testdata.get("ACnumber");
		String email=testdata.get("email");
		String Address1=testdata.get("Address1");
		String Address2=testdata.get("Address2");
		String Zipcode=testdata.get("Zipcode");
		String Mobilephone=testdata.get("Mobilephone");
		String fname=testdata.get("firstname_CID");
		String lname=testdata.get("lastname_CID");
		
		BasicAuthenticaion basic=new BasicAuthenticaion(driver);
		basic.loadCharterLegacy();
		//basic.dotComLogin(Address1, Address2, Zipcode, ACnumber);
		basic.TVUpgradeDotCom_Silver(Address1, Address2, Zipcode, ACnumber,email,Mobilephone,fname,lname);
		
	}
	
	//Name: TD46_Validate_TV_Upgrade_DoublePlayAccount_charterDotCom()
	//Description: Verification of buyflow for TV Service Upgrade from double play(voice+internet) from charter.com
	//HOH user
	//Scripter:Dhruva
	//Date/Version:12-Nov-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD46_Validate_TV_Upgrade_DoublePlayAccount_charterDotCom(Map<String,String> testdata) throws Exception{

		String BasicURL=testdata.get("LegacySiteURL");
		String ACnumber=testdata.get("ACnumber");
		String email=testdata.get("email");
		String Address1=testdata.get("Address1");
		String Address2=testdata.get("Address2");
		String Zipcode=testdata.get("Zipcode");
		String Mobilephone=testdata.get("Mobilephone");
		String fname=testdata.get("firstname_CID");
		String lname=testdata.get("lastname_CID");
		
		driver.navigate().to(BasicURL);
		BasicAuthenticaion basic=new BasicAuthenticaion(driver);
		//basic.dotComLogin(Address1, Address2, Zipcode, ACnumber);
		basic.tvUpgradeDotCom(Address1, Address2, Zipcode,ACnumber,email,Mobilephone,fname,lname);
		
	}

	//Name: TD47_Validate_Internet_Upgrade_DoublePlayAccount_charterDotCom()
	//Description: Verification of buyflow for Internet Service Upgrade from double play(voice+TV) from charter.com
	//HOH user
	//Scripter:Dhruva
	//Date/Version:12-Nov-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD47_Validate_Internet_Upgrade_DoublePlayAccount_charterDotCom(Map<String,String> testdata) throws Exception{

		String BasicURL=testdata.get("LegacySiteURL");
		String ACnumber=testdata.get("ACnumber");
		String email=testdata.get("email");
		String Address1=testdata.get("Address1");
		String Address2=testdata.get("Address2");
		String Zipcode=testdata.get("Zipcode");
		String Mobilephone=testdata.get("Mobilephone");
		String fname=testdata.get("firstname_CID");
		String lname=testdata.get("lastname_CID");
		
		driver.navigate().to(BasicURL);
		BasicAuthenticaion basic=new BasicAuthenticaion(driver);
		//basic.dotComLogin(Address1, Address2, Zipcode, ACnumber);
		basic.internetUpgradeDotCom(Address1, Address2, Zipcode,ACnumber,email,Mobilephone,fname,lname);
	}
	
	//Name: TD48_Validate_Internet_Equipment_details()
	//Description: Verification of internet equipment and its details
	//HOH user
	//Scripter:Dhruva
	//Date/Version:19-Nov-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD48_Validate_Internet_Equipment_details(Map<String,String> testdata) throws Exception{
		
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.InternetServiceslink();
		InternetServicesPage isp = new InternetServicesPage(driver);
		isp.modemDetails();
		hp.logoutApplication();
	}
	
	//Name: TD49_Validate_TV_Upgrade_GoldPackage_charterDotCom()
	//Description: Verification of buyflow for TV Service Upgrade to Gold Package from charter.com
	//HOH user
	//Scripter:Dhruva
	//Date/Version:19-Nov-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD49_Validate_TV_Upgrade_GoldPackage_charterDotCom(Map<String,String> testdata) throws Exception{

		String BasicURL=testdata.get("LegacySiteURL");
		String ACnumber=testdata.get("ACnumber");
		String email=testdata.get("email");
		String Address1=testdata.get("Address1");
		String Address2=testdata.get("Address2");
		String Zipcode=testdata.get("Zipcode");
		String Mobilephone=testdata.get("Mobilephone");
		String firstname=testdata.get("firstname_CID");
		String lastname=testdata.get("lastname_CID");
		
		BasicAuthenticaion basic=new BasicAuthenticaion(driver);
		basic.loadCharterLegacy();
		//basic.dotComLogin(Address1, Address2, Zipcode, ACnumber);
		basic.TVUpgradeDotCom_Gold(Address1, Address2, Zipcode, ACnumber,email,Mobilephone,firstname,lastname);
		
	}
	
	//Name: TD50_Validate_TV_Upgrade_TVSelectPackage_HBOChannel_charterDotCom()
	//Description: Verification of buyflow for TV Service Upgrade to Silver Package along with HBO channel from charter.com
	//HOH user
	//Scripter:Dhruva
	//Date/Version:19-Nov-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD50_Validate_TV_Upgrade_TVSelectPackage_HBOChannel_charterDotCom(Map<String,String> testdata) throws Exception{

		String BasicURL=testdata.get("LegacySiteURL");
		String ACnumber=testdata.get("ACnumber");
		String email=testdata.get("email");
		String Address1=testdata.get("Address1");
		String Address2=testdata.get("Address2");
		String Zipcode=testdata.get("Zipcode");
		String Mobilephone=testdata.get("Mobilephone");
		String firstname=testdata.get("firstname_CID");
		String lastname=testdata.get("lastname_CID");
		
		BasicAuthenticaion basic=new BasicAuthenticaion(driver);
		basic.loadCharterLegacy();
		//basic.dotComLogin(Address1, Address2, Zipcode, ACnumber);
		basic.TVUpgradeDotCom_Select_HBO(Address1, Address2, Zipcode, ACnumber,email,Mobilephone,firstname,lastname);
		
	}
	
	//Name: TD51_Validate_Voice_Upgrade_DoublePlayAccount_charterDotCom()
	//Description: Verification of buyflow for Voice Service Upgrade from double play(voice+TV) from charter.com
	//HOH user
	//Scripter:Dhruva
	//Date/Version:19-Nov-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD51_Validate_Voice_Upgrade_DoublePlayAccount_charterDotCom(Map<String,String> testdata) throws Exception{

		String BasicURL=testdata.get("LegacySiteURL");
		String ACnumber=testdata.get("ACnumber");
		String email=testdata.get("email");
		String Address1=testdata.get("Address1");
		String Address2=testdata.get("Address2");
		String Zipcode=testdata.get("Zipcode");
		String Mobilephone=testdata.get("Mobilephone");
		String fname=testdata.get("firstname_CID");
		String lname=testdata.get("lastname_CID");
		
		driver.navigate().to(BasicURL);
		BasicAuthenticaion basic=new BasicAuthenticaion(driver);
		//basic.dotComLogin(Address1, Address2, Zipcode, ACnumber);
		basic.voiceUpgradeDotCom(Address1, Address2, Zipcode,ACnumber,email,Mobilephone,fname,lname);
		
	}
	
	//Name: TD52_Validate_TV_Upgrade_MDUAccount_charterDotCom()
	//Description: Verification of buyflow for TV Service Upgrade for a MDU account from charter.com
	//HOH user
	//Scripter:Dhruva
	//Date/Version:20-Nov-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD52_Validate_TV_Upgrade_MDUAccount_charterDotCom(Map<String,String> testdata) throws Exception{

		String BasicURL=testdata.get("LegacySiteURL");
		String ACnumber=testdata.get("ACnumber");
		String email=testdata.get("email");
		String Address1=testdata.get("Address1");
		String Address2=testdata.get("Address2");
		String Zipcode=testdata.get("Zipcode");
		String Mobilephone=testdata.get("Mobilephone");
		String firstname=testdata.get("firstname_CID");
		String lastname=testdata.get("lastname_CID");
		
		BasicAuthenticaion basic=new BasicAuthenticaion(driver);
		basic.loadCharterLegacy();
		basic.dotComLogin(Address1, Address2, Zipcode, ACnumber);
		basic.TVUpgradeDotCom_Silver(Address1, Address2, Zipcode, ACnumber,email,Mobilephone,firstname,lastname);
		
	}
	
	//Name: TD53_Validate_ServiceUpgrade_HardDisconnectedAccount_charterDotCom()
	//Description: Verification of buyflow for any Service Upgrade for a Hard Disconnected account from charter.com
	//HOH user
	//Scripter:Dhruva
	//Date/Version:20-Nov-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD53_Validate_ServiceUpgrade_HardDisconnectedAccount_charterDotCom(Map<String,String> testdata) throws Exception{

		String BasicURL=testdata.get("LegacySiteURL");
		String ACnumber=testdata.get("ACnumber");
		String email=testdata.get("email");
		String Address1=testdata.get("Address1");
		String Address2=testdata.get("Address2");
		String Zipcode=testdata.get("Zipcode");
		String Mobilephone=testdata.get("Mobilephone");
		String firstname=testdata.get("firstname_CID");
		String lastname=testdata.get("lastname_CID");
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		
		BasicAuthenticaion basic=new BasicAuthenticaion(driver);
		HomePage hp = new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage ap = new AuthenticationPage(driver);
		ap.InValidLogin(username, password);
		basic.loadCharterLegacy();
		//basic.dotComLogin(Address1, Address2, Zipcode, ACnumber);
		basic.TVUpgrade_TriplePlay(Address1, Address2, Zipcode, ACnumber,email,Mobilephone,firstname,lastname);
		
	}
	
	//Name: TD54_Validate_TV_Upgrade_NewCustomer_charterDotCom()
	//Description: Verification of buyflow for TV Service Upgrade for new customer
	//HOH user
	//Scripter:Dhruva
	//Date/Version:20-Nov-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD54_Validate_TV_Upgrade_NewCustomer_charterDotCom(Map<String,String> testdata) throws Exception{

		String BasicURL=testdata.get("LegacySiteURL");
		String ACnumber=testdata.get("ACnumber");
		String email=testdata.get("email");
		String Address1=testdata.get("Address1");
		String Address2=testdata.get("Address2");
		String Zipcode=testdata.get("Zipcode");
		String Mobilephone=testdata.get("Mobilephone");
		String fname=testdata.get("firstname_CID");
		String lname=testdata.get("lastname_CID");
		
		BasicAuthenticaion basic=new BasicAuthenticaion(driver);
		basic.loadCharterLegacy();
		//basic.dotComLogin(Address1, Address2, Zipcode, ACnumber);
		basic.TVUpgrade_NewCustomer(Address1, Address2, Zipcode,email,Mobilephone,fname,lname);
		
	}
	
	//Name: TD55_Validate_HardDisconnectedUser_NotAbleToUpgrade_charterDotCom()
	//Description: Verify that disconnected user should not be able to upgrade for any services from charter.com
	//HOH user
	//Scripter:Dhruva
	//Date/Version:10-Dec-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD55_Validate_HardDisconnectedUser_NotAbleToUpgrade_charterDotCom(Map<String,String> testdata) throws Exception{

		String ACnumber=testdata.get("ACnumber");
		String Address1=testdata.get("Address1");
		String Address2=testdata.get("Address2");
		String Zipcode=testdata.get("Zipcode");
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		
		BasicAuthenticaion basic=new BasicAuthenticaion(driver);
		basic.loadCharterLegacy();	
		Assert.assertTrue(basic.TVUpgrade_HardDisconnectUser(Address1, Address2, Zipcode, ACnumber), "Error message for not validating hard Disconnected user is not displayed");
		HomePage hp = new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage ap = new AuthenticationPage(driver);
		ap.InValidLogin(username, password);
	}
	
	//Name: TD56_Validate_SuspendedUser_NotAbleToUpgrade_charterDotCom()
	//Description: Verify that Suspended user should not be able to upgrade for any services from charter.com
	//HOH user
	//Scripter:Dhruva
	//Date/Version:11-Dec-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TD56_Validate_SuspendedUser_NotAbleToUpgrade_charterDotCom(Map<String,String> testdata) throws Exception{

		String ACnumber=testdata.get("ACnumber");
		String Address1=testdata.get("Address1");
		String Address2=testdata.get("Address2");
		String Zipcode=testdata.get("Zipcode");
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		
		BasicAuthenticaion basic=new BasicAuthenticaion(driver);
		basic.loadCharterLegacy();	
		Assert.assertTrue(basic.TVUpgrade_SuspendedUser(Address1, Address2, Zipcode, ACnumber), "Error message for not validating Suspended user is not displayed");
		HomePage hp = new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage ap = new AuthenticationPage(driver);
		ap.InValidLogin(username, password);
	}
	
	@AfterMethod
    public void afterMethod() throws InterruptedException{
           Thread.sleep(2000);
           driver.manage().deleteAllCookies();
           driver.close();
    }
}


