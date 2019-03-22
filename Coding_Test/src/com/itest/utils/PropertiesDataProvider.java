package com.itest.utils;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * 从.properties文件中读取相关测试数据，代码如下：
 * @author 24431
 *
 */
public class PropertiesDataProvider {
    /**
     * 获得配置文件的数据
     * @param configFilePath
     * @param key
     * @return
     */
    public static String getTestData(String configFilePath,String key) {
        Configuration config=null;
        try {
            config =new PropertiesConfiguration(configFilePath);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return String.valueOf(config.getProperty(key));
    }
}
