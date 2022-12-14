package tests;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseClass;
import commons.DataProviderForRegistration;
import pages.FirstPage;
import pages.RegisterPage;

public class RegisterPageTest extends BaseClass {
	private WebDriver driver;
	private FirstPage objFirstPage;
	private RegisterPage objRegisterPage;
	
	public Logger logger=Logger.getLogger( RegisterPageTest.class.getName());
	
	public RegisterPageTest() {
		super();
	}
	
	/**
	 * This method does the necessary work like creating WebDriver instance and opening the base page URL
	 * and clicking on the SignUp link and opens the Registration page
	 * @param browser taken from testng.xml 
	 */
	@Parameters("Browser")
	@BeforeMethod
	void initRegisterPage(String browser)
	{
		driver=initWebdriver(browser);
		objFirstPage=new FirstPage(driver);
		objRegisterPage=objFirstPage.clickOnSignUp();	
		
	}
	
	@Test
	void testFunctionalFieldCompnyName() 
	{
		boolean functionDisplayed=objRegisterPage.companyNameFieldDisplayed();
		if( functionDisplayed==true)
		{
			System.out.println( "Organization / Company Name  field displayed ");
			logger.info("Organization / Company Name field displayed ");
		}
		else
		{
			System.out.println( "Organization / Company Name field not displayed ");
			logger.error("Organization / Company Name field not displayed ");
		}
		Assert.assertTrue(functionDisplayed);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(enabled=true)
	void testFunctionalFieldFullName() 
	{
		boolean functionDisplayed=objRegisterPage.fullNameFieldDisplayed();
		if( functionDisplayed==true)
		{
			System.out.println( "Full Name field displayed ");
			logger.info("Full Name field displayed ");
		}
		else
		{
			System.out.println( "Full Name field not displayed ");
			logger.error("Full Name field not displayed ");
		}
		Assert.assertTrue(functionDisplayed);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testFunctionalFieldEmailId()
	{
		boolean functionDisplayed=objRegisterPage.businessEmailFieldDisplayed();
	
		if( functionDisplayed==true)
		{
			System.out.println( "businessEmail field displayed: ");
			logger.info("businessEmail field displayed: ");
		}
		else
		{
			System.out.println( "businessEmail field not displayed: ");
			logger.error("businessEmail field not displayed");
		}
		Assert.assertTrue(functionDisplayed);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testFunctionalFieldDesiredPassword()
	{
		boolean functionDisplayed=objRegisterPage.desiredPasswordFieldDisplayed();
		
		if( functionDisplayed==true)
		{
			System.out.println( "Desired Password field displayed ");
			logger.info("Desired Password field displayed ");
		}
		else
		{
			System.out.println( "Desired Password field is not displayed: ");
			logger.error("Desired Password field is not displayed: ");
		}
		Assert.assertTrue(functionDisplayed);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testFunctionalFieldPhoneNumber()
	{
		boolean functionDisplayed=objRegisterPage.phoneFieldDisplayed();
		
		if( functionDisplayed==true)
		{
			System.out.println( "Phone number field displayed ");
			logger.info("Phone number field displayed ");
		}
		else
		{
			System.out.println( "Phone number field is not displayed: ");
			logger.error("Phone number field is not displayed: ");
		}
		Assert.assertTrue(functionDisplayed);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testFunctionalFieldTermsAndPrivacyPolicy()
	{
		boolean functionDisplayed=objRegisterPage.agreementFieldDisplayed();
	
		if( functionDisplayed==true)
		{
			System.out.println( "Terms and Privacy Policy field displayed ");
			logger.info("Terms and Privacy Policy field displayed ");
		}
		else
		{
			System.out.println( "Terms and Privacy Policy field is not displayed");
			logger.error("Terms and Privacy Policy field is not displayed: ");
		}
		Assert.assertTrue(functionDisplayed);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testFunctionalFieldFreeSignUp()
	{
		boolean functionDisplayed=objRegisterPage.freeSignUpButtonDisplayed();
		
	
		if( functionDisplayed==true)
		{
			System.out.println( "Free Signup button displayed ");
			logger.info("Free Signup button displayed ");
		}
		else
		{
			System.out.println( "Free Signup button is not displayed: ");
			logger.error("Free Signup button is not displayed: ");
		}
		Assert.assertTrue(functionDisplayed);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(dataProvider="RegistrationData",dataProviderClass=DataProviderForRegistration.class)
	public void providingValidRegistrationData(Row row)
	{

		String desiredURL="https://accounts.lambdatest.com/email/verify";
		String actualURL=objRegisterPage.registerTheUser(row);
		Assert.assertEquals(actualURL, desiredURL);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test(dataProvider="RegistrationData",dataProviderClass=DataProviderForRegistration.class)
	public void providingblankUserName(Row row)
	{
		
		String desiredMessage="Please enter your name";
		String actualMessage=objRegisterPage.registerTheUserWithBlankFullName(row);
		Assert.assertEquals(actualMessage, desiredMessage);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test(dataProvider="RegistrationData",dataProviderClass=DataProviderForRegistration.class)
	public void providingblankEmail(Row row)
	{

		String desiredMessage="Please enter your email address";
		String actualMessage=objRegisterPage.registerTheUserWithBlankEmail(row);
		Assert.assertEquals(actualMessage, desiredMessage);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test(dataProvider="RegistrationData",dataProviderClass=DataProviderForRegistration.class,enabled=false)
	public void providingRegisteredEmail(Row row)
	{
		String desiredMessage="This Email is already registered";
		String actualMessage=objRegisterPage.registerTheUserExistingkEmail(row);
		Assert.assertEquals(actualMessage, desiredMessage);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(dataProvider="RegistrationData",dataProviderClass=DataProviderForRegistration.class)
	public void providingShortPassword(Row row)
	{
		String desiredMessage="Password should be at least 8 characters long";
		String actualMessage=objRegisterPage.registerTheUserWithShortPassword(row);
		Assert.assertEquals(actualMessage, desiredMessage);
		
	}
	
	@Test(dataProvider="RegistrationData",dataProviderClass=DataProviderForRegistration.class)
	public void providingBlankPhoneNumber(Row row)
	{
		String desiredMessage="Please enter your phone";
		String actualMessage=objRegisterPage.registerTheUserWithBlankPassword(row);
		Assert.assertEquals(actualMessage, desiredMessage);
		
	}
	
	@Test(dataProvider="RegistrationData",dataProviderClass=DataProviderForRegistration.class)
	public void withoutAcceptingTerms(Row row)
	{
		String desiredMessage="You must agree to terms and conditions before continuing";
		String actualMessage=objRegisterPage.registerTheUserWithoutAcceptingTerms(row);
		Assert.assertEquals(actualMessage, desiredMessage);
		
	}
	
	@AfterMethod
	void tearDownRegisterPage()
	{
		//driver.quit();
	}
}
