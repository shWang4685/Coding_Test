package com.itest.testcases.bean;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.itest.utils.SeleniumUtil;

public class LoginBean {
    private static String codingHomeHandle;
    private static String newHandle;

    
    public static String getCodingHomeHandle() {
      return codingHomeHandle;
    }

    public static String getNewHandle() {
      return newHandle;
    }

    public LoginBean(){
      
    }
    /**
     * 老师登录
     * @param driver
     */
    public static void teacherLogin(WebDriver driver){
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
      seleniumUtil.pause(5000);

      codingHomeHandle=driver.getWindowHandle();
      //点击校园标签，查看能否拉起校园模块，验证登录是否成功使用
      driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div[2]/a[3]")).click();
      Set<String> allHandle=driver.getWindowHandles();
      for (String s:allHandle){
        if(s.equals(codingHomeHandle)){
          continue;
        }else{
          newHandle=s;
          driver.switchTo().window(s);
          break;
        }
      } 
    }
    
    /**
     * 学生登录
     * @param driver
     */
    public static void studentLogin(WebDriver driver){
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
      seleniumUtil.pause(1000);
      
      String homeHandle=driver.getWindowHandle();
      //点击校园标签，查看能否拉起校园模块，验证登录是否成功使用
      driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div[2]/a[3]")).click();
      Set<String> allHandle=driver.getWindowHandles();
      for (String s:allHandle){
        if(s.equals(homeHandle)){
          continue;
        }else{
          newHandle=s;
          driver.switchTo().window(s);
          break;
        }
      } 
    }
}
