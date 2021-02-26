package missonTested;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.io.Closer;

import missionEnded.Home;
public class TestUser {
		
public static WebDriver driver;
public static final String URL = "https://www.humanity.com/";
public static final String value = "Spinach";
public static final String numero = "77777";
public static final String pass = "nemamTiKad";
	
	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "E:\\IT Bootcamp\\Programi za kurs\\chromedriver_win32\\ChromeDriver.exe");
		driver = new ChromeDriver();
}
	@Test(priority = 1)
	public void testSearch() {
		Home.goTo(driver, URL);
		String current = driver.getCurrentUrl();
		String expected = URL;
		Assert.assertEquals(current, expected);
	}
	
	@Test(priority = 2)
	public void closePops() {
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		Home.pressPopUp(driver);
		Home.pressCookies(driver);
		
		String current = driver.getCurrentUrl();
		String expected = URL;
		
		Assert.assertEquals(current, expected);
	}
	@Test (priority = 3)
	public void testAboutUs() {
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		Home.aboutUs(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actual= driver.getCurrentUrl();
		String expected = "https://www.humanity.com/about";
		Assert.assertEquals(actual, expected);
		
	}
	@Test (priority = 4)
	public void testMainSignIn() {
		driver.navigate().to(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Home.registerName(driver);
		Home.registerWorkemail(driver);
		Home.pressBtn(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String current = driver.getCurrentUrl();
		String expected = "https://www.humanity.com/wizard-setup2/";
		Assert.assertEquals(current, expected);
}
	@Test (priority = 5)
	public void testLogIn2() {
		driver.navigate().to(URL);
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		Home.rightClick(driver);
		String actual= driver.getCurrentUrl();
		String expected = "https://www.humanity.com/wizard-setup2/";
		Assert.assertEquals(actual, expected);
	
}
	@Test (priority = 6)
	public void testExistingUser() {
		driver.navigate().to(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Home.existingUser(driver);
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actual= driver.getCurrentUrl();
		String expected = "https://spinach.humanity.com/app/dashboard/";
		Assert.assertEquals(actual, expected);
	}
}