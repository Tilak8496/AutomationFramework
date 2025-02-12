package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestCase2 {

	public static void main(String[] args) {
		
		// Step 1: Lunch Browser

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Step 1: Login to Application with valid credentials
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();

		// step 3: Navigate to Organization link

		driver.findElement(By.linkText("Organizations")).click();

		// Step 4: Click on create Organization look up image

		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		// Step 5: Create Organization with mandatory fileds
		driver.findElement(By.name("accountname")).sendKeys("Grid Logic");

		// Step 6: Save and verify
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String orgname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (orgname.contains("Grid Logic")) {
			System.out.println(orgname + " -- passed");
		} else {
			System.out.println(orgname += "---failed");
		}

		// Step 7: Logout the application

		WebElement logoutEle = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action = new Actions(driver);
		action.moveToElement(logoutEle).perform();
		driver.findElement(By.linkText("Sign Out")).click();

		driver.quit();

	}

}
