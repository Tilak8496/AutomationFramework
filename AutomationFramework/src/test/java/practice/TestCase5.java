package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestCase5 {

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

		// step 3: Navigate to contacts link

		driver.findElement(By.linkText("Contacts")).click();
		String parentId = driver.getWindowHandle();

		// Step 4: Click on create contact look image

		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		// Step 5: Create contact with mandatory fileds
		driver.findElement(By.name("lastname")).sendKeys("Tilak L N");

		// Step 6: Select the Organization form Organization look up image

		driver.findElement(By.xpath("//img[@title='Select']")).click();
		Set<String> allIds = driver.getWindowHandles();
		allIds.remove(parentId);
		for (String id : allIds) {
			driver.switchTo().window(id);
			driver.findElement(By.linkText("Grid Logic")).click();

		}
		driver.switchTo().window(parentId);

		// Step 6: Save and verify
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String lastname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (lastname.contains("Tilak L N")) {
			System.out.println(lastname + " -- passed");
		} else {
			System.out.println(lastname += "---failed");
		}

		// Step 7: Logout the application

		WebElement logoutEle = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action = new Actions(driver);
		action.moveToElement(logoutEle).perform();
		driver.findElement(By.linkText("Sign Out")).click();

		// Step 8 :quit
		driver.quit();

	}

}
