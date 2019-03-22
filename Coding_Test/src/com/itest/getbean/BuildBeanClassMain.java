package com.itest.getbean;

import com.itest.utils.PropertiesDataProvider;

public class BuildBeanClassMain {
    public static void main(String []args){
      WriterBeanClass writeBean=new WriterBeanClass();
      PropertiesDataProvider  properties=new PropertiesDataProvider();  
      
      String  elementTableUrl=properties.getTestData("./config/config.properties", "beantablepath");
      String caseFolder=properties.getTestData("./config/config.properties", "beanpackage");
      
      writeBean.writeBeanClass(caseFolder,elementTableUrl);
    }
}
