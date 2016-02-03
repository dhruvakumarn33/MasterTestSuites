package com.charter.page;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.cognizant.framework.ajax.Until;
import com.cognizant.framework.core.CaptureScreenshot;
import com.cognizant.framework.core.EnvParameters;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.WebDriverBase;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.gargoylesoftware.htmlunit.javascript.host.Element;

public class BillingAndTransactionsPage extends WebDriverBase {

	private static String SignInLink=ReadFromExcel.getLocator("HomePage", "SignIn");
	private static String Username=ReadFromExcel.getLocator("HomePage", "username");
	private static String Password=ReadFromExcel.getLocator("HomePage", "password");
	private static String PasswordPlaceHolder=ReadFromExcel.getLocator("HomePage", "password_placeholder");
	private static String btnSignin=ReadFromExcel.getLocator("HomePage", "btnSignin");
	private static String Paybill2=ReadFromExcel.getLocator("BTPage", "Paybill2");
	private static String OneTimeDebitPayment_Option=ReadFromExcel.getLocator("BTPage", "OneTimeDebitOption");
	private static String OneTimeCreditPayment_Option=ReadFromExcel.getLocator("BTPage", "OneTimeCreditOption");
	private static String MakePayment_Button=ReadFromExcel.getLocator("BTPage", "MakePayment");
	private static String OneTimeCheckingSaving=ReadFromExcel.getLocator("BTPage", "OneTimeCheckingSaving");
	private static String PayNow_Button=ReadFromExcel.getLocator("BTPage", "PayNow");
	private static String EnrollBtn=ReadFromExcel.getLocator("BTPage", "EnrollBtn");
	private static String Enrollnow=ReadFromExcel.getLocator("BTPage", "Enrollnow");
	private static String CardType=ReadFromExcel.getLocator("BTPage", "CardType");
	private static String CardNumber=ReadFromExcel.getLocator("BTPage", "CardNumber");
	private static String ExpirationMonth=ReadFromExcel.getLocator("BTPage", "ExpirationMonth");
	private static String ExpirationYear=ReadFromExcel.getLocator("BTPage", "ExpirationYear");
	private static String PaymentAmount=ReadFromExcel.getLocator("BTPage", "PaymentAmount");
	private static String PaymentAmtError=ReadFromExcel.getLocator("BTPage", "PaymentAmtError");
	private static String ReviewPayment=ReadFromExcel.getLocator("BTPage", "ReviewPayment");
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
	private static String PHExpand=ReadFromExcel.getLocator("BTPage", "PHExpand");
	private static String PHCollapse=ReadFromExcel.getLocator("BTPage", "wePH");

	private static String RTbtn=ReadFromExcel.getLocator("BTPage", "RTbtn");
	private static String RTExpand=ReadFromExcel.getLocator("BTPage", "RTExpand");
	private static String RTCollapse=ReadFromExcel.getLocator("BTPage", "RTCollapse");
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
	private static String nextMonth=ReadFromExcel.getLocator("BTPage","nextMonth");
	private static String noUpcoming=ReadFromExcel.getLocator("BTPage","noUpcoming");
	private static String billDeliveryStatus=ReadFromExcel.getLocator("BTPage","billDeliveryStatus");
	private static String viewTermsCondition=ReadFromExcel.getLocator("BTPage","viewTermsCondition");
	private static String printTerms=ReadFromExcel.getLocator("BTPage","printTerms");
	private static String closeTerms=ReadFromExcel.getLocator("BTPage","closeTerms");
	private static String balanceInfo=ReadFromExcel.getLocator("BTPage","balanceInfo");
	private static String checkImage=ReadFromExcel.getLocator("BTPage","checkImage");
	private static String EFTInfo=ReadFromExcel.getLocator("BTPage","EFTInfo");
	private static String invalidInputMsg=ReadFromExcel.getLocator("BTPage","invalidInputMsg");
	private static String autopayStatus=ReadFromExcel.getLocator("BTPage","autopayStatus");
	private static String verifyDetails=ReadFromExcel.getLocator("BTPage","verifyDetails");
	private static String TermsError=ReadFromExcel.getLocator("BTPage","TermsError");
	private static String AmtBalance=ReadFromExcel.getLocator("BTPage", "AmtBalance");
	private static String LPAmt=ReadFromExcel.getLocator("BTPage", "LPAmt");
	private static String LPDate=ReadFromExcel.getLocator("BTPage", "LPDate");
	private static String LPCard=ReadFromExcel.getLocator("BTPage", "LPCard");

	WebDriver popupDriver = null;
	CaptureScreenshot<WebDriver> screenshot;

	public BillingAndTransactionsPage(WebDriver driver) {
		this.driver=driver;
		screenshot= new CaptureScreenshot<WebDriver>(driver);
	}

	public void makePayment() {
		HomePage hp=new HomePage(driver);
		hp.pagewait();
		wait(Until.elementToBeDisplayed(Paybill2));
		clickOnElement(Paybill2);
	}

	public void AgreeButton(){
		
		if(isElementVisible("xpath;(//button[contains(text(),'Cancel Payment')])[2]")){
			System.out.println("Cancel Payment button is visible");
		}
		clickOnElement(Makepayment2);
	}

	public void Finishbtn(){
		switchToDefaultContent();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(isElementVisible(Finishbtn))
			clickOnElement(Finishbtn);
	}
	public void AutopayEnroll(){
		sleep(10);
		wait(Until.elementToBeDisplayed(AutopayEnrollBtn));
		clickOnElement(AutopayEnrollBtn);
		}
	
	public boolean DuplicateErrorMsg(){
		
		switchToDefaultContent();
		boolean retVal=false;
		if(isElementPresent(Errorbtnok))
		{
			wait(Until.elementToBeClickable(Errorbtnok));
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
		clickOnElement(Makepayment2);
		if(isElementVisible(TermsError))
			System.out.println("Error Message for not checking the Terms and Condition checkbox is displayed");
		clickOnElement(CbTerms);
	}
	
	public void ApTermsandConditions(){
		clickOnElement(AutopayEnrollBtn);
		if(isElementVisible(TermsError))
			System.out.println("Error Message for not checking the Terms and Condition checkbox is displayed");
		clickOnElement(CbTerms);
	}
	
	public boolean verifyCardDetails(){
		boolean retVal=false;
		System.out.println("Card Type: "+getText(verifyDetails+"/li[1]"));
		System.out.println("Card Number: "+getText(verifyDetails+"/li[2]"));
		System.out.println("Expiration Date: "+getText(verifyDetails+"/li[3]"));
		return retVal;
	}
	
	public void AcceptTermsandConditions(){
		switchToFrame("id;pciIframe");
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
		sleep(20);
		clickOnElement(OneTimeCreditPayment_Option);			
		clickOnElement(MakePayment_Button);	
		switchToFrame("id;pciIframe");
		clickOnElementUsingJavaScript(PaymentAmount);
		clearTextBox(PaymentAmount);
		type(PaymentAmount,""+Keys.TAB);
		if(isElementVisible(PaymentAmtError))
			System.out.println("Invalid Payment Amount error message is displayed");
		type(PaymentAmount, amount);	
		EnterCardDetails(cardtype,cardNumber,expMonth,expYear);
		clickOnElement(ReviewPayment);
	}
	
	public boolean daysOfPayment(){
		boolean retVal=false;
		clickOnElement(OneTimeCreditPayment_Option);			
		clickOnElement(MakePayment_Button);	
		switchToFrame("id;pciIframe");
		clickOnElement(PaymentDate1);
		int days=0;		
		Collection<WebElement> count= driver.findElements(By.xpath("//td[@aria-disabled='false']/button/span[@class='ng-binding']"));
		days= count.size();
		System.out.println("Present month days ="+days);
		if(driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm pull-right']")).isEnabled()){
			System.out.println("Next month");
			clickOnElement("xpath;//button[@class='btn btn-default btn-sm pull-right']");
			Collection<WebElement> count1= driver.findElements(By.xpath("//td[@aria-disabled='false']/button/span[@class='ng-binding']"));
			System.out.println("Next month days ="+count1.size());
			days=days+count1.size();
		}
		System.out.println(days);
		switchToDefaultContent();
		if(days==30)
			retVal=true;
		return retVal;
	}

	public void debitCardPayment(String cardtype,String cardNumber,String expMonth,String expYear,String amount) {
		boolean days = daysOfPayment();
		if(days==true)
			System.out.println("Number of days available for paying bill: 30");
		refreshPage();
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.loadBillingAndTransactionSection();
		makePayment();
		wait(Until.elementToBeClickable(OneTimeDebitPayment_Option));
		clickOnElement(OneTimeDebitPayment_Option);
		clickOnElement(MakePayment_Button);	
		switchToFrame("id;pciIframe");
		//clickOnElement("xpath;.//*[@id='paymentNumber']");
		clickOnElementUsingJavaScript(PaymentAmount);
		clearTextBox(PaymentAmount);
		type(PaymentAmount, amount);
		EnterCardDetails(cardtype,cardNumber,expMonth,expYear);
		clickOnElement(ReviewPayment);
	}
	
	public void debitCardPaymentPastDue(String cardtype,String cardNumber,String expMonth,String expYear,String amount) {
		sleep(20);
		wait(Until.elementToBeClickable(OneTimeDebitPayment_Option));
		clickOnElement(OneTimeDebitPayment_Option);
		clickOnElement(MakePayment_Button);	
		switchToFrame("id;pciIframe");
		//clickOnElement("xpath;.//*[@id='paymentNumber']");
		clickOnElementUsingJavaScript(PaymentAmount);
		clearTextBox(PaymentAmount);
		type(PaymentAmount, amount);
		EnterCardDetails(cardtype,cardNumber,expMonth,expYear);
		clickOnElement(ReviewPayment);
	}

	public void checkingPayment(String routingnumber, String accountnumber, String amount) {

		sleep(20);
		clickOnElement(OneTimeCheckingSaving);
		clickOnElement(MakePayment_Button);
		if(isElementVisible(balanceInfo))
			System.out.println(balanceInfo);
		switchToFrame("id;pciIframe");
		sleep(5);
		if(isElementVisible(checkImage)){
			System.out.println("Check Image is Visible");
			System.out.println("EFT Information Displayed: "+ getText(EFTInfo));
		}
		isElementEnabled(rbCheck);
		type(weRoutingNumber,"0000000"+Keys.TAB);
		if(isElementVisible(invalidInputMsg))
			System.out.println("Invalid Routing Number Message: "+getText(invalidInputMsg));
		clearTextBox(weRoutingNumber);
		type(weRoutingNumber,routingnumber);
		type(weaccountNumber,"1234abcd!@#$"+Keys.TAB);
		if(isElementVisible(invalidInputMsg))
			System.out.println("Invalid Account Number Message: "+getText(invalidInputMsg));
		clearTextBox(weaccountNumber);
		type(weaccountNumber,accountnumber);
		clearTextBox(PaymentAmount);
		type(PaymentAmount, amount);
		clickOnElement(ReviewPayment);
		if(isElementPresent(weVerifyPaymentConfirmation)){
			System.out.println("Review Payment Confirmation Page is displayed");
		}
		else{
			System.out.println("Review Payment Confirmation Page is not displayed");
		}

	}
	
	public void checkingPaymentFutureDate(String routingnumber, String accountnumber, String amount,String FutureDate) {

		
		clickOnElement(OneTimeCheckingSaving);
		clickOnElement(MakePayment_Button);
		if(isElementVisible(balanceInfo))
			System.out.println(balanceInfo);
		switchToFrame("id;pciIframe");
		sleep(5);
		if(isElementVisible(checkImage)){
			System.out.println("Check Image is Visible");
			System.out.println("EFT Information Displayed: "+getText(EFTInfo));
		}
		isElementEnabled(rbCheck);
		type(weRoutingNumber,"0000000"+Keys.TAB);
		if(isElementVisible(invalidInputMsg))
			System.out.println("Invalid Routing Number Message: "+getText(invalidInputMsg));
		clearTextBox(weRoutingNumber);
		type(weRoutingNumber,routingnumber);
		type(weaccountNumber,"1234abcd!@#$"+Keys.TAB);
		if(isElementVisible(invalidInputMsg))
			System.out.println("Invalid Account Number Message: "+getText(invalidInputMsg));
		clearTextBox(weaccountNumber);
		type(weaccountNumber,accountnumber);
		clearTextBox(PaymentAmount);
		type(PaymentAmount, amount);
		BTPage1 bt = new BTPage1(driver);
		bt.selectFutureDate(FutureDate);
		clickOnElement(ReviewPayment);
		if(isElementPresent(weVerifyPaymentConfirmation)){
			System.out.println("Review Payment Confirmation Page is displayed");
		}
		else{
			System.out.println("Review Payment Confirmation Page is not displayed");
		}

	}

	public void Savingspayment(String routingnumber, String accountnumber, String amount){

		sleep(20);
		clickOnElement(OneTimeCheckingSaving);
		clickOnElement(MakePayment_Button);
		if(isElementVisible(balanceInfo))
			System.out.println(balanceInfo);
		switchToFrame("id;pciIframe");
		sleep(5);
		if(isElementVisible(checkImage)){
			System.out.println("Check Image is Visible");
			System.out.println("EFT Information Displayed: "+getText(EFTInfo));
		}

		clickOnElement(rbSaving);
		type(weRoutingNumber,"0000000"+Keys.TAB);
		if(isElementVisible(invalidInputMsg))
			System.out.println("Invalid Routing Number Message: "+getText(invalidInputMsg));
		clearTextBox(weRoutingNumber);
		type(weRoutingNumber,routingnumber);
		type(weaccountNumber,"1234abcd!@#$"+Keys.TAB);
		if(isElementVisible(invalidInputMsg))
			System.out.println("Invalid Account Number Message: "+getText(invalidInputMsg));
		clearTextBox(weaccountNumber);
		type(weaccountNumber,accountnumber);
		clearTextBox(PaymentAmount);
		type(PaymentAmount, amount);

		clickOnElement(ReviewPayment);
		if(isElementPresent(weVerifyPaymentConfirmation)){
			System.out.println("Review Payment Confirmation Page is displayed");
		}
		else{
			System.out.println("Review Payment Confirmation Page is not displayed");
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
		wait(Until.elementToBeDisplayed(AutopayDC));
		clickOnElement(AutopayDC);
		clickOnElement(EnrollBtn);
		switchToFrame("id;pciIframe");
		EnterCardDetails(cardtype,cardNumber,expMonth,expYear);
		clickOnElement(ReviewPayment);

	}

	public boolean Autopay_CC(String cardtype,String cardNumber,String expMonth,String expYear){

		boolean retVal=false;
		wait(Until.elementToBeDisplayed(AutopayCC));
		clickOnElement(AutopayCC);
		clickOnElement(EnrollBtn);
		switchToFrame("id;pciIframe");
		EnterCardDetails(cardtype,cardNumber,expMonth,expYear);
		clickOnElement(ReviewPayment);
		return retVal;
	}

	public void Autopay_checking(String routingnumber, String accountnumber){
		wait(Until.elementToBeDisplayed(AutopayCS));
		clickOnElement(AutopayCS);
		clickOnElement(EnrollBtn);
		switchToFrame("id;pciIframe");
		sleep(5);
		isElementEnabled(rbCheck);
		type(weRoutingNumber,routingnumber);
		type(weaccountNumber,accountnumber);
		clickOnElement(ReviewPayment);
	}

	public void Autopay_saving(String routingnumber, String accountnumber){
		wait(Until.elementToBeDisplayed(AutopayCS));
		clickOnElement(AutopayCS);
		clickOnElement(EnrollBtn);
		switchToFrame("id;pciIframe");
		sleep(5);
		clickOnElement(rbSaving);
		type(weRoutingNumber,routingnumber);
		type(weaccountNumber,accountnumber);
		clickOnElement(ReviewPayment);
	}

	public boolean Manage_BillDelivery(){

		boolean retVal=true;
		clickOnElement(BillDeliveryOptions);
		System.out.println("Bill Delivery Mode Selected: Online Bill");
		sleep(5);
		setCheckBox(PaperOnlineBill, true);
		System.out.println("Changed the Bill Delivery Mode to Paper and Online Bill");
		wait(Until.elementToBeClickable(btnChange));
		clickOnElement(btnChange);
		sleep(5);
		clickOnElement(WeOK);
		MyAccountPage MAPage = new MyAccountPage(driver);
		MAPage.loadBillingAndTransactionSection();
		clickOnElement(BillDeliveryOptions);
		System.out.println("Bill Delivery Mode Selected: Online Bill");
		sleep(5);
		setCheckBox(OnlineBill, true);
		System.out.println("Changed the Bill Delivery Mode to Paper and Online Bill");
		wait(Until.elementToBeClickable(btnChange));
		clickOnElement(btnChange);

		if(isElementVisible("xpath;//*[@class='modal-content']")){
			if(getText("xpath;//*[@class='modal-content']").contains("Success"))
				retVal=true;
		}
		sleep(5);
		clickOnElement(WeOK);
		return retVal;
	}

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

		//switchToFrame("id;pciIframe");
		sleep(15);
		wait(Until.elementToBeDisplayed(rbbtCancel));
		clickOnElement(rbbtCancel);
		wait(Until.elementToBeDisplayed(btAutoCancel));
		clickOnElement(btAutoCancel);
		//switchToDefaultContent();
		wait(Until.elementToBeDisplayed(btnYES));
		clickOnElement(btnYES);
		sleep(10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(!isElementVisible(rbbtCancel)){
			System.out.println("Cancel Autopay button is not visible after Autopay cancellation");
		}
		/*if(isElementVisible(WeOK)){
			sleep(5);
			clickOnElement(WeOK);
		}*/
	}

	public void Retain_Autopay(){

		//switchToFrame("id;pciIframe");
		wait(Until.elementToBeDisplayed(rbbtCancel));
		clickOnElement(rbbtCancel);
		clickOnElement(btAutoCancel);
		//switchToDefaultContent();
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
		wait(Until.elementToBeDisplayed(PHExpand));
		clickOnElement(PHExpand);
		sleep(5);
		if(isElementPresent(PaymentDate)){
			clickOnElement(PHCollapse);
			System.out.println("Payment History hidden");
			retVal=true;
		}
		clickOnElement(PHExpand);
		System.out.println("Payment History Expanded");
		clickOnElement(PHViewmorelink);
		sleep(5);
		if(isElementPresent(wePH)){
			retVal=true;
		}
		return retVal;
	}


	public boolean Payment_History_Section(){

		boolean retVal=false;
		wait(Until.elementToBeClickable(PHExpand));
		clickOnElement(PHExpand);
		sleep(5);
		if(isElementPresent(PaymentDate)){
			int rowCount=driver.findElements(By.xpath("//table[@ng-show='payments.show']//tbody/tr[@class='ng-scope']")).size();
			System.out.println("Payment History record count: " +rowCount );
		}
		if(isElementPresent(PHViewmorelink)){
			clickOnElement(PHViewmorelink);
			sleep(5);
			System.out.println("Payment Info: ");
			for(int i=1;i<9;i++){
			System.out.println(getText("xpath;(//tr/td[@class='ng-binding'])["+i+"]"));
			if(i==4 || i==8)
				System.out.println("");
			}
			wait(Until.elementsToBeDisplayed(wePH));
			int rowCount1=driver.findElements(By.xpath("//tbody/tr")).size();
			System.out.println("View More Payment History record count: " +rowCount1 );
		}

		retVal =true;
		return retVal;
	}
	public boolean Recent_Transactions(){
		boolean retVal=false;
		wait(Until.elementToBeClickable(RTExpand));
		clickOnElement(RTExpand);
		sleep(5);
		if(isElementPresent(weDatarow1)){
			clickOnElement(RTCollapse);
			retVal=true;
		}
		clickOnElement(RTExpand);
		wait(Until.elementToBeClickable(RTViewmoreLink));
		clickOnElement(RTViewmoreLink);
		sleep(5);
		if(isElementPresent(weDatarow2)){
			int rowCount=driver.findElements(By.xpath("//table//tbody//tr[@class='ng-scope']")).size();
			if(rowCount<11){
				System.out.println("Not more than 10 transactions since the last statement is displayed");
				retVal=true;
			}
		}
		return retVal;
	}

	public void Recent_Transaction_Section(){

		wait(Until.elementToBeClickable(RTExpand));
		clickOnElement(RTExpand);
		sleep(5);
		if(isElementPresent(weDatarow1)){
			int rowCount=driver.findElements(By.xpath("//table//tbody//tr[@class='ng-scope']")).size();
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
		sleep(5);
		retVal = true;
		return retVal;
	}
	
	public void PCISession15Mins(){
		sleep(950);
		refreshPage();
		if(getCurrentUrl().contains("login")){
			if(isElementVisible("xpath;//*[contains(text(),'Your session has expired due to inactivity')]")){
				System.out.println(getText("xpath;//*[contains(text(),'Your session has expired due to inactivity')]"));
			}
		}
	}
	public boolean NoUpcomingPayments(){
		boolean retVal=false;
		wait(Until.elementToBeClickable(UpcomingPayments));
		clickOnElement(UpcomingPayments);
		if(isElementPresent(noUpcoming))
			retVal = true;
		return retVal;
	}
	
	public void getUpcomingPaymentInfo(){
		wait(Until.elementToBeDisplayed("xpath;(//*[@class='container']/div[2]/div[1]/div[1]/ul)[1]"));
		System.out.println(getText("xpath;(//*[@class='container']/div[2]/div[1]/div[1]/ul)[1]"));
	}

	public boolean ViewCBillLink() throws InterruptedException{
		boolean retVal=false;
		wait(Until.elementToBeDisplayed(ViewCBill));
		clickOnElement(ViewCBill);
		/*String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
			if(!windowHandle.equals(parentWindow))
			{
				driver.switchTo().window(windowHandle);
				sleep(10);
				driver.close(); //closing child window
				driver.switchTo().window(parentWindow);//cntrl to parent window
				sleep(3);
			}
		}*/
		retVal = true;
		return retVal;
	}	
	
	public void printCurrentPDF(){
		String parentWindow = driver.getWindowHandle();
		wait(Until.elementToBeDisplayed(ViewCBill));
		clickOnElement(ViewCBill);
		String[] filepath=new String[] { System.getProperty("user.dir") + File.separator + "AutoIT" + File.separator +"Print.exe",EnvParameters.WEB_BROWSER_TYPE.replaceAll("\\*", "")};
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
			if(!windowHandle.equals(parentWindow))
			{
				driver.switchTo().window(windowHandle);
				sleep(10);
				driver.findElement(By.id("print")).click();
				try {
					Runtime.getRuntime().exec(filepath);
				}
				catch (IOException e) {
					e.printStackTrace();
					System.out.println("Unable to close");
				}
				driver.close(); //closing child window
				driver.switchTo().window(parentWindow);//cntrl to parent window
				sleep(3);
			}
		}
	}

	public boolean viewduedate()throws InterruptedException{

		boolean retVal=false;
		wait(Until.elementToBeDisplayed(ViewDueDate));
		System.out.println(driver.findElement(By.xpath("//*[contains(text(),'Due by')]")).getText().replace("Due by ", ""));
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
	
	public boolean checkCreditAdjustmentValue(){
		boolean retVal = false;
		for(int i=1;i<11;i++){
			String s=(driver.findElement(By.xpath("html/body/div[1]/section/div/div[2]/div/div/div/table/tbody/tr["+i+"]/td[2]"))).getText();
			System.out.println(s);
			if(s.equals("CREDIT TEST ACCT - ADJUSTMENT")){
				String amount = (driver.findElement(By.xpath("html/body/div[1]/section/div/div[2]/div/div/div/table/tbody/tr["+i+"]/td[4]"))).getText();
				System.out.println(amount);
				Character a = amount.charAt(0);
				if (a=='-'){
					retVal = true;
					return retVal;
				}
			}
		}
		return retVal;
	}
	
	public void lastpaymentDetails(){
		sleep(5);
		if(isElementVisible(AmtBalance)){
		System.out.println("Last Payment Amount: "+getText(LPAmt));
		System.out.println("Last payment Date: "+getText(LPDate));
		System.out.println("Last Payment Number: "+getText(LPCard));
		//System.out.println("Last payment Type: "+driver.findElement(By.xpath("//p[@class='last-payment-type ng-binding']")).getText());
		}
	}
	
	public boolean noRecentpayment(){
		boolean retVal=false;
/*		sleep(5);
		if(driver.findElement(By.xpath("//*[contains(text(),'No payments')]")).getText().contains("No payments have been processed for this account. If you have made a payment please allow 24 hours for your account to be updated")){
			System.out.println("Message Displayed on Last Payment section : "+getText("xpath;//*[contains(text(),'No payments')]"));
		}*/
		//wait(Until.elementToBeDisplayed(PaymentHistorySection));
		//clickOnElement(PaymentHistorySection);
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//*[text()='Last Payment']/../p[2]")));
		wait(Until.elementToBeDisplayed("xpath;//*[@section-title='Payment History']//*[contains(@class,'expandable')]"));
		clickOnElement("xpath;//*[@section-title='Payment History']//*[contains(@class,'expandable')]");
		sleep(10);
		if(isElementVisible("xpath;//*[contains(text(),'recent payment activity')]")){
			if(getText("xpath;//*[contains(text(),'recent payment activity')]").contains("Our records do not indicate any recent payment activity posted to your account since your last statement")){
			System.out.println("Message displayed on Payment History section : "+getText("xpath;//*[contains(text(),'recent payment activity')]"));
			retVal=true;
			}
		}
		return retVal;
	}
	
	public boolean AutoPayStatus(){
		boolean retVal=false;
		sleep(5);
		System.out.println("AutoPay Status: "+getText(autopayStatus));
		if(getText(autopayStatus).contains("Enroll Now")){
			clickOnElement(Enrollnow);
			System.out.println("User navigated to Auto Pay Enroll Page: "+driver.getCurrentUrl());
			retVal=true;
		}
		else{
			clickOnElement(Paybill2);
			System.out.println("User navigated to Auto Pay manage Page: "+driver.getCurrentUrl());
			retVal=true;
		}
		return retVal;	
	}
	
	public void GetAutoPayStatus(){
		MyAccountPage myAccPage=new MyAccountPage(driver);
		myAccPage.openMyAccountTab();
		System.out.println("AutoPay Status in Overview Page: "+ getText(autopayStatus));
		myAccPage.loadBillingAndTransactionSection();
		System.out.println("AutoPay Status in Billing Page: "+ getText(autopayStatus));
	}
	
	public boolean BilldeliveryStatus(){
		boolean retVal=false;
		if(isElementPresent(billDeliveryStatus))
			if(driver.findElement(By.xpath("//div[@class='text-status-widget margin-xs-bottom-6 margin-sm-bottom-0']")).getText().contains("Go Green"))
				System.out.println("Current bill delivery option is Paper and Online");
			if(driver.findElement(By.xpath("//div[@class='text-status-widget margin-xs-bottom-6 margin-sm-bottom-0']")).getText().contains("Online Bill"))
				System.out.println("Current bill delivery option is Online Only");
			retVal=true;
		return retVal;
	}
	
	public void PrintTermsCondition() throws IOException{
		wait(Until.elementToBeDisplayed(viewTermsCondition));
		clickOnElement(viewTermsCondition);
		switchToDefaultContent();
		System.out.println("Terms and Conditions are displayed");
		String[] filepath=new String[] { System.getProperty("user.dir") + File.separator + "AutoIT" + File.separator +"Print.exe",EnvParameters.WEB_BROWSER_TYPE.replaceAll("\\*", "")};
		Runtime.getRuntime().exec(filepath);
		sleep(5);
		wait(Until.elementToBeDisplayed(printTerms));
		clickOnElement(printTerms);
		if(EnvParameters.GetPropertyValue("web.browser").equals("*chrome")){
			String parentWindow = driver.getWindowHandle();
			Set<String> handles =  driver.getWindowHandles();
			for(String windowHandle  : handles)
			{
				if(!windowHandle.equals(parentWindow))
				{
					driver.switchTo().window(windowHandle);
					sleep(10);
					driver.close(); //closing child window
					driver.switchTo().window(parentWindow);//cntrl to parent window
					sleep(3);
				}
			}
		}
		System.out.println("Clicked on Print");
		sleep(10);
		wait(Until.elementToBeDisplayed(closeTerms));
		clickOnElement(closeTerms);
		sleep(10);
		System.out.println("Close Terms and Conditions");
		
	}
	
	public void CancelPayment(){
		HomePage hp = new HomePage(driver);
		hp.pagewait();
		System.out.println(getText("xpath;(//*[text()='Payment Date']/../p)[1]"));
		clickOnElement("xpath;(//*[contains(text(),'Cancel Payment')])[1]");
		sleep(5);
		wait(Until.elementToBeDisplayed(WeOK));
		clickOnElement(WeOK);
		sleep(5);
		wait(Until.elementToBeDisplayed(WeOK));
		clickOnElement(WeOK);
		sleep(5);
	}
	
	public void pendingPaymentMsg(){
		if(isElementVisible("xpath;//*[contains(text(),'Does not reflect')]"))
			System.out.println("Pending payment Message: "+getText("xpath;//*[contains(text(),'Does not reflect')]"));
	}
	
	public void pendingPaymentHistory(){
		wait(Until.elementToBeClickable("xpath;//*[@section-title='Payment History']//*[contains(@class,'expandable')]"));
		clickOnElement("xpath;//*[@section-title='Payment History']//*[contains(@class,'expandable')]");
		sleep(5);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd");
		Date date = new Date();
		String date1= dateFormat.format(date);
		wait(Until.elementToBeDisplayed("xpath;(//*[@ng-repeat='payment in payments.recent'])[1]/td[1]"));
		String date2=getText("xpath;(//*[@ng-repeat='payment in payments.recent'])[1]/td[1]").trim();
		String status=getText("xpath;(//*[@ng-repeat='payment in payments.recent'])[1]/td[3]").trim();
		if(date2.equals(date1.trim())){
			if(status.equals("Pending"))
				System.out.println("Transaction success! Pending payment visible in Payment History");
			System.out.println("Payment Date: "+getText("xpath;(//*[@ng-repeat='payment in payments.recent'])[1]/td[1]"));
			System.out.println("Payment Status: "+getText("xpath;(//*[@ng-repeat='payment in payments.recent'])[1]/td[3]"));
		}
	}
	
}


