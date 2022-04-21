package index.getinspiredpagetests;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import index.base.TestUtilities;
import index.pages.IndexPage;
import index.pages.OutfitsPage;


public class GetInspiredPageTests extends TestUtilities {
	
	@Test
	public void getInspiredPageTest() {
		
		IndexPage indexPage = logIn();		
		OutfitsPage getInspiredPage = indexPage.clickGetInspiredLink();
		
		// verify we are on gallery page 
		Assert.assertEquals(getInspiredPage.getCurrentUrl(), getInspiredPage.getExpectedUrlGallery());
		
		// verify we see 2 carousels
		Assert.assertTrue(getInspiredPage.isTopBottomsCarouselVisible(), "Tops and bottoms carousel is not visible.");
		Assert.assertTrue(getInspiredPage.isDressesCarouselVisible(), "Dresses carousel is not visible.");
		
		ArrayList<String> outfitsTB = getInspiredPage.getTBOutfits();
		int sizeTB = outfitsTB.size();
			
		// get outfits by clicking through carousel
		ArrayList<String> outfitsTB2 = getInspiredPage.getTBOutfitsSeparately(sizeTB/3);
		
		// compare lists of items
		Assert.assertEquals(outfitsTB, outfitsTB2);
		
		//refresh to get first item in second carousel
		driver.navigate().refresh();

		ArrayList<String> outfitsD = getInspiredPage.getDOutfits();
		int sizeD = outfitsD.size();
		
		// get outfits by clicking through carousel
		ArrayList<String> outfitsD2 = getInspiredPage.getDOutfitsSeparately(sizeD/2);

		// compare lists of items
		Assert.assertEquals(outfitsD, outfitsD2);
	}
}
