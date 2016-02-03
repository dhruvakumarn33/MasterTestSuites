package com.charter.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.charter.page.AuthenticationPage;
import com.charter.page.HomePage;
import com.charter.utils.Constants;
import com.charter.utils.DataProviderClass;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.TestNGBase;

public class ForgotPassword extends TestNGBase{
	private String URL= Constants.URL;

	//Name: TA35_Validate_RetrievingPassword_HOHuser()
	//Description: Validate whether the HOH user is able to retrieve the password from Forgot Password Flow
	//HOH User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA35_Validate_RetrievingPassword_HOHuser(Map<String,String> testdata) throws Exception{

		String password = testdata.get("UserPassword");
		String CharterID_fp = testdata.get("CharterID_fp");
		String Zipcode_fp=testdata.get("Zipcode_fp");
		String security_answer=testdata.get("security_answer");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.fp_ValidE2E_HOH(password,CharterID_fp,Zipcode_fp,security_answer), "HOH user is not able to retrieve forgotten password");
	}

	//Name: TA37_Validate_RetrievingPassword_AdminUser()
	//Description: Validate whether the Admin user is able to retrieve the password from Forgot Password Flow
	//Admin User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA37_Validate_RetrievingPassword_AdminUser(Map<String,String> testdata) throws Exception{

		String password = testdata.get("UserPassword");
		String CharterID_fp = testdata.get("CharterID_fp");
		String Zipcode_fp=testdata.get("Zipcode_fp");
		String security_answer=testdata.get("security_answer");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.fp_ValidE2E_Admin(password,CharterID_fp,Zipcode_fp,security_answer), "Admin user is not able to retrieve forgotten password");
	}

	//Name: TA38_Validate_RetrievingPassword_StandardUser()
	//Description: Validate whether the Standard user is able to retrieve the password from Forgot Password Flow
	//Standard User
	//Scripter:Lakshmi
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA38_Validate_RetrievingPassword_StandardUser(Map<String,String> testdata) throws Exception{
		String password = testdata.get("UserPassword");
		String CharterID_fp = testdata.get("CharterID_fp");
		String Zipcode_fp=testdata.get("Zipcode_fp");
		String security_answer=testdata.get("security_answer");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.fp_ValidE2E_Standard(password,CharterID_fp,Zipcode_fp,security_answer), "Standard user is not able to retrieve forgotten password");
	}

	//Name: TA39_Validate_ForgotPasswordPage_HelpLink_NavigateTo_SupportArticlePage()
	//Description: Validate whether the user is able to navigate to the support article page on clicking Help link to find Charter ID link in Forgot Password Flow
	//Scripter:Lakshmi
	//Date/Version:
	@Test
	public void TA39_Validate_ForgotPasswordPage_HelpLink_NavigateTo_SupportArticlePage() throws Exception{
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.fp_supportPage(), "User is not able to Navigate to Support article page");
	}
	//Name: TA40_Validate_ForgotPasswordPage_GetChaterIDLink_NavigateTo_ForgotPasswordPage()
	//Description: Validate whether the user is able to navigate to Create account page on clicking business customers Get Charter ID link in Forgot Password Flow
	//Scripter:Lakshmi
	//Date/Version:
	@Test
	public void TA40_Validate_ForgotPasswordPage_GetChaterIDLink_NavigateTo_ForgotPasswordPage() throws Exception{
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.fp_CCommPage(), "User is not able to Navigate to Create Account page with business customer link in Forgot password flow");
	}

	//Name: TA43_Validate_ForgotUsernamePage_ConfirmPassword_Message()
	//Description:Validate Confirm password and successful message after password has been reset
	//Scripter:Ramana
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA43_Validate_ForgotPasswordPage_ConfirmPassword_Message(Map<String,String> testdata) throws Exception{

		String password = testdata.get("UserPassword");
		String CharterID_fp = testdata.get("CharterID_fp");
		String lastname_fp=testdata.get("lastname_fp");
		String Zipcode_fp=testdata.get("Zipcode_fp");
		String security_answer=testdata.get("security_answer");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.fp_pwdresetsuccess(password,CharterID_fp,lastname_fp,Zipcode_fp,security_answer), "Successful message is not displayed after resetting the password in Forgot password flow");
	}

	//Name: TA44_Validate_ForgotPassword_InvalidZipCodeMessage()
	//Description:Validate whether the user is able to view in-line warning message is getting displayed when invalid length of Zipcode is entered in Forgot Password flow
	//Scripter:Ramana
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA44_Validate_ForgotPassword_InvalidZipCodeMessage(Map<String,String> testdata) throws Exception{

		String CharterID_fp = testdata.get("CharterID_fp");
		String lastname_fp=testdata.get("lastname_fp");
		String invalidZipcode=testdata.get("invalidZipcode");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.fp_invalidzipcode(CharterID_fp,lastname_fp,invalidZipcode), "In-line warning message is not displayed for invalid length of zipcode in Forgot password flow");
	}

	//Name: TA45_Validate_ForgotPassword_InvalidSecurityCodeMessage()
	//Description: Validate whether the user is dispalyed with an error message when user enters invalid security answer in Forgot Password flow
	//Scripter:Ramana
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA45_Validate_ForgotPassword_InvalidSecurityCodeMessage(Map<String,String> testdata) throws Exception{

		String CharterID_fp = testdata.get("CharterID_fp");
		String lastname_fp=testdata.get("lastname_fp");
		String Zipcode_fp=testdata.get("Zipcode_fp");
		String invalidSecurityAns=testdata.get("invalidSecurityAns");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.fp_invalidsecuritycode(CharterID_fp,lastname_fp,Zipcode_fp,invalidSecurityAns), "");
	}
	//Name: TA46_Validate_ForgotPassword_PasswordMismatchMessage()
	//Description:Validate whether the user is able to view in-line warning message when mismatch of password in Forgot Password flow
	//Scripter:Ramana
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA46_Validate_ForgotPassword_PasswordMismatchMessage(Map<String,String> testdata) throws Exception{

		String password = testdata.get("UserPassword");
		String invalidPassword=testdata.get("invalidPassword");
		String CharterID_fp = testdata.get("CharterID_fp");
		String lastname_fp=testdata.get("lastname_fp");
		String Zipcode_fp=testdata.get("Zipcode_fp");
		String security_answer=testdata.get("security_answer");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.fp_pwdmismatch(password,CharterID_fp,lastname_fp,Zipcode_fp,security_answer,invalidPassword), "In-line warning message is not displayed for mismatch of password in Forgot password flow");

	}

	//Name: TA47_Validate_ForgotPassword_NoDataEntry_Message()
	//Description:Validate error message if user didn't entered any data in any of the fields
	//Scripter:Ramana
	//Date/Version:
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA47_Validate_ForgotPassword_NoDataEntry_Message(Map<String,String> testdata) throws Exception{
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		Assert.assertTrue(auth.fp_missedfieldsmessages(),"Error Messages are not displayed when data is not entered in fields of forgot password first page");
        
	}
    @Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TA52_Validate_ForgotPassword_Non_Converted_MS_Login(Map<String,String> testdata) throws Exception{
    	
    	String CharterID_fp = testdata.get("CharterID_fp");
    	String password = testdata.get("UserPassword");
		String Zipcode_fp=testdata.get("Zipcode_fp");
		String security_answer=testdata.get("security_answer");
		
    	HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		AuthenticationPage auth=new AuthenticationPage(driver);
		auth.fp_ValidE2E_NonconvertedMSLogin(CharterID_fp,password,Zipcode_fp,security_answer);
    }
    
    @Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
   	public void TA53_Validate_ForgotPassword_Non_Converted_CharterID(Map<String,String> testdata) throws Exception{
    	String CharterID_fp = testdata.get("CharterID_fp");
    	String password = testdata.get("UserPassword");
		String Zipcode_fp=testdata.get("Zipcode_fp");
		String security_answer=testdata.get("security_answer");
		
       	HomePage hp=new HomePage(driver);
   		hp.loadCharterPage(URL);
   		AuthenticationPage auth=new AuthenticationPage(driver);
   		auth.fp_ValidE2E_NonconvertedCharterID(CharterID_fp,password,Zipcode_fp,security_answer);
       }
    
    @Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
   	public void TA54_Validate_ForgotPassword_Converted_CharterID(Map<String,String> testdata) throws Exception{
    	String CharterID_fp = testdata.get("CharterID_fp");
    	String password = testdata.get("UserPassword");
		String Zipcode_fp=testdata.get("Zipcode_fp");
		String security_answer=testdata.get("security_answer");
		
       	HomePage hp=new HomePage(driver);
   		hp.loadCharterPage(URL);
   		AuthenticationPage auth=new AuthenticationPage(driver);
   		auth.fp_ValidE2E_convertedCharterID(CharterID_fp,password,Zipcode_fp,security_answer);
       }

	@AfterMethod
	public void afterMethod() throws InterruptedException{
		Thread.sleep(2000);
		driver.manage().deleteAllCookies();
		driver.close();
	}
}
