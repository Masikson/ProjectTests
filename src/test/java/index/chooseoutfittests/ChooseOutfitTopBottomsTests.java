package index.chooseoutfittests;

import java.util.ArrayList;
import java.util.Map;

import org.testng.annotations.Test;

import index.assertions.ChooseOutfitTopBottomsTestAssert;
import index.base.CsvDataProviders;
import index.pages.ChooseBottomsPage;
import index.pages.ChooseOutfitPage;
import index.pages.ChooseShoesPage;
import index.pages.ChooseTopPage;
import index.pages.IndexPage;

public class ChooseOutfitTopBottomsTests extends ChooseOutfitTopBottomsTestAssert {

	@Test(dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void chooseOutfitTopBottomsTest(Map<String, String> testData) {

		// get the data
		String no = testData.get("no");
		String type = testData.get("type");
		String weather = testData.get("weather");
		String event = testData.get("event");
		int topno = Integer.parseInt(testData.get("topnumber"));
		int bottomsno = Integer.parseInt(testData.get("bottomnumber"));
		int shoesno = Integer.parseInt(testData.get("shoesnumber"));

		log.info("Starting chooseOutfitTopBottomsTest #" + no + " for " + type);

		// log in
		IndexPage indexPage = logIn();

		// open Choose Oufit page
		ChooseOutfitPage chooseOutfitPage = indexPage.clickChooseLink();

		// select filters
		chooseOutfitPage.selectOptions(type, weather, event);

		// verify correct filters are selected
		verifyFiltersAreSelected(type, weather, event);

		// for checking filters later
		weather = weather.replace("all", "None");
		event = event.replace("all", "None");

		// click choose top
		ChooseTopPage chooseTopPage = chooseOutfitPage.clickChooseLink();

		// verify we see a carousel and the first slide is correct
		verifyTopsPage();

		// get all tops in the carousel
		ArrayList<String> tops = chooseTopPage.getItems();

		// move carousel to chosen top
		chooseTopPage.moveCarouselToItem(topno);
		sleep(1000);

		// verify we see filtered items
		verifyTopsFiltersAreApplied(type, weather, event);

		// verify selected top is correct
		String expectedTop = tops.get(topno - 1);
		verifySelectedTop(expectedTop);

		// verify choose button is visible and click
		verifyChooseTopButtonVisibility();
		ChooseBottomsPage chooseBottomsPage = chooseTopPage.clickChooseButton();

		// verify we see a carousel and the first slide is correct
		verifyBottomsPage();

		// get all bottoms in the carousel
		ArrayList<String> bottoms = chooseBottomsPage.getItems();

		// verify we can see the selected top
		verifyVisibleTop(expectedTop);

		// move carousel to chosen bottoms
		chooseBottomsPage.moveCarouselToItem(bottomsno);
		sleep(1000);

		// verify we see filtered items
		verifyBottomsFiltersAreApplied(type, weather, event);

		// verify selected bottoms are correct
		String expectedBottoms = bottoms.get(bottomsno - 1);
		verifySelectedBottoms(expectedBottoms);

		// verify choose button is visible and click
		verifyChooseBottomsButtonVisibility();
		ChooseShoesPage chooseShoesPage = chooseBottomsPage.clickChooseButton();

		// verify we see a carousel and the first slide is correct
		verifyShoesPage();

		// get all shoes in the carousel
		ArrayList<String> shoes = chooseShoesPage.getItems();

		// verify we can see the selected top and bottoms
		verifyVisibleTopAndBottoms(expectedTop, expectedBottoms);

		// move carousel to chosen shoes
		chooseShoesPage.moveCarouselToItem(shoesno);
		sleep(1000);

		// verify selected shoes are correct
		String expectedShoes = shoes.get(shoesno - 1);
		verifySelectedShoes(expectedShoes);

		// verify choose button is visible and click
		verifyChooseShoesButtonVisibility();
		chooseShoesPage.clickChooseButton();

		// verify we are on outfits page
		verifyOutfitsPage();

		// verify our outfit appeared first on the correct carousel
		verifySelectedOutfit(expectedTop, expectedBottoms, expectedShoes);

	}
}
