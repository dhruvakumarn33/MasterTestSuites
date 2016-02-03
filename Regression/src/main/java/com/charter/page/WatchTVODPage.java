package com.charter.page;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.cognizant.framework.ajax.Until;
import com.cognizant.framework.core.CaptureScreenshot;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.WebDriverBase;

public class WatchTVODPage extends WebDriverBase{
	CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);
	
	private String Scroll_next = ReadFromExcel.getLocator("WatchTVODPage","Scroll_next");
	private String Scroll_prev = ReadFromExcel.getLocator("WatchTVODPage","Scroll_prev");
	private String Movies_next = ReadFromExcel.getLocator("WatchTVODPage","Movies_next");
	private String Movies_prev = ReadFromExcel.getLocator("WatchTVODPage","Movies_prev");
	private String TVShows_next = ReadFromExcel.getLocator("WatchTVODPage","TVShows_next");
	private String TVShows_prev = ReadFromExcel.getLocator("WatchTVODPage","TVShows_prev");
	private String Networks_next = ReadFromExcel.getLocator("WatchTVODPage","Networks_next");
	private String Networks_prev = ReadFromExcel.getLocator("WatchTVODPage","Networks_prev");
	private String Premiums_next = ReadFromExcel.getLocator("WatchTVODPage","Premiums_next");
	private String Premiums_prev = ReadFromExcel.getLocator("WatchTVODPage","Premiums_prev");
	
	private String Movies_tab = ReadFromExcel.getLocator("WatchTVODPage","Movies_tab");
	private String TVshows_tab = ReadFromExcel.getLocator("WatchTVODPage","TVshows_tab");
	private String Premiums_tab = ReadFromExcel.getLocator("WatchTVODPage","Premiums_tab");
	private String Networks_tab = ReadFromExcel.getLocator("WatchTVODPage","Networks_tab");
	private String Networks_grid = ReadFromExcel.getLocator("WatchTVODPage","Networks_grid");
	
	private String PlayMovie_Online = ReadFromExcel.getLocator("WatchTVODPage","PlayMovie_Online");
	private String ClosePlayer = ReadFromExcel.getLocator("WatchTVODPage","ClosePlayer");
	private String WatchOnTV = ReadFromExcel.getLocator("WatchTVODPage","WatchOnTV");
	private String SelectMovie = ReadFromExcel.getLocator("WatchTVODPage","SelectMovie");
	private String MovieInfo = ReadFromExcel.getLocator("WatchTVODPage","MovieInfo");
	private String STB_select = ReadFromExcel.getLocator("WatchTVODPage","STB_select");
	private String STB1 = ReadFromExcel.getLocator("WatchTVODPage","STB1");
	private String StartOnDemand = ReadFromExcel.getLocator("WatchTVODPage","StartOnDemand");
	private String OnDemandModal = ReadFromExcel.getLocator("WatchTVODPage","OnDemandModal");
	private String SendToTV = ReadFromExcel.getLocator("WatchTVODPage","SendToTV");
	private String SentToTV = ReadFromExcel.getLocator("WatchTVODPage","SentToTV");
	private String Okbtn = ReadFromExcel.getLocator("WatchTVODPage","Okbtn");
	private String premiumMovieInfo = ReadFromExcel.getLocator("WatchTVODPage","premiumMovieInfo");
	private String watchLive = ReadFromExcel.getLocator("WatchTVpage","watchLive");
	
	private String PremiumMovies_header = ReadFromExcel.getLocator("WatchTVODPage","PremiumMovies_header");
	private String AllPremiumMovies_Tab = ReadFromExcel.getLocator("WatchTVODPage","AllPremiumMovies_Tab");
	private String ActionMovies_Tab = ReadFromExcel.getLocator("WatchTVODPage","ActionMovies_Tab");
	private String BiographyWarMovies_Tab = ReadFromExcel.getLocator("WatchTVODPage","BiographyWarMovies_Tab");
	private String ComedyMovies_Tab = ReadFromExcel.getLocator("WatchTVODPage","ComedyMovies_Tab");
	private String CrimeMovies_Tab = ReadFromExcel.getLocator("WatchTVODPage","CrimeMovies_Tab");
	private String DramaMovies_Tab = ReadFromExcel.getLocator("WatchTVODPage","DramaMovies_Tab");
	private String DocumentaryMovies_Tab = ReadFromExcel.getLocator("WatchTVODPage","DocumentaryMovies_Tab");
	private String RomanceMovies_Tab = ReadFromExcel.getLocator("WatchTVODPage","RomanceMovies_Tab");
	private String ThrillerMovies_Tab = ReadFromExcel.getLocator("WatchTVODPage","ThrillerMovies_Tab");
	private String WesternMovies_Tab = ReadFromExcel.getLocator("WatchTVODPage","WesternMovies_Tab");
	private String PremiumTV_header = ReadFromExcel.getLocator("WatchTVODPage","PremiumTV_header");
	private String AllTV_Tab = ReadFromExcel.getLocator("WatchTVODPage","AllTV_Tab");
	private String ComedyTV_Tab = ReadFromExcel.getLocator("WatchTVODPage","ComedyTV_Tab");
	private String DramaTV_tab = ReadFromExcel.getLocator("WatchTVODPage","DramaTV_tab");
	private String SitcomTV_Tab = ReadFromExcel.getLocator("WatchTVODPage","SitcomTV_Tab");
	
	public WatchTVODPage(WebDriver driver) {
		this.driver=driver;	
	}
	
	public void Scrolling(){
		wait(Until.elementToBeDisplayed(Scroll_next));
		clickOnElement(Scroll_next);
		clickOnElement(Scroll_prev);
	}
	
	public boolean CheckMoviesTab(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(Movies_next));
		clickOnElement(Movies_next);
		clickOnElement(Movies_prev);
		retVal=true;
		return retVal;
	}
	
	public boolean CheckTVShowsTab(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(TVShows_next));
		clickOnElement(TVShows_next);
		clickOnElement(TVShows_prev);
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
	
	public boolean CheckPremiumsTab(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(Premiums_next));
		clickOnElement(Premiums_next);
		clickOnElement(Premiums_prev);
		retVal=true;
		return retVal;
	}
	
	public boolean OnDemandCheckTabs(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(Movies_tab));
		clickOnElement(Movies_tab);
		Scrolling();
		wait(Until.elementToBeDisplayed(TVshows_tab));
		clickOnElement(TVshows_tab);
		Scrolling();
		wait(Until.elementToBeDisplayed(Premiums_tab));
		clickOnElement(Premiums_tab);
		Scrolling();
		wait(Until.elementToBeDisplayed(Networks_tab));
		clickOnElement(Networks_tab);
		wait(Until.elementToBeDisplayed(Networks_grid));
		if(isElementPresent(Networks_grid))
		retVal=true;
		return retVal;
	}
	
	public boolean checkOnDemandSections(){
		boolean retVal=false;
		CheckMoviesTab();
		CheckNetworksTab();
		CheckPremiumsTab();
		CheckTVShowsTab();
		retVal=true;
		return retVal;
	}
	
	public void OpenWatchOnTV(){
		clickOnElement(WatchOnTV);
		System.out.println("User Navigated to WatchOn TV page:"+ driver.getCurrentUrl());
	}
	
	public boolean WatchOnlineMovie(){
		boolean retVal=false;
		selectAsset();
		clickOnElement(PlayMovie_Online);
		clickOnElement(ClosePlayer);
		retVal=true;
		return retVal;
	}
	
	public boolean StartOnDemand(){
		boolean retVal=false;
		selectAsset();
		clickOnElement(STB_select);
		clickOnElement(STB1);
		clickOnElement(StartOnDemand);
		clickOnElement(SendToTV);
		if(isElementVisible(SentToTV)){
			System.out.println(driver.findElement(By.xpath("//div[@class='start-on-demand-asset-success-modal ng-binding ng-scope']")).getText());
		}
		clickOnElement(Okbtn);
		clickOnElement(ClosePlayer);
		retVal=true;
		return retVal;
	}
	
	public void selectAsset(){
		wait(Until.elementToBeDisplayed(SelectMovie));
		sleep(2);
		goToUrl(getAttribute(MovieInfo,"href"));
	}
	
	public boolean OpenPremiumAssets(){
		boolean retVal = false;
		boolean retVal1 = false;
		boolean retVal2 = false;
		clickOnElement(Premiums_tab);
		sleep(10);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if(isElementVisible(PremiumTV_header)){
			if(isElementVisible(AllTV_Tab) & isElementVisible(ComedyTV_Tab) & 
					isElementVisible(DramaTV_tab) & isElementVisible(SitcomTV_Tab)){
				System.out.println(driver.getCurrentUrl());
				retVal1=true;
			}
			else{
				System.out.println("Premium TV Sections not visible");
				String Folder = "PremiumTVAssetSectionsError";
				screenshot.saveScreenshot("WatchTV"+ File.separator + Folder);
			}
		}
		else{
			System.out.println("Premium TV Header not visible");
			String Folder = "PremiumTVAssetHeaderError";
			screenshot.saveScreenshot("WatchTV"+ File.separator + Folder);
		}
		if(isElementVisible(PremiumMovies_header)){
			if(isElementVisible(AllPremiumMovies_Tab) & isElementVisible(ActionMovies_Tab) & 
					isElementVisible(BiographyWarMovies_Tab) & isElementVisible(ComedyMovies_Tab) & 
					isElementVisible(CrimeMovies_Tab) & isElementVisible(DramaMovies_Tab) & 
					isElementVisible(DocumentaryMovies_Tab) & isElementVisible(RomanceMovies_Tab) & 
					isElementVisible(ThrillerMovies_Tab) & isElementVisible(WesternMovies_Tab)){
				System.out.println(driver.getCurrentUrl());
				retVal2=true;
			}
			else{
				System.out.println("Premium Movies Sections not visible");
				String Folder = "PremiumMovieAssetSectionsError";
				screenshot.saveScreenshot("WatchTV"+ File.separator + Folder);
			}
		}
		else{
			System.out.println("Premium Movies Header not visible");
			String Folder = "PremiumMovieAssetHeaderError";
			screenshot.saveScreenshot("WatchTV"+ File.separator + Folder);
		}
		retVal = retVal1 & retVal2;
		return retVal;
	}
	
	public void selectPremiumAsset(){
		wait(Until.elementToBeDisplayed(SelectMovie));
		sleep(2);
		goToUrl(getAttribute(premiumMovieInfo,"href"));
	}
	
	public boolean WatchPremiumMovie(){
		boolean retVal=false;
		selectPremiumAsset();
		clickOnElement(PlayMovie_Online);
		sleep(10);
		clickOnElement(ClosePlayer);
		sleep(5);
		retVal=true;
		return retVal;
	}
	
	public boolean WatchLive(){
		boolean retVal=false;
		selectAsset();
		clickOnElement(STB_select);
		clickOnElement(STB1);
		clickOnElement(watchLive);
		clickOnElement(SendToTV);
		if(isElementVisible(SentToTV)){
			System.out.println(driver.findElement(By.xpath("//div[@class='start-on-demand-asset-success-modal ng-binding ng-scope']")).getText());
		}
		clickOnElement(Okbtn);
		clickOnElement(ClosePlayer);
		retVal=true;
		return retVal;
	}

}
