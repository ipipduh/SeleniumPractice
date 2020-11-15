package com.peoplentech.seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SeleniumHomeworkTarget extends TestBase {

// the goal is to look up an item using the search bar, click button, view the item, and then navigate back
    @Test
    public static void validateSearchBarAndClickButtonFunctionality(){

        setupDriver();
        navigateToURL("https://www.target.com");
        sleepFor(2);

        driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys("A Promised Land");

        sleepFor(2);

        driver.findElement(By.xpath("//*[@id=\"headerMain\"]/div/form/button[2]")).click();

                sleepFor(2);

        navigateBack();

        sleepFor(2);

        closeDriver();
    }

    @Test
            public static void AssertionTesting() {

        setupDriver();
        navigateToURL("https://www.target.com");
        sleepFor(2);

        // search for gift ideas via the search bar
        driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys("Gift Ideas");
        driver.findElement(By.xpath("//*[@id=\"headerMain\"]/div[1]/form/button[2]")).click();

        sleepFor(2);

        // constructor for currentUrl
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

//         assertion to test whether or not the url contains the information provided
//        Assert.assertTrue(currentUrl.contains("gift-ideas"));

        // and/or you can assert in the following way:
        // first one is actual, second one is expected
//           Assert.assertEquals(currentUrl, "https://www.target.com/c/gift-ideas/-/N-96d2i?lnk=snav_rd_gifts");

           // try it in a way that produces false/not equal to
        Assert.assertEquals(currentUrl, "https://www.target.com/c/gift-ideas-for-women/-/N-22vn7");

            sleepFor(2);

                closeDriver();
    }


    // the goal is to add items to cart and proceed to checkout
    @Test
    public static void validateCategoryDropDownAndSelectAndAddToCart() {
        setupDriver();
        navigateToURL("https://www.target.com");

        // Clicking the dropdown
        driver.findElement(By.xpath("//body/div[@id='root']/div[@id='viewport']/div[3]/div[2]/nav[1]/a[3]/span[2]")).click();

        sleepFor(3);

        // Selecting (3) - Target Black Friday
        driver.findElement(By.xpath("//*[@id='5q0f2']/a/div")).click();

        sleepFor(3);

        // Select "on select Virginia trees"
        driver.findElement(By.xpath("//*[@id=\"mainContainer\"]/div[4]/div/div[2]/div/div[3]/a/div[1]/div/div/div/div[2]")).click();

        sleepFor(3);

        // Select the Wondershop ornament set deals
        driver.findElement(By.xpath("//*[@id=\"mainContainer\"]/div[3]/div/div/div/div[3]/a/div[1]/div/div/div/div[2]")).click();

        sleepFor(3);

        // Select the rose gold ornaments
        driver.findElement(By.xpath("//a[contains(text(),'50ct Christmas 70mm Ornament Set Champagne Dusty R')]")).click();

        sleepFor(3);

        // Click "ship it"
        driver.findElement(By.xpath("//button[contains(text(),'Ship it')]")).click();

        sleepFor(3);

        // Click "view cart anc checkout" pop-up
        driver.findElement(By.xpath("//button[contains(text(),'View cart & checkout')]")).click(); // issue with pop-ups, ask for assistance
        // sometimes this fails and sometimes it passes - why? how to fix?

        sleepFor(3);

     //   driver.findElement(By.xpath("//*[@id=\"orderSummaryWrapperDiv\"]/div/div/div[2]/button")).click();

      //  sleepFor(3);

        closeDriver();
    }

}
