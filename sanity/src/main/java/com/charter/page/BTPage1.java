package com.charter.page;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.cognizant.framework.ajax.Until;
import com.cognizant.framework.core.CaptureScreenshot;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.WebDriverBase;
import com.sun.jna.platform.win32.WinUser.HOOKPROC;
import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

public class BTPage1 extends WebDriverBase {

	private String URL= ReadFromExcel.getData("HomePage","Prod_Url");

	private static String OneTimeDebitPayment_Option=ReadFromExcel.getLocator("BTPage", "OneTimeDebitOption");
	private static String OneTimeCreditPayment_Option=ReadFromExcel.getLocator("BTPage", "OneTimeCreditOption");

	private static String MakePayment_Button=ReadFromExcel.getLocator("BTPage", "MakePayment");
	private static String InputManualAmount=ReadFromExcel.getLocator("BTPage", "InputManualAmount");
	private static String CardType=ReadFromExcel.getLocator("BTPage", "CardType");
	private static String CardNumber=ReadFromExcel.getLocator("BTPage", "CardNumber");
	private static String ExpirationMonth=ReadFromExcel.getLocator("BTPage", "ExpirationMonth");
	private static String ExpirationYear=ReadFromExcel.getLocator("BTPage", "ExpirationYear");
	private static String PaymentAmount=ReadFromExcel.getLocator("BTPage", "PaymentAmount");
	private static String ReviewPayment=ReadFromExcel.getLocator("BTPage", "ReviewPayment");
	private static String weVerifyPaymentConfirmation=ReadFromExcel.getLocator("BTPage", "weVerifyPaymentConfirmation");
	private static String PaymentDate1=ReadFromExcel.getLocator("BTPage","PaymentDate1");
	private static String EditPayment=ReadFromExcel.getLocator("BTPage","EditPayment");
	private static String CancelPayment=ReadFromExcel.getLocator("BTPage","CancelPayment");
	private static String Cancel_btn=ReadFromExcel.getLocator("BTPage", "Cancelbtn");
	private static String BtnOK=ReadFromExcel.getLocator("BTPage", "BtnOK");
	private static String UpcomingPayments=ReadFromExcel.getLocator("BTPage","UpcomingPayments");
	private static String SSSection=ReadFromExcel.getLocator("BTPage", "SSSection");
	private static String SSHelpicon=ReadFromExcel.getLocator("BTPage", "SSHelpicon");
	private static String SSdropdown=ReadFromExcel.getLocator("BTPage", "SSdropdown");
	private static String Viewbtn=ReadFromExcel.getLocator("BTPage", "Viewbtn");
	private static String ContactInfoSection=ReadFromExcel.getLocator("BTPage", "ContactInfoSection");
	private static String Billing=ReadFromExcel.getLocator("MAPage", "Billing");

	private static String ChangeName=ReadFromExcel.getLocator("BTPage", "ChangeName");

	private static String SAlabel=ReadFromExcel.getLocator("BTPage", "SAlabel");
	private static String BAlabel=ReadFromExcel.getLocator("BTPage", "BAlabel");
	private static String IDlabel=ReadFromExcel.getLocator("BTPage", "IDlabel");

	private static String TAOPage=ReadFromExcel.getLocator("BTPage", "TAOPage");
	private static String TMSLink=ReadFromExcel.getLocator("BTPage", "TMSLink");
	private static String CMRPage=ReadFromExcel.getLocator("BTPage", "CMRPage");
	private static String Phhelp=ReadFromExcel.getLocator("BTPage","Phhelp");

	private static String RTHelp=ReadFromExcel.getLocator("BTPage","RTHelp");
	private static String CancelOTPlink=ReadFromExcel.getLocator("BTPage","CancelOTPlink");

	CaptureScreenshot<WebDriver> screenshot;
	WebDriver popupDriver = null;

	public BTPage1(WebDriver driver) {
		this.driver=driver;
		screenshot= new CaptureScreenshot<WebDriver>(driver);
	}

	public void EnterCardDetails(String cardtype,String cardNumber,String expMonth,String expYear){

		selectValueFromDropDown(CardType, cardtype);
		type(CardNumber, cardNumber);
		selectValueFromDropDown(ExpirationMonth, expMonth);
		selectValueFromDropDown(ExpirationYear, expYear);

	}

	public void EditpaymentCarddetails(String cardtype,String cardNumber, String expMonth,String expYear){

		clickOnElement(EditPayment);
		selectValueFromDropDown(CardType, cardtype);
		clearTextBox(CardNumber);
		type(CardNumber, cardNumber);
		selectValueFromDropDown(ExpirationMonth, expMonth);
		selectValueFromDropDown(ExpirationYear, expYear);
		clickOnElement(ReviewPayment);
	}
	//Pre-requisite - Set future date appropriately in the test data
	public void FutureCC(String cardtype,String cardNumber,String expMonth,String expYear,String amount,String FutureDate) 
	{
		clickOnElement(OneTimeCreditPayment_Option);			
		clickOnElement(MakePayment_Button);	
		switchToFrame("id;pciIframe");
		clickOnElementUsingJavaScript(PaymentAmount);
		clearTextBox(PaymentAmount);
		type(PaymentAmount, amount);
		clickOnElement(PaymentDate1);
		String strtext=FutureDate;
		String str="//td[@aria-disabled='false']/button[1]/span[text()='"+strtext+"']";
		WebElement wlmelm=driver.findElement(By.xpath(str));
		wlmelm.click();
		WebElement Cclose=driver.findElement(By.xpath("//a[contains(@class,'ccicon ccicon-close-thin icon-bordered pull-right')]"));
		if(Cclose.isDisplayed()){ 
			Cclose.click(); 
		}
		EnterCardDetails(cardtype,cardNumber,expMonth,expYear);
		clickOnElement(ReviewPayment);
			
	}

	//Pre-requisite - Set future date appropriately in the test data
	public void FutureDC(String cardtype,String cardNumber,String expMonth,String expYear,String amount,String FutureDate) {
		
		clickOnElement(OneTimeDebitPayment_Option);
		clickOnElement(MakePayment_Button);
		switchToFrame("id;pciIframe");
		clickOnElementUsingJavaScript(PaymentAmount);
		clearTextBox(PaymentAmount);
		type(PaymentAmount, amount);
		clickOnElement(PaymentDate1);
		String strtext=FutureDate;
		String str="//td[@aria-disabled='false']/button[1]/span[text()='"+strtext+"']";
		WebElement wlmelm=driver.findElement(By.xpath(str));
		wlmelm.click();
		WebElement Cclose=driver.findElement(By.xpath("//a[contains(@class,'ccicon ccicon-close-thin icon-bordered pull-right')]"));
		if(Cclose.isDisplayed()){ 
			Cclose.click(); 
		}
		EnterCardDetails(cardtype,cardNumber,expMonth,expYear);
		clickOnElement(ReviewPayment);
		
	}

	public boolean CancelUpcomingPayments()
	{
		boolean retVal=false;
		clickOnElement(Billing);
		clickOnElement(UpcomingPayments);
		wait(Until.elementToBeDisplayed(CancelPayment));
		clickOnElement(CancelPayment);
		wait(Until.elementToBeDisplayed(Cancel_btn));
		clickOnElement(Cancel_btn);
		sleep(5);
		//if(isElementPresent(BtnOK)){
			//clickOnElement(BtnOK);
		//}
		retVal=true;
		return retVal;
	}	

	public boolean SSSection(){

		boolean retVal=false;
		if(isElementPresent(SSSection)){
			retVal=true;
		}
		return retVal;
	}


	public boolean SSHelpicon(){

		boolean retVal=true;
		//hoverOver(SSHelpicon);
		if(isElementEnabled(SSHelpicon)){
			System.out.println(getText(SSHelpicon));
			retVal=true;
		}
		return retVal;
	}


	public boolean SSSpecificDate(String SelectDate){
		boolean retVal=false;
		selectValueFromDropDown(SSdropdown,SelectDate);
		clickOnElement(Viewbtn);
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

	public boolean ContactInfo(){

		boolean retVal=false;
		if(isElementPresent(ContactInfoSection) &(isElementPresent(SAlabel))&(isElementPresent(BAlabel))&(isElementPresent(IDlabel))){
			retVal=true;
		}
		return retVal;
	}

	public boolean ChangeNameLink(){

		boolean retVal=false;
		wait(Until.elementToBeClickable(ChangeName));
		clickOnElement(ChangeName);
		retVal=true;
		return retVal;
	}

	public boolean TMSLink(){

		boolean retVal=false;
		wait(Until.elementToBeClickable(TMSLink));
		clickOnElement(TMSLink);
		retVal=true;
		return retVal;
	}

	public boolean PHHelpicon(){

		boolean retVal=false;
		//hoverOver(Phhelp);
		if(isElementPresent(Phhelp)){
			System.out.println(getText(Phhelp));
			retVal=true;
		}
		return retVal;
	}

	public boolean RTHelpicon(){

		boolean retVal=false;
		//	hoverOver(RTHelp);
		if(isElementPresent(RTHelp)){
			System.out.println(getText(RTHelp));
			retVal=true;
		}
		return retVal;
	}
}
