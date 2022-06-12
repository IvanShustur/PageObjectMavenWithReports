package selenium.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class RozetkaTestListener implements ITestListener {
    private static final Logger logger = LogManager.getLogger(RozetkaTestListener.class);

    @Override
    public void onTestStart(ITestResult iTestResult) {
        logger.info("Test was started");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logger.info("Test successfully passed");

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        logger.info("Test failed");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        logger.info("Test was skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
       logger.info("The test is finished");
    }
}