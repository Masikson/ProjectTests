package index.assertions;

import java.util.ArrayList;

import org.testng.Assert;

import index.base.TestUtilities;
import index.pages.ChooseDressPage;
import index.pages.ChooseOutfitPage;
import index.pages.ChooseShoesDressPage;
import index.pages.OutfitsPage;

public class ChooseOutfitDressTestAssert extends TestUtilities {

	/** choose outfits test: check filters are selected **/
	public void verifyFiltersAreSelected(String type, String weather, String event) {
		
		ChooseOutfitPage chooseOutfitPage = new ChooseOutfitPage(driver, log);
		
		String selectedType = chooseOutfitPage.getSelectedType();
		String selectedWeather = chooseOutfitPage.getSelectedWeather();
		String selectedEvent = chooseOutfitPage.getSelectedEvent();
		
		Assert.assertTrue(selectedType.equals(type), type + " not selected. Instead selected - " + selectedType);
		Assert.assertTrue(selectedWeather.equals(weather), weather + " not selected. Instead selected - " + selectedWeather);
		Assert.assertTrue(selectedEvent.equals(event), event + " not selected. Instead selected - " + selectedEvent);
	}
	
	public void verifyDressesPage() {
		
		ChooseDressPage chooseDressPage = new ChooseDressPage(driver, log);
		
		// verify we see a carousel 
		Assert.assertTrue(chooseDressPage.isCarouselVisible(), "Carousel is not visible.");
		
		// verify we are on the dresses page by the first slide
		Assert.assertTrue(chooseDressPage.isDressesImageVisible(), "Dresses Image is not visible.");
	}
	
	public void verifyFiltersAreApplied(String type, String weather, String event) {
		
		ChooseDressPage chooseDressPage = new ChooseDressPage(driver, log);
		String selectedWeather = chooseDressPage.getWeather();
		String selectedEvent = chooseDressPage.getEvent();
		 
		Assert.assertTrue(selectedWeather.equals(weather), weather + " filter not selected. Instead selected - " + selectedWeather);			
		Assert.assertTrue(selectedEvent.equals(event), event + " filter not selected. Instead selected - " + selectedEvent);
	}
	
	public void verifySelectedDress(String expectedDress) {
		
		ChooseDressPage chooseDressPage = new ChooseDressPage(driver, log);
		// get the selected dress 
		String selectedDress = chooseDressPage.getSelectedDress();
		
		// verify selected dress is correct
		Assert.assertTrue(selectedDress.equals(expectedDress), expectedDress + " not selected. Instead selected - " + selectedDress);
	}
	
	public void verifyChooseDressButtonVisibility() {
		
		ChooseDressPage chooseDressPage = new ChooseDressPage(driver, log);
		Assert.assertTrue(chooseDressPage.isChooseButtonVisible(), "Choose button is not visible.");
	}
	
	public void verifyShoesPage() {

		ChooseShoesDressPage chooseShoesDressPage = new ChooseShoesDressPage(driver, log);
		// verify we see a carousel
		Assert.assertTrue(chooseShoesDressPage.isCarouselVisible(), "Carousel is not visible.");
		
		//verify we are on the shoes page by the first slide
		Assert.assertTrue(chooseShoesDressPage.isShoesImageVisible(), "Shoes Image is not visible.");
	}
	
	public void verifyVisibleDress(String expectedDress) {
		
		ChooseShoesDressPage chooseShoesDressPage = new ChooseShoesDressPage(driver, log);
		// verify we can see the selected dress
		String selectedDress = chooseShoesDressPage.getDress();
		Assert.assertTrue(selectedDress.equals(expectedDress), expectedDress + " not visible. Instead visible - " + selectedDress);
	}
	
	public void verifySelectedDressShoes (String expectedShoes) {
		
		ChooseShoesDressPage chooseShoesDressPage = new ChooseShoesDressPage(driver, log);
		String selectedShoes = chooseShoesDressPage.getSelectedShoes();

		// verify selected shoes are correct
		Assert.assertTrue(selectedShoes.equals(expectedShoes), expectedShoes + " not selected. Instead selected - " + selectedShoes);
	}
	
	public void verifyChooseShoesButtonVisibility() {
		
		ChooseShoesDressPage chooseShoesDressPage = new ChooseShoesDressPage(driver, log);
		Assert.assertTrue(chooseShoesDressPage.isChooseButtonVisible(), "Choose button is not visible.");
	}
	
	public void verifyOutfitsPage() {
		OutfitsPage myOutfitsPage = new OutfitsPage(driver, log);
		Assert.assertEquals(myOutfitsPage.getCurrentUrl(), myOutfitsPage.getExpectedUrl());
	}

	public void verifySelectedOutfit(String expectedDress, String expectedShoes) {
		OutfitsPage myOutfitsPage = new OutfitsPage(driver, log);
		myOutfitsPage.moveDressCarouselToItem(1);
		
		ArrayList<String> dressOutfit = myOutfitsPage.getDressOutfit();
		Assert.assertTrue(dressOutfit.get(0).equals(expectedDress), expectedDress + " not visible. Instead visible - " + dressOutfit.get(0));
		Assert.assertTrue(dressOutfit.get(1).equals(expectedShoes), expectedShoes + " not visible. Instead visible - " + dressOutfit.get(1));

	}
	
	
	
	
	
}
