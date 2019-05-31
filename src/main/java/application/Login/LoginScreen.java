/**
 * This Code is Property of SAP Labs and is Copyright.
 * Distribution and Copying is Prohibited without
 * Approval OR Permission.
 *
 * @author I313006 / Nov 26, 2017
 */
package application.Login;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.SAXException;

import logs.LowLevelLogs;
import utils.Common_Functions;
import utils.Constants;

/**
 * @author I313006
 *
 */
public class LoginScreen {

	private Common_Functions commfunct_Obj = new Common_Functions();
	// private Application_Common_Functions Appcommfunct_Obj = new
	// Application_Common_Functions();

	public ArrayList<String> MsgList = new ArrayList<String>();
	private static final Logger lowlevellogsobj = Logger.getLogger(LoginScreen.class);

	public LoginScreen(WebDriver driver) {
	}

	@FindBy(id = "USERNAME_FIELD-inner")
	private WebElement txt_Username;

	@FindBy(id = "PASSWORD_FIELD-inner")
	private WebElement txt_Password;

	@FindBy(xpath = "//div[@class='sapUiSraLoginButtonBlock']//span[1][text()='Log On']")
	private WebElement btn_LogOn;

	// Add id for Financing Workplace
	@FindBy(xpath = "//h1[(text()='Home')]")
	private WebElement checkLandingScreen;

	// Add id for Clicking Create Financing
	@FindBy(xpath = "//div/span/span[(text()='Create Financing')]")
	private WebElement CreateFinancing;

	// Add id for Clicking Manage Financing
	@FindBy(xpath = "//div/span/span[(text()='Manage Financing Deals')]")
	private WebElement ManageFinancing;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement txtSearch;

	// Add id for Clicking Manage Financing
	@FindBy(xpath = "//div/span/span[(text()='My Inbox for Financing Workplace')]")
	private WebElement InboxWP;

	public String landingPage = "//h2[contains(text(),'Master Data')]";
	public String CFTile = "//div/span/span[(text()='Create Financing')]";
	public String MFTile = "//div/span/span[(text()='Manage Financing Deals')]";
	public String MyinboxTile = "//div/span/span[(text()='My Inbox')]";
	public String MyInboxWP = "//div/span/span[(text()='My Inbox for Financing Workplace')]";
	public String xpUsername = "USERNAME_FIELD-inner";
	public String xpPassword = "PASSWORD_FIELD-inner";
	public String xpLogOn = "//div[@class='sapUiSraLoginButtonBlock']//span[1][text()='Log On']";
	public String xpSearch = "//input[@type='search']";

	public boolean inputLogin(WebDriver driver, List<String> testArray_Data, HashMap<String, Integer> headerMap_Data)
			throws InterruptedException, IOException, SAXException, ParserConfigurationException {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		boolean result = true;
		boolean result1=false;

		String sUserName = commfunct_Obj.getParameter(testArray_Data, headerMap_Data, Constants.C_LOGIN_UserName);
		String sPassword = commfunct_Obj.getParameter(testArray_Data, headerMap_Data, Constants.C_LOGIN_Password);
		
		
		try {
			lowlevellogsobj.info("Started in Login Class");
			Thread.sleep(3000);

			lowlevellogsobj.info("Entering Login Details");
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(xpUsername)));
			commfunct_Obj.commonSetTextTextBox(txt_Username, sUserName);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(xpPassword)));
			commfunct_Obj.commonSetTextTextBox(txt_Password, sPassword);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpLogOn)));
			//commfunct_Obj.commonClick(btn_LogOn, sIsLogOn);

			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(landingPage)));
			System.out.println(checkLandingScreen.getText());
			lowlevellogsobj.info("Checking if Landed on Correct Screen");
			commfunct_Obj.expectedValue(checkLandingScreen, "text", "Home", "Yes");
			lowlevellogsobj.info("Landed successfully on Home Page");
			Thread.sleep(4000);
			
      	  
			
			

		} catch (Exception e) {
			LowLevelLogs.getLogger().error("Exception in inputLogin:  " + e.getMessage(), e);
			result = false;
		} 

			
		

		return result;

	}

}