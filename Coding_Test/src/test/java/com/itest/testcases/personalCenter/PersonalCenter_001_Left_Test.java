package com.itest.testcases.personalCenter;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.TreeSet;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.testng.webElements.codingHome.CodingHome_Ele;
import test.testng.webElements.codingHome.HeaderIndex_Ele;
import test.testng.webElements.teacher.LeftHelp_Ele;
import com.itest.testcases.codingHome.CodingHome_001_HeaderIndex_Test;
import com.itest.utils.GetBorwser;
import com.itest.utils.LogConfiguration;
import com.itest.utils.LoginCookie;
import com.itest.utils.RobotUtil;
import com.itest.utils.SeleniumUtils;

/**
 * 个人中心操作
 * 1.修改头像
 * @author 24431
 * 继承RobotUtil帮助类（鼠标键盘事件）
 *
 */
public class PersonalCenter_001_Left_Test extends RobotUtil{

  static Logger logger=Logger.getLogger(CodingHome_001_HeaderIndex_Test.class);
  ITestContext itestContext=null;
  WebDriver driver=null;
  Set<String> handleSet=null;
  SeleniumUtils seleniumUtils=null;
  CodingHome_Ele codingHome_Ele=null;
  HeaderIndex_Ele headerIndex_Ele=null;
  
  @BeforeClass
  public void beforeTest(ITestContext itestContext){
    this.itestContext=itestContext;    
    this.driver=new GetBorwser().getWebDriver();
    itestContext.setAttribute("SELENIUM_DRIVER", driver);
    this.seleniumUtils=new SeleniumUtils(driver);
    this.codingHome_Ele=new CodingHome_Ele(driver);
    this.headerIndex_Ele=new HeaderIndex_Ele(driver);
    //定义一个存句柄的数组,主要为了点击事件
    handleSet=new TreeSet<>();
    LogConfiguration.initLog(this.getClass().getSimpleName());
  }
  
  @Test
  public void leftHelp(){
    //自动登录
    LoginCookie loginCookie=new LoginCookie();
    logger.info("开始添加登录cookie");
    loginCookie.getCookie(driver);
    //1.我的作品页拉起
    seleniumUtils.click(headerIndex_Ele.headP(), handleSet, "点击头像");
    seleniumUtils.click(headerIndex_Ele.myWrok(), handleSet, "点击我的作品"); 
    seleniumUtils.pause(1000);    

    //复制，粘贴
    
    //Actions action=new Actions(driver);
    updateHeaderImg();
    //判断是否有作品
    if(seleniumUtils.checkBodyText("你还没有创作作品噢，创作一番吧")){
      seleniumUtils.click(codingHome_Ele.doing(), handleSet, "无作品时，点击创作按钮");
      seleniumUtils.checkBodyText("动画");
    }else{
      
    }
            
  }
  
  
  public void updateHeaderImg(){
    
    //获得老图片的图片地址
    String oldImgUrl=codingHome_Ele.updateHeaderPic().getAttribute("src");
    seleniumUtils.click(codingHome_Ele.updateHeaderPic(), handleSet, "修改头像");
    seleniumUtils.pause(2000);
    //复制，粘贴
    setAndctrlVClipboardData("1.png");
    //enter 键盘
    pressEnterKey();
    //获得新的头像图片地址
    seleniumUtils.pause(2000);   
    String newImgUrl=codingHome_Ele.updateHeaderPic().getAttribute("src");
    if(!oldImgUrl.equals(newImgUrl)){
      logger.info("修改头像成功");
    }else{
      logger.error("修改头像失败，请检查一下是不是上传的是同一张照片，如果是更换照片");
      Assert.fail("修改头像失败");
    }
        
  }
}
