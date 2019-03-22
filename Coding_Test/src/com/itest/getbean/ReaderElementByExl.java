package com.itest.getbean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 * @author 24431
 *
 */
public class ReaderElementByExl {  
  
      public ReaderElementByExl(){
        
      }
     static Logger logger=Logger.getLogger(ReaderElementByExl.class);
        /**
         * 
         * 读取所有的元素xpath，跟方法命名（用&拼接成字符串存入List中返回）
         * @param url
         *          表格的路劲
         * @param indexSheet
         *          sheet的位置
         * @return
         */
     public static List<String> allElements(String url,int indexSheet){
    
          //读入excel表中的数据放入Map中
          //读入表格的第1列，第5列
          List<String> elements=new ArrayList<String>();
          XSSFWorkbook wb=null;         
          try { 
             wb = new XSSFWorkbook(new FileInputStream(new File(url)));
             Sheet sheet=wb.getSheetAt(indexSheet);            
             for(int i=0;i<sheet.getLastRowNum();i++){
               String elementString="";
               //规避空格与第一行
               if(i<1||sheet.getRow(i)==null){
                   continue;
               }
               String methodName=sheet.getRow(i).getCell(0).getStringCellValue();
               String xpath=sheet.getRow(i).getCell(1).getStringCellValue();
               String notes=sheet.getRow(i).getCell(2).getStringCellValue();
              
               elementString=methodName+"&"+xpath+"&"+notes;
               logger.info("[elementString]:"+elementString);
               elements.add(elementString);
               
             }
          } catch (FileNotFoundException e) {
            e.printStackTrace();
          } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
          return elements;
     }

     /**
      * 获得当前excel的sheet数量 - 每个模块的用例数
      * @param filePath
      *            文件路径
      * @return 获得excel的sheet数量
      * @throws FileNotFoundException
      * @throws IOException
      */
     public static int getSheetNum(String filePath)
             throws FileNotFoundException, IOException {
         int casesNum = 0;
         XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File(
                 filePath)));
         casesNum = workbook.getNumberOfSheets();
         return casesNum;
     }

     /**
      * 获得sheet的名称
      * @param sheetIndex
      *            sheet的位置
      * @param filePath
      *            excel文件路径相对的
      * @return 返回sheet的名字
      * @throws IOException
      */
     public static String getSheetName(int sheetIndex, String filePath)
             throws IOException {
         String casesName = "";
         if(sheetIndex<0){
           System.out.println("表格sheetIndex不能小于1");
         }
         XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(filePath));
         casesName = workbook.getSheetName(sheetIndex);         
         return casesName;
     }
}
