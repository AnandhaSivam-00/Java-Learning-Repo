import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.Arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SeleniumTest {

  private WebDriver webDriver;
  private WebDriverWait wait;
  private static final Logger logger = Logger.getLogger(SeleniumTest.class.getName());
  private Process httpServerProcess;
  private String browserType; // "chrome" or "edge"

  // Architecture and system detection
  private static final String OS_NAME = System.getProperty("os.name").toLowerCase();
  private static final String OS_ARCH = System.getProperty("os.arch").toLowerCase();
  private static final boolean IS_ARM = OS_ARCH.contains("aarch64") || OS_ARCH.contains("arm");
  private static final boolean IS_WINDOWS = OS_NAME.contains("windows");
  private static final boolean IS_LINUX = OS_NAME.contains("linux");
  private static final boolean IS_MAC = OS_NAME.contains("mac");

  private static class BrowserConfig {
    final String browserType;
    final String driverPath;
    final String binaryPath;

    BrowserConfig(String browserType, String driverPath, String binaryPath) {
      this.browserType = browserType;
      this.driverPath = driverPath;
      this.binaryPath = binaryPath;
    }
  }

  @Before
  public void setUp() {
    try {
      printEnvironmentInfo();

      BrowserConfig browserConfig = detectBrowserAndDriver();
      this.browserType = browserConfig.browserType;

      File htmlFile = findHtmlFile();
      String htmlUrl = determineHtmlUrl(htmlFile);

      webDriver = createWebDriver(browserConfig);

      wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));

      webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
      webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

      System.out.println("\n=== NAVIGATING TO PAGE ===");
      System.out.println("Navigating to: " + htmlUrl);
      webDriver.get(htmlUrl);

      wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
      System.out.println("Page loaded successfully");

      printPageInfo();

    } catch (Exception e) {
      System.err.println("\n=== SETUP FAILED ===");
      System.err.println("Error: " + e.getMessage());
      e.printStackTrace();

      cleanup();
      throw new RuntimeException("Setup failed", e);
    }
  }

  @Test
  public void testClickParagraph() {

    // Find a p tag and click it
    WebElement paragraph = webDriver.findElement(By.tagName("p"));
    paragraph.click();

    // assert that the content field was updated:
    WebElement content = webDriver.findElement(By.id("content"));

    Assert.assertEquals("[object HTMLParagraphElement]", content.getText());
  }

  @Test
  public void testClickButton() {

    // Find a button tag and click it
    WebElement button = webDriver.findElement(By.tagName("button"));
    button.click();

    // assert that the content field was updated:
    WebElement content = webDriver.findElement(By.id("content"));

    Assert.assertEquals("[object HTMLButtonElement]", content.getText());
  }

  @Test
  public void testClickHeader() {

    // Find a header tag and click it
    WebElement header = webDriver.findElement(By.tagName("h1"));
    header.click();

    // assert that the content field was updated:
    WebElement content = webDriver.findElement(By.id("content"));

    Assert.assertEquals("[object HTMLHeadingElement]", content.getText());
  }

  @Test
  public void testClickAnchor() {

    // Find anchor tag and click it
    WebElement anchor = webDriver.findElement(By.tagName("a"));
    anchor.click();

    // assert that the content field was updated:
    WebElement content = webDriver.findElement(By.id("content"));

    Assert.assertEquals("https://developer.mozilla.org/en-US/docs/Web/API/Event", content.getText());
  }

  private void printEnvironmentInfo() {
    System.out.println("=== ENVIRONMENT INFO ===");
    System.out.println("OS: " + OS_NAME + " (" + OS_ARCH + ")");
    System.out.println("Architecture: " + (IS_ARM ? "ARM64" : "x86/x64"));
    System.out.println("Java version: " + System.getProperty("java.version"));
    System.out.println("Working directory: " + System.getProperty("user.dir"));
  }

  private BrowserConfig detectBrowserAndDriver() {
    System.out.println("\n=== BROWSER AND DRIVER DETECTION ===");

    BrowserConfig projectDriverConfig = checkProjectDriverFolder();
    if (projectDriverConfig != null) {
      return projectDriverConfig;
    }

    BrowserConfig systemDriverConfig = checkSystemDrivers();
    if (systemDriverConfig != null) {
      return systemDriverConfig;
    }

    throw new RuntimeException("No compatible browser driver found");
  }

  private BrowserConfig checkProjectDriverFolder() {
    File driverFolder = new File("driver");
    if (!driverFolder.exists() || !driverFolder.isDirectory()) {
      System.out.println("No 'driver' folder found in project root");
      return null;
    }

    System.out.println("Found 'driver' folder, checking for executables...");

    String[] edgeDriverNames = IS_WINDOWS ? new String[] { "msedgedriver.exe", "edgedriver.exe" }
        : new String[] { "msedgedriver", "edgedriver" };

    for (String driverName : edgeDriverNames) {
      File driverFile = new File(driverFolder, driverName);
      if (driverFile.exists()) {
        makeExecutable(driverFile);
        if (driverFile.canExecute()) {
          System.out.println("Found Edge driver: " + driverFile.getAbsolutePath());
          return new BrowserConfig("edge", driverFile.getAbsolutePath(), findEdgeBinary());
        }
      }
    }

    String[] chromeDriverNames = IS_WINDOWS ? new String[] { "chromedriver.exe" } : new String[] { "chromedriver" };

    for (String driverName : chromeDriverNames) {
      File driverFile = new File(driverFolder, driverName);
      if (driverFile.exists()) {
        makeExecutable(driverFile);
        if (driverFile.canExecute()) {
          System.out.println("Found Chrome driver: " + driverFile.getAbsolutePath());
          return new BrowserConfig("chrome", driverFile.getAbsolutePath(), findChromeBinary());
        }
      }
    }

    System.out.println("No compatible drivers found in 'driver' folder");
    return null;
  }

  private BrowserConfig checkSystemDrivers() {
    System.out.println("Checking system-installed drivers...");

    String[] chromeDriverPaths = {
        "/usr/bin/chromedriver",
        "/usr/local/bin/chromedriver",
        "/snap/bin/chromedriver",
        System.getProperty("user.home") + "/.cache/selenium/chromedriver/linux64/chromedriver",
        "/opt/chromedriver/chromedriver"
    };

    if (IS_WINDOWS) {
      chromeDriverPaths = new String[] {
          "C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe",
          "C:\\ChromeDriver\\chromedriver.exe",
          "chromedriver.exe"
      };
    }

    for (String driverPath : chromeDriverPaths) {
      File driverFile = new File(driverPath);
      if (driverFile.exists() && driverFile.canExecute()) {
        System.out.println("Found system Chrome driver: " + driverPath);
        return new BrowserConfig("chrome", driverPath, findChromeBinary());
      }
    }

    if (IS_WINDOWS) {
      String[] edgeDriverPaths = {
          "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe",
          "msedgedriver.exe"
      };

      for (String driverPath : edgeDriverPaths) {
        File driverFile = new File(driverPath);
        if (driverFile.exists() && driverFile.canExecute()) {
          System.out.println("Found system Edge driver: " + driverPath);
          return new BrowserConfig("edge", driverPath, findEdgeBinary());
        }
      }
    }

    return null;
  }

  private String findChromeBinary() {
    String[] chromePaths;

    if (IS_WINDOWS) {
      chromePaths = new String[] {
          "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe",
          "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"
      };
    } else if (IS_MAC) {
      chromePaths = new String[] {
          "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome"
      };
    } else {
      chromePaths = new String[] {
          "/usr/bin/chromium-browser",
          "/usr/bin/chromium",
          "/usr/bin/google-chrome",
          "/snap/bin/chromium"
      };
    }

    for (String path : chromePaths) {
      if (new File(path).exists()) {
        System.out.println("Found Chrome binary: " + path);
        return path;
      }
    }

    System.out.println("Chrome binary not found, using default");
    return null;
  }

  private String findEdgeBinary() {
    if (IS_WINDOWS) {
      String[] edgePaths = {
          "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe",
          "C:\\Program Files\\Microsoft\\Edge\\Application\\msedge.exe"
      };

      for (String path : edgePaths) {
        if (new File(path).exists()) {
          System.out.println("Found Edge binary: " + path);
          return path;
        }
      }
    }

    System.out.println("Edge binary not found, using default");
    return null;
  }

  private void makeExecutable(File file) {
    if (!file.canExecute()) {
      try {
        file.setExecutable(true);
        System.out.println("Made executable: " + file.getAbsolutePath());
      } catch (Exception e) {
        System.out.println("Could not make executable: " + e.getMessage());
      }
    }
  }

  private File findHtmlFile() {
    String[] possibleHtmlPaths = {
        "src/main/EventObject.html",
    };

    for (String htmlPath : possibleHtmlPaths) {
      File testFile = new File(htmlPath);
      if (testFile.exists()) {
        System.out.println("Found HTML file: " + testFile.getAbsolutePath());
        return testFile;
      }
    }

    throw new RuntimeException("Could not find index.html in any expected location: " +
        Arrays.toString(possibleHtmlPaths));
  }

  private String determineHtmlUrl(File htmlFile) {
    if (isPython3Available()) {
      try {
        return startHttpServer(htmlFile);
      } catch (Exception e) {
        System.out.println("HTTP server failed, falling back to file URL: " + e.getMessage());
      }
    } else {
      System.out.println("Python3 not available, using file URL");
    }

    return "file://" + htmlFile.getAbsolutePath();
  }

  private boolean isPython3Available() {
    try {
      Process process = new ProcessBuilder("python3", "--version").start();
      boolean finished = process.waitFor(5, java.util.concurrent.TimeUnit.SECONDS);
      if (finished && process.exitValue() == 0) {
        System.out.println("Python3 is available");
        return true;
      }
    } catch (Exception e) {
      // Ignore
    }

    if (IS_WINDOWS) {
      try {
        Process process = new ProcessBuilder("python", "--version").start();
        boolean finished = process.waitFor(5, java.util.concurrent.TimeUnit.SECONDS);
        if (finished && process.exitValue() == 0) {
          System.out.println("Python is available");
          return true;
        }
      } catch (Exception e) {
        // Ignore
      }
    }

    System.out.println("Python3/Python not available");
    return false;
  }

  private String startHttpServer(File htmlFile) throws Exception {
    int port = 8000 + (int) (Math.random() * 1000);
    String directory = htmlFile.getParent();
    String fileName = htmlFile.getName();

    System.out.println("Starting HTTP server on port " + port);

    String pythonCmd = IS_WINDOWS ? "python" : "python3";
    ProcessBuilder pb = new ProcessBuilder(pythonCmd, "-m", "http.server", String.valueOf(port));
    pb.directory(new File(directory));
    pb.redirectErrorStream(true);

    httpServerProcess = pb.start();

    Thread.sleep(3000);

    if (!httpServerProcess.isAlive()) {
      throw new RuntimeException("HTTP server failed to start");
    }

    String url = "http://localhost:" + port + "/" + fileName;

    for (int i = 0; i < 10; i++) {
      try {
        java.net.URL testUrl = new java.net.URL(url);
        java.net.HttpURLConnection connection = (java.net.HttpURLConnection) testUrl.openConnection();
        connection.setConnectTimeout(1000);
        connection.setReadTimeout(1000);
        connection.setRequestMethod("HEAD");
        int responseCode = connection.getResponseCode();
        connection.disconnect();

        if (responseCode == 200) {
          System.out.println("HTTP server ready: " + url);
          return url;
        }
      } catch (Exception e) {
        if (i == 9) {
          throw new RuntimeException("HTTP server not responding: " + e.getMessage());
        }
        Thread.sleep(1000);
      }
    }

    throw new RuntimeException("HTTP server failed to respond");
  }

  private WebDriver createWebDriver(BrowserConfig config) {
    System.out.println("\n=== CREATING WEBDRIVER ===");
    System.out.println("Browser: " + config.browserType);
    System.out.println("Driver: " + config.driverPath);
    System.out.println("Binary: " + config.binaryPath);

    if ("edge".equals(config.browserType)) {
      return createEdgeDriver(config);
    } else {
      return createChromeDriver(config);
    }
  }

  private WebDriver createChromeDriver(BrowserConfig config) {
    System.setProperty("webdriver.chrome.driver", config.driverPath);

    ChromeOptions options = new ChromeOptions();

    if (config.binaryPath != null) {
      options.setBinary(config.binaryPath);
    }

    options.addArguments(getChromeArguments());

    LoggingPreferences logPrefs = new LoggingPreferences();
    logPrefs.enable(LogType.BROWSER, Level.ALL);
    options.setCapability("goog:loggingPrefs", logPrefs);

    ChromeDriverService.Builder serviceBuilder = new ChromeDriverService.Builder()
        .usingDriverExecutable(new File(config.driverPath))
        .withTimeout(Duration.ofSeconds(30));

    ChromeDriverService service = serviceBuilder.build();

    return new ChromeDriver(service, options);
  }

  private WebDriver createEdgeDriver(BrowserConfig config) {
    System.setProperty("webdriver.edge.driver", config.driverPath);

    EdgeOptions options = new EdgeOptions();

    if (config.binaryPath != null) {
      options.setBinary(config.binaryPath);
    }

    options.addArguments(getEdgeArguments());

    LoggingPreferences logPrefs = new LoggingPreferences();
    logPrefs.enable(LogType.BROWSER, Level.ALL);
    options.setCapability("ms:loggingPrefs", logPrefs);

    EdgeDriverService.Builder serviceBuilder = new EdgeDriverService.Builder()
        .usingDriverExecutable(new File(config.driverPath))
        .withTimeout(Duration.ofSeconds(30));

    EdgeDriverService service = serviceBuilder.build();

    return new EdgeDriver(service, options);
  }

  private String[] getChromeArguments() {
    return getCommonBrowserArguments();
  }

  private String[] getEdgeArguments() {
    return getCommonBrowserArguments();
  }

  private String[] getCommonBrowserArguments() {
    String[] baseArgs = {
        "--headless=new",
        "--no-sandbox",
        "--disable-dev-shm-usage",
        "--disable-gpu",
        "--window-size=1920,1080",
        "--disable-extensions",
        "--disable-web-security",
        "--allow-file-access-from-files",
        "--allow-running-insecure-content",
        "--user-data-dir=/tmp/browser-test-" + System.currentTimeMillis(),
        "--disable-features=TranslateUI,VizDisplayCompositor",
        "--disable-background-timer-throttling",
        "--disable-backgrounding-occluded-windows",
        "--disable-renderer-backgrounding"
    };

    if (IS_ARM) {
      String[] armArgs = {
          "--disable-features=VizDisplayCompositor",
          "--use-gl=swiftshader",
          "--disable-software-rasterizer"
      };

      String[] combined = new String[baseArgs.length + armArgs.length];
      System.arraycopy(baseArgs, 0, combined, 0, baseArgs.length);
      System.arraycopy(armArgs, 0, combined, baseArgs.length, armArgs.length);
      return combined;
    }

    return baseArgs;
  }

  private void printPageInfo() {
    System.out.println("Page title: " + webDriver.getTitle());
    System.out.println("Current URL: " + webDriver.getCurrentUrl());
    System.out.println("Page source length: " + webDriver.getPageSource().length());
  }

  private void stopHttpServer() {
    if (httpServerProcess != null) {
      try {
        System.out.println("Stopping HTTP server...");
        httpServerProcess.destroy();

        boolean terminated = httpServerProcess.waitFor(5, java.util.concurrent.TimeUnit.SECONDS);
        if (!terminated) {
          httpServerProcess.destroyForcibly();
        }

        httpServerProcess = null;
        System.out.println("HTTP server stopped");
      } catch (Exception e) {
        System.out.println("Warning: Error stopping HTTP server: " + e.getMessage());
        try {
          httpServerProcess.destroyForcibly();
        } catch (Exception ignored) {
        }
        httpServerProcess = null;
      }
    }
  }

  private void cleanup() {
    stopHttpServer();
    if (webDriver != null) {
      try {
        webDriver.quit();
        webDriver = null;
      } catch (Exception e) {
        System.err.println("Error cleaning up WebDriver: " + e.getMessage());
      }
    }
  }

  @After
  public void tearDown() {
    System.out.println("\n=== TEARDOWN ===");
    cleanup();
    System.out.println("Teardown completed");
  }
}
