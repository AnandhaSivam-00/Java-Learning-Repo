package com.revature;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockserver.client.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

    private WebDriver driver;
    @SuppressWarnings("unused")
    private WebDriverWait wait;
    private ClientAndServer mockServer;
    private MockServerClient mockServerClient;

    @Before
    public void setUp() throws InterruptedException {
       
        WebDriverManager.chromedriver().setup();

        File file = new File("src/main/resources/public/frontend/login/login-page.html");
        String path = "file://" + file.getAbsolutePath();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");

        // Initialize ChromeDriver and MockServer
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        mockServer = ClientAndServer.startClientAndServer(8081);
        mockServerClient = new MockServerClient("localhost", 8081);

        // CORS options request setup
        mockServerClient
        .when(HttpRequest.request().withMethod("OPTIONS").withPath(".*"))
        .respond(HttpResponse.response()
            .withHeader("Access-Control-Allow-Origin", "*")
            .withHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS")
            .withHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Origin, Access-Control-Allow-Methods, Access-Control-Allow-Headers, Origin, Accept, X-Requested-With"));
    

        // Load the login page
        driver.get(path);

        Thread.sleep(1000);
    }

    @Test
    public void correctLoginTest() throws InterruptedException {
        // Locate elements using the correct IDs from the HTML
        WebElement nameInput = driver.findElement(By.id("login-input"));
        WebElement passwordInput = driver.findElement(By.id("password-input"));
        WebElement submitButton = driver.findElement(By.id("login-button"));
        
        // Mocking the login response
        mockServerClient
            .when(HttpRequest.request().withMethod("POST").withPath("/login"))
            .respond(HttpResponse.response()
                .withHeader("Content-Type", "application/json")
                .withHeader("Access-Control-Allow-Origin", "*")
                .withBody("{\"auth-token\":\"12345\"}"));
    
        nameInput.sendKeys("correct");
        passwordInput.sendKeys("correct");
        submitButton.click();
        Thread.sleep(1000);
    
        // Dismiss any unexpected alert and print the alert text
        try {
            String alertText = driver.switchTo().alert().getText();
            System.out.println("Alert Text: " + alertText);  // Print alert text for debugging
            driver.switchTo().alert().accept(); // Dismiss the alert
        } catch (org.openqa.selenium.NoAlertPresentException e) {
            System.out.println("No alert present after clicking the login button.");
        }
    
        // Assertion to verify redirection to the recipe page
        assertTrue("URL should contain 'recipe-page.html' after successful login.", driver.getCurrentUrl().contains("recipe-page.html"));
    }
    
    

    @Test
    public void incorrectLoginTest() throws InterruptedException {
        // Locate elements using the correct IDs from the HTML
        WebElement nameInput = driver.findElement(By.id("login-input"));
        WebElement passwordInput = driver.findElement(By.id("password-input"));
        WebElement submitButton = driver.findElement(By.id("login-button"));
        
        // Mocking the unauthorized response
        mockServerClient
            .when(HttpRequest.request().withMethod("POST").withPath("/login"))
            .respond(HttpResponse.response()
                .withStatusCode(401)
                .withHeader("Content-Type", "application/json")
                .withHeader("Access-Control-Allow-Origin", "*"));

        nameInput.sendKeys("incorrect");
        passwordInput.sendKeys("incorrect");
        submitButton.click();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();
        
        Thread.sleep(1000);
        assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        if (mockServer != null) {
            mockServer.stop();
        }
        if (mockServerClient != null) {
            mockServerClient.close(); // Ensure `MockServerClient` is closed to prevent resource leaks
        }
    }
}
