package com.vk.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ActionStep extends AbstractStep {

    public ActionStep(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Open site: {url}")
    public void openSite(String url) {
        signInPage.openSite(url);
    }

    @Step("Perform login")
    public void performLogin(String email, String password) {
        signInPage.performLogin(email, password);
    }

    @Step("Create new chat")
    public void createNewChat(String name) {
        messengerPage.createNewChat(name);
    }

    @Step("Attach audio from library")
    public void attachAudioFromLibrary() {
        messengerPage.selectAudioFromLibrary();
    }
}
