package com.charter.page;

import java.io.File;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cognizant.framework.ajax.Until;
import com.cognizant.framework.core.CaptureScreenshot;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.WebDriverBase;

public class TVServicesPage extends WebDriverBase{
	private String URL= ReadFromExcel.getData("HomePage","Prod_Url");
	
	private  static String RecieverInput=ReadFromExcel.getLocator("TVServ","EditRecieverName");
	private  static String btnSave=ReadFromExcel.getLocator("TVServ","SaveButton");
	private  static String NicknameText=ReadFromExcel.getLocator("TVServ","NicknameText");
	
	private static String btnUpdate=ReadFromExcel.getLocator("TVServ","UpdateReciever");
	private static String SessionTimeOut=ReadFromExcel.getLocator("TVServ","Timeout");
	private static String btnOk=ReadFromExcel.getLocator("TVServ","btnOk");
	private static String TVSpectrum=ReadFromExcel.getLocator("TVServ","TVSpectrum");
	private static String TVLMlink=ReadFromExcel.getLocator("InternetServ","InternetLMlink");
	private static String PRLink=ReadFromExcel.getLocator("TVServ","PRLink");
	private static String Tv_Supportlink=ReadFromExcel.getLocator("TVServ","Tv_Supportlink");
	private static String DRLink=ReadFromExcel.getLocator("TVServ","DRLink");

	private static String AskCharterWidget=ReadFromExcel.getLocator("TVServ","AskCharterWidget");
	private static String BtnASK=ReadFromExcel.getLocator("TVServ","BtnASK");
	private static String ActivateNDRbtn=ReadFromExcel.getLocator("TVServ","ActivateNDRbtn");

	private static String NYDRLearnMore=ReadFromExcel.getLocator("TVServ","NYDRLearnMore");
	private static String ANDRLearnMore=ReadFromExcel.getLocator("TVServ","ANDRLearnMore");
	private static String UDRLearnMore=ReadFromExcel.getLocator("TVServ","UDRLearnMore");
	private static String ADRUpdatenow=ReadFromExcel.getLocator("TVServ","ADRUpdatenow");
	private static String CheckTV=ReadFromExcel.getLocator("TVServ","CheckTV");


	private static String EditNickname=ReadFromExcel.getLocator("TVServ","EditNickname");
	private static String CreateNickName=ReadFromExcel.getLocator("TVServ","CreateNickName");

	private static String TVBanner=ReadFromExcel.getLocator("TVServ","TVBanner");

	//************** Ayesha ****************//
	private static String TVServicesHeader=ReadFromExcel.getLocator("TVServ","TVServicesHeader");
	private static String SupportQuickLinksHeader=ReadFromExcel.getLocator("TVServ","SupportQuickLinksHeader");
	private static String AskCharterWidget1=ReadFromExcel.getLocator("BTPage","AskCharterWidget");
	private static String ManageTVServicesHeader=ReadFromExcel.getLocator("TVServ","ManageTVServicesHeader");
	private static String UpdateReceiverSection=ReadFromExcel.getLocator("TVServ","UpdateReceiverSection");
	private static String NameYourReceiverSection=ReadFromExcel.getLocator("TVServ","NameYourReceiverSection");
	private static String ActivateReceiverSection=ReadFromExcel.getLocator("TVServ","ActivateReceiverSection");
	private static String TVTipsHeader=ReadFromExcel.getLocator("TVServ","TVTipsHeader");
	private static String FooterTV=ReadFromExcel.getLocator("MAPage","FooterTV");
	private static String FooterMA=ReadFromExcel.getLocator("MAPage","FooterMA");
	private static String FooterSupport=ReadFromExcel.getLocator("MAPage","FooterSupport");

	CaptureScreenshot<WebDriver> screenshot; 

	public TVServicesPage(WebDriver driver){
		this.driver=driver;
		screenshot= new CaptureScreenshot<WebDriver>(driver);
	}

	public void ReNameDigital_Reciever(Map<String,String> testdata) {
		String newdigitalRecieverName=testdata.get("Devicenickname");
		clearTextBox(RecieverInput);
		screenshot.saveScreenshot("T518308"+ File.separator + "Enter NickName");
		type(RecieverInput, newdigitalRecieverName);
		screenshot.saveScreenshot("T518308"+ File.separator + "New NickName");
		clickOnElement(btnSave);
		screenshot.saveScreenshot("T518308"+ File.separator + "Saved NickName");
	}

	public boolean UpdateDigital_Reciever() {
		boolean retVal=false;
		clickOnElement(btnUpdate);
		clickOnElement(btnOk);
		retVal=true;
		return retVal;
	}
	public void verifyTitle(){
		TVServicesPage TV=new TVServicesPage(driver);
		String Title=TV.getWindowTitle();
		System.out.println("Page title "+Title);
	}
	public void istimeout_for_TVServices(){
		WebDriverWait w=new WebDriverWait(driver,901);
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SessionTimeOut)));
		if(w.equals(true)){
			System.out.println("Time Out session verified successfully ");
		}
		else{
			System.out.println("Time Out session not verified. ");
		}	
	}

	public boolean TVLearnMoreLink(){
		boolean retVal=false;
		wait(Until.elementToBeClickable(TVLMlink));
		if(isElementPresent(TVLMlink));
		retVal=true;
		return retVal;
	}

	public boolean FPR_DR_Link(){

		boolean retVal=false;
		wait(Until.elementToBeClickable(PRLink));
		clickOnElement(PRLink);
		System.out.println(driver.getCurrentUrl());
		driver.get(URL+"/my-tv-services/");
		wait(Until.elementToBeClickable(DRLink));
		clickOnElement(DRLink);
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

	public void AskCharterSection(){


		if(isElementPresent(AskCharterWidget)){
			System.out.println("Ask Charter Section Header is present in TV Services Page ");
		}
		else{
			System.out.println("Ask Charter Section Header is not present in TV Services Page");
		}	


		if(isElementPresent(BtnASK)){
			System.out.println("Ask button is present in TV Services Page ");
		}
		else{
			System.out.println("Ask button is not present in TV Services Page");
		}	
	}

	public boolean UpdateNow_ActivateNDR(){

		boolean retVal=false;
		wait(Until.elementToBeClickable(ActivateNDRbtn));
		clickOnElement(ActivateNDRbtn);
		retVal=true;
		driver.navigate().back();
		return retVal;

	}

	public boolean NYDR_TV_Manage_Section(){
		boolean retVal=false;
		
		wait(Until.elementToBeClickable(NYDRLearnMore));
		clickOnElement(NYDRLearnMore);
		System.out.println(driver.getCurrentUrl());
		driver.get(URL+"/my-tv-services/");
		wait(Until.elementToBeClickable(ANDRLearnMore));
		clickOnElement(ANDRLearnMore);
		System.out.println(driver.getCurrentUrl());
		driver.get(URL+"/my-tv-services/");
		wait(Until.elementToBeClickable(UDRLearnMore));
		clickOnElement(UDRLearnMore);
		System.out.println(driver.getCurrentUrl());
		retVal=true;
		return retVal;
	}

	public boolean TV_Support_Links(){
		boolean retVal=false;
		sleep(3);
		wait(Until.elementToBeClickable(PRLink));
		clickOnElement(PRLink);
		System.out.println(driver.getCurrentUrl());
		driver.navigate().back();
		wait(Until.elementToBeClickable(Tv_Supportlink));
		clickOnElement(Tv_Supportlink);
		System.out.println(driver.getCurrentUrl());
		retVal = true;
		return retVal;
	}

	public boolean DigitalReceiverLink(){
		boolean retVal=false;
		clickOnElement(DRLink);
		retVal = true;
		return retVal;

	}

	public boolean UDRLearnMLink(){

		boolean retVal=false;
		wait(Until.elementToBeClickable(UDRLearnMore));
		clickOnElement(UDRLearnMore);
		retVal = true;
		return retVal;
	}

	public boolean ADRUpdatebtn(){
		boolean retVal=false;
		wait(Until.elementToBeClickable(ADRUpdatenow));
		clickOnElement(ADRUpdatenow);
		retVal = true;
		return retVal;

	}
	//Existing Defect for CheckTV Link in TV Services page
	public boolean CheckTVlink(){

		boolean retVal=false;
		if(isElementPresent(CheckTV)){
			//clickOnElement(CheckTV);
			retVal=true;
		}
	

		return retVal;

	}

	public boolean UpdateAndSaveMACAddress(String Devicenickname){
		boolean retVal=false;
		wait(Until.elementToBeClickable(EditNickname));
		clickOnElement(EditNickname);
		clearTextBox(CreateNickName);
		type(CreateNickName,Devicenickname);
		clickOnElementUsingJavaScript(btnSave);
		retVal=true;
		return retVal;
	}

	public String nicknameverify(){
		
		System.out.println(getText(NicknameText));
		return getText(NicknameText);
		
	}
	public boolean NYDRToMATVPage(){
		boolean retVal=false;
		wait(Until.elementToBeClickable(NYDRLearnMore));
		clickOnElement(NYDRLearnMore);
		retVal = true;
		return retVal;
	}

	public boolean ANDRLMlink()
	{
		boolean retVal=false;
		wait(Until.elementToBeClickable(ANDRLearnMore));
		clickOnElement(ANDRLearnMore);
		retVal = true;
		return retVal;

	}

	public boolean ViewBannerAndSupportVideo(){
		boolean retVal=false;
		if(isElementPresent(TVBanner)){
			clickOnElement(TVBanner);
			System.out.println("User Navigated to Charter TV App Page:"+ driver.getCurrentUrl());
			driver.navigate().back();
			retVal=true;
		}
			return retVal;
	}

	//*********** Ayesha****************//
	public boolean TVServicesHeaders(){
		boolean retVal=false;
		if(isElementPresent(TVServicesHeader)&(isElementPresent(SupportQuickLinksHeader)&(isElementPresent(ManageTVServicesHeader)&(isElementPresent(UpdateReceiverSection)
				&(isElementPresent(NameYourReceiverSection)&(isElementPresent(AskCharterWidget1)&(isElementPresent(ActivateReceiverSection))
						&(isElementPresent(TVTipsHeader)&(isElementPresent(FooterMA))&(isElementPresent(FooterTV))&(isElementPresent(FooterSupport)))))))))
		{
			retVal=true;
		}
		return retVal;
	}
}
