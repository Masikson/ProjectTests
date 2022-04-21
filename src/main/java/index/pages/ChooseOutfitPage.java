package index.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChooseOutfitPage extends BasePageObject {

	private By typeDropdownLocator = By.name("type");
	private By weatherDropdownLocator = By.name("weather");
	private By eventDropdownLocator = By.name("event");

	private By chooseButtonLocator = By.xpath("//button[@class='btn btn-primary button']");

	public ChooseOutfitPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public void selectOptions(String type, String weather, String event) { 
		log.info("Selecting: " + type + ", " + weather + ", " + event);		
		selectOption(type, typeDropdownLocator);
		selectOption(weather, weatherDropdownLocator);
		selectOption(event, eventDropdownLocator);
	}


	public String getSelectedType() {
		log.info("Getting selected type");
		return getSelectedOption(typeDropdownLocator);
	}

	public String getSelectedWeather() {
		log.info("Getting selected weather");
		return getSelectedOption(weatherDropdownLocator);
	}

	public String getSelectedEvent() {
		log.info("Getting selected event");
		return getSelectedOption(eventDropdownLocator);
	}

	public ChooseDressPage clickChooseDressesLink() {
		log.info("Clicking 'Choose'");
		click(chooseButtonLocator);
		return new ChooseDressPage(driver, log);
	}
	
	public ChooseTopPage clickChooseLink() {
		log.info("Clicking 'Choose'");
		click(chooseButtonLocator);
		return new ChooseTopPage(driver, log);
	}
	
}
