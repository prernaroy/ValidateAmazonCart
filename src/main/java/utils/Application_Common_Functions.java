package utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.SAXException;

import com.google.common.base.Function;



public class Application_Common_Functions {

	public ArrayList<String> LoginMsgList = new ArrayList<String>();
	private static final Logger lowlevellogsobj = Logger.getLogger(Application_Common_Functions.class);
	private Common_Functions cfobj = new Common_Functions();

	public void clickComponentDescrition(WebDriver driver, List <WebElement> elementlist, 
			String attributevalue)
					throws Exception {
		WebElement element = null;
		try {
			WebElement [] elementarray = elementlist.toArray(new WebElement[elementlist.size()]);
			for (int i = 0; i < elementarray.length; i++ ) {
				element = elementarray[i];	
				try {
					element.click();
				}catch (Exception e) {
					//do nothing
				}
				if (!(driver.findElements( By.id("id_compAdd_table_column1-menu-filter-tf") ).size() == 0)) {
					break;
				}
			}
		} catch (Exception e) {
			lowlevellogsobj.error(
					"Exception in clickComponentDescrition :" + e.getMessage(), e);
		}	
	}

	public WebElement fluentWaitMethod(WebDriver driver, int time,final By locator){

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(time,TimeUnit.SECONDS)
				.pollingEvery(500, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement foundElement = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}

		});
		return foundElement;
	}

	public WebDriver switchtoFrame(WebDriver driver){
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[contains(@title, 'The title of the hosted application within the canvas area')]")));
		WebDriver lhsFrame = driver.switchTo().frame("WorkAreaFrame1");
		return lhsFrame;
	}

	public void switchtopopupWindow(WebDriver driver, String MainWindowhandle){
		Set<String> windowHandles = driver.getWindowHandles();
		if(windowHandles.size() > 1){
			for(String handle : windowHandles){
				System.out.println("Now Handle ID is:"+ handle);
				if(handle.equalsIgnoreCase(MainWindowhandle)){
					System.out.println("This is Parent Window Handle");
				}else {
					System.out.println("This is Child Window Handle");
					driver.switchTo().window(handle);
				}
			}
		}else {
			Set<String> windowHandles1 = driver.getWindowHandles();
			if(windowHandles.size() > 1){
				for(String handle1 : windowHandles1){
					System.out.println("Now Handle ID is:"+ handle1);
					if(handle1.equalsIgnoreCase(MainWindowhandle)){
						System.out.println("This is Parent2 Window Handle");
					}else {
						System.out.println("This is Child2 Window Handle");
						driver.switchTo().window(handle1);
					}
				}
			}
		}
	}

	public void clickNavigationItem(WebDriver driver, String sItemName) throws Exception {
		boolean blnItemFound = false;
		WebElement eleScroll = driver.findElement(By.xpath("//*[contains(@onclick, 'pro54_scroll_nav')]"));
		try {

			for(int iIteration = 1;iIteration < 10; iIteration++){

				List<WebElement> eleNavItems = driver.findElements(By.xpath("//ul[@id='ul_nav_1']/li/a/span"));

				for(WebElement eleItem:eleNavItems){
					String sDescription = eleItem.getText().trim();
					String sNewDescription = sDescription.replaceAll("\n", " ");
					if(sNewDescription.equalsIgnoreCase(sItemName)){	
						if(eleItem.isDisplayed()){
							blnItemFound = true;
							eleItem.click();
							break;
						}

					}
				}

				if(blnItemFound){
					break;
				}else{
					eleScroll.click();
					Thread.sleep(1000);
				}

			}

			if(!blnItemFound){
				lowlevellogsobj.error("Navigation item Not Found");
			}

		} catch (Exception e) {
			lowlevellogsobj.error(
					"Exception in clickNavigationItem :" + e.getMessage(), e);
		}	
	}

	/**
	 * @param driver
	 *            WebDriver reference
	 * @param timeOutInSeconds
	 *            integer type waiting time in second after that time out of
	 *            waiting
	 * @throws TimeoutException
	 *             if time out exception occurred
	 * @throws InterruptedException 
	 */
	public boolean commonWaitForWaitIconDisappear(WebDriver driver,int timeOutInSeconds) throws TimeoutException, InterruptedException {

		boolean result = false;

		Thread.sleep(2000);
		String sExpression = "//div[@class='lsLoadAItem lsLoadAItem2Display lsLoadAItem2Delay lsLoadImg']";

		boolean isDisappear;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			isDisappear = false;

			isDisappear = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(sExpression)));
			result = isDisappear;
		} catch (Exception e) {
			//e.printStackTrace();
		}

		Thread.sleep(2000);
		return result;
	}
	public boolean checkSavemessage(WebDriver driver, String msg) {
		boolean result = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15000);

			if ((wait.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'" + msg + "')]")))) != null) {
				lowlevellogsobj.info("Save message is showing properly ::" + msg);
			} else {
				lowlevellogsobj.error("Save message is not showing properly ::" + msg);
			}
			//cfobj.waitUntilDocumentIsReady(driver);
			result = true;
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
	public boolean messageVerificationPartner(WebDriver driver,String sExpMsg){
    	boolean result=true; boolean result1=false;
    	try {
    		
    		if(!(sExpMsg.contains(";"))){
    			String actMsg=cfobj.commonFindElement_GetText(driver, "xpath", "//table[contains(@aria-labelledby,'idConsistencyTable-header')]/tbody/tr[1]/td[6]/span");
    			if(actMsg.equals(sExpMsg)){
    				result=true;
    			}else{
    				result=false;
    			}
    			return result;
    		}
			List<WebElement>msgList=cfobj.getElements(driver, "xpath", "//table[contains(@aria-labelledby,'idConsistencyTable-header')]/tbody/tr/td[6]/span");
			String[]expMsg=cfobj.splitValue(sExpMsg,Constants.C_SPLIT_SEMICOLON);
			String[] actMsg=new String[msgList.size()];
			for(int i=0;i<=msgList.size()-1;i++){
				result1=false;
				int k=i+1;
				actMsg[i]=cfobj.commonFindElement_GetText(driver, "xpath", "//table[contains(@aria-labelledby,'idConsistencyTable-header')]/tbody/tr["+k+"]/td[6]/span");
				
				for(int j=0;j<=expMsg.length-1;j++){
					if(actMsg[i].equalsIgnoreCase(expMsg[j])){
						result1=true;
						break;
					}
				}
				if(result1==false){
					lowlevellogsobj.error(actMsg+" does not match with "+expMsg);
					
				}
				result=result&&result1;
			}
			if(msgList.isEmpty()){
				result=false;
			}
			
		} catch (Exception e) {
			lowlevellogsobj.error(
					"Exception in message verification: " + e.getMessage(), e);
			result = false;
		}
    	return result;
    }
	
public void catchDump(WebDriver driver) throws IOException, SAXException, ParserConfigurationException, InterruptedException{
	if(driver.findElements(By.xpath("//a[text()='Show Details']")).size()==1){
		cfobj.commonFindElement_Click(driver, "xpath", "//a[text()='Show Details']", "Yes");
		Thread.sleep(1000);
		String geterrorText = cfobj.commonFindElement_GetText(driver, "xpath", "//div[contains(@class,'sapMMessageBoxDetails')]");
		lowlevellogsobj.info(geterrorText);
		cfobj.commonFindElement_Click(driver, "xpath", "//footer//*[text()='Close']", "Yes");
	}
}
public void clickGridele(WebDriver driver, String excelInput,String table,WebElement cmbType,String cmbValue, WebElement applyBtn ) throws IOException, SAXException, ParserConfigurationException, InterruptedException {
		try{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		String strSplit [] = excelInput.split("\\|");
		int totalRows=driver.findElements(By.xpath(table)).size();
				for(int i=0; i<totalRows; i++)
				
				{
					WebElement ele = driver.findElement(By.xpath("//span[text()='"+strSplit[i]+"']"));
					cfobj.commonClick_Action(driver, ele, "Yes");
					Thread.sleep(3000);
					cfobj.waitUntilDocumentIsReady(driver);
					//wait.until(ExpectedConditions.visibilityOf(cmbType));
					if(cmbType.isDisplayed()==true){
					cfobj.comboSelect(driver, cmbValue, cmbType);
					Thread.sleep(2000);
					}
					cfobj.commonClick(applyBtn, "Yes");
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+strSplit[i]+"']")));
					
				}
		}catch(Exception e){
			lowlevellogsobj.info("Element Not Found");
		}
}
		
}