package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("START - main");

        WebDriver driver = null;
        try {
            System.out.println("1 - WebDriverManager setup start");
            WebDriverManager.chromedriver().setup();
            System.out.println("2 - WebDriverManager setup done");

            // ChromeOptions: enable headless by uncommenting the line below if you want no browser window
            ChromeOptions options = new ChromeOptions();
            // options.addArguments("--headless=new"); // <- uncomment to run headless (no UI)
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");

            System.out.println("3 - creating ChromeDriver");
            driver = new ChromeDriver(options);
            System.out.println("4 - driver created");

            System.out.println("5 - navigating to https://www.google.com");
            driver.get("https://www.google.com");

            System.out.println("6 - page title: " + driver.getTitle());

            // Example simple interaction (uncomment if you want to test clicking/typing)
            // WebElement search = driver.findElement(By.name("q"));
            // search.sendKeys("Selenium WebDriver");
            // search.submit();

            System.out.println("7 - finished actions");
        } catch (Throwable t) {
            System.err.println("ERROR in main:");
            t.printStackTrace();
        } finally {
            if (driver != null) {
                try {
                    driver.quit();
                    System.out.println("8 - driver.quit() called");
                } catch (Throwable t) {
                    System.err.println("ERROR while quitting driver:");
                    t.printStackTrace();
                }
            }
            System.out.println("END - main");
        }
    }
}