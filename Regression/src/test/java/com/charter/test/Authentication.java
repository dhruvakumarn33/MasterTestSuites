package com.charter.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.charter.page.AuthenticationPage;
import com.charter.page.HomePage;
import com.charter.utils.Constants;
import com.charter.utils.DataProviderClass;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.TestNGBase;

public class Authentication extends TestNGBase{
	
	private String URL= Constants.URL;
	
	//Name: TU01_Validate_LoginErrorMsg_InvalidDomain()
	//Description: Validate the error message when tried to login with Invalid Domain
	//Standard user
	//Scripter:Dhruva
	//Date/Version:22-Jul-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TU01_Validate_LoginErrorMsg_InvalidDomain(Map<String,String> testdata) throws Exception {

		String username = testdata.get("email");
		String password = testdata.get("UserPassword");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		Assert.assertTrue(hp.validateDomain(username, password), "Invalid Domain users are validated at login");
	}
	
	//Name: TU02_Validate_LoginZipCode_WeakPassword()
	//Description: Validate the zip code check when tried to login with weak password
	//Standard user
	//Scripter:Dhruva
	//Date/Version:22-Jul-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TU02_Validate_LoginZipCode_WeakPassword(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		Assert.assertTrue(hp.checkweakpassword(username, password), "Zip code entry is not prompted while logging with weak password");
	}
		
}
