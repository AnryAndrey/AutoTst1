package com.luxoft.dbdc.upskilling.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    public void googleComSimpleTestByName() throws InterruptedException {
        String address = "http://google.com";
        String queryString = "selenium";
        webDriver.get(address);
        WebElement searchField = webDriver.findElement(By.name("q"));
        searchField.sendKeys("selenium" + Keys.ENTER);
        Thread.sleep(3000);
        Assertions.assertTrue( ()-> webDriver.getTitle().contains(queryString) );
    }


    @Test
    public void googleComSimpleTestByXpath() throws InterruptedException {
        String address = "http://google.com";
        String queryString = "selenium";
        webDriver.get(address);
        WebElement searchField = webDriver.findElement(By.xpath("//input[@name='q']"));
        searchField.clear();
        searchField.sendKeys(queryString);
        searchField.submit();
        Thread.sleep(3000);
        Assertions.assertTrue( ()-> webDriver.getTitle().contains(queryString) );
    }




    @AfterAll
    public static void tearDown(){
        webDriver.quit();
    }

}
