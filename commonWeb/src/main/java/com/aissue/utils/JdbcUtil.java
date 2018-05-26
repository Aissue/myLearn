package com.aissue.utils;

import java.sql.*;

public class JdbcUtil {
    public static void main(String[] args) throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@10.1.2.141:1521:orcl","wangkun","wangkun");
        String sql = "select * from aquila_dict where 1!=1";
//        String sql = "select * from sys_user where 1!=1";
//        String sql = "select * from view_user where 1!=1";
        Statement statement = conn.createStatement();
        ResultSet rs =  statement.executeQuery(sql);
        ResultSetMetaData md = rs.getMetaData();
        int size = md.getColumnCount();
        for(int i=1;i<=size;i++){
            System.out.println("字段名:"+md.getColumnName(i));
            //是否可以为null,0-notnull;1-null
            System.out.println("是否可以为NULL:"+md.isNullable(i));
//            System.out.println(md.getTableName(i));
        }
        System.out.println("========================");
        /*DatabaseMetaData dbmd = conn.getMetaData();
//        ResultSet rs1 = dbmd.getPrimaryKeys(null,null,"AQUILA_DICT");
        ResultSet rs1 = dbmd.getPrimaryKeys(null,null,"SYS_SCHOOL");
        ResultSetMetaData rsmd = rs.getMetaData();
        int cols = rsmd.getColumnCount();
        while(rs1.next()) {
            for (int i = 1; i <= cols; i++) {
                System.out.println(rs1.getString(i));
            }
        }
        rs1.close();*/
        rs.close();
        statement.close();
        conn.close();
    }
}
