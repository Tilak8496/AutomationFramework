package objectRepository;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {

	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement OrganizationName;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	@FindBy(name = "industry")
	private WebElement industryDropDown;

	@FindBy(name = "accounttype")
	private WebElement typeDropDown;
	
	Random rd = new Random();
	public int random=rd.nextInt(1000);

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getOrganizationName() {
		return OrganizationName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

}
