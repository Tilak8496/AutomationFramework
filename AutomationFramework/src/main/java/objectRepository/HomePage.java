package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Organizations")
	private WebElement organizations;

	@FindBy(linkText = "Contacts")
	private WebElement contacts;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement admin;

	@FindBy(linkText = "Sign Out")
	private WebElement signout;

	public WebElement getOrganizations() {
		return organizations;
	}

	public WebElement getContacts() {
		return contacts;
	}

	public WebElement getAdmin() {
		return admin;
	}

	public WebElement getSignout() {
		return signout;
	}

}
