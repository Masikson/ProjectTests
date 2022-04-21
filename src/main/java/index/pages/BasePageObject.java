package index.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BasePageObject {

	protected WebDriver driver;
	protected Logger log;
	
	public BasePageObject(WebDriver driver, Logger log) {
		this.driver = driver;
		this.log = log;
	}
	
	/**open page with given url */
	protected void openUrl(String url) {
		driver.get(url);
	}
	
	/**find element using given locator */
	protected WebElement find(By locator) {
		return driver.findElement(locator);
	}
	
	/**find all elements using given locator */
	protected List<WebElement> findAll(By locator) {
		return driver.findElements(locator);
	}
	
	/**click on element with given locator when it's visible */
	protected void click(By locator) {
		waitForVisibilityOf(locator, 5);
		find(locator).click();
	}
	
	/**type given text into element with given locator */
	protected void type(String text, By locator) {
		waitForVisibilityOf(locator, 5);
		find(locator).sendKeys(text);
	}
	
	/**wait for specific ExpectedCondition for the given amount of time in seconds */
		private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
		timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(condition);
	}
	
	/**wait for given number of seconds for element with given location to be visible on the page */
	protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) { 
		int attempts = 0;
		while (attempts < 2) {
			try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator), 
						(timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
				break;
			} catch (StaleElementReferenceException e){ 				
			}
			attempts ++;		
		}
	}

	/** get current url from the browser */
	public String getCurrentUrl() {  
		return driver.getCurrentUrl();
	}

	/** select option in a dropdown by name **/
	public void selectOption(String option, By locator) { 
		
		WebElement dropdownElement = find(locator);
		Select dropdown = new Select(dropdownElement);

		dropdown.selectByVisibleText(option);
	}
	
	/** Get selected option in a dropdown by its locator **/
	protected String getSelectedOption(By dropdownLocator) {
		
		WebElement dropdownElement1 = find(dropdownLocator);
		Select dropdown = new Select(dropdownElement1);
		
		String selectedOption = dropdown.getFirstSelectedOption().getText();
		log.info(selectedOption + " is selected in dropdown");
		return selectedOption;
	}
	
	protected boolean isVisible(By locator) {
		return find(locator).isDisplayed(); 
	}
	
	protected void moveCarouselBy(int number, By carouselControl) {
		for (int i = 0; i < number; i++) {
			click(carouselControl);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<String> getCarouselItems(By locator) {
		List<WebElement> itemElements = findAll(locator);
		ArrayList<String> items = new ArrayList<String>();
		for (WebElement item: itemElements) {
			items.add(item.getAttribute("src").replace("https://ide-8d8481f8907e489494d4a7f3a13af4f4-8080.cs50.ws/static/", ""));
		}
		log.info("Items to choose from are: " + items);
		return items;
	}
	
	public String getItem(By locator) {
		String name = find(locator).getAttribute("src").replace("https://ide-8d8481f8907e489494d4a7f3a13af4f4-8080.cs50.ws/static/", "");
		return name;
	}
	

}
