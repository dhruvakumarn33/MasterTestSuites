package com.charter.page;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.charter.utils.Constants;
import com.cognizant.framework.ajax.Until;
import com.cognizant.framework.core.CaptureScreenshot;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.WebDriverBase;

public class WatchTVGuidePage extends WebDriverBase{
	private String URL= Constants.URL;
	CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);
	
	private String Date_next = ReadFromExcel.getLocator("WatchTVGuide","Date_next");
	private String Date_Prev = ReadFromExcel.getLocator("WatchTVGuide","Date_Prev");
	private String time_next = ReadFromExcel.getLocator("WatchTVGuide","time_next");
	private String time_prev = ReadFromExcel.getLocator("WatchTVGuide","time_prev");
	private String tvGuideSpinner = ReadFromExcel.getLocator("WatchTVGuide","tvGuideSpinner");
	private String filterToggle = ReadFromExcel.getLocator("WatchTVGuide","filterToggle");
	private String HD_filter = ReadFromExcel.getLocator("WatchTVGuide","HD_filter");
	private String filter_close = ReadFromExcel.getLocator("WatchTVGuide","filter_close");
	private String HD_channel = ReadFromExcel.getLocator("WatchTVGuide","HD_channel");
	private String programs_list = ReadFromExcel.getLocator("WatchTVGuide","programs_list");
	private String clearFilter = ReadFromExcel.getLocator("WatchTVGuide","clearFilter");
	private String sort_A_Z = ReadFromExcel.getLocator("WatchTVGuide","sort_A_Z");
	private String sort_ChannelNo = ReadFromExcel.getLocator("WatchTVGuide","sort_ChannelNo");
	private String primeTimeFilter = ReadFromExcel.getLocator("WatchTVGuide","primeTimeFilter");
	private String startOnDemand = ReadFromExcel.getLocator("WatchTVGuide","startOnDemand");
	private String record = ReadFromExcel.getLocator("WatchTVGuide", "record");
	private String GuideChannel = ReadFromExcel.getLocator("WatchTVGuide", "GuideChannel");
	private String sort_Myfav = ReadFromExcel.getLocator("WatchTVGuide", "sort_Myfav");
	private String zipcode = ReadFromExcel.getLocator("WatchTVGuide", "zipcode");
	private String PlayMovie_Online = ReadFromExcel.getLocator("WatchTVODPage","PlayMovie_Online");
	private String ClosePlayer = ReadFromExcel.getLocator("WatchTVODPage","ClosePlayer");
	private String Guide_link = ReadFromExcel.getLocator("WatchTVpage","Guide_link");
	
	public WatchTVGuidePage(WebDriver driver){
		this.driver = driver;
	}
	
	public boolean CheckDateTime(){
		boolean retVal = false;
		
		String day = driver.findElement(By.xpath("//a[@class='guide-day-tab noPreventDefault ng-scope active']/span[1]")).getText();
		String date = driver.findElement(By.xpath("//a[@class='guide-day-tab noPreventDefault ng-scope active']/span[2]")).getText();	
		String ChannelName = driver.findElement(By.xpath("(//div[@class='guide-row guide-channel']/div[2])[1]")).getText();
		String time = driver.findElement(By.xpath("//li[@class='ng-binding ng-scope active']")).getText();
		String program = driver.findElement(By.xpath("(//div[@class='guide-show']/a)[1]")).getText();
		System.out.println("Channel "+ChannelName+" is playing "+program+" today, i.e on "+date+" "+day+" at "+time);
		retVal= true;
		return retVal;
	}
	
	public boolean CheckDateNavigation(){
		boolean retVal= false;
		wait(Until.elementToBeDisplayed(Date_next));
		clickOnElement(Date_next);
		if(isElementVisible(tvGuideSpinner)){
			//wait(Until.elementToBeInvisible(tvGuideSpinner));
			wait(Until.elementToBeDisplayed(programs_list));
		}
		clickOnElement(Date_Prev);
		retVal=true;
		return retVal;
	}
	
	public boolean CheckTimeNavigation(){
		boolean retVal= false;
		wait(Until.elementToBeDisplayed(time_next));
		clickOnElement(time_next);
		/*if(isElementVisible(tvGuideSpinner)){
		  	wait(Until.elementToBeDisplayed(programs_list));
			wait(Until.elementToBeInvisible(tvGuideSpinner));
		}*/
		clickOnElement(time_prev);
		retVal=true;
		return retVal;
	}
	
	public boolean CheckFilterChannels(){
		boolean retVal= false;
		applyFilter();
		if(isElementVisible(HD_channel)){
				retVal=true;
				System.out.println("Filtered to HD channels");
		}
		sleep(5);
		return retVal;
	}
	
	public void applyFilter(){
		if(isElementVisible(tvGuideSpinner))
			wait(Until.elementToBeDisplayed(programs_list));
		clickOnElement(filterToggle);
		wait(Until.elementToBeDisplayed(HD_filter));
		clickOnElement(HD_filter);
		clickOnElement(filter_close);
	}
	
	public boolean clearFilter(){
		boolean retVal= true;
		/*if(isElementVisible(tvGuideSpinner)){
			wait(Until.elementToBeDisplayed(programs_list));
			//sleep(5);
		}*/
		wait(Until.elementToBeClickable(filterToggle));
		clickOnElement(filterToggle);
		clickOnElement(clearFilter);
		clickOnElement(filter_close);
		if(isElementVisible(HD_channel)){
			retVal=false;
			System.out.println("Filtered to HD channels");
		}
		return retVal;
	}
	
	public boolean checkAtoZsort(){
		/*if(isElementVisible(tvGuideSpinner)){
			wait(Until.elementToBeDisplayed(programs_list));
			//sleep(5);
		}*/
		boolean retVal= false;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if(isElementVisible(filterToggle)){
			sleep(5);
			clickOnElement(filterToggle);
			System.out.println("Clicked on Filter Toggle");
			if(isElementVisible(sort_A_Z)){
				clickOnElement(sort_A_Z);
				System.out.println("A-Z Filter Selected");
				if(isElementVisible(filter_close)){
					clickOnElement(filter_close);
					System.out.println("Filter Closed");
					try{
					String[] logo = new String[10];
					String[] chno = new String[10];
					String[] ch = new String[10];
					System.out.println("Sorted channels alphabetically:");
					System.out.println("");
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					for(int i=1;i<9;i++){
						ch = driver.findElement(By.xpath("(//div[@class='channel-number'])["+i+"]")).getText().split(" ");
						chno[i]= ch[1].trim();
						logo[i] = driver.findElement(By.xpath("(//img[@class = 'logo'])["+i+"]")).getAttribute("alt");
						System.out.println(i+". "+logo[i]+" ; channel num : "+chno[i]);
					}
					retVal=true;
					}
					catch(Exception e){
						System.out.println("Filtered channels are not visible");
						String Folder = "FilterChannelsError";
						screenshot.saveScreenshot("WatchTV"+ File.separator + Folder);
						System.out.println(e);
					}
				}
				else{
					System.out.println("Filter close button is not visible");
					String Folder = "GuideFilterCloseError";
					screenshot.saveScreenshot("WatchTV"+ File.separator + Folder);
				}
			}
			else{
				System.out.println("A to Z Filter option is not visible");
				String Folder = "AtoZGuideFilterError";
				screenshot.saveScreenshot("WatchTV"+ File.separator + Folder);
			}
		}
		else{
			System.out.println("Filter Toggle button is not visible");
			String Folder = "GuideFilterToggleError";
			screenshot.saveScreenshot("WatchTV"+ File.separator + Folder);
		}
		
		return retVal;
	}
	
	public boolean checkChannelNoSort(){
		/*if(isElementVisible(tvGuideSpinner)){
			wait(Until.elementToBeDisplayed(programs_list));
		}*/
		boolean retVal= false;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if(isElementVisible(filterToggle)){
			sleep(5);
			clickOnElement(filterToggle);
			System.out.println("Clicked on Filter Toggle");
			if(isElementVisible(sort_ChannelNo)){
				clickOnElement(sort_ChannelNo);
				System.out.println("Channel number sort option Selected");
				if(isElementVisible(filter_close)){
					clickOnElement(filter_close);
					System.out.println("Filter Closed");
					try{
					String[] logo = new String[10];
					String[] chno = new String[10];
					String[] ch = new String[10];
					System.out.println("Sorted channels by Channel number:");
					System.out.println("");
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					for(int i=1;i<9;i++){
						ch = driver.findElement(By.xpath("(//div[@class='channel-number'])["+i+"]")).getText().split(" ");
						chno[i]= ch[1].trim();
						logo[i] = driver.findElement(By.xpath("(//img[@class = 'logo'])["+i+"]")).getAttribute("alt");
						System.out.println(i+". "+logo[i]+" ; channel num : "+chno[i]);
					}
					retVal=true;
					}
					catch(Exception e){
						System.out.println("Sorted channels are not visible");
						String Folder = "SortedChannelsError";
						screenshot.saveScreenshot("WatchTV"+ File.separator + Folder);
						System.out.println(e);
					}
				}
				else{
					System.out.println("Filter close button is not visible");
					String Folder = "GuideFilterCloseError";
					screenshot.saveScreenshot("WatchTV"+ File.separator + Folder);
				}
			}
			else{
				System.out.println("Sort by Channel number option is not visible");
				String Folder = "ChannelNoSortOptionError";
				screenshot.saveScreenshot("WatchTV"+ File.separator + Folder);
			}
			
		}
		else{
			System.out.println("Filter Toggle button is not visible");
			String Folder = "GuideFilterToggleError";
			screenshot.saveScreenshot("WatchTV"+ File.separator + Folder);
		}
		
		return retVal;
	}
	
	public boolean checkPrimeTimeFilter(){
		boolean retVal= false;
		String[] Assets = new String[10];
		String[] Assets2 = new String[10];
		if(isElementVisible("xpath;//*[@id='main-guide-grid']/div[2]/div[2]/div[1]/a")){
			for(int i=2;i<6;i++){
				Assets[i] = getText("xpath;//*[@id='main-guide-grid']/div[2]/div["+i+"]/div[1]/a");
			}
			System.out.println("Asset Line up before applying Primetime Filter: ");
			for(int i=2;i<6;i++){
				System.out.println(Assets[i]);
			}
			System.out.println();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			if(isElementVisible(filterToggle)){
				sleep(5);
				clickOnElement(filterToggle);
				System.out.println("Clicked on Filter Toggle");
				if(isElementVisible(primeTimeFilter)){
					clickOnElement(primeTimeFilter);
					System.out.println("Prime time filter option selected");
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					if(isElementVisible(filter_close)){
						clickOnElement(filter_close);
						System.out.println("Filter closed");
						driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
						try{
							for(int i=2;i<6;i++){
								Assets2[i]=getText("xpath;//*[@id='main-guide-grid']/div[2]/div["+i+"]/div[1]/a");
							}
							System.out.println("Asset Line up after applying Primetime Filter: ");
							for(int i=2;i<6;i++){
								System.out.println(Assets2[i]);
							}
							retVal= true;
						}
						catch(Exception e){
							System.out.println("Filtered channels are not visible");
							String Folder = "PrimetimeFilteredChannelsError";
							screenshot.saveScreenshot("WatchTV"+ File.separator + Folder);
							System.out.println(e);
						}
					}
					
				}
				else{
					System.out.println("prime time filter option is not visible");
					String Folder = "PrimeTimeFilterOptionError";
					screenshot.saveScreenshot("WatchTV"+ File.separator + Folder);
				}
			}
			else{
				System.out.println("Filter Toggle button is not visible");
				String Folder = "GuideFilterToggleError";
				screenshot.saveScreenshot("WatchTV"+ File.separator + Folder);
			}
		}
		else{
			System.out.println("Guide assets are not visible");
			String Folder = "GuideAssetsError";
			screenshot.saveScreenshot("WatchTV"+ File.separator + Folder);
		}
		
		return retVal;
	}
	
	public boolean checkStartOnDemand(){
		boolean retVal= false;
		if(isElementEnabled(startOnDemand))
			retVal= true;
		return retVal;
	}
	
	public void OpenGuideAsset(){
		sleep(5);
		driver.findElement(By.xpath("(//div[@class='guide-show']/a)[1]")).click();
	}
	
	public boolean checkRecord(){
		boolean retVal= false;
		sleep(5);
		if(isElementEnabled(record)){
			System.out.println("Record button is enabled");
			retVal= true;
		}
		return retVal;
	}
	
	public boolean manageFavorites(){
		boolean retVal=false;
		String ch= addFavorite();
		if(!ch.equals("Error")){
			sleep(5);
			if(isElementVisible(filterToggle)){
				clickOnElement(filterToggle);
				sleep(5);
				System.out.println("Clicked on Filter Toggle");
				if(isElementVisible(sort_Myfav)){
					setCheckBox(sort_Myfav, true);
					System.out.println("Favourite Channels filter selected");
					sleep(5);
					clickOnElement(filterToggle);
					System.out.println("Filter Closed");
					sleep(5);
					if(isElementVisible("xpath;.//*[@id='main-guide-grid']/div[2]/div[1]/div[1]/a")){
						clickOnElement("xpath;.//*[@id='main-guide-grid']/div[2]/div[1]/div[1]/a");
						if(isElementEnabled(PlayMovie_Online)){
							clickOnElement(PlayMovie_Online);
							sleep(10);
							if(isElementVisible(ClosePlayer)){
								clickOnElement(ClosePlayer);
								if(isElementVisible(Guide_link)){
									clickOnElement(Guide_link);
									sleep(5);
									if(isElementVisible(filterToggle)){
										sleep(5);
										clickOnElement(filterToggle);
										if(isElementVisible(sort_Myfav)){
											setCheckBox(sort_Myfav, true);
											clickOnElement(filterToggle);
											System.out.println("Filter Closed");
											sleep(5);
											String ch2= removeFavorite();
											if(!ch2.equals("Error"))
												retVal=true;
										}
										else{
											System.out.println("Favourites Filter option not visible");
											String Folder = "FavouriteFilterOptionError";
											screenshot.saveScreenshot("WatchTV"+ File.separator + Folder);
										}
									}
									else{
										System.out.println("Filter Toggle not visible");
										String Folder = "FilterToggleError";
										screenshot.saveScreenshot("WatchTV"+ File.separator + Folder);
									}
								}
								else{
									System.out.println("Guide link not visible");
									String Folder = "GuideLinkError";
									screenshot.saveScreenshot("WatchTV"+ File.separator + Folder);
								}
							}
							else{
								System.out.println("Close player button not visible");
								String Folder = "ClosePlayerButtonError";
								screenshot.saveScreenshot("WatchTV"+ File.separator + Folder);
							}
						}
						else{
							System.out.println("Play Online Asset option not Enabled");
							String Folder = "playOnlineAssetError";
							screenshot.saveScreenshot("WatchTV"+ File.separator + Folder);
							if(isElementVisible(Guide_link)){
								clickOnElement(Guide_link);
								sleep(5);
								if(isElementVisible(filterToggle)){
									sleep(5);
									clickOnElement(filterToggle);
									if(isElementVisible(sort_Myfav)){
										setCheckBox(sort_Myfav, true);
										clickOnElement(filterToggle);
										System.out.println("Filter Closed");
										sleep(5);
										String ch2= removeFavorite();
										if(!ch2.equals("Error"))
											retVal=true;
									}
									else{
										System.out.println("Favourites Filter option not visible");
										Folder = "FavouriteFilterOptionError";
										screenshot.saveScreenshot("WatchTV"+ File.separator + Folder);
									}
								}
								else{
									System.out.println("Filter Toggle not visible");
									Folder = "FilterToggleError";
									screenshot.saveScreenshot("WatchTV"+ File.separator + Folder);
								}
							}
							else{
								System.out.println("Guide link not visible");
								Folder = "GuideLinkError";
								screenshot.saveScreenshot("WatchTV"+ File.separator + Folder);
							}
						}
					}
					else{
						System.out.println("Favourite Asset not visible");
						String Folder = "FavAssetError";
						screenshot.saveScreenshot("WatchTV"+ File.separator + Folder);
					}
				}
				else{
					System.out.println("Favourites Filter option not visible");
					String Folder = "FavouriteFilterOptionError";
					screenshot.saveScreenshot("WatchTV"+ File.separator + Folder);
				}
			}
			else{
				System.out.println("Filter Toggle not visible");
				String Folder = "FilterToggleError";
				screenshot.saveScreenshot("WatchTV"+ File.separator + Folder);
			}
		}
		else{
			System.out.println("Asset not Favourited");
			String Folder = "AssetFavouriteError";
			screenshot.saveScreenshot("WatchTV"+ File.separator + Folder);
		}
		return retVal;
	}
	
	public String addFavorite(){
		String channelName="";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		sleep(5);
		if(isElementVisible(GuideChannel+"[2]/button")){
			clickOnElement(GuideChannel+"[2]/button");
			System.out.println("Clicked on Favourite button for the asset");
			channelName=getText(GuideChannel+"[2]");
			if(getAttribute(GuideChannel+"[2]/button", "class").contains("favorited")){
				System.out.println("Favourite Channel added: "+channelName.trim());
			}
			else{
				System.out.println("Asset not favourited");
				String Folder = "AssetFavouritedError";
				screenshot.saveScreenshot("WatchTV"+ File.separator + Folder);
				channelName = "Error";
			}
		}
		else{
			System.out.println("Guide not visible");
			String Folder = "GuideAssetError";
			screenshot.saveScreenshot("WatchTV"+ File.separator + Folder);
			channelName="Error";
		}
		return channelName;
	}
	
	public String removeFavorite(){
		String channelName="";
		if(isElementVisible(GuideChannel+"[1]")){
			System.out.println("Favourite Channel removed: "+getText(GuideChannel+"[1]").trim());
			clickOnElement(GuideChannel+"[1]/button");
			if(!(getAttribute(GuideChannel+"[1]/button", "class").contains("favorited"))){
				System.out.println("Favourite Channel added: "+channelName.trim());
				channelName=getText(GuideChannel+"[1]").trim();
			}
			else{
				System.out.println("Guide Asset favourite not removed ");
				String Folder = "GuideAssetFavouriteError";
				screenshot.saveScreenshot("WatchTV"+ File.separator + Folder);
				channelName="Error";
			}
		}
		else{
			System.out.println("Guide Asset visible");
			String Folder = "GuideAssetError";
			screenshot.saveScreenshot("WatchTV"+ File.separator + Folder);
			channelName="Error";
		}
		return channelName;
	}
	
	public boolean zipCodeNonLoggedIn(){
		boolean retVal=false;
		String zip=null;
		if(isElementVisible(zipcode)){
			zip=getText(zipcode);
			System.out.println(zip);
			if(zip=="63131");
			retVal=true;
		}
		return retVal;
	}
	
	public boolean zipCodeChannels(){
		boolean retVal=false;
		clearTextBox(zipcode);
		type(zipcode,"76132"+Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(isElementVisible("xpath;//*[contains(text(),'KDTN')]") || isElementVisible("xpath;//*[contains(text(),'KPXD')]") || isElementVisible("xpath;//*[contains(text(),'KDAF')]") || isElementVisible("xpath;//*[contains(text(),'KTXA')]"))
			retVal=true;
		return retVal;
	}
	
	public boolean regionalChannels(){
		boolean retVal=false;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(isElementVisible("xpath;//*[contains(text(),'KDTN')]") || isElementVisible("xpath;//*[contains(text(),'KPXD')]") || isElementVisible("xpath;//*[contains(text(),'KDAF')]") || isElementVisible("xpath;//*[contains(text(),'KTXA')]"))
			retVal=true;
		return retVal;
	}
}
