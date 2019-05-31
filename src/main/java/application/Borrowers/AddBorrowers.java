/**
 * This Code is Property of SAP Labs and is Copyright.
 * Distribution and Copying is Prohibited without
 * Approval OR Permission.
 *
 * @author I313006 / Dec 1, 2017
 */
package application.Borrowers;

import static org.testng.Assert.expectThrows;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.SAXException;

import logs.LowLevelLogs;
import utils.Application_Common_Functions;
import utils.Common_Functions;
import utils.Constants;
import utils.DataSourceHelper;

/**
 * @author C5268933
 *
 */
public class AddBorrowers {

	private Common_Functions commfunct_Obj = new Common_Functions();
	private Application_Common_Functions Appcommfunct_Obj = new Application_Common_Functions();
	private DataSourceHelper ds = new DataSourceHelper();
	public ArrayList<String> MsgList = new ArrayList<String>();
	private static final Logger lowlevellogsobj = Logger.getLogger(AddBorrowers.class);

	public AddBorrowers(WebDriver driver) {
	}

	@FindBy(xpath = "//div[contains(@id,'DealDrawingRulesView')]//*[text()='Permitted Borrowers']/following::button[position()=3]/span")
	public WebElement btn_AddPB;

	@FindBy(xpath = "//div[contains(@id,'DealDrawingRulesView')]//input[contains(@id,'Borrower-input-inner')]")
	private WebElement txt_Borrower;

	@FindBy(xpath = "//a[contains(@aria-labelledby,'Borrower-label')]")
	private WebElement txt_BorrowerName;

	@FindBy(xpath = "//div[contains(@id,'DealDrawingRulesView')]//*[contains(text(),'Valid From')]/../following::div[position()=2]//input[contains(@aria-labelledby,'idValidFrom')]")
	private WebElement txt_ValidFrom;

	@FindBy(xpath = "//div[contains(@id,'DealDrawingRulesView')]//*[contains(text(),'Valid To')]/../following::div[position()=2]//input[contains(@aria-labelledby,'idvalidto')]")
	public WebElement txt_ValidTo;

	@FindBy(xpath = "//div[contains(@id,'DealDrawingRulesView')]//table[contains(@aria-labelledby,'PermittedBorrowers')]/tbody/tr")
	public WebElement table_PBcol;

	public String xpDDRulestab = "//button/*[contains(@id,'dealEdit--DealDrawingRules')]";
	public String xpbtnPBAdd = "//div[contains(@id,'DealDrawingRulesView')]//*[text()='Permitted Borrowers']/following::button[position()=3]/span";
	public String xpPBCreate = "//div[contains(@id,'DealDrawingRulesView')]//*[text()='Create']";
	public String xptxt_PB = "//div[contains(@id,'DealDrawingRulesView')]//input[contains(@id,'Borrower-input-inner')]";
	public String xpPBlabel = "//a[contains(@aria-labelledby,'Borrower-label')]";
	public String xpValidfrom = "//div[contains(@id,'DealDrawingRulesView')]//*[contains(text(),'Valid From')]/../following::div[position()=2]//input[contains(@aria-labelledby,'idValidFrom')]";
	public String xpValidTo = "//div[contains(@id,'DealDrawingRulesView')]//*[contains(text(),'Valid To')]/../following::div[position()=2]//input[contains(@aria-labelledby,'idvalidto')]";
	public String xpPBTablecol = "//div[contains(@id,'DealDrawingRulesView')]//table[contains(@aria-labelledby,'PermittedBorrowers')]/tbody/tr";

	public boolean borrowerDetails(WebDriver driver, List<String> testArray_Data,
			HashMap<String, Integer> headerMap_Data)
			throws InterruptedException, IOException, SAXException, ParserConfigurationException {

		boolean result = true;
		boolean result1=false;

		WebDriverWait wait = new WebDriverWait(driver, 100);

		String sPB = commfunct_Obj.getParameter(testArray_Data, headerMap_Data, Constants.C_AddBorrowers_PermBorrowers);
		String sMainBorrower = commfunct_Obj.getParameter(testArray_Data, headerMap_Data,
				Constants.C_AddBorrowers_MainBorrower);
		String sBorrowerName = commfunct_Obj.getParameter(testArray_Data, headerMap_Data,
				Constants.C_AddBorrowers_BorrowerName);
		String sValidfrom = commfunct_Obj.getParameter(testArray_Data, headerMap_Data,
				Constants.C_AddBorrowers_ValidFrom);
		String sValidTo = commfunct_Obj.getParameter(testArray_Data, headerMap_Data, Constants.C_AddBorrowers_ValidTo);

		try {
			Thread.sleep(3000);
			lowlevellogsobj.info("Started in Drawdown Class");
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpDDRulestab)));
			commfunct_Obj.commonFindElement_Click(driver, "xpath", xpDDRulestab, "Yes");
			Thread.sleep(1000);
			// Add Permitted Borrowers
			if (sPB.equalsIgnoreCase("Yes")) {

				String strSplit[] = sMainBorrower.split("\\|");

				int totalele = strSplit.length;
				for (int i = 0; i < totalele; i++) {
					commfunct_Obj.commonClick(btn_AddPB, "Yes");

					if (sMainBorrower.length() > 0) {

						wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xptxt_PB)));
						commfunct_Obj.commonFindElement_enterText(driver, "xpath", xptxt_PB, "Yes", strSplit[i]);
						Thread.sleep(500);
						txt_Borrower.sendKeys(Keys.ENTER);
						Thread.sleep(500);
						lowlevellogsobj.info("Entered Main Borrower is:" + sMainBorrower);
						// wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpPBlabel)));
						result1 = true;

					}

					if (sValidfrom.length() > 0) {
						wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpValidfrom)));
						commfunct_Obj.commonFindElement_enterText(driver, "xpath", xpValidfrom, "Yes", sValidfrom);
						lowlevellogsobj.info("Entered Valid from date is:" + sValidfrom);
						result1 = true;

					}

					if (sValidTo.length() > 0) {
						wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpValidTo)));
						commfunct_Obj.commonFindElement_enterText(driver, "xpath", xpValidTo, "Yes", sValidTo);
						lowlevellogsobj.info("Entered Valid To date is:" + sValidTo);
						result1 = true;

					}

					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpPBCreate)));
					commfunct_Obj.commonFindElement_Click(driver, "xpath", xpPBCreate, "Yes");
					result1 = true;

				}

				Thread.sleep(2000);

				lowlevellogsobj.info("Permitted borrowers is added");
				Thread.sleep(2000);
				result1 = true;

			}

			

		} catch (Exception e) {
			LowLevelLogs.getLogger().error("Exception in entering Drawdown Detail:  " + e.getMessage(), e);
			result = false;
		} finally {
			if((driver.findElements(By.xpath("//a[text()='Show Details']")).size()==1) && (driver.findElements(By.xpath("//header[@role='heading']//span[contains(text(),'Error')]")).size()==1)){
				commfunct_Obj.commonFindElement_Click(driver, "xpath", "//a[text()='Show Details']", "Yes");
				Thread.sleep(1000);
				String geterrorText = commfunct_Obj.commonFindElement_GetText(driver, "xpath", "//div[contains(@class,'sapMMessageBoxDetails')]");
				lowlevellogsobj.info(geterrorText);
				MsgList.add("Application Dump->"+geterrorText);
				commfunct_Obj.commonFindElement_Click(driver, "xpath", "//footer//*[text()='Close']", "Yes");
				result=false;
			}
			else if(driver.findElements(By.xpath("//header[@role='heading']//span[contains(text(),'Error')]")).size()==1){
				String geterrorText = commfunct_Obj.commonFindElement_GetText(driver, "xpath", "//div[@class='sapMDialogScrollCont']//span[contains(text(),'error')]/following::li[position()=1]");
				lowlevellogsobj.info(geterrorText);
				MsgList.add("Application Dump->"+geterrorText);
				commfunct_Obj.commonFindElement_Click(driver, "xpath", "//*[contains(text(), 'Close')]", "Yes");
				result=false;
			
			} else {
				MsgList.add("Application Dump did not occur");
				result =  result && result1;

			}
		}

		return result;
	}

}
