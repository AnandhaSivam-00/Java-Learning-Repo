
import java.io.File;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {

    private WebDriver webDriver;
    /**
     * set up selenium web driver.
     * NOTE: the selenium web driver might not be properly configured for your environment.
     * If you get an issue involving being unable to run the exe, a mismatched chromedriver version, or any sort of
     * null driver or inability for the Selenium webdriver to start, disregard any failed tests and continue to test
     * the lab manually via the browser.
     */
    @Before
    public void setUp() {
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");//linux_64

        // Get file
        File file = new File("src/main/index.html");
        String path = "file://" + file.getAbsolutePath();

        // Create a new ChromeDriver instance
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        webDriver = new ChromeDriver(options);

        // Open the HTML file
        webDriver.get(path);
    }
    /**
     * ensure that when the button is clicked, the success line is displayed on the page as part of the catch block.
     */
    @Test
    public void testClickErrorButton() {

        // Find the button element and click it
        WebElement button = webDriver.findElement(By.id("errorButton"));
        button.click();

        // Wait for the monitor element to update and retrieve its text
        WebElement monitor = webDriver.findElement(By.id("monitor"));
        String monitorText = monitor.getText();

        // Verify the expected text after the error handling
        String expectedText = "This text should be displayed only in the event of a an error, as it should be placed within " +
        "a try block. If you did intend to cause an error and see this text, you have succeeded.";

        Assert.assertEquals(expectedText, monitorText);
    }
    @Test
    public void testClickNoErrorButton() {

        // Find the button element and click it
        WebElement button = webDriver.findElement(By.id("noErrorButton"));
        button.click();

        // Wait for the monitor element to update and retrieve its text
        WebElement monitor = webDriver.findElement(By.id("monitor"));
        String monitorText = monitor.getText();

        // Verify the expected text after the error handling
        String expectedText = "The button was clicked. This text should only be displayed on the site if an exception is "+
        "never thrown, as the second message should only replace this one when the try block executes.";

        Assert.assertEquals(expectedText, monitorText);
    }
    @After
    public void tearDown() {
        // Close the browser
        webDriver.quit();
    }
}
