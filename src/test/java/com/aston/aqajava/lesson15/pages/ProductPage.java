package com.aston.aqajava.lesson15.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class ProductPage {
    WebDriver driver;
    List<Product> addedProducts= new ArrayList<>();


    public ProductPage(WebDriver driver){
        this.driver = driver;
    }
    By addToCartButton = By.xpath("//button[@class=\"btn-main\"]");
    By returnToMainButton = By.xpath("//button[@class=\"breadcrumbs__back\"]");
    By productName = By.xpath("//h1");
    By productPrice = By.xpath("//ins[@class=\"price-block__final-price\"]");

    public void addToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton)).click();
        String name =  (driver.findElement(productName)).getAttribute("textContent");
        String priceValue = (driver.findElement(productPrice))
                .getAttribute("innerHTML")
                .replaceAll("[^\\p{ASCII}]|&nbsp;| ", "");
        double price = Double.parseDouble(priceValue);
        addedProducts.add(new Product(name, price));
        driver.findElement(returnToMainButton).click();
    }

    public List<Product> getAddedProducts() {
        return addedProducts;
    }
}
