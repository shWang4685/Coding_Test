package com.itest.assertion;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import com.itest.utils.GetBorwser;

  
/**
 * 用例执行断言监听
 * @author 24431
 *
 */
public class AssertionListener extends TestListenerAdapter {
    static Logger logger=Logger.getLogger(AssertionListener.class); 
    /**
     * 用例执行开始 提示
     * @param tr
     */
    @Override
    public void onTestStart(ITestResult tr){

      VerifyElement.flag = true;
      VerifyElement.errors.clear();
        //获得执行的测试用例类名
        String className=tr.getTestClass().getRealClass().getSimpleName().trim();
        //获得执行的测试用例类中 的方法
        String testMethodName = tr.getMethod().getMethodName();
        logger.info("开始执行["+className+"]"+"中["+testMethodName+"]");
        System.out.println("开始执行["+className+"]"+"中["+testMethodName+"]");
    }
    

    @Override
    public void onTestFailure(ITestResult tr) {
      // 失败时截一个图
      captureScreen(tr);

      this.handleAssertion(tr);
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
      // 失败时截一个图
      captureScreen(tr);

      this.handleAssertion(tr);
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
      this.handleAssertion(tr);
    }

    @Override
    public void onFinish(ITestContext testContext) {
      logger.info("用例结束");
      super.onFinish(testContext);
    }

    private int index = 0;

    // 用来处理Verify验证结果失败时，标记用例结果为Failure，但是不停止执行。
    private void handleAssertion(ITestResult tr) {
      if (!VerifyElement.flag) {
        Throwable throwable = tr.getThrowable();
        if (throwable == null) {
          throwable = new Throwable();
        }
        StackTraceElement[] traces = throwable.getStackTrace();
        StackTraceElement[] alltrace = new StackTraceElement[0];
        for (Error e : VerifyElement.errors) {
          StackTraceElement[] errorTraces = e.getStackTrace();
          StackTraceElement[] et = this.getKeyStackTrace(tr, errorTraces);
          StackTraceElement[] message =
              new StackTraceElement[] {new StackTraceElement("message : " + e.getMessage()
                  + " in method : ", tr.getMethod().getMethodName(), tr.getTestClass().getRealClass()
                  .getSimpleName(), index)};
          index = 0;
          alltrace = this.merge(alltrace, message);
          alltrace = this.merge(alltrace, et);
        }
        if (traces != null) {
          traces = this.getKeyStackTrace(tr, traces);
          alltrace = this.merge(alltrace, traces);
        }
        throwable.setStackTrace(alltrace);
        tr.setThrowable(throwable);
        VerifyElement.flag = true;
        VerifyElement.errors.clear();
        tr.setStatus(ITestResult.FAILURE);
      }
    }

    private StackTraceElement[] getKeyStackTrace(ITestResult tr, StackTraceElement[] errorTraces) {
      List<StackTraceElement> ets = new ArrayList<StackTraceElement>();
      for (StackTraceElement stackTraceElement : errorTraces) {
        if (stackTraceElement.getClassName().equals(tr.getTestClass().getName())) {
          ets.add(stackTraceElement);
          index = stackTraceElement.getLineNumber();
        }
      }
      StackTraceElement[] et = new StackTraceElement[ets.size()];
      for (int i = 0; i < et.length; i++) {
        et[i] = ets.get(i);
      }
      return et;
    }

    private StackTraceElement[] merge(StackTraceElement[] traces1, StackTraceElement[] traces2) {
      StackTraceElement[] ste = new StackTraceElement[traces1.length + traces2.length];
      for (int i = 0; i < traces1.length; i++) {
        ste[i] = traces1[i];
      }
      for (int i = 0; i < traces2.length; i++) {
        ste[traces1.length + i] = traces2[i];
      }
      return ste;
    }

    private void captureScreen(ITestResult tr) {
      try {
        GetBorwser browser = (GetBorwser) tr.getInstance();

        WebDriver driver = browser.getDriver();

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); // 将截取的图片以文件的形式返回

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd.HH时mm分ss秒");
        String dateTime = simpleDateFormat.format(new Date()); // 显示的格式

        String className = tr.getTestClass().getRealClass().getSimpleName().trim();

        String testMethodName = tr.getMethod().getMethodName();

        String fileSavePath = ".\\screenShot\\";
        String fileName = dateTime + className + "_" + testMethodName + "执行失败" + ".png";

        org.apache.commons.io.FileUtils.copyFile(srcFile, new File(fileSavePath + fileName)); // 使用copyFile()方法保存获取到的截图文件

        // 设置reportNG参数，在html报告中显示链接和图片
        System.setProperty("org.uncommons.reportng.escape-output", "false");

        // Link
        Reporter.log("<a href=./../../../screenShot/" + fileName
            + " target=_blank>testFailed ScreenShot</a>", true);

        // Img
        Reporter.log("<img src=./../../../screenShot/" + fileName + " /img>", true);

      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (ClassCastException e) {
        logger.info("出现了异常'java.lang.ClassCastException',请把类继承于这个类userMothod.Browser,可以解决问题。");
        e.printStackTrace();
      }

    }

    
}
