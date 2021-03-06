package com.luxoft.dbdc.upskilling.selenium.ebay.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class EbayComPageObject extends BasePageObjects {

    private final String mainPage = "http://www.ebay.com";
    private static final String SEARCH_FIELD = "#gh-ac";
    private static final String AUCTION_BUTTON = "a[title='Auction']";
    //private static final String AUCTION_BUTTON = String.format("button[title='$s']","Auction");
    private static final String SHOP_BY_PRICE_ITEMS = "div.search-guidance__text-item-title";

    @FindBy(id = "gh-ac")
    private WebElement searchFieldElement;

    public EbayComPageObject(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public EbayComPageObject goToMainPage() {
        webDriver.get(mainPage);
        return this;
    }

    public EbayComPageObject searchFor(String item) {
        enterCriteriaToSearchField(item);
        return this;
    }

    private void enterCriteriaToSearchField(String item) {
        WebElement searchField = getSearchField();
        // WebElement searchField = searchFieldElement;
        searchField.clear();
        searchField.sendKeys(item);
        searchField.submit();

    }

    private WebElement getSearchField() {
        return findElementWithWait(By.cssSelector(SEARCH_FIELD));
    }

    public EbayComPageObject selectActionItems() {
        selectActionItemsOption();
        return this;
    }

    public String getPageTitle(){
        return webDriver.getTitle();
    }

    private void selectActionItemsOption() {
        // String auctionItemButton = String.format("a[title='$s']","Auction");
        findElementWithWait(By.cssSelector(AUCTION_BUTTON)).click();

    }

    public List<String> getAuctionBestPrices() {
        return webDriver.findElements(By.cssSelector(SHOP_BY_PRICE_ITEMS))
                .stream()
                .map(webElement -> webElement.getText())
                .collect(Collectors.toList());
    }

    public EbayComPageObject selectItemsInAdditionalCategoryForCategory(String subCategory, String category) {

        Actions builder = new Actions(webDriver);

        String xpathSelCat = String.format("//*[@id='navigationFragment']/div/table/tbody/tr/td[5]/a[contains(., '%s')]",category);
        String xpathSelSubCat = String.format("//*[@id='navigationFragment']/div/table/tbody/tr/td[5]/div[2]/div[1]/ul[2]/li[2]/a[contains(text(), '%s')]",subCategory);

        builder
                .moveToElement(findElementWithWait(By.xpath(xpathSelCat)))
                .pause(Duration.ofSeconds(5))
                //.moveToElement(findElementWithWait(By.xpath(xpathSelSubCat)))
                //.click()
                .build()
                .perform();

        builder
                .moveToElement(findElementWithWait(By.xpath(xpathSelSubCat)))
                .click()
                .build()
                .perform();

        return this;

    }
}