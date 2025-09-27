package Validations;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;







public class ValidationsForUserPages {

	private static Workbook workbook;
	public static void readData() throws IOException {

	FileInputStream fi= new FileInputStream("D:\\UserPageLoginData.xlsx");
	//to specify workbook
	//workbook= new XSSFWorkbook(fi);
	 workbook = WorkbookFactory.create(fi);
	}
	public static String getCellData(String sheetName, int row, int col){
	//to specify worksheet
	    Sheet sheet = workbook.getSheet(sheetName);
	    Row r = sheet.getRow(row);
        Cell c = r.getCell(col);
        return c.toString();
	}
        public static int getRowCount(String sheetName) {
           Sheet sheet = workbook.getSheet(sheetName);
            return sheet.getLastRowNum();
        }
  
}


