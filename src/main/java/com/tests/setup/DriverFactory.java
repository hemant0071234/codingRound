package com.tests.setup;

import com.sun.javafx.PlatformUtil;
import com.tests.helpers.util.Storage;
import com.thoughtworks.gauge.AfterScenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

public class DriverFactory {
    private static WebDriver driver;
    private static final String FIREFOX = "firefox";
    private static final String CHROME = "chrome";
    private static final String INTERNET_EXPLORER = "internetexplorer";

    public static String browserName = System.getenv("browser_name") == null ? "internetexplorer" : System.getenv("browser_name");
    public static boolean cleanCache = System.getenv("clearCache") != null && Boolean.parseBoolean(System.getenv("clearCache"));

    public static void setDriver() {
        if(driver!=null)
            return;

        if (browserName.equalsIgnoreCase(CHROME)) {
            driver =  createChromeDriver(cleanCache);
        }
        else if (browserName.equalsIgnoreCase(INTERNET_EXPLORER)) {
            driver = createInternetExplorerDriver(cleanCache);
        }
        else if(browserName.equalsIgnoreCase(FIREFOX)){
            //driver = createFirefoxDriver(cleanCache);
        }
        else {
            throw new RuntimeException("Unknown WebDriver browser: " + browserName);
        }

        // Delete All cookies in case of clean session requirement
        System.out.println("====>>>> clear cache value: " + cleanCache);

        if (cleanCache) {
            driver.manage().deleteAllCookies();
        }

        //driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        if(driver==null)
            setDriver();
        return driver;
    }

    public static WebDriver getExistingDriverElseReturnNull() {
            return driver;
    }

    @AfterTest
    public void tearDown() {
        Storage.flushAll();
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
    private static WebDriver createChromeDriver(boolean clearCache) {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", System.getenv("webdriver_chrome_driver_mac"));
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", System.getenv("webdriver_chrome_driver_windows"));
        }
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions opts = new ChromeOptions();
        if (clearCache) {
            //opts.addArguments("--disable-application-cache");
            opts.addArguments("--incognito");
        }
        opts.addArguments("disable-extensions");
        opts.addArguments("--start-maximized");
        capabilities.setCapability(ChromeOptions.CAPABILITY, opts);
        WebDriver driver =  new ChromeDriver(opts);
        if (clearCache) {
            driver.get("chrome://extensions-frame");
            WebElement checkbox = driver.findElement(By.xpath("//label[@class='incognito-control']/input[@type='checkbox']"));
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
        return driver;
    }

    private static WebDriver createInternetExplorerDriver(boolean clearCache) {
        System.setProperty("webdriver.ie.driver", System.getenv("webdriver_ie_driver"));
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
        capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, clearCache);
        return new InternetExplorerDriver(capabilities);
    }

}
