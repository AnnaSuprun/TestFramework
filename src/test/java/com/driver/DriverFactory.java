package com.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static com.it.common.Constants.BASE_URL;

class DriverFactory {

    public static WebDriver getDriver() {
        WebDriver driver = null;
        String driverName = System.getProperty("driver");
        if(driverName != null){
            if("fireFox".equals(driverName)){
                System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
                driver = new FirefoxDriver();
            }else if("chrome".equals(driverName)){
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
                driver = new ChromeDriver();
            }
        }else{
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
            driver = new ChromeDriver();
        }
        driver.get(BASE_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
