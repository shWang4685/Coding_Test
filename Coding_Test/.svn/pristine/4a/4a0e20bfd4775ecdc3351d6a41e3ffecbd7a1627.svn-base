package test.testng.webElements.teacher;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.itest.utils.SeleniumUtils;

/**
 * 教师端center /课程显示
 * @author 24431
 *
 */
public class CenterCurriculum_Ele {
  WebDriver driver;
  SeleniumUtils seleniumUtils;
  static int timeOut=5;
  
  public CenterCurriculum_Ele(WebDriver driver){
    this.driver=driver;
    seleniumUtils=new SeleniumUtils(driver);   
  }
  
  /**
   * 教师端，课程中心
   */
  public WebElement curriculumCenter(){     
    return seleniumUtils.getWebElementByPositioningMethod("xpath", 
        "//*[@id=\"app\"]/div/div/div[1]/div[2]/div/div/ul/li[1]/span/a"
        ,timeOut,"教师端，课程中心");        
  }
  
  /**
   * 课程详情页，我的课程 文案
   *
   * 
   */
  public WebElement myCourseOnCenter(){     
    return seleniumUtils.getWebElementByPositioningMethod("xpath", 
        "//*[@id=\"app\"]/div/div/div[1]/div[3]/div/div/h2"
        ,timeOut,"课程详情页，我的课程 文案");        
  }
  
  /**
   * 课程详情页，无班级时，创建班级按钮
   *
   * 
   */
  public WebElement bulidClassCenter(){     
    return seleniumUtils.getWebElementByPositioningMethod("xpath", 
        "//*[@id=\"app\"]/div/div/div[1]/div[3]/div/div/div[1]/a"
        ,timeOut,"无班级时，创建班级按钮");        
  }
  
  /**
   * 我的课程tab，只有一个课程的时候使用
   * @return
   */
  public WebElement myCurriculumOne(){
    return seleniumUtils.getWebElementByPositioningMethod("xpath", 
        "//*[@id=\"app\"]/div/div/div[1]/div[3]/div/div/div[1]/div/div/div/a"
        ,timeOut,"我的课程，只有一个课程的时候使用");
  }
  
  /**
   * 我的课程tab,课程列表
   * @return
   */
  public WebElement myCurriculum(int num){
    return seleniumUtils.getWebElementByPositioningMethod("xpath", 
        "//*[@id=\"app\"]/div/div/div[1]/div[3]/div/div/div[1]/div/div["+num+"]/div/a"
        ,timeOut,"我的课程，只有一个课程的时候使用");
  }
  
  /**
   * 我的课程列表数
   */
  public List<WebElement> myCurriculums(){
 
    return seleniumUtils.findElementsBy(timeOut
        , By.xpath("//*[@id=\"app\"]/div/div/div[1]/div[3]/div/div/div[1]/div/div")
        ,"课程资源列表");

  }
  
  /**
   * 课程资源列表   
   */
  public List<WebElement> curriculumResources (){

    return seleniumUtils.findElementsBy(timeOut, By.xpath("//*[@id=\"app\"]/div/div/div[1]/div[3]/div/div/div[2]/div/div"), "课程资源列表");
  }
  
  /**
   * 课程资源tab,一个个读取
   */
  public WebElement curriculumResource(int num){
    return seleniumUtils.getWebElementByPositioningMethod("xpath", 
        "//*[@id=\"app\"]/div/div/div[1]/div[3]/div/div/div[2]/div/div["+num+"]/div/a"
        ,timeOut,"课程资源tab,一个个读取");
  }
  
  
}
