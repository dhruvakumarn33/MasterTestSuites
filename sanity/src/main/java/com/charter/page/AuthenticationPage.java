package com.charter.page;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.charter.page.UserPreferencePage.userType;
import com.cognizant.framework.ajax.Until;
import com.cognizant.framework.core.CaptureScreenshot;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.WebDriverBase;

public class AuthenticationPage extends WebDriverBase {

	private String URL= ReadFromExcel.getData("HomePage","Engnew_URL");

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

	CaptureScreenshot<WebDriver> screenshot;
	public AuthenticationPage(WebDriver driver) {
		this.driver=driver;	

		screenshot= new CaptureScreenshot<WebDriver>(driver);
	}

	
	// In Scenario Sheet 
	public boolean createID_Nextbutton(String firstname_CID,String lastname_CID,String Address_CID,String Zipcode_CID,String MAC_CID,String invalidZipcode){

		boolean retVal=false;
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(CreateID));
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
		wait(Until.elementToBeDisplayed(CreateID));
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
		wait(Until.elementToBeDisplayed(CreateID));
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
		wait(Until.elementToBeDisplayed(CreateID));
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
	
	public boolean fp_ValidE2E_NonconvertedMSLogin(String charterID,String password,String zip,String SecAns) throws Exception{

		boolean retVal=false;
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(fPassword));
		clickOnElement(fPassword);
		HomePage hp=new HomePage(driver);
		hp.pagewait();
		type(fpCharterId,charterID);
		type(fpZip,zip);
		clickOnElement(fpNextBtn);
		type(fpSecurityAnswer,SecAns);
		clickOnElement(fpNextBtn);
		type(fpNewPassword,password);
		type(fpConfirmNewPassword,password);
		clickOnElement(Savebtn);
		clickOnElement(Finishbtn);
		hp.logoutApplication();
		retVal=true;
		return retVal;

	}
	
	public boolean fp_ValidE2E_NonconvertedCharterID(String charterID,String password,String zip,String SecAns) throws Exception{

		boolean retVal=false;
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(fPassword));
		clickOnElement(fPassword);
		HomePage hp=new HomePage(driver);
		hp.pagewait();
		type(fpCharterId,charterID);
		type(fpZip,zip);
		clickOnElement(fpNextBtn);
		type(fpSecurityAnswer,SecAns);
		clickOnElement(fpNextBtn);
		type(fpNewPassword,password);
		type(fpConfirmNewPassword,password);
		clickOnElement(Savebtn);
		clickOnElement(Finishbtn);
		hp.logoutApplication();
		retVal=true;
		return retVal;

	}
	
	public boolean fp_ValidE2E_convertedCharterID(String charterID,String password,String zip,String SecAns) throws Exception{

		boolean retVal=false;
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(fPassword));
		clickOnElement(fPassword);
		HomePage hp=new HomePage(driver);
		hp.pagewait();
		type(fpCharterId,charterID);
		type(fpZip,zip);
		clickOnElement(fpNextBtn);
		type(fpSecurityAnswer,SecAns);
		clickOnElement(fpNextBtn);
		type(fpNewPassword,password);
		type(fpConfirmNewPassword,password);
		clickOnElement(Savebtn);
		clickOnElement(Finishbtn);
		hp.logoutApplication();
		retVal=true;
		return retVal;

	}

	public boolean fp_ValidE2E_Admin(String password,String CharterID_fp,String Zipcode_fp,String security_answer) throws Exception{

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
		clickOnElement(Finishbtn);
		hp.logoutApplication();
		retVal=true;
		return retVal;
	}

	public boolean fp_ValidE2E_Standard(String password,String CharterID_fp,String Zipcode_fp,String security_answer) throws Exception{

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
		clickOnElement(Finishbtn);
		hp.logoutApplication();
		retVal=true;
		return retVal;
	}
	public boolean fp_supportPage()
	{
		boolean retVal=false;
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(fPassword));
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
		wait(Until.elementToBeDisplayed(fPassword));
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
		wait(Until.elementToBeDisplayed(fCharterId));
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
		wait(Until.elementToBeDisplayed(fCharterId));
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
		wait(Until.elementToBeDisplayed(CreateID));
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
	//	type(cIDFirstname,firstname_CID);
		type(cIDlastname,lastname_CID);
		type(CIDAddressfield,Address_CID);
		type(cIDZipcode,Zipcode_CID);
		type(cIDMAC,MAC_CID);
		clickOnElement(cIDNextbtn);
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
		hp.loadCharterPage(URL);
		hp.login(charterID, password);
		hp.pagewait();
		hp.logoutApplication();

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
	public void createuser_HOH(String firstname_CID,String lastname_CID,String Address_CID,String Zipcode_CID,String MAC_CID,String charterID, String password, String email,String security_question, String security_answer) throws Exception
	{

		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(CreateID));
		clickOnElement(CreateID);
		//type(cIDFirstname,firstname_CID);
		type(cIDlastname,lastname_CID);
		type(CIDAddressfield,Address_CID);
		type(cIDZipcode,Zipcode_CID);
		type(cIDMAC,MAC_CID);
		//clickOnElement(PrimaryACCHolder);
		WebElement primaryaccholder = driver.findElement(By.xpath("/html/body/div[1]/section/div/section/div[2]/div/div/div[2]/div[1]/form/div/div[2]/div/div[6]/label"));
		primaryaccholder.click();
		clickOnElement(cIDNextbtn);
		type(cIDFirstname,firstname_CID);
		type(wecharterID,charterID);
		type(wepassword,password);
		type(weconfirmpassword,password);
		type(weemail,email);
		selectValueFromDropDown(wesecurityQuestion,security_question);
		type(wesecurityAnswer,security_answer);
		clickOnElement(cbterms);

		clickOnElement(btncreateUsername);
		if(isElementPresent(msgCreation)){
			screenshot.saveScreenshot("Add User"+ File.separator + "You have successfully created your Charter ID");
		}
		else{
			screenshot.saveScreenshot("Add User"+ File.separator + "Charter ID is not created");
		}
		clickOnElement(DoneButton);
		HomePage hp= new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(charterID, password);
		hp.pagewait();
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
	
	public boolean FID_Non_Converted_MS_Login(String password,String security_answer,String lastname_fID,String address_fID,String zipcode_fID,String mac_fID,String fLinkCID,String AccountNumberVerify,String ACnumber){
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
	
	public boolean FID_FU_ValidateEmail(String password,String security_answer,String lastname_fID,String address_fID,String zipcode_fID,String mac_fID,String fLinkCID,String AccountNumberVerify,String ACnumber){
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
		WebElement dr = driver.findElement(By.xpath("/html/body/div[1]/section/div/section/div/div/div/div/div/div/basic-form/form/a"));
		dr.click();
		WebElement rb = driver.findElement(By.xpath("/html/body/div[1]/section/div/section/div/div/div/div/ui-view/div/div/get-code-form/form/div[2]/div/label"));
		rb.click();
		WebElement sv = driver.findElement(By.xpath("/html/body/div[1]/section/div/section/div/div/div/div/ui-view/div/div/get-code-form/form/div[4]/input"));
		sv.click();
		driver.get("https://www.gmail.com/intl/en/mail/help/about.html");
		WebElement signinlink = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/a[1]"));
		signinlink.click();
		WebElement uname = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/form/div[1]/div/div[1]/div/div/input[1]"));
		uname.sendKeys("ramana2006@gmail.com");
		WebElement nextbtn = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/form/div[1]/div/input"));
		nextbtn.click();
		WebElement pwd = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/form/div[2]/div/div[2]/div/div/input[2]"));
		pwd.sendKeys("09Raman@");
		WebElement signbtn = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/form/div[2]/div/input[1]"));
		signbtn.click();
		
		
		
		
		//type(fpSecurityAnswer,security_answer);
		//clickOnElement(FURBNextButton);
		//WebElement FID=driver.findElement(By.xpath("//p[@class='username-result semibold view-username-text ng-binding']"));
		//String FIDName=FID.getText();
		//clickOnElement(Fusigninbtn);
		//	type(FID_user11,FIDName);
		//type(FID_pw1,password);
		//clickOnElement(submitSignin);
		retVal=true;
		return retVal;
	}
	
	public boolean FID_Non_Converted_HOH(String password,String security_answer,String lastname_fID,String address_fID,String zipcode_fID,String mac_fID,String fLinkCID,String AccountNumberVerify,String ACnumber){
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


	public String invalid_Zip_Message(){

		System.out.println(getText(CID_ZipcodeError));
		return getText(CID_ZipcodeError);
	}
	public boolean invalid_ZIP_CID(String firstname_CID,String lastname_CID,String Address_CID,String invalidZipcode,String MAC_CID){

		boolean retVal=false;
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(CreateID));
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
		wait(Until.elementToBeDisplayed(CreateID));
		clickOnElement(CreateID);
		type(cIDlastname,lastname_CID);
		type(CIDAddressfield,invalidAddress);
		type(cIDZipcode,Zipcode_CID);
		type(cIDMAC,MAC_CID);
		if(isElementPresent(AddressR)&(isElementPresent(Address1R))&(isElementPresent(Address2R))){
			System.out.println(getText(AddressR));
			System.out.println(getText(Address1R));
			System.out.println(getText(Address2R));
			retVal=true;
		}
		return retVal;
	}
	public boolean Service_Address_mismatch(String firstname_CID,String lastname_CID,String invalidAddress,String Zipcode_CID,String MAC_CID){

		boolean retVal=false;
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(CreateID));
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
		wait(Until.elementToBeDisplayed(CreateID));
		clickOnElement(CreateID);
		type(cIDFirstname,firstname_CID);
		type(cIDlastname,lastname_CID);
		type(CIDAddressfield,Address_CID);
		type(cIDZipcode,Zipcode_CID);
		type(cIDMAC,MAC_CID);
		clickOnElement(cIDNextbtn);
		if(isElementPresent(Proceedbtn)){
			clickOnElement(Proceedbtn);
		}
		if(isElementPresent(captcha)){
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
		wait(Until.elementToBeDisplayed(fCharterId));
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

		if(isElementPresent(SecAnsErrorMSG)){
			retVal=true;
			System.out.println(getText(SecAnsErrorMSG));
		}

		return retVal;
	}

	public boolean ZipCode_ErrorMsg(String invalidZipcode,String AccountNumberVerify,String ACnumber){

		boolean retVal=false;
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(fCharterId));
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
		wait(Until.elementToBeDisplayed(fCharterId));
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
		wait(Until.elementToBeDisplayed(fCharterId));
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
		wait(Until.elementToBeDisplayed(fCharterId));
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
		wait(Until.elementToBeDisplayed(fCharterId));
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
		wait(Until.elementToBeDisplayed(fPassword));
		clickOnElement(fPassword);
		type(fpCharterId,CharterID_fp);
		type(fpZip,Zipcode_fp);
		clickOnElement(fpNextBtn);
		type(fpSecurityAnswer,security_answer);
		clickOnElement(fpNextBtn);
		type(fpNewPassword,password);
		type(fpConfirmNewPassword,invalidPassword);
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


	public boolean fp_invalidzipcode(String CharterID_fp,String lastname_fp,String invalidZipcode){

		boolean retVal=false;
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(fPassword));
		clickOnElement(fPassword);
		type(fpCharterId,CharterID_fp);
		type(fpZip,invalidZipcode);
		clickOnElement(fpNextBtn);
		if(isElementPresent(InvalidMsg)){
			retVal=true;
			System.out.println(getText(InvalidMsg));
		}
		return retVal;
	}

	public boolean fp_pwdresetsuccess(String password,String CharterID_fp,String lastname_fp,String Zipcode_fp,String security_answer){

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
		wait(Until.elementToBeDisplayed(fPassword));
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
		wait(Until.elementToBeDisplayed(fPassword));
		clickOnElement(fPassword);
		clickOnElement(fpCharterId);
		WebElement charteridmissed = driver.findElement(By.xpath("/html/body/div[1]/section/div/section/div/div/div/form/div[1]/div/div/div/span"));
		System.out.println(charteridmissed.getText());
		clickOnElement(fp_lastname);
		WebElement lastnamemissed = driver.findElement(By.xpath("/html/body/div[1]/section/div/section/div/div/div/form/div[2]/div/div/div/span"));
		System.out.println(lastnamemissed.getText());
		clickOnElement(fpZip);
		WebElement zipcodemissed = driver.findElement(By.xpath("/html/body/div[1]/section/div/section/div/div/div/form/div[3]/div/div/div/span"));
		System.out.println(zipcodemissed.getText());
		clickOnElement(fpCharterId);
		if(!isElementEnabled((fpNextBtn))){
			retVal=true;
		}
		return retVal;
	}

	public boolean fId_missedfieldsmessages(String AccountNumberVerify,String ACnumber, String aCnumber2){

		boolean retVal=false;
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(fCharterId));
		clickOnElement(fCharterId);
		clickOnElement(fID_Zipcode);
		selectValueFromDropDown(SelecttoVerify,AccountNumberVerify);
		type(InfoField,ACnumber);
		clickOnElement(FUNextbtn);
		if(isElementPresent(ErrorMessage)){
			retVal=true;
		}
		return retVal;
	}

	public boolean CreateID_missedfieldsmessages(){

		boolean retVal=false;
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(CreateID));
		clickOnElement(CreateID);
	//	clickOnElement(cIDFirstname);
	//	type(cIDFirstname,"");
		clickOnElement(cIDlastname);
		type(cIDlastname,"");
		clickOnElement(CIDAddressfield);
		type(CIDAddressfield,"");
		clickOnElement(cIDZipcode);
		type(cIDZipcode,"");
		clickOnElement(cIDMAC);
		clickOnElement(cIDZipcode);
		type(cIDMAC,"");

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
		wait(Until.elementToBeDisplayed(CreateID));
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
			retVal=true;
		}
		return retVal;
	}
	public boolean invalid_Mac_CID(String firstname_CID,String lastname_CID,String Address_CID,String Zipcode_CID,String invalidMAC){

		boolean retVal=false;
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(CreateID));
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
		wait(Until.elementToBeDisplayed(CreateID));
		clickOnElement(CreateID);
//		type(cIDFirstname,firstname_CID);
		type(cIDlastname,invalidLastname);
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
		wait(Until.elementToBeDisplayed(CreateID));
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
		wait(Until.elementToBeDisplayed(CreateID));
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


	public boolean fid_successfultqmessage(String security_answer,String zipcode_fID,String fLinkCID,String AccountNumberVerify,String ACnumber){

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
		if(isElementPresent(FIDMessage)){
			System.out.println(getText(FIDMessage));
			retVal=true;	
		}

		return retVal;
	}

	public boolean fp_helpicons(String password,String CharterID_fp,String lastname_fp,String Zipcode_fp,String security_answer){

		boolean retVal=false;
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(fPassword));
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

	public boolean ValidLogin(String username,String password){
		boolean retVal = false;
		driver.manage().deleteAllCookies();
		clickOnElement(SignInLink);
		type(Username,username);
		type(PasswordPlaceHolder,password);
		clickOnElement(btnSignin);
		WebElement loginvalidationtxt = driver.findElement(By.id("logout-header-btn"));
		System.out.println(loginvalidationtxt.getText());
		//clickOnElement(lnkAccount);
		//clickOnElement(weSignOut);
		//WebElement signout = driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div[1]/ul[1]/li[2]/form/button"));
		//signout.click();
		//System.out.println("User Logged Out Successfully");
		driver.manage().deleteAllCookies();
		driver.quit();
		retVal = true;
		return retVal;
	}

	public boolean InValidLogin(String username,String password){
		boolean retVal = false;
		driver.manage().deleteAllCookies();
		clickOnElement(SignInLink);
		type(Username,username);
		type(PasswordPlaceHolder,password);
		clickOnElement(btnSignin);
		WebElement errormessage = driver.findElement(By.xpath("/html/body/div[1]/section/div[3]/div[2]/div/section/form/div/div[1]/div/section/ul/li[3]/div/span"));
		System.out.println(errormessage.getText());
		retVal = true;
		return retVal;
	}

	public void fp_CreateIDPage() throws Exception{
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(fPassword));
		clickOnElement(fPassword);
		HomePage hp=new HomePage(driver);
		hp.pagewait();
	}
}
