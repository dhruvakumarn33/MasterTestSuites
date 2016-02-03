package com.charter.page;

import org.openqa.selenium.WebDriver;

import com.cognizant.framework.ajax.Until;
import com.cognizant.framework.core.CaptureScreenshot;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.WebDriverBase;

public class MyAccountSupportPage extends WebDriverBase {
	
	
	private static String SupportMyAccountTab=ReadFromExcel.getLocator("SupportMyAccountPage", "SupportMyAccountTab");
	private static String MyAccount=ReadFromExcel.getLocator("SupportMyAccountPage", "MyAccount");
	private static String Billing=ReadFromExcel.getLocator("SupportMyAccountPage", "Billing");
	private static String CharterUsername=ReadFromExcel.getLocator("SupportMyAccountPage", "CharterUsername");
	private static String MyAccountBilling=ReadFromExcel.getLocator("SupportMyAccountPage", "MyAccountBilling");
	
	private static String Article_Rating=ReadFromExcel.getLocator("SupportPage", "Article_Rating");
	
CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);	
	
	public MyAccountSupportPage(WebDriver driver){
		this.driver=driver;
	}
	
	public boolean SupportMyAccountTab(){
		boolean retVal=false;
		hoverOver(SupportMyAccountTab);
		clickOnElement(SupportMyAccountTab);
		System.out.println("User Navigated to My Account Support page:"+ driver.getCurrentUrl());
		retVal=true;
		return retVal;
	}
	
	public boolean MyAccount(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(MyAccount));
		clickOnElement(MyAccount);
		clickOnElement(CharterUsername);
		System.out.println("User Navigated to My Account Support page:"+ driver.getCurrentUrl());
		if(isElementPresent(Article_Rating)){
			retVal=true;
		}
		return retVal;
	}
	
	public boolean Billing(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(Billing));
		clickOnElement(Billing);
		clickOnElement(MyAccountBilling);
		System.out.println("User Navigated to My Account Support page:"+ driver.getCurrentUrl());
		if(isElementPresent(Article_Rating)){
			retVal=true;
		}
		return retVal;
	}

}
