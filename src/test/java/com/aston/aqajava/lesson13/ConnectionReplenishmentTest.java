package com.aston.aqajava.lesson13;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class ConnectionReplenishmentTest {
    public static ChromeDriver driver;

    @BeforeAll
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cookie = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//button[@id=\"cookie-agree\"]")));
        cookie.click();
    }
    @Test
    public void testConnectionReplenishment(){
        driver.get("https://www.mts.by/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement phoneNumber = driver.findElement(By.xpath("//input[@class=\"phone\"]"));
        phoneNumber.sendKeys("297777777");

        WebElement replenishmentSum = driver.findElement(By.xpath("//input[@class=\"total_rub\"]"));
        replenishmentSum.sendKeys("10");

        WebElement continueButton = driver.findElement
                (By.xpath("//form[@id='pay-connection']//button[@type='submit']"));
        continueButton.click();
        driver.switchTo().frame(wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//iframe[@class='bepaid-iframe']"))));

        WebElement moneySum = driver.findElement(By.xpath("//p[@class=\"header__payment-amount\"]"));
        WebElement paymentInfo = driver.findElement(By.xpath("//p[@class=\"header__payment-info\"]"));
        WebElement cardNumber = driver.findElement(By.xpath("//label[@class=\"ng-tns-c47-1 ng-star-inserted\"]"));
        WebElement validDate = driver.findElement(By.xpath("//label[@class=\"ng-tns-c47-4 ng-star-inserted\"]"));
        WebElement codeCVC = driver.findElement(By.xpath("//label[@class=\"ng-tns-c47-5 ng-star-inserted\"]"));
        WebElement cartHolder = driver.findElement(By.xpath("//label[@class=\"ng-tns-c47-3 ng-star-inserted\"]"));

        assertAll(
                () -> assertEquals(" 10.00 BYN ", moneySum.getAttribute("textContent")),
                () -> assertEquals(" Оплата: Услуги связи\nНомер:375297777777 ",
                        paymentInfo.getAttribute("textContent")),
                () -> assertEquals("Номер карты",cardNumber.getAttribute("textContent") ),
                () -> assertEquals("Срок действия", validDate.getAttribute("textContent")),
                () -> assertEquals("CVC", codeCVC.getAttribute("textContent")),
                () -> assertEquals("Имя держателя (как на карте)", cartHolder.getAttribute("textContent"))
        );

    }
    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}

