package objectRepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genenricLibraries.ExcelUtils;

public class ArtistSongViewsPage extends ExcelUtils{

	@FindBy(xpath="//div[@class='hb8C1VAjyUg0VMxrwpix']")
	private List<WebElement> songs;

	@FindBy(xpath="//div[@class='qev2KFBSKCHkeXT4fDTl']")
	private List<WebElement> views;
	
	@FindBy(xpath="//button[@aria-label='Home']")
	private WebElement homeBtn;

	public ArtistSongViewsPage(WebDriver driver) {
		PageFactory.initElements( driver, this);
	}

	public List<WebElement> getSongs() {
		return songs;
	}

	public List<WebElement> getViews() {
		return views;
	}

	public WebElement getHomeBtn() {
		return homeBtn;
	}
	
	
}

