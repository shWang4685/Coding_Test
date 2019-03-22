package com.itest.buildTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.itest.getbean.ReaderElementByExl;
import com.itest.utils.GetBorwser;
import com.itest.utils.LogConfiguration;
import com.itest.utils.PropertiesDataProvider;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WriterTestcaseClass {
  static Logger logger=Logger.getLogger(WriterTestcaseClass.class);

  static ReaderTestByExl readerByExl=new ReaderTestByExl();
/**
 * 
 * 写用例
 * @param testExlFile
 *          表格的地址
 * @param sourceFile
 *          文件写出的路劲 
 */
  public static void writerTestClass(String testExlFile,String sourceFile,String logintestcase){
    
    File testcasef=new File(testExlFile);
    
    File sourceFilef=new File(sourceFile);
    XSSFWorkbook wb;    
    String moduleName=testExlFile.substring(0, testExlFile.indexOf("."));
    //判断是否存放用例的木有已经创建
    if(sourceFilef.exists()){      
      System.out.println("包存在，继续下一步");
      System.out.println("正在生成bean到包下，请稍等...");
    }else{
      System.out.println("包不存在，正在创建包");
      sourceFilef.mkdirs();
      System.out.println("包创建完成，正在生成bean到包下，请稍后...");     
    }
    try {
      wb = new XSSFWorkbook(new FileInputStream(testcasef));
      
      int sheetCounts =wb.getNumberOfSheets();
      if(sheetCounts<2){
        logger.error("[没有可输出的用例]");
        return;
      }
      for(int i=2;i<=sheetCounts-1;i++){
        String sheetName=wb.getSheetName(i);
       // File sourceFilef=new File(sourceFile);               
        writeTest(sourceFilef,moduleName,sheetName,i,logintestcase);
      }     
    } catch (FileNotFoundException e) { 
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }    
  }
  
  
  /**
   * 
   * @param sourceFile
   *        文件写出的路劲 
   * @param moduleName
   *        用例模块名称
   * @param sheetname
   *        用例名称
   * @param sheetIndex
   *        用例所在sheet下标
   */
  public static void writeTest(File sourceFile,String moduleName,String sheetname,int sheetIndex,String logintestcase){

    //模块名称
    moduleName=moduleName.substring(moduleName.lastIndexOf("/")+1) ;
    String ClassNameHeader=moduleName.replaceFirst(moduleName.substring(0, 1), moduleName.substring(0, 1).toUpperCase());
    //用例序号
    String testNum=null;
    if(sheetIndex<10){
      testNum="00"+String.valueOf(sheetIndex);
    }else if(sheetIndex>99){
      testNum=String.valueOf(sheetIndex);
    }else{
      testNum="0"+String.valueOf(sheetIndex);
    }
    //写入文件准备
    FileWriter writer;
    String javaClassName=ClassNameHeader+"_"+testNum+"_"+sheetname+"_Test";       
    String attDriver="SELENIUM_DRIVER";

    System.out.println(javaClassName);
    try {
      sourceFile=new File(sourceFile+File.separator
          +javaClassName
          +".java");
      System.out.println(sourceFile);
      writer = new FileWriter(sourceFile);
      // 生成测试用例代码的头文件
      writer.write("package com.itest.testcases;\n"
          +"import org.apache.log4j.Logger;\n"
          +"import org.testng.annotations.BeforeClass;\n"
          +"import com.itest.utils.LogConfiguration;\n"
          +"import org.testng.annotations.Test;\n"
          +"import java.util.List;\n"
          +"import com.itest.buildTest.TestShepBean;\n"
          +"import com.itest.buildTest.ReaderTestByExl;\n"
          +"import com.itest.buildTest.ActionFunction;\n"
          +"import com.itest.utils.GetBorwser;\n"
          +"import org.testng.ITestContext;\n"
          +"import org.openqa.selenium.WebDriver;\n"
          +"import com.itest.utils.SeleniumUtil;\n\n\n"
          +"public class "
          + javaClassName
          +"    extends GetBorwser"
          + "{ \n\n");
      //logger 写入
      writer.write("  static Logger logger=Logger.getLogger("
          +javaClassName
          +".class);\n"
          +"  ITestContext testContext=null;\n"
          +"  WebDriver driver=null;\n");
      //写beforeClass
      writer.write("  @BeforeClass\n"
            +"  public void startTest(ITestContext context){\n\n"  
            +"      this.driver=new GetBorwser().getWebDriver();\n"
            +"      this.testContext=context;\n"
            // "\"我是中国工人\"";
            +"      testContext.setAttribute("
            + "\""+attDriver+"\""
            +",driver);\n" 
            +"      LogConfiguration.initLog(this.getClass().getSimpleName());\n"
            +"  }\n");
      
      //写@Test
      writer.write("  @Test\n");
      //写执行方法
      writer.write("  public void "
          + sheetname+"(){\n"
          +"        List<TestShepBean> testShepBeans=new ReaderTestByExl().readerTestShep("
          + "\""+logintestcase+"\""
          +","
          +sheetIndex
          +");\n"
          +"        ActionFunction actionFunction=new ActionFunction(driver);\n"
          +"        actionFunction.actionFunction(testShepBeans);\n"
         + "    }\n");
      
      
      // 代码结尾大括号
      writer.write("}");
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    

  }
  
  
  public static void main(String  []args){
    
    PropertiesDataProvider  properties=new PropertiesDataProvider();  
    String  logintestcase=properties.getTestData("./config/config.properties", "logintestcase");               
    String sourcecodedir=properties.getTestData("./config/config.properties", "sourcecodedir");
    writerTestClass(logintestcase,sourcecodedir,logintestcase);
//    String  coding_sourcecodedirHomeCase=properties.getTestData("./config/config.properties", "Coding_sourcecodedirHomeCase");      
//    String coding_sourcecodedir=properties.getTestData("./config/config.properties", "Coding_sourcecodedir");
//    writerTestClass(coding_sourcecodedirHomeCase,coding_sourcecodedir,coding_sourcecodedirHomeCase);
    
    
  }

  
  
}
