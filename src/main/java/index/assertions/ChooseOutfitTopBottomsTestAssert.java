package index.assertions;

import java.util.ArrayList;

import org.testng.Assert;

import index.base.TestUtilities;
import index.pages.ChooseBottomsPage;
import index.pages.ChooseOutfitPage;
import index.pages.ChooseShoesPage;
import index.pages.ChooseTopPage;
import index.pages.OutfitsPage;

public class ChooseOutfitTopBottomsTestAssert extends TestUtilities {
	
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
	
	
	public void verifyTopsPage() {
			
			ChooseTopPage chooseTopPage = new ChooseTopPage(driver,log);
			// verify we see a carousel
			Assert.assertTrue(chooseTopPage.isCarouselVisible(), "Carousel is not visible.");
			// verify we are on the tops page by the first slide
			Assert.assertTrue(chooseTopPage.isTopsImageVisible(), "Tops Image is not visible.");
		}
	
	public void verifyTopsFiltersAreApplied(String type, String weather, String event) {
		
		ChooseTopPage chooseTopPage = new ChooseTopPage(driver, log);
		String selectedWeather = chooseTopPage.getWeather();
		String selectedEvent = chooseTopPage.getEvent();
		 
		Assert.assertTrue(selectedWeather.equals(weather), weather + " filter not selected. Instead selected - " + selectedWeather);			
		Assert.assertTrue(selectedEvent.equals(event), event + " filter not selected. Instead selected - " + selectedEvent);
	}
	
	public void verifySelectedTop(String expectedTop) {
		
		ChooseTopPage chooseTopPage = new ChooseTopPage(driver, log);
		// get the selected top
		String selectedTop = chooseTopPage.getSelectedTop();
		
		// verify selected top is correct
		Assert.assertTrue(selectedTop.equals(expectedTop), expectedTop + " not selected. Instead selected - " + selectedTop);
	}
	
	public void verifyChooseTopButtonVisibility() {
		
		ChooseTopPage chooseTopPage = new ChooseTopPage(driver, log);
		Assert.assertTrue(chooseTopPage.isChooseButtonVisible(), "Choose button is not visible.");
	}
	
	public void verifyBottomsPage() {

		ChooseBottomsPage chooseBottomsPage = new ChooseBottomsPage(driver, log);
		// verify we see a carousel
		Assert.assertTrue(chooseBottomsPage.isCarouselVisible(), "Carousel is not visible.");
		
		//verify we are on the bottoms page by the first slide
		Assert.assertTrue(chooseBottomsPage.isBottomsImageVisible(), "Bottoms Image is not visible.");
	}
	
	public void verifyVisibleTop(String expectedTop) {
		
		ChooseBottomsPage chooseBottomsPage = new ChooseBottomsPage(driver, log);
		// verify we can see the selected top
		String selectedTop = chooseBottomsPage.getTop();
		Assert.assertTrue(selectedTop.equals(expectedTop), expectedTop + " not visible. Instead visible - " + selectedTop);
	}
	
	public void verifyBottomsFiltersAreApplied(String type, String weather, String event) {
			
			ChooseBottomsPage chooseBottomsPage = new ChooseBottomsPage(driver, log);
			String selectedWeather = chooseBottomsPage.getWeather();
			String selectedEvent = chooseBottomsPage.getEvent();
			 
			Assert.assertTrue(selectedWeather.equals(weather), weather + " filter not selected. Instead selected - " + selectedWeather);			
			Assert.assertTrue(selectedEvent.equals(event), event + " filter not selected. Instead selected - " + selectedEvent);
		}
	
	public void verifySelectedBottoms(String expectedBottoms) {
		
		ChooseBottomsPage chooseBottomsPage = new ChooseBottomsPage(driver, log);
		// get the selected bottoms
		String selectedBottoms = chooseBottomsPage.getSelectedBottoms();
		
		// verify selected bottoms are correct
		Assert.assertTrue(selectedBottoms.equals(expectedBottoms), expectedBottoms + " not selected. Instead selected - " + selectedBottoms);
	}
	
	public void verifyChooseBottomsButtonVisibility() {
		
		ChooseBottomsPage chooseBottomsPage = new ChooseBottomsPage(driver, log);
		Assert.assertTrue(chooseBottomsPage.isChooseButtonVisible(), "Choose button is not visible.");
	}
	
	
	public void verifyShoesPage() {

		ChooseShoesPage chooseShoesPage = new ChooseShoesPage(driver, log);
		// verify we see a carousel
		Assert.assertTrue(chooseShoesPage.isCarouselVisible(), "Carousel is not visible.");
		
		//verify we are on the shoes page by the first slide
		Assert.assertTrue(chooseShoesPage.isShoesImageVisible(), "Shoes Image is not visible.");
	}
	
	public void verifyVisibleTopAndBottoms(String expectedTop, String expectedBottoms) {
		
		ChooseShoesPage chooseShoesPage = new ChooseShoesPage(driver, log);
		// verify we can see the selected top and bottoms
		String selectedTop = chooseShoesPage.getTop();
		String selectedBottoms = chooseShoesPage.getBottoms();
		
		Assert.assertTrue(selectedTop.equals(expectedTop), expectedTop + " not visible. Instead visible - " + selectedTop);
		Assert.assertTrue(selectedBottoms.equals(expectedBottoms), expectedBottoms + " not visible. Instead visible - " + selectedBottoms);
	}
	
	public void verifySelectedShoes (String expectedShoes) {
		
		ChooseShoesPage chooseShoesPage = new ChooseShoesPage(driver, log);
		String selectedShoes = chooseShoesPage.getSelectedShoes();

		// verify selected shoes are correct
		Assert.assertTrue(selectedShoes.equals(expectedShoes), expectedShoes + " not selected. Instead selected - " + selectedShoes);
	}
	
	public void verifyChooseShoesButtonVisibility() {
		
		ChooseShoesPage chooseShoesPage = new ChooseShoesPage(driver, log);
		Assert.assertTrue(chooseShoesPage.isChooseButtonVisible(), "Choose button is not visible.");
	}
	
	public void verifyOutfitsPage() {
		OutfitsPage myOutfitsPage = new OutfitsPage(driver, log);
		Assert.assertEquals(myOutfitsPage.getCurrentUrl(), myOutfitsPage.getExpectedUrl());
	}
	
	public void verifySelectedOutfit(String expectedTop, String expectedBottoms, String expectedShoes) {
		OutfitsPage myOutfitsPage = new OutfitsPage(driver, log);
		myOutfitsPage.moveTopBottomsCarouselToItem(1);
		
		ArrayList<String> topBottomsOutfit = myOutfitsPage.getTopBottomsOutfit();
		Assert.assertTrue(topBottomsOutfit.get(0).equals(expectedTop), expectedTop + " not visible. Instead visible - " + topBottomsOutfit.get(0));
		Assert.assertTrue(topBottomsOutfit.get(1).equals(expectedBottoms), expectedBottoms + " not visible. Instead visible - " + topBottomsOutfit.get(0));
		Assert.assertTrue(topBottomsOutfit.get(2).equals(expectedShoes), expectedShoes + " not visible. Instead visible - " + topBottomsOutfit.get(2));

	}
	
}
