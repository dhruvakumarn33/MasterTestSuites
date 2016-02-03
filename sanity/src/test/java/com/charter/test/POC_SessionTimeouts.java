package com.charter.test;

import java.io.File;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.charter.page.BillDeliveryPage;
import com.charter.page.HomePage;
import com.charter.page.InternetServicesPage;
import com.charter.page.MyAccountPage;
import com.charter.page.OverviewPage;
import com.charter.page.TVServicesPage;
import com.charter.page.VoiceServicesPage;
import com.charter.utils.Constants;
import com.charter.utils.DataProviderClass;
import com.cognizant.framework.core.CaptureScreenshot;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.TestNGBase;

public class POC_SessionTimeouts extends TestNGBase{

	private String URL= Constants.URL;
	
	@BeforeSuite
	 public void setproperty(){
		 System.setProperty("webdriver.ie.driver.logfile","E:/logfile.log");
	 }
	
	
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	
	 public void MA_BillingandTransactions_PCISession_Timeout_T518059(Map<String,String> testdata) throws Exception {
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518059"+ File.separator + "LoginPage");

		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();	
		screenshot.saveScreenshot("T518059"+ File.separator + "Billing and Transaction Page");
		MAPage.is_Timeout_for_Page();
		
}
	

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	
	 public void MA_BillDeliveryOptions_PCIsession_timeout_rules_T518057(Map<String,String> testdata) throws Exception {
		
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518057"+ File.separator + "LoginPage");

		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
				
		BillDeliveryPage BDPage=new BillDeliveryPage(driver);
		BDPage.hoveronBT();
		BDPage.linkBillDeliveryOptions();
		screenshot.saveScreenshot("T518057"+ File.separator + "Bill Delivery Options Page");
		MAPage.is_Timeout_for_Page();
	}

	

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	
	 public void MyAccount_PCI_Session_Timeout_T517937(Map<String,String> testdata) throws Exception {
		
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T517937"+ File.separator + "LoginPage");

		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
	
		OverviewPage Vpage=new OverviewPage(driver);
		Vpage.Overviewlink();
		screenshot.saveScreenshot("T517937"+ File.separator + "Overview Page");
		MAPage.is_Timeout_for_Page();
	
	}
	
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void  validate_TVServices_PCI_session_timeoutrules_T518303(Map<String,String> testdata) throws Exception{
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		
		screenshot.saveScreenshot("T518307"+ File.separator + "LoginPage");
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.TVServiceslink();
		TVServicesPage TVPage=new TVServicesPage(driver);
		TVPage.verifyTitle();
		MAPage.is_Timeout_for_Page();
		hp.logoutApplication();
	}
	
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void validate_InternetServices_PCI_session_timeout_rules_T518295(Map<String,String> testdata) throws Exception{
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		
		screenshot.saveScreenshot("T518298"+ File.separator + "LoginPage");
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.InternetServiceslink();
		InternetServicesPage IPage=new InternetServicesPage(driver);
		MAPage.is_Timeout_for_Page();
	    hp.logoutApplication();
	}
	
	
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void validate_VoiceServices_PCI_session_timeout_rules_T518315(Map<String,String> testdata) throws Exception{
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518298"+ File.separator + "LoginPage");
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.VoiceServiceslink();
		VoiceServicesPage VSPage=new VoiceServicesPage(driver);
		VSPage.VerifyVoiceServicesPageTitle();
		MAPage.is_Timeout_for_Page();
		hp.logoutApplication();
	}
		
	
}



