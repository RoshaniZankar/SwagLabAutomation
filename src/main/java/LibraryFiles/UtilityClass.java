package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class UtilityClass 
{

	public static String GetTD(int rowIndex,int cellIndex) throws EncryptedDocumentException, IOException 
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Sharad\\eclipse-workspace\\MavenProject\\TestData\\Book1.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("Sheet5");
		String value = sh.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		return value;
	}
	
	public static String GetPFD(String key) throws IOException 
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Sharad\\eclipse-workspace\\MavenProject\\PropertyFile.properties");
		
		Properties p=new Properties();
		
		p.load(file);
		
		String value = p.getProperty(key);
		
		return value;
	}
	
	public static void CaptureSS(WebDriver driver,int TCIDNumber) throws IOException 
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest= new File("C:\\Users\\Sharad\\eclipse-workspace\\MavenProject\\FailedTCesSS\\TestCaseId"+ TCIDNumber +".png");
	    org.openqa.selenium.io.FileHandler.copy(src, dest);
	}
	
}
