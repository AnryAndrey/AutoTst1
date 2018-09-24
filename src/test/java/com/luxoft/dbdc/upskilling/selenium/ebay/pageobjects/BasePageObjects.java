package com.luxoft.dbdc.upskilling.selenium.ebay.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.ConcurrentHashMap;


public class BasePageObjects {
    protected WebDriver webDriver;
    private final int MAX_WAIT_TIME = 30;

    public BasePageObjects (WebDriver webDriver){
        this.webDriver = webDriver;

    }

    protected WebElement findElementWithWait(By locator){
        return new WebDriverWait (webDriver, MAX_WAIT_TIME).until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }


}