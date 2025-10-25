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
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");

        // Get file
        File file = new File("src/main/CSSBoxModel.html");
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

    @Test
    public void testAllPizzaPadding() {
        WebElement pizza = webDriver.findElement(By.className("pizza"));
        assertEquals("20px", pizza.getCssValue("padding"));
    }

    @Test
    public void testAllPizzaMargin() {
        WebElement pizza = webDriver.findElement(By.className("pizza"));
        assertEquals("20px", pizza.getCssValue("margin"));
    }

    @Test
    public void testPizza1BackgroundColor() {
        WebElement pizza1 = webDriver.findElement(By.id("pizza1"));
        assertEquals("rgba(255, 255, 0, 1)", pizza1.getCssValue("background-color")); // Expected value for yellow
    }

    @Test
    public void testPizza2Color() {
        WebElement pizza2 = webDriver.findElement(By.id("pizza2"));
        assertEquals("rgba(255, 0, 0, 1)", pizza2.getCssValue("color")); // Expected value for red
    }

    @Test
    public void testPizza2Border() {
        WebElement pizza2 = webDriver.findElement(By.id("pizza2"));
        assertEquals("solid", pizza2.getCssValue("border-style"));
        assertEquals("rgb(139, 69, 19)", pizza2.getCssValue("border-color"));
        // For some reason, possible due to inconsistencies between browsers, the border-width is sometimes
        // retrieved as 4.6667. By converting it to a double and rounding, we circumvent this problem:
        double borderWidth = Double.valueOf(pizza2.getCssValue("border-width").replace("px",""));
        borderWidth = Math.round(borderWidth);
        assertEquals(5.0, borderWidth, 0.01);
    }

    @Test
    public void testPizza3Border() {
        WebElement pizza3 = webDriver.findElement(By.id("pizza3"));
        assertEquals("10px solid rgb(0, 0, 0)", pizza3.getCssValue("border")); // Expected value for black solid 10px
    }

}
