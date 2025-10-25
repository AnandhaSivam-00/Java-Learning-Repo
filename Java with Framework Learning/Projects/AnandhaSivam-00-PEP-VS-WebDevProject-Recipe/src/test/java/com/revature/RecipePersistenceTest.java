package com.revature;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.time.Duration;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import io.javalin.Javalin;

public class RecipePersistenceTest {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static Javalin app;

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

        Thread.sleep(1000);

        performLogin();

    }

    @AfterClass
    public static void tearDown() {
        performLogout();

        // Stop the backend and clean up
        if (app != null) {
            app.stop();
        }
        if (driver != null) {
            driver.quit();
        }
    }

    private void handleUnexpectedAlerts(WebDriver driver) {
        try {
            WebDriverWait alertWait = new WebDriverWait(driver, Duration.ofSeconds(3));
            Alert alert = alertWait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Unexpected Alert Text: " + alert.getText());
            alert.dismiss();
        } catch (TimeoutException e) {
            System.out.println("No unexpected alerts.");
        }
    }

    private void handleUnexpectedAlerts() {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert detected: " + alert.getText());
            alert.dismiss();
        } catch (TimeoutException e) {
            System.out.println("No unexpected alerts.");
        }
    }

    private static void performLogin() {
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

    }

    private static void performLogout() {
        // perform logout functionality
        WebElement logoutButton = driver.findElement(By.id("logout-button"));
        logoutButton.click();
    }

    @Test
    public void addRecipePostTest() {
        // Add a recipe
        WebElement nameInput = driver.findElement(By.id("add-recipe-name-input"));
        WebElement instructionsInput = driver.findElement(By.id("add-recipe-instructions-input"));
        WebElement addButton = driver.findElement(By.id("add-recipe-submit-input"));
        nameInput.sendKeys("Beef Stroganoff");
        instructionsInput.sendKeys("Mix beef with sauce and serve over pasta");
        addButton.click();

        // Wait for the recipe list to update
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("recipe-list")));
        WebElement recipeList = driver.findElement(By.id("recipe-list"));
        String innerHTML = recipeList.getAttribute("innerHTML");

        // Assert the result
        assertTrue("Expected recipe to be added.", innerHTML.contains("Beef Stroganoff"));

    }

    @Test
    public void displayRecipesOnInitTest() throws InterruptedException {

        // check for any issues
        handleUnexpectedAlerts(driver);

        // refresh the page to trigger backend API call
        driver.navigate().refresh();

        // gather recipe list information
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("recipe-list")));
        WebElement recipeList = driver.findElement(By.id("recipe-list"));
        String innerHTML = recipeList.getAttribute("innerHTML");

        // make assertions: recipe list should contain expected recipes
        assertTrue("Expected recipes to be displayed.", innerHTML.contains("carrot soup"));
        assertTrue("Expected recipes to be displayed.", innerHTML.contains("potato soup"));
        assertTrue("Expected recipes to be displayed.", innerHTML.contains("tomato soup"));
        assertTrue("Expected recipes to be displayed.", innerHTML.contains("lemon rice soup"));
        assertTrue("Expected recipes to be displayed.", innerHTML.contains("stone soup"));

    }

    @Test
    public void updateRecipePutTest() {

        // perform update
        WebElement nameInput = driver.findElement(By.id("update-recipe-name-input"));
        WebElement instructionsInput = driver.findElement(By.id("update-recipe-instructions-input"));
        WebElement updateButton = driver.findElement(By.id("update-recipe-submit-input"));
        nameInput.sendKeys("carrot soup");
        instructionsInput.sendKeys("Updated instructions for carrot soup");
        updateButton.click();
        handleUnexpectedAlerts();

        // gather recipe list information
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.id("recipe-list"),
                "Updated instructions for carrot soup"));
        WebElement recipeList = driver.findElement(By.id("recipe-list"));
        String innerHTML = recipeList.getAttribute("innerHTML");

        // make assertion: recipe should be updated
        assertTrue("Expected recipe to be updated.", innerHTML.contains("Updated instructions for carrot soup"));

    }

    @Test
    public void deleteRecipeDeleteTest() throws InterruptedException {
        // Proceed with deletion
        WebElement nameInput = driver.findElement(By.id("delete-recipe-name-input"));
        WebElement deleteButton = driver.findElement(By.id("delete-recipe-submit-input"));
        nameInput.sendKeys("stone soup");
        deleteButton.click();

        // check recipe list
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("recipe-list")));
        WebElement recipeList = driver.findElement(By.id("recipe-list"));
        String innerHTML = recipeList.getAttribute("innerHTML");

        // make assertion: deleted recipe should not be in list
        assertTrue("Expected recipe to be deleted.", !innerHTML.contains("stone soup"));

    }

    @Test
    public void searchFiltersTest() throws InterruptedException {

        WebElement searchInput = driver.findElement(By.id("search-input"));
        WebElement searchButton = driver.findElement(By.id("search-button"));
        WebElement recipeList = driver.findElement(By.id("recipe-list"));

        String searchTerm = "to soup";
        searchInput.sendKeys(searchTerm);
        searchButton.click();

        Thread.sleep(1000);
        // check recipe list
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("recipe-list")));
        String innerHTML = recipeList.getAttribute("innerHTML");

        assertTrue("Expected potato soup recipe to be in list.", innerHTML.contains("potato soup"));
        assertTrue("Expected tomato soup recipe to be in list.", innerHTML.contains("tomato soup"));
        assertTrue("Expected stone soup recipe to NOT be in list.", !innerHTML.contains("stone soup"));
        assertTrue("Expected carrot soup recipe to NOT be in list.", !innerHTML.contains("carrot soup"));
        assertTrue("Expected lemon rice soup recipe to NOT be in list.", !innerHTML.contains("lemon rice soup"));

    }

}
