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
        File file = new File("src/main/Arrays.html");
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
    public void testAdd() {
        WebElement inputElement = webDriver.findElement(By.id("input"));
        WebElement pushButton = webDriver.findElement(By.id("pushButton"));
        WebElement currentArray = webDriver.findElement(By.id("content"));

        inputElement.sendKeys("apple");
        pushButton.click();
        inputElement.clear();
        inputElement.sendKeys("banana");
        pushButton.click();
        inputElement.clear();
        inputElement.sendKeys("orange");
        pushButton.click();

        Assert.assertEquals("apple,banana,orange", currentArray.getText());

    }

    @Test
    public void testPop() {
        WebElement inputElement = webDriver.findElement(By.id("input"));
        WebElement pushButton = webDriver.findElement(By.id("pushButton"));
        WebElement currentArray = webDriver.findElement(By.id("content"));
        WebElement popButton = webDriver.findElement(By.id("popButton"));

        inputElement.sendKeys("apple");
        pushButton.click();
        inputElement.clear();
        inputElement.sendKeys("banana");
        pushButton.click();
        inputElement.clear();
        inputElement.sendKeys("orange");
        pushButton.click();

        popButton.click();

        Assert.assertEquals("apple,banana", currentArray.getText());

    }

    @Test
    public void testLengthAfterAdd() {
        WebElement pushButton = webDriver.findElement(By.id("pushButton"));
        WebElement length = webDriver.findElement(By.id("length"));

        pushButton.click();        
        pushButton.click();
        pushButton.click();


        Assert.assertEquals("3", length.getText());

    }

    @Test
    public void testLengthAfterAddPop() {
        WebElement pushButton = webDriver.findElement(By.id("pushButton"));
        WebElement popButton = webDriver.findElement(By.id("popButton"));
        WebElement length = webDriver.findElement(By.id("length"));

        pushButton.click();
        pushButton.click();
        pushButton.click();

        popButton.click();

        Assert.assertEquals("2", length.getText());

    }



}
