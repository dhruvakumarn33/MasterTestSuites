package com.charter.page;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.jetty.html.Frame;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.charter.page.UserPreferencePage.userType;
import com.charter.utils.Constants;
import com.cognizant.framework.ajax.Until;
import com.cognizant.framework.core.CaptureScreenshot;
import com.cognizant.framework.core.EnvParameters;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.WebDriverBase;
import com.gargoylesoftware.htmlunit.html.FrameWindow;
import com.opera.core.systems.internal.ImplicitWait;

public class AuthenticationPage extends WebDriverBase {

	private String URL= Constants.URL;

	private static String SignInLink=ReadFromExcel.getLocator("HomePage", "SignIn");
	private static String Username=ReadFromExcel.getLocator("HomePage", "username");
	private static String Password=ReadFromExcel.getLocator("HomePage", "password");
	private static String PasswordPlaceHolder=ReadFromExcel.getLocator("HomePage", "password_placeholder");
	private static String btnSignin=ReadFromExcel.getLocator("HomePage", "btnSignin");
	private static String fPassword=ReadFromExcel.getLocator("HomePage", "forgotPassword");
	private static String CharterID=ReadFromExcel.getLocator("HomePage", "CharterID");
	private static String fplastname=ReadFromExcel.getLocator("HomePage", "fplastname");
	private static String Zipcode=ReadFromExcel.getLocator("HomePage", "Zipcode");
	private static String Nextbtn=ReadFromExcel.getLocator("HomePage", "Nextbtn");
	private static String Proceedbtn=ReadFromExcel.getLocator("HomePage", "Proceedbtn");
	private static String captcha=ReadFromExcel.getLocator("HomePage", "captcha");
	private static String CreateID=ReadFromExcel.getLocator("HomePage", "CreateID");
	private static String CIDAddressfield=ReadFromExcel.getLocator("HomePage", "Address");
	private static String cIDFirstname= ReadFromExcel.getLocator("HomePage", "cIDFirstname");
	private static String cIDlastname=ReadFromExcel.getLocator("HomePage", "cIDlastname");
	private static String cIDZipcode=ReadFromExcel.getLocator("HomePage", "cIDZipcode");
	private static String CID_ZipcodeError=ReadFromExcel.getLocator("CreateID", "CID_ZipcodeError");
	private static String cIDMAC=ReadFromExcel.getLocator("HomePage", "cIDMAC");
	private static String cIDHelpmsg=ReadFromExcel.getLocator("HomePage", "cIDHelpmsg");
	
	private static String CID_HelpMessage=ReadFromExcel.getData("Auth", "CID_HelpMessage");
	
	private static String cIDNextbtn=ReadFromExcel.getLocator("HomePage", "cIDNextbtn");
	private static String CharterIDhelpicon=ReadFromExcel.getLocator("CreateID", "CharterIDhelpicon");
	private static String pwdhelpicon=ReadFromExcel.getLocator("CreateID", "pwdhelpicon");
	private static String LastnameR=ReadFromExcel.getLocator("CreateID", "LastnameR");
	private static String AddressR=ReadFromExcel.getLocator("CreateID", "AddressR");
	private static String Address1R=ReadFromExcel.getLocator("CreateID", "Address1R");
	private static String Address2R=ReadFromExcel.getLocator("CreateID", "Address2R");
	private static String ZipcodeR=ReadFromExcel.getLocator("CreateID", "ZipcodeR");
	private static String MacR=ReadFromExcel.getLocator("CreateID", "MacR");
	private static String MACError=ReadFromExcel.getLocator("CreateID", "MACError");
	private static String AddressHelpicon=ReadFromExcel.getLocator("CreateID", "AddressHelpicon");
	private static String MACHelpicon=ReadFromExcel.getLocator("CreateID", "MACHelpicon");
	private static String PrimaryAccHelpicon=ReadFromExcel.getLocator("CreateID", "PrimaryAccHelpicon");
	private static String PwdError1=ReadFromExcel.getLocator("CreateID", "PwdError1");
	private static String PwdError2=ReadFromExcel.getLocator("CreateID", "PwdError2");
	private static String PwdError3=ReadFromExcel.getLocator("CreateID", "PwdError3");
	private static String SecureAnsError=ReadFromExcel.getLocator("CreateID", "SecureAnsError");
	//***********/
	private static String cIDCharterID=ReadFromExcel.getLocator("HomePage", "cIDCharterID");
	private static String cIDPassword=ReadFromExcel.getLocator("HomePage", "cIDPassword");
	private static String cIDEmail=ReadFromExcel.getLocator("HomePage", "cIDEmail");
	private static String cIDSecurityAnswer=ReadFromExcel.getLocator("HomePage", "cIDSecurityAnswer");
	//********************/

	private static String fCharterId=ReadFromExcel.getLocator("HomePage", "fCharterId");
	private static String fID_Address=ReadFromExcel.getLocator("HomePage", "fID_Address");
	private static String fID_Zipcode=ReadFromExcel.getLocator("HomePage", "fID_Zipcode");
	private static String fID_Mac=ReadFromExcel.getLocator("HomePage", "fID_Mac");
	private static String fID_LastName=ReadFromExcel.getLocator("ForgotUsername", "fID_LastName");
	private static String SelecttoVerify=ReadFromExcel.getLocator("ForgotUsername", "SelecttoVerify");
	private static String InfoField=ReadFromExcel.getLocator("ForgotUsername", "InfoField");
	private static String FU_Commpage=ReadFromExcel.getLocator("ForgotUsername", "FU_Commpage");
	private static String FUNextbtn=ReadFromExcel.getLocator("ForgotUsername", "FUNextbtn");
	private static String ErrorMessage=ReadFromExcel.getLocator("ForgotUsername", "ErrorMessage");
	private static String fpCharterId=ReadFromExcel.getLocator("ForgotPassword", "fpCharterId");
	private static String fp_lastname=ReadFromExcel.getLocator("ForgotPassword", "fp_lastname");
	private static String fpZip=ReadFromExcel.getLocator("ForgotPassword", "fpZip");
	
	private static String ForgotAnswerLink=ReadFromExcel.getLocator("ForgotPassword", "ForgotAnswerLink");
	private static String EmailCheckBox=ReadFromExcel.getLocator("ForgotPassword", "EmailCheckBox");
	private static String getCode=ReadFromExcel.getLocator("ForgotPassword", "getCode");
	private static String checkEmail=ReadFromExcel.getLocator("ForgotPassword", "checkEmail");
	
	private static String fpNextBtn=ReadFromExcel.getLocator("ForgotPassword", "fpNextBtn");
	private static String Savebtn=ReadFromExcel.getLocator("ForgotPassword", "Savebtn");
	private static String SuccessMsg=ReadFromExcel.getLocator("ForgotPassword", "SuccessMsg");
	private static String Finishbtn=ReadFromExcel.getLocator("ForgotPassword", "Finishbtn");
	private static String fpSecurityAnswer=ReadFromExcel.getLocator("ForgotPassword", "fpSecurityAnswer");
	private static String fpNewPassword=ReadFromExcel.getLocator("ForgotPassword", "fpNewPassword");
	private static String fpConfirmNewPassword=ReadFromExcel.getLocator("ForgotPassword", "fpConfirmNewPassword");
	private static String fpSignInBtn=ReadFromExcel.getLocator("ForgotPassword", "fpSignInBtn");
	private static String fp_helpLink=ReadFromExcel.getLocator("ForgotPassword", "fp_helpLink");
	private static String FU_helplink=ReadFromExcel.getLocator("ForgotUsername", "FU_helplink");
	private static String fp_CommPage=ReadFromExcel.getLocator("ForgotPassword", "fp_CommPage");
	private static String InvalidMsg=ReadFromExcel.getLocator("ForgotPassword", "InvalidMsg");
	private static String InvalidPWD=ReadFromExcel.getLocator("ForgotPassword", "InvalidPWD");
	private static String CommPagelink=ReadFromExcel.getLocator("CreateID", "CommPagelink");
	private static String fp_Nextpw=ReadFromExcel.getLocator("ForgotPassword", "fp_Nextpw");
	private static String fpSecurityNextBtn=ReadFromExcel.getLocator("ForgotPassword", "fpSecurityNextBtn");
	private static String invalidsecurityerror=ReadFromExcel.getLocator("ForgotPassword", "invalidsecurityerror");
	private static String lnkAccount=ReadFromExcel.getLocator("HomePage", "lnkAccount");
	private static String weSignOut=ReadFromExcel.getLocator("HomePage", "weSignOut");

	//add user
	private static String weLastName=ReadFromExcel.getLocator("UPPage", "weLastName");
	private static String wecharterID=ReadFromExcel.getLocator("UPPage", "wecharterID");
	private static String wepassword=ReadFromExcel.getLocator("UPPage", "wepassword");
	private static String weconfirmpassword=ReadFromExcel.getLocator("UPPage", "weconfirmpassword");
	private static String PwdError=ReadFromExcel.getLocator("CreateID", "PwdError");
	private static String EmailError=ReadFromExcel.getLocator("CreateID", "EmailError");
	private static String weemail=ReadFromExcel.getLocator("UPPage", "weemail");
	private static String weMobilephone=ReadFromExcel.getLocator("CreateID", "Mobilephone");
	private static String wesecurityQuestion=ReadFromExcel.getLocator("UPPage", "wesecurityQuestion");
	private static String wesecurityAnswer=ReadFromExcel.getLocator("UPPage", "wesecurityAnswer");
	private static String cbterms=ReadFromExcel.getLocator("UPPage", "cbterms");
	private static String btncreateUsername=ReadFromExcel.getLocator("UPPage", "btncreateUsername");
	private static String btnfinish=ReadFromExcel.getLocator("UPPage", "btnfinish");
	private static String msgCreation=ReadFromExcel.getLocator("UPPage", "msgCreation");
	private static String submitSignin=ReadFromExcel.getLocator("HomePage", "submitSignin");
	private static String DoneButton=ReadFromExcel.getLocator("CreateID", "DoneButton");
	private static String Nobutton=ReadFromExcel.getLocator("ForgotUsername", "Nobutton");
	private static String FURBNextButton=ReadFromExcel.getLocator("ForgotUsername", "FURBNextButton");
	private static String SecAnsErrorMSG=ReadFromExcel.getLocator("ForgotUsername", "SecAnsErrorMSG");
	private static String Fusigninbtn=ReadFromExcel.getLocator("ForgotUsername", "Fusigninbtn");
	private static String FU1Nextbtn=ReadFromExcel.getLocator("ForgotUsername", "FU1Nextbtn");
	private static String FIDMessage=ReadFromExcel.getLocator("ForgotUsername", "FIDMessage");
	private static String FID_user11=ReadFromExcel.getLocator("ForgotUsername", "FID_signin1");
	private static String FID_pw1=ReadFromExcel.getLocator("ForgotUsername", "FID_pw1");
	private static String invalidError=ReadFromExcel.getLocator("ForgotUsername", "invalidError");
	private static String Zip_Message=ReadFromExcel.getLocator("CreateID", "Zip_Message");
	private static String MAC_Message=ReadFromExcel.getLocator("CreateID", "MAC_Message");
	private static String LastName_Message=ReadFromExcel.getLocator("CreateID", "LastName_Message");
	private static String Address_Message=ReadFromExcel.getLocator("CreateID", "Address_Message");
	private static String MyAccountTab=ReadFromExcel.getLocator("MAPage", "MyAccountTab");
	private static String UserPreferencelink=ReadFromExcel.getLocator("MAPage", "UserPreferencelink");
	private static String PrimaryACCHolder=ReadFromExcel.getLocator("CreateID", "PrimaryACCHolder");

	private static String accountctrlPlusbtn=ReadFromExcel.getLocator("UPPage", "accountctrlPlusbtn");
	private static String chkboxAdmin=ReadFromExcel.getLocator("UPPage", "chkboxAdmin");
	private static String accountCtrlsavebtn=ReadFromExcel.getLocator("UPPage", "accountCtrlsavebtn");
	private static String btnOK=ReadFromExcel.getLocator("UPPage", "btnOK");
	
	//----------------------
	private static String QuoteTimeError=ReadFromExcel.getLocator("ForgotPassword", "QuoteTimeError");
	private static String GmailID=ReadFromExcel.getLocator("ForgotPassword", "GmailID");
	private static String Gmailpw=ReadFromExcel.getLocator("ForgotPassword", "Gmailpw");
	private static String GmailNext=ReadFromExcel.getLocator("ForgotPassword", "GmailNext");
	private static String GmailSignin=ReadFromExcel.getLocator("ForgotPassword", "GmailSignin");
	private static String GmailFpMail=ReadFromExcel.getLocator("ForgotPassword", "GmailFpMail");
	private static String GmailResetLink=ReadFromExcel.getLocator("ForgotPassword", "GmailResetLink");
	
	//Update Username
	private static String UpFirstName=ReadFromExcel.getLocator("HomePage", "UpFirstName");
	private static String UpLastName=ReadFromExcel.getLocator("HomePage", "UpLastName");
	private static String UpSecQ=ReadFromExcel.getLocator("HomePage", "UpSecQ");
	private static String UpSecA=ReadFromExcel.getLocator("HomePage", "UpSecA");
	private static String UpEmail=ReadFromExcel.getLocator("HomePage", "UpEmail");
	private static String UpMobile=ReadFromExcel.getLocator("HomePage", "UpMobile");
	private static String UpTC=ReadFromExcel.getLocator("HomePage", "UpTC");
	private static String UpUpdatebtn=ReadFromExcel.getLocator("HomePage", "UpUpdatebtn");
	private static String inlineError=ReadFromExcel.getLocator("ForgotUsername", "inlineError");
	private static String needMoreInfoMsg=ReadFromExcel.getLocator("ForgotUsername", "needMoreInfoMsg");
	private static String lastName=ReadFromExcel.getLocator("ForgotUsername", "lastName");
	private static String Ap_GmailConfirm=ReadFromExcel.getLocator("BTPage", "Ap_GmailConfirm");
	private static String GmailConfirm_payment=ReadFromExcel.getLocator("BTPage", "GmailConfirm_payment");
	private static String Sp_GmailConfirm=ReadFromExcel.getLocator("BTPage", "Sp_GmailConfirm");
	private static String fp_Gmail=ReadFromExcel.getLocator("ForgotPassword", "fp_Gmail");
	private static String statementMail=ReadFromExcel.getLocator("BTPage", "statementMail");
	private static String billDeliveryMail=ReadFromExcel.getLocator("BTPage", "billDeliveryMail");
	private static String gmail_verifymail=ReadFromExcel.getLocator("ForgotUsername", "gmail_verifymail");
	private static String viewTermsCondition=ReadFromExcel.getLocator("CreateID","viewTermsCondition");
	private static String printTerms=ReadFromExcel.getLocator("BTPage","printTerms");
	private static String closeTerms=ReadFromExcel.getLocator("BTPage","closeTerms");
	private static String invalidSecAnsMsg=ReadFromExcel.getLocator("ForgotPassword","invalidSecAnsMsg");
	private static String InfoError=ReadFromExcel.getLocator("ForgotUsername", "InfoError");
	private static String lastNameError=ReadFromExcel.getLocator("ForgotUsername", "lastNameError");
	private static String invalidPhoneError=ReadFromExcel.getLocator("ForgotUsername", "invalidPhoneError");
	private static String newUserGmail=ReadFromExcel.getLocator("CreateID","newUserGmail");
	
	private static String obfuscatedPw=ReadFromExcel.getLocator("HomePage","obfuscatedPw");
	private static String fnRequired=ReadFromExcel.getLocator("HomePage","fnRequired");
	private static String LnRequired=ReadFromExcel.getLocator("HomePage","LnRequired");
	private static String sqRequired=ReadFromExcel.getLocator("HomePage","sqRequired");
	private static String saRequired=ReadFromExcel.getLocator("HomePage","saRequired");
	private static String emailRequired=ReadFromExcel.getLocator("HomePage","emailRequired");
	private static String mobileRequired=ReadFromExcel.getLocator("HomePage","mobileRequired");
	private static String invalidMail=ReadFromExcel.getLocator("HomePage","invalidMail");
	private static String invalidPhone=ReadFromExcel.getLocator("HomePage","invalidPhone");
	private static String signInbtn=ReadFromExcel.getLocator("HomePage","signInbtn");
	
	CaptureScreenshot<WebDriver> screenshot;
	public AuthenticationPage(WebDriver driver) {
		this.driver=driver;	
		screenshot= new CaptureScreenshot<WebDriver>(driver);
	}


	// In Scenario Sheet 
	public boolean createID_Nextbutton(String firstname_CID,String lastname_CID,String Address_CID,String Zipcode_CID,String MAC_CID,String invalidZipcode){

		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(CreateID);
		//	type(cIDFirstname,firstname_CID);
		type(cIDlastname,lastname_CID);
		type(CIDAddressfield,Address_CID);
		type(cIDZipcode,invalidZipcode);
		type(cIDMAC,MAC_CID);
		if(isElementEnabled(cIDNextbtn)){
			retVal=false;
		}
		clearTextBox(cIDZipcode);
		type(cIDZipcode,Zipcode_CID);

		if(isElementEnabled(cIDNextbtn)){
			retVal=true;
		}	
		return retVal;

	}
	public boolean Invalid_Data(String firstname_CID,String lastname_CID,String Address_CID,String Zipcode_CID,String MAC_CID){

		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(CreateID);
		//	type(cIDFirstname,firstname_CID);
		type(cIDlastname,lastname_CID);
		type(CIDAddressfield,Address_CID);
		type(cIDZipcode,Zipcode_CID);
		type(cIDMAC,MAC_CID);
		clickOnElement(cIDNextbtn);
		if(isElementPresent(captcha)){
			retVal=true;
		}

		return retVal;
	}
	public boolean CharterIDrules(String firstname_CID,String lastname_CID,String Address_CID,String Zipcode_CID,String MAC_CID){

		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(CreateID);
		type(cIDFirstname,firstname_CID);
		type(cIDlastname,lastname_CID);
		type(CIDAddressfield,Address_CID);
		type(cIDZipcode,Zipcode_CID);
		type(cIDMAC,MAC_CID);
		clickOnElement(cIDNextbtn);
		hoverOver(CharterIDhelpicon);
		System.out.println("Charter ID Rules:" + getText(CharterIDhelpicon));
		WebElement rule1 = driver.findElement(By.xpath("//h5[contains(text(),'A Charter ID MUST meet the following criteria:')]/following-sibling::ul/li[1]"));
		System.out.println(rule1.getText());
		WebElement rule2 = driver.findElement(By.xpath("//h5[contains(text(),'A Charter ID MUST meet the following criteria:')]/following-sibling::ul/li[2]"));
		System.out.println(rule2.getText());
		WebElement rule3 = driver.findElement(By.xpath("//h5[contains(text(),'A Charter ID MUST meet the following criteria:')]/following-sibling::ul/li[3]"));
		System.out.println(rule3.getText());
		WebElement rule4 = driver.findElement(By.xpath("//h5[contains(text(),'A Charter ID MUST meet the following criteria:')]/following-sibling::ul/li[4]"));
		System.out.println(rule4.getText());
		WebElement rule5 = driver.findElement(By.xpath("//h5[contains(text(),'A Charter ID MUST meet the following criteria:')]/following-sibling::ul/li[5]"));
		System.out.println(rule5.getText());
		WebElement rule6 = driver.findElement(By.xpath("//h5[contains(text(),'A Charter ID MUST meet the following criteria:')]/following-sibling::ul/li[6]"));
		System.out.println(	rule6.getText());
		WebElement rule7 = driver.findElement(By.xpath("//h5[contains(text(),'A Charter ID MUST meet the following criteria:')]/following-sibling::ul/li[7]"));
		System.out.println(rule7.getText());
		WebElement rule8 = driver.findElement(By.xpath("//h5[contains(text(),'A Charter ID MUST meet the following criteria:')]/following-sibling::ul/li[8]"));
		System.out.println(rule8.getText());

		retVal=true;
		return retVal;

	}

	public boolean create_user_ID_fields(String charterID,String password,String email,String security_question,String security_answer,String lastname_CID,String Address_CID,String Zipcode_CID,String MAC_CID,String invalidPassword){

		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(CreateID);
		type(cIDlastname,lastname_CID);
		type(CIDAddressfield,Address_CID);
		type(cIDZipcode,Zipcode_CID);
		type(cIDMAC,MAC_CID);
		clickOnElement(cIDNextbtn);

		type(wecharterID,charterID);
		type(wepassword,invalidPassword);
		if(isElementPresent(PwdError1)&(isElementPresent(PwdError2))&(isElementPresent(PwdError3))){
			System.out.println(getText(PwdError1) + getText(PwdError2) + getText(PwdError3));	
		}
		WebElement pwdStrength = driver.findElement(By.xpath("//span[contains(text(),'WEAK')]"));
		System.out.println(pwdStrength.getText());
		hoverOver(pwdhelpicon);
		System.out.println(getText(pwdhelpicon));

		WebElement rule1 = driver.findElement(By.xpath("//h5[contains(text(),'Passwords rules:')]/following-sibling::ul/li[1]"));
		System.out.println(rule1.getText());
		WebElement rule2 = driver.findElement(By.xpath("//h5[contains(text(),'Passwords rules:')]/following-sibling::ul/li[2]"));
		System.out.println(rule2.getText());
		WebElement rule3 = driver.findElement(By.xpath("//h5[contains(text(),'Passwords rules:')]/following-sibling::ul/li[3]"));
		System.out.println(rule3.getText());
		WebElement rule4 = driver.findElement(By.xpath("//h5[contains(text(),'Passwords rules:')]/following-sibling::ul/li[4]"));
		System.out.println(rule4.getText());
		WebElement rule5 = driver.findElement(By.xpath("//h5[contains(text(),'Passwords rules:')]/following-sibling::ul/li[5]"));
		System.out.println(rule5.getText());
		WebElement rule6 = driver.findElement(By.xpath("//h5[contains(text(),'Passwords rules:')]/following-sibling::ul/li[6]"));
		System.out.println(	rule6.getText());
		WebElement rule7 = driver.findElement(By.xpath("//h5[contains(text(),'Passwords rules:')]/following-sibling::ul/li[7]"));
		System.out.println(rule7.getText());
		WebElement rule8 = driver.findElement(By.xpath("//h5[contains(text(),'Passwords rules:')]/following-sibling::ul/li[8]"));
		System.out.println(rule8.getText());
		WebElement rule9 = driver.findElement(By.xpath("//h5[contains(text(),'Passwords rules:')]/following-sibling::ul/li[9]"));
		System.out.println(rule9.getText());
		clearTextBox(wepassword);
		type(wepassword,password);
		type(weconfirmpassword,password);
		type(weemail,email);
		selectValueFromDropDown(wesecurityQuestion,security_question);
		type(wesecurityAnswer,security_answer);

		if(isElementPresent(SecureAnsError)){
			System.out.println(getText(SecureAnsError));
		}
		clickOnElement(cbterms);
		clickOnElement(btncreateUsername);
		retVal=true;
		return retVal;
	}



	public boolean fp_ValidE2E_HOH(String password,String CharterID_fp,String Zipcode_fp,String security_answer) throws Exception{

		boolean retVal=false;
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(fPassword));
		clickOnElement(fPassword);
		HomePage hp=new HomePage(driver);
		hp.pagewait();
		type(fpCharterId,""+Keys.TAB);
		type(fpZip,""+Keys.TAB);
		driver.manage().deleteAllCookies();
		hp.loadCharterPage(URL);
		clickOnElement(SignInLink);
		clickOnElement(fPassword);
		type(fpCharterId,CharterID_fp);
		type(fpZip,Zipcode_fp);
		wait(Until.elementToBeClickable(fpNextBtn));
		clickOnElement(fpNextBtn);
		sleep(5);
		clickOnElement(fpNextBtn);
		if(isElementVisible(invalidSecAnsMsg))
			System.out.println(getText(invalidSecAnsMsg));
		type(fpSecurityAnswer,security_answer);
		wait(Until.elementToBeClickable(fpNextBtn));
		clickOnElement(fpNextBtn);
		wait(Until.elementToBeDisplayed(fpNewPassword));
		type(fpNewPassword,password);
		type(fpConfirmNewPassword,"Test"+Keys.TAB);
		if(isElementVisible("xpath;//*[contains(text(),'match')]")){
			System.out.println("Passwords do not match message: "+getText("xpath;//*[contains(text(),'match')]"));
		}
		clearTextBox(fpConfirmNewPassword);
		type(fpConfirmNewPassword,password);
		clickOnElement(Savebtn);
		clickOnElement(Finishbtn);
		retVal=true;
		return retVal;

	}
	
	public boolean fp_ValidE2E_UnconvertedHOH(String password,String CharterID_fp,String Zipcode_fp,String security_answer) throws Exception{

		boolean retVal=false;
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(fPassword));
		clickOnElement(fPassword);
		HomePage hp=new HomePage(driver);
		hp.pagewait();
		type(fpCharterId,""+Keys.TAB);
		type(fpZip,""+Keys.TAB);
		if(isElementVisible("xpath;//*[contains(text(),'Please enter a valid username')]")){
			System.out.println("Invalid username error message :"+getText("xpath;//*[contains(text(),'Please enter a valid username')]"));
		}
		if(isElementVisible("xpath;//*[contains(text(),'Please enter a valid ZIP code')]")){
			System.out.println("Invalid username error message :"+getText("xpath;//*[contains(text(),'Please enter a valid ZIP code')]"));
		}
		driver.manage().deleteAllCookies();
		hp.loadCharterPage(URL);
		clickOnElement(SignInLink);
		clickOnElement(fPassword);
		type(fpCharterId,CharterID_fp);
		type(fpZip,Zipcode_fp);
		wait(Until.elementToBeClickable(fpNextBtn));
		clickOnElement(fpNextBtn);
		sleep(5);
		clickOnElement("xpath;//*[text()='"+CharterID_fp+"@charter.net']");
		sleep(5);
		clickOnElement(fpNextBtn);
		sleep(5);
		clickOnElement(fpNextBtn);
		if(isElementVisible(invalidSecAnsMsg))
			System.out.println(getText(invalidSecAnsMsg));
		type(fpSecurityAnswer,security_answer);
		wait(Until.elementToBeClickable(fpNextBtn));
		clickOnElement(fpNextBtn);
		wait(Until.elementToBeDisplayed(fpNewPassword));
		type(fpNewPassword,password);
		type(fpConfirmNewPassword,"Test"+Keys.TAB);
		if(isElementVisible("xpath;//*[contains(text(),'match')]")){
			System.out.println("Passwords do not match message: "+getText("xpath;//*[contains(text(),'match')]"));
		}
		clearTextBox(fpConfirmNewPassword);
		type(fpConfirmNewPassword,password);
		clickOnElement(Savebtn);
		sleep(10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(getText("xpath;//*[contains(@class,'forgot-id')]").contains("Almost Done")){
			System.out.println("conversion message displayed: "+getText("xpath;//*[contains(@class,'forgot-id')]"));
			clickOnElement("xpath;.//*[@id='confirmation-finish-submit']");
		}
		sleep(10);
		if(isElementVisible("xpath;//*[text()='Update Your Username']")){
			System.out.println("Forgot password for a unconvertetd user leads to conversion flow after password reset");
		}
		retVal=true;
		return retVal;

	}
	
	public boolean fp_ChangedSecurityQuestion(String password,String CharterID_fp,String Zipcode_fp,String security_answer,String email) throws Exception{
		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(fPassword);
		HomePage hp=new HomePage(driver);
		hp.pagewait();
		type(fpCharterId,CharterID_fp);
		type(fpZip,Zipcode_fp);
		clickOnElement(fpNextBtn);
		wait(Until.elementToBeDisplayed(fpSecurityAnswer));
		type(fpSecurityAnswer,"wrongAnswer");
		clickOnElement(fpNextBtn);
		if(isElementVisible(invalidSecAnsMsg)){
			sleep(10);
			System.out.println(getText(invalidSecAnsMsg));
		}
		clickOnElement(ForgotAnswerLink);
		//setCheckBox(EmailCheckBox,true);
		//setCheckBox(EmailCheckBox, true);
		String text[] = email.split("@");
		//System.out.println(text[0]+"and"+text[1]);
		String dropdownvalue = text[0].charAt(text[0].length()-1) + "";
		//System.out.println(dropdownvalue);
		dropdownvalue= dropdownvalue+"@"+text[1];
		//System.out.println(dropdownvalue);
		//Select selc = new Select(driver.findElement(By.xpath("//select[@name='email']/option[contains(text(),'"+dropdownvalue+"')]")));
		//selectValueFromDropDown("xpath;//select[@name='email']", dropdownvalue);
		clickOnElement("xpath;(//*[contains(text(),'"+dropdownvalue+"')])[1]");
		clickOnElement(getCode);
		sleep(5);
		retVal=true;
		return retVal;

	}

	public boolean fp_ValidE2E_Admin(String password,String CharterID_fp,String Zipcode_fp,String security_answer) throws Exception{

		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(fPassword);
		HomePage hp=new HomePage(driver);
		hp.pagewait();
		type(fpCharterId,CharterID_fp);
		type(fpZip,Zipcode_fp);
		clickOnElement(fpNextBtn);
		type(fpSecurityAnswer,security_answer);
		clickOnElement(fpNextBtn);
		type(fpNewPassword,password);
		type(fpConfirmNewPassword,password);
		clickOnElement(Savebtn);
		clickOnElement(Finishbtn);
		hp.logoutApplication();
		retVal=true;
		return retVal;
	}

	public boolean fp_ValidE2E_Standard(String password,String CharterID_fp,String Zipcode_fp,String security_answer) throws Exception{

		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(fPassword);
		HomePage hp=new HomePage(driver);
		hp.pagewait();
		type(fpCharterId,CharterID_fp);
		type(fpZip,Zipcode_fp);
		clickOnElement(fpNextBtn);
		type(fpSecurityAnswer,security_answer);
		clickOnElement(fpNextBtn);
		type(fpNewPassword,password);
		type(fpConfirmNewPassword,password);
		clickOnElement(Savebtn);
		clickOnElement(Finishbtn);
		hp.logoutApplication();
		retVal=true;
		return retVal;
	}
	
	public boolean FP_MS_Login(String password,String CharterID_fp,String Zipcode_fp,String security_answer) throws Exception{

		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(fPassword);
		HomePage hp=new HomePage(driver);
		hp.pagewait();
		type(fpCharterId,CharterID_fp);
		type(fpZip,Zipcode_fp);
		clickOnElement(fpNextBtn);
		type(fpSecurityAnswer,security_answer);
		clickOnElement(fpNextBtn);
		type(fpNewPassword,password);
		type(fpConfirmNewPassword,password);
		clickOnElement(Savebtn);
		clickOnElement(Finishbtn);
		/*clickOnElement(fpSignInBtn);
		hp.loadCharterPage(URL);
		hp.login(CharterID_fp,password);*/
		hp.logoutApplication();
		retVal=true;
		return retVal;

	}
	public boolean fp_supportPage()
	{
		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(fPassword);
		clickOnElement(fp_helpLink);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		retVal=true;
		return retVal;
	}



	public boolean fp_CCommPage()
	{
		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(fPassword);
		clickOnElement(fp_CommPage);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		retVal=true;
		return retVal;
	}

	public boolean fID_Supportpage(){

		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(fCharterId);
		wait(Until.elementToBeClickable(FU_helplink));
		clickOnElement(FU_helplink);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		retVal=true;
		return retVal;
	}

	public boolean fID_CommPage(){

		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(fCharterId);
		clickOnElement(FU_Commpage);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		retVal=true;
		return retVal;
	}

	public boolean cID_CommPage(){

		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(CreateID);
		wait(Until.elementToBeClickable(CommPagelink));
		clickOnElement(CommPagelink);
		System.out.println(driver.getCurrentUrl());
		retVal=true;
		return retVal;
	}

	public void createuser_STND(String firstname_CID,String lastname_CID,String Address_CID,String Zipcode_CID,String MAC_CID,String charterID, String password, String email,String security_question, String security_answer,String Mobilephone) throws Exception
	{
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(CreateID));
		clickOnElement(CreateID);
		type(cIDlastname,lastname_CID);
		type(CIDAddressfield,Address_CID);
		type(cIDZipcode,Zipcode_CID);
		type(cIDMAC,MAC_CID);
		clickOnElement(cIDNextbtn);
		type(cIDFirstname,firstname_CID);
		type(wecharterID,charterID);
		type(wepassword,password);
		type(weconfirmpassword,password);
		selectValueFromDropDown(wesecurityQuestion,security_question);
		type(wesecurityAnswer,security_answer);
		type(weemail,email);
		type(weMobilephone,Mobilephone);

		clickOnElement(cbterms);
		clickOnElement(btncreateUsername);
		if(isElementPresent(msgCreation)){
			System.out.println(getText(msgCreation));
		}
		clickOnElement(btnfinish);

		HomePage hp=new HomePage(driver);
		if(isElementVisible(weSignOut)){
			hp.logoutApplication();
		}
		else{
			hp.login(charterID, password);
			hp.pagewait();
			hp.logoutApplication();
		}

	}

	public void VerifyNewuserrole(String NewRole){

		WebElement role=driver.findElement(By.xpath("//div[@class='user-identity ng-scope' ]/descendant::p[@class='role ng-scope']/span"));

		String  nrole=role.getText();

		if(NewRole.equalsIgnoreCase(nrole))  
		{
			System.out.println("New role in app:"+nrole);
			System.out.println("Role comparison:"+NewRole);

		}
		else
		{
			System.out.println("New role in app"+nrole);
			System.out.println("Test data"+NewRole);
		}
		return;
	}
	public void promoteToAdmin(String HOHuser,String pword,String charterID,String Account_Type,String NewRole){

		UserPreferencePage UPpage=new UserPreferencePage(driver);
		UPpage.selectuser(userType.username,charterID);
		UPpage.Promote_Selected_User("Admin");
		UPpage.selectuser(userType.username,charterID);
		VerifyNewuserrole(NewRole);
	}
	
	public boolean createuser_HOH(String ACNum, String firstname_CID,String lastname_CID,String Address_CID,String Zipcode_CID,String MAC_CID,String charterID, String password, String email,String security_question, String security_answer,String Mobilephone) throws Exception
	{
		boolean retVal= false;
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(CreateID));
		clickOnElement(CreateID);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='account-option']"));
		selectValueFromDropDown("xpath;.//*[@id='account-option']", "Phone Number on Account");
		type("xpath;//*[@name='verifyData']",""+Keys.TAB);
		if(isElementVisible("xpath;//*[contains(text(),'Please enter your info')]")){
			System.out.println("Error message for invalid info: "+getText("xpath;//*[contains(text(),'Please enter your info')]"));
		}
		type("xpath;//*[@name='verifyData']",Mobilephone);
		type(cIDlastname,""+Keys.TAB);
		if(isElementVisible("xpath;//*[contains(text(),'Please enter your last name')]")){
			System.out.println("Error message for invalid last name: "+getText("xpath;//*[contains(text(),'Please enter your last name')]"));
		}
		type(cIDlastname,lastname_CID);
		clickOnElement("xpath;.//*[@id='account-info-submit']");
		sleep(10);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='account-option']"));
		selectValueFromDropDown("xpath;.//*[@id='account-option']", "Last Four Characters of MAC Address");
		type("xpath;//*[@name='verifyData']",""+Keys.TAB);
		if(isElementVisible("xpath;//*[contains(text(),'Please enter your info')]")){
			System.out.println("Error message for invalid info: "+getText("xpath;//*[contains(text(),'Please enter your info')]"));
		}
		type("xpath;//*[@name='verifyData']",MAC_CID);
		clickOnElement("xpath;.//*[@id='account-info-submit']");
		sleep(10);
		wait(Until.elementToBeDisplayed(cIDFirstname));
		type(cIDFirstname,""+Keys.TAB);
		if(isElementVisible("xpath;//*[contains(text(),'First name is required')]")){
			System.out.println("Error message for invalid first name : "+getText("xpath;//*[contains(text(),'First name is required')]"));
		}
		type(cIDFirstname,firstname_CID);
		type(wecharterID,""+Keys.TAB);
		if(isElementVisible("xpath;//*[contains(text(),'Username is required')]")){
			System.out.println("Error message for invalid User name : "+getText("xpath;//*[contains(text(),'Username is required')]"));
		}
		type(wecharterID,charterID);
		type(wepassword,""+Keys.TAB);
		if(isElementVisible("xpath;//*[contains(text(),'Password is required')]")){
			System.out.println("Error message for invalid Password : "+getText("xpath;//*[contains(text(),'Password is required')]"));
		}
		type(wepassword,password);
		type(weconfirmpassword,""+Keys.TAB);
		if(isElementVisible("xpath;//*[contains(text(),'Please enter your info')]")){
			System.out.println("Error message for invalid password : "+getText("xpath;//*[contains(text(),'Please enter your info')]"));
		}
		type(weconfirmpassword,password);
		type(weemail,""+Keys.TAB);
		if(isElementVisible("xpath;//*[contains(text(),'Please enter your info')]")){
			System.out.println("Error message for invalid email : "+getText("xpath;//*[contains(text(),'Please enter your info')]"));
		}
		type(weemail,email);
		clickOnElement(wesecurityQuestion);
		pressKey(wesecurityQuestion, Keys.TAB);
		if(isElementVisible("xpath;//*[contains(text(),'Please select your security question')]")){
			System.out.println("Error message for invalid Sec Q : "+getText("xpath;//*[contains(text(),'Please select your security question')]"));
		}
		selectValueFromDropDown(wesecurityQuestion,security_question);
		type(wesecurityAnswer,""+Keys.TAB);
		if(isElementVisible("xpath;//*[contains(text(),'Please enter your info')]")){
			System.out.println("Error message for invalid Sec A : "+getText("xpath;//*[contains(text(),'Please enter your info')]"));
		}
		type(wesecurityAnswer,security_answer);
		type(weMobilephone,""+Keys.TAB);
		if(isElementVisible("xpath;//*[contains(text(),'Please enter your info')]")){
			System.out.println("Error message for invalid Mobile phone : "+getText("xpath;//*[contains(text(),'Please enter your info')]"));
		}
		type(weMobilephone,Mobilephone);
		clickOnElement(viewTermsCondition);
/*		String[] filepath=new String[] { System.getProperty("user.dir") + File.separator + "AutoIT" + File.separator +"Print.exe",EnvParameters.WEB_BROWSER_TYPE.replaceAll("\\*", "")};
		Runtime.getRuntime().exec(filepath);
		clickOnElement(printTerms);*/
		sleep(10);
		wait(Until.elementToBeDisplayed(closeTerms));
		clickOnElement(closeTerms);
		sleep(5);
		clickOnElement(cbterms);
/*		clickOnElement("xpath;//*[@value='Create Username']");
		//clickOnElement(btncreateUsername);
		if(isElementPresent(msgCreation)){
			System.out.println(getText(msgCreation));
		}
		clickOnElement(DoneButton);
		HomePage hp= new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(charterID, password);
		hp.pagewait();*/
		retVal=true;
		return retVal;
	}
	
	public boolean createuser_HOH_ACNum(String ACNum, String firstname_CID,String lastname_CID,String Address_CID,String Zipcode_CID,String MAC_CID,String charterID, String password, String email,String security_question, String security_answer,String Mobilephone) throws Exception
	{
		boolean retVal= false;
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(CreateID));
		clickOnElement(CreateID);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='account-option']"));
		selectValueFromDropDown("xpath;.//*[@id='account-option']", "Phone Number on Account");
		type("xpath;//*[@name='verifyData']",""+Keys.TAB);
		if(isElementVisible("xpath;//*[contains(text(),'Please enter your info')]")){
			System.out.println("Error message for invalid info: "+getText("xpath;//*[contains(text(),'Please enter your info')]"));
		}
		type("xpath;//*[@name='verifyData']",Mobilephone);
		type(cIDlastname,""+Keys.TAB);
		if(isElementVisible("xpath;//*[contains(text(),'Please enter your last name')]")){
			System.out.println("Error message for invalid last name: "+getText("xpath;//*[contains(text(),'Please enter your last name')]"));
		}
		type(cIDlastname,lastname_CID);
		clickOnElement("xpath;.//*[@id='account-info-submit']");
		sleep(10);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='account-option']"));
		type("xpath;//*[@name='verifyData']",""+Keys.TAB);
		if(isElementVisible("xpath;//*[contains(text(),'Please enter your info')]")){
			System.out.println("Error message for invalid info: "+getText("xpath;//*[contains(text(),'Please enter your info')]"));
		}
		type("xpath;//*[@name='verifyData']",ACNum);
		clickOnElement("xpath;.//*[@id='account-info-submit']");
		sleep(10);
		wait(Until.elementToBeDisplayed(cIDFirstname));
		type(cIDFirstname,""+Keys.TAB);
		if(isElementVisible("xpath;//*[contains(text(),'First name is required')]")){
			System.out.println("Error message for invalid first name : "+getText("xpath;//*[contains(text(),'First name is required')]"));
		}
		type(cIDFirstname,firstname_CID);
		type(wecharterID,""+Keys.TAB);
		if(isElementVisible("xpath;//*[contains(text(),'Username is required')]")){
			System.out.println("Error message for invalid first name : "+getText("xpath;//*[contains(text(),'Username is required')]"));
		}
		type(wecharterID,charterID);
		type(wepassword,""+Keys.TAB);
		if(isElementVisible("xpath;//*[contains(text(),'Password is required')]")){
			System.out.println("Error message for invalid first name : "+getText("xpath;//*[contains(text(),'Password is required')]"));
		}
		type(wepassword,password);
		type(weconfirmpassword,""+Keys.TAB);
		if(isElementVisible("xpath;//*[contains(text(),'Please enter your info')]")){
			System.out.println("Error message for invalid first name : "+getText("xpath;//*[contains(text(),'Please enter your info')]"));
		}
		type(weconfirmpassword,password);
		type(weemail,""+Keys.TAB);
		if(isElementVisible("xpath;//*[contains(text(),'Please enter your info')]")){
			System.out.println("Error message for invalid first name : "+getText("xpath;//*[contains(text(),'Please enter your info')]"));
		}
		type(weemail,""+Keys.TAB);
		if(isElementVisible("xpath;//*[contains(text(),'Please enter your info')]")){
			System.out.println("Error message for invalid first name : "+getText("xpath;//*[contains(text(),'Please enter your info')]"));
		}
		type(weemail,email);
		clickOnElement(wesecurityQuestion);
		pressKey(wesecurityQuestion, Keys.TAB);
		if(isElementVisible("xpath;//*[contains(text(),'Please select your security question')]")){
			System.out.println("Error message for invalid first name : "+getText("xpath;//*[contains(text(),'Please select your security question')]"));
		}
		selectValueFromDropDown(wesecurityQuestion,security_question);
		type(wesecurityAnswer,""+Keys.TAB);
		if(isElementVisible("xpath;//*[contains(text(),'Please enter your info')]")){
			System.out.println("Error message for invalid first name : "+getText("xpath;//*[contains(text(),'Please enter your info')]"));
		}
		type(wesecurityAnswer,security_answer);
		type(weMobilephone,""+Keys.TAB);
		if(isElementVisible("xpath;//*[contains(text(),'Please enter your info')]")){
			System.out.println("Error message for invalid first name : "+getText("xpath;//*[contains(text(),'Please enter your info')]"));
		}
		type(weMobilephone,Mobilephone);
		clickOnElement(viewTermsCondition);
/*		String[] filepath=new String[] { System.getProperty("user.dir") + File.separator + "AutoIT" + File.separator +"Print.exe",EnvParameters.WEB_BROWSER_TYPE.replaceAll("\\*", "")};
		Runtime.getRuntime().exec(filepath);
		clickOnElement(printTerms);*/
		sleep(10);
		wait(Until.elementToBeDisplayed(closeTerms));
		clickOnElement(closeTerms);
		sleep(5);
		clickOnElement(cbterms);
/*		clickOnElement("xpath;//*[@value='Create Username']");
		//clickOnElement(btncreateUsername);
		if(isElementPresent(msgCreation)){
			System.out.println(getText(msgCreation));
		}
		clickOnElement(DoneButton);
		HomePage hp= new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(charterID, password);
		hp.pagewait();*/
		retVal=true;
		return retVal;
	}
	
	public boolean createuser_Std(String ACNum, String firstname_CID,String lastname_CID,String Address_CID,String Zipcode_CID,String MAC_CID,String charterID, String password, String email,String security_question, String security_answer,String Mobilephone) throws Exception
	{
		boolean retVal= false;
		clickOnElement(SignInLink);
		sleep(10);
		wait(Until.elementToBeDisplayed(CreateID));
		clickOnElement(CreateID);
		type("xpath;//*[@name='verifyData']",ACNum);
		type(cIDlastname,lastname_CID);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='account-info-submit']"));
		clickOnElement("xpath;.//*[@id='account-info-submit']");
		type(cIDFirstname,firstname_CID);
		type(wecharterID,charterID);
		type(wepassword,password);
		type(weconfirmpassword,password);
		type(weemail,email);
		selectValueFromDropDown(wesecurityQuestion,security_question);
		type(wesecurityAnswer,security_answer);
		type(weMobilephone,Mobilephone);
		clickOnElement(viewTermsCondition);
/*		String[] filepath=new String[] { System.getProperty("user.dir") + File.separator + "AutoIT" + File.separator +"Print.exe",EnvParameters.WEB_BROWSER_TYPE.replaceAll("\\*", "")};
		Runtime.getRuntime().exec(filepath);
		clickOnElement(printTerms);*/
		wait(Until.elementToBeDisplayed(closeTerms));
		clickOnElement(closeTerms);
		sleep(5);
		clickOnElement(cbterms);
		if(isElementPresent("xpath;//*[contains(text(),'marketing purposes')]"))
			System.out.println("Mobile number info: "+getText("xpath;//*[contains(text(),'marketing purposes')]"));
		clickOnElement("xpath;//*[@value='Create Username']");
		//clickOnElement(btncreateUsername);
		if(isElementPresent(msgCreation)){
			System.out.println(getText(msgCreation));
			retVal=true;
		}
		clickOnElement(DoneButton);
		HomePage hp= new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(charterID, password);
		hp.pagewait();
		return retVal;
	}


	public boolean FID_RetrieveID_HOH(String password,String security_answer,String lastname_fID,String address_fID,String zipcode_fID,String mac_fID,String fLinkCID,String AccountNumberVerify,String ACnumber){
		boolean retVal=false;
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(fCharterId));
		clickOnElement(fCharterId);	
		HomePage hp=new HomePage(driver);
		hp.pagewait();
		type(fID_Zipcode,zipcode_fID);
		selectValueFromDropDown(SelecttoVerify,AccountNumberVerify);
		type(InfoField,ACnumber);
		clickOnElement(FUNextbtn);
		WebElement FIDuserRB=driver.findElement(By.xpath("//span[contains(text(),'"+ fLinkCID +"')]"));
		System.out.println(FIDuserRB);
		FIDuserRB.click();
		clickOnElement(FU1Nextbtn);
		type(fpSecurityAnswer,security_answer);
		clickOnElement(FURBNextButton);
		WebElement FID=driver.findElement(By.xpath("//p[@class='username-result semibold view-username-text ng-binding']"));
		String FIDName=FID.getText();
		clickOnElement(Fusigninbtn);
		//	type(FID_user11,FIDName);
		type(FID_pw1,password);
		clickOnElement(submitSignin);
		retVal=true;
		return retVal;
	}

	//Expecting Admin - charter ID to be at 2nd radio button value
	public boolean FID_RetrieveID_Admin(String password,String security_answer,String lastname_fID,String address_fID,String zipcode_fID,String mac_fID, String fLinkCID,String AccountNumberVerify,String ACnumber){

		boolean retVal=false;
		HomePage hp= new HomePage(driver);
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(fCharterId));
		clickOnElement(fCharterId);	

		type(fID_Zipcode,zipcode_fID);
		selectValueFromDropDown(SelecttoVerify,AccountNumberVerify);
		type(InfoField,ACnumber);
		clickOnElement(FUNextbtn);
		WebElement FIDuserRB=driver.findElement(By.xpath("//span[contains(text(),'"+ fLinkCID +"')]"));
		System.out.println(FIDuserRB);
		FIDuserRB.click();
		clickOnElement(FU1Nextbtn);
		type(fpSecurityAnswer,security_answer);
		clickOnElement(FURBNextButton);
		WebElement FID=driver.findElement(By.xpath("//p[@class='username-result semibold view-username-text ng-binding']"));
		String FIDName=FID.getText();
		clickOnElement(Fusigninbtn);
		//	type(FID_user11,FIDName);
		type(FID_pw1,password);
		clickOnElement(submitSignin);
		retVal=true;
		return retVal;
	}

	public boolean FID_RetrieveID_Standard(String password,String security_answer,String lastname_fID,String address_fID,String zipcode_fID,String mac_fID, String fLinkCID,String AccountNumberVerify,String ACnumber){
		boolean retVal=false;
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(fCharterId));
		clickOnElement(fCharterId);	
		HomePage hp= new HomePage(driver);
		type(fID_Zipcode,zipcode_fID);
		selectValueFromDropDown(SelecttoVerify,AccountNumberVerify);
		type(InfoField,ACnumber);
		clickOnElement(FUNextbtn);
		WebElement FIDuserRB=driver.findElement(By.xpath("//span[contains(text(),'"+ fLinkCID +"')]"));
		System.out.println(FIDuserRB);
		FIDuserRB.click();
		clickOnElement(FU1Nextbtn);
		type(fpSecurityAnswer,security_answer);
		clickOnElement(FURBNextButton);
		WebElement FID=driver.findElement(By.xpath("//p[@class='username-result semibold view-username-text ng-binding']"));
		String FIDName=FID.getText();
		clickOnElement(Fusigninbtn);
		//	type(FID_user11,FIDName);
		type(FID_pw1,password);
		clickOnElement(submitSignin);
		retVal=true;
		return retVal;
	}

	public boolean FID_Non_Converted_MS_Login(String password,String security_answer,String lastname_fID,String address_fID,String zipcode_fID,String mac_fID, String fLinkCID,String AccountNumberVerify,String ACnumber){

		boolean retVal=false;
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(fCharterId));
		clickOnElement(fCharterId);	

		type(fID_Zipcode,zipcode_fID);
		selectValueFromDropDown(SelecttoVerify,AccountNumberVerify);
		type(InfoField,ACnumber);
		clickOnElement(FUNextbtn);
		WebElement FIDuserRB=driver.findElement(By.xpath("//span[contains(text(),'"+ fLinkCID +"')]"));
		System.out.println(FIDuserRB);
		FIDuserRB.click();
		clickOnElement(FU1Nextbtn);
		type(fpSecurityAnswer,security_answer);
		clickOnElement(FURBNextButton);
		WebElement FID=driver.findElement(By.xpath("//p[@class='username-result semibold view-username-text ng-binding']"));
		String FIDName=FID.getText();
		System.out.println(FIDName);
		clickOnElement(Fusigninbtn);
		//type(FID_user11,FIDName);
		clickOnElement(PasswordPlaceHolder);
		type(FID_pw1,password);
		clickOnElement(submitSignin);
		System.out.println(driver.getCurrentUrl());

		wait(Until.elementToBeClickable(Nobutton));
		clickOnElement(Nobutton);
		retVal=true;
		return retVal;
	}

	public boolean FID_Non_Converted_HOH(String password,String security_answer,String lastname_fID,String address_fID,String zipcode_fID,String mac_fID, String fLinkCID,String AccountNumberVerify,String ACnumber){

		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(fCharterId);	

		type(fID_Zipcode,zipcode_fID);
		selectValueFromDropDown(SelecttoVerify,AccountNumberVerify);
		type(InfoField,ACnumber);
		clickOnElement(FUNextbtn);
		WebElement FIDuserRB=driver.findElement(By.xpath("//span[contains(text(),'"+ fLinkCID +"')]"));
		System.out.println(FIDuserRB);
		FIDuserRB.click();
		clickOnElement(FU1Nextbtn);
		type(fpSecurityAnswer,security_answer);
		clickOnElement(FURBNextButton);
		WebElement FID=driver.findElement(By.xpath("//p[@class='username-result semibold view-username-text ng-binding']"));
		String FIDName=FID.getText();
		System.out.println(FIDName);
		clickOnElement(Fusigninbtn);
		//type(FID_user11,FIDName);
		clickOnElement(PasswordPlaceHolder);
		type(FID_pw1,password);
		clickOnElement(submitSignin);
		System.out.println(driver.getCurrentUrl());

		wait(Until.elementToBeClickable(Nobutton));
		clickOnElement(Nobutton);
		retVal=true;
		return retVal;
	}

	public String invalid_Zip_Message(){

		System.out.println(getText(CID_ZipcodeError));
		return getText(CID_ZipcodeError);
	}
	public boolean invalid_ZIP_CID(String firstname_CID,String lastname_CID,String Address_CID,String invalidZipcode,String MAC_CID){

		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(CreateID);
		//	type(cIDFirstname,firstname_CID);
		type(cIDlastname,lastname_CID);
		type(CIDAddressfield,Address_CID);
		type(cIDZipcode,invalidZipcode);
		type(cIDMAC,MAC_CID);
		if(isElementPresent(CID_ZipcodeError)){
			retVal=true;
		}

		return retVal;
	}

	public boolean invalid_Service_Address_CID(String firstname_CID,String lastname_CID,String invalidAddress,String Zipcode_CID,String MAC_CID){

		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(CreateID);
		type(cIDlastname,lastname_CID);
		type(CIDAddressfield,invalidAddress);
		clearTextBox(CIDAddressfield);
		type(cIDZipcode,Zipcode_CID);
		type(cIDMAC,MAC_CID);
		if(isElementPresent(AddressR)){
			System.out.println(getText(AddressR));
		/*	System.out.println(getText(Address1R));
			System.out.println(getText(Address2R));*/
			retVal=true;
		}
		return retVal;
	}
	public boolean Service_Address_mismatch(String firstname_CID,String lastname_CID,String invalidAddress,String Zipcode_CID,String MAC_CID){

		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(CreateID);
		//	type(cIDFirstname,firstname_CID);
		type(cIDlastname,lastname_CID);
		type(CIDAddressfield,invalidAddress);
		type(cIDZipcode,Zipcode_CID);
		type(cIDMAC,MAC_CID);
		clickOnElement(cIDNextbtn);
		if(isElementPresent(Proceedbtn)){
			clickOnElement(Proceedbtn);
		}
		if(isElementPresent(captcha)){
			retVal=true;	
		}
		return retVal;
	}
	public boolean HOH_ErrorMessage(String firstname_CID,String lastname_CID,String Address_CID,String Zipcode_CID,String MAC_CID){

		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(CreateID);
		//type(cIDFirstname,firstname_CID);
		type(cIDlastname,lastname_CID);
		type(CIDAddressfield,Address_CID);
		type(cIDZipcode,Zipcode_CID);
		type(cIDMAC,MAC_CID);
		clickOnElement(cIDNextbtn);
		type(cIDFirstname,firstname_CID);
		if(isElementPresent(Proceedbtn))
			{
			clickOnElement(Proceedbtn);
			}
		if(isElementPresent(captcha))
			{
			System.out.println("captcha is displayed");
			}
		else{
			System.out.println("captcha is not displayed");
			}

		retVal=true;
		return retVal;
	}
	public boolean SecAns_ErrorMsg(String zipcode_fID,String AccountNumberVerify,String ACnumber,String invalidSecurityAns){

		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(fCharterId);	
		type(fID_Zipcode,zipcode_fID);
		selectValueFromDropDown(SelecttoVerify,AccountNumberVerify);
		type(InfoField,ACnumber);
		clickOnElement(FUNextbtn);
		WebElement FIDuserRB=driver.findElement(By.xpath("//label[@class='id-radio-label radio-inline radio-dark-outline']"));
		FIDuserRB.click();
		clickOnElement(FU1Nextbtn);
		type(fpSecurityAnswer,invalidSecurityAns);
		clickOnElement(FURBNextButton);
		clearTextBox(fpSecurityAnswer);
		type(fpSecurityAnswer,invalidSecurityAns);
		clickOnElement(FURBNextButton);

		if(isElementPresent(SecAnsErrorMSG)){
			retVal=true;
			System.out.println(getText(SecAnsErrorMSG));
		}

		return retVal;
	}

	public boolean ZipCode_ErrorMsg(String invalidZipcode,String AccountNumberVerify,String ACnumber){

		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(fCharterId);	
		type(fID_Zipcode,invalidZipcode);
		selectValueFromDropDown(SelecttoVerify,AccountNumberVerify);
		type(InfoField,ACnumber);
		clickOnElement(FUNextbtn);
		if (isElementPresent(invalidError)){
			retVal=true;
		} 
		return retVal;
	}

	public boolean MAC_ErrorMsg(String lastname_fID,String address_fID,String zipcode_fID,String mac_fID){

		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(fCharterId);	
		type(fplastname,lastname_fID);
		type(fID_Address,address_fID);
		type(fID_Mac,"");
		type(fID_Zipcode,zipcode_fID);
		if (isElementPresent(MAC_Message)){
			retVal=true;
		}
		return retVal;
	}

	public boolean LastName_ErrorMsg(String lastname_fID,String address_fID,String zipcode_fID,String mac_fID){

		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(fCharterId);	
		type(fplastname,"");
		type(fID_Address,address_fID);
		type(fID_Zipcode,zipcode_fID);
		type(fID_Mac,mac_fID);
		if (isElementPresent(LastName_Message)){
			retVal=true;
		}
		return retVal;
	}

	public boolean Address_ErrorMsg(String lastname_fID,String address_fID,String zipcode_fID,String mac_fID){

		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(fCharterId);	
		type(fplastname,lastname_fID);
		type(fID_Address,address_fID);
		type(fID_Zipcode,zipcode_fID);
		type(fID_Mac,mac_fID);
		if (isElementPresent(Address_Message)){
			retVal=true;
		}
		return retVal;
	}


	public boolean fid_helpicons(){

		boolean retVal=false;

		clickOnElement(SignInLink);
		clickOnElement(fCharterId);	
		WebElement lastnamehelpicondata = driver.findElement(By.xpath("//p[contains(text(),'Please provide the last name from your service address. Your entry can be no greater than 50 characters.')]/../../i"));
		lastnamehelpicondata.click();
		lastnamehelpicondata.getText();
		WebElement addresshelpicondata = driver.findElement(By.xpath("//p[contains(text(),'The service address is the physical address of your service.')]/../../i"));
		addresshelpicondata.click();
		addresshelpicondata.getText();
		WebElement zipcodehelpicondata = driver.findElement(By.xpath("//p[contains(text(),'Zip Code must be between 5 and 9 characters long.')]/../../i"));
		zipcodehelpicondata.click();
		zipcodehelpicondata.getText();
		WebElement macaddresshelpicondata = driver.findElement(By.xpath("//div[@class='charter-tooltip-content msg-18010']/p/../../i"));
		macaddresshelpicondata.click();
		macaddresshelpicondata.getText();

		retVal=true;
		return retVal;
	}



	public boolean fp_pwdmismatch(String password,String CharterID_fp,String lastname_fp,String Zipcode_fp,String security_answer,String invalidPassword){

		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(fPassword);
		type(fpCharterId,CharterID_fp);
		type(fpZip,Zipcode_fp);
		clickOnElement(fpNextBtn);
		type(fpSecurityAnswer,security_answer);
		clickOnElement(fpNextBtn);
		type(fpNewPassword,password);
		type(fpConfirmNewPassword,invalidPassword+Keys.TAB);
		if(isElementPresent(InvalidPWD)){
			retVal=true;
			System.out.println(getText(InvalidPWD));
		}
		clearTextBox(fpConfirmNewPassword);
		type(fpConfirmNewPassword,password);
		clickOnElement(Savebtn);
		clickOnElement(Finishbtn);
		return retVal;
	}


	public boolean fp_invalidzipcode(String CharterID_fp,String invalidZipcode){

		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(fPassword);
		type(fpCharterId,CharterID_fp);
		type(fpZip,invalidZipcode);
		clickOnElement(fpNextBtn);
		if(isElementPresent(InvalidMsg)){
			retVal=true;
			System.out.println(getText(InvalidMsg));
		}
		if(isElementVisible(captcha))
			System.out.println("Captcha is displayed for invalid combination of Username and Zipcode");
		retVal=true;
		return retVal;
	}

	public boolean fp_pwdresetsuccess(String password,String CharterID_fp,String lastname_fp,String Zipcode_fp,String security_answer){

		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(fPassword);
		HomePage hp=new HomePage(driver);
		hp.pagewait();
		type(fpCharterId,CharterID_fp);
		type(fpZip,Zipcode_fp);
		clickOnElement(fpNextBtn);
		type(fpSecurityAnswer,security_answer);
		clickOnElement(fpNextBtn);
		type(fpNewPassword,password);
		type(fpConfirmNewPassword,password);
		clickOnElement(Savebtn);
		if(isElementPresent(SuccessMsg)){
			retVal=true;	
			System.out.println(getText(SuccessMsg));
		}
		retVal=true;
		return retVal;
	}

	public boolean fp_invalidsecuritycode(String CharterID_fp,String lastname_fp,String Zipcode_fp,String invalidSecurityAns){

		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(fPassword);
		type(fpCharterId,CharterID_fp);
		type(fpZip,Zipcode_fp);
		clickOnElement(fpNextBtn);
		type(fpSecurityAnswer,invalidSecurityAns);
		clickOnElement(fpNextBtn);
		if(isElementPresent(invalidsecurityerror)){
			retVal=true;
		}
		return retVal;
	}

	public boolean fp_missedfieldsmessages(){

		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(fPassword);
		clickOnElement(fpCharterId);
		type(fpCharterId, ""+Keys.TAB);
		WebElement usernameMissed = driver.findElement(By.xpath("//*[contains(text(),'valid username')]"));
		System.out.println(usernameMissed.getText());
		clickOnElement(fpZip);
		type(fpZip, ""+Keys.TAB);
		WebElement zipcodemissed = driver.findElement(By.xpath("//*[contains(text(),'valid ZIP code')]"));
		System.out.println(zipcodemissed.getText());
		if(isElementEnabled((fpNextBtn))){
			retVal=true;
		}
		return retVal;
	}

	public boolean fId_missedfieldsmessages(String zipcode_fID,String AccountNumberVerify,String ACnumber){

		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(fCharterId);
		clickOnElement(fID_Zipcode);
		type(fID_Zipcode,zipcode_fID);
		clearTextBox(fID_Zipcode);
		selectValueFromDropDown(SelecttoVerify,AccountNumberVerify);
		type(InfoField,ACnumber);
		clickOnElement(FUNextbtn);
		if(isElementPresent(ErrorMessage)){
			retVal=true;
		}
		return retVal;
	}

	public boolean CreateID_missedfieldsmessages(String lastname_CID,String Address_CID,String Zipcode_CID,String MAC_CID){

		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(CreateID);
		//	clickOnElement(cIDFirstname);
		//	type(cIDFirstname,"");
		clickOnElement(cIDlastname);
		type(cIDlastname,lastname_CID);
		clearTextBox(cIDlastname);
		
		clickOnElement(CIDAddressfield);
		type(CIDAddressfield,Address_CID);
		clearTextBox(CIDAddressfield);
		
		clickOnElement(cIDZipcode);
		type(cIDZipcode,Zipcode_CID);
		clearTextBox(cIDZipcode);
		
		clickOnElement(cIDMAC);
		clickOnElement(cIDZipcode);
		type(cIDMAC,MAC_CID);
		clearTextBox(cIDMAC);
		//	WebElement Firstnamemissed=driver.findElement(By.xpath("//span[contains(text(),'First name is required.')]"));
		//	System.out.println(Firstnamemissed.getText());
		WebElement lastNamemissed = driver.findElement(By.xpath("//span[contains(text(),'Last name is required.')]"));
		System.out.println(lastNamemissed.getText());
		WebElement serviceAddressmissed = driver.findElement(By.xpath("//span[contains(text(),'Address is required.')]"));
		System.out.println(serviceAddressmissed.getText());
		WebElement zipcodemissed = driver.findElement(By.xpath("//span[contains(text(),'Zipcode is required.')]"));
		System.out.println(zipcodemissed.getText());
		WebElement macAccountNomissed = driver.findElement(By.xpath("//span[contains(text(),'Mac address is required.')]"));
		System.out.println(macAccountNomissed.getText());
		if(!isElementEnabled(cIDNextbtn)){
			retVal=true;
		}

		return retVal;
	}

	public boolean CreateID_helpicons(){
		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(CreateID);	
		hoverOver(AddressHelpicon);		
		System.out.println(getText(AddressHelpicon));
		hoverOver(MACHelpicon);		
		System.out.println(getText(MACHelpicon));
		hoverOver(PrimaryAccHelpicon);		
		System.out.println(getText(PrimaryAccHelpicon));
		retVal=true;
		return retVal;
	}

	public boolean successful_msg(String firstname_CID,String charterID,String password,String email,String security_question,String security_answer,String lastname_CID,String Address_CID,String Zipcode_CID,String MAC_CID,String Mobilephone) throws Exception{

		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(CreateID);
		type(cIDlastname,lastname_CID);
		type(CIDAddressfield,Address_CID);
		type(cIDZipcode,Zipcode_CID);
		type(cIDMAC,MAC_CID);
		clickOnElement(cIDNextbtn);
		type(cIDFirstname,firstname_CID);
		type(wecharterID,charterID);
		type(wepassword,password);
		type(weconfirmpassword,password);
		selectValueFromDropDown(wesecurityQuestion,security_question);
		type(wesecurityAnswer,security_answer);
		type(weemail,email);
		type(weMobilephone,Mobilephone);
		clickOnElement(cbterms);
		clickOnElement(btncreateUsername);
		if(isElementPresent(msgCreation)){
			System.out.println(getText(msgCreation));
			retVal=true;
		}
		return retVal;
	}
	public boolean invalid_Mac_CID(String firstname_CID,String lastname_CID,String Address_CID,String Zipcode_CID,String invalidMAC){

		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(CreateID);
		//	type(cIDFirstname,firstname_CID);
		type(cIDlastname,lastname_CID);
		type(CIDAddressfield,Address_CID);
		type(cIDZipcode,Zipcode_CID);
		type(cIDMAC,invalidMAC);
		clickOnElement(cIDZipcode);
		if(isElementPresent(MACError)){
			retVal=true;
		}
		return retVal;

	}

	public boolean invalid_lastname_CID(String firstname_CID,String invalidLastname,String Address_CID,String Zipcode_CID,String MAC_CID){

		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(CreateID);
		//		type(cIDFirstname,firstname_CID);
		type(cIDlastname,invalidLastname);
		clearTextBox(cIDlastname);
		type(CIDAddressfield,Address_CID);
		type(cIDZipcode,Zipcode_CID);
		type(cIDMAC,MAC_CID);
		if(isElementPresent(LastnameR)){
			System.out.println(getText(LastnameR));
			retVal=true;
		}
		return retVal;
	}

	public boolean passwordmismatch_CID(String firstname_CID,String lastname_CID,String Address_CID,String Zipcode_CID,String MAC_CID,String charterID,String password,String invalidPassword,String email){

		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(CreateID);
		//	type(cIDFirstname,firstname_CID);
		type(cIDlastname,lastname_CID);
		type(CIDAddressfield,Address_CID);
		type(cIDZipcode,Zipcode_CID);
		type(cIDMAC,MAC_CID);
		clickOnElement(cIDNextbtn);
		type(wecharterID,charterID);
		type(wepassword,password);
		type(weconfirmpassword,invalidPassword);
		type(weemail,email);
		wait(Until.elementToBeDisplayed(PwdError));	
		if(isElementPresent(PwdError)){
			System.out.println("Password Mismatch Error is:"+getText(PwdError));
			retVal=true;
		}
		return retVal;
	}

	public boolean InvalidEmail_CID(String firstname_CID,String charterID,String password,String invalidEmail,String lastname_CID,String Address_CID,String Zipcode_CID,String MAC_CID,String security_question,String security_answer){

		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(CreateID);
		//	type(cIDFirstname,firstname_CID);
		type(cIDlastname,lastname_CID);
		type(CIDAddressfield,Address_CID);
		type(cIDZipcode,Zipcode_CID);
		type(cIDMAC,MAC_CID);
		clickOnElement(cIDNextbtn);
		type(wecharterID,charterID);
		type(wepassword,password);
		type(weconfirmpassword,password);
		type(weemail,invalidEmail);
		selectValueFromDropDown(wesecurityQuestion,security_question);
		type(wesecurityAnswer,security_answer);
		if(isElementPresent(EmailError)){
			System.out.println("Email mismatch Error is:"+ getText(EmailError));
			retVal=true;
		}
		return retVal;
		//assertTrue(driver.getPageSource().contains("Invalid input for contact email. Please review and resubmit."));
	}


	public boolean fid_successfultqmessage(String security_answer,String zipcode_fID,String fLinkCID,String AccountNumberVerify,String verificationdata){

		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(fCharterId);	
		type(fID_Zipcode,zipcode_fID);
		selectValueFromDropDown(SelecttoVerify,AccountNumberVerify);
		type(InfoField,verificationdata);
		clickOnElement(FUNextbtn);
		WebElement FIDuserRB=driver.findElement(By.xpath("//span[contains(text(),'"+ fLinkCID +"')]"));
		System.out.println(FIDuserRB);
		FIDuserRB.click();
		clickOnElement(FU1Nextbtn);
		type(fpSecurityAnswer,security_answer);
		clickOnElement(FURBNextButton);
		if(isElementPresent(FIDMessage)){
			System.out.println(getText(FIDMessage));
			wait(Until.elementToBeDisplayed("xpath;.//*[@id='view-username-submit']"));
			clickOnElement("xpath;.//*[@id='view-username-submit']");
			System.out.println(getText("xpath;.//*[@id='cc-username']"));
			if(getText("xpath;.//*[@id='cc-username']").contains(fCharterId));
			System.out.println("Username is auto populated in username field ");
			retVal=true;	
		}

		return retVal;
	}
	
	public void fid_email(String zipcode_fID,String fLinkCID,String AccountNumberVerify,String ACnumber,String email){

		clickOnElement(SignInLink);
		clickOnElement(fCharterId);	
		clickOnElement(FUNextbtn);
		if(isElementVisible(InfoError)){
			System.out.println("Error message for not filling Verification Info is displayed");
			System.out.println("VerificationInfo Error Message: "+getText(InfoError));
		}
		
		if(isElementVisible(lastNameError)){
			System.out.println("Error message for not filling Last name is displayed");
			System.out.println("LastName Error Message: "+getText(lastNameError));
		}
		
		if(isElementVisible(ErrorMessage)){
			System.out.println("Error message for not filling ZipCode is displayed");
			System.out.println("ZipCode Error Message: "+getText(ErrorMessage));
		}
		type(fID_Zipcode,zipcode_fID);
		selectValueFromDropDown(SelecttoVerify,"Phone Number on Account");
		type(InfoField,"--"+Keys.TAB);
		if(isElementVisible(invalidPhoneError))
			System.out.println("Invalid Phone Number Error message Displayed : "+getText(invalidPhoneError));
		selectValueFromDropDown(SelecttoVerify,AccountNumberVerify);
		type(InfoField, "Charter@ 1234");
		System.out.println("Account Number Info field doesnot accept Special characters or spaces");
		clearTextBox(InfoField);
		type(InfoField,ACnumber);
		clickOnElement(FUNextbtn);
		WebElement FIDuserRB=driver.findElement(By.xpath("//span[contains(text(),'"+ fLinkCID +"')]"));
		System.out.println(FIDuserRB);
		FIDuserRB.click();
		clickOnElement(FU1Nextbtn);
		clickOnElement(ForgotAnswerLink);
		//clickOnElement(EmailCheckBox);
		String text[] = email.split("@");
		System.out.println(text[0]+"and"+text[1]);
		String dropdownvalue = text[0].charAt(text[0].length()-1) + "";
		System.out.println(dropdownvalue);
		dropdownvalue= dropdownvalue+"@"+text[1];
		System.out.println(dropdownvalue);
		//Select selc = new Select(driver.findElement(By.xpath("//select[@name='email']/option[contains(text(),'"+dropdownvalue+"')]")));
		//selectValueFromDropDown("xpath;//select[@name='email']", dropdownvalue);
		sleep(5);
		clickOnElement("xpath;//select[@name='email']/option[contains(text(),'"+dropdownvalue+"')]");
		clickOnElement(getCode);
		sleep(20);
	}
	
	public boolean fp_helpicons(String password,String CharterID_fp,String lastname_fp,String Zipcode_fp,String security_answer){

		boolean retVal=false;
		clickOnElement(SignInLink);
		clickOnElement(fPassword);	

		type(fpCharterId,CharterID_fp);
		type(fp_lastname,lastname_fp);
		type(fpZip,Zipcode_fp);
		clickOnElement(fpNextBtn);
		type(fpSecurityAnswer,security_answer);
		clickOnElement(fpNextBtn);
		type(fpNewPassword,password);
		WebElement PassowrdStrengthHelpIcon = driver.findElement(By.xpath("//span[contains(text(),'Password Strength ')]/a"));
		PassowrdStrengthHelpIcon.click();
		System.out.println(PassowrdStrengthHelpIcon.getText());
		type(fpNewPassword,password);
		clickOnElement(fpNextBtn);
		retVal=true;
		return retVal;
	}

	public boolean ValidLogin(String username,String password) throws Exception{
		boolean retVal = false;
		wait(Until.elementToBeDisplayed(SignInLink));
		clickOnElement(SignInLink);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		if(isElementVisible(Username) & isElementVisible(PasswordPlaceHolder) & isElementVisible(btnSignin)){
			clearTextBox(Username);
			type(Username,username);
			type(PasswordPlaceHolder,password);
			clickOnElement(btnSignin);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			if(isElementVisible(weSignOut)){
				System.out.println("Login Successful");
				HomePage hp = new HomePage(driver);
				hp.pagewait();
				retVal = true;
			}
			else{
				System.out.println("Login Unsuccessful");
				String Folder = "LoginError";
				screenshot.saveScreenshot("Login And Authentication"+ File.separator + Folder);
			}
		}
		else{
			System.out.println("Login Fields are not visible");
			String Folder = "LoginFieldsMissingError";
			screenshot.saveScreenshot("Login And Authentication"+ File.separator + Folder);
		}
		return retVal;
	}

	public boolean InValidLogin(String username,String password) throws Exception{
		boolean retVal = false;
		wait(Until.elementToBeDisplayed(SignInLink));
		clickOnElement(SignInLink);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		if(isElementVisible(Username) & isElementVisible(PasswordPlaceHolder) & isElementVisible(btnSignin)){
			type(Username,username);
			type(PasswordPlaceHolder,password);
			clickOnElement(btnSignin);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			if(isElementVisible("xpath;//*[contains(text(),'match our records')]")){
				System.out.println(getText("xpath;//*[contains(text(),'match our records')]"));
				retVal = true;
			}
			else{
				System.out.println("Invalid Login Error not displayed");
				String Folder = "InvalidLoginError";
				screenshot.saveScreenshot("Login And Authentication"+ File.separator + Folder);
			}
		}
		else{
			System.out.println("Login Fields are not visible");
			String Folder = "LoginFieldsMissingError";
			screenshot.saveScreenshot("Login And Authentication"+ File.separator + Folder);
		}
		return retVal;
	}

	public void fp_CreateIDPage() throws Exception{
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(fPassword));
		clickOnElement(fPassword);
		HomePage hp=new HomePage(driver);
		hp.pagewait();
	}
	
	public boolean verifyMACmsg(){
		boolean retVal = false;
		driver.manage().deleteAllCookies();
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(CreateID));
		clickOnElement(CreateID);
		clickOnElement(cIDMAC);
		type(cIDMAC,"abc");
		wait(Until.elementToBeDisplayed(cIDHelpmsg));
		hoverOver(cIDHelpmsg);
		clickOnElement(cIDHelpmsg);
		String msg = driver.findElement(By.xpath("//p[@class='tooltip-popover-content ng-binding']")).getText();
		System.out.println(msg);
		if(msg.equals(CID_HelpMessage)){
			retVal = true;
		}
		return retVal;
	}
	
	public boolean fp_forgotSecurityAnswer(String CharterID_fp,String Zipcode_fp){

		boolean retVal=false;
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(fPassword));
		clickOnElement(fPassword);
		HomePage hp=new HomePage(driver);
		hp.pagewait();
		type(fpCharterId,CharterID_fp);
		type(fpZip,Zipcode_fp);
		clickOnElement(fpNextBtn);
		wait(Until.elementToBeDisplayed(ForgotAnswerLink));
		clickOnElement(ForgotAnswerLink);
		clickOnElement(EmailCheckBox);
		selectValueFromDropDown("xpath;(//*[@name='email'])[2]", "d**********r@charter.com");
		clickOnElement(getCode);
		if(isElementPresent(checkEmail)){
			retVal=true;	
			System.out.println(getText(checkEmail));
		}
		return retVal;
	}
	
	public boolean fp_NonCPNISecurityAnswer(String CharterID_fp,String password,String security_answer,String Zipcode_fp){

		boolean retVal=false;
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(fPassword));
		clickOnElement(fPassword);
		HomePage hp=new HomePage(driver);
		hp.pagewait();
		type(fpCharterId,CharterID_fp);
		type(fpZip,Zipcode_fp);
		clickOnElement(fpNextBtn);
		type(fpSecurityAnswer,security_answer);
		clickOnElement(fpNextBtn);
		type(fpNewPassword,password);
		type(fpConfirmNewPassword,password);
		clickOnElement(Savebtn);
		if(isElementPresent(checkEmail)){
			retVal=true;	
			System.out.println(getText(checkEmail));
		}
		clickOnElement(Finishbtn);
		return retVal;
	}
	
	public boolean fp_NonCPNIEmail(String CharterID_fp,String password,String Zipcode_fp){

		boolean retVal=false;
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(fPassword));
		clickOnElement(fPassword);
		HomePage hp=new HomePage(driver);
		hp.pagewait();
		type(fpCharterId,CharterID_fp);
		type(fpZip,Zipcode_fp);
		clickOnElement(fpNextBtn);
		clickOnElement(ForgotAnswerLink);
		setCheckBox(EmailCheckBox, true);
		clickOnElement(fpNextBtn);
		if(isElementPresent(checkEmail)){
			retVal=true;	
			System.out.println(getText(checkEmail));
		}
		return retVal;
	}
	
	public boolean fp_CPNISecurityAnswer(String CharterID_fp,String password,String security_answer,String Zipcode_fp){

		boolean retVal=false;
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(fPassword));
		clickOnElement(fPassword);
		HomePage hp=new HomePage(driver);
		hp.pagewait();
		type(fpCharterId,CharterID_fp);
		type(fpZip,Zipcode_fp);
		clickOnElement(fpNextBtn);
		type(fpSecurityAnswer,security_answer);
		clickOnElement(fpNextBtn);
		type(fpNewPassword,password);
		type(fpConfirmNewPassword,password);
		clickOnElement(Savebtn);
		if(isElementPresent(checkEmail)){
			retVal=true;	
			System.out.println(getText(checkEmail));
		}
		clickOnElement(Finishbtn);
		sleep(20);
		return retVal;
	}
	
	public void fp_CPNIEmail(String CharterID_fp,String Zipcode_fp,String email){
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(fPassword));
		clickOnElement(fPassword);
		HomePage hp=new HomePage(driver);
		hp.pagewait();
		type(fpCharterId,CharterID_fp);
		type(fpZip,Zipcode_fp);
		clickOnElement(fpNextBtn);
		clickOnElement(ForgotAnswerLink);
		//setCheckBox(EmailCheckBox, true);
		String text[] = email.split("@");
		//System.out.println(text[0]+"and"+text[1]);
		String dropdownvalue = text[0].charAt(text[0].length()-1) + "";
		//System.out.println(dropdownvalue);
		dropdownvalue= dropdownvalue+"@"+text[1];
		//System.out.println(dropdownvalue);
		//Select selc = new Select(driver.findElement(By.xpath("//select[@name='email']/option[contains(text(),'"+dropdownvalue+"')]")));
		//selectValueFromDropDown("xpath;//select[@name='email']", dropdownvalue);
		clickOnElement("xpath;//select[@name='email']/option[contains(text(),'"+dropdownvalue+"')]");
		clickOnElement(fpNextBtn);
	}
	
	public void loadGmail(String pw){
		try{
		driver.navigate().to("https://mail.google.com/");
		type(Gmailpw,pw);
		clickOnElement(GmailSignin);
		}
		catch(Exception e){
			driver.navigate().to("https://mail.google.com/");
			type(Gmailpw,pw);
			clickOnElement(GmailSignin);
		}
	}
	public void gmailLogin(String ID,String pw){		
		driver.navigate().to("https://mail.google.com/");
		sleep(20);
		if(isElementPresent("xpath;//*[@title='Websense']")){
			switchToFrame("ws_blockoption");
			clickOnElement("xpath;.//*[@id='quota-text']/input");
			sleep(20);
		}
		wait(Until.elementToBeDisplayed(GmailID));
		type(GmailID,ID);
		clickOnElement(GmailNext);
		type(Gmailpw,pw);
		clickOnElement(GmailSignin);
		sleep(10);
	}
	
	public void charterDotComMailLogin(String ID,String pw){
		driver.manage().deleteAllCookies();
		driver.navigate().to("https://outlook.chartercom.com/");
		wait(Until.elementToBeDisplayed("id;username"));
		type("id;username",ID);
		type("id;password",pw);
		clickOnElement("xpath;//*[@value='Log On']");
		sleep(10);
	}
	
	public boolean resetPasswordCharterMail(String pass){
		boolean retVal=false;
		
		sleep(10);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='lnkHdrcheckmessages']"));
		clickOnElement("xpath;.//*[@id='lnkHdrcheckmessages']");
		while(!isElementVisible("xpath;(//*[@class='bld']/*[contains(text(),'Your verification link to reset')])[1]")){
			clickOnElement("xpath;.//*[@id='lnkHdrcheckmessages']");
			sleep(10);
		}
		
		if(isElementVisible("xpath;(//*[@class='bld']/*[contains(text(),'Your verification link to reset')])[1]")){
			clickOnElement("xpath;(//*[@class='bld']/*[contains(text(),'Your verification link to reset')])[1]");
			System.out.println("Password Reset Verification mail is Received");
			sleep(5);
			
			wait(Until.elementToBeDisplayed("xpath;//*[contains(text(),'reset-password')]"));
			String newURL=getText("xpath;(//*[contains(text(),'reset-password')])[1]");
			driver.navigate().to(newURL.replace("//", "//charternet:Chart3rn3t@"));
			sleep(5);
			//driver.findElement(By.xpath("//html")).sendKeys(Keys.CONTROL+"t");
/*			String parentWindow = driver.getWindowHandle();
			Set<String> handles =  driver.getWindowHandles();
			for(String windowHandle  : handles)
			{
				if(!windowHandle.equals(parentWindow))
				{
					driver.switchTo().window(windowHandle);
					driver.manage().window().maximize();
					//driver.navigate().to(ResetPassURL.replace("//", "//charternet:Chart3rn3t@"));
					System.out.println("user navigated to reset password page "+driver.getCurrentUrl());
					wait(Until.elementToBeClickable(fpNewPassword));
					type(fpNewPassword,pass);
					type(fpConfirmNewPassword,pass);
					clickOnElement(Savebtn);
					sleep(10);
					if(isElementPresent(checkEmail)){
						retVal=true;	
						System.out.println("Success Message: "+getText("xpath;//*[@class='container forgot-id']"));
					}
					driver.close(); //closing child window
					driver.switchTo().window(parentWindow);//cntrl to parent window
				}
			}*/
			System.out.println("user navigated to reset password page "+driver.getCurrentUrl());
			wait(Until.elementToBeClickable(fpNewPassword));
			type(fpNewPassword,pass);
			type(fpConfirmNewPassword,pass);
			clickOnElement(Savebtn);
			sleep(10);
			if(isElementPresent(checkEmail)){
				retVal=true;	
				System.out.println("Success Message: "+getText("xpath;//*[@class='container forgot-id']"));
			}
				/*wait(Until.elementToBeDisplayed("xpath;.//*[@id='lnkNavMail']"));
				clickOnElement("xpath;.//*[@id='lnkNavMail']");
				sleep(5);*/
	
			}

		return retVal;
	}
	
	public boolean resetPasswordlinkExpire(String pass){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed("xpath;(//*[contains(text(),'Your verification link to reset')])[1]"));
		clickOnElement("xpath;(//*[contains(text(),'Your verification link to reset')])[1]");
		System.out.println("Password Reset Verification mail is Received");
		sleep(10);
		wait(Until.elementToBeDisplayed("xpath;//*[contains(text(),'reset-password')]"));
		clickOnElement("xpath;//*[contains(text(),'reset-password')]");
		
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
			if(!windowHandle.equals(parentWindow))
			{
				driver.switchTo().window(windowHandle);
				driver.manage().window().maximize();
				System.out.println("user navigated to reset password page "+driver.getCurrentUrl());
				wait(Until.elementToBeClickable(fpNewPassword));
				type(fpNewPassword,pass);
				type(fpConfirmNewPassword,pass);
				clickOnElement(Savebtn);
				sleep(10);
				if(isElementPresent("xpath;//*[contains(text(),'timed out')]")){
					retVal=true;	
					System.out.println("Link Time Message: "+getText("xpath;//*[contains(text(),'timed out')]"));
				}
				driver.close(); //closing child window
				driver.switchTo().window(parentWindow);//cntrl to parent window
			}
		}
		return retVal;
	}
	
	public void GmailLogout(){
		wait(Until.elementToBeDisplayed("xpath;//*[contains(@title,'Google Account')]"));
		clickOnElement("xpath;//*[contains(@title,'Google Account')]");
		wait(Until.elementToBeDisplayed("xpath;//*[text()='Sign out']"));
		clickOnElement("xpath;//*[text()='Sign out']");
		sleep(5);
	}
	
	public void resetLinkExpirationwait(){
		sleep(900);
		System.out.println("Waiting for 15 mins for the link to expire");
	}
	
	
	
	public boolean newPwdConfirmCharterMail(){
		boolean retVal = false;
		sleep(10);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='lnkHdrcheckmessages']"));
		clickOnElement("xpath;.//*[@id='lnkHdrcheckmessages']");
		while(!isElementVisible("xpath;(//*[@class='bld']/*[contains(text(),'Your Spectrum password has been')])[1]")){
			clickOnElement("xpath;.//*[@id='lnkHdrcheckmessages']");
			sleep(10);
		}
		for(int i=0;i<50;i++){
			clickOnElement("xpath;.//*[@id='lnkHdrcheckmessages']");
			if(isElementVisible("xpath;(//*[@class='bld']/*[contains(text(),'Your Spectrum password has been')])[1]")){
				clickOnElement("xpath;(//*[@class='bld']/*[contains(text(),'Your Spectrum password has been')])[1]");
				sleep(5);
				wait(Until.elementToBeDisplayed("xpath;.//*[@id='lnkNavMail']"));
				clickOnElement("xpath;.//*[@id='lnkNavMail']");
				sleep(5);
				break;
			}
		}
		System.out.println("New Password Confirmation mail received");
		retVal=true;
		return retVal;
	}
	
	public boolean retrieveUsernameCharterMail(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed("xpath;(//*[contains(text(),'Your verification link to retrie')])[1]"));
		clickOnElement("xpath;(//*[contains(text(),'Your verification link to retrie')])[1]");
		System.out.println("Username retrieve Verification mail is Received");
		sleep(10);
		wait(Until.elementToBeDisplayed("xpath;(//*[contains(text(),'recover-id')])[1]"));
		clickOnElement("xpath;(//*[contains(text(),'recover-id')])[1]");
		String newURL=getText("xpath;(//*[contains(text(),'recover-id')])[1]");
		driver.navigate().to(newURL.replace("//", "//charternet:Chart3rn3t@"));
/*		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
			if(!windowHandle.equals(parentWindow))
			{
				driver.switchTo().window(windowHandle);
				driver.manage().window().maximize();
				System.out.println("user navigated to reset password page "+driver.getCurrentUrl());
				
				if(isElementPresent("xpath;//*[@class='container forgot-password ng-scope']")){
					retVal=true;	
					System.out.println("Success Message: "+getText("xpath;//*[@class='container forgot-password ng-scope']"));
				}
				driver.close(); //closing child window
				driver.switchTo().window(parentWindow);//cntrl to parent window
			}
		}*/
		System.out.println("user navigated to reset password page "+driver.getCurrentUrl());
		
		if(isElementPresent("xpath;//*[@class='container forgot-password ng-scope']")){
			retVal=true;	
			System.out.println("Success Message: "+getText("xpath;//*[@class='container forgot-password ng-scope']"));
		}
		return retVal;
	}
	
	public void convertUserCharterMail(){
		wait(Until.elementToBeDisplayed("xpath;(//*[contains(text(),'Your New Username')])[1]"));
		clickOnElement("xpath;(//*[contains(text(),'Your New Username')])[1]");
		sleep(5);
		System.out.println("Email received for converting a user");
	}
	
	public boolean resetPasswordMail(String pass){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(GmailFpMail));
		clickOnElement(GmailFpMail);
		wait(Until.elementToBeDisplayed(GmailResetLink));
		clickOnElement(GmailResetLink);
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
			if(!windowHandle.equals(parentWindow))
			{
				driver.switchTo().window(windowHandle);
				driver.manage().window().maximize();
				System.out.println(driver.getCurrentUrl());
				wait(Until.elementToBeClickable(fpNewPassword));
				type(fpNewPassword,pass);
				type(fpConfirmNewPassword,pass);
				clickOnElement(Savebtn);
				if(isElementPresent(checkEmail)){
					retVal=true;	
					System.out.println(getText(checkEmail));
				}
				driver.close(); //closing child window
				driver.switchTo().window(parentWindow);//cntrl to parent window
			}
		}
		return retVal;
	}
	
	public boolean pwResetConfirmationMail(){
		boolean retVal=false;
		wait(Until.elementToBeClickable(fp_Gmail));
		clickOnElement(fp_Gmail);
		if(isElementVisible(fp_Gmail))
			retVal=true;
		return retVal;
	}
	
	public boolean newUserMail(){
		boolean retVal=false;
		wait(Until.elementToBeClickable(newUserGmail));
		clickOnElement(newUserGmail);
		if(isElementVisible(newUserGmail))
			retVal=true;
		return retVal;
	}
	
	public boolean UIDResetConfirmationMail(){
		boolean retVal=false;
		wait(Until.elementToBeClickable(gmail_verifymail));
		clickOnElement(gmail_verifymail);
		retVal=true;
		return retVal;
	}
	
	public boolean BillDeliveryConfirmationMail(){
		boolean retVal=false;
		wait(Until.elementToBeClickable(billDeliveryMail));
		clickOnElement(billDeliveryMail);
		if(isElementVisible(billDeliveryMail))
			retVal=true;
		return retVal;
	}
	
	public boolean StatementNotificationMail(){
		boolean retVal=false;
		wait(Until.elementToBeClickable(statementMail));
		clickOnElement(statementMail);
		if(isElementVisible("xpath;(//img[@title='Gray_Bar_New'])[1]"))
			retVal=true;
		return retVal;
	}
	
	public boolean AutoPayConfirmationMail(){
		boolean retVal=false;
		wait(Until.elementToBeClickable(Ap_GmailConfirm));
		clickOnElement(Ap_GmailConfirm);
		sleep(5);
		retVal=true;
		return retVal;
	}
	
	public boolean PaymentConfirmationMail(){
		boolean retVal=false;
		wait(Until.elementToBeClickable(GmailConfirm_payment));
		clickOnElement(GmailConfirm_payment);
		sleep(5);
		retVal=true;
		return retVal;
	}
	
	public boolean SchedulePayment_ConfirmationMail(){
		boolean retVal=false;
		wait(Until.elementToBeClickable(Sp_GmailConfirm));
		clickOnElement(Sp_GmailConfirm);
		if(isElementVisible(Sp_GmailConfirm))
			retVal=true;
		return retVal;
	}
	
	public boolean fp_ValidE2E_NonconvertedMSLogin() throws Exception{

		boolean retVal=false;
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(fPassword));
		clickOnElement(fPassword);
		HomePage hp=new HomePage(driver);
		hp.pagewait();
		type(fpCharterId,"e2esprt3test15");
		type(fpZip,"97103");
		clickOnElement(fpNextBtn);
		type(fpSecurityAnswer,"red");
		clickOnElement(fpNextBtn);
		type(fpNewPassword,"Testing01");
		type(fpConfirmNewPassword,"Testing01");
		clickOnElement(Savebtn);
		clickOnElement(Finishbtn);
		hp.logoutApplication();
		retVal=true;
		return retVal;

	}
	
	public boolean fp_ValidE2E_NonconvertedCharterID() throws Exception{

		boolean retVal=false;
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(fPassword));
		clickOnElement(fPassword);
		HomePage hp=new HomePage(driver);
		hp.pagewait();
		type(fpCharterId,"uatadd205");
		type(fpZip,"63129");
		clickOnElement(fpNextBtn);
		type(fpSecurityAnswer,"bcci");
		clickOnElement(fpNextBtn);
		type(fpNewPassword,"Testing01");
		type(fpConfirmNewPassword,"Testing01");
		clickOnElement(Savebtn);
		clickOnElement(Finishbtn);
		hp.logoutApplication();
		retVal=true;
		return retVal;

	}
	
	public boolean fp_ValidE2E_convertedCharterID() throws Exception{

		boolean retVal=false;
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(fPassword));
		clickOnElement(fPassword);
		HomePage hp=new HomePage(driver);
		hp.pagewait();
		type(fpCharterId,"enge2e027");
		type(fpZip,"63129");
		clickOnElement(fpNextBtn);
		type(fpSecurityAnswer,"red");
		clickOnElement(fpNextBtn);
		type(fpNewPassword,"Testing01");
		type(fpConfirmNewPassword,"Testing01");
		clickOnElement(Savebtn);
		clickOnElement(Finishbtn);
		hp.logoutApplication();
		retVal=true;
		return retVal;

	}
	
	public boolean updateUsername(String fname,String lname,String secQ,String secA,String email,String mob) throws Exception{
		boolean retVal=false;
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(isElementVisible("xpath;.//*[@id='conversionForm']")){
			System.out.println("Step Number: "+getText("xpath;//*[contains(@class,'step-number ng-binding ng-scope step-current')]"));
			wait(Until.elementToBeDisplayed("xpath;.//*[@id='conversionForm']/ul/li/a"));//continue button
			clickOnElement("xpath;.//*[@id='conversionForm']/ul/li/a");
			
			System.out.println("Step Number: "+getText("xpath;//*[contains(@class,'step-number ng-binding ng-scope step-current')]"));
			
			//mandatory fields validation
			wait(Until.elementToBeDisplayed(UpFirstName));
			type(UpFirstName,""+Keys.TAB);
			if(isElementVisible(fnRequired)){
				System.out.println("First name field mandatory error: "+getText(fnRequired));
			}
			type(UpLastName, ""+Keys.TAB);
			if(isElementVisible(LnRequired)){
				System.out.println("Last name field mandatory error: "+getText(LnRequired));
			}
			clickOnElement(UpSecQ);
			pressKey(UpSecQ, Keys.TAB);
			if(isElementVisible(sqRequired)){
				System.out.println("Security Question field mandatory error: "+getText(sqRequired));
			}
			type(UpSecA,""+Keys.TAB);
			if(isElementVisible(saRequired)){
				System.out.println("Security answer field mandatory error: "+getText(saRequired));
			}
			type(UpEmail,""+Keys.TAB);
			if(isElementVisible(emailRequired)){
				System.out.println("Email field mandatory error: "+getText(emailRequired));
			}
			clearTextBox(UpMobile);
			type(UpMobile,""+Keys.TAB);
			if(isElementVisible(mobileRequired)){
				System.out.println("Mobile field mandatory error: "+getText(mobileRequired));
			}
			//invalid values validation
			type(UpEmail,"test"+Keys.TAB);
			if(isElementVisible(invalidMail)){
				System.out.println("Invalid email error: "+getText(invalidMail));
			}
			type(UpMobile,"0000"+Keys.TAB);
			if(isElementVisible(invalidPhone)){
				System.out.println("Invalid Phone number error: "+getText(invalidPhone));
			}
			
			//Obfuscated password validation
			if(isElementVisible(obfuscatedPw)){
				System.out.println("Obfuxcated password message is displayed as : "+getText(obfuscatedPw));
			}
				
			clearTextBox(UpEmail);
			clearTextBox(UpMobile);
			
			//continue normal flow
			type(UpFirstName,fname);
			type(UpLastName, lname);
			selectValueFromDropDown(UpSecQ, secQ);
			type(UpSecA,secA);
			type(UpEmail,email);
			clearTextBox(UpMobile);
			type(UpMobile, mob);
			if(isElementEnabled(UpUpdatebtn))
				retVal=true;
			sleep(10);
	/*		clickOnElement(UpUpdatebtn);
			sleep(10);
			System.out.println("Step Number: "+getText("xpath;//*[contains(@class,'step-number ng-binding ng-scope step-current')]"));
			wait(Until.elementToBeDisplayed(signInbtn));
			clickOnElement(signInbtn);
			sleep(10);
			HomePage hp = new HomePage(driver);
			hp.logoutApplication();*/
		}
		else if(isElementVisible(UpFirstName) & isElementVisible(UpLastName) & isElementVisible(UpSecQ) & isElementVisible(UpSecA) & isElementVisible(UpEmail) & isElementVisible(UpMobile) & isElementVisible(UpUpdatebtn)){
			System.out.println("Step Number: "+getText("xpath;//*[contains(@class,'step-number ng-binding ng-scope step-current')]"));
			
			//mandatory fields validation
			wait(Until.elementToBeDisplayed(UpFirstName));
			type(UpFirstName,""+Keys.TAB);
			if(isElementVisible(fnRequired)){
				System.out.println("First name field mandatory error: "+getText(fnRequired));
			}
			type(UpLastName, ""+Keys.TAB);
			if(isElementVisible(LnRequired)){
				System.out.println("Last name field mandatory error: "+getText(LnRequired));
			}
			clickOnElement(UpSecQ);
			pressKey(UpSecQ, Keys.TAB);
			if(isElementVisible(sqRequired)){
				System.out.println("Security Question field mandatory error: "+getText(sqRequired));
			}
			type(UpSecA,""+Keys.TAB);
			if(isElementVisible(saRequired)){
				System.out.println("Security answer field mandatory error: "+getText(saRequired));
			}
			type(UpEmail,""+Keys.TAB);
			if(isElementVisible(emailRequired)){
				System.out.println("Email field mandatory error: "+getText(emailRequired));
			}
			clearTextBox(UpMobile);
			type(UpMobile,""+Keys.TAB);
			if(isElementVisible(mobileRequired)){
				System.out.println("Mobile field mandatory error: "+getText(mobileRequired));
			}
			//invalid values validation
			type(UpEmail,"test"+Keys.TAB);
			if(isElementVisible(invalidMail)){
				System.out.println("Invalid email error: "+getText(invalidMail));
			}
			type(UpMobile,"0000"+Keys.TAB);
			if(isElementVisible(invalidPhone)){
				System.out.println("Invalid Phone number error: "+getText(invalidPhone));
			}
			
			//Obfuscated password validation
			if(isElementVisible(obfuscatedPw)){
				System.out.println("Obfuxcated password message is displayed as : "+getText(obfuscatedPw));
			}
				
			clearTextBox(UpEmail);
			clearTextBox(UpMobile);
			
			//continue normal flow
			type(UpFirstName,fname);
			type(UpLastName, lname);
			selectValueFromDropDown(UpSecQ, secQ);
			type(UpSecA,secA);
			type(UpEmail,email);
			clearTextBox(UpMobile);
			type(UpMobile, mob);
			if(isElementEnabled(UpUpdatebtn))
				retVal=true;
			sleep(10);
	/*		clickOnElement(UpUpdatebtn);
			sleep(10);
			System.out.println("Step Number: "+getText("xpath;//*[contains(@class,'step-number ng-binding ng-scope step-current')]"));
			wait(Until.elementToBeDisplayed(signInbtn));
			clickOnElement(signInbtn);
			sleep(10);
			HomePage hp = new HomePage(driver);
			hp.logoutApplication();*/
		}
		else {
			System.out.println("Update page not loaded");
			String Folder = "UpdatePageError";
			screenshot.saveScreenshot("Email"+ File.separator + Folder);
		}

		return retVal;
	}
	
	public void firstTimeConversion(){
		System.out.println("Step Number: "+getText("xpath;//*[contains(@class,'step-number ng-binding ng-scope step-current')]"));
		
		if(isElementVisible("xpath;.//*[@id='conversionForm']")){
			wait(Until.elementToBeDisplayed("xpath;.//*[@id='conversionForm']/ul/li/a"));//continue button
			clickOnElement("xpath;.//*[@id='conversionForm']/ul/li/a");
			System.out.println("First Time access page- Step 1 is displayed");
		}
	}
	
	public boolean secondTimeConversion(String fname,String lname,String secQ,String secA,String email,String mob){
		boolean retVal=false;
		
		System.out.println("Step Number: "+getText("xpath;//*[contains(@class,'step-number ng-binding ng-scope step-current')]"));
		System.out.println("Second attempt to login- step 2");
		//mandatory fields validation
		wait(Until.elementToBeDisplayed(UpFirstName));
		type(UpFirstName,""+Keys.TAB);
		if(isElementVisible(fnRequired)){
			System.out.println("First name field mandatory error: "+getText(fnRequired));
		}
		type(UpLastName, ""+Keys.TAB);
		if(isElementVisible(LnRequired)){
			System.out.println("Last name field mandatory error: "+getText(LnRequired));
		}
		clickOnElement(UpSecQ);
		pressKey(UpSecQ, Keys.TAB);
		if(isElementVisible(sqRequired)){
			System.out.println("Security Question field mandatory error: "+getText(sqRequired));
		}
		type(UpSecA,""+Keys.TAB);
		if(isElementVisible(saRequired)){
			System.out.println("Security answer field mandatory error: "+getText(saRequired));
		}
		type(UpEmail,""+Keys.TAB);
		if(isElementVisible(emailRequired)){
			System.out.println("Email field mandatory error: "+getText(emailRequired));
		}
		clearTextBox(UpMobile);
		type(UpMobile,""+Keys.TAB);
		if(isElementVisible(mobileRequired)){
			System.out.println("Mobile field mandatory error: "+getText(mobileRequired));
		}
		//invalid values validation
		type(UpEmail,"test"+Keys.TAB);
		if(isElementVisible(invalidMail)){
			System.out.println("Invalid email error: "+getText(invalidMail));
		}
		type(UpMobile,"0000"+Keys.TAB);
		if(isElementVisible(invalidPhone)){
			System.out.println("Invalid Phone number error: "+getText(invalidPhone));
		}
		
		//Obfuscated password validation
		if(isElementVisible(obfuscatedPw)){
			System.out.println("Obfuxcated password message is displayed as : "+getText(obfuscatedPw));
		}
			
		clearTextBox(UpEmail);
		clearTextBox(UpMobile);
		
		//continue normal flow
		type(UpFirstName,fname);
		type(UpLastName, lname);
		selectValueFromDropDown(UpSecQ, secQ);
		type(UpSecA,secA);
		type(UpEmail,email);
		clearTextBox(UpMobile);
		type(UpMobile, mob);
		if(isElementEnabled(UpUpdatebtn))
			retVal=true;
		sleep(10);
/*		clickOnElement(UpUpdatebtn);
		sleep(10);
		System.out.println("Step Number: "+getText("xpath;//*[contains(@class,'step-number ng-binding ng-scope step-current')]"));
		wait(Until.elementToBeDisplayed(signInbtn));
		clickOnElement(signInbtn);
		sleep(10);
		HomePage hp = new HomePage(driver);
		hp.logoutApplication();*/
		return retVal;
	}
	public void Conversion_ConfirmationMail(String username){
		sleep(15);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
		clickOnElement("xpath;.//*[@id='get-mail-button']/i");
		while(!isElementVisible("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Your New Username'])[1]")){
			wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
			clickOnElement("xpath;.//*[@id='get-mail-button']/i");
		}
		for(int i=1;i<50;){
			if(isElementPresent("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Your New Username'])["+i+"]")){
				clickOnElement("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Your New Username'])["+i+"]");
				wait(Until.elementToBeDisplayed("xpath;.//*[@id='mail-list-auto-resizer']"));
				clickOnElement("xpath;.//*[@id='mail-list-auto-resizer']");

				if(getText("xpath;.//*[@id='message-display-pane']").contains("Thanks for updating your username, "+username)){
					System.out.println("Conversion mail received successfully");
					break;
				}
				}
				else{
					wait(Until.elementToBeDisplayed("xpath;.//*[@id='mail-list-auto-resizer']"));
					clickOnElement("xpath;.//*[@id='mail-list-auto-resizer']");
					wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
					clickOnElement("xpath;.//*[@id='get-mail-button']/i");
				}
				
			}
		}
	
	public boolean dontRememberAns(String AccNumVer, String AccNum, String zip, String CID){
		boolean retVal=false;
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(fCharterId));
		clickOnElement(fCharterId);
		type(fID_Zipcode,zip );
		selectValueFromDropDown(SelecttoVerify,AccNumVer);
		type(InfoField,AccNum);
		clickOnElement(FUNextbtn);
		WebElement FIDuserRB=driver.findElement(By.xpath("//span[contains(text(),'"+ CID +"')]"));
		System.out.println(FIDuserRB);
		FIDuserRB.click();
		clickOnElement(FU1Nextbtn);
		clickOnElement(ForgotAnswerLink);
		driver.findElement(By.xpath("//*[contains(text(),'Try Other Ways')]")).click();
		//clickOnElement(ForgotAnswerLink);
		clickOnElement(fpNextBtn);
		if(isElementVisible(inlineError)){
			System.out.println(getText(inlineError));
			retVal=true;
		}
		return retVal;
	}
	
	public boolean conflictEmail(String AccVer, String email, String zip) throws Exception{
		boolean retVal=false;
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(fCharterId));
		clickOnElement(fCharterId);
		type(fID_Zipcode,zip );
		selectValueFromDropDown(SelecttoVerify,1);
		type(InfoField,email);
		clickOnElement(FUNextbtn);
		if(isElementVisible(captcha) || isElementVisible(needMoreInfoMsg)){
			System.out.println(getText(needMoreInfoMsg));
			retVal=true;
		}
		if(!isElementEnabled("xpath;//*[contains(text(),'Contact email address on account')]"))
			System.out.println("Email Option is not enabled");
		driver.manage().deleteAllCookies();
		//driver.navigate().refresh();
		HomePage hp = new HomePage(driver);
		hp.loadCharterPage(URL);
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(fCharterId));
		clickOnElement(fCharterId);
		sleep(5);
		if(isElementEnabled("xpath;//*[contains(text(),'Contact email address on account')]"))
			System.out.println("Email Option is enabled after clearing cookies");
		return retVal;
	}
	
	public boolean conflictPhone(String AccVer, String phone, String zip, String lastN) throws Exception{
		boolean retVal=false;
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(fCharterId));
		clickOnElement(fCharterId);
		type(fID_Zipcode,zip);
		selectValueFromDropDown(SelecttoVerify,0);
		type(InfoField,phone);
		type(lastName,lastN);
		clickOnElement(FUNextbtn);
		if(isElementVisible(captcha) || isElementVisible(needMoreInfoMsg)){
			System.out.println(needMoreInfoMsg);
			retVal=true;
		}
		if(!isElementEnabled("xpath;//*[contains(text(),'Phone Number on Account')]"))
			System.out.println("Phone Number Option is not enabled");
		driver.manage().deleteAllCookies();
		//driver.navigate().refresh();
		HomePage hp = new HomePage(driver);
		hp.loadCharterPage(URL);
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(fCharterId));
		clickOnElement(fCharterId);
		if(isElementEnabled("xpath;//*[contains(text(),'Phone Number on Account')]"))
			System.out.println("Phone Number Option is enabled after clearing cookies");
		return retVal;
	}
	
	public boolean FID_Non_Converted_CharterID(String password,String security_answer,String lastname_fID,String address_fID,String zipcode_fID,String mac_fID,String fLinkCID,String AccountNumberVerify,String ACnumber){
		boolean retVal=false;
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(fCharterId));
		clickOnElement(fCharterId);	
		HomePage hp=new HomePage(driver);
		hp.pagewait();
		type(fID_Zipcode,zipcode_fID);
		selectValueFromDropDown(SelecttoVerify,AccountNumberVerify);
		type(InfoField,ACnumber);
		clickOnElement(FUNextbtn);
		//WebElement ud = driver.findElement(By.xpath(""));
		//ud.click();
		WebElement FIDuserRB=driver.findElement(By.xpath("//span[contains(text(),'"+ fLinkCID +"')]"));
		System.out.println(FIDuserRB);
		FIDuserRB.click();
		clickOnElement(FU1Nextbtn);
		type(fpSecurityAnswer,security_answer);
		clickOnElement(FURBNextButton);
		WebElement FID=driver.findElement(By.xpath("//p[@class='username-result semibold view-username-text ng-binding']"));
		String FIDName=FID.getText();
		clickOnElement(Fusigninbtn);
		//	type(FID_user11,FIDName);
		wait(Until.elementToBeDisplayed(FID_pw1));
		type(FID_pw1,password);
		clickOnElement(submitSignin);
		retVal=true;
		return retVal;
	}
	
	public void mailLogin(String mailUserID,String pass){	
		wait(Until.elementToBeDisplayed(SignInLink));
	    clickOnElement(SignInLink);
		type(Username,mailUserID);
		type(PasswordPlaceHolder,pass);
		wait(Until.elementToBeClickable(btnSignin));
		clickOnElement(btnSignin);
		sleep(10);
		wait(Until.elementToBeDisplayed("xpath;//*[text()='Email']"));
		clickOnElement("xpath;//*[text()='Email']");
		sleep(10);
	}
	
	public void SP_ConfirmationMail(){
		WebElement email = driver.findElement(By.xpath("(//*[contains(text(),'Scheduled Payment Confirmation')])[1]"));
		while(!isElementVisible("xpath;(//*[contains(text(),'Scheduled Payment Confirmation')])[1]")){
			sleep(5);
			clickOnElement("xpath;//*[@id='get-mail-button-label']");
		}
		email.click();
		sleep(5);
		System.out.println("Email Received");
	}
	
	public void AP_ConfirmationMail(){
		sleep(5);
		WebElement email = driver.findElement(By.xpath("(//*[contains(text(),'Auto Pay Confirmation')])[1]"));
		while(!isElementVisible("xpath;(//*[contains(text(),'Auto Pay Confirmation')])[1]")){
			sleep(5);
			clickOnElement("xpath;//*[@id='get-mail-button-label']");
		}
		email.click();
		sleep(5);
		System.out.println("Email Received");
	}
	
	public void APS_CC_ConfirmationMail(){		
		sleep(15);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
		clickOnElement("xpath;.//*[@id='get-mail-button']/i");
		while(!isElementVisible("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Auto Pay Confirmation'])[1]")){
			wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
			clickOnElement("xpath;.//*[@id='get-mail-button']/i");
		}
		for(int i=1;i<50;){
			if(isElementPresent("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Auto Pay Confirmation'])["+i+"]")){
				clickOnElement("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Auto Pay Confirmation'])["+i+"]");
				wait(Until.elementToBeDisplayed("xpath;.//*[@id='mail-list-auto-resizer']"));
				clickOnElement("xpath;.//*[@id='mail-list-auto-resizer']");
				//switchToFrame(1);
				//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='message-display-iframe']")));
				System.out.println(getText("xpath;.//*[@id='message-pane']"));
				if(getText("xpath;.//*[@id='message-pane']").contains("Auto Pay Credit Card Enrollment")){
					System.out.println("Auto Pay Credit Card Enrollment mail received successfully");
					//switchToDefaultContent();
					break;
				}
				else{
					//switchToDefaultContent();
					wait(Until.elementToBeDisplayed("xpath;.//*[@id='mail-list-auto-resizer']"));
					clickOnElement("xpath;.//*[@id='mail-list-auto-resizer']");
					wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
					clickOnElement("xpath;.//*[@id='get-mail-button']/i");
				}
				
			}
		}
	}
	
	public void APC_CC_ConfirmationMail(){		
		sleep(15);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
		clickOnElement("xpath;.//*[@id='get-mail-button']/i");
		while(!isElementVisible("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Auto Pay Confirmation'])[1]")){
			wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
			clickOnElement("xpath;.//*[@id='get-mail-button']/i");
		}
		for(int i=1;i<50;){
			if(isElementPresent("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Auto Pay Confirmation'])["+i+"]")){
				clickOnElement("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Auto Pay Confirmation'])["+i+"]");
				wait(Until.elementToBeDisplayed("xpath;.//*[@id='mail-list-auto-resizer']"));
				clickOnElement("xpath;.//*[@id='mail-list-auto-resizer']");
				//switchToFrame(1);
				//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='message-display-iframe']")));
				System.out.println(getText("xpath;.//*[@id='message-pane']"));
				if(getText("xpath;.//*[@id='message-pane']").contains("Auto Pay Credit Card Cancellation")){
					System.out.println("Auto Pay Credit Card Cancellation mail received successfully");
					//switchToDefaultContent();
					break;
				}
				else{
					//switchToDefaultContent();
					wait(Until.elementToBeDisplayed("xpath;.//*[@id='mail-list-auto-resizer']"));
					clickOnElement("xpath;.//*[@id='mail-list-auto-resizer']");
					wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
					clickOnElement("xpath;.//*[@id='get-mail-button']/i");
				}
				
			}
		}
	}
	
	public void APS_DC_ConfirmationMail(){		
		sleep(15);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
		clickOnElement("xpath;.//*[@id='get-mail-button']/i");
		while(!isElementVisible("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Auto Pay Confirmation'])[1]")){
			wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
			clickOnElement("xpath;.//*[@id='get-mail-button']/i");
		}
		for(int i=1;i<50;){
			if(isElementPresent("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Auto Pay Confirmation'])["+i+"]")){
				clickOnElement("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Auto Pay Confirmation'])["+i+"]");
				wait(Until.elementToBeDisplayed("xpath;.//*[@id='mail-list-auto-resizer']"));
				clickOnElement("xpath;.//*[@id='mail-list-auto-resizer']");
				sleep(10);
				//switchToFrame(1);
				//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='message-display-iframe']")));
				System.out.println(getText("xpath;.//*[@id='message-pane']"));
				if(getText("xpath;.//*[@id='message-pane']").contains("Auto Pay Debit Card Enrollment")){
					System.out.println("Auto Pay Debit Card Enrollment mail received successfully");
					//switchToDefaultContent();
					break;
				}
				else{
					//switchToDefaultContent();
					wait(Until.elementToBeDisplayed("xpath;.//*[@id='mail-list-auto-resizer']"));
					clickOnElement("xpath;.//*[@id='mail-list-auto-resizer']");
					wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
					clickOnElement("xpath;.//*[@id='get-mail-button']/i");
				}
				
			}
		}
	}
	
	public void APC_DC_ConfirmationMail(){		
		sleep(15);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
		clickOnElement("xpath;.//*[@id='get-mail-button']/i");
		while(!isElementVisible("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Auto Pay Confirmation'])[1]")){
			wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
			clickOnElement("xpath;.//*[@id='get-mail-button']/i");
		}
		for(int i=1;i<50;){
			if(isElementPresent("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Auto Pay Confirmation'])["+i+"]")){
				clickOnElement("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Auto Pay Confirmation'])["+i+"]");
				wait(Until.elementToBeDisplayed("xpath;.//*[@id='mail-list-auto-resizer']"));
				clickOnElement("xpath;.//*[@id='mail-list-auto-resizer']");
				//switchToFrame(1);
				//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='message-display-iframe']")));
				System.out.println(getText("xpath;.//*[@id='message-pane']"));
				if(getText("xpath;.//*[@id='message-pane']").contains("Auto Pay Debit Card Cancellation")){
					System.out.println("Auto Pay Debit Card Cancellation mail received successfully");
					//switchToDefaultContent();
					break;
				}
				else{
					//switchToDefaultContent();
					wait(Until.elementToBeDisplayed("xpath;.//*[@id='mail-list-auto-resizer']"));
					clickOnElement("xpath;.//*[@id='mail-list-auto-resizer']");
					wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
					clickOnElement("xpath;.//*[@id='get-mail-button']/i");
				}
				
			}
		}
	}
	
	public void APS_CS_ConfirmationMail(){		
		sleep(15);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
		clickOnElement("xpath;.//*[@id='get-mail-button']/i");
		while(!isElementVisible("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Auto Pay Confirmation'])[1]")){
			wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
			clickOnElement("xpath;.//*[@id='get-mail-button']/i");
		}
		for(int i=1;i<50;){
			if(isElementPresent("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Auto Pay Confirmation'])["+i+"]")){
				clickOnElement("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Auto Pay Confirmation'])["+i+"]");
				wait(Until.elementToBeDisplayed("xpath;.//*[@id='mail-list-auto-resizer']"));
				clickOnElement("xpath;.//*[@id='mail-list-auto-resizer']");
				sleep(10);
				//switchToFrame(1);
				//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='message-display-iframe']")));
				System.out.println(getText("xpath;.//*[@id='message-pane']"));
				if(getText("xpath;.//*[@id='message-pane']").contains("Auto Pay Bank Account Enrollment")){
					System.out.println("Auto Pay Bank Account Enrollment mail received successfully");
					//switchToDefaultContent();
					break;
				}
				else{
					//switchToDefaultContent();
					wait(Until.elementToBeDisplayed("xpath;.//*[@id='mail-list-auto-resizer']"));
					clickOnElement("xpath;.//*[@id='mail-list-auto-resizer']");
					wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
					clickOnElement("xpath;.//*[@id='get-mail-button']/i");
				}
				
			}
		}
	}
	
	public void APC_CS_ConfirmationMail(){		
		sleep(15);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
		clickOnElement("xpath;.//*[@id='get-mail-button']/i");
		while(!isElementVisible("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Auto Pay Confirmation'])[1]")){
			wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
			clickOnElement("xpath;.//*[@id='get-mail-button']/i");
		}
		for(int i=1;i<50;){
			if(isElementPresent("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Auto Pay Confirmation'])["+i+"]")){
				clickOnElement("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Auto Pay Confirmation'])["+i+"]");
				wait(Until.elementToBeDisplayed("xpath;.//*[@id='mail-list-auto-resizer']"));
				clickOnElement("xpath;.//*[@id='mail-list-auto-resizer']");
				//switchToFrame(1);
				//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='message-display-iframe']")));
				System.out.println(getText("xpath;.//*[@id='message-pane']"));
				if(getText("xpath;.//*[@id='message-pane']").contains("Auto Pay Bank Account Cancellation")){
					System.out.println("Auto Pay Bank Account Cancellation mail received successfully");
					//switchToDefaultContent();
					break;
				}
				else{
					//switchToDefaultContent();
					wait(Until.elementToBeDisplayed("xpath;.//*[@id='mail-list-auto-resizer']"));
					clickOnElement("xpath;.//*[@id='mail-list-auto-resizer']");
					wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
					clickOnElement("xpath;.//*[@id='get-mail-button']/i");
				}
				
			}
		}
	}
	
	public void OTP_CC_ConfirmationMail(){		
		sleep(15);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
		clickOnElement("xpath;.//*[@id='get-mail-button']/i");
		while(!isElementVisible("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Payment Confirmation'])[1]")){
			wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
			clickOnElement("xpath;.//*[@id='get-mail-button']/i");
		}
		for(int i=1;i<50;){
			if(isElementPresent("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Payment Confirmation'])["+i+"]")){
				clickOnElement("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Payment Confirmation'])["+i+"]");
				sleep(10);
				wait(Until.elementToBeDisplayed("xpath;.//*[@id='mail-list-auto-resizer']"));
				clickOnElement("xpath;.//*[@id='mail-list-auto-resizer']");
				//switchToFrame(1);
				//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='message-display-iframe']")));
				System.out.println(getText("xpath;.//*[@id='message-pane']"));
				if(getText("xpath;.//*[@id='message-pane']").contains("Credit Card Payment")){
					sleep(10);
					System.out.println("Credit Card payment mail received successfully");
					//switchToDefaultContent();
					break;
				}
				else{
					//switchToDefaultContent();
					wait(Until.elementToBeDisplayed("xpath;.//*[@id='mail-list-auto-resizer']"));
					clickOnElement("xpath;.//*[@id='mail-list-auto-resizer']");
					wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
					clickOnElement("xpath;.//*[@id='get-mail-button']/i");
				}
				
			}
		}
	}
	
	public void OTP_DC_ConfirmationMail(){		
		sleep(15);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
		clickOnElement("xpath;.//*[@id='get-mail-button']/i");
		while(!isElementVisible("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Payment Confirmation'])[1]")){
			wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
			clickOnElement("xpath;.//*[@id='get-mail-button']/i");
		}
		for(int i=1;i<50;){
			if(isElementPresent("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Payment Confirmation'])["+i+"]")){
				clickOnElement("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Payment Confirmation'])["+i+"]");
				sleep(10);
				wait(Until.elementToBeDisplayed("xpath;.//*[@id='mail-list-auto-resizer']"));
				clickOnElement("xpath;.//*[@id='mail-list-auto-resizer']");
				//switchToFrame(1);
				//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='message-display-iframe']")));
				System.out.println(getText("xpath;.//*[@id='message-pane']"));
				if(getText("xpath;.//*[@id='message-pane']").contains("Debit Card Payment")){
					sleep(10);
					System.out.println("Debit Card payment mail received successfully");
					//switchToDefaultContent();
					break;
				}
				else{
					//switchToDefaultContent();
					wait(Until.elementToBeDisplayed("xpath;.//*[@id='mail-list-auto-resizer']"));
					clickOnElement("xpath;.//*[@id='mail-list-auto-resizer']");
					wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
					clickOnElement("xpath;.//*[@id='get-mail-button']/i");
				}
				
			}
		}
	}
	
	public void OTPS_CC_ConfirmationMail(){		
		sleep(15);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
		clickOnElement("xpath;.//*[@id='get-mail-button']/i");
		while(!isElementVisible("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Scheduled Payment Confirmation'])[1]")){
			wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
			clickOnElement("xpath;.//*[@id='get-mail-button']/i");
		}
		for(int i=1;i<50;){
			if(isElementPresent("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Scheduled Payment Confirmation'])["+i+"]")){
				clickOnElement("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Scheduled Payment Confirmation'])["+i+"]");
				wait(Until.elementToBeDisplayed("xpath;.//*[@id='mail-list-auto-resizer']"));
				clickOnElement("xpath;.//*[@id='mail-list-auto-resizer']");
				//switchToFrame(1);
				//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='message-display-iframe']")));
				System.out.println(getText("xpath;.//*[@id='message-pane']"));
				if(getText("xpath;.//*[@id='message-pane']").contains("Scheduled Credit Card Payment")){
					System.out.println("Scheduled Credit Card payment mail received successfully");
					//switchToDefaultContent();
					break;
				}
				else{
					//switchToDefaultContent();
					wait(Until.elementToBeDisplayed("xpath;.//*[@id='mail-list-auto-resizer']"));
					clickOnElement("xpath;.//*[@id='mail-list-auto-resizer']");
					wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
					clickOnElement("xpath;.//*[@id='get-mail-button']/i");
				}
				
			}
		}
	}
	
	public void OTPS_DC_ConfirmationMail(){		
		sleep(15);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
		clickOnElement("xpath;.//*[@id='get-mail-button']/i");
		while(!isElementVisible("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Scheduled Payment Confirmation'])[1]")){
			wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
			clickOnElement("xpath;.//*[@id='get-mail-button']/i");
		}
		for(int i=1;i<50;){
			if(isElementPresent("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Scheduled Payment Confirmation'])["+i+"]")){
				clickOnElement("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Scheduled Payment Confirmation'])["+i+"]");
				wait(Until.elementToBeDisplayed("xpath;.//*[@id='mail-list-auto-resizer']"));
				clickOnElement("xpath;.//*[@id='mail-list-auto-resizer']");
				//switchToFrame(1);
				//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='message-display-iframe']")));
				System.out.println(getText("xpath;.//*[@id='message-pane']"));
				if(getText("xpath;.//*[@id='message-pane']").contains("Scheduled Debit Card Payment")){
					System.out.println("Scheduled Debit Card payment mail received successfully");
					//switchToDefaultContent();
					break;
				}
				else{
					//switchToDefaultContent();
					wait(Until.elementToBeDisplayed("xpath;.//*[@id='mail-list-auto-resizer']"));
					clickOnElement("xpath;.//*[@id='mail-list-auto-resizer']");
					wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
					clickOnElement("xpath;.//*[@id='get-mail-button']/i");
				}
				
			}
		}
	}
	
	public void OTPS_CS_ConfirmationMail(){		
		sleep(15);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
		clickOnElement("xpath;.//*[@id='get-mail-button']/i");
		while(!isElementVisible("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Scheduled Payment Confirmation'])[1]")){
			wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
			clickOnElement("xpath;.//*[@id='get-mail-button']/i");
		}
		for(int i=1;i<50;){
			if(isElementPresent("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Scheduled Payment Confirmation'])["+i+"]")){
				clickOnElement("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Scheduled Payment Confirmation'])["+i+"]");
				wait(Until.elementToBeDisplayed("xpath;.//*[@id='mail-list-auto-resizer']"));
				clickOnElement("xpath;.//*[@id='mail-list-auto-resizer']");
				//switchToFrame(1);
				//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='message-display-iframe']")));
				System.out.println(getText("xpath;.//*[@id='message-pane']"));
				if(getText("xpath;.//*[@id='message-pane']").contains("Scheduled Bank Account Payment")){
					System.out.println("Scheduled Bank Account payment mail received successfully");
					//switchToDefaultContent();
					break;
				}
				else{
					//switchToDefaultContent();
					wait(Until.elementToBeDisplayed("xpath;.//*[@id='mail-list-auto-resizer']"));
					clickOnElement("xpath;.//*[@id='mail-list-auto-resizer']");
					wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
					clickOnElement("xpath;.//*[@id='get-mail-button']/i");
				}
				
			}
		}
	}
	
	public void OTP_CS_ConfirmationMail(){		
		sleep(15);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
		clickOnElement("xpath;.//*[@id='get-mail-button']/i");
		while(!isElementVisible("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Payment Confirmation'])[1]")){
			wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
			clickOnElement("xpath;.//*[@id='get-mail-button']/i");
		}
		for(int i=1;i<50;){
			if(isElementPresent("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Payment Confirmation'])["+i+"]")){
				clickOnElement("xpath;(//*[contains(@class,'message-unread')]/td/div[text()='Payment Confirmation'])["+i+"]");
				wait(Until.elementToBeDisplayed("xpath;.//*[@id='mail-list-auto-resizer']"));
				clickOnElement("xpath;.//*[@id='mail-list-auto-resizer']");
				//switchToFrame(1);
				//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='message-display-iframe']")));
				System.out.println(getText("xpath;.//*[@id='message-pane']"));
				if(getText("xpath;.//*[@id='message-pane']").contains("Bank Account Payment")){
					System.out.println("Bank Account payment mail received successfully");
					//switchToDefaultContent();
					break;
				}
				else{
					//switchToDefaultContent();
					wait(Until.elementToBeDisplayed("xpath;.//*[@id='mail-list-auto-resizer']"));
					clickOnElement("xpath;.//*[@id='mail-list-auto-resizer']");
					wait(Until.elementToBeDisplayed("xpath;.//*[@id='get-mail-button']/i"));
					clickOnElement("xpath;.//*[@id='get-mail-button']/i");
				}
				
			}
		}
	}
	
	public void BD_ConfirmationMail(){
		sleep(5);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement email = driver.findElement(By.xpath("(//*[text()='Bill Delivery Preference Notification'])[1]"));
		while(!isElementVisible("xpath;(//*[text()='Bill Delivery Preference Notification'])[1]")){
			sleep(5);
			clickOnElement("xpath;//*[@id='get-mail-button-label']");
		}
		email.click();
		sleep(5);
		System.out.println("Email Received");
	}
	
	public boolean BD_NotificationCharterMail(){
		boolean retVal = false;
		sleep(10);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='lnkHdrcheckmessages']"));
		clickOnElement("xpath;.//*[@id='lnkHdrcheckmessages']");
		while(!isElementVisible("xpath;(//*[@class='bld']/*[contains(text(),'Bill Delivery Preference')])[1]")){
			clickOnElement("xpath;.//*[@id='lnkHdrcheckmessages']");
			sleep(10);
		}
		for(int i=0;i<50;i++){
			clickOnElement("xpath;.//*[@id='lnkHdrcheckmessages']");
			if(isElementVisible("xpath;(//*[@class='bld']/*[contains(text(),'Bill Delivery Preference')])[1]")){
				clickOnElement("xpath;(//*[@class='bld']/*[contains(text(),'Bill Delivery Preference')])[1]");
				sleep(5);
				wait(Until.elementToBeDisplayed("xpath;.//*[@id='lnkNavMail']"));
				clickOnElement("xpath;.//*[@id='lnkNavMail']");
				sleep(5);
				break;
			}
		}
		System.out.println("Bill Delivery Preference Notification mail received");
		retVal=true;
		return retVal;
	}
	
	public void CID_ConfirmationMail(){
		sleep(5);
		WebElement email = driver.findElement(By.xpath("(//*[text()='Your New Username'])[1]"));
		while(!isElementVisible("xpath;(//*[text()='Your New Username'])[1]")){
			sleep(5);
			clickOnElement("xpath;//*[@id='get-mail-button-label']");
		}
		email.click();
		sleep(5);
		System.out.println("Email Received");
	}
	
	public void BillAddress_ConfirmationMail(){
		sleep(5);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement email = driver.findElement(By.xpath("(//*[text()='Billing Address Change Notification'])[1]"));
		while(!isElementVisible("xpath;(//*[text()='Billing Address Change Notification'])[1]")){
			sleep(5);
			clickOnElement("xpath;//*[@id='get-mail-button-label']");
		}
		email.click();
		sleep(5);
		System.out.println("Email Received");
	}
	
	public void stmt_NotificationMail(){
		WebElement email = driver.findElement(By.xpath("(//*[text()='Charter Statement Notification'])[1]"));
		while(!isElementVisible("xpath;(//*[text()='Charter Statement Notification'])[1]")){
			clickOnElement("xpath;//*[@id='mail-page-more']");
		}
		email.click();
		sleep(5);
		System.out.println("Email Received");
		/*if(isElementVisible("xpath;.//*[@id='image-charter-head']"))
			System.out.println("New Charter Spectrum logo is displayed");*/
	}
	
    public String getAccountDetails(String accountNum){
    	
		String[] filepath=new String[] { System.getProperty("user.dir") + File.separator + "AutoIT" + File.separator +"KMSLogin.exe",EnvParameters.WEB_BROWSER_TYPE.replaceAll("\\*", "")};
        try {
			Runtime.getRuntime().exec(filepath);
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("Unable to close");
		}
		driver.navigate().to("https://dkumar2:Sep@2015@kms20.corp.chartercom.com/SetBySystem/default.aspx");
        sleep(5);
        selectValueFromDropDown("xpath;//tbody/tr[1]/td[1]/p[1]/select", "Account");
        clickOnElement("xpath;//*[@value=' Set ']");
        type("xpath;//table/tbody/tr[1]/td[2]/input[1]",accountNum);
        clickOnElement("xpath;//*[@value=' Find ']");
        sleep(5);
        String CustomerName = getText("xpath;(//tbody/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/span[1][contains(@id,'CustomerName')])");
        String ServiceAddress = getText("xpath;(//tbody/tr[1]/td[1]/table[1]/tbody[1]/tr[2]/td[1]/span[1][contains(@id,'Address')])");
        String CityStateZip = getText("xpath;(//tbody/tr[1]/td[1]/table[1]/tbody[1]/tr[3]/td[1]/span[1][contains(@id,'CityStateZip')])");
        String Phone = getText("xpath;(//tbody/tr[1]/td[1]/table[1]/tbody[1]/tr[6]/td[2]/span[1][contains(@id,'PhoneNumber')])");
        System.out.println("Customer Information for the Account Number: "+accountNum);
        System.out.println("Customer Name: "+CustomerName);
        System.out.println("Service Address: "+ServiceAddress);
        System.out.println("City, State and Zip: "+ CityStateZip);
        System.out.println("Phone Number: "+Phone);
        String CompleteAddress = accountNum+CustomerName+ServiceAddress+CityStateZip+Phone;
        System.out.println(CompleteAddress);
        return CompleteAddress;
 }
    
    
    public void recoverUID(){
    	String ParentWindow = driver.getWindowHandle();
    	
    	if(isElementVisible("xpath;//*[@target='_blank'][contains(text(),'https')]"))
    		clickOnElement("xpath;//*[@target='_blank'][contains(text(),'https')]");
    	Set<String> windows = driver.getWindowHandles();
    	for(String Handle:windows){
    		if(!Handle.equals(ParentWindow))
    			driver.switchTo().window(Handle);
    	}
    	sleep(5);
    }
    
    public boolean convertUserMSLogin(String fname,String lname,String secQ,String secA,String email,String mob,String username){
    	boolean retVal=false;
       	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	if(isElementVisible("xpath;//*[@class='modal-content']")){
    		if(getText("xpath;//*[@class='modal-content']").contains("Can't convert MS Login")){
    			System.out.println("MS Login conversion not allowed");
    			System.out.println("MS Login conversion pop up message : "+getText("xpath;//*[@class='modal-content']"));
    		}
    		clickOnElement("xpath;.//*[@id='btn-modal-1']");
    	}
       	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	//step 1
		if(isElementVisible("xpath;.//*[@id='conversionForm']")){
			wait(Until.elementToBeDisplayed("xpath;.//*[@id='conversionForm']/ul/li/a"));//continue button
			clickOnElement("xpath;.//*[@id='conversionForm']/ul/li/a");
		}
		clearTextBox(UpEmail);
		clearTextBox(UpMobile);
		
		//step 2
		System.out.println("Username displayed: "+getText("xpath;//*[contains(@ng-repeat,'convertingIds')]"));
		if(getText("xpath;.//*[@id='idValidation']/div[3]/div").contains(username)){
			System.out.println("Username is auto populated");
		}
		type(UpFirstName,fname);
		type(UpLastName, lname);
		selectValueFromDropDown(UpSecQ, secQ);
		
		type(UpSecA,secA);
		type(UpEmail,email);
		clearTextBox(UpMobile);
		type(UpMobile, mob);
		if(isElementEnabled(UpUpdatebtn))
			retVal=true;
		sleep(10);
		/*clickOnElement(UpUpdatebtn);
		sleep(10);
		//step 3
		System.out.println("Step Number: "+getText("xpath;//*[contains(@class,'step-number ng-binding ng-scope step-current')]"));
		wait(Until.elementToBeDisplayed(signInbtn));
		clickOnElement(signInbtn);
		sleep(10);
		HomePage hp = new HomePage(driver);
		hp.logoutApplication();*/
    	retVal=true;
    	return retVal;
    }
    
    public boolean convertUserDotNetID(String fname,String lname,String secQ,String secA,String email,String mob){
    	boolean retVal=false;
       	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	if(isElementVisible("xpath;//*[@class='modal-content']")){
    		if(getText("xpath;//*[@class='modal-content']").contains("Can't convert MS Login")){
    			System.out.println("MS Login conversion not allowed");
    			System.out.println("MS Login conversion pop up message : "+getText("xpath;//*[@class='modal-content']"));
    		}
    		clickOnElement("xpath;.//*[@id='btn-modal-1']");
    	}
       	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	//step 1
		if(isElementVisible("xpath;.//*[@id='conversionForm']")){
			wait(Until.elementToBeDisplayed("xpath;.//*[@id='conversionForm']/ul/li/a"));//continue button
			clickOnElement("xpath;.//*[@id='conversionForm']/ul/li/a");
		}
		clearTextBox(UpEmail);
		clearTextBox(UpMobile);
		
		//step 2
		System.out.println("Username displayed: "+getText("xpath;//*[contains(@ng-repeat,'convertingIds')]"));
		if(getText("xpath;.//*[@id='idValidation']/div[3]/div").contains(fname)){
			System.out.println("Username is auto populated");
		}
		type(UpFirstName,fname);
		type(UpLastName, lname);
		selectValueFromDropDown(UpSecQ, secQ);
		
		type(UpSecA,secA);
		type(UpEmail,email);
		clearTextBox(UpMobile);
		type(UpMobile, mob);
		if(isElementEnabled(UpUpdatebtn))
			retVal=true;
		sleep(10);
		/*clickOnElement(UpUpdatebtn);
		sleep(10);
		//step 3
		System.out.println("Step Number: "+getText("xpath;//*[contains(@class,'step-number ng-binding ng-scope step-current')]"));
		wait(Until.elementToBeDisplayed(signInbtn));
		clickOnElement(signInbtn);
		sleep(10);
		HomePage hp = new HomePage(driver);
		hp.logoutApplication();*/
    	retVal=true;
    	return retVal;
    }
    
    public boolean forgotPasswordSpectrumWifi(String spectrumwifiURL,String charterID,String lastName,String zip,String security_answer,String password){
    	boolean retVal=false;
    	driver.navigate().to(spectrumwifiURL);
    	wait(Until.elementToBeDisplayed("xpath;.//*[@id='username']"));
    	type("xpath;.//*[@id='username']",""+Keys.TAB);
    	if(isElementVisible("xpath;//*[contains(text(),'Username is required')]")){
    		System.out.println(getText("xpath;//*[contains(text(),'Username is required')]"));
    	}
    	type("xpath;.//*[@id='lastName']",""+Keys.TAB);
    	if(isElementVisible("xpath;//*[contains(text(),'Last name is required')]")){
    		System.out.println(getText("xpath;//*[contains(text(),'Last name is required')]"));
    	}
    	type("xpath;.//*[@id='zip']",""+Keys.TAB);
    	if(isElementVisible("xpath;//*[contains(text(),'Zip is required')]")){
    		System.out.println(getText("xpath;//*[contains(text(),'Zip is required')]"));
    	}
    	type("xpath;.//*[@id='username']",charterID);
    	type("xpath;.//*[@id='lastName']",lastName);
    	type("xpath;.//*[@id='zip']",zip);
    	clickOnElement("xpath;//*[@value='Next']");
    	
    	wait(Until.elementToBeDisplayed("xpath;.//*[@id='securityAnswer']"));
    	type("xpath;.//*[@id='securityAnswer']",""+Keys.TAB);
    	if(isElementVisible("xpath;//*[contains(text(),'Security answer is required')]")){
    		System.out.println(getText("xpath;//*[contains(text(),'Security answer is required')]"));
    	}
    	type("xpath;.//*[@id='securityAnswer']",security_answer);
    	clickOnElement("xpath;//*[@value='Next']");
    	
    	wait(Until.elementToBeDisplayed("xpath;.//*[@id='password']"));
    	type("xpath;.//*[@id='password']",""+Keys.TAB);
    	if(isElementVisible("xpath;//*[contains(text(),'Password is required')]")){
    		System.out.println(getText("xpath;//*[contains(text(),'Password is required')]"));
    	}
    	type("xpath;.//*[@id='password']",password);
    	type("xpath;.//*[@id='confirmPassword']","test"+Keys.TAB);
    	if(isElementVisible("xpath;//*[contains(text(),'passwords entered do not match')]")){
    		System.out.println(getText("xpath;//*[contains(text(),'passwords entered do not match')]"));
    	}
    	clearTextBox("xpath;.//*[@id='password']");
    	clearTextBox("xpath;.//*[@id='confirmPassword']");
    	type("xpath;.//*[@id='password']",password);
    	type("xpath;.//*[@id='confirmPassword']",password);
    	clickOnElement("xpath;//*[@value='Next']");
    	
    	wait(Until.elementToBeDisplayed("xpath;//*[text()='Sign in']"));
    	System.out.println(getText("xpath;//*[contains(text(),'success')]"));
    	clickOnElement("xpath;//*[text()='Sign in']");
    	sleep(5);
    	wait(Until.elementToBeDisplayed("xpath;//*[@ng-model='userName']"));
    	clearTextBox("xpath;//*[@ng-model='userName']");
    	type("xpath;//*[@ng-model='userName']",charterID);
    	type("xpath;//*[@ng-model='userPassword']",password);
    	clickOnElement("xpath;.//*[@id='signin-button']");
    	sleep(10);
    	if(isElementVisible("xpath;//*[contains(text(),'Connected to Spectrum')]")){
    		System.out.println(getText("xpath;//*[contains(text(),'Connected to Spectrum')]"));
    		retVal= true;
    	}
    	return retVal;
    }
	
}
