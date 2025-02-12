package genericUtlity;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class containes method related to excel file
 */

public class ExcelFileUtility {
	/**
	 * This method to read data form excel file.
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public String toReadDataFromExcel(String sheetname, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IconstantUtility.execelFilepath);
		Workbook wb =  WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetname).getRow(row).getCell(cell).toString();
		return value;

	}

}
