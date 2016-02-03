package com.charter.test;

import java.util.Map;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.charter.page.BasicAuthenticaion;
import com.charter.utils.DataProviderClass;
import com.cognizant.framework.core.TestNGBase;

public class CharterDotCom extends TestNGBase{

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TE01_Validate_Navigation_from_charterDotCom_with_Login_option_and_Verify_CreateIDbutton_inLoginpage(Map<String,String> testdata) throws Exception {
		String BasicURL=testdata.get("LegacySiteURL");
		driver.get(BasicURL);
		BasicAuthenticaion basic=new BasicAuthenticaion(driver);
		basic.Basic_CreateID();
	}
	
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TE02_Validate_Navigation_from_charterDotCom_with_Login_option_and_Verify_ForgotUsername_Link_inLoginpage(Map<String,String> testdata) throws Exception {
		String BasicURL=testdata.get("LegacySiteURL");
		driver.get(BasicURL);
		BasicAuthenticaion basic=new BasicAuthenticaion(driver);
		basic.Basic_ForgotCharterID();
	}

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TE03_Validate_Navigation_from_charterDotCom_with_Login_option_and_Verify_ForgotPassword_Link_inLoginpage(Map<String,String> testdata) throws Exception {
		String BasicURL=testdata.get("LegacySiteURL");
		driver.get(BasicURL);
		BasicAuthenticaion basic=new BasicAuthenticaion(driver);
		basic.Basic_ForgotPassword();
	}

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TE04_Validate_CharterDotCom_SignUpOption(Map<String,String> testdata) throws Exception {

		String BasicURL=testdata.get("LegacySiteURL");
		driver.get(BasicURL);
		BasicAuthenticaion basic=new BasicAuthenticaion(driver);
		basic.SignUp_button();
	}
	
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TE05_Validate_CharterDotCom_LoginOption(Map<String,String> testdata) throws Exception {
		
		String BasicURL=testdata.get("LegacySiteURL");
		driver.get(BasicURL);
		BasicAuthenticaion basic=new BasicAuthenticaion(driver);
		basic.Login_button();
	}

	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TE06_Validate_Navigation_from_charterDotCom_with_Login_option_and_Verify_Business_Customers_Link_inLoginpage(Map<String,String> testdata) throws Exception {
		
		String businessaccountNo=testdata.get("businessaccountNo");
		String SecurityCode=testdata.get("SecurityCode");
		String BusinessCharterID=testdata.get("BusinessCharterID");
		String UserPassword=testdata.get("UserPassword");
		String BasicURL=testdata.get("LegacySiteURL");
		driver.get(BasicURL);
		BasicAuthenticaion basic=new BasicAuthenticaion(driver);
		basic.Business_Customers_Link(businessaccountNo,SecurityCode,BusinessCharterID,UserPassword);
	}
	
	@AfterMethod
	public void afterMethod() throws InterruptedException{
		Thread.sleep(2000);
		driver.manage().deleteAllCookies();
		driver.close();
	}
}
