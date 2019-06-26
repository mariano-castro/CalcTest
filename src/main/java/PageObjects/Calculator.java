package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class Calculator {

    public AndroidDriver<AndroidElement> ad;

    public void typeNumber(String n){
        System.out.println("Type number");
        for(int i=0;i<n.length();i++){
            ad.findElement(By.id("com.android.calculator2:id/digit_"+n.charAt(i))).click();
        }
    }

    public void setAndroidDriver(AndroidDriver<AndroidElement> androidDr){
        ad = androidDr;
    }

    public void typeOperator(String n){
        System.out.println("Type Operator");
        ad.findElement(By.id("com.android.calculator2:id/op_"+n)).click();
    }

    public String Sum(String num1, String num2) {

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