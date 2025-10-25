package com.revature;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.time.Duration;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import io.javalin.Javalin;



public class AdminTest {
    
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

    private static void performLogout() {
        // perform logout functionality
        WebElement logoutButton = driver.findElement(By.id("logout-button"));
        logoutButton.click();
    }

    /**
     * Admin link should not exist when the logged-in user is not an admin.
     * @throws InterruptedException
     */
    @Test
    public void noAdminNoLinkTest() throws InterruptedException{
        // go to relevant HTML page
        File loginFile = new File("src/main/resources/public/frontend/login/login-page.html");
        String loginPath = "file:///" + loginFile.getAbsolutePath().replace("\\", "/");
        driver.get(loginPath);


        try {
    WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(2));
    Alert alert = shortWait.until(ExpectedConditions.alertIsPresent());
    System.out.println("Dismissing leftover alert: " + alert.getText());
    alert.dismiss();
} catch (Exception ignored) {
    // No alert present — move on
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
    
        // check that role value is 'false' in session storage
        assertTrue((js.executeScript(String.format(
            "return window.sessionStorage.getItem('%s');", "is-admin")).equals("false")));
        
        WebElement adminLink = driver.findElement(By.id("admin-link"));
        //verify that there are no admin links because the user is not an admin.
        Assert.assertFalse(adminLink.isDisplayed());

        performLogout();
    }

    /**
     * Admin link should exist when the logged-in user is an admin.
     * @throws InterruptedException
     */
    @Test
    public void adminLinkTest() throws InterruptedException{
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
    
        // check that role value is 'false' in session storage
        assertTrue((js.executeScript(String.format(
            "return window.sessionStorage.getItem('%s');", "is-admin")).equals("true")));
        
        WebElement adminLink = driver.findElement(By.id("admin-link"));
        //verify that there are no admin links because the user is not an admin.
        Assert.assertTrue(adminLink.isDisplayed());

        performLogout();
    }

    /**
     * On startup, the site should pull the currently available ingredients from the API.
     */
    @Test
    public void displayIngredientsOnInitTest() throws InterruptedException{
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
    
        // click on link to go to ingredients page
        Thread.sleep(1000);
        WebElement adminLink = driver.findElement(By.id("admin-link"));
        adminLink.click();

        Thread.sleep(1000);
        WebElement list = driver.findElement(By.id("ingredient-list"));
        String innerString = list.getAttribute("innerHTML");
        Assert.assertTrue(innerString.contains("carrot"));
        Assert.assertTrue(innerString.contains("potato"));
        Assert.assertTrue(innerString.contains("tomato"));
        Assert.assertTrue(innerString.contains("lemon"));
        Assert.assertTrue(innerString.contains("rice"));
        Assert.assertTrue(innerString.contains("stone"));

        WebElement backLink = driver.findElement(By.id("back-link"));
        backLink.click();
        Thread.sleep(1000);

        performLogout();
    }

    /**
     * The site should send a request to persist the ingredient after the recipe is submitted.
     * @throws InterruptedException
     */
    @Test
    public void addIngredientPostTest() throws InterruptedException{
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
    
        // click on link to go to ingredients page
        Thread.sleep(1000);
        WebElement adminLink = driver.findElement(By.id("admin-link"));
        adminLink.click();

        Thread.sleep(1000);
        
        WebElement nameInput = driver.findElement(By.id("add-ingredient-name-input"));
        WebElement ingredientSubmitButton = driver.findElement(By.id("add-ingredient-submit-button"));
        nameInput.sendKeys("salt");
        ingredientSubmitButton.click();
        Thread.sleep(1000);

        // Wait for the recipe list to update
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ingredient-list")));
        WebElement ingredientList = driver.findElement(By.id("ingredient-list"));
        String innerHTML = ingredientList.getAttribute("innerHTML");

        // Assert the result
        assertTrue("Expected ingredient to be added.", innerHTML.contains("salt"));

        WebElement backLink = driver.findElement(By.id("back-link"));
        backLink.click();
        Thread.sleep(1000);

        performLogout();
    }

    /**
     * The site should send a request to delete the ingredient when the delete button is clicked.
     * @throws InterruptedException
     */
    @Test
    public void deleteIngredientDeleteTest() throws InterruptedException{
        // go to relevant HTML page
        File loginFile = new File("src/main/resources/public/frontend/login/login-page.html");
        String loginPath = "file:///" + loginFile.getAbsolutePath().replace("\\", "/");
        driver.get(loginPath);

        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(2));
            Alert alert = shortWait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Dismissing leftover alert: " + alert.getText());
            alert.dismiss();
        } catch (Exception ignored) {
            // No alert present — move on
        }

        // perform login functionality
        WebElement usernameInput = driver.findElement(By.id("login-input"));
        WebElement passwordInput = driver.findElement(By.id("password-input"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        usernameInput.sendKeys("ChefTrevin");
        passwordInput.sendKeys("trevature");
        loginButton.click();

        // ensure we navigate to appropriate webpage
        wait.until(ExpectedConditions.urlContains("recipe-page")); // Wait for navigation to the recipe page
    
        // click on link to go to ingredients page
        Thread.sleep(1000);
        WebElement adminLink = driver.findElement(By.id("admin-link"));
        adminLink.click();

        Thread.sleep(1000);
        
        WebElement nameInput = driver.findElement(By.id("delete-ingredient-name-input"));
        WebElement ingredientSubmitButton = driver.findElement(By.id("delete-ingredient-submit-button"));
        nameInput.sendKeys("tomato");
        ingredientSubmitButton.click();
        Thread.sleep(1000);
        
        // Wait for the recipe list to update
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ingredient-list")));
        WebElement ingredientList = driver.findElement(By.id("ingredient-list"));
        String innerHTML = ingredientList.getAttribute("innerHTML");

        // Assert the result
        assertTrue("Expected ingredient to NOT be added.", !innerHTML.contains("tomato"));

        WebElement backLink = driver.findElement(By.id("back-link"));
        backLink.click();
        Thread.sleep(1000);

        performLogout();
    }

}
