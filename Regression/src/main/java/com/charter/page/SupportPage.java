package com.charter.page;

import java.awt.AWTException;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.cognizant.framework.ajax.Until;
import com.cognizant.framework.core.CaptureScreenshot;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.WebDriverBase;

public class SupportPage extends WebDriverBase {
	
	private static String SupportTab=ReadFromExcel.getLocator("SupportPage", "SupportTab");
	private static String TV_Articlehead=ReadFromExcel.getLocator("SupportPage", "TV_Articlehead");
	private static String Voice_Articlehead=ReadFromExcel.getLocator("SupportPage", "Voice_Articlehead");
	private static String Internet_Articlehead=ReadFromExcel.getLocator("SupportPage", "Internet_Articlehead");
	private static String MyAccount_Articlehead=ReadFromExcel.getLocator("SupportPage", "MyAccount_Articlehead");
	private static String WatchTV_SupportLink=ReadFromExcel.getLocator("SupportPage", "WatchTV_SupportLink");
	private static String Internet_SupportLink=ReadFromExcel.getLocator("SupportPage", "Internet_SupportLink");
	private static String Voice_SupportLink=ReadFromExcel.getLocator("SupportPage", "Voice_SupportLink");
	private static String MyAccount_SupportLink=ReadFromExcel.getLocator("SupportPage", "MyAccount_SupportLink");
	private static String Article_Rating=ReadFromExcel.getLocator("SupportPage", "Article_Rating");
	private static String Next=ReadFromExcel.getLocator("SupportPage", "SupVideo_Next");
	private static String Prev=ReadFromExcel.getLocator("SupportPage", "SupVideo_Prev");
	private static String SupportVideo=ReadFromExcel.getLocator("SupportPage", "SupportVideo");
	
	private static String AskCharterWidget=ReadFromExcel.getLocator("TVServ","AskCharterWidget");
	private static String BtnASK=ReadFromExcel.getLocator("TVServ","BtnASK");
	
	private static String searchBar=ReadFromExcel.getLocator("HomePage","searchBar");
	private static String searchWatchOnTV=ReadFromExcel.getLocator("SearchPage","searchWatchOnTV");
	private static String searchWatchOnline=ReadFromExcel.getLocator("SearchPage","searchWatchOnline");
	private static String searchSupport=ReadFromExcel.getLocator("SearchPage","searchSupport");
	private static String googleSearch=ReadFromExcel.getLocator("SearchPage","googleSearch");
	private static String viewAllWatchOnline=ReadFromExcel.getLocator("SearchPage","viewAllWatchOnline");
	private static String viewAllWatchOnTV=ReadFromExcel.getLocator("SearchPage","viewAllWatchOnTV");
	private static String viewAllSupport=ReadFromExcel.getLocator("SearchPage","viewAllSupport");
	private static String resultsList=ReadFromExcel.getLocator("SearchPage","resultsList");
	private static String WO_dropdown=ReadFromExcel.getLocator("SearchPage","WO_dropdown");
	private static String Wotv_dropdown=ReadFromExcel.getLocator("SearchPage","Wotv_dropdown");
	private static String Sup_dropdown=ReadFromExcel.getLocator("SearchPage","Sup_dropdown");
	private static String STW_dropdown=ReadFromExcel.getLocator("SearchPage","STW_dropdown");
	
	CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);	
	public SupportPage(WebDriver driver){
		this.driver=driver;
	}
	
	public boolean SupportTab(){
		boolean retVal=false;
		wait(Until.elementToBeClickable(SupportTab));
		hoverOver(SupportTab);
		clickOnElement(SupportTab);
		System.out.println("User Navigated to Support page:"+ driver.getCurrentUrl());
		retVal=true;
		return retVal;
	}
	
	public boolean SupportArticles(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(TV_Articlehead));
		hoverOver(TV_Articlehead);
		System.out.println("TV Support Articles present");
		hoverOver(Voice_Articlehead);
		System.out.println("Voice Support Articles present");
		hoverOver(Internet_Articlehead);
		System.out.println("Internet Support Articles present");
		hoverOver(MyAccount_Articlehead);
		System.out.println("My Account Support Articles present");		
		retVal=true;
		return retVal;
	}
	
	public boolean AskCharter_TV(){
		boolean retVal=false;
		if(isElementPresent(AskCharterWidget)){
			retVal=true;
		}
		return retVal;
	}

	public boolean Askbutton_TV(){

		boolean retVal=false;
		if(isElementPresent(BtnASK)){
			retVal=true;
		}
		return retVal;
	}
	
	public boolean TVSupport_Article(){
		boolean retVal=false;
		wait(Until.elementToBeClickable(WatchTV_SupportLink));
		clickOnElement(WatchTV_SupportLink);
		System.out.println("User Navigated to TV Support Article page:"+ driver.getCurrentUrl());
		if(isElementPresent(Article_Rating)){
			retVal=true;
		}
		return retVal;
	}
	
	public boolean InternetSupport_Article(){
		boolean retVal=false;
		wait(Until.elementToBeClickable(Internet_SupportLink));
		clickOnElement(Internet_SupportLink);
		System.out.println("User Navigated to Internet Support Article page:"+ driver.getCurrentUrl());
		if(isElementPresent(Article_Rating)){
			retVal=true;
		}
		return retVal;
	}
	
	public boolean VoiceSupport_Article(){
		boolean retVal=false;
		wait(Until.elementToBeClickable(Voice_SupportLink));
		clickOnElement(Voice_SupportLink);
		System.out.println("User Navigated to Voice Support Article page:"+ driver.getCurrentUrl());
		if(isElementPresent(Article_Rating)){
			retVal=true;
		}
		return retVal;
	}
	
	public boolean MyAccountSupport_Article(){
		boolean retVal=false;
		wait(Until.elementToBeClickable(MyAccount_SupportLink));
		clickOnElement(MyAccount_SupportLink);
		System.out.println("User Navigated to My Account Support Article page:"+ driver.getCurrentUrl());
		if(isElementPresent(Article_Rating)){
			retVal=true;
		}
		return retVal;
	}
	
	public boolean BrowseSupportVideos(){
		boolean retVal=false;
		clickOnElement(Next);
		clickOnElement(Next);
		clickOnElement(Prev);
		retVal=true;
		return retVal;
	}
	
	public boolean checkSearchSections() {
		boolean retVal=false;
		driver.findElement(By.id("search-bar-text-field")).sendKeys("Internet"+Keys.RETURN);
		System.out.println("Page navigated to search results "+ driver.getCurrentUrl());
		HomePage hp = new HomePage(driver);
		hp.pagewait();
		type(searchBar,"Internet");
		if(isElementVisible(searchWatchOnTV)&&isElementVisible(searchWatchOnline)&&isElementVisible(searchSupport)&&isElementVisible(googleSearch))
		retVal=true;
		return retVal;
	}
	
	public boolean WatchOnlineResults_ViewAll(){
		boolean retVal=false;
		driver.findElement(By.id("search-bar-text-field")).sendKeys("Internet"+Keys.RETURN);
		System.out.println("Page navigated to search results "+ driver.getCurrentUrl());
		HomePage hp = new HomePage(driver);
		hp.pagewait();
		type(searchBar,"Internet");
		clickOnElement(viewAllWatchOnline);
		if(isElementPresent(resultsList))
		retVal=true;
		return retVal;
	}
	
	public boolean WatchOnTVResults_ViewAll(){
		boolean retVal=false;
		driver.findElement(By.id("search-bar-text-field")).sendKeys("Internet"+Keys.RETURN);
		System.out.println("Page navigated to search results "+ driver.getCurrentUrl());
		HomePage hp = new HomePage(driver);
		hp.pagewait();
		type(searchBar,"Internet");
		clickOnElement(viewAllWatchOnTV);
		if(isElementPresent(resultsList))
		retVal=true;
		return retVal;
	}
	
	public boolean SupportResults_ViewAll(){
		boolean retVal=false;
		driver.findElement(By.id("search-bar-text-field")).sendKeys("Internet"+Keys.RETURN);
		System.out.println("Page navigated to search results "+ driver.getCurrentUrl());
		HomePage hp = new HomePage(driver);
		hp.pagewait();
		type(searchBar,"Internet");
		clickOnElement(viewAllSupport);
		if(isElementPresent(resultsList))
		retVal=true;
		return retVal;
	}
	
	public boolean GoogleResults_ViewAll(){
		boolean retVal=false;
		driver.findElement(By.id("search-bar-text-field")).sendKeys("Internet"+Keys.RETURN);
		System.out.println("Page navigated to search results "+ driver.getCurrentUrl());
		HomePage hp = new HomePage(driver);
		hp.pagewait();
		type(searchBar,"Internet");
		clickOnElement(googleSearch);
		if(isElementPresent(resultsList))
		retVal=true;
		return retVal;
	}
	
	public boolean ghostSearchText(){
		boolean retVal=false;
		String ghostText = driver.findElement(By.id("search-bar-text-field")).getAttribute("placeholder");
		System.out.println(ghostText);
		if(ghostText.equals("Search"))
			retVal=true;
		return retVal;
	}
	
	public boolean SearchDropdown(){
		boolean retVal=false;
		driver.findElement(By.id("search-bar-text-field")).sendKeys("Internet");
		if(isElementVisible(WO_dropdown)&&isElementVisible(Wotv_dropdown)&&isElementVisible(Sup_dropdown)&&isElementVisible(STW_dropdown))
			retVal=true;
		return retVal;
	}
	
}
