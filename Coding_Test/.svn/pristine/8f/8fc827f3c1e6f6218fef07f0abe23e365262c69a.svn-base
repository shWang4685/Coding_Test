package com.itest.testcases;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.itest.buildTest.ActionFunction;
import com.itest.buildTest.ReaderTestByExl;
import com.itest.buildTest.TestShepBean;
import com.itest.utils.GetBorwser;
import com.itest.utils.LogConfiguration;
import com.itest.utils.SeleniumUtil;

public class CodingLogin_Test {
  private static final boolean String = false;
  static Logger logger=Logger.getLogger(CodingLogin_Test.class);
  ITestContext testContext=null;
  WebDriver driver=null;
  private static Set<String> handleSet=new TreeSet<>();
  @BeforeClass
  public void startTest(ITestContext context){

      this.driver=new GetBorwser().getWebDriver();
      this.testContext=context;
      testContext.setAttribute("SELENIUM_DRIVER",driver);
      LogConfiguration.initLog(this.getClass().getSimpleName());
  }
  @Test
  public void HomeClick_001(){
    
      SeleniumUtil seleniumUtil=new SeleniumUtil(driver);
      seleniumUtil.openUrl("https://dev.coding.qq.com/home/#/");
      seleniumUtil.pause(1000);
      System.out.println("sss");
      
      driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div[2]/a[3]")).click();
      String winHandleBefore=driver.getWindowHandle();  
      for(String s:driver.getWindowHandles()){
        
        if (s.equals(winHandleBefore)) {
          continue;
          }
      //如果拉起新的页面，就将句柄定位到该页面
        driver.switchTo().window(s);
        break;          
       } 
      
      seleniumUtil.pause(1000);
      
      driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[1]/div/div[1]/img")).click();
      
      driver.switchTo().frame("_login_frame_quick_");
      driver.switchTo().frame("ptlogin_iframe");

      driver.findElement(By.id("switcher_plogin")).click();;
      
      
    }
}
