package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.xml.sax.SAXException;

import logs.LowLevelLogs;

//import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class Common_Functions {
	
	private static final Logger lowlevellogsobj = Logger.getLogger(Common_Functions.class);
	public ArrayList<String> CFMsgList = new ArrayList<String>();
	public static String scptName;
	public String browserName;
	public String parentWindowHandle=null;



	/**
	 * @param driver
	 *            WebDriver reference
	 * @param findElementBy
	 *            String type expression of finding the element using :
	 *            xpath/ID/CSS path
	 * @param expr
	 *            String type expression of xpath/ID/CSS path
	 * @return boolean about the status of WebElement present
	 * @throws TimeoutException
	 *             if time out exception occurred
	 */
	public boolean commonFindElement(WebDriver driver, String findElementBy,
			String expr) throws TimeoutException {
		boolean result = false;
		WebElement element = null;
		try {

			if (findElementBy.equals("xpath")) {
				element = driver.findElement(By.xpath(expr));
			} else if (findElementBy.equals("id")) {
				element = driver.findElement(By.id(expr));
			} else if (findElementBy.equals("cssSelector")) {
				element = driver.findElement(By.cssSelector(expr));
			} else if (findElementBy.equals("linkText")) {
				element = driver.findElement(By.linkText(expr));
			} else if (findElementBy.equals("className")) {
				element = driver.findElement(By.className(expr));
			}
			if (element != null) {
				result = true;
			} else {
				result = false;
			}
		} catch (NoSuchElementException e) {
			lowlevellogsobj.error(
					"NoSuchElementException in commonFindElement for :"
							+ e.getMessage(), e);
			result = false;
		} catch (TimeoutException e) {
			lowlevellogsobj.error(
					"TimeoutException in commonFindElement for :"
							+ e.getMessage(), e);
			result = false;
		} catch (Exception e) {
			lowlevellogsobj.error(
					"Exception in commonFindElement for :" + e.getMessage(), e);
			result = false;
		}
		return result;
	}

	/**
	 * @param driver
	 *            WebDriver reference
	 * @param findElementBy
	 *            String type expression of finding the element using :
	 *            xpath/ID/CSS path
	 * @param expr
	 *            String type expression of xpath/ID/CSS path
	 * @return boolean about the status of WebElement present
	 * @throws TimeoutException
	 *             if time out exception occurred
	 */
	public boolean commonFindElement(WebDriver driver, WebElement element)
			throws TimeoutException {
		boolean result = false;

		try {

			if (element != null) {
				result = true;
			} else {
				result = false;
			}
		} catch (NoSuchElementException e) {
			lowlevellogsobj.error(
					"NoSuchElementException in commonFindElement for :"
							+ e.getMessage(), e);
			result = false;
		} catch (TimeoutException e) {
			lowlevellogsobj.error(
					"TimeoutException in commonFindElement for :"
							+ e.getMessage(), e);
			result = false;
		} catch (Exception e) {
			lowlevellogsobj.error(
					"Exception in commonFindElement for :" + e.getMessage(), e);
			result = false;
		}
		return result;
	}
	/**
	 * @param elementlist
	 *            List <WebElement>
	 * @param attribute
	 *            String attribute
	 * @param attributevalue
	 *            String attribute value
	 * @return WebElement
	 */ 
	public WebElement commonSearchElementByAttribute(List <WebElement> elementlist, 
			String attribute, String attributevalue)
					throws Exception {

		WebElement element = null;

		try {

			Iterator<WebElement> taItr = elementlist.iterator();

			while (taItr.hasNext()) {

				element = taItr.next();

				if (attribute != null) {

					if (attribute.equalsIgnoreCase(Constants.C_TEXT)) {
						if (element.getText().contains(attributevalue)) {
							return element;
						}
					}

					if (attribute.equalsIgnoreCase(Constants.C_VALUE)) {
						if (element.getAttribute("value").equalsIgnoreCase(attributevalue)) {
							return element;   					
						}

					}

				}	

			}

		} catch (Exception e) {
			lowlevellogsobj.error(
					"Exception in clickComponentDescrition :" + e.getMessage(), e);
			element = null;
		}	

		return element; 
	}

	/**
	 * @param driver
	 *            WebDriver reference
	 * @param findElementBy
	 *            String type expression of finding the element using :
	 *            xpath/ID/CSS path
	 * @param expr
	 *            String type expression of xpath/ID/CSS path
	 * @return WebDriver WebElement
	 * @throws TimeoutException
	 *             if time out exception occurred
	 */
	public WebElement commonFindElement_GetElement(WebDriver driver,
			String findElementBy, String expr) throws TimeoutException {

		WebElement element = null;
		try {

			if (findElementBy.equals("xpath")) {
				element = driver.findElement(By.xpath(expr));
			} else if (findElementBy.equals("id")) {
				element = driver.findElement(By.id(expr));
			} else if (findElementBy.equals("cssSelector")) {
				element = driver.findElement(By.cssSelector(expr));
			} else if (findElementBy.equals("linkText")) {
				element = driver.findElement(By.linkText(expr));
			} else if (findElementBy.equals("className")) {
				element = driver.findElement(By.className(expr));
			}
		} catch (NoSuchElementException e) {
			lowlevellogsobj.error(
					"NoSuchElementException in commonFindElement_GetElement for :"
							+ e.getMessage(), e);
		} catch (TimeoutException e) {
			lowlevellogsobj.error(
					"TimeoutException in commonFindElement_GetElement for :"
							+ e.getMessage(), e);
		} catch (Exception e) {
			lowlevellogsobj.error(
					"Exception in commonFindElement_GetElement for :"
							+ e.getMessage(), e);
		}
		return element;
	}


	/**
	 * @param driver
	 *            WebDriver reference
	 * @param timeOutInSeconds
	 *            integer type waiting time in second after that time out of
	 *            waiting
	 * @param FindElementBy
	 *            String type expression of finding the element using :
	 *            xpath/ID/CSS path
	 * @return boolean Status of WebDriver element i.e. found or not
	 * @param Expr
	 *            String type expression of xpath/ID/CSS path
	 * @throws TimeoutException
	 *             if time out exception occurred
	 */
	public boolean commonWaitToFindElement(WebDriver driver,
			int timeOutInSeconds, String findElementBy, String expr)
					throws TimeoutException {
		boolean result = false;
		WebElement element = null;
		try {
			// Element is Click able - it is Displayed and Enabled.
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

			if (findElementBy.equals("xpath")) {
				element = wait.until(ExpectedConditions.elementToBeClickable(By
						.xpath(expr)));
			} else if (findElementBy.equals("id")) {
				element = wait.until(ExpectedConditions.elementToBeClickable(By
						.id(expr)));
			} else if (findElementBy.equals("cssSelector")) {
				element = wait.until(ExpectedConditions.elementToBeClickable(By
						.cssSelector(expr)));
			} else if (findElementBy.equals("className")) {
				element = wait.until(ExpectedConditions.elementToBeClickable(By
						.className(expr)));
			} else if (findElementBy.equals("linkText")) {
				element = wait.until(ExpectedConditions.elementToBeClickable(By
						.linkText(expr)));
			}

			if (element != null) {
				result = true;
			} else {
				result = false;
			}
		} catch (TimeoutException e) {
			lowlevellogsobj.error(
					"TimeoutException in commonWaitToFindElement for :"
							+ e.getMessage(), e);
		}
		return result;
	}

	/**
	 * @param driver
	 *            WebDriver reference
	 * @param timeOutInSeconds
	 *            integer type waiting time in second after that time out of
	 *            waiting
	 * @param findElementBy
	 *            String type expression of finding the element using :
	 *            xpath/ID/CSS path
	 * @param expr
	 *            String type expression of xpath/ID/CSS path
	 * @return WebDriver WebElement
	 * @throws TimeoutException
	 *             if time out exception occurred
	 */
	public WebElement commonWaitToFindElement_GetElement(WebDriver driver,
			int timeOutInSeconds, String findElementBy, String expr)
					throws TimeoutException {
		WebElement element = null;
		try {
			// Element is Click able - it is Displayed and Enabled.
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

			if (findElementBy.equals("xpath")) {
				element = wait.until(ExpectedConditions.elementToBeClickable(By
						.xpath(expr)));
			} else if (findElementBy.equals("id")) {
				element = wait.until(ExpectedConditions.elementToBeClickable(By
						.id(expr)));
			} else if (findElementBy.equals("cssSelector")) {
				element = wait.until(ExpectedConditions.elementToBeClickable(By
						.cssSelector(expr)));
			} else if (findElementBy.equals("className")) {
				element = wait.until(ExpectedConditions.elementToBeClickable(By
						.className(expr)));
			} else if (findElementBy.equals("linkText")) {
				element = wait.until(ExpectedConditions.elementToBeClickable(By
						.linkText(expr)));
			}
		} catch (NoSuchElementException e) {
			lowlevellogsobj.error(
					"NoSuchElementException in commonWaitToFindElement_GetElement for :"
							+ e.getMessage(), e);
		} catch (TimeoutException e) {
			lowlevellogsobj.error(
					"TimeoutException in commonWaitToFindElement_GetElement for :"
							+ e.getMessage(), e);
		} catch (Exception e) {
			lowlevellogsobj.error(
					"Exception in commonWaitToFindElement_GetElement for :"
							+ e.getMessage(), e);
		}
		return element;
	}

	/**
	 * @param driver
	 *            WebDriver reference
	 * @param timeOutInSeconds
	 *            integer type waiting time in second after that time out of
	 *            waiting
	 * @param findElementBy
	 *            String type expression of finding the element using :
	 *            xpath/ID/CSS path
	 * @param expr
	 *            String type expression of xpath/ID/CSS path
	 * @return Text for the respective WebDriver element
	 * @throws TimeoutException
	 *             if time out exception occurred
	 */
	public String commonWaitToFindElement_GetText(WebDriver driver,
			int timeOutInSeconds, String findElementBy, String expr)
					throws TimeoutException {

		String elementText = "";
		WebElement element = null;
		try {
			// Element is Click able - it is Displayed and Enabled.
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

			if (findElementBy.equals("xpath")) {
				element = wait.until(ExpectedConditions.elementToBeClickable(By
						.xpath(expr)));
			} else if (findElementBy.equals("id")) {
				element = wait.until(ExpectedConditions.elementToBeClickable(By
						.id(expr)));
			} else if (findElementBy.equals("cssSelector")) {
				element = wait.until(ExpectedConditions.elementToBeClickable(By
						.cssSelector(expr)));
			} else if (findElementBy.equals("className")) {
				element = wait.until(ExpectedConditions.elementToBeClickable(By
						.className(expr)));
			} else if (findElementBy.equals("linkText")) {
				element = wait.until(ExpectedConditions.elementToBeClickable(By
						.linkText(expr)));
			}

			if (element != null) {
				elementText = element.getText();
			}
		} catch (NoSuchElementException e) {
			lowlevellogsobj.error(
					"NoSuchElementException in commonWaitToFindElement_GetText for :"
							+ e.getMessage(), e);
		} catch (TimeoutException e) {
			lowlevellogsobj.error(
					"TimeoutException in commonWaitToFindElement_GetText for :"
							+ e.getMessage(), e);
		} catch (Exception e) {
			lowlevellogsobj.error(
					"Exception in commonWaitToFindElement_GetText for :"
							+ e.getMessage(), e);
		}
		return elementText;
	}

	/**
	 * This function will return the list of elements.
	 * 
	 * @param driver
	 *            WebDriver reference
	 * @param findElementBy
	 *            String type expression of finding the element using :
	 *            xpath/ID/CSS path
	 * @param expr
	 *            String type expression of xpath/ID/CSS path
	 * @return This will return the list of element
	 */

	public List<WebElement> getElements(WebDriver driver, String findElementBy,
			String expr) throws TimeoutException {

		List<WebElement> element = null;
		try {

			if (findElementBy.equals("xpath")) {
				element = driver.findElements(By.xpath(expr));
			} else if (findElementBy.equals("id")) {
				element = driver.findElements(By.id(expr));
			} else if (findElementBy.equals("cssSelector")) {
				element = driver.findElements(By.cssSelector(expr));
			} else if (findElementBy.equals("className")) {
				element = driver.findElements(By.className(expr));
			} else if (findElementBy.equals("linkText")) {
				element = driver.findElements(By.linkText(expr));
			}
		} catch (NoSuchElementException e) {
			lowlevellogsobj.error(
					"NoSuchElementException in getElements for :"
							+ e.getMessage(), e);
		} catch (TimeoutException e) {
			lowlevellogsobj
			.error("TimeoutException in getElements for :"
					+ e.getMessage(), e);
		} catch (Exception e) {
			lowlevellogsobj.error(
					"Exception in getElements for :" + e.getMessage(), e);
		}
		return element;
	}

	/**
	 * This function will Click on provided WebElement
	 * 
	 * @param iclickInfo
	 *            WebElement to be Clicked
	 * @param toclickORnot
	 *            Boolean type value to check whether to click Enter button
	 *            after selecting the element
	 * @throws IOException
	 *             if IO exception occurred
	 * @throws SAXException
	 *             ifSAX Exception occurred
	 * @throws ParserConfigurationException
	 *             if ParserConfiguration Exception occurred
	 */
	public void commonClick(WebElement iclickInfo,String toclickORnot)
			throws IOException, SAXException, ParserConfigurationException {


		try {
			if (!toclickORnot.equals(Constants.C_NULL) ) {
				iclickInfo.click();
				Thread.sleep(500);
			}

		} catch (Exception e) {
			lowlevellogsobj.error(
					"Exception in commonClick:" + e.getMessage(), e);
		}
	}

	/**
	 * This function will Click on provided WebElement
	 * 
	 * @param iclickInfo
	 *            WebElement to be Clicked
	 * @param toclickORnot
	 *            Boolean type value to check whether to click Enter button
	 *            after selecting the element
	 * @throws IOException
	 *             if IO exception occurred
	 * @throws SAXException
	 *             ifSAX Exception occurred
	 * @throws ParserConfigurationException
	 *             if ParserConfiguration Exception occurred
	 */
	public void commonFindElement_Click(WebDriver  driver,String findElementBy, String expr,String toclickORnot)
			throws IOException, SAXException, ParserConfigurationException {


		try {
			WebElement iclickInfo=	commonFindElement_GetElement(driver, findElementBy, expr);
			if(iclickInfo!=null){
				if (!toclickORnot.equals(Constants.C_NULL) ) {
					iclickInfo.click();
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			lowlevellogsobj.error(
					"Exception in commonClick:" + e.getMessage(), e);
		}
	}

	/**
	 * This function will Click on corresponding element using Action Builder
	 * class
	 * 
	 * @param iclickInfo
	 *            WebElement to be Clicked
	 * @param toclickORnot
	 *            Boolean type value to check whether to click Enter button
	 *            after selecting the element
	 * @throws IOException
	 *             if IO exception occurred
	 * @throws SAXException
	 *             ifSAX Exception occurred
	 * @throws ParserConfigurationException
	 *             if ParserConfiguration Exception occurred
	 */
	public void commonClick_Action(WebDriver driver, WebElement iclickInfo,
			String toclickORnot) throws IOException, SAXException,
	ParserConfigurationException {

		try {
			if (!toclickORnot.equalsIgnoreCase(Constants.C_NULL)) {
				Actions actions = new Actions(driver);
				actions.moveToElement(iclickInfo);
				Thread.sleep(1000);
				actions.click();
				actions.build().perform();
				Thread.sleep(1000); 
			}

		} catch (Exception e) {
			lowlevellogsobj.error(
					"Exception in commonClick_Action:" + e.getMessage(), e);
		}
	}
	/**
	 * This function will Click on corresponding element using Action Builder
	 * class
	 * 
	 * @param iclickInfo
	 *            WebElement to be Clicked
	 * @param toclickORnot
	 *            Boolean type value to check whether to click Enter button
	 *            after selecting the element
	 * @throws IOException
	 *             if IO exception occurred
	 * @throws SAXException
	 *             ifSAX Exception occurred
	 * @throws ParserConfigurationException
	 *             if ParserConfiguration Exception occurred
	 */
	public void commonMoveMouse_EnterKey(WebDriver driver, WebElement sElementInfo,
			Keys sKeys) throws IOException, SAXException,
	ParserConfigurationException {

		try {
			Actions builder = new Actions(driver);
			builder.moveToElement(sElementInfo).build().perform();
			builder.sendKeys(sElementInfo,sKeys).build().perform();
			Thread.sleep(500);

		} catch (Exception e) {
			lowlevellogsobj.error(
					"Exception in commonMoveMouse_Click:" + e.getMessage(), e);
		}
	}

	/**
	 * @param iTextBoxInfo
	 *            WebElement reference
	 * @param sText
	 *            String type text which will be set in text box
	 * @return boolean True/False as a result on the basis that correct value
	 *         has been entered in the textbox
	 * @throws IOException
	 *             if IO exception occurred
	 * @throws ParserConfigurationException
	 *             if parse configuration exception occurred
	 * @throws SAXException
	 *             if SAX exception occurred
	 */
	public boolean commonSetTextTextBox(WebElement iTextBoxInfo, String sText)
			throws IOException, ParserConfigurationException, SAXException {

		boolean result = false;

		try {
			if(!sText.equals(Constants.C_NULL)){
				iTextBoxInfo.click();
				Thread.sleep(10);
				iTextBoxInfo.clear();
				iTextBoxInfo.sendKeys(sText);
				// VP>>>Verify that value has been entered
				result = commonVerifyValueTextBox(iTextBoxInfo, sText);	
			} else {
				result = true;
			}

		} catch (Exception ex) {
			lowlevellogsobj.error(
					"Exception in commonSetTextTextBox:" + ex.getMessage(), ex);
			result = false;
		}
		return result;
	}

	/**
	 * @param iTextBoxInfo
	 *            WebElement reference
	 * @param sText
	 *            String type text which will be set in text box
	 * @return boolean True/False as a result on the basis that correct value
	 *         has been entered in the filter
	 * @throws IOException
	 *             if IO exception occurred
	 * @throws ParserConfigurationException
	 *             if parse configuration exception occurred
	 * @throws SAXException
	 *             if SAX exception occurred
	 */
	public boolean commonSetFilter(WebElement iTextBoxInfo, String sText)
			throws IOException, ParserConfigurationException, SAXException {

		boolean result = false;

		try {
			if(!sText.equals(Constants.C_NULL)){
				commonClick(iTextBoxInfo, sText);
				result = commonSetTextTextBox(iTextBoxInfo, sText);
				result = true;   // done temporarily
				commonSendKeys(iTextBoxInfo, Keys.ENTER);
			} else {
				result = true;
			}

		} catch (Exception ex) {
			lowlevellogsobj.error(
					"Exception in commonSetFilter:" + ex.getMessage(), ex);
			result = false;
		}
		return result;
	}
	
	/**
	 * This function will Move Mouse on corresponding element using Action Builder
	 * class
	 * 
	 * @param iclickInfo
	 *            WebElement to be Move Mouse
	 * @throws IOException
	 *             if IO exception occurred
	 * @throws SAXException
	 *             ifSAX Exception occurred
	 * @throws ParserConfigurationException
	 *             if ParserConfiguration Exception occurred
	 */
	public void commonMoveMouse(WebDriver driver, WebElement sElementInfo) throws IOException, SAXException,ParserConfigurationException {

		try {
			Actions builder = new Actions(driver);
			builder.moveToElement(sElementInfo).build().perform();
			Thread.sleep(500);

		} catch (Exception e) {
			lowlevellogsobj.error(
					"Exception in commonMoveMouse:" + e.getMessage(), e);
		}
	}
	/**
	 * @param iTextBoxInfo
	 *            WebElement reference
	 * @param sExpectedValue
	 *            String type expected value
	 * @return boolean True/False as a result on the basis of verification that
	 *         corresponding element is there in the element
	 * @throws IOException
	 *             if IO exception occurred
	 * @throws SAXException
	 *             if SAX exception occurred
	 * @throws ParserConfigurationException
	 *             if parser configuration exception occurred
	 */
	public boolean commonVerifyValueTextBox(WebElement iTextBoxInfo,
			String sExpectedValue) throws IOException, SAXException,
	ParserConfigurationException {

		String sTempStr = null;
		boolean result = false;

		try {
			sExpectedValue = sExpectedValue.trim().toLowerCase();

			sTempStr = iTextBoxInfo.getAttribute("value").trim().toLowerCase();

			// VP >>> Verify that Actual Value contains the expected value
			if ((sTempStr.contains(sExpectedValue))) {
				result = true;
			} else {
				result = false;
			}
		} catch (Exception e) {
			lowlevellogsobj.error(
					"Exception in commonVerifyValueTextBox:" + e.getMessage(),
					e);
			result = false;
		}
		return result;
	}

	/**
	 * @param ControlInfo
	 *            WebElement reference
	 * @param sKeys
	 *            String type key which is used in pressing Enter
	 * @throws NoSuchElementException
	 *             if NoSuchElement Exception occurred
	 * @throws NullPointerException
	 *             if NullPointer Exception occurred
	 */
	public void commonSendKeys(WebElement ControlInfo, Keys sKeys)
			throws NoSuchElementException, NullPointerException {
		try {
			if (ControlInfo != null) {
				ControlInfo.sendKeys(sKeys); 
			}
		} catch (Exception e) {
			lowlevellogsobj.error(
					"Exception in commonSendKeys:" + e.getMessage(), e);
		}
	}

	/**
	 * @param checkbox
	 *            WebElement reference
	 * @param checkstatus
	 *            String type check/uncheck status
	 * @return boolean True/False
	 * @throws InterruptedException
	 *             if interrupted exception occurred
	 * @throws ParserConfigurationException
	 *             if parser configuration exception occurred
	 * @throws SAXException
	 *             if SAX exception occurred
	 * @throws IOException
	 *             if IO exception occurred
	 */
	public boolean commonVerifyCheckUncheckCheckBox(WebElement checkbox, String expected) throws InterruptedException,
	ParserConfigurationException, SAXException, IOException {
		boolean result = false;

		try {
			if ((checkbox.isSelected()&& expected.equalsIgnoreCase(Constants.C_CHECK)) || 
					(checkbox.isSelected()==false && expected.equalsIgnoreCase(Constants.C_UNCHECK))) {
				result = true;
			} else {
				result = false;
			}
		} catch (Exception e) {
			lowlevellogsobj
			.error("Exception in commonSelectItemInCombobox:"
					+ e.getMessage(), e);
			result = false;
		}
		return result;
	}


	/**
	 * @param checkbox
	 *            WebElement reference
	 * @param checkstatus
	 *            String type check/uncheck status
	 * @return boolean True/False
	 * @throws InterruptedException
	 *             if interrupted exception occurred
	 * @throws ParserConfigurationException
	 *             if parser configuration exception occurred
	 * @throws SAXException
	 *             if SAX exception occurred
	 * @throws IOException
	 *             if IO exception occurred
	 */
	public boolean commonCheckUncheckCheckBox(WebElement checkbox,
			String checkstatus) throws InterruptedException,
	ParserConfigurationException, SAXException, IOException {
		boolean result = false;

		try {
			if (checkstatus.equalsIgnoreCase(Constants.C_CHECK)|| checkstatus.equalsIgnoreCase(Constants.C_UNCHECK)) {

				if (checkbox.isSelected()
						&& checkstatus.equalsIgnoreCase(Constants.C_CHECK)) {
					result = true;
				} else if (checkbox.isSelected() == false
						&& checkstatus.equalsIgnoreCase(Constants.C_CHECK)) {

					//Check
					checkbox.click();

					//Verify that the check box is selected or not
					result=commonVerifyCheckUncheckCheckBox(checkbox, checkstatus);

				} else if (checkbox.isSelected() == false
						&& checkstatus.equalsIgnoreCase(Constants.C_UNCHECK)) {
					result = true;
				} else if (checkbox.isSelected()
						&& checkstatus.equalsIgnoreCase(Constants.C_UNCHECK)) {

					//Uncheck
					checkbox.click();

					//Verify that the check box is selected or not
					result=commonVerifyCheckUncheckCheckBox(checkbox, checkstatus);

				} 

				lowlevellogsobj.info(
						"checkstatus:" + checkstatus + ",Result:" + result);

			} else {
				result = true;
			}


		} catch (Exception e) {
			lowlevellogsobj
			.error("Exception in commonCheckUncheckCheckBox:"
					+ e.getMessage(), e);
			result = false;
		}
		return result;
	}

	/**
	 * @param checkbox
	 *            WebElement reference
	 * @param checkstatus
	 *            String type check/uncheck status
	 * @return boolean True/False
	 * @throws InterruptedException
	 *             if interrupted exception occurred
	 * @throws ParserConfigurationException
	 *             if parser configuration exception occurred
	 * @throws SAXException
	 *             if SAX exception occurred
	 * @throws IOException
	 *             if IO exception occurred
	 */
	public boolean commonCheckUncheckCheckBoxAction(WebDriver driver,WebElement checkbox,
			String checkstatus) throws InterruptedException,
	ParserConfigurationException, SAXException, IOException {
		boolean result = false;

		try {
			if (checkstatus.equalsIgnoreCase(Constants.C_CHECK)|| checkstatus.equalsIgnoreCase(Constants.C_UNCHECK)) {

				if (checkbox.isSelected()
						&& checkstatus.equalsIgnoreCase(Constants.C_CHECK)) {
					result = true;
				} else if (checkbox.isSelected() == false
						&& checkstatus.equalsIgnoreCase(Constants.C_CHECK)) {

					while (!commonVerifyCheckUncheckCheckBox(checkbox, checkstatus)) {
						//Check
						actionClick(driver, checkbox);		
					}

					//Verify that the check box is selected or not
					result=commonVerifyCheckUncheckCheckBox(checkbox, checkstatus);

				} else if (checkbox.isSelected() == false
						&& checkstatus.equalsIgnoreCase(Constants.C_UNCHECK)) {
					result = true;
				} else if (checkbox.isSelected()
						&& checkstatus.equalsIgnoreCase(Constants.C_UNCHECK)) {

					while (!commonVerifyCheckUncheckCheckBox(checkbox, checkstatus)) {
						//UnCheck
						actionClick(driver, checkbox);		
					}

					//Verify that the check box is selected or not
					result=commonVerifyCheckUncheckCheckBox(checkbox, checkstatus);
				} 

				lowlevellogsobj.info(
						"checkstatus:" + checkstatus + ",Result:" + result);

			} else {
				result = true;
			}


		} catch (Exception e) {
			lowlevellogsobj
			.error("Exception in commonCheckUncheckCheckBoxAction:"
					+ e.getMessage(), e);
			result = false;
		}
		return result;
	}

	private static void actionClick(WebDriver driver, WebElement element)
			throws IOException, SAXException, ParserConfigurationException {

		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(element);
			Thread.sleep(2500);
			actions.click();
			actions.build().perform();
			Thread.sleep(1000);
		} catch (Exception e) {
			lowlevellogsobj.error(
					"Exception in actionClick:" + e.getMessage(), e);

		}

	}

	/**
	 * @param value
	 *            String type containing the TC ID
	 */
	public static void setScriptName(String value) {
		scptName = value;
		if (scptName.contains(".")) {
			scptName = scptName.substring(scptName.lastIndexOf(".") + 1);
		}
	}

	/* This Function will get the name of script */
	public static String getScriptName() {
		return scptName;
	}

	/**
	 * This function will take comma separated value and return the array.
	 * 
	 * @param sInput
	 *            A comma separated value.
	 * 
	 * @return This will return the string of array
	 */
	public String[] splitValue(String sValue) {
		String sdata;
		String[] splitArray = null;
		try {
			sdata = sValue;
			splitArray = sdata.split(",");

		} catch (Exception e) {
			lowlevellogsobj.error(
					"Exception in splitValue:" + e.getMessage(), e);
		}
		return splitArray;
	}

	/**
	 * This function will take comma separated value and return webelement.
	 * 
	 * @param sInput
	 *            A comma separated value.
	 * 
	 * @return This will return webelement
	 */
	public void findDblClick0RowIndex(WebDriver driver, List<WebElement> sElementGroup, String toclickORnot) {

		int rowcount = sElementGroup.size();
		try {
			if(!toclickORnot.equals(Constants.C_NULL)){	

				// if the last column has data.
				for (int i = 0; i < rowcount; i++) {
					String data = sElementGroup.get(i).getAttribute("data-sap-ui-rowindex");

					if (data != null) {
						if (data.equals("0")) {
							Thread.sleep(1000);
							Actions action = new Actions(driver);
							action.moveToElement(sElementGroup.get(i)).doubleClick().build().perform();
							Thread.sleep(1000);
							break;
						}
					}
				}	
			}
		} catch (Exception e) {
			lowlevellogsobj.error(
					"Exception in findDblClick0RowIndex:" + e.getMessage(), e);
		}
	}



	/**
	 * This function will take comma separated value and return webelement.
	 * 
	 * @param sInput
	 *            A comma separated value.
	 * 
	 * @return This will return webelement
	 */
	public void findClickElement(WebDriver driver, List<WebElement> sElementGroup,
			String sElementTxt, String toclickORnot) {

		int rowcount = sElementGroup.size();
		try {
			if(toclickORnot != null && !toclickORnot.isEmpty()&& toclickORnot.equals(Constants.C_CLICK)){	

				// if the last column has data.
				for (int i = 0; i < rowcount; i++) {
					String data = sElementGroup.get(i).getText().toString();
					if (data != null) {
						if (data.trim().contains(sElementTxt)) {
							commonClick_Action(driver, sElementGroup.get(i),
									Constants.C_YES);

							break;
						}
					}
				}	
			}
		} catch (Exception e) {
			lowlevellogsobj.error(
					"Exception in findClickElement:" + e.getMessage(), e);
		}
	}

	/**
	 * This function will take comma separated value and return webelement.
	 * 
	 * @param sInput
	 *            A comma separated value.
	 * 
	 * @return This will return webelement
	 */
	public void findDblClickElement(WebDriver driver, List<WebElement> sElementGroup,
			String sElementTxt, String toclickORnot) {

		int rowcount = sElementGroup.size();
		Actions action = new Actions(driver);
		try {
			if(!toclickORnot.equals(Constants.C_NULL)){			
				// if the last column has data.
				for (int i = 0; i < rowcount; i++) {
					String data = sElementGroup.get(i).getText().toString();
					if (data != null) {
						if (data.trim().contains(sElementTxt)) {
							action.moveToElement(sElementGroup.get(i)).doubleClick().build().perform();
							break;
						}
					}
				}	
			}
		} catch (Exception e) {
			lowlevellogsobj.error(
					"Exception in findClickElement:" + e.getMessage(), e);
		}
	}


	public boolean comboBox_selectOptions(WebDriver driver,String sElementName,
			String sOptionValue, WebElement element) {

		boolean result = false;
		try {
			if (element == null) {
				result = false;
				return result;
			}
			// check whether the required option is already selected
			String actualstr = element.getText().toString();
			if (actualstr.equals(sOptionValue)) {
				result = true;
			} else {
				if (element.isEnabled()) {
					String str = sOptionValue.substring(0, 2);
					Actions builder = new Actions(driver);
					builder.click(element).sendKeys(str).click().build()
					.perform();

					// verify that the correct option is selected
					Thread.sleep(10000);
					String sElement = element.getText().toString();
					if (sElement.equals(sOptionValue)) {
						result = true;
					} else {
						result = false;
						CFMsgList.add("Incorrect value selected for: " + sElementName + " Actual is: "
								+ sElement + " ,Expected Value: "
								+ sOptionValue);
					}
				}
			}		
		} catch (Exception e) {
			lowlevellogsobj
			.error("Exception in comboBox_selectOptions: "
					+ e.getMessage(), e);
			result = false;
		}
		return result;
	}
	public boolean comboBox_VerifyOptions(WebDriver driver,
			String sOptionValue, WebElement element) {

		boolean result = false;
		try {
			if (element == null) {
				result = false;
				return result;
			}
			// check whether the required option is already selected
			String actualstr = element.getText().toString();
			if (actualstr.equals(sOptionValue)) {
				result = true;
			} 		else{				result = false;
			CFMsgList.add("incorrect value displayed. Actual is: "
					+ actualstr + " ,Expected Value: "
					+ sOptionValue);
			}			
		} catch (Exception e) {
			lowlevellogsobj
			.error("Exception in comboBox_selectOptions: "
					+ e.getMessage(), e);
			result = false;
		}
		return result;
	}

	public String captureDesktop(WebDriver driver) throws SAXException,
	IOException {
		DateFormat format = new SimpleDateFormat("dd.MM.yy_hh");
		String dtTime = format.format(new Date());
		String fileName = getScriptName() + " " + dtTime + ".png";
		new ReadProperties();
		String filePath =ReadProperties.readProperty("highLevelReport")
				+ "Snapshot_Pass\\" + fileName;

		try {
			File screenshot = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(filePath), true);

		} catch (RuntimeException e) {
			lowlevellogsobj.error(
					"RuntimeException in captureDesktop: " + e.getMessage(), e);
		} catch (IOException e) {
			lowlevellogsobj.error(
					"IOException in captureDesktop: " + e.getMessage(), e);
		}
		return filePath;
	}

	public WebElement lastElement(List <WebElement> elementlist)
			throws Exception {
		WebElement element = null;


		try {	
			WebElement [] elementarray = elementlist.toArray(new WebElement[elementlist.size()]);

			for (int i = 0; i < elementarray.length; i++ ) {
				element = elementarray[i];
				if (element.getAttribute("value").equals("") ) {
					element = elementarray[i - 1];
					break;
				}	
			}

		} catch (Exception e) {
			lowlevellogsobj.error(
					"Exception in lastElement:" + e.getMessage(), e);
			element = null;
		}	

		return element;
	}	

	public void clickUntilExpCond(WebDriver driver, WebElement elementtobeclicked, 
			String toclickORnot, String resultingelementID)
					throws Exception {

		try {
			while (driver.findElements( By.id(resultingelementID) ).size() == 0) {
				if (toclickORnot.equalsIgnoreCase(Constants.C_CLICK)) {
					commonClick(elementtobeclicked, toclickORnot);
				}
			}

		} catch (Exception e) {
			lowlevellogsobj.error(
					"Exception in clickUntilExpCond:" + e.getMessage(), e);
		}	

	}

	public void clickATIndex(WebDriver driver, String regexID, 
			String variablepart)
					throws NoSuchElementException, Exception {

		try { 


			if (!variablepart.equals(Constants.C_NULL)) {
				driver.findElement(By.id(regexID+variablepart)).click();
			}



		}   catch (NoSuchElementException e) {
			lowlevellogsobj.error(
					"NoSuchElementException in clickATIndex for :"
							+ e.getMessage(), e);

		} catch (Exception e) {
			lowlevellogsobj.error(
					"Exception in clickATIndex :" + e.getMessage(), e);

		}	

	}

	public boolean expectedValue(WebElement element, String attribute, 
			String expvalue, String compareornot)
					throws NoSuchElementException, Exception {

		boolean result = false;

		try { 

			if (!compareornot.equals(Constants.C_NULL)) {
				if (attribute.equals("text")) {
					if (element.getText().equalsIgnoreCase(expvalue)) {
						result = true;
					} else {
						Assert.fail("Expected text: " + expvalue + 
								"Actual text: "  + element.getText());
					}

				} else {
					if (element.getAttribute(attribute).equalsIgnoreCase(expvalue)) {
						result = true;
					} else {
						Assert.fail("Expected " + attribute + "value: " + expvalue + 
								"Actual " + attribute + "value: "  + element.getAttribute(attribute));

					} 

				}
			} else {
				result = true;
			}			

		}   catch (NoSuchElementException e) {
			lowlevellogsobj.error(
					"NoSuchElementException in expectedValue for :"
							+ e.getMessage(), e);
			result = false;
		} catch (Exception e) {
			lowlevellogsobj.error(
					"Exception in expectedValue :" + e.getMessage(), e);
			result = false;
		}	
		return result;

	}
	
	public boolean expectedlabelValue(WebElement element, String attribute, 
			String expvalue, String compareornot)
					throws NoSuchElementException, Exception {

		boolean result = false;

		try { 

			if (!compareornot.equals(Constants.C_NULL)) {
				if (attribute.contains("text")) {
					if (element.getText().contains(expvalue)) {
						result = true;
					} else {
						Assert.fail("Expected text: " + expvalue + 
								"Actual text: "  + element.getText());
					}

				} else {
					if (element.getAttribute(attribute).contains(expvalue)) {
						result = true;
					} else {
						Assert.fail("Expected " + attribute + "value: " + expvalue + 
								"Actual " + attribute + "value: "  + element.getAttribute(attribute));

					} 

				}
			} else {
				result = true;
			}			

		}   catch (NoSuchElementException e) {
			lowlevellogsobj.error(
					"NoSuchElementException in expectedValue for :"
							+ e.getMessage(), e);
			result = false;
		} catch (Exception e) {
			lowlevellogsobj.error(
					"Exception in expectedValue :" + e.getMessage(), e);
			result = false;
		}	
		return result;

	}

	public boolean expectedElementExists(WebDriver driver, String by, 
			String idenexpression, String checkornot)
					throws NoSuchElementException, Exception {

		boolean result = false;

		try { 

			if (!checkornot.equals(Constants.C_NULL)) {
				if (driver.findElements( By.id(idenexpression) ).size() != 0) {
					result = true;
				}if (driver.findElements( By.xpath(idenexpression) ).size() != 0) {
					result = true;
				} else {
					Assert.fail("Expected element not found");
					
				}

			} else {
				result = true;
			}			

		}   catch (NoSuchElementException e) {
			lowlevellogsobj.error(
					"NoSuchElementException in expectedElementExists for :"
							+ e.getMessage(), e);
			result = false;
		} catch (Exception e) {
			lowlevellogsobj.error(
					"Exception in expectedElementExists :" + e.getMessage(), e);
			result = false;
		}	
		return result;
	}

	/**
	 * This function click an element using java script
	 * 
	 * @param driver
	 *            WebDriver reference.
	 * @param element
	 *            Element which are going to click.
	 * 
	 * @throws Exception
	 *             if Element is not found exception occurred
	 */
	public void commonClick_JavaScript(WebDriver driver, WebElement element) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);

		} catch (Exception e) {
			lowlevellogsobj.error(
					"TimeoutException in commonWaitToFindElement for :"
							+ e.getMessage(), e);
		}
	}

	/**
	 * This function click an element using java script
	 * 
	 * @param driver
	 *            WebDriver reference.
	 * @param element
	 *            Element which are going to click.
	 * 
	 * @throws Exception
	 *             if Element is not found exception occurred
	 */
	public void commonSelect_JavaScript(WebDriver driver,String arg0, String arg1) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript(arg0,  arg1);

		} catch (Exception e) {
			lowlevellogsobj.error(
					"TimeoutException in commonFindClick_JavaScript for :"
							+ e.getMessage(), e);
		}
	}

	/**
	 * This function will Click on corresponding element using Action Builder
	 * class
	 * 
	 * @param iclickInfo
	 *            WebElement to be Clicked
	 * @param toclickORnot
	 *            Boolean type value to check whether to click Enter button
	 *            after selecting the element
	 * @throws IOException
	 *             if IO exception occurred
	 * @throws SAXException
	 *             ifSAX Exception occurred
	 * @throws ParserConfigurationException
	 *             if ParserConfiguration Exception occurred
	 */
	public void commonDoubleClick_Action(WebDriver driver, WebElement iclickInfo
			) throws IOException, SAXException,
	ParserConfigurationException {

		try {

			Actions actions = new Actions(driver);
			actions.doubleClick(iclickInfo).build().perform();
			Thread.sleep(1000); 


		} catch (Exception e) {
			lowlevellogsobj.error(
					"Exception in commonClick_Action:" + e.getMessage(), e);
		}
	}
	/**
	 * @param driver
	 *            WebDriver reference
	 * @param findElementBy
	 *            String type expression of finding the element using :
	 *            xpath/ID/CSS path
	 * @param expr
	 *            String type expression of xpath/ID/CSS path
	 * @return String text for WebDriver WebElement
	 * @throws TimeoutException
	 *             if time out exception occurred
	 */

	public String commonFindElement_GetText(WebDriver driver,
			String findElementBy, String expr) throws TimeoutException {

		WebElement element = null;
		String elementText = null;
		try {

			element = commonFindElement_GetElement(driver, findElementBy, expr);
			if (element != null) {
				elementText = element.getText();
			}

		} catch (NoSuchElementException e) {
			lowlevellogsobj.error(
					"NoSuchElementException in commonFindElement_GetText for :"
							+ e.getMessage(), e);
			element = null;
		} catch (TimeoutException e) {
			lowlevellogsobj.error(
					"TimeoutException in commonFindElement_GetText for :"
							+ e.getMessage(), e);
			element = null;
		} catch (Exception e) {
			lowlevellogsobj.error(
					"Exception in commonFindElement_GetText for :"
							+ e.getMessage(), e);
			element = null;
		}
		return elementText;
	}
	
	public String commonElement_GetText(WebElement element) throws TimeoutException {

		String elementText = null;
		try {

			if (element != null) {
				elementText = element.getText();
			}

		} catch (NoSuchElementException e) {
			lowlevellogsobj.error(
					"NoSuchElementException in commonFindElement_GetText for :"
							+ e.getMessage(), e);
			element = null;
		} catch (TimeoutException e) {
			lowlevellogsobj.error(
					"TimeoutException in commonFindElement_GetText for :"
							+ e.getMessage(), e);
			element = null;
		} catch (Exception e) {
			lowlevellogsobj.error(
					"Exception in commonFindElement_GetText for :"
							+ e.getMessage(), e);
			element = null;
		}
		return elementText;
	}
	
	/**
	 * @param driver
	 *            WebDriver reference
	 * @param findElementBy
	 *            String type expression of finding the element using :
	 *            xpath/ID/CSS path
	 * @param expr
	 *            String type expression of xpath/ID/CSS path
	 * @return boolean about the status of WebElement present
	 * @throws TimeoutException
	 *             if time out exception occurred
	 */
	public String commonFindElement_GetAttribute(WebDriver driver, String findElementBy, String expr,String sAttribute)
			throws TimeoutException {
		String sElem_Attribute="";
		WebElement element = null;
		try {

			if (findElementBy.equals("xpath")) {
				element = driver.findElement(By.xpath(expr));
			} else if (findElementBy.equals("id")) {
				element = driver.findElement(By.id(expr));
			} else if (findElementBy.equals("cssSelector")) {
				element = driver.findElement(By.cssSelector(expr));
			} else if (findElementBy.equals("linkText")) {
				element = driver.findElement(By.linkText(expr));
			} else if (findElementBy.equals("className")) {
				element = driver.findElement(By.className(expr));
			}

			if (element != null) {
				sElem_Attribute=element.getAttribute(sAttribute);
			}

		} catch (NoSuchElementException e) {
			lowlevellogsobj.error(
					"NoSuchElementException in commonFindElement_GetAttribute for :"
							+ e.getMessage(), e);
		} catch (TimeoutException e) {
			lowlevellogsobj.error(
					"TimeoutException in commonFindElement_GetAttribute for :"
							+ e.getMessage(), e);
		} catch (Exception e) {
			lowlevellogsobj.error(
					"Exception in commonFindElement_GetAttribute for :"
							+ e.getMessage(), e);
		}

		return sElem_Attribute;
	}
	
	/**
	 * @param driver
	 *            WebDriver reference
	 * @param timeOutInSeconds
	 *            integer type waiting time in second after that time out of
	 *            waiting
	 * @param eleBy
	 *             element to to be displyed
	 * @throws TimeoutException
	 *             if time out exception occurred
	 */
	public boolean commonWaitToDisplayElement(WebDriver driver,	int timeOutInSeconds, By eleBy)	throws TimeoutException {
		
		boolean result = false;
		WebElement element = null;
		try {
			// Element is Displayed
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

			element = wait.until(ExpectedConditions.visibilityOfElementLocated(eleBy));
			
			if (element != null) {
				result = true;
			} else {
				result = false;
			}
		} catch (TimeoutException e) {
			result = false;
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
	public WebDriver commonWaitForFrameToLoad(WebDriver driver,int timeOutInSeconds,int iIndex){

		WebDriver result = null;

		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

			result = wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iIndex));

		} catch (Exception e) {
			lowlevellogsobj.error("Exception in Common Functions :  " + e.getMessage(), e);
		}

		return result;
	}

	public WebDriver commonWaitForFrameToLoad(WebDriver driver,int timeOutInSeconds,String sId){

		WebDriver result = null;

		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

			result = wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(sId));

		} catch (Exception e) {
			lowlevellogsobj.error("Exception in Common Functions :  " + e.getMessage(), e);
		}

		return result;
	}
	
	public WebDriver commonWaitForFrameExist(WebDriver driver,int timeOutInSeconds,String sId){

		WebDriver result = null;

		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

			result = wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(sId));

		} catch (Exception e) {
			// Do Nothing
		}

		return result;
	}
	
	public WebDriver commonWaitForFrameToLoad(WebDriver driver,int timeOutInSeconds,By byDesc){

		WebDriver result = null;

		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

			result = wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(byDesc));

		} catch (Exception e) {
			lowlevellogsobj.error("Exception in Common Functions :  " + e.getMessage(), e);
		}

		return result;
	}
	
	
	
	/**
	 * @param driver
	 *            WebDriver reference
	 * @param timeOutInSeconds
	 *            integer type waiting time in second after that time out of
	 *            waiting
	 * @param eleBy
	 *             element to to be displyed
	 * @throws TimeoutException
	 *             if time out exception occurred
	 */
	public boolean commonWaitToDisplayElement(WebDriver driver,	int timeOutInSeconds, WebElement eleExpected)	throws TimeoutException {
		
		boolean result = false;
		WebElement element = null;
		try {
			// Element is Displayed
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

			element = wait.until(ExpectedConditions.visibilityOf(eleExpected));
			
			if (element != null) {
				result = true;
			} else {
				result = false;
			}
		} catch (TimeoutException e) {
			result = false;
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
	
	public String commonDateAdd(String sInputDate,int iDaysToAdd,String sInputDateFormat, String sOutputDateFormat){
		
		String result= "";
		
		SimpleDateFormat inputformatter=new SimpleDateFormat(sInputDateFormat);
		SimpleDateFormat outputformatter=new SimpleDateFormat(sOutputDateFormat);
		
		try {
			Date date=inputformatter.parse((sInputDate));
			Calendar calender=Calendar.getInstance();
			calender.setTime(date);
			calender.add(Calendar.DATE,iDaysToAdd);
			result=outputformatter.format(calender.getTime());
		} catch (Exception e) {
			lowlevellogsobj.error("Exception in commonDateAdd:  " + e.getMessage(), e);
		}
		
		return result;
	}
	
	public String commonGetCellData(String sWorkBookName,String ssSheetName, String sTCID, int iParameterPos){
		
		String result= "";
		
		try {
			String sFileName = ReadProperties.readProperty(sWorkBookName);
			FileInputStream file= new FileInputStream(new File(sFileName));
			XSSFWorkbook workbook=new XSSFWorkbook(file);
			XSSFSheet sheet=workbook.getSheet(ssSheetName);
			int iRowNo=DataSourceHelper.findRow(sheet, sTCID);
			Cell cell=sheet.getRow(iRowNo).getCell(iParameterPos);
			cell.setCellType(CellType.STRING);
			result=cell.getStringCellValue();
			
			workbook.close();
			file.close();
			
		} catch (IOException e) {

			lowlevellogsobj.error("Exception in commonGetCellData:  " + e.getMessage(), e);
		}
		
		return result;
	}
	
	public String commonGetCellData(String sWorkBookName,String ssSheetName, String sTCID, String sParameterName){
		
		String result= "";
	
		try {
			
			DataSourceHelper dataObj = new DataSourceHelper();
			List<String> list_TCData = new ArrayList<String>();
			HashMap<String, Integer> mapTCData = new HashMap<String, Integer>();
			
			list_TCData = dataObj.getTestData_List(sWorkBookName,ssSheetName, sTCID);
			mapTCData = dataObj.getHeaderMap_TestData(sWorkBookName,ssSheetName);
			
			result = list_TCData.get(mapTCData.get(sParameterName)).toString();
			
		} catch (Exception e) {
			lowlevellogsobj.error("Exception in commonGetCellData:  " + e.getMessage(), e);
		}
		return result;
	}
	
	public String getParameter(List<String> testArray_Data,HashMap<String, Integer> headerMap_Data,String sParametrName){
		
		String sTempValue = "";
		int iTestDataSize = testArray_Data.size();
		
		//Get Parameter Index
		int iParaIndex = headerMap_Data.get(sParametrName);
		if(iParaIndex < iTestDataSize){
			sTempValue = testArray_Data.get(headerMap_Data.get(sParametrName)).toString().trim();
		}
		
		return sTempValue;		
	}
	
	public void commonFindElement_enterText(WebDriver driver, String findElementBy, String expr, String toclickORnot,String Value)
			throws IOException, SAXException, ParserConfigurationException {

		try {
			WebElement iclickInfo = commonFindElement_GetElement(driver, findElementBy, expr);
			if (iclickInfo != null) {
				if (!toclickORnot.equals(Constants.C_NULL)) {
					
					iclickInfo.clear();
					Thread.sleep(500);
					iclickInfo.sendKeys(Value);
					Thread.sleep(500);
					}
				}
			
			
		} catch (Exception e) {
			LowLevelLogs.getLogger().error("Exception in commonClick:" + e.getMessage(), e);
		}
	}
	
	//Select value from Combo
	
	public void comboSelect(WebDriver driver,String expValue, WebElement ele) throws IOException, SAXException, ParserConfigurationException{
		if(!(expValue.equals(Constants.C_NOTAPPLICABLE))){
			commonClick(ele, "");
            List<WebElement> element=getElements(driver, "xpath", "//li");
            String actProduct="";
            for(int i=0;i<=element.size()-1;i++){
            	actProduct=element.get(i).getText();
            	if(actProduct.equalsIgnoreCase(expValue)){
            		commonClick_Action(driver,element.get(i), Constants.C_YES);
            		break;
            	}
            	
            }
            
			
            
		}
	}
	
	public void selectComboval(WebDriver driver,String expValue, WebElement ele, String idName) throws IOException, SAXException, ParserConfigurationException{
		if(!(expValue.equals(Constants.C_NOTAPPLICABLE))){
			commonClick(ele, "");
            List<WebElement> element=getElements(driver, "xpath", "//li[contains(@id,'"+idName+"')]");
            String actProduct="";
            for(int i=0;i<=element.size()-1;i++){
            	actProduct=element.get(i).getText();
            	if(actProduct.equals(expValue)){
            		commonClick(element.get(i), Constants.C_YES);
            		break;
            	}
            	
            }
            
			
            
		}
	}
	
	public String dateTimeGenerate(){
		   String dateTime="";
		   try{
			   SimpleDateFormat dtNow=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		       String currentDate=dtNow.format(new Date());
		       String[] val=currentDate.split(" ");
		       String newDate=val[0].replaceAll("/", "");
		       String newTime=val[1].replaceAll(":", "");
		       dateTime=newDate+"_"+newTime;   
		   }catch(Exception e){
			   LowLevelLogs.getLogger().error("Exception in creating date & time string: " + e.getMessage(), e);
		   }
		   
	       return dateTime;
	   }
	
	public boolean compareValue(WebDriver driver, String expr,String fieldName, String exp){
		boolean result=false;
		String act = commonFindElement_GetAttribute(driver, "xpath", expr, "value");
		if (act.equalsIgnoreCase(exp)){
			lowlevellogsobj.info("Value is displayed as expected for "+fieldName+" ->"+act);
			result=true;
		}
		else{
			lowlevellogsobj.info(""+fieldName+" value is NOT displayed as expected");
			result=false;
		}
		return result;
	}
	public void waitUntilDocumentIsReady(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver arg0) {
				return ((JavascriptExecutor) arg0).executeScript("return document.readyState").equals("complete");
			}
		});
	}
	
	public String[] splitValue(String sValue, String sSplitBy) {
		String sdata;
		String[] splitArray = null;
		try {
			sdata = sValue;

			switch (sSplitBy) {
			case Constants.C_SPLIT_COMMA:
				splitArray = sdata.split(",");
				break;
			case Constants.C_SPLIT_DOT:
				splitArray = sdata.split("\\.");
				break;
			case Constants.C_SPLIT_SPACE:
				splitArray = sdata.split("\\s+");
				break;
			case Constants.C_SPLIT_OPENING_PARENTHESES:
				splitArray = sdata.split("\\(");
				break;
			case Constants.C_SPLIT_SEMICOLON:
				splitArray = sdata.split(";");
				break;
			case Constants.C_SPLIT_COLON:
				splitArray = sdata.split(":");
				break;
			default:
				break;
			}
		} catch (Exception e) {
			LowLevelLogs.getLogger().error(
					"Exception in splitValue:" + e.getMessage(), e);
			splitArray = null;
		}
		return splitArray;
	}	
	public WebDriver getHandleToWindow(WebDriver driver,String title){
		 
        parentWindowHandle = driver.getWindowHandle(); // save the current window handle.
        WebDriver popup = null;
        Set<String> windowIterator = driver.getWindowHandles();
        System.err.println("No of windows :  " + windowIterator.size());
        for (String s : windowIterator) {
          String windowHandle = s; 
          popup = driver.switchTo().window(windowHandle);
          System.out.println("Window Title : " + popup.getTitle());
          System.out.println("Window Url : " + popup.getCurrentUrl());
          if (popup.getTitle().equals(title) ){
              System.out.println("Selected Window Title : " + popup.getTitle());
              return popup;
          }

        }
                System.out.println("Window Title :" + popup.getTitle());
                System.out.println();
            return popup;
        }

 public void movetoparentWindow(WebDriver driver){
	  driver.switchTo().window(parentWindowHandle);
 }
 
 public static String convertTime_MSToMinSec(long sTime_ms) {
		String str_exectime = null;
		long elapsedTime_sec, elapsedTime_min;
		try {
			elapsedTime_sec = (long) (0.001 * sTime_ms) % 60;
			elapsedTime_min = (long) (0.001 * sTime_ms) / 60;

			if (elapsedTime_sec != 0 && elapsedTime_min != 0) {
				str_exectime = String.valueOf(elapsedTime_min) + " mins "
						+ String.valueOf(elapsedTime_sec) + " sec";
			} else if (elapsedTime_min != 0) {
				str_exectime = String.valueOf(elapsedTime_min) + " min";
			} else if (elapsedTime_sec != 0) {
				str_exectime = String.valueOf(elapsedTime_sec) + " sec ";
			}
		} catch (Exception e) {
			lowlevellogsobj.error(
					"Exception in getTimeMin_Sec:" + e.getMessage(), e);
			str_exectime = null;
		}
		return str_exectime;
	} 
 
 public String convertodecimal(String excelValue){
		
		long num = Long.parseLong(excelValue);
		DecimalFormat df = new DecimalFormat("##,#####");
		String temp1 = df.format(num);
		return temp1;
	}
 public boolean commonWaitToNotDisplayElement(WebDriver driver,	int timeOutInSeconds, WebElement eleExpected)	throws TimeoutException {
		
		boolean result = false;
		try {
			// Element is Displayed
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

			result = wait.until(ExpectedConditions.invisibilityOf(eleExpected));

		} catch (TimeoutException e) {
			result = false;
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
}


