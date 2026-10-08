package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginSucceedsWithValidCredentialsTest {

    private WebDriver driver;
    private WebDriverWait wait;

    private static final By EMAIL_INPUT = By.name("email");
    private static final By PASSWORD_INPUT = By.name("password");
    private static final By LOGIN_BUTTON = By.xpath("//button[normalize-space()='Login']");
    private static final By DASHBOARD_MARKER = By.xpath("//*[contains(normalize-space(),'dashboard') or contains(normalize-space(),'Dashboard')]");

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void manualUHGpkcVu768LqEnKIqasoLoginSucceedsWithValidCredentials() {
        // step 1
        driver.get(System.getProperty("baseUrl", "https://app.example.com/login"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "Step 1: Login page is shown");

        // step 2
        String username = System.getProperty("login.username", "user@example.com");
        String password = System.getProperty("login.password", "secret123");
        wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL_INPUT)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_INPUT)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON)).click();
        WebElement dashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_MARKER));
        Assert.assertTrue(dashboard.isDisplayed(), "Step 2: User lands on the dashboard");
    }
}