package com.aissue.spring;

import com.aissue.utils.DataSourceContextHolder;
import com.alibaba.druid.pool.DruidDataSource;
import org.apache.log4j.Logger;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


public class DynamicDataSource extends AbstractRoutingDataSource {
    private static Logger log = Logger.getLogger(DynamicDataSource.class);
    static{
        log.info("======DynamicDataSource is running...");
    }

    private DruidDataSource defaultSource;

    public DynamicDataSource() {

    }

    @Override
    protected Object determineCurrentLookupKey() {
        log.info("======要连接数据库了=====determineCurrentLookupKey()");
        return DataSourceContextHolder.getDbType();
    }

    public void close(){

    }
}
