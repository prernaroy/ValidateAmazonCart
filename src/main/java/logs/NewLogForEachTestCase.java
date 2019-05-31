package logs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Appender;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Logger;

/**
 * @author C5249742
 *
 */

public class NewLogForEachTestCase {
	
	
	
	public static void changeLogName(String sTCID){
		Appender appender=null;	
		String sCurrentFile;
		String sNewFileName;
		
		LowLevelLogs.loadLogger();
		
		Logger rootLogger = Logger.getRootLogger();
		
		/*Enumeration appenders = rootLogger.getAllAppenders();
		while ( appenders.hasMoreElements() ){
			  appender = (Appender)appenders.nextElement();
			  //System.out.println("Appender Name" + appender.getName());	
		}
		*/
		
		appender = rootLogger.getAppender("SAP");
		
		if(appender != null){
			
			DailyRollingFileAppender drfAppender = (DailyRollingFileAppender)appender;
			
			//Get Current File Path
			sCurrentFile = drfAppender.getFile();
			//System.out.println("Existing Log File Name : " + sCurrentFile);
			
			//Get Parent Path and File Name
			File theFile = new File(sCurrentFile);
			String sParent = theFile.getParent().trim();
			//String sChild = theFile.getName();
			
			//System.out.println("Parent path " + sParent);
			//System.out.println("File Name " + sChild);
			
			if(sParent.length() > 0){
				sNewFileName = sParent + File.separator + "LowLevelReport_" + sTCID + ".log";
				createBackupFile(sNewFileName);
			}
			else{
				sNewFileName = "LowLevelReport_" + sTCID + ".log";
				createBackupFile(sNewFileName);
			}
			
			//System.out.println("File Appender Name" + sNewFileName);
			drfAppender.setFile(sNewFileName);
			
		}

	}
	
	public static void createBackupFile(String sFileName){
		
		try {
			File sourceFile = new File(sFileName);
			if(sourceFile.exists()){
				
				Date dNow = new Date();
		        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
		        String datetime = ft.format(dNow);
		        //System.out.println(datetime);
				File destFile = new File(sFileName + "." + datetime);
				
				if (!destFile.exists()) {
					destFile.createNewFile();
				}
				
				@SuppressWarnings("resource")
				FileChannel source = new FileInputStream(sourceFile).getChannel();
				@SuppressWarnings("resource")
				FileChannel destination = new FileOutputStream(destFile).getChannel();

				if (destination != null && source != null) {
					destination.transferFrom(source, 0, source.size());
				}
				
				source.close();
				destination.close();
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
