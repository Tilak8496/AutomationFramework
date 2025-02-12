package organizationTest;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtlity.BaseClass;
import genericUtlity.ExcelFileUtility;
import genericUtlity.WebDriverUtility;
import objectRepository.CreateOrganizationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationInformationPage;
import objectRepository.OrganizationPage;

@Listeners(genericUtlity.ListenersImplementation.class)
public class ToOrganizationDropDownTest extends BaseClass {

	@Test(groups = "regression")
	public void ToCreateOrganizationDropDown() throws EncryptedDocumentException, IOException {

		HomePage hp = new HomePage(driver);
		hp.getOrganizations().click();
		OrganizationPage op = new OrganizationPage(driver);
		op.getOrganizationLookImage().click();

		CreateOrganizationPage cop = new CreateOrganizationPage(driver);

		ExcelFileUtility eutil = new ExcelFileUtility();
		
		Random r = new Random();
		int random = r.nextInt(1000);
		String ORGANIZATIONNAME = eutil.toReadDataFromExcel("contacts", 2, 2)+random;
		cop.getOrganizationName().sendKeys(ORGANIZATIONNAME);

		WebDriverUtility wutil = new WebDriverUtility();

		WebElement dropdown = cop.getIndustryDropDown();
		wutil.toHandleDropDown("Chemicals", dropdown);

		cop.getSaveButton().click();
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String organizationName = oip.getInformation().getText();
		Assert.assertTrue(organizationName.contains(ORGANIZATIONNAME));
		Reporter.log(organizationName + "--------------passed", true);

	}

}
