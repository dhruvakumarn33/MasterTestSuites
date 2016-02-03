package com.charter.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.charter.page.AuthenticationPage;
import com.charter.page.BillingAndTransactionsPage;
import com.charter.page.HomePage;
import com.charter.page.MyAccountPage;
import com.charter.page.OnDemandPage;
import com.charter.page.WatchTVPage;
import com.charter.utils.Constants;
import com.charter.utils.DataProviderClass;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.TestNGBase;

public class CL19 extends TestNGBase {
	
	private String URL= Constants.URL;
	
	//Name: CL19_CHARTERNET_2407_Validate_InvalidDomain_Users_at_Login()
	//Description: Validate whether Users with invalid domains are still being validated at the server
	//Standard user
	//Scripter:Dhruva
	//Date/Version:07-Jul-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void CL19_CHARTERNET_2407_Validate_InvalidDomain_Users_at_Login(Map<String,String> testdata) throws Exception {

		String username = testdata.get("email");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		Assert.assertTrue(hp.validateDomain(username, password), "Invalid Domain users are validated at login");
	}
	
	//Name: CL19_CHARTERNET_2072_Validate_CreditAdjutsments_AmountSign()
	//Description: Validate whether credit adjustments are displayed with "-" sign
	//HOH user
	//Scripter:Dhruva
	//Date/Version:08-Jul-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void CL19_CHARTERNET_2072_Validate_CreditAdjutsments_AmountSign(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		MyAccountPage ma = new MyAccountPage(driver);
		ma.loadBillingAndTransactionSection();
		BillingAndTransactionsPage bt = new BillingAndTransactionsPage(driver);
		bt.Recent_Transaction_Section();
		Assert.assertTrue(bt.checkCreditAdjustmentValue(),"Credit adjustment shows positive values");
	}
	
	//Name: CL19_CHARTERNET_2053_Validate_SupportDD_Position()
	//Description: Validate whether credit adjustments are displayed with "-" sign
	//HOH user
	//Scripter:Dhruva
	//Date/Version:09-Jul-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void CL19_CHARTERNET_2053_Validate_SupportDD_Position(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		Assert.assertTrue(hp.checkSupportDDPosition(),"Support Dropdown does not display the description and images on the right side");
	}
	
	//Name: CL19_CHARTERNET_2037_Validate_Networks_HeaderColor()
	//Description: Validate whether Networks header tab is visible on networks landing page
	//HOH user
	//Scripter:Dhruva
	//Date/Version:08-Jul-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void CL19_CHARTERNET_2037_Validate_Networks_HeaderColor(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		WatchTVPage wtv= new WatchTVPage(driver);
		wtv.OpenOnDemand();
		OnDemandPage odp= new OnDemandPage(driver);
		odp.openNetworksTab();
		Assert.assertTrue(odp.checkNetworksColor(),"Networks header is not visible");
	}
	
	//Name: CL19_CHARTERNET_1954_Validate_MACid_popup_msg()
	//Description: Validate the hyperlink on MAC id help section during create new User
	//HOH user
	//Scripter:Dhruva
	//Date/Version:09-Jul-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void CL19_CHARTERNET_1954_Validate_MACid_popup_msg(Map<String,String> testdata) throws Exception {

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage aup = new AuthenticationPage(driver);
		Assert.assertTrue(aup.verifyMACmsg(),"Help message on MAC address field is not as expected");
		
	}
		 
	}
	

