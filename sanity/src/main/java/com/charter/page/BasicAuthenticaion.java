package com.charter.page;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cognizant.framework.ajax.Until;
import com.cognizant.framework.core.CaptureScreenshot;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.WebDriverBase;

public class BasicAuthenticaion extends WebDriverBase{


	private static String BasicLogin=ReadFromExcel.getLocator("HomePage", "BasicLogin");
	private static String BasicCreateID=ReadFromExcel.getLocator("HomePage", "BasicCreateID");
	private static String createIDHeader=ReadFromExcel.getLocator("HomePage", "createIDHeader");
	private static String BasicForgotUsername=ReadFromExcel.getLocator("HomePage", "BasicForgotUsername");
	private static String ForgotIDHeader=ReadFromExcel.getLocator("HomePage", "ForgotIDHeader");
	private static String BasicForgotPassword=ReadFromExcel.getLocator("HomePage", "BasicForgotPassword");
	private static String ForgotPWHeader=ReadFromExcel.getLocator("HomePage", "ForgotPWHeader");
	private static String BasicSignup=ReadFromExcel.getLocator("HomePage", "BasicSignup");
	private static String BusinessLink=ReadFromExcel.getLocator("HomePage", "BusinessLink");
	private static String charterBusinessHeader=ReadFromExcel.getLocator("HomePage", "charterBusinessHeader");
	private static String AccountNo=ReadFromExcel.getLocator("HomePage", "AccountNo");
	private static String SecCode=ReadFromExcel.getLocator("HomePage", "SecCode");
	private static String BusinessNextbtn=ReadFromExcel.getLocator("HomePage", "BusinessNextbtn");
	private static String BusinessSignin=ReadFromExcel.getLocator("HomePage", "BusinessSignin");
	private static String AccountCharterID=ReadFromExcel.getLocator("HomePage", "AccountCharterID");
	private static String AccountPassword=ReadFromExcel.getLocator("HomePage", "AccountPassword");
	private static String AccountSignin=ReadFromExcel.getLocator("HomePage", "AccountSignin");
	private static String BusinessBT=ReadFromExcel.getLocator("HomePage", "BusinessBT");
	private static String AccountLogout=ReadFromExcel.getLocator("HomePage", "AccountLogout");
	private static String Logout=ReadFromExcel.getLocator("HomePage", "Logout");
	
	CaptureScreenshot<WebDriver> screenshot;
	public BasicAuthenticaion(WebDriver driver) {
		this.driver=driver;	
		screenshot= new CaptureScreenshot<WebDriver>(driver);
	}
	public void Basic_CreateID(){

		wait(Until.elementToBeClickable(BasicLogin));
		clickOnElementUsingJavaScript(BasicLogin);
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
			if(!windowHandle.equals(parentWindow))
			{
				driver.switchTo().window(windowHandle);
				driver.manage().window().maximize();
				System.out.println(driver.getCurrentUrl());
				wait(Until.elementToBeClickable(BasicCreateID));
				clickOnElement(BasicCreateID);
				System.out.println(driver.getCurrentUrl());
				sleep(10);
				wait(Until.elementsToBeDisplayed(createIDHeader));
				System.out.println("Create ID page loaded");
				driver.close(); //closing child window
				driver.switchTo().window(parentWindow);//cntrl to parent window
			}
		}
	}

	public void Basic_ForgotCharterID(){
		wait(Until.elementToBeClickable(BasicLogin));
		clickOnElementUsingJavaScript(BasicLogin);

		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
			if(!windowHandle.equals(parentWindow))
			{
				driver.switchTo().window(windowHandle);
				driver.manage().window().maximize();
				System.out.println(driver.getCurrentUrl());
				wait(Until.elementToBeClickable(BasicForgotUsername));
				clickOnElement(BasicForgotUsername);
				sleep(10);
				System.out.println(driver.getCurrentUrl());
				wait(Until.elementsToBeDisplayed(ForgotIDHeader));
				System.out.println("Forgot Charter ID page loaded");
				driver.close(); //closing child window
				driver.switchTo().window(parentWindow);//cntrl to parent window
			}
		}

	}

	public void Basic_ForgotPassword(){
		wait(Until.elementToBeClickable(BasicLogin));
		clickOnElementUsingJavaScript(BasicLogin);

		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
			if(!windowHandle.equals(parentWindow))
			{
				driver.switchTo().window(windowHandle);
				driver.manage().window().maximize();
				System.out.println(driver.getCurrentUrl());
				wait(Until.elementToBeClickable(BasicForgotPassword));
				clickOnElement(BasicForgotPassword);
				sleep(10);
				System.out.println(driver.getCurrentUrl());
				wait(Until.elementsToBeDisplayed(ForgotPWHeader));
				System.out.println("Forgot Password Page loaded");
				driver.close(); //closing child window
				driver.switchTo().window(parentWindow);//cntrl to parent window
			}
		}
	}
	
	public void SignUp_button(){
		
		wait(Until.elementToBeClickable(BasicSignup));
		clickOnElementUsingJavaScript(BasicSignup);
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
			if(!windowHandle.equals(parentWindow))
			{
				driver.switchTo().window(windowHandle);
				driver.manage().window().maximize();
				System.out.println(driver.getCurrentUrl());
				wait(Until.elementsToBeDisplayed(createIDHeader));
				sleep(10);
				System.out.println("Sign up page loaded");
				driver.close(); //closing child window
				driver.switchTo().window(parentWindow);//cntrl to parent window
			}
		}
	}
	
	public void Login_button(){
		wait(Until.elementToBeClickable(BasicLogin));
		clickOnElementUsingJavaScript(BasicLogin);
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
			if(!windowHandle.equals(parentWindow))
			{
				driver.switchTo().window(windowHandle);
				driver.manage().window().maximize();
				System.out.println(driver.getCurrentUrl());
				wait(Until.elementsToBeDisplayed(BasicForgotUsername));
				sleep(10);
				System.out.println("Login page loaded");
				driver.close(); //closing child window
				driver.switchTo().window(parentWindow);//cntrl to parent window
			}
		}
		
	}
	
	public void Business_Customers_Link(String businessaccountNo,String SecurityCode,String BusinessCharterID,String UserPassword){
		
		wait(Until.elementToBeClickable(BasicLogin));
		clickOnElementUsingJavaScript(BasicLogin);
		
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
			if(!windowHandle.equals(parentWindow))
			{
				driver.switchTo().window(windowHandle);
				driver.manage().window().maximize();
				System.out.println(driver.getCurrentUrl());
				wait(Until.elementToBeClickable(BusinessLink));
				clickOnElement(BusinessLink);
				sleep(10);
				System.out.println(driver.getCurrentUrl());
				WebElement register = driver.findElement(By.xpath("/html/body/div[2]/main/div/div/div[1]/div/div/div[2]/div/a"));
				register.click();
				wait(Until.elementsToBeDisplayed(charterBusinessHeader));
				sleep(10);
				System.out.println("Spectrum business page loaded");
				type(AccountNo,businessaccountNo);
				type(SecCode,SecurityCode);
				clickOnElement(BusinessNextbtn);
				clickOnElement(BusinessSignin);
				type(AccountCharterID,BusinessCharterID);
				type(AccountPassword,UserPassword);
				clickOnElement(AccountSignin);
				wait(Until.elementsToBeDisplayed(BusinessBT));
				clickOnElement(AccountLogout);
				clickOnElement(Logout);
				driver.close(); //closing child window
				driver.switchTo().window(parentWindow);//cntrl to parent window
			}
		}
	}
}
