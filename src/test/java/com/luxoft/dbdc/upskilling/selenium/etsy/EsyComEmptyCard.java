package com.luxoft.dbdc.upskilling.selenium.etsy;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class EsyComEmptyCard extends EtsyBase {

    private static final String PRIVACY_POLICY_FORM = ".alert";
    private static final String PRIVACY_POLICY_ACCEPT_BUTTON = "button.btn-outline";
    private static final String SHOPING_CARD_ICON = ".etsy-icon-cart";
    private static final String PRIVACY_POLICY_SUCCESS_MODAL = ".alert-success";
    private static final String EMPTY_CARD_HEADER = "div.empty-header";

    @Test
    public void shouldHaveEmptyShoppingCartOnFirstVisit() throws InterruptedException {
        String mainPage = "http://www.etsy.com";
        //Go to Etsy.com page
        webDriver.get(mainPage);

        //Accept privacy Rules
        WebElement acceptPrivacyRulesButton =
                webDriver.findElement(By.cssSelector(PRIVACY_POLICY_FORM))
                .findElement(By.cssSelector(PRIVACY_POLICY_ACCEPT_BUTTON));
        acceptPrivacyRulesButton.click();
        //Go to cart page
        //webDriver.findElement(By.cssSelector(SHOPING_CARD_ICON)).click();
        new WebDriverWait(webDriver, 20).until(
                webDriver1 -> webDriver1.findElement(By.cssSelector(PRIVACY_POLICY_SUCCESS_MODAL))
        );
        webDriver.get(mainPage + "/cart");

        //Check if card is empty
        Thread.sleep(5000);
        boolean shoppingCartHasNoItem = webDriver.findElement(By.cssSelector(EMPTY_CARD_HEADER)).isDisplayed();
        assertThat(shoppingCartHasNoItem, is(true));

    }

}
