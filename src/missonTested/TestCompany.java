package missonTested;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import missionEnded.Home;
import missionEnded.SpinachCompany;

public class TestCompany {
	public static WebDriver driver;
	public static final String URL = "https://www.humanity.com/";
	public static final String SPINACHURL ="https://spinach.humanity.com/app/dashboard/";
	public static final String POPUPANNOUC_XPATH = "/html/body/div[2]/div/div/div[1]/button";
	public static final String COOKIES_XPATH = "/html/body/div[9]/div/div/div/div[2]/div[2]/div[1]/button";
	
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Home.existingUser(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actual= driver.getCurrentUrl();
		String expected = "https://spinach.humanity.com/app/dashboard/";
		Assert.assertEquals(actual, expected);
}
	
	@Test (priority = 4)
	public void testReport () {
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		SpinachCompany.reports(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actual= driver.getCurrentUrl();
		String expected = "https://spinach.humanity.com/app/reports/dashboard/";
		Assert.assertEquals(actual, expected);
	}
	
	@Test (priority = 5)
	public void testPayroll () {
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		SpinachCompany.payroll(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actual= driver.getCurrentUrl();
		String expected = "https://spinach.humanity.com/app/payroll/scheduled-hours/";
		Assert.assertEquals(actual, expected);
}
	@Test (priority = 6)
	public void testStaff() {
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		SpinachCompany.staff(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actual= driver.getCurrentUrl();
		String expected = "https://spinach.humanity.com/app/staff/list/load/true/";
		Assert.assertEquals(actual, expected);
	}
	@Test (priority = 7)
	public void testTraining() {
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		SpinachCompany.training(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actual= driver.getCurrentUrl();
		String expected = "https://spinach.humanity.com/app/training/";
		Assert.assertEquals(actual, expected);
	}
	@Test (priority = 8)
	public void testLeave() {
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		SpinachCompany.leave(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actual= driver.getCurrentUrl();
		String expected = "https://spinach.humanity.com/app/requests/vacation/";
		Assert.assertEquals(actual, expected);
	}
	@Test (priority = 9)
	public void testClock() {
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		SpinachCompany.clock(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actual= driver.getCurrentUrl();
		String expected = "https://spinach.humanity.com/app/timeclock/";
		Assert.assertEquals(actual, expected);
	}
	@Test (priority = 10)
	public void testShift() {
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		SpinachCompany.shift(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actual= driver.getCurrentUrl();
		String expected = "https://spinach.humanity.com/app/schedule/employee/week/overview/overview/25%2c1%2c2021/";
		Assert.assertEquals(actual, expected);
	}
	@Test (priority = 11)
	public void testDashboard() {
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		SpinachCompany.dashboard(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actual= driver.getCurrentUrl();
		String expected = "https://spinach.humanity.com/app/dashboard/";
		Assert.assertEquals(actual, expected);
	}
	@Test (priority = 12)
	public void testAvailability() {
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		SpinachCompany.availability(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actual= driver.getCurrentUrl();
		String expected = "https://spinach.humanity.com/fe/availability/";
		Assert.assertEquals(actual, expected);
	}
	
	}

