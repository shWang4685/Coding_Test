package com.itest.testcases.codingHome;

import java.util.Set;
import java.util.TreeSet;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.testng.webElements.codingHome.HeaderIndex_Ele;
import test.testng.webElements.codingHome.LoginIframe_Ele;
import test.testng.webElements.codingHome.Login_Ele;
import com.itest.utils.GetBorwser;
import com.itest.utils.LogConfiguration;
import com.itest.utils.SeleniumUtils;

public class CodingHome_002_Login_Test {

  static Logger logger=Logger.getLogger(CodingHome_002_Login_Test.class);
  ITestContext itestContext=null;
  WebDriver driver=null;
  Set<String> handleSet=null;
  SeleniumUtils seleniumUtils=null;
  LoginIframe_Ele loginIframe_Ele=null;
  Login_Ele login_Ele=null;
  HeaderIndex_Ele headerIndex_Ele=null;
  
  @BeforeClass
  public void  beforeTest(ITestContext itestContext){
    this.driver=new GetBorwser().getWebDriver();
    this.itestContext=itestContext;
    itestContext.setAttribute("SELENIUM_DRIVER", driver);
    this.loginIframe_Ele=new LoginIframe_Ele(driver);
    this.headerIndex_Ele=new HeaderIndex_Ele(driver);
    this.login_Ele=new Login_Ele(driver);
    this.seleniumUtils=new SeleniumUtils(driver);
    //定义一个存句柄的数组,主要为了点击事件
    handleSet=new TreeSet<>();
    LogConfiguration.initLog(this.getClass().getSimpleName());
  }
  
  @Test
  public void  loginPage(){

    seleniumUtils.openUrl("https://coding.qq.com/");
    String userName="1507718378";
    String password="laoshizuoren";
    //1.点击校园标签
    seleniumUtils.click(headerIndex_Ele.school(), handleSet, "点击校园标签");
    
    //输入错误班级码，验证是否头提示
    seleniumUtils.click(login_Ele.classInput(), handleSet, "点击班级码输入框");
    seleniumUtils.sendKeys(login_Ele.classInput(), "xxxxx");
    seleniumUtils.click(login_Ele.joinBtn(), handleSet, "点击进入按钮");
    if(!seleniumUtils.isDisplayed(login_Ele.errorClassInput())){
      Assert.fail("输入了错误的班级码，但没有提示");
    }
    
    //2.点击qq登录按钮
    seleniumUtils.click(login_Ele.qqLoginBtn(), handleSet, "qq登录按钮");
    qqInputLogin(userName,password);
    //验证登录是否成功
   // driver.navigate().refresh();
    seleniumUtils.pause(1000);
    seleniumUtils.isTextPresent("深圳明德实验学校");
    
    
  }
  
  
  
  /**
   * 官网首页登录
   * @param userName
   *        账号
   * @param password
   *        密码
   */
  public void qqInputLogin(String userName,String password){
    seleniumUtils.inFrame("qq_login_iframe");
    seleniumUtils.inFrame("ptlogin_iframe");
    seleniumUtils.click(headerIndex_Ele.qqInputA(), handleSet, "登录窗口，qq账号密码输入登录标签");
    
    seleniumUtils.click(loginIframe_Ele.userNameInput(), handleSet, "qq登录账号输入框");
    seleniumUtils.sendKeys(loginIframe_Ele.userNameInput(), userName);
    seleniumUtils.click(loginIframe_Ele.passwordInput(), handleSet, "qq登录，密码输入框");
    seleniumUtils.sendKeys(loginIframe_Ele.passwordInput(), password);
    seleniumUtils.click(loginIframe_Ele.logBtn(), handleSet, "qq登录，登录按钮");
    
  }
}
