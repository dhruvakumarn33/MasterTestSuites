package com.charter.page;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.thoughtworks.selenium.condition.Text;
import com.cognizant.framework.ajax.Until;
import com.cognizant.framework.core.CaptureScreenshot;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.WebDriverBase;

public class InternetServicesPage extends WebDriverBase {
	private String URL= ReadFromExcel.getData("HomePage","Prod_URL");

	private static String MangeSecuritylink=ReadFromExcel.getLocator("InternetServ","ManageSecurity");
	private  static String SecuritySuitelink=ReadFromExcel.getLocator("InternetServ","SecuritySuite");
	private  static String Security_LearnMore=ReadFromExcel.getLocator("InternetServ","Security_LearnMore");
	private static String CloudDrive=ReadFromExcel.getLocator("InternetServ","CloudDrive");
	private static String Mange_CloudDrivelink=ReadFromExcel.getLocator("InternetServ","ManageCloudDrive");
	private  static String cloud_LearnMore=ReadFromExcel.getLocator("InternetServ","LearnCloud");
	private  static String Emailink=ReadFromExcel.getLocator("InternetServ","CharterEmail");
	private  static String MangeEmaillink=ReadFromExcel.getLocator("InternetServ","ManageEmail");
	private  static String Email_LearnMore=ReadFromExcel.getLocator("InternetServ","LearnEmail");
	private  static String EmailTab=ReadFromExcel.getLocator("InternetServ","EmailTab");
	private  static String CloudDrive_Login="Charter Cloud Drive™ | Login";
	private  static String LearnMore_Cloud="Charter Cloud Drive";
	private static String SECURITY_PAGE_TITLE="Charter.net Security Suite";
	private static String Manage_SECURITY_PAGE_TITLE="Charter.net Security Suite";
	private static String LearnMore_PAGE_TITLE="Charter.net Charter Security Suite";
	private  static String SessionTimeOut=ReadFromExcel.getLocator("InternetServ","Timeout");

	private static String InternetLMlink=ReadFromExcel.getLocator("InternetServ","InternetLMlink");
	private static String InternetSpectrum=ReadFromExcel.getLocator("InternetServ","InternetSpectrum");

	private static String InternetSupport=ReadFromExcel.getLocator("InternetServ","InternetSupport");
	private static String CableModem=ReadFromExcel.getLocator("InternetServ","CableModem");
	private static String AskCharterWidget=ReadFromExcel.getLocator("TVServ","AskCharterWidget");
	private static String BtnASK=ReadFromExcel.getLocator("TVServ","BtnASK");

	private static String InternetServicesHeader=ReadFromExcel.getLocator("InternetServ","InternetServicesHeader");
	private static String SupportLinksHeader=ReadFromExcel.getLocator("InternetServ","SupportLinksHeader");
	private static String AskCharterWidget1=ReadFromExcel.getLocator("BTPage","AskCharterWidget");
	private static String ManageInternetServicesHeader=ReadFromExcel.getLocator("InternetServ","ManageInternetServicesHeader");
	private static String InternetTipsHeader=ReadFromExcel.getLocator("InternetServ","InternetTipsHeader");
	private static String CharterSecuritySuiteHeader=ReadFromExcel.getLocator("InternetServ","CharterSecuritySuiteHeader");

	private static String FooterTV=ReadFromExcel.getLocator("MAPage","FooterTV");
	private static String FooterMA=ReadFromExcel.getLocator("MAPage","FooterMA");
	private static String FooterSupport=ReadFromExcel.getLocator("MAPage","FooterSupport");
	private static String ISBanner=ReadFromExcel.getLocator("InternetServ","ISBanner");
	private  static String Learn_Cloudlink=ReadFromExcel.getLocator("InternetServ","LearnCloud");

	CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);	
	public InternetServicesPage(WebDriver driver){
		this.driver=driver;
	} 

	public boolean charterSecuritySuitelink() {
		boolean retVal=false;
		wait(Until.elementToBeClickable(SecuritySuitelink));
		clickOnElement(SecuritySuitelink);
		//System.out.println(driver.getCurrentUrl());
		retVal = true;
		return retVal;		
	}
	public boolean CharterCloudDrivelink() {
		boolean retVal=false;
		if(isElementPresent(CloudDrive)){
			wait(Until.elementToBeClickable(Mange_CloudDrivelink));
			clickOnElement(Mange_CloudDrivelink);
			retVal = true;
		}
		return retVal;	
	}

	public void ClickLearnMorelink() {
		clickOnElement(Security_LearnMore);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String Title=driver.getTitle();
		if (Title.trim().equalsIgnoreCase(LearnMore_PAGE_TITLE))
			System.out.println("User navigated to LearnMore Page. ");
		driver.navigate().back();
	}

	public void ClickLearnMoreCloudDrivelink() {
		clickOnElement(cloud_LearnMore);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Text text=new Text(LearnMore_Cloud);
		String label=text.getMessage();
		System.out.println("************************************ "+label);
		if (label.contains(LearnMore_Cloud)){
			System.out.println("User navigated to Charter Cloud-LearnMore Page. ");
		}
		else{
			System.out.println("User didnot navigated to Charter Cloud-LearnMore Page. ");
			screenshot.saveScreenshot("T518300"+ File.separator + "NotCloudLearnMore_Page");
		}
		driver.navigate().back();
	}

	public boolean CharterEmail_link() {
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(Emailink));
		clickOnElement(Emailink);
		System.out.println(driver.getCurrentUrl());
		retVal = true;
		return retVal;
	}

	public boolean CharterEmail_Manage_link(){

		boolean retVal=false;
		wait(Until.elementToBeClickable(Emailink));
		clickOnElement(Emailink);
		System.out.println(driver.getCurrentUrl());
		retVal = true;
		return retVal;
	}
	public boolean ManageCharterEmail_link() {

		boolean retVal=false;
		clickOnElement(MangeEmaillink);
		retVal = true;
		return retVal;
	}

	public void ClickLearnCharterEmail_link() {
		clickOnElement(Email_LearnMore);
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		String TitleEmailPage=driver.getTitle();
		if (TitleEmailPage.trim().equalsIgnoreCase("Charter.net Charter Email - Desktop")){
			System.out.println("User navigated to Charter EmailLearn More Page. ");
		}
		else{
			System.out.println("User didnot navigated to Charter EmailLearn More Page. ");
			screenshot.saveScreenshot("T518298"+ File.separator + "NotEmail_Page");
		}
		driver.navigate().back();
	}

	public void istimeout_for_InternetServices(){

		WebDriverWait w=new WebDriverWait(driver,901);
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SessionTimeOut)));
		if(w.equals(true)){
			System.out.println("Time Out session verified successfully ");
		}
		else{
			System.out.println("Time Out session not verified. ");
		}
	}

	public boolean InternetLearnMorelink(){

		boolean retVal=false;
		wait(Until.elementToBeClickable(InternetLMlink));
		clickOnElement(InternetLMlink);
		retVal=true;
		return retVal;

	}

	public boolean wifi_CableModemLink(){
		boolean retVal = false;
		wait(Until.elementToBeClickable(InternetSupport));
		clickOnElement(InternetSupport);
		System.out.println("User Navigated to finding wifi name and password page"+ driver.getCurrentUrl());
		driver.get(URL+"/my-internet-services/");
		wait(Until.elementToBeClickable(CableModem));
		clickOnElement(CableModem);
		System.out.println("User Navigated to cable modem page"+ driver.getCurrentUrl());
		retVal = true;
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

	public boolean Manage_InternetServices(){
		HomePage hp=new HomePage(driver);
		hp.pagewait();
		boolean retVal=false;
		wait(Until.elementsToBePresent(Email_LearnMore));
		if(isElementEnabled(Email_LearnMore) && isElementEnabled(Security_LearnMore) && isElementEnabled(cloud_LearnMore)){
			clickOnElement(cloud_LearnMore);
			retVal=true;
		}
		return retVal;
	}

	public boolean InternetSupport(){

		boolean retVal=false;
		wait(Until.elementToBeClickable(InternetSupport));
		clickOnElement(InternetSupport);
		System.out.println(driver.getCurrentUrl());
		retVal = true;
		return retVal;
	}

	public boolean CableModem(){
		boolean retVal=false;
		wait(Until.elementToBeClickable(CableModem));
		clickOnElement(CableModem);
		retVal = true;
		return retVal;
	}

	public boolean SecuritySuiteLM(){

		boolean retVal=false;
		wait(Until.elementToBeClickable(Security_LearnMore));
		clickOnElement(Security_LearnMore);
		System.out.println(driver.getCurrentUrl());
		retVal = true;
		return retVal;
	}

	public boolean CharterEmail_LMlink(){

		boolean retVal=false;
		wait(Until.elementToBeClickable(Email_LearnMore));
		clickOnElement(Email_LearnMore);
		retVal = true;
		return retVal;
	}

	//***************** Ayesha ******************//
	public boolean InternerServicesHeaders(){
		boolean retVal=false;
		if(isElementPresent(InternetServicesHeader)&(isElementPresent(SupportLinksHeader)&(isElementPresent(ManageInternetServicesHeader)&(isElementPresent(InternetTipsHeader)
				&(isElementPresent(CharterSecuritySuiteHeader)&(isElementPresent(AskCharterWidget1)&(isElementPresent(FooterTV))
						&(isElementPresent(FooterMA))&(isElementPresent(FooterSupport))))))))
		{
			retVal=true;
		}
		return retVal;
	}

	public boolean ViewBannerAndSupportVideo()
	{
		boolean retVal=false;
		if(isElementPresent(ISBanner)){
			clickOnElement(ISBanner);
			System.out.println("User Navigated to Internet Charter wifi Page:"+ driver.getCurrentUrl());
			driver.navigate().to(URL);
			retVal=true;
		}
		return retVal;
	}

	public boolean CloudDriverLMLink(){

		boolean retVal=false;
		wait(Until.elementToBeClickable(Learn_Cloudlink));
		clickOnElement(Learn_Cloudlink);
		retVal=true;
		return retVal;
	}

}
