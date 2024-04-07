package LibraryFiles;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass 
{

	public WebDriver driver;
	public void IntializeBrowser() throws IOException 
	{
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(UtilityClass.GetPFD("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
}
