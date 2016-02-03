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


public class Authentication_NegativeSceanrio extends TestNGBase{
	
	private String URL= Constants.URL;
	
/*	//Name: TA27_Validate_ForgotUsernamePage_SecurityQuestion()
	//Description: Validate Security questions
	//Scripter:Ramana
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA27_Validate_ForgotUsernamePage_SecurityQuestion(Map<String,String> testdata) throws Exception{
		String invalidSecurityAns=testdata.get("invalidSecurityAns");
		String zipcode_fID=testdata.get("zipcode_fID");
		String AccountNumberVerify=testdata.get("AccountNumberVerify");
		String ACnumber=testdata.get("ACnumber");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		auth.SecAns_ErrorMsg(zipcode_fID,AccountNumberVerify,ACnumber,invalidSecurityAns);
	}
*/
	//Name: TA10_Validate_CreateID_AddressMismatch_Message()
	//Description: Validate Service address mismatch flow
	//Scripter:Ramana
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA10_Validate_CreateID_AddressMismatch_Message(Map<String,String> testdata) throws Exception{
		
		String firstname_CID=testdata.get("firstname_CID");
		String lastname_CID=testdata.get("lastname_CID");
		String Zipcode_CID=testdata.get("zipcode_CID");
		String MAC_CID=testdata.get("mac_CID");
		String invalidAddress=testdata.get("invalidAddress");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.Service_Address_mismatch(firstname_CID,lastname_CID,invalidAddress,Zipcode_CID,MAC_CID), "Captcha code is not displayed for Services Address Mismatch");
	}

	//Name: TA11_Validate_CreateID_FirstScreenInvalidData_ErrorMessage()
	//Description: Validate whether the user is displayed with an error message when invalid data is entered in the first screen of Create ID flow
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA11_Validate_CreateID_FirstScreenInvalidData_ErrorMessage(Map<String,String> testdata)throws Exception{
		
		String firstname_CID=testdata.get("firstname_CID");
		String lastname_CID=testdata.get("lastname_CID");
		String Address_CID=testdata.get("address_CID");
		String Zipcode_CID=testdata.get("zipcode_CID");
		String MAC_CID=testdata.get("mac_CID");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.Invalid_Data(firstname_CID,lastname_CID,Address_CID,Zipcode_CID,MAC_CID), "Error Message is not displayed when invalid data entered in first screen of create ID page");
	}

   //Name: TA19_Validate_CreateID_WithoutHOHAccountCreation_Message()
	//Description: Validate whether the user is displayed with an error message when user tries to create an account without the creation of HOH in the account.
	//Scripter:Lakshmi
	//Date/Version:
	//error message when user tries to create an account without the creation of HOH in the account.
	//@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA19_Validate_CreateID_WithoutHOHAccountCreation_Message(Map<String,String> testdata) throws Exception{
		
		String firstname_CID=testdata.get("firstname_CID");
		String lastname_CID=testdata.get("lastname_CID");
		String Address_CID=testdata.get("address_CID");
		String Zipcode_CID=testdata.get("zipcode_CID");
		String MAC_CID=testdata.get("mac_CID");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.HOH_ErrorMessage(firstname_CID,lastname_CID,Address_CID,Zipcode_CID,MAC_CID), "The first Charter Identity on your account must be created by the primary account holder message is not displayed in create ID page");
	}
}
