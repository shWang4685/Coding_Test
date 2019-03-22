package com.itest.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.itest.utils.GetBorwser;
import com.itest.utils.LogConfiguration;
import com.itest.utils.SeleniumUtil;

public class CodingHome_001_login_Test{
    static Logger logger=Logger.getLogger(CodingHome_001_login_Test.class);
    //设置上下文
    ITestContext testContext=null;
    WebDriver driver=null;
    
    @BeforeClass
    public void startClass(ITestContext iTestContext){
      this.testContext=iTestContext;
      driver=new GetBorwser().getDriver();
      //将浏览器驱动放入ITestContext 上下文中
      testContext.setAttribute("SELENIUM_DRIVER", driver);
      //初始化log4j日志配置
      LogConfiguration.initLog(this.getClass().getSimpleName());
    }
    @Test
    public void checkInfo(){
      SeleniumUtil seleniumUtil=new SeleniumUtil(driver);
      //打开浏览器
      seleniumUtil.openUrl("https://dev.coding.qq.com/home/#/");
      //*[@id="app"]/div/div/div/div[4]/div[1]/div[2]/div[1]
      By testBy=By.xpath("//*[@id=\"app\"]/div/div/div/div[4]/div[1]/div[2]/div[1]");
      WebElement webElement=driver.findElement(testBy);
      webElement.getText();
      // seleniumUtil.isDisplayed(webElement);
      seleniumUtil.isTextPresent("携手创造孩子未来");

    }
    
      
      
}
