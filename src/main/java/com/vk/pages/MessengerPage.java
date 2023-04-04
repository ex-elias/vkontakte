package com.vk.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MessengerPage extends AbstractPage {

    private static String expectedAudioTitle;
    private final Actions actions;

    @FindBy(className = "_im_create_convo")
    private WebElement newChatCreateButton;

    @FindBy(id = "im_dialogs_creation_name")
    private WebElement newChatNameInput;

    @FindBy(className = "_im_confirm_creation")
    private WebElement newChatConfirmButton;

    @FindBy(className = "_im_dialog_link")
    private WebElement chatName;

    @FindBy(className = "ms_items_more_wrap")
    private WebElement mediaSelector;

    @FindBy(className = "ms_item_audio")
    private WebElement audioItem;

    @FindBy(className = "ape_attach")
    private WebElement attachAudioButton;

    @FindBy(className = "audio_row__performer_title")
    private WebElement audioTitle;

    public MessengerPage(WebDriver webDriver) {
        super(webDriver);
        actions = new Actions(webDriver);
    }

    public static String getExpectedAudioTitle() {
        return expectedAudioTitle;
    }

    public static void setExpectedAudioTitle(String audioTitle) {
        expectedAudioTitle = audioTitle;
    }

    public String getAttachedAudioTitle() {
        return audioTitle.getText();
    }

    public void createNewChat(String name) {
        newChatCreateButton.click();
        newChatNameInput.sendKeys(name);
        newChatConfirmButton.click();
    }

    public void selectAudioFromLibrary() {
        actions.moveToElement(mediaSelector).perform();
        audioItem.click();
        wait.until(ExpectedConditions.elementToBeClickable(audioTitle));
        setExpectedAudioTitle(audioTitle.getText());
        attachAudioButton.click();
    }

    public boolean getCreatedChatName(String name) {
        return wait.until(ExpectedConditions.textToBePresentInElement(chatName, name));
    }
}
