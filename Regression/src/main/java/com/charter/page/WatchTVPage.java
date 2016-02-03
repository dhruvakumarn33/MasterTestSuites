package com.charter.page;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.charter.utils.Constants;
import com.cognizant.framework.ajax.Until;
import com.cognizant.framework.core.CaptureScreenshot;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.WebDriverBase;

public class WatchTVPage extends WebDriverBase{
	private String URL= Constants.URL;
	CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);
	
	private String OnDemand = ReadFromExcel.getLocator("WatchTVpage","OnDemand");
	private String WatchTV = ReadFromExcel.getLocator("WatchTVpage","Watchtv");
	private String Guide_link = ReadFromExcel.getLocator("WatchTVpage","Guide_link");
	private String TVGuide = ReadFromExcel.getLocator("WatchTVpage","TVGuide");
	private String LiveTV_link = ReadFromExcel.getLocator("WatchTVpage","LiveTV_link");
	private String Networks_next = ReadFromExcel.getLocator("WatchTVpage","Networks_next");
	private String Networks_prev = ReadFromExcel.getLocator("WatchTVpage","Networks_prev");
	private String Ondemand_next = ReadFromExcel.getLocator("WatchTVpage","Ondemand_next");
	private String Ondemand_prev = ReadFromExcel.getLocator("WatchTVpage","Ondemand_prev");
	private String LiveTV_next = ReadFromExcel.getLocator("WatchTVpage","Ondemand_next");
	private String LiveTV_prev = ReadFromExcel.getLocator("WatchTVpage","Ondemand_prev");
	private String Networks = ReadFromExcel.getLocator("WatchTVpage","Networks");
	private String OpenChannel = ReadFromExcel.getLocator("WatchTVpage","OpenChannel");
	private String PlayChannel = ReadFromExcel.getLocator("WatchTVpage","PlayChannel");
	private String Program = ReadFromExcel.getLocator("WatchTVpage","Program");
	
	private String Movies_tab = ReadFromExcel.getLocator("WatchTVODPage","Movies_tab");
	private String TVshows_tab = ReadFromExcel.getLocator("WatchTVODPage","TVshows_tab");
	private String Networks_tab = ReadFromExcel.getLocator("WatchTVODPage","Networks_tab");
	private String Premiums_tab = ReadFromExcel.getLocator("WatchTVODPage","Premiums_tab");
	
	public WatchTVPage(WebDriver driver) {
		this.driver=driver;	
	}
	
	public boolean OpenWatchTVTab(){
		boolean retVal=false;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if(isElementVisible(WatchTV)){
			clickOnElement(WatchTV);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			if(isElementVisible("xpath;//h4[text()='Guide']") & isElementVisible("xpath;//h4[text()='Watch TV']") & isElementVisible("xpath;//h4[text()='On Demand']")){
				System.out.println("User Navigated to WatchTV Overview page:"+ driver.getCurrentUrl());
				retVal=true;
			}
			else{
				System.out.println("Watch TV overview page not loaded completely");
				String Folder = "WatchTVPageLoadError";
				screenshot.saveScreenshot("WatchTV"+ File.separator + Folder);
			}
		}
		else{
			System.out.println("Watch TV link not visible");
			String Folder = "WatchTVLinkError";
			screenshot.saveScreenshot("WatchTV"+ File.separator + Folder);
		}
		return retVal;
	}	
	
	public boolean OpenOnDemand(){
		boolean retVal=false;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if(isElementVisible(OnDemand)){
			clickOnElement(OnDemand);
			sleep(10);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			if(isElementVisible(Movies_tab) & isElementVisible(TVshows_tab) & isElementVisible(Networks_tab) & isElementVisible(Premiums_tab)){
				System.out.println("User Navigated to OnDemand page:"+ driver.getCurrentUrl());
				retVal=true;
			}
		}
		return retVal;
	}
	
	public boolean OpenGuideLink(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(Guide_link));
		hoverOver(Guide_link);
		clickOnElement(Guide_link);
		System.out.println("User Navigated to Guide page:"+ driver.getCurrentUrl());
		retVal=true;
		return retVal;
	}
	
	public boolean OpenTVGuide(){
		boolean retVal=false;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if(isElementVisible(TVGuide)){
			clickOnElement(TVGuide);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			if(isElementVisible("xpath;//*[@class='guide-container container']")){
				System.out.println("User Navigated to TVGuide page: "+ driver.getCurrentUrl());
				retVal=true;
			}
			else{
				System.out.println("Guide page loading unsuccessfull");
				String Folder = "GuidePageLoadError";
				screenshot.saveScreenshot("WatchTV"+ File.separator + Folder);
			}
		}
		else{
			System.out.println("TV Guide Link not visible");
			String Folder = "TVGuideLinkError";
			screenshot.saveScreenshot("WatchTV"+ File.separator + Folder);
		}
		return retVal;
	}

	public boolean OpenLiveTVLink(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(LiveTV_link));
		hoverOver(LiveTV_link);
		clickOnElement(LiveTV_link);
		System.out.println("User Navigated to LiveTV page:"+ driver.getCurrentUrl());
		retVal=true;
		return retVal;
	}
	
	public boolean CheckNetworksTab(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(Networks_next));
		clickOnElement(Networks_next);
		clickOnElement(Networks_prev);
		retVal=true;
		return retVal;
	}
	
	public boolean CheckOndemandTab(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(Ondemand_next));
		clickOnElement(Ondemand_next);
		clickOnElement(Ondemand_prev);
		retVal=true;
		return retVal;
	}
	
	public boolean CheckLiveTVTab(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(LiveTV_next));
		clickOnElement(LiveTV_next);
		clickOnElement(LiveTV_prev);
		clickOnElement(LiveTV_prev);
		retVal=true;
		return retVal;
	}
	
	public boolean PlayChannel(){
		boolean retVal=false;
		clickOnElement(Networks);
		driver.navigate().to("http://www.charter.net/tv/on-demand/watch-online/networks/telemundo/");
		hoverOver(Program);
		clickOnElement(OpenChannel);
		clickOnElement(PlayChannel);
		retVal=true;
		return retVal;
	}
	
	public void PlayMovie(){
		driver.navigate().to(URL+"/tv/watch-online/content/Fifty-Shades-of-Grey-31561019/");
		sleep(20);
		wait(Until.elementToBeClickable(PlayChannel));
		clickOnElement(PlayChannel);
		sleep(5);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(isElementVisible("xpath;//*[text()='Parental Restriction']")){
			System.out.println("Asset locked by Parental Control");
			sleep(5);
			clickOnElement("xpath;(//*[@id='modal-close-btn'])[2]");
		}
		else if(isElementVisible("xpath;//*[@id='vam-player-modal']")){
			System.out.println("Asset allowed by parental Control ");
			sleep(5);
			clickOnElement("xpath;(//*[@id='modal-close-btn'])[2]");
		}
		
	}
	
}
