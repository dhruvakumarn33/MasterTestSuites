package com.charter.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cognizant.framework.ajax.Until;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.WebDriverBase;

public class OnDemandPage extends WebDriverBase{
	
	
	private String Networks=ReadFromExcel.getLocator("OnDemandPage", "Networks");

	public OnDemandPage(WebDriver driver){
		this.driver=driver;
	}
	
	public boolean openNetworksTab(){
		boolean retVal=false;
		wait(Until.elementToBeClickable(Networks));
		hoverOver(Networks);
		clickOnElement(Networks);
		System.out.println("User Navigated to Networks tab");
		retVal=true;
		return retVal;
	}
	
	public boolean checkNetworksColor(){
		boolean retVal=false;
		String color = driver.findElement(By.xpath("//h2[contains(text(),'Networks')]")).getCssValue("color");
		System.out.println(color);
		if (color.equals("rgba(255, 255, 255, 1)")){
		retVal=true;
		}
		return retVal;
	}
}
