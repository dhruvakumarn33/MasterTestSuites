package com.charter.page;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.charter.utils.Constants;
import com.cognizant.framework.ajax.Until;
import com.cognizant.framework.core.CaptureScreenshot;
import com.cognizant.framework.core.EnvParameters;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.WebDriverBase;

public class MyAccountPage extends WebDriverBase {

	private String URL= Constants.URL;
	
	private static String MyAccountTab=ReadFromExcel.getLocator("MAPage", "MyAccountTab");
	private static String Billing=ReadFromExcel.getLocator("MAPage", "Billing");
	private static String UserPreferencelink=ReadFromExcel.getLocator("MAPage", "UserPreferencelink");
	private static String OverViewLink=ReadFromExcel.getLocator("MAPage", "OverViewLink");
	///
	private static String InternetServlink=ReadFromExcel.getLocator("MAPage", "InternetServices");
	private static String TVServlink=ReadFromExcel.getLocator("MAPage", "TVServices");
	private static String VoiceServlink=ReadFromExcel.getLocator("MAPage", "VoiceServices");
	private static String Internetoff=ReadFromExcel.getLocator("MAPage", "Internetoff");
	private static String Tvoff=ReadFromExcel.getLocator("MAPage", "Tvoff");
	private static String Voiceoff=ReadFromExcel.getLocator("MAPage", "Voiceoff");
	private static String TVRefresh=ReadFromExcel.getLocator("MAPage", "TVRefresh");
	private static String SuccessMsg=ReadFromExcel.getLocator("MAPage", "SuccessMsg");
	private static String RefreshError=ReadFromExcel.getLocator("MAPage", "RefreshError");
	private static String SuccessOK=ReadFromExcel.getLocator("MAPage", "SuccessOK");
	private static String AdminUser=ReadFromExcel.getLocator("MAPage", "AdminUser");
	private static String StdUser=ReadFromExcel.getLocator("MAPage", "StdUser");
	private static String NewPassword=ReadFromExcel.getLocator("MAPage", "NewPassword");
	private static String ConfirmPassword=ReadFromExcel.getLocator("MAPage", "ConfirmPassword");
	private static String ContactEmail=ReadFromExcel.getLocator("MAPage", "ContactEmail");
	private static String ContactPhone=ReadFromExcel.getLocator("MAPage", "ContactPhone");
	private static String Question=ReadFromExcel.getLocator("MAPage", "Question");
	private static String Answer=ReadFromExcel.getLocator("MAPage", "Answer");
	private static String Submit=ReadFromExcel.getLocator("MAPage", "Submit");
	private static String PayBill=ReadFromExcel.getLocator("MAPage", "PayBill");
	private static String ViewBillDetail=ReadFromExcel.getLocator("MAPage", "ViewBillDetail");
	private static String ViewBillStmt=ReadFromExcel.getLocator("MAPage", "ViewBillStmt");
	private static String accountInfo=ReadFromExcel.getLocator("UPPage", "accountInfo");
	private static String viewCurrentBill=ReadFromExcel.getLocator("MAPage", "viewCurrentBill");
	private static String viewPrevBill=ReadFromExcel.getLocator("MAPage", "viewPrevBill");
	private static String btnModalOk=ReadFromExcel.getLocator("UPPage", "btnModalOk");
	
	CaptureScreenshot<WebDriver> screenshot;	
	public MyAccountPage(WebDriver driver) {
		this.driver=driver;
		screenshot= new CaptureScreenshot<WebDriver>(driver);
	}
	
	public void PayBill(){
		wait(Until.elementToBeClickable(PayBill));
		clickOnElement(PayBill);
	}

	public void openMyAccountTab() {
		wait(Until.elementToBeDisplayed(MyAccountTab));
		//hoverOver(MyAccountTab);
		sleep(5);
		clickOnElement(MyAccountTab);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		if(isElementPresent("xpath;//*[contains(@class,'close')]")){
			clickOnElement("xpath;//*[contains(@class,'close')]");
		}
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		sleep(10);
	}
	public void loadBillingAndTransactionSection() {
		wait(Until.elementToBeDisplayed(Billing));
		clickOnElement(Billing);
		HomePage hp = new HomePage(driver);
		hp.pagewait();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(isElementPresent("xpath;.//*[@id='btn-modal-1']")){
			clickOnElement("xpath;.//*[@id='btn-modal-1']");
		}
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	public void loadUPPage(){
		wait(Until.elementToBeClickable(UserPreferencelink));
		clickOnElement(UserPreferencelink);
		HomePage hp = new HomePage(driver);
		hp.pagewait();
	}
	public void loadOverviewPage(){
		wait(Until.elementToBeClickable(OverViewLink));
		clickOnElement(OverViewLink);
		HomePage hp = new HomePage(driver);
		hp.pagewait();
	}

	public void InternetServiceslink(){
		wait(Until.elementToBeClickable(InternetServlink));
		clickOnElement(InternetServlink);
		HomePage hp = new HomePage(driver);
		hp.pagewait();
	}
	
	public void checkInternetEquipment(){
		sleep(5);
		if(isElementVisible("xpath;//*[@model='devices.list']")){
			System.out.println("Internet Equipment displayed ");
		}
	}
	
	public void checkTVEquipment(){
		sleep(5);
		if(isElementVisible("xpath;//*[@model='devices.list']")){
			System.out.println("TV Equipment displayed ");
		}
	}
	public void TVServiceslink(){
		wait(Until.elementToBeClickable(TVServlink));
		clickOnElement(TVServlink);
		HomePage hp = new HomePage(driver);
		hp.pagewait();
	}
	public boolean VoiceServiceslink(){

		boolean retVal=false;
		wait(Until.elementToBeClickable(VoiceServlink));
		clickOnElement(VoiceServlink);
		HomePage hp = new HomePage(driver);
		hp.pagewait();
		retVal=true;
		return retVal;
	}

	public void is_Timeout_for_Page(){

		wait(Until.elementToBeDisplayed("xpath;//div[contains(text(),'Your session will end in 2 minutes due to inactivity. Please click OK to continue your session.')]"),960);
		screenshot.saveScreenshot("Session Timeout"+ File.separator + "POPUp Warning for session Timeout ");
		wait(Until.elementToBeDisplayed("xpath;//*[contains(text(),'Your session has expired due to inactivity.')]"),140);
		screenshot.saveScreenshot("Session Timeout"+ File.separator + "Login page After session Timeout");
	}

	public void InternetwithoutLogin(){
		clickOnElement(Internetoff);
	}

	public void TVwithoutLogin(){
		clickOnElement(Tvoff);
	}

	public boolean VoicewithoutLogin(){
		boolean retVal=false;
		clickOnElement(Voiceoff);
		retVal=true;
		return retVal;
	}
	
	public boolean TVRefresh(){
		boolean retVal=false;
		clickOnElement(TVRefresh);
		sleep(5);
		if(isElementVisible(SuccessMsg)){
			retVal=true;
			System.out.println(driver.findElement(By.xpath("//div[contains(text(),'successfully')]")).getText());
		}
		clickOnElement(SuccessOK);
		sleep(5);
		return retVal;
		
	}
	
	public boolean TVRefresherror(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(TVRefresh));
		clickOnElement(TVRefresh);
		sleep(5);
		if(isElementVisible("xpath;.//*[@id='modalTitle'][text()='Unable to Refresh']")){
			retVal=true;
			System.out.println(getText("xpath;.//*[@id='modalTitle'][text()='Unable to Refresh']"));
		}
		clickOnElement(SuccessOK);
		sleep(5);
		return retVal;
		
	}
	
	public boolean TVRefreshError(){
		boolean retVal=false;
		clickOnElement(TVRefresh);
		for(;isElementVisible(SuccessMsg);){
			clickOnElement(SuccessOK);
			clickOnElement(TVRefresh);
		}
		if(isElementVisible(RefreshError)){
			System.out.println(driver.findElement(By.xpath("//div[contains(text(),'sorry')]")).getText());
			clickOnElement(SuccessOK);
			retVal= true;
		}
		return retVal;
	}
	
	
	
	public void SelectAdminUser(){
		clickOnElement(AdminUser);
	}
	
	public void SelectStdUser(){
		clickOnElement(StdUser);
	}
	
	public void Editcontact(String newPass,String CPass,String Email,String Phone,String SecuQ,String SecuA){
		driver.findElement(By.xpath("(//a[@id='edit-btn'])[1]")).click();
		type(NewPassword, newPass);
		type(ConfirmPassword, CPass);
		driver.findElement(By.xpath("(//a[@id='edit-btn'])[2]")).click();
		clearTextBox(ContactEmail);
		type(ContactEmail,Email);
		driver.findElement(By.xpath("(//a[@id='edit-btn'])[3]")).click();
		clearTextBox(ContactPhone);
		type(ContactPhone,Phone);
		driver.findElement(By.xpath("(//a[@id='edit-btn'])[4]")).click();
		selectValueFromDropDown(Question, SecuQ);
		clearTextBox(Answer);
		type(Answer, SecuA);
		clickOnElement(Submit);
	}
	
	public void autoPayStatus(){
		System.out.println("Auto pay current status is : "+driver.findElement(By.className("text-status-widget")).getText());
	}
	
	public boolean viewBillDetailLink(){
		boolean retVal=false;
		clickOnElement(ViewBillDetail);
		if(driver.getCurrentUrl().contains("billing-and-transactions"))
			retVal=true;
		return retVal;		
	}
	
	public boolean ViewBillStmtLink(){
		boolean retVal=false;
		
		wait(Until.elementToBeDisplayed(ViewBillStmt));
		clickOnElement(ViewBillStmt);
		String parentWindow = driver.getWindowHandle();
		String[] filepath=new String[] { System.getProperty("user.dir") + File.separator + "AutoIT" + File.separator +"Print.exe",EnvParameters.WEB_BROWSER_TYPE.replaceAll("\\*", "")};
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
			if(!windowHandle.equals(parentWindow))
			{
				System.out.println("Switching window!");
				System.out.println(windowHandle);
				driver.switchTo().window(windowHandle);
				sleep(10);
				try {
					Runtime.getRuntime().exec(filepath);
					//driver.findElement(By.id("print")).click();
					Actions actions = new Actions(driver);
					actions.sendKeys(Keys.CONTROL).sendKeys("p");
					System.out.println("Printing");
					
				}
				catch (IOException e) {
					e.printStackTrace();
					System.out.println("Unable to close");
				}
				retVal=true;
				driver.close(); //closing child window
				System.out.println("closing window");
				driver.switchTo().window(parentWindow);
				System.out.println("switching to parent window");
				sleep(3);
			}
		}
		
		return retVal;
	}
	
	public boolean AccountInfo(){
		boolean retVal=false;
		if(isElementPresent(accountInfo))
			retVal=true;
		return retVal;
	}
	
	public void printAvailablePDF(){
		String parentWindow = driver.getWindowHandle();
		wait(Until.elementToBeDisplayed(viewPrevBill));
		clickOnElement(viewPrevBill);
		System.out.println("Bill Statement Of: "+getText(viewPrevBill));
		String[] filepath=new String[] { System.getProperty("user.dir") + File.separator + "AutoIT" + File.separator +"Print.exe",EnvParameters.WEB_BROWSER_TYPE.replaceAll("\\*", "")};
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
			if(!windowHandle.equals(parentWindow))
			{
				System.out.println("Switching window!");
				driver.switchTo().window(windowHandle);
				sleep(10);
				try {
					Runtime.getRuntime().exec(filepath);
					//driver.findElement(By.id("print")).click();
					Actions actions = new Actions(driver);
					actions.sendKeys(Keys.CONTROL).sendKeys("p");
					driver.close();
					driver.switchTo().window(parentWindow);
					break;
				}
				catch (IOException e) {
					e.printStackTrace();
					System.out.println("Unable to close");
				}
				driver.close(); //closing child window
				sleep(3);
			}
		}
	}
	
	public void availableStatements(){
		System.out.println("Statements are available for the following months: ");
			System.out.println(getTextOfSimilarElements("xpath;//*[@class='underlined-link ng-binding']"));
	}
	
	public boolean pastDueAmount(){
		boolean retVal= false;
		if(isElementVisible("xpath;//*[contains(text(),'Please pay')]")){
			if(getText("xpath;//*[contains(text(),'Please pay')]").equals("Please pay this amount to avoid service interruption.")){
				retVal=true;
				System.out.println(getText("xpath;//*[contains(text(),'Past Due')]"));
				System.out.println("Past Due message: "+getText("xpath;//*[contains(text(),'Please pay')]"));
			}
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(isElementVisible("xpath;.//*[@id='btn-modal-1']")){
			clickOnElement("xpath;.//*[@id='btn-modal-1']");
		}
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		return retVal;
	}
	
	public void couponGiftsLink(){
		sleep(10);
		wait(Until.elementToBeDisplayed("xpath;//*[contains(text(),'Redeem')]"));
		clickOnElement("xpath;//*[contains(text(),'Redeem')]");
		HomePage hp = new HomePage(driver);
		hp.pagewait();
		System.out.println("Page Navigated to : "+driver.getCurrentUrl());
	}
	
	public void redeemCoupon(String couponNumber){
		type("xpath;.//*[@id='couponNumber']",couponNumber);
		wait(Until.elementToBeDisplayed("xpath;//*[@value='Redeem']"));
		clickOnElement("xpath;//*[@value='Redeem']");
		if(isElementVisible("xpath;//*[@class='modal-content']")){
			if(getText("xpath;//*[@class='modal-content']").equals("Error")){
				System.out.println("Invalid Coupon Error Message: "+getText("xpath;//*[@class='modal-content']"));
				clickOnElement("xpath;.//*[@id='btn-modal-1']");
				sleep(5);
			}
			else if(isElementPresent("xpath;(//*[contains(text(),'Confirmation')])[1]")){
				System.out.println("Valid Coupon redemption Successful");
				System.out.println(getText("xpath;//*[@class='redeem-text ng-binding']"));
				System.out.println(getText("xpath;//*[@class='redeem-list']"));
				sleep(5);
				
				clickOnElement("xpath;//*[contains(text(),'Redemption History')]");
				sleep(5);
				wait(Until.elementToBeDisplayed("xpath;//table/tbody"));
				if(isElementPresent("xpath;//table/tbody")){
					System.out.println("Recent Coupon Rebate History");
					wait(Until.elementToBeDisplayed("xpath;//table/tbody/tr[1]/td[1]"));
					System.out.println("Coupon Rebate # : "+getText("xpath;//table/tbody/tr[1]/td[1]"));
					System.out.println("Coupon Rebate Details : "+getText("xpath;//table/tbody/tr[1]/td[2]"));
					System.out.println("Offer Value : "+getText("xpath;//table/tbody/tr[1]/td[3]"));
					System.out.println("Redemption Date : "+getText("xpath;//table/tbody/tr[1]/td[4]"));
					System.out.println("Confirmation # : "+getText("xpath;//table/tbody/tr[1]/td[5]"));
				}
				else 
					System.out.println("No Coupon Redemption History");
			}
		}
		

	}
	
	public void UpgradeVoice(String Address, String apartment,String zipcode,String AccountNum,String email,String fname,String lname,String phone){
		wait(Until.elementToBeDisplayed("xpath;(//*[contains(text(),'Upgrade')][contains(@cc-link,'Voice')])[2]"));
		clickOnElement("xpath;(//*[contains(text(),'Upgrade')][contains(@cc-link,'Voice')])[2]");
		sleep(5);
		driver.navigate().to("https://www.charter.com/buyflow/buyflow-localization-resp");
		sleep(5);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='address']"));
		type("xpath;.//*[@id='address']",Address);//address1 field
		//type("xpath;.//*[@id='appartment']",apartment);//address2 field
		type("xpath;.//*[@id='zip-code']",zipcode);//zip code field
		clickOnElement("xpath;.//*[@id='localization_checkavailability']");
		sleep(5);
		if(getCurrentUrl().contains("address-does-not-match")){
			clickOnElement("xpath;//*[text()[contains(.,'Yes')]]");
			clickOnElement("xpath;(//*[text()='Continue'])[1]");
			sleep(10);
			wait(Until.elementToBeDisplayed("xpath;.//*[@id='existing_login']"));
			clickOnElement("xpath;.//*[@id='existing_login']");
			 
			wait(Until.elementToBeDisplayed("xpath;.//*[@name='accountNumber']"));
			type("xpath;.//*[@name='accountNumber']",AccountNum);
			clickOnElement("xpath;//*[@ng-click='authenticateSecurityCode()']");
			sleep(10);
		}
		if(getCurrentUrl().contains("multiple-addresses")){
			clickOnElement("xpath;//*[text()[contains(.,'"+apartment+"')]]");
			
			wait(Until.elementToBeDisplayed("xpath;.//*[@id='existing_login']"));
			clickOnElement("xpath;.//*[@id='existing_login']");
			 
			wait(Until.elementToBeDisplayed("xpath;.//*[@name='accountNumber']"));
			type("xpath;.//*[@name='accountNumber']",AccountNum);
			clickOnElement("xpath;//*[@ng-click='authenticateSecurityCode()']");
			sleep(10);
		}
		
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='choose_101001100']"));
		clickOnElement("xpath;.//*[@id='choose_101001100']");
		sleep(10);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='phone_option_port_keep_existing']"));
		clickOnElement("xpath;.//*[@id='phone_option_port_keep_existing']");
		type("xpath;//*[@type='tel']",phone);
		selectValueFromDropDown("xpath;.//*[@id='current-phone-provider']", "AT&T");
		sleep(5);
		clickOnElement("xpath;(.//*[@id='continue_btn_side_cart'])[2]");
		sleep(10);
/*		type("xpath;.//*[@id='firstname']",fname);
		type("xpath;.//*[@id='lastname']",lname );
		type("xpath;.//*[@id='phoneNumber']",phone);
		clickOnElement("xpath;.//*[@id='phone-type-home-label']");*/
		type("xpath;.//*[@id='email']",email);
		type("xpath;.//*[@id='confirm-email']",email);
		//clickOnElement("xpath;.//*[@id='over_a_year_over_1_year']");
		clickOnElement("xpath;.//*[@id='terms_agree']");
		sleep(10);
	}
	
	public void UpgradeVoiceServices(String Address, String apartment,String zipcode,String AccountNum,String email){
		wait(Until.elementToBeDisplayed("xpath;(//*[contains(text(),'Upgrade')][contains(@href,'phone-service')])[2]"));
		clickOnElement("xpath;(//*[contains(text(),'Upgrade')][contains(@href,'phone-service')])[2]");
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='BestOffers_CSV']"));
		clickOnElement("xpath;.//*[@id='BestOffers_CSV']");
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='402500-402590001-BundlePage']/a"));
		clickOnElement("xpath;.//*[@id='402500-402590001-BundlePage']/a");
		sleep(5);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='address']"));
		type("xpath;.//*[@id='address']",Address);//address1 field
		type("xpath;.//*[@id='appartment']",apartment);//address2 field
		type("xpath;.//*[@id='zip-code']",zipcode);//zip code field
		
		clickOnElement("xpath;.//*[@id='get_online_only_deals']");
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='existing_login']"));
		clickOnElement("xpath;.//*[@id='existing_login']");
		
		wait(Until.elementToBeDisplayed("xpath;.//*[@name='accountNumber']"));
		type("xpath;.//*[@name='accountNumber']",AccountNum);
		clickOnElement("xpath;//*[@ng-click='authenticateSecurityCode()']");
		sleep(10);
		
		wait(Until.elementToBeDisplayed("xpath;(//*[text()='Continue'])[2]"));
		clickOnElement("xpath;(//*[text()='Continue'])[2]");//continue order button
		
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='email']"));
		type("xpath;.//*[@id='email']",email);//email field
		type("xpath;.//*[@id='confirm-email']",email);//confirm email field
		clickOnElement("xpath;.//*[@id='terms_agree']");//agree terms
		
		clickOnElement("xpath;.//*[@id='registration-submit']");//submit order
		sleep(10);
		
		if(isElementPresent("xpath;//*[@class='title-primaryOut']")){
			if(getText("xpath;//*[@class='title-primaryOut']").contains("complete")){
				System.out.println("Upgrade Flow for Internet Successful");
			}
			System.out.println("Confirmation message: "+getText("xpath;//*[@class='title-primaryOut']"));
			System.out.println("Order summary: "+getText("xpath;//*[contains(@class,'Summary')]"));
		}
		
		driver.navigate().to(URL);
	}
	
	public void UpgradeTVServices(String Address, String apartment,String zipcode,String AccountNum,String email){
		wait(Until.elementToBeDisplayed("xpath;(//*[contains(text(),'Upgrade')][contains(@href,'tv-service')])[2]"));
		clickOnElement("xpath;(//*[contains(text(),'Upgrade')][contains(@href,'tv-service')])[2]");
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='BestOffers_CSTV']"));
		clickOnElement("xpath;.//*[@id='BestOffers_CSTV']");
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='405500-405590001-BundlePage']/a"));
		clickOnElement("xpath;.//*[@id='405500-405590001-BundlePage']/a");
		
		type("xpath;.//*[@id='address']",Address);
		type("xpath;.//*[@id='appartment']",apartment);
		type("xpath;.//*[@id='zip-code']",zipcode);
		
		clickOnElement("xpath;.//*[@id='get_online_only_deals']");
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='existing_login']"));
		clickOnElement("xpath;.//*[@id='existing_login']");
		
		wait(Until.elementToBeDisplayed("xpath;.//*[@name='accountNumber']"));
		type("xpath;.//*[@name='accountNumber']",AccountNum);
		clickOnElement("xpath;//*[@ng-click='authenticateSecurityCode()']");
		sleep(10);
		
		wait(Until.elementToBeDisplayed("xpath;(//*[text()='Continue'])[2]"));
		clickOnElement("xpath;(//*[text()='Continue'])[2]");//continue order button
		
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='email']"));
		type("xpath;.//*[@id='email']",email);//email field
		type("xpath;.//*[@id='confirm-email']",email);//confirm email field
		clickOnElement("xpath;.//*[@id='terms_agree']");//agree terms
		
		clickOnElement("xpath;.//*[@id='registration-submit']");//submit order
		sleep(10);
		
		if(isElementPresent("xpath;//*[@class='title-primaryOut']")){
			if(getText("xpath;//*[@class='title-primaryOut']").contains("complete")){
				System.out.println("Upgrade Flow for Internet Successful");
			}
			System.out.println("Confirmation message: "+getText("xpath;//*[@class='title-primaryOut']"));
			System.out.println("Order summary: "+getText("xpath;//*[contains(@class,'Summary')]"));
		}
		
		driver.navigate().to(URL);
	}
	
	public void UpgradeTV(String Address, String apartment,String zipcode,String AccountNum,String email,String fname,String lname,String phone){
		wait(Until.elementToBeDisplayed("xpath;(//*[contains(text(),'Upgrade')][contains(@cc-link,'TV')])[2]"));
		clickOnElement("xpath;(//*[contains(text(),'Upgrade')][contains(@cc-link,'TV')])[2]");
		sleep(5);
		driver.navigate().to("https://www.charter.com/buyflow/buyflow-localization-resp");
		sleep(5);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='address']"));
		type("xpath;.//*[@id='address']",Address);//address1 field
		type("xpath;.//*[@id='appartment']",apartment);//address2 field
		type("xpath;.//*[@id='zip-code']",zipcode);//zip code field
		clickOnElement("xpath;.//*[@id='localization_checkavailability']");
		sleep(5);
		if(getCurrentUrl().contains("multiple-addresses")){
			clickOnElement("xpath;//*[text()[contains(.,'"+apartment+"')]]");
			
			wait(Until.elementToBeDisplayed("xpath;.//*[@id='existing_login']"));
			clickOnElement("xpath;.//*[@id='existing_login']");
			 
			wait(Until.elementToBeDisplayed("xpath;.//*[@name='accountNumber']"));
			type("xpath;.//*[@name='accountNumber']",AccountNum);
			clickOnElement("xpath;//*[@ng-click='authenticateSecurityCode()']");
			sleep(10);
		}
		
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='choose_101100000']"));
		clickOnElement("xpath;.//*[@id='choose_101100000']");
		sleep(10);
		wait(Until.elementToBeDisplayed("xpath;//*[@id='tv_option_dvr_no']/.."));
		clickOnElement("xpath;//*[@id='tv_option_dvr_no']/..");
		sleep(5);
		clickOnElement("xpath;(.//*[@id='continue_btn_side_cart'])[2]");
		sleep(10);
		type("xpath;.//*[@id='firstname']",fname);
		type("xpath;.//*[@id='lastname']",lname );
		type("xpath;.//*[@id='phoneNumber']",phone);
		clickOnElement("xpath;.//*[@id='phone-type-home-label']");
		type("xpath;.//*[@id='email']",email);
		type("xpath;.//*[@id='confirm-email']",email);
		clickOnElement("xpath;.//*[@id='over_a_year_over_1_year']");
		clickOnElement("xpath;.//*[@id='terms_agree']");
		sleep(10);
	}
	
	public void UpgradeInternetServices(String Address, String apartment,String zipcode,String AccountNum, String email){
		wait(Until.elementToBeDisplayed("xpath;(//*[contains(text(),'Upgrade')][contains(@href,'internet-service')])[2]"));
		clickOnElement("xpath;(//*[contains(text(),'Upgrade')][contains(@href,'internet-service')])[2]");
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='BestOffers_CSI']"));
		clickOnElement("xpath;.//*[@id='BestOffers_CSI']");
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='406500-406590101-BundlePage']/a"));
		clickOnElement("xpath;.//*[@id='406500-406590101-BundlePage']/a");
		sleep(5);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='address']"));
		type("xpath;.//*[@id='address']",Address);//address1 field
		type("xpath;.//*[@id='appartment']",apartment);//address2 field
		type("xpath;.//*[@id='zip-code']",zipcode);//zip code field
		
		clickOnElement("xpath;.//*[@id='get_online_only_deals']");//get offers and deals button
		sleep(5);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='existing_login']"));
		clickOnElement("xpath;.//*[@id='existing_login']");//existing login button
		sleep(5);
		wait(Until.elementToBeDisplayed("xpath;.//*[@name='accountNumber']"));
		type("xpath;.//*[@name='accountNumber']",AccountNum);//account number field
		wait(Until.elementToBeDisplayed("xpath;//*[@ng-click='authenticateSecurityCode()']"));
		clickOnElement("xpath;//*[@ng-click='authenticateSecurityCode()']");//log in button
		sleep(10);
		
		wait(Until.elementToBeDisplayed("xpath;(//*[text()='Continue'])[2]"));
		clickOnElement("xpath;(//*[text()='Continue'])[2]");//continue order button
		
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='email']"));
		type("xpath;.//*[@id='email']",email);//email field
		type("xpath;.//*[@id='confirm-email']",email);//confirm email field
		clickOnElement("xpath;.//*[@id='terms_agree']");//agree terms
		
		clickOnElement("xpath;.//*[@id='registration-submit']");//submit order
		sleep(10);
		
		if(isElementPresent("xpath;//*[@class='title-primaryOut']")){
			if(getText("xpath;//*[@class='title-primaryOut']").contains("complete")){
				System.out.println("Upgrade Flow for Internet Successful");
			}
			System.out.println("Confirmation message: "+getText("xpath;//*[@class='title-primaryOut']"));
			System.out.println("Order summary: "+getText("xpath;//*[contains(@class,'Summary')]"));
		}
		
		driver.navigate().to(URL);
	}
	
	public void UpgradeInternet(String Address, String apartment,String zipcode,String AccountNum,String email,String fname,String lname,String phone){
		wait(Until.elementToBeDisplayed("xpath;(//*[contains(text(),'Upgrade')][contains(@cc-link,'Internet')])[2]"));
		clickOnElement("xpath;(//*[contains(text(),'Upgrade')][contains(@cc-link,'Internet')])[2]");
		sleep(5);
		driver.navigate().to("https://www.charter.com/buyflow/buyflow-localization-resp");
		sleep(5);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='address']"));
		type("xpath;.//*[@id='address']",Address);//address1 field
		//type("xpath;.//*[@id='appartment']",apartment);//address2 field
		type("xpath;.//*[@id='zip-code']",zipcode);//zip code field
		clickOnElement("xpath;.//*[@id='localization_checkavailability']");
		sleep(5);
		if(getCurrentUrl().contains("address-does-not-match")){
			clickOnElement("xpath;//*[text()[contains(.,'Yes')]]");
			clickOnElement("xpath;(//*[text()='Continue'])[1]");
			sleep(10);
			wait(Until.elementToBeDisplayed("xpath;.//*[@id='existing_login']"));
			clickOnElement("xpath;.//*[@id='existing_login']");
			 
			wait(Until.elementToBeDisplayed("xpath;.//*[@name='accountNumber']"));
			type("xpath;.//*[@name='accountNumber']",AccountNum);
			clickOnElement("xpath;//*[@ng-click='authenticateSecurityCode()']");
			sleep(10);
		}
		if(getCurrentUrl().contains("multiple-addresses")){
			clickOnElement("xpath;//*[text()[contains(.,'"+apartment+"')]]");
			
			wait(Until.elementToBeDisplayed("xpath;.//*[@id='existing_login']"));
			clickOnElement("xpath;.//*[@id='existing_login']");
			 
			wait(Until.elementToBeDisplayed("xpath;.//*[@name='accountNumber']"));
			type("xpath;.//*[@name='accountNumber']",AccountNum);
			clickOnElement("xpath;//*[@ng-click='authenticateSecurityCode()']");
			sleep(10);
		}
		
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='upgrade_101010100']"));
		clickOnElement("xpath;.//*[@id='upgrade_101010100']");
		sleep(10);
		wait(Until.elementToBeDisplayed("xpath;.//*[@id='autoCust4065202_no']"));
		clickOnElement("xpath;.//*[@id='autoCust4065202_no']");
		sleep(5);
		clickOnElement("xpath;(.//*[@id='continue_btn_side_cart'])[2]");
		sleep(10);
/*		type("xpath;.//*[@id='firstname']",fname);
		type("xpath;.//*[@id='lastname']",lname );
		type("xpath;.//*[@id='phoneNumber']",phone);
		clickOnElement("xpath;.//*[@id='phone-type-home-label']");*/
		type("xpath;.//*[@id='email']",email);
		type("xpath;.//*[@id='confirm-email']",email);
		//clickOnElement("xpath;.//*[@id='over_a_year_over_1_year']");
		clickOnElement("xpath;.//*[@id='terms_agree']");
		sleep(10);
	}
	
	public void tvEquipmentSection(){
		if(isElementVisible("xpath;//*[text()='Nickname Device']")){
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//*[text()='Nickname Device']")));
			System.out.println("Nickname Device link is available under TV equipment section");
			clickOnElement("xpath;//*[text()='Nickname Device']");
			System.out.println("Nickname Device link opens URL : "+getCurrentUrl());
			sleep(10);
			openMyAccountTab();
		}
		
		if(isElementVisible("xpath;//*[text()='View Channel Lineup']")){
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//*[text()='View Channel Lineup']")));
			System.out.println("View Channel Lineup link is available under TV equipment section");
			clickOnElement("xpath;//*[text()='View Channel Lineup']");
			System.out.println("View Channel Lineup link opens URL : "+getCurrentUrl());
			sleep(10);
			openMyAccountTab();
		}
	}
	
	public void verifyNonCPNI(){
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if(isElementVisible("xpath;.//*[@id='MAC']")){
			System.out.println("CPNI Road Block displayed- User is Non CPNI");
			//type("xpath;.//*[@id='MAC']",mac);
			//clickOnElement("xpath;//*[@value='Submit']");
			sleep(10);
		}
	}
	
	public void verifyCPNI(String mac){
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if(isElementVisible("xpath;.//*[@id='MAC']")){
			System.out.println("CPNI Road Block displayed- User is Non CPNI");
			type("xpath;.//*[@id='MAC']",mac);
			clickOnElement("xpath;//*[@value='Submit']");
			sleep(10);
		}
	}
}
