package test.testng.webElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Itest_loginEle {
  WebDriver driver;
  // 默认构造方法
  public Itest_loginEle(WebDriver driver) {
    // 当前页面、当前对象
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }
  /**
   * 输入账号
   */
    @FindBy(xpath = "//*[@id='username']")
  public WebElement inputUserName;

    
    
  /**
   * 输入密码
   */

    @FindBy(xpath = "//*[@id='password_input']")
  public WebElement inputPassword;
  
  /**
   * 登录按钮
   */
    @FindBy(xpath = "//*[@id='login_button']")
  public WebElement buttonLogin;
    
    
  /**
   * 获得用户的名称
   */
   @FindBy(xpath ="/html/body/div[1]/ul[2]/li[4]/a")
   public WebElement getUserName;
}
