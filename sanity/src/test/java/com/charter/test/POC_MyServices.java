package com.charter.test;

import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

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

public class POC_MyServices extends TestNGBase {
	private String URL= Constants.URL;
	
	
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void validate_IS_newpage_SecuritySuiteBar_T518299(Map<String,String> testdata) throws Exception{
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		
		screenshot.saveScreenshot("T517987"+ File.separator + "LoginPage");
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		myAccPage.InternetServiceslink();
		//wait(3);
		InternetServicesPage IPage=new InternetServicesPage(driver);
		IPage.charterSecuritySuitelink();
		IPage.ClickLearnMorelink();
		hp.logoutApplication();
	}
	
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void validate_IS_newpage_CloudDriveBar_T518300(Map<String,String> testdata) throws Exception{
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		
		screenshot.saveScreenshot("T518300"+ File.separator + "LoginPage");
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.InternetServiceslink();
		InternetServicesPage IPage=new InternetServicesPage(driver);
		IPage.CharterCloudDrivelink();
		IPage.ClickLearnMoreCloudDrivelink();
		
		hp.logoutApplication();
	}
	
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void validate_IS_newpage_EmailServiceBar_T518298(Map<String,String> testdata) throws Exception{
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		
		screenshot.saveScreenshot("T518298"+ File.separator + "LoginPage");
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.InternetServiceslink();
		//wait(3);
		InternetServicesPage IPage=new InternetServicesPage(driver);
	    IPage.CharterEmail_link();
	    IPage.ManageCharterEmail_link();
	    IPage.ClickLearnCharterEmail_link();
		hp.logoutApplication();
	}
	
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void Validate_TVservices_newpage_NickNameDevicesServiceBar_default_T518308(Map<String,String> testdata) throws Exception{
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		
		screenshot.saveScreenshot("T518308"+ File.separator + "LoginPage");
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.TVServiceslink();
		TVServicesPage TVPage=new TVServicesPage(driver);
		TVPage.ReNameDigital_Reciever(testdata);
		hp.logoutApplication();
	}
	
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TV_ServicesNewPage_UpdateDigitalReceiver_T518307(Map<String,String> testdata) throws Exception{
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		
		screenshot.saveScreenshot("T518307"+ File.separator + "LoginPage");
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.TVServiceslink();
		TVServicesPage TVPage=new TVServicesPage(driver);
		TVPage.verifyTitle();
		TVPage.UpdateDigital_Reciever();
		hp.logoutApplication();
	}
	
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void validate_VoiceServices_T518318(Map<String,String> testdata) throws Exception{
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );
		screenshot.saveScreenshot("T518318"+ File.separator + "LoginPage");
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.VoiceServiceslink();
		VoiceServicesPage VSPage=new VoiceServicesPage(driver);
		VSPage.VerifyVoiceServicesPageTitle();
		VSPage.ClickPhoneOnlineManagerServiceBar();
		hp.logoutApplication();
	}


	
	
}



