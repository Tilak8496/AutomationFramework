package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {

	public CreateContactPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "lastname")
	private WebElement lastnameTextFiled;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement saveButton;

	@FindBy(xpath = "//img[@title='Select']")
	private WebElement contactAddButton;

	@FindBy(linkText = "Grid Logic")
	private WebElement organizationSubChild;

	public WebElement getOrganizationSubChild() {
		return organizationSubChild;
	}

	public WebElement getContactAddButton() {
		return contactAddButton;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getLastnameTextFiled() {
		return lastnameTextFiled;
	}

}
