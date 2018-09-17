package com.luxoft.dbdc.upskilling.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SampleSeleniumTest {
    private static WebDriver webDriver;

    @BeforeAll
    public static void setUp(){
        ChromeOptions opt = new ChromeOptions();
        //opt.setHeadless(true);
        webDriver = new ChromeDriver(opt);
    }

    @Test
    public void googleComSimpleTest(){
        String address = "http://google.com";
        webDriver.get(address);
        Assertions.assertTrue( ()-> webDriver.getTitle().equalsIgnoreCase("Google") );
    }

    @AfterAll
    public static void tearDown(){
        webDriver.quit();
    }

}
