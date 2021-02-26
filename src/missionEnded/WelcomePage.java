package missionEnded;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WelcomePage {
	
	private static WebDriver driver;

	public static final String URL_NEXTPAGE = "https://www.humanity.com/";
	private static final String COMPANY_XPATH = "//*[@id=\"root\"]/div/div/form/div[1]/div/div[1]/div/div/input";
	private static final String INDUSTRY_XPATH = "/html/body/div/div/div/form/div[1]/div/div[2]/div/div/span";
	public static final String ROLE_XPATH ="/html/body/div/div/div/form/div[1]/div/div[3]/div/div/span";
	public static final String PHONE_XPATH = "//*[@id=\"root\"]/div/div/form/div[1]/div/div[4]/div/input";
	public static final String PASSWORD_XPATH = "//*[@id=\"root\"]/div/div/form/div[1]/div/div[5]/div/input";
	public static final String PASSWORD2_XPATH = "//*[@id=\"root\"]/div/div/form/div[1]/div/div[6]/div/input";
	public static final String BTN_XPATH = "//*[@id=\"root\"]/div/div/form/div[2]/span/input";
	
	public static void nextPage (WebDriver driver) {
		driver.navigate().to(URL_NEXTPAGE);
		
	}
	public static void company (WebDriver driver, String name) {
		WebElement we = driver.findElement(By.xpath(COMPANY_XPATH));
		we.sendKeys(name);
	}
	public static void industry (WebDriver driver, int opt) {
		WebElement we = driver.findElement(By.cssSelector(INDUSTRY_XPATH));
		we.click();
}
	public static void role (WebDriver driver) {
		WebElement we = driver.findElement(By.cssSelector(ROLE_XPATH));
		we.click();
	}

	public static void password (WebDriver driver, String pass) {
		WebElement we = driver.findElement(By.xpath(PASSWORD_XPATH));
		we.click();
		we.sendKeys(pass);
	}
	public static void passwordAgain (WebDriver driver, String pass) {
		WebElement we = driver.findElement(By.xpath(PASSWORD2_XPATH));
		we.click();
		we.sendKeys(pass);
	}
	
	public static void phone (WebDriver driver) {
		WebElement we = driver.findElement(By.xpath(BTN_XPATH));
		we.click();
	}
}