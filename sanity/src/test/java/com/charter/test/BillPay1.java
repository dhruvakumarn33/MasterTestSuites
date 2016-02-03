
package com.charter.test;

import java.io.File;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.charter.page.BillingAndTransactionsPage;
import com.charter.page.HomePage;
import com.charter.page.MyAccountPage;
import com.charter.utils.Constants;
import com.charter.utils.DataProviderClass;
import com.cognizant.framework.core.CaptureScreenshot;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.TestNGBase;

public class BillPay1 extends TestNGBase{

	private String URL= Constants.URL;

	@BeforeSuite
	public void setproperty(){
		System.setProperty("webdriver.ie.driver.logfile","E:/logfile.log");
	}

	//Name: TBB_12_Validate_HOH_user_able_to_Manage_BillDelivery_Method_C84921()
	//Description: Validate whether HOH user is able to View/Manage the current Bill Delivery Method
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TBB_12_Validate_HOH_user_able_to_Manage_BillDelivery_Method_C84921(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		Assert.assertTrue(BTPage.Manage_BillDelivery(),"User is not able view Current Bill Delivery Method");
		hp.logoutApplication();

	}
	//Name: TBB_11_Validate_Admin_user_able_to_Manage_BillDelivery_Method_C84922()
	//Description: Validate whether Admin user is able to View/Manage the current Bill Delivery Method
	//Admin User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TBB_11_Validate_Admin_user_able_to_Manage_BillDelivery_Method_C84922(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("C84922"+ File.separator + "LoginPage");
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();
		screenshot.saveScreenshot("C84922"+ File.separator + "Billing and Transaction Page");
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.Manage_BillDelivery();
		hp.logoutApplication();
	}

	//Name: TBB_19_validate_HOH_user_able_to_Edit_ContactInfo_BillingandTransaction_Page_T518104()
	//Description: Validate whether HOH user is able to Edit Contact Info in Billing and Transaction Page
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TBB_19_validate_HOH_user_able_to_Edit_ContactInfo_BillingandTransaction_Page_T518104(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String Address1=testdata.get("Address1");
		String Address2=testdata.get("Address2");
		String City=testdata.get("City");
		String State=testdata.get("State");
		String Zipcode=testdata.get("Zipcode");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		Assert.assertTrue(BTPage.Edit_contact_Button(Address1, Address2, City, State, Zipcode), "User is not able to Edit Contact info in Billing and Transaction Section");
		hp.logoutApplication();

	}
	//Name: TBB_20_validate_Admin_user_able_to_Edit_ContactInfo_BillingandTransaction_Page_T518105()
	//Description: Validate whether Admin user is able to Edit Contact Info in Billing and Transaction Page
	//Admin User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TBB_20_validate_Admin_user_able_to_Edit_ContactInfo_BillingandTransaction_Page_T518105(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String Address1=testdata.get("Address1");
		String Address2=testdata.get("Address2");
		String City=testdata.get("City");
		String State=testdata.get("State");
		String Zipcode=testdata.get("Zipcode");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.Edit_contact_Button(Address1, Address2, City, State, Zipcode);
		hp.logoutApplication();
	}

	//Name: TBB_21_validate_Standard_user_able_to_Edit_ContactInfo_BillingandTransaction_Page_T518106()
	//Description: Validate whether Standard user is able to Edit Contact Info in Billing and Transaction Page and User should display with Error Message
	//Standard User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TBB_21_validate_Standard_user_able_to_Edit_ContactInfo_BillingandTransaction_Page_T518106(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518106"+ File.separator + "LoginPage");
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();
		screenshot.saveScreenshot("T518106"+ File.separator + "Billing and Transaction Page");
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		Assert.assertTrue(BTPage.Edit_contact_Standard(), "Error message is not displayed when Standard user is trying to edit contact info in billing and transation page");
		hp.logoutApplication();
	}

	//Name: TBB_22_Validate_PaymentHistorySection_Viewmorelink_T518112()
	//Description: Validate whether user is able to view Payment history in billing and transaction page
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TBB_22_Validate_PaymentHistorySection_Viewmorelink_T518112(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518112"+ File.separator + "LoginPage");
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();
		screenshot.saveScreenshot("T518112"+ File.separator + "Billing and Transaction Page");
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.Payment_History();
		hp.logoutApplication();
	}

	//Name: TBB_23_Validate_RecentTransactionsSection_Viewmorelink_T518117()
	//Description: Validate whether user is able to view Recent Transactions in billing and transaction page
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TBB_23_Validate_RecentTransactionsSection_Viewmorelink_T518117(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518117"+ File.separator + "LoginPage");
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();
		screenshot.saveScreenshot("T518117"+ File.separator + "Billing and Transaction Page");
		Thread.sleep(5000);
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.Recent_Transactions();
		hp.logoutApplication();
	}
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)

	public void AutoPaymentThroughDebitCard_T518255(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String DCtype = testdata.get("CardType");
		String DCNo = testdata.get("CardNumber");
		String DCExpMonth = testdata.get("ExpDate");
		String DCExpyear = testdata.get("ExpYear");
		String AutoapayConfirmMsg = ReadFromExcel.getData("Payments","AutoapayConfirmMsg");

		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518255"+ File.separator + "LoginPage");
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();

		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		driver.navigate().refresh();
		screenshot.saveScreenshot("T518255"+ File.separator + "Autopay Page");
		BTPage.Autopay_DC(DCtype, DCNo, DCExpMonth, DCExpyear);
		screenshot.saveScreenshot("T518255"+ File.separator + "clicked on Terms and conditions ");
		BTPage.TermsandConditions();
		BTPage.AgreeButton();
		BTPage.AutopayConfirm();
		verifyAssert(BTPage.getautopayConfirmationMsg(), AutoapayConfirmMsg,"Payment Confirmation Message");
		screenshot.saveScreenshot("T518255"+ File.separator + "Autopay confirmation Page");
		hp.logoutApplication();
	}




	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class,dependsOnMethods = {"AutoPaymentThroughDebitCard_T518255"})
	public void RetainAutoPayment_DC_T518708(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518708"+ File.separator + "LoginPage");
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();

		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		driver.navigate().refresh();
		screenshot.saveScreenshot("T518708"+ File.separator + "Cancel AutoPay Page");
		BTPage.Retain_Autopay();
		hp.logoutApplication();
	}

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class,dependsOnMethods = {"AutoPaymentThroughDebitCard_T518255","RetainAutoPayment_DC_T518708"})
	public void cancelAutoPayment_DC_T518707(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518707"+ File.separator + "LoginPage");
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		screenshot.saveScreenshot("T518707"+ File.separator + "Cancel AutoPay Page");
		driver.navigate().refresh();
		screenshot.saveScreenshot("T518707"+ File.separator + "Cancel AutoPay Page");
		BTPage.Cancel_AutoPay();
		Thread.sleep(2000);
		hp.logoutApplication();	
	}

	//Name: TBB_03_Validate_HOH_user_able_Autopay_with_CC_T518254()
	//Description: Validate whether HOH user is able to do Auto pay Set-up with CC
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)	
	public void TBB_03_Validate_HOH_user_able_Autopay_with_CC_T518254(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String CCtype = testdata.get("CardType");
		String CCNo = testdata.get("CardNumber");
		String CCExpMonth = testdata.get("ExpDate");
		String CCExpyear = testdata.get("ExpYear");
		String AutopayConfirmMsg = ReadFromExcel.getData("Payments","AutoapayConfirmMsg");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		driver.navigate().refresh();
		Assert.assertTrue(BTPage.Autopay_CC(CCtype, CCNo, CCExpMonth, CCExpyear), "User is not able to select auto pay and enter the card details");
		BTPage.TermsandConditions();
		BTPage.AgreeButton();
		verifyAssert(BTPage.getautopayConfirmationMsg(), AutopayConfirmMsg,"Payment Confirmation Message");
		hp.logoutApplication();
	}

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class,dependsOnMethods = {"AutoPaymentThroughCreditCard_T518254"})
	//@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void RetainAutoPayment_CC_T518706(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518706"+ File.separator + "LoginPage");
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();

		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		screenshot.saveScreenshot("T518706"+ File.separator + "Cancel AutoPay Page");
		driver.navigate().refresh();
		screenshot.saveScreenshot("T518706"+ File.separator + "Cancel AutoPay Page");
		BTPage.Retain_Autopay();
		Thread.sleep(2000);
		hp.logoutApplication();
	}

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class,dependsOnMethods = {"AutoPaymentThroughCreditCard_T518254" ,"RetainAutoPayment_CC_T518706"})
	public void cancelAutoPayment_CC_T518705(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518705"+ File.separator + "LoginPage");
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();

		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		screenshot.saveScreenshot("T518705"+ File.separator + "Cancel AutoPay Page");
		driver.navigate().refresh();
		screenshot.saveScreenshot("T518705"+ File.separator + "Cancel AutoPay Page");
		BTPage.Cancel_AutoPay();
		hp.logoutApplication();

	}

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void AutoPaymentChecking_T518264(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String routingnumber = testdata.get("routingnumber");
		String accountnumber =testdata.get("accountnumber");
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518264"+ File.separator + "LoginPage");
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();

		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		screenshot.saveScreenshot("T518264"+ File.separator + "Autopay Page");
		driver.navigate().refresh();
		BTPage.Autopay_checking(routingnumber, accountnumber);
		screenshot.saveScreenshot("T518264"+ File.separator + "clicked on Terms and conditions");
		BTPage.TermsandConditions();
		BTPage.AgreeButton();
		BTPage.AutopayConfirm();
		screenshot.saveScreenshot("T518264"+ File.separator + "Autopay confirmation Page");
		hp.logoutApplication();
	}


	// Checking Retain
	/*@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class,dependsOnMethods = { "AutoPaymentChecking_T518264" })

	public void RetainAutoPay_Checking_T518710(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518710"+ File.separator + "LoginPage");
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();

		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		screenshot.saveScreenshot("T518710"+ File.separator + "Cancel AutoPay Page");
		driver.navigate().refresh();
		screenshot.saveScreenshot("T518710"+ File.separator + "Cancel AutoPay Page");
		BTPage.Retain_Autopay();
		Thread.sleep(2000);
	    hp.logoutApplication();
	}
	/// Checking Cancel
	 @Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class,dependsOnMethods = { "AutoPaymentChecking_T518264" ,"RetainAutoPay_Checking_T518710"})

	public void CancelAutoPay_Checking_T518709(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518709"+ File.separator + "LoginPage");
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();

		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		screenshot.saveScreenshot("T518709"+ File.separator + "Cancel AutoPay Page");
		driver.navigate().refresh();
		screenshot.saveScreenshot("T518709"+ File.separator + "Cancel AutoPay Page");
		BTPage.Cancel_AutoPay();
	    hp.logoutApplication();


	}*/
	///////////////////////////////////////////////////////////////////////////////////////////
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void AutoPaymentSaving_T518265(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String routingnumber = testdata.get("routingnumber");
		String accountnumber =testdata.get("accountnumber");
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518265"+ File.separator + "LoginPage");
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();

		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		screenshot.saveScreenshot("T518265"+ File.separator + "Autopay Page");
		driver.navigate().refresh();
		BTPage.Autopay_saving(routingnumber, accountnumber);
		screenshot.saveScreenshot("T518265"+ File.separator + "clicked on Terms and conditions");
		BTPage.TermsandConditions();
		BTPage.AgreeButton();
		BTPage.AutopayConfirm();
		screenshot.saveScreenshot("T518265"+ File.separator + "Autopay confirmation Page");
		hp.logoutApplication();

	}
	/*// Savings Retain
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class,dependsOnMethods = { "AutoPaymentSaving_T518265" })

	  public void RetainAutoPay_Savings_T518712(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518712"+ File.separator + "LoginPage");
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();

		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		screenshot.saveScreenshot("T518712"+ File.separator + "Cancel AutoPay Page");
		driver.navigate().refresh();
		screenshot.saveScreenshot("T518712"+ File.separator + "Cancel AutoPay Page");
		BTPage.Retain_Autopay();
		Thread.sleep(2000);
	    hp.logoutApplication();
	}

//Savings Cancel
@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class,dependsOnMethods = { "AutoPaymentSaving_T518265" ,"RetainAutoPay_Savings_T518712"})
public void CancelAutoPay_Savings_T518711(Map<String,String> testdata) throws Exception {

	String username = testdata.get("UserID");
	String password = testdata.get("UserPassword");

	CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);
	HomePage hp=new HomePage(driver);
	hp.loadCharterPage(URL);
	hp.login(username, password );
	screenshot.saveScreenshot("T518711"+ File.separator + "LoginPage");
	MyAccountPage myAccPage=new MyAccountPage(driver);
	myAccPage.openMyAccountTab();
	myAccPage.loadBillingAndTransactionSection();

	BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
	BTPage.makePayment();
	screenshot.saveScreenshot("T518711"+ File.separator + "Cancel AutoPay Page");
	driver.navigate().refresh();
	screenshot.saveScreenshot("T518711"+ File.separator + "Cancel AutoPay Page");
	BTPage.Cancel_AutoPay();
    Thread.sleep(2000);
    hp.logoutApplication();
}*/

	//Name: TBB_01_Validate_HOH_user_able_OTP_with_CC_T518136()
	//Description: Validate whether HOH user is able to do OTP with CC
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TBB_01_Validate_HOH_user_able_OTP_with_CC_T518136(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String CCtype = testdata.get("CardType");
		String CCNumber =testdata.get("CardNumber");
		String CCExpMonth = testdata.get("ExpDate");
		String CCExpYear = testdata.get("ExpYear");

		String PaymentAmount = ReadFromExcel.getData("Payments","PaymentAmount");
		String PaymentConfMsg = ReadFromExcel.getData("Payments", "PaymentConfirmationMessage");
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518136"+ File.separator + "LoginPage");
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();

		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		//driver.navigate().refresh();
		screenshot.saveScreenshot("T518136"+ File.separator + "OTP Page");
		BTPage.creditCardPayment(CCtype,CCNumber,CCExpMonth,CCExpYear,PaymentAmount);
		screenshot.saveScreenshot("T518136"+ File.separator + "clicked on Continue Button");
		BTPage.TermsandConditions();
		BTPage.AgreeButton();
		screenshot.saveScreenshot("T518136"+ File.separator + "Payment confirmation page");

		verifyAssert(BTPage.getPaymentConfirmationMsg(), PaymentConfMsg,"Payment Confirmation Message");
		hp.logoutApplication();
	}

	//Name: TBB_02_Validate_HOH_user_able_OTP_with_DC_T518137()
	//Description: Validate whether HOH user is able to do OTP with DC
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)

	public void TBB_02_Validate_HOH_user_able_OTP_with_DC_T518137(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String DCtype = testdata.get("CardType");
		String DCNo = testdata.get("CardNumber");
		String DCExpMonth = testdata.get("ExpDate");
		String DCExpyear = testdata.get("ExpYear");
		String PaymentAmount = ReadFromExcel.getData("Payments","PaymentAmount");
		String PaymentConfMsg = ReadFromExcel.getData("Payments", "PaymentConfirmationMessage");

		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518137"+ File.separator + "LoginPage");
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();

		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		//driver.navigate().refresh();
		screenshot.saveScreenshot("T518137"+ File.separator + "OTP Page");
		BTPage.debitCardPayment(DCtype, DCNo, DCExpMonth, DCExpyear, PaymentAmount);
		screenshot.saveScreenshot("T518137"+ File.separator + "Terms and conditions checked");
		BTPage.TermsandConditions();
		BTPage.AgreeButton();
		screenshot.saveScreenshot("T518137"+ File.separator + "Payment confirmation");
		verifyAssert(BTPage.getPaymentConfirmationMsg(), PaymentConfMsg,"Payment Confirmation Message");
		hp.logoutApplication();
	}


	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)

	public void OTP_checking_T518154(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String routingnumber = testdata.get("routingnumber");
		String accountnumber =testdata.get("accountnumber");
		String PaymentAmount = ReadFromExcel.getData("Payments","PaymentAmount");
		String PaymentConfMsg = ReadFromExcel.getData("Payments", "PaymentConfirmationMessage");

		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518154"+ File.separator + "LoginPage");
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		//driver.navigate().refresh();
		screenshot.saveScreenshot("T518154"+ File.separator + "OTP Page");
		BTPage.checkingPayment(routingnumber, accountnumber,PaymentAmount);
		screenshot.saveScreenshot("T518154"+ File.separator + "Terms and conditions checked");
		BTPage.TermsandConditions();
		BTPage.AgreeButton();
		screenshot.saveScreenshot("T518154"+ File.separator + "Payment confirmation");
		verifyAssert(BTPage.getPaymentConfirmationMsg(), PaymentConfMsg,"Payment Confirmation Message");
		hp.logoutApplication();
	}


	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)

	public void OTP_Saving_T518155(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String routingnumber = testdata.get("routingnumber");
		String accountnumber =testdata.get("accountnumber");

		String PaymentAmount = ReadFromExcel.getData("Payments","PaymentAmount");
		String PaymentConfMsg = ReadFromExcel.getData("Payments", "PaymentConfirmationMessage");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		//driver.navigate().refresh();
		BTPage.Savingspayment(routingnumber, accountnumber, PaymentAmount);
		BTPage.TermsandConditions();
		BTPage.AgreeButton();
		verifyAssert(BTPage.getPaymentConfirmationMsg(), PaymentConfMsg,"Payment Confirmation Message");
		hp.logoutApplication();

	}

}
