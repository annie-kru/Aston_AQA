package com.aston.aqajava.lesson17;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {
    public static AndroidDriver driver;
    @BeforeAll
    static void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","android");
        capabilities.setCapability("platformVersion","10");
        //capabilities.setCapability("deviceName","pixel-4");
        capabilities.setCapability("udid","emulator-5554");
        capabilities.setCapability("automationName","UIAutomator2");
        capabilities.setCapability("appPackage","com.google.android.calculator");
        capabilities.setCapability("appActivity","com.android.calculator2.Calculator");

        try {
            URL url = new URL("http://127.0.0.1:4723/wd/hub/");
            driver = new AndroidDriver(url,capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    By two = By.id("com.google.android.calculator:id/digit_2");
    By six = By.id("com.google.android.calculator:id/digit_6");
    By plus = By.id("com.google.android.calculator:id/op_add");
    By minus = By.id("com.google.android.calculator:id/op_sub");
    By multiply = By.id("com.google.android.calculator:id/op_mul");
    By divide = By.id("com.google.android.calculator:id/op_div");
    By equal = By.id("com.google.android.calculator:id/eq");
    By result = By.id("com.google.android.calculator:id/result_final");

    @Test
    @DisplayName("Checking the result of addition")
    @Severity(SeverityLevel.CRITICAL)
    public void testAddition(){
        driver.findElement(six).click();
        driver.findElement(plus).click();
        driver.findElement(two).click();
        driver.findElement(equal).click();
        String resultText = driver.findElement(result).getText();

        assertTrue(resultText.equals("8"));
    }
    @Test
    @DisplayName("Checking the result of subtraction")
    @Severity(SeverityLevel.CRITICAL)
    public void testSubtraction(){
        driver.findElement(six).click();
        driver.findElement(minus).click();
        driver.findElement(two).click();
        driver.findElement(equal).click();
        String resultText = driver.findElement(result).getText();

        assertTrue(resultText.equals("4"));
    }
    @Test
    @DisplayName("Checking the result of multiplication")
    @Severity(SeverityLevel.CRITICAL)
    public void testMultiplication(){
        driver.findElement(six).click();
        driver.findElement(multiply).click();
        driver.findElement(two).click();
        driver.findElement(equal).click();
        String resultText = driver.findElement(result).getText();

        assertTrue(resultText.equals("12"));
    }
    @Test
    @DisplayName("Checking the result of division")
    @Severity(SeverityLevel.CRITICAL)
    public void testDivision(){
        driver.findElement(six).click();
        driver.findElement(divide).click();
        driver.findElement(two).click();
        driver.findElement(equal).click();
        String resultText = driver.findElement(result).getText();

        assertTrue(resultText.equals("3"));
    }

    @AfterAll
   static void tearDown() {
        driver.quit();
    }
}