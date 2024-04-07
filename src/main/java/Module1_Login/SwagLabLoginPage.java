package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabLoginPage 
{

	@FindBy(xpath = "//input[@id='user-name']") private WebElement UN;
	@FindBy(xpath = "//input[@id='password']") private WebElement PWD;
	@FindBy(xpath = "//input[@class='submit-button btn_action']") private WebElement LoginBtn;
	
	public SwagLabLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void EnterSwagLabLoginPageUN(String Username) 
	{
		UN.sendKeys(Username);
	}
	
	public void EnterSwagLabLoginPagePWD(String Password) 
	{
	   PWD.sendKeys(Password);	
	}
	public void ClickSwaglabLoginPageLoginBtn() 
	{
	    LoginBtn.click();	
	}
	
	
}
