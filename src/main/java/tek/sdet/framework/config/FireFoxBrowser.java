package tek.sdet.framework.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URL;

public class FireFoxBrowser implements Browser {

    public WebDriver openBrowser(String url) throws MalformedURLException {
        // Use WebDriverManager to manage FirefoxDriver
        WebDriverManager.firefoxdriver().setup();

        // Define FirefoxOptions
        FirefoxOptions options = new FirefoxOptions();
       // Set to true for headless mode 

        // Create a RemoteWebDriver instance and connect to Selenium Grid hub
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/"), options);
         

        driver.get(url);
        
        return driver;
    }
}

