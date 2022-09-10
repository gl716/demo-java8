package com.leon.chromedriver;
import java.net.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @author Leon
 * @since 2021年12月08日 17:57
 **/
public class ChromeDriverTest {

        public static void main(String[] args) throws MalformedURLException, InterruptedException {
            {
//                WebDriver driver = new RemoteWebDriver(
//                        new URL("http://127.0.0.1:9515"),
//                        new ChromeOptions());
//
//                driver.get("http://www.google.com");
//
//                driver.quit();
            }

            {
                System.setProperty("webdriver.chrome.driver", "D:\\Development\\chromedriver\\chromedriver.exe");
                WebDriver driver = new ChromeDriver();

                driver.get("http://www.google.com/");

                Thread.sleep(5000);  // Let the user actually see something!

                WebElement searchBox = driver.findElement(By.name("q"));

                searchBox.sendKeys("ChromeDriver");

                searchBox.submit();

                Thread.sleep(5000);  // Let the user actually see something!

                driver.quit();
            }


        }

}
