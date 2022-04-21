package index.pages;

import java.util.ArrayList;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChooseBottomsPage extends BasePageObject {

	private By carouselLocator = By.xpath("//div[@id='carousel_2']");
	private By bottomsImageLocator = By.xpath("//div[@class='carousel-item active']/img[@alt='bottoms']");
	private By carouselItemsLocator = By.xpath("//div[@class='carousel-item']//img");
	private By carouselControlNext = By.className("carousel-control-next-icon");
	
	private By selectedTopLocator = By.xpath("//img[@alt='top']");
	
	private By activeBottomsLocator = By.xpath("//div[@class='carousel-item active']//img"); 
	private By weatherLocator = By.name("weather");
	private By eventLocator = By.name("event");
	
	private By buttonLocator = By.xpath("//div[@class='carousel-item active']//button"); 
	
	public ChooseBottomsPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public boolean isCarouselVisible() {
		return isVisible(carouselLocator); 
	}
	
	public ArrayList<String> getItems() {
		return getCarouselItems(carouselItemsLocator);
	}
	
	public String getTop() {
		log.info("Getting selected top");
		return getItem(selectedTopLocator);
	}
	
	public boolean isBottomsImageVisible() {
		return find(bottomsImageLocator).isDisplayed(); 
	}
	
	public void moveCarouselToItem(int number) {
		log.info("Selecting bottoms number " + number);
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

	public String getSelectedBottoms() {
		log.info("Getting selected bottoms");
		return getItem(activeBottomsLocator);
	}
	
	public boolean isChooseButtonVisible() {
		return isVisible(buttonLocator); 
	}
	
	public ChooseShoesPage clickChooseButton() {
		log.info("Clicking 'Choose'");
		click(buttonLocator);
		return new ChooseShoesPage(driver, log);
	}

}
