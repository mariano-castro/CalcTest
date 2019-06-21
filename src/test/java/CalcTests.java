import PageObjects.Calculator;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;


public class CalcTests extends Calculator{

    public AndroidDriver<AndroidElement> ad;

    @DataProvider(name = "nums")
    public Object[][] dataProviderMethod() {
        return new Object[][] { { "10000","5000","15000" } };
    }

    @BeforeTest
    public void loadCalculator() throws MalformedURLException {
        ad = this.setup();
    }

    @Test(dataProvider = "nums")
    public void Add(String num1, String num2, String result) {
        Assert.assertEquals(this.Sum(num1,num2), result);
    }

    @AfterTest
    public void End() {
        ad.quit();
    }
}