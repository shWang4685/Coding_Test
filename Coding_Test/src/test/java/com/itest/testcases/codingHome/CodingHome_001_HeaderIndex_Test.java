package com.itest.testcases.codingHome;

import java.util.Set;
import java.util.TreeSet;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.testng.webElements.codingHome.HeaderIndex_Ele;
import test.testng.webElements.codingHome.LoginIframe_Ele;
import com.itest.utils.GetBorwser;
import com.itest.utils.LogConfiguration;
import com.itest.utils.SeleniumUtils;
import jxl.common.Logger;

/**
 * 官网首页验证
 * 1.课程标签点击
 * 2.校园标签点击
 * 3.立即创作点击
 * 4.登录按钮（要校验已登录和未登录两种情况）
 * @author 24431
 *
 */
public class CodingHome_001_HeaderIndex_Test {

    static Logger logger=Logger.getLogger(CodingHome_001_HeaderIndex_Test.class);
    ITestContext itestContext=null;
    WebDriver driver=null;
    Set<String> handleSet=null;
    SeleniumUtils seleniumUtils=null;
    HeaderIndex_Ele headerIndex_Ele=null;
    LoginIframe_Ele loginIframe_Ele=null;
    
    @BeforeClass
    public void beforeTest(ITestContext itestContext){
      this.driver=new GetBorwser().getWebDriver();
      this.itestContext=itestContext;
      this.seleniumUtils=new SeleniumUtils(driver);
      itestContext.setAttribute("SELENIUM_DRIVER", driver);
      this.headerIndex_Ele=new HeaderIndex_Ele(driver);
      this.loginIframe_Ele=new LoginIframe_Ele(driver);
      //定义一个存句柄的数组,主要为了点击事件
      handleSet=new TreeSet<>();
      LogConfiguration.initLog(this.getClass().getSimpleName());
    }
    
    @Test
    public void HeaderIndex(){
      seleniumUtils.openUrl("https://coding.qq.com/home/");
      //1.点击课程标签
      seleniumUtils.click(headerIndex_Ele.curriculum(), handleSet, "点击官网课程标签");
      //校验是否拉起课程
      seleniumUtils.isTextPresent("精品课程");
      //2.校园标签点击
      seleniumUtils.click(headerIndex_Ele.codingIndex(), handleSet, "点击官网首页标签");
      //校验是否拉起校园
      seleniumUtils.pause(1000);
      seleniumUtils.isTextPresent("腾讯扣叮编程");
      //3.点击校园标签
      seleniumUtils.click(headerIndex_Ele.school(), handleSet, "点击校园标签");
      //校验是否拉起登录页面
      seleniumUtils.pause(1000);
      seleniumUtils.isTextPresent("账号登录");
      //4.点击立即创作按钮
      seleniumUtils.click(headerIndex_Ele.logo(), handleSet, "点击登录页面品牌logo");
      seleniumUtils.pause(1000);
      seleniumUtils.closeOther();//关闭其它窗口
      seleniumUtils.click(headerIndex_Ele.doIt(), handleSet, "点击立即创作按钮");
      seleniumUtils.pause(1000);
      seleniumUtils.isTextPresent("积木代码");
      
      //5.登录标签
      seleniumUtils.click(headerIndex_Ele.logo(), handleSet, "点击游戏实验室页面品牌logo");
      String userName="1507718378";
      String password="laoshizuoren";
      
      qqInputLogin(userName,password);      
      //6.我的作品页拉起
      seleniumUtils.click(headerIndex_Ele.headP(), handleSet, "点击头像");
      seleniumUtils.click(headerIndex_Ele.myWrok(), handleSet, "点击我的作品");
      //校验是否拉起个人中心页面
      seleniumUtils.isTextPresent("我的作品");
      seleniumUtils.pause(1000);
      seleniumUtils.click(headerIndex_Ele.logo(), handleSet, "点击个人中心页面品牌logo");
      seleniumUtils.pause(1000);
      seleniumUtils.click(headerIndex_Ele.headP(), handleSet, "点击头像");
      seleniumUtils.click(headerIndex_Ele.out(), handleSet, "退出登录");
      
      driver.quit();
      
    }
    
    
  /**
   * 官网首页登录
   * @param userName
   *        账号
   * @param password
   *        密码
   */
    public void qqInputLogin(String userName,String password){
      seleniumUtils.click(headerIndex_Ele.login(), handleSet, "点击官网首页登录标签");
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
