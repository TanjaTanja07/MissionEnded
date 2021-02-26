package missonTested;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import missionEnded.Home;
import missionEnded.SpinachCompany;

public class TestEmployees {
	public static WebDriver driver;
	public static final String URL = "https://www.humanity.com/";
	
	
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
	public void testExistingUser() {
		driver.navigate().to(URL);
		driver.manage().window().maximize();
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
	@Test (priority = 4)
	public void testAddStaff() {
		driver.navigate().to("https://spinach.humanity.com/app/staff/list/load/true/");
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		SpinachCompany.addEmployee(driver, "Aca", "Alas", "dunavska4@ha.com");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actual= driver.getCurrentUrl();
		String expected = "https://spinach.humanity.com/app/staff/add/";
		Assert.assertEquals(actual, expected);
	}
		@Test (priority = 5)
		public void testChangeName() {
			driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
			SpinachCompany.changeName(driver, "Talas");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String actual= driver.getCurrentUrl();
			String expected = "https://spinach.humanity.com/app/staff/edit/6089013/";
			Assert.assertEquals(actual, expected);
	}
		@Test (priority = 6)
		public void testChangePicture() {
			driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
			SpinachCompany.setPicture(driver);
		}
		@Test (priority = 7)
		public void testExcelAdding() {
			driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
			SpinachCompany.newUserFromApache(driver, "data.xlsx");	
}
		@Test (priority = 8)
		public void testChangeProfile() {
			driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
			SpinachCompany.changeProfile(driver, "Olivija");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String actual= driver.getCurrentUrl();
			String expected = "https://spinach.humanity.com/app/staff/edit/6089013/";
			Assert.assertEquals(actual, expected);
		}
		}
	/*	@Test (priority = 10)
		public void testNotifications() {
			driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
			SpinachCompany.settingsBtn(driver);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			String actual= driver.getCurrentUrl();
			String expected = "https://spinach.humanity.com/app/admin/settings/";
			Assert.assertEquals(actual, expected); */
	
	
