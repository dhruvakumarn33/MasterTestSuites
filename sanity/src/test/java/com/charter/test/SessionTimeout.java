package com.charter.test;

import java.util.Map;

import org.testng.annotations.Test;

import com.charter.page.AuthenticationPage;
import com.charter.page.BillDeliveryPage;
import com.charter.page.BillingAndTransactionsPage;
import com.charter.page.HomePage;
import com.charter.page.MyAccountPage;
import com.charter.utils.Constants;
import com.charter.utils.DataProviderClass;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.TestNGBase;

public class SessionTimeout extends TestNGBase{
	private String URL= Constants.URL;
		
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	 public void TT01_Validate_SessionTimeOut_MyAccountOverviewPage(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadOverviewPage();
		MAPage.is_Timeout_for_Page();
	}
	
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TT02_Validate_SessionTimeOut_BillingAndTransactionPage(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();	
		MAPage.is_Timeout_for_Page();
	}

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	 public void TT03_Validate_SessionTimeOut_BillingAndTransaction_PayBillPage(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();	
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.PayBill(); //Repair
		MAPage.is_Timeout_for_Page();
	}

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	 public void TT04_Validate_SessionTimeOut_BillingAndTransaction_AutoPaySetupPage(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();	
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.AutoPayDC(); //Repair
		MAPage.is_Timeout_for_Page();
	}

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	 public void TT05_Validate_SessionTimeOut_BillingAndTransaction_OneTimePaymentPage(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();	
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.OTPPayDC();
		MAPage.is_Timeout_for_Page();
	}

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	 public void TT06_Validate_SessionTimeOut_BillingAndTransaction_DeliveryOptionsPage(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();	
		BillDeliveryPage BDPage=new BillDeliveryPage(driver);
		BDPage.linkBillDeliveryOptions();
		MAPage.is_Timeout_for_Page();
	}

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	 public void TT07_Validate_SessionTimeOut_MyAccount_UserPreference_Page(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadUPPage();
		MAPage.is_Timeout_for_Page();
	}

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void  TT08_Validate_SessionTimeOut_MyServices_Page(Map<String,String> testdata) throws Exception{
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.TVServiceslink();
		MAPage.is_Timeout_for_Page();
	}
	
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void  TT09_Validate_SessionTimeOut_CreateID_Page(Map<String,String> testdata) throws Exception{
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		auth.fp_CreateIDPage(); //New
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.is_Timeout_for_Page();
	}
	
}