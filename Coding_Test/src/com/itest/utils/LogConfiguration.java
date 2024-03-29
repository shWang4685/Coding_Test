package com.itest.utils;

import java.util.Properties;
import org.apache.log4j.PropertyConfigurator;


/**
 * 配置了log的输出等级，以及如何显示，如何输出，输出的日志保存到哪里等配置
 * @author 24431
 *  @deprecated 动态生成各个模块中的每条用例的日志，运行完成用例之后请到result/log目录下查看
 */
public class LogConfiguration {
    
    public static void initLog(String fileName) {
        //获取模块的名称
        String founctionName=getFunctionName(fileName);
        //申明日志文件存储路劲及文件名字/格式
        System.out.println("--------------"+founctionName+"--------------"+fileName);
        final String logFilePath  = "./result/log/"+founctionName+"/"+fileName+".log";  

        
        //Properties类继承自Hashtable类并且实现了Map接口，也是使用一种键值对的形式来保存属性集。
        //不过Properties有特殊的地方，就是它的键和值都是字符串类型。
        Properties prop=new Properties();
        //配置日志输出的格式
        prop.setProperty("log4j.rootLogger","info,toConsole,File");
        prop.setProperty("log4j.appender.File.encoding","UTF-8" );
        prop.setProperty("log4j.appender.toConsole","org.apache.log4j.ConsoleAppender");
        prop.setProperty("log4j.appender.toConsole.Target","System.out");
        prop.setProperty("log4j.appender.toConsole.layout","org.apache.log4j.PatternLayout ");
        prop.setProperty("log4j.appender.toConsole.layout.ConversionPattern","%d{yyyy-MM-dd HH:mm:ss.SSS} %5p ${PID:- }  %-40.40logger{39} : %m%n");        
        prop.setProperty("log4j.appender.File","org.apache.log4j.DailyRollingFileAppender");
        prop.setProperty("log4j.appender.File.file",logFilePath);
        prop.setProperty("log4j.appender.File.append","false");
        prop.setProperty("log4j.appender.File.Threshold","info");
        prop.setProperty("log4j.appender.File.layout","org.apache.log4j.PatternLayout");
        prop.setProperty("log4j.appender.File.layout.ConversionPattern", "%d{yyyy-MM-dd HH:mm:ss.SSS} %5p ${PID:- } --- [%t] %-40.40logger{39} : %m%n");
        PropertyConfigurator.configure(prop);

        
        

    } 
    /**
     * 
     * @param fileName
     *      @deprecated 获取模块的名字
     * @return
     */
    public static String getFunctionName(String fileName) {
         String functionName = null; 
         int firstUndelineIndex = fileName.indexOf("_"); 
         functionName = fileName.substring(0, firstUndelineIndex-4);
         return functionName;
    }

}
