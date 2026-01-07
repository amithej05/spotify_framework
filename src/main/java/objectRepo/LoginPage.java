package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genenricLibraries.WebDriverUtils;

import genenricLibraries.WebDriverUtils;

public class LoginPage extends WebDriverUtils {

	//declaration
	
	
	@FindBy(id="username")
	private WebElement usernameTf;

	@FindBy(xpath="//button[@type='submit']")
	private WebElement continueBtn;


	//initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements( driver, this);
	}

	public WebElement getUsernameTf() {
		return usernameTf;
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}
 
	public void LoginSpotify(String username) throws InterruptedException {
		usernameTf.sendKeys(username);
		continueBtn.click();
		Thread.sleep(30000);
	}
}
