package index.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OutfitsPage extends BasePageObject {

	private String expectedUrl = "https://ide-8d8481f8907e489494d4a7f3a13af4f4-8080.cs50.ws/myoutfits";
	private String expectedUrlGallery = "https://ide-8d8481f8907e489494d4a7f3a13af4f4-8080.cs50.ws/gallery";
	
	private By topBottomsCarouselLocator = By.xpath("//div[@id='carousel_1']");
	private By dressesCarouselLocator = By.xpath("//div[@id='carousel_2']");
		
	private By dressCarouselControlNext = By.xpath("//div[@id='carousel_2']//span[@class='carousel-control-next-icon']");
	private By topbottomsCarouselControlNext = By.xpath("//div[@id='carousel_1']//span[@class='carousel-control-next-icon']");
	
	private By activeOutfitDressLocator = By.xpath("//div[@id='carousel_2']//div[@class='carousel-item active']//img");
	private By activeOutfitTopBottomsLocator = By.xpath("//div[@id='carousel_1']//div[@class='carousel-item active']//img");
	
	private By outfitsTBLocator = By.xpath("//div[@id='carousel_1']//div[@class='carousel-item']//img");
	private By outfitsDLocator = By.xpath("//div[@id='carousel_2']//div[@class='carousel-item']//img");
	
	public OutfitsPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public String getExpectedUrl() {
		return expectedUrl;
	}
	
	public String getExpectedUrlGallery() {
		return expectedUrlGallery;
	}
	
	
	public void moveDressCarouselToItem(int number) {
		log.info("Selecting outfit number " + number + " in the dresses outfits");
		moveCarouselBy(number, dressCarouselControlNext);
	}
	
	public void moveTopBottomsCarouselToItem(int number) {
		log.info("Selecting outfit number " + number + " in the tops and bottoms outfits");
		moveCarouselBy(number, topbottomsCarouselControlNext);
	}
	
	public ArrayList<String> getDressOutfit() {
		return getCarouselItems(activeOutfitDressLocator);
	}
	
	public ArrayList<String> getTopBottomsOutfit() {
		return getCarouselItems(activeOutfitTopBottomsLocator);
	}
	
	public boolean isTopBottomsCarouselVisible() {
		return isVisible(topBottomsCarouselLocator); 
	}
	
	public boolean isDressesCarouselVisible() {
		return isVisible(dressesCarouselLocator); 
	}
	
	public ArrayList<String> getTBOutfits() {
		return getCarouselItems(outfitsTBLocator);
	}
	
	public ArrayList<String> getDOutfits() {
		return getCarouselItems(outfitsDLocator);
	}
	
	public ArrayList<String> getTBOutfitsSeparately(int size) {
		ArrayList<String> outfits = new ArrayList<String>();
		for(int i = 0; i < size; i++) {
			moveCarouselBy(1, topbottomsCarouselControlNext);
			List<WebElement> items = findAll(activeOutfitTopBottomsLocator);
			for (WebElement item: items) {
				outfits.add(item.getAttribute("src").replace("https://ide-8d8481f8907e489494d4a7f3a13af4f4-8080.cs50.ws/static/", ""));
			}
		}
		return outfits;
	}
	
	public ArrayList<String> getDOutfitsSeparately(int size) {
		ArrayList<String> outfits = new ArrayList<String>();
		for(int i = 0; i < size; i++) {
			moveCarouselBy(1, dressCarouselControlNext);
			List<WebElement> items = findAll(activeOutfitDressLocator);
			for (WebElement item: items) {
				outfits.add(item.getAttribute("src").replace("https://ide-8d8481f8907e489494d4a7f3a13af4f4-8080.cs50.ws/static/", ""));
			}
		}
		return outfits;
	}
}

