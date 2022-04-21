package index.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject {

	private By usernameLocator = By.name("username");
	private By passwordLocator = By.name("password");
	private By logInButtonLocator = By.xpath("//button[@class='btn btn-primary button']");

	private String expectedUrl = "https://ide-8d8481f8907e489494d4a7f3a13af4f4-8080.cs50.ws/login";

	public LoginPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public IndexPage logIn(String username, String password) {
		log.info("Executing login with username [" + username + "] and password [" + password + "]");
		type(username, usernameLocator);
		type(password, passwordLocator);
		click(logInButtonLocator);
		return new IndexPage(driver, log);
	}
	
	public ErrorPage negativeLogIn(String username, String password) {
		log.info("Executing LogIn with username [" + username + "] and password [" + password + "]");
		type(username, usernameLocator);
		type(password, passwordLocator);
		click(logInButtonLocator);
		return new ErrorPage(driver, log);
	}
	
	public String getExpectedUrl() {
		return expectedUrl;
	}
	
	public boolean isLogInButtonVisible() {
		return isVisible(logInButtonLocator); 
	}
	
}
