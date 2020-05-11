package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerExample implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("***Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("***Test succeeded: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("***Test failed: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("***Test was skipped: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("***Test was partially succeeded: " + result.getName());
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
        System.out.println("***Test failed due time out: " + result.getName());
    }


    @Override
    public void onFinish(ITestContext context) {
        System.out.println("***Test is completed: " + context.getName());
    }

}
