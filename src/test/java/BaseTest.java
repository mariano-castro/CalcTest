import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public AndroidDriver<AndroidElement> ad;

    protected AndroidDriver<AndroidElement> setup(String activity, String pack) throws MalformedURLException {

        System.out.println("SETUP");

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", pack);
        dc.setCapability("appActivity", activity);

        ad = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        ad.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return ad;
    }

    @AfterTest
    public void End() {
        ad.quit();
    }
}
