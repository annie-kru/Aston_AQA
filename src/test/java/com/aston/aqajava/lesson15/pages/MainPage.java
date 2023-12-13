package com.aston.aqajava.lesson15.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage {
    WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver = driver;
    }
    By mainPageContent = By.xpath("//div[@class=\"main-page__content\"]");
    By productsList = By.xpath("//a[@class=\"product-card__link j-card-link j-open-full-product-card\"]");
    By cartButton = By.xpath("//div[@class=\"navbar-pc__item j-item-basket\"]");

    public void openMainPage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement mainPageContentElement = wait.until(ExpectedConditions.visibilityOfElementLocated(mainPageContent));

        Thread.sleep(1000);
    }
    public List<WebElement> createListOfProducts(){
        List<WebElement> listOfProducts = driver.findElements(productsList);
        return listOfProducts;
    }
    public void navigateToCart() throws InterruptedException {
        WebElement cart = driver.findElement(cartButton);
        Actions action = new Actions(driver);
        action.click(cart).build().perform();
        Thread.sleep(2000);
    }
}
