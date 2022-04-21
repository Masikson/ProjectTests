package index.addtoclosettests;

import org.testng.Assert;
import org.testng.annotations.Test;

import index.base.TestUtilities;
import index.pages.AddToClosetPage;
import index.pages.IndexPage;


public class AddToClosetTests extends TestUtilities {
	
	@Test(dataProvider="files") 
	public void addToClosetTest(int no, String fileName, String type, String weather, String event) { 
		
		log.info("Starting addToClosetTest #" + no + " for " + fileName);
			
		IndexPage indexPage = logIn();
		AddToClosetPage addToClosetPage = indexPage.clickAddToClosetLink();
		
		// verify we are on outfits page 
		Assert.assertEquals(addToClosetPage.getCurrentUrl(), addToClosetPage.getExpectedUrl());
		
		// select file
		addToClosetPage.selectFile(fileName);
		
		// select type, weather and event 
		addToClosetPage.selectOptions(type, weather, event);
		
		// push upload button
		indexPage = addToClosetPage.pushUploadButton();
		
		String item = null;
		
		// move correct carousel to prevoius item and get the file name
		switch(type) {
		case "tops":
			indexPage.clickTopsCarouselPrevious();
			item = indexPage.getActiveTop();
			break;
		case "bottoms":
			indexPage.clickBottomsCarouselPrevious();
			item = indexPage.getActiveBottoms();
			break;
		case "dresses":
			indexPage.clickDressesCarouselPrevious();
			item = indexPage.getActiveDress();
			break;
		case "shoes":
			indexPage.clickShoesCarouselPrevious();
			item = indexPage.getActiveShoes();
			break;
		}
		
		//verify selected file uploaded
		Assert.assertTrue(item.equals(fileName), "Our file" + fileName + "is not the one uploaded: " + item);

	}
}
