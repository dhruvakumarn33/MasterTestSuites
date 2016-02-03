package com.charter.page;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.cognizant.framework.ajax.Until;
import com.cognizant.framework.core.CaptureScreenshot;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.WebDriverBase;

public class BillingAndTransactionsPage extends WebDriverBase {

	private static String Paybill2=ReadFromExcel.getLocator("BTPage", "Paybill2");
	private static String OneTimeDebitPayment_Option=ReadFromExcel.getLocator("BTPage", "OneTimeDebitOption");
	private static String OneTimeCreditPayment_Option=ReadFromExcel.getLocator("BTPage", "OneTimeCreditOption");
	private static String MakePayment_Button=ReadFromExcel.getLocator("BTPage", "MakePayment");
	private static String OneTimeCheckingSaving=ReadFromExcel.getLocator("BTPage", "OneTimeCheckingSaving");
	private static String PayNow_Button=ReadFromExcel.getLocator("BTPage", "PayNow");
	private static String EnrollBtn=ReadFromExcel.getLocator("BTPage", "EnrollBtn");
	private static String CardType=ReadFromExcel.getLocator("BTPage", "CardType");
	private static String CardNumber=ReadFromExcel.getLocator("BTPage", "CardNumber");
	private static String ExpirationMonth=ReadFromExcel.getLocator("BTPage", "ExpirationMonth");
	private static String ExpirationYear=ReadFromExcel.getLocator("BTPage", "ExpirationYear");
	private static String PaymentAmount=ReadFromExcel.getLocator("BTPage", "PaymentAmount");
	private static String ReviewPayment=ReadFromExcel.getLocator("BTPage", "ReviewPayment");
	private static String Continue_Button=ReadFromExcel.getLocator("BTPage", "ContinueButton");
	private static String Makepayment2=ReadFromExcel.getLocator("BTPage", "Makepayment2");
	private static String AutopayEnrollBtn=ReadFromExcel.getLocator("BTPage", "AutopayEnrollBtn");
	private static String Finishbtn=ReadFromExcel.getLocator("BTPage", "Finishbtn");
	private static String PaymentConfirmationMsg=ReadFromExcel.getLocator("BTPage", "PaymentConfirmationMessage");
	private static String AutopayconfirmMessage=ReadFromExcel.getLocator("BTPage", "AutopayconfirmMessage");
	private static String CbTerms=ReadFromExcel.getLocator("BTPage", "CbTerms");
	private static String rbCheck=ReadFromExcel.getLocator("BTPage", "rbCheck");
	private static String rbSaving=ReadFromExcel.getLocator("BTPage", "rbSaving");
	private static String weRoutingNumber=ReadFromExcel.getLocator("BTPage", "weRoutingNumber");
	private static String weaccountNumber=ReadFromExcel.getLocator("BTPage", "weaccountNumber");
	private static String IDonot_Agree=ReadFromExcel.getLocator("BTPage", "IDonotAgree");
	private static String Cancel_btn=ReadFromExcel.getLocator("BTPage", "Cancelbtn");
	private static String AutopayDC=ReadFromExcel.getLocator("BTPage", "AutopayDC");
	private static String AutopayCC=ReadFromExcel.getLocator("BTPage", "AutopayCC");
	private static String AutopayCS=ReadFromExcel.getLocator("BTPage", "AutopayC_S");
	private static String VerifyPayment=ReadFromExcel.getLocator("BTPage", "VerifyPament_Info");
	private static String SetupAutoPay=ReadFromExcel.getLocator("BTPage", "SetupAutoPay");
	private static String BillDeliveryOptions=ReadFromExcel.getLocator("BTPage", "BillDeliveryOptions");
	private static String PaperOnlineBill=ReadFromExcel.getLocator("BTPage", "PaperOnlineBill");
	private static String OnlineBill=ReadFromExcel.getLocator("BTPage", "OnlineBill");
	private static String btnChange=ReadFromExcel.getLocator("BTPage", "btnChange");
	private static String WeOK=ReadFromExcel.getLocator("BTPage", "WeOK");
	private static String WeEditcontactinfo=ReadFromExcel.getLocator("BTPage", "WeEditcontactinfo");
	private static String weAddress1=ReadFromExcel.getLocator("BTPage", "weAddress1");
	private static String weAddress2=ReadFromExcel.getLocator("BTPage", "weAddress2");
	private static String weCityField=ReadFromExcel.getLocator("BTPage", "weCityField");
	private static String weStateCode=ReadFromExcel.getLocator("BTPage", "weStateCode");
	private static String weZipCode=ReadFromExcel.getLocator("BTPage", "weZipCode");
	private static String btSavee=ReadFromExcel.getLocator("BTPage", "btSavee");
	private static String weBillAddress=ReadFromExcel.getLocator("OverviewPage", "weBillAddress");
	private static String BtnOK=ReadFromExcel.getLocator("BTPage", "BtnOK");
	private static String Errorbtnok=ReadFromExcel.getLocator("BTPage", "Errorbtnok");
	private static String rbbtCancel=ReadFromExcel.getLocator("BTPage", "rbbtCancel");
	private static String btAutoCancel=ReadFromExcel.getLocator("BTPage", "btAutoCancel");
	private static String btnYES=ReadFromExcel.getLocator("BTPage", "btnYESModal");
	private static String btnNO=ReadFromExcel.getLocator("BTPage", "btnNOModal");
	private static String weOverview=ReadFromExcel.getLocator("OverviewPage", "weOverview");
	private static String lnkDetails=ReadFromExcel.getLocator("OverviewPage", "lnkDetails");
	private static String AutoPayCMessage=ReadFromExcel.getLocator("BTPage", "AutoPayCMessage");
	private static String weProceed=ReadFromExcel.getLocator("BTPage", "weProceed");
	private static String weVerifyPaymentConfirmation=ReadFromExcel.getLocator("BTPage", "weVerifyPaymentConfirmation");
	private static String PHbtn=ReadFromExcel.getLocator("BTPage", "PHbtn");
	private static String PaymentDate=ReadFromExcel.getLocator("BTPage", "PaymentDate");
	private static String PHViewmorelink=ReadFromExcel.getLocator("BTPage", "PHViewmorelink");
	private static String wePH=ReadFromExcel.getLocator("BTPage", "wePH");

	private static String RTbtn=ReadFromExcel.getLocator("BTPage", "RTbtn");
	private static String weDatarow1=ReadFromExcel.getLocator("BTPage", "weDatarow1");
	private static String RTViewmoreLink=ReadFromExcel.getLocator("BTPage", "RTViewmoreLink");
	private static String weRT=ReadFromExcel.getLocator("BTPage", "weRT");
	private static String weDatarow2=ReadFromExcel.getLocator("BTPage", "weDatarow2");
	private static String UpcomingPayments=ReadFromExcel.getLocator("BTPage","UpcomingPayments");
	private static String ViewCBill=ReadFromExcel.getLocator("BTPage","ViewCBill");
	private static String ViewDueDate=ReadFromExcel.getLocator("BTPage","ViewDueDate");
	private static String PaymentDate1=ReadFromExcel.getLocator("BTPage","PaymentDate1");

	private static String AskCWidget=ReadFromExcel.getLocator("TVServ","AskCharterWidget");
	private static String BtnASK=ReadFromExcel.getLocator("TVServ","BtnASK");
	private static String VIBillMessage=ReadFromExcel.getLocator("BTPage","VIBillMessage");

	private static String BTHeader=ReadFromExcel.getLocator("BTPage", "BTHeader");
	private static String SSSection=ReadFromExcel.getLocator("MAPage", "SSSection");
	private static String CallDetailsSection=ReadFromExcel.getLocator("MAPage", "CallDetailsSection");
	private static String PaymentHistorySection=ReadFromExcel.getLocator("MAPage", "PaymentHistorySection");
	private static String RecentTransSection=ReadFromExcel.getLocator("MAPage", "RecentTransSection");
	private static String AskCharterWidget1=ReadFromExcel.getLocator("BTPage","AskCharterWidget");
	private static String ContactInfoSection=ReadFromExcel.getLocator("BTPage","ContactInfoSection");
	private static String FooterTV=ReadFromExcel.getLocator("MAPage","FooterTV");
	private static String FooterMA=ReadFromExcel.getLocator("MAPage","FooterMA");
	private static String FooterSupport=ReadFromExcel.getLocator("MAPage","FooterSupport");

	private static String CallDetailsLink=ReadFromExcel.getLocator("BTPage","CallDetailsLink");
	private static String statementsByMonth=ReadFromExcel.getLocator("BTPage","statementsbyMonth");
	private static String filterByType=ReadFromExcel.getLocator("BTPage","filterbyType");
	private static String filterByPhone=ReadFromExcel.getLocator("BTPage","filterbyPhone");
	private static String filterByRate=ReadFromExcel.getLocator("BTPage","filterbyRate");
	private static String PhoneNo=ReadFromExcel.getLocator("BTPage","PhoneNo");
	private static String Rate=ReadFromExcel.getLocator("BTPage","Rate");

	WebDriver popupDriver = null;
	CaptureScreenshot<WebDriver> screenshot;

	public BillingAndTransactionsPage(WebDriver driver) {
		this.driver=driver;
		screenshot= new CaptureScreenshot<WebDriver>(driver);
	}

	public void makePayment() {
		HomePage hp=new HomePage(driver);
		//hp.pagewait();
		wait(Until.elementToBeDisplayed(Paybill2));
		clickOnElement(Paybill2);
	}

	public void AgreeButton(){
		
		clickOnElement(Makepayment2);
	}

	public void Finishbtn(){
		switchToDefaultContent();
		clickOnElement(Finishbtn);
		/*WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(10));
		wait.Until(ExpectedConditions.ElementExists(By.XPath(SOME XPATH HERE));
*/
	}
	public void AutopayEnroll(){
		clickOnElement(AutopayEnrollBtn);
		}
	
	public boolean DuplicateErrorMsg(){
		
		switchToDefaultContent();
		sleep(5);
		boolean retVal=false;
		if(isElementPresent(Errorbtnok)){
			clickOnElement(Errorbtnok);
			retVal=true;
		}
		return retVal;
	}
	
	public void DoNotAgreeButton(){
		clickOnElement(IDonot_Agree);
	}
	public void CancelButton(){
		clickOnElement(Cancel_btn);
	}

	public void AcceptAlert(){
		acceptAlert();
	}

	public void DismissAlert(){
		dismissAlert();

	}

	public void TermsandConditions(){

		clickOnElement(CbTerms);
	}
	public void AutopayConfirm(){

		if(isElementPresent(AutoPayCMessage)){
			System.out.println("Autopay is Successful");
		}

		else{
			System.out.println("Autopay is not Successful");
		}


	}

	public void EnterCardDetails(String cardtype,String cardNumber,String expMonth,String expYear){

		selectValueFromDropDown(CardType, cardtype);
		type(CardNumber, cardNumber);
		selectValueFromDropDown(ExpirationMonth, expMonth);
		selectValueFromDropDown(ExpirationYear, expYear);
	}

	public void creditCardPayment(String cardtype,String cardNumber,String expMonth,String expYear,String amount) 
	{
	
		clickOnElement(OneTimeCreditPayment_Option);			
		clickOnElement(MakePayment_Button);	
		switchToFrame("id;pciIframe");
		clickOnElementUsingJavaScript(PaymentAmount);
		clearTextBox(PaymentAmount);
		type(PaymentAmount, amount);	
		EnterCardDetails(cardtype,cardNumber,expMonth,expYear);
		clickOnElement(ReviewPayment);
	}

	public void debitCardPayment(String cardtype,String cardNumber,String expMonth,String expYear,String amount) {

		clickOnElement(OneTimeDebitPayment_Option);
		clickOnElement(MakePayment_Button);	
		switchToFrame("id;pciIframe");
		clickOnElementUsingJavaScript(PaymentAmount);
		clearTextBox(PaymentAmount);
		type(PaymentAmount, amount);
		EnterCardDetails(cardtype,cardNumber,expMonth,expYear);
		clickOnElement(ReviewPayment);
	}

	public void checkingPayment(String routingnumber, String accountnumber, String amount) {

		switchToFrame("id;iFrameResizer0");
		clickOnElement(OneTimeCheckingSaving);
		sleep(5);
		screenshot.saveScreenshot("OTP Checking"+ File.separator + "Selected One Time Checking");
		clickOnElement(PayNow_Button);
		isElementEnabled(rbCheck);
		type(weRoutingNumber,routingnumber);
		type(weaccountNumber,accountnumber);
		clearTextBox(PaymentAmount);
		type(PaymentAmount, amount);
		screenshot.saveScreenshot("OTP Checking"+ File.separator + "Entered Bank Details");
		clickOnElement(Continue_Button);
		if(isElementPresent(weVerifyPaymentConfirmation)){
			System.out.println("Verify Payment Confirmation Page is displayed");
			screenshot.saveScreenshot("OTP Checking"+ File.separator + "VerifyPaymentConfirmation");
		}
		else{
			System.out.println("Verify Payment Confirmation Page is not displayed");
		}

	}

	public void Savingspayment(String routingnumber, String accountnumber, String amount){

		switchToFrame("id;iFrameResizer0");
		clickOnElement(OneTimeCheckingSaving);
		sleep(5);
		screenshot.saveScreenshot("OTP Savings"+ File.separator + "Selected One Time Savings");
		clickOnElement(PayNow_Button);
		clickOnElement(rbSaving);
		type(weRoutingNumber,routingnumber);
		type(weaccountNumber,accountnumber);
		clearTextBox(PaymentAmount);
		type(PaymentAmount, amount);
		screenshot.saveScreenshot("OTP Savings"+ File.separator + "Entered Bank Details");
		clickOnElement(Continue_Button);
		if(isElementPresent(weVerifyPaymentConfirmation)){
			System.out.println("Verify Payment Confirmation Page is displayed");
			screenshot.saveScreenshot("OTP Savings"+ File.separator + "VerifyPaymentConfirmation");
		}
		else{
			System.out.println("Verify Payment Confirmation Page is not displayed");
		}

	}
	public String getPaymentConfirmationMsg() {
		System.out.println(getText(PaymentConfirmationMsg));
		return getText(PaymentConfirmationMsg);
	}

	public String getautopayConfirmationMsg(){
		System.out.println("payment conf msg--"+getText(AutopayconfirmMessage)+"--ends");
		return getText(AutopayconfirmMessage);
	}
	public void Autopay_DC(String cardtype,String cardNumber,String expMonth,String expYear){

		clickOnElement(AutopayDC);
		clickOnElement(EnrollBtn);
		switchToFrame("id;pciIframe");
		EnterCardDetails(cardtype,cardNumber,expMonth,expYear);
		clickOnElement(ReviewPayment);

	}

	public boolean Autopay_CC(String cardtype,String cardNumber,String expMonth,String expYear){

		boolean retVal=false;
		clickOnElement(AutopayCC);
		clickOnElement(EnrollBtn);
		switchToFrame("id;pciIframe");
		EnterCardDetails(cardtype,cardNumber,expMonth,expYear);
		clickOnElement(ReviewPayment);
		return retVal;
	}

	public void Autopay_checking(String routingnumber, String accountnumber){

		switchToFrame("id;iFrameResizer0");
		clickOnElement(AutopayCS);
		sleep(5);
		screenshot.saveScreenshot("AutoPay Checking"+ File.separator + "Selected Autopay checking");
		clickOnElement(SetupAutoPay);
		isElementEnabled(rbCheck);
		type(weRoutingNumber,routingnumber);
		type(weaccountNumber,accountnumber);
		screenshot.saveScreenshot("AutoPay Checking"+ File.separator + "Entered Bank Details");
		clickOnElement(Continue_Button);
		if(isElementPresent(weVerifyPaymentConfirmation)){
			System.out.println("Verify Payment Confirmation Page is displayed");
			screenshot.saveScreenshot("AutoPay Checking"+ File.separator + "VerifyPaymentConfirmation");
		}
		else{
			System.out.println("Verify Payment Confirmation Page is not displayed");
		}

	}

	public void Autopay_saving(String routingnumber, String accountnumber){

		switchToFrame("id;iFrameResizer0");
		sleep(5);
		clickOnElement(AutopayCS);
		screenshot.saveScreenshot("AutoPay Savings"+ File.separator + "Selected Autopay Savings");
		clickOnElement(SetupAutoPay);
		clickOnElement(rbSaving);
		type(weRoutingNumber,routingnumber);
		type(weaccountNumber,accountnumber);
		screenshot.saveScreenshot("AutoPay Savings"+ File.separator + "Entered Bank Details");
		clickOnElement(Continue_Button);
		if(isElementPresent(weVerifyPaymentConfirmation)){
			System.out.println("Verify Payment Confirmation Page is displayed");
			screenshot.saveScreenshot("AutoPay Savings"+ File.separator + "VerifyPaymentConfirmation");
		}
		else{
			System.out.println("Verify Payment Confirmation Page is not displayed");
		}


	}

	public boolean Manage_BillDelivery(){

		boolean retVal=true;
		clickOnElement(BillDeliveryOptions);
		if(isElementEnabled(OnlineBill)){
			//clickOnElement(OnlineBill);
			if(isElementPresent(PaperOnlineBill)){
				retVal=true;
			}
		}
		return retVal;
		/*	if(isElementPresent(btnChange)){
			clickOnElement(btnChange);
		}
		if(isElementPresent(WeOK)){
			clickOnElement(WeOK);
		}*/
		/*		wait(Until.elementToBeDisplayed(BillDeliveryOptions));
		clickOnElement(BillDeliveryOptions);
		 */	}

	public boolean Edit_contact_Button(String Address1,String Address2,String City,String State,String Zipcode){

		boolean retVal=false;
		if(isElementPresent(WeEditcontactinfo)){

			System.out.println("Contact Edit button is Present");
			clickOnElement(WeEditcontactinfo);
		}
		else{

			System.out.println("Contact Edit button is not Present");
		}
		clearTextBox(weAddress1);
		type(weAddress1,Address1);
		clearTextBox(weAddress2);
		type(weAddress2,Address2);
		clearTextBox(weCityField);
		type(weCityField,City);
		selectValueFromDropDown(weStateCode, State);
		clearTextBox(weZipCode);
		type(weZipCode,Zipcode);
		clickOnElementUsingJavaScript(btSavee);
		clickOnElementUsingJavaScript(BtnOK);
		HomePage hp= new HomePage(driver);
		hp.pagewait();
		driver.navigate().refresh();
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.loadOverviewPage();
		wait(Until.elementToBeDisplayed(weBillAddress));
		retVal=true;
		return retVal;
	}

	public void Cancel_AutoPay(){

		switchToFrame("id;iFrameResizer0");
		//	wait(Until.elementToBeDisplayed(rbbtCancel));
		//clickOnElement(rbbtCancel);
		WebElement cancelrbbtn = driver.findElement(By.xpath("/html/body/section/div/div/div/div/div/div[2]/div[2]/div[1]/ul/li[4]/label"));
		cancelrbbtn.click();
		clickOnElement(btAutoCancel);
		switchToDefaultContent();
		clickOnElement(btnYES);
		clickOnElement(WeOK);
		/*//Temp Code
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).perform();
		sleep(5);*/

		wait(Until.elementToBeDisplayed(weOverview));
		screenshot.saveScreenshot("Cancel AutoPay"+ File.separator + "Overview Page");

	}

	public void Retain_Autopay(){

		switchToFrame("id;iFrameResizer0");
		wait(Until.elementToBeDisplayed(rbbtCancel));
		clickOnElement(rbbtCancel);
		clickOnElement(btAutoCancel);
		switchToDefaultContent();
		clickOnElement(btnNO);
		//wait(Until.elementToBeDisplayed(rbbtCancel));
		//driver.navigate().back();
	}


	public boolean Edit_contact_Standard(){
		boolean retVal=false;
		HomePage hp=new HomePage(driver);
		hp.pagewait();
		if(isElementPresent(WeEditcontactinfo)){

			System.out.println("Contact Edit button is Present");
			clickOnElement(WeEditcontactinfo);
		}
		else{
			System.out.println("Contact Edit button is not Present");
		}
		clickOnElement(weProceed);
		retVal=true;
		return retVal;
	}

	public boolean Payment_History(){
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(PHbtn));
		clickOnElement(PHbtn);
		sleep(5);
		if(isElementPresent(PaymentDate)){
			retVal=true;
		}
		/*clickOnElement(PHViewmorelink);
		sleep(5);
		if(isElementPresent(wePH)){
			retVal=true;
		}*/
		return retVal;
	}


	public boolean Payment_History_Section(){

		boolean retVal=false;
		//wait(Until.elementToBeClickable(PHbtn));
		//clickOnElement(PHbtn);
		
		WebElement phlink = driver.findElement(By.xpath("/html/body/div[1]/section/div/div[5]/section/div/button"));
		phlink.click();
		sleep(5);
		if(isElementPresent(PaymentDate)){
			int rowCount=driver.findElements(By.xpath("//table[@ng-show='payments.show']//tbody/tr[@class='ng-scope']")).size();
			System.out.println("Payment History record count: " +rowCount );
		}
		if(isElementPresent(PHViewmorelink)){
			clickOnElement(PHViewmorelink);
			sleep(5);
			wait(Until.elementsToBeDisplayed(wePH));
			int rowCount1=driver.findElements(By.xpath("//tbody/tr")).size();
			System.out.println("View More Payment History record count: " +rowCount1 );
		}

		retVal =true;
		return retVal;
	}
	public boolean Recent_Transactions(){
		boolean retVal=false;
		wait(Until.elementToBeClickable(RTbtn));
		clickOnElement(RTbtn);
		sleep(5);
		if(isElementPresent(weDatarow1)){
			retVal=true;
		}
		/*wait(Until.elementToBeClickable(RTViewmoreLink));
		clickOnElement(RTViewmoreLink);
		sleep(5);
		if(isElementPresent(weDatarow2)){
			retVal=true;
		}*/
		return retVal;
	}

	public void Recent_Transaction_Section(){

		wait(Until.elementToBeClickable(RTbtn));
		clickOnElement(RTbtn);
		sleep(5);
		if(isElementPresent(weDatarow1)){
			int rowCount=driver.findElements(By.xpath("//table[@ng-show='transactions.show']//tbody//tr[@class='ng-scope']")).size();
			System.out.println("Recent Transaction Section record count: " +rowCount );
		}
		if(isElementPresent(RTViewmoreLink))	{
			clickOnElement(RTViewmoreLink);
			sleep(5);
			int rowCount=driver.findElements(By.xpath("//tbody/tr")).size();
			System.out.println("View More Recent Transaction Section record count: " +rowCount );
		}

	}
	public boolean Billdeliverylink(){
		boolean retVal=false;
		wait(Until.elementToBeClickable(BillDeliveryOptions));
		clickOnElement(BillDeliveryOptions);
		retVal = true;
		return retVal;
	}

	public boolean UpcomingPaymentsLink(){
		boolean retVal=false;
		wait(Until.elementToBeClickable(UpcomingPayments));
		clickOnElement(UpcomingPayments);
		retVal = true;
		return retVal;
	}

	public boolean ViewCBillLink() throws InterruptedException{
		boolean retVal=false;
		wait(Until.elementToBeClickable(ViewCBill));
		clickOnElement(ViewCBill);
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
			if(!windowHandle.equals(parentWindow))
			{
				driver.switchTo().window(windowHandle);
				sleep(7);
				driver.close(); //closing child window
				driver.switchTo().window(parentWindow);//cntrl to parent window
				sleep(3);
			}
		}
		retVal = true;
		return retVal;
	}	

	public boolean viewduedate()throws InterruptedException{

		boolean retVal=false;
		screenshot.saveScreenshot("ViewDueDateLink"+ File.separator + "Billing and Transaction Page");
		wait(Until.elementToBeClickable(ViewDueDate));
		clickOnElement(ViewDueDate);
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
			if(!windowHandle.equals(parentWindow))
			{
				driver.switchTo().window(windowHandle);
				sleep(5);
				driver.close(); //closing child window
				driver.switchTo().window(parentWindow);//cntrl to parent window
				sleep(5);
			}
		}
		retVal = true;
		return retVal;

	}
	public boolean AskCharterSection(){

		boolean retVal=false;
		if(isElementPresent(AskCWidget)){
			retVal=true;
		}	
		if(isElementPresent(BtnASK)){
			retVal=true;
		}	
		return retVal;
	}

	public boolean VImpBillMsg(){
		boolean retVal=false;
		wait(Until.elementToBeClickable(VIBillMessage));
		clickOnElement(VIBillMessage);
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
			if(!windowHandle.equals(parentWindow))
			{
				sleep(5);
				driver.switchTo().window(windowHandle);
				driver.close(); //closing child window
				driver.switchTo().window(parentWindow);//cntrl to parent window
				sleep(5);
			}
		}	
		retVal=true;
		return retVal;
	}

	public boolean makepaymentLink(){
		boolean retVal=false;
		wait(Until.elementToBeClickable(Paybill2));
		clickOnElement(Paybill2);
		System.out.println(driver.getCurrentUrl());
		retVal = true;
		return retVal;
	}
	public boolean BillingAndTransactionHeaders(){
		boolean retVal=false;
		if(isElementPresent(BTHeader)&(isElementPresent(SSSection)&(isElementPresent(CallDetailsSection)&(isElementPresent(PaymentHistorySection)
				&(isElementPresent(RecentTransSection)&(isElementPresent(AskCharterWidget1)&(isElementPresent(ContactInfoSection))
						&(isElementPresent(FooterTV)&(isElementPresent(FooterMA))&(isElementPresent(FooterSupport)))))))))
		{

			retVal=true;
		}
		return retVal;

	}

	public boolean BTPage_CallDetailsLink(){

		boolean retVal=false;
		wait(Until.elementToBeClickable(CallDetailsLink));
		clickOnElement(CallDetailsLink);
		retVal=true;
		return retVal;
	}

	public void CallDetails_Filters(String Statement,String filterbyType,String filterbyPhone,String filterbyRate){

		selectValueFromDropDown(statementsByMonth, Statement);
		selectValueFromDropDown(filterByType, filterbyType);
		selectValueFromDropDown(filterByPhone, filterbyPhone);
		selectValueFromDropDown(filterByRate, filterbyRate);
	}

	public String getPhoneNo() {

		System.out.println(getText(PhoneNo));
		return getText(PhoneNo);
	}

	public void get_phonecount(){
		int PhonenoCount=driver.findElements(By.xpath("//tr[@class='ng-scope']/td[4]")).size();
		System.out.println(PhonenoCount);

	}

	public String getRate(){
		System.out.println(getText(Rate));
		return getText(Rate);
	}

	public void get_ratecount(){
		int RateCount=driver.findElements(By.xpath("//tr[@class='ng-scope']/td[6]")).size();
		System.out.println(RateCount);		
	}
	public void getcount_calldetails_records(){

		int rowCount=driver.findElements(By.xpath("//tr[@class='ng-scope']")).size();
		System.out.println(rowCount);
	}
	public void PayBill(){
		clickOnElement(Paybill2);
		HomePage hp=new HomePage(driver);
		hp.pagewait();
	}

	public void AutoPayDC(){
		clickOnElement(Paybill2);
		HomePage hp=new HomePage(driver);
		hp.pagewait();
		clickOnElement(AutopayDC);
		clickOnElement(SetupAutoPay);
	}

	public void OTPPayDC(){
		clickOnElement(Paybill2);
		HomePage hp=new HomePage(driver);
		hp.pagewait();
		clickOnElement(OneTimeDebitPayment_Option);
		clickOnElement(PayNow_Button);
	}
}


