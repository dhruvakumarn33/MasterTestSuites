package com.charter.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.charter.page.AuthenticationPage;
import com.charter.page.BillingAndTransactionsPage;
import com.charter.page.BTPage1;
import com.charter.page.EmailPage;
import com.charter.page.HomePage;
import com.charter.page.MyAccountPage;
import com.charter.utils.Constants;
import com.charter.utils.DataProviderClass;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.TestNGBase;

public class Billpay extends TestNGBase {
	
	private String URL= Constants.URL;
	
	//Name: TB01_Validate_OTPSchedule_ByDebitCard_HOHUser()
	//Description: Validate whether the HOH user is able to schedule a OTP for future date  through DC
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB01_Validate_OTPSchedule_ByDebitCard_HOHUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String DCtype = testdata.get("CardType");
		String DCNo = testdata.get("CardNumber");
		String DCExpMonth = testdata.get("ExpDate");
		String DCExpyear = testdata.get("ExpYear");
		String FutureDate=testdata.get("FutureDate");
		String PaymentAmount = ReadFromExcel.getData("Payments","pay1");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		BTPage1 BTP1=new BTPage1(driver);
		BTP1.FutureDC(DCtype, DCNo, DCExpMonth, DCExpyear, PaymentAmount, FutureDate);
		BTPage.TermsandConditions();
		BTPage.AgreeButton();
	//	verifyAssert(BTPage.getPaymentConfirmationMsg(), PaymentConfMsg,"Payment Confirmation Message");
		BTPage.Finishbtn();
		hp.logoutApplication();
	}

	//Name: TB02_Validate_OTPSchedule_ByCreditCard_HOHUser()
	//Description: Validate whether the HOH user is able to schedule a OTP for future date  through CC
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)

	public void TB02_Validate_OTPSchedule_ByCreditCard_HOHUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String CCtype = testdata.get("CardType");
		String CCNumber =testdata.get("CardNumber");
		String CCExpMonth = testdata.get("ExpDate");
		String CCExpYear = testdata.get("ExpYear");
		String FutureDate=testdata.get("FutureDate");
		String PaymentAmount = ReadFromExcel.getData("Payments","pay");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		BTPage1 BTP1=new BTPage1(driver);
		BTP1.FutureCC(CCtype,CCNumber,CCExpMonth,CCExpYear,PaymentAmount,FutureDate);
     	BTPage.AgreeButton();
     	BTPage.Finishbtn();
		hp.logoutApplication();
	}

	//Name: TB03_Validate_CancelFuturePayment_ScheduledByDebitCard_HOHUser()
	//Description:Validate whether the HOH user is able to cancel the future dated payment which was scheduled through DC
	//HOH User
	//Scripter:Ayesha
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB03_Validate_CancelFuturePayment_ScheduledByDebitCard_HOHUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String DCtype = testdata.get("CardType");
		String DCNo = testdata.get("CardNumber");
		String DCExpMonth = testdata.get("ExpDate");
		String DCExpyear = testdata.get("ExpYear");
		String FutureDate=testdata.get("FutureDate");
		String PaymentAmount = ReadFromExcel.getData("Payments","pay");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );

		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		BTPage1 BTP1=new BTPage1(driver);
		BTP1.FutureDC(DCtype, DCNo, DCExpMonth, DCExpyear, PaymentAmount,FutureDate);
		BTPage.TermsandConditions();
		BTPage.AgreeButton();
		BTPage.Finishbtn();
		Assert.assertTrue(BTP1.CancelUpcomingPayments(), "User is not able to cancel the upcoming payments");
		hp.logoutApplication();
	}

	//Name: TB04_Validate_CancelFuturePayment_ScheduledByCreditCard_HOHUser()
	//Description:Validate whether the HOH user is able to cancel the the future dated payment which was scheduled through CC
	//HOH User
	//Scripter:Ayesha
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB04_Validate_CancelFuturePayment_ScheduledByCreditCard_HOHUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String CCtype = testdata.get("CardType");
		String CCNumber =testdata.get("CardNumber");
		String CCExpMonth = testdata.get("ExpDate");
		String CCExpYear = testdata.get("ExpYear");
		String FutureDate=testdata.get("FutureDate");
		String PaymentAmount = ReadFromExcel.getData("Payments","PaymentAmount");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		BTPage1 BTP1=new BTPage1(driver);
		BTP1.FutureCC(CCtype,CCNumber,CCExpMonth,CCExpYear,PaymentAmount,FutureDate);
		BTPage.AgreeButton();
		BTPage.Finishbtn();
		Assert.assertTrue(BTP1.CancelUpcomingPayments(), "User is not able to cancel the upcoming payments");
		hp.logoutApplication();
	}

	//Name: TB05_Validate_OTPayment_ByDebitCard_AdminUser()
	//Description:Validate whether the HOH user is able to cancel the the future dated payment which was scheduled through CC
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB05_Validate_OTPayment_ByDebitCard_AdminUser(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String DCtype = testdata.get("CardType");
		String DCNo = testdata.get("CardNumber");
		String DCExpMonth = testdata.get("ExpDate");
		String DCExpyear = testdata.get("ExpYear");
		String PaymentAmount = ReadFromExcel.getData("Payments","pay1");
		String PaymentConfMsg = ReadFromExcel.getData("Payments", "PaymentConfirmationMessage");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		BTPage.debitCardPayment(DCtype, DCNo, DCExpMonth, DCExpyear, PaymentAmount);
		BTPage.TermsandConditions();
		BTPage.AgreeButton();
		verifyAssert(BTPage.getPaymentConfirmationMsg(), PaymentConfMsg,"Payment Confirmation Message");
		BTPage.Finishbtn();
		hp.logoutApplication();
	}

	//Name: TB06_Validate_OTPayment_ByCreditCard_AdminUser()
	//Description:Validate whether the Admin user is able to do OTP for current date through DC
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB06_Validate_OTPayment_ByCreditCard_AdminUser(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String CCtype = testdata.get("CardType");
		String CCNumber =testdata.get("CardNumber");
		String CCExpMonth = testdata.get("ExpDate");
		String CCExpYear = testdata.get("ExpYear");
		String PaymentAmount = ReadFromExcel.getData("Payments","PaymentAmount");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		BTPage.creditCardPayment(CCtype, CCNumber, CCExpMonth, CCExpYear, PaymentAmount);
		BTPage.AgreeButton();
		BTPage.Finishbtn();
		hp.logoutApplication();
	}

	//Name: TB07_Validate_ScheduleOTP_ByDebitCard_AdminUser()
	//Description:Validate whether the Admin user is able to schedule a OTP for future date through DC
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB07_Validate_ScheduleOTP_ByDebitCard_AdminUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String DCtype = testdata.get("CardType");
		String DCNo = testdata.get("CardNumber");
		String DCExpMonth = testdata.get("ExpDate");
		String DCExpyear = testdata.get("ExpYear");
		String FutureDate=testdata.get("FutureDate");
		String PaymentAmount = ReadFromExcel.getData("Payments","PaymentAmount");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		BTPage1 BTP1=new BTPage1(driver);
		BTP1.FutureDC(DCtype, DCNo, DCExpMonth, DCExpyear, PaymentAmount,FutureDate);
		BTPage.TermsandConditions();
		BTPage.AgreeButton();
		BTPage.Finishbtn();
		hp.logoutApplication();

	}

	//Name: TB08_Validate_ScheduleOTP_ByCreditCard_AdminUser()
	//Description: Validate whether the Admin user is able to schedule a OTP for future date through CC
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB08_Validate_ScheduleOTP_ByCreditCard_AdminUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String CCtype = testdata.get("CardType");
		String CCNumber =testdata.get("CardNumber");
		String CCExpMonth = testdata.get("ExpDate");
		String CCExpYear = testdata.get("ExpYear");
		String FutureDate=testdata.get("FutureDate");
		String PaymentAmount = ReadFromExcel.getData("Payments","PaymentAmount");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		BTPage1 BTP1=new BTPage1(driver);
		BTP1.FutureCC(CCtype,CCNumber,CCExpMonth,CCExpYear,PaymentAmount,FutureDate);
		BTPage.AgreeButton();
		BTPage.Finishbtn();
		hp.logoutApplication();
	}

	//Name: TB09_Validate_CancelFuturePayment_ScheduledByDebitCard_AdminUser()
	//Description: Validate whether the Admin user is able to cancel the future dated payment which was scheduled through DC
	//HOH User
	//Scripter:Ayesha
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB09_Validate_CancelFuturePayment_ScheduledByDebitCard_AdminUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String DCtype = testdata.get("CardType");
		String DCNo = testdata.get("CardNumber");
		String DCExpMonth = testdata.get("ExpDate");
		String DCExpyear = testdata.get("ExpYear");
		String FutureDate=testdata.get("FutureDate");
		String PaymentAmount = ReadFromExcel.getData("Payments","pay1");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		BTPage1 BTP1=new BTPage1(driver);
		BTP1.FutureDC(DCtype, DCNo, DCExpMonth, DCExpyear, PaymentAmount,FutureDate);
		BTPage.TermsandConditions();
		BTPage.AgreeButton();
		BTPage.Finishbtn();
		BTP1.CancelUpcomingPayments();
		hp.logoutApplication();

	}

	//Name: TB10_Validate_CancelFuturePayment_ScheduledByCreditCard_AdminUser()
	//Description: Validate whether the Admin user is able to cancel the future dated payment which was scheduled through DC
	//HOH User
	//Scripter:Ayesha
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB10_Validate_CancelFuturePayment_ScheduledByCreditCard_AdminUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String CCtype = testdata.get("CardType");
		String CCNumber =testdata.get("CardNumber");
		String CCExpMonth = testdata.get("ExpDate");
		String CCExpYear = testdata.get("ExpYear");
		String PaymentAmount = ReadFromExcel.getData("Payments","pay");
		String FutureDate=testdata.get("FutureDate");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		BTPage1 BTP1=new BTPage1(driver);
		BTP1.FutureCC(CCtype,CCNumber,CCExpMonth,CCExpYear,PaymentAmount,FutureDate);
		BTPage.AgreeButton();
		BTPage.Finishbtn();
		BTP1.CancelUpcomingPayments();
		hp.logoutApplication();
	}

	//Name: TB11_Validate_AutoPaySetup_ByDebitCard_AdminUser()
	//Description: Validate whether the Admin user is able to setup Autopay through DC
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB11_Validate_AutoPaySetup_ByDebitCard_AdminUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String DCtype = testdata.get("CardType");
		String DCNo = testdata.get("CardNumber");
		String DCExpMonth = testdata.get("ExpDate");
		String DCExpyear = testdata.get("ExpYear");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();

		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		BTPage.Autopay_DC(DCtype, DCNo, DCExpMonth, DCExpyear);
		BTPage.TermsandConditions();
		BTPage.AutopayEnroll();
		BTPage.Finishbtn();
		hp.logoutApplication();
	}

	//Name: TB12_Validate_AutoPaySetup_ByCreditCard_AdminUser()
	//Description: Validate whether the admin user is able to setup Auto pay through CC
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)	
	public void TB12_Validate_AutoPaySetup_ByCreditCard_AdminUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String CCtype = testdata.get("CardType");
		String CCNo = testdata.get("CardNumber");
		String CCExpMonth = testdata.get("ExpDate");
		String CCExpyear = testdata.get("ExpYear");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();

		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		BTPage.Autopay_CC(CCtype, CCNo, CCExpMonth, CCExpyear);
		BTPage.TermsandConditions();
		BTPage.AutopayEnroll();
		BTPage.Finishbtn();
		hp.logoutApplication();

	}

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB13_Validate_AutoPayCancel_ByDebitCard_AdminUser(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();

		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		driver.navigate().refresh();
		BTPage.Cancel_AutoPay();
	}


	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB14_Validate_AutoPayCancel_ByCreditCard_AdminUser(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		driver.navigate().refresh();
		BTPage.Cancel_AutoPay();

	}

	//Name: TB15_Validate_ModifyOTPayment_ByDebitCard_VerificationPage()
	//Description: Validate whether the  user is able to modify the payment details thourgh verification page and submit the OTP through the DC
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB15_Validate_ModifyOTPayment_ByDebitCard_VerificationPage(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String DCtype = testdata.get("CardType");
		String DCNo = testdata.get("CardNumber");
		String DCExpMonth = testdata.get("ExpDate");
		String DCExpyear = testdata.get("ExpYear");
		String FutureDate=testdata.get("FutureDate");
		String PaymentAmount = ReadFromExcel.getData("Payments","PaymentAmount");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		BTPage1 BTP1=new BTPage1(driver);
		BTP1.FutureDC(DCtype, DCNo, DCExpMonth, DCExpyear, PaymentAmount,FutureDate);
		BTP1.EditpaymentCarddetails(DCtype, DCNo,DCExpMonth,DCExpyear);
		BTPage.TermsandConditions();
		BTPage.AgreeButton();
		BTPage.Finishbtn();
		hp.logoutApplication();
	}

	//Name: TB16_Validate_ModifyOTPayment_ByCreditCard_VerificationPage()
	//Description: Validate whether the  user is able to modify  the payment details thourgh verification page and submit the OTP through the CC
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB16_Validate_ModifyOTPayment_ByCreditCard_VerificationPage(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String CCtype = testdata.get("CardType");
		String CCNumber =testdata.get("CardNumber");
		String CCExpMonth = testdata.get("ExpDate");
		String CCExpYear = testdata.get("ExpYear");
		String PaymentAmount = ReadFromExcel.getData("Payments","PaymentAmount");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		BTPage.creditCardPayment(CCtype,CCNumber,CCExpMonth,CCExpYear,PaymentAmount);
		BTPage1 BTP1=new BTPage1(driver);
		BTP1.EditpaymentCarddetails(CCtype, CCNumber,CCExpMonth,CCExpYear);
		BTPage.AgreeButton();
		BTPage.Finishbtn();
		hp.logoutApplication();
	}

	//Name: TB19_Validate_ViewCurrentBillLink_NavigateTo_PFDStatement_HOHUser()
	//Description: Validate whether the HOH user is able to view the PDF statement on clicking View Current Bill link in Billing and Transactions page
	//HOH User
	//Scripter:Ayesha
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB19_Validate_ViewCurrentBillLink_NavigateTo_PFDStatement_HOHUser(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		//MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTP=new BillingAndTransactionsPage(driver);
		BTP.ViewCBillLink();
		hp.logoutApplication();
	}

	//Name: TB20_Validate_ViewCurrentBillLink_NavigateTo_PFDStatement_AdminUser()
	//Description:Validate whether the Admin user is able to view the PDF statement on clicking View Current Bill link in Billing and Transactions page
	//HOH User
	//Scripter:Ayesha
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB20_Validate_ViewCurrentBillLink_NavigateTo_PFDStatement_AdminUser(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		//MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTP=new BillingAndTransactionsPage(driver);
		BTP.ViewCBillLink();
		hp.logoutApplication();
	}

	//Name: TB21_Validate_BillDeliveryLink_NavigateTo_BillDeliveryOptionsPage_HOHUser()
	//Description:Validate whether the HOH user is able to navigate to Bill Delivery  options page on clicking Bill Delivery Options link in Billing and Transactions Page
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB21_Validate_BillDeliveryLink_NavigateTo_BillDeliveryOptionsPage_HOHUser(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.Billdeliverylink();
		hp.logoutApplication();
	}

	//Name: TB22_Validate_BillDeliveryLink_NavigateTo_BillDeliveryOptionsPage_AdminUser()
	//Description:Validate whether the Admin user is able to navigate to Bill Delivery  options page on clicking Bill Delivery Options link in Billing and Transactions Page
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB22_Validate_BillDeliveryLink_NavigateTo_BillDeliveryOptionsPage_AdminUser(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		//MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.Billdeliverylink();
		hp.logoutApplication();

	}

	//Name: TB23_Validate_ViewImportantBillMessagesLink_NavigateTo_BillMessagesPage_HOHUser()
	//Description:Validate whether the HOH user is able to view Bill Message on clicking View Important Bill messages link in Billing and transactions Page
	//HOH User
	//Scripter:Ayesha
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB23_Validate_ViewImportantBillMessagesLink_NavigateTo_BillMessagesPage_HOHUser(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		//MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.VImpBillMsg();
		hp.logoutApplication();

	}

	//Name: TB24_Validate_ViewImportantBillMessagesLink_NavigateTo_BillMessagesPage_AdminUser()
	//Description:Validate whether the Admin user is able to view Bill Message on clicking View Important Bill messages link in Billing and Transactions Page
	//HOH User
	//Scripter:Ayesha
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB24_Validate_ViewImportantBillMessagesLink_NavigateTo_BillMessagesPage_AdminUser(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		//MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.VImpBillMsg();
		hp.logoutApplication();

	}

	//Name: TB25_Validate_UpcomingPaymentsLink_NavigateTo_UpcomingPaymentsPage_HOHUser()
	//Description: Validate whether the HOH user is able to navigate to Upcoming Payments page on clicking Upcoming Payments link in Billing and Transactions page
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB25_Validate_UpcomingPaymentsLink_NavigateTo_UpcomingPaymentsPage_HOHUser(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String MAC = testdata.get("mac_CID");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTP=new BillingAndTransactionsPage(driver);
		BTP.UpcomingPaymentsLink();
		hp.logoutApplication();
	}

	//Name: TB26_Validate_UpcomingPaymentsLink_NavigateTo_UpcomingPaymentsPage_AdminUser()
	//Description: Validate whether the Admin user is able to navigate to Upcoming Payments page on clicking Upcoming Payments link in Billing and Transactions page
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB26_Validate_UpcomingPaymentsLink_NavigateTo_UpcomingPaymentsPage_AdminUser(Map<String,String> testdata) throws Exception{

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
		BTP.UpcomingPaymentsLink();
		hp.logoutApplication();
	}

	//Name: TB27_Validate_PaymentDueDateLink_NavigateTo_PaymentDueDatePage_HOHUser()
	//Description: Validate whether the HOH user is able to view the Payment Due Date on clicking View Payment Due Date link in Billing and Transactions Page
	//HOH User
	//Scripter:Ayesha
	//Date/Version:
	//PRE Requisite: Auto Pay Setup should be setup
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB27_Validate_PaymentDueDateLink_NavigateTo_PaymentDueDatePage_HOHUser(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		//MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTP=new BillingAndTransactionsPage(driver);
		BTP.viewduedate();
		hp.logoutApplication();

	}

	//Name: TB28_Validate_PaymentDueDateLink_NavigateTo_PaymentDueDatePage_AdminUser()
	//Description: Validate whether the Admin user is able to view the Payment Due Date on clicking View Payment Due Date link in Billing and Transactions Page
	//HOH User
	//Scripter:Ayesha
	//Date/Version:
	//PRE Requisite: Auto Pay Setup should be setup
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB28_Validate_PaymentDueDateLink_NavigateTo_PaymentDueDatePage_AdminUser(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		//MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTP=new BillingAndTransactionsPage(driver);
		BTP.viewduedate();
		hp.logoutApplication();
	}

	//Name: TB29_Validate_Duplicate_OTP_Message_ByDebitCard()
	//Description: Validate whether the user is getting Duplicate payment Message when trying to do OTP through DC
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB29_Validate_Duplicate_OTP_Message_ByDebitCard(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String DCtype = testdata.get("CardType");
		String DCNo = testdata.get("CardNumber");
		String DCExpMonth = testdata.get("ExpDate");
		String DCExpyear = testdata.get("ExpYear");
		String PaymentAmount = ReadFromExcel.getData("Payments","pay");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage myAccPage=new MyAccountPage(driver);
		//myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		BTPage.debitCardPayment(DCtype, DCNo, DCExpMonth, DCExpyear, PaymentAmount);
		BTPage.TermsandConditions();
		BTPage.AgreeButton();
		BTPage.Finishbtn();
		driver.get(URL+"/billing-and-transactions/");
		BTPage.makePayment();
		BTPage.debitCardPayment(DCtype, DCNo, DCExpMonth, DCExpyear, PaymentAmount);
		BTPage.TermsandConditions();
		BTPage.AgreeButton();
		Assert.assertTrue(BTPage.DuplicateErrorMsg(), "Duplicate Error Message is not Displayed");
		hp.logoutApplication();
	}

	//Name: TB30_Validate_Duplicate_OTP_Message_ByCreditCard()
	//Description: Validate whether the user is getting Duplicate payment Message when trying to do OTP through CC
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB30_Validate_Duplicate_OTP_Message_ByCreditCard(Map<String,String> testdata) throws Exception{
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String CCtype = testdata.get("CardType");
		String CCNumber =testdata.get("CardNumber");
		String CCExpMonth = testdata.get("ExpDate");
		String CCExpYear = testdata.get("ExpYear");
		String PaymentAmount = ReadFromExcel.getData("Payments","pay1");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		BTPage.creditCardPayment(CCtype,CCNumber,CCExpMonth,CCExpYear,PaymentAmount);
		BTPage.AgreeButton();
		BTPage.Finishbtn();
		driver.get(URL+"/billing-and-transactions/");
		BTPage.makePayment();
		BTPage.creditCardPayment(CCtype,CCNumber,CCExpMonth,CCExpYear,PaymentAmount);
		BTPage.AgreeButton();
		Assert.assertTrue(BTPage.DuplicateErrorMsg(), "Duplicate Error Message is not Displayed");
		hp.logoutApplication();
	}
	
	
	//Name: TB31_Validate_ViewCurrentBillLink_NavigateTo_PFDStatement_adminUser()
	//Description: Validate whether the HOH user is able to view the PDF statement on clicking View Current Bill link in Billing and Transactions page
	//HOH User
	//Scripter:Dhruva
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB31_Validate_ViewCurrentBillLink_NavigateTo_PFDStatement_adminUser(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTP=new BillingAndTransactionsPage(driver);
		BTP.ViewCBillLink();
		hp.logoutApplication();
	}
	
	//Name: TB32_Validate_BillingAndTransactionPage_BillDeliveryOptionsLink_NavigateTo_BilldeliveryOptionsPage_adminUser()
	//Description: Validate navigating to Bill Delivery Options by clicking on "Bill Delivery Options" link 
	//Admin User
	//Scripter:Dhruva
	//Date/Version:18-Aug-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB32_Validate_BillingAndTransactionPage_BillDeliveryOptionsLink_NavigateTo_BilldeliveryOptionsPage_adminUser(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String GmailID=testdata.get("GmailID");
		String Gmailpw=testdata.get("Gmailpw");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTP=new BillingAndTransactionsPage(driver);
		Assert.assertTrue(BTP.Billdeliverylink(), "User is -Not Navigated to Bill Delivery Options Page");
		AuthenticationPage auth = new AuthenticationPage(driver);
		auth.gmailLogin(GmailID, Gmailpw);
		Assert.assertTrue(auth.BillDeliveryConfirmationMail(),"Confirmation Mail is not received on changing bill delivery option");
	}
	
	//Name: TB33_Validate_UpcomingPaymentLink_NavigateTo_NoUpcomingPayments_HOHUser()
	//Description: Verify the Upcoming Payments link shall not be presented if the account does not have any pending one time payments
	//HOH User
	//Scripter:Dhruva
	//Date/Version:18-Aug-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB33_Validate_UpcomingPaymentLink_NavigateTo_NoUpcomingPayments_HOHUser(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTP=new BillingAndTransactionsPage(driver);
		Assert.assertTrue(BTP.NoUpcomingPayments(), "No Upcoming Payments message is not displayed");
		hp.logoutApplication();
	}
	
	//Name: TB34_Validate_LastPayment_Details_HOH()
	//Description: Verify the details related to the financial facility which is used to complete the last payment is displayed if the payment is due.
	//HOH User
	//Scripter:Dhruva
	//Date/Version:19-Aug-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB34_Validate_LastPayment_Details_HOH(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.loadBillingAndTransactionSection();
		BillingAndTransactionsPage bt=new BillingAndTransactionsPage(driver);
		bt.lastpaymentDetails();
		hp.logoutApplication();
	}
	
	//Name: TB35_Validate_LastPayment_Details_admin()
	//Description: Verify the details related to the financial facility which is used to complete the last payment is displayed if the payment is due.
	//Admin User
	//Scripter:Dhruva
	//Date/Version:19-Aug-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB35_Validate_LastPayment_Details_admin(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.loadBillingAndTransactionSection();
		BillingAndTransactionsPage bt=new BillingAndTransactionsPage(driver);
		bt.lastpaymentDetails();
		hp.logoutApplication();
	}
	
	//Name: TB36_Validate_NoLastPayment_Message_HOH()
	//Description: Verify the display of "No Payments have been processed for this account" if no payment activity is reported by the billing system.
	//HOH User
	//Scripter:Dhruva
	//Date/Version:19-Aug-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB36_Validate_NoLastPayment_Message_HOH(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.loadBillingAndTransactionSection();
		BillingAndTransactionsPage bt=new BillingAndTransactionsPage(driver);
		Assert.assertTrue(bt.noRecentpayment(),"No recent Payment message is not displayed");
		hp.logoutApplication();
	}
	
	//Name: TB37_Validate_AutoPayStatus_admin()
	//Description: Verify whether the user is able to setup/manage the Auto pay status by clicking on Auto Pay link.
	//Admin User
	//Scripter:Dhruva
	//Date/Version:19-Aug-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB37_Validate_AutoPayStatus_admin(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.loadBillingAndTransactionSection();
		BillingAndTransactionsPage bt=new BillingAndTransactionsPage(driver);
		Assert.assertTrue(bt.AutoPayStatus(),"Auto Pay status is not displayed");
		hp.logoutApplication();
		hp.login("tdr33013", "Testing01");
		MA.loadBillingAndTransactionSection();
		Assert.assertTrue(bt.AutoPayStatus(),"Auto Pay status is not displayed");
		hp.logoutApplication();
	}

	//Name: TB38_Validate_Available_LastStatements_admin()
	//Description: Verify whether the user is able to view the Last Statement summary under Billing 
	//Admin User
	//Scripter:Dhruva
	//Date/Version:21-Aug-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB38_Validate_Available_LastStatements_admin(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.loadBillingAndTransactionSection();
		BTPage1 bt=new BTPage1(driver);
		Assert.assertTrue(bt.lastStatements(),"Last statements are not displayed");
		hp.logoutApplication();
	}
	
	//Name: TB39_Validate_OTPSchedule_ByDebitCard_ConfirmationMail()
	//Description: Validate whether the HOH user is able receive email confirmation on schedule a OTP for future date through DC
	//HOH User
	//Scripter:Dhruva
	//Date/Version: 08-Sep-2015
	//Pre-requisite: Accounts should be provisioned with legacy (Sigma) with Internet and voice
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB39_Validate_OTPSchedule_ByDebitCard_ConfirmationMail(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String DCtype = testdata.get("CardType");
		String DCNo = testdata.get("CardNumber");
		String DCExpMonth = testdata.get("ExpDate");
		String DCExpyear = testdata.get("ExpYear");
		String FutureDate=testdata.get("FutureDate");
		String PaymentAmount = ReadFromExcel.getData("Payments","pay1");
		String MAC = testdata.get("mac_CID");
		String mailUserID = testdata.get("UserID1");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		
		MAPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		BTPage1 BTP1=new BTPage1(driver);
		BTP1.FutureDC(DCtype, DCNo, DCExpMonth, DCExpyear, PaymentAmount, FutureDate);
		BTPage.TermsandConditions();
		BTPage.AgreeButton();
		BTPage.Finishbtn();
		MAPage.loadBillingAndTransactionSection();
     	BTPage.UpcomingPaymentsLink();
     	BTPage.getUpcomingPaymentInfo();
     	BTPage.CancelPayment();
     	hp.logoutApplication();
		AuthenticationPage auth = new AuthenticationPage(driver);
		auth.mailLogin(mailUserID,password);
		auth.OTPS_DC_ConfirmationMail();
	}

	//Name: TB40_Validate_OTPSchedule_ByCreditCard_ConfirmationMail()
	//Description: Validate whether the HOH user is able to receive confirmation Mail on schedule a OTP for future date  through CC
	//HOH User
	//Scripter:Dhruva
	//Date/Version: 08-Sep-2015
	//Pre-requisite: Accounts should be provisioned with legacy (Sigma) with Internet and voice
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB40_Validate_OTPSchedule_ByCreditCard_ConfirmationMail(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String CCtype = testdata.get("CardType");
		String CCNumber =testdata.get("CardNumber");
		String CCExpMonth = testdata.get("ExpDate");
		String CCExpYear = testdata.get("ExpYear");
		String FutureDate=testdata.get("FutureDate");
		String PaymentAmount = ReadFromExcel.getData("Payments","pay");
		String MAC = testdata.get("mac_CID");
		String mailUserID = testdata.get("UserID1");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		BTPage1 BTP1=new BTPage1(driver);
		BTP1.FutureCC(CCtype,CCNumber,CCExpMonth,CCExpYear,PaymentAmount,FutureDate);
     	BTPage.AgreeButton();
     	BTPage.Finishbtn();
     	MAPage.loadBillingAndTransactionSection();
     	BTPage.UpcomingPaymentsLink();
     	BTPage.getUpcomingPaymentInfo();
     	BTPage.CancelPayment();
     	hp.logoutApplication();
		AuthenticationPage auth = new AuthenticationPage(driver);
		auth.mailLogin(mailUserID,password);
		auth.OTPS_CC_ConfirmationMail();
	}
	
	//Name: TB41_Validate_OTPSchedule_ByChecking_ConfirmationMail()
	//Description: Validate whether the HOH user is able to receive confirmation Mail on schedule a OTP for future date  through Checking Account
	//HOH User
	//Scripter:Dhruva
	//Date/Version: 08-Sep-2015
	//Pre-requisite: Accounts should be provisioned with legacy (Sigma) with Internet and voice
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB41_Validate_OTPSchedule_ByChecking_ConfirmationMail(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String routingnumber = testdata.get("routingnumber");
		String accountnumber =testdata.get("accountnumber");
		String PaymentAmount = ReadFromExcel.getData("Payments","PaymentAmount");
		String FutureDate=testdata.get("FutureDate");
		String MAC = testdata.get("mac_CID");
		String mailUserID = testdata.get("UserID1");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		BTPage.checkingPaymentFutureDate(routingnumber, accountnumber,PaymentAmount,FutureDate);
		BTPage.TermsandConditions();
		BTPage.AgreeButton();
		BTPage.Finishbtn();
		MAPage.loadBillingAndTransactionSection();
     	BTPage.UpcomingPaymentsLink();
     	BTPage.getUpcomingPaymentInfo();
     	BTPage.CancelPayment();
		hp.logoutApplication();
		//hp.loadCharterPage(URL);
		AuthenticationPage auth = new AuthenticationPage(driver);
		auth.mailLogin(mailUserID,password);
		auth.OTPS_CS_ConfirmationMail();
	}
	
	//Name: TB42_Validate_AutoPaySetup_ByDebitCard_ConfirmationMail()
	//Description: Validate whether the user is able to receive confirmation mail on setup Autopay through DC
	//HOH User
	//Scripter:Dhruva
	//Date/Version: 08-Sep-2015
	//Pre-requisite: Accounts should be provisioned with legacy (Sigma) with Internet and voice
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB42_Validate_AutoPaySetup_ByDebitCard_ConfirmationMail(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String DCtype = testdata.get("CardType");
		String DCNo = testdata.get("CardNumber");
		String DCExpMonth = testdata.get("ExpDate");
		String DCExpyear = testdata.get("ExpYear");
		String mailUserID = testdata.get("UserID1");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.GetAutoPayStatus();
		MAPage.loadBillingAndTransactionSection();
		BTPage.makePayment();
		BTPage.Autopay_DC(DCtype, DCNo, DCExpMonth, DCExpyear);
		BTPage.ApTermsandConditions();
		BTPage.AutopayEnroll();
		BTPage.Finishbtn();
		hp.logoutApplication();
		AuthenticationPage auth = new AuthenticationPage(driver);
		auth.mailLogin(mailUserID,password);
		auth.APS_DC_ConfirmationMail();
		EmailPage em = new EmailPage(driver);
		em.mailLogout();
		hp.login(username, password);
		MAPage.loadBillingAndTransactionSection();
		BTPage.makePayment();
		BTPage.Cancel_AutoPay();
		BTPage.GetAutoPayStatus();
		hp.logoutApplication();
		//hp.loadCharterPage(URL);
		auth.mailLogin(mailUserID,password);
		auth.APC_DC_ConfirmationMail();
	}

	//Name: TB43_Validate_AutoPaySetup_ByCreditCard_ConfirmationMail()
	//Description: Validate whether the user is able to receive confirmation mail on setup Auto pay through CC
	//HOH User
	//Scripter:Dhruva
	//Date/Version: 08-Sep-2015
	//Pre-requisite: Accounts should be provisioned with legacy (Sigma) with Internet and voice
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)	
	public void TB43_Validate_AutoPaySetup_ByCreditCard_ConfirmationMail(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String CCtype = testdata.get("CardType");
		String CCNo = testdata.get("CardNumber");
		String CCExpMonth = testdata.get("ExpDate");
		String CCExpyear = testdata.get("ExpYear");
		String mailUserID = testdata.get("UserID1");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.GetAutoPayStatus();
		MAPage.loadBillingAndTransactionSection();
		
		BTPage.makePayment();
		BTPage.Autopay_CC(CCtype, CCNo, CCExpMonth, CCExpyear);
		BTPage.ApTermsandConditions();
		BTPage.AutopayEnroll();
		BTPage.Finishbtn();
		hp.logoutApplication();
		AuthenticationPage auth = new AuthenticationPage(driver);
		auth.mailLogin(mailUserID,password);
		auth.APS_CC_ConfirmationMail();
		EmailPage em = new EmailPage(driver);
		em.mailLogout();
		hp.login(username, password);
		MAPage.loadBillingAndTransactionSection();
		BTPage.makePayment();
		BTPage.Cancel_AutoPay();
		BTPage.GetAutoPayStatus();
		hp.logoutApplication();
		//hp.loadCharterPage(URL);
		auth.mailLogin(mailUserID,password);
		auth.APC_CC_ConfirmationMail();
	}
	
	//Name: TB44_Validate_AutoPaySetup_ByChecking_ConfirmationMail()
	//Description: Validate whether the user is able to receive confirmation mail on setup Auto pay through Checking Account
	//HOH User
	//Scripter:Dhruva
	//Date/Version: 08-Sep-2015
	//Pre-requisite: Accounts should be provisioned with legacy (Sigma) with Internet and voice
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB44_Validate_AutoPaySetup_ByChecking_ConfirmationMail(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String routingnumber = testdata.get("routingnumber");
		String accountnumber =testdata.get("accountnumber");
		String mailUserID = testdata.get("UserID1");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.GetAutoPayStatus();
		MAPage.loadBillingAndTransactionSection();
		
		BTPage.makePayment();
		BTPage.Autopay_checking(routingnumber, accountnumber);
		BTPage.ApTermsandConditions();
		BTPage.AutopayEnroll();
		BTPage.Finishbtn();
		hp.logoutApplication();
		AuthenticationPage auth = new AuthenticationPage(driver);
		auth.mailLogin(mailUserID,password);
		auth.APS_CS_ConfirmationMail();
		EmailPage em = new EmailPage(driver);
		em.mailLogout();
		hp.login(username, password);
		MAPage.loadBillingAndTransactionSection();
		BTPage.makePayment();
		BTPage.Cancel_AutoPay();
		BTPage.GetAutoPayStatus();
		hp.logoutApplication();
		//hp.loadCharterPage(URL);
		auth.mailLogin(mailUserID,password);
		auth.APC_CS_ConfirmationMail();
	}
	
	//Name: TB45_Validate_OTP_ByChecking_ConfirmationMail()
	//Description: Validate whether the HOH user is able to receive confirmation Mail on a OTP through Checking Account
	//HOH User
	//Scripter:Dhruva
	//Date/Version: 08-Sep-2015
	//Pre-requisite: Accounts should be provisioned with legacy (Sigma) with Internet and voice
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB45_Validate_OTP_ByChecking_ConfirmationMail(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String routingnumber = testdata.get("routingnumber");
		String accountnumber =testdata.get("accountnumber");
		String PaymentAmount = ReadFromExcel.getData("Payments","PaymentAmount");		
		String mailUserID = testdata.get("UserID1");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		BTPage.checkingPayment(routingnumber, accountnumber,PaymentAmount);
		//BTPage.PrintTermsCondition();
		//BTPage.AcceptTermsandConditions();
		BTPage.TermsandConditions();
		BTPage.AgreeButton();
		BTPage.Finishbtn();
		MAPage.loadBillingAndTransactionSection();
     	BTPage.pendingPaymentMsg();
     	BTPage.pendingPaymentHistory();
		hp.logoutApplication();
		hp.loadCharterPage(URL);
		AuthenticationPage auth = new AuthenticationPage(driver);
		auth.mailLogin(mailUserID,password);
		auth.OTP_CS_ConfirmationMail();
	}
	
	//Name: TB46_Validate_OTPayment_ByDebitCard_ConfirmationMail()
	//Description:Validate whether the HOH user is able to receive confirmation Mail on a OTP through DC
	//HOH User
	//Scripter:Dhruva
	//Date/Version: 08-Sep-2015
	//Pre-requisite: Accounts should be provisioned with legacy (Sigma) with Internet and voice
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB46_Validate_OTPayment_ByDebitCard_ConfirmationMail(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String DCtype = testdata.get("CardType");
		String DCNo = testdata.get("CardNumber");
		String DCExpMonth = testdata.get("ExpDate");
		String DCExpyear = testdata.get("ExpYear");
		String PaymentAmount = ReadFromExcel.getData("Payments","pay1");
		String mailUserID = testdata.get("UserID1");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		BTPage.debitCardPayment(DCtype, DCNo, DCExpMonth, DCExpyear, PaymentAmount);
		//BTPage.PrintTermsCondition();
		//BTPage.AcceptTermsandConditions();
		BTPage.TermsandConditions();
		BTPage.AgreeButton();
		BTPage.Finishbtn();
		MAPage.loadBillingAndTransactionSection();
     	BTPage.pendingPaymentMsg();
     	BTPage.pendingPaymentHistory();
		hp.logoutApplication();
		//hp.loadCharterPage(URL);
		AuthenticationPage auth = new AuthenticationPage(driver);
		auth.mailLogin(mailUserID,password);
		auth.OTP_DC_ConfirmationMail();
	}

	//Name: TB47_Validate_OTPayment_ByCreditCard_ConfirmationMail()
	//Description:Validate whether the HOH user is able to receive confirmation Mail on a OTP through CC
	//HOH User
	//Scripter:Dhruva
	//Date/Version: 08-Sep-2015
	//Pre-requisite: Accounts should be provisioned with legacy (Sigma) with Internet and voice
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB47_Validate_OTPayment_ByCreditCard_ConfirmationMail(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String CCtype = testdata.get("CardType");
		String CCNumber =testdata.get("CardNumber");
		String CCExpMonth = testdata.get("ExpDate");
		String CCExpYear = testdata.get("ExpYear");
		String PaymentAmount = ReadFromExcel.getData("Payments","PaymentAmount");
		String mailUserID = testdata.get("UserID1");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		BTPage.creditCardPayment(CCtype, CCNumber, CCExpMonth, CCExpYear, PaymentAmount);
		BTPage.AgreeButton();
		BTPage.Finishbtn();
		MAPage.loadBillingAndTransactionSection();
     	BTPage.pendingPaymentMsg();
     	BTPage.pendingPaymentHistory();
		hp.logoutApplication();
		//hp.loadCharterPage(URL);
		AuthenticationPage auth = new AuthenticationPage(driver);
		auth.mailLogin(mailUserID,password);
		auth.OTP_CC_ConfirmationMail();
	}
	
	//Name: TB48_Validate_AutoPayCancel_ByDebitCard_ConfirmationMail()
	//Description:Validate whether the HOH user is able to receive confirmation Mail on cancelling Autopay
	//HOH User
	//Scripter:Dhruva
	//Date/Version: 08-Sep-2015
	//Pre-requisite: Accounts should be provisioned with legacy (Sigma) with Internet and voice
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB48_Validate_AutoPayCancel_ByDebitCard_ConfirmationMail(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String GmailID=testdata.get("GmailID");
		String Gmailpw=testdata.get("Gmailpw");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage myAccPage=new MyAccountPage(driver);
		
		myAccPage.loadBillingAndTransactionSection();

		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		driver.navigate().refresh();
		BTPage.Cancel_AutoPay();
		AuthenticationPage auth = new AuthenticationPage(driver);
		auth.gmailLogin(GmailID, Gmailpw);
		Assert.assertTrue(auth.AutoPayConfirmationMail(),"Confirmation Mail is not received on Cancelling Autopay");
	}

	//Name: TB49_Validate_AutoPayCancel_ByCreditCard_ConfirmationMail()
	//Description:Validate whether the HOH user is able to receive confirmation Mail on cancelling Autopay
	//HOH User
	//Scripter:Dhruva
	//Date/Version: 08-Sep-2015
	//Pre-requisite: Accounts should be provisioned with legacy (Sigma) with Internet and voice
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB49_Validate_AutoPayCancel_ByCreditCard_ConfirmationMail(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String GmailID=testdata.get("GmailID");
		String Gmailpw=testdata.get("Gmailpw");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage myAccPage=new MyAccountPage(driver);
		
		myAccPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		driver.navigate().refresh();
		BTPage.Cancel_AutoPay();
		AuthenticationPage auth = new AuthenticationPage(driver);
		auth.gmailLogin(GmailID, Gmailpw);
		Assert.assertTrue(auth.AutoPayConfirmationMail(),"Confirmation Mail is not received on Cancelling Autopay");
	}
	
	//Name: TB50_Validate_AutoPayCancel_ByChecking_ConfirmationMail()
	//Description:Validate whether the HOH user is able to receive confirmation Mail on cancelling Autopay
	//HOH User
	//Scripter:Dhruva
	//Date/Version: 08-Sep-2015
	//Pre-requisite: Accounts should be provisioned with legacy (Sigma) with Internet and voice
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB50_Validate_AutoPayCancel_ByChecking_ConfirmationMail(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String GmailID=testdata.get("GmailID");
		String Gmailpw=testdata.get("Gmailpw");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		driver.navigate().refresh();
		BTPage.Cancel_AutoPay();
		AuthenticationPage auth = new AuthenticationPage(driver);
		auth.gmailLogin(GmailID, Gmailpw);
		Assert.assertTrue(auth.AutoPayConfirmationMail(),"Confirmation Mail is not received on Cancelling Autopay");
	}
	
	//Name: TB51_Validate_StatementSummary_NotificationMail()
	//Description:Validate whether the user is able to receive notification Mail on Charter Statement Summary
	//HOH User
	//Scripter:Dhruva
	//Date/Version: 08-Sep-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB51_Validate_StatementSummary_NotificationMail(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String mailUserID = testdata.get("UserID1");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.loadBillingAndTransactionSection();
		myAccPage.availableStatements();
		hp.logoutApplication();
		AuthenticationPage auth = new AuthenticationPage(driver);
		auth.mailLogin(mailUserID,password);
		auth.stmt_NotificationMail();
	}
	
	//Name: TB52_Validate_OTP_BySaving_ConfirmationMail()
	//Description: Validate whether the HOH user is able to receive confirmation Mail on a OTP through Saving Account
	//HOH User
	//Scripter:Dhruva
	//Date/Version: 16-Sep-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB52_Validate_OTP_BySaving_ConfirmationMail(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String routingnumber = testdata.get("routingnumber");
		String accountnumber =testdata.get("accountnumber");
		String PaymentAmount = ReadFromExcel.getData("Payments","PaymentAmount");
		String mailUserID = testdata.get("UserID1");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage myAccPage=new MyAccountPage(driver);
		
		myAccPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		BTPage.Savingspayment(routingnumber, accountnumber,PaymentAmount);
		BTPage.PrintTermsCondition();
		BTPage.AcceptTermsandConditions();
		BTPage.AgreeButton();
		BTPage.Finishbtn();
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.loadBillingAndTransactionSection();
     	BTPage.pendingPaymentMsg();
     	BTPage.pendingPaymentHistory();
		hp.logoutApplication();
		hp.loadCharterPage(URL);
		AuthenticationPage auth = new AuthenticationPage(driver);
		auth.mailLogin(mailUserID,password);
		auth.OTP_CS_ConfirmationMail();
	}
	
	//Name: TB53_Validate_AutoPaySetup_BySaving_ConfirmationMail()
	//Description: Validate whether the user is able to receive confirmation mail on setup Auto pay through Saving Account
	//HOH User
	//Scripter:Dhruva
	//Date/Version: 12-Oct-2015
	//Pre-requisite: Accounts should be provisioned with legacy (Sigma) with Internet and voice
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB53_Validate_AutoPaySetup_BySaving_ConfirmationMail(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String routingnumber = testdata.get("routingnumber");
		String accountnumber =testdata.get("accountnumber");
		String mailUserID = testdata.get("UserID1");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		BTPage.Autopay_saving(routingnumber, accountnumber);
		BTPage.ApTermsandConditions();
		BTPage.AutopayEnroll();
		BTPage.Finishbtn();
		hp.logoutApplication();
		AuthenticationPage auth = new AuthenticationPage(driver);
		auth.mailLogin(mailUserID,password);
		auth.APS_CS_ConfirmationMail();
		EmailPage em = new EmailPage(driver);
		em.mailLogout();
		hp.login(username, password);
		MAPage.loadBillingAndTransactionSection();
		BTPage.makePayment();
		BTPage.Cancel_AutoPay();
		hp.logoutApplication();
		//hp.loadCharterPage(URL);
		auth.mailLogin(mailUserID,password);
		auth.APC_CS_ConfirmationMail();
	}
	
	//Name: TB54_Validate_OTPayment_ByDebitCard_PastDueAmount()
	//Description:Validate whether user is able to view past due amount and pay bill accordingly
	//HOH User
	//Scripter:Dhruva
	//Date/Version: 13-Oct-2015
	//Pre-requisite: Accounts should be provisioned with legacy (Sigma) with Internet and voice
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB54_Validate_OTPayment_ByDebitCard_PastDueAmount(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String DCtype = testdata.get("CardType");
		String DCNo = testdata.get("CardNumber");
		String DCExpMonth = testdata.get("ExpDate");
		String DCExpyear = testdata.get("ExpYear");
		String PaymentAmount = ReadFromExcel.getData("Payments","pay1");
		String mailUserID = testdata.get("UserID1");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.loadBillingAndTransactionSection();
		MAPage.pastDueAmount();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		BTPage.debitCardPaymentPastDue(DCtype, DCNo, DCExpMonth, DCExpyear, PaymentAmount);
		BTPage.PrintTermsCondition();
		BTPage.AcceptTermsandConditions();
		BTPage.AgreeButton();
		BTPage.Finishbtn();
		MAPage.loadBillingAndTransactionSection();
     	BTPage.pendingPaymentMsg();
     	BTPage.pendingPaymentHistory();
		hp.logoutApplication();
		//hp.loadCharterPage(URL);
		AuthenticationPage auth = new AuthenticationPage(driver);
		auth.mailLogin(mailUserID,password);
		auth.OTP_DC_ConfirmationMail();
	}
	
	//Name: TB55_Validate_OTPayment_ByCreditCard_PastDueAmount()
	//Description:Validate whether user is able to view past due amount and pay bill accordingly
	//HOH User
	//Scripter:Dhruva
	//Date/Version: 19-Oct-2015
	//Pre-requisite: Accounts should be provisioned with legacy (Sigma) with Internet and voice
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB55_Validate_OTPayment_ByCreditCard_PastDueAmount(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String CCtype = testdata.get("CardType");
		String CCNumber =testdata.get("CardNumber");
		String CCExpMonth = testdata.get("ExpDate");
		String CCExpYear = testdata.get("ExpYear");
		String PaymentAmount = ReadFromExcel.getData("Payments","PaymentAmount");
		String mailUserID = testdata.get("UserID1");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.loadBillingAndTransactionSection();
		MAPage.pastDueAmount();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		BTPage.creditCardPayment(CCtype, CCNumber, CCExpMonth, CCExpYear, PaymentAmount);
		BTPage.AgreeButton();
		BTPage.Finishbtn();
		MAPage.loadBillingAndTransactionSection();
     	BTPage.pendingPaymentMsg();
     	BTPage.pendingPaymentHistory();
		hp.logoutApplication();
		//hp.loadCharterPage(URL);
		AuthenticationPage auth = new AuthenticationPage(driver);
		auth.mailLogin(mailUserID,password);
		auth.OTP_CC_ConfirmationMail();
	}
	
	//Name: TB56_Validate_OTPayment_ByChecking_PastDueAmount()
	//Description: Validate whether user is able to view past due amount and pay bill accordingly
	//HOH User
	//Scripter:Dhruva
	//Date/Version: 19-Oct-2015
	//Pre-requisite: Accounts should be provisioned with legacy (Sigma) with Internet and voice
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB56_Validate_OTPayment_ByChecking_PastDueAmount(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String routingnumber = testdata.get("routingnumber");
		String accountnumber =testdata.get("accountnumber");
		String PaymentAmount = ReadFromExcel.getData("Payments","PaymentAmount");		
		String mailUserID = testdata.get("UserID1");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.loadBillingAndTransactionSection();
		MAPage.pastDueAmount();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		BTPage.checkingPayment(routingnumber, accountnumber,PaymentAmount);
		BTPage.PrintTermsCondition();
		BTPage.AcceptTermsandConditions();
		BTPage.AgreeButton();
		BTPage.Finishbtn();
		MAPage.loadBillingAndTransactionSection();
     	BTPage.pendingPaymentMsg();
     	BTPage.pendingPaymentHistory();
		hp.logoutApplication();
		hp.loadCharterPage(URL);
		AuthenticationPage auth = new AuthenticationPage(driver);
		auth.mailLogin(mailUserID,password);
		auth.OTP_CS_ConfirmationMail();
	}
	
	//Name: TB57_Validate_OTPayment_BySaving_PastDueAmount()
	//Description: Validate whether user is able to view past due amount and pay bill accordingly
	//HOH User
	//Scripter:Dhruva
	//Date/Version: 19-Oct-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB57_Validate_OTPayment_BySaving_PastDueAmount(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String routingnumber = testdata.get("routingnumber");
		String accountnumber =testdata.get("accountnumber");
		String PaymentAmount = ReadFromExcel.getData("Payments","PaymentAmount");
		String mailUserID = testdata.get("UserID1");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.loadBillingAndTransactionSection();
		myAccPage.pastDueAmount();
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		BTPage.Savingspayment(routingnumber, accountnumber,PaymentAmount);
		BTPage.PrintTermsCondition();
		BTPage.AcceptTermsandConditions();
		BTPage.AgreeButton();
		BTPage.Finishbtn();
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.loadBillingAndTransactionSection();
     	BTPage.pendingPaymentMsg();
     	BTPage.pendingPaymentHistory();
		hp.logoutApplication();
		hp.loadCharterPage(URL);
		AuthenticationPage auth = new AuthenticationPage(driver);
		auth.mailLogin(mailUserID,password);
		auth.OTP_CS_ConfirmationMail();
	}
	
	//Name: TB58_Validate_PCISession_TimeOut_UpcomingPayments()
	//Description: Validate whether user is able to view past due amount and pay bill accordingly
	//HOH User
	//Scripter:Dhruva
	//Date/Version: 19-Oct-2015
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TB58_Validate_PCISession_TimeOut_UpcomingPayments(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.loadBillingAndTransactionSection();
		BillingAndTransactionsPage bt = new BillingAndTransactionsPage(driver);
		bt.UpcomingPaymentsLink();
		bt.PCISession15Mins();
	}
	
	@AfterMethod
	public void afterMethod() throws InterruptedException{
		Thread.sleep(2000);
		driver.manage().deleteAllCookies();
		driver.close();
	}
}