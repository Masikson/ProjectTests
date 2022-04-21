package index.pages;

import java.util.ArrayList;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChooseShoesDressPage extends BasePageObject {
	
	private By carouselLocator = By.xpath("//div[@id='carousel_4']");
	private By shoesImageLocator = By.xpath("//div[@class='carousel-item active']/img[@alt='shoes']");
	private By carouselItemsLocator = By.xpath("//div[@class='carousel-item']//img");
	private By carouselControlNext = By.className("carousel-control-next-icon");
	
	private By selectedDressLocator = By.xpath("//img[@alt='dress']");

	private By activeShoesLocator = By.xpath("//div[@class='carousel-item active']//img");
	private By buttonLocator = By.xpath("//div[@class='carousel-item active']//button"); 
	
	public ChooseShoesDressPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public boolean isCarouselVisible() {
		return isVisible(carouselLocator); 
	}
	
	public ArrayList<String> getItems() {
		return getCarouselItems(carouselItemsLocator);
	}
	
	public String getDress() {
		log.info("Getting selected dress");
		return getItem(selectedDressLocator);
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