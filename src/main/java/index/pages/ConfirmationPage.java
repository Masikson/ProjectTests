package index.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage extends BasePageObject {
	
	private String pageUrl = "https://ide-8d8481f8907e489494d4a7f3a13af4f4-8080.cs50.ws";
	private By proceedButtonLocator =  By.xpath("//a[@class='btn btn-primary']");
	
	public ConfirmationPage (WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public void openPage() {
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page opened!");
	}
	
	public LoginPage clickConfirmation() {
		click(proceedButtonLocator);
		return new LoginPage(driver, log);
	}
}
