package com.charter.page;

import org.openqa.selenium.WebDriver;

import com.cognizant.framework.ajax.Until;
import com.cognizant.framework.core.CaptureScreenshot;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.WebDriverBase;

public class VoiceSupportPage extends WebDriverBase {
	
	private static String SupportVoiceTab=ReadFromExcel.getLocator("SupportVoicePage", "SupportVoiceTab");	
	private static String Features=ReadFromExcel.getLocator("SupportVoicePage", "Features");
	private static String VoiceEquipment=ReadFromExcel.getLocator("SupportVoicePage", "VoiceEquipment");
	private static String InternationalCalling=ReadFromExcel.getLocator("SupportVoicePage", "InternationalCalling");
	private static String Troubleshooting=ReadFromExcel.getLocator("SupportVoicePage", "Troubleshooting");
	private static String CallDetails=ReadFromExcel.getLocator("SupportVoicePage", "CallDetails");
	private static String PhoneModems=ReadFromExcel.getLocator("SupportVoicePage", "PhoneModems");
	private static String MexicoCalling=ReadFromExcel.getLocator("SupportVoicePage", "MexicoCalling");
	private static String VoicemailHelp=ReadFromExcel.getLocator("SupportVoicePage", "VoicemailHelp");
	
	private static String Article_Rating=ReadFromExcel.getLocator("SupportPage", "Article_Rating");
	
CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);	
	
	public VoiceSupportPage(WebDriver driver){
		this.driver=driver;
	}
	
	public boolean SupportVoiceTab(){
		boolean retVal=false;
		hoverOver(SupportVoiceTab);
		clickOnElement(SupportVoiceTab);
		System.out.println("User Navigated to VoiceSupport page:"+ driver.getCurrentUrl());
		retVal=true;
		return retVal;
	}
	
	public boolean Features(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(Features));
		clickOnElement(Features);
		clickOnElement(CallDetails);
		System.out.println("User Navigated to VoiceSupport page:"+ driver.getCurrentUrl());
		if(isElementPresent(Article_Rating)){
			retVal=true;
		}
		return retVal;
	}
	
	public boolean VoiceEquipment(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(VoiceEquipment));
		clickOnElement(VoiceEquipment);
		clickOnElement(PhoneModems);
		System.out.println("User Navigated to VoiceSupport page:"+ driver.getCurrentUrl());
		if(isElementPresent(Article_Rating)){
			retVal=true;
		}
		return retVal;
	}
	
	public boolean InternationalCalling(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(InternationalCalling));
		clickOnElement(InternationalCalling);
		clickOnElement(MexicoCalling);
		System.out.println("User Navigated to VoiceSupport page:"+ driver.getCurrentUrl());
		if(isElementPresent(Article_Rating)){
			retVal=true;
		}
		return retVal;
	}
	
	public boolean Troubleshooting(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(Troubleshooting));
		clickOnElement(Troubleshooting);
		clickOnElement(VoicemailHelp);
		System.out.println("User Navigated to VoiceSupport page:"+ driver.getCurrentUrl());
		if(isElementPresent(Article_Rating)){
			retVal=true;
		}
		return retVal;
	}

}
