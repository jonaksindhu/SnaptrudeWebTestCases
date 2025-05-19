package com.snaptrude.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class DrawPage extends BasePage {
    @FindBy(css = ".chmln-action > strong")
    private WebElement showYouAroundButton;

    @FindBy(css = ".chmln-close")
    private WebElement tutorialCloseButton;

    @FindBy(xpath = "//span[contains(text(),'Draw')]")
    private WebElement drawMenu;

    @FindBy(css = "*:nth-child(1) > .sc-uojGG > .topMenuIcon")
    private WebElement pencilTool;

    @FindBy(xpath = "//a[@href ='/dashboard']")
    private WebElement snaptrudeIcon;

    public DrawPage(WebDriver driver) {
        super(driver);
    }

    public void handleTutorialPopup() {
        wait.until(ExpectedConditions.visibilityOf(showYouAroundButton));
        click(showYouAroundButton);
        click(tutorialCloseButton);
    }

    public void selectDrawTool() {
        click(drawMenu);
        click(pencilTool);
    }

    public void drawTriangleAndQuadrilateral() throws AWTException, InterruptedException {
        Robot robot = new Robot();
        // Draw triangle
        robot.mouseMove(200, 200);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(400, 200);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(400, 400);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(200, 400);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(200, 200);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.keyRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(2000);
        Thread.sleep(2000);
        // Press L to exit and re-enter draw tool
        robot.keyPress(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_L);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_L);
        Thread.sleep(5000);
        // Draw quadrilateral
        robot.mouseMove(420, 420);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(700, 400);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(500, 700);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(300, 700);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(420, 420);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.keyRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(4000);
    }

    public void goToDashboard() throws InterruptedException {
        click(snaptrudeIcon);
        Thread.sleep(7000);
    }
} 