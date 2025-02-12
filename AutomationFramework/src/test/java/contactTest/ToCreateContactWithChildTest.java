package contactTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtlity.BaseClass;
import genericUtlity.ExcelFileUtility;
import genericUtlity.WebDriverUtility;
import objectRepository.ContactInformationPage;
import objectRepository.ContactsPage;
import objectRepository.CreateContactPage;
import objectRepository.HomePage;

@Listeners(genericUtlity.ListenersImplementation.class)
public class ToCreateContactWithChildTest extends BaseClass {
	
	@Test(groups = "smoke")
	public void toCreateContactChild_005() throws EncryptedDocumentException, IOException {
		
		HomePage hp = new HomePage(driver);
		hp.getContacts().click();
		ContactsPage cp = new ContactsPage(driver);
		cp.getContactLookImage().click();
		CreateContactPage ccp = new CreateContactPage(driver);
		ExcelFileUtility eutil = new ExcelFileUtility();
		String LASTNAME = eutil.toReadDataFromExcel("contacts", 1, 2);
		ccp.getLastnameTextFiled().sendKeys(LASTNAME);
		
		ccp.getContactAddButton().click();
		WebDriverUtility wutil = new WebDriverUtility();
		
		wutil.toSwitchWindow(driver, "Accounts");
		ccp.getOrganizationSubChild().click();
		wutil.toSwitchWindow(driver, "Contacts&action");
		
		ccp.getSaveButton().click();
		ContactInformationPage cip = new ContactInformationPage(driver);
		String lastname = cip.getInformation().getText();
		
		Assert.assertTrue(lastname.contains(LASTNAME));
		Reporter.log(lastname+"--------------passed", true);

		
		
		
	}
	

}
