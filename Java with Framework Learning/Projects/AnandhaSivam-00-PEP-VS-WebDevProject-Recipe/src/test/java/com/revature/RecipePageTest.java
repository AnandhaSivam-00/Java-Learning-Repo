package com.revature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This class contains Selenium tests written in Java. Selenium is a tool used for BDD, or behavior-driven-development, for frontends. That means that the tests verify that the site exhbits expected
 * behavior behavior, such as verifying that some behavior occurs on the site when a button is clicked. In this case, Selenium will just be used to verify that certain tags exist on the site.
 */
public class RecipePageTest{
    
    private WebDriver webDriver;
    
    @SuppressWarnings("unused")
    private WebDriverWait wait;
    /**
     * Set up the chrome driver for running bdd selenium tests in the browser.
     * @throws InterruptedException 
     */
    @Before
    public void setUp() throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        File file = new File("src/main/resources/public/frontend/recipe/recipe-page.html");
        String path = "file://" + file.getAbsolutePath();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        webDriver = new ChromeDriver(options);
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        webDriver.get(path);
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);

        Thread.sleep(1000);
    }
    /**
     * The page should contain a h1 header element containing the pattern "recipes".
     */
    @Test
    public void testH1RecipesExists() {
        List<WebElement> elements = webDriver.findElements(By.tagName("h1"));
        boolean flag = false;
        for (WebElement element : elements) {
            if (element.getText().toLowerCase().contains("recipes")) {
                flag = true;
                break;
            }
        }
        assertTrue(flag);
    }
    
    /**
     * The page should contain a ul unordered list element with the id "recipelist".
     */
    @Test
    public void testUlExists() {
        WebElement element = webDriver.findElement(By.id("recipe-list"));
        assertEquals("ul", element.getTagName());
    }
    /**
     * The page should contain an h2 element containing text matching the pattern "add a recipe".
     */
     @Test
     public void testH2AddRecipeExists() {
         List<WebElement> elements = webDriver.findElements(By.tagName("h2"));
         boolean flag = false;
         for(WebElement e : elements){
            if(e.getText().toLowerCase().contains("add a recipe")){
                flag = true;
            }
         }
         assertTrue(flag);
     }
     /**
      * The page should contain an element "add-recipe-name-input" that is of type input.
      */
     @Test
     public void testAddRecipeNameInputExists() {
         WebElement element = webDriver.findElement(By.id("add-recipe-name-input"));
         assertEquals("input", element.getTagName());
     }
     /**
      * The page should contain an element "add-recipe-instructions-input" that is of type textarea.
      */
     @Test
     public void testAddRecipeInstructionsInputExists() {
         WebElement element = webDriver.findElement(By.id("add-recipe-instructions-input"));
         assertEquals("textarea", element.getTagName());
     }
     /**
      * The page should contain an element "add-recipe-submit-button" that is of type button.
      */
     @Test
     public void testAddRecipeSubmitButtonExists() {
         WebElement element = webDriver.findElement(By.id("add-recipe-submit-input"));
         assertEquals("button", element.getTagName());
     }
     /**
      * The add-recipe-submit-button should have some text inside.
      */
     @Test
     public void testAddRecipeSubmitButtonTextNotEmpty() {
         WebElement element = webDriver.findElement(By.id("add-recipe-submit-input"));
         assertTrue(element.getText().length()>=1);
     }
     /**
     * The page should contain an h2 element containing text matching the pattern "update a recipe".
     */
     @Test
     public void testH2UpdateRecipeExists() {
         List<WebElement> elements = webDriver.findElements(By.tagName("h2"));
         boolean flag = false;
         for(WebElement e : elements){
            if(e.getText().toLowerCase().contains("update a recipe")){
                flag = true;
            }
         }
         assertTrue(flag);
     }
     /**
      * The page should contain an element "update-recipe-name-input" that is of type input.
      */
     @Test
     public void testUpdateRecipeNameInputExists() {
         WebElement element = webDriver.findElement(By.id("update-recipe-name-input"));
         assertEquals("input", element.getTagName());
     }
     /**
      * The page should contain an element "update-recipe-instructions-input" that is of type textarea.
      */
     @Test
     public void testUpdateRecipeInstructionsInputExists() {
         WebElement element = webDriver.findElement(By.id("update-recipe-instructions-input"));
         assertEquals("textarea", element.getTagName());
     }
     /**
      * The page should contain an element "update-recipe-submit-button" that is of type button.
      */
     @Test
     public void testUpdateRecipeSubmitButtonExists() {
         WebElement element = webDriver.findElement(By.id("update-recipe-submit-input"));
         assertEquals("button", element.getTagName());
     }
     /**
      * The update-recipe-submit-button should have some text inside.
      */
     @Test
     public void testUpdateRecipeSubmitButtonTextNotEmpty() {
         WebElement element = webDriver.findElement(By.id("update-recipe-submit-input"));
         assertTrue(element.getText().length()>=1);
     }
     /**
     * The page should contain an h2 element containing text matching the pattern "delete a recipe".
     */
     @Test
     public void testH2DeleteRecipeExists() {
         List<WebElement> elements = webDriver.findElements(By.tagName("h2"));
         boolean flag = false;
         for(WebElement e : elements){
            if(e.getText().toLowerCase().contains("delete a recipe")){
                flag = true;
            }
         }
         assertTrue(flag);
     }
     /**
      * The page should contain an element "delete-recipe-name-input" that is of type input.
      */
     @Test
     public void testDeleteRecipeNameInputExists() {
         WebElement element = webDriver.findElement(By.id("delete-recipe-name-input"));
         assertEquals("input", element.getTagName());
     }
     /**
      * The page should contain an element "delete-recipe-submit-button" that is of type button.
      */
     @Test
     public void testDeleteRecipeSubmitButtonExists() {
         WebElement element = webDriver.findElement(By.id("delete-recipe-submit-input"));
         assertEquals("button", element.getTagName());
     }
     /**
      * The delete-recipe-submit-button should have some text inside.
      */
     @Test
     public void testDeleteRecipeSubmitButtonTextNotEmpty() {
         WebElement element = webDriver.findElement(By.id("delete-recipe-submit-input"));
         assertTrue(element.getText().length()>=1);
     }

     @Test
    public void searchBarExistsTest(){
        WebElement searchInput = webDriver.findElement(By.id("search-input"));
        WebElement searchButton = webDriver.findElement(By.id("search-button"));
        Assert.assertTrue(searchInput.getTagName().equals("input"));
        Assert.assertTrue(searchButton.getTagName().equals("button"));
    }


     /**
     * close down hanging browsers spawned by the chromedriver
     */
    @After
    public void tearDown() {
        // Close the browser
        webDriver.quit();
    }
}

