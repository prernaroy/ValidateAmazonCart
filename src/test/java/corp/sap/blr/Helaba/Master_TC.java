package corp.sap.blr.Helaba;
import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.xml.sax.SAXException;

import amazon.ValidateProfile;
import application.Borrowers.AddBorrowers;

import application.Login.LoginScreen;
import utils.Constants;
import utils.DataSourceHelper;

public class Master_TC {

	private LoginScreen Login_ScreenObj;
	private AddBorrowers AddBorrowers_ScreenObj;
	private ValidateProfile ValidateProfile_Obj;
	
	
	DataSourceHelper dataObj = new DataSourceHelper();
	ArrayList<String> masterScriptMsgList = new ArrayList<String>();
	private static final Logger lowlevellogsobj = Logger.getLogger("Master_TC");

	@SuppressWarnings("rawtypes")
	public boolean executeMaster_TC( WebDriver driver,List testArray, HashMap headerMap,String password)
			throws ParserConfigurationException, SAXException, IOException,
			NoSuchElementException, AWTException {


		boolean result = false;

		try {

			String sTCID = testArray.get(
					(Integer) headerMap.get(Constants.C_TCID_TEXT)).toString();


			List<String> list_TCData_Path = new ArrayList<String>();
			list_TCData_Path = dataObj.getTestData_List(
					Constants.C_WB_TESTDATA_MASTERTC,
					Constants.C_SHEET_PATH, sTCID);


			List<String> tempList = new ArrayList<String>();
			tempList = new ArrayList<String>(list_TCData_Path);
			tempList.remove(0);

			Iterator<String> taItr = tempList.iterator();
			System.out.println(tempList);

			while(taItr.hasNext()) {

				String stemp = taItr.next();
				System.out.println("STEMP:" + stemp);
				String rowref = stemp.substring(stemp.length() - 6, stemp.length());
				System.out.println("ROWREF:"+ rowref);
				String screendatatab = stemp.substring(0, stemp.length() - 7);

				System.out.println("STEP NAME: "+ stemp);

				result = testcasePath_Executor( driver,rowref, "SHEET_"+screendatatab,password);

				if (result == false) {
					//	masterScriptMsgList.addAll(ATC_ScreenObj.LoginMsgList);
					return result;
				} 
			} 


		} catch (Exception e) {
			lowlevellogsobj.error(
					"Exception in executeMaster_TC: " + e.getMessage(), e);
			result = false;
		} finally {
			lowlevellogsobj.info("executeMaster_TC:  End");
		}
		return result;
	}

	public boolean testcasePath_Executor(WebDriver driver, String rowref, 
			String screendatatab,String password)
					throws ParserConfigurationException, SAXException, IOException,
					NoSuchElementException, AWTException {

		boolean result = false;

		try {

			List<String> list_TCData = new ArrayList<String>();

			list_TCData = dataObj.getTestData_List(Constants.C_WB_TESTDATA_TC,screendatatab, rowref);
			System.out.println("list_TCData"+list_TCData);

			HashMap<String, Integer> mapTCData = new HashMap<String, Integer>();
			mapTCData = dataObj.getHeaderMap_TestData(Constants.C_WB_TESTDATA_TC,screendatatab);
			System.out.println("mapTCData"+mapTCData);
			System.out.println("screenName:"+screendatatab);


			switch(screendatatab)
			{

			case Constants.C_SHEET_LOGIN:

				Login_ScreenObj = new LoginScreen(driver);
				PageFactory.initElements(driver, Login_ScreenObj);
				result = Login_ScreenObj.inputLogin(driver, list_TCData,mapTCData);
				if (result == false) {
					masterScriptMsgList.addAll(Login_ScreenObj.MsgList);
				}
				break;
				
			case Constants.C_SHEET_ValidateProfile:

				ValidateProfile_Obj = new ValidateProfile(driver);
				PageFactory.initElements(driver, ValidateProfile_Obj);
				result = ValidateProfile_Obj.ValidateProfile_details(driver, list_TCData,mapTCData);
				if (result == false) {
					masterScriptMsgList.addAll(ValidateProfile_Obj.MsgList);
				}
				break;

				
			
			case Constants.C_SHEET_AddBorrowers:

				AddBorrowers_ScreenObj = new AddBorrowers(driver);
				PageFactory.initElements(driver, AddBorrowers_ScreenObj);
				result = AddBorrowers_ScreenObj.borrowerDetails(driver, list_TCData,mapTCData);
				if (result == false) {
					masterScriptMsgList.addAll(AddBorrowers_ScreenObj.MsgList);
				}
				break;		
				
	

			default:
				break;
			}

		} catch (Exception e) {
			lowlevellogsobj.error("Exception in testcasePath_Executor: " + e.getMessage(), e);
			result = false;
			
		}
		
		

		return result;
	}
}	
