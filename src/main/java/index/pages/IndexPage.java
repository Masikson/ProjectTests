package index.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IndexPage extends BasePageObject {
	
	private String expectedUrl = "https://ide-8d8481f8907e489494d4a7f3a13af4f4-8080.cs50.ws/";
	
	private By logOutButtonLocator = By.xpath("//a[@class='nav-link' and @href='/logout']");
	private By chooseOutfitButtonLocator = By.xpath("//a[@class='nav-link' and @href='/choose']");
	private By myOutfitsButtonLocator = By.xpath("//a[@class='nav-link' and @href='/myoutfits']");
	private By getInspiredButtonLocator = By.xpath("//a[@class='nav-link' and @href='/gallery']");
	private By addToClosetButtonLocator = By.xpath("//a[@class='nav-link' and @href='/upload']");
	
	
	private By topsCarouselControlPrevious = By.xpath("//div[@id='carousel_1']//span[@class='carousel-control-prev-icon']");
	private By bottomsCarouselControlPrevious = By.xpath("//div[@id='carousel_2']//span[@class='carousel-control-prev-icon']");
	private By dressesCarouselControlPrevious = By.xpath("//div[@id='carousel_3']//span[@class='carousel-control-prev-icon']");
	private By shoesCarouselControlPrevious = By.xpath("//div[@id='carousel_4']//span[@class='carousel-control-prev-icon']");
	
	private By activeTopLocator = By.xpath("//div[@id='carousel_1']//div[@class='carousel-item active']//img");
	private By activeBottomsLocator = By.xpath("//div[@id='carousel_2']//div[@class='carousel-item active']//img");
	private By activeDressLocator = By.xpath("//div[@id='carousel_3']//div[@class='carousel-item active']//img");
	private By activeShoesLocator = By.xpath("//div[@id='carousel_4']//div[@class='carousel-item active']//img");
	
	public IndexPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public String getExpectedUrl() {
		return expectedUrl;
	}
	
	public boolean isLogoutButtonVisible() {
		return isVisible(logOutButtonLocator); 
	}
	
	public ChooseOutfitPage clickChooseLink() {
		log.info("Clicking 'Choose outfit'");
		click(chooseOutfitButtonLocator);
		return new ChooseOutfitPage(driver, log);
	}
	
	public OutfitsPage clickMyOutfitsLink() {
		log.info("Clicking 'My outfits'");
		click(myOutfitsButtonLocator);
		return new OutfitsPage(driver,log);
	}
	
	public OutfitsPage clickGetInspiredLink() {
		log.info("Clicking 'Get inspired'");
		click(getInspiredButtonLocator);
		return new OutfitsPage(driver,log);
	}
	
	public AddToClosetPage clickAddToClosetLink() {
		log.info("Clicking 'Add to closet'");
		click(addToClosetButtonLocator);
		return new AddToClosetPage(driver,log);
	}
	
	public void clickTopsCarouselPrevious() {
		log.info("Moving tops carousel to previous item");
		moveCarouselBy(1, topsCarouselControlPrevious);
	}
	
	public void clickBottomsCarouselPrevious() {
		log.info("Moving bottoms carousel to previous item");
		moveCarouselBy(1, bottomsCarouselControlPrevious);
	}
	
	public void clickDressesCarouselPrevious() {
		log.info("Moving dresses carousel to previous item");
		moveCarouselBy(1, dressesCarouselControlPrevious);
	}
	
	public void clickShoesCarouselPrevious() {
		log.info("Moving shoes carousel to previous item");
		moveCarouselBy(1, shoesCarouselControlPrevious);
	}
	
	public String getActiveTop() {
		String name = getItem(activeTopLocator);
		log.info("Uploaded files: " + name);
		return name;
	}
	
	public String getActiveBottoms() {
		String name = getItem(activeBottomsLocator);
		log.info("Uploaded files: " + name);
		return name;
	}
	
	public String getActiveDress() {
		String name = getItem(activeDressLocator);
		log.info("Uploaded files: " + name);
		return name;
	}
	
	public String getActiveShoes() {
		String name = getItem(activeShoesLocator);
		log.info("Uploaded files: " + name);
		return name;
	}
	
	public LoginPage clickLogOutButton() {
		log.info("Clicking 'Log out'");
		click(logOutButtonLocator);
		return new LoginPage(driver, log);
	}
}
