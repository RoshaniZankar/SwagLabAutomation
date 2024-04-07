package Module3_Menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabMenuPage 
{


	@FindBy(xpath = "(//a[@class='bm-item menu-item'])[3]") private WebElement LogOut;

	public SwagLabMenuPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClickSwagLabMenuPageLogOutBtn() 
	{
		LogOut.click();
	}
}
