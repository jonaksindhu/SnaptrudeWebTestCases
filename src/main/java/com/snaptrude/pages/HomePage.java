package com.snaptrude.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class HomePage extends BasePage {
    private By createProjectButton = By.xpath("//p[contains(text(),'Create a Project')]");
    private By projectNameInput = By.xpath("//input[@placeholder='Enter new project name']");
    private By unitsDropdown = By.cssSelector("div:nth-child(2) > div > div > img");
    private By createButton = By.cssSelector("div:nth-child(3) > div p");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickCreateProject() {
        driver.findElement(createProjectButton).click();
    }

    public void enterProjectName(String projectName) {
        driver.findElement(projectNameInput).sendKeys(projectName);
    }

    public void selectUnits(String units) {
        driver.findElement(unitsDropdown).click();
        List<WebElement> options = driver.findElements(unitsDropdown);
        for (WebElement option : options) {
            if (option.getText().equals(units)) {
                option.click();
                return;
            }
        }
    }

    public void clickCreate() {
        driver.findElement(createButton).click();
    }
} 