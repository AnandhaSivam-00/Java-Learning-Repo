import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");

        // Get file
        File file = new File("src/main/StyledElements.html");
        String path = "file://" + file.getAbsolutePath();

        // Create a new ChromeDriver instance
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        webDriver = new ChromeDriver(options);

        // Open the HTML file
        webDriver.get(path);
    }
    
    @Test
    public void testItalicText() {
        WebElement p = webDriver.findElement(By.id("italic"));
        assertEquals("italic", p.getCssValue("font-style"));
    }


    @Test
    public void testSmallText() {
        WebElement p = webDriver.findElement(By.id("small"));
        String fontSize = p.getCssValue("font-size");
        // extract the font size of the p element:
        fontSize = fontSize.substring(0, fontSize.length() - 2);
        int fontSizeNum = Integer.valueOf(fontSize);
        // assert that the font size is less than 30:
        assertTrue(fontSizeNum < 16);
    }

    @Test
    public void testCenterContent() {
        WebElement p = webDriver.findElement(By.id("center"));
        boolean centered = p.getCssValue("text-align").equals("center");
        assertTrue(centered);
    }

    @After
    public void tearDown() {
        // Close the browser
        webDriver.quit();
    }
}
