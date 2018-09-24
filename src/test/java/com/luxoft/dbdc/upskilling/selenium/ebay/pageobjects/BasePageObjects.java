package com.luxoft.dbdc.upskilling.selenium.ebay.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ConcurrentHashMap;


public class BasePageObjects {
    protected WebDriver webDriver;
    private final int MAX_WAIT_TIME = 10;



    public BasePageObjects (WebDriver webDriver){
        this.webDriver = webDriver;
    }


    protected WebElement findElementWithWait(By locator){
        try {
            return new WebDriverWait(webDriver, MAX_WAIT_TIME).until(
                    ExpectedConditions.visibilityOfElementLocated(locator)
            );
        } catch (WebDriverException ex){
            captureScreenShot();
        }
        return null;
    }

    private void captureScreenShot() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
        String time = LocalDateTime.now().format(dtf);
        File screenshot1 = new File("target/screenshot"+time+".png"); /// path to saved Screenshot
        File outFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(outFile.toPath(), screenshot1.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}