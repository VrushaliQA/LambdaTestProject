package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FirstPage {
	private WebDriver driver;
	Logger logger=Logger.getLogger(FirstPage.class.getName());
	
	@FindBy(xpath="//div[@id=\"m_class\"]/following-sibling::*")            
	WebElement signUp;

	/**
	 * This class constructor takes the driver reference from FirstPageTest class
	 * initializes the PageFactory and assigns driver instance to private WebDriver reference of this class  
	 * @param driver reference from FirstPageTest class
	 */
	public FirstPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
/**
 * This method clicks on SignUp link 
 * This method demonstrate use of JavaScript Exceutor 
 * The issue I faced here is that in headless browser many times this web element could not b found
 * so by violating POM framework rule I have not used Page object in action method
 * @return Registration Page Object
 */
	
	public RegisterPage clickOnSignUp()
	{
		//signUp.click();
		//driver.findElement(By.xpath("//div[@id=\"m_class\"]/following-sibling::*")).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement signOn=(WebElement)js.executeScript("return  document.querySelector(\"a[href='https://accounts.lambdatest.com/register']\")");
		signOn.click();
		logger.trace("clicking on Sign in");
		return new RegisterPage(driver);
	}
	

}
