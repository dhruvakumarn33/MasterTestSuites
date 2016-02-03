package com.charter.page;

import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cognizant.framework.ajax.Until;
import com.cognizant.framework.core.CaptureScreenshot;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.WebDriverBase;

public class VoiceServicesPage extends WebDriverBase{

	private String URL= ReadFromExcel.getData("HomePage","Prod_URL");

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
		screenshot.saveScreenshot("T518318"+ File.separator + "Charter Phone Link");
		driver.navigate().back();
		clickOnElement(CPManage);
		screenshot.saveScreenshot("T518318"+ File.separator + "ManageLink");
		driver.navigate().back();
		clickOnElement(CPLearnMore);
		screenshot.saveScreenshot("T518318"+ File.separator + "LearnMore Link");
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
	public boolean CharterPhoneLink(){

		boolean retVal=false;
		wait(Until.elementToBeClickable(VoiceManage));
		clickOnElement(VoiceManage);
		//System.out.println(driver.getCurrentUrl());
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
		if(isElementPresent(VoiceServicesHeader))
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
			driver.navigate().to(URL);
			retVal=true;
		}
		return retVal;
	}

}
