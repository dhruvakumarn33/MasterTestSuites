package com.charter.page;

import org.openqa.selenium.WebDriver;

import com.cognizant.framework.ajax.Until;
import com.cognizant.framework.core.CaptureScreenshot;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.WebDriverBase;

public class InternetSupportPage extends WebDriverBase{

	private static String SupportInternetTab=ReadFromExcel.getLocator("SupportInternetPage", "SupportInternetTab");
	private static String CharterDotNet=ReadFromExcel.getLocator("SupportInternetPage", "CharterDotNet");
	private static String InternetEquipment=ReadFromExcel.getLocator("SupportInternetPage", "InternetEquipment");
	private static String Email=ReadFromExcel.getLocator("SupportInternetPage", "Email");
	private static String SecuritySuite=ReadFromExcel.getLocator("SupportInternetPage", "SecuritySuite");
	private static String Installation=ReadFromExcel.getLocator("SupportInternetPage", "Installation");
	private static String Networking=ReadFromExcel.getLocator("SupportInternetPage", "Networking");
	private static String OnlineSecurity=ReadFromExcel.getLocator("SupportInternetPage", "OnlineSecurity");
	private static String Troubleshooting=ReadFromExcel.getLocator("SupportInternetPage", "Troubleshooting");
	private static String TVOnline=ReadFromExcel.getLocator("SupportInternetPage", "TVOnline");
	private static String Wifi=ReadFromExcel.getLocator("SupportInternetPage", "Wifi");
	
	private static String CharterHelp=ReadFromExcel.getLocator("SupportInternetPage", "CharterHelp");
	private static String Modems=ReadFromExcel.getLocator("SupportInternetPage", "Modems");
	private static String EmailMobile=ReadFromExcel.getLocator("SupportInternetPage", "EmailMobile");
	private static String SecuritySuiteBP=ReadFromExcel.getLocator("SupportInternetPage", "SecuritySuiteBP");
	private static String ActivateModem=ReadFromExcel.getLocator("SupportInternetPage", "ActivateModem");
	private static String FindingWifi=ReadFromExcel.getLocator("SupportInternetPage", "FindingWifi");
	private static String EmailSecurity=ReadFromExcel.getLocator("SupportInternetPage", "EmailSecurity");
	private static String ResetModem=ReadFromExcel.getLocator("SupportInternetPage", "ResetModem");
	private static String CharterTVApp=ReadFromExcel.getLocator("SupportInternetPage", "CharterTVApp");
	private static String SpectrumWifi=ReadFromExcel.getLocator("SupportInternetPage", "SpectrumWifi");
	
	private static String Article_Rating=ReadFromExcel.getLocator("SupportPage", "Article_Rating");
	
CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);	
	
	public InternetSupportPage(WebDriver driver){
		this.driver=driver;
	}
	
	public boolean SupportInternetTab(){
		boolean retVal=false;
		hoverOver(SupportInternetTab);
		clickOnElement(SupportInternetTab);
		System.out.println("User Navigated to TVSupport page:"+ driver.getCurrentUrl());
		retVal=true;
		return retVal;
	}
	
	public boolean CharterDotNet(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(CharterDotNet));
		clickOnElement(CharterDotNet);
		clickOnElement(CharterHelp);
		System.out.println("User Navigated to TVSupport page:"+ driver.getCurrentUrl());
		if(isElementPresent(Article_Rating)){
			retVal=true;
		}
		return retVal;
	}
	
	public boolean InternetEquipment(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(InternetEquipment));
		clickOnElement(InternetEquipment);
		clickOnElement(Modems);
		System.out.println("User Navigated to TVSupport page:"+ driver.getCurrentUrl());
		if(isElementPresent(Article_Rating)){
			retVal=true;
		}
		return retVal;
	}
	
	public boolean Email(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(Email));
		clickOnElement(Email);
		clickOnElement(EmailMobile);
		System.out.println("User Navigated to TVSupport page:"+ driver.getCurrentUrl());
		if(isElementPresent(Article_Rating)){
			retVal=true;
		}
		return retVal;
	}
	
	public boolean SecuritySuite(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(SecuritySuite));
		clickOnElement(SecuritySuite);
		clickOnElement(SecuritySuiteBP);
		System.out.println("User Navigated to TVSupport page:"+ driver.getCurrentUrl());
		if(isElementPresent(Article_Rating)){
			retVal=true;
		}
		return retVal;
	}
	
	public boolean Installation(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(Installation));
		clickOnElement(Installation);
		clickOnElement(ActivateModem);
		System.out.println("User Navigated to TVSupport page:"+ driver.getCurrentUrl());
		if(isElementPresent(Article_Rating)){
			retVal=true;
		}
		return retVal;
	}
	
	public boolean Networking(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(Networking));
		clickOnElement(Networking);
		clickOnElement(FindingWifi);
		System.out.println("User Navigated to TVSupport page:"+ driver.getCurrentUrl());
		if(isElementPresent(Article_Rating)){
			retVal=true;
		}
		return retVal;
	}
	
	public boolean OnlineSecurity(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(OnlineSecurity));
		clickOnElement(OnlineSecurity);
		clickOnElement(EmailSecurity);
		System.out.println("User Navigated to TVSupport page:"+ driver.getCurrentUrl());
		if(isElementPresent(Article_Rating)){
			retVal=true;
		}
		return retVal;
	}
	
	public boolean Troubleshooting(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(Troubleshooting));
		clickOnElement(Troubleshooting);
		clickOnElement(ResetModem);
		System.out.println("User Navigated to TVSupport page:"+ driver.getCurrentUrl());
		if(isElementPresent(Article_Rating)){
			retVal=true;
		}
		return retVal;
	}
	
	public boolean TVOnline(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(TVOnline));
		clickOnElement(TVOnline);
		clickOnElement(CharterTVApp);
		System.out.println("User Navigated to TVSupport page:"+ driver.getCurrentUrl());
		if(isElementPresent(Article_Rating)){
			retVal=true;
		}
		return retVal;
	}
	
	public boolean Wifi(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(Wifi));
		clickOnElement(Wifi);
		clickOnElement(SpectrumWifi);
		System.out.println("User Navigated to TVSupport page:"+ driver.getCurrentUrl());
		if(isElementPresent(Article_Rating)){
			retVal=true;
		}
		return retVal;
	}
}
