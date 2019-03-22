package com.itest.testcases;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.itest.utils.LogConfiguration;
import org.testng.annotations.Test;
import java.util.List;
import com.itest.buildTest.TestShepBean;
import com.itest.buildTest.ReaderTestByExl;
import com.itest.buildTest.ActionFunction;
import com.itest.utils.GetBorwser;
import org.testng.ITestContext;
import com.itest.utils.SeleniumUtil;


public class ItestLogin_002_LoginSucessFuction_001_Test{ 
  
  static Logger logger=Logger.getLogger(ItestLogin_002_LoginSucessFuction_001_Test.class);
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
  public void LoginSucessFuction_001(){
        List<TestShepBean> testShepBeans=new ReaderTestByExl().readerTestShep("res/testcase/ItestLogin.xlsx",2);
        ActionFunction actionFunction=new ActionFunction(driver);
        actionFunction.actionFunction(testShepBeans);
    }
  @AfterClass
  public void afterTest(){
    SeleniumUtil seleniumUtil=new SeleniumUtil(driver);
    seleniumUtil.quit();
  }
}