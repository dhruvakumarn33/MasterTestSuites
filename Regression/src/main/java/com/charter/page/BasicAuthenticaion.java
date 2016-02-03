package com.charter.page;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.cognizant.framework.ajax.Until;
import com.cognizant.framework.core.CaptureScreenshot;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.WebDriverBase;

public class BasicAuthenticaion extends WebDriverBase{


	private static String BasicLogin=ReadFromExcel.getLocator("HomePage", "BasicLogin");
	private static String BasicCreateID=ReadFromExcel.getLocator("HomePage", "BasicCreateID");
	private static String createIDHeader=ReadFromExcel.getLocator("HomePage", "createIDHeader");
	private static String BasicForgotUsername=ReadFromExcel.getLocator("HomePage", "BasicForgotUsername");
	private static String ForgotIDHeader=ReadFromExcel.getLocator("HomePage", "ForgotIDHeader");
	private static String BasicForgotPassword=ReadFromExcel.getLocator("HomePage", "BasicForgotPassword");
	private static String ForgotPWHeader=ReadFromExcel.getLocator("HomePage", "ForgotPWHeader");
	private static String BasicSignup=ReadFromExcel.getLocator("HomePage", "BasicSignup");
	private static String BusinessLink=ReadFromExcel.getLocator("HomePage", "BusinessLink");
	private static String charterBusinessHeader=ReadFromExcel.getLocator("HomePage", "charterBusinessHeader");
	private static String AccountNo=ReadFromExcel.getLocator("HomePage", "AccountNo");
	private static String SecCode=ReadFromExcel.getLocator("HomePage", "SecCode");
	private static String BusinessNextbtn=ReadFromExcel.getLocator("HomePage", "BusinessNextbtn");
	private static String BusinessSignin=ReadFromExcel.getLocator("HomePage", "BusinessSignin");
	private static String AccountCharterID=ReadFromExcel.getLocator("HomePage", "AccountCharterID");
	private static String AccountPassword=ReadFromExcel.getLocator("HomePage", "AccountPassword");
	private static String AccountSignin=ReadFromExcel.getLocator("HomePage", "AccountSignin");
	private static String BusinessBT=ReadFromExcel.getLocator("HomePage", "BusinessBT");
	private static String AccountLogout=ReadFromExcel.getLocator("HomePage", "AccountLogout");
	private static String Logout=ReadFromExcel.getLocator("HomePage", "Logout");
	
	private static String streetAddressHome=ReadFromExcel.getLocator("CharterDotCom", "streetAddressHome");
	private static String aptAddressHome=ReadFromExcel.getLocator("CharterDotCom", "aptAddressHome");
	private static String zipHome=ReadFromExcel.getLocator("CharterDotCom", "zipHome");
	private static String submitHome=ReadFromExcel.getLocator("CharterDotCom", "submitHome");
	private static String loginExisting=ReadFromExcel.getLocator("CharterDotCom", "loginExisting");
	private static String accountNum=ReadFromExcel.getLocator("CharterDotCom", "accountNum");
	private static String submitACNum=ReadFromExcel.getLocator("CharterDotCom", "submitACNum");
	private static String internetUpgradeBtn=ReadFromExcel.getLocator("CharterDotCom", "internetUpgradeBtn");
	private static String continueBtn=ReadFromExcel.getLocator("CharterDotCom", "continueBtn");
	private static String expandDetails=ReadFromExcel.getLocator("CharterDotCom", "expandDetails");
	private static String collapseDetails=ReadFromExcel.getLocator("CharterDotCom", "collapseDetails");
	private static String DVR_no=ReadFromExcel.getLocator("CharterDotCom", "DVR_no");
	private static String email=ReadFromExcel.getLocator("CharterDotCom", "email");
	private static String confirmEmail=ReadFromExcel.getLocator("CharterDotCom", "confirmEmail");
	private static String agreeTerms=ReadFromExcel.getLocator("CharterDotCom", "agreeTerms");
	private static String submitOrder=ReadFromExcel.getLocator("CharterDotCom", "submitOrder");
	private static String preferredDate=ReadFromExcel.getLocator("CharterDotCom", "preferredDate");
	private static String continueLaststep=ReadFromExcel.getLocator("CharterDotCom", "continueLaststep");
	private static String installationInfo=ReadFromExcel.getLocator("CharterDotCom", "installationInfo");
	private static String preferredTime=ReadFromExcel.getLocator("CharterDotCom", "preferredTime");
	private static String tvUpgradeBtn=ReadFromExcel.getLocator("CharterDotCom", "tvUpgradeBtn");
	private static String voiceUpgradeBtn=ReadFromExcel.getLocator("CharterDotCom", "voiceUpgradeBtn");
	private static String keepExistingPhone=ReadFromExcel.getLocator("CharterDotCom", "keepExistingPhone");
	private static String existingPhoneNumField=ReadFromExcel.getLocator("CharterDotCom", "existingPhoneNumField");
	private static String phoneProvider=ReadFromExcel.getLocator("CharterDotCom", "phoneProvider");
	
	CaptureScreenshot<WebDriver> screenshot;
	public BasicAuthenticaion(WebDriver driver) {
		this.driver=driver;	
		screenshot= new CaptureScreenshot<WebDriver>(driver);
	}
	
	
	public void loadCharterLegacy(){
		driver.manage().deleteAllCookies();
		driver.navigate().to("https://www.charter.com");
		sleep(10);
	}
	
	public void Basic_CreateID(){

		wait(Until.elementToBeClickable(BasicLogin));
		clickOnElementUsingJavaScript(BasicLogin);
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
			if(!windowHandle.equals(parentWindow))
			{
				driver.switchTo().window(windowHandle);
				driver.manage().window().maximize();
				System.out.println(driver.getCurrentUrl());
				wait(Until.elementToBeClickable(BasicCreateID));
				clickOnElement(BasicCreateID);
				System.out.println(driver.getCurrentUrl());
				wait(Until.elementsToBeDisplayed(createIDHeader));
				driver.close(); //closing child window
				driver.switchTo().window(parentWindow);//cntrl to parent window
			}
		}
	}

	public void Basic_ForgotCharterID(){
		wait(Until.elementToBeClickable(BasicLogin));
		clickOnElementUsingJavaScript(BasicLogin);

		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
			if(!windowHandle.equals(parentWindow))
			{
				driver.switchTo().window(windowHandle);
				driver.manage().window().maximize();
				System.out.println(driver.getCurrentUrl());
				wait(Until.elementToBeClickable(BasicForgotUsername));
				clickOnElement(BasicForgotUsername);
				System.out.println(driver.getCurrentUrl());
				wait(Until.elementsToBeDisplayed(ForgotIDHeader));
				driver.close(); //closing child window
				driver.switchTo().window(parentWindow);//cntrl to parent window
			}
		}

	}

	public void Basic_ForgotPassword(){
		wait(Until.elementToBeClickable(BasicLogin));
		clickOnElementUsingJavaScript(BasicLogin);

		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
			if(!windowHandle.equals(parentWindow))
			{
				driver.switchTo().window(windowHandle);
				driver.manage().window().maximize();
				System.out.println(driver.getCurrentUrl());
				wait(Until.elementToBeClickable(BasicForgotPassword));
				clickOnElement(BasicForgotPassword);
				System.out.println(driver.getCurrentUrl());
				wait(Until.elementsToBeDisplayed(ForgotPWHeader));
				driver.close(); //closing child window
				driver.switchTo().window(parentWindow);//cntrl to parent window
			}
		}
	}
	
	public void SignUp_button(){
		
		wait(Until.elementToBeClickable(BasicSignup));
		clickOnElementUsingJavaScript(BasicSignup);
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
			if(!windowHandle.equals(parentWindow))
			{
				driver.switchTo().window(windowHandle);
				driver.manage().window().maximize();
				System.out.println(driver.getCurrentUrl());
				wait(Until.elementsToBeDisplayed(createIDHeader));
				driver.close(); //closing child window
				driver.switchTo().window(parentWindow);//cntrl to parent window
			}
		}
	}
	
	public void Login_button(){
		wait(Until.elementToBeClickable(BasicLogin));
		clickOnElementUsingJavaScript(BasicLogin);
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
			if(!windowHandle.equals(parentWindow))
			{
				driver.switchTo().window(windowHandle);
				driver.manage().window().maximize();
				System.out.println(driver.getCurrentUrl());
				wait(Until.elementsToBeDisplayed(BasicForgotUsername));
				driver.close(); //closing child window
				driver.switchTo().window(parentWindow);//cntrl to parent window
			}
		}
		
	}
	
	public void Business_Customers_Link(String businessaccountNo,String SecurityCode,String BusinessCharterID,String UserPassword){
		
		wait(Until.elementToBeClickable(BasicLogin));
		clickOnElementUsingJavaScript(BasicLogin);
		
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
			if(!windowHandle.equals(parentWindow))
			{
				driver.switchTo().window(windowHandle);
				driver.manage().window().maximize();
				System.out.println(driver.getCurrentUrl());
				wait(Until.elementToBeClickable(BusinessLink));
				clickOnElement(BusinessLink);
				System.out.println(driver.getCurrentUrl());
				wait(Until.elementsToBeDisplayed(charterBusinessHeader));
				/*type(AccountNo,businessaccountNo);
				type(SecCode,SecurityCode);
				clickOnElement(BusinessNextbtn);
				clickOnElement(BusinessSignin);
				type(AccountCharterID,BusinessCharterID);
				type(AccountPassword,UserPassword);
				clickOnElement(AccountSignin);
				wait(Until.elementsToBeDisplayed(BusinessBT));
				clickOnElement(AccountLogout);
				clickOnElement(Logout);
				driver.close(); //closing child window
				driver.switchTo().window(parentWindow);//cntrl to parent window
*/			}
		}
	}
	
	public void dotComLogin(String Address1,String Address2,String zipCode,String ACNumber){
		sleep(10);
		wait(Until.elementToBeDisplayed(streetAddressHome));
		type(streetAddressHome,Address1);
		type(aptAddressHome,Address2);
		type(zipHome,zipCode);
		clickOnElement(submitHome);
		sleep(10);
	
		wait(Until.elementToBeDisplayed(loginExisting));
		clickOnElement(loginExisting);
		wait(Until.elementToBeDisplayed(accountNum));
		type(accountNum,ACNumber);
		clickOnElement(submitACNum);
		sleep(10);
	}
	
	public void tvUpgradeDotCom(String Address1,String Address2,String zipCode,String ACNum,String emailinput,String phone,String fname,String lname){
/*		wait(Until.elementToBeDisplayed(expandDetails));
		clickOnElement(expandDetails);
		sleep(5);
		clickOnElement(collapseDetails);*/
		wait(Until.elementToBeDisplayed(streetAddressHome));
		type(streetAddressHome,Address1);
		type(aptAddressHome,Address2);
		type(zipHome,zipCode);
		clickOnElement(submitHome);
		sleep(25);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='prospect_view_offers']"));
		clickOnElement("xpath;.//*[@id='prospect_view_offers']");
		sleep(5);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='choose_101100000']"));
		clickOnElement("xpath;.//*[@id='choose_101100000']");
		sleep(10);
		wait(Until.elementsToBeDisplayed(DVR_no));
		clickOnElement(DVR_no);
		sleep(10);
		clickOnElement(continueBtn);
		sleep(5);
		wait(Until.elementToBeDisplayed(email));
		type(email,emailinput);
		type(confirmEmail,emailinput);// agree button =
		type("xpath;.//*[@id='firstname']",fname);
		type("xpath;.//*[@id='lastname']",lname);
		clickOnElement("xpath;.//*[@id='over_a_year_over_1_year']");
		clickOnElement("xpath;.//*[@id='phone-type-home-label']");
		type("xpath;.//*[@id='phoneNumber']", phone);
		clickOnElement(agreeTerms);
		sleep(10);
/*		clickOnElement(submitOrder);
		
		sleep(5);
		wait(Until.elementToBeDisplayed(preferredDate));
		clickOnElement(preferredDate);
		wait(Until.elementToBeDisplayed(preferredTime));
		clickOnElement(preferredTime);
		wait(Until.elementToBeDisplayed(continueLaststep));
		clickOnElement(continueLaststep);
		
		sleep(5);
		wait(Until.elementToBeDisplayed(installationInfo));
		System.out.println(getText(installationInfo));*/
		
	}
	
	public void internetUpgradeDotCom(String Address1,String Address2,String zipCode,String ACNum,String emailinput,String phone,String fname,String lname){
		
/*		if(isElementPresent(expandDetails)){
			//wait(Until.elementToBeDisplayed(expandDetails));
			clickOnElement(expandDetails);
			sleep(5);
			clickOnElement(collapseDetails);

		}*/
		wait(Until.elementToBeDisplayed(streetAddressHome));
		type(streetAddressHome,Address1);
		type(aptAddressHome,Address2);
		type(zipHome,zipCode);
		clickOnElement(submitHome);
		sleep(25);
		wait(Until.elementToBeDisplayed(loginExisting));
		clickOnElement(loginExisting);
		wait(Until.elementToBeDisplayed(accountNum));
		type(accountNum,ACNum);
		clickOnElement(submitACNum);
		sleep(10);
		wait(Until.elementToBeDisplayed(internetUpgradeBtn));
		clickOnElement(internetUpgradeBtn);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='autoCust4065202_no']"));
		clickOnElement("xpath;.//*[@id='autoCust4065202_no']");
		sleep(10);
		wait(Until.elementToBeDisplayed(continueBtn));
		clickOnElement(continueBtn);
		sleep(10);
		wait(Until.elementToBeDisplayed(email));
		type(email,emailinput);
		type(confirmEmail,emailinput);
		//type("xpath;.//*[@id='firstname']",fname);
		//type("xpath;.//*[@id='lastname']",lname);
		//clickOnElement("xpath;.//*[@id='over_a_year_over_1_year']");
		//clickOnElement("xpath;.//*[@id='phone-type-home-label']");
		//type("xpath;.//*[@id='phoneNumber']", phone);
		clickOnElement(agreeTerms);
		sleep(10);
/*		clickOnElement(submitOrder);
		
		sleep(5);
		wait(Until.elementToBeDisplayed(preferredDate));
		clickOnElement(preferredDate);
		wait(Until.elementToBeDisplayed(preferredTime));
		clickOnElement(preferredTime);
		wait(Until.elementToBeDisplayed(continueLaststep));
		clickOnElement(continueLaststep);
		
		sleep(5);
		wait(Until.elementToBeDisplayed(installationInfo));
		System.out.println(getText(installationInfo));
		*/
	}
	
	public void voiceUpgradeDotCom(String Address1,String Address2,String zipCode,String ACNum,String emailinput,String phone,String fname,String lname){
/*		wait(Until.elementToBeDisplayed(expandDetails));
		clickOnElement(expandDetails);
		sleep(5);
		clickOnElement(collapseDetails);*/
		wait(Until.elementToBeDisplayed(streetAddressHome));
		type(streetAddressHome,Address1);
		type(aptAddressHome,Address2);
		type(zipHome,zipCode);
		clickOnElement(submitHome);
		sleep(25);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='prospect_view_offers']"));
		clickOnElement("xpath;.//*[@id='prospect_view_offers']");
		sleep(5);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='choose_102011000']"));
		clickOnElement("xpath;.//*[@id='choose_102011000']");
		wait(Until.elementsToBeDisplayed(keepExistingPhone));
		clickOnElement(keepExistingPhone);
		type(existingPhoneNumField,phone);
		selectValueFromDropDown(phoneProvider, "AT&T");
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='autoCust4065202_no']"));
		clickOnElement("xpath;.//*[@id='autoCust4065202_no']");
		sleep(10);
		//wait(Until.elementToBeDisplayed(continueBtn));
		clickOnElement(continueBtn);
		
		sleep(5);
		wait(Until.elementToBeDisplayed(email));
		type(email,emailinput);
		type(confirmEmail,emailinput);
		type("xpath;.//*[@id='firstname']",fname);
		type("xpath;.//*[@id='lastname']",lname);
		clickOnElement("xpath;.//*[@id='over_a_year_over_1_year']");
		clickOnElement("xpath;.//*[@id='phone-type-home-label']");
		type("xpath;.//*[@id='phoneNumber']", phone);
		clickOnElement(agreeTerms);
		sleep(10);
/*		clickOnElement(submitOrder);
		
		sleep(5);
		wait(Until.elementToBeDisplayed(preferredDate));
		clickOnElement(preferredDate);
		wait(Until.elementToBeDisplayed(preferredTime));
		clickOnElement(preferredTime);
		wait(Until.elementToBeDisplayed(continueLaststep));
		clickOnElement(continueLaststep);
		
		sleep(5);
		wait(Until.elementToBeDisplayed(installationInfo));
		System.out.println(getText(installationInfo));*/
		
	}
	
	public void TVUpgradeDotCom_Silver(String Address1,String Address2,String zipCode,String ACNumber,String emailinput,String phone,String fname,String lname){
		
		//sleep(10);
		wait(Until.elementToBeDisplayed(streetAddressHome));
		type(streetAddressHome,Address1);
		type(aptAddressHome,Address2);
		type(zipHome,zipCode);
		clickOnElement(submitHome);
		sleep(15);
/*		wait(Until.elementToBeDisplayed(loginExisting));
		clickOnElement(loginExisting);
		wait(Until.elementToBeDisplayed(accountNum));
		type(accountNum,ACNumber);
		clickOnElement(submitACNum);
		sleep(10);*/
		
		//wait(Until.elementToBeDisplayed(expandDetails));
		//clickOnElement(expandDetails);
		//sleep(5);
		//clickOnElement(collapseDetails);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='prospect_view_offers']"));
		clickOnElement("xpath;.//*[@id='prospect_view_offers']");
		sleep(5);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='choose_103211010']"));//put silver package update button
		clickOnElement("xpath;.//*[@id='choose_103211010']");
		sleep(20);
		wait(Until.elementsToBeDisplayed(DVR_no));
		clickOnElement(DVR_no);
		wait(Until.elementsToBeDisplayed(keepExistingPhone));
		clickOnElement(keepExistingPhone);
		type(existingPhoneNumField,phone);
		selectValueFromDropDown(phoneProvider, "AT&T");
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='autoCust4065210_no']"));
		clickOnElement("xpath;.//*[@id='autoCust4065210_no']");
		//wait(Until.elementToBeClickable(continueBtn));
		sleep(5);
		clickOnElement(continueBtn);
		sleep(10);
		wait(Until.elementToBeDisplayed(email));
		type(email,emailinput);
		type(confirmEmail,emailinput);
		type("xpath;.//*[@id='firstname']",fname);
		type("xpath;.//*[@id='lastname']",lname);
		clickOnElement("xpath;.//*[@id='over_a_year_over_1_year']");
		clickOnElement("xpath;.//*[@id='phone-type-home-label']");
		type("xpath;.//*[@id='phoneNumber']", phone);
		clickOnElement(agreeTerms);
		sleep(10);
/*		clickOnElement(submitOrder);
		
		sleep(5);
		wait(Until.elementToBeDisplayed(preferredDate));
		clickOnElement(preferredDate);
		wait(Until.elementToBeDisplayed(preferredTime));
		clickOnElement(preferredTime);
		wait(Until.elementToBeDisplayed(continueLaststep));
		clickOnElement(continueLaststep);
		
		sleep(5);
		wait(Until.elementToBeDisplayed(installationInfo));
		System.out.println(getText(installationInfo));*/
		
	}
	
	public void TVUpgradeDotCom_Gold(String Address1,String Address2,String zipCode,String ACNumber,String emailinput,String phone,String fname,String lname){
		
		//sleep(10);
		wait(Until.elementToBeDisplayed(streetAddressHome));
		type(streetAddressHome,Address1);
		type(aptAddressHome,Address2);
		type(zipHome,zipCode);
		clickOnElement(submitHome);
		sleep(15);
/*		wait(Until.elementToBeDisplayed(loginExisting));
		clickOnElement(loginExisting);
		wait(Until.elementToBeDisplayed(accountNum));
		type(accountNum,ACNumber);
		clickOnElement(submitACNum);
		sleep(10);*/
		
		//wait(Until.elementToBeDisplayed(expandDetails));
		//clickOnElement(expandDetails);
		//sleep(5);
		//clickOnElement(collapseDetails);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='prospect_view_offers']"));
		clickOnElement("xpath;.//*[@id='prospect_view_offers']");
		sleep(5);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='choose_103311010']"));//put Gold package update button
		clickOnElement("xpath;.//*[@id='choose_103311010']");
		sleep(10);
		wait(Until.elementsToBeDisplayed(DVR_no));
		clickOnElement(DVR_no);
		wait(Until.elementsToBeDisplayed(keepExistingPhone));
		clickOnElement(keepExistingPhone);
		type(existingPhoneNumField,phone);
		selectValueFromDropDown(phoneProvider, "AT&T");
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='autoCust4065210_no']"));
		clickOnElement("xpath;.//*[@id='autoCust4065210_no']");
		//wait(Until.elementToBeDisplayed("xpath;//*[contains(@sideclass,'side-cart')]/*/*/*/*/*[text()='Continue']"));
		sleep(5);
		clickOnElement("xpath;//*[contains(@sideclass,'side-cart')]/*/*/*/*/*[text()='Continue']");
		sleep(10);
		wait(Until.elementToBeDisplayed(email));
		type(email,emailinput);
		type(confirmEmail,emailinput);
		clickOnElement("xpath;.//*[@id='over_a_year_over_1_year']");
		type("xpath;.//*[@id='firstname']",fname);
		type("xpath;.//*[@id='lastname']",lname);
		clickOnElement("xpath;.//*[@id='phone-type-home-label']");
		type("xpath;.//*[@id='phoneNumber']",phone);
		clickOnElement(agreeTerms);
		sleep(10);
/*		clickOnElement(submitOrder);
		
		sleep(5);
		wait(Until.elementToBeDisplayed(preferredDate));
		clickOnElement(preferredDate);
		wait(Until.elementToBeDisplayed(preferredTime));
		clickOnElement(preferredTime);
		wait(Until.elementToBeDisplayed(continueLaststep));
		clickOnElement(continueLaststep);
		
		sleep(5);
		wait(Until.elementToBeDisplayed(installationInfo));
		System.out.println(getText(installationInfo));*/
		
	}
	
	public void TVUpgradeDotCom_Select_HBO(String Address1,String Address2,String zipCode,String ACNumber,String emailinput,String phone,String fname,String lname){
		
		sleep(10);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='tvServicePage_Link']"));
		clickOnElement("xpath;.//*[@id='tvServicePage_Link']");
		sleep(10);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='BestOffers_CSTV']"));
		clickOnElement("xpath;.//*[@id='BestOffers_CSTV']");
		sleep(10);
		
		wait(Until.elementToBeDisplayed("xpath;//*[contains(@class,'404500-404590039')][text()=' Choose ']"));//put Select TV package update button
		clickOnElement("xpath;//*[contains(@class,'404500-404590039')][text()=' Choose ']");
		sleep(10);
		
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='address1']"));
		type("xpath;.//*[@id='address1']",Address1);
		type("xpath;.//*[@id='appartment']",Address2);
		type("xpath;.//*[@id='zip-code']",zipCode);
		clickOnElement("xpath;.//*[@id='get_online_only_deals']");
		sleep(10);
		wait(Until.elementToBeDisplayed(loginExisting));
		clickOnElement(loginExisting);
		wait(Until.elementToBeDisplayed(accountNum));
		type(accountNum,ACNumber);
		clickOnElement(submitACNum);
		sleep(25);
/*		wait(Until.elementsToBeDisplayed(DVR_no));
		clickOnElement(DVR_no);
		wait(Until.elementsToBeDisplayed(keepExistingPhone));
		clickOnElement(keepExistingPhone);
		type(existingPhoneNumField,phone);
		selectValueFromDropDown(phoneProvider, "AT&T");*/
		wait(Until.elementToBeDisplayed("xpath;(.//*[@id='tv_options'])[2]"));
		clickOnElement("xpath;(.//*[@id='tv_options'])[2]");
		sleep(5);
		clickOnElement("xpath;.//*[@id='autoCustGrp99855100']/section/div/form/div/span/div[1]/div/div/div[3]/div/label");
		//wait(Until.elementToBeDisplayed("xpath;//*[contains(@sideclass,'side-cart')]/*/*/*/*/*[text()='Continue']"));
		sleep(5);
		clickOnElement("xpath;//*[contains(@sideclass,'side-cart')]/*/*/*/*/*[text()='Continue']");
		sleep(10);
		wait(Until.elementToBeDisplayed(email));
		type(email,emailinput);
		type(confirmEmail,emailinput);
/*		clickOnElement("xpath;.//*[@id='over_a_year_over_1_year']");
		type("xpath;.//*[@id='firstname']",fname);
		type("xpath;.//*[@id='lastname']",lname);
		selectValueFromDropDown("xpath;.//*[@id='phoneType']", 1);
		type("xpath;.//*[@id='phoneNumber']",phone);*/
		clickOnElement(agreeTerms);
/*		sleep(10);
		clickOnElement(submitOrder);
		
		sleep(15);
		wait(Until.elementToBeDisplayed(preferredDate));
		clickOnElement(preferredDate);
		wait(Until.elementToBeDisplayed(preferredTime));
		clickOnElement(preferredTime);
		wait(Until.elementToBeDisplayed(continueLaststep));
		clickOnElement(continueLaststep);
		
		sleep(5);
		wait(Until.elementToBeDisplayed(installationInfo));
		System.out.println(getText(installationInfo));*/
		
	}
	
	public void TVUpgrade_DoublePlay(String Address1,String Address2,String zipCode,String ACNumber,String emailinput){
		
		wait(Until.elementToBeDisplayed(streetAddressHome));
		type(streetAddressHome,Address1);
		type(aptAddressHome,Address2);
		type(zipHome,zipCode);
		clickOnElement(submitHome);
		sleep(10);
		wait(Until.elementToBeDisplayed(loginExisting));
		clickOnElement(loginExisting);
		wait(Until.elementToBeDisplayed(accountNum));
		type(accountNum,ACNumber);
		clickOnElement(submitACNum);
		sleep(25);
/*		wait(Until.elementToBeDisplayed(expandDetails));
		clickOnElement(expandDetails);
		sleep(5);
		clickOnElement(collapseDetails);*/
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='upgrade_101100100']"));
		clickOnElement("xpath;.//*[@id='upgrade_101100100']");
		wait(Until.elementsToBeDisplayed(DVR_no));
		clickOnElement(DVR_no);
		sleep(5);
		clickOnElement(continueBtn);
		
		sleep(5);
		wait(Until.elementToBeDisplayed(email));
		type(email,emailinput);
		type(confirmEmail,emailinput);
		clickOnElement(agreeTerms);
/*		sleep(10);
		clickOnElement(submitOrder);
		
		sleep(5);
		wait(Until.elementToBeDisplayed(preferredDate));
		clickOnElement(preferredDate);
		wait(Until.elementToBeDisplayed(preferredTime));
		clickOnElement(preferredTime);
		wait(Until.elementToBeDisplayed(continueLaststep));
		clickOnElement(continueLaststep);
		
		sleep(5);
		wait(Until.elementToBeDisplayed(installationInfo));
		System.out.println(getText(installationInfo));*/
		
	}
	
	public void TVUpgrade_NewCustomer(String Address1,String Address2,String zipCode,String emailinput,String phone,String fname,String lname){
		//sleep(10);
		wait(Until.elementToBeDisplayed(streetAddressHome));
		type(streetAddressHome,Address1);
		type(aptAddressHome,Address2);
		type(zipHome,zipCode);
		clickOnElement(submitHome);
		sleep(25);
/*		wait(Until.elementToBeDisplayed(expandDetails));
		clickOnElement(expandDetails);
		sleep(5);
		clickOnElement(collapseDetails);*/
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='choose_103111010']"));
		clickOnElement("xpath;.//*[@id='choose_103111010']");
		wait(Until.elementsToBeDisplayed(DVR_no));
		clickOnElement(DVR_no);
		sleep(5);
		wait(Until.elementsToBeDisplayed(keepExistingPhone));
		clickOnElement(keepExistingPhone);
		type(existingPhoneNumField,phone);
		selectValueFromDropDown(phoneProvider, "AT&T");
		sleep(5);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='autoCust4065210_no']"));
		clickOnElement("xpath;.//*[@id='autoCust4065210_no']");
		sleep(5);
		clickOnElement(continueBtn);
		
		sleep(5);
		wait(Until.elementToBeDisplayed(email));
		type(email,emailinput);
		type(confirmEmail,emailinput);
		type("xpath;.//*[@id='firstname']",fname);
		type("xpath;.//*[@id='lastname']",lname);
		clickOnElement("xpath;.//*[@id='over_a_year_over_1_year']");
		clickOnElement("xpath;.//*[@id='phone-type-home-label']");
		type("xpath;.//*[@id='phoneNumber']", phone);
		clickOnElement(agreeTerms);
		sleep(10);
/*		clickOnElement(submitOrder);
		
		sleep(5);
		wait(Until.elementToBeDisplayed(preferredDate));
		clickOnElement(preferredDate);
		wait(Until.elementToBeDisplayed(preferredTime));
		clickOnElement(preferredTime);
		wait(Until.elementToBeDisplayed(continueLaststep));
		clickOnElement(continueLaststep);
		
		sleep(5);
		wait(Until.elementToBeDisplayed(installationInfo));
		System.out.println(getText(installationInfo));*/
		
	}
	
	public void InternetUpgrade_DoublePlay(String Address1,String Address2,String zipCode,String ACNumber, String emailinput){
		/*wait(Until.elementToBeDisplayed(expandDetails));
		clickOnElement(expandDetails);
		sleep(5);
		clickOnElement(collapseDetails);*/
		
		wait(Until.elementToBeDisplayed(streetAddressHome));
		type(streetAddressHome,Address1);
		type(aptAddressHome,Address2);
		type(zipHome,zipCode);
		clickOnElement(submitHome);
		sleep(10);
		wait(Until.elementToBeDisplayed(loginExisting));
		clickOnElement(loginExisting);
		wait(Until.elementToBeDisplayed(accountNum));
		type(accountNum,ACNumber);
		clickOnElement(submitACNum);
		sleep(25);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='upgrade_101010100']"));
		clickOnElement("xpath;.//*[@id='upgrade_101010100']");
		sleep(10);
		clickOnElement(continueBtn);
		
		sleep(5);
		wait(Until.elementToBeDisplayed(email));
		type(email,emailinput);
		type(confirmEmail,emailinput);
		clickOnElement(agreeTerms);
/*		sleep(10);
		clickOnElement(submitOrder);
		
		sleep(5);
		wait(Until.elementToBeDisplayed(preferredDate));
		clickOnElement(preferredDate);
		wait(Until.elementToBeDisplayed(preferredTime));
		clickOnElement(preferredTime);
		wait(Until.elementToBeDisplayed(continueLaststep));
		clickOnElement(continueLaststep);
		
		sleep(5);
		wait(Until.elementToBeDisplayed(installationInfo));
		System.out.println(getText(installationInfo));*/
		
	}
	
	public void VoiceUpgrade_DoublePlay(String emailinput,String phone){
/*		wait(Until.elementToBeDisplayed(expandDetails));
		clickOnElement(expandDetails);
		sleep(5);
		clickOnElement(collapseDetails);*/
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='upgrade_101001100']"));
		clickOnElement("xpath;.//*[@id='upgrade_101001100']");
		wait(Until.elementsToBeDisplayed(keepExistingPhone));
		clickOnElement(keepExistingPhone);
		type(existingPhoneNumField,phone);
		selectValueFromDropDown(phoneProvider, "AT&T");
		sleep(5);
		clickOnElement(continueBtn);
		
		sleep(5);
		wait(Until.elementToBeDisplayed(email));
		type(email,emailinput);
		type(confirmEmail,emailinput);
		clickOnElement(agreeTerms);
/*		clickOnElement(submitOrder);
		
		sleep(5);
		wait(Until.elementToBeDisplayed(preferredDate));
		clickOnElement(preferredDate);
		wait(Until.elementToBeDisplayed(preferredTime));
		clickOnElement(preferredTime);
		wait(Until.elementToBeDisplayed(continueLaststep));
		clickOnElement(continueLaststep);
		
		sleep(5);
		wait(Until.elementToBeDisplayed(installationInfo));
		System.out.println(getText(installationInfo));*/
		
	}
	
	public void TVUpgrade_TriplePlay(String Address1,String Address2,String zipCode,String ACNumber,String emailinput,String phone,String fname,String lname){

		wait(Until.elementToBeDisplayed(streetAddressHome));
		type(streetAddressHome,Address1);
		type(aptAddressHome,Address2);
		type(zipHome,zipCode);
		clickOnElement(submitHome);
		sleep(15);
		
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='choose_103311010']"));
		clickOnElement("xpath;.//*[@id='choose_103311010']");
		sleep(10);
		
		wait(Until.elementsToBeDisplayed(DVR_no));
		clickOnElement(DVR_no);
		
		wait(Until.elementsToBeDisplayed(keepExistingPhone));
		clickOnElement(keepExistingPhone);
		type(existingPhoneNumField,phone);
		selectValueFromDropDown(phoneProvider, "AT&T");
		sleep(5);
		
		clickOnElement("xpath;.//*[@id='tv_options']");
		sleep(5);
		clickOnElement("xpath;(.//*[@id='addl_opt_4055205'])[2]");
		sleep(5);
		
		clickOnElement("xpath;(.//*[@id='phone_options'])[2]");
		sleep(5);
		clickOnElement("xpath;.//*[@id='phone_option_mexico_yes']");
		sleep(5);
		clickOnElement("xpath;.//*[@id='4075303']");
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='autoCust4065210_no']"));
		clickOnElement("xpath;.//*[@id='autoCust4065210_no']");
		sleep(5);
		clickOnElement(continueBtn);
		
		sleep(5);
		wait(Until.elementToBeDisplayed(email));
		type(email,emailinput);
		type(confirmEmail,emailinput);
		type("xpath;.//*[@id='firstname']",fname);
		type("xpath;.//*[@id='lastname']",lname);
		clickOnElement("xpath;.//*[@id='phone-type-home-label']");
		type("xpath;.//*[@id='phoneNumber']", phone);
		
		clickOnElement(agreeTerms);
		sleep(10);
/*		clickOnElement(submitOrder);
		
		sleep(15);
		wait(Until.elementToBeDisplayed(preferredDate));
		clickOnElement(preferredDate);
		wait(Until.elementToBeDisplayed(preferredTime));
		clickOnElement(preferredTime);
		wait(Until.elementToBeDisplayed(continueLaststep));
		clickOnElement(continueLaststep);
		
		sleep(5);
		wait(Until.elementToBeDisplayed(installationInfo));
		System.out.println(getText(installationInfo));*/
		
	}
	
	public boolean TVUpgrade_HardDisconnectUser(String Address1,String Address2,String zipCode,String ACNumber){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(streetAddressHome));
		type(streetAddressHome,Address1+" "+Address2);
		//type(aptAddressHome,Address2);
		type(zipHome,zipCode);
		clickOnElement(submitHome);
		sleep(25);
		//wait(Until.elementToBePresent("xpath;//*[@href='#collapse']"));
		clickOnElement("xpath;//*[@href='#collapse']");
		if(isElementVisible("xpath;//*[contains(text(),'verify the address')]")){
			retVal = true;
			System.out.println(getText("xpath;//*[contains(text(),'verify the address')]"));
		}
		return retVal;
	}
	
	public boolean TVUpgrade_SuspendedUser(String Address1,String Address2,String zipCode,String ACNumber){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(streetAddressHome));
		type(streetAddressHome,Address1+" "+Address2);
		//type(aptAddressHome,Address2);
		type(zipHome,zipCode);
		clickOnElement(submitHome);
		sleep(25);
		//wait(Until.elementToBePresent("xpath;//*[@href='#collapse']"));
		clickOnElement("xpath;//*[@href='#collapse']");
		if(isElementVisible("xpath;//*[contains(text(),'verify the address')]")){
			retVal = true;
			System.out.println(getText("xpath;//*[contains(text(),'verify the address')]"));
		}
		return retVal;
	}

}
