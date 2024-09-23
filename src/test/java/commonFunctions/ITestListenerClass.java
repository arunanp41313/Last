package commonFunctions;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerClass implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("---@Test  Started---");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("---@Test  Successed---");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("---@Test Failed---");
		try {
			TakeScreenshot.myTakeScreenshot("//"+"FailedTestCase"+"//"+result.getTestContext().getName()+"_"+result.getMethod().getMethodName()+".png");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("---@Test Skipped---");
	}

//	@Override
//	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("---@Test Failed due to Timeout---");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("---Test OnStart---");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("---Test OnFinish---");
	}

}
