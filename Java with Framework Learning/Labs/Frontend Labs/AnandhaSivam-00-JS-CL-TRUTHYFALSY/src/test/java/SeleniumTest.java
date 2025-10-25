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
        File file = new File("src/main/TruthyFalsy.html");
        String path = "file://" + file.getAbsolutePath();

        // Create a new ChromeDriver instance
         ChromeOptions options = new ChromeOptions();
        
        options.addArguments("headless");
          webDriver = new ChromeDriver(options);
       

        // Open the HTML file
        webDriver.get(path);
    }
    
    @Test
    public void testR1() {
        WebElement r1 = webDriver.findElement(By.id("r1"));
        assertEquals(r1.getText(), "true");
    }

    @Test
    public void testR2() {
        WebElement r2 = webDriver.findElement(By.id("r2"));
        assertEquals(r2.getText(), "false");
    }

    @Test
    public void testR3() {
        WebElement r3 = webDriver.findElement(By.id("r3"));
        assertEquals(r3.getText(), "false");
    }

    @Test
    public void testR4() {
        WebElement r4 = webDriver.findElement(By.id("r4"));
        assertEquals(r4.getText(), "true");
    }

    @Test
    public void testR5() {
        WebElement r5 = webDriver.findElement(By.id("r5"));
        assertEquals(r5.getText(), "false");
    }

    @Test
    public void testR6() {
        WebElement r6 = webDriver.findElement(By.id("r6"));
        assertEquals(r6.getText(), "true");
    }

    @Test
    public void testR7() {
        WebElement r7 = webDriver.findElement(By.id("r7"));
        assertEquals(r7.getText(), "true");
    }

    @Test
    public void testR8() {
        WebElement r8 = webDriver.findElement(By.id("r8"));
        assertEquals(r8.getText(), "true");
    }

    @Test
    public void testR9() {
        WebElement r9 = webDriver.findElement(By.id("r9"));
        assertEquals(r9.getText(), "false");
    }

    @Test
    public void testR10() {
        WebElement r10 = webDriver.findElement(By.id("r10"));
        assertEquals(r10.getText(), "false");
    }

    

    @After
    public void tearDown() {
        // Close the browser
        webDriver.quit();
    }
}
