package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement information;
	
	@FindBy(xpath = "//span[@class='small']")
	private WebElement small;
	

	public WebElement getSmall() {
		return small;
	}


	public WebElement getInformation() {
		return information;
	}
	

}
