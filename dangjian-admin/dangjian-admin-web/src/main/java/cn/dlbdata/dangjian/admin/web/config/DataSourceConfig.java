package cn.dlbdata.dangjian.admin.web.config;

import cn.dlbdata.dangjian.common.secret.EncryptorFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: linfujun
 * @Description: 配置项
 * @Date: Created on 14:07 2018/2/11
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource getDataSource() {
        return new DataSource();
    }

    @Bean(name = "jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        return EncryptorFactory.newStringEncryptor();
    }

}
