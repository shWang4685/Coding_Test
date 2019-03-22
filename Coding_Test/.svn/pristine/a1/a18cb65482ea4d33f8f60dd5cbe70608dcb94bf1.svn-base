package com.itest.getbean;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;

public class WriterBeanClass {
  static ReaderElementByExl  readerElement=new ReaderElementByExl();
  static Logger logger=Logger.getLogger(ReaderElementByExl.class);

  /**
   * 
   * @param caseFolder
   *        bean的存放路径
   * @param elementTableUrl
   *        读取表格的路径
   */
  public static void writeBeanClass(String caseFolder,String elementTableUrl){
    //源文件
    File sourceFile = null;
    //功能模块名字
    String functionName = null;          
    try {
      int sheetCounts =readerElement.getSheetNum(elementTableUrl);
      //验证类要存入的路劲是否存在
      File packageByBean=new File(caseFolder);
      if(packageByBean.exists()){
        System.out.println("包存在，继续下一步");
        System.out.println("正在生成bean到包下，请稍等...");
      }else{
        System.out.println("包不存在，正在创建包");
        packageByBean.mkdirs();
        System.out.println("包创建完成，正在生成bean到包下，请稍后...");     
      }
      //这里循环写出bean
      for(int i=0;i<sheetCounts;i++){
        String sheetName= readerElement.getSheetName(i, elementTableUrl);
        // 创建测试用例源码，指定存放路径
        sourceFile=new File(caseFolder+File.separator
            +sheetName.replaceFirst(sheetName.substring(0, 1), sheetName.substring(0, 1).toUpperCase())
            +"_bean.java");
        writeBean(sourceFile,sheetName,elementTableUrl);
      } 
    } catch (FileNotFoundException e){

      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  /**
   * 写入文件内容
   * @param sourceFile
   *        源文件
   * @param sheetname
   *        
   * @param elementsUrl
   */
  public static void  writeBean(File sourceFile,String sheetname,String elementsUrl){
    //写入文件准备
    FileWriter writer;
    String javaClassName=sheetname.replaceFirst(sheetname.substring(0,1),sheetname.substring(0, 1).toUpperCase())+"_bean"; 
    try {
      writer = new FileWriter(sourceFile);
      // 生成测试用例代码的头文件
      writer.write("package com.itest.bean;\n"
              +"import org.openqa.selenium.support.FindBy;\n"
              +"import org.openqa.selenium.support.PageFactory;\n"
              +"import org.openqa.selenium.WebDriver;\n"
              +"import org.openqa.selenium.WebElement;\n"
              +"public class "
              + javaClassName
              + "{ \n");
      //写变量
      writer.write("    WebDriver driver;\n");
     
      //写构造方法
      writer.write("    public "+javaClassName+"(WebDriver driver) {\n"
          +"        PageFactory.initElements(driver, this);\n"
          +"        this.driver = driver;\n"
          +"    }\n");
      
      //方法块
      List<String> elements=readerElement.allElements(elementsUrl, 0);
      for(int i=0;i<elements.size();i++){
        String[] element=elements.get(i).split("&");

          writer.write("    @FindBy(xpath =\""+element[1].toString()+"\")\n"
              +"    public WebElement "+element[0].toString()+";\n"
              );
      
      }
     
      // 代码结尾大括号
      writer.write("}");
      writer.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }
}
