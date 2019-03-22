package com.itest.testcases.teacher;

import java.util.Set;
import java.util.TreeSet;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.testng.webElements.teacher.HeaderIndex_Ele;
import com.itest.utils.GetBorwser;
import com.itest.utils.LogConfiguration;
import com.itest.utils.LoginCookie;
import com.itest.utils.SeleniumUtils;

/**
 * 教师端顶部导航栏功能测试
 * 测试项：
 * 1.用户头像的点击
 * 2.用户个人中心点击
 * 3.用户退出
 * 4.立即创作按钮
 * @author 24431
 *
 */
public class TeacherHome_001_HeaderIndex_Test {
  
    static Logger logger=Logger.getLogger(TeacherHome_001_HeaderIndex_Test.class);
    ITestContext itestContext=null;
    WebDriver driver=null;
    Set<String> handleSet=null;
    @BeforeClass
    public void beforeTest(ITestContext itestContext){
      this.driver=new GetBorwser().getWebDriver();
      this.itestContext=itestContext;
      itestContext.setAttribute("SELENIUM_DRIVER", driver);
      //定义一个存句柄的数组,主要为了点击事件
      handleSet=new TreeSet<>();
      LogConfiguration.initLog(this.getClass().getSimpleName());
    }
    
    @Test
    public void headerIndex(){     
      SeleniumUtils seleniumUtils=new SeleniumUtils(driver);      
      HeaderIndex_Ele headerInderElm=new HeaderIndex_Ele(driver);
      
      //自动登录
      LoginCookie loginCookie=new LoginCookie();
      logger.info("开始添加登录cookie");
      loginCookie.getCookie(driver); 

      //官网首页点击校园标签      
      seleniumUtils.click(headerInderElm.school(), handleSet,"官网首页校园标签");
      //教师端首页，点击头像
      seleniumUtils.click(headerInderElm.headP(), handleSet,"教师端首页头像");
      //教师端首页，点击个人中心
      seleniumUtils.click(headerInderElm.myWrok(), handleSet,"教师端首页个人中心");
      //从个人中心，回到教师端首页
      seleniumUtils.click(headerInderElm.backCodingHome(), handleSet, "个人中心校园");
      //关闭其它窗口
      seleniumUtils.closeOther();
      //教师端首页，点击立即创作
      seleniumUtils.click(headerInderElm.doing(), handleSet, "教师端首页立即创作");
      //校验是否拉起IDE
      seleniumUtils.isTextPresent("动画");
      
      
      //从JS页面，回到教师端首页
      seleniumUtils.click(headerInderElm.backCodingHomeOnDoing(), handleSet, "个人中心校园");
      //官网首页点击校园标签      
      seleniumUtils.click(headerInderElm.school(), handleSet,"官网首页校园标签");
      //教师端首页，点击头像
      seleniumUtils.click(headerInderElm.headP(), handleSet,"教师端首页头像");
      //退出教师客户端
      seleniumUtils.click(headerInderElm.logOut(), handleSet,"教师端退出登录" );
      //校验退出是否成功
      seleniumUtils.isTextPresent("账号登录");
      driver.quit();
    }
}
