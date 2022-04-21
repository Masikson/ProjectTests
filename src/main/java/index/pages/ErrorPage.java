package index.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ErrorPage extends BasePageObject {
	
	private By errorMessage = By.tagName("img");
			
	public ErrorPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public String getErrorMessageText() {
		String message = find(errorMessage).getAttribute("src").replace('-', ' ').replace("~s","/");
		return message;
	}
}
