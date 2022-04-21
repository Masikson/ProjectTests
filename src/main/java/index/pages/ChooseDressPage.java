package index.pages;

import java.util.ArrayList;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ChooseDressPage extends BasePageObject {

	
	private By carouselLocator = By.xpath("//div[@id='carousel_3']");
	private By dressesImageLocator = By.xpath("//div[@class='carousel-item active']/img[@alt='dresses']");
	private By carouselItemsLocator = By.xpath("//div[@class='carousel-item']//img");
	private By carouselControlNext = By.className("carousel-control-next-icon");
	
	private By activeDressLocator = By.xpath("//div[@class='carousel-item active']//img"); 
	private By weatherLocator = By.name("weather");
	private By eventLocator = By.name("event");
	
	private By buttonLocator = By.xpath("//div[@class='carousel-item active']//button"); 
	
	public ChooseDressPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public boolean isCarouselVisible() {
		return isVisible(carouselLocator); 
	}
	
	public ArrayList<String> getItems() {
		return getCarouselItems(carouselItemsLocator);
	}
	
	public boolean isDressesImageVisible() {
		return find(dressesImageLocator).isDisplayed(); 
	}

	public void moveCarouselToItem(int number) {
		log.info("Selecting dress number " + number);
		moveCarouselBy(number, carouselControlNext);
	}
	
	public String getWeather() {
		log.info("Getting selected weather");
		return find(weatherLocator).getAttribute("value");
	}
	
	public String getEvent() {
		log.info("Getting selected event");
		return find(eventLocator).getAttribute("value");
	}
	
	public String getSelectedDress() {
		log.info("Getting selected dress");
		return getItem(activeDressLocator);
	}
	
	public boolean isChooseButtonVisible() {
		return isVisible(buttonLocator); 
	}
	
	public ChooseShoesDressPage clickChooseButton() {
		log.info("Clicking 'Choose'");
		click(buttonLocator);
		return new ChooseShoesDressPage(driver, log);
	}
	
	
}
