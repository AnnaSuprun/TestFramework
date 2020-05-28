package com.it.helpers;

import com.it.pages.BasePage;

import org.apache.log4j.Logger;

public class CommonHelper extends BasePage {
    public void appStop(){
        driver.quit();
    }

    public void takeScreenShot(){
        driver.takeSnapShot();
    }

    public void addLogToAllure(){
        driver.logToAllure(log.toString());
    }

}
