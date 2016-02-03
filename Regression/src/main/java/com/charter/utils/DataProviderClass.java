package com.charter.utils;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.testng.annotations.DataProvider;

import com.cognizant.framework.core.EnvParameters;

public class DataProviderClass {

	@DataProvider(name="TestDataCharter")
	public static Object[][] getDataFromFile(Method testmethod) throws Exception
	{
		Workbook objWorkBook = null;
		Sheet objCurrentSheet;
		String strAbsFilePath = EnvParameters.GetPropertyValue("dataprovider.filename");
		try {
			objWorkBook = Workbook.getWorkbook(new File(strAbsFilePath));
			objCurrentSheet = objWorkBook.getSheet(EnvParameters.GetPropertyValue("dataprovider.sheetname"));
			Cell testId = objCurrentSheet.findCell(testmethod.getName());
			if (testId == null){
				throw new RuntimeException("Data not supplied for " + testmethod.getName());
			}
			Cell[] firstRow = objCurrentSheet.getRow(0);
			Cell[] testdataRow = objCurrentSheet.getRow(testId.getRow());
			int i=0;
			Map<String, String> testdata = new HashMap<String,String>();
			for (Cell cell: firstRow){
				if (cell.getContents().equalsIgnoreCase("") || cell.getContents() == null) break;
				try{
					testdata.put(cell.getContents(), testdataRow[i++].getContents());
				}catch(ArrayIndexOutOfBoundsException e){
					break;
				}
			}
			return new Object[][] {	new Object[] { testdata } };
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally{
			if (objWorkBook!=null){
				objWorkBook.close();
			}
		}
	}

}
