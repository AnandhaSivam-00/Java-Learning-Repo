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
        File file = new File("src/main/IfStatement.html");
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
        WebElement incrementButton = webDriver.findElement(By.id("counter"));
        incrementButton.click();

        // Find the display element and verify the incremented value
        WebElement displayElement = webDriver.findElement(By.id("display"));
        assertEquals("2", displayElement.getText());
        incrementButton.click();

        // Find the display element and verify the incremented value
        assertEquals("3", displayElement.getText());
    }

    @Test
    public void testCheckButton() {

        // Find the checkButton and click it
        WebElement countButton = webDriver.findElement(By.id("counter"));
        countButton.click();

        // Find the lightText element and verify the text based on the initial value of lightOn
        WebElement evenOrOddTextElement = webDriver.findElement(By.id("evenOrOddText"));
        String expectedText = "even"; // Assuming number is initially 1, and 2 after a click
        assertEquals(expectedText, evenOrOddTextElement.getText());
        
    }
    @Test
    public void testCheckButton2Clicks() {

        // Find the checkButton and click it
        WebElement countButton = webDriver.findElement(By.id("counter"));
        countButton.click();
        countButton.click();

        // Find the lightText element and verify the text based on the initial value of lightOn
        WebElement evenOrOddTextElement = webDriver.findElement(By.id("evenOrOddText"));
        String expectedText = "odd"; // Assuming number is initially 1, and 2 after a click
        assertEquals(expectedText, evenOrOddTextElement.getText());
        
    }

    @After
    public void tearDown() {
        // Close the browser
        webDriver.quit();
    }
}
