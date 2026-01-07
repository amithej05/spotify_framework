package objectRepo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageAftrLgn {

	@FindBy(xpath="//input[@type='search']")
	private WebElement searchTf;
	
	
	@FindBy(xpath="//a[@class='aYeZbjwj2kxRcdU1cAXV']")
	private WebElement artName;
	
	public HomePageAftrLgn(WebDriver driver) {
		PageFactory.initElements( driver, this);
	}

	public WebElement getSearchTf() {
		return searchTf;
	}
	
	public WebElement getArtName() {
		return artName;
	}

	public void searchArtist(String artist) {
		searchTf.sendKeys(artist,Keys.ENTER);
	}
}


