package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Calculator {

    public AndroidDriver<AndroidElement> ad;

    public void typeNumber(String n){
        System.out.println("Type number");
        for(int i=0;i<n.length();i++){
            ad.findElement(By.id("com.android.calculator2:id/digit_"+n.charAt(i))).click();
        }
    }

    public void typeOperator(String n){
        System.out.println("Type Operator");
        ad.findElement(By.id("com.android.calculator2:id/op_"+n)).click();
    }

    protected AndroidDriver<AndroidElement> setup() throws MalformedURLException {

        System.out.println("SETUP");

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", "com.android.calculator2");
        dc.setCapability("appActivity", ".Calculator");

        ad = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        ad.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return ad;
    }

    protected String Sum(String num1, String num2) {

        System.out.println("Calculate sum of two numbers");
        //Locate elements using By.name() to enter data and click +/= buttons
        //int result= Integer.parseInt(num1.trim())+Integer.parseInt(num2.trim());
        typeNumber(num1);
        typeOperator("add");
        typeNumber(num2);
        String result = ad.findElementById("com.android.calculator2:id/result").getText();

        return result;
    }
}
