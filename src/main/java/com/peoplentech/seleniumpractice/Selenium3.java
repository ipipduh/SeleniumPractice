package com.peoplentech.seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium3 extends TestBase {

// xpath rules
    //tagName[text()=' '] ---> text
    //tagName[@attribute=' '] ---> id/class/aria-label etc


    public static void main(String[] args) {
        // validateUserCanTypeOnSearchBar();
        //validateUserCanTypeOnSearchBarAndClickSearchButton();
    }

//        @Test
//    public static void validateUserCanTypeOnSearchBar() {
//        setupDriver("Chrome");
//        navigateToURL("https://www.ebay.com");
//
//        // by id
//        driver.findElement(By.id("gh-ac")).sendKeys("Java Books");
//        // by xpath
//        //   driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("Java Books");
//
//        sleepFor(2);
//        closeDriver();
//    }
//
//    @Test
//    public static void validateUserCanTypeOnSearchBarAndClickSearchButton() {
//        setupDriver("Chrome");
//        navigateToURL("https://www.ebay.com");
//
//        driver.findElement(By.id("gh-ac")).sendKeys("Java Books");
//        driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
//        sleepFor(2);
//
//        WebElement searchedItem = driver.findElement(By.xpath("//span[text()='Java Books']"));
//        String actualText = searchedItem.getText();
//        System.out.println(actualText);
//
//        Assert.assertEquals(actualText, "Java Books");
//
//        searchedItem.isDisplayed();
//
//        sleepFor(2);
//        closeDriver();
//    }
//
//    @Test
//    public static void validateProductDropDown() {
//        setupDriver("Chrome");
//        navigateToURL("https://www.ebay.com");
//
//        // print the data
//        String data = driver.findElement(By.xpath("//select[@id='gh-cat']")).getText();
//        System.out.println(data);
//
//        // get all the elements in the list
//        List<WebElement> dropDown = driver.findElements(By.xpath("//select[@id='gh-cat']/option"));
//        System.out.println(dropDown.size());
//
//        dropDown.get(4).click();
//        sleepFor(4);
//        closeDriver();
//    }
//
//    @Test
//    public static void validateSearchClick(){
//        setupDriver("Chrome");
//        navigateToURL(("https://www.ebay.com"));
//
//        driver.findElement(By.id("//input[@id='gh-btn']")).click();
//
//        sleepFor(5);
//        closeDriver();
//
//    }

//    @Test
//    public static void validateUserCanTypeOnSearchBarAndChooseFromDropDownAndSearch(){
//        setupDriver("Chrome");
//        navigateToURL("https://www.ebay.com");
//        driver.findElement(By.xpath("//*[@id='gh-ac']")).sendKeys("Java Books");
//
//        List<WebElement>dropDown = driver.findElements(By.xpath("//select[@id='gh-cat']/option"));
//        System.out.println(dropDown.size());
//        dropDown.get(4).click();
//
//        driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
//
//        sleepFor(5);
//        closeDriver();
//    }

            @Test
            public static void SeleniumMethods() {
                setupDriver("Chrome");
                navigateToURL("https://www.ebay.com");
                WebElement clickElement = driver.findElement(By.xpath("//input[@id='gh-btn']"));
                clickElement.click();

                sleepFor(5);
                driver.findElement(By.xpath("//h2[text()='eBay Motors']")).click();

                sleepFor(5);
                String currentUrl = driver.getCurrentUrl();

                System.out.println(currentUrl);

                //  Assert.assertTrue(currentUrl.contains("Auto-Parts-and-Vehicles"));

                // first one is actual, second one is expected
                //   Assert.assertEquals(currentUrl, "https://www.ebay.com/b/Auto-Parts-and-Vehicles/6000/bn_1865334");

                sleepFor(2);
                closeDriver();

            }

        }

