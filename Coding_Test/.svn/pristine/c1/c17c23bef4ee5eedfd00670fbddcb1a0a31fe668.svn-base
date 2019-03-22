package com.itest.assertion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.log4j.Logger;
import org.testng.Assert;

/**
 * 页面元素检测，如果检测不符合，然会flase
 * @author 24431
 *
 */
public class VerifyElement {
    static boolean flag = true;
    static List<Error> errors = new ArrayList<Error>();
    static Logger logger=Logger.getLogger(VerifyElement.class);
    
    public VerifyElement(){
      
    }
    
    /**
     * 
     * @param actualCol
     *          实际
     * @param expectStr
     *          期望值
     * @param message
     *          网页哪一个模块，用例做log提示用
     */
    public void iterateIsEquals(Collection<?> actualCol,
        String expectStr, String message){
        //获得实际的值
        Object[] actualCols=actualCol.toArray();
        logger.info(message + " 遍历集合中的每一个元素，是否等于预期值：" + expectStr);
        for(int i=0;i<actualCols.length;i++){
          Boolean equals=actualCols[i].toString().trim().equals(expectStr);
          if(equals){
            logger.info("第" + i + "个元素," + actualCols[i] + "==" + expectStr);
            
          }else{
            logger.error("[第" + i + "个元素]:" + actualCols[i] + "≠≠" + expectStr);
            try {              
              Assert.fail("第" + i + "个元素," + actualCols[i] + "≠≠" + expectStr);
            } catch (Exception e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
              flag = false;
            }
          }
          
        }      
    }
    /**
     * 调用Assert.assertEquals()方法，比较两个集合是否相等。
     * @param actual
     * @param expected
     * @param message
     */
    public void assertIsEquals(Collection<?> actual, Collection<?> expected, String message) {
      if (message.isEmpty()) {
        message = "检查(实际结果,预期结果)是否相等:";
      }
      try {
        Assert.assertEquals(actual, expected, message);
        System.out.println(message + ": " + actual + "==" + expected);
      } catch (Exception e) {
        // TODO Auto-generated catch block
        System.err.println(message + ": " + actual + "≠≠" + expected);
        // System.out.println(message+": "+actual+"≠≠"+expected);
        e.printStackTrace();
        flag = false;
      }
    }
    
    
    /**
     * 调用Assert.assertEquals()方法，比较两个两个字符串
     * @param actual
     *          实际
     * @param expected
     *          期望值
     * @param message
     *         网页哪一个模块，用例做log提示用 
     */

    public void assertIsEquals(String actual, String expected, String message) {
      if (message.isEmpty()) {
        message = "检查(实际结果,预期结果)是否相等:";
      }
      actual = actual.trim();
      expected = expected.trim();

      try {
        Assert.assertEquals(actual, expected);
        logger.info(message + ": " + actual + "==" + expected);
      
      } catch (Exception e) {
        logger.error(message + ": " + actual + "≠≠" + expected);  
        e.printStackTrace();
        flag = false;
      }
    }
    
    /**
     * 实际值可能有多个字符串组成，只要包含预期值，结果则为true。
     * @param actualCol
     * @param expectStr
     * @param message
     */
    public void iterateIsContains(Collection<?> actualCol, String expectStr, String message) {
      if (message.isEmpty()) {
        message = "检查(实际结果,预期结果)是否包含:";
      }
      Object[] obj = actualCol.toArray();
      int i = 0;
      logger.info(message + " 遍历集合中的每一个元素,是否包含预期值[" + expectStr + "]");
     
      for (Object s : obj) {
        i++;
        Boolean contains = s.toString().contains(expectStr.trim());
        if (contains) {
          logger.info("预期值:（" + expectStr + "）⊆第" + i + "个元素{" + s + "}");
         
        } else {
          logger.error("预期值:（" + expectStr + "）!⊆第" + i + "个元素{" + s + "}");
          try {
            Assert.fail("预期值:（" + expectStr + "）!⊆第" + i + "个元素{" + s + "}");
          } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            flag = false;
          }
        }
      }
    }
    /**
     * 右包含，实际值在预期范围内。⊆ ⊂ ⊇ ⊃ ∈＝≠[实际值Array,预期值String]
     * @param actualCol
     * @param expectStr
     * @param message
     */

    public void iterateIsContainsR(Collection<?> actualCol, String expectStr, String message) {
      if (message.isEmpty()) {
        message = "检查(实际结果, 预期结果)是否包含:";
      }
      Object[] obj = actualCol.toArray();
      int i = 0;
      logger.info(message + " 遍历集合中的每一个元素，是否包含在预期值[" + expectStr + "]");// expectStr="1,2,3"

      for (Object s : obj) {
        i++;
        Boolean contains = expectStr.trim().contains(s.toString());
        if (contains) {
          logger.info("第" + i + "个元素,（" + s + "） ⊆ 预期值:{" + expectStr + "}");

        } else {
          logger.error("第" + i + "个元素,（" + s + "） !⊆ 预期值:{" + expectStr + "}");
       
          try {
            Assert.fail("第" + i + "个元素,（" + s + "） !⊆ 预期值:{" + expectStr + "}");
          } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            flag = false;
          }
        }
      }
    }
    /**
     *  检测实际字符串中是否包含 期望字符串
     * @param actualStr
     * @param expectStr
     * @param message
     */
    public void isContains(String actualStr, String expectStr, String message) {
      if (message.isEmpty()) {
        message = "检查(实际结果,预期结果)是否包含:";
      }
      actualStr = actualStr.trim();
      expectStr = expectStr.trim();
      Boolean contains = actualStr.contains(expectStr);
      if (contains) {
        logger.info(message + "  预期值:（" + expectStr + "） ⊆ 实际值:" + actualStr);
       
      } else {
        logger.error(message + "  预期值:（" + expectStr + "） !⊆ 实际值:" + actualStr);
       
        try {
          Assert.fail(message + "  预期值:（" + expectStr + "） !⊆ 实际值:" + actualStr);
        } catch (Exception e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
          flag = false;
        }
      }
    }
    
    /**
     * 调用Assert.assertEquals(String actual, String expected, String message)方法，比较两个两个字符串  
     * @param actual
     * @param expected
     * 
     */
    public void assertIsEquals(String actual, String expected) {
      assertIsEquals(actual, expected, "");
    }
    
    /**
     * 判断真假
     * @param checkResult
     */
    public void assertTrue(Boolean checkResult) {
      Boolean actual = checkResult;
      Boolean expected = true;
      try {
        Assert.assertEquals(actual, expected, "检查(实际结果是否为True):");
        System.out.println("检查(实际结果是否为True),检查结果为：True");
      } catch (Exception e) {
        // TODO Auto-generated catch block
        System.err.println("！！检查(实际结果是否为True),检查结果为：False");
        // System.err.println("！！检查(实际结果,预期结果)是否相等。检查结果为：False");
        // log4j.PrintStackTraceElement();
        e.printStackTrace();
        flag = false;
      }

    }
}
