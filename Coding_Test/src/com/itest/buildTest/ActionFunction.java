package com.itest.buildTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.testng.webElements.Itest_loginPage_Sheet1_Test;
import com.itest.getbean.ReaderElementByExl;
import com.itest.utils.GetBorwser;
import com.itest.utils.SeleniumUtil;


/**
 * 封装所有需要的
 * @author 24431
 *
 */
public class ActionFunction {
  static Logger logger=Logger.getLogger(ActionFunction.class);
  private static WebDriver  driver;
  
  //定义一个存句柄的数组,主要为了点击事件
  private static Set<String> handleSet=new TreeSet<>();
  public  ActionFunction(WebDriver  driver){
    this.driver=driver;
  }
  
  //2.把Action中的动作的方法全部封装起来
  public static void actionFunction(List<TestShepBean> testShepBeans){

      //循环执行用例action
      for(int i = 0;i<testShepBeans.size();i++){
        
        action(testShepBeans.get(i),handleSet);
      }
  }
  
  /**
   * 
   * @param testShepBean
   * @param handleSet
   *        放页面句柄的字符串数据
   */
  public static void action(TestShepBean testShepBean,Set<String> handleSet){
    SeleniumUtil seleniumUtil = new SeleniumUtil(driver);
    switch(testShepBean.getAction()){
      case "打开链接":
       // seleniumUtil.get(testShepBean.getDataTest());
        seleniumUtil.openUrl(testShepBean.getDataTest());
        break;  
      case "点击":       
        seleniumUtil.click(testShepBean,handleSet);
        break;  
      case "输入":           
        seleniumUtil.sendKeys(testShepBean);
        break; 
      case"校验":        
        seleniumUtil.TextContrast(testShepBean);
        break; 
      case "后退":
        seleniumUtil.back();
        break; 
      case "关闭所有页面":
        seleniumUtil.quit();
        break;
      case "关闭当前页面":
        seleniumUtil.close();
        break;
      case "暂停":        
        seleniumUtil.pause(Integer.parseInt(testShepBean.getDataTest()));
        break; 
      case "切换iframe":
        seleniumUtil.inFrame(testShepBean.getWebElementName());
        break;
    }
  }
  
}
