package com.charter.page;

import org.openqa.selenium.WebDriver;

import com.cognizant.framework.ajax.Until;
import com.cognizant.framework.core.CaptureScreenshot;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.WebDriverBase;

public class TVSupportPage extends WebDriverBase {
	
	private static String SupportTVTab=ReadFromExcel.getLocator("SupportTVPage", "SupportTVTab");
	private static String CharterTVService=ReadFromExcel.getLocator("SupportTVPage", "CharterTVService");
	private static String TVEquipment=ReadFromExcel.getLocator("SupportTVPage", "TVEquipment");
	private static String TVOnline=ReadFromExcel.getLocator("SupportTVPage", "TVOnline");
	private static String ProgramGuides=ReadFromExcel.getLocator("SupportTVPage", "ProgramGuides");
	private static String HD=ReadFromExcel.getLocator("SupportTVPage", "HD");
	private static String PayPerView=ReadFromExcel.getLocator("SupportTVPage", "PayPerView");
	private static String Troubleshooting=ReadFromExcel.getLocator("SupportTVPage", "Troubleshooting");
	private static String CharterSpectrum=ReadFromExcel.getLocator("SupportTVPage", "CharterSpectrum");
	private static String DigitalReceiver=ReadFromExcel.getLocator("SupportTVPage", "DigitalReceiver");
	private static String SeeIT=ReadFromExcel.getLocator("SupportTVPage", "SeeIT");
	private static String WatchTVGuide=ReadFromExcel.getLocator("SupportTVPage", "WatchTVGuide");
	private static String HDAutoTune=ReadFromExcel.getLocator("SupportTVPage", "HDAutoTune");
	private static String SpectrumOD=ReadFromExcel.getLocator("SupportTVPage", "SpectrumOD");
	private static String TVTroubleshooting=ReadFromExcel.getLocator("SupportTVPage", "TVTroubleshooting");
	
	private static String Article_Rating=ReadFromExcel.getLocator("SupportPage", "Article_Rating");
	
	
	CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);	
	
	public TVSupportPage(WebDriver driver){
		this.driver=driver;
	}
	
	public boolean SupportTVTab(){
		boolean retVal=false;
		hoverOver(SupportTVTab);
		clickOnElement(SupportTVTab);
		System.out.println("User Navigated to TVSupport page:"+ driver.getCurrentUrl());
		retVal=true;
		return retVal;
	}
	
	public boolean CharterTVService(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(CharterTVService));
		clickOnElement(CharterTVService);
		clickOnElement(CharterSpectrum);
		System.out.println("User Navigated to TVSupport page:"+ driver.getCurrentUrl());
		if(isElementPresent(Article_Rating)){
			retVal=true;
		}
		return retVal;
	}
	
	public boolean TVEquipment(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(TVEquipment));
		clickOnElement(TVEquipment);
		clickOnElement(DigitalReceiver);
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
		clickOnElement(SeeIT);
		System.out.println("User Navigated to TVSupport page:"+ driver.getCurrentUrl());
		if(isElementPresent(Article_Rating)){
			retVal=true;
		}
		return retVal;
	}
	
	public boolean ProgramGuides(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(ProgramGuides));
		clickOnElement(ProgramGuides);
		clickOnElement(WatchTVGuide);
		System.out.println("User Navigated to TVSupport page:"+ driver.getCurrentUrl());
		if(isElementPresent(Article_Rating)){
			retVal=true;
		}
		return retVal;
	}
	
	public boolean HD(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(HD));
		clickOnElement(HD);
		clickOnElement(HDAutoTune);
		System.out.println("User Navigated to TVSupport page:"+ driver.getCurrentUrl());
		if(isElementPresent(Article_Rating)){
			retVal=true;
		}
		return retVal;
	}
	
	public boolean PayPerView(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(PayPerView));
		clickOnElement(PayPerView);
		clickOnElement(SpectrumOD);
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
		clickOnElement(TVTroubleshooting);
		System.out.println("User Navigated to TVSupport page:"+ driver.getCurrentUrl());
		if(isElementPresent(Article_Rating)){
			retVal=true;
		}
		return retVal;
	}
}
