package com.itest.plugins.arrow;

import org.testng.ITestContext;

public class MainTest {
  
    private static ITestContext testContext=null;
    
    
    public static void mian(String []args){
      testContext.setAttribute("haha", "name");
      System.out.println(testContext.getAttribute("haha"));
      
    }
}
