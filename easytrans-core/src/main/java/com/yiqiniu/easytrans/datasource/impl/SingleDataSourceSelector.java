package com.yiqiniu.easytrans.datasource.impl;

import com.yiqiniu.easytrans.datasource.DataSourceSelector;
import com.yiqiniu.easytrans.protocol.EasyTransRequest;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

public class SingleDataSourceSelector implements DataSourceSelector {

    private DataSource dataSource;

    private PlatformTransactionManager transactionManager;

    public SingleDataSourceSelector(DataSource dataSource, PlatformTransactionManager transactionManager) {
        super();
        this.dataSource = dataSource;
        this.transactionManager = transactionManager;
    }

    @Override
    public DataSource selectDataSource(String appId, String busCode, long trxId) {
        return dataSource;
    }

    @Override
    public PlatformTransactionManager selectTransactionManager(String appId, String busCode, long trxId) {
        return transactionManager;
    }

    @Override
    public DataSource selectDataSource(String appId, String busCode, EasyTransRequest<?, ?> request) {
        return dataSource;
    }

    @Override
    public PlatformTransactionManager selectTransactionManager(String appId, String busCode, EasyTransRequest<?, ?> request) {
        return transactionManager;
    }
}
