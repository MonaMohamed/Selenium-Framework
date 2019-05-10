package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;


public class ExcelUtilsOld {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	
	public Object[][] getTableArray(String FilePath, String SheetName) throws Exception {   
		String[][] tabArray = null;
		try {
				FileInputStream ExcelFile = new FileInputStream(FilePath);
			    // Access the required test data sheet
		     	ExcelWBook = new XSSFWorkbook(ExcelFile);
				ExcelWSheet = ExcelWBook.getSheet(SheetName);
			    int startRow = 1;
		     	int startCol = 0;
				int ci=0,cj=0;
				int totalRows = ExcelWSheet.getLastRowNum();
				// you can write a function as well to get Column count
				int totalCols = 2;
				tabArray=new String[totalRows][totalCols];
				for (int i=startRow;i<totalRows;i++) {           	   
					for (int j=startCol;j<totalCols;j++){
					   tabArray[i][j]=getCellData(i,j);
					   System.out.println(tabArray[i][j]);  
					}
				}
		   }catch (FileNotFoundException e){
				System.out.println("Could not read the Excel sheet");
				e.printStackTrace();
			}
			catch (IOException e){
				System.out.println("Could not read the Excel sheet");
				e.printStackTrace();
			}
			return tabArray;
		}

		public static String getCellData(int RowNum, int ColNum) throws Exception {
			try {
					DataFormatter formatter = new DataFormatter();
					Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);					
					String CellData = formatter.formatCellValue(Cell);
					return CellData;
				}catch (Exception e){
					System.out.println(e.getMessage());
					throw (e);
				}
		}
    }