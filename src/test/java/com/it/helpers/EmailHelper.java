package com.it.helpers;

import com.it.email.Email;
import com.it.pages.EmailPage;

public class EmailHelper extends EmailPage {

    public void sendEmail(String recipient, String subject, String message){
        btnCreateEmail();
        setRecipient(recipient);
        setSubject(subject);
        setMessage(message);
        btnClickSendEmail();
    }

    public boolean checkLastInputEmail(String sender){
        btnInputEmails();
        return checkInputEmail(sender);
    }

    public void sendEmail(Email email){
        log.info(String.format("Send new email to %s with subject %s ", email.getRecipient(), email.getSubject()));
        sendEmail(email.getRecipient(), email.getSubject(), email.getMessage());
    }
}
