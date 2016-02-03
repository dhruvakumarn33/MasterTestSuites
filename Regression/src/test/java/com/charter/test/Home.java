package com.charter.test;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.charter.page.HomePage;
import com.charter.page.SupportPage;
import com.charter.utils.Constants;
import com.charter.utils.DataProviderClass;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.TestNGBase;

public class Home extends TestNGBase{
		private String URL= Constants.URL;

	//Name: TH01_Validate_PaybillLink_NavigateTo_BillPage_HOHuser()
	//Description: Verify weather the HOH user is able to navigate by 'Pay Bill' link option to Bill page
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:29-Dec-14
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)

	public void TH01_Validate_PaybillLink_NavigateTo_BillPage_HOHuser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		Assert.assertTrue(hp.paybill_link(), "User is not able to navigate to billing page with pay bill link ");
	}

	//Name: TH02_Validate_ViewStatementLink_NavigateTo_StatementPage_HOHUser()
	//Description: Verify weather the HOH user is able to navigate by 'View Statement' link option to Statement Page
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:29-Dec-14
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TH02_Validate_ViewStatementLink_NavigateTo_StatementPage_HOHUser(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		Assert.assertTrue(hp.viewstatement_link(), "Statement summary section- Not present ");
		hp.logoutApplication();
	}

	//Name: TH03_Validate_TVGuideLink_NavigateTo_GuidePage_StandardUser()
	//Description: Verify weather the Standard user is able to navigate by 'TV Guide' link option to Guide page
	//Standard User
	//Scripter:Lakshmi
	//Date/Version:29-Dec-14
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TH03_Validate_TVGuideLink_NavigateTo_GuidePage_StandardUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		Assert.assertTrue(hp.TvGuide_link(), "User is not able to navigate to guide page with TV Guide link");

	}

	//Name: TH04_Validate_OnDemandLink_NavigateTo_OnDemandPage_StandardUser()
	//Description: Verify weather the Standard user is able to navigate by 'On Demand' link option to OnDemand page
	//Standard User
	//Scripter:Lakshmi
	//Date/Version:29-Dec-14
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TH04_Validate_OnDemandLink_NavigateTo_OnDemandPage_StandardUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		Assert.assertTrue(hp.Ondemand_link(), "User is not able to navigate to Demand page with On Demand link");
		hp.logoutApplication();
	}

	//Name: TH05_Validate_GetSupportLink_NavigateTo_GetSupportPage_HOHuser()
	//Description: Verify weather the HOH and Standard user is able to navigate by 'Get Support' link option to support article page
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:29-Dec-14
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TH05_Validate_GetSupportLink_NavigateTo_GetSupportPage_HOHuser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);	
		Assert.assertTrue(hp.AskSpectrum(), "User is not able to navigate to Ask Spectrum page in other wincdow");
		hp.logoutApplication();
	}	

	//Name: TH06_Validate_FindACharterStoreLink_NavigateTo_LocationPage_HOHuser()
	//Description: Verify weather the HOH and Standard user is able to navigate by 'Find a Charter Store' link option to Charter Location
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:29-Dec-14
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TH06_Validate_FindACharterStoreLink_NavigateTo_LocationPage_HOHuser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);	
		Assert.assertTrue(hp.FindCharterStore(), "User is not able to navigate to Charter Locaton with Find a Charter Store link");;
		hp.logoutApplication();
	}

	//Name: TH07_Validate_WatchAnywhere_LiveTVTab_HOHuser()
	//Description: Verify Watch Anywhere option - Tab Live TV for HOH and Standard user
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:29-Dec-14
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TH07_Validate_WatchAnywhere_LiveTVTab_HOHuser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String WAoptionText="Watch Anywhere";
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);	
		Assert.assertTrue(hp.LiveTV_Tab(), "User is not able to verify Watch Anywhere option Live TV Tab");
		verifyAssert(hp.WatchAnywhereOption(),WAoptionText,"Watch Anywhere Option for Live TV Tab");

	}

	//Name: TH08_Validate_WatchAnywhere_OnDemandTab_HOHuser()
	//Description: Verify Watch Anywhere option - Tab On Demand for HOH and Standard user
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:29-Dec-14
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TH08_Validate_WatchAnywhere_OnDemandTab_HOHuser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String WAoptionText="Watch Anywhere";
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		Assert.assertTrue(hp.OnDemand_Tab(), "User is not able to verify Watch Anywhere option -Tab On Demand ");
		verifyAssert(hp.WatchAnywhereOption(),WAoptionText,"Watch Anywhere Option for OnDemand Tab");
		hp.logoutApplication();
	}

	//Name: TH09_Validate_WatchAnywhere_NetworkTab_HOHuser()
	//Description: Verify Watch Anywhere option - Tab Network for HOH and Standard user
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:29-Dec-14
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TH09_Validate_WatchAnywhere_NetworkTab_HOHuser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String WAoptionText="Watch Anywhere";

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		Assert.assertTrue(hp.Networks_Tab(), "User is not able to verify Watch Anywhere option -Tab Network ");
		verifyAssert(hp.WatchAnywhereOption(),WAoptionText,"Watch Anywhere Option for OnDemand Tab");
		hp.logoutApplication();

	}

	//Name: TH11_Validate_PrimeTimeTonight_BrowseAll_AllUser()
	//Description: Verify PrimeTime Tonight option - Browse All page option for HOH and Standard user
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:30-Dec-14
	//Comments: Browse All link at Prime Time tonight is taken out of the home page in Application
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TH11_Validate_PrimeTimeTonight_BrowseAll_AllUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		Assert.assertTrue(hp.PrimeTimeOption(), "PrimeTime Tonight is Not Present _Failed");
		//	hp.PrimeTimeTN();
		hp.logoutApplication();
	}

	//Name: TH12_Validate_HomePage_EmailIcon_HOHuser()
	//Description: Home page verify icon for Email for HOH and Standard user
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:30-Dec-14
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TH12_Validate_HomePage_EmailIcon_HOHuser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		Assert.assertTrue(hp.Emailicon_Homepage(), "User is not able to verify Email icon in home page");
	}

	//Name: TH13_Validate_HomePage_VoicemailIcon_HOHuser()
	//Description: Home page verify icon for Voice mail for HOH and Standard user
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:30-Dec-14
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TH13_Validate_HomePage_VoicemailIcon_HOHuser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		Assert.assertTrue(hp.Voicemailicon_Homepage(), "User is not able view Voice mail icon in Home page");
	}

	//Name: TH14_Validate_HomePage_InAndOutHomeIndicator_HOHuser()
	//Description: Home page verify icon for In-home and Out-of-home indicator for HOH and Standard user
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:30-Dec-14
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TH14_Validate_HomePage_InAndOutHomeIndicator_HOHuser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		hp.HomeNetworkbutton();
	}

	//Name: TH15_Validate_HomePage_UserPreferenceIcon_HOHuser()
	//Description: Home page verify icon for User preference for HOH and Standard user
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:30-Dec-14
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TH15_Validate_HomePage_UserPreferenceIcon_HOHuser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		hp.UserPreferences();
		hp.logoutApplication();
	}

	//Name: TH16_Validate_HomePage_SignOutIcon_HOHuser()
	//Description:Home page verify icon for Sign-out for HOH and Standard user
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:30-Dec-14
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TH16_Validate_HomePage_SignOutIcon_HOHuser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		hp.logoutApplication();
	}

	//Name: TH17_Validate_WatchTV_NavigateTo_WatchTVOverviewPage_HOHUser()
	//Description:Home page verify Global navigation for Watch TV navigate to Watch TV Overview Page for HOH and Standard user
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:30-Dec-14
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TH17_Validate_WatchTV_NavigateTo_WatchTVOverviewPage_HOHUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		hp.WatchTVtab();	
		hp.logoutApplication();
	}

	//Name: TH18_Validate_MyAccount_NavigateTo_OverviewPage_HOHUser()
	//Description:Home page verify Global navigation for My Account navigate to Overview Page for HOH and Standard user
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:30-Dec-14
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TH18_Validate_MyAccount_NavigateTo_OverviewPage_HOHUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		hp.MyAccounttab();
		hp.logoutApplication();
	}

	//Name: TH19_Validate_Support_NavigateTo_SupportPage_HOHUser()
	//Description:Home page verify Global navigation for Support navigate to Support Page for HOH and Standard user
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:30-Dec-14
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TH19_Validate_Support_NavigateTo_SupportPage_HOHUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		hp.SupportTab();
		hp.logoutApplication();
	}

	//Name: TH20_Validate_HomePage_StaticBanner_HOHuser()
	//Description:Verify click on Static Banner to support article page as appropately (if Rotating banner is not enabled)
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:30-Dec-14
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TH20_Validate_HomePage_StaticBanner_HOHuser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		hp.StaticBanner();
		hp.logoutApplication();
	}

	//Name: TH22_Validate_HomePage_Without_Login()
	//Description:Veirfy Home screen without logging into charter.net
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:30-Dec-14
	@Test
	public void TH22_Validate_HomePage_Without_Login() throws Exception {

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		Assert.assertTrue(hp.Searchbar(), "Search bar is not present in the Home page without logging in to the application");
	}
	
	//Name: TH23_CL20_Validate_search_withoutLogin()
	//Description:Validate search functionality without logging in as a user
	//HOH User
	//Scripter:Dhruva
	//Date/Version:05-Aug-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TH23_CL20_Validate_search_withoutLogin(Map<String,String> testdata) throws Exception {
		
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		SupportPage sp = new SupportPage(driver);
		sp.checkSearchSections();
		hp.login(username, password);
		Assert.assertTrue(sp.ghostSearchText(), "Search bar doesnot have Ghost text as SEARCH");
		hp.logoutApplication();
	}
	
	//Name: TH24_CL20_Validate_predictive_searchDropdown()
	//Description:Validate whether the user is able to view the predictive search dropdown in as in the order Watch Online, Watch On TV, Support on Entering the Search Keyword 
	//HOH User
	//Scripter:Dhruva
	//Date/Version:05-Aug-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TH24_CL20_Validate_predictive_searchDropdown(Map<String,String> testdata) throws Exception {
		
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		SupportPage sp = new SupportPage(driver);		
		Assert.assertTrue(sp.SearchDropdown(), "Predictive search dropdown is not displayed");
		hp.logoutApplication();
	}
	
	//Name: TH25_Validate_PayBill_Guide_AskSpectrum_LocationLinks_HOH()
	//Description:Verify whether user is able to view and manage Pay Bill/Guide button.
	//HOH User
	//Scripter:Dhruva
	//Date/Version:19-Aug-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TH25_Validate_PayBill_Guide_AskSpectrum_LocationLinks_HOH(Map<String,String> testdata) throws Exception {
		
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);		
		Assert.assertTrue(hp.TvGuide_link(), "user cannot navigate to Guide page");
		hp.goToHome(URL);
		Assert.assertTrue(hp.AutoPayLink(), "user cannot navigate to AutoPay page");
		hp.goToHome(URL);
		Assert.assertTrue(hp.AskSpectrum(), "user cannot navigate to Ask Spectrum page");
		hp.goToHome(URL);
		Assert.assertTrue(hp.FindCharterStore(), "user cannot navigate to location page");
		hp.logoutApplication();
	}
	
	//Name: TH26_Validate_PayBill_userNotAuthenticated()
	//Description:Verify whether user is able to view and manage Pay Bill/Guide button.
	//HOH User
	//Scripter:Dhruva
	//Date/Version:19-Aug-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TH26_Validate_PayBill_userNotAuthenticated(Map<String,String> testdata) throws Exception {
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);		
		hp.paybillLink_unauthenticated();
	}

	//Name: TH27_Validate_WatchAnywhere_OnDemand_ManageAssets()
	//Description:Verify whether user is able to view and manage On Demand 
	//HOH User
	//Scripter:Dhruva
	//Date/Version:20-Aug-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TH27_Validate_WatchAnywhere_OnDemand_ManageAssets(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);	
		hp.login(username, password);
		hp.OnDemand_Tab();
		hp.PrimeTimeTN();
		//hp.loadCharterPage(URL);
		//hp.login(username, password);
		hp.recommendations();
		hp.WatchAnywhereOD();
		
		hp.logoutApplication();
	}
	
	//Name: TH28_Validate_RememberMeCheckBox()
	//Description:Verify whether The username is saved in cookies when user selects Remember Me checkbox
	//HOH User
	//Scripter:Dhruva
	//Date/Version:15-Oct-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TH28_Validate_RememberMeCheckBox(Map<String,String> testdata) throws Exception {
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);		
		
	}
	
	@AfterMethod
	public void afterMethod() throws InterruptedException{
		Thread.sleep(10000);
		driver.manage().deleteAllCookies();
		driver.close();
	}
}
