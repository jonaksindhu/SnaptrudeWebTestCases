package com.snaptrude.tests;

import com.snaptrude.pages.LoginPage;
import com.snaptrude.pages.SignUpPage;
import com.snaptrude.pages.HomePage;
import com.snaptrude.pages.ProfilePage;
import com.snaptrude.pages.DrawPage;
import com.snaptrude.pages.StaticSourcePage;
import com.snaptrude.utils.TestUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

public class SnaptrudeTest extends BaseTest {
    public static WebDriver driver;

    @BeforeTest
    public void loadChromeBroswer(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver 2");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // TC 1: Verify that the site loads and is HTTPS secure
    @Test(priority = 1, description = "TC 1: Verify that the site loads and is HTTPS secure")
    public void loadurl() {
        driver.get("https://app.snaptrude.com");
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("https://"), "The site is not HTTP secure");
        System.out.println("The Site is HTTPS secure");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    // TC 2: Test the sign-up functionality and measure page load times
    @Test(priority = 2, description = "TC 2: Test the sign-up functionality and measure page load times")
    public void signup() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSignUpHere();
        loginPage.enterSignUpDetails("Test QA", "testQA@testemail.com", "testpassword");
        loginPage.clickSignUpButton();
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.selectOtherOption();
        signUpPage.selectDesignerOption();
        signUpPage.selectQuickModellingOption();
        signUpPage.selectRemoteTeamsOption();
        signUpPage.selectClientCommunicationOption();
        signUpPage.clickGetStartedButton();
        // Assert: Check if redirected to home/dashboard (URL or element)
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Sign up did not redirect to dashboard");
    }

    // TC 3: Upload a profile picture using the profile settings
    @Test(priority= 3, description = "TC 3: Upload a profile picture using the profile settings")
    public void Uploadprofilepic() throws InterruptedException, AWTException {
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.goToAccount();
        profilePage.uploadProfilePicture("/Users/jonaksindhudas/Desktop/Screenshots/Screenshot 2022-03-10 at 12.59.02 PM.png");
        // Assert: Check if profile picture element is displayed (example selector)
        // Replace with actual selector for profile picture if available
        // Assert.assertTrue(driver.findElement(By.cssSelector("img.profile-picture")).isDisplayed(), "Profile picture not uploaded");
    }

    // TC 4: Create a new project and select measurement units
    @Test(priority = 4, description = "TC 4: Create a new project and select measurement units")
    public void createaproject() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickCreateProject();
        homePage.enterProjectName("QA Interview");
        homePage.selectUnits("Inches");
        homePage.clickCreate();
        // Assert: Check if project is created (example: project name appears)
        // Replace with actual selector for project name if available
        // Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'QA Interview')]")).isDisplayed(), "Project not created");
    }

    // TC 5: Draw shapes (triangle and quadrilateral) on the canvas using the draw tool
    @Test(priority = 5, description = "TC 5: Draw shapes (triangle and quadrilateral) on the canvas using the draw tool")
    public void drawImage() throws InterruptedException, AWTException {
        DrawPage drawPage = new DrawPage(driver);
        drawPage.handleTutorialPopup();
        drawPage.selectDrawTool();
        drawPage.drawTriangleAndQuadrilateral();
        drawPage.goToDashboard();
        // Assert: Check if returned to dashboard (URL or element)
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Did not return to dashboard after drawing");
    }

    // TC 6: Calculate the number of static sources in the canvas
    @Test(priority = 6, description = "TC 6: Calculate the number of static sources in the canvas")
    public void calculateStaticSourceInCanvas() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickCreateProject();
        homePage.enterProjectName("Check Sources");
        homePage.selectUnits("Inches");
        homePage.clickCreate();
        StaticSourcePage staticSourcePage = new StaticSourcePage(driver);
        int staticSourceCount = staticSourcePage.countStaticSources();
        System.out.println("The Number of Static Sources in the draw page is : " + staticSourceCount);
        // Assert: There should be at least one static source
        Assert.assertTrue(staticSourceCount > 0, "No static sources found in the canvas");
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
} 