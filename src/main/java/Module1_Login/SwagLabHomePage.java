package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabHomePage 
{

	@FindBy(xpath = "//div[@class='app_logo']") private WebElement Logo;
	@FindBy(xpath = "//button[text()='Open Menu']") private WebElement Menu;
	@FindBy(xpath = "//button[text()='Add to cart']") private WebElement AddtoCart;
	@FindBy(xpath = "//button[text()='Remove']") private WebElement Remove;
	
	public SwagLabHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean VerifySwagLabHomePageLogo() 
	{
	    boolean actResult = Logo.isDisplayed();	
	    return actResult;
	}
	
	public void ClickSwagLabHomePageAddtocart() 
	{
	    AddtoCart.click();	
	}
	
	public String VerifySwagLabHomePageRemoveBtn() 
	{
	     String actText = Remove.getText();	
	     return actText;
	}
	
	public void ClickSwagLabHomePageMenuBtn() 
	{ 
	     Menu.click();
	}
	
}
