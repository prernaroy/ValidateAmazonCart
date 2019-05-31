package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.log4j.Logger;

/**
 * @author C5249742
 *
 */

public class ExecuteFNMS1Transaction {
	
	private static final Logger lowlevellogsobj = Logger.getLogger("Execute FNMS Transaction");
	public ArrayList<String> MsgList = new ArrayList<String>();

	public boolean executeFNMS1Transaction()
	{
		boolean result = false;
		
		try {
			
			String sOutput=null;
			String sLine=null;
			String sError=null;
			String sVBSFIleName="ExecuteFNMS1Transaction.vbs";

            InputStream stderr = null;
            InputStream stdin = null;
            
            //Generate path for .VBS file
            File sDir = new File(".");
			String sBasePath = sDir.getCanonicalPath();
			String sFinalPath = sBasePath + File.separator  + "Resources\\Tools" + File.separator + sVBSFIleName;
			//System.out.println("VBS File Path" + sFinalPath);
			
			String[] parms = {"cscript", sFinalPath};
			
			Process process =  Runtime.getRuntime().exec(parms);	
	        process.waitFor(); // Wait for the process to finish.	        

            stderr = process.getErrorStream ();
            stdin = process.getInputStream ();

            
            //output in stdin
            BufferedReader brData = new BufferedReader (new InputStreamReader (stdin));
            while ((sLine = brData.readLine ()) != null) {
            	if(sOutput!=null){
            		sOutput = sOutput + sLine;
            	}else{
            		sOutput =sLine;
            	}
            	
            }

            //output in stderr
            brData = new BufferedReader (new InputStreamReader (stderr));
            while ((sLine = brData.readLine ()) != null) {
            	if(sError!=null){
            		sError = sError + sLine;
            	}else{
            		sError =sLine;
            	}
            }
        
            brData.close();
            
            //System.out.println("UFT Script Output : " + sOutput);
            
            if(sOutput.contains("Execution Failed")){
            	lowlevellogsobj.error("FNMS1 Transaction not Successful");
            	MsgList.add("FNMS1 Transaction not Successful");
            	return false;
            }
            
            if(sError!= null){
            	lowlevellogsobj.error("FNMS1 Transaction not Successful");
            	MsgList.add("FNMS1 Transaction not Successful");
            	return false;
            }
            
            lowlevellogsobj.info("FNMS1 Transaction Successful");
            result = true;
            
		} catch (Exception e) {
			lowlevellogsobj.error("Exception in FNMS1 Transaction:  " + e.getMessage(), e);
			MsgList.add("Exception while FNMS1 Transaction");
			result = false;
		}
		
		return result;
	}

}


