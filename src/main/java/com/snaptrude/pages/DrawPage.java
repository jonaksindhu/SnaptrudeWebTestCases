package com.snaptrude.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

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

    // Add selectors for drawing tool states
    @FindBy(css = ".drawing-tool-active")
    private WebElement drawingToolActive;

    @FindBy(css = ".drawing-tool-ready")
    private WebElement drawingToolReady;

    @FindBy(css = ".shape-loading")
    private WebElement shapeLoading;

    private static final Duration DEFAULT_WAIT = Duration.ofSeconds(10);

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
        // Wait for drawing tool to be ready
        waitForToolReady();
    }

    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private void drawShape(Robot robot, Point[] points, Duration waitAfterDrawing) throws InterruptedException {
        // Wait for drawing tool to be active
        waitForToolActive();
        
        // Move to first point
        robot.mouseMove(points[0].x, points[0].y);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);

        // Draw lines to subsequent points
        for (int i = 1; i < points.length; i++) {
            robot.mouseMove(points[i].x, points[i].y);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        }

        // Close the shape by returning to the first point
        robot.mouseMove(points[0].x, points[0].y);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.keyRelease(InputEvent.BUTTON1_DOWN_MASK);
        
        // Wait for shape to be drawn
        waitForShapeToBeDrawn();
    }

    private void waitForShapeToBeDrawn() {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT);
        try {
            // Wait for shape loading indicator to disappear
            wait.until(ExpectedConditions.invisibilityOf(shapeLoading));
            System.out.println("Shape drawing completed");
        } catch (Exception e) {
            System.out.println("No shape loading indicator found, continuing...");
        }
    }

    private void resetDrawTool(Robot robot) {
        // Press L to exit and re-enter draw tool
        robot.keyPress(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_L);
        
        // Wait for tool to reset
        waitForToolReset();
        
        robot.keyPress(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_L);
        
        // Wait for tool to be ready
        waitForToolReady();
    }

    private void waitForToolActive() {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT);
        try {
            wait.until(ExpectedConditions.visibilityOf(drawingToolActive));
            System.out.println("Drawing tool is active");
        } catch (Exception e) {
            System.out.println("Drawing tool active state not detected, continuing...");
        }
    }

    private void waitForToolReset() {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT);
        try {
            wait.until(ExpectedConditions.invisibilityOf(drawingToolActive));
            System.out.println("Drawing tool reset completed");
        } catch (Exception e) {
            System.out.println("Drawing tool reset state not detected, continuing...");
        }
    }

    private void waitForToolReady() {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT);
        try {
            wait.until(ExpectedConditions.visibilityOf(drawingToolReady));
            System.out.println("Drawing tool is ready");
        } catch (Exception e) {
            System.out.println("Drawing tool ready state not detected, continuing...");
        }
    }

    public void drawTriangleAndQuadrilateral() throws AWTException, InterruptedException {
        Robot robot = new Robot();

        // Draw triangle
        Point[] trianglePoints = {
            new Point(200, 200),
            new Point(400, 200),
            new Point(400, 400),
            new Point(200, 200)  // Closing point
        };
        drawShape(robot, trianglePoints, DEFAULT_WAIT);

        // Reset draw tool
        resetDrawTool(robot);

        // Draw quadrilateral
        Point[] quadrilateralPoints = {
            new Point(420, 420),
            new Point(700, 400),
            new Point(500, 700),
            new Point(300, 700),
            new Point(420, 420)  // Closing point
        };
        drawShape(robot, quadrilateralPoints, DEFAULT_WAIT);
    }

    public void goToDashboard() {
        click(snaptrudeIcon);
        // Wait for dashboard to load
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT);
        wait.until(ExpectedConditions.urlContains("dashboard"));
    }
} 