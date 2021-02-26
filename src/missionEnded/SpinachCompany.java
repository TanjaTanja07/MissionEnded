package missionEnded;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SpinachCompany {
	
	public static final String URL = "https://spinach.humanity.com/app/dashboard/";
	//private static final String POPP_XPATH = "//*[@id=\"intercom-container\"]/div/span/div/div/div/span";
	private static final String DASHBOARD_XPATH ="/html/body/table/tbody/tr/td/div[7]/div/div[2]/ul/li[1]/a/span";
	private static final String SHIFT_XPATH = "//*[@id=\"sn_schedule\"]/span";
	private static final String CLOCK_XPATH = "//*[@id=\"sn_timeclock\"]/span";
	private static final String TRAINING_XPATH = "//*[@id=\"sn_training\"]/span";
	private static final String STAFF_XPATH = "//*[@id=\"sn_staff\"]/span";
	private static final String LEAVE_XPATH = "/html/body/table/tbody/tr/td/div[7]/div/div[2]/ul/li[4]/a/span/p";
	private static final String AVAILABILITY_XPATH = "//*[@id=\"sn_availability\"]/span";
	private static final String PAYROLL_XPATH = "//*[@id=\"sn_payroll\"]/span";
	private static final String REPORTS_XPATH = "//*[@id=\"sn_reports\"]/span";
	private static final String USER = "https://spinach.humanity.com/app/staff/detail/6089013/";
	private static final String PROFILE = "https://spinach.humanity.com/app/staff/detail/6081148/";
	
	public static void nextPage (WebDriver driver) {
		driver.navigate().to(URL);
		
	}
	public static void leave (WebDriver driver) {
		WebElement we = driver.findElement(By.xpath(LEAVE_XPATH));
		we.click();
	}
	/*public static void closePopp (WebDriver driver) {
		WebElement btn  = driver.findElement(By.xpath(POPP_XPATH));
		btn.click();
	}*/
	public static void dashboard (WebDriver driver) {
		driver.navigate().to("https://spinach.humanity.com/app/dashboard/");
		WebElement we = driver.findElement(By.xpath(DASHBOARD_XPATH));
		we.click();
	}
	public static void shift (WebDriver driver) {
		WebElement we = driver.findElement(By.xpath(SHIFT_XPATH));
		we.click();
	}
	public static void clock (WebDriver driver) {
		WebElement we = driver.findElement(By.xpath(CLOCK_XPATH));
		we.click();
}
	public static void training (WebDriver driver) {
		WebElement we = driver.findElement(By.xpath(TRAINING_XPATH));
		we.click();
	}
	public static void staff (WebDriver driver) {
		WebElement we = driver.findElement(By.xpath(STAFF_XPATH));
		we.click();
	}
	public static void payroll (WebDriver driver) {
		WebElement we = driver.findElement(By.xpath(PAYROLL_XPATH ));
		we.click();
	}
	public static void availability (WebDriver driver) {
		WebElement we = driver.findElement(By.xpath(AVAILABILITY_XPATH));
		we.click();
}
	public static void reports (WebDriver driver) {
		WebElement we = driver.findElement(By.xpath(REPORTS_XPATH));
		we.click();
}
	public static void addEmployee (WebDriver driver, String name, String lastName, String eMail) {
		driver.navigate().to("https://spinach.humanity.com/app/staff/list/load/true/");
		WebElement we = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/div[5]/button[3]"));
		we.click();
		WebElement we1 = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/div[9]/div[5]/div[2]/div[2]/div/table/tbody/tr/td/div[2]/table/tbody/tr[2]/td[2]/input"));
		we1.click();
		we1.sendKeys(name);
		WebElement we2 = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/div[9]/div[5]/div[2]/div[2]/div/table/tbody/tr/td/div[2]/table/tbody/tr[2]/td[3]/input"));
		we2.click();
		we2.sendKeys(lastName);
		WebElement we3 = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/div[9]/div[5]/div[2]/div[2]/div/table/tbody/tr/td/div[2]/table/tbody/tr[2]/td[4]/input"));
		we3.click();
		we3.sendKeys(eMail);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement we4 = driver.findElement(By.xpath("//*[@id=\"_as_save_multiple\"]"));
		we4.click();
	}
	
	public static void changeName (WebDriver driver, String name) {
		driver.navigate().to(USER);
		WebElement we = driver.findElement(By.xpath("//*[@id=\"_cd_staff\"]/div[2]/div[2]/div[1]/a[2]"));
		we.click();
		WebElement we1 = driver.findElement(By.xpath("//*[@id=\"first_name\"]"));
		we1.click();
		we1.clear();
		we1.sendKeys(name);
		WebElement we2 = driver.findElement(By.xpath("//*[@id=\"NewEmployeeForm\"]/table/tbody/tr[39]/td/input"));
		we2.click();
	}
	public static void setPicture(WebDriver driver) {
		driver.navigate().to("https://spinach.humanity.com/app/staff/detail/6089053/");
		driver.findElement(By.xpath("//*[@id=\"_cd_staff\"]/div[2]/div[2]/div[1]/a[2]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"fileupload\"]")).sendKeys("E:\\IT Bootcamp\\Programi za kurs\\zavrsniProjekat\\Aca_Talas.jpg");
		driver.findElement(By.xpath("//*[@id=\"NewEmployeeForm\"]/table/tbody/tr[39]/td/input")).click();
	}
	
	public static void newUserFromApache(WebDriver driver, String file) {
		driver.navigate().to("https://spinach.humanity.com/app/staff/list/load/true/");
		WebElement we = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/div[5]/button[3]"));
		we.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		for(int i = 1; i<6 ;i++) {
			WebElement wn = driver.findElement(By.id("_asf"+i));
			wn.sendKeys(Home.readIt(file, i , 0));
			WebElement wl = driver.findElement(By.id("_asl"+i));
			wl.sendKeys(Home.readIt(file, i , 1));
			WebElement wk = driver.findElement(By.id("_ase" +i));
			wk.sendKeys(Home.readIt(file, i , 2));
		}
		//WebElement we4 = driver.findElement(By.xpath("//*[@id=\"_as_save_multiple\"]"));
		//we4.click();
	}
	
	public static void changeProfile (WebDriver driver, String name) {
		driver.navigate().to(PROFILE);
		WebElement we = driver.findElement(By.xpath("//*[@id=\"wrap_us_menu\"]/i"));
		we.click();
		WebElement we1 = driver.findElement(By.xpath("//*[@id=\"_cd_staff\"]/div[2]/div[2]/div[1]/a[2]"));
		we1.click();
		we1.clear();
		we1.sendKeys(name);
		WebElement we2 = driver.findElement(By.xpath("//*[@id=\"first_name\"]"));
		we2.click();

	}
	/*public static void  settingsBtn (WebDriver driver) {
		driver.navigate().to("https://spinach.humanity.com/app/admin/settings/");
		WebElement we = driver.findElement(By.xpath("//*[@id=\"sn_admin\"]/span/p"));
		we.click();
		driver.findElement(By.xpath("//*[@id=\"pref_pref_email\"]")).click();;
		driver.findElement(By.xpath("//*[@id=\"pref_pref_sms\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"pref_pref_mobile_push\"]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//driver.findElement(By.xpath("//*[@id=\"adminSettingsForm\"]/div[1]/table/tbody/tr[3]/td[2]/select")).click();
		//driver.findElement(By.xpath("//*[@id=\"adminSettingsForm\"]/div[1]/table/tbody/tr[3]/td[2]/select/option[6]")).click();
} */
	
}
