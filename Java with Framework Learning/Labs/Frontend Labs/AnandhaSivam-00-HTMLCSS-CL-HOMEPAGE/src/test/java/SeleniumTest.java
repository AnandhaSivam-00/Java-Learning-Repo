import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SeleniumTest {

    private WebDriver webDriver;

    @Before
    public void setUp() {
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");

        // Get file
        File file = new File("src/main/YourHomePage.html");
        String path = "file://" + file.getAbsolutePath();

        // Create a new ChromeDriver instance
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        webDriver = new ChromeDriver(options);

        // Open the HTML file
        webDriver.get(path);
    }

    @After
    public void teardown() {
        webDriver.quit();
    }

    /*
    TODO: Write tests
     */

     @Test
     public void titleIsChanged() {
        String title = webDriver.getTitle();

        assertNotEquals("placeholder", title);
     }

     @Test
     public void headerTagTest() {
        boolean isHeaderPresent = false;
        String[] headerTagNames = {"h1", "h2", "h3", "h4", "h5", "h6"};
        for(String headerTagName: headerTagNames) {
            isHeaderPresent = webDriver.findElements(By.tagName(headerTagName)).size() > 0;
            if (isHeaderPresent) break;
        }
        assertTrue(isHeaderPresent);

     }

     @Test
     public void listTest() {
        WebElement element = webDriver.findElement(By.cssSelector("ul > li"));
        assertNotNull(element);
     }

     @Test
     public void linkTest() {
        WebElement element = webDriver.findElement(By.tagName("a"));
        assertNotNull(element);
        assertEquals("Intro.html", element.getDomAttribute("href"));
     }

}
