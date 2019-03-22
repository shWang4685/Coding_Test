package com.itest.testcases.codingHome;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.itest.utils.GetBorwser;
import com.itest.utils.LogConfiguration;
import com.itest.utils.SeleniumUtil;
import jxl.common.Logger;
import lazy.test.tools.util.asserts.Assert;
/**
 * 验证，拉起个人中心，注销
 * @author 24431
 *
 */
public class CodingHome_003_UserHeader_Test {
    
      static Logger logger=Logger.getLogger(CodingHome_003_UserHeader_Test.class);
      ITestContext itestContext=null;
      WebDriver driver=null;
      
      @BeforeClass
      public void beforeClass(ITestContext itestContext){
        this.itestContext=itestContext;
        this.driver=new GetBorwser().getWebDriver();
        itestContext.setAttribute("SELENIUM_DRIVER", driver);
        LogConfiguration.initLog(this.getClass().getSimpleName());
      }
      
      @Test
      public void header(){
        SeleniumUtil seleniumUtil=new SeleniumUtil(driver);
        //打开官网
        driver.get("https://coding.qq.com/home/");
        driver.manage().window().maximize();
        //点击标签，显示等待
        //elementCheck(driver,By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div[3]/div/a"));
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div[3]/div/a")).click();
        driver.switchTo().frame("qq_login_iframe");
        driver.switchTo().frame("ptlogin_iframe");
       //elementCheck(driver,By.xpath("//*[@id=\"switcher_plogin\"]"));
        driver.findElement(By.xpath("//*[@id=\"switcher_plogin\"]")).click();
        //输入账号密码,登录
        driver.findElement(By.xpath("//*[@id=\"u\"]")).sendKeys("244313089");
        seleniumUtil.pause(1000);
        driver.findElement(By.xpath("//*[@id=\"p\"]")).sendKeys("1qaz@WSX");
        seleniumUtil.pause(1000);
        driver.findElement(By.xpath("//*[@id=\"login_button\"]")).click();
        seleniumUtil.pause(3000); 
        driver.navigate().refresh();
        elementCheck(driver,By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div[3]/div/div/div[1]/span/i"));
        
        seleniumUtil.pause(3000);     
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div[3]/div/div/div[1]/span/i")).click();

        //我的作品点击  
        elementCheck(driver,By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div[3]/div/div/div[2]/a[1]"));
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div[3]/div/div/div[2]/a[1]")).click();
        String homeHandle=driver.getWindowHandle();
        Set<String> allHandle=driver.getWindowHandles();
        for (String s:allHandle){
          if(s.equals(homeHandle)){
            continue;
          }else{
            driver.switchTo().window(s);
            break;
          }
        }
        String url=driver.getCurrentUrl();
        if(url.equals("https://coding.qq.com/personal/#/")){
          logger.info("[进入了个人中心]");
        }else{
          logger.info("[进入个人中心失败了]");
          Assert.fail("[进入个人中心失败了]");
        }
        
        seleniumUtil.pause(1000);
        driver.quit();       
      }
      
    /**
     * 显示等待元素
     * @param driver
     * @param by
     * 
     */
      public static void elementCheck(WebDriver driver,By by){
        try{
          ITestContext itestContext=null;        
          System.out.println("进来等元素");
          WebDriverWait wait=new WebDriverWait(driver,3);
          wait.until(ExpectedConditions.elementToBeClickable(by));         
        }catch(TimeoutException e){
          logger.error("[等待超时]："+by);
          Assert.fail("[等待超时]："+by);
        }

     }
      
      
      
  
}
