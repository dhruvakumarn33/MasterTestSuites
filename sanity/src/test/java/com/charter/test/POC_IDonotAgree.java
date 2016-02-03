package com.charter.test;

import java.io.File;
import java.util.Map;

import com.cognizant.framework.core.TestNGBase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.charter.page.BillingAndTransactionsPage;
import com.charter.page.HomePage;
import com.charter.page.MyAccountPage;
import com.charter.utils.Constants;
import com.charter.utils.DataProviderClass;
import com.cognizant.framework.core.CaptureScreenshot;
import com.cognizant.framework.core.ReadFromExcel;

public class POC_IDonotAgree extends TestNGBase {

	private String URL= Constants.URL;
	
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		public void OTP_DC_IDoNotAgree_T518147(Map<String,String> testdata) throws Exception{
				 
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String DCtype = testdata.get("CardType");
		String DCNo = testdata.get("CardNumber");
		String DCExpMonth = testdata.get("ExpDate");
		String DCExpyear = testdata.get("ExpYear");
		
		String PaymentAmount = ReadFromExcel.getData("Payments","PaymentAmount");
		
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518147"+ File.separator + "LoginPage");

		MyAccountPage MA=new MyAccountPage(driver);
		MA.openMyAccountTab();
		MA.loadBillingAndTransactionSection();
		
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		driver.navigate().refresh();
		screenshot.saveScreenshot("T518147"+ File.separator + "OTP Page");
		BTPage.debitCardPayment(DCtype, DCNo, DCExpMonth, DCExpyear, PaymentAmount);
		screenshot.saveScreenshot("T518147"+ File.separator + "T&C Checked");
		BTPage.DoNotAgreeButton();
		screenshot.saveScreenshot("T518147"+ File.separator + "Donot Agree Button");
		BTPage.CancelButton();
		System.out.println(driver.getTitle());
		screenshot.saveScreenshot("T518147"+ File.separator + "Overview Page");
		hp.logoutApplication();
	}
	
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void OTP_CC_IDoNOtAgree_T518146(Map<String,String> testdata) throws Exception{
		
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String CCtype = testdata.get("CardType");
		String CCNumber =testdata.get("CardNumber");
		String CCExpMonth = testdata.get("ExpDate");
		String CCExpYear = testdata.get("ExpYear");
		String PaymentAmount = ReadFromExcel.getData("Payments","PaymentAmount");
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518146"+ File.separator + "Login Page");

		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();
		
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		driver.navigate().refresh();
		screenshot.saveScreenshot("T518146"+ File.separator + "OTP Page");

		BTPage.creditCardPayment(CCtype,CCNumber,CCExpMonth,CCExpYear,PaymentAmount);
		screenshot.saveScreenshot("T518146"+ File.separator + "Clicked Continue");
		BTPage.DoNotAgreeButton();
		screenshot.saveScreenshot("T518146"+ File.separator + "Donot Agree Button");
		System.out.println(driver.getTitle());
		screenshot.saveScreenshot("T518146"+ File.separator + "Overview Page");
		hp.logoutApplication();
	}
	
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	
	public void OTP_Checking_IDonotAgree_T518172(Map<String,String> testdata) throws Exception{
		
		 
    	String username = testdata.get("UserID");
 		String password = testdata.get("UserPassword");
		String routingnumber = testdata.get("routingnumber");
		String accountnumber =testdata.get("accountnumber");
		String PaymentAmount = ReadFromExcel.getData("Payments","PaymentAmount");
		
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518172"+ File.separator + "Login Page");
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();
		
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		driver.navigate().refresh();
		screenshot.saveScreenshot("T518172"+ File.separator + "OTP Page");
		BTPage.checkingPayment(routingnumber, accountnumber, PaymentAmount);
		screenshot.saveScreenshot("T518172"+ File.separator + "T&C Checked");
		BTPage.DoNotAgreeButton();
		screenshot.saveScreenshot("T518172"+ File.separator + "DoNotAgree Button");
		BTPage.CancelButton();
		System.out.println(driver.getTitle());
		screenshot.saveScreenshot("T518172"+ File.separator + "Overview Page");
		hp.logoutApplication();
	}
	
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	
	public void OTP_Savings_IDonotAgree_T518174(Map<String,String> testdata) throws Exception{
		
	   	String username = testdata.get("UserID");
 		String password = testdata.get("UserPassword");
		String routingnumber = testdata.get("routingnumber");
		String accountnumber =testdata.get("accountnumber");
		
		String PaymentAmount = ReadFromExcel.getData("Payments","PaymentAmount");
		
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);
	HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518174"+ File.separator + "Login Page");
	MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();
	BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		 BTPage.makePayment();
		 driver.navigate().refresh();
		screenshot.saveScreenshot("T518174"+ File.separator + "OTP Page");
		
		BTPage.Savingspayment(routingnumber, accountnumber, PaymentAmount);
		screenshot.saveScreenshot("T518174"+ File.separator + "T&C Checked");
		BTPage.DoNotAgreeButton();
		screenshot.saveScreenshot("T518174"+ File.separator + "DoNotAgree Button");
		BTPage.CancelButton();
		System.out.println(driver.getTitle());
		screenshot.saveScreenshot("T518174"+ File.separator + "Overview Page");
		hp.logoutApplication();
	}
	
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	
	public void AutoPay_through_Checking_BA_IDoNotAgree_T518268(Map<String,String> testdata) throws Exception{
				
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String routingnumber = testdata.get("routingnumber");
		String accountnumber =testdata.get("accountnumber");
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518268"+ File.separator + "Login Page");
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();
		
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		screenshot.saveScreenshot("T518268"+ File.separator + "Autopay Page");
		driver.navigate().refresh();
		BTPage.Autopay_checking(routingnumber, accountnumber);
		screenshot.saveScreenshot("T518268"+ File.separator + "T&C Checked");
		BTPage.DoNotAgreeButton();
		screenshot.saveScreenshot("T518268"+ File.separator + "Donot Agree");
		BTPage.CancelButton();
		System.out.println(driver.getTitle());
		screenshot.saveScreenshot("T518268"+ File.separator + "Overview Page");
		hp.logoutApplication();
	}
	
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	
	public void AutoPay_through_Saving_BA_IDoNotAgree_T518269(Map<String,String> testdata) throws Exception{
		
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String routingnumber = testdata.get("routingnumber");
		String accountnumber =testdata.get("accountnumber");
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);
	HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518269"+ File.separator + "Login Page");
	MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();
	BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		screenshot.saveScreenshot("T518269"+ File.separator + "Autopay Page");
		driver.navigate().refresh();
		BTPage.Autopay_saving(routingnumber, accountnumber);
		screenshot.saveScreenshot("T518269"+ File.separator + "T&C Checked");
		BTPage.DoNotAgreeButton();
		screenshot.saveScreenshot("T518269"+ File.separator + "Donot Agree");
		BTPage.CancelButton();
		System.out.println(driver.getTitle());
		screenshot.saveScreenshot("T518269"+ File.separator + "Overview Page");
		hp.logoutApplication();
	}
	
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	
	public void AutoPayment_CC_IDoNotAgree_T518258(Map<String,String> testdata) throws Exception{
	
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String CCtype = testdata.get("CardType");
		String CCNo = testdata.get("CardNumber");
		String CCExpMonth = testdata.get("ExpDate");
		String CCExpyear = testdata.get("ExpYear");
						
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518258"+ File.separator + "Login Page");
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();
		Thread.sleep(5000);
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		screenshot.saveScreenshot("T518258"+ File.separator + "Autopay Page");
		driver.navigate().refresh();
		BTPage.Autopay_CC(CCtype, CCNo, CCExpMonth, CCExpyear);
		screenshot.saveScreenshot("T518258"+ File.separator + "T&C Checked");
		BTPage.DoNotAgreeButton();
		screenshot.saveScreenshot("T518258"+ File.separator + "Donot Agree");
		BTPage.CancelButton();
		System.out.println(driver.getTitle());
		screenshot.saveScreenshot("T518258"+ File.separator + "Overview Page");
		hp.logoutApplication();
	}
	
	
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)

	public void AutoPayment_DC_IDoNotAgree_T518259(Map<String,String> testdata) throws Exception{
		
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String DCtype = testdata.get("CardType");
		String DCNo = testdata.get("CardNumber");
		String DCExpMonth = testdata.get("ExpDate");
		String DCExpyear = testdata.get("ExpYear");
						
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518259"+ File.separator + "Login Page");
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.loadBillingAndTransactionSection();
		
		BillingAndTransactionsPage BTPage=new BillingAndTransactionsPage(driver);
		BTPage.makePayment();
		screenshot.saveScreenshot("T518259"+ File.separator + "Autopay Page");
		driver.navigate().refresh();
		BTPage.Autopay_DC(DCtype, DCNo, DCExpMonth, DCExpyear);
		screenshot.saveScreenshot("T518259"+ File.separator + "T&C Checked");
		BTPage.DoNotAgreeButton();
		screenshot.saveScreenshot("T518259"+ File.separator + "Donot Agree");
		BTPage.CancelButton();
		System.out.println(driver.getTitle());
		screenshot.saveScreenshot("T518259"+ File.separator + "Overview Page");
		hp.logoutApplication();
	}
}
