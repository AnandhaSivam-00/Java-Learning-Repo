package com.revature;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.time.Duration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import io.javalin.Javalin;

public class AuthenticationTest {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static Javalin app;
    private static JavascriptExecutor js;

    @BeforeClass
    public static void setUp() throws InterruptedException {
        // Start the backend programmatically
        int port = 8081;
        app = Main.main(new String[] { String.valueOf(port) });

        WebDriverManager.chromedriver().setup();
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        js = (JavascriptExecutor) driver;

        Thread.sleep(1000);
    }

    @AfterClass
    public static void tearDown() {
        // Stop the backend and clean up
        if (app != null) {
            app.stop();
        }
        if (driver != null) {
            driver.quit();
        }
    }

    @After
    public void tearDownBetween() {
        performLogout();
    }
    
    @Test
    public void authTest1() {
        // go to relevant HTML page
        File loginFile = new File("src/main/resources/public/frontend/login/login-page.html");
        String loginPath = "file:///" + loginFile.getAbsolutePath().replace("\\", "/");
        driver.get(loginPath);

        // perform login functionality
        WebElement usernameInput = driver.findElement(By.id("login-input"));
        WebElement passwordInput = driver.findElement(By.id("password-input"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        usernameInput.sendKeys("ChefTrevin");
        passwordInput.sendKeys("trevature");
        loginButton.click();

        // ensure we navigate to appropriate webpage
        wait.until(ExpectedConditions.urlContains("recipe-page")); // Wait for navigation to the recipe page
    
        // check storage contains a token
        assertTrue(!(js.executeScript(String.format(
            "return window.sessionStorage.getItem('%s');", "auth-token")) == null));
        
        // ensure admin user can perform admin operation

        // delete a recipe (admin only)
        WebElement nameInput = driver.findElement(By.id("delete-recipe-name-input"));
        WebElement deleteButton = driver.findElement(By.id("delete-recipe-submit-input"));
        nameInput.sendKeys("carrot soup");
        deleteButton.click();

        // assertions
        boolean alert = isAlertPresent(driver);

        assertEquals(false, alert);
    }

    @Test
    public void authTest2() {
        // go to relevant HTML page
        File loginFile = new File("src/main/resources/public/frontend/login/login-page.html");
        String loginPath = "file:///" + loginFile.getAbsolutePath().replace("\\", "/");
        driver.get(loginPath);

        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(2));
            Alert alert = shortWait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert present before login: " + alert.getText());
            alert.dismiss();  // Clean it up
            // Do NOT fail, just continue
        } catch (TimeoutException ignored) {
            System.out.println("No alert before login, proceeding...");
        }
        
        // perform login functionality
        WebElement usernameInput = driver.findElement(By.id("login-input"));
        WebElement passwordInput = driver.findElement(By.id("password-input"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        usernameInput.sendKeys("JoeCool");
        passwordInput.sendKeys("redbarron");
        loginButton.click();

        // ensure we navigate to appropriate webpage
        wait.until(ExpectedConditions.urlContains("recipe-page")); // Wait for navigation to the recipe page
       
        // check storage contains a token
        assertTrue(!(js.executeScript(String.format(
            "return window.sessionStorage.getItem('%s');", "auth-token")) == null));
        
        // ensure non-admin user cannot perform admin operation

        // delete a recipe (admin only)
        WebElement nameInput = driver.findElement(By.id("delete-recipe-name-input"));
        WebElement deleteButton = driver.findElement(By.id("delete-recipe-submit-input"));
        nameInput.sendKeys("stone soup");
        deleteButton.click();

        // assertions
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        boolean isAlertPresent = isAlertPresent(driver);
        
        alert.dismiss();
        assertEquals(true, isAlertPresent);
    }

    // credit to https://www.geeksforgeeks.org/how-to-check-if-any-alert-exists-using-selenium-with-java/
    public static boolean isAlertPresent(WebDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private void performLogout() {
        try {
            WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout-button")));
            logoutButton.click();
        } catch (Exception e) {
            System.out.println("Logout skipped or failed: " + e.getMessage());
        }
    }
}
