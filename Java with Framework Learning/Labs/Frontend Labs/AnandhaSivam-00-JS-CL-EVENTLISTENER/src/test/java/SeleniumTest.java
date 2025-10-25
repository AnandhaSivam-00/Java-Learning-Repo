import static org.junit.Assert.assertEquals;

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

    @Before
    public void setUp() {
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");//linux_64

        // Get file
        File file = new File("src/main/EventListener.html");
        String path = "file://" + file.getAbsolutePath();

        // Create a new ChromeDriver instance
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        webDriver = new ChromeDriver(options);

        // Open the HTML file
        webDriver.get(path);
    }

    @Test
    public void testButton1Text1() {
        WebElement text1 = webDriver.findElement(By.id("text1"));

        Assert.assertEquals("this text will change when button1 is clicked", text1.getText());

        // Find button 1 and click it
        WebElement button1 = webDriver.findElement(By.id("button1"));
        button1.click();

        assertEquals("button1 clicked", text1.getText());
    }

    @Test
    public void testButton1Text2() {
        WebElement text2 = webDriver.findElement(By.id("text2"));

        Assert.assertEquals("this text will change when either button1 or button2 is clicked", text2.getText());

        // Find button 1 and click it
        WebElement button1 = webDriver.findElement(By.id("button1"));
        button1.click();

        assertEquals("either button1 or button2 clicked", text2.getText());
    }

    @Test
    public void testButton2Text3() {
        WebElement text3 = webDriver.findElement(By.id("text3"));

        Assert.assertEquals("this text will change when button2 is clicked", text3.getText());

        // Find button 2 and click it
        WebElement button2 = webDriver.findElement(By.id("button2"));
        button2.click();

        assertEquals("button2 clicked", text3.getText());
    }

    @Test
    public void testButton2Text2() {
        WebElement text2 = webDriver.findElement(By.id("text2"));

        Assert.assertEquals("this text will change when either button1 or button2 is clicked", text2.getText());

        // Find button 2 and click it
        WebElement button2 = webDriver.findElement(By.id("button2"));
        button2.click();

        assertEquals("either button1 or button2 clicked", text2.getText());
    }

    @After
    public void tearDown() {
        // Close the browser
        webDriver.quit();
    }
}
