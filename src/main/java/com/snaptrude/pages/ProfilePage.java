package com.snaptrude.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class ProfilePage extends BasePage {
    @FindBy(css = ".row > *:nth-child(2)")
    private WebElement profileIcon;

    @FindBy(xpath = "//div[contains(text(),'Account')]")
    private WebElement accountButton;

    @FindBy(xpath = "//p[contains(text(),'Edit Profile Picture')]")
    private WebElement editProfilePictureButton;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public void goToAccount() {
        click(profileIcon);
        click(accountButton);
    }

    public void uploadProfilePicture(String imagePath) throws AWTException, InterruptedException {
        click(editProfilePictureButton);
        Thread.sleep(1000);
        StringSelection s = new StringSelection(imagePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
        Robot robot = new Robot();
        robot.delay(3000);
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_G);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_G);
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_V);
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
    }
} 