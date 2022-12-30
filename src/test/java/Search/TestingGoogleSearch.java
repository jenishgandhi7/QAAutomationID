package Search;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestingGoogleSearch {
	WebDriver driver;
	@BeforeTest
	public void browserSetup() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@Test(dataProvider="searchDataValue")
	public void testFlow(String serchvInput) {
		driver.get("https://www.google.com/");  //Visit to Google.com
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(serchvInput);
		List<WebElement> list = driver.findElements(By.tagName("li"));
		for(WebElement s1:list) {
			System.out.println("google Search by "+serchvInput);

			if(s1.getText().equalsIgnoreCase(serchvInput)) {
				System.out.println("google Search by "+serchvInput);
				Assert.assertTrue(s1.getText().equalsIgnoreCase(serchvInput));
				s1.click();
			}
			
		}
		
	}
	@DataProvider(name="searchDataValue")
	public Object[][] searchDataValue(){
		return new Object[][] 
		{
			{"India national cricket team"},
			{"Tesla"},
			{"Austin"}
		};
	}
	
	@AfterTest
	public void AfterSetup() {
		driver.close();
	}
	
	

}
