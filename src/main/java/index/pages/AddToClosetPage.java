package index.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToClosetPage extends BasePageObject {

	private String expectedUrl = "https://ide-8d8481f8907e489494d4a7f3a13af4f4-8080.cs50.ws/upload";
	
	private By chooseFileFieldLocator =  By.name("file");

	private By typeDropdownLocator = By.name("type");
	private By weatherDropdownLocator = By.name("weather");
	private By eventDropdownLocator = By.name("event");

	private By uploadButtonLocator = By.xpath("//button[@class='btn btn-primary button']");

	
	public AddToClosetPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
		
	public String getExpectedUrl() {
		return expectedUrl;
	}
	
	public void selectFile (String fileName) {
		log.info("Selecting '" + fileName + "' from Files folder");
		String filePath = System.getProperty("user.dir") + "//src//main//resources//files//" + fileName;
		type(filePath, chooseFileFieldLocator);
		log.info("File selected");
	}
	
	
	public void selectOptions(String type, String weather, String event) { 
		log.info("Selecting: " + type + ", " + weather + ", " + event);		
		selectOption(type, typeDropdownLocator);
		selectOption(weather, weatherDropdownLocator);
		selectOption(event, eventDropdownLocator);
	}

	
	public IndexPage pushUploadButton() {
		log.info("Clicking on upload button");
		click(uploadButtonLocator);
		return new IndexPage(driver, log);
	}

}
