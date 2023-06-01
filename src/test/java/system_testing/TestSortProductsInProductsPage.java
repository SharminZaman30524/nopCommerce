package system_testing;

import base.Common;
import frontend_pages.ShoesPage;
import frontend_pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class TestSortProductsInProductsPage extends Common {
    HomePage homePage;
    ShoesPage shoesPage;
    String sortOption1 = "Name: A to Z";
    String sortOption2 = "Name: Z to A";
    String sortOption3 = "Price: Low to High";
    String sortOption4 = "Price: High to Low";
    String sortOption5 = "Created on";

    @Test(enabled = false)
    public void testSortProductPricesLowToHigh() throws InterruptedException {
        homePage = new HomePage();
        homePage.hoverOverApparelMenuOption();
        homePage.clickShoesOption();
        shoesPage = new ShoesPage();
        shoesPage.selectSortOptionFromDropdown(sortOption3);
        List<Float> prices = shoesPage.getPrices();
        List <Float> sortedPrices = prices;
        Collections.sort(sortedPrices);
        Assert.assertTrue(prices.equals(sortedPrices));
        Thread.sleep(3000);

    }
    @Test
    public void testSortProductPricesZtoA() throws InterruptedException {
        homePage = new HomePage();
        homePage.hoverOverApparelMenuOption();
        homePage.clickShoesOption();
        shoesPage = new ShoesPage();
        shoesPage.selectSortOptionFromDropdown(sortOption2);
        List<String> productNames = shoesPage.getProductNames();
        List<String> sortedProductNames = productNames;
        Collections.sort(sortedProductNames);
        Assert.assertTrue(productNames.equals(sortedProductNames));
        Thread.sleep(3000);
    }
}
