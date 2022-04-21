package index.logouttests;

import org.testng.Assert;
import org.testng.annotations.Test;

import index.base.TestUtilities;
import index.pages.IndexPage;
import index.pages.LoginPage;

public class LogOutTests extends TestUtilities {
	
	@Test
	public void logInTest() {
	
		IndexPage indexPage = logIn();
	
		LoginPage loginPage = indexPage.clickLogOutButton();
		
		// verify we are on login page
		Assert.assertEquals(loginPage.getCurrentUrl(), loginPage.getExpectedUrl());
		
		// verify log in button is visible
		Assert.assertTrue(loginPage.isLogInButtonVisible(), "Log In Button is not visible.");
	}
}
