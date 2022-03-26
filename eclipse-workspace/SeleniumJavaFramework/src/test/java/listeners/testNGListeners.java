package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class testNGListeners implements ITestListener {

	public void onTestSuccess(ITestResult result) {
		System.out.println("Testing is successfully completed.");
	}
	
	public void onTestFail(ITestResult result) {
		System.out.println("Testing is failed.");
	}
	
	public void onTestStart(ITestResult result) {
		System.out.println("Testing is started.");
	}
	
	public void onFinish(ITestContext context) {
		System.out.println("Testing is completed.");
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("Testing is skipped.");
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Testing is xxxx.");
	}
}
