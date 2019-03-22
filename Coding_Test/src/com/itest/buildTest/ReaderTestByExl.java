package com.itest.buildTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.itest.getbean.ReaderElementByExl;
import com.itest.utils.PropertiesDataProvider;

/**
 * 读取文件
 * @author 24431
 *
 */
public class ReaderTestByExl {
  
  
  static Logger logger=Logger.getLogger(ReaderElementByExl.class);
  static ReaderElementByExl readerByExl=new ReaderElementByExl();
  
  //1.读取文件出来


  //3.读取测试用例中的测试步骤，方法一：将其用字符串拼接起来 方法二：用一个实例存起来，再用List存上所有的操作步骤去实现调用方法
  
  /**
   * 读取测试用例中的操作步骤到List中，用readerTestShep实体存储其中
   * @param exlPath
   *        用例路劲
   * @return
   */
  public static List<TestShepBean> readerTestShep(String exlPath,int sheetNum){

    File testcasef=new File(exlPath);
    XSSFWorkbook wb=null; 
    List<TestShepBean> testShepBeans=null;
    
    try {
      //获得表格sheet的数量
      //int sheetNum=readerByExl.getSheetNum(exlPath);
      //开始准备读取操作步骤：
      wb=new XSSFWorkbook(new FileInputStream(testcasef));
      String testcaseName=wb.getSheetName(sheetNum);
      logger.info("[读取到表格中用例的条数为]:"+(sheetNum-2)+testcaseName);
      Sheet sheet=wb.getSheetAt(sheetNum);
      
      testShepBeans=new ArrayList<TestShepBean>();
      System.out.println("一共多少行"+sheet.getLastRowNum());
      for(int i=1;i<(sheet.getLastRowNum())+1;i++){   
        Row row=sheet.getRow(i);        
        if(row.getCell(0).getCellType() ==Cell.CELL_TYPE_BLANK){
          logger.info("[该行为空，直接跳过]");
          continue;
        }
        
       
        TestShepBean testShepBean=new TestShepBean();    
        
        try{
          Cell type0=row.getCell(0);  
         // System.out.println("[sss:]"+Integer.parseInt(GetCellValue(type0)));
          testShepBean.setTestNumber(Integer.parseInt(GetCellValue(type0)));
          int s=Integer.parseInt(GetCellValue(type0));
          Cell type1=row.getCell(1);          
          testShepBean.setShepDescribe(GetCellValue(type1));
          
          Cell type2=row.getCell(2);          
          testShepBean.setAction(GetCellValue(type2));
          
          Cell type3=row.getCell(3); 
          testShepBean.setPositioningMethod(GetCellValue(type3));
          
          Cell type4=row.getCell(4); 
          String webElementName=GetCellValue(type4);
         // System.out.println(webElementName.indexOf("&"));
        //  System.out.println("[webElementName]"+webElementName.substring(0,webElementName.lastIndexOf("&")));
          
          testShepBean.setWebElementName(webElementName.substring(0,webElementName.indexOf("&")));
          
          Cell type5=row.getCell(5);          
          testShepBean.setDataTest(GetCellValue(type5));        
         
          testShepBeans.add(testShepBean);
          
        }catch(NullPointerException e){
          logger.error("[空指针异常]");
          break;
        }
        
      }      
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    return testShepBeans;
    
  }
  
  public static void main(String []args){
    PropertiesDataProvider  properties=new PropertiesDataProvider();  
    String  logintestcase=properties.getTestData("./config/config.properties", "logintestcase");
    List<TestShepBean> testShepBeans=readerTestShep(logintestcase,2);

    for(TestShepBean testShepBean:testShepBeans){
      System.out.println(testShepBean.toString());
    }
  }

  
  /**
   *  读取表格数据时候，要校验表格中的数据类型
   * @param cellType
   * @return
   */
  private static String GetCellValue(Cell cellType){
    String temp="";
    //使用getCellType时候要确定的定位好哪一行的cell
    int cellc= cellType.getCellType();
    switch(cellc) {
      //这里需要手动引包 import org.apache.poi.ss.usermodel.Cell;
      case Cell.CELL_TYPE_STRING:
        temp = cellType.getStringCellValue().trim();   
        temp = StringUtils.isEmpty(temp) ? "NULL" : temp;
        break;
      case Cell.CELL_TYPE_BOOLEAN:                      
        temp = String.valueOf(cellType.getBooleanCellValue()); 
        break;                 
      case Cell.CELL_TYPE_FORMULA:                  
        temp = String.valueOf(cellType.getCellFormula().trim());                        
        break;
      case Cell.CELL_TYPE_NUMERIC:
        /**
         *  当需要存入INT类型时
                           需要将其转为DOUBLE在调用MATH.CEIL
         Double f = Double.valueOf(s);
         Int a = (int)Math.ceil(f);
         */        
        Double num=Double.valueOf(cellType.getNumericCellValue());
        temp =String.valueOf((int)Math.ceil(num));
        break;
       case Cell.CELL_TYPE_BLANK:                      
            temp = "NULL";                      
            break;                  
       case Cell.CELL_TYPE_ERROR:                      
            temp = "ERROR";                     
            break;

      default:
        temp = cellType.toString().trim();
        break;
    }  
    return temp;
  }
      
}
