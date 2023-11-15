package tek.sdet.framework.config;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

public interface Browser {
    
    WebDriver openBrowser(String url) throws MalformedURLException;

}
