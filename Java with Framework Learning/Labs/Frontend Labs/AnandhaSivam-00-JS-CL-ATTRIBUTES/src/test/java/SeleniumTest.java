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
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");//linux_64

        // Get file
        File file = new File("src/main/Attributes.html");
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
    public void testImageSrc() {
        //setup
        WebElement imageElement = webDriver.findElement(By.id("image"));
        WebElement buttonElement = webDriver.findElement(By.id("button"));
        WebElement inputElement = webDriver.findElement(By.id("input"));
        String url = "./resources/python.png";
        String placeholder = "./resources/placeholder.png";

        //make sure initial src is present
        String initial = imageElement.getAttribute("src");
        Assert.assertEquals(placeholder.substring(placeholder.length() - 26), initial.substring(initial.length() - 26));

        //enter new input and click button
        inputElement.sendKeys(url);
        buttonElement.click();
        String src = imageElement.getAttribute("src");

        //assert src attribute now matches input
        Assert.assertEquals(url.substring(1), src.substring(src.length() + 1 - url.length()));
    }


}
