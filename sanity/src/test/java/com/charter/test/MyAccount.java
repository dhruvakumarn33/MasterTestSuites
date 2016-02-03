package com.charter.test;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.charter.page.BTPage1;
import com.charter.page.BillingAndTransactionsPage;
import com.charter.page.HomePage;
import com.charter.page.InternetServicesPage;
import com.charter.page.MyAccountPage;
import com.charter.page.OverviewPage;
import com.charter.page.TVServicesPage;
import com.charter.page.UserPreferencePage;
import com.charter.page.VoiceServicesPage;
import com.charter.page.UserPreferencePage.userType;
import com.charter.utils.Constants;
import com.charter.utils.DataProviderClass;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.TestNGBase;

public class MyAccount extends TestNGBase{
	private String URL= Constants.URL;

	//Name: TC01_Validate_OverviewPageHeaders_HOHUser()
	//Description: Validate navigating to My Account Overview page and verify all the links,headers in overview page
	//HOH User
	//Scripter:Ayesha
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC01_Validate_OverviewPageHeaders_HOHUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.loadOverviewPage();
		OverviewPage OVPage1=new OverviewPage(driver);
		verifyAssert(OVPage1.BTSectionText(),"Billing","BTSection");
		//verifyAssert(OVPage1.SESectionText(),"Services and Equipment","SE Section");
		//verifyAssert(OVPage1.UpsectionText(),"Settings","UP Section");
		//verifyAssert(OVPage1.ServiceAddressLabel(),"Service Address:","Service Address Label");
		//verifyAssert(OVPage1.BillingAddressLabel(),"Billing Address:","Billing Address Label");
		//verifyAssert(OVPage1.FooterWatchTV(),"Watch TV","Footer Watch TV");
		//verifyAssert(OVPage1.FooterMyAccount(),"My Account","Footer My Account");
		//verifyAssert(OVPage1.FooterSupport(),"Support","Footer Support");
		//Assert.assertTrue(OVPage1.OverviewHeaders(), "User is not able to view overview headers");
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
		MA.loadOverviewPage();
		OverviewPage OVPage=new OverviewPage(driver);
		Assert.assertTrue(OVPage.AskCharterSection(), "Ask Charter Section- Not present ");
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
		MA.loadOverviewPage();
		OverviewPage OVPage1=new OverviewPage(driver);
		Assert.assertTrue(OVPage1.TV_Internet_Voice_DetailsLink(), "User is not able to verify Details links for TV, Internet and Voice Services in Overview page");
		hp.logoutApplication();

	}
	
	//Name: TC13_Validate_OverviewPage_AvatarImagesViewProfile_HOHUser()
	//Description: Validate whether the user is able to view his and other user profiles on clicking the Avatar images in Overview page.
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC13_Validate_OverviewPage_AvatarImagesViewProfile_HOHUser(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadOverviewPage();
		WebElement wHOH= driver.findElement(By.xpath("(//*[@class='user-avatar']/img)[1]"));
		wHOH.click();
		WebElement wStandard=driver.findElement(By.xpath("(//*[@class='user-avatar']/img)[2]"));
		wStandard.click();
		WebElement wAdmin=driver.findElement(By.xpath("(//*[@class='user-avatar']/img)[3]"));
		wAdmin.click();
		//OverviewPage OVpage=new OverviewPage(driver);
		//Assert.assertTrue(OVpage.AvatarImages(), "User is not able to view profiles on clicking Avatar Images in overview page");
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
		MA.loadOverviewPage();
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
		MA.loadOverviewPage();
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
		MA.loadOverviewPage();
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
		MA.loadOverviewPage();
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
		MA.loadOverviewPage();
		OverviewPage OVPage=new OverviewPage(driver);
		Assert.assertFalse(OVPage.UpgradeLink_Standard(), "Upgrde link Exists for Standard User");
		//hp.logoutApplication();
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
		MA.loadOverviewPage();
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
		MA.openMyAccountTab();
		MA.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		Assert.assertTrue(BTPage.BillingAndTransactionHeaders(), "Headres are -Not displayed in Billing and Transaction page");
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
		MAPage.openMyAccountTab();
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
		MAPage.openMyAccountTab();
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
		MAPage.openMyAccountTab();
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
		MAPage.openMyAccountTab();
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
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
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
		MA.openMyAccountTab();
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
		MA.openMyAccountTab();
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
		MA.openMyAccountTab();
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
		MA.openMyAccountTab();
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
		MA.openMyAccountTab();
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
		MA.openMyAccountTab();
		MA.loadBillingAndTransactionSection();
		BTPage1 BTP1=new BTPage1(driver);
		Assert.assertTrue(BTP1.ChangeNameLink(), "User -Not able to navigate to Transfer account ownership Page");
		driver.quit();
		//hp.logoutApplication();
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
		MA.openMyAccountTab();
		MA.loadBillingAndTransactionSection();
		BTPage1 BTP1=new BTPage1(driver);
		Assert.assertTrue(BTP1.TMSLink(), "User -Not able to navigate to Charter Mover Resource Page");
		driver.quit();
		//hp.logoutApplication();

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
		MA.openMyAccountTab();
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
		MA.openMyAccountTab();
		MA.loadBillingAndTransactionSection();
		BillingAndTransactionsPage OVPage1=new BillingAndTransactionsPage(driver);
		Assert.assertTrue(OVPage1.BTPage_CallDetailsLink(), "User is -Not Navigated to Call Details page");
		driver.quit();
		//hp.logoutApplication();
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
		MA.openMyAccountTab();
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
		MA.openMyAccountTab();
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
		MAPage.openMyAccountTab();
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
		MAPage.openMyAccountTab();
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
		MA.openMyAccountTab();
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
		MA.openMyAccountTab();
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
		MA.openMyAccountTab();
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
		MA.openMyAccountTab();
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
		MA.openMyAccountTab();
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
		MA.openMyAccountTab();
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
		MA.openMyAccountTab();
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
		MA.openMyAccountTab();
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
		MA.openMyAccountTab();
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
		MA.openMyAccountTab();
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
		MA.openMyAccountTab();
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
		MA.openMyAccountTab();
		MA.InternetServiceslink();InternetServicesPage INpage=new InternetServicesPage(driver);
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
		MAPage.openMyAccountTab();
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
		MAPage.openMyAccountTab();
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
		MAPage.InternetServiceslink();
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
		MA.openMyAccountTab();
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
		MA.openMyAccountTab();
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
		MA.openMyAccountTab();
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
		MA.openMyAccountTab();
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
		MA.openMyAccountTab();
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
		MA.openMyAccountTab();
		MA.VoiceServiceslink();
		VoiceServicesPage voicepage=new VoiceServicesPage(driver);
		Assert.assertTrue(voicepage.CharterPhoneLink(),"User is -Not able to Navigate to Charter Voice page by clicking Charter Phone button -Failed");
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
		MA.openMyAccountTab();
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
		MAPage.openMyAccountTab();
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
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
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

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadUPPage();
		UserPreferencePage UPpage=new UserPreferencePage(driver);
		Assert.assertTrue(UPpage.BillingAddress_Edit(Address1,Address2,City,State,Zipcode), "User is -Not able to Edit  Billing Address fields");
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
		MAPage.openMyAccountTab();
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
		MAPage.openMyAccountTab();
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
		MAPage.openMyAccountTab();
		MAPage.loadUPPage();
		UserPreferencePage UPpage=new UserPreferencePage(driver);
		Assert.assertTrue(UPpage.EmailSection(), "User is -Not able to access Email controls Section in User Preferences Page");
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
		MAPage.openMyAccountTab();
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
		MAPage.openMyAccountTab();
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
		MAPage.openMyAccountTab();
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
		MAPage.openMyAccountTab();
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
		MAPage.openMyAccountTab();
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
		MAPage.openMyAccountTab();
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
		myAccPage.openMyAccountTab();
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
		MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.Recent_Transaction_Section();
		hp.logoutApplication();

	}
	//@AfterMethod
	public void afterMethod() throws InterruptedException{
		Thread.sleep(4000);
		driver.manage().deleteAllCookies();
		driver.close();
	}
}
