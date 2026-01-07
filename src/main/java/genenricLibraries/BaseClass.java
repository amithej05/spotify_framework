package genenricLibraries;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import objectRepo.HomePage;
import objectRepo.LoginPage;

public class BaseClass {

	public FileUtils flib=new FileUtils();
	public ExcelUtils elib=new ExcelUtils();
	public JavaUtils jlib=new JavaUtils();
	public DaatabaseUtils dlib=new DaatabaseUtils();
	public WebDriverUtils wlib=new WebDriverUtils();

	public WebDriver driver=null;
	public static WebDriver sdriver;

	//public static ThreadLocal<WebDriver> wdriver=new ThreadLocal<WebDriver>();
	
	@BeforeSuite(alwaysRun = true)

	public void connectToDB() throws SQLException {
		dlib.connectToDB();
		System.out.println("connect to DB");
	}

	//@Parameters("BROWSER")

	@BeforeClass(alwaysRun = true)

	public void launchBrowser(/*String BROWSER*/) throws Exception {
		String BROWSER =flib.readDataFromPropertyFile("browser");
		String URL =flib.readDataFromPropertyFile("url");


		//launch the browser
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			driver=new EdgeDriver();
		}
		sdriver=driver;

		//wdriver.set(driver);

		driver.get(URL);
		wlib.maximizeWindow(driver);

		wlib.waitForPageToLoad(driver, 10);
		HomePage hp=new HomePage(driver);
		hp.getLoginBtn().click();

		System.out.println("openbrowser");
	}

	@BeforeMethod(alwaysRun = true)

	public void loginToApp() throws Exception {
		String UN =flib.readDataFromPropertyFile("username");
		
		LoginPage lp= new LoginPage(driver);
		lp.LoginSpotify(UN);
		System.out.println("login");
	}

	@AfterMethod(alwaysRun = true)

	public void logoutOfApp() throws InterruptedException {
		HomePage hp= new HomePage(driver);
		
		System.out.println("logout");
	}

	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		//driver.quit();
		System.out.println("close");
	}

	@AfterSuite(alwaysRun = true)

	public void disconnectToDB() throws SQLException {
		dlib.disconnectDB();
		System.out.println("disconnectDB");
	}

}
