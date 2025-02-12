package genericUtlity;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass {

	PropertyFileUtility putil = new PropertyFileUtility();
	ExcelFileUtility eutil = new ExcelFileUtility();
	WebDriverUtility wutil = new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sDriver; //Listeners

	@BeforeSuite(groups = {"smoke","regression"})
	public void bsConfig() {
		Reporter.log("Database connection is established", true);
	}

	
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(groups = {"smoke","regression"})
	public void bcConfig(/*String BROWSER*/) throws IOException {
		String BROWSER = putil.toReadDatFromPropertyFile("browser");
		String URL = putil.toReadDatFromPropertyFile("url");
		if (BROWSER.contains("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.contains("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.contains("firefox")) {
			driver = new FirefoxDriver();
		}
		sDriver=driver; //Listeners
		wutil.toMaximize(driver);
		wutil.towaitForElements(driver);
		driver.get(URL);
		Reporter.log("Url got excuted", true);
	}

	@BeforeMethod(groups = {"smoke","regression"})
	public void bmConfig() throws IOException {
		String USERNAME = putil.toReadDatFromPropertyFile("username");
		String PASSWORD = putil.toReadDatFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.getUsernameTextField().sendKeys(USERNAME);
		lp.getPasswordTextField().sendKeys(PASSWORD);
		lp.getSubmitButton().click();
		Reporter.log("Navigated to Vtiger home page successfully", true);

	}

	@AfterMethod(groups = {"smoke","regression"})
	public void amConfig() {
		HomePage hp = new HomePage(driver);
		wutil.toMouseHover(driver, hp.getAdmin());
		hp.getSignout().click();
		Reporter.log("Succesfully logout has happen", true);
	}

	@AfterClass(groups = {"smoke","regression"})
	public void acConfig() {
		Reporter.log("WebSite got closed", true);
		driver.close();
	}

	@AfterSuite(groups = {"smoke","regression"})
	public void asConfig() {
		Reporter.log("Database got disconnected", true);
	}

}
