package com.aston.aqajava.lesson15;

import com.aston.aqajava.lesson15.pages.CartPage;
import com.aston.aqajava.lesson15.pages.MainPage;
import com.aston.aqajava.lesson15.pages.ProductPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;


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

        MainPage mainPage = new MainPage(driver);

        mainPage.openMainPage();

        List<WebElement> listOfProducts = mainPage.createListOfProducts();
        WebElement product1 = listOfProducts.get(0);
        WebElement product2 = listOfProducts.get(1);
        WebElement product3 = listOfProducts.get(2);


        Actions action = new Actions(driver);
        ProductPage add = new ProductPage(driver);

        action.click(product1).build().perform();
        add.addToCart();
        action.click(product2).build().perform();
        add.addToCart();
        action.click(product3).build().perform();
        add.addToCart();


        mainPage.navigateToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.collectProductsInCart();

        assertAll(
                () -> assertTrue(add.getAddedProducts().size() == cartPage.collectProductsInCart().size()),
                () -> assertTrue(add.getAddedProducts().containsAll(cartPage.collectProductsInCart())),
                () -> assertTrue(cartPage.comparePrice())
        );
    }
    @AfterAll
    public static void tierDown(){
        driver.quit();
    }
}
