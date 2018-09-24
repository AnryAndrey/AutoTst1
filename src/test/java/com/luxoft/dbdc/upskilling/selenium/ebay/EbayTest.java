package com.luxoft.dbdc.upskilling.selenium.ebay;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class EbayTest extends EbayBase{

    @Test
    public void shouldBeEmptyCardOnFirstVisit() throws InterruptedException{

        // open ebay page
        String ebayPage = "http://www.ebay.com";
        webDriver.get(ebayPage);
        Thread.sleep(1000);

        //go to card page
        webDriver.findElement(By.id("gh-cart-i")).click();
        Thread.sleep(1000);

        //check that cart is empty
        boolean ebayCartIsEmpty = webDriver.findElement(By.cssSelector("div.empty-cart")).isDisplayed();

        assertThat(ebayCartIsEmpty, is(true));
    }

}
