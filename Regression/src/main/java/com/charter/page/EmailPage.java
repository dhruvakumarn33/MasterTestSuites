package com.charter.page;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.charter.utils.Constants;
import com.cognizant.framework.ajax.Until;
import com.cognizant.framework.core.EnvParameters;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.WebDriverBase;
import com.cognizant.framework.core.CaptureScreenshot;

public class EmailPage extends WebDriverBase{
	CaptureScreenshot<WebDriver> screenshot = new CaptureScreenshot<WebDriver>(driver);
	private String URL= Constants.URL;
	
	private static String EmailLink = ReadFromExcel.getLocator("EmailPage","EmailLink");
	private static String Composebtn = ReadFromExcel.getLocator("EmailPage","Composebtn");
	private static String TOEnvelope = ReadFromExcel.getLocator("EmailPage","TOEnvelope");
	private static String CCbtn = ReadFromExcel.getLocator("EmailPage","CCbtn");
	private static String BCCbtn = ReadFromExcel.getLocator("EmailPage","BCCbtn");
	private static String CCField = ReadFromExcel.getLocator("EmailPage","CCField");
	private static String BCCField = ReadFromExcel.getLocator("EmailPage","BCCField");
	private static String SubjectField = ReadFromExcel.getLocator("EmailPage","SubjectField");
	private static String EmailBody = ReadFromExcel.getLocator("EmailPage","EmailBody");
	private static String SendMail = ReadFromExcel.getLocator("EmailPage","SendMail");
	private static String SentMsg = ReadFromExcel.getLocator("EmailPage","SentMsg");
	
	private static String mailSignOut=ReadFromExcel.getLocator("EmailPage", "mailSignOut");
	
	private static String toggleFormat=ReadFromExcel.getLocator("EmailPage", "toggleFormat");
	private static String Fonts=ReadFromExcel.getLocator("EmailPage", "Fonts");
	private static String DeleteCompose=ReadFromExcel.getLocator("EmailPage", "DeleteCompose");
	private static String Deletebtn=ReadFromExcel.getLocator("EmailPage", "Deletebtn");
	private static String GetMailbtn=ReadFromExcel.getLocator("EmailPage", "GetMailbtn");
	private static String AjaxLoader=ReadFromExcel.getLocator("EmailPage", "AjaxLoader");
	private static String mailHelpbtn=ReadFromExcel.getLocator("EmailPage", "mailHelpbtn");
	private static String emailAccDropdown=ReadFromExcel.getLocator("EmailPage", "emailAccDropdown");
	private static String search=ReadFromExcel.getLocator("EmailPage", "search");
	
	private static String draftFolder=ReadFromExcel.getLocator("EmailPage", "draftFolder");
	private static String sentFolder=ReadFromExcel.getLocator("EmailPage", "sentFolder");
	private static String spamFolder=ReadFromExcel.getLocator("EmailPage", "spamFolder");
	private static String trashFolder=ReadFromExcel.getLocator("EmailPage", "trashFolder");
	
	private static String editSentFolder=ReadFromExcel.getLocator("EmailPage", "editSentFolder");
	private static String editFolderbtn=ReadFromExcel.getLocator("EmailPage", "editFolderbtn");
	
	private static String customFolderName=ReadFromExcel.getLocator("EmailPage", "customFolderName");
	private static String createFolderbtn=ReadFromExcel.getLocator("EmailPage", "createFolderbtn");
	private static String newFolderName=ReadFromExcel.getLocator("EmailPage", "newFolderName");
	private static String createbtn=ReadFromExcel.getLocator("EmailPage", "createbtn");
	private static String folderCreateMsg=ReadFromExcel.getLocator("EmailPage", "folderCreateMsg");
	
	private static String contactsTab=ReadFromExcel.getLocator("EmailPage", "contactsTab");
	
	private static String addGroupbtn=ReadFromExcel.getLocator("EmailPage", "addGroupbtn");
	private static String groupName=ReadFromExcel.getLocator("EmailPage", "groupName");
	private static String createGroupbtn=ReadFromExcel.getLocator("EmailPage", "createGroupbtn");
	private static String createGroupMsg=ReadFromExcel.getLocator("EmailPage", "createGroupMsg");
	private static String groupMenu=ReadFromExcel.getLocator("EmailPage", "groupMenu");
	private static String deleteGroup=ReadFromExcel.getLocator("EmailPage", "deleteGroup");
	private static String deleteGroupYes=ReadFromExcel.getLocator("EmailPage", "deleteGroupYes");
	private static String deleteGroupMsg=ReadFromExcel.getLocator("EmailPage", "deleteGroupMsg");
	
	private static String addContactbtn=ReadFromExcel.getLocator("EmailPage", "addContactbtn");
	private static String firstName=ReadFromExcel.getLocator("EmailPage", "firstName");
	private static String lastName=ReadFromExcel.getLocator("EmailPage", "lastName");
	private static String email=ReadFromExcel.getLocator("EmailPage", "email");
	private static String mobile=ReadFromExcel.getLocator("EmailPage", "mobile");
	private static String saveContact=ReadFromExcel.getLocator("EmailPage", "saveContact");
	private static String deleteContact=ReadFromExcel.getLocator("EmailPage", "deleteContact");
	private static String selectContact=ReadFromExcel.getLocator("EmailPage", "selectContact");
	private static String contactDeleteMsg=ReadFromExcel.getLocator("EmailPage", "contactDeleteMsg");
	
	private static String settingsTab=ReadFromExcel.getLocator("EmailPage", "settingsTab");
	private static String settingAccbtn=ReadFromExcel.getLocator("EmailPage", "settingAccbtn");
	private static String addNewAccount=ReadFromExcel.getLocator("EmailPage", "addNewAccount");
	private static String newAccEmail=ReadFromExcel.getLocator("EmailPage", "newAccEmail");
	private static String newAccPwd=ReadFromExcel.getLocator("EmailPage", "newAccPwd");
	private static String newAccNext=ReadFromExcel.getLocator("EmailPage", "newAccNext");
	private static String newAccNickName=ReadFromExcel.getLocator("EmailPage", "newAccNickName");
	private static String newAccRealName=ReadFromExcel.getLocator("EmailPage", "newAccRealName");
	private static String addAccMsg=ReadFromExcel.getLocator("EmailPage", "addAccMsg");
	private static String newAccDelete=ReadFromExcel.getLocator("EmailPage", "newAccDelete");
	private static String newAccDone=ReadFromExcel.getLocator("EmailPage", "newAccDone");
	private static String accDeleteMsg=ReadFromExcel.getLocator("EmailPage", "accDeleteMsg");
	private static String myAccount=ReadFromExcel.getLocator("EmailPage", "myAccount");
	
	private static String Article_Rating=ReadFromExcel.getLocator("SupportPage", "Article_Rating");
	
	
	public EmailPage(WebDriver driver){
		this.driver=driver;
	}
	
	public void OpenMyAccount(){
		clickOnElement(myAccount);
		System.out.println("User navigated to My Account Page : "+driver.getCurrentUrl());
	}
	
	public void OpenCharterMail(){
		clickOnElement(EmailLink);
		wait(Until.elementToBeDisplayed(Composebtn));
	}
	
	public boolean ComposeMail(String toAddr, String cc, String bcc){
		boolean retVal = false;		
		fillRecipient(toAddr,cc,bcc);
		addSubject();
		type(EmailBody,"Testing Email Functionality");
		clickOnElement(SendMail);
		if(isElementVisible(SentMsg))
			retVal=true;
		return retVal;
	}
	
	public void addSubject(){
		type(SubjectField,"Testing Email Functionality");
	}
	
	public void fillRecipient(String toAddr, String cc, String bcc){
		clickOnElement(Composebtn);
		type(TOEnvelope, toAddr);
		clickOnElement(CCbtn);
		type(CCField,cc);
		clickOnElement(BCCbtn);
		type(BCCField,bcc);
	}
	
	public void changeFontStyle(String toAddr, String cc, String bcc){	
		type(EmailBody,"Testing Email Functionality"+Keys.RETURN);
		clickOnElement(toggleFormat);
		for(int i=1;i<10;i++){
			clickOnElement(Fonts);
			driver.findElement(By.xpath("//div[@access-tabindex='compose-panel-1-formatbar-"+i+"']")).click();
			type(EmailBody,"Testing Email Functionality"+Keys.RETURN);
		}
		//System.out.println(driver.findElement(By.className("envelope-email-body-edit")).getText());
	}
	
	public void mailLogout() throws Exception{
		wait(Until.elementToBeClickable(mailSignOut));
		clickOnElement(mailSignOut);
		HomePage hp = new HomePage(driver);
		hp.loadCharterPage(URL);
	}
	
	public void deleteCompose(){
		type(EmailBody,"Testing Email Functionality"+Keys.RETURN);
		clickOnElement(DeleteCompose);
		clickOnElement(Deletebtn);
	}
	
	public boolean getMail(){
		boolean retVal=false;
		clickOnElement(GetMailbtn);
		if(isElementVisible(AjaxLoader))
			retVal=true;
		return retVal;
	}
	
	public boolean mailHelp(){
		boolean retVal=false;
		
		String parentWindow = driver.getWindowHandle();
		clickOnElement(mailHelpbtn);
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
			if(!windowHandle.equals(parentWindow))
			{
				driver.switchTo().window(windowHandle);
				sleep(5);
				System.out.println("Navigated to Email Quick Reference Guide: "+driver.getCurrentUrl());
				if(isElementPresent(Article_Rating))
					retVal=true;
				driver.close(); //closing child window
				driver.switchTo().window(parentWindow);//cntrl to parent window
				sleep(3);
			}
		}
		return retVal;
	}
	
	public boolean viewAllAccounts(String mail){
		boolean retVal = false;
		clickOnElement(emailAccDropdown);
		System.out.println("Accounts logged in currently : ");
		System.out.println(driver.findElement(By.id("ui-id-1")).getText());
		System.out.println(driver.findElement(By.id("ui-id-2")).getText());
		if(driver.findElement(By.id("ui-id-1")).getText().equalsIgnoreCase(mail))
			retVal=true;
		return retVal;
	}
	
	public void searchMail(){
		type(search, "Charter"+Keys.RETURN);
		List<WebElement> web = driver.findElements(By.className("email-from"));
		System.out.println("Search results: ");
		for(WebElement element:web){
			System.out.println(element.getText());
		}
	}
	
	public void accessFolders(){
		clickOnElement(draftFolder);
		sleep(2);
		clickOnElement(sentFolder);
		sleep(2);
		clickOnElement(spamFolder);
		sleep(2);
		clickOnElement(trashFolder);
		sleep(2);
	}
	
	public void buttonBar() {
		sleep(5);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(isElementVisible("xpath;(//*[@id='email-button-buttons'])[1]")){
			if(isElementVisible("xpath;(//*[@id='search-email'])[1]"))
				System.out.println("Search email bar visible");
			if(isElementVisible("xpath;(//*[@id='compose-mail-button'])[1]"))
				System.out.println("Compose mail button visible");
			if(isElementVisible("xpath;(//*[@id='get-mail-button'])[1]"))
				System.out.println("Get mail button visible");
			if(isElementVisible("xpath;(//*[@id='help-mail-button'])[1]"))
				System.out.println("Help button visible");
		}
			
	}
	
	public void applicationBar() {
		sleep(5);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(isElementVisible("xpath;//*[@id='application-tabs']") & isElementVisible("xpath;//*[@id='tab-email']")
				& isElementVisible("xpath;//*[@id='tab-contacts']") & isElementVisible("xpath;//*[@id='tab-settings']")){
				System.out.println("All Tabs are Visible");
		}

	}
	
	public void verifyInbox() throws IOException{
		DateFormat dateFormat = new SimpleDateFormat("ddMMMyy_hhmmss");
		clickOnElement("xpath;//*[@title='Inbox']");
		sleep(5);
		applicationBar();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(isElementVisible("xpath;//thead[@id='email-list-header']"))
			System.out.println("Email List Header visible");
		if(isElementVisible("xpath;//*[@id='unread-inbox']"))
			System.out.println("Unread Inbox mail Counts visible");
		setCheckBox("xpath;(//*[@class='email-selection-checkbox'])[2]", true);

		if(isElementVisible("xpath;(//*[@id='email-button-buttons'])[1]") & isElementVisible("xpath;(//*[@id='search-email'])[1]")
				& isElementVisible("xpath;(//*[@id='compose-mail-button'])[1]") & isElementVisible("xpath;(//*[@id='get-mail-button'])[1]")
				& isElementVisible("xpath;(//*[@id='help-mail-button'])[1]") & isElementVisible("xpath;(//*[@id='reply-mail-button'])[1]")
				& isElementVisible("xpath;(//*[@id='reply-all-mail-button'])[1]") & isElementVisible("xpath;(//*[@id='forward-mail-button'])[1]")
				& isElementVisible("xpath;(//*[@id='mark-mail-dropdown-button'])[1]") & isElementVisible("xpath;(//*[@id='move-mail-button'])[1]")
				& isElementVisible("xpath;(//*[@id='delete-mail-button'])[1]") & isElementVisible("xpath;(//*[@id='print-mail-button'])[1]")){
			System.out.println("All the buttons are visible");
		}
		
		else{
			screenshot.saveScreenshot("Email"+ File.separator + "InboxFolderError");
			Date date = new Date();
			String date1= dateFormat.format(date);
			String name = "InboxFolderError-"+date1;
			System.out.println("Current date and time is " +date1);
			Runtime.getRuntime().exec("wscript D:\\Regression\\SendMail\\EmailError.vbs "+name);
		}
	}
	
	public void verifyDrafts() throws IOException{
		DateFormat dateFormat = new SimpleDateFormat("ddMMMyy_hhmmss");
		clickOnElement("xpath;//*[@title='Drafts']");
		sleep(5);
		applicationBar();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(isElementVisible("xpath;//thead[@id='email-list-header']"))
			System.out.println("Email List Header visible");
		if(isElementVisible("xpath;//*[@id='unread-drafts']"))
			System.out.println("Unread Drafts mail Counts visible");
		setCheckBox("xpath;(//*[@class='email-selection-checkbox'])[2]", true);

		if(isElementVisible("xpath;(//*[@id='email-button-buttons'])[1]") & isElementVisible("xpath;(//*[@id='search-email'])[1]")
				& isElementVisible("xpath;(//*[@id='compose-mail-button'])[1]") & isElementVisible("xpath;(//*[@id='get-mail-button'])[1]")
				& isElementVisible("xpath;(//*[@id='help-mail-button'])[1]") & isElementVisible("xpath;(//*[@id='reply-mail-button'])[1]")
				& isElementVisible("xpath;(//*[@id='reply-all-mail-button'])[1]") & isElementVisible("xpath;(//*[@id='forward-mail-button'])[1]")
				& isElementVisible("xpath;(//*[@id='mark-mail-dropdown-button'])[1]") & isElementVisible("xpath;(//*[@id='move-mail-button'])[1]")
				& isElementVisible("xpath;(//*[@id='delete-mail-button'])[1]") & isElementVisible("xpath;(//*[@id='print-mail-button'])[1]")){
			System.out.println("All the buttons are visible");
		}
		
		else{
			screenshot.saveScreenshot("Email"+ File.separator + "DraftsFolderError");
			Date date = new Date();
			String date1= dateFormat.format(date);
			String name = "DraftsFolderError-"+date1;
			System.out.println("Current date and time is " +date1);
			Runtime.getRuntime().exec("wscript D:\\Regression\\SendMail\\EmailError.vbs "+name);
		}
	}
	
	public void verifySentMail() throws IOException{
		DateFormat dateFormat = new SimpleDateFormat("ddMMMyy_hhmmss");
		clickOnElement("xpath;//*[@title='Sent Mail']");
		sleep(5);
		applicationBar();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(isElementVisible("xpath;//thead[@id='email-list-header']"))
			System.out.println("Email List Header visible");
		setCheckBox("xpath;(//*[@class='email-selection-checkbox'])[2]", true);

		if(isElementVisible("xpath;(//*[@id='email-button-buttons'])[1]") & isElementVisible("xpath;(//*[@id='search-email'])[1]")
				& isElementVisible("xpath;(//*[@id='compose-mail-button'])[1]") & isElementVisible("xpath;(//*[@id='get-mail-button'])[1]")
				& isElementVisible("xpath;(//*[@id='help-mail-button'])[1]") & isElementVisible("xpath;(//*[@id='reply-mail-button'])[1]")
				& isElementVisible("xpath;(//*[@id='reply-all-mail-button'])[1]") & isElementVisible("xpath;(//*[@id='forward-mail-button'])[1]")
				& isElementVisible("xpath;(//*[@id='mark-mail-dropdown-button'])[1]") & isElementVisible("xpath;(//*[@id='move-mail-button'])[1]")
				& isElementVisible("xpath;(//*[@id='delete-mail-button'])[1]") & isElementVisible("xpath;(//*[@id='print-mail-button'])[1]")){
			System.out.println("All the buttons are visible");
		}
		
		else{
			screenshot.saveScreenshot("Email"+ File.separator + "SentFolderError");
			Date date = new Date();
			String date1= dateFormat.format(date);
			String name = "SentFolderError-"+date1;
			System.out.println("Current date and time is " +date1);
			Runtime.getRuntime().exec("wscript D:\\Regression\\SendMail\\EmailError.vbs "+name);
		}
	}
	
	public void verifySpam() throws IOException{
		DateFormat dateFormat = new SimpleDateFormat("ddMMMyy_hhmmss");
		clickOnElement("xpath;//*[@title='Spam']");
		sleep(5);
		applicationBar();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(isElementVisible("xpath;//thead[@id='email-list-header']"))
			System.out.println("Email List Header visible");
		if(isElementVisible("xpath;//*[@id='unread-spam']"))
			System.out.println("Unread Spam mail Counts visible");
		setCheckBox("xpath;(//*[@class='email-selection-checkbox'])[2]", true);

		if(isElementVisible("xpath;(//*[@id='email-button-buttons'])[1]") & isElementVisible("xpath;(//*[@id='search-email'])[1]")
				& isElementVisible("xpath;(//*[@id='compose-mail-button'])[1]") & isElementVisible("xpath;(//*[@id='get-mail-button'])[1]")
				& isElementVisible("xpath;(//*[@id='help-mail-button'])[1]") & isElementVisible("xpath;(//*[@id='reply-mail-button'])[1]")
				& isElementVisible("xpath;(//*[@id='reply-all-mail-button'])[1]") & isElementVisible("xpath;(//*[@id='forward-mail-button'])[1]")
				& isElementVisible("xpath;(//*[@id='mark-mail-dropdown-button'])[1]") & isElementVisible("xpath;(//*[@id='move-mail-button'])[1]")
				& isElementVisible("xpath;(//*[@id='delete-mail-button'])[1]") & isElementVisible("xpath;(//*[@id='print-mail-button'])[1]")){
			System.out.println("All the buttons are visible");
		}
		
		else{
			screenshot.saveScreenshot("Email"+ File.separator + "SpamFolderError");
			Date date = new Date();
			String date1= dateFormat.format(date);
			String name = "SpamFolderError-"+date1;
			System.out.println("Current date and time is " +date1);
			Runtime.getRuntime().exec("wscript D:\\Regression\\SendMail\\EmailError.vbs "+name);
		}
	}
	
	public void verifyTrash() throws IOException{
		DateFormat dateFormat = new SimpleDateFormat("ddMMMyy_hhmmss");
		clickOnElement("xpath;//*[@class='ci icon-trash_fill_email']");
		sleep(5);
		applicationBar();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(isElementVisible("xpath;//thead[@id='email-list-header']"))
			System.out.println("Email List Header visible");
		if(isElementVisible("xpath;//*[@id='unread-trash']"))
			System.out.println("Unread Trash mail Counts visible");
		setCheckBox("xpath;(//*[@class='email-selection-checkbox'])[2]", true);

		if(isElementVisible("xpath;(//*[@id='email-button-buttons'])[1]") & isElementVisible("xpath;(//*[@id='search-email'])[1]")
				& isElementVisible("xpath;(//*[@id='compose-mail-button'])[1]") & isElementVisible("xpath;(//*[@id='get-mail-button'])[1]")
				& isElementVisible("xpath;(//*[@id='help-mail-button'])[1]") & isElementVisible("xpath;(//*[@id='reply-mail-button'])[1]")
				& isElementVisible("xpath;(//*[@id='reply-all-mail-button'])[1]") & isElementVisible("xpath;(//*[@id='forward-mail-button'])[1]")
				& isElementVisible("xpath;(//*[@id='mark-mail-dropdown-button'])[1]") & isElementVisible("xpath;(//*[@id='move-mail-button'])[1]")
				& isElementVisible("xpath;(//*[@id='delete-mail-button'])[1]") & isElementVisible("xpath;(//*[@id='print-mail-button'])[1]")){
			System.out.println("All the buttons are visible");
		}
		
		else{
			screenshot.saveScreenshot("Email"+ File.separator + "TrashFolderError");
			Date date = new Date();
			String date1= dateFormat.format(date);
			String name = "TrashFolderError-"+date1;
			System.out.println("Current date and time is " +date1);
			Runtime.getRuntime().exec("wscript D:\\Regression\\SendMail\\EmailError.vbs "+name);
		}
	}
	
	public void editSentFolder(){
		clickOnElement(editSentFolder);
		clickOnElement(editFolderbtn);
		clearTextBox(customFolderName);
		type(customFolderName, "Edited sent"+Keys.RETURN);
		sleep(5);
		clickOnElement(editSentFolder);
		clickOnElement(editFolderbtn);
		clearTextBox(customFolderName);
		type(customFolderName, "Sent"+Keys.RETURN);
		sleep(5);
	}
	
	public boolean createNewFolder(){
		boolean retVal=false;
		clickOnElement(createFolderbtn);
		type(newFolderName, "test");
		clickOnElement(createbtn);
		if(isElementVisible(folderCreateMsg))
			retVal=true;
		return retVal;
	}
	
	public boolean deleteFolder(){
		boolean retVal=false;
		driver.findElement(By.xpath("//div[@data-folder-path='test']/div[@class='custom-folder-options-button']")).click();
		driver.findElement(By.xpath("//div[@data-folder-path='test']/*//div[@class='delete-custom-folder-icon']")).click();
		sleep(5);
		String[] filepath=new String[] { System.getProperty("user.dir") + File.separator + "AutoIT" + File.separator +"deleteFolder.exe",EnvParameters.WEB_BROWSER_TYPE.replaceAll("\\*", "")};
		System.out.println("print :" +EnvParameters.WEB_BROWSER_TYPE);

		try {
			Runtime.getRuntime().exec(filepath);
			retVal=true;
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("Unable to close");
		}
		return retVal;
	}
	
	public boolean createGroup(){
		boolean retVal=false;
		clickOnElement(contactsTab);
		clickOnElement(addGroupbtn);
		type(groupName, "test");
		clickOnElement(createGroupbtn);
		if(isElementVisible(createGroupMsg))
			retVal=true;
		return retVal;
	}
	
	public boolean deleteGroup(){
		boolean retVal=false;
		clickOnElement(groupMenu);
		clickOnElement(deleteGroup);
		clickOnElement(deleteGroupYes);
		if(isElementVisible(deleteGroupMsg))
			retVal=true;
		return retVal;
	}
	
	public void createContact(){
		clickOnElement(contactsTab);
		clickOnElement(addContactbtn);
		type(firstName, "Test");
		type(lastName,"1");
		type(email, "Test1@gmail.com");
		type(mobile, "9876543210");
		clickOnElement(saveContact);
	}
	
	public boolean deleteContact(){
		boolean retVal=false;
		setCheckBox(selectContact, true);
		clickOnElement(deleteContact);
		driver.findElement(By.xpath("//span[contains(text(),'Yes')]")).click();
		if(isElementVisible(contactDeleteMsg))
			retVal=true;
		return retVal;
	}
	
	public void addNewAccount(){
		clickOnElement(settingsTab);
		clickOnElement(settingAccbtn);
		sleep(6);
		//clickOnElement(addNewAccount);
		driver.findElement(By.xpath("//button[contains(text(),'Add New Account')]")).click();
		type(newAccEmail, "tdr33011@charter.net");
		type(newAccPwd, "Testing01");
		clickOnElement(newAccNext);
		type(newAccNickName,"tdr33011@charter.net");
		type(newAccRealName, "tdr33011@charter.net");
		clickOnElement(newAccDone);
		//if(isElementVisible(addAccMsg))
	}
	
	public void deleteAccount(){
		clickOnElement(settingAccbtn);
		driver.findElement(By.xpath("//button[contains(text(),'tdr33011@charter.net')]")).click();
		clickOnElement(newAccDelete);
		sleep(5);
		String[] filepath=new String[] { System.getProperty("user.dir") + File.separator + "AutoIT" + File.separator +"deleteFolder.exe",EnvParameters.WEB_BROWSER_TYPE.replaceAll("\\*", "")};
		System.out.println("print :" +EnvParameters.WEB_BROWSER_TYPE);

		try {
			Runtime.getRuntime().exec(filepath);
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("Unable to close");
		}

	}
	
	
	
}
