package com.charter.test;

import java.io.File;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.charter.page.BillDeliveryPage;
import com.charter.page.HomePage;
import com.charter.page.MyAccountPage;
import com.charter.page.OverviewPage;
import com.charter.utils.Constants;
import com.charter.utils.DataProviderClass;
import com.cognizant.framework.core.CaptureScreenshot;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.TestNGBase;

public class POC_AskCharter extends TestNGBase{
	
	private String URL= Constants.URL;
	
	@BeforeSuite
	 public void setproperty(){
		 System.setProperty("webdriver.ie.driver.logfile","E:/logfile.log");
	 }
	
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	
	 public void BillDeliveryOptions_AskCharter_T518058(Map<String,String> testdata) throws Exception {
				
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String searchkey=testdata.get("searchkey");
		
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518058"+ File.separator + "LoginPage");
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		BillDeliveryPage BDPage=new BillDeliveryPage(driver);
		BDPage.hoveronBT();
		BDPage.linkBillDeliveryOptions();
		screenshot.saveScreenshot("T518058"+ File.separator + "Bill Delivery Options Page");
		BDPage.Askcharter(searchkey);
		screenshot.saveScreenshot("T518058"+ File.separator + "Userin parent window after search");
		hp.logoutApplication();
	}

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	
	public void BillingandTransPage_AskCharter_T518060(Map<String,String> testdata) throws Exception{
		
		
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String searchkey=testdata.get("searchkey");
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518060"+ File.separator + "LoginPage");
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadBillingAndTransactionSection();
		screenshot.saveScreenshot("T518060"+ File.separator + "Billing and Transaction Page");
		BillDeliveryPage BDPage=new BillDeliveryPage(driver);
		BDPage.Askcharter(searchkey);
		screenshot.saveScreenshot("T518060"+ File.separator + "Userin parent window after search");
		hp.logoutApplication();
	}
	
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	
	public void upcomingPayments_AskCharter_T518250(Map<String,String> testdata) throws Exception{
		
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String searchkey=testdata.get("searchkey");
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518250"+ File.separator + "LoginPage");
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		OverviewPage Vpage=new OverviewPage(driver);
		Vpage.Overviewlink();
		screenshot.saveScreenshot("T518250"+ File.separator + "Overview Page");
		Vpage.askCharter(searchkey);
		screenshot.saveScreenshot("T518250"+ File.separator + "Userin parent window after search");
		hp.logoutApplication();
		
	}
	
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
		
	public void validate_UserPreferenceAskCharter_T518035(Map<String,String> testdata) throws Exception{
	
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String searchkey=testdata.get("searchkey");
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518035"+ File.separator + "LoginPage");
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadUPPage();
		screenshot.saveScreenshot("T518035"+ File.separator + "UserPreference Page");
		
		BillDeliveryPage BDPage=new BillDeliveryPage(driver);
		BDPage.Askcharter(searchkey);
		screenshot.saveScreenshot("T518035"+ File.separator + "Userin parent window after search");
		hp.logoutApplication();
		
	}
}
