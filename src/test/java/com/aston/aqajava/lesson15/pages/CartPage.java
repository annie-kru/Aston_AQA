package com.aston.aqajava.lesson15.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    By allProductsInCart = By.xpath("//div[@class=\"basket-list__accordion accordion\"]");
    By productDetails = By.xpath("//div[@class=\"list-item__wrap\"]");
    String productNamePath = "(//a[@class=\"img-plug list-item__good-img j-product-popup\"])[%s]";
    String productPricePath = "(//div[@class=\"list-item__price-new\"])[%s]";
    By totalPriceInCart = By.xpath("//span[@class=\"b-right\"]");

    public List<Product> collectProductsInCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(allProductsInCart));

        List<WebElement> productsInCart = driver.findElements(productDetails);
        List<Product> listOfProductsForComparison = new ArrayList<>();

        for (int i = 1; i <= productsInCart.size(); i++){

            WebElement productNameElement = driver.findElement(By.xpath(String.format(productNamePath,i)));
            String productName = productNameElement.getAttribute("title");

            WebElement productPriceElement = driver.findElement(By.xpath(String.format(productPricePath,i)));
            String productPriceString = productPriceElement.getAttribute("innerHTML").
                    replaceAll("[^\\p{ASCII}]|&nbsp;| ", "");
            double productPrice = Double.parseDouble(productPriceString);

            listOfProductsForComparison.add(new Product(productName, productPrice));
        }
        return listOfProductsForComparison;
    }
    private double totalCartPrice(){
        WebElement totalPriceElement = driver.findElement(totalPriceInCart);
        String totalPriceString = totalPriceElement.getAttribute("innerHTML").
                replaceAll("[^\\p{ASCII}]|&nbsp;| ", "");
        double totalPrice = Double.parseDouble(totalPriceString);

        return totalPrice;
    }
    public boolean comparePrice(){
       double cartPrice =  totalCartPrice();
       double productPrice = 0;
       List <Product> products= collectProductsInCart();

       for(int i = 0; i < products.size(); i++){
           productPrice += products.get(i).getPrice();
       }
       return (cartPrice == productPrice);
    }
}
