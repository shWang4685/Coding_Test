package test.testng.webElements;

import lazy.test.ui.annotations.Description;
import lazy.test.ui.annotations.Frame;
import lazy.test.ui.annotations.Xpath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;



public class PageBaiduDean{
    WebDriver driver;
    // 默认构造方法
    public PageBaiduDean(WebDriver driver) {
      // 当前页面、当前对象
      PageFactory.initElements(driver, this);
      this.driver = driver;
    }

    @Xpath(xpath={"//input[@id='kw']", "//input[@name='wd']", "//input[contains(@class,'s_ipt')]"})
    @Frame(frame="")
    @Description(description="杈撳叆")
    public WebElement inputText;

    @Xpath(xpath={"//input[@id='su']", "//input[contains(@value,'鐧惧害涓?涓?')]", "//input[contains(@class,'bg s_btn')]"})
    @Frame(frame="")
    @Description(description="鐐瑰嚮")
    public WebElement su;

    

}