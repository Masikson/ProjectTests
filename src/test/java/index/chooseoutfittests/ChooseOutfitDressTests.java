package index.chooseoutfittests;

import java.util.ArrayList;
import java.util.Map;

import org.testng.annotations.Test;

import index.assertions.ChooseOutfitDressTestAssert;
import index.base.CsvDataProviders;
import index.pages.ChooseDressPage;
import index.pages.ChooseOutfitPage;
import index.pages.ChooseShoesDressPage;
import index.pages.IndexPage;

public class ChooseOutfitDressTests extends ChooseOutfitDressTestAssert {
	
	@Test(dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void chooseOutfitDressTest(Map<String, String> testData) {
		
		// get the data
		String no = testData.get("no");
		String type = testData.get("type");
		String weather = testData.get("weather");
		String event = testData.get("event");
		int dressno = Integer.parseInt(testData.get("dressnumber"));
		int shoesno = Integer.parseInt(testData.get("shoesnumber"));
		
		log.info("Starting chooseOutfitDressTest #" + no + " for " + type);
		
		//log in
		IndexPage indexPage = logIn();
		
		//open Choose Outfit page
		ChooseOutfitPage chooseOutfitPage = indexPage.clickChooseLink();
		
		// select filters 
 		chooseOutfitPage.selectOptions(type, weather, event); 
 	
 		// verify correct filters are selected
 		verifyFiltersAreSelected(type, weather, event);
 		
		// for checking filters later
 		weather = weather.replace("all", "None");
 		event = event.replace("all", "None");
		
		// click choose dress
		ChooseDressPage chooseDressPage = chooseOutfitPage.clickChooseDressesLink();
		
		// verify we see a carousel and the first slide is correct
		verifyDressesPage();
		
		// get all dresses in the carousel
		ArrayList<String> dresses = chooseDressPage.getItems();
		
		// move carousel to chosen dress
		chooseDressPage.moveCarouselToItem(dressno);
		sleep(1000);
		
		// verify we see filtered items 
		verifyFiltersAreApplied(type, weather, event);
		
		// verify selected dress is correct
		String expectedDress = dresses.get(dressno - 1);
		verifySelectedDress(expectedDress);
		
		// verify choose button is visible and click
		verifyChooseDressButtonVisibility();
		ChooseShoesDressPage chooseShoesDressPage = chooseDressPage.clickChooseButton();

		// verify we see a carousel and the first slide is correct
		verifyShoesPage();
		
		// get all shoes in the carousel
		ArrayList<String> shoes = chooseShoesDressPage.getItems();
		
		// verify we can see the selected dress
		verifyVisibleDress(expectedDress);
		
		// move carousel to chosen shoes
		chooseShoesDressPage.moveCarouselToItem(shoesno);
		sleep(1000);
		
		// verify selected shoes are correct
		String expectedShoes = shoes.get(shoesno - 1);
		verifySelectedDressShoes(expectedShoes);
		
		// verify choose button is visible and click
		verifyChooseShoesButtonVisibility();		
		chooseShoesDressPage.clickChooseButton();
		
		// verify we are on outfits page 
		verifyOutfitsPage();
		
		// verify our outfit appeared first on the correct carousel
		verifySelectedOutfit(expectedDress, expectedShoes);
		
		}
}
