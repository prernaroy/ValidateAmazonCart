package utils;

//-----------------------------------------------------------------------------------------------------------
//Description    :   Data Source helper file for test data
//Creator        :   Sapna Bansal
//Create         :   
//Modified on/By :   -
//-----------------------------------------------------------------------------------------------------------

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


//for reading the data from the provided excel file using apache POI
public class DataSourceHelper {
	/**
	 * @param args
	 */
	public static Object[] temp;
	public int size = 0;
	List<XSSFCell> sheetHeader = null;
	
	private static final Logger lowlevellogsobj = Logger.getLogger(DataSourceHelper.class);
	
	/**
	 * This function will give the object containing the data for the provided
	 * TC id from the sheet
	 * 
	 * @param tcid
	 *            The tc id for which data to be rendered from the sheet
	 * @param sSheetName
	 *            Sheet Name from where data to be rendered
	 * @param sWorkbookName
	 *            Workbook Name from where data to be rendered
	 * @param isExcelYesNo
	 *            The value of this parameter will decide whether to consider
	 *            the column value for Yes/No
	 * @return Object[][]: containing the data from the sheet for specific test
	 *         case id
	 */
	public Object[][] getTestData(String sWorkbookName, String sSheetName)
			throws Exception {

		Object[][] array = null;

		try {
			List<List<XSSFCell>> listData = getData(sWorkbookName, sSheetName);
			sheetHeader = listData.get(0);
			listData.remove(0);

			array = getArray(listData);

		} catch (Exception e) {
			lowlevellogsobj.error(
					"Exception in getTestData: " + e.getMessage(), e);
		}
		return array;
	}

	public List<String> getTestData_List(String sWorkbookName,
			String sSheetName, String sTCID) throws Exception {

		List<String> list = new ArrayList<String>();

		try {
			List<List<XSSFCell>> listData = getData(sWorkbookName, sSheetName);
			sheetHeader = listData.get(0);

			listData.remove(0);

			list = getList(listData, sTCID);

		} catch (Exception e) {
			lowlevellogsobj.error(
					"Exception in getTestData_List- " + e.getMessage(), e);
		}
		return list;
	}

	public Object[][] getArray(List<List<XSSFCell>> sheetData) {
		List<List<XSSFCell>> list = new ArrayList<List<XSSFCell>>();

		int indYN = getIndexFromSheetHeaderList(Constants.C_EXECUTE_TEST_TEXT); // "Yes/No");

		Iterator<List<XSSFCell>> checkData = sheetData.iterator();
		List<XSSFCell> oneDList = null;
		while (checkData.hasNext()) {
			oneDList = (List<XSSFCell>)checkData.next();
			if (oneDList.get(indYN).toString()
					.equalsIgnoreCase(Constants.C_YES))
				list.add(oneDList);
		}

		Object[][] result = new Object[list.size()][];
		try {
			for (int i = 0; i < result.length; i++) {
				result[i] = new Object[] { list.get(i) };
			}
		} catch (Exception ex) {
			lowlevellogsobj.error(
					"Exception in getArray- " + ex.getMessage(), ex);
		}
		return result;
	}

	public List<String> getList(List<List<XSSFCell>> sheetData, String sTCID) {
		List<String> list = new ArrayList<String>();
		int indTCID = getIndexFromSheetHeaderList(Constants.C_TCID_TEXT);
		Iterator<List<XSSFCell>> checkData = sheetData.iterator();
		List<XSSFCell> oneDList = null;
		List<String> listData = null;
		try {
			while (checkData.hasNext()) {
				oneDList = (List<XSSFCell>)checkData.next();
				if (oneDList.get(indTCID).toString().equalsIgnoreCase(sTCID)) {
					//list.add(oneDList.toString());
					for(XSSFCell cell:oneDList){
						list.add(cell.toString());
					}
					break;
				}
			}
			/*String slistData = list.get(0).toString();
			slistData = slistData.replace("[", "");
			slistData = slistData.replace("]", "");
			slistData.trim();
			listData = Arrays.asList(slistData.split("\\s*,\\s*"));*/
			listData = list;
		} catch (Exception ex) {
			lowlevellogsobj.error(
					"Exception in getList: " + ex.getMessage(), ex);
		}
		return listData;
	}

	public int getIndexFromSheetHeaderList(String hdrColName) {
		Iterator<XSSFCell> hdrItr = sheetHeader.iterator();
		XSSFCell hdrVal = null;
		int indOfCol = 0;
		try {
			while (hdrItr.hasNext()) {
				hdrVal = hdrItr.next();
				if (hdrVal.toString().trim().equals(hdrColName))
					indOfCol = sheetHeader.indexOf((Object) hdrVal);
			}
		} catch (Exception ex) {
			lowlevellogsobj.error(
					"Exception in getIndexFromSheetHeaderList: "
							+ ex.getMessage(), ex);
		}
		return indOfCol;

	}

	public HashMap<String, Integer>   getHeaderMap_TestData(String sWorkbookName,
			String sSheetName) throws Exception {

		XSSFCell hdrVal = null;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int indOfCol = 0;

		try {
			List<List<XSSFCell>> listData = getData(sWorkbookName, sSheetName);
			List<XSSFCell>	sheetHeader_TestData = listData.get(0);
			Iterator<XSSFCell> hdrItr = sheetHeader_TestData.iterator();

			while (hdrItr.hasNext()) {
				hdrVal = hdrItr.next();

				indOfCol = sheetHeader_TestData.indexOf((Object) hdrVal);
				map.put(hdrVal.toString(), indOfCol);
			}
		} catch (Exception ex) {
			lowlevellogsobj.error(
					"Exception in getHeaderMap_TestData: "
							+ ex.getMessage(), ex);
		}
		return map;

	}

	public static List<List<XSSFCell>> getData(String workBook,
			String ssheetName) {
		File dir1 = new File(".");
		List<List<XSSFCell>> sheetData = new ArrayList<List<XSSFCell>>();
		FileInputStream fis = null;
		XSSFWorkbook wb = null;
		XSSFSheet sheet = null;

		try {
			@SuppressWarnings("unused")
			String strBasePath = dir1.getCanonicalPath();

			new ReadProperties();
			String file = ReadProperties.readProperty(workBook);
			new ReadProperties();
			String sheetName = ReadProperties.readProperty(ssheetName);

			fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheet(sheetName);

			Iterator<Row> rows = sheet.rowIterator();

			while (rows.hasNext()) {
				XSSFRow rown = (XSSFRow) rows.next();
				Iterator<Cell> cells = rown.cellIterator();

				List<XSSFCell> data = new ArrayList<XSSFCell>();
				while (cells.hasNext()) {
					XSSFCell celln = (XSSFCell) cells.next();
					celln = (XSSFCell) castCellType(celln);
					data.add(celln);
				}
				sheetData.add(data);
			}

		} catch (IOException e) {
			lowlevellogsobj.error(
					"IOException in getData: " + e.getMessage(), e);
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					lowlevellogsobj.error(
							"IOException in getData: " + e.getMessage(), e);
				}
			}
		}
		return sheetData;
	}

	/**
	 * @param cell
	 *            cell for which type casting to be done
	 * @return type casted cell
	 */

	@SuppressWarnings("deprecation")
	public static Cell castCellType(Cell cell) {
		try { // Check for null column
			if (cell != null) {
				
				if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
					if (DateUtil.isCellDateFormatted(cell)) {
						cell.setCellType(Cell.CELL_TYPE_NUMERIC);
					} else
						cell.setCellType(CellType.STRING);
				} else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
					cell.getRichStringCellValue();
				} else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
					cell.setCellType(CellType.STRING);
				} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
					cell.setCellType(CellType.STRING);
				} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
					cell.setCellType(CellType.STRING);
				} else if (cell.getCellType() == Cell.CELL_TYPE_ERROR) {
					cell.setCellType(CellType.STRING);
				}
			}
		} catch (Exception ex) {
			lowlevellogsobj.error(
					"Exception in castCellType: " + ex.getMessage(), ex);
		}
		return cell;
	}

	@SuppressWarnings("deprecation")
	public static int findRow(XSSFSheet sheet, String cellContent) {
		int irow_no = 0;
		try {
			for (Row row : sheet) {
				for (Cell cell : row) {
					if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
						cell.setCellType(CellType.STRING);
					}
					if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						String cellval = cell.getRichStringCellValue()
								.getString().trim();
						if (cellval.equals(cellContent)) {
							irow_no = row.getRowNum();
							return irow_no;
						}
					}
				}
			}
		} catch (Exception ex) {
			lowlevellogsobj.error(
					"Exception in findRow: " + ex.getMessage(), ex);
			irow_no = 0;
		}
		return irow_no;
	}

	public void updateResult(String workBook, String ssheetName, String stcid,
			String qtnno, int colno) throws Exception {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		XSSFWorkbook wb = null;
		XSSFSheet sheet = null;
		Cell cell = null;

		try {
			new ReadProperties();
			String file = ReadProperties.readProperty(workBook);
			//   String file=workBook;
			File fileName = new File(file);
			if (fileName.exists()) {
				fis = new FileInputStream(new File(file));
				wb = new XSSFWorkbook(fis);
				new ReadProperties();
				String sheetName = ReadProperties.readProperty(ssheetName);
				//String sSheetName=ssheetName;
				sheet = wb.getSheet(sheetName);


				int rown = findRow(sheet, stcid);

				// update the corresponding cell for pass/fail
				cell = sheet.getRow(rown).getCell(colno);
				//cell.setCellType(Cell.CELL_TYPE_STRING);
				if (cell==null)
				{
					cell=sheet.getRow(rown).createCell(colno);
				}
				cell.setCellValue(qtnno);

				fis.close();
				fos = new FileOutputStream(new File(file));
				wb.write(fos);
				fos.close();
			}
		} catch (FileNotFoundException e) {
			lowlevellogsobj.error(
					"FileNotFoundException in updateResult: " + e.getMessage(),
					e);
		} catch (IOException e) {
			lowlevellogsobj.error(
					"IOException in updateResult: " + e.getMessage(), e);
		} catch (HeadlessException e) {
			lowlevellogsobj.error(
					"HeadlessException in updateResult: " + e.getMessage(), e);
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					lowlevellogsobj
					.error("IOException in updateResult: "
							+ e.getMessage(), e);
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					lowlevellogsobj
					.error("IOException in updateResult: "
							+ e.getMessage(), e);
				}
			}
		}
	}
	
	public void updateData(String workBook, String ssheetName, String stcid,
			String sInput, String sColumnName) throws Exception {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		XSSFWorkbook wb = null;
		XSSFSheet sheet = null;
		Cell cell = null;
		DataSourceHelper dataObj = new DataSourceHelper();
		HashMap<String, Integer> mapTCData = new HashMap<String, Integer>();

		try {
			new ReadProperties();
			String file = ReadProperties.readProperty(workBook);
			//   String file=workBook;
			File fileName = new File(file);
			if (fileName.exists()) {
				fis = new FileInputStream(new File(file));
				wb = new XSSFWorkbook(fis);
				new ReadProperties();
				String sheetName = ReadProperties.readProperty(ssheetName);
				//String sSheetName=ssheetName;
				sheet = wb.getSheet(sheetName);
				
				mapTCData = dataObj.getHeaderMap_TestData(workBook,ssheetName);
				int rown = findRow(sheet, stcid);
				int iColNo = mapTCData.get(sColumnName);

				// update the corresponding cell with Data
				cell = sheet.getRow(rown).getCell(iColNo);

				cell.setCellValue(sInput);

				fis.close();
				fos = new FileOutputStream(new File(file));
				wb.write(fos);
				fos.close();
			}
		} catch (FileNotFoundException e) {
			lowlevellogsobj.error(
					"FileNotFoundException in updateResult: " + e.getMessage(),
					e);
		} catch (IOException e) {
			lowlevellogsobj.error(
					"IOException in updateResult: " + e.getMessage(), e);
		} catch (HeadlessException e) {
			lowlevellogsobj.error(
					"HeadlessException in updateResult: " + e.getMessage(), e);
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					lowlevellogsobj.error("IOException in updateResult: "
							+ e.getMessage(), e);
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					lowlevellogsobj.error("IOException in updateResult: "
							+ e.getMessage(), e);
				}
			}
		}
	}
	
	public void updateCellDate(String workBook, String ssheetName,
			String stcid, String sCellValue, int iCellColNo) throws Exception {
		File dir1 = new File(".");
		FileInputStream fis = null;
		FileOutputStream fos = null;
		XSSFWorkbook wb = null;
		XSSFSheet sheet = null;
		Cell cell = null;

		try {

			String strBasePath = dir1.getCanonicalPath();
			System.out.println(strBasePath);

			String file = new ReadProperties().readProperty(workBook);
			System.out.println("The file is : " + file);

			File fileName = new File(file);
			if (fileName.exists()) {
				fis = new FileInputStream(new File(file));
				wb = new XSSFWorkbook(fis);
				String sheetName = new ReadProperties()
						.readProperty(ssheetName);
				sheet = wb.getSheet(sheetName);

				int rown = findRow(sheet, stcid);

				// update the corresponding cell for pass/fail
				cell = sheet.getRow(rown).getCell(iCellColNo);
				cell.setCellValue(sCellValue);

				fis.close();
				fos = new FileOutputStream(new File(file));
				wb.write(fos);
				fos.close();
			}
		} catch (FileNotFoundException e) {
			lowlevellogsobj.error(
					"FileNotFoundException in updateCellDate: "
							+ e.getMessage(), e);
		} catch (IOException e) {
			lowlevellogsobj.error(
					"IOException in updateCellDate: " + e.getMessage(), e);
		} catch (HeadlessException e) {
			lowlevellogsobj
					.error("HeadlessException in updateCellDate: "
							+ e.getMessage(), e);
		} catch (NullPointerException e) {
			lowlevellogsobj
					.error("NullPointerException in updateCellDate: "
							+ e.getMessage(), e);
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					lowlevellogsobj.error(
							"IOException in updateCellDate: " + e.getMessage(),
							e);
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					lowlevellogsobj.error(
							"IOException in updateCellDate: " + e.getMessage(),
							e);
				}
			}
		}
	}
	
	public String getCellData(String workBook, String ssheetName,
			String stcid, int iCellColNo) throws Exception {
		File dir1 = new File(".");
		FileInputStream fis = null;
		FileOutputStream fos = null;
		XSSFWorkbook wb = null;
		XSSFSheet sheet = null;
		Cell cell = null;
		String temp1 = null;
		try {

			String strBasePath = dir1.getCanonicalPath();
			System.out.println(strBasePath);

			String file = new ReadProperties().readProperty(workBook);
			System.out.println("The file is : " + file);

			File fileName = new File(file);
			if (fileName.exists()) {
				fis = new FileInputStream(new File(file));
				wb = new XSSFWorkbook(fis);
				String sheetName = new ReadProperties()
						.readProperty(ssheetName);
				sheet = wb.getSheet(sheetName);

				int rown = findRow(sheet, stcid);

				// update the corresponding cell for pass/fail
				cell = sheet.getRow(rown).getCell(iCellColNo);
				temp1 = cell.toString();
				

				fis.close();
				fos = new FileOutputStream(new File(file));
				wb.write(fos);
				fos.close();
			}
		} catch (FileNotFoundException e) {
			lowlevellogsobj.error(
					"FileNotFoundException in updateCellDate: "
							+ e.getMessage(), e);
		} catch (IOException e) {
			lowlevellogsobj.error(
					"IOException in updateCellDate: " + e.getMessage(), e);
		} catch (HeadlessException e) {
			lowlevellogsobj
					.error("HeadlessException in updateCellDate: "
							+ e.getMessage(), e);
		} catch (NullPointerException e) {
			lowlevellogsobj
					.error("NullPointerException in updateCellDate: "
							+ e.getMessage(), e);
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					lowlevellogsobj.error(
							"IOException in updateCellDate: " + e.getMessage(),
							e);
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					lowlevellogsobj.error(
							"IOException in updateCellDate: " + e.getMessage(),
							e);
				}
			}
		}
		return temp1;
	}

}