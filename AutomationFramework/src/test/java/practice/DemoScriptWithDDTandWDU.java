package practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtlity.ExcelFileUtility;
import genericUtlity.PropertyFileUtility;
import genericUtlity.WebDriverUtility;

public class DemoScriptWithDDTandWDU {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		PropertyFileUtility putil = new PropertyFileUtility();
		ExcelFileUtility eutil = new ExcelFileUtility();
		WebDriverUtility wutil = new WebDriverUtility();

		// Toread data from property file
		String BROWSER = putil.toReadDatFromPropertyFile("browser");
		String URL = putil.toReadDatFromPropertyFile("url");
		String USERNAME = putil.toReadDatFromPropertyFile("username");
		String PASSWORD = putil.toReadDatFromPropertyFile("password");

		// to read data from excel file
		String LASTNAME = eutil.toReadDataFromExcel("Contacts", 1, 2);

		// Automation Script
		// Step 1: launch browser

		WebDriver driver = null;
		if (BROWSER.contains("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.contains("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.contains("firefox")) {
			driver = new FirefoxDriver();
		}

		wutil.toMaximize(driver);
		wutil.towaitForElements(driver);

		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// step 3: Navigate to contacts link

		driver.findElement(By.linkText("Contacts")).click();

		// Step 4: Click on create contact look image

		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		// Step 5: Create contact with mandatory fileds
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);

		// Step 6: Save and verify
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String lastname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (lastname.contains(LASTNAME)) {
			System.out.println(lastname + " -- passed");
		} else {
			System.out.println(lastname += "---failed");
		}

		// Step 7: Logout the application

		WebElement logoutEle = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wutil.toMouseHover(driver, logoutEle);
		driver.findElement(By.linkText("Sign Out")).click();

		// Step 8:Close the Browser
		driver.quit();

	}

}
