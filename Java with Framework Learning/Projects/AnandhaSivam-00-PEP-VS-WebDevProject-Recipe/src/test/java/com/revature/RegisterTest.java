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

public class RegisterTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private ClientAndServer mockServer;
    private MockServerClient mockServerClient;

    @Before
    public void setUp() throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        File file = new File("src/main/resources/public/frontend/register/register-page.html");
        String path = "file://" + file.getAbsolutePath();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");

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
                        .withHeader("Access-Control-Allow-Headers",
                                "Content-Type, Access-Control-Allow-Origin, Access-Control-Allow-Methods, Access-Control-Allow-Headers, Origin, Accept, X-Requested-With"));

        driver.get(path);

        Thread.sleep(1000);
    }

    /**
     * Test for successful registration, which should redirect to the login page.
     */
    @Test
    public void validRegistrationTest() throws InterruptedException {
        WebElement nameInput = driver.findElement(By.id("username-input"));
        WebElement emailInput = driver.findElement(By.id("email-input"));
        WebElement passwordInput = driver.findElement(By.id("password-input"));
        WebElement passwordRepeatInput = driver.findElement(By.id("repeat-password-input"));
        WebElement submitButton = driver.findElement(By.id("register-button"));

        // Mock successful registration response
        mockServerClient
                .when(HttpRequest.request().withMethod("POST").withPath("/register"))
                .respond(HttpResponse.response()
                        .withStatusCode(201)
                        .withHeader("Content-Type", "application/json")
                        .withHeader("Access-Control-Allow-Origin", "*"));

        nameInput.sendKeys("correct");
        emailInput.sendKeys("correct@example.com");
        passwordInput.sendKeys("correct");
        passwordRepeatInput.sendKeys("correct");
        submitButton.click();

        Thread.sleep(1000);
        assertTrue(driver.getCurrentUrl().contains("login"));
    }
    /**
     * Test for failed registration due to duplicate account, which should display
     * an alert without redirecting.
     */
    @Test
    public void failedRegistrationTest() throws InterruptedException {
        WebElement nameInput = driver.findElement(By.id("username-input"));
        WebElement passwordInput = driver.findElement(By.id("password-input"));
        WebElement passwordRepeatInput = driver.findElement(By.id("repeat-password-input"));
        WebElement submitButton = driver.findElement(By.id("register-button"));

        // Mock duplicate account response
        mockServerClient
                .when(HttpRequest.request().withMethod("POST").withPath("/register"))
                .respond(HttpResponse.response()
                        .withStatusCode(409)
                        .withHeader("Content-Type", "application/json")
                        .withHeader("Access-Control-Allow-Origin", "*"));

        nameInput.sendKeys("duplicate");
        passwordInput.sendKeys("testpass");
        passwordRepeatInput.sendKeys("testpass");
        submitButton.click();

        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();
        Thread.sleep(1000);

        assertTrue(driver.getCurrentUrl().contains("register"));
    }

    /**
     * Test for invalid registration due to mismatched passwords, which should
     * trigger an alert without sending a request.
     */
    @Test
    public void invalidRegistrationTest() throws InterruptedException {
        WebElement nameInput = driver.findElement(By.id("username-input"));
        WebElement passwordInput = driver.findElement(By.id("password-input"));
        WebElement passwordRepeatInput = driver.findElement(By.id("repeat-password-input"));
        WebElement submitButton = driver.findElement(By.id("register-button"));

        nameInput.sendKeys("testuser");
        passwordInput.sendKeys("password123");
        passwordRepeatInput.sendKeys("mismatch");
        submitButton.click();

        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();
        Thread.sleep(1000);

        assertTrue(driver.getCurrentUrl().contains("register"));
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
            mockServerClient.close();
        }
    }
}


