package com.vk.steps;

import com.vk.pages.MessengerPage;
import com.vk.pages.SignInPage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

    protected SignInPage signInPage;
    protected MessengerPage messengerPage;

    protected AbstractStep(WebDriver webDriver) {
        signInPage = new SignInPage(webDriver);
        messengerPage = new MessengerPage(webDriver);
    }
}
