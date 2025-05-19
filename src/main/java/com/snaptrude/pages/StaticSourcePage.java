package com.snaptrude.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class StaticSourcePage extends BasePage {
    private By staticSourceElements = By.xpath("//*[contains(@src,'/static/')]");

    public StaticSourcePage(WebDriver driver) {
        super(driver);
    }

    public int countStaticSources() {
        List<WebElement> elements = driver.findElements(staticSourceElements);
        return elements.size();
    }
} 