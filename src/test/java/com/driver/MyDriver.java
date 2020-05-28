package com.driver;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.it.common.Constants.BASE_WAIT;

public class MyDriver implements WebDriver {
    private WebDriver driver;
    public WebDriverWait wait;
    private static MyDriver myDriver;
    private static int count;


    private MyDriver() {
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, BASE_WAIT);
    }

    public static MyDriver getMyDriver() {
        if (myDriver == null) {
            return myDriver = new MyDriver();
        } else {
            return myDriver;
        }
    }


    /***
     * Scroll UP
     */
    public void scrollUp() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)");
    }


    /***
     * Scroll DOWN
     */
    public void scrollDown() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    @Override
    public void get(String url) {
        driver.get(url);
    }

    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        List<WebElement> webElements = new ArrayList<>();
        driver.findElements(by).forEach(s -> webElements.add(new WrappedWebElement(s)));
        return webElements;
    }

    @Override
    public WebElement findElement(By by) {
        System.out.println("Hi");
        return new WrappedWebElement(driver.findElement(by));
    }

    @Override
    public String getPageSource() {
        return driver.getPageSource();
    }

    @Override
    public void close() {
        driver.close();
    }

    @Override
    public void quit() {
        driver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return driver.navigate();
    }

    @Override
    public Options manage() {
        return driver.manage();
    }

    public boolean isElementPresent(By locator) {
        boolean result = false;
        driver.manage().timeouts().
                implicitlyWait(0, TimeUnit.SECONDS);
        try {
            List<WebElement> list = driver.findElements(locator);
            driver.manage().timeouts().
                    implicitlyWait(BASE_WAIT, TimeUnit.SECONDS);
            result = list.size() != 0 && list.get(0).isDisplayed();
        } catch (StaleElementReferenceException | NoSuchElementException e) {
            //NOP
        }
        return result;
    }

    /**
     * Scroll  to Element
     *
     * @param element
     */
    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void takeSnapShot() {
        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShot, new File("build/screenshot/screen" + count + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Path content = Paths.get("build//screenshot//screen" + count + ".png");
        try (InputStream is = Files.newInputStream(content)) {
            Allure.addAttachment("My attachment", is);
        } catch (IOException e) {
            //NOP
        }
        count++;
    }

    public void logToAllure(String log) {
//        Allure.addAttachment("Logs", log.toString());
        Allure.addAttachment("Console log: ", log);
    }

}
