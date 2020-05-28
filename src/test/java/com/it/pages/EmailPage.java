package com.it.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends BasePage {
    @FindBy(id = "to")
    private WebElement inputToRecipient;

    @FindBy(xpath = "//input[@name='subject']")
    private WebElement inputSubject;

	@FindBy(id= "text")
	private WebElement inputMessage;

    @FindBy(xpath = "//p[@class='make_message']/a")
    private WebElement btnCreateEmail;

    @FindBy(xpath="//p[@class='send_container']//input[@name='send']")
    private WebElement btnSendEmail;

    @FindBy(xpath = "//form[@name='aform']//div[1]")
    private WebElement lastInputEmail;

    @FindBy(xpath = "//li[@class='new']/a")
    private WebElement btnInputEmails;

    protected void setRecipient(String recipient){
        inputToRecipient.sendKeys(recipient);
    }

    protected void setSubject(String subject){
        inputSubject.sendKeys(subject);
    }

    protected void setMessage(String message){
        inputMessage.sendKeys(message);
    }

    public void btnCreateEmail(){
        btnCreateEmail.click();
    }

    protected void btnClickSendEmail(){
        btnSendEmail.click();
    }

    protected boolean checkInputEmail(String sender){
        return lastInputEmail.getText().contains(sender);
    }

    public void btnInputEmails(){
        btnInputEmails.click();
    }


}
