package com.charter.page;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cognizant.framework.ajax.Until;
import com.cognizant.framework.core.CaptureScreenshot;
import com.cognizant.framework.core.ObjectLocators;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.WebDriverBase;
import com.cognizant.framework.exception.BrowserBotException;

public class UserPreferencePage extends WebDriverBase{

	private static String btnAddUser=ReadFromExcel.getLocator("UPPage", "btnAddUser");
	private static String Firstname= ReadFromExcel.getLocator("HomePage", "cIDFirstname");
	private static String weLastName=ReadFromExcel.getLocator("UPPage", "weLastName");
	private static String wecharterID=ReadFromExcel.getLocator("UPPage", "wecharterID");
	private static String wepassword=ReadFromExcel.getLocator("UPPage", "wepassword");
	private static String weconfirmpassword=ReadFromExcel.getLocator("UPPage", "weconfirmpassword");
	private static String weemail=ReadFromExcel.getLocator("UPPage", "weemail");
	private static String wesecurityQuestion=ReadFromExcel.getLocator("UPPage", "wesecurityQuestion");
	private static String wesecurityAnswer=ReadFromExcel.getLocator("UPPage", "wesecurityAnswer");
	private static String cbterms=ReadFromExcel.getLocator("UPPage", "cbterms");
	private static String btnNext=ReadFromExcel.getLocator("UPPage", "btnNext");
	private static String msgCreation=ReadFromExcel.getLocator("UPPage", "msgCreation");
	private static String Myaccounttest=ReadFromExcel.getLocator("HomePage", "Myaccounttest");
	private static String weSignOut=ReadFromExcel.getLocator("HomePage", "weSignOut");
	private static String SignInLink=ReadFromExcel.getLocator("HomePage", "SignIn");
	private static String Username=ReadFromExcel.getLocator("HomePage", "username");
	private static String PasswordPlaceHolder=ReadFromExcel.getLocator("HomePage", "password_placeholder");
	private static String Password=ReadFromExcel.getLocator("HomePage", "password");
	private static String btnSignin=ReadFromExcel.getLocator("HomePage", "btnSignin");
	private static String btnDeleteUser=ReadFromExcel.getLocator("UPPage", "btnDeleteUser");
	private static String btnModalOk=ReadFromExcel.getLocator("UPPage", "btnModalOk");

	private static String parentalctrlbtn=ReadFromExcel.getLocator("UPPage", "parentalctrlbtn");
	private static String tvlabel=ReadFromExcel.getLocator("UPPage", "tvlabel");
	private static String TV_Y=ReadFromExcel.getLocator("UPPage", "TV_Y");
	private static String TV_7=ReadFromExcel.getLocator("UPPage", "TV_7");
	private static String TV_7_FV=ReadFromExcel.getLocator("UPPage", "TV_7_FV");
	private static String TV_G=ReadFromExcel.getLocator("UPPage", "TV_G");
	private static String TV_PG=ReadFromExcel.getLocator("UPPage", "TV_PG");
	private static String TV_14=ReadFromExcel.getLocator("UPPage", "TV_14");
	private static String TV_MA=ReadFromExcel.getLocator("UPPage", "TV_MA");

	private static String movielabel=ReadFromExcel.getLocator("UPPage", "movielabel");
	private static String weG=ReadFromExcel.getLocator("UPPage", "weG");
	private static String wePG=ReadFromExcel.getLocator("UPPage", "wePG");
	private static String wePG_13=ReadFromExcel.getLocator("UPPage", "wePG_13");
	private static String weR=ReadFromExcel.getLocator("UPPage", "weR");
	private static String weNC_17=ReadFromExcel.getLocator("UPPage", "weNC_17");

	private static String allowUnratedlabel=ReadFromExcel.getLocator("UPPage", "allowUnratedlabel");
	private static String unratedYes=ReadFromExcel.getLocator("UPPage", "unratedYes");
	private static String unratedNo=ReadFromExcel.getLocator("UPPage", "unratedNo");
	private static String parentalsavBtn=ReadFromExcel.getLocator("UPPage", "parentalsavBtn");

	private static String accountctrlPlusbtn=ReadFromExcel.getLocator("UPPage", "accountctrlPlusbtn");
	private static String chkboxHOH=ReadFromExcel.getLocator("UPPage", "chkboxHOH");
	private static String chkboxAdmin=ReadFromExcel.getLocator("UPPage", "chkboxAdmin");
	private static String chkboxStandard=ReadFromExcel.getLocator("UPPage", "chkboxStandard");
	private static String accountCtrlsavebtn=ReadFromExcel.getLocator("UPPage", "accountCtrlsavebtn");
	private static String pomYes=ReadFromExcel.getLocator("UPPage", "pomYes");
	private static String pomNo=ReadFromExcel.getLocator("UPPage", "pomNo");

	private static String dvrYes=ReadFromExcel.getLocator("UPPage", "dvrYes");
	private static String dvrNo=ReadFromExcel.getLocator("UPPage", "dvrNo");
	private static String role=ReadFromExcel.getLocator("UPPage", "role");
	private static String btnOK=ReadFromExcel.getLocator("UPPage", "btnOK");
	private static String IDHelpicon=ReadFromExcel.getLocator("UPPage", "IDHelpicon");

	private static String BAEditbtn=ReadFromExcel.getLocator("UPPage", "BAEditbtn");
	private static String weAddress1=ReadFromExcel.getLocator("BTPage", "weAddress1");
	private static String weAddress2=ReadFromExcel.getLocator("BTPage", "weAddress2");
	private static String weCityField=ReadFromExcel.getLocator("BTPage", "weCityField");
	private static String weStateCode=ReadFromExcel.getLocator("BTPage", "weStateCode");
	private static String weZipCode=ReadFromExcel.getLocator("BTPage", "weZipCode");
	private static String btSavee=ReadFromExcel.getLocator("BTPage", "btSavee");
	private static String weBillAddress=ReadFromExcel.getLocator("OverviewPage", "weBillAddress");
	private static String BtnOK=ReadFromExcel.getLocator("BTPage", "BtnOK");
	private static String Askcharter=ReadFromExcel.getLocator("UPPage","Askcharter");

	private static String NpwEditbtn=ReadFromExcel.getLocator("UPPage","NpwEditbtn");
	private static String NewPW=ReadFromExcel.getLocator("UPPage","NewPW");
	private static String ConfirmPW=ReadFromExcel.getLocator("UPPage","ConfirmPW");
	private static String MismatchError=ReadFromExcel.getLocator("UPPage","MismatchError");
	private static String ContactEmail=ReadFromExcel.getLocator("UPPage","ContactEmail");
	private static String SecurityQuestion=ReadFromExcel.getLocator("UPPage","SecurityQuestion");
	private static String SecurityAnswer=ReadFromExcel.getLocator("UPPage","SecurityAnswer");
	private static String ContactEmailEditBtn=ReadFromExcel.getLocator("UPPage","ContactEmailEditBtn");
	private static String ContactPhoneEditBtn=ReadFromExcel.getLocator("UPPage","ContactPhoneEditBtn");
	private static String SecurityQEditBtn=ReadFromExcel.getLocator("UPPage","SecurityQEditBtn");
	private static String AccountInfoSaveButton=ReadFromExcel.getLocator("UPPage","AccountInfoSaveButton");
	private static String SecurityQSaveBtn=ReadFromExcel.getLocator("UPPage","SecurityQSaveBtn");
	private static String AccountChelpicon=ReadFromExcel.getLocator("UPPage","AccountChelpicon");
	private static String ParentalChelpicon=ReadFromExcel.getLocator("UPPage","ParentalChelpicon");
	private static String EmailChelpicon=ReadFromExcel.getLocator("UPPage","EmailChelpicon");
	private static String EmailCplusBtn=ReadFromExcel.getLocator("UPPage","EmailCplusBtn");
	private static String BMAlabel=ReadFromExcel.getLocator("UPPage","BMAlabel");
	private static String OMlabel=ReadFromExcel.getLocator("UPPage","OMlabel");
	private static String Eflabel=ReadFromExcel.getLocator("UPPage","Eflabel");
	private static String EmailSavebtn=ReadFromExcel.getLocator("UPPage","EmailSavebtn");
	private static String MarketingplusBtn=ReadFromExcel.getLocator("UPPage","MarketingplusBtn");
	private static String Marketinghelpicon=ReadFromExcel.getLocator("UPPage","Marketinghelpicon");
	private static String MarketingLink=ReadFromExcel.getLocator("UPPage","MarketingLink");
	private static String AdvertisingLink=ReadFromExcel.getLocator("UPPage","AdvertisingLink");
	private static String DoneButton=ReadFromExcel.getLocator("CreateID", "DoneButton");
	//********* Ayesha ***********//
	private static String UserPreferencesHeader=ReadFromExcel.getLocator("UPPage", "UserPreferencesHeader");
	private static String AccountControlsHeader=ReadFromExcel.getLocator("UPPage", "AccountControlsHeader");
	private static String ParentalControlHeader=ReadFromExcel.getLocator("UPPage", "ParentalControlHeader");
	private static String EmailControlsHeader=ReadFromExcel.getLocator("UPPage", "EmailControlsHeader");
	private static String MAHeader=ReadFromExcel.getLocator("UPPage", "MAHeader");

	private static String FooterTV=ReadFromExcel.getLocator("MAPage","FooterTV");
	private static String FooterMA=ReadFromExcel.getLocator("MAPage","FooterMA");
	private static String FooterSupport=ReadFromExcel.getLocator("MAPage","FooterSupport");
	private static String Mobilephone=ReadFromExcel.getLocator("CreateID","Mobilephone");
	
	CaptureScreenshot<WebDriver> screenshot;
	public UserPreferencePage(WebDriver driver) {
		this.driver=driver;
		screenshot= new CaptureScreenshot<WebDriver>(driver);
	}


	public void WindowHandles(){

		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
			if(!windowHandle.equals(parentWindow))
			{
				driver.switchTo().window(windowHandle);
				sleep(5);
				driver.close(); //closing child window
				driver.switchTo().window(parentWindow);//cntrl to parent window
				sleep(3);
			}
		}
	}
	public void add_User(String lastname,String charterID,String password, String email,String security_question,String security_answer,String phone){

		sleep(4);
		clickOnElement(btnAddUser);
		type(Firstname,charterID);
/*		if(isElementVisible(weLastName)){
		type(weLastName, lastname);
		}*/
		type(wecharterID,charterID);
		type(wepassword,password);
		type(weconfirmpassword,password);
		type(weemail,email);
		type(Mobilephone,phone);
		selectValueFromDropDown(wesecurityQuestion,security_question);
		type(wesecurityAnswer,security_answer);
		clickOnElement(cbterms);
		clickOnElement(btnNext);
		if(isElementPresent(msgCreation)){
			System.out.println(getText(msgCreation));
		}
		sleep(10);
		clickOnElement(DoneButton);
		sleep(10);
		clickOnElement(Myaccounttest);
		refreshPage();
	}
	
	public void checkBilling(){ 
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if(isElementPresent("xpath;//*[contains(@cc-crumb,'Footer')][contains(text(),'Billing')]"))
			System.out.println("Billing section is available for the user");
		else 
			System.out.println("Billing section is not available for the user");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	public void relogin_with_added_user(String charterID,String password){

		//clickOnElement(lnkAccount);
		wait(Until.elementToBeDisplayed(weSignOut));
		clickOnElement(weSignOut);
		clickOnElement(SignInLink);
		type(Username, charterID);
		clickOnElement(PasswordPlaceHolder);
		type(Password, password);
		clickOnElement(btnSignin);

	}
	public void DeleteisVisible(){

		if(isElementVisible(btnDeleteUser)){
			System.out.println("Delete button is not visible  for logged in User");
		}

		else{

			System.out.println("Delete button is visible for logged in User");
		}
	}
	
	public enum userType{
		role,username
	}

	public void selectuser(userType selectiontype,String user){
		sleep(10);

		String userlistlocator = "xpath;//div[contains(@class,'user-pref-carousel')]/div[1]/img";//"xpath;//div[contains(@class,'user-pref-carousel')]/div[1]/ul/li";
		String outercontainer = "xpath;//*[contains(@class,'user-carousel-container')]";//"xpath;//div[contains(@class,'user-pref-carousel')]/div[1]";

		int usercount = driver.findElements(ObjectLocators.getBySelector(userlistlocator)).size();

		String userToSelect="";
		switch(selectiontype){
		case role:
			userToSelect = "xpath;//div[contains(@class,'user-pref-carousel')]/div[contains(@class,'user-avatar')]/p/span[text()='"+user+"']";//"xpath;//div[contains(@class,'user-pref-carousel')]/div[1]/ul/li//div[contains(@class,'user-avatar')]/p/span[text()='"+user+"']";
			break;
		case username:
			userToSelect = "xpath;//div[@id='users-carousel']/div/ul/li/div/div/div/p[text()='" + user + "']";
			break;
		}

		WebElement outerelm = driver.findElement(ObjectLocators.getBySelector(outercontainer));
		Point p1 = outerelm.getLocation();
		Dimension size = outerelm.getSize();
		WebElement userelm = driver.findElement(ObjectLocators.getBySelector(userToSelect));
		Point p2 = userelm.getLocation();
		System.out.println(p1);
		System.out.println(size.toString());
		System.out.println(p2);
		int loopcounter = 0;
		while(true){
			if(p2.x > p1.x + size.width){
				clickOnElement("xpath;//button/i[@class='ccicon ccicon-chevron-right-fill']");
			}else if (p2.x < p1.x){
				clickOnElement("xpath;//button/i[@class='ccicon ccicon-chevron-left-fill']");
			}else{
				if (isElementVisible(userToSelect)) {
					System.out.println(userToSelect);
					clickOnElement(userToSelect);
					System.out.println("user selected");
					//screenshot.saveScreenshot("Select User"+ File.separator + "User is selected");

				}else{
					throw new BrowserBotException("Unable to select the user");
				}
				break;
			}
			sleep(2);
			userelm = driver.findElement(ObjectLocators.getBySelector(userToSelect));
			p2 = userelm.getLocation();
			if(++loopcounter > usercount){
				throw new BrowserBotException("Unable to select the user");
			}
		}

	}
	
	public boolean deleteUser(String user){
		boolean retVal = false;
		if(isElementPresent("xpath;//*[text()='"+user+"']/../..//button[text()='Delete user']")){
			clickOnElement("xpath;//*[text()='"+user+"']/../..//button[text()='Delete user']");
		}
		sleep(2);
		clickOnElement(btnModalOk);
		sleep(5);
		retVal = true;
		return retVal;
	}

	public void select_PC_TV(String PC_TV){

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		clickOnElement("xpath;.//*[@id='toggle-btn']");
		sleep(3);
		if(PC_TV.equalsIgnoreCase("TV_Y"))
		{
			clickOnElement(TV_Y);
		}

		if(PC_TV.equalsIgnoreCase("TV_7"))
		{
			clickOnElement(TV_7);
		}
		if(PC_TV.equalsIgnoreCase("TV_7_FV")){
			clickOnElement(TV_7_FV);
		}
		if(PC_TV.equalsIgnoreCase("TV_G"))
		{
			clickOnElement(TV_G);
		}
		if(PC_TV.equalsIgnoreCase("TV_PG"))
		{
			clickOnElement(TV_PG);
		}
		if(PC_TV.equalsIgnoreCase("TV_14"))
		{
			clickOnElement(TV_14);
		}
		if(PC_TV.equalsIgnoreCase("TV_MA"))
		{
			clickOnElement(TV_MA);
		}
		return;
	}


	public void Select_PC_Movie(String PC_Movie){

		sleep(3);
		if(PC_Movie.equalsIgnoreCase("G"))
		{
			clickOnElement(weG);
		}

		if(PC_Movie.equalsIgnoreCase("PG"))
		{
			clickOnElement(wePG);
		}

		if(PC_Movie.equalsIgnoreCase("PG-13"))
		{
			clickOnElement(wePG_13);
		}

		if(PC_Movie.equalsIgnoreCase("R"))
		{
			clickOnElement(weR);
		}

		if(PC_Movie.equalsIgnoreCase("NC-17"))
		{
			clickOnElement(weNC_17);
		}
		sleep(5);
		clickOnElement("xpath;(.//*[@id='save-btn-input'])[2]");
		sleep(5);
		clickOnElement(BtnOK);
		sleep(5);
		return;
	}
	
	public void selectAllowUnratedContent(String PC_Unratedcontent){
		wait(Until.elementToBeDisplayed(allowUnratedlabel));
		sleep(3);
		if(PC_Unratedcontent.equalsIgnoreCase("Yes")){
			clickOnElement(unratedYes);
		}
		if(PC_Unratedcontent.equalsIgnoreCase("No")){
			clickOnElement(unratedNo);
		}
		if(isElementPresent(parentalsavBtn)){
			clickOnElement(parentalsavBtn);
		}
		if(isElementPresent(parentalsavBtn)){
			clickOnElement(parentalctrlbtn);
		}
		clickOnElementUsingJavaScript(BtnOK);

	}


	public void Promote_Selected_User(String Account_Type){
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//*[text()='Account Controls']")));
		sleep(5);
		clickOnElement(accountctrlPlusbtn);
		sleep(10);
		if(Account_Type.equalsIgnoreCase("HOH")){
			clickOnElement(chkboxHOH);
		}

		if(Account_Type.equalsIgnoreCase("Admin")){		    	
			clickOnElement(chkboxAdmin);
		}

		if(Account_Type.equalsIgnoreCase("Standard")){
			clickOnElement(chkboxStandard);
		}    
		clickOnElement(accountCtrlsavebtn);
		sleep(5);
	}

	public void Demote_Selected_User(String Account_Type){
		sleep(5);
		while(!isElementVisible(chkboxStandard)){
			JavascriptExecutor je = (JavascriptExecutor)driver;
			je.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//*[text()='Account Controls']")));
			sleep(5);
			clickOnElement(accountctrlPlusbtn);
			sleep(5);
		}
		if(Account_Type.equalsIgnoreCase("Standard")){

			sleep(5);
			clickOnElement(chkboxStandard);
		}    
		clickOnElement(accountCtrlsavebtn);
		sleep(5);

	}
	public void VerifyNewuserrole(String NewRole){

		WebElement role=driver.findElement(By.xpath("//div[@class='user-identity ng-scope' ]/descendant::p[@class='role ng-scope']/span"));

		String  nrole=role.getText();

		if(NewRole.equalsIgnoreCase(nrole))  
		{
			System.out.println("New role in app"+role);
			System.out.println("Test data"+NewRole);
		}
		else
		{
			System.out.println("New role in app"+role);
			System.out.println("Test data"+NewRole);
		}
		return;
	}

	public void SelectPOM_AccntControl(String Account_pom){

		clickOnElement(accountctrlPlusbtn);
		sleep(3);
		if(Account_pom.equalsIgnoreCase("Yes")){
			clickOnElement(pomYes);
			//screenshot.saveScreenshot("POM"+ File.separator + "yes Button");
		}

		if(Account_pom.equalsIgnoreCase("No")){
			clickOnElement(pomNo);
			//screenshot.saveScreenshot("POM"+ File.separator + "No Button");
		}

		clickOnElement(accountCtrlsavebtn);
		return;
	}

	public void SelectDVRControl_AccntControl(String Account_DVRcontrol){


		if(Account_DVRcontrol.equalsIgnoreCase("Yes")){

			clickOnElement(dvrYes);
			//screenshot.saveScreenshot("DVR"+ File.separator + "yes Button");

		}

		if(Account_DVRcontrol.equalsIgnoreCase("No")){
			clickOnElement(dvrNo);
			//screenshot.saveScreenshot("DVR"+ File.separator + "No Button");
		}		   	    		
		clickOnElement(accountCtrlsavebtn);

		clickOnElement(accountctrlPlusbtn);
		return;
	}

	public void Relogin(String Relogin_UserID, String Relogin_Password){

		clickOnElement(Myaccounttest);
		clickOnElement(weSignOut);
		//screenshot.saveScreenshot("Relogin"+ File.separator + "SignOut");
		clickOnElement(SignInLink);
		type(Username, Relogin_UserID);
		clickOnElement(PasswordPlaceHolder);
		type(Password, Relogin_Password);
		//screenshot.saveScreenshot("Relogin"+ File.separator + "username and password");
		clickOnElement(btnSignin);
		//screenshot.saveScreenshot("Relogin"+ File.separator + "Logged in with new username and password");

		sleep(5);
	}


	public void IntialRoleverification(String username){


		driver.findElement(By.xpath("//p[contains(text(),'"+username+"')]/../child::img")).click();
		WebElement role=driver.findElement(By.xpath("//div[@class='user-identity ng-scope' ]/descendant::p[@class='role ng-scope']//span[text()='Standard']"));

		String  Initialrole=role.getText();

		if(Initialrole.equalsIgnoreCase("Standard"))  
		{
			System.out.println("Intial role is changed to Standard" + Initialrole + username);
			//screenshot.saveScreenshot("Verification"+ File.separator + "Standard");
		}
		else
		{
			System.out.println("Intial role is not changed to Standard" + Initialrole + username);
		}
	}

	public boolean UP_charterID_helpicon(){

		boolean retVal=false;
		//hoverOver(IDHelpicon);
		if(isElementPresent(IDHelpicon)){
			System.out.println("Charter ID Help Icon in User Preferences displays with Message:"+getText(IDHelpicon));	
			retVal=true;
		}
		return retVal;
	}

	public boolean BillingAddress_Edit(String Address1,String Address2,String City,String State,String Zipcode,String text1,String ACnumber,String URL,String username,String password) throws Exception{

		boolean retVal=false;
		wait(Until.elementToBeClickable(BAEditbtn));
		clickOnElement(BAEditbtn);
		clearTextBox(weAddress1);
		type(weAddress1,Address1);
		clearTextBox(weAddress2);
		type(weAddress2,Address2);
		clearTextBox(weCityField);
		type(weCityField,City);
		selectValueFromDropDown(weStateCode, State);
		clearTextBox(weZipCode);
		type(weZipCode,Zipcode);
		clickOnElementUsingJavaScript(btSavee);
		sleep(5);
		if(isElementVisible("xpath;//*[@class='modal-content']")){
			if(getText("xpath;//*[@class='modal-content']").contains("success"))
				retVal=true;
			clickOnElementUsingJavaScript(BtnOK);
			sleep(5);
		}
		
		AuthenticationPage auth = new AuthenticationPage(driver);
		String text2 = auth.getAccountDetails(ACnumber);		
		HomePage hp = new HomePage(driver);
		hp.loadCharterPage(URL);
		refreshPage();
		hp.login(username, password );
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.loadUPPage();
		clickOnElement(BAEditbtn);
		clearTextBox(weAddress2);
		clickOnElementUsingJavaScript(btSavee);
		sleep(5);
		clickOnElementUsingJavaScript(BtnOK);
		
		if(text1.equalsIgnoreCase(text2))
			System.out.println("Billling address change is not reflected in IDM");
		return retVal;
	}

	public boolean Askcharter_UP(){

		boolean retVal=false;
		if(isElementPresent(Askcharter)){
			retVal=true;
		}
		return retVal;
	}
	public void UP_pw_mismatch_ErrorMessage(){

		clickOnElement(NpwEditbtn);
		type(NewPW,"Testing01");
		type(ConfirmPW,"Testing");

	}
	public boolean PWErrorMsg(){

		boolean retVal=false;
		if(isElementPresent(MismatchError)){
			System.out.println(getText(MismatchError));	
			retVal=true;
		}

		return retVal;
	}


	public boolean EditContactFields_UP(String password,String email,String security_question,String security_answer){
		boolean retVal = false;
		sleep(5);
		wait(Until.elementToBeClickable(NpwEditbtn));
		clickOnElement(NpwEditbtn);
		type(NewPW,password);
		type(ConfirmPW,password);
		wait(Until.elementToBeClickable(ContactEmailEditBtn));
		clickOnElement(ContactEmailEditBtn);
		clearTextBox(ContactEmail);
		type(ContactEmail,email);
		wait(Until.elementToBeClickable(SecurityQEditBtn));
		clickOnElement(SecurityQEditBtn);
		selectValueFromDropDown(SecurityQuestion, security_question);
		type(SecurityAnswer,security_answer);
		wait(Until.elementToBeClickable(AccountInfoSaveButton));
		clickOnElement(AccountInfoSaveButton);
		retVal = true;
		return retVal;
	}
	public boolean AccountControlsSection(){

		boolean retVal=false;
		//hoverOver(AccountChelpicon);
		System.out.println(getText(AccountChelpicon));
		wait(Until.elementToBeClickable(accountctrlPlusbtn));
		clickOnElement(accountctrlPlusbtn);
		clickOnElement(chkboxAdmin);
		System.out.println("User is able to select Admin");
		clickOnElement(chkboxStandard);
		System.out.println("User is able to select Standard");
		clickOnElement(chkboxHOH);
		System.out.println("User is able to select HOH");
		clickOnElement(accountCtrlsavebtn);
		if(isElementPresent(btnOK))
		{
			clickOnElement(btnOK);
		}
		HomePage hp=new HomePage(driver);
		hp.pagewait();
		retVal=true;
		return retVal;
	}

	public boolean ParentalSection(){

		boolean retVal=false;
		//hoverOver(ParentalChelpicon);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//h1[text()='Parental Controls ']/a[1]")));
		System.out.println(getText(ParentalChelpicon));
		wait(Until.elementToBeClickable(parentalctrlbtn));
		clickOnElement(parentalctrlbtn);
		if(isElementPresent(tvlabel)){
			System.out.println("TV label is present in TV Section");
		}
		clickOnElement(TV_MA);
		if(isElementPresent(movielabel)){
			System.out.println("Movie Label is present in Movies Section");
		}
		clickOnElement(weR);
		clickOnElement(weNC_17);

		if((isElementPresent(unratedYes)) && ((isElementPresent(unratedNo)) && (isElementPresent(parentalsavBtn)))){
			retVal=true;
		}
		return retVal;
	}

	public boolean EmailSection(String username){

		boolean retVal=false;
		//hoverOver(EmailChelpicon);
		if(isElementVisible(EmailChelpicon)){
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//h1[contains(text(),'Email Parental Controls')]/a[1]")));
			System.out.println(getText(EmailChelpicon));
			wait(Until.elementToBeClickable(EmailCplusBtn));
			clickOnElement(EmailCplusBtn);
			sleep(10);
			if(isElementPresent(BMAlabel)){
				System.out.println("Blocked Mail Actions label is present in Email Controls:"+ getText(BMAlabel));
			}
	
			if(isElementPresent(OMlabel)){
				System.out.println("Other Mail label is present in Email Controls:"+getText(OMlabel));
			}
	
			if(isElementPresent(Eflabel)){
				System.out.println("Enable mails for this user label is present in Email Controls:" +getText(Eflabel));
			}
			type("xpath;.//*[@id='AllowedSenders']",username+"@charter.net; *@gmail.com");
			type("xpath;.//*[@id='BlockedSenders']",username+"@charter.net; *@gmail.com");
			setCheckBox("xpath;//*[contains(text(),'Delete emails from blocked senders')]",true);
			sleep(5);
			setCheckBox("xpath;//*[contains(text(),'Forward blocked email to the Head of Household')]", true);
			sleep(5);
			setCheckBox("xpath;//*[contains(text(),'Deliver all other email')]", true);
			sleep(5);
			setCheckBox("xpath;//*[contains(text(),'Delete all other email')]", true);
			sleep(10);
			clickOnElement("xpath;(.//*[@id='save-btn-input'])[3]");
			sleep(5);
			wait(Until.elementToBeInvisible("xpath;(.//*[@id='save-btn-input'])[3]"));
			wait(Until.elementToBeClickable(EmailCplusBtn));
			clickOnElement(EmailCplusBtn);
			//Navigating to Home page
			clickOnElement("xpath;//*[@class='navbar-brand']");
			HomePage hp = new HomePage(driver);
			hp.pagewait();
			MyAccountPage MAPage=new MyAccountPage(driver);
			MAPage.loadUPPage();
			je.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//h1[contains(text(),'Email Parental Controls')]/a[1]")));
			//Minimize the section
			wait(Until.elementToBeClickable(EmailCplusBtn));
			clickOnElement(EmailCplusBtn);
			//Checking the saved contents
			if(driver.findElement(By.id("AllowedSenders")).getAttribute("value").contains(username+"@charter.net; *@gmail.com")){
				System.out.println("Allowed Senders Email is saved");
			}
			
			if(driver.findElement(By.id("BlockedSenders")).getAttribute("value").contains(username+"@charter.net; *@gmail.com")){
				System.out.println("Blocked Senders Email is saved");
			}
			
			clearTextBox("xpath;.//*[@id='AllowedSenders']");
			clearTextBox("xpath;.//*[@id='BlockedSenders']");
			sleep(10);
			clickOnElement("xpath;(.//*[@id='save-btn-input'])[3]");
			wait(Until.elementToBeInvisible("xpath;(.//*[@id='save-btn-input'])[3]"));
			retVal=true;
		}
		else{
			System.out.println("Email Section is not available for Standard user");
		}
		return retVal;
	}
	
	public void testtext(String username){
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//h1[contains(text(),'Email Parental Controls')]/a[1]")));
		System.out.println(getText(EmailChelpicon));
		wait(Until.elementToBeClickable(EmailCplusBtn));
		clickOnElement(EmailCplusBtn);
		type("xpath;.//*[@id='AllowedSenders']",username+"@charter.net; *@gmail.com");
		clickOnElement("xpath;(.//*[@id='save-btn-input'])[3]");
		sleep(10);
		System.out.println(driver.findElement(By.id("AllowedSenders")).getAttribute("value"));
	}

	public boolean MarketingSection(){

		boolean retVal=false;
		//hoverOver(Marketinghelpicon);
		System.out.println(getText(Marketinghelpicon));
		wait(Until.elementToBeClickable(MarketingplusBtn));
		clickOnElement(MarketingplusBtn);
		wait(Until.elementToBeClickable(MarketingLink));
		clickOnElement(MarketingLink);
		System.out.println(driver.getCurrentUrl());
		WindowHandles();
		wait(Until.elementToBeClickable(AdvertisingLink));
		clickOnElement(AdvertisingLink);
		System.out.println(driver.getCurrentUrl());
		WindowHandles();
		retVal=true;
		return retVal;
	}

	//************* Ayesha *************//
	public boolean UserPreferencesHeaders(){
		boolean retVal=false;
		if(isElementPresent(UserPreferencesHeader)&(isElementPresent(AccountControlsHeader)&(isElementPresent(ParentalControlHeader)&(isElementPresent(EmailControlsHeader)
				&(isElementPresent(MAHeader)&(isElementPresent(FooterTV))&(isElementPresent(FooterMA))&(isElementPresent(FooterSupport)))))))
		{
			retVal=true;
		}
		return retVal;
	}
	
	public void AccountControls(){
		driver.findElement(By.xpath("//p[@class='role ng-scope']/span[contains(text(),'Head of Household')]")).click();
		clickOnElement(AccountControlsHeader);
		setCheckBox(chkboxAdmin, true);
		setCheckBox(chkboxStandard, true);
		setCheckBox(chkboxHOH, true);
		setCheckBox(pomNo, true);
		setCheckBox(pomYes, true);
		driver.findElement(By.xpath("//p[@class='role ng-scope']/span[contains(text(),'Admin')]")).click();
		clickOnElement(AccountControlsHeader);
		setCheckBox(chkboxHOH, true);
		setCheckBox(chkboxStandard, true);
		setCheckBox(chkboxAdmin, true);
		setCheckBox(pomNo, true);
		setCheckBox(pomYes, true);
		driver.findElement(By.xpath("(//p[@class='role ng-scope']/span[contains(text(),'Standard')])[1]")).click();
		clickOnElement(AccountControlsHeader);
		setCheckBox(chkboxAdmin, true);
		setCheckBox(chkboxHOH, true);
		setCheckBox(chkboxStandard, true);
		setCheckBox(pomNo, true);
		setCheckBox(pomYes, true);
	}
	
	public boolean EditSecurityQandA(String security_question,String security_answer){
		boolean retVal = false;
		sleep(5);
		wait(Until.elementToBeClickable(SecurityQEditBtn));
		clickOnElement(SecurityQEditBtn);
		selectValueFromDropDown(SecurityQuestion,security_question);
		type(SecurityAnswer,security_answer);
		wait(Until.elementToBeClickable(SecurityQSaveBtn));
		clickOnElement(SecurityQSaveBtn);
		sleep(10);
		retVal = true;
		return retVal;
	}
	
	public void checkAccountUsers(){
		WebElement[] element = new WebElement[7];
		List Users = driver.findElements(By.xpath(".//*[@id='users-carousel']/div[1]/ul/li"));
		
		System.out.println("Number of users "+Users.size());
		for(int i=1;i<=Users.size();i++){
			element[i] = driver.findElement(By.xpath(".//*[@id='users-carousel']/div[1]/ul/li["+i+"]"));
		}
		
		for(int i=1;i<=Users.size();i++){
			System.out.println(driver.findElement(By.xpath(".//*[@id='users-carousel']/div[1]/ul/li["+i+"]")).getText());
		}
	}

}



