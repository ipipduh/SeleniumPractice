package com.peoplentech.seleniumpractice;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumHomeworkWeddingWire extends TestBase {

    // I created before and after method with the help of Google and Youtube. It helps make sure these things run in the very beginning
    // I'll give each page a method rather than running it all together so it is easy to find mistakes or to perfect
    // Wanted to maximize the window for easier viewing
    @BeforeMethod
    public void setUp() {
        setupDriver();
        navigateToURL("https://www.weddingwire.com/");
        driver.manage().window().maximize(); // I don't like that it is delayed - is it because of the sleepFor(3); above?
        sleepFor(2);
    }

    @Test
    public static void validateNavigateBack() {

        // visit the venues link at the top
        driver.findElement(By.xpath("//*[@id=\"nav-main\"]/ul/li[2]/a")).click();

        sleepFor(2);

        navigateBack();

        sleepFor(2);

    }

    @Test
    public static void validateSearchBar(){

        // encountered an issue where the search bar was not clearing as I attempted to send keywords through
        // used .clear (below) - you can see the difference with and without it
        // I am clearing the text and then entering my desired text
        driver.findElement(By.xpath("//*[@id=\"txtStrSearch\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"txtStrSearch\"]")).sendKeys("Waterfront");

        sleepFor(2);

        // same thing, clearing the "Boston" and entering "Barcelona"
        driver.findElement(By.xpath("//*[@id=\"txtLocSearch\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"txtLocSearch\"]")).sendKeys("Barcelona");
        // Question - when I run it writes the template with my key send - how do I fix that?

        // click to search
        driver.findElement(By.xpath("//*[@id=\"mainSearchBtn\"]")).click();

        sleepFor(2);

    }

    @Test
            public static void validateAccountCreation() {

        //go to join page to sign up
        driver.findElement(By.xpath("//*[@id=\"menu\"]/div[1]/div/div/div[2]/div[2]/a[2]")).click();

        sleepFor(2);

        // enter first and last name
        driver.findElement(By.xpath("//*[@id=\"frmCapaAlta\"]/div/div[1]/input")).sendKeys("Pippa Kramou");

        sleepFor(2);

        // email
        driver.findElement(By.xpath("//*[@id=\"frmCapaAlta\"]/div/div[2]/div[1]/div/input")).sendKeys("philippakramou@gmail.com");

        sleepFor(2);

        // password
        driver.findElement(By.xpath("//*[@id=\"frmCapaAlta\"]/div/div[2]/div[2]/div/input")).sendKeys("abc123");

        sleepFor(2);

        // entering venue location
        driver.findElement(By.xpath("//*[@id=\"txtStrPoblacion\"]")).sendKeys("Barcelona");

        sleepFor(2);

        // calendar
        driver.findElement(By.xpath("//*[@id=\"frmCapaAlta\"]/div/div[4]/div/div/input")).click(); // stuck at the calendar, ask how to handle

        sleepFor(2);

    }

    @AfterMethod
    public void cleanUp() { // using this to close the @BeforeMethod. Cleaning up method means closing the driver.
//        closeDriver();
        driver.quit();
    }

}

