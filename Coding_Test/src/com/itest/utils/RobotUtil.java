package com.itest.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

/**
 * WebDriver键盘事件的使用
 * @author 24431
 *
 */
public class RobotUtil {
      
      /**
       * 向粘贴板中存放数据，还可以注释掉下面的语句，进行手工复制一些东西到粘贴板
       * @param string
       *        复制的内容
       */
      public void setAndctrlVClipboardData(String string)  
      {     
          StringSelection stringSelection = new StringSelection(string);    
          //使用Toolkit对象的setContents将字符串放到剪切板中   
          Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);      
          Robot robot = null;   
          try{          
            robot = new Robot();      
          }catch(AWTException e1){          
            e1.printStackTrace();     
          }         
          robot.keyPress(KeyEvent.VK_CONTROL);      
          robot.keyPress(KeyEvent.VK_V);    
          robot.keyRelease(KeyEvent.VK_V);      
          robot.keyRelease(KeyEvent.VK_CONTROL);      
      }  
      
      /**
       * Tab按键操作
       */
      public void pressTabKey()  {      
        Robot robot = null;   
        try{          
          robot = new Robot();      
        }catch(AWTException e1){          
          e1.printStackTrace();     
        }         
        robot.keyPress(KeyEvent.VK_TAB);      
        robot.keyRelease(KeyEvent.VK_TAB);      
      }  
      
      /**
       * 回车按键
       */
      public void pressEnterKey()  {    
        Robot robot = null;   
        try{          
          robot = new Robot();      
        }catch(AWTException e1){          
          e1.printStackTrace();     
        }         
        robot.keyPress(KeyEvent.VK_ENTER);    
        robot.keyRelease(KeyEvent.VK_ENTER);            
      }
  
}
