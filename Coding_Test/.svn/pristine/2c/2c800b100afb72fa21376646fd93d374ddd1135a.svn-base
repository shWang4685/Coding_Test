package com.itest.testcases;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import com.itest.utils.LogConfiguration;
import org.testng.annotations.Test;
import java.util.List;
import com.itest.buildTest.TestShepBean;
import com.itest.buildTest.ReaderTestByExl;
import com.itest.buildTest.ActionFunction;
import com.itest.utils.GetBorwser;
import org.testng.ITestContext;
import org.openqa.selenium.WebDriver;
import com.itest.utils.SeleniumUtil;


public class CodingHome_003_login_Test  extends GetBorwser{ 

  static Logger logger=Logger.getLogger(CodingHome_003_login_Test.class);
  ITestContext testContext=null;
  WebDriver driver=null;
  @BeforeClass
  public void startTest(ITestContext context){

      this.driver=new GetBorwser().getWebDriver();
      this.testContext=context;
      testContext.setAttribute("SELENIUM_DRIVER",driver);
      LogConfiguration.initLog(this.getClass().getSimpleName());
  }
  @Test
  public void login(){
        List<TestShepBean> testShepBeans=new ReaderTestByExl().readerTestShep("res/testCase/CodingHome.xlsx",3);
        ActionFunction actionFunction=new ActionFunction(driver);
        actionFunction.actionFunction(testShepBeans);
    }
}