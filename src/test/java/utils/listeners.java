package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class listeners implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result) {
//        take screenshot and save the screenshot as the test case name
     CommonMethods.takeScreenshot("passed "+result.getName());
    }
    @Override
    public void onTestFailure(ITestResult result) {
        //        take screenshot and save the screenshot as the test case name
        CommonMethods.takeScreenshot("failed "+result.getName());
    }

}
