package com.snaptrude.tests;

import com.snaptrude.pages.LoginPage;
import com.snaptrude.utils.TestUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class SnaptrudeTest extends BaseTest {

    @Test(priority = 1)
    public void verifySecureConnection() {
        TestUtils.logTestStep("Verifying secure connection");
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("https://"), "The site is not HTTP secure");
        TestUtils.logTestInfo("The Site is HTTPS secure");
    }

    @Test(priority = 2)
    public void testSignUp() {
        TestUtils.logTestStep("Testing sign up functionality");
        LoginPage loginPage = new LoginPage(driver);
        
        long startTime = System.currentTimeMillis();
        loginPage.completeSignUp("Test QA", "testQA@TestQAmail.com", "testpassword");
        long endTime = System.currentTimeMillis();
        
        TestUtils.logTestInfo("Time taken for sign up: " + (endTime - startTime) + " milliseconds");
    }

    // Add more test methods for other functionalities
} 