package test.testng.webElements.teacher;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.itest.utils.SeleniumUtils;

public class LeftHelp_Ele {
  static WebDriver driver;
  SeleniumUtils seleniumUtils;
  
  public LeftHelp_Ele(WebDriver driver){
    this.driver=driver;
    //放入构造的原因是，后续调用的时候，seleniuUtils被实例化了
    this.seleniumUtils=new SeleniumUtils(driver);    
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
   * 教师端，课程中心
   */
  public WebElement curriculumCenter(){     
    return seleniumUtils.getWebElementByPositioningMethod("xpath", 
        "//*[@id=\"app\"]/div/div/div[1]/div[2]/div/div/ul/li[1]/span/a"
        ,timeOut,"教师端，课程中心");        
  }
  
  /**
   * 教师端，创建班级
   */
  public WebElement buildClass(){     
    return seleniumUtils.getWebElementByPositioningMethod("xpath", 
        "//*[@id=\"app\"]/div/div/div[1]/div[2]/div/div/ul/li[2]/span/span/span/i"
        ,timeOut,"教师端，创建班级");        
  }

  /**
   * 创建班级窗口，班级名称输入框
   */
  public WebElement classNameInput(int num){     
    
    return seleniumUtils.getWebElementByPositioningMethod("xpath", 
        "/html/body/div["+num+"]/div/div[2]/div/div/div[2]/div/div[1]/div/div/input"
        ,timeOut,"创建班级窗口，班级名称输入框");       

  }
  
  /**
   * 教师端，所有班级
   */
  public List<WebElement> allClass(){  
    return seleniumUtils.findElementsBy(timeOut,       
        By.xpath("//*[@id=\"app\"]/div/div/div[1]/div[2]/div/div/ul/li[2]/ul/li"), 
        "教师端，所有班级");
          
  }
  
  public WebElement getOneClass(int num){
    return seleniumUtils.getWebElementByPositioningMethod("xpath", 
        "//*[@id=\"app\"]/div/div/div[1]/div[2]/div/div/ul/li[2]/ul/li["+num+"]/span/a/div"
        ,timeOut,"班级");  
    
  }
  
  /**
   * 教师端，班级详情展示，班级名称
   */
  public WebElement classNameCenter(){     
    return seleniumUtils.getWebElementByPositioningMethod("xpath", 
        "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[1]/h3/span"
        ,timeOut,"教师端，班级详情展示，班级名称");        
  }

  
  /**
   * 创建班级窗口，课程选择框
   */
  

 public WebElement selectCurriculumInput(int num){   
   
   return seleniumUtils.getWebElementByPositioningMethod("xpath", 
       "/html/body/div["+num+"]/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/div"
       ,timeOut,"创建班级窗口，课程选择框");        
 }
 
  /**
   * 创建班级窗口，课程选择框，所有课程名称
   */

 public List<WebElement> allCurriculum(int num){ 

   return  seleniumUtils.findElementsBy(timeOut, 
       By.xpath("/html/body/div["+num+"]/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/div/ul/li"),
       "创建班级窗口，课程选择框，所有课程名称");
        
 }
/**
 * 确认创建班级按钮
 * @return
 */
 
 public WebElement confirmBuildClass(int num){ 
   return seleniumUtils.getWebElementByPositioningMethod("xpath", 
       "/html/body/div["+num+"]/div/div[2]/div/div/div[3]/div/a"
       ,timeOut,"确认创建班级按钮");   
        
 }
 
 
 
 /**
  * 教师端，左侧布局
  */
 public WebElement divLeft(){     
   return seleniumUtils.getWebElementByPositioningMethod("className", 
       "page-sider-wrapper"
       ,timeOut,"教师端，左侧布局");        
 }
 
/**
 * 删除和重命名展示框
 * @param temp
 * @return
 */
 public WebElement divHelp(int temp){     
   return seleniumUtils.getWebElementByPositioningMethod("xpath", 
       "//*[@id=\"app\"]/div/div/div[1]/div[2]/div/div/ul/li[2]/ul/li["+temp+"]/span/a/div/div/div/i"
       ,timeOut,"删除和重命名展示框");        
 }
  /**
   * 重命名
   * @param ranameNum
   *        动态定位重命名标签使用的下标
   * @return
   */
 public WebElement reName(int ranameNum){     
   return seleniumUtils.getWebElementByPositioningMethod("xpath", 
       "/html/body/div["+ranameNum+"]/div/div/span[1]"
       ,timeOut,"动态定位重命名标签使用的下标");        
 }
 
 /**
  * 重命名输入框
  */
 public WebElement reNameInput(){     
   return seleniumUtils.getWebElementByPositioningMethod("xpath", 
       "/html/body/div[4]/div/div[2]/div/div/div[2]/div/input"
       ,timeOut,"重命名输入框");        
   }
 

 /**
  * 取消重命名按钮
  * @return
  */
  public WebElement cancelReNameButton(){     
         return seleniumUtils.getWebElementByPositioningMethod("xpath", 
             "/html/body/div[4]/div/div[2]/div/div/div[3]/div/a[1]"
             ,timeOut,"取消重命名按钮");        
   } 
/**
 * 确认重命名按钮
 * @return
 */

  public WebElement confirmReNameButton(){     
    return seleniumUtils.getWebElementByPositioningMethod("xpath", 
        "/html/body/div[4]/div/div[2]/div/div/div[3]/div/a[2]"
        ,timeOut,"确认重命名按钮");        
  }
  
  /**
   * 删除班级
   * @param num
   *    动态定位删除名标签使用的下标
   * @return
   */
  public WebElement deleteClass(int num){
    return seleniumUtils.getWebElementByPositioningMethod("xpath", 
        "/html/body/div["+num+"]/div/div/span[2]"
        ,timeOut,"动态定位重命名标签使用的下标");  
  }
  
  /**
   * 确认删除
   * @return
   */
  public WebElement confirmDelete (){
    return seleniumUtils.getWebElementByPositioningMethod("xpath", 
        "/html/body/div[5]/div/div[2]/div/div/div[2]/div/a[2]"
        ,timeOut,"确认删除按钮");    
  }
  
  public WebElement cancelDelete(){
    return seleniumUtils.getWebElementByPositioningMethod("xpath", 
        "/html/body/div[5]/div/div[2]/div/div/div[2]/div/a[1]"
        ,timeOut,"取消删除按钮");  
  }
  /**
   * 课程详情页，我的课程 文案
   *
   * 
   */
  public WebElement MyCourseOnCenter(){     
    return seleniumUtils.getWebElementByPositioningMethod("xpath", 
        "//*[@id=\"app\"]/div/div/div[1]/div[3]/div/div/h2"
        ,timeOut,"课程详情页，我的课程 文案");        
  }
  
  /**
   * 班级详情，课程名称
   * @return
   */
  public WebElement centerClassName(){
    return seleniumUtils.getWebElementByPositioningMethod("xpath", 
        "//*[@id=\"app\"]/div/div/div[1]/div[3]/div/div/div[1]/h3/span"
        ,timeOut,"班级详情，课程名称"); 
  }

}
