import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;

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
        File file = new File("src/main/AppendingElements.html");
        String path = "file://" + file.getAbsolutePath();

        // Create a new ChromeDriver instance
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        webDriver = new ChromeDriver(options);

        // Open the HTML file
        webDriver.get(path);
    }

    @Test
    public void addOneItemTest() {
        // find input element:
        WebElement input = webDriver.findElement(By.id("input"));

        // type in input box:
        input.sendKeys("apples");

        // find submit button and submit:
        WebElement button = webDriver.findElement(By.id("button"));
        button.click();

        // find list of items and ensure item is there:
        List<WebElement> list = webDriver.findElements(By.cssSelector("#list li"));

        Assert.assertEquals(1, list.size());

        Assert.assertEquals("apples", list.get(0).getText());
    }

    @Test
    public void addThreeItemsTest() {
        // find input element:
        WebElement input = webDriver.findElement(By.id("input"));

        // type in input box:
        input.sendKeys("apples");

        // find submit button and submit:
        WebElement button = webDriver.findElement(By.id("button"));
        button.click();

        // send more items:
        input.clear();
        input.sendKeys("bananas");
        button.click();
        input.clear();
        input.sendKeys("oranges");
        button.click();

        // find list of items and ensure items are there:
        List<WebElement> list = webDriver.findElements(By.cssSelector("#list li"));

        Assert.assertEquals(3, list.size());

        Assert.assertEquals("apples", list.get(0).getText());
        Assert.assertEquals("bananas", list.get(1).getText());
        Assert.assertEquals("oranges", list.get(2).getText());
    }

    @Test
    public void emptyListTest() {
        // find input element:
        WebElement input = webDriver.findElement(By.id("input"));

        // find list of items and ensure no items:
        List<WebElement> list = webDriver.findElements(By.cssSelector("#list li"));

        Assert.assertEquals(0, list.size());

    }


    @After
    public void tearDown() {
        // Close the browser
        webDriver.quit();
    }
}
