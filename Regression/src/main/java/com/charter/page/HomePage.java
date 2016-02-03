package com.charter.page;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.server.browserlaunchers.FirefoxCustomProfileLauncher;
import org.openqa.selenium.server.browserlaunchers.FirefoxLauncher;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.charter.utils.Constants;
import com.cognizant.framework.ajax.Until;
import com.cognizant.framework.core.CaptureScreenshot;
import com.cognizant.framework.core.EnvParameters;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.WebDriverBase;

public class HomePage extends WebDriverBase {
	
	private String URL= Constants.URL;
	CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);

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
	private static String InvalidDomain_Error=ReadFromExcel.getLocator("HomePage", "InvalidDomain_Error");
	private static String SupportDDimage=ReadFromExcel.getLocator("HomePage", "SupportDDimage");
	private static String SupportOverviewDD=ReadFromExcel.getLocator("HomePage", "SupportOverviewDD");
	private static String zipcodeEntry=ReadFromExcel.getLocator("HomePage", "zipcodeEntry");
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
	private static String MAOverviewlink=ReadFromExcel.getLocator("MAPage", "OverViewLink");
	private static String SupportTab=ReadFromExcel.getLocator("WatchTVpage", "SupportTab");
	private static String StaticImage=ReadFromExcel.getLocator("HomePage", "StaticImage");
	private static String Searchbar=ReadFromExcel.getLocator("HomePage", "Searchbar");
	private static String Autopay=ReadFromExcel.getLocator("HomePage", "Autopay");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;	
	}

	public boolean loadCharterPage(String URL) throws Exception {	
		boolean retVal = false;

		driver.manage().deleteAllCookies();
		String[] filepath=new String[] { System.getProperty("user.dir") + File.separator + "AutoIT" + File.separator +"LoginAll.exe",EnvParameters.WEB_BROWSER_TYPE.replaceAll("\\*", ""),AuthUsername,AuthPassword};
		System.out.println("print :" +EnvParameters.WEB_BROWSER_TYPE);

		try {
			if(EnvParameters.WEB_BROWSER_TYPE.equalsIgnoreCase("*firefox")){
				Runtime.getRuntime().exec(filepath);
			}
			if(EnvParameters.WEB_BROWSER_TYPE.equalsIgnoreCase("*iexplore")){
				Runtime.getRuntime().exec(filepath);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("Unable to close");
		}

		driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.navigate().to(URL);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		if(isElementPresent(SignInLink)) {
			pagewait();
			System.out.println("User logged in successfully");
			retVal = true;
		}
		else{
			System.out.println("Charter URL: "+URL+" Loading Unsuccessful");
			String Folder = "CharterURLLoadError";
			screenshot.saveScreenshot("Login And Authentication"+ File.separator + Folder);
		}
		return retVal;
	}
	
	public void openNewWindow(){
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
	}
	
	public WebDriver openNewInstance(){
		driver.close();
		if(EnvParameters.WEB_BROWSER_TYPE.equals("*firefox")){
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability(FirefoxDriver.PROFILE, true);
			driver = new FirefoxDriver(capabilities);
			System.out.println("New Firefox Instance Started");
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			return driver;
		}
		if(EnvParameters.WEB_BROWSER_TYPE.equals("*chrome")){
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			driver=new ChromeDriver(capabilities);
			System.out.println("New Chrome Instance Started");
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			return driver;
		}
		if(EnvParameters.WEB_BROWSER_TYPE.equals("*iexplore")){
			driver=new InternetExplorerDriver();
			System.out.println("New Internet Explorer Instance Started");
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			return driver;
		}
		System.out.println("Not able to create new instance");
		return driver;
	}

	public boolean pagewait(){
		//Use code only for www.charter.net application web pages
		//Other external web pages not having "Policies" link like Spectrum, Charter TV, etc - not to be used
		//Do not use pagewait for Internet Explorer
		boolean retVal = false;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Policies")));
		retVal = true;
		System.out.println("NEW: Wait for Complete Page Load");
		return retVal;
	}

	public boolean login(String username, String password) {		
		boolean retVal = false;
		wait(Until.elementToBeDisplayed(SignInLink));
		clickOnElement(SignInLink);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		if(isElementVisible(Username) & isElementVisible(PasswordPlaceHolder) & isElementVisible(btnSignin)){
			clearTextBox(Username);
			type(Username,username);
			type(PasswordPlaceHolder,password);
			clickOnElement(btnSignin);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			if(isElementVisible(weSignOut)){
				System.out.println("Charter Login Successful");
				HomePage hp = new HomePage(driver);
				hp.pagewait();
				retVal = true;
			}
			else{
				System.out.println("Login Unsuccessful");
				String Folder = "LoginError";
				screenshot.saveScreenshot("Login And Authentication"+ File.separator + Folder);
			}
		}
		else{
			System.out.println("Login Fields are not visible");
			String Folder = "LoginFieldsMissingError";
			screenshot.saveScreenshot("Login And Authentication"+ File.separator + Folder);
		}
		return retVal;
	}
	
	public boolean UnconvertedLogin(String username, String password) {		
		boolean retVal = false;
		wait(Until.elementToBeDisplayed(SignInLink));
		clickOnElement(SignInLink);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		if(isElementVisible(Username) & isElementVisible(PasswordPlaceHolder) & isElementVisible(btnSignin)){
			clearTextBox(Username);
			type(Username,username);
			type(PasswordPlaceHolder,password);
			clickOnElement(btnSignin);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			if(isElementVisible("xpath;.//*[@id='validationStepHeading']")){
				System.out.println("Charter Login Successful");
				HomePage hp = new HomePage(driver);
				hp.pagewait();
				retVal = true;
			}
			else{
				System.out.println("Login Unsuccessful");
				String Folder = "LoginError";
				screenshot.saveScreenshot("Login And Authentication"+ File.separator + Folder);
			}
		}
		else{
			System.out.println("Login Fields are not visible");
			String Folder = "LoginFieldsMissingError";
			screenshot.saveScreenshot("Login And Authentication"+ File.separator + Folder);
		}
		return retVal;
	}
	public boolean MyAccountRefererlogin(String username, String password){
		
		boolean retVal = false;
		wait(Until.elementToBeDisplayed(SignInLink));
		clickOnElement(SignInLink);
		driver.navigate().to(URL.concat("/login/?referer=myaccount"));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		if(isElementVisible(Username) & isElementVisible(PasswordPlaceHolder) & isElementVisible(btnSignin)){
			clearTextBox(Username);
			type(Username,username);
			type(PasswordPlaceHolder,password);
			clickOnElement(btnSignin);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			if(isElementVisible("xpath;.//*[@id='validationStepHeading']")){
				System.out.println("Charter Login Successful");
				HomePage hp = new HomePage(driver);
				hp.pagewait();
				retVal = true;
			}
			else{
				System.out.println("Login Unsuccessful");
				String Folder = "LoginError";
				screenshot.saveScreenshot("Login And Authentication"+ File.separator + Folder);
			}
		}
		else{
			System.out.println("Login Fields are not visible");
			String Folder = "LoginFieldsMissingError";
			screenshot.saveScreenshot("Login And Authentication"+ File.separator + Folder);
		}
		return retVal;
	}

	public void VerifyLogin(String user, String pword){
		driver.manage().deleteAllCookies();
		clickOnElement(SignInLink);
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
	
	public boolean paybillLink_unauthenticated(){
		boolean retVal=false;
		wait(Until.elementToBeClickable(Billing));
		if(driver.getCurrentUrl().contains("login"))
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
		wait(Until.elementToBeClickable(TvGuidelink));
		clickOnElement(TvGuidelink);
		System.out.println("User Navigated to TV Guide page:"+driver.getCurrentUrl());
		retVal=true;
		return retVal;
	}

	public boolean Ondemand_link(){
		boolean retVal=false;
		wait(Until.elementToBeClickable(OndemandLink));
		clickOnElement(OndemandLink);
		System.out.println("User navigated to On Demand Page:"+driver.getCurrentUrl());
		retVal=true;
		return retVal;
	}
	public boolean AskSpectrum(){
		boolean retVal=false;
		wait(Until.elementsToBeDisplayed(AskSpectrumfield));
		type(AskSpectrumfield, "internet");
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
		wait(Until.elementToBeClickable(LiveTvTab));
		clickOnElement(LiveTvTab);
		if(isElementPresent(WAOption)){
			retVal=true;
		}
		return retVal;
	}

	public boolean OnDemand_Tab(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(OnDemandTab));
		clickOnElement(OnDemandTab);
		if(isElementPresent(WAOption)){
			retVal=true;			
		}
		return retVal;
	}

	public boolean Networks_Tab(){

		boolean retVal=false;
		wait(Until.elementToBeClickable(NetworksTab));
		clickOnElement(NetworksTab);
		HomePage hp=new HomePage(driver);
		hp.pagewait();
		if(isElementPresent(WAOption)){
			retVal=true;
		}
		return retVal;
	}

	public void PrimeTimeTN(){
		if(isElementVisible("xpath;//*[contains(text(),'PrimeTime')]"))
			System.out.println("PrimeTime Tonight Section in Available on Homepage");
		clickOnElement("xpath;(//*[@title='Next'])[5]");
		clickOnElement("xpath;(//*[@title='Next'])[5]");
		clickOnElement("xpath;(//*[@title='Previous'])[5]");
		sleep(5);
		while(isElementVisible("xpath;(//*[@title='Next'])[5]")){
			clickOnElement("xpath;(//*[@title='Next'])[5]");
		}
		clickOnElement(BrowseAlllink);
		System.out.println("User Navigated to Tv Guide Page:"+ driver.getCurrentUrl());
		sleep(5);
		wait(Until.elementToBeDisplayed("xpath;//*[@class='navbar-brand']"));
		clickOnElement("xpath;//*[@class='navbar-brand']");
	}
	
	public void recommendations(){
		if(isElementVisible("xpath;//*[contains(text(),'Recommendations')]"))
			System.out.println("Recommendations Section Available on Homepage");
		clickOnElement("xpath;(//*[@title='Next'])[4]");
		clickOnElement("xpath;(//*[@title='Next'])[4]");
		clickOnElement("xpath;(//*[@title='Previous'])[4]");
		clickOnElement("xpath;(//*[@title='Previous'])[4]");
		sleep(5);
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
		sleep(5);
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

	public boolean logoutApplication() {
		boolean retVal=false;
		
		wait(Until.elementToBeClickable(weSignOut));
		clickOnElement(weSignOut);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(isElementVisible(SignInLink)){
			System.out.println("Charter logout Successful");
			new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Policies")));
			retVal=true;
		}
		else{
			System.out.println("User logout Unsuccessful");
			String Folder = "CharterLogoutError";
			screenshot.saveScreenshot("Email"+ File.separator + Folder);
		}
		return retVal;
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
	
	public boolean validateDomain(String user, String pword){
		boolean retVal=false;
		driver.manage().deleteAllCookies();
		clickOnElement(SignInLink);
		type(Username, user);
		clickOnElement(PasswordPlaceHolder);
		type(Password, pword);
		
		if((isElementPresent(InvalidDomain_Error)) || (isElementEnabled(btnSignin)))
			retVal=true;
		return retVal;
		
	}
	
	public boolean checkSupportDDPosition(){
		boolean retVal=false;
		hoverOver(SupportTab);
		hoverOver(SupportOverviewDD);
		hoverOver(SupportDDimage);
		WebElement w = driver.findElement(By.xpath(".//*[@id='subnav-support-tab']/div/div"));
		//System.out.println("Getting location of image");
		String position = w.getLocation().toString();
		if(position.equals("(891, 151)"))
		retVal=true;
		return retVal;
	}
	
	public boolean checkweakpassword(String user, String pword){
		boolean retVal=false;
		driver.manage().deleteAllCookies();
		clickOnElement(SignInLink);
		type(Username, user);
		clickOnElement(PasswordPlaceHolder);
		type(Password, pword);
		clickOnElement(btnSignin);
		if(isElementVisible(zipcodeEntry))
		retVal=true;
		return retVal;
	}
	
	public boolean AutoPayLink(){
		boolean retVal=false;
		clickOnElement(Autopay);
		System.out.println("User navigated to Payment page: "+driver.getCurrentUrl());
		retVal=true;
		return retVal;
	}
	
	public void goToHome(String URL){
		driver.navigate().to(URL);
	}
	
	public void WatchAnywhereOD(){
		String text1,text2,text3;
		if(isElementVisible("xpath;//*[contains(text(),'Watch Anywhere')]"))
			System.out.println("Watch Anywhere Section is available on Homepage");
		
		wait(Until.elementToBeDisplayed("xpath;//div[@class='tve-switcher']/..//*[@tab-name='On Demand']/button"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//div[@class='tve-switcher']/..//*[@tab-name='On Demand']/button")));
		clickOnElement("xpath;//div[@class='tve-switcher']/..//*[@tab-name='On Demand']/button");
		
		sleep(10);
		//wait(Until.elementToBeDisplayed("xpath;(//*[contains(@resize,'onDemand')]/div/button[@title='Previous'])[1]"));
		driver.findElement(By.xpath("(.//*[@id='BCLcontainingBlock']/div/div[2]/button[1])[2]")).click();
		//wait(Until.elementToBeDisplayed("xpath;(//*[contains(@resize,'onDemand')]/div/button[@title='Previous'])[1]"));
		driver.findElement(By.xpath("(.//*[@id='BCLcontainingBlock']/div/div[2]/button[1])[2]")).click();
		//wait(Until.elementToBeDisplayed("xpath;//*[@class='ng-scope cc-carousel-slide fake active-slide']/button"));
		
		sleep(5);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		if(isElementPresent("xpath;(//*[contains(@class,'active')]/button[contains(@cc-link,'Play')])[2]")){
			clickOnElement("xpath;(//*[contains(@class,'active')]/button[contains(@cc-link,'Play')])[2]");
			text1 = getAttribute("xpath;(//*[contains(@class,'active')]/button[contains(@cc-link,'Play')])[2]/../img", "src");
			sleep(15);
			
			clickOnElement("xpath;//div[@class='tve-switcher']/..//*[@tab-name='Networks']/button");
			sleep(10);
			clickOnElement("xpath;//div[@class='tve-switcher']/..//*[@tab-name='On Demand']/button");
			text2 = getAttribute("xpath;(//*[contains(@class,'active')]/button[contains(@cc-link,'Play')])[2]/../img", "src");
			System.out.println(text2);
			if(text1.equalsIgnoreCase(text2)){
				System.out.println("User is returned to the asset cover art corresponding to the video player previously played");
			}
			sleep(10);
			text3 = getAttribute("xpath;(//*[contains(@class,'active')]/button[contains(@cc-link,'Play')])[2]/../img", "src");
			if(!(text2.equals(text3))){
				System.out.println("Cover art changes for every 8 seconds");
			}
		}
		else{
			wait(Until.elementToBePresent("xpath;(//*[contains(@class,'active')]/button[contains(@cc-link,'Play')])[2]"));
			WebElement play= driver.findElement(By.xpath("(//*[contains(@class,'active')]/button[contains(@cc-link,'Play')])[2]"));
			text1 = getAttribute("xpath;(//*[contains(@class,'active')]/button[contains(@cc-link,'Play')])[2]/../img", "src");
			System.out.println(text1);
			play.click();
			System.out.println("Clicked on play asset");
			sleep(15);
			
			clickOnElement("xpath;//div[@class='tve-switcher']/..//*[@tab-name='Networks']/button");
			sleep(10);
			clickOnElement("xpath;//div[@class='tve-switcher']/..//*[@tab-name='On Demand']/button");
			text2 = getAttribute("xpath;(//*[contains(@class,'active')]/button[contains(@cc-link,'Play')])[2]/../img", "src");
			System.out.println(text2);
			if(text1.equalsIgnoreCase(text2)){
				System.out.println("User is returned to the asset cover art corresponding to the video player previously played");
			}
			sleep(15);
			text3 = getAttribute("xpath;(//*[contains(@class,'active')]/button[contains(@cc-link,'Play')])[2]/../img", "src");
			if(!(text2.equals(text3))){
				System.out.println("Cover art changes for every 8 seconds");
			}
		}

		/*	if(isElementPresent("xpath;//*[@id='_playerPdkSwfObject']")){
			clickOnElement("xpath;//*[@id='_playerPdkSwfObject']");
			wait(Until.elementToBeDisplayed("xpath;//*[@class='close-button']"));
			clickOnElement("xpath;//*[@class='close-button']");
		}*/
	}
	
	public boolean rememberMe(String username,String password){
		
		boolean retVal = false;
		wait(Until.elementToBeDisplayed(SignInLink));
		clickOnElement(SignInLink);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		if(isElementVisible(Username) & isElementVisible(PasswordPlaceHolder) & isElementVisible(btnSignin)){
			clearTextBox(Username);
			type(Username,username);
			type(PasswordPlaceHolder,password);
			if(!getAttribute("xpath;//*[@id='keep-me-in']", "value").equals("true")){ // select Remember Me check box if not selected
				clickOnElement("xpath;//*[text()='Remember Me']");
				System.out.println("Selected REMEMBER ME check box");
			}
			clickOnElement(btnSignin);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			if(isElementVisible(weSignOut)){
				System.out.println("Charter Login Successful");
				retVal = true;
			}
			else{
				System.out.println("Login Unsuccessful");
				String Folder = "LoginError";
				screenshot.saveScreenshot("Email"+ File.separator + Folder);
			}
		}
		else{
			System.out.println("Login Fields are not visible");
			String Folder = "LoginFieldsMissingError";
			screenshot.saveScreenshot("Email"+ File.separator + Folder);
		}
		return retVal;
	}
	
	public boolean usernameSuggestion(String username, String password){
		String newuser = username.substring(0,3);
		boolean retVal = false;
		wait(Until.elementToBeDisplayed(SignInLink));
		clickOnElement(SignInLink);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		if(isElementVisible(Username) & isElementVisible(PasswordPlaceHolder) & isElementVisible(btnSignin)){
			clearTextBox(Username);
			
			WebElement element = driver.findElement(By.xpath("//*[@id='cc-username']"));
			element.sendKeys(newuser);
			sleep(2);
			element.sendKeys(Keys.ARROW_DOWN);
			sleep(2);
			element.sendKeys(Keys.ENTER);
			
			type(PasswordPlaceHolder,password);
			clickOnElement(btnSignin);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			if(isElementVisible(weSignOut)){
				System.out.println("Charter Login Successful");
				retVal = true;
			}
			else{
				System.out.println("Login Unsuccessful");
				String Folder = "LoginError";
				screenshot.saveScreenshot("Login And Authentication"+ File.separator + Folder);
			}
		}
		else{
			System.out.println("Login Fields are not visible");
			String Folder = "LoginFieldsMissingError";
			screenshot.saveScreenshot("Login And Authentication"+ File.separator + Folder);
		}
		return retVal;
	}
	
	public boolean verifyTestData(String[] testdata){
		boolean retVal = true;
		for(int i=0;i<=testdata.length-1;i++){
		if(testdata[i].equals(null)){
			retVal = false;
			System.out.println("Test data not defined for parameter number "+i);
			break;
		}
		}
		return retVal;
	}
	
}

