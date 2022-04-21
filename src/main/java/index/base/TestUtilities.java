package index.base;

import java.util.List;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.DataProvider;

import index.pages.ConfirmationPage;
import index.pages.IndexPage;
import index.pages.LoginPage;

public class TestUtilities extends BaseTest {

	
	@DataProvider(name="files")
	protected static Object[][] files() {
		return new Object[][] {
			{1,"top5.png","tops","hot","casual"}, 
			{2,"shoes8.png","shoes","all","party"},
			{3,"skirt3.png","bottoms","warm","all"}
		};
	}

	/** Get logs from browser console */
	protected List<LogEntry> getBrowserLogs() {
		LogEntries log = driver.manage().logs().get("browser");
		List<LogEntry> logList = log.getAll();
		return logList;
	}
	
	protected void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/** Confirm and login **/
	protected IndexPage logIn() {
		ConfirmationPage confirmationPage = new ConfirmationPage(driver, log);
		confirmationPage.openPage();
		LoginPage loginPage = confirmationPage.clickConfirmation();
		
		// execute login		
		IndexPage indexPage = loginPage.logIn("Masia","qq");
		return indexPage;
		
	}
	
	
	
	
}
