package com.charter.page;

import java.io.File;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.cognizant.framework.ajax.Until;
import com.cognizant.framework.core.CaptureScreenshot;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.WebDriverBase;

public class BillDeliveryPage  extends WebDriverBase {

	private static String BillingAndTransactionSection=ReadFromExcel.getLocator("MAPage", "BillingandTransactions");
	private static String BillDeliveryOptions=ReadFromExcel.getLocator("MAPage", "BillDeliveryOptions");
	private static String weAskCharter=ReadFromExcel.getLocator("BillDeliveryPage", "weAskCharter");
	private static String weask=ReadFromExcel.getLocator("BillDeliveryPage", "weask");
	private static String btnask=ReadFromExcel.getLocator("BillDeliveryPage", "btnask");
	private static String inputbox=ReadFromExcel.getLocator("BillDeliveryPage", "inputbox");
	private static String btnask2=ReadFromExcel.getLocator("BillDeliveryPage", "btnask2");
	WebDriver popupDriver = null;
	
    CaptureScreenshot<WebDriver> screenshot; 
	
	public BillDeliveryPage(WebDriver driver) {
		this.driver=driver;
		screenshot= new CaptureScreenshot<WebDriver>(driver);
	}
	
	public void hoveronBT(){
		hoverOver(BillingAndTransactionSection);
	}
	
	public void linkBillDeliveryOptions(){
		clickOnElement(BillDeliveryOptions);
	}
	
	public void Askcharter(String searchkey){
		
		wait(Until.elementToBeDisplayed(weAskCharter));
		clickOnElement(weAskCharter);
		type(weask,searchkey);
		screenshot.saveScreenshot("AskCharter Widget"+ File.separator + "searchbox");
		String parent=driver.getWindowHandle();
		clickOnElement(btnask);
		
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> windowIterator = windowHandles.iterator();
		while(windowIterator.hasNext()) { 
			String windowHandle = windowIterator.next(); 
			sleep(3);
			popupDriver = driver.switchTo().window(windowHandle);
			System.out.println(popupDriver.getTitle()+"popupDriver");
			
			if (popupDriver.getTitle().equals("Ask Charter"))
			{
				
				System.out.println("User in new window");
				screenshot.saveScreenshot("AskCharter Widget"+ File.separator + "New window-AskCharter");
				sleep(3);
				clearTextBox(inputbox);
				type(inputbox,searchkey);
				screenshot.saveScreenshot("AskCharter Widget"+ File.separator + "searchbox-New Window");
				clickOnElement(btnask2);
				popupDriver.close();
				driver = driver.switchTo().window(parent);	
				screenshot.saveScreenshot("AskCharter Widget"+ File.separator + "Parent window after search");

			}
			else{
				System.out.println(driver.getTitle()+"ELSE");
			}
		
	}
	}
}
