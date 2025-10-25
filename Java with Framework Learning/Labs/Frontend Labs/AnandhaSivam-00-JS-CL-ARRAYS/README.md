# Selenium-Prototype

## Gitpod Environment
For Selenium tests to work we need:
 - A Selenium WebDriver
 - A compatible browser

This prototype uses Chrome. We download and install chrome from dl.google.com getting the latest stable chrome installer for linux amd64. This is the first task, see `.gitpod.yml`.
```yml
  - name: Chrome
    before: sudo apt update
    init: wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
    command: sudo apt install ./google-chrome-stable_current_amd64.deb -y
```

We get the compatible WebDriver for Chrome by first requesting a text file that identifies the latest release. Then we download that release. Not sure how future proof this is, it looks like they replace that file as new releases come out.
```yml
  - name: SeleniumDriver
    before: wget https://chromedriver.storage.googleapis.com/LATEST_RELEASE
    init: wget https://chromedriver.storage.googleapis.com/$(cat LATEST_RELEASE)/chromedriver_linux64.zip
    command: unzip ./chromedriver_linux64.zip -d ./driver
```

The chrome installer can take a minute or two to complete. This is less than ideal, but we could roll it into our own Docker image. In my testing, gitpod takes a long time to compose a new image from a dockerfile, but a pre-published image might work faster. If we are already using a pre-built image, we can just install chrome on it, and load the compatible driver into some location on the PATH. This is the optimal solution, I believe.

## Unit Tests
Setting up the unit tests is fairly easy. We do need to identify the location of the WebDriver. We can tell Selenium where it is located with a system property, see `SeleniumTest.java`.
```java
System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
```
This is the correct property for the location the `.gitpod.yml` places the driver.  

Another pitfall: Selenium is picky about the name. We must prepend the absolute path with `"file://"`:
```java
File file = new File("index.html");
String path = "file://" + file.getAbsolutePath();
```

Lastly, we need to run it in headless mode. This is done by giving Selenium the `"headless"` argument:
```java
ChromeOptions options = new ChromeOptions();
options.addArguments("headless");
webDriver = new ChromeDriver(options);
```
