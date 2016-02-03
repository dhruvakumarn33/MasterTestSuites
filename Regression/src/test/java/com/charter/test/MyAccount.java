package com.charter.test;

import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.charter.page.AuthenticationPage;
import com.charter.page.BTPage1;
import com.charter.page.BillingAndTransactionsPage;
import com.charter.page.EmailPage;
import com.charter.page.HomePage;
import com.charter.page.InternetServicesPage;
import com.charter.page.MyAccountPage;
import com.charter.page.OverviewPage;
import com.charter.page.TVServicesPage;
import com.charter.page.UserPreferencePage;
import com.charter.page.VoiceServicesPage;
import com.charter.page.WatchTVPage;
import com.charter.page.UserPreferencePage.userType;
import com.charter.utils.Constants;
import com.charter.utils.DataProviderClass;
import com.cognizant.framework.core.CaptureScreenshot;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.TestNGBase;

public class MyAccount extends TestNGBase{
	
	private String URL= Constants.URL;
	
	//Name: TC01_Validate_OverviewPageHeaders_HOHUser()
	//Description: Validate navigating to My Account Overview page and verify all the links,headers in overview page
	//HOH User
	//Scripter:Ramana
	//Date/Version:10/05/2015
	//Pre-requisite:Provision the triple play account in legacy through Sigma/CSG from East Time Zone SysPrin
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC01_Validate_OverviewPageHeaders_HOHUser(Map<String,String> testdata) throws Exception {
		//Retrieving the username and password values
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		//Opening the browser
		HomePage hp=new HomePage(driver);
		//Open charter.net url
		hp.loadCharterPage(URL);
		//Entering username and password
		hp.login(username, password);
		//Navigate to overview page
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.loadOverviewPage();
		OverviewPage OVPage1=new OverviewPage(driver);
		//Validate the billing data in overview page
		verifyAssert(OVPage1.BTSectionText(),"Billing","BTSection");
		OVPage1.BTdata();
		OVPage1.Billsection();
		//Clicking on view bill details link
		OVPage1.viewbilllink();
		//Validating autopay status
		OVPage1.AutoPayStatus();
		//validate ask charter widget
		OVPage1.askcharterwidget();
		hp.logoutApplication();
	}

	//Name: TC02_Validate_BillingandTransactionSection_HOHUser()
	//Description: Validate Billing and Transactions section in Overview page
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC02_Validate_BillingandTransactionSection_HOHUser(Map<String,String> testdata) throws Exception {	
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.loadOverviewPage();
		OverviewPage OVPage1=new OverviewPage(driver);
		Assert.assertTrue(OVPage1.BTSection(), "Billing and Transaction Section- Not present ");
		hp.logoutApplication();
	}

	//Name: TC03_Validate_AskCharterWidget_HOHUser()
	//Description: Validate Ask Charter Widget in Overview page
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC03_Validate_AskCharterWidget_HOHUser(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		//MA.loadOverviewPage();
		OverviewPage OVPage=new OverviewPage(driver);
		Assert.assertTrue(OVPage.AskCharterSection(), "Ask Charter Section- Not present ");
		hp.logoutApplication();
	}

	//Name: TC04_Validate_ServiceAndEquipmentSection_And_UpgradeRules_TVInternetVoice_HOHUser()
	//Description: Validate Services and Equipment section in Overview page(Validate the upgrade rules for Internet,Voice and TV).
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC04_Validate_ServiceAndEquipmentSection_And_UpgradeRules_TVInternetVoice_HOHUser(Map<String,String> testdata) throws Exception{
		String username = testdata.get("UserID");
		String username1=testdata.get("UserID1");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		//MAPage.loadOverviewPage();
		OverviewPage OVpage=new OverviewPage(driver);
		Assert.assertTrue(OVpage.TV_Internet_UpgradeLink(URL), "User - is Not Navigated to the Tv and Internet Spectrum  Page");
		hp.logoutApplication();
		hp.loadCharterPage(URL);
		hp.login(username1, password );  
		MAPage.openMyAccountTab();
		MAPage.loadOverviewPage();
		Assert.assertTrue(OVpage.Voice_UpgradeLink(), "User - is Not Navigated to the Voice Spectrum Page");

	}

	//Name: TC05_Validate_UserPreferencesSection_HOHUser()
	//Description: Validate Users and Preferences section in Overview page
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC05_Validate_UserPreferencesSection_HOHUser(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.loadOverviewPage();
		OverviewPage OVPage1=new OverviewPage(driver);
		Assert.assertTrue(OVPage1.UPSection(), "User Preferences Section- Not Present");
		hp.logoutApplication();
	}

	//Name: TC07_Validate_BillingandTransaction_Helpicon()
	//Description: Validate the help icon for Billing and Transactions section in Overview page
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC07_Validate_BillingandTransaction_Helpicon(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.loadOverviewPage();
		OverviewPage OVPage1=new OverviewPage(driver);
		Assert.assertTrue(OVPage1.BTHelpicon(), "Billing and Transaction Section Help Icon- Not Present");
		hp.logoutApplication();
	}

	//Name: TC08_Validate_BillingandTransaction_SectionEachLinks_HOHUser()
	//Description: Validate the links for Billing and Transactions section in Overview page
	//HOH User -E2E5011
	//Pre-Requisite: Auto pay should be set up to check View bill and View Due date links, upcoming payments should be set up to check upcoming payment link 
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC08_Validate_BillingandTransaction_SectionEachLinks_HOHUser(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.loadOverviewPage();
		OverviewPage OVPage=new OverviewPage(driver);
		Assert.assertTrue(OVPage.BTSection_Links(), "User is not able to validate Billing and Transaction Section links in Overview page");
	}

	//Name: TC09_Validate_ServiceAndEquipment_SectionEachLink_AdminUser()
	//Description: Validate navigations to the respective pages by clicking on links under TV,Internet,Voice in Services and Equipment section of Overview page
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC09_Validate_ServiceAndEquipment_SectionEachLink_AdminUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		//MA.loadOverviewPage();
		OverviewPage OVPage1=new OverviewPage(driver);
		Assert.assertTrue(OVPage1.TV_Internet_Voice_DetailsLink(), "User is not able to verify Details links for TV, Internet and Voice Services in Overview page");
		hp.logoutApplication();

	}

	//Name: TC10_Validate_ServiceandEquipment_Helpicon()
	//Description: Validate the help icon for Services and Equipment section in Overview page
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC10_Validate_ServiceandEquipment_Helpicon(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		//MA.loadOverviewPage();
		OverviewPage OVPage1=new OverviewPage(driver);
		Assert.assertTrue(OVPage1.SEHelpicon(), "Service and Equipment Section Help icon- Not Present");
		hp.logoutApplication();

	}

	//Name: TC11_Validate_UserPreferences_Helpicon()
	//Description: Validate the help icon for Users and Preferences section in Overview page
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC11_Validate_UserPreferences_Helpicon(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		//MA.loadOverviewPage();
		OverviewPage OVPage1=new OverviewPage(driver);
		Assert.assertTrue(OVPage1.UPHelpicon(), "UserPreferences Section Help icon- Not Present");
		hp.logoutApplication();

	}

	//Name: TC12_Validate_OverviewPage_ViewPaymentViewDate_HOHUser()
	//Description: Validate whether the user is able to view Payment Due Date on clicking 'View Payment Due Date' in Overview page.
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC12_Validate_OverviewPage_ViewPaymentViewDate_HOHUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);

		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		//MA.loadOverviewPage();
		BillingAndTransactionsPage BTP=new BillingAndTransactionsPage(driver);
		Assert.assertTrue(BTP.viewduedate(), "User -Not able to Navigate to view Payment Due Date");
		hp.logoutApplication();
	}

	//Name: TC13_Validate_OverviewPage_AvatarImagesViewProfile_HOHUser()
	//Description: Validate whether the user is able to view his and other user profiles on clicking the Avatar images in Overview page.
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	//*****/
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC13_Validate_OverviewPage_AvatarImagesViewProfile_HOHUser(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		//MAPage.loadOverviewPage();
		OverviewPage OVpage=new OverviewPage(driver);
		Assert.assertTrue(OVpage.AvatarImages(), "User is not able to view profiles on clicking Avatar Images in overview page");
		hp.logoutApplication();
	}

	//Name: TC14_Validate_OverviewPage_NickNameLink_NavigationTo_TVServices()
	//Description: Validate whether the user is able to navigate to TV Services page on clicking 'Nickname Device' link in Overview page.
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC14_Validate_OverviewPage_NickNameLink_NavigationTo_TVServices(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		//MA.loadOverviewPage();
		OverviewPage OVP=new OverviewPage(driver);
		Assert.assertTrue(OVP.NDLink(),"User -Not Navigated to TV Services Nick Name Device Page");
		hp.logoutApplication();
	}
	//Name: TC15_Validate_OverviewPage_RefreshDevicesLink_NavigationTo_TVServices()
	//Description: Validate whether the user is able to navigate to TV Services page on clicking 'Refresh Devices' link in Overview page.
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)

	public void TC15_Validate_OverviewPage_RefreshDevicesLink_NavigationTo_TVServices(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		//MA.loadOverviewPage();
		OverviewPage OVPage=new OverviewPage(driver);
		Assert.assertTrue(OVPage.RefreshDevicesLink(), "User -Not Navigated to TV Services Refresh Devices Page");
		hp.logoutApplication();
	}
	
	//Name: TC16_Validate_OverviewPage_CheckEmailLink_NavigationTo_Webmail()
	//Description: Validate whether the user is able to navigate to Webmail page on clicking 'Check email' link in Overview page.
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC16_Validate_OverviewPage_CheckEmailLink_NavigationTo_Webmail(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		//MA.loadOverviewPage();
		OverviewPage OVPage=new OverviewPage(driver);
		Assert.assertTrue(OVPage.CheckEmailLink(), "User -Not Navigated to Email Page");
	}

	//Name: TC17_Validate_OverviewPage_SecuritySuiteLink_NavigationTo_SecuritySuitePage()
	//Description: Validate whether the user is able to navigate to Security suite page on clicking 'Security suite link' in Overview page.
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC17_Validate_OverviewPage_SecuritySuiteLink_NavigationTo_SecuritySuitePage(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		//MA.loadOverviewPage();
		OverviewPage OVPage=new OverviewPage(driver);
		Assert.assertTrue(OVPage.SecuritySuiteLink(), "User is -Not Navigated to Security Suite Page");
		hp.logoutApplication();
	}

	//Name: TC18_Validate_OverviewPage_ServiceEquipmentPanel_Stduser()
	//Description: Validate whether the user is able to view Service equipment panel in overview page
	//Standard User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC18_Validate_OverviewPage_ServiceEquipmentPanel_Stduser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		//MA.loadOverviewPage();
		OverviewPage OVPage=new OverviewPage(driver);
		Assert.assertTrue(OVPage.UpgradeLink_Standard(), "Upgrde link Exists for Standard User");
		hp.logoutApplication();
	}

	//Name: TC19_Validate_OverviewPage_PhoneOnlineMangerLink_NavigateTo_POMpage_Adminuser()
	//Description: Validate whether the user is able to navigate to POM page on clicking 'Phone online manager' link in Overview page.
	//Admin User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC19_Validate_OverviewPage_PhoneOnlineMangerLink_NavigateTo_POMpage_Adminuser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		//MA.loadOverviewPage();
		OverviewPage OVPage=new OverviewPage(driver);
		Assert.assertTrue(OVPage.POMLink(), "User is -Not Navigated to Phone Online Manager Page");
	}
	
	//Name: TC20_Validate_BillingAndTransactionPage_HeadersAndLinks()
	//Description: Validate navigating to My Account Billing and Transactions page and verify all the headers in the page
	//Admin User
	//Scripter:Ayesha
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)

	public void TC20_Validate_BillingAndTransactionPage_HeadersAndLinks(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		//MA.openMyAccountTab();
		MA.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		Assert.assertTrue(BTPage.BillingAndTransactionHeaders(), "Headers are -Not displayed in Billing and Transaction page");
		hp.logoutApplication();
	}

	//Name: TC21_Validate_BillingAndTransactionPage_MakeAPaymentLink_NavigateTo_PaymentOptionPage_HOHUser()
	//Description: Validate navigating to Payment Options page by clicking on "Make a Payment" link 
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC21_Validate_BillingAndTransactionPage_MakeAPaymentLink_NavigateTo_PaymentOptionPage_HOHUser(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		//MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTP=new BillingAndTransactionsPage(driver);
		Assert.assertTrue(BTP.makepaymentLink(), "User is -Not Navigated to Payment Options Page");
		hp.logoutApplication();
	}

	//Name: TC22_Validate_BillingAndTransactionPage_ViewCurrentBillLink_NavigateTo_CurrentBillPage_HOHUser()
	//Description: Validate current bill of the user by clicking on "View Current Bill" link 
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC22_Validate_BillingAndTransactionPage_ViewCurrentBillLink_NavigateTo_CurrentBillPage_HOHUser(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTP=new BillingAndTransactionsPage(driver);
		Assert.assertTrue(BTP.ViewCBillLink(), "User is not able to view bill with View Current bill link");
		hp.logoutApplication();
	}

	//Name: TC23_Validate_BillingAndTransactionPage_BillDeliveryOptionsLink_NavigateTo_BilldeliveryOptionsPage_HOHUser()
	//Description: Validate navigating to Bill Delivery Options by clicking on "Bill Delivery Options" link 
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC23_Validate_BillingAndTransactionPage_BillDeliveryOptionsLink_NavigateTo_BilldeliveryOptionsPage_HOHUser(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		//MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTP=new BillingAndTransactionsPage(driver);
		Assert.assertTrue(BTP.Billdeliverylink(), "User is -Not Navigated to Bill Delivery Options Page");
		hp.logoutApplication();
	}
	
	//Name: TC24_Validate_BillingAndTransPage_ViewImportantBillMessageLink_NavigateTo_ViewImportantBillMessagePage_HOHUser()
	//Description:Validate navigating to Important Bill Messages by clicking on "View Important Bill Messages" link 
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC24_Validate_BillingAndTransPage_ViewImportantBillMessageLink_NavigateTo_ViewImportantBillMessagePage_HOHUser(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		//MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		Assert.assertTrue(BTPage.VImpBillMsg(), "User is -Not able to view important bill messages with View Important Bill Messages link ");
		hp.logoutApplication();
	}

	//Name: TC25_Validate_BillingAndTransPage_UpcomingPaymentLink_NavigateTo_UpcomingPaymentPage_HOHUser()
	//Description: Validate navigating to upcoming payments page by clicking on "Upcoming Payments" link 
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC25_Validate_BillingAndTransPage_UpcomingPaymentLink_NavigateTo_UpcomingPaymentPage_HOHUser(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String MAC = testdata.get("mac_CID");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		//MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTP=new BillingAndTransactionsPage(driver);
		Assert.assertTrue(BTP.UpcomingPaymentsLink(), "User is -Not Navigated to Upcoming Payments Page");
		hp.logoutApplication();
	}

	//Name: TC26_Validate_BillingAndTransactionPage_SummarySection_HOHUser()
	//Description: Validate statement summary section in Billing and Transactions page 
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC26_Validate_BillingAndTransactionPage_SummarySection_HOHUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.loadBillingAndTransactionSection();
		BTPage1 BTP1=new BTPage1(driver);
		Assert.assertTrue(BTP1.SSSection(), "Statement Summary Section is - Not Present");
		hp.logoutApplication();
	}

	//Name: TC27_Validate_BillingAndTransactionPage_StatementSummaryHelpIcon_HOHUser()
	//Description: Validate help icon of Statement Summary 
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC27_Validate_BillingAndTransactionPage_StatementSummaryHelpIcon_HOHUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		//MA.openMyAccountTab();
		MA.loadBillingAndTransactionSection();
		BTPage1 BTP1=new BTPage1(driver);
		Assert.assertTrue(BTP1.SSHelpicon(), "Statement Summary Section Help icon is -Not Present");
		hp.logoutApplication();

	}

	//Name: TC28_Validate_BillingAndTransactionPage_SelectDateDropDownOption_HOHUser()
	//Description: Validate navigating to prior statements by selecting specific date in drop-down  
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC28_Validate_BillingAndTransactionPage_SelectDateDropDownOption_HOHUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String SelectDate=testdata.get("SelectDate");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		//MA.openMyAccountTab();
		MA.loadBillingAndTransactionSection();
		BTPage1 bill=new BTPage1(driver);
		Assert.assertTrue(bill.SSSpecificDate(SelectDate), "user is not able to select specific date in Statement summary Section");
		hp.logoutApplication();
	}


	//Name: TC29_Validate_BillingAndTransaction_PayBillLink_NavigateTo_PaymentOption_HOHUser()
	//Description: Validate navigating to Payment Options page by clicking on "Pay Bill" button  
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC29_Validate_BillingAndTransaction_PayBillLink_NavigateTo_PaymentOption_HOHUser(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.loadBillingAndTransactionSection();
		OverviewPage OVPage1=new OverviewPage(driver);
		Assert.assertTrue(OVPage1.BTPage_PaybillLink(),"User is - Not Navigated to Payment options page - Failed");
		hp.logoutApplication();
	}

	//Name: TC30_Validate_BillingAndTransactionPage_ContactInfoSection_HOHuser()
	//Description: Validate Contact Info section  
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC30_Validate_BillingAndTransactionPage_ContactInfoSection_HOHuser(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.loadBillingAndTransactionSection();
		BTPage1 BTP1=new BTPage1(driver);
		Assert.assertTrue(BTP1.ContactInfo(), "Contact Info Section is -Not Present");
		hp.logoutApplication();
	}
	
	//Name: TC31_Validate_BillingandTransPage_ChangeNameLink_NavigateTo_TransferAccountOwnershipPage_HOHuser()
	//Description: Validate navigating to Transfer Account ownership page by clicking on "Change Name" link 
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC31_Validate_BillingandTransPage_ChangeNameLink_NavigateTo_TransferAccountOwnershipPage_HOHuser(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.loadBillingAndTransactionSection();
		BTPage1 BTP1=new BTPage1(driver);
		Assert.assertTrue(BTP1.ChangeNameLink(), "User -Not able to navigate to Transfer account ownership Page");
		hp.logoutApplication();
	}

	//Name: TC32_Validate_BillingAndTransactionPage_TransferMyServiceLink_NavigateTo_TransferServicePage_HOHUser()
	//Description: Validate navigating to Transfer Service page by clicking on "Transfer My Service" link 
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC32_Validate_BillingAndTransactionPage_TransferMyServiceLink_NavigateTo_TransferServicePage_HOHUser(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		//MA.openMyAccountTab();
		MA.loadBillingAndTransactionSection();
		BTPage1 BTP1=new BTPage1(driver);
		Assert.assertTrue(BTP1.TMSLink(), "User -Not able to navigate to Charter Mover Resource Page");
		hp.logoutApplication();

	}

	//Name: TC33_Validate_BillingAndTransactionPage_CallDetailsHelpicon_HOHUser()
	//Description: Validate help icon of Call Details 
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC33_Validate_BillingAndTransactionPage_CallDetailsHelpicon_HOHUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		//MA.openMyAccountTab();
		MA.loadBillingAndTransactionSection();
		OverviewPage OVPage1=new OverviewPage(driver);
		Assert.assertTrue(OVPage1.CallDetailsHelpicon(), "Call Details Help icon is -Not Present");
		hp.logoutApplication();
	}

	//Name: TC34_Validate_BillingAndTransactionPage_ViewCallDetailsLink_NavigateTo_CallDetailsPage_HOHUser()
	//Description: Validate navigating to Call Details page by clicking on "View Call details" link 
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC34_Validate_BillingAndTransactionPage_ViewCallDetailsLink_NavigateTo_CallDetailsPage_HOHUser(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		//MA.openMyAccountTab();
		MA.loadBillingAndTransactionSection();
		BillingAndTransactionsPage OVPage1=new BillingAndTransactionsPage(driver);
		Assert.assertTrue(OVPage1.BTPage_CallDetailsLink(), "User is -Not Navigated to Call Details page");
		hp.logoutApplication();
	}

	//Name: TC35_Validate_BillingAndTransactionPage_PaymentHistoryHelpIcon_HOHUser()
	//Description: Validate help icon of Payment History 
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC35_Validate_BillingAndTransactionPage_PaymentHistoryHelpIcon_HOHUser(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		//MA.openMyAccountTab();
		MA.loadBillingAndTransactionSection();
		BTPage1 bill=new BTPage1(driver);
		Assert.assertTrue(bill.PHHelpicon(), "Payment History Section Help icon is -Not Present");
		hp.logoutApplication();
	}

	//Name: TC36_Validate_BillingAndTransactionPage_RecentTransactionsHelpIcon_HOHUser()
	//Description: Validate help icon of Recent Transactions 
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC36_Validate_BillingAndTransactionPage_RecentTransactionsHelpIcon_HOHUser(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		//MA.openMyAccountTab();
		MA.loadBillingAndTransactionSection();
		BTPage1 bill=new BTPage1(driver);
		Assert.assertTrue(bill.RTHelpicon(), "Recent Transactions Section Help icon is -Not Present");
		hp.logoutApplication();
	}

	//Name: TC37_Validate_BillingAndTransactionPage_PaymentHistorySection_HOHUser()
	//Description: Validate Payment History section 
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC37_Validate_BillingAndTransactionPage_PaymentHistorySection_HOHUser(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		Assert.assertTrue(BTPage.Payment_History(), "Payment History Section is -Not Present");
		hp.logoutApplication();
	}

	//Name: TC38_Validate_BillingAndTransactionPage_RecentTransactionsSection_HOHUser()
	//Description: Validate Recent Transactions section 
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC38_Validate_BillingAndTransactionPage_RecentTransactionsSection_HOHUser(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		Assert.assertTrue(BTPage.Recent_Transactions(), "Recent Transaction Section is -Not Present");
		hp.logoutApplication();

	}

	//Name: TC39_Validate_BillingAndTransactionPage_AskCharterWidget_HOHUser()
	//Description: Validate Ask Charter Widget in Billing and Transactions page 
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC39_Validate_BillingAndTransactionPage_AskCharterWidget_HOHUser(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		//MA.openMyAccountTab();
		MA.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		Assert.assertTrue(BTPage.AskCharterSection(), "Askcharter Section is -Not Present");
		hp.logoutApplication();
	}

	//Name: TC40_Validate_TVServicesPage_Navigation_AndVerifyHeaderLinks()
	//Description: Validate navigating to My Account TV Services page and verify all the links,headers in the page 
	//HOH User
	//Scripter:Ayesha
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC40_Validate_TVServicesPage_Navigation_AndVerifyHeaderLinks(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		//MA.openMyAccountTab();
		MA.TVServiceslink();
		TVServicesPage TVPage=new TVServicesPage(driver);
		Assert.assertTrue(TVPage.TVServicesHeaders(), "TV Servcies Page Headers are -Not Present");
		hp.logoutApplication();
	}

	//Name: TC41_Validate_TVServicesPage_LearnMoreLink_NavigateTo_SpectrumGuide_HOHUser()
	//Description: Validate navigating to charter spectrum TV page by clicking on Learn More link 
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC41_Validate_TVServicesPage_LearnMoreLink_NavigateTo_SpectrumGuide_HOHUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		//MA.openMyAccountTab();
		MA.TVServiceslink();
		TVServicesPage TVPage=new TVServicesPage(driver);
		Assert.assertTrue(TVPage.TVLearnMoreLink(), "User is -Not Navigated to Charter Spectrum TV Page");
	}


	//Name: TC42_Validate_TVServicesPage_DigitalReceiversLinks_Navigation_HOHUser()
	//Description: Validate support quick links section and navigate to the respective pages by clicking on the links Digital receivers and Find program yoru remote 
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC42_Validate_TVServicesPage_DigitalReceiversLinks_Navigation_HOHUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		//MA.openMyAccountTab();
		MA.TVServiceslink();
		TVServicesPage TVPage=new TVServicesPage(driver);
		Assert.assertTrue(TVPage.FPR_DR_Link(), "User is -Not Navigated to Program Your Remote Page");
		hp.logoutApplication();
	}

	//Name: TC43_Validate_TVServicesPage_AskCharterWidget_HOHUser()
	//Description: Validate Ask Charter widget in TV Services page 
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC43_Validate_TVServicesPage_AskCharterWidget_HOHUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		//MA.openMyAccountTab();
		MA.TVServiceslink();
		TVServicesPage TVPage=new TVServicesPage(driver);
		Assert.assertTrue(TVPage.AskCharter_TV(),"Ask Charter Header in TV Services Page is - Not Present");
		Assert.assertTrue(TVPage.Askbutton_TV(),"Ask button in TV Services Page is -Not Present");
		hp.logoutApplication();
	}

	//Name: TC44_Validate_TVServicesPage_ManageYourTVSection_HOHUser()
	//Description: Validate Manage your TV service section 
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC44_Validate_TVServicesPage_ManageYourTVSection_HOHUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		//MA.openMyAccountTab();
		MA.TVServiceslink();
		TVServicesPage TVPage=new TVServicesPage(driver);
		Assert.assertTrue(TVPage.NYDR_TV_Manage_Section(),"User is -Not able to navigate to Name Receiver Page");
		hp.logoutApplication();
	}

	//Name: TC45_Validate_TVServicesPage_UpdateNowKink_NavigateTo_ActivationPage_HOHUser()
	//Description:Validate navigating to Activation page by clicking on "Update Now" link for Activate New Digital Receiver 
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC45_Validate_TVServicesPage_UpdateNowKink_NavigateTo_ActivationPage_HOHUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		//MA.openMyAccountTab();
		MA.TVServiceslink();
		TVServicesPage TVPage=new TVServicesPage(driver);
		Assert.assertTrue(TVPage.UpdateNow_ActivateNDR(),"User is -Not able to navigate to Activate Charter Page");
		hp.logoutApplication();
	}
	//Name: TC46_Validate_InternetServicesPage_Navigation_AndVerifyHeaderLinks()
	//Description:Validate navigating to My Account Internet Services page and verify all the links,headers in the page 
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC46_Validate_InternetServicesPage_Navigation_AndVerifyHeaderLinks(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		//MA.openMyAccountTab();
		MA.InternetServiceslink();
		InternetServicesPage TVPage=new InternetServicesPage(driver);
		Assert.assertTrue(TVPage.InternerServicesHeaders(),"Internet Services Headers are -Not Present");
		hp.logoutApplication();
	}

	//Name: TC47_Validate_InternetServicesPage_LearnMoreLink_NavigateTo_SpectrumGuide_HOHUser()
	//Description:Validate navigating to charter spectrum Internet page by clicking on Learn More link 
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC47_Validate_InternetServicesPage_LearnMoreLink_NavigateTo_SpectrumGuide_HOHUser(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		//MA.openMyAccountTab();
		MA.InternetServiceslink();
		InternetServicesPage INpage=new InternetServicesPage(driver);
		Assert.assertTrue(INpage.InternetLearnMorelink(),"User is -Not able to Navigate to Charter Internet Spectrum page");
		//hp.logoutApplication();
	}

	//Name: TC48_Validate_InternetServicesPage_SupportLinks_AndNavigation_HOHuser()
	//Description:Validate support quick links section and navigate to the respective pages by clicking on the links "Restarting your cable modem" and "Finding Wifi name and Password" 
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC48_Validate_InternetServicesPage_SupportLinks_AndNavigation_HOHuser(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		//MA.openMyAccountTab();
		MA.InternetServiceslink();
		InternetServicesPage INpage=new InternetServicesPage(driver);
		Assert.assertTrue(INpage.wifi_CableModemLink(), "Validate Support links in Internet Services page - Failed");
		hp.logoutApplication();

	}
	
	//Name: TC49_Validate_InternetServicesPage_AskCharterWidget_HOHUser()
	//Description:Validate Ask Charter widget in Internet Services page 
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC49_Validate_InternetServicesPage_AskCharterWidget_HOHUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		//MA.openMyAccountTab();
		MA.InternetServiceslink();
		InternetServicesPage INpage=new InternetServicesPage(driver);
		Assert.assertTrue(INpage.AskCharter_TV(),"Ask Charter Header in Internet Services Page is - Not Present");
		Assert.assertTrue(INpage.Askbutton_TV(),"Ask button in Internet Services Page is -Not Present");
		hp.logoutApplication();
	}

	//Name: TC50_Validate_InternetServicesPage_ManageYourInternetSection_HOHUser()
	//Description:Validate Manage your Internet service section 
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC50_Validate_InternetServicesPage_ManageYourInternetSection_HOHUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		//MA.openMyAccountTab();
		MA.InternetServiceslink();
		InternetServicesPage INpage=new InternetServicesPage(driver);
		Assert.assertTrue(INpage.Manage_InternetServices(),"Manage your Internet Services Section is -Not Present");
		hp.logoutApplication();
	}

	//Name: TC51_Validate_InternetServicesPage_CharterEmailLink_NavigateTo_ChaterEmail_HOHUser()
	//Description: Validate navigating to Charter Email page by clicking on "Charter Email" link
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC51_Validate_InternetServicesPage_CharterEmailLink_NavigateTo_ChaterEmail_HOHUser(Map<String,String> testdata) throws Exception{
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		//MAPage.openMyAccountTab();
		MAPage.InternetServiceslink();
		InternetServicesPage IPage=new InternetServicesPage(driver);
		Assert.assertTrue(IPage.CharterEmail_link(), "Verify navigation to Charter email - Failed");
	}

	//Name: TC52_Validate_InternetServicesPage_CharterSecurityLink_NavigateTo_CharterSecurityPage_HOHUser()
	//Description: Validate navigating to Charter Security page by clicking on "Charter Security" link
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC52_Validate_InternetServicesPage_CharterSecurityLink_NavigateTo_CharterSecurityPage_HOHUser(Map<String,String> testdata) throws Exception{
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		//MAPage.openMyAccountTab();
		MAPage.InternetServiceslink();
		InternetServicesPage IPage=new InternetServicesPage(driver);
		Assert.assertTrue(IPage.charterSecuritySuitelink(), "Verify navigation to Charter Security page - Failed");

	}
	
	//Name: TC53_Validate_InternetServicesPage_CloudDriveLink_NavigateTo_CharterCloudDrivePage_HOHuser()
	//Description: Validate navigating to Charter Cloud Drive page by clicking on "Cloud Drive" link
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC53_Validate_InternetServicesPage_CloudDriveLink_NavigateTo_CharterCloudDrivePage_HOHuser(Map<String,String> testdata) throws Exception{
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		//MAPage.InternetServiceslink();
		InternetServicesPage IPage=new InternetServicesPage(driver);
		Assert.assertTrue(IPage.CharterCloudDrivelink(), "Verify navigation to Charter Cloud Drive page - Failed");
	}

	//Name: TC54_Validate_VoiceServicesPage_Navigation_AndVerifyHeaderLinks()
	//Description: Validate navigating to My Account Voice Services page and verify all the headers in the page
	//HOH User
	//Scripter:Ayesha
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC54_Validate_VoiceServicesPage_Navigation_AndVerifyHeaderLinks(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		//MA.openMyAccountTab();
		MA.VoiceServiceslink();
		VoiceServicesPage VSPage=new VoiceServicesPage(driver);
		Assert.assertTrue(VSPage.VoiceServicesHeaders(), "Voice Services Headers are -Not Present -Failed");
		hp.logoutApplication();
	}

	//Name: TC55_Validate_VoiceServicesPage_LearnMoreLink_NavigateTo_SpectrumGuide_HOHUser()
	//Description: Validate navigating to charter spectrum Voice page by clicking on Learn More link
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC55_Validate_VoiceServicesPage_LearnMoreLink_NavigateTo_SpectrumGuide_HOHUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		//MA.openMyAccountTab();
		MA.VoiceServiceslink();
		VoiceServicesPage VoicePage=new VoiceServicesPage(driver);
		Assert.assertTrue(VoicePage.VoiceLearnMoreLink(), "User is -Not able to Navigate to Charter Voice page -Failed");
	}

	//Name: TC56_Validate_VoiceServicesPage_SupportLinks_AndNavigation_HOHuser()
	//Description: Validate support quick links section and navigate to the respective pages by clicking on the links "Voice mail help" and "Voice features"
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC56_Validate_VoiceServicesPage_SupportLinks_AndNavigation_HOHuser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		//MA.openMyAccountTab();
		MA.VoiceServiceslink();
		VoiceServicesPage voicepage=new VoiceServicesPage(driver);
		Assert.assertTrue(voicepage.Voice_SupportLink(), "User is -Not able to Navigate to Voice Services page Support links -Failed");
	}

	//Name: TC57_Validate_VoiceServicesPage_AskCharterWidget_HOHUser()
	//Description: Validate Ask Charter widget in Voice Services page
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC57_Validate_VoiceServicesPage_AskCharterWidget_HOHUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		//MA.openMyAccountTab();
		MA.VoiceServiceslink();
		VoiceServicesPage voicepage=new VoiceServicesPage(driver);
		Assert.assertTrue(voicepage.AskCharter_TV(),"Ask Charter Header in Voice Services Page is - Not Present");
		Assert.assertTrue(voicepage.Askbutton_TV(),"Ask button in Voice Services Page is -Not Present");
		hp.logoutApplication();
	}

	//Name: TC58_Validate_VoiceServicesPage_ManageYourVoiceSection_HOHUser()
	//Description: Validate Manage your Voice service section
	//Admin User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC58_Validate_VoiceServicesPage_ManageYourVoiceSection_HOHUser(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		//MA.openMyAccountTab();
		MA.VoiceServiceslink();
		VoiceServicesPage voicepage=new VoiceServicesPage(driver);
		Assert.assertTrue(voicepage.Manage_voiceServices(),"Manage your Voice Services Section is -Not Present");

	}
	
	//Name: TC59_Validate_VoiceServicesPage_CharterPhone_NavigateTo_CharterVoicePage_HOHUser()
	//Description: Validate navigating to Charter Voice page by clicking on "Charter Phone" button
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC59_Validate_VoiceServicesPage_CharterPhone_NavigateTo_CharterVoicePage_HOHUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		//MA.openMyAccountTab();
		MA.VoiceServiceslink();
		VoiceServicesPage voicepage=new VoiceServicesPage(driver);
		Assert.assertTrue(voicepage.VoiceOnlineManagerLink(),"User is -Not able to Navigate to Charter Voice page by clicking Charter Phone button -Failed");
	}
	
	//Name: TC60_Validate_UserPreferencesPage_Navigation_AndVerifyHeaderLinks()
	//Description: Validate navigating to my account user preferences page and verify all the headers in the page
	//HOH User
	//Scripter:Ayesha
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC60_Validate_UserPreferencesPage_Navigation_AndVerifyHeaderLinks(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		//MA.openMyAccountTab();
		MA.loadUPPage();
		UserPreferencePage UPPage=new UserPreferencePage(driver);
		Assert.assertTrue(UPPage.UserPreferencesHeaders(),"User Preferences Page Headers are -Not present -Failed");
		hp.logoutApplication();
	}
	
	//Name: TC61_Validate_UserPreferencesPage_Helpicon_HOHUser()
	//Description: Validate help icon of charter id.
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC61_Validate_UserPreferencesPage_Helpicon_HOHUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		//MAPage.openMyAccountTab();
		MAPage.loadUPPage();
		UserPreferencePage UPpage=new UserPreferencePage(driver);
		Assert.assertTrue(UPpage.UP_charterID_helpicon(),"User Preferences Page Charter ID Help icon is -Not present-Failed ");
		hp.logoutApplication();
	}

	//Name: TC62_Validate_UserPreferencesPage_EditFields_HOHUser()
	//Description: Validate Edit fields of Password,Contact Email,Phone,Security question
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC62_Validate_UserPreferencesPage_EditFields_HOHUser(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String email=testdata.get("email");
		String security_question=testdata.get("security_question");
		String security_answer=testdata.get("security_answer");
		String ACnumber = testdata.get("ACnumber");
		
		HomePage hp=new HomePage(driver);
		AuthenticationPage auth = new AuthenticationPage(driver);
		String text1 = auth.getAccountDetails(ACnumber);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.loadUPPage();
		UserPreferencePage UPpage=new UserPreferencePage(driver);
		Assert.assertTrue(UPpage.EditContactFields_UP(password,email,security_question,security_answer), "User is -Not able to Edit fields of Password,Contact Email,Phone,Security question of Users");
		hp.logoutApplication();
	}

	//Name: TC63_Validate_UserPreferencesPage_BillingAddressEditFields_HOHUser()
	//Description: Validate Edit field for Billing Address
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC63_Validate_UserPreferencesPage_BillingAddressEditFields_HOHUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String Address1 = testdata.get("Address1");
		String Address2 = testdata.get("Address2");
		String City = testdata.get("City");
		String State = testdata.get("State");
		String Zipcode = testdata.get("Zipcode");
		String ACnumber = testdata.get("ACnumber");

		HomePage hp=new HomePage(driver);
		AuthenticationPage auth = new AuthenticationPage(driver);
		String text1 = auth.getAccountDetails(ACnumber);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		//MAPage.openMyAccountTab();
		MAPage.loadUPPage();
		UserPreferencePage UPpage=new UserPreferencePage(driver);
		Assert.assertTrue(UPpage.BillingAddress_Edit(Address1,Address2,City,State,Zipcode,text1,ACnumber,URL,username,password), "User is -Not able to Edit  Billing Address fields");
		hp.logoutApplication();
	}

	//Name: TC64_Validate_UserPreferencesPage_AccountControlSection_HOHUser()
	//Description: Validate Account controls section(including help icon)
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC64_Validate_UserPreferencesPage_AccountControlSection_HOHUser(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		//MAPage.openMyAccountTab();
		MAPage.loadUPPage();
		UserPreferencePage UPpage=new UserPreferencePage(driver);
		Assert.assertTrue(UPpage.AccountControlsSection(), "User is -Not able to access Account Controls Section in User Preferences Page");
		hp.logoutApplication();
	}
	
	//Name: TC65_Validate_UserPreferencesPage_ParentalControlSection_HOHUser()
	//Description:Validate Parental controls section(including help icon)
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC65_Validate_UserPreferencesPage_ParentalControlSection_HOHUser(Map<String,String> testdata) throws Exception{
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		//MAPage.openMyAccountTab();
		MAPage.loadUPPage();
		UserPreferencePage UPpage=new UserPreferencePage(driver);
		Assert.assertTrue(UPpage.ParentalSection(), "User is -Not able to access Parental Controls Section in User Preferences Page");
		hp.logoutApplication();
	}

	//Name: TC66_Validate_UserPreferencesPage_EmailControlSection_HOHUser()
	//Description:Validate Email controls section(including help icon)
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC66_Validate_UserPreferencesPage_EmailControlSection_HOHUser(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		//MAPage.openMyAccountTab();
		MAPage.loadUPPage();
		UserPreferencePage UPpage=new UserPreferencePage(driver);
		Assert.assertTrue(UPpage.EmailSection(username), "User is -Not able to access Email controls Section in User Preferences Page");
		hp.logoutApplication();
	}

	//Name: TC67_Validate_UserPreferencesPage_MarketingAndAdvertisingSection_HOHUser()
	//Description:Validate Marketing and Advertising preferences section(including help icon)
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC67_Validate_UserPreferencesPage_MarketingAndAdvertisingSection_HOHUser(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		//MAPage.openMyAccountTab();
		MAPage.loadUPPage();
		UserPreferencePage UPpage=new UserPreferencePage(driver);
		Assert.assertTrue(UPpage.MarketingSection(), "User is -Not able to access Marketing and Advertising Section in User Preferences Page -Failed");
		hp.logoutApplication();
	}

	//Name: TC68_Validate_UserPreferencesPage_AskCharter_HOHUser()
	//Description:Validate Ask Charter widget in User Preferences page
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC68_Validate_UserPreferencesPage_AskCharter_HOHUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		//MAPage.openMyAccountTab();
		MAPage.loadUPPage();
		UserPreferencePage UPpage=new UserPreferencePage(driver);
		Assert.assertTrue(UPpage.Askcharter_UP(), "Ask Charter Widget is -Not present in User Preferences Page -Failed");
		hp.logoutApplication();
	}

	//Name: TC69_Validate_UserPreferencesPage_HOHEditHOHAdminAndStandardProfiles_HOHUser()
	//Description: Validate if HOH user is able to edit HOH, Admin and Standard user profiles
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC69_Validate_UserPreferencesPage_HOHEditHOHAdminAndStandardProfiles_HOHUser(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String email=testdata.get("email");
		String security_question=testdata.get("security_question");
		String security_answer=testdata.get("security_answer");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		//MAPage.openMyAccountTab();
		MAPage.loadUPPage();
		UserPreferencePage UPpage=new UserPreferencePage(driver);
		UPpage.EditContactFields_UP(password,email,security_question,security_answer);
		UPpage.selectuser(userType.role, "Admin");
		UPpage.EditContactFields_UP(password,email,security_question,security_answer);
		UPpage.selectuser(userType.role, "Standard");
		Assert.assertTrue(UPpage.EditContactFields_UP(password,email,security_question,security_answer), "HOH User is not able to edit HOH,Admin and Standard user profiles");
		hp.logoutApplication();


	}

	//Name: TC70_Validate_UserPreferencesPage_AdminEditAdminAndStandardProfiles_AdminUser()
	//Description: Validate if Admin user is able to edit Admin and Standard user profiles
	//Admin User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC70_Validate_UserPreferencesPage_AdminEditAdminAndStandardProfiles_AdminUser(Map<String,String> testdata) throws Exception{
		boolean retVal = false;
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String email=testdata.get("email");
		String security_question=testdata.get("security_question");
		String security_answer=testdata.get("security_answer");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		//MAPage.openMyAccountTab();
		MAPage.loadUPPage();
		UserPreferencePage UPpage=new UserPreferencePage(driver);
		UPpage.EditContactFields_UP(password,email,security_question,security_answer);
		UPpage.selectuser(userType.role, "Standard");
		UPpage.EditContactFields_UP(password,email,security_question,security_answer);
		hp.logoutApplication();
		retVal = true;
		Assert.assertTrue(retVal, "Admin user is Not able to edit Admin and Standard user profiles - Failed" );
	}

	//Name: TC71_Validate_UserPreferencesPage_StandardEditStandardProfiles_StandardUser()
	//Description: Validate if Standard user is able to edit Standard user profile and not of HOH and Admin
	//Standard User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC71_Validate_UserPreferencesPage_StandardEditStandardProfiles_StandardUser(Map<String,String> testdata) throws Exception{
		boolean retVal=false;
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String email=testdata.get("email");
		String security_question=testdata.get("security_question");
		String security_answer=testdata.get("security_answer");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		//MAPage.openMyAccountTab();
		MAPage.loadUPPage();
		UserPreferencePage UPpage=new UserPreferencePage(driver);
		UPpage.EditContactFields_UP(password,email,security_question,security_answer);
		hp.logoutApplication();
		retVal = true;
		Assert.assertTrue(retVal, "Standard user is Not able to edit his/her own profile - Failed" );
	}

	//Name: TC72_Validate_UserPreferencesPage_PasswordMismatchError_HOHUser()
	//Description: User Preferences: Standard - password and confirm password mismatch error message
	//Standard User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC72_Validate_UserPreferencesPage_PasswordMismatchError_HOHUser(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		//MAPage.openMyAccountTab();
		MAPage.loadUPPage();
		UserPreferencePage UPpage=new UserPreferencePage(driver);
		UPpage.UP_pw_mismatch_ErrorMessage();
		Assert.assertTrue(UPpage.PWErrorMsg(), "Password Mismatch Error Message is Not Displayed ");
		hp.logoutApplication();
	}

	//Name: TC73_Validate_BillingandTransactonPage_CallDetails_Section_Filters
	//Description: Validate whether user is able to access filters in Call Details Section in Billing and Transaction Page
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC73_Validate_BillingandTransactonPage_CallDetails_Section_Filters(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String Statement=testdata.get("Statement");
		String filterbyType=testdata.get("filterbyType");
		String filterbyPhone=testdata.get("filterbyPhone");
		String filterbyRate=testdata.get("filterbyRate");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage myAccPage=new MyAccountPage(driver);
		//myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTpage=new BillingAndTransactionsPage(driver);
		BTpage.BTPage_CallDetailsLink();
		BTpage.CallDetails_Filters(Statement,filterbyType,filterbyPhone,filterbyRate);
		verifyAssert(BTpage.getPhoneNo(), filterbyPhone,"Selected Phone No is Displayed");
		BTpage.get_phonecount();
		verifyAssert(BTpage.getRate(), filterbyRate,"Selected Rate is Displayed");
		BTpage.get_ratecount();
		BTpage.getcount_calldetails_records();
		hp.logoutApplication();

	}

	//Name: TC74_Validate_BillingandTransactonPage_PaymentHistory_Section_Records
	//Description: Validate whether user is able to count the records in Payment History Section in Billing and Transaction Page
	//HOH User
	//Scripter:Rana
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC74_Validate_BillingandTransactonPage_PaymentHistory_Section_Records(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		Assert.assertTrue(BTPage.Payment_History_Section(), "User is not able to count records in Payment history section");
	}


	//Name: TC75_Validate_BillingandTransactonPage_RecentTransaction_Section_Records
	//Description: Validate whether user is able to count the records in Recent Transaction Section in Billing and Transaction Page
	//HOH User
	//Scripter:Rana
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC75_Validate_BillingandTransactonPage_RecentTransaction_Section_Records(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		//MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.Recent_Transaction_Section();
		hp.logoutApplication();

	}
	
	//Name: TC76_CL20_Validate_SuccessMsg_on_Equipment_Refresh
	//Description: Validate the success message displayed on TV equipment refresh
	//HOH User
	//Scripter:Dhruva
	//Date/Version: 04-Aug-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC76_CL20_Validate_SuccessMsg_on_Equipment_Refresh(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.TVServiceslink();
		Assert.assertTrue(MAPage.TVRefresh(), "TV Equipment success message is not displayed");
		Assert.assertTrue(MAPage.TVRefresherror(), "TV Equipment Error message is not displayed");
		hp.logoutApplication();

	}
	
	//Name: TC77_CL20_Validate_HOH_canUpdate_AdminUserDetails
	//Description: Validate whether HOH user can edit admin user details 
	//HOH User
	//Scripter:Dhruva
	//Date/Version: 05-Aug-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC77_CL20_Validate_HOH_canUpdate_AdminUserDetails(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String newPassword = testdata.get("Password1");
		String ConfirmPassword = testdata.get("ConfirmPassword");
		String ContactEmail = testdata.get("ContactEmail");
		String ContactPhone = testdata.get("Mobilephone");
		String SecurityQ = testdata.get("SecurityQuestion");
		String SecurityA = testdata.get("SecurityAnswer");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.loadUPPage();
		MAPage.SelectAdminUser();
		MAPage.Editcontact(newPassword,ConfirmPassword,ContactEmail,ContactPhone,SecurityQ,SecurityA);
		hp.logoutApplication();
	}
	
	//Name: TC78_CL20_Validate_HOH_canUpdate_StandardUserDetails
	//Description: Validate whether HOH user can edit Standard user details 
	//HOH User
	//Scripter:Dhruva
	//Date/Version: 05-Aug-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC78_CL20_Validate_HOH_canUpdate_StandardUserDetails(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String newPassword = testdata.get("Password1");
		String ConfirmPassword = testdata.get("ConfirmPassword");
		String ContactEmail = testdata.get("ContactEmail");
		String ContactPhone = testdata.get("Mobilephone");
		String SecurityQ = testdata.get("SecurityQuestion");
		String SecurityA = testdata.get("SecurityAnswer");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.loadUPPage();
		MAPage.SelectStdUser();
		MAPage.Editcontact(newPassword,ConfirmPassword,ContactEmail,ContactPhone,SecurityQ,SecurityA);
		hp.logoutApplication();
	}
	
	//Name: TC79_CL20_Validate_RefreshLimitMsg_on_Equipment_Refresh
	//Description: Validate the refresh limit message displayed on TV equipment refresh
	//HOH User
	//Scripter:Dhruva
	//Date/Version: 06-Aug-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC79_CL20_Validate_RefreshLimitMsg_on_Equipment_Refresh(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.TVServiceslink();
		Assert.assertTrue(MAPage.TVRefreshError(), "TV Equipment refresh limit message is not displayed");
		hp.logoutApplication();

	}
	
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void addUserbyHoH_T518024(Map<String,String> testdata) throws Exception {

		String randomNumbers = ((int)(Math.random()*1000))+"";
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String charterID=testdata.get("charterID")+randomNumbers;
		String lastname=testdata.get("lastname");
		String email=testdata.get("email");
		String security_question=testdata.get("security_question");
		String security_answer=testdata.get("security_answer");
		String phone=testdata.get("Mobilephone");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.loadUPPage();
		Thread.sleep(5000);
		UserPreferencePage UPPage=new UserPreferencePage(driver);
		UPPage.add_User(lastname, charterID, password, email,security_question, security_answer,phone);
		UPPage.relogin_with_added_user(charterID,password);
		hp.logoutApplication();
	}


	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void deleteUserbyHoH_C84683(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

	
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );


		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.loadUPPage();
		Thread.sleep(5000);
		UserPreferencePage UPPage=new UserPreferencePage(driver);
		UPPage.selectuser(userType.role, "Head of Household");

		UPPage.DeleteisVisible();
		//UPPage.selectuser(userType.role, "Admin");
		//UPPage.deleteUser();             
		UPPage.selectuser(userType.role, "Standard");
		UPPage.deleteUser(username);
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
	
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.loadUPPage();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		UserPreferencePage UPPage=new UserPreferencePage(driver);
		UPPage.add_User(lastname, charterID, password, email,security_question, security_answer,Mobilephone);
		UPPage.relogin_with_added_user(charterID, password);
		hp.logoutApplication();
	}

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void deleteUserbyAdmin_C84684(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
	
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.loadUPPage();
		Thread.sleep(5000);
		UserPreferencePage UPPage=new UserPreferencePage(driver);
		UPPage.selectuser(userType.role, "Admin");
		UPPage.DeleteisVisible();
		UPPage.selectuser(userType.role, "Standard");
		UPPage.deleteUser(username);
		hp.logoutApplication();
	}

	//Name: MA_UsersandPreferences_Parentalcontrols_HOH_T518044
	//Description: Validate whether the user is able to set Parental Control
	//HOH User
	//Scripter:Dhruva
	//Date/Version: 06-Oct-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void MA_UsersandPreferences_Parentalcontrols_HOH_T518044(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String PC_TV = testdata.get("PC_TV");
		String PC_Movie=testdata.get("PC_Movie");
		String PC_Unratedcontent=testdata.get("PC_Unratedcontent");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		WatchTVPage tv = new WatchTVPage(driver);
		tv.PlayMovie();//Check whether the asset is locked
		MAPage.loadUPPage();
		Thread.sleep(5000);
		UserPreferencePage UPPage=new UserPreferencePage(driver);
		UPPage.select_PC_TV(PC_TV);//change PC for TV
		UPPage.Select_PC_Movie(PC_Movie);//Change PC for Movie
		UPPage.selectAllowUnratedContent(PC_Unratedcontent);//Change PC for Unrated Content
		tv.PlayMovie();//Check whether the asset can be played now
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
	
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.loadUPPage();
		Thread.sleep(5000);
		UserPreferencePage UPPage=new UserPreferencePage(driver);
		UPPage.selectuser(userType.role, "Standard");
		UPPage.Promote_Selected_User(Account_Type);
		driver.navigate().refresh();
		UPPage.VerifyNewuserrole(NewRole);
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
	
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.loadUPPage();
		Thread.sleep(5000);
		UserPreferencePage UPPage=new UserPreferencePage(driver);
		UPPage.selectuser(userType.role, "Standard");
		UPPage.Promote_Selected_User(Account_Type);
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
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.loadUPPage();
		Thread.sleep(5000);
		UserPreferencePage UPPage=new UserPreferencePage(driver);
		UPPage.selectuser(userType.role, "Standard");
		UPPage.Promote_Selected_User(Account_Type);
		driver.navigate().refresh();
		//UPPage.VerifyNewuserrole(NewRole);
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
	
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.loadUPPage();
		Thread.sleep(5000);
		UserPreferencePage UPPage=new UserPreferencePage(driver);
		UPPage.selectuser(userType.role, "Admin");
		UPPage.Promote_Selected_User(Account_Type);
		//driver.navigate().refresh();
		UPPage.VerifyNewuserrole(NewRole);
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
	
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.loadUPPage();
		Thread.sleep(5000);
		UserPreferencePage UPPage=new UserPreferencePage(driver);
		UPPage.selectuser(userType.role, "Admin");
		UPPage.Demote_Selected_User(Account_Type);
		//driver.navigate().refresh();
		UPPage.VerifyNewuserrole(NewRole);
		UPPage.Relogin(Relogin_UserID, Relogin_Password);
		MAPage.openMyAccountTab();
		MAPage.loadUPPage();
		hp.logoutApplication();
	}

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void Validate_MyAccount_UsersPreferences_non_convertedUser_HOH_T518026(Map<String,String> testdata) throws Exception{
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
           
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
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
		//MAPage.openMyAccountTab();
		MAPage.loadUPPage();

		UserPreferencePage UPPage=new UserPreferencePage(driver);
		UPPage.add_User(lastname, charterID, password, email,security_question, security_answer,Mobilephone);
		hp.logoutApplication();
		hp.loadCharterPage(URL);
		hp.login(charterID, password);
		UPPage.checkBilling();
		hp.logoutApplication();
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MAPage.loadUPPage();
		UPPage.selectuser(userType.username, charterID);
		UPPage.Promote_Selected_User("Admin");
		hp.logoutApplication();
		hp.loadCharterPage(URL);
		hp.login(charterID, password);
		UPPage.checkBilling();
		hp.logoutApplication();
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MAPage.loadUPPage();
		UPPage.selectuser(userType.username,charterID);
		UPPage.Demote_Selected_User("Standard");
		hp.logoutApplication();
		hp.loadCharterPage(URL);
		hp.login(charterID, password);
		UPPage.checkBilling();
		hp.logoutApplication();
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MAPage.loadUPPage();
		UPPage.selectuser(userType.username,charterID);
		Assert.assertTrue(UPPage.deleteUser(charterID), "User is not able to delete Selected user");
		hp.logoutApplication();
		hp.loadCharterPage(URL);
		AuthenticationPage auth = new AuthenticationPage(driver);
		auth.InValidLogin(charterID, password);
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
		//MAPage.openMyAccountTab();
		MAPage.loadUPPage();
		UserPreferencePage UPPage=new UserPreferencePage(driver);
		UPPage.add_User(lastname, charterID, password, email,security_question, security_answer,Mobilephone);
		UPPage.selectuser(userType.username, charterID);
		UPPage.Promote_Selected_User("Admin");
		hp.logoutApplication();
		hp.login("E2E5034", password );  
		//MAPage.openMyAccountTab();
		MAPage.loadUPPage();
		UPPage.selectuser(userType.username, charterID);
		UPPage.Demote_Selected_User("Standard");
		UPPage.selectuser(userType.username,charterID);
		Assert.assertTrue(UPPage.deleteUser(charterID), "User is not able to delete Selected user");
		hp.logoutApplication();
	}

	// If you click on Reschedule button, calendar should be displayed to Reschedule the appointment 
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)

	public void MA_SAP_Rescheduleappointment_HOH_T517997(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		OverviewPage Vpage=new OverviewPage(driver);
		Vpage.Overviewlink();
		Vpage.Reschedule_Appointment();
		hp.logoutApplication();
	}

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)

	public void MA_SAP_Rescheduleappointment_Admin_T517998(Map<String,String> testdata) throws Exception {


		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		OverviewPage Vpage=new OverviewPage(driver);
		Vpage.Overviewlink();
		Vpage.Reschedule_Appointment();

		hp.logoutApplication();
	}


	// If you click on Reschedule button Message should be displayed
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)

	public void MA_SAP_Rescheduleinstalledwork_HOH_T518001(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		OverviewPage Vpage=new OverviewPage(driver);
		Vpage.Overviewlink();
		Vpage.Reschedule_Appointment();

		hp.logoutApplication();
	}



	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)

	public void MA_SAP_Rescheduleinstalledwork_Admin_T518002(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		OverviewPage Vpage=new OverviewPage(driver);
		Vpage.Overviewlink();
		Vpage.Reschedule_Appointment();
		hp.logoutApplication();
	}

	// Cancel Appointment
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)

	public void MA_SAP_Cancel_appointment_HOH_T517999(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		OverviewPage Vpage=new OverviewPage(driver);
		Vpage.Overviewlink();
		Vpage.Cancel_Appointment();
		hp.logoutApplication();

	}

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)

	public void MA_SAP_Cancel_appointment_Admin_T518000(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		OverviewPage Vpage=new OverviewPage(driver);
		Vpage.Overviewlink();
		Vpage.Cancel_Appointment();
		hp.logoutApplication();

	}


	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void validate_TVInternetVoice_DetailsLink_T517987(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		OverviewPage Ovrpge=new OverviewPage(driver);
		Ovrpge.TVInternetVoiceLInk();
		TVServicesPage tvs=new TVServicesPage(driver);
		MAPage.openMyAccountTab();
		tvs.viewChLineup();
		MAPage.openMyAccountTab();
		InternetServicesPage isp =new InternetServicesPage(driver);
		isp.CharterEmail_link();
		EmailPage ep = new EmailPage(driver);
		ep.OpenMyAccount();
		isp.charterSecuritySuitelink();
		MAPage.openMyAccountTab();
		VoiceServicesPage vsp=new VoiceServicesPage(driver);
		vsp.VoiceOnlineManagerLink();
		MAPage.openMyAccountTab();
		hp.logoutApplication();
	}

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)

	public void MyAccount_ServiceAndEquipment_TV_T517981(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");	
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		//driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		OverviewPage Ovrpge=new OverviewPage(driver);
		Ovrpge.VerifyOverViewPageTitle();
		Ovrpge.validateServiceAndEquipment_TV();
		hp.logoutApplication();

	}

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)

	public void MyAccount_ServiceAndEquipment_Internet_T517988(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		// driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		OverviewPage Ovrpge=new OverviewPage(driver);
		Ovrpge.VerifyOverViewPageTitle();
		Ovrpge.validateServiceAndEquipment_Internet();
		hp.logoutApplication();

	}

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)

	public void MyAccount_ServiceAndEquipment_Voice_T517992(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		// driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		OverviewPage Ovrpge=new OverviewPage(driver);
		Ovrpge.VerifyOverViewPageTitle();
		Ovrpge.validateServiceAndEquipment_Voice();
		hp.logoutApplication();
	}
	
	//Name: TC80_Validate_DateOfPayment_Selection()
	//Description: Validate Billing and Transactions section in Overview page
	//HOH User
	//Scripter:Dhruva
	//Date/Version:17-Aug-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC80_Validate_DateOfPayment_Selection(Map<String,String> testdata) throws Exception {	
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.PayBill();
		BillingAndTransactionsPage bt = new BillingAndTransactionsPage(driver);
		Assert.assertTrue(bt.daysOfPayment(),"Number of days available for future payment is more or less than 30 days from current date");
		hp.logoutApplication();
	}
	
	//Name: TC81_Validate_AutopayStatus()
	//Description: Autopay status should be displayed as "Enroll Now", "Pending" or "Enrolled"
	//HOH User
	//Scripter:Dhruva
	//Date/Version:17-Aug-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC81_Validate_AutopayStatus(Map<String,String> testdata) throws Exception {	
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.autoPayStatus();
		hp.logoutApplication();
	}
	
	//Name: TC82_Validate_ViewBillDetails_link_HOH()
	//Description: Verify the HOH user is re-directed to Billing & Transactions page when user clicks on 'Details' link.
	//HOH User
	//Scripter:Dhruva
	//Date/Version:18-Aug-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC82_Validate_ViewBillDetails_link_HOH(Map<String,String> testdata) throws Exception {	
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		Assert.assertTrue(MA.viewBillDetailLink(),"User is not redirected to Billing Page");
		hp.logoutApplication();
	}
	
	//Name: TC83_Validate_ViewBillDetails_link_admin()
	//Description: Verify the Admin user is re-directed to Billing & Transactions page when user clicks on 'Details' link.
	//Admin User
	//Scripter:Dhruva
	//Date/Version:18-Aug-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC83_Validate_ViewBillDetails_link_admin(Map<String,String> testdata) throws Exception {	
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		Assert.assertTrue(MA.viewBillDetailLink(),"User is not redirected to Billing Page");
		hp.logoutApplication();
	}
	
	//Name: TC84_Validate_BillingAndTransaction_PayBillLink_NavigateTo_PaymentOption_adminUser()
	//Description: Validate navigating to Payment Options page by clicking on "Pay Bill" button  
	//Admin User
	//Scripter:Dhruva
	//Date/Version:18-Aug-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC84_Validate_BillingAndTransaction_PayBillLink_NavigateTo_PaymentOption_adminUser(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.loadBillingAndTransactionSection();
		OverviewPage OVPage1=new OverviewPage(driver);
		Assert.assertTrue(OVPage1.BTPage_PaybillLink(),"User is - Not Navigated to Payment options page - Failed");
		hp.logoutApplication();
	}
	
	//Name: TC85_Validate_ViewBillStatements_adminUser()
	//Description: Verify whether the user is able to view available statements associated with the account
	//Admin User
	//Scripter:Dhruva
	//Date/Version:18-Aug-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC85_Validate_ViewBillStatements_adminUser(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		Assert.assertTrue(MAPage.ViewBillStmtLink(),"User is not Navigated current bill statement");
		MAPage.loadBillingAndTransactionSection();
		BTPage1 bt=new BTPage1(driver);
		Assert.assertTrue(bt.lastStatements(),"Last statements are not displayed");
		MAPage.printAvailablePDF();		
		hp.logoutApplication();
	}
	
	//Name: TC86_Validate_UserPreferencesSection_AccountControl_HOHUser()
	//Description: Verify whether the user is able to promote/demote any of the roles and manage Account controls section.
	//HOH User
	//Scripter:Dhruva
	//Date/Version:19-Aug-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC86_Validate_UserPreferencesSection_AccountControl_HOHUser(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.loadUPPage();
		UserPreferencePage UP=new UserPreferencePage(driver);
		UP.AccountControls();
		hp.logoutApplication();
	}
	
	//Name: TC87_Validate_UserPreferencesSection_AccountControl_adminUser()
	//Description: Verify whether the user is able to promote/demote any of the roles and manage Account controls section.
	//Admin User
	//Scripter:Dhruva
	//Date/Version:19-Aug-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC87_Validate_UserPreferencesSection_AccountControl_adminUser(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.loadUPPage();
		UserPreferencePage UP=new UserPreferencePage(driver);
		UP.AccountControls();
		hp.logoutApplication();
	}
	
	//Name: TC88_Validate_OverviewPageHeaders_AdminUser()
	//Description: Validate navigating to My Account Overview page and verify all the links,headers in overview page
	//Admin User
	//Scripter:Dhruva
	//Date/Version:24-Aug-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC88_Validate_OverviewPageHeaders_AdminUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		//MA.loadOverviewPage();
		OverviewPage OVPage1=new OverviewPage(driver);
		verifyAssert(OVPage1.BTSectionText(),"Billing","BTSection");
		verifyAssert(OVPage1.SESectionText(),"Services and Equipment","SE Section");
		verifyAssert(OVPage1.UpsectionText(),"Settings","UP Section");
		verifyAssert(OVPage1.ServiceAddressLabel(),"Service","Service Address Label");
		verifyAssert(OVPage1.BillingAddressLabel(),"Billing Address","Billing Address Label");
		/*verifyAssert(OVPage1.FooterWatchTV(),"Watch TV","Footer Watch TV");
		verifyAssert(OVPage1.FooterMyAccount(),"My Account","Footer My Account");
		verifyAssert(OVPage1.FooterSupport(),"Support","Footer Support");*/
	/*	Assert.assertTrue(OVPage1.OverviewHeaders(), "User is not able to view overview headers");*/
		hp.logoutApplication();
	}
	
	//Name: TC89_Validate_BillingAndTransactionPage_BillDeliveryStatus_HOHUser()
	//Description: Verify the text 'Go Green' shall be displayed in the Bill Delivery status if the current bill delivery is Paper & Online and text 'Online Bill' shall be displayed in the Bill Delivery status if the current bill delivery is Online.
	//HOH User
	//Scripter:Dhruva
	//Date/Version:24-Aug-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC89_Validate_BillingAndTransactionPage_BillDeliveryStatus_HOHUser(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		//MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTP=new BillingAndTransactionsPage(driver);
		Assert.assertTrue(BTP.BilldeliveryStatus(), "User is not able to view Bill Delivery Status");
		hp.logoutApplication();
	}
	
	//Name: TC90_Validate_BillingAndTransactionPage_ViewCurrentBillLink_NavigateTo_CurrentBillPage_AdminUser()
	//Description: Validate current bill of the user by clicking on "View Current Bill" link 
	//Admin User
	//Scripter:Dhruva
	//Date/Version:24-Aug-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC90_Validate_BillingAndTransactionPage_ViewCurrentBillLink_NavigateTo_CurrentBillPage_AdminUser(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		//MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTP=new BillingAndTransactionsPage(driver);
		Assert.assertTrue(BTP.ViewCBillLink(), "User is not able to view bill with View Current bill link");
		hp.logoutApplication();
	}
	
	//Name: TC91_Validate_BillingAndTransactionPage_ContactInfoSection_Adminuser()
	//Description: Validate Contact Info section  
	//Admin User
	//Scripter:Dhruva	
	//Date/Version:24-Aug-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC91_Validate_BillingAndTransactionPage_ContactInfoSection_Adminuser(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		//MA.openMyAccountTab();
		MA.loadBillingAndTransactionSection();
		BTPage1 BTP1=new BTPage1(driver);
		Assert.assertTrue(BTP1.ContactInfo(), "Contact Info Section is -Not Present");
		hp.logoutApplication();
	}
	
	//Name: TC92_Validate_BillingAndTransactionPage_ContactInfoSection_Standarduser()
	//Description: Validate Contact Info section  
	//Standard User
	//Scripter:Dhruva	
	//Date/Version:24-Aug-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC92_Validate_BillingAndTransactionPage_ContactInfoSection_Standarduser(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		//MA.openMyAccountTab();
		MA.loadUPPage();
		Assert.assertTrue(MA.AccountInfo(), "Account Info Section available for Standard User");
		hp.logoutApplication();
	}
	
	//Name: TC93_Validate_UserPreferencesPage_EditFields_AdminUser()
	//Description: Validate Edit fields of Password,Contact Email,Phone,Security question
	//Admin User
	//Scripter:Dhruva
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC93_Validate_UserPreferencesPage_EditFields_AdminUser(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String email=testdata.get("email");
		String security_question=testdata.get("security_question");
		String security_answer=testdata.get("security_answer");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		//MAPage.openMyAccountTab();
		MAPage.loadUPPage();
		UserPreferencePage UPpage=new UserPreferencePage(driver);
		Assert.assertTrue(UPpage.EditContactFields_UP(password,email,security_question,security_answer), "User is -Not able to Edit fields of Password,Contact Email,Phone,Security question of Users");
		hp.logoutApplication();
	}
	
	//Name: TC94_Validate_UserPreferencesPage_EmailControlSection_StdUser()
	//Description:Validate Email controls section(including help icon)
	//Standard User
	//Scripter:Dhruva
	//Date/Version:26-Aug-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC94_Validate_UserPreferencesPage_EmailControlSection_StdUser(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		//MAPage.openMyAccountTab();
		MAPage.loadUPPage();
		UserPreferencePage UPpage=new UserPreferencePage(driver);
		Assert.assertFalse(UPpage.EmailSection(username), "Email controls Section is available for standard user in User Preferences Page");
		hp.logoutApplication();
	}
	
	//Name: TC95_Validate_CurrentBillStatement_PrintPDF()
	//Description:Verify whether the user is able to print the Current Bill statement
	//HOH User
	//Scripter:Dhruva
	//Date/Version:27-Aug-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC95_Validate_CurrentBillStatement_PrintPDF(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTP=new BillingAndTransactionsPage(driver);
		BTP.printCurrentPDF();
		hp.logoutApplication();
	}
	
	//Name: TC96_Validate_AvailableBillStatement_PrintPDF()
	//Description:Verify whether the user is able to print the available statements
	//HOH User
	//Scripter:Dhruva
	//Date/Version:27-Aug-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC96_Validate_AvailableBillStatement_PrintPDF(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.loadBillingAndTransactionSection();
		MAPage.printAvailablePDF();
		hp.logoutApplication();
	}
	
	//Name: TC97_Validate_OverviewPage_ViewPaymentViewDate_AdminUser()
	//Description: Validate whether the user is able to view Payment Due Date on clicking 'View Payment Due Date' in Overview page.
	//Admin User
	//Scripter:Dhruva
	//Date/Version:28-Aug-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC97_Validate_OverviewPage_ViewPaymentViewDate_AdminUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);

		MyAccountPage MA=new MyAccountPage(driver);
		//MA.openMyAccountTab();
		MA.loadOverviewPage();
		BillingAndTransactionsPage BTP=new BillingAndTransactionsPage(driver);
		Assert.assertTrue(BTP.viewduedate(), "User -Not able to Navigate to view Payment Due Date");
		hp.logoutApplication();
	}
	
	//Name: TC98_Validate_MyAccount_FirstTime_Access()
	//Description: Validate whether user is asked to select a delivery option on first time accessing My Account
	//HOH user
	//Scripter:Dhruva
	//Date/Version:07-Sep-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC98_Validate_MyAccount_FirstTime_Access(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		hp.MyAccounttab();
		OverviewPage ov = new OverviewPage(driver);
		Assert.assertTrue(ov.firstTimeMyAccount(),"Bill Delivery Options are not diaplayed on first time accessing My Account");
	}
	
	//Name: TC99_Validate_UserPreferences_CreateID_Promote_demote_deleteUser_HOH()
	//Description: Validate whether HOH user is able to create standard user, 
	//promote standard user to admin, demote admin to standard and delete the same user//
	//HOH User
	//Scripter:Dhruva
	//Date/Version: 7-Oct-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC99_Validate_UserPreferences_CreateID_Promote_demote_deleteUser_HOH(Map<String,String> testdata) throws Exception{
		String randomNumbers = RandomStringUtils.randomNumeric(3);
		String password = testdata.get("UserPassword");
		String charterID=testdata.get("charterID")+randomNumbers;
		String email=testdata.get("email");
		String firstname_CID=testdata.get("firstname_CID");
		String lastname_CID=testdata.get("lastname_CID");
		String Address_CID=testdata.get("address_CID");
		String Zipcode_CID=testdata.get("zipcode_CID");
		String MAC_CID=testdata.get("mac_CID");
		String Mobilephone=testdata.get("Mobilephone");
		String security_question=testdata.get("security_question");
		String security_answer=testdata.get("security_answer");
		String hohuser=testdata.get("hohuser");
		String ACnumber=testdata.get("ACnumber");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		auth.createuser_Std(ACnumber,firstname_CID,lastname_CID,Address_CID,Zipcode_CID,MAC_CID,charterID, password, email,security_question, security_answer,Mobilephone);
		hp.logoutApplication();
		hp.login(hohuser, password);
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.loadUPPage();
		UserPreferencePage UPPage=new UserPreferencePage(driver);
		UPPage.selectuser(userType.username, charterID);
		UPPage.Promote_Selected_User("Admin");
		UPPage.selectuser(userType.username,charterID);
		UPPage.Demote_Selected_User("Standard");
		UPPage.selectuser(userType.username,charterID);
		Assert.assertTrue(UPPage.deleteUser(charterID), "User is not able to delete Selected user");
		hp.logoutApplication();
	}
	
	//Name: TC100_Validate_ParentalControlChanges_StandardUser()
	//Description: Verify whether logged in user is restricted based on the parental control set by Primary/HOH
	//Standard User
	//Scripter:Dhruva
	//Pre-requisite:User must be logged in as Standard user.
	//				Parental control should have been set to some assets by Primary/HOH User
	//Date/Version: 8-Oct-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC100_Validate_ParentalControlChanges_StandardUser(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String PC_Movie=testdata.get("PC_Movie");
		String hohuser = testdata.get("hohuser");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		WatchTVPage tv = new WatchTVPage(driver);
		tv.PlayMovie();//Check whether the asset is locked
		hp.logoutApplication();
		hp.login(hohuser, password);
		MAPage.loadUPPage();
		Thread.sleep(5000);
		UserPreferencePage UPPage=new UserPreferencePage(driver);
		UPPage.selectuser(userType.username, username);
		UPPage.ParentalSection();
		UPPage.Select_PC_Movie(PC_Movie);//Change PC for Movie
		hp.logoutApplication();
		hp.login(username, password);
		tv.PlayMovie();//Check whether the asset can be played now
		hp.logoutApplication();
		hp.login(hohuser, password);
		MAPage.loadUPPage();
		Thread.sleep(5000);
		UPPage.selectuser(userType.username, username);
		UPPage.ParentalSection();
		UPPage.Select_PC_Movie(PC_Movie);//Change PC for Movie
		hp.logoutApplication();
	}
	
	//Name: TC101_Validate_ErrorMsg_InvalidCouponRedemption()
	//Description: Validation of invalid coupon for redemption
	//HOH User
	//Scripter:Dhruva
	//Pre-requisite:Provision the triple play account in legacy through Sigma/CSG from East time zone
	//Date/Version: 13-Oct-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC101_Validate_ErrorMsg_InvalidCouponRedemption(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String couponNumber=testdata.get("couponNumber");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.couponGiftsLink();
		MAPage.redeemCoupon(couponNumber);
		hp.logoutApplication();
	}
	
	//Name: TC102_Validate_SuccessMsg_ValidCouponRedemption()
	//Description: Validation of Valid coupon for redemption
	//HOH User
	//Scripter:Dhruva
	//Pre-requisite:Provision the triple play account in legacy through Sigma/CSG from East time zone
	//Date/Version: 13-Oct-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC102_Validate_SuccessMsg_ValidCouponRedemption(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String couponNumber=testdata.get("couponNumber");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.couponGiftsLink();
		MAPage.redeemCoupon(couponNumber);
		hp.logoutApplication();
	}
	
	//Name: TC103_Validate_ErrorMsg_SameCouponRedemption()
	//Description: Validation of Valid coupon for redemption
	//HOH User
	//Scripter:Dhruva
	//Pre-requisite:Provision the triple play account in legacy through Sigma/CSG from East time zone
	//Date/Version: 13-Oct-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC103_Validate_ErrorMsg_SameCouponRedemption(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String couponNumber=testdata.get("couponNumber");
		String UserID1 = testdata.get("UserID1");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.couponGiftsLink();
		MAPage.redeemCoupon(couponNumber);
		hp.logoutApplication();
		hp.login(UserID1, password );

		MAPage.openMyAccountTab();
		MAPage.couponGiftsLink();
		MAPage.redeemCoupon(couponNumber);
		
	}
	
	@AfterMethod
	public void afterMethod() throws InterruptedException{
		Thread.sleep(4000);
		driver.manage().deleteAllCookies();
		driver.close();
	}
}
