import PageObjects.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;


public class CalcTests extends BaseTest{

    //public AndroidDriver<AndroidElement> ad;
    public Calculator pageObject;

    @DataProvider(name = "nums")
    public Object[][] dataProviderMethod() {
        return new Object[][] { { "10000","5000","15000" } };
    }

    @BeforeTest
    public void loadCalculator() throws MalformedURLException {
        setup(".Calculator","com.android.calculator2");
        pageObject = new Calculator();
    }

    @Test(dataProvider = "nums")
    public void Add(String num1, String num2, String result){
        Assert.assertEquals(pageObject.Sum(num1,num2), result);
    }

}