package com.charter.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

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

	//Name: TD06_Validate_MyServicesPage_UpdateMACAddress_AndMessage()
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
		Assert.assertTrue(VP.CharterPhoneLink(), "User with Charter Phone Link -Not Navigated to Phone Online Manager Page");
	    //driver.close();
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

	@AfterMethod
    public void afterMethod() throws InterruptedException{
           Thread.sleep(2000);
           driver.manage().deleteAllCookies();
           driver.close();
    }
}


