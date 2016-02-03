package com.charter.page;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cognizant.framework.ajax.Until;
import com.cognizant.framework.core.EnvParameters;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.WebDriverBase;

public class HomePage extends WebDriverBase {

	private static String SignInLink=ReadFromExcel.getLocator("HomePage", "SignIn");
	private static String Username=ReadFromExcel.getLocator("HomePage", "username");
	private static String Password=ReadFromExcel.getLocator("HomePage", "password");
	private static String PasswordPlaceHolder=ReadFromExcel.getLocator("HomePage", "password_placeholder");
	private static String btnSignin=ReadFromExcel.getLocator("HomePage", "btnSignin");
	private static String AuthUsername=	ReadFromExcel.getData("HomePage", "Auth_Username");	
	private static String AuthPassword=	ReadFromExcel.getData("HomePage", "Auth_Password");
	private static String lnkAccount=ReadFromExcel.getLocator("HomePage", "lnkAccount");
	private static String weSignOut=ReadFromExcel.getLocator("HomePage", "weSignOut");
	private static String submitSignin=ReadFromExcel.getLocator("HomePage", "submitSignin");

	private static String Billing=ReadFromExcel.getLocator("HomePage", "Billing");
	private static String VSlink=ReadFromExcel.getLocator("HomePage", "VSlink");
	private static String SSSection=ReadFromExcel.getLocator("BTPage", "SSSection");
	private static String TvGuidelink=ReadFromExcel.getLocator("HomePage", "TvGuidelink");
	private static String OndemandLink=ReadFromExcel.getLocator("HomePage", "OndemandLink");
	private static String Getsupportlink=ReadFromExcel.getLocator("HomePage", "Getsupportlink");
	private static String AskSpectrumfield=ReadFromExcel.getLocator("HomePage", "AskSpectrumfield");
	private static String Askbutton=ReadFromExcel.getLocator("HomePage", "Askbutton");
	private static String FindCS=ReadFromExcel.getLocator("HomePage", "FindCS");
	private static String LiveTvTab=ReadFromExcel.getLocator("HomePage", "LiveTvTab");
	private static String WAOption=ReadFromExcel.getLocator("HomePage", "WAOption");
	private static String OnDemandTab=ReadFromExcel.getLocator("HomePage", "OnDemandTab");
	private static String NetworksTab=ReadFromExcel.getLocator("HomePage", "NetworksTab");
	private static String PrimeTime=ReadFromExcel.getLocator("HomePage", "PrimeTime");
	private static String BrowseAlllink=ReadFromExcel.getLocator("HomePage", "BrowseAlllink");
	private static String Emailicon=ReadFromExcel.getLocator("HomePage", "Emailicon");
	private static String Voicemailicon=ReadFromExcel.getLocator("HomePage", "Voicemailicon");
	private static String OutofNetworkicon=ReadFromExcel.getLocator("HomePage", "OutofNetworkicon");
	private static String UPButton=ReadFromExcel.getLocator("HomePage", "UPButton");
	private static String Watchtv=ReadFromExcel.getLocator("WatchTVpage", "Watchtv");
	private static String MyAccountTab=ReadFromExcel.getLocator("MAPage", "MyAccountTab");
	private static String WatchTVOverViewLink=ReadFromExcel.getLocator("MAPage", "WatchTVOverViewLink");
	private static String MAOverviewlink=ReadFromExcel.getLocator("MAPage", "MAOverviewlink");
	private static String SupportTab=ReadFromExcel.getLocator("WatchTVpage", "SupportTab");
	private static String StaticImage=ReadFromExcel.getLocator("HomePage", "StaticImage");
	private static String Searchbar=ReadFromExcel.getLocator("HomePage", "Searchbar");

	public HomePage(WebDriver driver) {
		this.driver=driver;	
	}

	public void loadCharterPage(String URL) throws Exception {	

		driver.manage().deleteAllCookies();
		String[] filepath=new String[] { System.getProperty("user.dir") + File.separator + "AutoIT" + File.separator +"LoginAll.exe",EnvParameters.WEB_BROWSER_TYPE.replaceAll("\\*", ""),AuthUsername,AuthPassword};
		System.out.println("print :" +EnvParameters.WEB_BROWSER_TYPE);

		try {
			Runtime.getRuntime().exec(filepath);
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("Unable to close");
		}

		driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		goToUrl(URL);
		//goToUrl(URL.replace("http", "https"));
		pagewait();
		wait(Until.elementToBeDisplayed(SignInLink));		
	}

	public boolean pagewait(){
		//Use code only for www.charter.net application web pages
		//Other external web pages not having "Policies" link like Spectrum, Charter TV, etc - not to be used
		boolean retVal = false;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Policies")));
		retVal = true;
		System.out.println("NEW: Wait initiated");
		return retVal;
	}

	public void login(String user, String pword) {	

		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(Username));
		type(Username, user);
		clickOnElement(PasswordPlaceHolder);
		type(Password, pword);
		clickOnElement(btnSignin);
		pagewait();
	}

	public void VerifyLogin(String user, String pword){
		driver.manage().deleteAllCookies();
		clickOnElement(SignInLink);
		wait(Until.elementToBeDisplayed(Username));
		type(Username, user);
		clickOnElement(PasswordPlaceHolder);
		type(Password, pword);
		clickOnElement(submitSignin);
	}

	public boolean paybill_link(){
		boolean retVal=false;
		wait(Until.elementToBeClickable(Billing));
		clickOnElement(Billing);
		System.out.println("User Navigated to the Billing and Transaction page by clicking Paybill link in Home Page:"+ driver.getCurrentUrl());
		logoutApplication();
		retVal=true;
		return retVal;
	}
	public boolean viewstatement_link(){
		boolean retVal = false;
		wait(Until.elementToBeClickable(VSlink));
		clickOnElement(VSlink);
		if(isElementPresent(SSSection)) {
			retVal = true;
			System.out.println("User navigated to statements page by clicking View Statements link in Home Page:"+driver.getCurrentUrl());
		}
		return retVal;
	}

	public boolean TvGuide_link(){
		boolean retVal=false;
		sleep(5);
		wait(Until.elementToBeClickable(TvGuidelink));
		clickOnElement(TvGuidelink);
		System.out.println("User Navigated to TV Guide page:"+driver.getCurrentUrl());
		logoutApplication();
		retVal=true;
		return retVal;
	}

	public boolean Ondemand_link(){
		boolean retVal=false;
		sleep(5);
		wait(Until.elementToBeDisplayed(OndemandLink));
		clickOnElement(OndemandLink);
		System.out.println("User navigated to On Demand Page:"+driver.getCurrentUrl());
		retVal=true;
		return retVal;
	}
	public boolean AskSpectrum(){
		boolean retVal=false;
		sleep(5);
		wait(Until.elementsToBeDisplayed(AskSpectrumfield));
		type(AskSpectrumfield, "internet");
		sleep(5);
		clickOnElement(Askbutton);
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
			if(!windowHandle.equals(parentWindow))
			{
				driver.switchTo().window(windowHandle);
				sleep(5);
				System.out.println("User navigated to Support page:"+driver.getCurrentUrl());
				driver.close(); //closing child window
				driver.switchTo().window(parentWindow);//cntrl to parent window
				sleep(3);
			}
		}
		
		retVal=true;
		return retVal;
	}

	public boolean FindCharterStore(){
		boolean retVal=false;
		sleep(5);
		wait(Until.elementToBeClickable(FindCS));
		clickOnElement(FindCS);
		System.out.println("User navigated to Location page:"+driver.getCurrentUrl());
		retVal=true;
		return retVal;
	}
	public String WatchAnywhereOption(){

		return getText(WAOption);

	}

	public boolean PrimeTimeOption(){
		boolean retVal=false;
		if(isElementPresent(PrimeTime)){
			retVal=true;
		}
		return retVal;
	}
	public boolean LiveTV_Tab(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(LiveTvTab));
		clickOnElement(LiveTvTab);
		if(isElementPresent(WAOption)){
			retVal=true;
		}
		return retVal;
	}

	public boolean OnDemand_Tab(){
		boolean retVal=false;
		clickOnElement(OnDemandTab);
		if(isElementPresent(WAOption)){
			retVal=true;			
		}
		return retVal;
	}

	public boolean Networks_Tab(){

		boolean retVal=false;
		clickOnElement(NetworksTab);
		HomePage hp=new HomePage(driver);
		hp.pagewait();
		if(isElementPresent(WAOption)){
			retVal=true;
		}
		return retVal;
	}

	public void PrimeTimeTN(){
		clickOnElement(BrowseAlllink);
		System.out.println("User Navigated to Tv Guide Page:"+ driver.getCurrentUrl());
	}

	public boolean Emailicon_Homepage(){
		boolean retVal=false;
		clickOnElement(Emailicon);
		System.out.println("User navigated to charter Email page:"+ driver.getCurrentUrl());
		retVal=true;
		return retVal;
	}

	public boolean Voicemailicon_Homepage(){
		boolean retVal=false;
		clickOnElement(Voicemailicon);
		System.out.println("User navigated to charter voicemail page:"+ driver.getCurrentUrl());
		HomePage hp=new HomePage(driver);
		hp.pagewait();
		retVal=true;
		return retVal;
	}

	public boolean UserPreferences(){
		boolean retVal=false;
		clickOnElement(lnkAccount);
		HomePage hp=new HomePage(driver);
		hp.pagewait();
		clickOnElement(UPButton);
		hp.pagewait();
		System.out.println("User navigated to User Preferences page:"+ driver.getCurrentUrl());
		retVal=true;
		return retVal;
	}

	public void logoutApplication() {
		try{
		wait(Until.elementToBeDisplayed(weSignOut));
		clickOnElement(weSignOut);
		}
		catch(Exception e){
			System.out.println(e);
			refreshPage();
			wait(Until.elementToBeDisplayed(weSignOut));
			clickOnElement(weSignOut);
		}
	}

	public boolean WatchTVtab(){

		boolean retVal=false;
		//hoverOver(Watchtv);
		wait(Until.elementToBeClickable(WatchTVOverViewLink));
		clickOnElement(WatchTVOverViewLink);
		System.out.println("User Navigated to the TV page:"+driver.getCurrentUrl());
		retVal=true;
		return retVal;
	}

	public void WatchTVtab(WebElement Watchtv, WebElement Overviewlink){
		Actions action=new Actions(driver);
		action.moveToElement(Watchtv).moveToElement(Overviewlink).click().build().perform();
	}


	public boolean MyAccounttab(){
		boolean retVal=false;
		//hoverOver(MyAccountTab);
		wait(Until.elementToBeClickable(MAOverviewlink));
		clickOnElement(MAOverviewlink);
		System.out.println("User Navigated to the Overview page:"+driver.getCurrentUrl());
		retVal=true;
		return retVal;
	}

	public boolean SupportTab(){
		boolean retVal=false;
		wait(Until.elementToBeClickable(SupportTab));
		clickOnElement(SupportTab);
		System.out.println("User Navigated to Support page:"+ driver.getCurrentUrl());
		retVal=true;
		return retVal;
	}
	public boolean StaticBanner(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(StaticImage));
		clickOnElement(StaticImage);
		HomePage hp=new HomePage(driver);
		hp.pagewait();
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
			if(!windowHandle.equals(parentWindow))
			{
				driver.switchTo().window(windowHandle);
				driver.close(); //closing child window
				driver.switchTo().window(parentWindow);//cntrl to parent window
			}
		}
		retVal=true;
		return retVal;
	}

	public boolean Searchbar(){
		boolean retVal=false;
		if(isElementPresent(Searchbar)){
			retVal=true;
		}
	return retVal;
	}

	public boolean HomeNetworkbutton(){
		boolean retVal=false;
		clickOnElement(OutofNetworkicon);
		System.out.println("Home Network icon is clickable:"+ getText(OutofNetworkicon));
		retVal=true;
		return retVal;
	}
}

