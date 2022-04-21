package index.myoutfitspagetests;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import index.base.TestUtilities;
import index.pages.IndexPage;
import index.pages.OutfitsPage;

public class MyOutfitsPageTests extends TestUtilities {
	
	@Test
	public void myOutfitsPageTest() {
		
		IndexPage indexPage = logIn();
		
		OutfitsPage myOutfitsPage = indexPage.clickMyOutfitsLink();
		
		// verify we are on outfits page 
		Assert.assertEquals(myOutfitsPage.getCurrentUrl(), myOutfitsPage.getExpectedUrl());
		
		// verify we see 2 carousels
		Assert.assertTrue(myOutfitsPage.isTopBottomsCarouselVisible(), "Tops and bottoms carousel is not visible.");
		Assert.assertTrue(myOutfitsPage.isDressesCarouselVisible(), "Dresses carousel is not visible.");
		
		ArrayList<String> outfitsTB = myOutfitsPage.getTBOutfits();
		int sizeTB = outfitsTB.size();
		
		// get outfits by clicking through carousel
		ArrayList<String> outfitsTB2 = myOutfitsPage.getTBOutfitsSeparately(sizeTB/3);
			
		// compare lists of items
		Assert.assertEquals(outfitsTB, outfitsTB2);
		
		//refresh to get first item in second carousel
		driver.navigate().refresh();
		
		ArrayList<String> outfitsD = myOutfitsPage.getDOutfits();
		int sizeD = outfitsD.size();
			
		// get outfits by clicking through carousel
		ArrayList<String> outfitsD2 = myOutfitsPage.getDOutfitsSeparately(sizeD/2);
		
		// compare lists of items
		Assert.assertEquals(outfitsD, outfitsD2);
		
	}
}
