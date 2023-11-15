package tek.sdet.framework.base;
import java.net.MalformedURLException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import tek.sdet.framework.utilities.CommonUtility;
public class BaseUITest extends CommonUtility {
    @Before
    public void setupTests() throws MalformedURLException {
        super.setupBrowser(); 
    }
    @After
    public void closeTests(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenShot = takeScreenShotAsBytes();
            scenario.attach(screenShot, "iamge/png", scenario.getName() + " scenario Failed");
        }
        super.quitBrowser();
    }
}
