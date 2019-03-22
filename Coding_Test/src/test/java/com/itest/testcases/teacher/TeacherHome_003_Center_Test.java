package com.itest.testcases.teacher;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import jxl.common.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.testng.webElements.teacher.CenterClass_Ele;
import test.testng.webElements.teacher.CenterCurriculum_Ele;
import test.testng.webElements.teacher.HeaderIndex_Ele;
import test.testng.webElements.teacher.LeftHelp_Ele;
import com.itest.testcases.bean.LoginBean;
import com.itest.utils.GetBorwser;
import com.itest.utils.LogConfiguration;
import com.itest.utils.LoginCookie;
import com.itest.utils.SeleniumUtil;
import com.itest.utils.SeleniumUtils;

/**
 * 教师端首页中心布局验证
 * 测试项：
 * 1.我的课程展示及点击拉起
 * 2.课程资源展示及点击拉起
 * 3.未创建班级情况下，我的课程布局区 “创建班级”按钮
 * @author 24431
 *
 */
public class TeacherHome_003_Center_Test {
  static Logger logger=Logger.getLogger(TeacherHome_002_LeftHelp_Test.class);
  WebDriver driver=null;
  ITestContext itestContext=null;
  Set<String> handleSet=null;
  CenterCurriculum_Ele centerCurriculum=null;
  SeleniumUtils seleniumUtils=null;
  
  @BeforeClass
  public void  teacherHome_003_center_Test(ITestContext itestContext){
    this.itestContext=itestContext;
    this.driver=new GetBorwser().getWebDriver();
    itestContext.setAttribute("SELENIUM_DRIVER", driver);
    LogConfiguration.initLog(this.getClass().getSimpleName());   
    this.handleSet=new TreeSet<>();
    this.centerCurriculum=new CenterCurriculum_Ele(driver);
    this.seleniumUtils=new SeleniumUtils(driver); 
  }
  @Test
  public void LeftHelp(){
    SeleniumUtil seleniumUtil=new SeleniumUtil(driver);
    HeaderIndex_Ele headerInderElm=new HeaderIndex_Ele(driver);
    LeftHelp_Ele leftHelp_Ele=new LeftHelp_Ele(driver);
    //自动登录
    LoginCookie loginCookie=new LoginCookie();
    loginCookie.getCookie(driver);
    //1.官网首页点击校园标签      
    seleniumUtils.click(headerInderElm.school(), handleSet,"官网首页校园标签");
    //2.校验页面中心是否展示 课程中心内容  
  
    if(seleniumUtils.checkBodyText("你当前没有在授课")){
      //没有创建一个班级时候，课程中心点击创建按钮创建班级
      buildClass("建一个班级","python编程基础与应用",leftHelp_Ele);
      //点击左侧导航，我的课程
      seleniumUtils.click(leftHelp_Ele.curriculumCenter(), handleSet, "课程中心");
      //1.点击班级课程
      seleniumUtils.click(centerCurriculum.myCurriculumOne(), handleSet, "我的课程展示tab");
      //2.判断是否拉起课程详情页
      seleniumUtils.pause(1000);
      seleniumUtils.isTextPresent("前言");
      //3.回到首页
      seleniumUtils.back();         
    }else{
      //点击左侧导航，我的课程
      seleniumUtils.click(leftHelp_Ele.curriculumCenter(), handleSet, "课程中心");
      checkMyCurriculum(centerCurriculum.myCurriculums());     
    }
    //课程资源
    checkCurriculumResources(centerCurriculum.curriculumResources());  
    driver.quit();
  }
  
  
  
  
  /**
   * 教师没有创建任何班级时，点击课程中心中 创建班级按钮
   * @param className
   * @param CurriculumName
   * @param leftHelp_Ele
   */
  public void buildClass(String className,String CurriculumName,LeftHelp_Ele leftHelp_Ele){
    seleniumUtils.click(centerCurriculum.bulidClassCenter(), handleSet, "点击课程中心，班级创建按钮");
    
    seleniumUtils.sendKeys(leftHelp_Ele.classNameInput(6), className);
    
    seleniumUtils.click(leftHelp_Ele.selectCurriculumInput(6), handleSet, "创建班级窗口，课程选择框");
    //查看下拉框中是否有某课程，有就创建，没有就提出错误
    boolean bool=false;    
    WebElement webCurriculum=null;

    for(WebElement web:leftHelp_Ele.allCurriculum(6)){   
      if(web.getText().trim().contains(CurriculumName)){ 
        logger.info("有["+CurriculumName+"]这门课程");
        webCurriculum=web;
        bool=true;
        break;
      }       
    } 
    if(bool){
      webCurriculum.click();
    }else{
      logger.error("无["+CurriculumName+"]这门课程,不能选中，请检查创建的课程名称参数");
      Assert.fail("无["+CurriculumName+"]这门课程,不能选中，请检查创建的课程名称参数");
    }
    seleniumUtils.click(leftHelp_Ele.confirmBuildClass(6), handleSet, "确认创建班级");       
    //因创建班级，页面构造发生了变化
    driver.navigate().refresh(); 
    seleniumUtils.pause(1000);
  }
  
  /**
   * 挨个点击课程资源
   * @param webs
   */
  public void checkCurriculumResources(List<WebElement> webs){
    for(int i=1;i<=webs.size();i++){
      seleniumUtils.click(centerCurriculum.curriculumResource(i), handleSet, "检车课程资源能否点击");
      seleniumUtils.pause(1000);
      seleniumUtils.isTextPresent("第");
      seleniumUtils.back();
      seleniumUtils.pause(1000);
    }
  }
  
  /**
   * 挨个遍历点击我的课程
   * @param webs
   */
  public void checkMyCurriculum(List<WebElement> webs){
     for(int i=1;i<=webs.size();i++){
       seleniumUtils.click(centerCurriculum.myCurriculum(i), handleSet, "检车我的课程能否点击");
       seleniumUtils.pause(1000);
       seleniumUtils.isTextPresent("第");
       seleniumUtils.back();
       seleniumUtils.pause(1000);
     }
    
  }
}
