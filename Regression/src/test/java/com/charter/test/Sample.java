package com.charter.test;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.charter.page.AuthenticationPage;
import com.charter.page.BasicAuthenticaion;
import com.charter.page.BillingAndTransactionsPage;
import com.charter.page.BTPage1;
import com.charter.page.EmailPage;
import com.charter.page.HomePage;
import com.charter.page.InternetServicesPage;
import com.charter.page.MyAccountPage;
import com.charter.page.OverviewPage;
import com.charter.page.TVServicesPage;
import com.charter.page.UserPreferencePage;
import com.charter.page.VoiceServicesPage;
import com.charter.page.WatchTVGuidePage;
import com.charter.page.WatchTVODPage;
import com.charter.page.WatchTVPage;
import com.charter.page.UserPreferencePage.userType;
import com.charter.utils.Constants;
import com.charter.utils.DataProviderClass;
import com.cognizant.framework.ajax.Until;
import com.cognizant.framework.core.CaptureScreenshot;
import com.cognizant.framework.core.EnvParameters;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.TestNGBase;
import com.cognizant.framework.core.WebDriverBase;

public class Sample extends TestNGBase {
	
	private String URL= Constants.URL;
	
	CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA77_Validate_StdUser_CreateID(Map<String,String> testdata) throws Exception{

		String randomNumbers = RandomStringUtils.randomNumeric(3);
		String password = testdata.get("UserPassword");
		String charterID=testdata.get("charterID")+randomNumbers;
		String email=testdata.get("email");
		String security_question=testdata.get("security_question");
		String security_answer=testdata.get("security_answer");
		String firstname_CID=testdata.get("firstname_CID");
		String lastname_CID=testdata.get("lastname_CID");
		String Address_CID=testdata.get("address_CID");
		String Zipcode_CID=testdata.get("zipcode_CID");
		String MAC_CID=testdata.get("mac_CID");
		String Mobilephone=testdata.get("Mobilephone");
		String hohuser=testdata.get("hohuser");
		String mailUserID = testdata.get("UserID1");
		String accountNum = testdata.get("ACnumber");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.createuser_Std(accountNum,firstname_CID,lastname_CID,Address_CID,Zipcode_CID,MAC_CID,charterID, password, email,security_question, security_answer,Mobilephone),"User is -Not able to see Successful message after Charter ID creation in create id flow");
		hp.logoutApplication();
		//auth.getAccountDetails(accountNum);
		auth.mailLogin(mailUserID,password);
		auth.CID_ConfirmationMail();
		EmailPage em= new EmailPage(driver);
		em.mailLogout();
		hp.login(hohuser, password);
		MyAccountPage MA=new MyAccountPage(driver);
		MA.loadUPPage();
		hp.pagewait();
		UserPreferencePage UPpage=new UserPreferencePage(driver);
		UPpage.selectuser(userType.username, charterID);
		UPpage.Promote_Selected_User("Admin");
		UPpage.selectuser(userType.username, charterID);
		UPpage.Demote_Selected_User("Standard");
		Assert.assertTrue(UPpage.deleteUser(charterID), "User not deleted");
		hp.logoutApplication();
	}

}

