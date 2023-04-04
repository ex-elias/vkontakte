package com.vk.tests;

import com.vk.utils.RetryAnalyzer;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Feature("Test functionality of VK site")
@Story("Test functionality of Messenger page")
public class MessengerTest extends BaseTest {

    @BeforeClass
    public void setUp() {
        actionStep.performLogin(System.getenv("EMAIL"), System.getenv("PASSWORD"));
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void createNewChatTest() {
        String newChatName = "Test-" + RandomStringUtils.randomNumeric(3);
        actionStep.createNewChat(newChatName);
        assertStep.assertCreatedChat(newChatName);
    }

    @Test(dependsOnMethods = "createNewChatTest", retryAnalyzer = RetryAnalyzer.class)
    public void attachAudioFromLibraryTest() {
        actionStep.attachAudioFromLibrary();
        assertStep.assertAttachedAudio();
    }
}
