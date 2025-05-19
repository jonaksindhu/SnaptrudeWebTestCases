package com.snaptrude.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import com.snaptrude.config.ConfigManager;
import java.time.Duration;

public class TestUtils {
    
    public static WebDriver initializeDriver() {
        WebDriver driver;
        String browser = ConfigManager.getBrowser();
        
        switch (browser.toLowerCase()) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                driver = new ChromeDriver();
        }
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigManager.getImplicitWait()));
        return driver;
    }

    public static void takeScreenshot(WebDriver driver, String testName) {
        // TODO: Implement screenshot functionality
    }

    public static void logTestStep(String step) {
        System.out.println("[TEST STEP] " + step);
    }

    public static void logTestInfo(String info) {
        System.out.println("[TEST INFO] " + info);
    }

    public static void logTestError(String error) {
        System.out.println("[TEST ERROR] " + error);
    }
} 