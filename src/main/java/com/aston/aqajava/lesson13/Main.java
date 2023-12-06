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

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://mts.by");
        WebElement phoneNumber = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        phoneNumber.sendKeys("297777777");
        WebElement sum = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        sum.sendKeys("10");

        WebElement cookie = driver.findElement(By.xpath("//button[@class='cookie__close']"));
        cookie.click();

        WebElement button = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        button.click();
        WebElement popup = driver.findElement(By.xpath("//div[@class='app-wrapper__content']"));
        System.out.println(popup.isDisplayed());



    driver.quit();

    }
}


//*[@id="pay-section"]/div/div/div[2]/section/div
//*[@id="pay-section"]/div/div/div[2]/section/div
//*[@id="pay-section"]/div/div/div[2]/section/div/div[2]/ul/li[1]/img
//*[@id="pay-section"]/div/div/div[2]/section/div/div[2]
//div[@class='app-payment-container']
//*[@id="pay-section"]/div/div/div[2]/section/div/a

//html/body/app-root/div/div/app-payment-container
//html/body/app-root/div/div

//new WebDriverWait(getWebDriver(), 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id="pay-connection"]/button"))).click();