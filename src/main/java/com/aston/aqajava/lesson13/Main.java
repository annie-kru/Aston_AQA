package com.aston.aqajava.lesson13;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://mts.by");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement cookie = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id=\"cookie-agree\"]")));
        cookie.click();


        WebElement phoneNumber = driver.findElement(By.xpath("//input[@class=\"phone\"]"));
        phoneNumber.sendKeys("297777777");

        WebElement replenishmentSum = driver.findElement(By.xpath("//input[@class=\"total_rub\"]"));
        replenishmentSum.sendKeys("10");


        WebElement continueButton = driver.findElement(By.xpath("//button[@class=\"button button__default \"]"));
        continueButton.click();


        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/app-payment-container ")));

    driver.quit();

    }
}