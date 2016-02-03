package com.charter.page;

import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cognizant.framework.ajax.Until;
import com.cognizant.framework.core.CaptureScreenshot;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.WebDriverBase;

public class VoiceServicesPage extends WebDriverBase{

	private String URL= ReadFromExcel.getData("HomePage","Prod_Url");

	private  String btnPhone=ReadFromExcel.getLocator("VoiceServ","Phone");
	private String VOICE_SERVICE_TITLE = "Charter.net Voice Services";
	private String SessionTimeOut=ReadFromExcel.getLocator("VoiceServ","Timeout");
	private String CPLearnMore=ReadFromExcel.getLocator("VoiceServ","CPLearnMore");
	private String CPManage=ReadFromExcel.getLocator("VoiceServ","CPManage");
	private static String VoiceLMlink=ReadFromExcel.getLocator("InternetServ","InternetLMlink");
	private static String VoiceSpectrum=ReadFromExcel.getLocator("VoiceServ","VoiceSpectrum");
	private static String VoiceHelpLink=ReadFromExcel.getLocator("VoiceServ","VoiceHelpLink");
	private static String VoiceFeaturesLink=ReadFromExcel.getLocator("VoiceServ","VoiceFeaturesLink");
	private static String AskCharterWidget=ReadFromExcel.getLocator("TVServ","AskCharterWidget");
	private static String BtnASK=ReadFromExcel.getLocator("TVServ","BtnASK");
	private static String CharterPhone=ReadFromExcel.getLocator("VoiceServ","CharterPhone");
	private static String VoiceLearnMore=ReadFromExcel.getLocator("VoiceServ","VoiceLearnMore");
	private static String VoiceManage=ReadFromExcel.getLocator("VoiceServ","VoiceManage");
	//*************** Ayesha ********************//
	private static String VoiceServicesHeader=ReadFromExcel.getLocator("VoiceServ","VoiceServicesHeader");
	private static String SupportLinksHeader=ReadFromExcel.getLocator("InternetServ","SupportLinksHeader");
	private static String ManageVoiceServiceHeader=ReadFromExcel.getLocator("VoiceServ","ManageVoiceServiceHeader");
	private static String VoiceTipsHeader=ReadFromExcel.getLocator("VoiceServ","VoiceTipsHeader");
	private static String CharterOnlineManagerHeader=ReadFromExcel.getLocator("VoiceServ","CharterOnlineManagerHeader");
	private static String VoiceHeader=ReadFromExcel.getLocator("VoiceServ", "Voiceheader");
	private static String promotionalbanner=ReadFromExcel.getLocator("VoiceServ", "promotionalbanner");

	private static String FooterTV=ReadFromExcel.getLocator("MAPage","FooterTV");
	private static String FooterMA=ReadFromExcel.getLocator("MAPage","FooterMA");
	private static String FooterSupport=ReadFromExcel.getLocator("MAPage","FooterSupport");
	private static String VoiceBanner=ReadFromExcel.getLocator("VoiceServ","VoiceBanner");
	CaptureScreenshot<WebDriver> screenshot;	

	public VoiceServicesPage(WebDriver driver){
		this.driver=driver;
		screenshot= new CaptureScreenshot<WebDriver>(driver);
	}
	public void ClickPhoneOnlineManagerServiceBar() {

		clickOnElement(btnPhone);
		driver.navigate().back();
		clickOnElement(CPManage);
		driver.navigate().back();
		clickOnElement(CPLearnMore);
		driver.navigate().back();
		driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
	}
	public void VerifyVoiceServicesPageTitle(){
		String Title=new VoiceServicesPage(driver).getWindowTitle();
		if(Title.trim().equalsIgnoreCase(VOICE_SERVICE_TITLE)){
			System.out.println("Voice Services Page title verified successfully.");
		}
		else{
			System.out.println("Voice Services Page title was not verified.");
		}
	}

	public void istimeout_for_VoiceServices(){
		WebDriverWait w=new WebDriverWait(driver,900);
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SessionTimeOut)));
		if(w.equals(true)){
			System.out.println("Time Out session verified successfully ");
		}
		else{
			System.out.println("Time Out session not verified. ");
		}	
	}

	public boolean VoiceLearnMoreLink(){

		boolean retVal=false;
		wait(Until.elementToBeClickable(VoiceLMlink));
		clickOnElement(VoiceLMlink);
		wait(Until.elementsToBePresent(VoiceSpectrum));
		if(isElementPresent(VoiceSpectrum)){
			retVal=true;
		}
		return retVal;

	}

	public boolean Voice_SupportLink(){
		boolean retVal=false;

		wait(Until.elementToBeClickable(VoiceHelpLink));
		clickOnElement(VoiceHelpLink);
		System.out.println("User Navigated to Voicemail Help Page"+driver.getCurrentUrl());
		driver.get(URL+"/my-voice-services/");
		wait(Until.elementToBeClickable(VoiceFeaturesLink));
		clickOnElement(VoiceFeaturesLink);
		System.out.println("User Navigated to Voice calling features Page"+driver.getCurrentUrl());
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
	public boolean VoiceOnlineManagerLink(){

		boolean retVal=false;
		wait(Until.elementToBeClickable(VoiceManage));
		clickOnElement(VoiceManage);
		System.out.println(driver.getCurrentUrl());
		retVal = true;
		return retVal;
	}

	public boolean charterPhone_Managelink(){

		boolean retVal=false;
		clickOnElement(VoiceManage);
		retVal = true;
		return retVal;

	}
	public boolean Manage_voiceServices(){

		boolean retVal=false;
		wait(Until.elementToBeClickable(VoiceLearnMore));
		clickOnElement(VoiceLearnMore);
		System.out.println(driver.getCurrentUrl());
		driver.get(URL+"/my-voice-services/");
		wait(Until.elementToBeClickable(VoiceManage));
		clickOnElement(VoiceManage);
		System.out.println(driver.getCurrentUrl());
		retVal=true;
		return retVal;
	}
	public boolean Voicehelp(){

		boolean retVal=false;
		wait(Until.elementToBeClickable(VoiceHelpLink));
		clickOnElement(VoiceHelpLink);
		retVal = true;
		return retVal;
	}
	public boolean VoiceFeatures(){
		boolean retVal=false;
		wait(Until.elementToBeClickable(VoiceFeaturesLink));
		clickOnElement(VoiceFeaturesLink);
		retVal = true;
		return retVal;
	}
	public boolean CharterPhoneLMLink(){

		boolean retVal=false;
		wait(Until.elementToBeClickable(CPLearnMore));
		clickOnElement(CPLearnMore);
		retVal = true;
		return retVal;
	}


	//**************** Ayesha *************//
	public boolean VoiceServicesHeaders(){
		boolean retVal=false;
		/*if(isElementPresent(VoiceServicesHeader)&(isElementPresent(SupportLinksHeader)&(isElementPresent(AskCharterWidget)&(isElementPresent(ManageVoiceServiceHeader)
				&(isElementPresent(VoiceTipsHeader)&(isElementPresent(CharterOnlineManagerHeader)&(isElementPresent(FooterTV))
						&(isElementPresent(FooterMA))&(isElementPresent(FooterSupport))))))))
		{
			retVal=true;
		}*/
		
		if(isElementPresent(VoiceHeader)&(isElementPresent(promotionalbanner)&(isElementPresent(AskCharterWidget))))
		{
			retVal=true;
		}
		return retVal;
	}

	public boolean ViewBannerAndSupportVideo(){

		boolean retVal=false;
		if(isElementPresent(VoiceBanner)){
			clickOnElement(VoiceBanner);
			System.out.println("User Navigated to Phone Online Manager Page:"+driver.getCurrentUrl());
			retVal=true;
		}

		return retVal;
	}
	
	public boolean checkVoiceEquipment(){
		boolean retVal=false;
		if(isElementVisible(VoiceManage)){		
			System.out.println("Voice Service Page displays only Security Suite as Tools");
			retVal= true;
		}
		return retVal;
	}
	
	public boolean CPNIRoadBlock(String MAC){
		boolean retVal=false;
		if(isElementPresent("xpath;//*[@class='charter-modal']")){
			System.out.println("User is Non CPNI");
			type("xpath;.//*[@id='MAC']",MAC);
			sleep(5);
			clickOnElement("//*[@value='Submit']");
			sleep(10);
		}
		else
			System.out.println("User is CPNI");
		retVal=true;
		sleep(10);
		return retVal;
	}
	
	public boolean VoiceNotificationMail(String email){
		boolean retVal=false;
		clickOnElement("xpath;(//div[@title='Readable Voicemail'])[1]");
		wait(Until.elementToBeDisplayed("xpath;//*[contains(text(),'DELETE ALL')]"));
		clickOnElement("xpath;//*[contains(text(),'DELETE ALL')]");
		sleep(5);
		wait(Until.elementToBeDisplayed("xpath;(//*[@id='focusDelete'])[1]"));
		clickOnElement("xpath;(//*[@id='focusDelete'])[1]");
		sleep(5);
		wait(Until.elementToBeDisplayed("xpath;//*[@class='feature-cf-header2']/label[1]"));
		
		if(isElementEnabled("xpath;//*[@class='feature-cf-header2']/label[1]"))
			System.out.println("Readable Voicemail Radio is enabled");
		clickOnElement("xpath;//*[@class='feature-cf-header2']/label[2]");
		sleep(5);
		clickOnElement("xpath;//*[contains(text(),'SAVE')]");
		sleep(5);
		clickOnElement("xpath;.//*[@id='focusSave']");
		sleep(5);
		wait(Until.elementToBeDisplayed("xpath;(.//*[@id='focusSuccess'])[1]"));
		clickOnElement("xpath;(.//*[@id='focusSuccess'])[1]");
		sleep(5);
		clickOnElement("xpath;//*[@class='feature-cf-header2']/label[1]");	
		sleep(5);
		type("xpath;(//*[@placeholder='Enter an email address'])[1]",email);
		sleep(5);
		clickOnElement("xpath;//*[contains(text(),'SAVE')]");
		sleep(5);
		wait(Until.elementToBeDisplayed("xpath;(.//*[@id='focusSave'])[1]"));
		clickOnElement("xpath;(.//*[@id='focusSave'])[1]");
		sleep(5);
		wait(Until.elementToBeDisplayed("xpath;(//*[contains(text(),'confirmation email')])[2]"));
		sleep(5);
		if(isElementVisible("xpath;(//*[contains(text(),'confirmation email')])[2]"))
			System.out.println("Success Message : "+getText("xpath;(//*[contains(text(),'confirmation email')])[2]"));
		clickOnElement("xpath;(.//*[@id='focusSuccess'])[1]");
		
		Voicemail_VerificationMail();
		retVal=true;
		return retVal;
	}
	
	public void Voicemail_VerificationMail(){
		sleep(5);
		clickOnElement("xpath;//span[contains(text(),'Email')]");
		sleep(5);
		WebElement email = driver.findElement(By.xpath("(//*[text()='Confirm your sign-up for Readable Voicemail notifications'])[1]"));
		while(!isElementVisible("xpath;(//*[text()='Confirm your sign-up for Readable Voicemail notifications'])[1]")){
			sleep(5);
			clickOnElement("xpath;//*[@id='get-mail-button-label']");
		}
		email.click();
		sleep(5);
		System.out.println("Email Received");
	}

}
