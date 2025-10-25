import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {

    private WebDriver webDriver;

    @Before
    public void setUp() {
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");//linux_64

        // Get file
        File file = new File("src/main/HelloUser.html");
        String path = "file://" + file.getAbsolutePath();

        // Create a new ChromeDriver instance
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        webDriver = new ChromeDriver(options);

        // Open the HTML file
        webDriver.get(path);




    }
    @Test
    public void testNoName() {
        // Find the submit button and click it
        WebElement submitButton = webDriver.findElement(By.id("submit"));
        submitButton.click();

        // Find the text element and verify the greeting
        WebElement displayElement = webDriver.findElement(By.id("text"));
        assertEquals("Hello,", displayElement.getText());
    }

    @Test
    public void testShortName() {
        // fill in the input box with a name:
        WebElement inputBox = webDriver.findElement(By.id("input"));
        inputBox.sendKeys("Rick");

        // Find the submit button and click it
        WebElement submitButton = webDriver.findElement(By.id("submit"));
        submitButton.click();

        // Find the text element and verify the greeting
        WebElement displayElement = webDriver.findElement(By.id("text"));
        assertEquals("Hello, Rick", displayElement.getText());
    }

    @Test
    public void testLongName() {
        // fill in the input box with a name:
        WebElement inputBox = webDriver.findElement(By.id("input"));
        inputBox.sendKeys("Alexander Sebastian Montgomery Fitzgerald-Jenkins");

        // Find the submit button and click it
        WebElement submitButton = webDriver.findElement(By.id("submit"));
        submitButton.click();

        // Find the text element and verify the greeting
        WebElement displayElement = webDriver.findElement(By.id("text"));
        assertEquals("Hello, Alexander Sebastian Montgomery Fitzgerald-Jenkins", displayElement.getText());
    }
    @After
    public void tearDown() {
        // Close the browser
        webDriver.quit();
    }
}
