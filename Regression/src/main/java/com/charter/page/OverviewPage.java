package com.charter.page;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.charter.page.UserPreferencePage.userType;
import com.cognizant.framework.ajax.Until;
import com.cognizant.framework.core.CaptureScreenshot;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.WebDriverBase;

public class OverviewPage extends WebDriverBase {
	//private String URL= ReadFromExcel.getData("HomePage","Prod_Url");

	private static String AskCharterTitle=ReadFromExcel.getLocator("BillDeliveryPage", "AskCharterTitle");
	private static String OverviewLink=ReadFromExcel.getLocator("OverviewPage", "OverviewLink");
	private static String lnkupcomingpayments=ReadFromExcel.getLocator("OverviewPage", "lnkupcomingpayments");
	private static String weAskCharter=ReadFromExcel.getLocator("BillDeliveryPage", "weAskCharter");
	private static String weask=ReadFromExcel.getLocator("BillDeliveryPage", "weask");
	private static String btnask=ReadFromExcel.getLocator("BillDeliveryPage", "btnask");
	private static String inputbox=ReadFromExcel.getLocator("BillDeliveryPage", "inputbox");
	private static String btnask2=ReadFromExcel.getLocator("BillDeliveryPage", "btnask2");
	private static String txtPayment=ReadFromExcel.getLocator("BillDeliveryPage", "txtPayment");
	
	private static String txtSAP=ReadFromExcel.getLocator("OverviewPage", "txtSAP");
	private static String weReschedule=ReadFromExcel.getLocator("OverviewPage", "weReschedule");
	private static String weSAPCancel=ReadFromExcel.getLocator("OverviewPage", "weSAPCancel");
	public static String TVlink=ReadFromExcel.getLocator("OverviewPage","linkTV");
	public static String Internetlink=ReadFromExcel.getLocator("OverviewPage","linkInternet");
	public static String Voicelink=ReadFromExcel.getLocator("OverviewPage","linkVoice");
	private String OVERVIEW_PAGE_TITLE_QA ="Charter.net My Account";
	private String lnkUpgrade_TV=ReadFromExcel.getLocator("OverviewPage","UpgradeTVLink");
	private String lnkUpgrade_Internet=ReadFromExcel.getLocator("OverviewPage","UpgradeInternetLink");
	private String lnkUpgrade_Voice=ReadFromExcel.getLocator("OverviewPage","UpgradeVoiceLink");
	private String UsrPref=ReadFromExcel.getLocator("OverviewPage","UserAndPref");
	private String RedAlertIcon=ReadFromExcel.getLocator("OverviewPage","RedAlert");
	private String MSG=ReadFromExcel.getLocator("OverviewPage","Message");
	private String btnUpdateNow=ReadFromExcel.getLocator("OverviewPage","UpdateNow");


	private static String Details=ReadFromExcel.getLocator("OverviewPage", "Details");
	private static String ViewCBill=ReadFromExcel.getLocator("BTPage","ViewCBill");
	private static String ViewDueDate=ReadFromExcel.getLocator("BTPage","ViewDueDate");
	private static String UpcomingPayments=ReadFromExcel.getLocator("OverviewPage", "UpcomingPayments");
	private static String BillDeliveryOptions=ReadFromExcel.getLocator("OverviewPage", "BillDeliveryOptions");
	private static String PayBill=ReadFromExcel.getLocator("OverviewPage", "PayBill");
	private static String ViewBill=ReadFromExcel.getLocator("OverviewPage", "ViewBill");
	private static String ViewPaymentDueDate=ReadFromExcel.getLocator("OverviewPage", "ViewPaymentDueDate");

	private static String TVNickNameDevice=ReadFromExcel.getLocator("OverviewPage", "TVNickNameDevice");
	private static String TVRefreshDevice=ReadFromExcel.getLocator("OverviewPage", "TVRefreshDevice");
	private static String InternetCheckEmail=ReadFromExcel.getLocator("OverviewPage", "InternetCheckEmail");
	private static String InternetSecuritySuite=ReadFromExcel.getLocator("OverviewPage", "InternetSecuritySuite");
	private static String POMLink=ReadFromExcel.getLocator("OverviewPage", "POMLink");
	private static String UpgradeLink=ReadFromExcel.getLocator("OverviewPage", "Upgrade_std");

	private static String BTHelpicon=ReadFromExcel.getLocator("OverviewPage", "BTHelpicon");
	private static String SEHelpicon=ReadFromExcel.getLocator("OverviewPage", "SEHelpicon");
	private static String UPHelpicon=ReadFromExcel.getLocator("OverviewPage", "UPHelpicon");
	private static String BTPaybill=ReadFromExcel.getLocator("OverviewPage","BTPaybill");
	private static String CallDetailsLink=ReadFromExcel.getLocator("OverviewPage","CallDetailsLink");
	private static String CallDetailsHelpicon=ReadFromExcel.getLocator("OverviewPage","CallDetailsHelpicon");

	private static String Upsection=ReadFromExcel.getLocator("OverviewPage","Upsection");
	private static String BTSection=ReadFromExcel.getLocator("OverviewPage","BTSection");
	private static String SESection=ReadFromExcel.getLocator("OverviewPage", "SESection");

	private static String AskCWidget=ReadFromExcel.getLocator("TVServ","AskCharterWidget");
	private static String BtnASK=ReadFromExcel.getLocator("TVServ","BtnASK");

	private static String OverviewEditInfo=ReadFromExcel.getLocator("OverviewPage","OverviewEditInfo");
	private static String weAddress1=ReadFromExcel.getLocator("BTPage", "weAddress1");
	private static String weAddress2=ReadFromExcel.getLocator("BTPage", "weAddress2");
	private static String weCityField=ReadFromExcel.getLocator("BTPage", "weCityField");
	private static String weStateCode=ReadFromExcel.getLocator("BTPage", "weStateCode");
	private static String weZipCode=ReadFromExcel.getLocator("BTPage", "weZipCode");
	private static String btSavee=ReadFromExcel.getLocator("BTPage", "btSavee");
	private static String weBillAddress=ReadFromExcel.getLocator("OverviewPage", "weBillAddress");
	private static String BtnOK=ReadFromExcel.getLocator("BTPage", "BtnOK");

	private static String HOHImage=ReadFromExcel.getLocator("OverviewPage", "HOHImage");
	private static String AdminImage=ReadFromExcel.getLocator("OverviewPage", "AdminImage");
	private static String StandardImage=ReadFromExcel.getLocator("OverviewPage", "StandardImage");

	//**********Ayesha*****************//
	private static String ServiceAddress=ReadFromExcel.getLocator("OverviewPage", "ServiceAddress");
	private static String BillingAddress=ReadFromExcel.getLocator("OverviewPage", "BillingAddress");
	private static String AskCharterWidget1=ReadFromExcel.getLocator("MAPage","AskCharterWidget");
	private static String CharterWifi=ReadFromExcel.getLocator("MAPage","CharterWifi");

	private static String FooterTV=ReadFromExcel.getLocator("MAPage","FooterTV");
	private static String FooterMA=ReadFromExcel.getLocator("MAPage","FooterMA");
	private static String FooterSupport=ReadFromExcel.getLocator("MAPage","FooterSupport");
	


	CaptureScreenshot<WebDriver> screenshot;
	WebDriver popupDriver = null;
	public OverviewPage(WebDriver driver) {
		this.driver=driver;
		screenshot= new CaptureScreenshot<WebDriver>(driver);
	}

	public void Overviewlink()
	{
		hoverOver(OverviewLink);
		clickOnElement(OverviewLink);		
	}

	public void askCharter(String searchkey){

		clickOnElement(lnkupcomingpayments);
		wait(Until.elementToBeDisplayed(weAskCharter));
		clickOnElement(weAskCharter);
		type(weask,searchkey);
		String parent=driver.getWindowHandle();
		clickOnElement(btnask);
		sleep(5);

		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> windowIterator = windowHandles.iterator();
		while(windowIterator.hasNext()) { 
			String windowHandle = windowIterator.next(); 
			sleep(3);
			popupDriver = driver.switchTo().window(windowHandle);

			System.out.println(popupDriver.getTitle() + "popupDriver");

			if (popupDriver.getTitle().equals("Ask Charter")) {
				System.out.println("User in new window");
				clearTextBox(inputbox);
				type(inputbox,searchkey);
				clickOnElement(btnask2);
				popupDriver.close();
				driver = driver.switchTo().window(parent);		
			}
			else{
				System.out.println(driver.getTitle()+"ELSE");
			}

		}

	}

	public void Reschedule_Appointment(){

		wait(Until.elementToBeDisplayed(txtSAP));

		if(isElementPresent(weReschedule))
		{
			clickOnElement(weReschedule);
		}

	}


	public void Cancel_Appointment(){

		wait(Until.elementToBeDisplayed(txtSAP));

		if(isElementPresent(weSAPCancel))
		{
			clickOnElement(weSAPCancel);
		}

	}

	public void TVInternetVoiceLInk(){
		//TV Service
		clickOnElement(TVlink);
		if(isElementVisible("xpath;(//div/*[@class='device-type ng-binding'])[1]")){
			System.out.println("TV Equipment Available");
		}
		//Internet Service
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//*[contains(@class,'account')]//*[text()='Internet'][contains(@cc-crumb,'Footer')]")));
		wait(Until.elementsToBeDisplayed("xpath;//*[contains(@class,'account')]//*[text()='Internet'][contains(@cc-crumb,'Footer')]"));
		clickOnElement("xpath;//*[contains(@class,'account')]//*[text()='Internet'][contains(@cc-crumb,'Footer')]");
		sleep(5);
		if(driver.findElement(By.xpath("//*[contains(text(),'Check Email')]")).isDisplayed() || driver.findElement(By.xpath("//*[contains(text(),'Go to Security Suite')]")).isDisplayed())
			System.out.println("Internet Equipment Available");
		//Voice Service
		je.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//*[contains(@class,'account')]//*[text()='Voice'][contains(@cc-crumb,'Footer')]")));
		wait(Until.elementsToBeDisplayed("xpath;//*[contains(@class,'account')]//*[text()='Voice'][contains(@cc-crumb,'Footer')]"));
		clickOnElement("xpath;//*[contains(@class,'account')]//*[text()='Voice'][contains(@cc-crumb,'Footer')]");
		if(driver.findElement(By.xpath("//*[contains(text(),'Voice Online Manager')]")).isDisplayed())
			System.out.println("Voice Equipment available");
	}
	
	public void VerifyOverViewPageTitle(){
		OverviewPage OP=new OverviewPage(driver);
		String Title=OP.getWindowTitle();
		if(Title.trim().equalsIgnoreCase(OVERVIEW_PAGE_TITLE_QA)){
			System.out.println("OverView page title Verified successfully.");
		}else{
			System.out.println("OverView page title was not Verified.");	
		}
	}

	public void validateServiceAndEquipment_TV() {
		clickOnElement(lnkUpgrade_TV);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		String Title=driver.getTitle();
		if(Title.contains("Charter Spectrum TV: 200+ Channels available including FREE HD")){
			System.out.println("Service&Equipment Section,"+"/n"+"Upon click on Upgrade button user navigated to Charter.com page");
		}
		else{
			System.out.println("Service&Equipment Section,"+"/n"+"User didn't navigate to Charter.com page");
		}
		driver.navigate().back();
	}

	public void validateServiceAndEquipment_Internet() {
		clickOnElement(lnkUpgrade_Internet);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		String Title=driver.getTitle();
		if(Title.contains("Charter Internet: Download speeds up to 30 Mbps")){
			System.out.println("Service&Equipment Section,"+"/n"+"Upon click on Upgrade button user navigated to Charter.com page");
		}
		else{
			System.out.println("Service&Equipment Section,"+"/n"+"User didn't navigate to Charter.com page");
		}
		driver.navigate().back();
	}

	public void validateServiceAndEquipment_Voice() {
		clickOnElement(lnkUpgrade_Voice);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		String Title=driver.getTitle();
		if(Title.contains("Charter Spectrum Voice: Reliable home phone with unlimited local and long distance")){
			System.out.println("Service&Equipment Section,"+"/n"+"Upon click on Upgrade button user navigated to Charter.com page");
		}
		else{
			System.out.println("Service&Equipment Section,"+"/n"+"User didn't navigate to Charter.com page");
		}
		driver.navigate().back();
	}

	public void CheckUserAndPreference(){
		if(isElementVisible(UsrPref)==true){
			System.out.println("Users AND Preference Section Present on Overview Page.");
		}else{
			System.out.println("Users AND Preference Section Not Present on Overview Page.");
		}
	}

	public void CheckRedAlertAndConvertUSer(){
		if(isElementVisible(RedAlertIcon)==true){
			System.out.println("Red Alert icon present on non converted users.");
		}else{
			System.out.println("Red Alert icon not present on non converted users.");  
		}

	}

	public void Verifymessage(Map<String,String> testdata){
		String Msg_Expected=testdata.get("Message");
		clickOnElement(RedAlertIcon);
		String MsgText=getText(MSG);
		if(MsgText.trim().equalsIgnoreCase(Msg_Expected));
		System.out.println("Message verified successsfully");
		new WebDriverWait(driver,5).until(ExpectedConditions.elementToBeClickable(By.id(btnUpdateNow)));

	}

	public boolean viewbill()throws InterruptedException{
		boolean retVal=false;
		wait(Until.elementToBeClickable(ViewBill));
		clickOnElement(ViewBill);
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
			if(!windowHandle.equals(parentWindow))
			{
				driver.switchTo().window(windowHandle);
				sleep(5);
				driver.close(); //closing child window
				driver.switchTo().window(parentWindow);//cntrl to parent window
				sleep(3);
			}
		}
		retVal=true;
		return retVal;	
	}


	public boolean BTSection_Links() throws InterruptedException{
		boolean retVal=false;
		if(isElementEnabled(Details) && (isElementEnabled(PayBill) && (isElementEnabled(ViewBill) && (isElementEnabled(UpcomingPayments))))){
			clickOnElement(Details);
			driver.navigate().back();
			wait(Until.elementToBeClickable(BillDeliveryOptions));
			clickOnElement(BillDeliveryOptions);
			retVal=true;
		}
		return retVal;
	}

	public boolean NDLink(){

		boolean Val=false;
		wait(Until.elementToBeClickable(TVNickNameDevice));
		clickOnElement(TVNickNameDevice);
		sleep(5);
		Val=true;
		return Val;

	}

	public boolean RefreshDevicesLink(){

		boolean retVal=false;
		clickOnElement(TVRefreshDevice);
		sleep(5);
		retVal = true;
		return retVal;		
	}

	public boolean CheckEmailLink(){

		boolean retVal=false;
		clickOnElement(InternetCheckEmail);
		retVal = true;
		return retVal;	
	}

	public boolean SecuritySuiteLink(){

		boolean retVal=false;
		clickOnElement(InternetSecuritySuite);
		sleep(5);
		retVal = true;
		return retVal;	
	}


	public boolean UpgradeLink_Standard(){

		boolean retVal=true;
		if(isElementVisible(UpgradeLink)){
			retVal= false;
		}
		return retVal;
	}

	public boolean POMLink(){

		boolean retVal=false;
		wait(Until.elementToBeClickable(POMLink));
		clickOnElement(POMLink);
		System.out.println(driver.getCurrentUrl());
		retVal=true;
		return retVal;	

	}

	public boolean TV_Internet_Voice_DetailsLink(){

		boolean retVal=false;
		wait(Until.elementToBeClickable(TVlink));
		clickOnElement(TVlink);
		System.out.println(driver.getCurrentUrl());
		driver.get("https://www.charter.net/my-account/");
		//driver.navigate().back();
		//wait(Until.elementToBeDisplayed(Internetlink));
		clickOnElement(Internetlink);
		System.out.println(driver.getCurrentUrl());
		driver.get("https://www.charter.net/my-account/");
		//driver.navigate().back();
		//wait(Until.elementToBeDisplayed(Voicelink));
		clickOnElement(Voicelink);
		System.out.println(driver.getCurrentUrl());
		retVal =true;
		
		return retVal;
	}

	public boolean BTHelpicon(){

		boolean retVal=false;
		System.out.println("Billing and Transaction help icon:" + getText(BTHelpicon));
		if(isElementEnabled(BTHelpicon)){
			retVal= true;
		}
		return retVal;

	}

	public boolean SEHelpicon(){
		boolean retVal=false;
		if(isElementEnabled(SEHelpicon)){
			System.out.println("Service and Equipment Section Help icon:"+ getText(SEHelpicon));
			retVal=true;
		}

		return retVal;
	}
	public boolean UPHelpicon(){

		boolean retVal=false;
		if(isElementEnabled(UPHelpicon)){
			System.out.println("UserPreferences Section Help icon:"+ getText(UPHelpicon));
			retVal=true;
		}

		return retVal;
	}

	public boolean CallDetailsHelpicon(){

		boolean retVal=false;
		if(isElementPresent(CallDetailsHelpicon)){
			System.out.println(getText(CallDetailsHelpicon));
			retVal=true;
		}

		return retVal;
	}

	public boolean BTPage_PaybillLink(){

		boolean retVal=false;
		wait(Until.elementToBeClickable(BTPaybill));
		clickOnElement(BTPaybill);
		System.out.println("Navigated to Billing and Transaction Page"+driver.getCurrentUrl());
		retVal=true;
		return retVal;
	}

	public boolean BTSection(){

		boolean retVal = false;
		if(isElementPresent(BTSection)) {
			retVal = true;
		}
		return retVal;
	}
	public boolean UPSection(){

		boolean retVal = false;
		if(isElementPresent(Upsection)) {
			retVal = true;
		}
		return retVal;

	}

	public boolean AskCharterSection(){
		boolean retVal=false;
		System.out.println(getCurrentUrl());
		if(isElementPresent(AskCWidget) && (isElementPresent(BtnASK))){
			retVal = true;
		}	
		return retVal;
	}

	public boolean AvatarImages(){
		boolean retVal = false;
		WebElement wHOH= driver.findElement(By.xpath("//div[contains(@class,'user-pref-carousel')]/div[1]/ul/li//*[contains(text(),'Head of Household')]"));
		wHOH.click();
		driver.navigate().refresh();
		WebElement wAdmin=driver.findElement(By.xpath("//div[contains(@class,'user-pref-carousel')]/div[1]/ul/li//*[contains(text(),'e2e5023_child_03')]"));
		wAdmin.click();
		return retVal;
	}

	public boolean TV_Internet_UpgradeLink(String URL) throws InterruptedException{
		boolean retVal=false;
		wait(Until.elementToBeClickable(lnkUpgrade_TV));
		clickOnElement(lnkUpgrade_TV);
		System.out.println(driver.getCurrentUrl());
		//driver.navigate().back();
		driver.get(URL+"/my-account/");
		sleep(5);
		wait(Until.elementToBeClickable(lnkUpgrade_Internet));
		clickOnElement(lnkUpgrade_Internet);
		System.out.println(driver.getCurrentUrl());
		//driver.navigate().back();
		driver.get(URL+"/my-account/");
		sleep(5);
		retVal = true;
		return retVal;
	}

	/* public boolean Internet_UpgradeLink(){
		boolean retVal=false;	
		wait(Until.elementToBeClickable(lnkUpgrade_Internet));
		clickOnElement(lnkUpgrade_Internet);
		System.out.println(driver.getCurrentUrl());
		retVal = true;
		return retVal;
	}*/
	public boolean Voice_UpgradeLink(){
		boolean retVal=false;
		wait(Until.elementToBeClickable(lnkUpgrade_Voice));
		clickOnElement(lnkUpgrade_Voice);
		System.out.println(driver.getCurrentUrl());
		retVal = true;
		return retVal;
	}

	public String BTSectionText(){

		return getText(BTSection);

	}
	public String SESectionText(){

		return getText(SESection);

	}
	public String UpsectionText(){
		return getText(Upsection);
	}
	public String ServiceAddressLabel(){
		return getText(ServiceAddress);
	}

	public String BillingAddressLabel(){
		return getText(BillingAddress);
	}
	public String AskCharterWidgetText(){
		return getText(AskCharterWidget1);
	}
	public String FooterWatchTV(){
		return getText(FooterTV);
	}
	public String FooterMyAccount(){
		return getText(FooterMA);
	}
	public String FooterSupport(){
		return getText(FooterSupport);
	}

	public boolean OverviewHeaders(){
		boolean retVal=false;
		if(isElementPresent(CharterWifi)){
			System.out.println("Advertisment Image is present");
		}
		if(isElementPresent(AskCharterWidget1)){
			retVal=true;
		}
		return retVal;
	}
	
	public boolean firstTimeMyAccount(){
		boolean retVal=false;
		goToUrl("https://www.charter.net/billing-and-transactions/bill-delivery/#/first-time");
		if(isElementVisible("xpath;//*[@class='bt-delivery-form-container']"))
			retVal=true;
		return retVal;
		
	}
	
	public boolean userDetails(){
		boolean retVal=false;
		System.out.println("User Full Name: "+getText("xpath;//*[@class='account-info-name ng-binding']"));
		System.out.println("User Charter ID: "+getText("xpath;(//li/p[@class='ng-binding'])[1]"));
		System.out.println("User Account Number: "+getText("xpath;(//li/p[@class='ng-binding'])[2]"));
		System.out.println("Service Address: "+getText("xpath;(//*[@class='hidden-xs'])[1]"));
		System.out.println("Billing Address: "+getText("xpath;(//*[@class='hidden-xs ng-scope'])[1]"));
		System.out.println("Email Address: "+getText("xpath;(//*[@class='hidden-xs'])[2]"));
		retVal=true;
		return retVal;
	}
	
	public void BTdata()
	{
		WebElement btdata = driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/div/div[2]/section/div/div/div[1]"));
	    System.out.println(btdata.getText());
	}
	
	public void Billsection()
	{
		WebElement billsection = driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/div/div[2]/section/div/div/div[2]"));
	    System.out.println(billsection.getText());
	}
	
	public void AutoPayStatus()
	{
		WebElement aps = driver.findElement(By.xpath("/html/body/div[1]/section/div/div[3]/section/div/div/div[1]/div"));
        System.out.println(aps.getText());	
	}
	
	public void viewbilllink()
	{
		WebElement vbl = driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/div/div[2]/section/div/div/div[3]/ul/li[1]/a"));
		vbl.click();
	}
	
	public void askcharterwidget()
	{
		WebElement ask = driver.findElement(By.xpath("/html/body/div[1]/section/div/div[1]/div/div/div[2]/div/section/div/div[2]/h3"));
		System.out.println(ask.getText());
	}
	
	public void upcomingPaymentsLink(){
		wait(Until.elementToBeDisplayed(UpcomingPayments));
		clickOnElement(UpcomingPayments);
		System.out.println("User navigated to Upcoming payments page : "+getCurrentUrl());
	}
	
}





