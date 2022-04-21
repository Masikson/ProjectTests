package index.loginpagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import index.base.TestUtilities;

import index.pages.LoginPage;
import index.pages.ConfirmationPage;
import index.pages.IndexPage;

public class PositiveLogInTests extends TestUtilities {

	@Test
	public void logInTest() {
	
		String username = "Masia";
		String password = "qq";
		
		ConfirmationPage confirmationPage = new ConfirmationPage(driver, log);
		confirmationPage.openPage();
		
		LoginPage loginPage = confirmationPage.clickConfirmation();
		
		// execute login		
		IndexPage indexPage = loginPage.logIn(username, password);
		
		// verify new page url is as expected
		Assert.assertEquals(indexPage.getCurrentUrl(), indexPage.getExpectedUrl());

		// log out button is visible
		Assert.assertTrue(indexPage.isLogoutButtonVisible(), "logOutButton is not visible.");

	}
}
