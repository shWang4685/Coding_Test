package com.itest.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;



/**
 * 启动浏览器
 * @author 24431
 *
 */
public class GetBorwser {
    static Logger logger=Logger.getLogger(GetBorwser.class);
    static SeleniumUtil seleniumUtil=null;
    
    
    //public static WebDriver driver = getWebDriver();
    //成员变量，传入的 context参数
    
    
    public WebDriver getDriver() {
      return getWebDriver();
    }
   
    public  WebDriver getWebDriver(){
      WebDriver driver = null;
      //读取配置文件
      Properties properties = new Properties();
      try {     
        properties.load(new FileInputStream("./webdriver/config.properties"));
        String browerName = properties.getProperty("auto.test.brower");       
        if ("ie".equals(browerName)) {
            logger.info("[老铁请用谷歌浏览器！]");
        } else if ("chrome".equals(browerName)) {
          System.setProperty("webdriver.chrome.driver", "./webdriver/chromedriver.exe");
          driver = new ChromeDriver();
          
          //seleniumUtil=new SeleniumUtil(driver);
          //http://itest.tencent.com/v2/
          //seleniumUtil.get("http://baidu.com");
        } else if ("firefox".equals(browerName)) {
          logger.info("[老铁请用谷歌浏览器！]");
        }       
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return driver;
    }
    
    
}
