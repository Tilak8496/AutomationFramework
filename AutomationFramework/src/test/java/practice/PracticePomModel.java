package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtlity.ExcelFileUtility;
import genericUtlity.PropertyFileUtility;
import genericUtlity.WebDriverUtility;
import objectRepository.ContactInformationPage;
import objectRepository.ContactsPage;
import objectRepository.CreateContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class PracticePomModel {
	public static void main(String[] args) throws IOException {

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

		// to maximze and and implesit wait
		wutil.toMaximize(driver);
		wutil.towaitForElements(driver);

		// To read data form POM model

		LoginPage lp = new LoginPage(driver);

		driver.get(URL);
		lp.getUsernameTextField().sendKeys(USERNAME);
		lp.getPasswordTextField().sendKeys(PASSWORD);
		lp.getSubmitButton().click();

		// step 3: Navigate to contacts link

		HomePage hp = new HomePage(driver);
		hp.getContacts().click();

		// Step 4: Click on create contact look image

		ContactsPage cp = new ContactsPage(driver);
		cp.getContactLookImage().click();

		// Step 5: Create contact with mandatory fileds

		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.getLastnameTextFiled().sendKeys(LASTNAME);
		ccp.getSaveButton().click();

		// Step 6: Save and verify

		ContactInformationPage cip = new ContactInformationPage(driver);
		String lastname = cip.getInformation().getText();
		if (lastname.contains(LASTNAME)) {
			System.out.println(lastname + " -- passed");
		} else {
			System.out.println(lastname += "---failed");
		}

		// Step 7: Logout the application

		wutil.toMouseHover(driver, hp.getAdmin());
		hp.getSignout().click();

		// Step 8:Close the Browser
		driver.quit();

	}

}
