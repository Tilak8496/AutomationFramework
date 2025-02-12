package contactTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtlity.BaseClass;
import genericUtlity.ExcelFileUtility;
import objectRepository.ContactInformationPage;
import objectRepository.ContactsPage;
import objectRepository.CreateContactPage;
import objectRepository.HomePage;

@Listeners(genericUtlity.ListenersImplementation.class)
public class ToCreateContactTest extends BaseClass {

	@Test(groups = "smoke")
	public void toCreateContact_001() throws EncryptedDocumentException, IOException {
		HomePage hp = new HomePage(driver);
		hp.getContacts().click();
		ContactsPage cp = new ContactsPage(driver);
		cp.getContactLookImage().click();
		CreateContactPage ccp = new CreateContactPage(driver);
		ExcelFileUtility eutil = new ExcelFileUtility();
		String LASTNAME = eutil.toReadDataFromExcel("contacts", 1, 2);
		ccp.getLastnameTextFiled().sendKeys(LASTNAME);
		ccp.getSaveButton().click();
		// Assert.fail();
		ContactInformationPage cip = new ContactInformationPage(driver);
		String lastname = cip.getInformation().getText();

		Assert.assertTrue(lastname.contains(LASTNAME));
		Reporter.log(lastname + "--------------passed", true);

	}

}
