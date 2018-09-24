package com.luxoft.dbdc.upskilling.selenium.ebay;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.luxoft.dbdc.upskilling.selenium.ebay.pageobjects.EbayComPageObject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;


public class EbayComTest {
    protected static WebDriver webDriver;
    EbayComPageObject ebayPage;

    @BeforeAll
    public static void setUpAll(){
        webDriver = new ChromeDriver();
    }

    @BeforeEach
    public   void setUp(){
        ebayPage = new EbayComPageObject(webDriver);
    }

    @Test
    public void shouldShowBestPriceWhenSelectAuctionAfterSearch(){
        // EbayComPageObject ebayPage = new EbayComPageObject(webDriver);
        ebayPage.goToMainPage()
                .searchFor("leather bags")
                .selectActionItems();
        assertThat(ebayPage.getAuctionBestPrices(),
                containsInAnyOrder("Under $8.00", "$8.00 - $18.00", "Over $18.00")
        ) ;
    }


    @Test
    public void shouldShowBestPriceWhenSelectAuctionAfterSearchAfterSelectingItemsInAdditionalCategory()  throws InterruptedException{
        ebayPage.goToMainPage()
                .selectItemsInAdditionalCategoryForCategory("iPhone","Electronics");
        Assertions.assertTrue(ebayPage.getPageTitle().contains("iPhone"),
                String.format("Pagetitle contains doesn't %s subcategory name","iPhone"));

    }

    //  @AfterEach

    @AfterAll
    public static  void tearDown(){
        webDriver.quit();
    }

}