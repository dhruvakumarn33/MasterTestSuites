package com.charter.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.charter.page.EmailPage;
import com.charter.page.HomePage;
import com.charter.utils.Constants;
import com.charter.utils.DataProviderClass;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.TestNGBase;

public class CharterMail extends TestNGBase{
	
	private String URL= Constants.URL;
	
	//Name: TM01_Validate_SendEmail_functionality()
	//Description: Validate whether the user is able to compose email and enter details in To, CC, BCC and Subject text fields and send mail
	//HOH user
	//Scripter:Dhruva
	//Date/Version:07-Aug-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TM01_Validate_SendEmail_functionality(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String To = testdata.get("CmailTo");
		String cc = testdata.get("CmailCC");
		String bcc = testdata.get("CmailBCC");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		EmailPage em = new EmailPage(driver);
		em.OpenCharterMail();
		Assert.assertTrue(em.ComposeMail(To, cc, bcc),"Success alert message for sending mail is not displayed");
		em.mailLogout();
	}
	
	//Name: TM02_Validate_Text_Font_changeIn_ComposeMail()
	//Description: Validate whether the user is able to change text style and font in compose email
	//HOH user
	//Scripter:Dhruva
	//Date/Version:07-Aug-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TM02_Validate_Text_Font_changeIn_ComposeMail(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String To = testdata.get("CmailTo");
		String cc = testdata.get("CmailCC");
		String bcc = testdata.get("CmailBCC");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		EmailPage em = new EmailPage(driver);
		em.OpenCharterMail();
		em.fillRecipient(To, cc, bcc);
		em.changeFontStyle(To, cc, bcc);
		em.mailLogout();
	}
	
	//Name: TM03_Validate_Delete_ComposedMail()
	//Description: Validate whether the user is able to delete the composed email
	//HOH user
	//Scripter:Dhruva
	//Date/Version:07-Aug-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TM03_Validate_Delete_ComposedMail(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String To = testdata.get("CmailTo");
		String cc = testdata.get("CmailCC");
		String bcc = testdata.get("CmailBCC");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		EmailPage em = new EmailPage(driver);
		em.OpenCharterMail();
		em.fillRecipient(To, cc, bcc);
		em.addSubject();
		em.deleteCompose();
		em.mailLogout();
	}
	
	//Name: TM04_Validate_GetMailBtn_OnInbox()
	//Description: Validate whether the user is able to access the Get Email Tab
	//HOH user
	//Scripter:Dhruva
	//Date/Version:10-Aug-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TM04_Validate_GetMailBtn_OnInbox(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String To = testdata.get("CmailTo");
		String cc = testdata.get("CmailCC");
		String bcc = testdata.get("CmailBCC");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		EmailPage em = new EmailPage(driver);
		em.OpenCharterMail();
		em.ComposeMail(To, cc, bcc);
		Assert.assertTrue(em.getMail(),"Get Mail doesn't refresh the mail box");
		em.mailLogout();
	}
	
	//Name: TM05_Validate_GetHelpLink_QuickEmailReferenceGuidePage()
	//Description: Validate whether the user is able to access the Get Email Tab
	//HOH user
	//Scripter:Dhruva
	//Date/Version:10-Aug-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TM05_Validate_GetHelpLink_QuickEmailReferenceGuidePage(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		EmailPage em = new EmailPage(driver);
		em.OpenCharterMail();
		Assert.assertTrue(em.mailHelp(),"Help button doesn't load Quick Email Reference Guide");
		em.mailLogout();
	}
	
	//Name: TM06_Validate_displayOf_AllAccounts_InShowAllAccounts_Dropdown()
	//Description: Validate whether the user is able to see all accounts which are currently signed in by clicking on Show All accounts in drop down
	//HOH user
	//Scripter:Dhruva
	//Date/Version:10-Aug-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TM06_Validate_displayOf_AllAccounts_InShowAllAccounts_Dropdown(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		String email = testdata.get("email");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		EmailPage em = new EmailPage(driver);
		em.OpenCharterMail();
		Assert.assertTrue(em.viewAllAccounts(email), "Current logged in accounts are not displayed in the dropdown");
		em.mailLogout();
	}
	
	//Name: TM07_Validate_SearchEmail_Functionality()
	//Description: Validate whether the user is able to search specific emails in search tab
	//HOH user
	//Scripter:Dhruva
	//Date/Version:10-Aug-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TM07_Validate_SearchEmail_Functionality(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		EmailPage em = new EmailPage(driver);
		em.OpenCharterMail();
		em.searchMail();
		em.mailLogout();
	}
	
	//Name: TM08_Validate_accessTo_Inbox_Drafts_Sent_Spam_TrashFolders()
	//Description: Validate user is able to access Inbox, Drafts, Sent Mail, Spam, Trash folders
	//HOH user
	//Scripter:Dhruva
	//Date/Version:10-Aug-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TM08_Validate_accessTo_Inbox_Drafts_Sent_Spam_TrashFolders(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		EmailPage em = new EmailPage(driver);
		em.OpenCharterMail();
		em.accessFolders();
		em.mailLogout();
	}
	
	//Name: TM09_Validate_SentFolder_EditFunctionality()
	//Description: Validate the user is able to edit the Sent folder
	//HOH user
	//Scripter:Dhruva
	//Date/Version:11-Aug-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TM09_Validate_SentFolder_EditFunctionality(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		EmailPage em = new EmailPage(driver);
		em.OpenCharterMail();
		em.editSentFolder();
		em.mailLogout();
	}
	
	//Name: TM10_Validate_CreateNewFolder_functionality()
	//Description: Validate the user is able to create new folder name
	//HOH user
	//Scripter:Dhruva
	//Date/Version:11-Aug-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TM10_Validate_CreateNewFolder_functionality(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		EmailPage em = new EmailPage(driver);
		em.OpenCharterMail();
		Assert.assertTrue(em.createNewFolder(),"Create folder success message is not displayed");
		Assert.assertTrue(em.deleteFolder(),"Delete folder success message is not displayed");
		em.mailLogout();
	}
	
	//Name: TM11_Validate_Create_NewUserGroup_Functionality()
	//Description: Validate user is able to create new group in contacts tab
	//HOH user
	//Scripter:Dhruva
	//Date/Version:11-Aug-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TM11_Validate_Create_NewUserGroup_Functionality(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		EmailPage em = new EmailPage(driver);
		em.OpenCharterMail();
		Assert.assertTrue(em.createGroup(),"Create Group success message is not displayed");
		Assert.assertTrue(em.deleteGroup(),"Delete Group success message is not displayed");
		em.mailLogout();
	}
	
	//Name: TM12_Validate_Create_NewContact_Functionality()
	//Description: Validate user is able to create new group in contacts tab
	//HOH user
	//Scripter:Dhruva
	//Date/Version:11-Aug-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TM12_Validate_Create_NewContact_Functionality(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		EmailPage em = new EmailPage(driver);
		em.OpenCharterMail();
		em.createContact();
		Assert.assertTrue(em.deleteContact(),"Contact delete success message is not displayed");
		em.mailLogout();
	}
	
	//Name: TM13_Validate_Adding_NewAccountFunctionality()
	//Description: Validate whether the user is able to add account in Account settings
	//HOH user
	//Scripter:Dhruva
	//Date/Version:11-Aug-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TM13_Validate_Adding_NewAccountFunctionality(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		
		EmailPage em = new EmailPage(driver);
		em.OpenCharterMail();
		em.addNewAccount();
		em.deleteAccount();
		em.mailLogout();
	}
	
	//Name: TM14_Validate_CharterMail_SignOut()
	//Description: Validate whether the user is able to sign out from Email page
	//HOH user
	//Scripter:Dhruva
	//Date/Version:12-Aug-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TM14_Validate_CharterMail_SignOut(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		
		EmailPage em = new EmailPage(driver);
		em.OpenCharterMail();
		em.mailLogout();
	}
	
	//Name: TM15_Validate_ATMailError_Inbox()
	//Description: Validate whether the user is able to view inbox without any error
	//HOH user
	//Scripter:Dhruva
	//Date/Version:07-Dec-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TM15_Validate_ATMailError_Inbox(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		
		EmailPage em = new EmailPage(driver);
		em.OpenCharterMail();
		em.verifyInbox();
		em.mailLogout();
	}
	
	//Name: TM16_Validate_ATMailError_Drafts()
	//Description: Validate whether the user is able to view drafts without any error
	//HOH user
	//Scripter:Dhruva
	//Date/Version:07-Dec-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TM16_Validate_ATMailError_Drafts(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		
		EmailPage em = new EmailPage(driver);
		em.OpenCharterMail();
		em.verifyDrafts();
		em.mailLogout();
	}
	
	//Name: TM17_Validate_ATMailError_SentMail()
	//Description: Validate whether the user is able to view sent mail without any error
	//HOH user
	//Scripter:Dhruva
	//Date/Version:07-Dec-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TM17_Validate_ATMailError_SentMail(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		
		EmailPage em = new EmailPage(driver);
		em.OpenCharterMail();
		em.verifySentMail();
		em.mailLogout();
	}
	
	//Name: TM18_Validate_ATMailError_Spam()
	//Description: Validate whether the user is able to view spam folder without any error
	//HOH user
	//Scripter:Dhruva
	//Date/Version:07-Dec-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TM18_Validate_ATMailError_Spam(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		
		EmailPage em = new EmailPage(driver);
		em.OpenCharterMail();
		em.verifySpam();
		em.mailLogout();
	}
	
	//Name: TM19_Validate_ATMailError_Trash()
	//Description: Validate whether the user is able to view trash folder without any error
	//HOH user
	//Scripter:Dhruva
	//Date/Version:07-Dec-15
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TM19_Validate_ATMailError_Trash(Map<String,String> testdata) throws Exception {

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");
		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password);
		
		EmailPage em = new EmailPage(driver);
		em.OpenCharterMail();
		em.verifyTrash();
		em.mailLogout();
	}
	
}
