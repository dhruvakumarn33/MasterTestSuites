package com.charter.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.charter.page.HomePage;
import com.charter.page.SupportPage;
import com.charter.page.WatchTVGuidePage;
import com.charter.page.WatchTVODPage;
import com.charter.page.WatchTVPage;
import com.charter.utils.Constants;
import com.charter.utils.DataProviderClass;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.TestNGBase;

public class WatchTV extends TestNGBase{
	
	private String URL= Constants.URL;
	
	//Name: TV01_Validate_WatchTVOverview_ToGuide_Navigation()
	//Description: Validate user is able to navigate to guide page on clicking Guide link in Watch TV Overview page
	//Standard user
	//Scripter:Dhruva
	//Date/Version:13-Jul-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TV01_Validate_WatchTVOverview_ToGuide_Navigation(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		WatchTVPage wtv = new WatchTVPage(driver);
		wtv.OpenWatchTVTab();
		wtv.OpenGuideLink();
		hp.logoutApplication();
	}	
	
	//Name: TV02_Validate_WatchTVOverview_ToLiveTV_Navigation()
	//Description: Validate user is able to navigate to Live TV page on clicking Watch TV link in Watch TV overview page
	//Standard user
	//Scripter:Dhruva
	//Date/Version:13-Jul-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TV02_Validate_WatchTVOverview_ToLiveTV_Navigation(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		WatchTVPage wtv = new WatchTVPage(driver);
		wtv.OpenWatchTVTab();
		wtv.OpenLiveTVLink();
		hp.logoutApplication();
	}
	
	//Name: TV03_Validate_WatchTVOverview_ToOnDemand_Navigation()
	//Description: Validate user is able to navigate to Live TV page on clicking Watch TV link in Watch TV overview page
	//Standard user
	//Scripter:Dhruva
	//Date/Version:13-Jul-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TV03_Validate_WatchTVOverview_ToOnDemand_Navigation(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		WatchTVPage wtv = new WatchTVPage(driver);
		wtv.OpenWatchTVTab();
		wtv.OpenOnDemand();
		hp.logoutApplication();
	}
	
	//Name: TV04_Validate_WatchTVOverview_Networkslist()
	//Description: Validate Networks Tab and left and right arrows  in Watch TV-Overview page
	//Standard user
	//Scripter:Dhruva
	//Date/Version:14-Jul-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TV04_Validate_WatchTVOverview_Networkslist(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		WatchTVPage wtv = new WatchTVPage(driver);
		wtv.OpenWatchTVTab();
		Assert.assertTrue(wtv.CheckNetworksTab(),"Cannot navigate through the list of networks in Networks tab");
		hp.logoutApplication();
	}
	
	//Name: TV05_Validate_WatchTVOverview_Ondemandlist()
	//Description: Validate Most Popular On Demand tab and left and right arrows in watch TV-Overview page
	//Standard user
	//Scripter:Dhruva
	//Date/Version:14-Jul-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TV05_Validate_WatchTVOverview_Ondemandlist(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		WatchTVPage wtv = new WatchTVPage(driver);
		wtv.OpenWatchTVTab();
		Assert.assertTrue(wtv.CheckOndemandTab(),"Cannot navigate through the list of OnDemand channels in OnDemand tab");
		hp.logoutApplication();
	}
	
	//Name: TV06_Validate_WatchTVOverview_LiveTVlist()
	//Description: Validate Movies tab and left and right arrows to view list of movies in Watch TV -On Demand page
	//Standard user
	//Scripter:Dhruva
	//Date/Version:14-Jul-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TV06_Validate_WatchTVOverview_LiveTVlist(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		WatchTVPage wtv = new WatchTVPage(driver);
		wtv.OpenWatchTVTab();
		Assert.assertTrue(wtv.CheckLiveTVTab(),"Cannot navigate through the list of Live Channels in Live TV tab");
		hp.logoutApplication();
	}
	
	//Name: TV07_Validate_WatchTVOnDemand_Movieslist()
	//Description: Validate Movies tab and left and right arrows to view list of movies in Watch TV -On Demand page
	//Standard user
	//Scripter:Dhruva
	//Date/Version:15-Jul-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TV07_Validate_WatchTVOnDemand_Movieslist(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		WatchTVPage wtv = new WatchTVPage(driver);
		wtv.OpenOnDemand();
		WatchTVODPage wod = new WatchTVODPage(driver);
		Assert.assertTrue(wod.CheckMoviesTab(),"Cannot navigate through the list of Live Movies in Movies tab");
		hp.logoutApplication();
	}
	
	//Name: TV08_Validate_WatchTVOnDemand_TVshowslist()
	//Description: Validate Tv Shows tab and left and right arrows to view list of TV Shows in watch TV-On Demand page
	//Standard user
	//Scripter:Dhruva
	//Date/Version:15-Jul-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TV08_Validate_WatchTVOnDemand_TVshowslist(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		WatchTVPage wtv = new WatchTVPage(driver);
		wtv.OpenOnDemand();
		WatchTVODPage wod = new WatchTVODPage(driver);
		Assert.assertTrue(wod.CheckTVShowsTab(),"Cannot navigate through the list of TV shows in TV shows tab");
		hp.logoutApplication();
	}
	
	//Name: TV09_Validate_WatchTVOnDemand_Networkslist()
	//Description: Validate Networks tab,Left and right arrows to view list of networks in Watch TV- On Demand page
	//Standard user
	//Scripter:Dhruva
	//Date/Version:15-Jul-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TV09_Validate_WatchTVOnDemand_Networkslist(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		WatchTVPage wtv = new WatchTVPage(driver);
		wtv.OpenOnDemand();
		WatchTVODPage wod = new WatchTVODPage(driver);
		Assert.assertTrue(wod.CheckNetworksTab(),"Cannot navigate through the list of Networks in Networks tab");
		hp.logoutApplication();
	}
	
	//Name: TV10_Validate_WatchTVOnDemand_Premiumslist()
	//Description: Validate Premiums tab, left and right arrows to view list in watch TV -On Demand page
	//Standard user
	//Scripter:Dhruva
	//Date/Version:16-Jul-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TV10_Validate_WatchTVOnDemand_Premiumslist(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		WatchTVPage wtv = new WatchTVPage(driver);
		wtv.OpenOnDemand();
		WatchTVODPage wod = new WatchTVODPage(driver);
		Assert.assertTrue(wod.CheckPremiumsTab(),"Cannot navigate through the list of Networks in Premiums tab");
		hp.logoutApplication();
	}
	
	//Name: TV11_Validate_WatchTVOnDemand_Movies_Tvshows_Networks_Premium_tabs()
	//Description: Validate Movies, TV shows , Networks and Premium tabs on top of On Demand page 
	//Standard user
	//Scripter:Dhruva
	//Date/Version:16-Jul-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TV11_Validate_WatchTVOnDemand_Movies_Tvshows_Networks_Premium_tabs(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		WatchTVPage wtv = new WatchTVPage(driver);
		wtv.OpenOnDemand();
		WatchTVODPage wod = new WatchTVODPage(driver);
		Assert.assertTrue(wod.OnDemandCheckTabs(),"Cannot navigate through the tabs in OnDemand tab");
		hp.logoutApplication();
	}
	
	//Name: TV12_Validate_WatchTVOnDemand_WatchOnline_WatchOnTV_tabs()
	//Description: Validate Watch Online and Watch On TV tabs in Watch TV- On Demand page 
	//HOH user
	//Scripter:Dhruva
	//Date/Version:17-Jul-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TV12_Validate_WatchTVOnDemand_WatchOnline_WatchOnTV_tabs(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		WatchTVPage wtv = new WatchTVPage(driver);
		wtv.OpenOnDemand();
		WatchTVODPage wod = new WatchTVODPage(driver);
		Assert.assertTrue(wod.checkOnDemandSections(),"Not all tabs are available on Watch Online tab ");
		wod.OpenWatchOnTV();
		Assert.assertTrue(wod.checkOnDemandSections(),"Not all tabs are available on Watch on TV tab");
		hp.logoutApplication();
	}
	
	//Name: TV13_Validate_WatchTVGuide_DateTime_Channels_Programs()
	//Description: Validate Date, Time, channels and Programs are displayed  in Watch TV-Guide page
	//HOH user
	//Scripter:Dhruva
	//Date/Version:17-Jul-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TV13_Validate_WatchTVGuide_DateTime_Channels_Programs(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		WatchTVPage wtv = new WatchTVPage(driver);
		wtv.OpenTVGuide();
		WatchTVGuidePage wtg = new WatchTVGuidePage(driver);
		Assert.assertTrue(wtg.CheckDateTime(),"Cannot fetch the current program details");
		hp.logoutApplication();
	}
	
	//Name: TV14_Validate_WatchTVGuide_DateNavigation()
	//Description: Validate left and right arrows at Dates tab in Watch Tv-Guide page
	//HOH user
	//Scripter:Dhruva
	//Date/Version:20-Jul-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TV14_Validate_WatchTVGuide_DateNavigation(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		WatchTVPage wtv = new WatchTVPage(driver);
		wtv.OpenTVGuide();
		WatchTVGuidePage wtg = new WatchTVGuidePage(driver);
		Assert.assertTrue(wtg.CheckDateNavigation(),"Cannot navigate through date in TV Guide");
		hp.logoutApplication();
	}
	
	//Name: TV15_Validate_WatchTVGuide_TimeNavigation()
	//Description: Validate left and right arrows at Times tab in Watch Tv-Guide page
	//HOH user
	//Scripter:Dhruva
	//Date/Version:20-Jul-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TV15_Validate_WatchTVGuide_TimeNavigation(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		WatchTVPage wtv = new WatchTVPage(driver);
		wtv.OpenTVGuide();
		WatchTVGuidePage wtg = new WatchTVGuidePage(driver);
		Assert.assertTrue(wtg.CheckTimeNavigation(),"Cannot navigate through time in TV Guide");
		hp.logoutApplication();
	}
	
	//Name: TV16_Validate_WatchTVGuide_FilterChannel()
	//Description: Validate Filter button at right side of the Programs tab and validate user is able to filter desired channels in Watch TV -Guide page
	//HOH user
	//Scripter:Dhruva
	//Date/Version:21-Jul-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TV16_Validate_WatchTVGuide_FilterChannel(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		WatchTVPage wtv = new WatchTVPage(driver);
		wtv.OpenTVGuide();
		WatchTVGuidePage wtg = new WatchTVGuidePage(driver);
		Assert.assertTrue(wtg.CheckFilterChannels(),"Cannot filter channels in TV Guide");
		hp.logoutApplication();
	}
	
	//Name: TV17_Validate_WatchTVGuide_FilterChannel_SortList()
	//Description: Validate user is able to select Channel Number and A-Z radio button and Validate Prime Time button in Sort list under Filter tab in Watch Tv-Guide page
	//HOH user
	//Scripter:Dhruva
	//Date/Version:21-Jul-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TV17_Validate_WatchTVGuide_FilterChannel_SortList(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		
		HomePage hp=new HomePage(driver);
		String[] TDArray = {username,password};
		Assert.assertTrue(hp.verifyTestData(TDArray), "Test data Undefined"); // Verify the test data definition
		
		Assert.assertTrue(hp.loadCharterPage(URL),"Charter URL loading unsuccessful"); // Verify Charter URL is loaded
		Assert.assertTrue(hp.login(username, password),"Charter login unsuccessful"); // Verify Charter login
		WatchTVPage wtv = new WatchTVPage(driver);
		Assert.assertTrue(wtv.OpenTVGuide(),"TV Guide page loading unsuccessful"); // Open TV Guide page
		WatchTVGuidePage wtg = new WatchTVGuidePage(driver);
		Assert.assertTrue(wtg.checkAtoZsort(),"A-Z functionality not working"); // A-Z filter validation
		Assert.assertTrue(wtg.checkChannelNoSort(),"Channel number sort functionality not working"); // Channel number sort validation
		Assert.assertTrue(wtg.checkPrimeTimeFilter(),"Primetime filter functionality not working"); // Prime time filter validation
		Assert.assertTrue(hp.logoutApplication(),"Charter Apllication logout Unsuccessful");// logout from Charter Application
	}
	
	//Name: TV18_Validate_WatchTVGuide_ClearFilters()
	//Description: Validate whether  the user is able to clear Filters in Filters tab in Watch TV -Guide page
	//admin user
	//Scripter:Dhruva
	//Date/Version:21-Jul-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TV18_Validate_WatchTVGuide_ClearFilters(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		WatchTVPage wtv = new WatchTVPage(driver);
		wtv.OpenTVGuide();
		WatchTVGuidePage wtg = new WatchTVGuidePage(driver);
		wtg.applyFilter();
		Assert.assertFalse(wtg.clearFilter(),"Cannot filter channels in TV Guide");
		hp.logoutApplication();
	}
	
	//Name: TV19_Validate_WatchTVOverview_Search()
	//Description: Validate whether user is able to search a topic and find the results refined into Watch Online, Watch TV Support and Google search on Watch TV Overview page
	//Standard user
	//Scripter:Dhruva
	//Date/Version:28-Jul-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TV19_Validate_WatchTVOverview_Search(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		SupportPage sp = new SupportPage(driver);
		WatchTVPage wtv = new WatchTVPage(driver);
		wtv.OpenWatchTVTab();
		Assert.assertTrue(sp.checkSearchSections(), "Search results do not contain different sections");
		hp.logoutApplication();
	}
	
	//Name: TV20_Validate_WatchTVOverview_WatchOnline_SearchResults()
	//Description: Validate whether user is able to search a topic and view all the Watch Online results on Watch TV Overview page
	//Standard user
	//Scripter:Dhruva
	//Date/Version:28-Jul-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TV20_Validate_WatchTVOverview_WatchOnline_SearchResults(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		SupportPage sp = new SupportPage(driver);
		WatchTVPage wtv = new WatchTVPage(driver);
		wtv.OpenWatchTVTab();
		Assert.assertTrue(sp.WatchOnlineResults_ViewAll(), "Watch Online results list is not displayed");
		hp.logoutApplication();
	}
	
	//Name: TV21_Validate_WatchTVOverview_WatchOnTV_SearchResults()
	//Description: Validate whether user is able to search a topic and view all the Watch TV results  on Watch TV Overview page
	//Standard user
	//Scripter:Dhruva
	//Date/Version:28-Jul-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TV21_Validate_WatchTVOverview_WatchOnTV_SearchResults(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		SupportPage sp = new SupportPage(driver);
		WatchTVPage wtv = new WatchTVPage(driver);
		wtv.OpenWatchTVTab();
		Assert.assertTrue(sp.WatchOnTVResults_ViewAll(), "WatchOn TV results list is not displayed");
		hp.logoutApplication();
	}
	
	//Name: TV22_Validate_WatchTVOverview_Support_SearchResults()
	//Description: Validate whether user is able to search a topic and view all the Support results  on Watch TV Overview page
	//Standard user
	//Scripter:Dhruva
	//Date/Version:28-Jul-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TV22_Validate_WatchTVOverview_Support_SearchResults(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		SupportPage sp = new SupportPage(driver);
		WatchTVPage wtv = new WatchTVPage(driver);
		wtv.OpenWatchTVTab();
		Assert.assertTrue(sp.SupportResults_ViewAll(), "Support results list is not displayed");
		hp.logoutApplication();
	}
	
	//Name: TV23_Validate_WatchTVOverview_Google_SearchResults()
	//Description: Validate whether user is able to search a topic and view all the Google search results  on Watch TV Overview page
	//Standard user
	//Scripter:Dhruva
	//Date/Version:28-Jul-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TV23_Validate_WatchTVOverview_Google_SearchResults(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		SupportPage sp = new SupportPage(driver);
		WatchTVPage wtv = new WatchTVPage(driver);
		wtv.OpenWatchTVTab();
		Assert.assertTrue(sp.GoogleResults_ViewAll(), "Google results list is not displayed");
		hp.logoutApplication();
	}
	
	//Name: TV24_CL20_Validate_Telemundo_Channel_Changes()
	//Description: Validate whether Telemundo channel can be played from Watch TV OnDemand
	//Standard user
	//Scripter:Dhruva
	//Date/Version:04-Aug-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TV24_CL20_Validate_Telemundo_Channel_Changes(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		WatchTVPage wtv = new WatchTVPage(driver);
		wtv.OpenWatchTVTab();
		Assert.assertTrue(wtv.PlayChannel(),"Cannot play the selected channel");
		hp.logoutApplication();
	}
	
	//Name: TV25_CL20_Validate_StartOnDemand_OnWatchTVGuide()
	//Description: Validate whether StartOnDemand option is enabled on WatchTV Guide
	//Standard user
	//Scripter:Dhruva
	//Date/Version:04-Aug-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TV25_CL20_Validate_StartOnDemand_OnWatchTVGuide(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		WatchTVPage wtv = new WatchTVPage(driver);
		wtv.OpenWatchTVTab();
		wtv.OpenGuideLink();
		WatchTVGuidePage wtvg = new WatchTVGuidePage(driver);
		Assert.assertTrue(wtvg.checkStartOnDemand(),"Start OnDemand option is enabled in Watch TV guide");
		hp.logoutApplication();
	}
	
	//Name: TV26_CL20_Validate_SendAsset_fromOnDemand_WatchOnTV_toSTB()
	//Description: Validate whether user can send asset from ON Demand Watch On TV page to STB
	//Standard user
	//Scripter:Dhruva
	//Date/Version:06-Aug-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TV26_CL20_Validate_SendAsset_fromOnDemand_WatchOnTV_toSTB(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		WatchTVPage wtv = new WatchTVPage(driver);
		wtv.OpenOnDemand();
		WatchTVODPage wod = new WatchTVODPage(driver);
		Assert.assertTrue(wod.StartOnDemand(),"Not able to send the asset to TV");
		hp.logoutApplication();
	}
	
	//Name: TV27_CL20_Validate_PlayAsset_fromOnDemand_WatchOnline()
	//Description: Validate whether user play an asset from ON Demand Watch Online page
	//Standard user
	//Scripter:Dhruva
	//Date/Version:06-Aug-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TV27_CL20_Validate_PlayAsset_fromOnDemand_WatchOnline(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		WatchTVPage wtv = new WatchTVPage(driver);
		wtv.OpenWatchTVTab();
		WatchTVODPage wod = new WatchTVODPage(driver);
		wtv.OpenOnDemand();
		wod.OpenWatchOnTV();
		Assert.assertTrue(wod.WatchOnlineMovie(),"Not able to play asset to Online");
		hp.logoutApplication();
	}
	
	//Name: TV28_Validate_Record_OnWatchTVGuide()
	//Description: Validate whether Record option is enabled on WatchTV Guide
	//HOH user
	//Scripter:Dhruva
	//Date/Version:31-Aug-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TV28_Validate_Record_OnWatchTVGuide(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		WatchTVPage wtv = new WatchTVPage(driver);
		wtv.OpenWatchTVTab();
		wtv.OpenGuideLink();
		WatchTVGuidePage wtvg = new WatchTVGuidePage(driver);
		wtvg.OpenGuideAsset();
		Assert.assertFalse(wtvg.checkRecord(),"Record option is enabled in Watch TV guide");
		hp.logoutApplication();
	}
	
	//Name: TV29_Validate_Record_OnWatchTV_OnDemandPage()
	//Description: Validate whether Record option is enabled on WatchTV OnDemand Page
	//HOH user
	//Scripter:Dhruva
	//Date/Version:31-Aug-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TV29_Validate_Record_OnWatchTV_OnDemandPage(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		WatchTVPage wtv = new WatchTVPage(driver);
		wtv.OpenWatchTVTab();
		wtv.OpenOnDemand();
		WatchTVODPage wod = new WatchTVODPage(driver);
		wod.selectAsset();
		WatchTVGuidePage wtvg = new WatchTVGuidePage(driver);
		Assert.assertFalse(wtvg.checkRecord(),"Record option is enabled in Watch TV OnDemand");
		hp.logoutApplication();
	}
	
	//Name: TV30_Validate_Record_OnWatchTV_LiveTVPage()
	//Description: Validate whether Record option is enabled on WatchTV LiveTV Page
	//HOH user
	//Scripter:Dhruva
	//Date/Version:31-Aug-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TV30_Validate_Record_OnWatchTV_LiveTVPage(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		WatchTVPage wtv = new WatchTVPage(driver);
		wtv.OpenWatchTVTab();
		wtv.OpenLiveTVLink();
		WatchTVODPage wod = new WatchTVODPage(driver);
		wod.selectAsset();
		WatchTVGuidePage wtvg = new WatchTVGuidePage(driver);
		Assert.assertFalse(wtvg.checkRecord(),"Record option is enabled in Watch TV Live TV");
		hp.logoutApplication();
	}
	
	//Name: TV31_Validate_WatchTVGuide_ManageFavorites()
	//Description: Validate whether user is able to manage Favorites
	//HOH user
	//Scripter:Dhruva
	//Date/Version: 02-Sep-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TV31_Validate_WatchTVGuide_ManageFavorites(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		
		HomePage hp=new HomePage(driver);
		String[] TDArray = {username,password};
		Assert.assertTrue(hp.verifyTestData(TDArray), "Test data Undefined"); // Verify the test data definition
		
		Assert.assertTrue(hp.loadCharterPage(URL),"Charter URL loading unsuccessful"); // Verify Charter URL is loaded
		Assert.assertTrue(hp.login(username, password),"Charter login unsuccessful"); // Verify Charter login
		WatchTVPage wtv = new WatchTVPage(driver);
		Assert.assertTrue(wtv.OpenWatchTVTab(),"Watch TV page loading unsuccesful"); // Watch TV page loading 
		Assert.assertTrue(wtv.OpenTVGuide(),"TV Guide page loading unsuccessful"); // Open TV Guide page
		WatchTVGuidePage wtvg = new WatchTVGuidePage(driver);
		Assert.assertTrue(wtvg.manageFavorites(),"User is not able to add and remove favourites");//Verifying Add Remove
		Assert.assertTrue(hp.logoutApplication(),"Charter Application logout Unsuccessful");// logout from Charter Application
	}
	
	//Name: TV32_Validate_WatchTVOnDemand_WatchPremiumMovie()
	//Description: Validate whether user is able to view Premium Assets
	//HOH user
	//Scripter:Dhruva
	//Date/Version: 02-Sep-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TV32_Validate_WatchTVOnDemand_WatchPremiumMovie(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		
		HomePage hp=new HomePage(driver);
		String[] TDArray = {username,password};
		Assert.assertTrue(hp.verifyTestData(TDArray), "Test data Undefined"); // Verify the test data definition
		Assert.assertTrue(hp.loadCharterPage(URL),"Charter URL loading unsuccessful"); // Verify Charter URL is loaded
		Assert.assertTrue(hp.login(username, password),"Charter login unsuccessful"); // Verify Charter login
		WatchTVPage wtv = new WatchTVPage(driver);
		Assert.assertTrue(wtv.OpenWatchTVTab(),"Watch TV page loading unsuccesful"); // Watch TV page loading 
		Assert.assertTrue(wtv.OpenOnDemand(),"On Demand page loading unsuccesful"); // On Demand page loading 
		WatchTVODPage wod = new WatchTVODPage(driver);
		Assert.assertTrue(wod.OpenPremiumAssets(),"Premium Assets page loading unsuccesful"); // Premium Assets page loading
		Assert.assertTrue(wod.WatchPremiumMovie(),"User is not able to view Premium Assets");
		hp.logoutApplication();
	}
	
	//Name: TV33_Validate_SendAsset_fromLiveTV_WatchOnTV_toSTB()
	//Description: Validate whether user can send asset from ON Demand Watch On TV page to STB
	//Standard user
	//Scripter:Dhruva
	//Date/Version:06-Aug-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TV33_Validate_SendAsset_fromLiveTV_WatchOnTV_toSTB(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		WatchTVPage wtv = new WatchTVPage(driver);
		wtv.OpenLiveTVLink();
		WatchTVODPage wod = new WatchTVODPage(driver);
		Assert.assertTrue(wod.WatchLive(),"Not able to send the asset to TV");
		hp.logoutApplication();
	}
	
	//Name: TV34_Validate_WatchTV_Guide_default_ZipCode()
	//Description: Validate whether non-logged in user can see 63131 as default Zip code in Watch TV Guide
	//Standard user
	//Scripter:Dhruva
	//Date/Version:07-Sep-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TV34_Validate_WatchTV_Guide_default_ZipCode(Map<String,String> testdata) throws Exception {

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		WatchTVPage wtv = new WatchTVPage(driver);
		wtv.OpenGuideLink();
		WatchTVGuidePage wtg = new WatchTVGuidePage(driver);
		Assert.assertTrue(wtg.zipCodeNonLoggedIn(),"Default Zip code is not displayed as 63131");
		Assert.assertTrue(wtg.zipCodeChannels(),"Zip Code specific channels and programs are not displayed");
	}
	
	//Name: TV35_Validate_WatchTV_Guide_RegionalChannels()
	//Description: To verify whether logged in user is shown with channel line up associated with user's service address
	//HOH user
	//Scripter:Dhruva
	//Date/Version:07-Sep-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TV35_Validate_WatchTV_Guide_RegionalChannels(Map<String,String> testdata) throws Exception {
		
		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		WatchTVPage wtv = new WatchTVPage(driver);
		wtv.OpenGuideLink();
		WatchTVGuidePage wtg = new WatchTVGuidePage(driver);
		Assert.assertTrue(wtg.regionalChannels(),"Channel Line up is not associated with user's service address");
	}
	
}

