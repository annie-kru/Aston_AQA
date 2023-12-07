package com.aston.aqajava.lesson13;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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
    public void testPaymentServiceDetails(){
        WebElement serviceInfoLink = driver.findElement(By.xpath("//div[@class='pay__wrapper']//a"));
        serviceInfoLink.click();
        assertEquals(driver.getCurrentUrl(),"https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/");
    }
    @Test
    public void testNextButton(){
        driver.get("https://www.mts.by/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cookie = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//button[@id=\"cookie-agree\"]")));
        cookie.click();

        WebElement phoneNumber = driver.findElement(By.xpath("//input[@class=\"phone\"]"));
        phoneNumber.sendKeys("297777777");

        WebElement replenishmentSum = driver.findElement(By.xpath("//input[@class=\"total_rub\"]"));
        replenishmentSum.sendKeys("10");

        WebElement continueButton = driver.findElement
                (By.xpath("//form[@id='pay-connection']//button[@type='submit']"));
        continueButton.click();
        driver.switchTo().frame(wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//iframe[@class='bepaid-iframe']"))));

        WebElement popup = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//app-payment-container")));

        assertTrue(popup.isDisplayed());
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}

