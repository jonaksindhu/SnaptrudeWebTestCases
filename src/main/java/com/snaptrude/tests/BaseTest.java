package com.snaptrude.tests;

import com.snaptrude.config.ConfigManager;
import com.snaptrude.utils.TestUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = TestUtils.initializeDriver();
        driver.get(ConfigManager.getBaseUrl());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
} 