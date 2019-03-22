package test.testng.webElements.teacher;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.itest.utils.SeleniumUtils;

/**
 * 教师端首页，班级
 * @author 24431
 *
 */
public class CenterClass_Ele {
  WebDriver driver;
  SeleniumUtils seleniumUtils;
  
  
  public CenterClass_Ele(WebDriver driver){
    this.driver=driver;
    seleniumUtils=new SeleniumUtils(driver);
  }
  

}
