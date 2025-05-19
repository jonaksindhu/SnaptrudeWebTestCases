package com.snaptrude.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SignUpPage extends BasePage {
    private By otherOption = By.xpath("//span[contains(text(),'Other')]");
    private By designerOption = By.xpath("//span[contains(text(),'Designer')]");
    private By quickModellingOption = By.xpath("//span[contains(text(),'Quick modelling with data & BIM')]");
    private By remoteTeamsOption = By.xpath("//span[contains(text(),'Design collaboratively with remote teams')]");
    private By clientCommunicationOption = By.xpath("//span[contains(text(),'Improve design communication with clients')]");
    private By getStartedButton = By.xpath("//p[contains(text(),'Get Started')]");

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void selectOtherOption() {
        driver.findElement(otherOption).click();
    }

    public void selectDesignerOption() {
        driver.findElement(designerOption).click();
    }

    public void selectQuickModellingOption() {
        driver.findElement(quickModellingOption).click();
    }

    public void selectRemoteTeamsOption() {
        driver.findElement(remoteTeamsOption).click();
    }

    public void selectClientCommunicationOption() {
        driver.findElement(clientCommunicationOption).click();
    }

    public void clickGetStartedButton() {
        driver.findElement(getStartedButton).click();
    }
} 