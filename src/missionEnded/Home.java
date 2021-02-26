package missionEnded;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
//import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Rectangle;



public class Home {


private static WebDriver driver;

		public static final String URL = "https://www.humanity.com/";
		public static final String POPUPANNOUC_XPATH = "/html/body/div[2]/div/div/div[1]/button";
		public static final String COOKIES_XPATH = "/html/body/div[9]/div/div/div/div[2]/div[2]/div[1]/button";
		public static final String RIGHTCLICK_XPATH = "//*[@id=\"navbarSupportedContent\"]/div/a[3]";
		public static final String CLICK_XPATH = "/html/body/div[7]";
		public static final String WELCOME_XPATH ="/html/body/div/div/div/div[1]/div/div/span";
		public static final String ABOUTUS ="/html/body/div[1]/header/div[1]/div/div/div/nav/div[2]/ul/li[6]/a";
		public static final String USERNAME_XPATH = "//*[@id=\"top-form\"]/div/div[1]/input"; 
		public static final String PASSWORD_XPATH = "//*[@id=\"top-form\"]/div/div[2]/input";
		public static final String TXTBTN_XPATH ="/html/body/div[1]/header/div[2]/div/div/div/div/form/div/div[3]/input";
		public static final String INFO = "data.xlsx";
		
		public static void goTo (WebDriver driver, String address) {
			driver.navigate().to(URL);
		} 
		public static void pressPopUp (WebDriver driver) {
			WebElement btn  = driver.findElement(By.xpath(POPUPANNOUC_XPATH));
			btn.click();
		}
		public static void pressCookies (WebDriver driver) {
			WebElement btn  = driver.findElement(By.xpath(COOKIES_XPATH));
			btn.click();
		}
		public static void registerName (WebDriver driver) {
			WebElement username  = driver.findElement(By.xpath(USERNAME_XPATH));
			username.click();
			username.sendKeys("Duskic Duskic");
		}
		public static void registerWorkemail (WebDriver driver) {
			WebElement workEmail = driver.findElement(By.xpath(PASSWORD_XPATH));
			workEmail.click();
			workEmail.sendKeys("saRgarepa@njam.na");
		}
		public static void pressBtn (WebDriver driver) {
			WebElement btn  = driver.findElement(By.xpath(TXTBTN_XPATH));
			btn.click();
		}
		public static String readIt(String f, int r, int c) {
			
			File d = new File(f);
			InputStream inp=null;
			try {
				inp = new FileInputStream(d);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			XSSFWorkbook wb=null;
			try {
				wb = new XSSFWorkbook(inp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Sheet sheet1 = wb.getSheetAt(0);
			Row row = sheet1.getRow(r);
			Cell cell = row.getCell(c);
			String kredencijal = cell.getStringCellValue();
			
			return kredencijal.toString();
		}

			public static void rightClick (WebDriver driver) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				WebElement btn  = driver.findElement(By.xpath(RIGHTCLICK_XPATH));
				btn.click();
				WebElement we = driver.findElement(By.xpath("//*[@id=\"popup-form\"]/div[1]/input"));
				we.click();
				we.sendKeys("Pajce Zmajce");
				WebElement we1 = driver.findElement(By.xpath("//*[@id=\"popup-form\"]/div[2]/input"));
				we1.click();
				we1.sendKeys("zmajce@yahoo.com");
				driver.findElement(By.xpath("//*[@id=\"popup-free-trial-link\"]")).click();
			}
			public static void screen(WebDriver driver, String n) {
				try {
		            Robot robot = new Robot();
		            String format = "jpg";
		            String fileName = n + format;
		            
		            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
		            ImageIO.write(screenFullImage, format, new File(fileName));
		        } catch (AWTException | IOException ex) {
		            System.err.println(ex);
		        }
				
			}
			public static void aboutUs (WebDriver driver) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				//WebElement btn  = driver.findElement(By.xpath(ABOUTUS));
				//btn.click();
				driver.navigate().to("https://www.humanity.com/about"); 
				screen(driver, "aboutus.");
			}
			public static void existingUser (WebDriver driver) {
				driver.navigate().to(URL);
				WebElement btn  = driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/div/div/nav/div[2]/div/a[2]/p"));
				btn.click();
				
				WebElement name = driver.findElement(By.xpath("//*[@id=\"email\"]"));
				name.click();  
				name.sendKeys("olivapopaj@yahoo.com");
				
				WebElement pass = driver.findElement(By.xpath("//*[@id=\"password\"]"));
				pass.click();  
				pass.sendKeys("Olivap");
				driver.findElement(By.xpath("//*[@id=\"LoginForm\"]/div[3]/div/button[1]")).click();
		
				
}
}