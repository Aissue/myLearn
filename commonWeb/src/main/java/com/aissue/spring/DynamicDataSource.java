package com.aissue.spring;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.log4j.Logger;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


public class DynamicDataSource extends AbstractRoutingDataSource {
    private static Logger log = Logger.getLogger(DynamicDataSource.class);

    private DruidDataSource defaultSource;

    public DynamicDataSource() {

    }

    @Override
    protected Object determineCurrentLookupKey() {
        log.info("======要连接数据库了=====determineCurrentLookupKey()");
        return defaultSource;
    }

    @Override
    protected DruidDataSource determineTargetDataSource() {
        log.info("======要连接数据库了=====determineTargetDataSource()");
        return (DruidDataSource)determineCurrentLookupKey();
    }

    @Override
    public void afterPropertiesSet() {
    }

    public void close(){

    }
}
