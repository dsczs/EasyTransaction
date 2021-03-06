package com.yiqiniu.easytrans.log.impl.database;

import com.alibaba.druid.pool.DruidDataSource;
import com.yiqiniu.easytrans.log.TransactionLogReader;
import com.yiqiniu.easytrans.log.TransactionLogWritter;
import com.yiqiniu.easytrans.master.EasyTransMasterSelector;
import com.yiqiniu.easytrans.serialization.ObjectSerializer;
import com.yiqiniu.easytrans.util.ByteFormIdCodec;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

/**
 * @author xudeyou
 */
@Configuration
@ConditionalOnProperty(name = "easytrans.log.database.enabled", havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties(DatabaseTransactionLogProperties.class)
public class DataBaseTransactionLogConfiguration {

    @Value("${spring.application.name}")
    private String applicationName;


    @Bean
    @ConditionalOnProperty(name = {"logCleanEnabled"}, prefix = "easytrans.log.database")
    public DataBaseTransactionLogCleanJob logCleanJob(EasyTransMasterSelector master, DataBaseTransactionLogWritterImpl logWritter,
                                                      DatabaseTransactionLogProperties properties) {
        return new DataBaseTransactionLogCleanJob(applicationName, master, logWritter, properties.getLogReservedDays(), properties.getLogCleanTime());
    }

    @Bean
    @ConditionalOnMissingBean(TransactionLogReader.class)
    public DataBaseTransactionLogReaderImpl dataBaseTransactionLogReaderImpl(ObjectSerializer serializer,
                                                                             DataBaseForLog dataBaseWrap, ByteFormIdCodec idCodec, DatabaseTransactionLogProperties properties) {
        return new DataBaseTransactionLogReaderImpl(applicationName, serializer, dataBaseWrap.getDataSource(), idCodec,
                properties.getTablePrefix());
    }

    @Bean
    @ConditionalOnMissingBean(TransactionLogWritter.class)
    public DataBaseTransactionLogWritterImpl dataBaseTransactionLogWritterImpl(ObjectSerializer serializer,
                                                                               DataBaseForLog dataBaseWrap, ByteFormIdCodec idCodec, DatabaseTransactionLogProperties properties) {
        return new DataBaseTransactionLogWritterImpl(serializer, dataBaseWrap.getDataSource(), idCodec,
                properties.getTablePrefix());
    }

    @Bean
    @ConditionalOnMissingBean(DataBaseForLog.class)
    public DataBaseForLog dataBaseForLog(DatabaseTransactionLogProperties properties) {
        DruidDataSource datasource = new DruidDataSource();
        Map<String, String> druidPropertyMap = properties.getDruid();
        Properties druidProperties = new Properties();
        for (Entry<String, String> entry : druidPropertyMap.entrySet()) {
            druidProperties.put("druid." + entry.getKey(), entry.getValue());
        }
        datasource.configFromPropety(druidProperties);
        DataBaseForLog dbForLog = new DataBaseForLog();
        dbForLog.setDataSource(datasource);
        return dbForLog;
    }


    /**
     * to avoid multiple database bean register in beanfactory
     * <p>
     * user should create this bean
     *
     * @author deyou
     */
    public static class DataBaseForLog {
        private DataSource dataSource;

        public DataSource getDataSource() {
            return dataSource;
        }

        public void setDataSource(DataSource dataSource) {
            this.dataSource = dataSource;
        }
    }

}
