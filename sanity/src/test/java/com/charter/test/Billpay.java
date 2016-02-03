package com.charter.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.charter.page.BillingAndTransactionsPage;
import com.charter.page.BTPage1;
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
		String PaymentConfMsg = ReadFromExcel.getData("Payments", "PaymentConfirmationMessage");
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

	//Name: TB04_Validate_CancelFuturePayment_ScheduledByCreditCard_HOHUser()
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
	//	verifyAssert(BTPage.getPaymentConfirmationMsg(), PaymentConfMsg,"Payment Confirmation Message");
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

	/*@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
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

	}*/

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
		MAPage.openMyAccountTab();
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
		MAPage.openMyAccountTab();
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
		MAPage.openMyAccountTab();
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
		MAPage.openMyAccountTab();
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
		MAPage.openMyAccountTab();
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
		MAPage.openMyAccountTab();
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
		MAPage.openMyAccountTab();
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
		myAccPage.openMyAccountTab();
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


	@AfterMethod
	public void afterMethod() throws InterruptedException{
		Thread.sleep(2000);
		driver.manage().deleteAllCookies();
		driver.close();
	}
}