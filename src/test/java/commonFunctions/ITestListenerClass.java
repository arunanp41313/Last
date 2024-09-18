package commonFunctions;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerClass implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("---Test method Started---");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("---Test method Successed---");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("---Test method Failed---");
		try {
			TakeScreenshot.myTakeScreenshot("//"+"FailedTestCase"+"//"+result.getTestContext().getName()+"_"+result.getMethod().getMethodName()+".png");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("---Test method Skipped---");
	}

//	@Override
//	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("---Test method Failed due to Timeout---");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("---Test method OnStart---");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("---Test method OnFinish---");
	}

}
