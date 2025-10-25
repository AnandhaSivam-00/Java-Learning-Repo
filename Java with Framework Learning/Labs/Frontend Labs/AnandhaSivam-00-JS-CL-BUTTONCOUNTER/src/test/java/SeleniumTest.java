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
        File file = new File("src/main/ButtonCounter.html");
        String path = "file://" + file.getAbsolutePath();

        // Create a new ChromeDriver instance
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        webDriver = new ChromeDriver(options);

        // Open the HTML file
        webDriver.get(path);
    }

    @Test
    public void testIncrementButton() {

        // Find the increment button and click it
        WebElement incrementButton = webDriver.findElement(By.id("button"));
        incrementButton.click();

        // Find the display element and verify the incremented value
        WebElement displayElement = webDriver.findElement(By.id("count"));
        assertEquals("1", displayElement.getText());
    }
    @Test
    public void testIncrementButtonMultipleTimes() {

        // Find the increment button and click it
        WebElement incrementButton = webDriver.findElement(By.id("button"));
        incrementButton.click();
        incrementButton.click();
        incrementButton.click();
        incrementButton.click();
        incrementButton.click();
        incrementButton.click();
        

        // Find the display element and verify the incremented value
        WebElement displayElement = webDriver.findElement(By.id("count"));
        assertEquals("6", displayElement.getText());

    }



    @After
    public void tearDown() {
        // Close the browser
        webDriver.quit();
    }
}
