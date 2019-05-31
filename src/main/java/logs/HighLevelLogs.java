package logs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.ProcessingInstruction;
import org.xml.sax.SAXException;

import utils.Common_Functions;
import utils.Constants;
import utils.ReadProperties;

@SuppressWarnings("rawtypes")
public class HighLevelLogs {
	// >>>>>>>> #region " Variable declaration "
	/**
	 * To specify date format.
	 */
	private static DateFormat format = new SimpleDateFormat("dd.MM.yy_hh.mm.ss");
	/**
	 * To get the current date value.
	 */
	private static Date date = new Date();
	/**
	 * To get formated current date value.
	 */
	private static String dtTime = format.format(date);
	/**
	 * To store high level log file name.
	 */
	private static String highlevelFileName = "";
	/**
	 * To store high level log report file path.
	 */
	private static String highlevelRptPath = "";
	/**
	 * Declaration of Document object reference which will assign Document
	 * object.
	 */
	private static Document document;
	/**
	 * Declaration of PrintStream object reference which will assign PrintStream
	 * object.
	 */
	private PrintStream printStream;

	/**
	 * @param type
	 */
	private void validateLogDiretory() {
		try {
			File highLevelFilePath = null;
			File highLevelFile = null;

			highLevelFilePath = new File(getHighLevelLoggerPath());
			highlevelRptPath = "HighLevelReport_" + dtTime + ".xml";
			highlevelFileName = getHighLevelLoggerPath() + highlevelRptPath;
			highLevelFile = new File(highlevelFileName);
			if (!(highLevelFilePath.exists())) {
				highLevelFilePath.mkdir();
			}
			if (!(highLevelFile.exists())) {
				createXmlFile(highlevelFileName, "../HighLevelReport/"
						+ highlevelRptPath);
			}
		} catch (RuntimeException ex) {
			throw new RuntimeException("Unable to create the xml log file");
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		}
	}
	
	public void writeHighLevelLog(String tcID, String description,
			String browser, String priority, String status, String sLogFileName,
			String scrnshotPath, List coments,String str_exectime)
			
			throws ParserConfigurationException, SAXException, IOException {
		validateLogDiretory();
		String scrnShotName = "View";

		if (scrnshotPath.isEmpty()) {
			scrnShotName = Constants.C_NOTAPPLICABLE;
		} else {

			File oFile = new File(scrnshotPath);
			String sFileName = oFile.getName();
			scrnshotPath = "Snapshot/" + sFileName;
			System.out.println("Screeenshot Path is :: " + scrnshotPath);
		}
		DocumentBuilder documentBuilder;
		documentBuilder = new DocumentUtil().getDocumentBuilder();
		try {
			document = documentBuilder.parse(highlevelFileName);
			Element rootNode = document.getDocumentElement();
			Element newNode = document.createElement("ParentNode");
			Element scrnShotNode = document.createElement("Screenshot");
			Element LogNode = document.createElement("LowLevelReport");

			newNode.setAttribute("TC", tcID);
			newNode.appendChild(document.createElement("TcId")).setTextContent(
					tcID);
			newNode.appendChild(document.createElement("Description"))
					.setTextContent(description);
			newNode.appendChild(document.createElement("Browser"))
					.setTextContent(browser);
			newNode.appendChild(document.createElement("Priority"))
					.setTextContent(priority);
			newNode.appendChild(document.createElement("Status"))
					.setTextContent(status);
			
			//Add Screen Shot node
			newNode.appendChild(scrnShotNode).setTextContent(scrnshotPath);
			scrnShotNode.setAttribute("name", scrnShotName);

			//Add Log Node
			newNode.appendChild(LogNode).setTextContent("../LowLevelReport/" + sLogFileName);
			LogNode.setAttribute("name", sLogFileName);
			
			if (!coments.isEmpty()) {
				newNode.appendChild(document.createElement("Comments"))
						.setTextContent(String.valueOf(coments));
			}
			newNode.appendChild(document.createElement("Run")).setTextContent(str_exectime);
			rootNode.insertBefore(newNode, rootNode.getLastChild());
			/*
			 * PrintStream will be responsible for writing the text data to the
			 * file
			 */
			printStream = new PrintStream(highlevelFileName);
			TransformerFactory
					.newInstance()
					.newTransformer()
					.transform(new DOMSource(document),
							new StreamResult(printStream));
		} catch (DOMException ex) {
			System.out.println("DOM Exception :: " + ex);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			printStream.close();
		}
	}
	
	public void writeHighLevelLog(String tcID, String description,
			String browser, String priority, String status,
			String scrnshotPath, List coments)
			
			throws ParserConfigurationException, SAXException, IOException {
		validateLogDiretory();
		String scrnShotName = "View";

		if (scrnshotPath.isEmpty()) {
			scrnShotName = Constants.C_NOTAPPLICABLE;
		} else {
			
			/*
			String stringSeparators = "/Report";
			String[] scrnshotPathArr = scrnshotPath.split(stringSeparators, 0);
			scrnshotPath = scrnshotPathArr[0];
			*/
			File oFile = new File(scrnshotPath);
			String sFileName = oFile.getName();
			scrnshotPath = "Snapshot/" + sFileName;
			System.out.println("Screeenshot Path is :: " + scrnshotPath);
		}
		DocumentBuilder documentBuilder;
		documentBuilder = new DocumentUtil().getDocumentBuilder();
		try {
			document = documentBuilder.parse(highlevelFileName);
			Element rootNode = document.getDocumentElement();
			Element newNode = document.createElement("ParentNode");
			Element scrnShotNode = document.createElement("Screenshot");
			Element LogNode = document.createElement("LowLevelReport");

			newNode.setAttribute("TC", tcID);
			newNode.appendChild(document.createElement("TcId")).setTextContent(
					tcID);
			newNode.appendChild(document.createElement("Description"))
					.setTextContent(description);
			newNode.appendChild(document.createElement("Browser"))
					.setTextContent(browser);
			newNode.appendChild(document.createElement("Priority"))
					.setTextContent(priority);
			newNode.appendChild(document.createElement("Status"))
					.setTextContent(status);
			
			//Add Screen Shot node
			newNode.appendChild(scrnShotNode).setTextContent(scrnshotPath);
			scrnShotNode.setAttribute("name", scrnShotName);

			//Add Log Node
			newNode.appendChild(LogNode).setTextContent("../LowLevelReport/lowLevelReport.log");
			LogNode.setAttribute("name", "LowLevelReport");
			
			if (!coments.isEmpty()) {
				newNode.appendChild(document.createElement("Comments"))
						.setTextContent(String.valueOf(coments));
			}
			rootNode.insertBefore(newNode, rootNode.getLastChild());
			/*
			 * PrintStream will be responsible for writing the text data to the
			 * file
			 */
			printStream = new PrintStream(highlevelFileName);
			TransformerFactory
					.newInstance()
					.newTransformer()
					.transform(new DOMSource(document),
							new StreamResult(printStream));
		} catch (DOMException ex) {
			System.out.println("DOM Exception :: " + ex);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			printStream.close();
		}
	}

	public void writeHighLevelLog(String tcID, String browser, String status,
			String scrnshotPath, List coments)
			throws ParserConfigurationException, SAXException, IOException {
		validateLogDiretory();
		String scrnShotName = "View";

		if (scrnshotPath.isEmpty()) {
			scrnShotName = Constants.C_NOTAPPLICABLE;
		} else {
			String stringSeparators = "/Report";
			String[] scrnshotPathArr = scrnshotPath.split(stringSeparators, 0);
			scrnshotPath = scrnshotPathArr[0];
			System.out.println("Screeenshot Path is :: " + scrnshotPath);
		}
		DocumentBuilder documentBuilder;
		documentBuilder = new DocumentUtil().getDocumentBuilder();
		try {
			document = documentBuilder.parse(highlevelFileName);
			Element rootNode = document.getDocumentElement();
			Element newNode = document.createElement("ParentNode");
			Element scrnShotNode = document.createElement("Screenshot");

			newNode.setAttribute("TC", tcID);
			newNode.appendChild(document.createElement("TcId")).setTextContent(
					tcID);
			newNode.appendChild(document.createElement("Browser"))
					.setTextContent(browser);
			newNode.appendChild(document.createElement("Status"))
					.setTextContent(status);

			newNode.appendChild(scrnShotNode).setTextContent(scrnshotPath);
			scrnShotNode.setAttribute("name", scrnShotName);
			if (!coments.isEmpty()) {
				newNode.appendChild(document.createElement("Comments"))
						.setTextContent(String.valueOf(coments));
			}
			rootNode.insertBefore(newNode, rootNode.getLastChild());
			/*
			 * PrintStream will be responsible for writing the text data to the
			 * file
			 */
			printStream = new PrintStream(highlevelFileName);
			TransformerFactory
					.newInstance()
					.newTransformer()
					.transform(new DOMSource(document),
							new StreamResult(printStream));
		} catch (DOMException ex) {
			System.out.println("DOM Exception :: " + ex);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			printStream.close();
		}
	}
	
	public void finallyBlock(WebDriver driver, String tcID, String description,
			String browser, String priority, boolean result, String sLogFileName,
			boolean hasExceptionOccured, List coments,String str_exectime) throws SAXException,
			IOException {
		// >>> log to the HL logger <<<
		String scrnshotPath = "";

		if (hasExceptionOccured || (result == false)) {
			scrnshotPath = captureDesktop(driver);
		}
		try {

			writeHighLevelLog(tcID, description, browser, Constants.C_HIGH,
					(result) ? Constants.C_PASS : Constants.C_FAIL,sLogFileName,
					scrnshotPath, coments,str_exectime);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	public void finallyBlock(WebDriver driver, String tcID, String description,
			String browser, String priority, boolean result,
			boolean hasExceptionOccured, List coments) throws SAXException,
			IOException {
		// >>> log to the HL logger <<<
		String scrnshotPath = "";

		if (hasExceptionOccured || (result == false)) {
			scrnshotPath = captureDesktop(driver);
		}
		try {

			writeHighLevelLog(tcID, description, browser, Constants.C_HIGH,
					(result) ? Constants.C_PASS : Constants.C_FAIL,
					scrnshotPath, coments);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	public void finallyBlock(WebDriver driver, String tcID, String browser,
			boolean result, boolean hasExceptionOccured, List coments)
			throws SAXException, IOException {
		// >>> log to the HL logger <<<
		String scrnshotPath = "";

		if (hasExceptionOccured || (result == false)) {
			scrnshotPath = captureDesktop(driver);
		}
		try {

			writeHighLevelLog(tcID, browser, (result) ? Constants.C_PASS
					: Constants.C_FAIL, scrnshotPath, coments);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void finalize() {
		printStream.close();
	}

	public String captureDesktop(WebDriver driver) throws SAXException,
			IOException {
		String fileName = Common_Functions.getScriptName() + " "
				+ getDateAndTime() + ".png";
		String filePath = getHighLevelLoggerPath() + "Snapshot/" + fileName;

		try {
			File screenshot = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(filePath));

		} catch (RuntimeException ex) {

			ex.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// dispose
		}
		return filePath;
	}

	public Date getDate() {
		return new Date();
	}

	/**
	 * @return String of formatted current date.
	 */
	public String getDateAndTime() {
		DateFormat format = new SimpleDateFormat("dd.MM.yy_hh.mm.ss");
		String dtTime = format.format(getDate());
		return dtTime;
	}

	public void createXmlFile(String filename, String linkFileName) {

		String xslFileRef = "";
		if (filename.contains("HighLevelReport")) {
			xslFileRef = String
					.format("type='text/xsl' href='XmlReference/HighLevelLog.xsl'");
		}
		try {
			DocumentBuilder documentBuilder;
			documentBuilder = new DocumentUtil().getDocumentBuilder();
			Document document = documentBuilder.newDocument();
			ProcessingInstruction node = document.createProcessingInstruction(
					"xml-stylesheet", xslFileRef);
			document.appendChild(node);
			Element rootNode = document.createElement("RootNode");
			document.appendChild(rootNode);

			rootNode.setAttribute("ExecuteTime", new SimpleDateFormat(
					"MM/dd/yyyy hh.mm.ss").format(new Date()));
			rootNode.setAttribute("ReportLinkPath", linkFileName);

			document.createElement("ParentNode");
			System.out.println("File Name is :: " + filename);
			PrintStream printStream = new PrintStream(filename);
			TransformerFactory
					.newInstance()
					.newTransformer()
					.transform(new DOMSource(document),
							new StreamResult(printStream));
		} catch (RuntimeException ex) {
			System.out.println("The Exception is :: " + ex);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	public String getHighLevelLoggerPath() {
		new ReadProperties();
		return ReadProperties.readProperty("highLevelReport");
	}
	
	public String getHighLevelLoggerFileName() {
		return highlevelFileName;
	}
	
	public void generateHTMLReport(){
		
		try {			
			
			/*String sXmlFilePath = getHighLevelLoggerFileName();
			String sXslFilePath = getHighLevelLoggerPath() + "XmlReference/HighLevelLog.xsl";
			String sHTMLFilePath = getHighLevelLoggerPath() + "FinalReport.html";			
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();			
			Document document = db.parse(sXmlFilePath);
			DOMSource source = new DOMSource(document);
			
			StreamSource stylesource = new StreamSource(sXslFilePath);
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer(stylesource);
			
			//The HTML output is in FinalReport.html
			StreamResult result = new StreamResult(sHTMLFilePath);
			transformer.transform(source,result);*/
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            
            String sXmlFilePath = getHighLevelLoggerFileName();
            String sXslFilePath = getHighLevelLoggerPath() + "XmlReference/HighLevelLog.xsl";
            String sHTMLFilePath = getHighLevelLoggerPath() + "FinalReport.html";                 
            
            File sourceFile = new File(sXmlFilePath);
            if(sourceFile.exists()){
                  Document document = db.parse(sXmlFilePath);
                  DOMSource source = new DOMSource(document);
                  
                  StreamSource stylesource = new StreamSource(sXslFilePath);
                  TransformerFactory tf = TransformerFactory.newInstance();
                  Transformer transformer = tf.newTransformer(stylesource);
                  
                  //The HTML output is in FinalReport.html
                  StreamResult result = new StreamResult(sHTMLFilePath);
                  transformer.transform(source,result);
            }

		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}