package tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.FirstPage;

/**
 * This Class has Test methods related to First page
 * @author Vrushali
 *
 */
public class FirstPageTest extends BaseClass {

	private WebDriver driver;
	private FirstPage objFirstPage;
	public Logger logger=Logger.getLogger( FirstPageTest.class.getName());
	
	public FirstPageTest() {
		super();
		
	}
	
	/*
	 * This method does the necessary work like creating WebDriver instance and opening the base page URL
	 */
	@Parameters("Browser")
	@BeforeMethod
	void initFirstPage(String browser)
	{
		driver=initWebdriver(browser);
		objFirstPage=new FirstPage(driver);		
	}
	
	@Test
	void test1()
	{
		objFirstPage.clickOnSignUp();
		System.out.println("SignUpPageOpened");
		logger.trace("SignUp Page Opened");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
