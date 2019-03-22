package com.itest.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

/**
 * 读取某账号的Cookie配置文件，完成自动登录
 * @author 24431
 *
 */
public class LoginCookie {
  
  
  /**
   * 教师账号：244313089
   * @param driver
   */
  public void getCookie(WebDriver driver){

    driver.get("https://coding.qq.com/home/");
    driver.manage().window().maximize();
    File file=new File("./config/cookie.properties");
    
    try {
      //读配置文件
      FileReader fr=new FileReader(file);
      BufferedReader br=new BufferedReader(fr);
      String line=null;
      while((line=br.readLine())!=null){
        String [] sz = line.split(";");
        String doman =  sz[0].trim();
        String name = sz[1].trim();
        String value = sz[2].trim();
        String path = sz[3].trim();
        Date date = null;       
        if(!(sz[4].equals("null"))){    
          date = new Date(sz[4]);
        }
        Boolean bl = Boolean.valueOf(sz[5]);                      
        Cookie ck = new Cookie(name,value,doman,path,date,bl); 
        //将Cookie信息添加的本驱动
        driver.manage().addCookie(ck);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }     
    driver.navigate().refresh();
  }
  
}
