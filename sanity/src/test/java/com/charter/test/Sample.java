package com.charter.test;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.charter.page.AuthenticationPage;
import com.charter.page.BTPage1;
import com.charter.page.BasicAuthenticaion;
import com.charter.page.BillingAndTransactionsPage;
import com.charter.page.HomePage;
import com.charter.page.InternetServicesPage;
import com.charter.page.MyAccountPage;
import com.charter.page.OverviewPage;
import com.charter.page.TVServicesPage;
import com.charter.page.UserPreferencePage;
import com.charter.page.VoiceServicesPage;
import com.charter.utils.Constants;
import com.charter.utils.DataProviderClass;
import com.cognizant.framework.core.ReadFromExcel;
import com.cognizant.framework.core.TestNGBase;

public class Sample extends TestNGBase {
	
	private String URL= Constants.URL;
	
	@Test(dataProvider="TestDataCharter", dataProviderClass = DataProviderClass.class)
	public void TC13_Validate_OverviewPage_AvatarImagesViewProfile_HOHUser(Map<String,String> testdata) throws Exception{

		String username = testdata.get("UserID");
		String password = testdata.get("UserPassword");

		HomePage hp=new HomePage(driver);
		hp.loadCharterPage(URL);
		hp.login(username, password );  
		MyAccountPage MAPage=new MyAccountPage(driver);
		MAPage.openMyAccountTab();
		MAPage.loadOverviewPage();
		WebElement wHOH= driver.findElement(By.xpath("(//*[@class='user-avatar']/img)[1]"));
		wHOH.click();
		WebElement wStandard=driver.findElement(By.xpath("(//*[@class='user-avatar']/img)[2]"));
		wStandard.click();
		WebElement wAdmin=driver.findElement(By.xpath("(//*[@class='user-avatar']/img)[3]"));
		wAdmin.click();
		//OverviewPage OVpage=new OverviewPage(driver);
		//Assert.assertTrue(OVpage.AvatarImages(), "User is not able to view profiles on clicking Avatar Images in overview page");
		hp.logoutApplication();
	}

}

