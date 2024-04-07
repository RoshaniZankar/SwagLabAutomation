package Module1_Login_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import Module1_Login.SwagLabHomePage;
import Module1_Login.SwagLabLoginPage;
import Module3_Menu.SwagLabMenuPage;

public class SwagLabTest extends BaseClass
{
	SwagLabLoginPage login;
	SwagLabHomePage home;
	SwagLabMenuPage menu;
	int TCID;
	
	@BeforeClass
	public void EnterURL() throws EncryptedDocumentException, IOException 
	{
		
		IntializeBrowser();
		login = new SwagLabLoginPage(driver);
		home = new SwagLabHomePage(driver);
		menu = new SwagLabMenuPage(driver);
	}
	
	@BeforeMethod
	public void LoginToApp() throws EncryptedDocumentException, IOException 
	{
		login.EnterSwagLabLoginPageUN(UtilityClass.GetPFD("UN"));
		
		login.EnterSwagLabLoginPagePWD(UtilityClass.GetPFD("PWD"));
		
		login.ClickSwaglabLoginPageLoginBtn();
	}
	
	@Test(priority = 1)
	public void VerifyLogo() 
	{
		TCID = 101;
		boolean actResult = home.VerifySwagLabHomePageLogo();
		Assert.assertTrue(actResult, "Failed- No Logo Found: ");
	}
	
	@Test(priority = 2)
	public void VerifyAddToCartAndRemoveFunc() throws EncryptedDocumentException, IOException 
	{
	   TCID = 102;
		home.ClickSwagLabHomePageAddtocart();
		
		String actText = home.VerifySwagLabHomePageRemoveBtn();
		String ExpText= UtilityClass.GetTD(0, 2);
		Assert.assertEquals(actText, ExpText);
		
		
	}
	
	@AfterMethod
	public void LogOutApp(ITestResult s1) throws IOException 
	{
		if(s1.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.CaptureSS(driver, TCID);
		}
		home.ClickSwagLabHomePageMenuBtn();
	    menu.ClickSwagLabMenuPageLogOutBtn();
	}
	
	@AfterClass
	public void CloseApp() 
	{
		driver.quit();
	}
	
}
