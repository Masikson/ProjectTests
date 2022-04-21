package index.pages;

import java.util.ArrayList;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChooseTopPage extends BasePageObject {

	private By carouselLocator = By.xpath("//div[@id='carousel_1']");
	private By topsImageLocator = By.xpath("//div[@class='carousel-item active']/img[@alt='tops']");
	private By carouselItemsLocator = By.xpath("//div[@class='carousel-item']//img");
	private By carouselControlNext = By.className("carousel-control-next-icon");
	
	private By activeTopLocator = By.xpath("//div[@class='carousel-item active']//img"); 
	private By weatherLocator = By.name("weather");
	private By eventLocator = By.name("event");
	
	private By buttonLocator = By.xpath("//div[@class='carousel-item active']//button"); 
		
	public ChooseTopPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public boolean isCarouselVisible() {
		return isVisible(carouselLocator); 
	}
	
	public ArrayList<String> getItems() {
		return getCarouselItems(carouselItemsLocator);
	}
	
	public boolean isTopsImageVisible() {
		return find(topsImageLocator).isDisplayed(); 
	}
	
	public void moveCarouselToItem(int number) {
		log.info("Selecting top number " + number);
		moveCarouselBy(number, carouselControlNext);
	}
	
	public String getWeather() {
		return find(weatherLocator).getAttribute("value");
	}
	
	public String getEvent() {
		return find(eventLocator).getAttribute("value");
	}
	
	public String getSelectedTop() {
		log.info("Getting selected top");
		return getItem(activeTopLocator);
	}
	
	public boolean isChooseButtonVisible() {
		return isVisible(buttonLocator); 
	}
	
	public ChooseBottomsPage clickChooseButton() {
		log.info("Clicking 'Choose'");
		click(buttonLocator);
		return new ChooseBottomsPage(driver, log);
	}
	

}
