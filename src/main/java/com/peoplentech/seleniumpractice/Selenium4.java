package com.peoplentech.seleniumpractice;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium4 extends TestBase {

    // creating object for Logger
    private static Logger LOGGER = Logger.getLogger(Selenium4.class);


    @Test
    public void validateDragAndDrop() { // INTERVIEW QUESTION (create an object of the class and give 2 xpath for source and destination and add to drag and drop method, then drag and drop element to page
        setupDriver("Chrome");
        navigateToURL("http://demo.guru99.com/test/drag_drop.html");
        sleepFor(2);

        // source AND destination xpath
        WebElement source = driver.findElement(By.xpath("(//li[@data-id=\"2\"])[1]"));
        WebElement destination = driver.findElement(By.xpath("//ol[@id=\"amt8\"]"));

        // actions constructor
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, destination).build().perform();

        sleepFor(5);
        closeDriver();
    }


    @Test(enabled = false)
    public void validateiFrame() { // iFrame work and this is mainly showing the concept and not the example
        setupDriver("Chrome");
        navigateToURL("https://www.tiktok.com/@lopezchristmas/video/6893211038523657478?lang=en");
        sleepFor(2);

      //  driver.switchTo().frame("frame1");
        driver.findElement(By.xpath("(//span[@class='jsx-2055372491 event-delegate-mask'])[3]")).click();

        driver.switchTo().defaultContent();
        //perform all actions required in the main page
        driver.findElement(By.xpath("xpath from main page")).click();

        sleepFor(2);
        closeDriver();

        // you can use YouTube or Tik Tok as an example, and find others to try for homework
    }


    @Test
    public void validateDropDown() {
        setupDriver("Chrome");
        navigateToURL("https://www.ebay.com");
        sleepFor(2);

        WebElement element = driver.findElement(By.id("gh-cat"));

        Select select = new Select(element); // using this to choose text, know for interviews
        select.selectByVisibleText("Music");

        sleepFor(2);
        closeDriver();
    }

    @Test
    public void validateMouseHover() {
        setupDriver("Chrome");
        navigateToURL("https://www.ebay.com");
        sleepFor(2);

        WebElement motors = driver.findElement(By.linkText("Motors"));
        Actions actions = new Actions(driver);
        actions.moveToElement(motors).build().perform();

        sleepFor(2);

        driver.findElement(By.linkText("Cars & Trucks")).click();

        sleepFor(2);
        closeDriver();

    }

    @Test
    public void validateMouseHoverExercise() {
        setupDriver("Chrome");
        navigateToURL("https://www.ebay.com");
        sleepFor(2);

        WebElement sportinggoods = driver.findElement(By.linkText("Sporting Goods"));
        Actions actions = new Actions(driver);
        actions.moveToElement(sportinggoods).build().perform();

        sleepFor(2);

        driver.findElement(By.linkText("Golf")).click();

        sleepFor(2);

        navigateBack();

        sleepFor(2);

        WebElement toysandhobbies = driver.findElement(By.linkText("Toys & hobbies"));
        Actions action = new Actions(driver);
        actions.moveToElement(toysandhobbies).build().perform();

        sleepFor(2);

        driver.findElement(By.linkText("Action figures")).click();

        sleepFor(2);
        closeDriver(); // fix this there is an error in the second web element somewhere
    }

    @Test
    public void validateScroll(){
        setupDriver("Chrome");
        navigateToURL("https://www.ebay.com");
        sleepFor(2);

        JavascriptExecutor js = (JavascriptExecutor) driver; // driver will have capability of Javascript
        js.executeScript("window.scrollBy(0,1000)");

        sleepFor(2);
        closeDriver();
    }

    @Test
    public void validateScrollToElement(){ // can Selenium perform scrolling by itself? No, you have to cast it and use JavascriptExecutor
        setupDriver("Chrome");
        navigateToURL("https://www.ebay.com");
        sleepFor(2);

        WebElement element = driver.findElement(By.linkText("Announcements"));
        JavascriptExecutor js = (JavascriptExecutor) driver; // driver will have capability of Javascript
        js.executeScript("arguments[0].scrollIntoView(true);",element);

        sleepFor(2);
        closeDriver();
    }

//    @Test
//    public void validatePopup(){ // ERROR IN THIS CHECK ZAN'S CODE
//        setupDriver("Chrome");
//        navigateToURL("http://demo.guru99.com/test/delete_customer.php");
//        sleepFor(2);
//
//        driver.findElement(By.xpath("//input[@name=\"cusid\"]")).sendKeys("1");
//        sleepFor(2);
//        driver.findElement(By.xpath("//input[@name=\"submit\"]")).click();
//        sleepFor(2);
//
//        String popup1 = driver.switchTo().alert().getText();
//        System.out.println(popup1);
//        driver.switchTo().alert().accept(); // you can also put dismiss and then bottom code would not have to be included
//        LOGGER.info(popup1);
//
//        String popup2 = driver.switchTo().alert().getText();
//        System.out.println(popup2);
//        driver.switchTo().alert().accept();
//        LOGGER.info(popup2);
//         //how do you handle a popup - INTERVIEW question - tell driver to switch to alert, then you can get, dismiss, or accept it
//
//        sleepFor(2);
//        closeDriver();
//    }

    @Test // Zan's code
    public void validatePopup() {
        setupDriver("chrome");
        navigateToURL("http://demo.guru99.com/test/delete_customer.php");
        sleepFor(2);

        driver.findElement(By.xpath("//input[@name=\"cusid\"]")).sendKeys("1");
        driver.findElement(By.xpath("//input[@name=\"submit\"]")).click();


        String popup1 = driver.switchTo().alert().getText();
        LOGGER.info(popup1);

        driver.switchTo().alert().accept();

        sleepFor(2);
        String popup2 = driver.switchTo().alert().getText();
        LOGGER.info(popup2);

        driver.switchTo().alert().accept();

        sleepFor(5);
        closeDriver();
    }
}
