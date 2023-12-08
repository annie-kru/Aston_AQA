package com.aston.aqajava.lesson13;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReplenishmentTest{
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
    public void testCommunicationServicesFields() {
        driver.get("https://www.mts.by/");

        Actions action = new Actions(driver);
        WebElement payForm = driver.findElement(By.xpath("//div[@class=\"pay__wrapper\"]"));
        action.moveToElement(payForm).perform();

        WebElement openMenu = driver.findElement(By.xpath("//button[@class=\"select__header\"]"));
        action.click(openMenu).build().perform();

        List <WebElement> dropdownMenu = driver.findElements(By.xpath("//p[@class=\"select__option\"]"));
        action.click(dropdownMenu.get(0)).build().perform();

        WebElement dropdownSelected = driver.findElement(By.xpath("//span[@class=\"select__now\"]"));
        WebElement phone = driver.findElement(By.xpath("//input[@id=\"connection-phone\"]"));
        WebElement sum = driver.findElement(By.xpath("//input[@id=\"connection-sum\"]"));
        WebElement email = driver.findElement(By.xpath("//input[@id=\"connection-email\"]"));

        assertAll(
                () -> assertEquals("Услуги связи", dropdownSelected.getAttribute("textContent")),
                () -> assertEquals("Номер телефона", phone.getAttribute("placeholder")),
                () -> assertEquals("Сумма", sum.getAttribute("placeholder")),
                () -> assertEquals("E-mail для отправки чека", email.getAttribute("placeholder"))
        );
    }
    @Test
    public void testHomeInternetFields() {
        driver.get("https://www.mts.by/");

        Actions action = new Actions(driver);
        WebElement payForm = driver.findElement(By.xpath("//div[@class=\"pay__wrapper\"]"));
        action.moveToElement(payForm).perform();

        WebElement openMenu = driver.findElement(By.xpath("//button[@class=\"select__header\"]"));
        action.click(openMenu).build().perform();

        List <WebElement> dropdownMenu = driver.findElements(By.xpath("//p[@class=\"select__option\"]"));
        action.click(dropdownMenu.get(1)).build().perform();

        WebElement dropdownSelected = driver.findElement(By.xpath("//span[@class=\"select__now\"]"));
        WebElement phone = driver.findElement(By.xpath("//input[@id=\"internet-phone\"]"));
        WebElement sum = driver.findElement(By.xpath("//input[@id=\"internet-sum\"]"));
        WebElement email = driver.findElement(By.xpath("//input[@id=\"internet-email\"]"));

        assertAll(
                () -> assertEquals("Домашний интернет", dropdownSelected.getAttribute("textContent")),
                () -> assertEquals("Номер абонента", phone.getAttribute("placeholder")),
                () -> assertEquals( "Сумма", sum.getAttribute("placeholder")),
                () -> assertEquals("E-mail для отправки чека", email.getAttribute("placeholder"))
        );
    }
    @Test
    public void testInstalmentFields(){
        driver.get("https://www.mts.by/");

        Actions action = new Actions(driver);

        WebElement openMenu = driver.findElement(By.xpath("//button[@class=\"select__header\"]"));
        action.click(openMenu).build().perform();

        WebElement payForm = driver.findElement(By.xpath("//div[@class=\"pay__wrapper\"]"));
        action.moveToElement(payForm).perform();

        List <WebElement> dropdownMenu = driver.findElements(By.xpath("//p[@class=\"select__option\"]"));
        action.click(dropdownMenu.get(2)).build().perform();

        WebElement dropdownSelected = driver.findElement(By.xpath("//span[@class=\"select__now\"]"));
        WebElement phone = driver.findElement(By.xpath("//input[@id=\"score-instalment\"]"));
        WebElement sum = driver.findElement(By.xpath("//input[@id=\"instalment-sum\"]"));
        WebElement email = driver.findElement(By.xpath("//input[@id=\"instalment-email\"]"));

        assertAll(
                () -> assertEquals("Рассрочка", dropdownSelected.getAttribute("textContent")),
                () -> assertEquals("Номер счета на 44", phone.getAttribute("placeholder")),
                () -> assertEquals( "Сумма", sum.getAttribute("placeholder")),
                () -> assertEquals("E-mail для отправки чека", email.getAttribute("placeholder"))
        );
    }
    @Test
    public void testDebtFields(){
        driver.get("https://www.mts.by/");

        Actions action = new Actions(driver);

        WebElement openMenu = driver.findElement(By.xpath("//button[@class=\"select__header\"]"));
        action.click(openMenu).build().perform();

        WebElement payForm = driver.findElement(By.xpath("//div[@class=\"pay__wrapper\"]"));
        action.moveToElement(payForm).perform();

        List <WebElement> dropdownMenu = driver.findElements(By.xpath("//p[@class=\"select__option\"]"));
        action.click(dropdownMenu.get(3)).build().perform();

        WebElement dropdownSelected = driver.findElement(By.xpath("//span[@class=\"select__now\"]"));
        WebElement phone = driver.findElement(By.xpath("//input[@id=\"score-arrears\"]"));
        WebElement sum = driver.findElement(By.xpath("//input[@id=\"arrears-sum\"]"));
        WebElement email = driver.findElement(By.xpath("//input[@id=\"arrears-email\"]"));

        assertAll(
                () -> assertEquals("Номер счета на 2073", phone.getAttribute("placeholder")),
                () -> assertEquals( "Сумма", sum.getAttribute("placeholder")),
                () -> assertEquals("E-mail для отправки чека", email.getAttribute("placeholder"))
        );
    }
    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}

