package com.aston.aqajava.lesson13;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OnlineReplenishmentTest {
    public static WebDriver driver;

    @BeforeAll
    public static void setup(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
    }

    @Test
    public void testElementName(){
        WebElement replenishmentBlock = driver.findElement(By.xpath("//div[@class='pay__wrapper']//h2"));
        String name = replenishmentBlock.getText();
        assertTrue(name.contains("Онлайн пополнение\nбез комиссии"));
    }
    @Test
    public void testPaymentSystemLogos(){
        List<WebElement> paymentSystemLogos = driver.findElements(By.xpath("//div[@class='pay__wrapper']//ul//img"));
        assertFalse(paymentSystemLogos.isEmpty());
    }

    @Test
    public void testNextButton(){
        WebElement phoneNumber = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        phoneNumber.sendKeys("297777777");
        WebElement sum = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        sum.sendKeys("10");

        WebElement cookie = driver.findElement(By.xpath("//button[@class='cookie__close']"));
        cookie.click();

        WebElement button = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        button.click();
        WebElement popup = driver.findElement(By.xpath("//div[@class='app-wrapper__content']"));
        assertTrue(popup.isDisplayed());
    }
    @Test
    public void testPaymentServiceDetails(){
        WebElement serviceInfoLink = driver.findElement(By.xpath("//div[@class='pay__wrapper']//a"));
        serviceInfoLink.click();
        assertEquals(driver.getCurrentUrl(),"https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/");
    }
    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}

