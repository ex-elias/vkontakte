package com.vk.steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class AssertStep extends AbstractStep {

    public AssertStep(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Assert created chat")
    public void assertCreatedChat(String name) {
        assertThat(messengerPage.getCreatedChatName(name)).as("Created chat name is incorrect").isTrue();
    }

    @Step("Assert attached audio")
    public void assertAttachedAudio() {
        assertThat(messengerPage.getAttachedAudioTitle()).as("Attached audio title is incorrect")
                .isEqualTo(messengerPage.getExpectedAudioTitle());
    }
}
