package com.vk.tests;

import com.vk.steps.ActionStep;
import com.vk.steps.AssertStep;
import com.vk.utils.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    protected ActionStep actionStep;
    protected AssertStep assertStep;
    private WebDriver webDriver;

    @BeforeClass(alwaysRun = true)
    public void setUp(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PropertyReader.getInt("wait.timeout.seconds")));
        context.setAttribute("driver", webDriver);
        actionStep = new ActionStep(webDriver);
        assertStep = new AssertStep(webDriver);
        actionStep.openSite(PropertyReader.get("messenger.url"));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        webDriver.quit();
    }
}
