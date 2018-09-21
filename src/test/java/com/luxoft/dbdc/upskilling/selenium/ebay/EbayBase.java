package com.luxoft.dbdc.upskilling.selenium.ebay;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EbayBase {

    protected static WebDriver webDriver;


    @BeforeAll
    public static void setUp(){
        ChromeOptions opt = new ChromeOptions();
        //opt.setHeadless(true);
        webDriver = new ChromeDriver(opt);
        webDriver.manage().deleteAllCookies();
    }


    @AfterAll
    public static void tearDown(){
        webDriver.quit();
    }

}

