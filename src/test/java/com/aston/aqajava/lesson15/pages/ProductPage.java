package com.aston.aqajava.lesson15.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ProductPage {
    WebDriver driver;


    public ProductPage(WebDriver driver){
        this.driver = driver;
    }
    By addToCartButton = By.xpath("//button[@class=\"btn-main\"]");
    By returnToMainButton = By.xpath("//button[@class=\"breadcrumbs__back\"]");

    public void addToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton)).click();
        driver.findElement(returnToMainButton).click();
    }
}
