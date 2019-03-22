package test.testng.webElements.codingHome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.itest.utils.SeleniumUtils;

public class CodingHome_Ele {
  WebDriver driver=null;
  SeleniumUtils seleniumUtils=null;
  static int timeOut=5;
  
  public CodingHome_Ele(WebDriver driver){
    this.seleniumUtils=new SeleniumUtils(driver);
    this.driver=driver ;
  }
  
  /**
   * 头像上传按钮
   * @return
   */
  public WebElement  updateHeaderPic(){
    return seleniumUtils.getWebElementByPositioningMethod("xpath",
        "//*[@id=\"app\"]/div/div/div[2]/div/div/div/div[1]/div/div/div/div/img", 
        timeOut, "点击头像上传按钮");
  }
  
  /**
   * 无作品时，去创作按钮
   */
  public WebElement  doing(){
    return seleniumUtils.getWebElementByPositioningMethod("xpath",
        "//*[@id=\"app\"]/div/div/div[2]/div/div/div/div[2]/div/div[1]/a", 
        timeOut, "去创作按钮");
  }
  
}
