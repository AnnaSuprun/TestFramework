package com.it.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


public class DashboardPage extends BasePage {

    @FindBy(xpath = "//span[@class='sn_menu_title']")
    private WebElement lbUserEmail;

    @FindBy(xpath = "//div[@class='block_confirmation']/div[@class='content clear']")
    private WebElement lbConfirmSendEmail;

    public String getLbUserEmail() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 20);
//        WebElement element = webDriverWait.until(s -> s.findElement(By.xpath("//span[@class='sn_menu_title']")));
        WebElement element = webDriverWait.until(ExpectedConditions.visibilityOf(lbUserEmail));

//        FluentWait<WebDriver> driverFluentWait = new FluentWait<>(driver)
//                .withTimeout(20, TimeUnit.SECONDS)
//                .pollingEvery(5, TimeUnit.SECONDS)
//                .ignoreAll(Arrays.asList(NoSuchElementException.class, ExceptionInInitializerError.class));// игнорирует все ошибки из списка в течении 20 сек,
////                .ignoring(NoSuchElementException.class); // игнорирует ошибку в течении 20 сек,
//         // если эдлемент не найден отпадет с ошибкой NoSuchElementExceptio
//        driverFluentWait.until(ExpectedConditions.visibilityOf(lbUserEmail));
        return element.getText();
    }

    public String getLbConfirmSendEmail() {
        return lbConfirmSendEmail.getText();
    }
}
