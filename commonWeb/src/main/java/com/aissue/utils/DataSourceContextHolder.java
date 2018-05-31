package com.aissue.utils;


/**
 * 设置数据源
 * @author YScredit
 *
 */
public class DataSourceContextHolder {
	private static final ThreadLocal<DataSources> dataSourceTypes = new ThreadLocal<DataSources>(){
		@Override
        protected DataSources initialValue(){
			//设置默认数据源
            return DataSources.MASTER;
        }
	};
    public static void setDbType(DataSources dbType) {  
    	dataSourceTypes .set(dbType);  
    }  
    public static DataSources getDbType() {  
        return dataSourceTypes .get();  
    }  
    public static void reset() {  
    	dataSourceTypes .remove();
    }
}
