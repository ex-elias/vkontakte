package com.vk.pages;

import com.vk.utils.PropertyReader;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    protected WebDriver webDriver;
    protected WebDriverWait wait;

    protected AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(PropertyReader.getInt("wait.timeout.seconds")));
        PageFactory.initElements(this.webDriver, this);
    }

    public void openSite(String url) {
        webDriver.navigate().to(url);
    }
}
