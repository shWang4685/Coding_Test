package test.testng.webElements.codingHome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.itest.utils.SeleniumUtils;

/**
 * 官网首页
 * @author 24431
 *
 */
public class HeaderIndex_Ele {
  WebDriver driver;
  SeleniumUtils seleniumUtils;
  static int timeOut=5;
  
  public HeaderIndex_Ele(WebDriver driver){
    this.driver=driver;
    seleniumUtils=new SeleniumUtils(driver);   
  }
  

  /**
   * 官网，首页标签
   */
  public WebElement codingIndex(){     
    if(driver.getCurrentUrl().contains("/lesson")){
      return seleniumUtils.getWebElementByPositioningMethod("xpath", 
          "//*[@id=\"app\"]/div/div/div[1]/div[2]/a[1]"
          ,timeOut,"官网，首页标签");   
    }
    return seleniumUtils.getWebElementByPositioningMethod("xpath", 
        "//*[@id=\"app\"]/div/div/div/div[1]/div[2]/a[1]"
        ,timeOut,"官网，首页标签");   
  }
  

  /**
   * 官网，课程标签
   */
  public WebElement curriculum(){     
    return seleniumUtils.getWebElementByPositioningMethod("xpath", 
        "//*[@id=\"app\"]/div/div/div/div[1]/div[2]/a[2]"
        ,timeOut,"官网，课程标签");   
  }
  

  /**
   * 官网，校园标签
   */
  public WebElement school(){     
    return seleniumUtils.getWebElementByPositioningMethod("xpath", 
        "//*[@id=\"app\"]/div/div/div/div[1]/div[2]/a[3]"
        ,timeOut,"官网，校园标签");   
  }

  /**
   * 官网，立即创作按钮
   */
  public WebElement doIt(){     
    return seleniumUtils.getWebElementByPositioningMethod("xpath", 
        "//*[@id=\"app\"]/div/div/div/div[1]/a"
        ,timeOut,"官网，立即创作按钮");   
  }
  
  /**
   * 官网，登录标签
   */
  public WebElement login(){     
    return seleniumUtils.getWebElementByPositioningMethod("xpath", 
        "//*[@id=\"app\"]/div/div/div/div[1]/div[3]/div/a"
        ,timeOut,"官网，登录标签");   
  }
  

  /**
   * 官网，登录后的头像
   */
  public WebElement headP(){     
    return seleniumUtils.getWebElementByPositioningMethod("xpath", 
        "//*[@id=\"app\"]/div/div/div/div[1]/div[3]/div/div/div/img"
        ,timeOut,"官网，头像");   
  }
  
  /**
   * 官网，登录后头像展示框，我的作品标签
   */
  public WebElement myWrok(){
    return seleniumUtils.getWebElementByPositioningMethod("xpath", 
        "/html/body/div[2]/div/div/a[1]"
        ,timeOut,"官网，我的作品标签");   
  }
  
  /**
   * 官网，登录后头像展示框，退出品标签
   * @return
   */
  public WebElement out(){
    return seleniumUtils.getWebElementByPositioningMethod("xpath", 
        "/html/body/div[2]/div/div/a[2]"
        ,timeOut,"官网，退出品标签");   
  }
  
  /**
   * 登录页面/游戏实验室，coding logo
   */

  public WebElement logo(){
    System.out.println("login:"+driver.getCurrentUrl());
    if(driver.getCurrentUrl().contains("game-lab/")){
      return seleniumUtils.getWebElementByPositioningMethod("xpath", 
          "//*[@id=\"app\"]/div/div[1]/a"
          ,timeOut,"JS实验室，品牌logo");   
    }
    if(driver.getCurrentUrl().contains("/personal")){   
      return seleniumUtils.getWebElementByPositioningMethod("xpath",         
          "//*[@id=\"app\"]/div/div/div[1]/div/div[1]/a"
          ,timeOut,"个人中心页面，品牌logo");   
    }
    return seleniumUtils.getWebElementByPositioningMethod("xpath", 
        "//*[@id=\"app\"]/div/div[1]/div/div[1]/a"
        ,timeOut,"登录页面，品牌logo");   
  }
  
  /**
   * 登录窗口，账号密码输入登录标签
   */
  public WebElement qqInputA(){
  
    return seleniumUtils.getWebElementByPositioningMethod("xpath", 
        "//*[@id=\"switcher_plogin\"]"
        ,timeOut,"登录窗口，账号密码输入登录标签"); 
  }

}
