package pkg1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class FormPage extends Base {
	public FormPage(WebDriver driver, WebDriverWait wait) {
		       super(driver, wait);
   }
	
	By fullName = By.cssSelector("[aria-label=\"Full Name\"]");
	By email = By.cssSelector("[aria-label=\"Email\"]");
	By password = By.cssSelector("[aria-label=\"Password\"]");
	By joinButton = By.cssSelector("[class=\"_6dgzsvq css-j6v0dd\"]");
	By errorMsg = By.cssSelector("[class=\"css-1dg8j96\"]");
	List<OneRowData> listInfo = new ArrayList<>();
	String fileNameStr = "src/main/java/dataForFormTest.xlsx";

	void runTheTest() throws InterruptedException {
	    readTheExcel(fileNameStr);
	    for (OneRowData curr : listInfo) {
	        insertInfo(curr);
	        Thread.sleep(5000);
	    }
	    writeResultsIntoOurExcel();
	}

	void insertInfo(OneRowData srd) {
		waitUntilElementInteractable(fullName);
		
		type(fullName,srd.fullname);
		type(email, srd.emailAddress);
		type(password, srd.password);
		findElement(joinButton).click();

        String actualResult=getText(errorMsg);
		if (!actualResult.equals(srd.expectedResult)) {
		    srd.actualResult = actualResult;
		    srd.FAIL_PASS = "FAIL";
		} else {
		    srd.actualResult = actualResult;
		    srd.FAIL_PASS = "PASS";
		}
	}
	void readTheExcel(String fileName) {

	    try (FileInputStream f = new FileInputStream(fileName)) {
	        XSSFWorkbook workbook = new XSSFWorkbook(f);

	        XSSFSheet sheet = workbook.getSheetAt(0);

	        Iterator<Row> rowIterator = sheet.iterator();
	        rowIterator.next();

	        while (rowIterator.hasNext()) {
	            OneRowData currSrd = new OneRowData();
	            Row row = rowIterator.next();

	            currSrd.fullname = row.getCell(0).getStringCellValue();
	            currSrd.emailAddress = row.getCell(1).getStringCellValue();
	            currSrd.password = row.getCell(2).getStringCellValue();
	            currSrd.expectedResult = row.getCell(3).getStringCellValue();

	            listInfo.add(currSrd);
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}


	void writeResultsIntoOurExcel() {
	    try (FileInputStream fis = new FileInputStream(fileNameStr);
	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
	         
	        XSSFSheet sheet = workbook.getSheetAt(0);

	        for (int i = 0; i < listInfo.size(); i++) {
	            OneRowData curr = listInfo.get(i);
	            Row row = sheet.getRow(i + 1);

	            Cell resultCell = row.createCell(4);
	            resultCell.setCellValue(curr.actualResult);

	            Cell passFailCell = row.createCell(5);
	            passFailCell.setCellValue(curr.FAIL_PASS);
	        }

	        try (FileOutputStream fos = new FileOutputStream(fileNameStr)) {
	            workbook.write(fos);
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

}
