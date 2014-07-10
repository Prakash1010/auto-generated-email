package com.edu.inventorycontrol.server.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelParsingUtil 
{
	public static List<List<Object>> readExcellData(InputStream fileContent) throws InvalidFormatException, IOException {

		System.out.println(" ************** Inside ExcelParsingUtil:readExcellData() !!!!!!!!!!!!!! *************************");
		//System.out.println(fileContent.);
		List<List<Object>> tableList = new ArrayList<List<Object>>();
//		try {
			Workbook wb = WorkbookFactory.create(fileContent);
			Sheet mySheet = wb.getSheetAt(0);
			Iterator<Row> rowIter = mySheet.rowIterator();
			
			while (rowIter.hasNext()) {
				List<Object> rowList = new ArrayList<Object>();
				
				Row myRow = (Row) rowIter.next();
				Iterator<Cell> cellIter = myRow.cellIterator();

				while (cellIter.hasNext()) {

					Cell myCell = (Cell) cellIter.next();

					switch (myCell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						rowList.add(myCell.getStringCellValue());
						break;
					case Cell.CELL_TYPE_NUMERIC:
						rowList.add(myCell.getNumericCellValue());
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						rowList.add(myCell.getBooleanCellValue());
						break;
					case Cell.CELL_TYPE_BLANK:
						rowList.add("");
						break;
					}
				}
				System.out.println("Row List is : "+rowList);
				boolean insert=false;
				for (Iterator iterator = rowList.iterator(); iterator.hasNext();) 
				{
					try
					{
						String object = (String) iterator.next();
						if(!object.equalsIgnoreCase(""))
							insert=true;
					}
					catch(Exception e)
					{
					}
				}
				if(insert)
					tableList.add(rowList);
			}
//		} catch (InvalidFormatException e1) {
//			e1.printStackTrace();
//			return null;
//		} catch (IOException e1) {
//			e1.printStackTrace();
//			return null;
//		}
		return tableList;
	
	}
}
