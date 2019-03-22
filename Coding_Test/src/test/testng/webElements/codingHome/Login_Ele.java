package test.testng.webElements.codingHome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.itest.utils.SeleniumUtils;

/**
 * 登录页面
 * @author 24431
 *
 */
public class Login_Ele {
  WebDriver driver =null;
  SeleniumUtils seleniumUtils=null;
  static int timeOut=5;
  
  public Login_Ele(WebDriver driver){
    this.driver=driver;
    seleniumUtils =new SeleniumUtils(driver);    
  }
  
  /**
   * 登录页面，qq登录按钮
   * @return
   */
  public WebElement qqLoginBtn(){
    return seleniumUtils.getWebElementByPositioningMethod("xpath",
        "//*[@id=\"app\"]/div/div[2]/div/div/div[1]/div/div[1]", 
        timeOut, "登录页面，qq登录按钮");
  }
  
  /**
   * 登录页面，班级码输入框
   * @return
   */
  public WebElement classInput(){  
    return seleniumUtils.getWebElementByPositioningMethod("xpath",
        "//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div/input", 
        timeOut, "登录页面，班级码输入框");
  }
  
  /**
   * 登录页面，加入班级按钮
   * @return
   */
  public WebElement joinBtn(){  
    return seleniumUtils.getWebElementByPositioningMethod("xpath",
        "//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div/a", 
        timeOut, "登录页面，加入班级按钮");
  }
  

  /**
   * 登录页面，班级码输入错误提示p
   * @return
   */
  public WebElement errorClassInput(){
    return seleniumUtils.getWebElementByPositioningMethod("xpath",
        "//*[@id=\"app\"]/div/div[2]/div/div/div[3]/p", 
        timeOut, "登录页面，班级码输入错误提示p");
  }
  
  /**
   * 登录页面，立即创作按钮
   * @return
   */
  public WebElement doing(){
    return seleniumUtils.getWebElementByPositioningMethod("xpath",
        "//*[@id=\"app\"]/div/div[1]/div/a", 
        timeOut, "登录页面，班级码输入错误提示p");
  }
}
