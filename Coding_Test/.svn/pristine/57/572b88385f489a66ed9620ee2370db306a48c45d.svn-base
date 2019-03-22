package test.testng.webElements.codingHome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.itest.utils.SeleniumUtils;

/**
 * 登录Iframe
 * @author 24431
 *
 */
public class LoginIframe_Ele {
  WebDriver driver;
  SeleniumUtils seleniumUtils;
  static int timeOut=5;
  
  public LoginIframe_Ele(WebDriver driver){
    this.driver=driver;
    seleniumUtils=new SeleniumUtils(driver);   
  }
  
  
  /**
   * 登录iframe 账号输入Input
   * @return
   */
  public WebElement userNameInput(){
    return seleniumUtils.getWebElementByPositioningMethod("xpath", 
        " //*[@id=\"u\"]"
        ,timeOut,"登录页面，品牌logo"); 
  }
  
  /**
   * 登录iframe，密码输入input
   * @return
   */
  public WebElement passwordInput(){
    return seleniumUtils.getWebElementByPositioningMethod("xpath", 
        "//*[@id=\"p\"]"
        ,timeOut,"登录iframe，密码输入input"); 
  }
  

  /**
   * 登录iframe，登录按钮
   * @return
   */
  public WebElement logBtn(){
    return seleniumUtils.getWebElementByPositioningMethod("xpath", 
        "//*[@id=\"login_button\"]"
        ,timeOut,"登录iframe，登录按钮"); 
  }
}
