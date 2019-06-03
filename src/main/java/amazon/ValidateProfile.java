package amazon;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.SAXException;
import logs.LowLevelLogs;
import utils.Common_Functions;
import utils.Constants;

public class ValidateProfile {
	
	private Common_Functions commfunct_Obj = new Common_Functions();
	public ArrayList<String> MsgList = new ArrayList<String>();
	private static final Logger lowlevellogsobj = Logger.getLogger(ValidateProfile.class);
	String data="Your Account";
	String mobile_name="Samsung";

	public ValidateProfile(WebDriver driver) {
	}

	@FindBy(xpath = "//span[@class='nav-line-2' and text()='Your Orders']")
	public WebElement btn_loginlnk;

	@FindBy(xpath = "//input[@name='email']")
	private WebElement txt_email;
	
	@FindBy(xpath ="//input[@name='password']")
	private WebElement txt_pass;
	
	@FindBy(xpath ="//a[@class='nav-a nav-a-2 nav-truncate']")
	private WebElement txt_account;
	
	@FindBy(xpath ="(//div[@class='a-column a-span9 a-span-last'])[2]")
	private WebElement account_details;
	
	@FindBy(xpath ="(//div[@class='a-fixed-right-grid-col a-col-left'])[2]//div[@class='a-row'][2]")
	private WebElement emailid;
	
	@FindBy(xpath ="//input[@type='text']")
	private WebElement search_field;
	
	@FindBy(xpath ="//span[@class='a-dropdown-prompt']")
	private WebElement drop_down;
	
	@FindBy(xpath ="//span[@class='a-size-medium a-color-base a-text-normal']")
	private WebElement select_phone;
	
	@FindBy(xpath ="//div[@class='a-popover-inner']//ul//li//a[text()='Price: High to Low']")
	private WebElement filter_select;
	
	
	@FindBy(xpath ="//input[@title='Add to Shopping Cart']")
	private WebElement Add_Cart;
	
	@FindBy(xpath ="//*[@class='a-row a-size-medium huc-v2-color-success']")
	private WebElement Added_Cart;
	
	@FindBy(xpath ="(//a[@class='a-button-text'])[1]")
	private WebElement Cart;	
	
	@FindBy(xpath ="(//span[@class='a-button-inner']//span[@role='button'])[1]")
	private WebElement Quan_button;
	
	@FindBy(xpath ="//div[@class='a-popover-inner']/ul/li[2]")
	private WebElement Quantity;
	
	String username="//input[@name='email']";
	String password="//input[@name='password']";
	String landing_page="//span[@class='nav-line-2' and text()='Your Orders']";
	String mobile="//*[text()='****']";
	
	
	
public boolean ValidateProfile_details(WebDriver driver, List<String> testArray_Data,
		HashMap<String, Integer> headerMap_Data)
		throws InterruptedException, IOException, SAXException, ParserConfigurationException {

	boolean result = true;
	
	WebDriverWait wait = new WebDriverWait(driver, 100);
	
	String sUsername = commfunct_Obj.getParameter(testArray_Data, headerMap_Data,
			Constants.C_UserName);
	String sPassword = commfunct_Obj.getParameter(testArray_Data, headerMap_Data,
			Constants.C_Password);
	
	try {
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		commfunct_Obj.commonClick(btn_loginlnk, "Yes");
		lowlevellogsobj.info("Entering Login Details");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(username)));
		commfunct_Obj.commonSetTextTextBox(txt_email, sUsername);
		System.out.println("username is:"+sUsername);
		txt_email.sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(password)));
		commfunct_Obj.commonSetTextTextBox(txt_pass, sPassword);
		System.out.println("Password is:"+sPassword);
		txt_pass.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		commfunct_Obj.commonClick(txt_account, "Yes");
		commfunct_Obj.commonClick(account_details, "Yes");
		String e_mail=commfunct_Obj.commonElement_GetText(emailid);
		
		
		
		if(e_mail.equalsIgnoreCase(sUsername))
		{
			lowlevellogsobj.info("Authentication is successfull");
			lowlevellogsobj.info("Adding items in cart");
		System.out.println("Validation is successfull");
		System.out.println("Adding items in cart");
		commfunct_Obj.commonClick(search_field, "Yes");
		commfunct_Obj.commonSetTextTextBox(search_field, this.mobile_name);
		search_field.sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.mobile.replace("****", this.mobile_name))));
		commfunct_Obj.commonClick(drop_down, "Yes");
		List<WebElement> drop_down=driver.findElements(By.xpath("//div[@class='a-popover-inner']//ul//li//a"));
		for(int i=0;i<drop_down.size();i++)
		{
			String feature_data=drop_down.get(i).getText();
			System.out.println(feature_data);
				
		}
		lowlevellogsobj.info("Selected item in cart is :" +this.mobile_name);
		commfunct_Obj.commonClick(filter_select, "Yes");
		commfunct_Obj.commonClick(select_phone,"Yes");
		
		Set<String> handles = driver.getWindowHandles();
				
        for (String handle1 : handles) {

            driver.switchTo().window(handle1);

        }
        commfunct_Obj.commonClick(Add_Cart,"Yes");
        lowlevellogsobj.info("Item is added to the cart");
        lowlevellogsobj.info("Item is added to cart!!!!!!!!Please proceed");            
        commfunct_Obj.commonClick(Cart,"Yes");  
        commfunct_Obj.commonClick(Quan_button,"Yes");
        commfunct_Obj.commonClick(Quantity,"Yes");
        Thread.sleep(1000);
        System.out.println("Quantity added");
        lowlevellogsobj.info("Quantity added successfully");
		}
	
	
	}

	catch (Exception e) {
		LowLevelLogs.getLogger().error("Exception in entering Login Detail:  " + e.getMessage(), e);
		result = false;
	}
	
	return result;
		
}
	}


