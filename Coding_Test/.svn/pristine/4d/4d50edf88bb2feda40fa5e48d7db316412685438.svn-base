package test.testng.webElements.teacher;


import lazy.test.ui.annotations.Description;
import lazy.test.ui.controls.Text;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.itest.utils.SeleniumUtils;

public class HeaderIndex_Ele {
  static WebDriver driver;
  SeleniumUtils seleniumUtils;
  // 默认构造方法
  public HeaderIndex_Ele(WebDriver driver) {
    // 当前页面、当前对象
    this.seleniumUtils=new SeleniumUtils(driver);
    this.driver = driver;
  }
  
  
  static int timeOut=3;

  /**
   * 官网首页，校园
   */
  public WebElement school(){ 
    
    return seleniumUtils.getWebElementByPositioningMethod("xpath", 
        "//*[@id=\"app\"]/div/div/div/div[1]/div[2]/a[3]"
        ,timeOut,"官网首页，校园标签");        
  }
  
  /**
   * 教师端，导航栏，立即创作按钮
   */
  
  public WebElement doing(){    
    return seleniumUtils.getWebElementByPositioningMethod("xpath",
        "//*[@id=\"app\"]/div/div/div[1]/div[1]/div/a",
        timeOut,"教师端，导航栏，立即创作按钮");        
  }
  
  /**
   * 教师端，导航栏，头像
   */
  public WebElement headP(){
    return seleniumUtils.getWebElementByPositioningMethod("xpath", 
        "//*[@id=\"app\"]/div/div/div[1]/div[1]/div/div[2]/div[2]/div/div/img"
        ,timeOut,"教师端，导航栏，头像");        
  }
  
  /**
   * 教师端，导航栏，我的作品
   */
  public WebElement myWrok(){
    return seleniumUtils.getWebElementByPositioningMethod("xpath",
        "/html/body/div[3]/div/div/a[1]",
        timeOut,"教师端，导航栏，我的作品");        
  }
  
  /** 
   * 教师端，导航栏，退出登录
   */
  public WebElement logOut(){
    return seleniumUtils.getWebElementByPositioningMethod("xpath", 
        "/html/body/div[3]/div/div/a[2]",timeOut,
        "教师端，导航栏，退出登录");        
  }
  
  /**
   * 个人中心回到教师端，个人中心，校园
   */
  public WebElement backCodingHome(){
    return seleniumUtils.getWebElementByPositioningMethod("xpath", 
        "//*[@id=\"app\"]/div/div/div[1]/div/ul/li[3]/a",
        timeOut,"个人中心，校园");        

  }
  /**
   * 从JS页面回到官网首页，JS页面平台logo
   */
  public WebElement backCodingHomeOnDoing(){
    return seleniumUtils.getWebElementByPositioningMethod("xpath", 
        "//*[@id=\"app\"]/div/div[1]/a/img",
        timeOut,"JS页面平台logo");        

  }

}
