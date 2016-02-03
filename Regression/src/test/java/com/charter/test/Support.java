package com.charter.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.charter.page.HomePage;
import com.charter.page.InternetSupportPage;
import com.charter.page.MyAccountSupportPage;
import com.charter.page.SupportPage;
import com.charter.page.TVSupportPage;
import com.charter.page.VoiceSupportPage;
import com.charter.utils.Constants;
import com.charter.utils.DataProviderClass;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.TestNGBase;

public class Support extends TestNGBase {
	private String URL= Constants.URL;
	
	
		//Name: TS01_Validate_TV_Voice_Internet_MyAccount_Links_SupportOverview()
		//Description: Validate the presence of Support Articles on Support Overview page
		//Standard user
		//Scripter:Dhruva
		//Date/Version:18-Jun-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TS01_Validate_TV_Voice_Internet_MyAccount_Links_SupportOverview(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			SupportPage sp=new SupportPage(driver);
			sp.SupportTab();
			Assert.assertTrue(sp.SupportArticles(), "Support Articles are not available");
			hp.logoutApplication();
		}

		//Name: TS02_Validate_SupportPage_AskCharterWidget_HOHUser()
		//Description:Validate Ask Charter widget in Support Overview page 
		//HOH User
		//Scripter:Dhruva
		//Date/Version:18-Jun-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TS02_Validate_SupportPage_AskCharterWidget_HOHUser(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			SupportPage sp=new SupportPage(driver);
			sp.SupportTab();
			Assert.assertTrue(sp.AskCharter_TV(),"Ask Charter Header in Support Overview Page is - Not Present");
			Assert.assertTrue(sp.Askbutton_TV(),"Ask button in Support Overview Page is -Not Present");
			hp.logoutApplication();
		}
		
		//Name: TS03_Validate_TVSupport_ArticleLinks()
		//Description: Validate the TV Support Articles page
		//Standard user
		//Scripter:Dhruva
		//Date/Version:18-Jun-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TS03_Validate_TVSupport_ArticleLinks(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			SupportPage sp=new SupportPage(driver);
			sp.SupportTab();
			Assert.assertTrue(sp.TVSupport_Article(), "TV Support Articles are not available");
			//hp.logoutApplication();
		}
		
		//Name: TS04_Validate_VoiceSupport_ArticleLinks()
		//Description: Validate the Voice Support Articles page
		//Standard user
		//Scripter:Dhruva
		//Date/Version:19-Jun-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TS04_Validate_VoiceSupport_ArticleLinks(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			SupportPage sp=new SupportPage(driver);
			sp.SupportTab();
			Assert.assertTrue(sp.VoiceSupport_Article(), "Voice Support Articles are not available");
			//hp.logoutApplication();
		}
		
		//Name: TS05_Validate_InternetSupport_ArticleLinks()
		//Description: Validate the Internet Support Articles page
		//Standard user
		//Scripter:Dhruva
		//Date/Version:19-Jun-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TS05_Validate_InternetSupport_ArticleLinks(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			SupportPage sp=new SupportPage(driver);
			sp.SupportTab();
			Assert.assertTrue(sp.InternetSupport_Article(), "Internet Support Articles are not available");
			//hp.logoutApplication();
		}
		
		//Name: TS06_Validate_MyAccountSupport_ArticleLinks()
		//Description: Validate the My Account Support Articles page
		//Standard user
		//Scripter:Dhruva
		//Date/Version:19-Jun-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TS06_Validate_MyAccountSupport_ArticleLinks(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			SupportPage sp=new SupportPage(driver);
			sp.SupportTab();
			Assert.assertTrue(sp.MyAccountSupport_Article(), "My Account Support Articles are not available");
			//hp.logoutApplication();
		}
		
		//Name: TS07_Validate_SupportVideo_browsing()
		//Description: Validate the Support Videos browsing on Support Overview page
		//Standard user
		//Scripter:Dhruva
		//Date/Version:22-Jun-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TS07_Validate_SupportVideo_browsing(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			SupportPage sp=new SupportPage(driver);
			sp.SupportTab();
			Assert.assertTrue(sp.BrowseSupportVideos(), "Support videos cannot be browsed");
			hp.logoutApplication();
		}
		
		//Name: TS08_Validate_TVSupportPage_AskCharterWidget_HOHUser()
		//Description:Validate Ask Charter widget in Support Overview page 
		//HOH User
		//Scripter:Dhruva
		//Date/Version:22-Jun-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TS08_Validate_TVSupportPage_AskCharterWidget_HOHUser(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			TVSupportPage tvsp=new TVSupportPage(driver);
			tvsp.SupportTVTab();
			SupportPage sp=new SupportPage(driver);
			Assert.assertTrue(sp.AskCharter_TV(),"Ask Charter Header in TV Support Page is - Not Present");
			Assert.assertTrue(sp.Askbutton_TV(),"Ask button in TV Support Page is -Not Present");
			hp.logoutApplication();
		}
		
		//Name: TS09_Validate_TVSupportVideo_browsing()
		//Description: Validate the Support Videos browsing on TV Support page
		//Standard user
		//Scripter:Dhruva
		//Date/Version:22-Jun-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TS09_Validate_TVSupportVideo_browsing(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			TVSupportPage tvsp=new TVSupportPage(driver);
			tvsp.SupportTVTab();
			SupportPage sp=new SupportPage(driver);
			Assert.assertTrue(sp.BrowseSupportVideos(), "Support videos cannot be browsed");
			hp.logoutApplication();
		}
		
		//Name: TS10_Validate_TVSupport_CharterTVServiceLink()
		//Description: Validate navigating to the respective pages by clicking links under Charter TV service in TV Support page
		//Standard user
		//Scripter:Dhruva
		//Date/Version:23-Jun-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TS10_Validate_TVSupport_CharterTVServiceLink(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			TVSupportPage tvsp=new TVSupportPage(driver);
			tvsp.SupportTVTab();
			Assert.assertTrue(tvsp.CharterTVService(), "Charter TV Service Support page cannot be opened");
			hp.logoutApplication();
		}
		
		//Name: TS11_Validate_TVSupport_TVEquipmentLink()
		//Description: Validate navigating to the respective pages by clicking links under TV Equipment  in TV support page
		//Standard user
		//Scripter:Dhruva
		//Date/Version:23-Jun-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TS11_Validate_TVSupport_TVEquipmentLink(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			TVSupportPage tvsp=new TVSupportPage(driver);
			tvsp.SupportTVTab();
			Assert.assertTrue(tvsp.TVEquipment(), "Charter TV Equipment Support page cannot be opened");
			hp.logoutApplication();
		}
		
		//Name: TS12_Validate_TVSupport_TVEquipmentLink()
		//Description: Validate navigating to the respective pages by clicking links under TV Online  in TV support page
		//Standard user
		//Scripter:Dhruva
		//Date/Version:23-Jun-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TS12_Validate_TVSupport_TVOnlineLink(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			TVSupportPage tvsp=new TVSupportPage(driver);
			tvsp.SupportTVTab();
			Assert.assertTrue(tvsp.TVOnline(), "Charter TV Online Support page cannot be opened");
			hp.logoutApplication();
		}
		
		//Name: TS13_Validate_TVSupport_ProgramGuidesLink()
		//Description: Validate navigating to the respective pages by clicking links under Program guides  in TV support page
		//Standard user
		//Scripter:Dhruva
		//Date/Version:23-Jun-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TS13_Validate_TVSupport_ProgramGuidesLink(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			TVSupportPage tvsp=new TVSupportPage(driver);
			tvsp.SupportTVTab();
			Assert.assertTrue(tvsp.ProgramGuides(), "Charter TV ProgramGuides Support page cannot be opened");
			hp.logoutApplication();
		}
		
		//Name: TS14_Validate_TVSupport_HDLink()
		//Description: Validate navigating to the respective pages by clicking links under HD  in TV support page
		//Standard user
		//Scripter:Dhruva
		//Date/Version:23-Jun-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TS14_Validate_TVSupport_HDLink(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			TVSupportPage tvsp=new TVSupportPage(driver);
			tvsp.SupportTVTab();
			Assert.assertTrue(tvsp.HD(), "Charter TV HD Support page cannot be opened");
			hp.logoutApplication();
		}
		
		//Name: TS15_Validate_TVSupport_PayPerViewLink()
		//Description: Validate navigating to the respective pages by clicking links under On Demand/Pay-per-view   in TV support page
		//Standard user
		//Scripter:Dhruva
		//Date/Version:23-Jun-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TS15_Validate_TVSupport_PayPerViewLink(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			TVSupportPage tvsp=new TVSupportPage(driver);
			tvsp.SupportTVTab();
			Assert.assertTrue(tvsp.PayPerView(), "Charter TV PayPerView Support page cannot be opened");
			hp.logoutApplication();
		}
		
		//Name: TS16_Validate_TVSupport_TroubleshootingLink()
		//Description: Validate navigating to the respective pages by clicking links under Troubleshooting  in TV support page
		//Standard user
		//Scripter:Dhruva
		//Date/Version:23-Jun-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TS16_Validate_TVSupport_TroubleshootingLink(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			TVSupportPage tvsp=new TVSupportPage(driver);
			tvsp.SupportTVTab();
			Assert.assertTrue(tvsp.Troubleshooting(), "Charter TV Troubleshooting Support page cannot be opened");
			hp.logoutApplication();
		}
		
		//Name: TS17_Validate_SupportInternetPage_AskCharterWidget_HOHUser()
		//Description:Validate Ask Spectrum Widget in Support Internet page 
		//HOH User
		//Scripter:Dhruva
		//Date/Version:24-Jun-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TS17_Validate_SupportInternetPage_AskCharterWidget_HOHUser(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			InternetSupportPage isp=new InternetSupportPage(driver);
			isp.SupportInternetTab();
			SupportPage sp = new SupportPage(driver);
			Assert.assertTrue(sp.AskCharter_TV(),"Ask Charter Header in Internet Support Page is - Not Present");
			Assert.assertTrue(sp.Askbutton_TV(),"Ask button in Internet Support Page is -Not Present");
			hp.logoutApplication();
		}
		
		//Name: TS18_Validate_SupportInternetVideo_browsing()
		//Description: Validate whether the user is able to browse the videos in Internet support videos panel on clicking left and right arrows in Internet Support page
		//Standard user
		//Scripter:Dhruva
		//Date/Version:24-Jun-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TS18_Validate_SupportInternetVideo_browsing(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			InternetSupportPage isp=new InternetSupportPage(driver);
			isp.SupportInternetTab();
			SupportPage sp=new SupportPage(driver);
			Assert.assertTrue(sp.BrowseSupportVideos(), "Support videos cannot be browsed");
			hp.logoutApplication();
		}
		
		//Name: TS19_Validate_InternetSupport_CharterDotNetLink()
		//Description: Validate navigating to the respective pages by clicking links under charter.net  in Internet  support page
		//Standard user
		//Scripter:Dhruva
		//Date/Version:24-Jun-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TS19_Validate_InternetSupport_CharterDotNetLink(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			InternetSupportPage isp=new InternetSupportPage(driver);
			isp.SupportInternetTab();
			Assert.assertTrue(isp.CharterDotNet(), "Charter.net Support page cannot be opened");
			hp.logoutApplication();
		}
		
		//Name: TS20_Validate_InternetSupport_InternetEquipmentLink()
		//Description: Validate navigating to the respective pages by clicking links under Internet Equipment  in Internet  support page
		//Standard user
		//Scripter:Dhruva
		//Date/Version:24-Jun-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TS20_Validate_InternetSupport_InternetEquipmentLink(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			InternetSupportPage isp=new InternetSupportPage(driver);
			isp.SupportInternetTab();
			Assert.assertTrue(isp.InternetEquipment(), "Internet Equipment Support page cannot be opened");
			hp.logoutApplication();
		}
		
		//Name: TS21_Validate_InternetSupport_EmailLink()
		//Description: Validate navigating to the respective pages by clicking links under Email in Internet  support page
		//Standard user
		//Scripter:Dhruva
		//Date/Version:24-Jun-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TS21_Validate_InternetSupport_EmailLink(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			InternetSupportPage isp=new InternetSupportPage(driver);
			isp.SupportInternetTab();
			Assert.assertTrue(isp.Email(), "Email Support page cannot be opened");
			hp.logoutApplication();
		}
		
		//Name: TS22_Validate_InternetSupport_SecuritySuiteLink()
		//Description: Validate navigating to the respective pages by clicking links under Security suite  in Internet  support page
		//Standard user
		//Scripter:Dhruva
		//Date/Version:24-Jun-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TS22_Validate_InternetSupport_SecuritySuiteLink(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			InternetSupportPage isp=new InternetSupportPage(driver);
			isp.SupportInternetTab();
			Assert.assertTrue(isp.SecuritySuite(), "Security Suite Support page cannot be opened");
			hp.logoutApplication();
		}
		
		//Name: TS23_Validate_InternetSupport_InstallationLink()
		//Description: Validate navigating to the respective pages by clicking links under Installation  in Internet  support page
		//Standard user
		//Scripter:Dhruva
		//Date/Version:24-Jun-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TS23_Validate_InternetSupport_InstallationLink(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			InternetSupportPage isp=new InternetSupportPage(driver);
			isp.SupportInternetTab();
			Assert.assertTrue(isp.Installation(), "Installation Support page cannot be opened");
			hp.logoutApplication();
		}
		
		//Name: TS24_Validate_InternetSupport_NetworkingLink()
		//Description: Validate navigating to the respective pages by clicking links under Networking/Wireless  in Internet  support page
		//Standard user
		//Scripter:Dhruva
		//Date/Version:24-Jun-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TS24_Validate_InternetSupport_NetworkingLink(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			InternetSupportPage isp=new InternetSupportPage(driver);
			isp.SupportInternetTab();
			Assert.assertTrue(isp.Networking(), "Networking Support page cannot be opened");
			hp.logoutApplication();
		}
		
		//Name: TS25_Validate_InternetSupport_OnlineSecurityLink()
		//Description: Validate navigating to the respective pages by clicking links under Online Security  in Internet  support page
		//Standard user
		//Scripter:Dhruva
		//Date/Version:24-Jun-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TS25_Validate_InternetSupport_OnlineSecurityLink(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			InternetSupportPage isp=new InternetSupportPage(driver);
			isp.SupportInternetTab();
			Assert.assertTrue(isp.OnlineSecurity(), "Online Security Support page cannot be opened");
			hp.logoutApplication();
		}
		
		//Name: TS26_Validate_InternetSupport_TroubleshootingLink()
		//Description: Validate navigating to the respective pages by clicking links under Troubleshooting  in Internet  support page
		//Standard user
		//Scripter:Dhruva
		//Date/Version:24-Jun-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TS26_Validate_InternetSupport_TroubleshootingLink(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			InternetSupportPage isp=new InternetSupportPage(driver);
			isp.SupportInternetTab();
			Assert.assertTrue(isp.Troubleshooting(), "Troubleshooting Support page cannot be opened");
			hp.logoutApplication();
		}
		
		//Name: TS27_Validate_InternetSupport_TVOnlineLink()
		//Description: Validate navigating to the respective pages by clicking links under TV Online   in Internet  support page
		//Standard user
		//Scripter:Dhruva
		//Date/Version:24-Jun-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TS27_Validate_InternetSupport_TVOnlineLink(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			InternetSupportPage isp=new InternetSupportPage(driver);
			isp.SupportInternetTab();
			Assert.assertTrue(isp.TVOnline(), "TV Online Support page cannot be opened");
			hp.logoutApplication();
		}
		
		//Name: TS28_Validate_InternetSupport_WifiLink()
		//Description: Validate navigating to the respective pages by clicking links under wireless/wifi  in Internet  support page
		//Standard user
		//Scripter:Dhruva
		//Date/Version:24-Jun-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TS28_Validate_InternetSupport_WifiLink(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			InternetSupportPage isp=new InternetSupportPage(driver);
			isp.SupportInternetTab();
			Assert.assertTrue(isp.Wifi(), "Wifi Support page cannot be opened");
			hp.logoutApplication();
		}
		
		//Name: TS29_Validate_VoiceSupportPage_AskCharterWidget_HOHUser()
		//Description: Validate Ask Spectrum Widget in Voice support page
		//HOH user
		//Scripter:Dhruva
		//Date/Version:1-Jul-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TS29_Validate_VoiceSupportPage_AskCharterWidget_HOHUser(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			VoiceSupportPage vsp=new VoiceSupportPage(driver);
			vsp.SupportVoiceTab();
			SupportPage sp = new SupportPage(driver);
			Assert.assertTrue(sp.AskCharter_TV(),"Ask Charter Header in Voice Support Page is - Not Present");
			Assert.assertTrue(sp.Askbutton_TV(),"Ask button in Voice Support Page is -Not Present");
			hp.logoutApplication();
		}
		
		//Name: TS30_Validate_VoiceSupport_FeaturesLink()
		//Description: Validate navigating to the respective pages by clicking links under Features in Voice support page
		//Standard user
		//Scripter:Dhruva
		//Date/Version:1-Jul-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TS30_Validate_VoiceSupport_FeaturesLink(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			VoiceSupportPage vsp=new VoiceSupportPage(driver);
			vsp.SupportVoiceTab();
			Assert.assertTrue(vsp.Features(), "Features Support page cannot be opened");
			hp.logoutApplication();
		}
		
		//Name: TS31_Validate_VoiceSupport_VoiceEquipmentLink()
		//Description: Validate navigating to the respective pages by clicking links under Voice Equipment in Voice support page
		//Standard user
		//Scripter:Dhruva
		//Date/Version:1-Jul-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TS31_Validate_VoiceSupport_VoiceEquipmentLink(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			VoiceSupportPage vsp=new VoiceSupportPage(driver);
			vsp.SupportVoiceTab();
			Assert.assertTrue(vsp.VoiceEquipment(), "Voice Equipment Support page cannot be opened");
			//hp.logoutApplication();
		}
		
		//Name: TS32_Validate_VoiceSupport_InternationalCallingLink()
		//Description: Validate navigating to the respective pages by clicking links under International calling  in Voice support page
		//Standard user
		//Scripter:Dhruva
		//Date/Version:1-Jul-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TS32_Validate_VoiceSupport_InternationalCallingLink(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			VoiceSupportPage vsp=new VoiceSupportPage(driver);
			vsp.SupportVoiceTab();
			Assert.assertTrue(vsp.InternationalCalling(), "International Calling Support page cannot be opened");
			hp.logoutApplication();
		}
		
		//Name: TS33_Validate_VoiceSupport_TroubleshootingLink()
		//Description: Validate navigating to the respective pages by clicking links under Troubleshooting  in Voice support page
		//Standard user
		//Scripter:Dhruva
		//Date/Version:1-Jul-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TS33_Validate_VoiceSupport_TroubleshootingLink(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			VoiceSupportPage vsp=new VoiceSupportPage(driver);
			vsp.SupportVoiceTab();
			Assert.assertTrue(vsp.Troubleshooting(), "Troubleshooting Support page cannot be opened");
			hp.logoutApplication();
		}
		
		//Name: TS34_Validate_MyAccountSupportPage_AskCharterWidget_HOHUser()
		//Description: Validate Ask Spectrum Widget in Support My Account page
		//HOH user
		//Scripter:Dhruva
		//Date/Version:1-Jul-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TS34_Validate_MyAccountSupportPage_AskCharterWidget_HOHUser(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			MyAccountSupportPage msp=new MyAccountSupportPage(driver);
			msp.SupportMyAccountTab();
			SupportPage sp = new SupportPage(driver);
			Assert.assertTrue(sp.AskCharter_TV(),"Ask Charter Header in My Account Support Page is - Not Present");
			Assert.assertTrue(sp.Askbutton_TV(),"Ask button in My Account Support Page is -Not Present");
			hp.logoutApplication();
		}
		
		//Name: TS35_Validate_MyAccountSupport_MyAccountLink()
		//Description: Validate navigating to the respective pages by clicking links under My Account in My Account support page
		//Standard user
		//Scripter:Dhruva
		//Date/Version:1-Jul-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TS35_Validate_MyAccountSupport_MyAccountLink(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			MyAccountSupportPage msp=new MyAccountSupportPage(driver);
			msp.SupportMyAccountTab();
			Assert.assertTrue(msp.MyAccount(), "MyAccount Support page cannot be opened");
			hp.logoutApplication();
		}
		
		//Name: TS36_Validate_MyAccountSupport_BillingLink()
		//Description: Validate navigating to the respective pages by clicking links under Billing in My Account support page
		//Standard user
		//Scripter:Dhruva
		//Date/Version:1-Jul-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TS36_Validate_MyAccountSupport_BillingLink(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			MyAccountSupportPage msp=new MyAccountSupportPage(driver);
			msp.SupportMyAccountTab();
			Assert.assertTrue(msp.Billing(), "Billing Support page cannot be opened");
			hp.logoutApplication();
		}
		
		//Name: TV37_Validate_SupportOverview_Search()
		//Description: Validate whether user is able to search a topic and find the results refined into Watch Online, Watch TV Support and Google search on Support Overview page
		//Standard user
		//Scripter:Dhruva
		//Date/Version:27-Jul-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TV37_Validate_SupportOverview_Search(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			SupportPage sp = new SupportPage(driver);
			sp.SupportTab();
			Assert.assertTrue(sp.checkSearchSections(), "Search results do not contain different sections");
			hp.logoutApplication();
		}
		
		//Name: TV38_Validate_SupportOverview_WatchOnline_SearchResults()
		//Description: Validate whether user is able to search a topic and view all the Watch Online results on Support Overview page
		//Standard user
		//Scripter:Dhruva
		//Date/Version:27-Jul-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TV38_Validate_SupportOverview_WatchOnline_SearchResults(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			SupportPage sp = new SupportPage(driver);
			sp.SupportTab();
			Assert.assertTrue(sp.WatchOnlineResults_ViewAll(), "Watch Online results list is not displayed");
			hp.logoutApplication();
		}
		
		//Name: TV39_Validate_SupportOverview_WatchOnTV_SearchResults()
		//Description: Validate whether user is able to search a topic and view all the Watch TV results on Support Overview page
		//Standard user
		//Scripter:Dhruva
		//Date/Version:28-Jul-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TV39_Validate_SupportOverview_WatchOnTV_SearchResults(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			SupportPage sp = new SupportPage(driver);
			sp.SupportTab();
			Assert.assertTrue(sp.WatchOnTVResults_ViewAll(), "Watch On TV results list is not displayed");
			hp.logoutApplication();
		}
		
		//Name: TV40_Validate_SupportOverview_Support_SearchResults()
		//Description: Validate whether user is able to search a topic and view all the Support results on Support Overview page
		//Standard user
		//Scripter:Dhruva
		//Date/Version:28-Jul-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TV40_Validate_SupportOverview_Support_SearchResults(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			SupportPage sp = new SupportPage(driver);
			sp.SupportTab();
			Assert.assertTrue(sp.SupportResults_ViewAll(), "Support results list is not displayed");
			hp.logoutApplication();
		}
		
		//Name: TV41_Validate_SupportOverview_Google_SearchResults()
		//Description: Validate whether user is able to search a topic and view all the Google search results on Support Overview page
		//Standard user
		//Scripter:Dhruva
		//Date/Version:28-Jul-15
		@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void TV41_Validate_SupportOverview_Google_SearchResults(Map<String,String> testdata) throws Exception {

			String username = testdata.get("UserID");
			String password = testdata.get("UserPassword");
			HomePage hp=new HomePage(driver);
			hp.loadCharterPage(URL);
			hp.login(username, password);
			SupportPage sp = new SupportPage(driver);
			sp.SupportTab();
			Assert.assertTrue(sp.GoogleResults_ViewAll(), "Google results list is not displayed");
			hp.logoutApplication();
		}
		
		@AfterMethod
		public void afterMethod() throws InterruptedException{
			Thread.sleep(4000);
			driver.manage().deleteAllCookies();
			driver.close();
		}
}
