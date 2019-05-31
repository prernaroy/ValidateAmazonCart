package utils;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
//import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
	
	private static final Logger lowlevellogsobj = Logger.getLogger(DriverFactory.class);
	
	public static WebDriver createDriver() {
		DesiredCapabilities capability;

		LoggingPreferences logs = new LoggingPreferences();	// New by I313006
		logs.enable(LogType.BROWSER, Level.ALL);	// New by I313006
		logs.enable(LogType.CLIENT, Level.ALL);		// New by I313006
		logs.enable(LogType.DRIVER, Level.ALL);		// New by I313006
		logs.enable(LogType.PERFORMANCE, Level.ALL);// New by I313006
		logs.enable(LogType.PROFILER, Level.ALL);	// New by I313006
		logs.enable(LogType.SERVER, Level.ALL);		// New by I313006

		String browser = ReadProperties.readProperty("browser").toLowerCase();
		//String sUserAgent = ReadProperties.readProperty("UserAgent");
		//String sExecutionDeviceType = ReadProperties.readProperty("ExecutionDeviceType");
		//String sDeviceName = ReadProperties.readProperty("DeviceName");
		
		WebDriver driver = null;
		boolean blnExecuteRemotely = false;
		
		//To Run Scripts Remotely
		String sRemoteMachineName = System.getProperty("RemoteMachineName");
		String sRemoteMachinePort = System.getProperty("RemoteMachinePort");
		
		if(sRemoteMachineName == null || sRemoteMachinePort == null){
			
			String sExecutionMachineType = ReadProperties.readProperty("ExecutionMachineType").toLowerCase();
			
			String sLocalMachineName = "";
			String sLocalMachinPort = "";
			
			if(sExecutionMachineType.equalsIgnoreCase("remote")){
				sLocalMachineName = ReadProperties.readProperty("RemoteMachineName").toLowerCase();
				sLocalMachinPort = ReadProperties.readProperty("RemoteMachinePort").toLowerCase();
			}
			
			if(sLocalMachineName == null || sLocalMachineName.equalsIgnoreCase("") || sLocalMachinPort == null || sLocalMachinPort.equalsIgnoreCase("")){
				blnExecuteRemotely = false;
			}else{
				sRemoteMachineName =  sLocalMachineName;
				sRemoteMachinePort =  sLocalMachinPort;
				blnExecuteRemotely = true;
			}
		}else{
			blnExecuteRemotely = true;
		}
				
		
		try {


			if (browser.equals("chrome")) {
				System.out.println("browser = " + browser);
				
				ChromeOptions options = new ChromeOptions();
				options.addArguments("disable-infobars");
				//options.addArguments("--user-agent=" + sUserAgent);
				
				/*if(sExecutionDeviceType.equalsIgnoreCase("MOBILE")){
					Constants.C_DEVICE_TYPE = "MOBILE";
					Map<String, String> mobileEmulation = new HashMap<String, String>();
					mobileEmulation.put("deviceName", sDeviceName);
					options.setExperimentalOption("mobileEmulation", mobileEmulation);
				}*/				
				
				capability = DesiredCapabilities.chrome();
				capability.setBrowserName("chrome");
				capability.setCapability(ChromeOptions.CAPABILITY, options);				
				
				System.setProperty("webdriver.chrome.driver", ReadProperties.readProperty("driver") + "chromedriver.exe");
				
				if(blnExecuteRemotely){
					driver = new RemoteWebDriver(new URL("http://" + sRemoteMachineName + ":" + sRemoteMachinePort + "/wd/hub"), capability);
				}else{
					driver = new ChromeDriver(capability);
				}
				
				
			} else if (browser.equals("firefox")) {
				
				System.out.println("browser = " + browser);
				capability = DesiredCapabilities.firefox();
				capability.setBrowserName("firefox");
				capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				capability.setCapability(CapabilityType.LOGGING_PREFS, logs);
				
				System.setProperty("webdriver.gecko.driver", ReadProperties.readProperty("driver") + "geckodriver.exe");
				
				if(blnExecuteRemotely){
					driver = new RemoteWebDriver(new URL("http://" + sRemoteMachineName + ":" + sRemoteMachinePort + "/wd/hub"), capability);
				}else{
					driver = new FirefoxDriver(capability);
				}
				
			} else if (browser.equals("safari")) {
				System.out.println("browser = " + browser);
				capability = DesiredCapabilities.safari();
				capability.setBrowserName("safari");				
				
				if(blnExecuteRemotely){
					driver = new RemoteWebDriver(new URL("http://" + sRemoteMachineName + ":" + sRemoteMachinePort + "/wd/hub"), capability);
				}else{
					driver = new SafariDriver();
				}
				
			} else if (browser.equals("internetexplorer")) {
				System.out.println("browser = " + browser);
				//capability = DesiredCapabilities.internetExplorer();
				//capability.setBrowserName("internet explorer");
				InternetExplorerOptions IEOptions = new InternetExplorerOptions();
				IEOptions.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
				IEOptions.ignoreZoomSettings();
				IEOptions.introduceFlakinessByIgnoringSecurityDomains();
				IEOptions.enableNativeEvents();
				IEOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				//IEOptions.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
				IEOptions.setCapability(CapabilityType.SUPPORTS_NETWORK_CONNECTION, true);			
				//capability.setCapability("requireWindowFocus", true);
				/*System.setProperty("webdriver.ie.driver", ReadProperties.readProperty("driver") + "IEDriverServer.exe");
				capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				//System.setProperty("webdriver.ie.driver",ReadProperties.readProperty("driver") + "IEDriverServer.exe");
				capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				capability.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);*/
				
				if(blnExecuteRemotely){
					driver = new RemoteWebDriver(new URL("http://" + sRemoteMachineName + ":" + sRemoteMachinePort + "/wd/hub"), IEOptions);
				}else{
					//driver = new InternetExplorerDriver(capability);
					System.setProperty("webdriver.ie.driver", ReadProperties.readProperty("driver") + "IEDriverServer.exe");
					driver = new InternetExplorerDriver(IEOptions);
				}
				
			} else if (browser.equals("phantomjs")) {
				System.out.println("browser = " + browser);
				capability = DesiredCapabilities.phantomjs();
				System.setProperty("phantomjs.binary.path", ReadProperties.readProperty("driver") + "phantomjs.exe");
				
				if(blnExecuteRemotely){
					driver = new RemoteWebDriver(new URL("http://" + sRemoteMachineName + ":" + sRemoteMachinePort + "/wd/hub"), capability);
				}else{
					//driver = new PhantomJSDriver(capability);
				}
			} else {
				System.out.println("browser(Default) = " + browser);
				ChromeOptions options = new ChromeOptions();
				options.addArguments("disable-infobars");
				
				capability = DesiredCapabilities.chrome();
				capability.setBrowserName("chrome");
				capability.setCapability(ChromeOptions.CAPABILITY, options);				
				
				System.setProperty("webdriver.chrome.driver", ReadProperties.readProperty("driver") + "chromedriver.exe");
				
				if(blnExecuteRemotely){
					driver = new RemoteWebDriver(new URL("http://" + sRemoteMachineName + ":" + sRemoteMachinePort + "/wd/hub"), capability);
				}else{
					driver = new ChromeDriver(capability);
				}
			}


		} catch (Exception e) {

			lowlevellogsobj.error(
					"Exception in DriverFactory for " + browser
					+ "  :" + e.getMessage(), e);
		}

		return driver;

	}
	
	public String getOSType(){
		
		String sOSType = "NONE";
		
		String OS = System.getProperty("os.name").toLowerCase();
		
		if (OS.indexOf("win") >= 0) {
			sOSType = "WINDOWS";
		} else if (OS.indexOf("mac") >= 0) {
			sOSType = "MAC";
		} else if (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0) {
			sOSType = "LINUX";
		} else if (OS.indexOf("sunos") >= 0) {
			sOSType = "SOLARIS";
		} else {
			System.out.println("Your OS is not support!!");
		}
		
		return sOSType;
	}
}
