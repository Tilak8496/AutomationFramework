package genericUtlity;
/*
 * 
 */

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/**
	 * \ this method is used to maximize
	 * 
	 * @param driver
	 */
	public void toMaximize(WebDriver driver) {
		driver.manage().window().maximize();

	}

	/**
	 * This method is ued to minimize
	 * 
	 * @param driver
	 */
	public void toMinimize(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * This method will wait untill webelements loaded in webpages(implict wait)
	 * 
	 * @param driver
	 */

	public void towaitForElements(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	/**
	 * this method is used to wait until element to be clikable provided driver and
	 * element
	 * 
	 * @param driver
	 * @param element
	 */
	public void toWaitUntilElementIsClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * this method is used to wait until element to be visible provided driver and
	 * element
	 * 
	 * @param driver
	 * @param element
	 */
	public void toWiatForVisibilityOfElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method used to handle dropdown using index
	 * 
	 * @param element
	 * @param index
	 */
	public void toHandleDropDown(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * This method used to handle dropdown by using value
	 * 
	 * @param element
	 * @param value
	 */
	public void toHandleDropDown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * This method is used to handle dropdown using visibleText
	 * 
	 * @param text
	 * @param element
	 */
	public void toHandleDropDown(String text, WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/**
	 * This methos used to handle frame using index
	 * 
	 * @param driver
	 * @param index
	 */
	public void toHandleFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method used to handle frame using id or name
	 * 
	 * @param driver
	 * @param name_id
	 */
	public void toHandleFrame(WebDriver driver, String name_id) {
		driver.switchTo().frame(name_id);
	}

	/**
	 * This method is used to handle frame using webelement
	 * 
	 * @param driver
	 * @param element
	 */
	public void toHandleFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * This method is use to switch back the driver control to main page
	 * 
	 * @param driver
	 */
	public void toSwitchBackFromFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * This method is used to mouse hover on the element (mouse action)
	 * 
	 * @param driver
	 * @param element
	 */
	public void toMouseHover(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();

	}

	/**
	 * This method is use to perform double click
	 * 
	 * @param driver
	 * @param element
	 */
	public void toDoubleClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	/**
	 * This method is used to perform right click
	 * 
	 * @param driver
	 * @param element
	 */
	public void toRightClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	/**
	 * This method is used to perform drag and drop provided driver, sourse element
	 * and raget element
	 * 
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void toDragAndDrop(WebDriver driver, WebElement src, WebElement target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(src, target);
	}

	/**
	 * This method is used to perform click and hold
	 * 
	 * @param driver
	 * @param element
	 */
	public void toClickandHold(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.clickAndHold(element).perform();
	}

	/**
	 * This method is used to handle alert popup using accepting (OK buton)
	 * 
	 * @param driver
	 */
	public void toHandleAlertPopupByAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * This method is used to handle alert popup by dismissig it (cancel button)
	 * 
	 * @param driver
	 */
	public void toHandleAlertPopupByDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This Method is used to capture mesage in alert popop and accept it.
	 * 
	 * @param driver
	 * @return
	 */
	public String toHandleAlertPopupAndCaptureTest(WebDriver driver) {
		Alert alertPopup = driver.switchTo().alert();
		String popupMsg = alertPopup.getText();
		alertPopup.accept();
		return popupMsg;
	}

	/**
	 * This method is used to take screenshot provided driver anf screenshot names
	 * 
	 * @param driver
	 * @param screenshotname
	 * @throws IOException
	 */
	public String toTakeScreenShot(WebDriver driver, String screenshotname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File src = new File("./errorShots/" + screenshotname + ".jpg");
		FileHandler.copy(temp, src);
		return src.getAbsolutePath();

	}

	/**
	 * This method is used to transfer driver control to windows provided driver anf
	 * partial tile
	 * 
	 * @param driver
	 * @param partialTitle
	 */
	public void toSwitchWindow(WebDriver driver, String partialTitle) {

		Set<String> allIds = driver.getWindowHandles();
		for (String id : allIds) {
			String windowTitle = driver.switchTo().window(id).getTitle();
			if (windowTitle.contains(partialTitle)) {
				break;
			}
		}
	}

}
