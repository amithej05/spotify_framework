package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genenricLibraries.WebDriverUtils;

public class HomePage extends WebDriverUtils {
	//initialization
	@FindBy(xpath="//span[text()='Log in']")
	private WebElement loginBtn;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	
	
}
