package com.snaptrude.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//p[contains(text(),'Sign Up here')]")
    private WebElement signUpLink;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//p[contains(text(),'Sign Up')]")
    private WebElement signUpButton;

    @FindBy(xpath = "//span[contains(text(),'Other')]")
    private WebElement industryOtherOption;

    @FindBy(xpath = "//span[contains(text(),'Designer')]")
    private WebElement roleDesignerOption;

    @FindBy(xpath = "//span[contains(text(),'Quick modelling with data & BIM')]")
    private WebElement quickModellingOption;

    @FindBy(xpath = "//span[contains(text(),'Design collaboratively with remote teams')]")
    private WebElement collaborativeDesignOption;

    @FindBy(xpath = "//span[contains(text(),'Improve design communication with clients')]")
    private WebElement designCommunicationOption;

    @FindBy(xpath = "//p[contains(text(),'Get Started')]")
    private WebElement getStartedButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickSignUpHere() {
        click(signUpLink);
    }

    public void enterSignUpDetails(String name, String email, String password) {
        sendKeys(firstNameInput, name);
        sendKeys(emailInput, email);
        sendKeys(passwordInput, password);
    }

    public void clickSignUpButton() {
        click(signUpButton);
    }

    public void selectIndustryAndRole() {
        click(industryOtherOption);
        click(roleDesignerOption);
    }

    public void selectAllOptions() {
        click(quickModellingOption);
        click(collaborativeDesignOption);
        click(designCommunicationOption);
    }

    public void clickGetStarted() {
        click(getStartedButton);
    }

    public void completeSignUp(String name, String email, String password) {
        clickSignUpHere();
        enterSignUpDetails(name, email, password);
        clickSignUpButton();
        selectIndustryAndRole();
        selectAllOptions();
        clickGetStarted();
    }
} 