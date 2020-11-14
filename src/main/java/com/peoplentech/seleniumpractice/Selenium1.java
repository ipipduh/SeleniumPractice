package com.peoplentech.seleniumpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium1 {

    public static void main(String[] args) throws InterruptedException {

        // SETTING UP THE DATA
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        // CREATE OBJECT FOR DRIVER
        WebDriver driver = new ChromeDriver();
        // TELL DRIVER TO GO TO URL
        driver.get("https://target.com");

        // WAIT 5 SECONDS
        Thread.sleep(5000);
        // CLOSE CHROME
        driver.close();
    }

}
