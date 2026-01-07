package genenricLibraries;


import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Point;
public class WebDriverUtils {

	 /** Maximizes the browser window
	  * @param driver
     * */
    public void maximizeWindow(WebDriver driver) {
        driver.manage().window().maximize();
    }

    /** Applies implicit wait for the specified duration 
     * @param driver
     * @param seconds*/
    public void waitForPageToLoad(WebDriver driver, int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    /** Waits until the specified element becomes visible
     * @param driver
     * @param element
     * @param seconds */
    public void waitUntilEleToBeVisible(WebDriver driver, int seconds, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    public WebElement waitUntilEleLocated(WebDriver driver, int time, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    /** Waits until the specified element becomes clickable
     * @param driver
     * @param element
     * @param seconds */
    public void waitUntilEleToBeClickable(WebDriver driver, int seconds, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /** Returns a Select object for interacting with dropdowns
     * @param driver
     *  */
    public Select dropdown(WebElement element) {
        return new Select(element);
    }

    /** Selects a dropdown option using the value attribute
     * @param driver
     * @param value */
    public void dropdownUsingValue(WebElement element, String value) {
        dropdown(element).selectByValue(value);
    }

    /** Selects a dropdown option using visible text 
     * @param driver
     * @param value*/
    public void dropdownUsingVisibleText(WebElement element, String value) {
        dropdown(element).selectByVisibleText(value);
    }
    
    public void dropdownUsingContainsVisibleText(WebElement element, String value) {
        dropdown(element).selectByContainsVisibleText(value);
    }

    /** Selects a dropdown option based on index 
     * @param driver
     * @param index*/
    public void dropdownUsingIndex(WebElement element, int index) {
        dropdown(element).selectByIndex(index);
    }

    /** Returns an Actions object to perform advanced mouse/keyboard actions
     * @param driver */
    public Actions actions(WebDriver driver) {
        return new Actions(driver);
    }

    /** Performs mouse hover on the given element 
     * @param driver
     * @param element*/
    public void mouseHover(WebDriver driver, WebElement element) {
        actions(driver).moveToElement(element).perform();
    }
    
    public void clickOnEle(WebDriver driver, WebElement element) {
        actions(driver).click(element).perform();
    }

    /** Mouse hover followed by click on the element 
     * @param driver
     * @param element*/
    public void mouseHoverAndClickonEle(WebDriver driver, WebElement element) {
        actions(driver).moveToElement(element).click(element).perform();
    }

    /** Double-clicks on the webpage
     * @param driver */
    public void doubleClickonWebPage(WebDriver driver) {
        actions(driver).doubleClick().perform();
    }

    /** Double-clicks a specific element 
     * @param driver
     * @param element*/
    public void doubleClickonElement(WebDriver driver, WebElement element) {
        actions(driver).doubleClick(element).perform();
    }

    /** Right-clicks anywhere on the webpage 
     * @param driver
     * */
    public void rightClickOnWebPage(WebDriver driver) {
        actions(driver).contextClick().perform();
    }

    /** Right-clicks on the given element
     * @param driver
     * @param element */
    public void rightClickonElement(WebDriver driver, WebElement element) {
        actions(driver).contextClick(element).perform();
    }

    /** Click and hold on an element
     * @param driver
     * @param element */
    public void clickAndHold(WebDriver driver, WebElement element) {
        actions(driver).clickAndHold(element).perform();
    }

    /** Click-hold and release on an element
     * @param driver
     * @param element */
    public void clickHoldAndRelease(WebDriver driver, WebElement element) {
        actions(driver).clickAndHold(element).release().perform();
    }

    /** Scrolls the page until the element is in view using Actions
     * @param driver
     * @param element */
    public void scrollToElement(WebDriver driver, WebElement element) {
        actions(driver).scrollToElement(element).perform();
    }

    /** Scrolls by a specific X and Y amount
     * @param driver
     * @paaram x
     * @param y */
    public void scrollByAmount(WebDriver driver, int x, int y) {
        actions(driver).scrollByAmount(x, y).perform();
    }

    /**
     * Switches to a child window whose title contains the expected title
     * 
     * @param driver
     * @param expTitle
     * @throws InterruptedException 
     */
    public void switchToWindow(WebDriver driver, String expTitle) throws InterruptedException {
    	String parent=driver.getWindowHandle();
    	Thread.sleep(2000);
    	Set<String> allwh = driver.getWindowHandles();
        for (String win : allwh) {
            String actualTitle = driver.switchTo().window(win).getTitle();
            if (actualTitle.contains(expTitle)) {
                break;
            }
        }
    }

    /** Switches back to the parent window
     * @param driver
     * @param parentID */
  /*  public void switchToParentWindow(WebDriver driver) {
    	String parentID=driver.getWindowHandle();
        driver.switchTo().window(parentID);
    }*/

    //Frames

    /** Switches to frame using index 
     * @param driver
     * @param index*/
    public void framesByIndex(WebDriver driver, int index) {
        driver.switchTo().frame(index);
    }

    /** Switches to frame using ID or Name attribute 
     * @param driver
     * @param ID*/
    public void framesByIDorName(WebDriver driver, String ID) {
        driver.switchTo().frame(ID);
    }

    /** Switches to frame using a WebElement reference
     * @param driver
     * @param element */
    public void framesByElement(WebDriver driver, WebElement element) {
        driver.switchTo().frame(element);
    }

    /** Switches from child frame to parent frame
     * @param driver */
    public void framesByParentFrame(WebDriver driver) {
        driver.switchTo().parentFrame();
    }

    /** Switches control back to the main webpage (default content)
     * @param driver */
    public void framesToWebPage(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    // alertpopup

    /** Accepts an alert popup
     * @param driver */
    public void acceptAlertPopup(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    /** Dismisses an alert popup
     * @param driver
     * */
    public void dismissAlertPopup(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    /** Retrieves text from an alert popup
     * @param driver
     * */
    public void getTextAlertPopup(WebDriver driver) {
        driver.switchTo().alert().getText();
    }

    /** Enters a value into an alert text field 
     * @param driver
     * @param value*/
    public void enterValueinotAlertPopupTextField(WebDriver driver, String value) {
        driver.switchTo().alert().sendKeys(value);
    }

    // javascriptExecutor

    /** Returns a JavaScriptExecutor instance
     * @param driver
     * */
    public JavascriptExecutor javaScriptExecutor(WebDriver driver) {
        return (JavascriptExecutor) driver;
    }

    /** Enters text into a field using JavaScript
     * @param driver
     * @param element
     * @param value */
    public void enterValueIntoTextFieldUsingJSE(WebDriver driver, WebElement element, String value) {
        javaScriptExecutor(driver).executeScript("arguments[0].value=arguments[1]", element, value);
    }

    /** Clicks on an element using JavaScript
     * @param driver
     * @param element */
    public void clickOnElementusingJSE(WebDriver driver, WebElement element) {
        javaScriptExecutor(driver).executeScript("arguments[0].click()", element);
    }

    /**
     * Scrolls using the element’s X & Y coordinates  
     * @param driver
     * @param element
     */
    public void scrollToEleUsingXYCoordinate(WebDriver driver, WebElement element) {
        Point loc = element.getLocation();
        int x = loc.getX();
        int y = loc.getY();
        javaScriptExecutor(driver).executeScript("window.scrollBy("+x+","+y+")");
    }

    /** Scrolls to the bottom of the page 
     * @param driver
     * */
    public void ScrollHeightusingJSE(WebDriver driver) {
        javaScriptExecutor(driver).executeScript("window.scrollBy(0, document.body.scrollHeight)");
    }

    /**
     * Scrolls until the element becomes visible  
     * @param driver
     * @param element
     */
    public void ScrollUntilEleVisibleusingJSE(WebDriver driver, WebElement element) {
        javaScriptExecutor(driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}