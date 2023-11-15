package tek.sdet.framework.config;
//import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeBrowser implements Browser {
    public WebDriver openBrowser(String url) {
        
        WebDriverManager.chromedriver().setup();
        
        WebDriver driver = new ChromeDriver();
        //ChromeOptions options = new ChromeOptions();
        //options.setHeadless(false);
        //WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/"), options);
        
        driver.get(url);
		return driver; 
        
        
    }

}

