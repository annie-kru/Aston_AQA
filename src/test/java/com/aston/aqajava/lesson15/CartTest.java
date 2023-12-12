package com.aston.aqajava.lesson15;

import com.aston.aqajava.lesson15.pages.ProductPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class CartTest {
    public static ChromeDriver driver;
    @BeforeAll
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.wildberries.ru/");
    }
    @Test
    public void test() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement mainPageContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"main-page__content\"]")));

        Thread.sleep(1000);
        List<WebElement> listOfProducts = driver.findElements(By.xpath("//a[@class=\"product-card__link j-card-link j-open-full-product-card\"]"));

        System.out.println(listOfProducts.size());

        Actions action = new Actions(driver);

        WebElement product1 = listOfProducts.get(0);
        WebElement product2 = listOfProducts.get(1);
        WebElement product3 = listOfProducts.get(2);

        ProductPage add = new ProductPage(driver);
        action.click(product1).build().perform();
        add.addToCart();
        action.click(product2).build().perform();
        add.addToCart();
        Thread.sleep(2000);

        WebElement cart = driver.findElement(By.xpath("//div[@class=\"navbar-pc__item j-item-basket\"]"));
        action.click(cart).build().perform();
        Thread.sleep(2000);
    }
    @AfterAll
    public static void tierDown(){
        driver.quit();
    }
}
