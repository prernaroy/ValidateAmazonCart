package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFolder {

	public void zipFolder(String sSourceFolder, String sOutputZipFile) throws Exception	{
		ZipOutputStream zip = null;
		FileOutputStream fileWriter = null;

		fileWriter = new FileOutputStream(sOutputZipFile);
		zip = new ZipOutputStream(fileWriter);

		String sMasterPath = "";
		addFolderToZip(sMasterPath, sSourceFolder, zip);

		zip.flush();
		zip.close();
	}

	public void addFolderToZip(String sMasterPath, String sSourceFolder, ZipOutputStream zip)	throws Exception	{

		File folder = new File(sSourceFolder);
		for (String fileName : folder.list())
		{
			//System.out.println("path :" + sMasterPath);
			if (sMasterPath.equals("")) {
				addFileToZip(folder.getName(), sSourceFolder + File.separator + fileName, zip);
			} else {
				addFileToZip(sMasterPath + File.separator + folder.getName(), sSourceFolder + File.separator + fileName, zip);
			}
		}
	}

	public void addFileToZip(String sMasterPath, String sSorceFile, ZipOutputStream zip) throws Exception	{

		File folder = new File(sSorceFile);
		if (folder.isDirectory())
		{
			addFolderToZip(sMasterPath, sSorceFile, zip);
		}
		else
		{
			byte[] byt = new byte[1024];

			FileInputStream in = new FileInputStream(sSorceFile);
			zip.putNextEntry(new ZipEntry(sMasterPath + File.separator + folder.getName()));
			int intlength;
			while ((intlength = in.read(byt)) > 0)
			{
				zip.write(byt, 0, intlength);
			}

			in.close();
		}
	}
}
