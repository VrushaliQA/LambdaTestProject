package tests;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestingBasics {
	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		 WebDriver driver=new EdgeDriver();
		 driver.manage().deleteAllCookies();
			 driver.manage().window().maximize();
			 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
			 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			 driver.get("https://www.lambdatest.com/webpage");
			 JavascriptExecutor js=(JavascriptExecutor)driver;
				WebElement signOn=(WebElement)js.executeScript("return  document.querySelector(\"a[href='https://accounts.lambdatest.com/register']\")");
				signOn.click();
				List<WebElement> textBoxes=driver.findElements(By.cssSelector("input[type='text']"));
				for(WebElement e:textBoxes)
				{
					System.out.println(e.getAttribute("placeholder"));
				}
	}
	 

}
