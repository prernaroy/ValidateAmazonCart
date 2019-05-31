package corp.sap.blr.Helaba;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import logs.HighLevelLogs;
import logs.LowLevelLogs;
import logs.NewLogForEachTestCase;
import utils.Common_Functions;
import utils.Constants;
import utils.DataSourceHelper;
import utils.DriverFactory;
import utils.ReadProperties;
import utils.ZipFolder;

public class Master_Test {
	public static WebDriver driver;
	private String browserName;
	private HighLevelLogs highlogObj = new HighLevelLogs();
	private Master_TC Master_TCObj;
	private static final Logger lowlevellogsobj = Logger.getLogger("Master_Test");
	private static String password ;
	DataSourceHelper dataObj = new DataSourceHelper();
	ArrayList<String> mainScriptMsgList;
	String str_exectime = null;
	long startTime = 0, stopTime = 0, elapsedTime = 0;

	@BeforeClass
	void generatePassword()
	{
		LowLevelLogs.getLogger();

	}

	@AfterMethod
	public void teardownTest() {
		try {
			if (driver != null) {
				driver.quit();
			}


		} catch (RuntimeException e) {		

			// Ignore errors if unable to close the browser
		}
	}

	@SuppressWarnings("rawtypes")
	@Test(dataProvider = "getData_executeMaster_Test")
	public void executeMaster_Test(List testArray) throws Exception {


		boolean hasExceptionOccured = false,result = true;

		ArrayList<String> itrListString = new ArrayList<String>();
		//int indTCID = dataObj.getIndexFromSheetHeaderList(Constants.C_TCID_TEXT);

		String sTCID = testArray.get(Constants.C_TCID).toString();
		String sTCDescription = testArray.get(Constants.C_TCDescription).toString();
		String sURL = ReadProperties.readProperty("url");
		browserName = ReadProperties.readProperty("browser");
		
		//Generate New log for Each Test Case
		NewLogForEachTestCase.changeLogName(sTCID);
		
		// Execute Test		
		driver = DriverFactory.createDriver();
		driver.get(sURL);
		driver.manage().window().maximize();
		
		lowlevellogsobj.info("==========TestCase: " + sTCID + " START==========");

		Logs logs = driver.manage().logs();					// New by I313006
		LogEntries logEntries = logs.get(LogType.CLIENT);	// New by I313006

		for (LogEntry logEntry : logEntries) {				// New by I313006
			System.out.println(logEntry.getMessage());		// New by I313006
		}													// New by I313006


		try {
			Common_Functions.setScriptName(sTCID);
			startTime = System.currentTimeMillis();
			Master_TCObj = new Master_TC();
			HashMap<String, Integer> mapTCData_Master = new HashMap<String, Integer>();
			mapTCData_Master = dataObj.getHeaderMap_TestData(
					Constants.C_WB_TESTDATA_MASTERTC,
					Constants.C_SHEET_MASTER);


			result = Master_TCObj.executeMaster_TC( driver,testArray, mapTCData_Master,password);
			String resultValue = String.valueOf(result);
			stopTime = System.currentTimeMillis();
			elapsedTime = stopTime - startTime;
			if (elapsedTime >= 60) {
				str_exectime = Common_Functions.convertTime_MSToMinSec(elapsedTime);
			} else {
				str_exectime = String.valueOf(elapsedTime)+ " sec";
			}
			System.out.println(str_exectime);

			if (resultValue.equalsIgnoreCase(Constants.C_FALSE)) {
				mainScriptMsgList = Master_TCObj.masterScriptMsgList;

				if (mainScriptMsgList != null) {
					if (!mainScriptMsgList.isEmpty()) {
						itrListString.addAll(mainScriptMsgList);
					}
				}

			}
		} catch (NoSuchElementException ex) {
			lowlevellogsobj.error(
					"NoSuchElementException in executeMaster_Test: "
							+ ex.getMessage(), ex);
			hasExceptionOccured = true;
			result = false;
			Assert.fail(ex.getMessage());
		} catch (Exception e) {
			lowlevellogsobj.error("Exception in executeMaster_Test: " + e.getMessage(), e);
			hasExceptionOccured = true;
			result = false;
			Assert.fail(e.getMessage());
			itrListString.add(e.getMessage());
		} finally {
			lowlevellogsobj.info("executeMaster_Test:  End");
			lowlevellogsobj.info("==========TestCase END==========");
			
			String sLowLevelLogFile = "LowLevelReport_" + sTCID + ".log";
			
//			highlogObj.finallyBlock(driver, testArray.get(indTCID).toString(), "",browserName, "", result, sLowLevelLogFile, hasExceptionOccured, itrListString);

			highlogObj.finallyBlock(driver, sTCID, sTCDescription, browserName, "", result, sLowLevelLogFile, hasExceptionOccured, itrListString,str_exectime);
			
			Assert.assertEquals(result, true, itrListString.toString());
		}
	}

	@AfterClass
	void generateHTMLReport() throws Exception
	{
		//Generate Final HTML Report
		highlogObj.generateHTMLReport();
		
		//Zip the Report Folder 
		String sReportFolder = ReadProperties.readProperty("MainReportFolder");
		ZipFolder ZipFolder = new ZipFolder();
		ZipFolder.zipFolder(sReportFolder, "Results.Zip");

	}
	
	
	@DataProvider
	public Object[][] getData_executeMaster_Test() throws Exception {
		Object[][] OW_SRP = null;
		try {
			OW_SRP = dataObj.getTestData(Constants.C_WB_TESTDATA_MASTERTC,
					Constants.C_SHEET_MASTER);			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return OW_SRP;
	}	
}