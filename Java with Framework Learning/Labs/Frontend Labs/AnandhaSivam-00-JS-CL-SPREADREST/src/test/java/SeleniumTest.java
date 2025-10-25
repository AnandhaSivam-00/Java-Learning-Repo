import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class SeleniumTest {
    private WebDriver webDriver;

    @Before
    public void setUp() {
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");

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

    @After
    public void tearDown() {
        // Close the browser
        webDriver.quit();
    }

    @Test
    public void testSum() throws InterruptedException {
        WebElement sum = webDriver.findElement(By.id("sum"));
        Assert.assertEquals("15", sum.getText());
       }

    @Test
    public void testEmployeeInfo() {
        WebElement employeeInfo = webDriver.findElement(By.id("employeeInfo"));
        Assert.assertEquals("Name: Smith, John - $89,000", employeeInfo.getText());
    }


}
