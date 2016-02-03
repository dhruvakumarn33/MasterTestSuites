package com.charter.page;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.cognizant.framework.ajax.Until;
import com.cognizant.framework.core.CaptureScreenshot;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.WebDriverBase;

public class MyAccountPage extends WebDriverBase {

	private static String MyAccountTab=ReadFromExcel.getLocator("MAPage", "MyAccountTab");
	private static String Billing=ReadFromExcel.getLocator("MAPage", "Billing");
	private static String UserPreferencelink=ReadFromExcel.getLocator("MAPage", "UserPreferencelink");
	private static String OverViewLink=ReadFromExcel.getLocator("MAPage", "OverViewLink");
	private static String InternetServlink=ReadFromExcel.getLocator("MAPage", "InternetServices");
	private static String TVServlink=ReadFromExcel.getLocator("MAPage", "TVServices");
	private static String VoiceServlink=ReadFromExcel.getLocator("MAPage", "VoiceServices");
	private static String Internetoff=ReadFromExcel.getLocator("MAPage", "Internetoff");
	private static String Tvoff=ReadFromExcel.getLocator("MAPage", "Tvoff");
	private static String Voiceoff=ReadFromExcel.getLocator("MAPage", "Voiceoff");
	CaptureScreenshot<WebDriver> screenshot;	
	public MyAccountPage(WebDriver driver) {
		this.driver=driver;
		screenshot= new CaptureScreenshot<WebDriver>(driver);
	}

	public void openMyAccountTab() {
		HomePage hp = new HomePage(driver);
		hp.pagewait();
		wait(Until.elementToBeDisplayed(MyAccountTab));
		hoverOver(MyAccountTab);
		sleep(5);
	}
	public void loadBillingAndTransactionSection() {

		wait(Until.elementToBeDisplayed(Billing));
		clickOnElement(Billing);
		HomePage hp = new HomePage(driver);
		hp.pagewait();
	}
	
	public void loadUPPage(){
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		wait(Until.elementToBeDisplayed(UserPreferencelink));
		clickOnElement(UserPreferencelink);
		HomePage hp = new HomePage(driver);
		hp.pagewait();
	}
	public void loadOverviewPage(){
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		//wait(Until.elementToBeClickable(OverViewLink));
		clickOnElement(MyAccountTab);
		HomePage hp = new HomePage(driver);
		hp.pagewait();
	}

	public void InternetServiceslink(){
		wait(Until.elementToBeDisplayed(InternetServlink));
		clickOnElement(InternetServlink);
		HomePage hp = new HomePage(driver);
		hp.pagewait();
	}
	public void TVServiceslink(){
		wait(Until.elementToBeDisplayed(TVServlink));
		clickOnElement(TVServlink);
		HomePage hp = new HomePage(driver);
		hp.pagewait();
	}
	public boolean VoiceServiceslink(){

		boolean retVal=false;
		wait(Until.elementToBeDisplayed(VoiceServlink));
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
		try{
			clickOnElement(Internetoff);
		}
		catch(Exception e){
			clickOnElement(Internetoff);
			System.out.println("Exception : "+e);
		}
	}

	public void TVwithoutLogin(){
		clickOnElement(Tvoff);
	}

	public boolean VoicewithoutLogin(){
		boolean retVal=false;
		try{
			clickOnElement(Voiceoff);
			retVal=true;
		}
		catch(Exception e){
			clickOnElement(Voiceoff);
			retVal=true;
		}
		return retVal;
	}
}
