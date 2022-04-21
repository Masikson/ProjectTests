package index.pages;

import java.util.ArrayList;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChooseShoesPage extends BasePageObject {

	private By carouselLocator = By.xpath("//div[@id='carousel_4']");
	private By shoesImageLocator = By.xpath("//div[@class='carousel-item active']/img[@alt='shoes']");
	private By carouselItemsLocator = By.xpath("//div[@class='carousel-item']//img");
	private By carouselControlNext = By.className("carousel-control-next-icon");
	
	private By selectedTopLocator = By.xpath("//img[@alt='top']");
	private By selectedBottomsLocator = By.xpath("//img[@alt='bottoms']");

	private By activeShoesLocator = By.xpath("//div[@class='carousel-item active']//img");
	private By buttonLocator = By.xpath("//div[@class='carousel-item active']//button"); 
	
	public ChooseShoesPage(WebDriver driver, Logger log) {
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
	
	public String getBottoms() {
		log.info("Getting selected bottoms");
		return getItem(selectedBottomsLocator);
	}
	
	public boolean isShoesImageVisible() {
		return find(shoesImageLocator).isDisplayed(); 
	}
	
	public void moveCarouselToItem(int number) {
		log.info("Selecting shoes number " + number);
		moveCarouselBy(number, carouselControlNext);
	}
	
	public String getSelectedShoes() {
		log.info("Getting selected shoes");
		return getItem(activeShoesLocator);
	}
	
	public boolean isChooseButtonVisible() {
		return isVisible(buttonLocator); 
	}
	
	public OutfitsPage clickChooseButton() {
		log.info("Clicking 'Choose'");
		click(buttonLocator);
		return new OutfitsPage (driver, log);
	}
}
