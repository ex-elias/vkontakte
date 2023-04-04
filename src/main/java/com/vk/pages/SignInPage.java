package com.vk.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInPage extends AbstractPage {

    @FindBy(id = "index_email")
    private WebElement emailInput;

    @FindBy(css = "input[type='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    public SignInPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void performLogin(String email, String password) {
        emailInput.sendKeys(email);
        submitButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        passwordInput.sendKeys(password);
        submitButton.click();
    }
}
